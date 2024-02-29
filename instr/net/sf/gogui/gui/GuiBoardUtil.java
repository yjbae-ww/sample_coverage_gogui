/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiBoardUtil.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.CountScore;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Marker;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;

/** Utility functions for class GuiBoard. */
public final class GuiBoardUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiBoardUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4130288179609190892L,/* translation unit id   */ 1361407525495162170L,/* timestamp             */ 1709177902423L,/* source file name      */ "GuiBoardUtil.java",/* probe size            */ 227);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static Color getColor(String string)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(0);if ((string.equals("blue")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(2) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(1);return Color.blue;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(3);if ((string.equals("cyan")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(5) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(4);return Color.cyan;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(6);if ((string.equals("green")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(8) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(7);return Color.green;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(9);if ((string.equals("gray")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(11) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(10);return Color.lightGray;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(12);if ((string.equals("magenta")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(14) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(13);return Color.magenta;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(15);if ((string.equals("pink")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(17) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(16);return Color.pink;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(18);if ((string.equals("red")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(20) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(19);return Color.red;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(21);if ((string.equals("yellow")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(23) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(22);return Color.yellow;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(24);if ((string.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(26) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(25);return Color.black;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(27);if ((string.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(29) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(28);return Color.white;}
        try
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(30);return Color.decode(string);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(31);return null;
        }
    }

    public static boolean[][] getMark(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(32);int size = guiBoard.getBoardSize();
        boolean[][] result = new boolean[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(33);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(35) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(34);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(38) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(37);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getMark(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(36);return result;
    }

    public static boolean[][] getMarkCircle(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(39);int size = guiBoard.getBoardSize();
        boolean[][] result = new boolean[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(40);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(42) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(41);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(45) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(44);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getMarkCircle(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(43);return result;
    }

    public static boolean[][] getMarkSquare(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(46);int size = guiBoard.getBoardSize();
        boolean[][] result = new boolean[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(47);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(49) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(48);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(52) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(51);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getMarkSquare(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(50);return result;
    }

    public static boolean[][] getMarkTriangle(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(53);int size = guiBoard.getBoardSize();
        boolean[][] result = new boolean[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(54);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(56) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(55);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(59) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(58);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getMarkTriangle(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(57);return result;
    }

    public static String[][] getLabels(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(60);int size = guiBoard.getBoardSize();
        String[][] result = new String[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(61);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(63) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(62);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(66) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(65);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getLabel(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(64);return result;
    }

    public static boolean[][] getSelects(GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(67);int size = guiBoard.getBoardSize();
        boolean[][] result = new boolean[size][size];
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(68);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(70) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(69);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(73) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(72);GoPoint point = GoPoint.get(x, y);
                result[x][y] = guiBoard.getSelect(point);
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(71);return result;
    }

    public static void setSelect(GuiBoard guiBoard, ConstPointList pointList,
                                 boolean select)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(74);if ((pointList == null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(76) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(75);return;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(77);for (GoPoint p : pointList)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(78);guiBoard.setSelect(p, select);}
    }

    public static void scoreBegin(GuiBoard guiBoard, CountScore countScore,
                                  ConstBoard board, ConstPointList deadStones)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(79);countScore.begin(board, deadStones);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(80);if ((deadStones != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(82) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(81);for (GoPoint p : deadStones)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(84);guiBoard.setCrossHair(p, true);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(83);computeScore(guiBoard, countScore, board);
    }

    public static void scoreSetDead(GuiBoard guiBoard, CountScore countScore,
                                    ConstBoard board, GoPoint p)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(85);GoColor c = board.getColor(p);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(86);if ((c == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(88) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(87);return;}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(89);PointList stones = countScore.changeStatus(p);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(90);for (GoPoint stone : stones)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(92);guiBoard.setCrossHair(stone, countScore.isDead(stone));}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(91);computeScore(guiBoard, countScore, board);
    }

    public static void showBWBoard(GuiBoard guiBoard, String[][] board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(93);for (int x = 0; (x < board.length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(95) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(94);for (int y = 0; (y < board[x].length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(97) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(96);GoPoint point = GoPoint.get(x, y);
                String s = board[x][y].toLowerCase(Locale.ENGLISH);
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(98);if ((s.equals("b") || s.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(100) && false))
                    {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(99);guiBoard.setTerritory(point, BLACK);}
                else {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(101);if ((s.equals("w") || s.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(103) && false))
                    {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(102);guiBoard.setTerritory(point, WHITE);}
                else
                    {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(104);guiBoard.setTerritory(point, EMPTY);}}
            }}
    }

    /** @deprecated This function was renamed to showMoves(). The forwarding
        functions may be removed in the future */
    @Deprecated
	public static void showChildrenMoves(GuiBoard guiBoard,
                                         ConstPointList childrenMoves)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(105);showMoves(guiBoard, childrenMoves);
    }

    public static void showColorBoard(GuiBoard guiBoard, String[][] colors)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(106);for (int x = 0; (x < colors.length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(108) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(107);for (int y = 0; (y < colors[x].length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(110) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(109);GoPoint point = GoPoint.get(x, y);
                guiBoard.setFieldBackground(point, getColor(colors[x][y]));
            }}
    }

    public static void showDoubleBoard(GuiBoard guiBoard, double[][] board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(111);for (int x = 0; (x < board.length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(113) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(112);for (int y = 0; (y < board[x].length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(115) && false); ++y)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(114);guiBoard.setInfluence(GoPoint.get(x, y), board[x][y]);}}
    }

    public static void showStringBoard(GuiBoard guiBoard,
                                       String[][] board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(116);for (int x = 0; (x < board.length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(118) && false); ++x)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(117);for (int y = 0; (y < board[x].length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(120) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(119);GoPoint point = GoPoint.get(x, y);
                guiBoard.setLabel(point, board[x][y]);
            }}
    }

    /** Shows markup on board.
        Existing markup is not cleared (but may be overwritten. */
    public static void showMarkup(GuiBoard guiBoard, ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(121);ConstPointList mark = node.getMarkedConst(MarkType.MARK);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(122);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(124) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(123);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(155);guiBoard.setMark(p, true);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(125);mark = node.getMarkedConst(MarkType.CIRCLE);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(126);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(128) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(127);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(154);guiBoard.setMarkCircle(p, true);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(129);mark = node.getMarkedConst(MarkType.SQUARE);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(130);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(132) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(131);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(153);guiBoard.setMarkSquare(p, true);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(133);mark = node.getMarkedConst(MarkType.TRIANGLE);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(134);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(136) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(135);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(152);guiBoard.setMarkTriangle(p, true);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(137);GuiBoardUtil.setSelect(guiBoard, node.getMarkedConst(MarkType.SELECT),
                                true);
        mark = node.getMarkedConst(MarkType.TERRITORY_BLACK);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(138);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(140) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(139);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(151);guiBoard.setTerritory(p, BLACK);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(141);mark = node.getMarkedConst(MarkType.TERRITORY_WHITE);
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(142);if ((mark != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(144) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(143);for (GoPoint p : mark)
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(150);guiBoard.setTerritory(p, WHITE);}}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(145);Map<GoPoint,String> labels = node.getLabelsUnmodifiable();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(146);if ((labels != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(148) && false))
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(147);for (Map.Entry<GoPoint,String> entry : labels.entrySet())
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(149);GoPoint point = entry.getKey();
                String value = entry.getValue();
                guiBoard.setLabel(point, value);
            }
        }
    }

    /** Show a list of moves with labels 'A', 'B', 'C' ...
        If the list contains more than 26 unique moves, the label '*' is used.
        If a move appears more than once in the list, the character '&gt;'
        will be appended to the label. */
    public static void showMoves(GuiBoard guiBoard,
                                 ConstPointList childrenMoves)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(156);Marker marker = new Marker(guiBoard.getBoardSize());
        int numberMarked = 0;
        char label = 'A';
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(157);for (GoPoint p : childrenMoves)
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(158);if ((marker.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(160) && false))
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(159);String s = guiBoard.getLabel(p);
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(161);if ((! s.endsWith(">")) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(163) && false))
                    {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(162);guiBoard.setLabel(p, s + ">");}
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(164);continue;
            }
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(165);marker.set(p);
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(166);if ((numberMarked >= 26) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(168) && false))
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(167);guiBoard.setLabel(p, "*");}
            else
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(173);guiBoard.setLabel(p, Character.toString(label));}
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(169);if ((numberMarked < 26) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(171) && false))
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(170);++label;}
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(172);++numberMarked;
        }
    }

    public static void showPointList(GuiBoard guiBoard, ConstPointList points)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(174);guiBoard.clearAllMarkup();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(175);for (GoPoint p : points)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(176);if ((p != null && p.isOnBoard(guiBoard.getBoardSize())) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(178) && false))
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(177);guiBoard.setMarkSquare(p, true);}}
    }

    public static void showPointStringList(GuiBoard guiBoard,
                                           ConstPointList pointList,
                                           ArrayList<String> stringList)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(179);guiBoard.clearAllLabels();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(180);for (int i = 0; (i < pointList.size()) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(182) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(181);GoPoint point = pointList.get(i);
            String string = stringList.get(i);
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(183);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(185) && false))
                {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(184);guiBoard.setLabel(point, string);}
        }
    }

    /** Shows moves in variation as stones with move number labels on board.
        If there are several moves on the same point then the only first move
        is shown for short variations (less/equal ten moves); and only the
        last move for long variations. */
    public static void showVariation(GuiBoard guiBoard, Move[] variation)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(186);guiBoard.clearAllLabels();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(187);if ((variation.length > 10) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(189) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(188);for (int i = 0; (i < variation.length) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(191) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(190);Move move = variation[i];
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(192);if ((move.getPoint() != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(194) && false))
                {
                    $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(193);String label = Integer.toString(i + 1);
                    guiBoard.setGhostStone(move.getPoint(), move.getColor());
                    guiBoard.setLabel(move.getPoint(), label);
                }
            }}
        else
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(195);for (int i = variation.length - 1; (i >= 0) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(197) && false); --i)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(196);Move move = variation[i];
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(198);if ((move.getPoint() != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(200) && false))
                {
                    $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(199);String label = Integer.toString(i + 1);
                    guiBoard.setGhostStone(move.getPoint(), move.getColor());
                    guiBoard.setLabel(move.getPoint(), label);
                }
            }}
    }

    public static void updateFromGoBoard(GuiBoard guiBoard, ConstBoard board,
                                         boolean markLastMove,
                                         boolean showMoveNumbers)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(201);for (GoPoint p : board)
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(222);guiBoard.setColor(p, board.getColor(p));}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(202);GoPoint lastMove = null;
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(203);if ((board.getLastMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(205) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(204);lastMove = board.getLastMove().getPoint();}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(206);if ((markLastMove) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(208) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(207);guiBoard.markLastMove(lastMove);}
        else
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(221);guiBoard.markLastMove(null);}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(209);if ((showMoveNumbers) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(211) && false))
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(210);for (int i = 0; (i < board.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(213) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(212);GoPoint point = board.getMove(i).getPoint();
                $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(218);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(220) && false))
                    {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(219);guiBoard.setLabel(point, Integer.toString(i + 1));}
            }}
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(214);if ((lastMove == null) ? true : (!$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(216) && false))
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(215);int size = guiBoard.getBoardSize();
            guiBoard.setCursor(GoPoint.get(size / 2, size / 2));
        }
        else
            {$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(217);guiBoard.setCursor(lastMove);}
    }

    /** Make constructor unavailable; class is for namespace only. */
    private GuiBoardUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(223);
    }

    private static void computeScore(GuiBoard guiBoard,
                                     CountScore countScore,
                                     ConstBoard board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(224);countScore.compute();
        $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(225);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_12e4b0ee6faec53a(226);GoColor c = countScore.getColor(p);
            guiBoard.setTerritory(p, c);
        }
    }
}
