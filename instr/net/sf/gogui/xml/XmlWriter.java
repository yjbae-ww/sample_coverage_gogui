/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// XmlWriter.java

package net.sf.gogui.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.EnumSet;
import java.util.Map;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstSgfProperties;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.game.SgfProperties;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.EMPTY;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.sgf.SgfUtil;
import net.sf.gogui.util.XmlUtil;

/** Write a game or board position in XML style to a stream.
    This class uses Jago's XML format, see http://www.rene-grothmann.de/jago
    It writes files that are valid XML documents according to the go.dtd
    from the Jago webpage (10/2007), see also the appendix "XML Format"
    of the GoGui documentation. */
public class XmlWriter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = XmlWriter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -182711593702034927L,/* translation unit id   */ 1943916745114059888L,/* timestamp             */ 1709177904313L,/* source file name      */ "XmlWriter.java",/* probe size            */ 199);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Construct writer and write tree. */
    public XmlWriter(OutputStream out, ConstGameTree tree, String application)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(0);m_out = new PrintStream(out, false, "UTF-8");
            m_out.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        }
        catch (UnsupportedEncodingException e)
        {
            // Every Java implementation is required to support UTF-8
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(6);assert false;
            m_out = new PrintStream(out, false);
            m_out.print("<?xml version='1.0'?>\n");
        }
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(1);ConstNode root = tree.getRootConst();
        ConstGameInfo info = tree.getGameInfoConst(root);
        // Game name is not supported in game.GameInformation, but XmlReader
        // puts it into the SGF-Proprty "GN"
        String gameNameAtt = "";
        ConstSgfProperties sgfProperties = root.getSgfPropertiesConst();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(2);if ((sgfProperties != null && sgfProperties.hasKey("GN")
            && sgfProperties.getNumberValues("GN") > 0) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(4) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(3);gameNameAtt = " name=\""
                + XmlUtil.escapeAttr(sgfProperties.getValue("GN", 0)) + "\"";}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(5);m_out.print("<Go>\n" +
                    "<GoGame" + gameNameAtt + ">\n");
        m_boardSize = tree.getBoardSize();
        printGameInfo(application, info);
        m_out.print("<Nodes>\n");
        printNode(root, true);
        m_out.print("</Nodes>\n" +
                    "</GoGame>\n" +
                    "</Go>\n");
        m_out.close();
    }

    private int m_boardSize;

    private PrintStream m_out;

    private String getSgfPoint(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(7);if ((p == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(9) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(8);return "";}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(10);int x = 'a' + p.getX();
        int y = 'a' + (m_boardSize - p.getY() - 1);
        return "" + (char)x + (char)y;
    }

    private void printElementWithParagraphs(String element, String value)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(11);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(13) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(12);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(14);StringReader reader = new StringReader(value);
        m_out.print("<" + element + ">\n");
        boolean endsWithNewline = false;
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(15);while (true)
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(16);String line = readLine(reader);
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(22);if ((line.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(24) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(23);break;}
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(25);endsWithNewline = line.endsWith("\n");
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(26);if ((endsWithNewline) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(28) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(27);line = line.substring(0, line.length() - 1);}
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(29);if ((line.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(31) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(30);m_out.print("<P/>\n");}
            else
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(32);printElementLine("P", line);}
        }
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(18);if ((endsWithNewline) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(20) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(19);m_out.print("<P/>\n");}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(21);m_out.print("</" + element + ">\n");
    }

    private void printElementLine(String element, String text)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(33);m_out.print("<" + element + ">" + XmlUtil.escapeText(text)
                    + "</" + element + ">\n");
    }

    private void printGameInfo(String application, ConstGameInfo info)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(34);m_out.print("<Information>\n");
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(35);if ((application != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(37) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(36);printElementLine("Application", application);}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(38);printElementLine("BoardSize", Integer.toString(m_boardSize));
        printInfo("WhitePlayer", info.get(StringInfoColor.NAME, WHITE));
        printInfo("BlackPlayer", info.get(StringInfoColor.NAME, BLACK));
        printInfo("WhiteRank", info.get(StringInfoColor.RANK, WHITE));
        printInfo("BlackRank", info.get(StringInfoColor.RANK, BLACK));
        printInfo("Date", info.get(StringInfo.DATE));
        printInfo("Rules", info.get(StringInfo.RULES));
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(39);if ((info.getHandicap() > 0) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(41) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(40);printInfo("Handicap", Integer.toString(info.getHandicap()));}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(42);if ((info.getKomi() != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(44) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(43);printInfo("Komi", info.getKomi().toString());}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(45);if ((info.getTimeSettings() != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(47) && false))
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(46);long time = info.getTimeSettings().getPreByoyomi() / 1000L;
            printInfo("Time", Long.toString(time));
        }
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(48);printInfo("Result", info.get(StringInfo.RESULT));
        printInfo("WhiteTeam", info.get(StringInfoColor.TEAM, WHITE));
        printInfo("BlackTeam", info.get(StringInfoColor.TEAM, BLACK));
        printInfo("User", info.get(StringInfo.USER));
        printInfo("Annotation", info.get(StringInfo.ANNOTATION));
        printInfo("Source", info.get(StringInfo.SOURCE));
        printInfo("Round", info.get(StringInfo.ROUND));
        printElementWithParagraphs("Copyright", info.get(StringInfo.COPYRIGHT));
        m_out.print("</Information>\n");
    }

    private void printInfo(String element, String value)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(49);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(51) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(50);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(52);printElementLine(element, value);
    }

    private void printMarkup(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(53);printMarkup(node, MarkType.MARK, "");
        printMarkup(node, MarkType.CIRCLE, " type=\"circle\"");
        printMarkup(node, MarkType.SQUARE, " type=\"square\"");
        printMarkup(node, MarkType.TRIANGLE, " type=\"triangle\"");
        printMarkup(node, MarkType.TERRITORY_BLACK, " territory=\"black\"");
        printMarkup(node, MarkType.TERRITORY_WHITE, " territory=\"white\"");
        ConstPointList pointList = node.getMarkedConst(MarkType.SELECT);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(54);if ((pointList != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(56) && false))
            // There is no type select in the Mark element -> use SGF/SL
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(55);for (GoPoint p : pointList)
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(62);m_out.print("<SGF type=\"SL\"><Arg>" + getSgfPoint(p)
                            + "</Arg></SGF>\n");}}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(57);Map<GoPoint,String> labels = node.getLabelsUnmodifiable();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(58);if ((labels != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(60) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(59);for (Map.Entry<GoPoint,String> e : labels.entrySet())
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(61);m_out.print("<Mark at=\"" + e.getKey() + "\" label=\""
                            + XmlUtil.escapeAttr(e.getValue()) + "\"/>\n");}}
    }

    private void printMarkup(ConstNode node, MarkType type, String attributes)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(63);ConstPointList pointList = node.getMarkedConst(type);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(64);if ((pointList == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(66) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(65);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(67);for (GoPoint p : pointList)
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(68);m_out.print("<Mark at=\"" + p + "\"" + attributes + "/>\n");}
    }

    private void printMove(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(69);Move move = node.getMove();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(70);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(72) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(71);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(73);GoPoint p = move.getPoint();
        String at = (((p == null) ? ($qualityscroll_cover_jacov_probe_1afa2dfaf9750470(74) || true) : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(75) && false)) ? "" : p.toString());
        GoColor c = move.getColor();
        int number = NodeUtil.getMoveNumber(node);
        String timeLeftAtt = "";
        double timeLeft = node.getTimeLeft(c);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(76);if ((! Double.isNaN(timeLeft)) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(78) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(77);timeLeftAtt = " timeleft=\"" + timeLeft + "\"";}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(79);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(81) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(80);m_out.print("<Black number=\"" + number + "\" at=\"" + at
                        + "\"" + timeLeftAtt + "/>\n");}
        else {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(91);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(93) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(92);m_out.print("<White number=\"" + number + "\" at=\"" + at
                        + "\"" + timeLeftAtt + "/>\n");}}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(82);int movesLeft = node.getMovesLeft(c);
        // There is no movesleft attribute in Black/White -> use SGF/OW,OB
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(83);if ((movesLeft >= 0) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(85) && false))
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(84);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(87) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(86);m_out.print("<SGF type=\"OB\"><Arg>" + movesLeft
                            + "</Arg></SGF>\n");}
            else {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(88);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(90) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(89);m_out.print("<SGF type=\"OW\"><Arg>" + movesLeft
                            + "</Arg></SGF>\n");}}
        }
    }

    private void printNode(ConstNode node, boolean isRoot)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(94);Move move = node.getMove();
        String comment = node.getComment();
        SgfProperties sgfProps = NodeUtil.cleanSgfProps(node);
        // Game name is not supported in game.GameInformation, but XmlReader
        // puts it into the SGF-Proprty "N"
        String nameAtt = "";
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(95);if ((sgfProps.hasKey("N") && sgfProps.getNumberValues("N") > 0) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(97) && false))
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(96);nameAtt = " name=\""
                + XmlUtil.escapeAttr(sgfProps.getValue("N", 0)) + "\"";
            sgfProps.remove("N");
        }

        // Preserve time left that cannot be written as timeleft attribute
        // of move element as SGF element
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(98);if ((! Double.isNaN(node.getTimeLeft(BLACK))
            && (move == null || move.getColor() != BLACK)) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(100) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(99);sgfProps.add("BL", Double.toString(node.getTimeLeft(BLACK)));}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(101);if ((! Double.isNaN(node.getTimeLeft(WHITE))
            && (move == null || move.getColor() != WHITE)) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(103) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(102);sgfProps.add("WL", Double.toString(node.getTimeLeft(WHITE)));}

        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(104);ConstGameInfo info = node.getGameInfoConst();

        // Write overtime information as SGF element (no XML element exists)
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(105);if ((isRoot) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(107) && false))
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(106);TimeSettings timeSettings = info.getTimeSettings();
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(108);if ((timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(110) && false))
            {
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(109);String overtime = SgfUtil.getOvertime(timeSettings);
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(111);if ((overtime != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(113) && false))
                    {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(112);sgfProps.add("OT", overtime);}
            }
        }

        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(114);Map<GoPoint,String> labels = node.getLabelsUnmodifiable();
        boolean hasMarkup = (labels != null && ! labels.isEmpty());
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(115);if ((! hasMarkup) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(117) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(116);for (MarkType type : EnumSet.allOf(MarkType.class))
            {
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(144);ConstPointList pointList = node.getMarkedConst(type);
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(145);if ((pointList != null && ! node.getMarkedConst(type).isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(147) && false))
                {
                    $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(146);hasMarkup = true;
                    break;
                }
            }}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(118);boolean hasSetup = node.hasSetup() || node.getPlayer() != null;
        // Moves left are currently written as SGF element, which needs a Node
        boolean hasMovesLeft =
            (move != null && node.getMovesLeft(move.getColor()) != -1);
        boolean hasNonRootGameInfo = (info != null && ! isRoot);

        // Root is considered empty, even if it has game info, because
        // this is written in Information element
        boolean isEmptyButMoveOrComment
            = (sgfProps.isEmpty()
               && ! hasSetup && ! hasMarkup && ! hasMovesLeft
               && !  hasNonRootGameInfo);

        // Is a node element needed? (not if only move and comment)
        boolean needsNode = (! isEmptyButMoveOrComment || ! nameAtt.equals("")
                             || (move == null && comment != null));

        boolean isEmpty =
            (isEmptyButMoveOrComment && comment == null && move == null);

        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(119);if ((isEmpty) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(121) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(120);m_out.print("<Node" + nameAtt + "/>\n");}
        else
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(133);if ((needsNode) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(135) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(134);m_out.print("<Node" + nameAtt + ">\n");}
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(136);printMove(node);
            printSetup(node);
            printMarkup(node);
            printElementWithParagraphs("Comment", comment);
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(137);if ((hasNonRootGameInfo) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(139) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(138);putGameInfoSgf(info, sgfProps);}
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(140);printSgfProperties(sgfProps);
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(141);if ((needsNode) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(143) && false))
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(142);m_out.print("</Node>\n");}
        }

        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(122);ConstNode father = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(123);if ((father != null && father.getChildConst() == node) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(125) && false))
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(124);int numberSiblings = father.getNumberChildren();
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(126);for (int i = 1; (i < numberSiblings) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(128) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(127);m_out.print("<Variation>\n");
                printNode(father.getChildConst(i), false);
                m_out.print("</Variation>\n");
            }
        }
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(129);ConstNode child = node.getChildConst();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(130);if ((child != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(132) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(131);printNode(child, false);}
    }

    private void printSgfProperties(ConstSgfProperties sgfProps)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(148);for (String key : sgfProps.getKeys())
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(149);m_out.print("<SGF type=\"" + key + "\">");
            int numberValues = sgfProps.getNumberValues(key);
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(150);for (int i = 0; (i < numberValues) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(152) && false); ++i)
                {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(151);m_out.print("<Arg>" +
                            XmlUtil.escapeText(sgfProps.getValue(key, i))
                            + "</Arg>");}
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(153);m_out.print("</SGF>\n");
        }
    }

    private void printSetup(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(154);for (GoPoint p : node.getSetup(BLACK))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(166);m_out.print("<AddBlack at=\"" + p + "\"/>\n");}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(155);for (GoPoint p : node.getSetup(WHITE))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(165);m_out.print("<AddWhite at=\"" + p + "\"/>\n");}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(156);for (GoPoint p : node.getSetup(EMPTY))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(164);m_out.print("<Delete at=\"" + p + "\"/>\n");}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(157);GoColor player = node.getPlayer();
        // The BlackToPlay, WhiteToPlay elements in the DTD are not usable:
        // they don't have a legal parent and it is not clear why they
        // have a text content -> save player with a SGF property
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(158);if ((BLACK.equals(player)) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(160) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(159);m_out.print("<SGF type=\"PL\"><Arg>B</Arg></SGF>\n");}
        else {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(161);if ((WHITE.equals(player)) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(163) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(162);m_out.print("<SGF type=\"PL\"><Arg>W</Arg></SGF>\n");}}
    }

    /** Put game information for non-root nodes into SGF properties.
        Game information for non-root nodes Not supported directly in XML. */
    private void putGameInfoSgf(ConstGameInfo info, SgfProperties sgfProps)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(167);putGameInfoSgf(info, sgfProps, "PB", StringInfoColor.NAME, BLACK);
        putGameInfoSgf(info, sgfProps, "PW", StringInfoColor.NAME, WHITE);
        putGameInfoSgf(info, sgfProps, "BR", StringInfoColor.RANK, BLACK);
        putGameInfoSgf(info, sgfProps, "WR", StringInfoColor.RANK, WHITE);
        putGameInfoSgf(info, sgfProps, "BT", StringInfoColor.TEAM, BLACK);
        putGameInfoSgf(info, sgfProps, "WT", StringInfoColor.TEAM, WHITE);
        putGameInfoSgf(info, sgfProps, "DT", StringInfo.DATE);
        putGameInfoSgf(info, sgfProps, "RE", StringInfo.RESULT);
        putGameInfoSgf(info, sgfProps, "RO", StringInfo.ROUND);
        putGameInfoSgf(info, sgfProps, "RU", StringInfo.RULES);
        putGameInfoSgf(info, sgfProps, "US", StringInfo.USER);
        putGameInfoSgf(info, sgfProps, "CP", StringInfo.COPYRIGHT);
        putGameInfoSgf(info, sgfProps, "AN", StringInfo.ANNOTATION);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(168);if ((info.getHandicap() > 0) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(170) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(169);putGameInfoSgf(sgfProps, "HA",
                           Integer.toString(info.getHandicap()));}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(171);if ((info.getKomi() != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(173) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(172);putGameInfoSgf(sgfProps, "KM", info.getKomi().toString());}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(174);if ((info.getTimeSettings() != null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(176) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(175);putGameInfoSgf(sgfProps, "TM", info.getTimeSettings().toString());}
    }

    private void putGameInfoSgf(SgfProperties sgfProps, String key,
                                String value)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(177);sgfProps.add(key, value);
    }

    private void putGameInfoSgf(ConstGameInfo info, SgfProperties sgfProps,
                                String key, StringInfo type)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(178);String value = info.get(type);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(179);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(181) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(180);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(182);sgfProps.add(key, value);
    }

    private void putGameInfoSgf(ConstGameInfo info, SgfProperties sgfProps,
                                String key, StringInfoColor type, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(183);String value = info.get(type, c);
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(184);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(186) && false))
            {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(185);return;}
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(187);sgfProps.add(key, value);
    }

    /** Reads a line without trimming the trailing newline. */
    private static String readLine(StringReader reader)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(188);StringBuilder result = new StringBuilder();
        try
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(189);int c;
            do
            {
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(190);c = reader.read();
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(191);if ((c == -1) ? true : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(193) && false))
                    {$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(192);break;}
                $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(195);result.append((char)c);
            }
            while ((((char)c != '\n') ? ($qualityscroll_cover_jacov_probe_1afa2dfaf9750470(196) || true) : (!$qualityscroll_cover_jacov_probe_1afa2dfaf9750470(197) && false)));
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(198);assert false;
        }
        $qualityscroll_cover_jacov_probe_1afa2dfaf9750470(194);return result.toString();
    }
}
