/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// TextParser.java

package net.sf.gogui.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.PointList;

/** Parse Go positions from ASCII text.
    Can handle a variety of formats. Black stones can be represented by 'X',
    'x', '@' or '#'; white stones by 'O' or 'o' (however one representation
    must be used consistently); '.', ',' and '+' are interpreted as empty
    points. Space characters are allowed between the points; leading numbers
    (or '|', '&gt;' and '$' characters) are ignored, as well as single
    inserted invalid lines (to support appended text after the row that was
    wrapped). Non-rectangular positions will be read into the smallest
    containing square board size at the top left position. If a a line
    contains the string "b|black|w|white to play|move" (case-insensitive), it
    will be used to set the current player in the position. */
public class TextParser
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TextParser.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1973704456299084308L,/* translation unit id   */ 7366941077104247656L,/* timestamp             */ 1709177903024L,/* source file name      */ "TextParser.java",/* probe size            */ 138);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_663ca1e0be084368(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public TextParser()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_663ca1e0be084368(0);
    }

    /** Get board with parsed position.
        Only valid after calling parse. */
    public Board getBoard()
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(1);return m_board;
    }

    public void parse(Reader reader) throws ParseError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(2);m_reader = new BufferedReader(reader);
            m_charBlack = null;
            m_charWhite = null;
            String line;
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(3);while (true)
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(4);line = readLine();
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(33);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(35) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(34);throw new ParseError("could not find position");}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(36);if ((isBoardRow(line, true)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(38) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(37);break;}
            }
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(6);m_board = new Board(m_width);
            checkToPlay(line);
            parseBoardRow(line, m_board.getSize() - 1);
            int i = 2;
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(7);while (true)
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(8);line = readLine();
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(16);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(18) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(17);break;}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(19);checkToPlay(line);
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(20);if ((! isBoardRow(line, false)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(22) && false))
                {
                    // Allow one failure if long lines were wrapped
                    $qualityscroll_cover_jacov_probe_663ca1e0be084368(21);line = readLine();
                    $qualityscroll_cover_jacov_probe_663ca1e0be084368(23);if ((line != null) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(25) && false))
                        {$qualityscroll_cover_jacov_probe_663ca1e0be084368(24);checkToPlay(line);}
                }
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(26);if ((line == null || ! isBoardRow(line, false)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(28) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(27);break;}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(29);if ((m_board.getSize() - i < 0) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(31) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(30);increaseBoardSize();}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(32);parseBoardRow(line, m_board.getSize() - i);
                ++i;
            }
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(10);if ((i != m_board.getSize() + 1) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(12) && false))
                // Assume that non-square positions are anchored at lower-left
                // corner
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(11);shiftBoardDown(m_board.getSize() + 1 - i);}
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(13);m_reader.close();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(15);
            }
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(14);m_reader = null;
        }
    }

    private int m_width;

    private Character m_charBlack;

    private Character m_charWhite;

    private Board m_board;

    private BufferedReader m_reader;

    private void checkToPlay(String line)
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(39);line = line.toLowerCase();
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(40);if ((line.contains("black to play") || line.contains("b to play")
            || line.contains("black to move") || line.contains("b to move")) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(42) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(41);m_board.setToMove(BLACK);}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(43);if ((line.contains("white to play") || line.contains("w to play")
            || line.contains("white to move") || line.contains("w to move")) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(45) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(44);m_board.setToMove(WHITE);}
    }

    /** Ignore characters at beginning of line.
        Ignores characters that are sometimes left of the actual position.
        The included characters are digits, pipe symbols (edge) and dollar
        signs. */
    private int ignoreBeginning(String line)
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(46);int i;
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(47);for (i = 0; (i < line.length()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(49) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(48);char c = line.charAt(i);
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(51);if ((! Character.isSpaceChar(c) && ! Character.isDigit(c)
                && c != '$' && c != '|' && c != '>') ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(53) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(52);break;}
        }
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(50);return i;
    }

    /** Increase boardsize by one.
        Keep existing position (shifted upward by one line) */
    private void increaseBoardSize()
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(54);int newSize = m_board.getSize() + 1;
        Board newBoard = new Board(newSize);
        PointList black = new PointList();
        PointList white = new PointList();
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(55);for (GoPoint p : m_board)
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(57);GoColor c = m_board.getColor(p);
            p = p.up(newSize);
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(58);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(60) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(59);black.add(p);}
            else {$qualityscroll_cover_jacov_probe_663ca1e0be084368(61);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(63) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(62);white.add(p);}}
        }
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(56);newBoard.setup(black, white, m_board.getToMove());
        m_board = newBoard;
    }

    private boolean isBlack(char c)
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(64);if ((m_charBlack != null) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(66) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(65);return (c == m_charBlack.charValue());}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(67);if ((c == 'X' || c == '@' || c == '#' || c == 'x') ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(69) && false))
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(68);m_charBlack = c;
            return true;
        }
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(70);return false;
    }

    private static boolean isEmpty(char c)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(71);return (c == '.' || c == ',' || c == '+');
    }

    private boolean isWhite(char c)
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(72);if ((m_charWhite != null) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(74) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(73);return (c == m_charWhite.charValue());}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(75);if ((c == 'o' || c == 'O') ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(77) && false))
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(76);m_charWhite = c;
            return true;
        }
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(78);return false;
    }

    private boolean isBoardRow(String line, boolean initSize)
        throws ParseError
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(79);int size = 0;
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(80);for (int i = ignoreBeginning(line); (i < line.length()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(82) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(81);char c = line.charAt(i);
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(90);if ((Character.isSpaceChar(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(92) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(91);continue;}
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(93);if ((isBlack(c) || isWhite(c) || isEmpty(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(95) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(94);++size;}
            else
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(96);break;}
        }
        // Don't try to parse boards smaller than 3x3
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(83);if ((size < 3 || size > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(85) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(84);return false;}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(86);if ((initSize) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(88) && false))
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(87);m_width = size;}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(89);return true;
    }

    private void parseBoardRow(String line, int y) throws ParseError
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(97);int x = 0;
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(98);for (int i = ignoreBeginning(line); (i < line.length()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(100) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(99);char c = line.charAt(i);
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(101);if ((Character.isSpaceChar(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(103) && false))
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(102);continue;}
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(104);if ((isBlack(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(106) && false))
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(105);if ((x >= m_board.getSize()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(108) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(107);increaseBoardSize();}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(109);PointList black =
                    new PointList(m_board.getSetup(BLACK));
                PointList white =
                    new PointList(m_board.getSetup(WHITE));
                black.add(GoPoint.get(x, y));
                m_board.setup(black, white, m_board.getToMove());
                ++x;
            }
            else {$qualityscroll_cover_jacov_probe_663ca1e0be084368(110);if ((isWhite(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(112) && false))
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(111);if ((x >= m_board.getSize()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(114) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(113);increaseBoardSize();}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(115);PointList black =
                    new PointList(m_board.getSetup(BLACK));
                PointList white =
                    new PointList(m_board.getSetup(WHITE));
                white.add(GoPoint.get(x, y));
                m_board.setup(black, white, m_board.getToMove());
                ++x;
            }
            else {$qualityscroll_cover_jacov_probe_663ca1e0be084368(116);if ((isEmpty(c)) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(118) && false))
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(117);if ((x >= m_board.getSize()) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(120) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(119);increaseBoardSize();}
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(121);++x;
            }
            else
                {$qualityscroll_cover_jacov_probe_663ca1e0be084368(122);break;}}}
        }
    }

    private String readLine() throws ParseError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(123);return m_reader.readLine();
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_663ca1e0be084368(124);return null;
        }
    }

    private void shiftBoardDown(int deltaY)
    {
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(125);int size = m_board.getSize();
        Board newBoard = new Board(size);
        PointList black = new PointList();
        PointList white = new PointList();
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(126);for (int y = 0; (y < size - deltaY) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(128) && false); ++y)
            {$qualityscroll_cover_jacov_probe_663ca1e0be084368(127);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(131) && false); ++x)
            {
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(130);GoColor c = m_board.getColor(GoPoint.get(x, y + deltaY));
                GoPoint p = GoPoint.get(x, y);
                $qualityscroll_cover_jacov_probe_663ca1e0be084368(132);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(134) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(133);black.add(p);}
                else {$qualityscroll_cover_jacov_probe_663ca1e0be084368(135);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_663ca1e0be084368(137) && false))
                    {$qualityscroll_cover_jacov_probe_663ca1e0be084368(136);white.add(p);}}
            }}
        $qualityscroll_cover_jacov_probe_663ca1e0be084368(129);newBoard.setup(black, white, m_board.getToMove());
        m_board = newBoard;
    }
}
