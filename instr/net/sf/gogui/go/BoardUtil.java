/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// BoardUtil.java

package net.sf.gogui.go;

import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;

/** Static utility functions related to class Board. */
public final class BoardUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -3127485187591031034L,/* translation unit id   */ 6015394993458750524L,/* timestamp             */ 1709177900335L,/* source file name      */ "BoardUtil.java",/* probe size            */ 111);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_537af9e028c5a43c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Number of rotation modes for <code>BoardUtil.rotate()</code>.
        @see #rotate */
    public static final int NUMBER_ROTATIONS = 8;

    /** Copy the state of one board to another.
        Initializes the target board with the size and the setup stones of the
        source board and executes all moves of the source board on the target
        board. */
    public static void copy(Board target, ConstBoard source)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(0);target.init(source.getSize());
        ConstPointList setupBlack = source.getSetup(BLACK);
        ConstPointList setupWhite = source.getSetup(WHITE);
        GoColor setupPlayer = source.getSetupPlayer();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(1);if ((setupBlack.size() > 0 || setupWhite.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(3) && false))
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(2);if ((source.isSetupHandicap()) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(5) && false))
                {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(4);target.setupHandicap(setupBlack);}
            else
                {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(9);target.setup(setupBlack, setupWhite, setupPlayer);}
        }
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(6);for (int i = 0; (i < source.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(8) && false); ++i)
            {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(7);target.play(source.getMove(i));}
    }

    /** Get board position as text diagram (without additional game
        information).
        Calls <code>toString()</code> with <code>withGameInfo == false</code>.
        @see #toString(ConstBoard, boolean) */
    public static String toString(ConstBoard board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(10);return toString(board, true, false);
    }

    /** Get board position as text diagram.
        @param board The board to print.
        @param withGameInfo Print additional game information on the right
        side of the board (at present only number of prisoners)
        @param color Colorize board using ANSI escape sequences
        @return Board position as text diagram. */
    public static String toString(ConstBoard board, boolean withGameInfo,
                                  boolean color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(11);StringBuilder s = new StringBuilder(1024);
        int size = board.getSize();
        String separator = System.getProperty("line.separator");
        assert separator != null;
        printXCoords(size, s, separator);
        String ansiStart = "\u001b[";
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(12);for (int y = size - 1; (y >= 0) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(14) && false); --y)
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(13);printYCoord(y, s, true);
            s.append(' ');
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(20);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(22) && false); ++x)
            {
                $qualityscroll_cover_jacov_probe_537af9e028c5a43c(21);if ((x > 0) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(32) && false))
                {
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(31);if ((color) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(34) && false))
                    {
                        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(33);s.append(ansiStart);
                        s.append("43m");
                    }
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(35);s.append(' ');
                }
                $qualityscroll_cover_jacov_probe_537af9e028c5a43c(36);GoPoint point = GoPoint.get(x, y);
                GoColor c = board.getColor(point);
                $qualityscroll_cover_jacov_probe_537af9e028c5a43c(37);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(39) && false))
                {
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(38);if ((color) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(41) && false))
                    {
                        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(40);s.append(ansiStart);
                        s.append("0;30;43m");
                    }
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(42);s.append('X');
                }
                else {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(43);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(45) && false))
                {
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(44);if ((color) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(47) && false))
                    {
                        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(46);s.append(ansiStart);
                        s.append("1;37;43m");
                    }
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(48);s.append('O');
                }
                else
                {
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(49);if ((color) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(51) && false))
                    {
                        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(50);s.append(ansiStart);
                        s.append("1;30;43m");
                    }
                    $qualityscroll_cover_jacov_probe_537af9e028c5a43c(52);if ((board.isHandicap(point)) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(54) && false))
                        {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(53);s.append('+');}
                    else
                        {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(55);s.append('.');}
                }}
            }
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(23);if ((color) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(25) && false))
            {
                $qualityscroll_cover_jacov_probe_537af9e028c5a43c(24);s.append(ansiStart);
                s.append("0m");
            }
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(26);s.append(' ');
            printYCoord(y, s, false);
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(27);if ((withGameInfo) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(29) && false))
                {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(28);printGameInfo(board, s, y);}
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(30);s.append(separator);
        }
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(15);printXCoords(size, s, separator);
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(16);if ((! withGameInfo) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(18) && false))
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(17);printToMove(board, s);
            s.append(separator);
        }
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(19);return s.toString();
    }

    /** Rotate/mirror point.
        Rotates and/or mirrors a point on a given board according to a given
        rotation mode.
        <table border="1">
        <tr><th>Mode</th><th>x</th><th>y</th></tr>
        <tr><td>0</td><td>x</td><td>y</td></tr>
        <tr><td>1</td><td>size - x - 1</td><td>y</td></tr>
        <tr><td>2</td><td>x</td><td>size - y - 1</td></tr>
        <tr><td>3</td><td>y</td><td>x</td></tr>
        <tr><td>4</td><td>size - y - 1</td><td>x</td></tr>
        <tr><td>5</td><td>y</td><td>size - x - 1</td></tr>
        <tr><td>6</td><td>size - x - 1</td><td>size - y - 1</td></tr>
        <tr><td>7</td><td>size - y - 1</td><td>size - x - 1</td></tr>
        </table>
        @param rotationMode The rotation mode in [0..NUMBER_ROTATIONS]
        @param point The point to be rotated
        @param size The board size
        @return The rotated mirrored point */
    public static GoPoint rotate(int rotationMode, GoPoint point, int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(56);assert rotationMode < NUMBER_ROTATIONS;
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(57);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(59) && false))
            {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(58);return null;}
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(60);int x = point.getX();
        int y = point.getY();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(61);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (rotationMode)
        {
        case 0:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(62); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(71);return GoPoint.get(x, y);
        case 1:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(63); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(72);return GoPoint.get(size - x - 1, y);
        case 2:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(64); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(73);return GoPoint.get(x, size - y - 1);
        case 3:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(65); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(74);return GoPoint.get(y, x);
        case 4:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(66); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(75);return GoPoint.get(size - y - 1, x);
        case 5:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(67); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(76);return GoPoint.get(y, size - x - 1);
        case 6:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(68); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(77);return GoPoint.get(size - x - 1, size - y - 1);
        case 7:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(69); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(78);return GoPoint.get(size - y - 1, size - x - 1);
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_537af9e028c5a43c(70); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(79);return GoPoint.get(x, y);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private BoardUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_537af9e028c5a43c(80);
    }

    private static void printGameInfo(ConstBoard board, StringBuilder s,
                                      int yIndex)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(81);int size = board.getSize();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(82);if ((yIndex == size - 1) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(84) && false))
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(83);s.append("  ");
            printToMove(board, s);
        }
        else {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(85);if ((yIndex == size - 2) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(87) && false))
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(86);s.append("  Prisoners: B ");
            s.append(board.getCaptured(BLACK));
            s.append("  W ");
            s.append(board.getCaptured(WHITE));
        }
        else {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(88);if ((yIndex <= size - 4) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(90) && false))
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(89);int moveNumber = board.getNumberMoves() - yIndex - 1;
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(91);if ((moveNumber >= 0) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(93) && false))
            {
                $qualityscroll_cover_jacov_probe_537af9e028c5a43c(92);s.append("  ");
                s.append(moveNumber + 1);
                s.append(' ');
                s.append(board.getMove(moveNumber));
            }
        }}}
    }

    private static void printToMove(ConstBoard board, StringBuilder buffer)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(94);buffer.append(board.getToMove().getCapitalizedName());
        buffer.append(" to play");
    }

    private static void printXCoords(int size, StringBuilder s,
                                     String separator)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(95);s.append("   ");
        int x;
        char c;
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(96);for (x = 0, c = 'A'; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(98) && false); ++x, ++c)
        {
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(97);if ((c == 'I') ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(101) && false))
                {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(100);++c;}
            $qualityscroll_cover_jacov_probe_537af9e028c5a43c(102);s.append(c);
            s.append(' ');
        }
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(99);s.append(separator);
    }

    private static void printYCoord(int y, StringBuilder s, boolean alignRight)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(103);String string = Integer.toString(y + 1);
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(104);if ((alignRight && string.length() == 1) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(106) && false))
            {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(105);s.append(' ');}
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(107);s.append(string);
        $qualityscroll_cover_jacov_probe_537af9e028c5a43c(108);if ((! alignRight && string.length() == 1) ? true : (!$qualityscroll_cover_jacov_probe_537af9e028c5a43c(110) && false))
            {$qualityscroll_cover_jacov_probe_537af9e028c5a43c(109);s.append(' ');}
    }
}
