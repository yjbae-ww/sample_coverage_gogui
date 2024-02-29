/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// TexWriter.java

package net.sf.gogui.tex;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.util.StringUtil;

/** Write a game or board position in PSGO style to a stream. */
public class TexWriter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TexWriter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -9043429901615904979L,/* translation unit id   */ -4534136815168843789L,/* timestamp             */ 1709177902971L,/* source file name      */ "TexWriter.java",/* probe size            */ 101);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public TexWriter(String title, OutputStream out, ConstBoard board,
                     String[][] markLabel, boolean[][] mark,
                     boolean[][] markTriangle, boolean[][] markCircle,
                     boolean[][] markSquare, boolean[][] markSelect)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(0);m_out = new PrintStream(out);
        printBeginDocument();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(1);if ((! StringUtil.isEmpty(title)) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(3) && false))
            {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(2);m_out.println("\\section*{" + escape(title) + "}");}
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(4);printBeginPSGo(board.getSize());
        printPosition(board, markLabel, mark, markTriangle, markCircle,
                      markSquare, markSelect);
        printEndPSGo();
        m_out.println("\\\\");
        m_out.print(board.getToMove().getCapitalizedName());
        m_out.println(" to play");
        printEndDocument();
        m_out.close();
    }

    public TexWriter(String title, OutputStream out, ConstGameTree tree)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(5);m_out = new PrintStream(out);
        printBeginDocument();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(6);if ((! StringUtil.isEmpty(title)) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(8) && false))
            {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(7);m_out.println("\\section*{" + escape(title) + "}");}
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(9);printBeginPSGo(tree.getBoardSize());
        String comment = printTree(tree);
        printEndPSGo();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(10);if ((! comment.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(12) && false))
        {
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(11);m_out.println("\\\\");
            m_out.println(comment);
        }
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(13);printEndDocument();
        m_out.close();
    }

    private final PrintStream m_out;

    /** Escape LaTeX special characters in text. */
    private String escape(String text)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(14);text = text.replaceAll("\\#", "\\\\#");
        text = text.replaceAll("\\$", "\\\\\\$");
        text = text.replaceAll("%", "\\\\%");
        text = text.replaceAll("\\&", "\\\\&");
        text = text.replaceAll("~", "\\\\~{}");
        text = text.replaceAll("_", "\\\\_");
        text = text.replaceAll("\\^", "\\\\^{}");
        text = text.replaceAll("\\\\", "\\$\\\\backslash\\$");
        text = text.replaceAll("\\{", "\\\\{");
        text = text.replaceAll("\\}", "\\\\}");
        return text;
    }

    private String getStoneInTextString(int moveNumber, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(15);return ("\\stone[" + moveNumber + "]{"
                + (((color == BLACK) ? ($qualityscroll_cover_jacov_probe_c1138296e8d70ff3(16) || true) : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(17) && false)) ? "black" : "white") + "}");
    }

    private void printBeginDocument()
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(18);m_out.println("\\documentclass{article}");
        m_out.println("\\usepackage{psgo} % version 0.14 or newer");
        m_out.println("\\pagestyle{empty}");
        m_out.println("\\begin{document}");
        m_out.println();
    }

    private void printBeginPSGo(int size)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(19);m_out.println("\\begin{psgoboard}[" + size + "]");
    }

    private void printColor(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(20);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(22) && false))
            {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(21);m_out.print("{black}");}
        else
        {
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(23);assert color == WHITE;
            m_out.print("{white}");
        }
    }

    private void printCoordinates(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(24);assert point != null;
        String s = point.toString();
        m_out.print("{" + s.substring(0, 1).toLowerCase(Locale.ENGLISH) + "}{"
                    + s.substring(1) + "}");
    }

    private void printEndDocument()
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(25);m_out.println();
        m_out.println("\\end{document}");
    }

    private void printEndPSGo()
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(26);m_out.println("\\end{psgoboard}");
    }

    private String printTree(ConstGameTree tree)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(27);StringBuilder comment = new StringBuilder();
        int size = tree.getBoardSize();
        ConstNode firstMoveAtPoint[][] = new ConstNode[size][size];
        ArrayList<ConstNode> needsComment = new ArrayList<ConstNode>();
        boolean blackToMove = true;
        m_out.println("\\setcounter{gomove}{0}");
        ConstNode node = tree.getRootConst();
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(28);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(30) && false))
        {
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(29);for (GoColor c : BLACK_WHITE)
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(64);for (GoPoint stone : node.getSetup(c))
                    {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(65);printStone(c, stone, null);}}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(43);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(44);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(46) && false))
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(45);node = node.getChildConst();
                continue;
            }
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(47);GoPoint point = move.getPoint();
            GoColor color = move.getColor();
            int moveNumber = NodeUtil.getMoveNumber(node);
            boolean isColorUnexpected =
                (blackToMove && color != BLACK)
                || (! blackToMove && color != WHITE);
            boolean isPass = (point == null);
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(48);if ((isPass || firstMoveAtPoint[point.getX()][point.getY()] != null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(50) && false))
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(49);needsComment.add(node);
                m_out.print("\\pass");
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(51);if ((! isPass) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(53) && false))
                {
                    $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(52);m_out.print(" % \\move");
                    printCoordinates(point);
                }
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(54);m_out.println(" % " + (((blackToMove) ? ($qualityscroll_cover_jacov_probe_c1138296e8d70ff3(55) || true) : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(56) && false)) ? "B " : "W ") + moveNumber);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(58);if ((isColorUnexpected) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(60) && false))
                {
                    $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(59);m_out.println("\\toggleblackmove");
                    blackToMove = ! blackToMove;
                }
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(61);m_out.print("\\move");
                printCoordinates(point);
                m_out.println(" % " + (((blackToMove) ? ($qualityscroll_cover_jacov_probe_c1138296e8d70ff3(62) || true) : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(63) && false)) ? "B " : "W ")
                              + moveNumber);
                firstMoveAtPoint[point.getX()][point.getY()] = node;
            }
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(57);blackToMove = ! blackToMove;
            node = node.getChildConst();
        }
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(31);for (int i = 0; (i < needsComment.size()) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(33) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(32);node = needsComment.get(i);
            int moveNumber = NodeUtil.getMoveNumber(node);
            Move move = node.getMove();
            GoPoint point = move.getPoint();
            GoColor color = move.getColor();
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(35);if ((comment.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(37) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(36);comment.append(" \\enspace\n");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(38);comment.append(getStoneInTextString(moveNumber, color));
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(39);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(41) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(40);comment.append("~pass");}
            else
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(42);int x = point.getX();
                int y = point.getY();
                comment.append("~at~");
                ConstNode first = firstMoveAtPoint[x][y];
                GoColor firstMoveColor = first.getMove().getColor();
                int firstMoveNumber = NodeUtil.getMoveNumber(first);
                comment.append(getStoneInTextString(firstMoveNumber,
                                                    firstMoveColor));
            }
        }
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(34);return comment.toString();
    }

    private void printPosition(ConstBoard board, String[][] markLabel,
                               boolean[][] mark, boolean[][] markTriangle,
                               boolean[][] markCircle, boolean[][] markSquare,
                               boolean[][] markSelect)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(66);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(67);GoColor color = board.getColor(p);
            int x = p.getX();
            int y = p.getY();
            StringBuilder buffer = new StringBuilder(128);
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(68);if ((mark != null && mark[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(70) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(69);buffer.append("\\markma");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(71);if ((markTriangle != null && markTriangle[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(73) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(72);buffer.append("\\marktr");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(74);if ((markCircle != null && markCircle[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(76) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(75);buffer.append("\\markcr");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(77);if ((markSquare != null && markSquare[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(79) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(78);buffer.append("\\marksq");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(80);if ((markLabel != null && ! StringUtil.isEmpty(markLabel[x][y])) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(82) && false))
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(81);buffer.append("\\marklb{");
                buffer.append(markLabel[x][y]);
                buffer.append('}');
            }
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(83);if ((markSelect != null && markSelect[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(85) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(84);buffer.append("\\marksl");}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(86);String markup = null;
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(87);if ((buffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(89) && false))
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(88);markup = buffer.toString();}
            $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(90);if ((color == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(92) && false))
            {
                $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(91);if ((markup != null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(94) && false))
                {
                    $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(93);m_out.print("\\markpos{" + markup + "}");
                    printCoordinates(p);
                    m_out.print("\n");
                }
            }
            else
                {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(95);printStone(color, p, markup);}
        }
    }

    private void printStone(GoColor color, GoPoint point, String markup)
    {
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(96);m_out.print("\\stone");
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(97);if ((markup != null) ? true : (!$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(99) && false))
            {$qualityscroll_cover_jacov_probe_c1138296e8d70ff3(98);m_out.print("[" + markup + "]");}
        $qualityscroll_cover_jacov_probe_c1138296e8d70ff3(100);printColor(color);
        printCoordinates(point);
        m_out.print("\n");
    }
}
