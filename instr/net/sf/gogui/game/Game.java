/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// Game.java

package net.sf.gogui.game;

import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.util.ObjectUtil;

/** Manages a tree, board, current node and clock. */
public class Game
    implements ConstGame
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Game.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3106019671103806773L,/* translation unit id   */ -1631356547231541618L,/* timestamp             */ 1709177899842L,/* source file name      */ "Game.java",/* probe size            */ 92);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e95c41dd1441968e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Game(int boardSize)
    {
        this(boardSize, null, null, "", null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e95c41dd1441968e(0);
    }

    public Game(int boardSize, Komi komi, ConstPointList handicap,
                String rules, TimeSettings timeSettings)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(1);m_board = new Board(boardSize);
        m_clock = new Clock();
        init(boardSize, komi, handicap, rules, timeSettings);
    }

    public Game(GameTree tree)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(2);int boardSize = tree.getBoardSize();
        m_board = new Board(boardSize);
        m_clock = new Clock();
        init(tree);
    }

    /** Add a mark property to current node. */
    public void addMarked(GoPoint point, MarkType type)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(3);m_current.addMarked(point, type);
        setModified();
    }

    /** Clear modified flag.
        Can be used for instance after game was saved.
        @see #isModified() */
    public void clearModified()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(4);m_modified = false;
    }

    /** Append new empty node and make it current node.
        Can be use for instance to prepare for setup stones if current node
        contains a move. */
    public void createNewChild()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(5);Node node = new Node();
        m_current.append(node);
        m_current = node;
        setModified();
    }

    @Override
	public ConstBoard getBoard()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(6);return m_board;
    }

    @Override
	public ConstClock getClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(7);return m_clock;
    }

    @Override
	public ConstNode getCurrentNode()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(8);return m_current;
    }

    @Override
	public ConstGameInfo getGameInfo(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(9);return m_tree.getGameInfoConst(node);
    }

    @Override
	public ConstNode getGameInfoNode()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(10);return m_tree.getGameInfoNode(m_current);
    }

    public ConstNode getGameInfoNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(11);return m_tree.getGameInfoNode(node);
    }

    @Override
	public int getMoveNumber()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(12);return NodeUtil.getMoveNumber(getCurrentNode());
    }

    @Override
	public ConstNode getRoot()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(13);return m_tree.getRoot();
    }

    @Override
	public int getSize()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(14);return m_board.getSize();
    }

    @Override
	public GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(15);return m_board.getToMove();
    }

    @Override
	public ConstGameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(16);return m_tree;
    }

    public void gotoNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(17);assert node != null;
        assert NodeUtil.getRoot(node) == getRoot();
        m_current = (Node)node;
        updateBoard();
    }

    public void haltClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(18);m_clock.halt();
    }

    /** Return last node when startClock() was called.
        @return The last such node or null, if the clock was never running. */
    public ConstNode getClockNode()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(19);return m_clockNode;
    }

    public final void init(int boardSize, Komi komi, ConstPointList handicap,
                           String rules, TimeSettings timeSettings)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(20);init(new GameTree(boardSize, komi, handicap, rules, timeSettings));
    }

    public final void init(GameTree tree)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(21);m_tree = tree;
        m_current = m_tree.getRoot();
        updateBoard();
        updateClock();
        m_clock.reset();
        m_clock.halt();
        m_modified = false;
        m_clockNode = null;
    }

    /** Check if game was modified.
        @return true, if game was mofified since constructor or last call to
        one of the init() functions or to clearModified(). */
    @Override
	public boolean isModified()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(22);return m_modified;
    }

    public void keepOnlyMainVariation()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(23);m_tree.keepOnlyMainVariation();
        setModified();
    }

    public void keepOnlyPosition()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(24);ConstGameInfo info = getGameInfo(m_current);
        m_tree = NodeUtil.makeTreeFromPosition(info, m_board);
        m_board.init(m_board.getSize());
        m_current = m_tree.getRoot();
        updateBoard();
        setModified();
    }

    /** Make current node the main variation. */
    public void makeMainVariation()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(25);NodeUtil.makeMainVariation(m_current);
        setModified();
    }

    public void play(Move move)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(26);m_clock.stopMove();
        Node node = new Node(move);
        GoColor color = move.getColor();
        // Only save time left information, if it also was known before the move
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(27);if ((m_clock.isInitialized()
            && NodeUtil.isTimeLeftKnown(m_current, color)) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(29) && false))
        {
            $qualityscroll_cover_jacov_probe_e95c41dd1441968e(28);assert ! m_clock.isRunning();
            // Round time to seconds
            long timeLeft = m_clock.getTimeLeft(color) / 1000L;
            node.setTimeLeft(color, timeLeft);
            $qualityscroll_cover_jacov_probe_e95c41dd1441968e(30);if ((m_clock.isInByoyomi(color)) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(32) && false))
                {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(31);node.setMovesLeft(color, m_clock.getMovesLeft(color));}
        }
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(33);m_current.append(node);
        m_current = node;
        updateBoard();
        setModified();
        m_clock.startMove(getToMove());
    }

    /** Remove a mark property from current node. */
    public void removeMarked(GoPoint point, MarkType type)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(34);m_current.removeMarked(point, type);
        setModified();
    }

    public void resetClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(35);m_clock.reset();
    }

    public void restoreClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(36);if ((! m_clock.isInitialized()) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(38) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(37);return;}
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(39);NodeUtil.restoreClock(getCurrentNode(), m_clock);
    }

    public void resumeClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(40);m_clock.resume();
    }

    /** Set clock listener.
        If the clock has a listener, the clock should be stopped with
        haltClock() if it is no longer used, otherwise the timer thread can
        keep an application from terminating. */
    public void setClockListener(Clock.Listener listener)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(41);m_clock.setListener(listener);
    }

    /** Set comment in current node. */
    public void setComment(String comment)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(42);setComment(comment, m_current);
    }

    public void setComment(String comment, ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(43);assert NodeUtil.getRoot(node) == getRoot();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(44);if ((! ObjectUtil.equals(comment, node.getComment())) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(46) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(45);setModified();}
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(47);((Node)node).setComment(comment);
    }

    public void setGameInfo(ConstGameInfo info, ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(48);assert NodeUtil.getRoot(node) == getRoot();
        ((Node)node).createGameInfo();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(49);if ((! ((Node)node).getGameInfo().equals(info)) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(51) && false))
        {
            $qualityscroll_cover_jacov_probe_e95c41dd1441968e(50);((Node)node).getGameInfo().copyFrom(info);
            updateClock();
            setModified();
        }
    }

    public void setKomi(Komi komi)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(52);Node node = m_tree.getGameInfoNode(m_current);
        GameInfo info = node.getGameInfo();
        info.setKomi(komi);
        setGameInfo(info, node); // updates m_modified
    }

    /** Set label in current node. */
    public void setLabel(GoPoint point, String value)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(53);if ((! ObjectUtil.equals(value, m_current.getLabel(point))) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(55) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(54);setModified();}
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(56);m_current.setLabel(point, value);
    }

    public void setPlayer(GoColor c, String name)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(57);Node node = m_tree.getGameInfoNode(m_current);
        GameInfo info = node.getGameInfo();
        info.set(StringInfoColor.NAME, c, name);
        setGameInfo(info, node); // updates m_modified
    }

    public void setResult(String result)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(58);Node node = m_tree.getGameInfoNode(m_current);
        GameInfo info = node.getGameInfo();
        info.set(StringInfo.RESULT, result);
        setGameInfo(info, node); // updates m_modified
    }

    public void setToMove(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(59);assert color != null;
        assert ! color.equals(EMPTY);
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(60);if ((! ObjectUtil.equals(color, m_current.getPlayer())
            || color.equals(m_board.getToMove())) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(62) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(61);setModified();}
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(63);m_current.setPlayer(color);
        updateBoard();
    }

    /** Change the time settings.
        If the current node is the root node, the clock will also be reset. */
    public void setTimeSettings(TimeSettings timeSettings)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(64);Node node = m_tree.getGameInfoNode(m_current);
        GameInfo info = node.getGameInfo();
        info.setTimeSettings(timeSettings);
        setGameInfo(info, node); // updates m_modified
        m_clock.setTimeSettings(timeSettings);
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(65);if ((m_current == node) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(67) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(66);m_clock.reset();}
    }

    public void setTimeLeft(GoColor c, double seconds)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(68);setTimeLeft(getCurrentNode(), c, seconds);
    }

    public void setTimeLeft(ConstNode node, GoColor c, double seconds)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(69);((Node)node).setTimeLeft(c, seconds);
    }

    public void setMovesLeft(GoColor c, int moves)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(70);setMovesLeft(getCurrentNode(), c, moves);
    }

    public void setMovesLeft(ConstNode node, GoColor c, int moves)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(71);((Node)node).setMovesLeft(c, moves);
    }

    /** Set a stone on the board or remove a stone.
        @param p The location.
        @param c The color of the stone (EMPTY for removal). */
    public void setup(GoPoint p, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(72);assert p != null;
        m_current.removeSetup(p);
        Node father = m_current.getFather();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(73);if ((father != null) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(75) && false))
        {
            $qualityscroll_cover_jacov_probe_e95c41dd1441968e(74);m_boardUpdater.update(getTree(), father, m_board);
            GoColor oldColor = m_board.getColor(p);
            $qualityscroll_cover_jacov_probe_e95c41dd1441968e(76);if ((oldColor == c) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(78) && false))
            {
                $qualityscroll_cover_jacov_probe_e95c41dd1441968e(77);updateBoard();
                return;
            }
        }
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(79);if ((c != EMPTY || father != null) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(81) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(80);m_current.addStone(c, p);}
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(82);setModified();
        updateBoard();
    }

    public void startClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(83);m_clock.startMove(getToMove());
        m_clockNode = m_current;
    }

    /** Truncate current node and subtree.
        New current node is the father of the old current node. */
    public void truncate()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(84);Node father = m_current.getFather();
        assert father != null;
        Node oldCurrentNode = m_current;
        m_current = father;
        m_current.removeChild(oldCurrentNode);
        setModified();
    }

    /** Remove children of currentNode. */
    public void truncateChildren()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(85);NodeUtil.truncateChildren(m_current);
        setModified();
    }

    /** See #isModified() */
    private boolean m_modified;

    private final Board m_board;

    private final BoardUpdater m_boardUpdater = new BoardUpdater();

    private GameTree m_tree;

    private Node m_current;

    /** See getClockNode() */
    private ConstNode m_clockNode;

    private final Clock m_clock;

    private void setModified()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(86);m_modified = true;
    }

    private void updateBoard()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(87);m_boardUpdater.update(m_tree, m_current, m_board);
    }

    private void updateClock()
    {
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(88);ConstNode node = getGameInfoNode();
        ConstGameInfo info = node.getGameInfoConst();
        $qualityscroll_cover_jacov_probe_e95c41dd1441968e(89);if ((info != null) ? true : (!$qualityscroll_cover_jacov_probe_e95c41dd1441968e(91) && false))
            {$qualityscroll_cover_jacov_probe_e95c41dd1441968e(90);m_clock.setTimeSettings(info.getTimeSettings());}
    }
}
