/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// SgfReader.java

package net.sf.gogui.sgf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.game.Node;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.util.ByteCountInputStream;
import net.sf.gogui.util.ProgressShow;

/** SGF reader.
    @bug The error messages sometimes contain wrong line numbers, because of
    problems in StreamTokenizer.lineno(). Maybe the implementation should be
    replaced not using StreamTokenizer, because this class is a legacy class.
    (Does this happen only on Windows?) */
public final class SgfReader
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfReader.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6320500814987135844L,/* translation unit id   */ -218118311538490552L,/* timestamp             */ 1709177902850L,/* source file name      */ "SgfReader.java",/* probe size            */ 548);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Read SGF file from stream.
        Default charset is ISO-8859-1 according to the SGF version 4 standard.
        The charset property is only respected if the stream is a
        FileInputStream, because it has to be reopened with a different
        encoding.
        The stream is closed after reading.
        @param in Stream to read from.
        @param file File name if input stream is a FileInputStream to allow
        reopening the stream after a charset change
        @param progressShow Callback to show progress, can be null
        @param size Size of stream if progressShow != null
        @throws SgfError If reading fails. */
    public SgfReader(InputStream in, File file, ProgressShow progressShow,
                     long size)
        throws SgfError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(0);m_file = file;
        m_progressShow = progressShow;
        m_size = size;
        m_isFile = (in instanceof FileInputStream && file != null);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(1);if ((progressShow != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(3) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(2);progressShow.showProgress(0);}
        try
        {
            // SGF FF 4 standard defines ISO-8859-1 as default
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(4);readSgf(in, "ISO-8859-1");
        }
        catch (SgfCharsetChanged e1)
        {
            try
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(7);in.close();
                in = new FileInputStream(file);
            }
            catch (IOException e2)
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(10);throw new SgfError("Could not reset SGF stream after"
                                   + " charset change.");
            }
            try
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(8);readSgf(in, m_newCharset);
            }
            catch (SgfCharsetChanged e3)
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(9);assert false;
            }
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(5);in.close();
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(6);System.err.println("Could not close SGF stream");
            }
        }
    }

    /** Get game tree of loaded SGF file.
        @return The game tree. */
    public GameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(11);return m_tree;
    }

    /** Get warnings that occurred during loading SGF file.
        @return String with warning messages or null if no warnings. */
    public String getWarnings()
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(12);if ((m_warnings.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(14) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(13);return null;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(15);StringBuilder result = new StringBuilder(m_warnings.size() * 80);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(16);for (String s : m_warnings)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(18);result.append(s);
            result.append('\n');
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(17);return result.toString();
    }

    private static class SgfCharsetChanged
        extends Exception
    {
    }

    private final boolean m_isFile;

    /** Has current node inconsistent FF3 overtime settings properties. */
    private boolean m_ignoreOvertime;

    private int m_lastPercent;

    private int m_boardSize;

    private int m_byoyomiMoves;

    private final long m_size;

    private long m_byoyomi;

    private long m_preByoyomi;

    private ByteCountInputStream m_byteCountInputStream;

    private java.io.Reader m_reader;

    private GameTree m_tree;

    private final ProgressShow m_progressShow;

    /** Contains strings with warnings. */
    private final Set<String> m_warnings = new TreeSet<String>();

    private StreamTokenizer m_tokenizer;

    private final File m_file;

    private String m_newCharset;

    /** Pre-allocated temporary buffer for use within functions. */
    private final StringBuilder m_buffer = new StringBuilder(512);

    private final PointList m_pointList = new PointList();

    /** Map containing the properties of the current node. */
    private final Map<String,ArrayList<String>> m_props =
        new TreeMap<String,ArrayList<String>>();

    /** Apply some fixes for broken SGF files. */
    private void applyFixes()
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(19);Node root = m_tree.getRoot();
        GameInfo info = m_tree.getGameInfo(root);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(20);if ((root.hasSetup() && root.getPlayer() == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(22) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(21);if ((info.getHandicap() > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(24) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(23);root.setPlayer(WHITE);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(25);boolean hasBlackChildMoves = false;
                boolean hasWhiteChildMoves = false;
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(26);for (int i = 0; (i < root.getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(28) && false); ++i)
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(27);Move move = root.getChild(i).getMove();
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(35);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(37) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(36);continue;}
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(38);if ((move.getColor() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(40) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(39);hasBlackChildMoves = true;}
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(41);if ((move.getColor() == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(43) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(42);hasWhiteChildMoves = true;}
                }
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(29);if ((hasBlackChildMoves && ! hasWhiteChildMoves) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(31) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(30);root.setPlayer(BLACK);}
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(32);if ((hasWhiteChildMoves && ! hasBlackChildMoves) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(34) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(33);root.setPlayer(WHITE);}
            }
        }
    }

    private void checkEndOfFile() throws SgfError, IOException
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(44);while (true)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(45);m_tokenizer.nextToken();
            int t = m_tokenizer.ttype;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(47);if ((t == '(') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(49) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(48);throw getError("Multiple SGF trees not supported");}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(50);if ((t == StreamTokenizer.TT_EOF) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(52) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(51);return;}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(53);if ((t != ' ' && t != '\t' && t != '\n' && t != '\r') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(55) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(54);setWarning("Extra text after SGF tree");
                return;
            }}}
        }
    }

    /** Check for obsolete long names for standard properties.
        These are still used in some old SGF files.
        @param property Property name
        @return Short standard version of the property or original property */
    private String checkForObsoleteLongProps(String property)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(56);if ((property.length() <= 2) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(58) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(57);return property;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(59);property = property.intern();
        String shortName = null;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(60);if ((property == "ADDBLACK") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(62) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(61);shortName = "AB";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(67);if ((property == "ADDEMPTY") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(69) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(68);shortName = "AE";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(70);if ((property == "ADDWHITE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(72) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(71);shortName = "AW";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(73);if ((property == "BLACK") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(75) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(74);shortName = "B";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(76);if ((property == "BLACKRANK") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(78) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(77);shortName = "BR";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(79);if ((property == "COMMENT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(81) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(80);shortName = "C";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(82);if ((property == "COPYRIGHT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(84) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(83);shortName = "CP";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(85);if ((property == "DATE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(87) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(86);shortName = "DT";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(88);if ((property == "EVENT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(90) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(89);shortName = "EV";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(91);if ((property == "GAME") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(93) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(92);shortName = "GM";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(94);if ((property == "HANDICAP") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(96) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(95);shortName = "HA";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(97);if ((property == "KOMI") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(99) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(98);shortName = "KM";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(100);if ((property == "PLACE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(102) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(101);shortName = "PC";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(103);if ((property == "PLAYERBLACK") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(105) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(104);shortName = "PB";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(106);if ((property == "PLAYERWHITE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(108) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(107);shortName = "PW";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(109);if ((property == "PLAYER") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(111) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(110);shortName = "PL";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(112);if ((property == "RESULT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(114) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(113);shortName = "RE";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(115);if ((property == "ROUND") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(117) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(116);shortName = "RO";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(118);if ((property == "RULES") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(120) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(119);shortName = "RU";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(121);if ((property == "SIZE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(123) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(122);shortName = "SZ";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(124);if ((property == "WHITE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(126) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(125);shortName = "W";}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(127);if ((property == "WHITERANK") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(129) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(128);shortName = "WR";}}}}}}}}}}}}}}}}}}}}}}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(63);if ((shortName != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(65) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(64);return shortName;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(66);return property;
    }

    private GameInfo createGameInfo(Node node)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(130);return node.createGameInfo();
    }

    private void findRoot() throws SgfError, IOException
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(131);while (true)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(132);m_tokenizer.nextToken();
            int t = m_tokenizer.ttype;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(134);if ((t == '(') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(136) && false))
            {
                // Better make sure that ( is followed by a node
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(135);m_tokenizer.nextToken();
                t = m_tokenizer.ttype;
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(137);if ((t == ';') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(139) && false))
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(138);m_tokenizer.pushBack();
                    return;
                }
                else
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(140);setWarning("Extra text before SGF tree");}
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(141);if ((t == StreamTokenizer.TT_EOF) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(143) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(142);throw getError("No root tree found");}
            else
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(144);setWarning("Extra text before SGF tree");}}
        }
    }

    private int getBoardSize()
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(145);if ((m_boardSize == -1) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(147) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(146);m_boardSize = 19;} // Default size for Go in the SGF standard
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(148);return m_boardSize;
    }

    private SgfError getError(String message)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(149);int lineNumber = m_tokenizer.lineno();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(150);if ((m_file == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(152) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(151);return new SgfError(lineNumber + ": " + message);}
        else
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(153);String s = m_file.getName() + ":" + lineNumber + ": " + message;
            return new SgfError(s);
        }
    }

    private void handleProps(Node node, boolean isRoot)
        throws IOException, SgfError, SgfCharsetChanged
    {
        // Handle SZ property first to be able to parse points
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(154);if ((m_props.containsKey("SZ")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(156) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(155);ArrayList<String> values = m_props.get("SZ");
            m_props.remove("SZ");
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(157);if ((! isRoot) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(159) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(158);setWarning("Size property not in root node ignored");}
            else
            {
                try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(332);int size = parseInt(values.get(0));
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(333);if ((size <= 0 || size > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(335) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(334);setWarning("Invalid board size value");}
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(336);assert m_boardSize == -1;
                    m_boardSize = size;
                }
                catch (NumberFormatException e)
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(337);setWarning("Invalid board size value");
                }
            }
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(160);for (Map.Entry<String,ArrayList<String>> entry : m_props.entrySet())
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(161);String p = entry.getKey();
            ArrayList<String> values = entry.getValue();
            String v = values.get(0);
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(162);if ((p == "AB") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(164) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(163);parsePointList(values);
                node.addStones(BLACK, m_pointList);
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(165);if ((p == "AE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(167) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(166);parsePointList(values);
                node.addStones(EMPTY, m_pointList);
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(168);if ((p == "AN") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(170) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(169);set(node, StringInfo.ANNOTATION, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(171);if ((p == "AW") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(173) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(172);parsePointList(values);
                node.addStones(WHITE, m_pointList);
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(174);if ((p == "B") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(176) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(175);node.setMove(Move.get(BLACK, parsePoint(v)));
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(177);if ((p == "BL") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(179) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(178);try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(180);node.setTimeLeft(BLACK, Double.parseDouble(v));
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(181);
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(182);if ((p == "BR") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(184) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(183);set(node, StringInfoColor.RANK, BLACK, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(185);if ((p == "BT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(187) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(186);set(node, StringInfoColor.TEAM, BLACK, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(188);if ((p == "C") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(190) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(189);node.setComment(v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(191);if ((p == "CA") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(193) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(192);if ((isRoot && m_isFile && m_newCharset == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(195) && false))
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(194);m_newCharset = v.trim();
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(196);if ((Charset.isSupported(m_newCharset)) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(198) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(197);throw new SgfCharsetChanged();}
                    else
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(199);setWarning("Unknown character set \"" + m_newCharset
                                   + "\"");}
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(200);if ((p == "CP") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(202) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(201);set(node, StringInfo.COPYRIGHT, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(203);if ((p == "CR") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(205) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(204);parseMarked(node, MarkType.CIRCLE, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(206);if ((p == "DT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(208) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(207);set(node, StringInfo.DATE, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(209);if ((p == "FF") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(211) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(210);int format = -1;
                try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(212);format = Integer.parseInt(v);
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(216);
                }
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(213);if ((format < 1 || format > 4) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(215) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(214);setWarning("Unknown SGF file format version");}
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(217);if ((p == "GM") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(219) && false))
            {
                // Some SGF files contain GM[], interpret as GM[1]
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(218);v = v.trim();
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(220);if ((! v.equals("") && ! v.equals("1")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(222) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(221);throw getError("Not a Go game");}
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(223);if ((p == "HA") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(225) && false))
            {
                // Some SGF files contain HA[], interpret as unknown handicap
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(224);v = v.trim();
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(226);if ((! v.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(228) && false))
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(227);try
                    {
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(229);int handicap = Integer.parseInt(v);
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(230);if ((handicap == 1 || handicap < 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(232) && false))
                            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(231);setWarning("Invalid handicap value");}
                        else
                            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(233);createGameInfo(node).setHandicap(handicap);}
                    }
                    catch (NumberFormatException e)
                    {
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(234);setWarning("Invalid handicap value");
                    }
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(235);if ((p == "KM") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(237) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(236);parseKomi(node, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(238);if ((p == "LB") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(240) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(239);for (int i = 0; (i < values.size()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(242) && false); ++i)
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(241);String value = values.get(i);
                    int pos = value.indexOf(':');
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(243);if ((pos > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(245) && false))
                    {
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(244);GoPoint point = parsePoint(value.substring(0, pos));
                        String text = value.substring(pos + 1);
                        node.setLabel(point, text);
                    }
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(246);if ((p == "MA" || p == "M") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(248) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(247);parseMarked(node, MarkType.MARK, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(249);if ((p == "OB") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(251) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(250);try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(252);node.setMovesLeft(BLACK, Integer.parseInt(v));
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(253);
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(254);if ((p == "OM") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(256) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(255);parseOvertimeMoves(v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(257);if ((p == "OP") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(259) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(258);parseOvertimePeriod(v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(260);if ((p == "OT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(262) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(261);parseOvertime(node, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(263);if ((p == "OW") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(265) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(264);try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(266);node.setMovesLeft(WHITE, Integer.parseInt(v));
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(267);
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(268);if ((p == "PB") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(270) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(269);set(node, StringInfoColor.NAME, BLACK, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(271);if ((p == "PW") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(273) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(272);set(node, StringInfoColor.NAME, WHITE, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(274);if ((p == "PL") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(276) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(275);node.setPlayer(parseColor(v));}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(277);if ((p == "RE") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(279) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(278);set(node, StringInfo.RESULT, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(280);if ((p == "RO") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(282) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(281);set(node, StringInfo.ROUND, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(283);if ((p == "RU") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(285) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(284);set(node, StringInfo.RULES, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(286);if ((p == "SO") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(288) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(287);set(node, StringInfo.SOURCE, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(289);if ((p == "SQ") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(291) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(290);parseMarked(node, MarkType.SQUARE, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(292);if ((p == "SL") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(294) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(293);parseMarked(node, MarkType.SELECT, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(295);if ((p == "TB") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(297) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(296);parseMarked(node, MarkType.TERRITORY_BLACK, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(298);if ((p == "TM") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(300) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(299);parseTime(node, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(301);if ((p == "TR") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(303) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(302);parseMarked(node, MarkType.TRIANGLE, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(304);if ((p == "US") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(306) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(305);set(node, StringInfo.USER, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(307);if ((p == "W") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(309) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(308);node.setMove(Move.get(WHITE, parsePoint(v)));}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(310);if ((p == "TW") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(312) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(311);parseMarked(node, MarkType.TERRITORY_WHITE, values);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(313);if ((p == "V") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(315) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(314);try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(316);node.setValue(Float.parseFloat(v));
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(317);
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(318);if ((p == "WL") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(320) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(319);try
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(321);node.setTimeLeft(WHITE, Double.parseDouble(v));
                }
                catch (NumberFormatException e)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(322);
                }
            }
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(323);if ((p == "WR") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(325) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(324);set(node, StringInfoColor.RANK, WHITE, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(326);if ((p == "WT") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(328) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(327);set(node, StringInfoColor.TEAM, WHITE, v);}
            else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(329);if ((p != "FF" && p != "GN" && p != "AP") ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(331) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(330);node.addSgfProperty(p, values);}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
        }
    }

    private GoColor parseColor(String s) throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(338);GoColor color;
        s = s.trim().toLowerCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(339);if ((s.equals("b") || s.equals("1")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(341) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(340);color = BLACK;}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(343);if ((s.equals("w") || s.equals("2")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(345) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(344);color = WHITE;}
        else
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(346);throw getError("Invalid color value");}}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(342);return color;
    }

    private int parseInt(String s) throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(347);int i = -1;
        try
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(348);i = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(350);throw getError("Number expected");
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(349);return i;
    }

    private void parseKomi(Node node, String value) throws SgfError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(351);Komi komi = Komi.parseKomi(value);
            createGameInfo(node).setKomi(komi);
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(352);if ((komi != null && ! komi.isMultipleOf(0.5)) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(354) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(353);setWarning("Komi is not a multiple of 0.5");}
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(355);setWarning("Invalid value for komi");
        }
    }

    private void parseMarked(Node node, MarkType type,
                             ArrayList<String> values)
        throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(356);parsePointList(values);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(357);for (GoPoint p : m_pointList)
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(358);node.addMarked(p, type);}
    }

    private void parseOvertime(Node node, String value)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(359);SgfUtil.Overtime overtime = SgfUtil.parseOvertime(value);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(360);if ((overtime == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(362) && false))
            // Preserve information
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(361);node.addSgfProperty("OT", value);}
        else
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(363);m_byoyomi = overtime.m_byoyomi;
            m_byoyomiMoves = overtime.m_byoyomiMoves;
        }
    }

    /** FF3 OM property */
    private void parseOvertimeMoves(String value)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(364);m_byoyomiMoves = Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(365);setWarning("Invalid value for byoyomi moves");
            m_ignoreOvertime = true;
        }
    }

    /** FF3 OP property */
    private void parseOvertimePeriod(String value)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(366);m_byoyomi = (long)(Double.parseDouble(value) * 1000);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(367);setWarning("Invalid value for byoyomi time");
            m_ignoreOvertime = true;
        }
    }

    /** Parse point value.
        @return Point or null, if pass move
        @throw SgfError On invalid value */
    private GoPoint parsePoint(String s) throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(368);s = s.trim().toLowerCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(369);if ((s.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(371) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(370);return null;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(372);if ((s.length() > 2
            || (s.length() == 2 && s.charAt(1) < 'a' || s.charAt(1) > 'z')) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(374) && false))
        {
            // Try human-readable encoding as used by SmartGo
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(373);try
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(375);return GoPoint.parsePoint(s, GoPoint.MAX_SIZE);
            }
            catch (InvalidPointException e)
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(388);throwInvalidCoordinates(s);
            }
        }
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(389);if ((s.length() != 2) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(391) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(390);throwInvalidCoordinates(s);}}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(376);int boardSize = getBoardSize();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(377);if ((s.equals("tt") && boardSize <= 19) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(379) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(378);return null;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(380);int x = s.charAt(0) - 'a';
        int y = boardSize - (s.charAt(1) - 'a') - 1;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(381);if ((x < 0 || x >= boardSize || y < 0 || y >= boardSize) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(383) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(382);if ((x == boardSize && y == -1) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(385) && false))
            {
                // Some programs encode pass moves, e.g. as jj for boardsize 9
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(384);setWarning("Non-standard pass move encoding");
                return null;
            }
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(386);throw getError("Coordinates \"" + s + "\" outside board size "
                           + boardSize);
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(387);return GoPoint.get(x, y);
    }

    private void parsePointList(ArrayList<String> values) throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(392);m_pointList.clear();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(393);for (int i = 0; (i < values.size()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(395) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(394);String value = values.get(i);
            int pos = value.indexOf(':');
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(396);if ((pos < 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(398) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(397);GoPoint point = parsePoint(value);
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(399);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(401) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(400);setWarning("Point list argument contains PASS");}
                else
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(402);m_pointList.add(point);}
            }
            else
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(403);GoPoint point1 = parsePoint(value.substring(0, pos));
                GoPoint point2 = parsePoint(value.substring(pos + 1));
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(404);if ((point1 == null || point2 == null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(406) && false))
                {
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(405);setWarning("Compressed point list contains PASS");
                    continue;
                }
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(407);int xMin = Math.min(point1.getX(), point2.getX());
                int xMax = Math.max(point1.getX(), point2.getX());
                int yMin = Math.min(point1.getY(), point2.getY());
                int yMax = Math.max(point1.getY(), point2.getY());
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(408);for (int x = xMin; (x <= xMax) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(410) && false); ++x)
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(409);for (int y = yMin; (y <= yMax) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(412) && false); ++y)
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(411);m_pointList.add(GoPoint.get(x, y));}}
            }
        }
    }

    /** TM property.
        According to FF4, TM needs to be a real value, but older SGF versions
        allow a string with unspecified content. We try to parse a few known
        formats. */
    private void parseTime(Node node, String value)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(413);value = value.trim();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(414);if ((value.equals("") || value.equals("-")) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(416) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(415);return;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(417);long preByoyomi = SgfUtil.parseTime(value);
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(418);if ((preByoyomi < 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(420) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(419);setWarning("Unknown format in time property");
            node.addSgfProperty("TM", value); // Preserve information
        }
        else
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(421);m_preByoyomi = preByoyomi;}
    }

    private Node readNext(Node father, boolean isRoot)
        throws IOException, SgfError, SgfCharsetChanged
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(422);if ((m_progressShow != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(424) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(423);int percent;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(425);if ((m_size > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(427) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(426);long count = m_byteCountInputStream.getCount();
                percent = (int)(count * 100 / m_size);
            }
            else
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(458);percent = 100;}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(428);if ((percent != m_lastPercent) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(430) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(429);m_progressShow.showProgress(percent);}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(431);m_lastPercent = percent;
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(432);m_tokenizer.nextToken();
        int ttype = m_tokenizer.ttype;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(433);if ((ttype == '(') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(435) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(434);Node node = father;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(436);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(438) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(437);node = readNext(node, false);}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(439);return father;
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(440);if ((ttype == ')') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(442) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(441);return null;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(443);if ((ttype == StreamTokenizer.TT_EOF) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(445) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(444);setWarning("Game tree not closed");
            return null;
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(446);if ((ttype != ';') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(448) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(447);throw getError("Next node expected");}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(449);Node son = new Node();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(450);if ((father != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(452) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(451);father.append(son);}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(453);m_ignoreOvertime = false;
        m_byoyomiMoves = -1;
        m_byoyomi = -1;
        m_preByoyomi = -1;
        m_props.clear();
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(454);while ((readProp()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(456) && false)){$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(455);;}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(457);handleProps(son, isRoot);
        setTimeSettings(son);
        return son;
    }

    private boolean readProp() throws IOException, SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(459);m_tokenizer.nextToken();
        int ttype = m_tokenizer.ttype;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(460);if ((ttype == StreamTokenizer.TT_WORD) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(462) && false))
        {
            // Use intern() to allow fast comparsion with ==
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(461);String p = m_tokenizer.sval.toUpperCase(Locale.ENGLISH).intern();
            ArrayList<String> values = new ArrayList<String>();
            String s;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(463);while (((s = readValue()) != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(465) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(464);values.add(s);}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(466);if ((values.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(468) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(467);setWarning("Property \"" + p + "\" has no value");
                return true;
            }
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(469);p = checkForObsoleteLongProps(p);
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(470);if ((m_props.containsKey(p)) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(472) && false))
                // Silently accept duplicate properties, as long as they have
                // the same value (only check for single value properties)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(471);if ((m_props.get(p).size() > 1 || values.size() > 1
                    || ! values.get(0).equals(m_props.get(p).get(0))) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(474) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(473);setWarning("Duplicate property " + p + " in node");}}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(475);m_props.put(p, values);
            return true;
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(476);if ((ttype != '\n') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(478) && false))
            // Don't pushBack newline, will confuse lineno() (Bug 4942853)
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(477);m_tokenizer.pushBack();}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(479);return false;
    }

    private void readSgf(InputStream in, String charset)
        throws SgfError, SgfCharsetChanged
    {
        try
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(480);m_boardSize = -1;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(481);if ((m_progressShow != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(483) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(482);m_byteCountInputStream = new ByteCountInputStream(in);
                in = m_byteCountInputStream;
            }
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(484);InputStreamReader reader;
            try
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(485);reader = new InputStreamReader(in, charset);
            }
            catch (UnsupportedEncodingException e)
            {
                // Should actually not happen, because this function is only
                // called with charset ISO-8859-1 (should be supported on every
                // Java platform according to Charset documentation) or with a
                // CA property value, which was already checked with
                // Charset.isSupported()
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(491);setWarning("Character set \"" + charset + "\" not supported");
                reader = new InputStreamReader(in);
            }
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(486);m_reader = new BufferedReader(reader);
            m_tokenizer = new StreamTokenizer(m_reader);
            findRoot();
            Node root = readNext(null, true);
            Node node = root;
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(487);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(489) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(488);node = readNext(node, false);}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(490);checkEndOfFile();
            getBoardSize(); // Set to default value if still unknown
            m_tree = new GameTree(m_boardSize, root);
            applyFixes();
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(492);throw new SgfError("File not found.");
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(493);throw new SgfError("IO error");
        }
        catch (OutOfMemoryError e)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(494);throw new SgfError("Out of memory");
        }
    }

    private String readValue() throws IOException, SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(495);m_tokenizer.nextToken();
        int ttype = m_tokenizer.ttype;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(496);if ((ttype != '[') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(498) && false))
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(497);if ((ttype != '\n') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(500) && false))
                // Don't pushBack newline, will confuse lineno() (Bug 4942853)
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(499);m_tokenizer.pushBack();}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(501);return null;
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(502);m_buffer.setLength(0);
        boolean quoted = false;
        Character last = null;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(503);while (true)
        {
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(504);int c = m_reader.read();
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(507);if ((c < 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(509) && false))
                {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(508);throw getError("Property value incomplete");}
            $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(510);if ((quoted) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(512) && false))
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(511);if ((c != '\n' && c != '\r') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(514) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(513);m_buffer.append((char)c);}
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(515);last = Character.valueOf((char)c);
                quoted = false;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(516);if ((c == ']') ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(518) && false))
                    {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(517);break;}
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(519);quoted = (c == '\\');
                $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(520);if ((! quoted) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(522) && false))
                {
                    // Transform all linebreaks allowed in SGF (LF, CR, LFCR,
                    // CRLF) to a single '\n'
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(521);boolean isLinebreak = (c == '\n' || c == '\r');
                    boolean lastLinebreak =
                        (last != null && (last.charValue() == '\n'
                                          || last.charValue() == '\r'));
                    boolean filterSecondLinebreak =
                        (isLinebreak && lastLinebreak && c != last.charValue());
                    $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(523);if ((filterSecondLinebreak) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(525) && false))
                        {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(524);last = null;}
                    else
                    {
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(526);if ((isLinebreak) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(528) && false))
                            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(527);m_buffer.append('\n');}
                        else
                            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(530);m_buffer.append((char)c);}
                        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(529);last = Character.valueOf((char)c);
                    }
                }
            }
        }
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(506);return m_buffer.toString();
    }

    private void set(Node node, StringInfo type, String value)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(531);GameInfo info = createGameInfo(node);
        info.set(type, value);
    }

    private void set(Node node, StringInfoColor type,
                                    GoColor c, String value)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(532);GameInfo info = createGameInfo(node);
        info.set(type, c, value);
    }

    private void setTimeSettings(Node node)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(533);TimeSettings s = null;
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(534);if ((m_preByoyomi > 0
            && (m_ignoreOvertime || m_byoyomi <= 0 || m_byoyomiMoves <= 0)) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(536) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(535);s = new TimeSettings(m_preByoyomi);}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(540);if ((m_preByoyomi <= 0 && ! m_ignoreOvertime && m_byoyomi > 0
                 && m_byoyomiMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(542) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(541);s = new TimeSettings(0, m_byoyomi, m_byoyomiMoves);}
        else {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(543);if ((m_preByoyomi > 0  && ! m_ignoreOvertime && m_byoyomi > 0
                 && m_byoyomiMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(545) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(544);s = new TimeSettings(m_preByoyomi, m_byoyomi, m_byoyomiMoves);}}}
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(537);if ((s != null) ? true : (!$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(539) && false))
            {$qualityscroll_cover_jacov_probe_fcf9168d21bd8348(538);node.createGameInfo().setTimeSettings(s);}
    }

    private void setWarning(String message)
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(546);m_warnings.add(message);
    }

    private void throwInvalidCoordinates(String s) throws SgfError
    {
        $qualityscroll_cover_jacov_probe_fcf9168d21bd8348(547);throw getError("Invalid coordinates \"" + s + "\"");
    }
}
