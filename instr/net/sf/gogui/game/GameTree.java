/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// GameTree.java

package net.sf.gogui.game;

import java.text.DecimalFormat;
import java.util.Calendar;
import net.sf.gogui.go.ConstPointList;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Komi;

/** Game tree.
    Note that the tree can have different GameInfo objects for different
    subtrees to allow the representation of trees loaded from SGF. Creating
    trees with multiple GameInfo objects is not not actively supported
    in GoGui, because they cannot be saved in (Jago's) XML format. */
public class GameTree
    implements ConstGameTree
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameTree.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1624052101533535632L,/* translation unit id   */ -2726992952390455560L,/* timestamp             */ 1709177899931L,/* source file name      */ "GameTree.java",/* probe size            */ 36);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameTree()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(0);m_boardSize = GoPoint.DEFAULT_SIZE;
        m_root = new Node();
        m_root.createGameInfo();
        setDate();
    }

    public GameTree(int boardSize, Komi komi, ConstPointList handicap,
                    String rules, TimeSettings timeSettings)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(1);m_boardSize = boardSize;
        m_root = new Node();
        GameInfo info = m_root.createGameInfo();
        setDate();
        info.setKomi(komi);
        info.set(StringInfo.RULES, rules);
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(2);if ((timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(4) && false))
            {$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(3);info.setTimeSettings(timeSettings);}
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(5);if ((handicap != null) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(7) && false))
        {
            $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(6);info.setHandicap(handicap.size());
            $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(8);if ((handicap.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(10) && false))
            {
                $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(9);m_root.addStones(BLACK, handicap);
                m_root.setPlayer(WHITE);
            }
        }
    }

    /** Probably only needed by SgfReader. */
    public GameTree(int boardSize, Node root)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(11);m_boardSize = boardSize;
        root.createGameInfo();
        m_root = root;
    }

    @Override
	public int getBoardSize()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(12);return m_boardSize;
    }

    /** Find the game information valid for this node.
        @return The game information from the nearest ancestor node,
        which has a game information (the root node is always guaranteed
        to have one). */
    public GameInfo getGameInfo(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(13);assert NodeUtil.getRoot(node) == getRoot();
        return getGameInfoNode(node).getGameInfo();
    }

    /** Find the node with game information valid for this node.
        @return The nearest ancestor node which has a game information
        (the root node is always guaranteed to have one). */
    public Node getGameInfoNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(14);assert NodeUtil.getRoot(node) == getRoot();
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(15);while ((node.getGameInfoConst() == null) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(17) && false))
            {$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(16);node = node.getFatherConst();}
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(18);return (Node)node;
    }

    /** @see #getGameInfo */
    @Override
	public ConstGameInfo getGameInfoConst(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(19);return getGameInfo(node);
    }

    /** Get a non-const reference to a const node.
        Requires: node is part of this game tree. */
    public Node getNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(20);assert NodeUtil.getRoot(node) == getRoot();
        return (Node)node;
    }

    public Node getRoot()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(21);return m_root;
    }

    @Override
	public ConstNode getRootConst()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(22);return m_root;
    }

    @Override
	public boolean hasVariations()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(23);ConstNode node = m_root;
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(24);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(26) && false))
        {
            $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(25);if ((node.getNumberChildren() > 1) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(29) && false))
                {$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(28);return true;}
            $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(30);node = node.getChildConst();
        }
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(27);return false;
    }

    public void keepOnlyMainVariation()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(31);Node node = m_root;
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(32);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(34) && false))
        {
            $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(33);node.removeVariations();
            node = node.getChild();
        }
    }

    private final int m_boardSize;

    private final Node m_root;

    private void setDate()
    {
        $qualityscroll_cover_jacov_probe_da27c65ba7c5eef8(35);Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DecimalFormat format = new DecimalFormat("00");
        GameInfo info = m_root.getGameInfo();
        info.set(StringInfo.DATE,
                 Integer.toString(year) + "-" + format.format(month) + "-"
                 + format.format(day));
    }
}
