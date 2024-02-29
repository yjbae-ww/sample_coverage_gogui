/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// SgfWriter.java

package net.sf.gogui.sgf;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstSgfProperties;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.BLACK_WHITE_EMPTY;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.PointList;
import net.sf.gogui.util.StringUtil;

/** Write in SGF format. */
public class SgfWriter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfWriter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8122568489922289557L,/* translation unit id   */ -3506098974983229989L,/* timestamp             */ 1709177902912L,/* source file name      */ "SgfWriter.java",/* probe size            */ 204);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static final String ENCODING = "UTF-8";

    /** Write game tree in SGF format.
        @param out Output stream.
        @param tree Game tree to write.
        @param application Application name for AP property.
        @param version If not null, version appended to application name in
        AP property. */
    public SgfWriter(OutputStream out, ConstGameTree tree, String application,
                     String version)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(0);m_out = new PrintStream(out, false, ENCODING);
        }
        catch (UnsupportedEncodingException e)
        {
            // UTF-8 should be supported by every Java implementation
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(2);assert false;
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(1);print("(");
        m_size = tree.getBoardSize();
        printHeader(application, version);
        printNewLine();
        printNode(tree.getRootConst(), true);
        print(")");
        m_out.println(m_buffer.toString());
        m_out.close();
    }

    /** Write position in SGF format.
        @param out Output stream.
        @param board Position to write.
        @param application Application name for AP property.
        @param version If not null, version appended to application name in
        AP property. */
    public SgfWriter(OutputStream out, ConstBoard board, String application,
                     String version)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(3);m_size = board.getSize();
        m_out = new PrintStream(out);
        print("(");
        printHeader(application, version);
        printNewLine();
        printPosition(board);
        print(")");
        m_out.println(m_buffer.toString());
        m_out.close();
    }

    private static final int STRINGBUF_CAPACITY = 128;

    private static final int MAX_CHARS_PER_LINE = 78;

    private final StringBuilder m_buffer
        = new StringBuilder(STRINGBUF_CAPACITY);

    private final int m_size;

    private PrintStream m_out;

    private String getEscaped(String text)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(4);return getEscaped(text, false);
    }

    private String getEscaped(String text, boolean escapeColon)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(5);StringBuilder result = new StringBuilder(2 * text.length());
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(6);for (int i = 0; (i < text.length()) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(8) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(7);char c = text.charAt(i);
            String specialCharacters;
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(10);if ((escapeColon) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(12) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(11);specialCharacters = "]:\\";}
            else
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(20);specialCharacters = "]\\";}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(13);if ((specialCharacters.indexOf(c) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(15) && false))
            {
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(14);result.append('\\');
                result.append(c);
            }
            else {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(16);if ((c != '\n' && Character.isWhitespace(c)) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(18) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(17);result.append(' ');}
            else
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(19);result.append(c);}}
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(9);return result.toString();
    }

    private static int getMoveNumberInVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(21);int moveNumber = 0;
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(22);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(24) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(23);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(27) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(26);++moveNumber;}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(28);node = node.getFatherConst();
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(29);if ((node != null && node.getNumberChildren() > 1) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(31) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(30);break;}
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(25);return moveNumber;
    }

    private String getPoint(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(32);if ((p == null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(34) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(33);return "";}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(35);int x = 'a' + p.getX();
        int y = 'a' + (m_size - p.getY() - 1);
        return "" + (char)x + (char)y;
    }

    private String getPointValue(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(36);return "[" + getPoint(point) + "]";
    }

    private String getPointList(ConstPointList v)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(37);StringBuilder buffer = new StringBuilder(STRINGBUF_CAPACITY);
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(38);for (int i = 0; (i < v.size()) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(40) && false); ++i)
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(39);buffer.append(getPointValue(v.get(i)));}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(41);return buffer.toString();
    }

    private boolean hasByoyomiInformation(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(42);ConstGameInfo info = node.getGameInfoConst();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(43);if ((info == null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(45) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(44);return false;}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(46);TimeSettings settings = info.getTimeSettings();
        return (settings != null && settings.getUseByoyomi());
    }

    private void print(String text)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(47);if ((text.indexOf('\n') > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(49) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(48);printNewLine();
            m_buffer.append(text);
            printNewLine();
            return;
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(50);if ((m_buffer.length() + text.length() > MAX_CHARS_PER_LINE) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(52) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(51);printNewLine();}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(53);m_buffer.append(text);
    }

    private void printNewLine()
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(54);if ((m_buffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(56) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(55);m_out.println(m_buffer.toString());
            m_buffer.replace(0, m_buffer.length(), "");
        }
    }

    private void printHeader(String application, String version)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(57);StringBuilder header = new StringBuilder(128);
        header.append(";FF[4]CA[");
        header.append(getEscaped(ENCODING));
        header.append(']');
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(58);if ((application != null && ! application.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(60) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(59);String appName = application;
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(61);if ((version != null && ! version.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(63) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(62);appName = appName + ":" + version;}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(64);header.append("AP[");
            header.append(getEscaped(appName));
            header.append(']');
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(65);if ((m_size != 19) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(67) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(66);header.append("SZ[");
            header.append(m_size);
            header.append(']');
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(68);print(header.toString());
    }

    private void printGameInfo(ConstGameInfo info)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(69);int handicap = info.getHandicap();
        Komi komi = info.getKomi();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(70);if ((handicap > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(72) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(71);print("HA[" + handicap + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(73);if ((komi != null && ! (handicap > 0 && komi.equals(new Komi(0)))) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(75) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(74);print("KM[" + komi + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(76);TimeSettings timeSettings = info.getTimeSettings();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(77);if ((timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(79) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(78);print("TM[" + timeSettings.getPreByoyomi() / 1000 + "]");
            String overtime = SgfUtil.getOvertime(timeSettings);
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(80);if ((overtime != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(82) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(81);print("OT[" + overtime + "]");}
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(83);printInfo("PB", info.get(StringInfoColor.NAME, BLACK));
        printInfo("PW", info.get(StringInfoColor.NAME, WHITE));
        printInfo("BR", info.get(StringInfoColor.RANK, BLACK));
        printInfo("WR", info.get(StringInfoColor.RANK, WHITE));
        printInfo("BT", info.get(StringInfoColor.TEAM, BLACK));
        printInfo("WT", info.get(StringInfoColor.TEAM, WHITE));
        printInfo("DT", info.get(StringInfo.DATE));
        printInfo("RE", info.get(StringInfo.RESULT));
        printInfo("RU", info.get(StringInfo.RULES));
        printInfo("US", info.get(StringInfo.USER));
        printInfo("CP", info.get(StringInfo.COPYRIGHT));
        printInfo("AN", info.get(StringInfo.ANNOTATION));
        printInfo("RO", info.get(StringInfo.ROUND));
        printInfo("SO", info.get(StringInfo.SOURCE));
        printNewLine();
    }

    private void printInfo(String label, String value)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(84);if ((value == null || value.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(86) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(85);return;}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(87);print(label + "[" + getEscaped(value) + "]");
    }

    private void printLabels(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(88);Map<GoPoint,String> labels = node.getLabelsUnmodifiable();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(89);if ((labels == null || labels.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(91) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(90);return;}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(92);StringBuilder buffer = new StringBuilder(STRINGBUF_CAPACITY);
        buffer.append("LB");
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(93);for (Map.Entry<GoPoint,String> entry : labels.entrySet())
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(95);GoPoint point = entry.getKey();
            String value = entry.getValue();
            buffer.append('[');
            buffer.append(getPoint(point));
            buffer.append(':');
            buffer.append(getEscaped(value, true));
            buffer.append(']');
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(94);print(buffer.toString());
    }

    private void printMarked(ConstNode node, String property, MarkType type)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(96);ConstPointList marked = node.getMarkedConst(type);
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(97);if ((marked != null && ! marked.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(99) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(98);print(property + getPointList(marked));}
    }

    private void printNode(ConstNode node, boolean isRoot)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(100);Move move = node.getMove();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(101);if ((! isRoot) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(103) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(102);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(105) && false))
            {
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(104);int moveNumber = getMoveNumberInVariation(node);
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(106);if ((moveNumber != 1 && moveNumber % 10 == 1) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(108) && false))
                    {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(107);printNewLine();}
            }
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(109);print(";");
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(110);ConstGameInfo info = node.getGameInfoConst();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(111);if ((info != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(113) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(112);printGameInfo(info);}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(114);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(116) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(115);String point = getPointValue(move.getPoint());
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(117);if ((move.getColor() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(119) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(118);print("B" + point);}
            else
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(180);print("W" + point);}
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(120);for (GoColor c : BLACK_WHITE_EMPTY)
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(165);ConstPointList points = node.getSetup(c);
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(166);if ((points.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(168) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(167);continue;}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(169);StringBuilder buffer = new StringBuilder(STRINGBUF_CAPACITY);
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(170);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(172) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(171);buffer.append("AB");}
            else {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(176);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(178) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(177);buffer.append("AW");}
            else
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(179);buffer.append("AE");}}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(173);for (GoPoint p : points)
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(175);buffer.append(getPointValue(p));}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(174);print(buffer.toString());
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(121);String comment = node.getComment();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(122);if ((! StringUtil.isEmpty(comment)) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(124) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(123);print("C[" + getEscaped(comment) + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(125);if ((! Double.isNaN(node.getTimeLeft(BLACK))) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(127) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(126);print("BL[" + node.getTimeLeft(BLACK) + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(128);if ((node.getMovesLeft(BLACK) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(130) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(129);print("OB[" + node.getMovesLeft(BLACK) + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(131);if ((! Double.isNaN(node.getTimeLeft(WHITE))) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(133) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(132);print("WL[" + node.getTimeLeft(WHITE) + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(134);if ((node.getMovesLeft(WHITE) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(136) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(135);print("OW[" + node.getMovesLeft(WHITE) + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(137);if ((node.getPlayer() != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(139) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(138);printToPlay(node.getPlayer());}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(140);printMarked(node, "MA", MarkType.MARK);
        printMarked(node, "CR", MarkType.CIRCLE);
        printMarked(node, "SQ", MarkType.SQUARE);
        printMarked(node, "TR", MarkType.TRIANGLE);
        printMarked(node, "SL", MarkType.SELECT);
        printMarked(node, "TB", MarkType.TERRITORY_BLACK);
        printMarked(node, "TW", MarkType.TERRITORY_WHITE);
        printLabels(node);
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(141);if ((! Double.isNaN(node.getValue())) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(143) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(142);print("V[" + node.getValue() + "]");}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(144);ConstSgfProperties sgfProps = NodeUtil.cleanSgfProps(node);
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(145);if ((sgfProps != null) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(147) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(146);for (String key : sgfProps.getKeys())
            {
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(158);if ((key.equals("OT") && hasByoyomiInformation(node)) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(160) && false))
                    {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(159);continue;}
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(161);print(key);
                $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(162);for (int i = 0; (i < sgfProps.getNumberValues(key)) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(164) && false); ++i)
                    {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(163);print("[" + sgfProps.getValue(key, i) + "]");}
            }}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(148);int numberChildren = node.getNumberChildren();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(149);if ((numberChildren == 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(151) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(150);return;}
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(152);if ((numberChildren == 1) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(154) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(153);printNode(node.getChildConst(), false);
            return;
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(155);for (int i = 0; (i < numberChildren) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(157) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(156);printNewLine();
            print("(");
            printNode(node.getChildConst(i), false);
            print(")");
        }
    }

    private void printPosition(ConstBoard board)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(181);PointList black = new PointList();
        PointList white = new PointList();
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(182);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(184);GoColor c = board.getColor(p);
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(185);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(187) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(186);black.add(p);}
            else {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(188);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(190) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(189);white.add(p);}}
        }
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(183);printSetup(black, white);
        printNewLine();
        printToPlay(board.getToMove());
    }

    private void printSetup(ConstPointList black, ConstPointList white)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(191);if ((black.size() > 0 || white.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(193) && false))
        {
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(192);if ((black.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(195) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(194);print("AB" + getPointList(black));}
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(196);printNewLine();
            $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(197);if ((white.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(199) && false))
                {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(198);print("AW" + getPointList(white));}
        }
    }

    private void printToPlay(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(200);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(202) && false))
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(201);print("PL[B]");}
        else
            {$qualityscroll_cover_jacov_probe_cf57d58ef0c36ddb(203);print("PL[W]");}
    }
}
