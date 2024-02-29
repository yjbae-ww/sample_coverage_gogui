/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// NodeUtil.java

package net.sf.gogui.game;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.Random;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.StringUtil;

/** Utility functions operating on a tree of nodes. */
public final class NodeUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = NodeUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4786053632903216122L,/* translation unit id   */ -6292208396923930260L,/* timestamp             */ 1709177900065L,/* source file name      */ "NodeUtil.java",/* probe size            */ 459);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Get node reached by going a number of nodes backward.
        @param node The start node.
        @param n The number of moves to go backward.
        @return The node reached by going n moves backward or the root node
        of the tree, if there are less than n nodes in the sequence before
        the start node. */
    public static ConstNode backward(ConstNode node, int n)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(0);assert n >= 0;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(1);for (int i = 0; (i < n && node.getFatherConst() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(3) && false); ++i)
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(2);node = node.getFatherConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(4);return node;
    }

    /** Remove SGF properties for information already contained in game info.
        This can be used for example, if a SGF reader cannot handle an unknown
        format of the TM property, puts it into the SGF properties of the node
        to preserve the information for future saving, but later a
        well-defined time settings was set in the game information of the node.
        Handles the following properties: TM (because FF3 allowed an arbitrary
        text in TM), OT (FF4 allows arbitrary text)
        @return The cleaned properties, empty properties, if
        node.getSgfProperties() was null */
    public static SgfProperties cleanSgfProps(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(5);SgfProperties props = new SgfProperties(node.getSgfPropertiesConst());
        ConstGameInfo info = node.getGameInfoConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(6);if ((info != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(8) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(7);if ((info.getTimeSettings() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(10) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(9);props.remove("OT");
                props.remove("TM");
                props.remove("OM"); // FF3
                props.remove("OP"); // FF3
            }
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(11);return props;
    }

    /** Check if the comment of the current node contains a pattern.
        @param node The node to check.
        @param pattern The pattern.
        @return <tt>true</tt>, if the current node has a comment and a match
        for the pattern is found in the comment. */
    public static boolean commentContains(ConstNode node, Pattern pattern)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(12);String comment = node.getComment();
        return (comment != null && pattern.matcher(comment).find());
    }

    /** Find first node with a certain move number in main variation
        of a given node.
        @param node The given node.
        @param moveNumber The move number of the wanted node.
        @return The node with the given move number or <code>null</code> if
        no such node exists. */
    public static ConstNode findByMoveNumber(ConstNode node, int moveNumber)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(13);int maxMoveNumber = getMoveNumber(node) + getMovesLeft(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(14);if ((moveNumber < 0 || moveNumber >  maxMoveNumber) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(16) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(15);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(17);if ((moveNumber <= getMoveNumber(node)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(19) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(18);while ((node.getFatherConst() != null
                   && (getMoveNumber(node) > moveNumber
                       || node.getMove() == null)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(21) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(20);node = node.getFatherConst();}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(23);while ((node.getChildConst() != null
                   && getMoveNumber(node) < moveNumber) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(25) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(24);node = node.getChildConst();}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(22);return node;
    }

    /** Get first node of a given variation.
        Searches the node that can be reached from the root node by taking the
        children defined by the integers in the variation string for nodes
        with more than one child.
        @param root The root node of the tree.
        @param variation The variation string (e.g. "1.1.3.1.5").
        @return The first node of the given variation, or the root node,
        if the variation string is empty, or <code>null</code>, if the
        variation string is invalid or does not specify a node in the
        given tree. */
    public static ConstNode findByVariation(ConstNode root, String variation)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(26);if ((variation.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(28) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(27);return root;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(29);String[] tokens = StringUtil.split(variation, '.');
        int[] n = new int[tokens.length];
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(30);for (int i = 0; (i < tokens.length) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(32) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(31);try
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(47);n[i] = Integer.parseInt(tokens[i]) - 1;
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(48);if ((n[i] < 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(50) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(49);return null;}
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(51);return null;
            }
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(33);ConstNode node = root;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(34);for (int i = 0; (i < n.length) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(36) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(35);while ((node.getNumberChildren() <= 1) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(39) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(38);node = node.getChildConst();
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(44);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(46) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(45);return null;}
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(40);if ((n[i] >= node.getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(42) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(41);return null;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(43);node = node.getChildConst(n[i]);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(37);return node;
    }

    /** Find next node with a comment containing a pattern in the iteration
        through complete tree.
        @param node The current node in the iteration.
        @param pattern The pattern.
        @return The next node in the iteration through the complete tree
        after the current node that contains a match of the pattern. */
    public static ConstNode findInComments(ConstNode node, Pattern pattern)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(52);node = nextNode(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(53);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(55) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(54);if ((commentContains(node, pattern)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(58) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(57);return node;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(59);node = nextNode(node);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(56);return null;
    }

    /** Find next node with a comment in the iteration through complete tree.
        @param node The current node in the iteration.
        @return The next node in the iteration through the complete tree
        after the current node that has a comment. */
    public static ConstNode findNextComment(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(60);node = nextNode(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(61);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(63) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(62);if ((node.hasComment()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(66) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(65);return node;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(67);node = nextNode(node);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(64);return null;
    }

    /** Get node reached by going a number of nodes forward.
        @param node The start node.
        @param n The number of moves to go forward.
        @return The node reached by going n moves forward following the main
        variaton (always the first child) or the last node in this variation,
        if it has less than n nodes. */
    public static ConstNode forward(ConstNode node, int n)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(68);assert n >= 0;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(69);for (int i = 0; (i < n) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(71) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(70);ConstNode child = node.getChildConst();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(73);if ((child == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(75) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(74);break;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(76);node = child;
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(72);return node;
    }

    /** Find the last node that was still in the main variation. */
    public static ConstNode getBackToMainVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(77);if ((isInMainVariation(node)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(79) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(78);return node;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(80);while ((! isInMainVariation(node)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(82) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(81);node = node.getFatherConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(83);return node.getChildConst(0);
    }

    /** Get all children moves.
        @return Point list containing the move points, not including passes
        and independent of color. */
    public static PointList getChildrenMoves(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(84);PointList moves = new PointList();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(85);for (int i = 0; (i < node.getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(87) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(86);Move childMove = node.getChildConst(i).getMove();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(89);if ((childMove != null && childMove.getPoint() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(91) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(90);moves.add(childMove.getPoint());}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(88);return moves;
    }

    /** Get child node containing a certain move.
        @return null if no such child exists. */
    public static ConstNode getChildWithMove(ConstNode node, Move move)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(92);for (int i = 0; (i < node.getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(94) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(93);ConstNode child = node.getChildConst(i);
            Move childMove = child.getMove();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(96);if ((childMove != null && childMove.equals(move)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(98) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(97);return child;}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(95);return null;
    }

    /** Get comment, but no more than a maximum number of characters.
        @return Start of comment, with ellipses appended if trunceted;
        null, if node has no comment. */
    public static String getCommentStart(ConstNode node,
                                         boolean firstLineOnly,
                                         int maxChar)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(99);String comment = node.getComment();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(100);if ((comment == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(102) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(101);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(103);boolean trimmed = false;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(104);if ((firstLineOnly) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(106) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(105);int pos = comment.indexOf("\n");
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(107);if ((pos >= 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(109) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(108);comment = comment.substring(0, pos);
                trimmed = true;
            }
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(110);if ((comment.length() > maxChar) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(112) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(111);comment = comment.substring(0, maxChar);
            trimmed = true;
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(113);if ((trimmed) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(115) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(114);if ((maxChar > 30) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(117) && false))
            {
                // Try to find a cut-off at a space
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(116);int pos = comment.lastIndexOf(' ');
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(118);if ((pos > 20) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(120) && false))
                {
                    $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(119);if ((comment.charAt(pos) == '.') ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(122) && false))
                        {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(121);--pos;}
                    $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(123);comment = comment.substring(0, pos);
                }
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(124);comment = comment + "...";
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(125);return comment;
    }

    /** Get depth of a node.
        @param node The node.
        @return The number of nodes in the sequence from the root node
        to the given node, excluding the given node (which means that the
        root node has depth 0). */
    public static int getDepth(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(126);int depth = 0;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(127);while ((node.getFatherConst() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(129) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(128);node = node.getFatherConst();
            ++depth;
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(130);return depth;
    }

    /** Get last node in main variation. */
    public static ConstNode getLast(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(131);while ((node.hasChildren()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(133) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(132);node = node.getChildConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(134);return node;
    }

    /** Get the move number of a node.
        @param node The node.
        @return The total number of moves in the sequence of nodes from
        the root node to the given node, including the given node. */
    public static int getMoveNumber(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(135);int moveNumber = 0;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(136);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(138) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(137);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(141) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(140);++moveNumber;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(142);node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(139);return moveNumber;
    }

    /** Moves left in main variation. */
    public static int getMovesLeft(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(143);int movesLeft = 0;
        node = node.getChildConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(144);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(146) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(145);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(149) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(148);++movesLeft;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(150);node = node.getChildConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(147);return movesLeft;
    }

    /** Return next variation of this node. */
    public static ConstNode getNextVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(151);ConstNode father = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(152);if ((father == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(154) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(153);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(155);return father.variationAfter(node);
    }

    /** Return next variation before this node. */
    public static ConstNode getNextEarlierVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(156);ConstNode child = node;
        node = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(157);while ((node != null && node.variationAfter(child) == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(159) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(158);child = node;
            node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(160);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(162) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(161);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(163);return node.variationAfter(child);
    }

    /** Nodes left in main variation. */
    public static int getNodesLeft(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(164);int nodesLeft = 0;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(165);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(167) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(166);++nodesLeft;
            node = node.getChildConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(168);return nodesLeft;
    }

    /** Get nodes in path from a given node to the root node.
        @param node The node
        @param result The resulting path. Passed as an argument to allow
        reusing an array list. It will be cleared before it is used. */
    public static void getPathToRoot(ConstNode node,
                                     ArrayList<ConstNode> result)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(169);result.clear();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(170);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(172) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(171);result.add(node);
            node = node.getFatherConst();
        }
    }

    /** Return previous variation of this node. */
    public static ConstNode getPreviousVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(173);ConstNode father = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(174);if ((father == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(176) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(175);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(177);return father.variationBefore(node);
    }

    /** Return previous variation before this node. */
    public static ConstNode getPreviousEarlierVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(178);ConstNode child = node;
        node = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(179);while ((node != null && node.variationBefore(child) == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(181) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(180);child = node;
            node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(182);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(184) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(183);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(185);node = node.variationBefore(child);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(186);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(188) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(187);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(189);while ((hasSubtree(node)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(191) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(190);node = node.getChildConst(node.getNumberChildren() - 1);}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(192);return node;
    }

    /** Get the root node.
        @param node The node.
        @return The root node of the tree that the given node belongs to. */
    public static ConstNode getRoot(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(193);while ((node.getFatherConst() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(195) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(194);node = node.getFatherConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(196);return node;
    }

    /** Get a text representation of the variation to a certain node.
        The string contains the number of the child for each node with more
        than one child in the path from the root node to this node.
        The childs are counted starting with 1 and the numbers are separated
        by colons. */
    public static String getVariationString(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(197);ArrayList<String> list = new ArrayList<String>();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(198);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(200) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(199);ConstNode father = node.getFatherConst();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(209);if ((father != null && father.getNumberChildren() > 1) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(211) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(210);int index = father.getChildIndex(node) + 1;
                list.add(0, Integer.toString(index));
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(212);node = father;
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(201);StringBuilder result = new StringBuilder(list.size() * 3);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(202);for (int i = 0; (i < list.size()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(204) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(203);result.append(list.get(i));
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(206);if ((i < list.size() - 1) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(208) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(207);result.append('.');}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(205);return result.toString();
    }

    /** Check if a node contains a move and has sibling nodes containing other
        moves. */
    public static boolean hasSiblingMoves(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(213);ConstNode father = node.getFatherConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(214);if ((father == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(216) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(215);return false;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(217);Move move = node.getMove();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(218);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(220) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(219);return false;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(221);for (int i = 0; (i < father.getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(223) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(222);Move childMove = father.getChildConst(i).getMove();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(225);if ((childMove != null && childMove != move) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(227) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(226);return true;}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(224);return false;
    }

    /** Subtree of node contains at least one node with 2 or more children. */
    public static boolean hasSubtree(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(228);while ((node != null && node.getNumberChildren() < 2) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(230) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(229);node = node.getChildConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(231);return (node != null);
    }

    /** Check if game is in cleanup stage.
        Cleanup stage is after two consecutive pass moves have been played. */
    public static boolean isInCleanup(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(232);boolean lastPass = false;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(233);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(235) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(234);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(237);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(239) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(238);if ((move.getPoint() == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(241) && false))
                {
                    $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(240);if ((lastPass) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(243) && false))
                        {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(242);return true;}
                    $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(244);lastPass = true;
                }
                else
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(246);lastPass = false;}
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(245);node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(236);return false;
    }

    /** Check if a node is in the main variation of the tree.
        @param node The node.
        @return <tt>true</tt>, if the given node is in the main variation,
        which is the sequence of nodes starting from the root of the tree
        and always following the first child. */
    public static boolean isInMainVariation(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(247);while ((node.getFatherConst() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(249) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(248);if ((node.getFatherConst().getChildConst(0) != node) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(252) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(251);return false;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(253);node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(250);return true;
    }

    /** Check if node is root node and has no children.
        @param node The node to check.
        @return <tt>true</tt>, if the node has no father node and no
        children. */
    public static boolean isRootWithoutChildren(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(254);return (! node.hasFather() && ! node.hasChildren());
    }

    /** Check that the time left for a color at a node is known.
        Returns true, if the last node (including the given one) containing a
        move of the given color also contains information about the time left
        after the move for the color. If a previous node with a game info
        containing time settings exists and no move of the given color was
        played since then, the function also returns true. */
    public static boolean isTimeLeftKnown(ConstNode node, GoColor color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(255);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(257) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(256);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(259);if ((move != null && move.getColor() == color) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(261) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(260);return ! Double.isNaN(node.getTimeLeft(color));}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(262);ConstGameInfo info = node.getGameInfoConst();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(263);if ((info != null && info.getTimeSettings() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(265) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(264);return true;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(266);node = node.getFatherConst();
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(258);return false;
    }

    /** Make the variation of the current node to be the main variation
        of the tree.
        Changes the children order of all nodes in the sequence from the root
        node to the current node (exclusive the current node), such that all
        nodes in the sequence (inclusive the current node) are the first
        child of their parents.
        @param node The current node. */
    public static void makeMainVariation(Node node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(267);while ((node.getFatherConst() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(269) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(268);node.getFather().makeFirstChild(node);
            node = node.getFather();
        }
    }

    /** Create a game tree with the current board position as setup stones. */
    public static GameTree makeTreeFromPosition(ConstGameInfo info,
                                                ConstBoard board)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(270);if ((info == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(272) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(271);info = new GameInfo();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(273);GameTree tree = new GameTree(board.getSize(), info.getKomi(), null,
                                     info.get(StringInfo.RULES),
                                     info.getTimeSettings());
        Node root = tree.getRoot();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(274);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(276);GoColor c = board.getColor(p);
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(277);if ((c.isBlackWhite()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(279) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(278);root.addStone(c, p);}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(275);root.setPlayer(board.getToMove());
        return tree;
    }

    /** Get next node for iteration through complete tree. */
    public static ConstNode nextNode(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(280);ConstNode child = node.getChildConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(281);if ((child != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(283) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(282);return child;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(284);return getNextEarlierVariation(node);
    }

    /** Get next node for iteration through subtree. */
    public static ConstNode nextNode(ConstNode node, int depth)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(285);node = nextNode(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(286);if ((node == null || NodeUtil.getDepth(node) <= depth) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(288) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(287);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(289);return node;
    }

    /** Return a string containing information about a node.
        The string contains a listing of the data stored in the node
        (like moves or setup stones) and properties of the node in the
        tree (like depth or variation). */
    public static String nodeInfo(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(290);StringBuilder buffer = new StringBuilder(128);
        buffer.append("NodeProperties:\n");
        appendInfo(buffer, "Depth", getDepth(node));
        appendInfo(buffer, "Children", node.getNumberChildren());
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(291);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(293) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(292);appendInfo(buffer, "Move", node.getMove().toString());
            appendInfo(buffer, "MoveNumber", getMoveNumber(node));
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(294);appendInfo(buffer, "Variation", getVariationString(node));
        ConstPointList black = node.getSetup(BLACK);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(295);if ((black.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(297) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(296);appendInfo(buffer, "AddBlack", black);}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(298);ConstPointList white = node.getSetup(WHITE);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(299);if ((white.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(301) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(300);appendInfo(buffer, "AddWhite", white);}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(302);ConstPointList empty = node.getSetup(EMPTY);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(303);if ((empty.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(305) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(304);appendInfo(buffer, "AddEmpty", empty);}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(306);if ((node.getPlayer() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(308) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(307);appendInfo(buffer, "Player", node.getPlayer().toString());}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(309);if ((! Double.isNaN(node.getTimeLeft(BLACK))) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(311) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(310);appendInfo(buffer, "TimeLeftBlack", node.getTimeLeft(BLACK));}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(312);if ((node.getMovesLeft(BLACK) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(314) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(313);appendInfo(buffer, "MovesLeftBlack", node.getMovesLeft(BLACK));}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(315);if ((! Double.isNaN(node.getTimeLeft(WHITE))) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(317) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(316);appendInfo(buffer, "TimeLeftWhite", node.getTimeLeft(WHITE));}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(318);if ((node.getMovesLeft(WHITE) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(320) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(319);appendInfo(buffer, "MovesLeftWhite", node.getMovesLeft(WHITE));}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(321);appendInfoComment(buffer, node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(322);for (MarkType type : EnumSet.allOf(MarkType.class))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(374);ConstPointList marked = node.getMarkedConst(type);
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(375);if ((marked != null && marked.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(377) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(376);appendInfo(buffer, "Marked " + type, marked);}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(323);Map<GoPoint,String> labels = node.getLabelsUnmodifiable();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(324);if ((labels != null && ! labels.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(326) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(325);StringBuilder labelsBuffer = new StringBuilder();
            boolean isFirst = true;
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(327);for (Map.Entry<GoPoint,String> entry : labels.entrySet())
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(370);if ((! isFirst) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(372) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(371);labelsBuffer.append(' ');}
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(373);isFirst = false;
                GoPoint point = entry.getKey();
                String value = entry.getValue();
                labelsBuffer.append(point);
                labelsBuffer.append(':');
                labelsBuffer.append(value);
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(328);appendInfo(buffer, "Labels", labelsBuffer.toString());
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(329);if ((! Float.isNaN(node.getValue())) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(331) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(330);appendInfo(buffer, "Value", Float.toString(node.getValue()));}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(332);ConstGameInfo info = node.getGameInfoConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(333);if ((info != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(335) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(334);buffer.append("GameInfo:\n");
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(336);for (StringInfo type : EnumSet.allOf(StringInfo.class))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(366);String s = info.get(type);
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(367);if ((s != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(369) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(368);appendInfo(buffer, type.toString(), s);}
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(337);for (StringInfoColor type : EnumSet.allOf(StringInfoColor.class))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(358);String s = info.get(type, BLACK);
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(359);if ((s != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(361) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(360);appendInfo(buffer, type.toString() + "[B]", s);}
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(362);s = info.get(type, WHITE);
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(363);if ((s != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(365) && false))
                    {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(364);appendInfo(buffer, type.toString() + "[W]", s);}
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(338);if ((info.getHandicap() != 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(340) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(339);appendInfo(buffer, "HANDICAP", info.getHandicap());}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(341);if ((info.getKomi() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(343) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(342);appendInfo(buffer, "KOMI", info.getKomi().toString());}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(344);if ((info.getTimeSettings() != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(346) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(345);appendInfo(buffer, "TIMESETTINGS",
                           info.getTimeSettings().toString());}
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(347);ConstSgfProperties sgfProperties = node.getSgfPropertiesConst();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(348);if ((sgfProperties != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(350) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(349);buffer.append("SgfProperties:\n");
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(351);for (String key : sgfProperties.getKeys())
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(353);StringBuilder values = new StringBuilder();
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(354);for (int i = 0; (i < sgfProperties.getNumberValues(key)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(356) && false); ++i)
                {
                    $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(355);values.append('[');
                    values.append(sgfProperties.getValue(key, i));
                    values.append(']');
                }
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(357);appendInfo(buffer, key, values.toString());
            }
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(352);return buffer.toString();
    }

    /** Restore the clock to the state corresponding to a node.
        Updates the clock from the time left information stored in the nodes
        of the sequence from the root node to the current node.
        @param node The current node.
        @param clock The clock to update. */
    public static void restoreClock(ConstNode node, Clock clock)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(378);clock.reset();
        ArrayList<ConstNode> path = new ArrayList<ConstNode>();
        getPathToRoot(node, path);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(379);for (int i = path.size() - 1; (i >= 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(381) && false); --i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(380);ConstNode pathNode = path.get(i);
            restoreTimeLeft(pathNode, clock, BLACK);
            restoreTimeLeft(pathNode, clock, WHITE);
        }
    }

    /** Select a random node in the main variation within a certain depth
        interval.
        @param root The root node
        @param minDepth The minimum depth of the interval (inclusive)
        @param maxDepth The maximum depth of the interval (inclusive)
        @return A random node in the given depth interval, null, if there is
        none. */
    public static ConstNode selectRandom(ConstNode root, int minDepth,
                                         int maxDepth)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(382);ConstNode last = getLast(root);
        int depth = getDepth(last);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(383);if ((depth < minDepth) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(385) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(384);return null;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(386);if ((depth < maxDepth) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(388) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(387);maxDepth = depth;}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(389);int idx = minDepth + s_random.nextInt(maxDepth - minDepth + 1);
        ConstNode node = last;
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(390);for (int i = depth; (i != idx) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(392) && false); --i)
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(391);node = node.getFatherConst();}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(393);return node;
    }

    /** Check if the number of nodes in the subtree of a node is greater
        than a given limit. */
    public static boolean subtreeGreaterThan(ConstNode node, int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(394);int n = 0;
        int depth = NodeUtil.getDepth(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(395);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(397) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(396);++n;
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(399);if ((n > size) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(401) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(400);return true;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(402);node = nextNode(node, depth);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(398);return false;
    }

    /** Count number of nodes in subtree.
        @param node The root node of the subtree.
        @return The number of nodes in the subtree (including the root
        node). */
    public static int subtreeSize(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(403);int n = 0;
        int depth = NodeUtil.getDepth(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(404);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(406) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(405);++n;
            node = nextNode(node, depth);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(407);return n;
    }

    /** Return a string containing information and statistics of the subtree
        of a node. */
    public static String treeInfo(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(408);int numberNodes = 0;
        int numberTerminal = 0;
        int moreThanOneChild = 0;
        int maxDepth = 0;
        int maxChildren = 0;
        double averageDepth = 0;
        double averageChildren = 0;
        double averageChildrenInner = 0;
        int rootDepth = getDepth(node);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(409);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(411) && false))
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(410);++numberNodes;
            int numberChildren = node.getNumberChildren();
            int depth = getDepth(node) - rootDepth;
            assert depth >= 0;
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(413);if ((depth > maxDepth) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(415) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(414);maxDepth = depth;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(416);if ((numberChildren > maxChildren) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(418) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(417);maxChildren = numberChildren;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(419);if ((numberChildren == 0) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(421) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(420);++numberTerminal;}
            else
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(426);averageChildrenInner += numberChildren;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(422);if ((numberChildren > 1) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(424) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(423);++moreThanOneChild;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(425);averageDepth += depth;
            averageChildren += numberChildren;
            node = nextNode(node, rootDepth);
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(412);int numberInner = numberNodes - numberTerminal;
        averageDepth /= numberNodes;
        averageChildren /= numberNodes;
        averageChildrenInner /= Math.max(numberInner, 1);
        NumberFormat format = StringUtil.getNumberFormat(3);
        format.setMinimumFractionDigits(3);
        StringBuilder buffer = new StringBuilder();
        appendInfo(buffer, "Nodes", numberNodes);
        appendInfo(buffer, "Terminal", numberTerminal);
        appendInfo(buffer, "Inner", numberInner);
        appendInfo(buffer, "AvgDepth", format.format(averageDepth));
        appendInfo(buffer, "MaxDepth", maxDepth);
        appendInfo(buffer, "AvgChildren", format.format(averageChildren));
        appendInfo(buffer, "AvgChildrenInner",
                   format.format(averageChildrenInner));
        appendInfo(buffer, "MaxChildren", maxChildren);
        appendInfo(buffer, "MoreThanOneChild", moreThanOneChild);
        return buffer.toString();
    }

    /** Remove all children. */
    public static void truncateChildren(Node node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(427);while (true)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(428);Node child = node.getChild();
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(430);if ((child == null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(432) && false))
                {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(431);break;}
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(433);node.removeChild(child);
        }
    }

    private static Random s_random = new Random();

    /** Make constructor unavailable; class is for namespace only. */
    private NodeUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(434);
    }

    private static void appendInfo(StringBuilder buffer, String label,
                                   int value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(435);appendInfo(buffer, label, Integer.toString(value));
    }

    private static void appendInfo(StringBuilder buffer, String label,
                                   double value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(436);appendInfo(buffer, label, Double.toString(value));
    }

    private static void appendInfo(StringBuilder buffer, String label,
                                   ConstPointList points)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(437);appendInfoLabel(buffer, label);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(438);for (int i = 0; (i < points.size()) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(440) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(439);if ((i % 10 == 9 && i < points.size() - 1) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(443) && false))
            {
                $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(442);buffer.append('\n');
                appendInfoLabel(buffer, "");
            }
            $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(444);buffer.append(points.get(i));
            buffer.append(' ');
        }
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(441);buffer.append('\n');
    }

    private static void appendInfo(StringBuilder buffer, String label,
                                   String value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(445);appendInfoLabel(buffer, label);
        buffer.append(value);
        buffer.append('\n');
    }

    private static void appendInfoComment(StringBuilder buffer, ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(446);String comment = getCommentStart(node, true, 30);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(447);if ((comment != null) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(449) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(448);appendInfo(buffer, "Comment", comment);}
    }

    private static void appendInfoLabel(StringBuilder buffer, String label)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(450);buffer.append(label);
        int numberEmpty = Math.max(0, 20 - label.length());
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(451);for (int i = 0; (i < numberEmpty) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(453) && false); ++i)
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(452);buffer.append(' ');}
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(454);buffer.append(' ');
    }

    private static void restoreTimeLeft(ConstNode node, Clock clock,
                                        GoColor color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(455);double timeLeft = node.getTimeLeft(color);
        int movesLeft = node.getMovesLeft(color);
        $qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(456);if ((! Double.isNaN(timeLeft)) ? true : (!$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(458) && false))
            {$qualityscroll_cover_jacov_probe_a8ad95ccf09e796c(457);clock.setTimeLeft(color, (long)(timeLeft * 1000), movesLeft);}
    }
}
