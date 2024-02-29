/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Board.java

package net.sf.gogui.go;

import java.util.ArrayList;
import java.util.Iterator;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;

/** Go board. */
public final class Board
    implements ConstBoard
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Board.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1552409577552019427L,/* translation unit id   */ -8407665235296017948L,/* timestamp             */ 1709177900275L,/* source file name      */ "Board.java",/* probe size            */ 144);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public class BoardIterator
        implements Iterator<GoPoint>
    {
        @Override
		public boolean hasNext()
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(0);return m_iterator.hasNext();
        }

        @Override
		public GoPoint next()
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(1);return m_iterator.next();
        }

        @Override
		public void remove()
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(2);throw new UnsupportedOperationException();
        }

        private final Iterator<GoPoint> m_iterator =
            m_constants.getPoints().iterator();
    }

    /** Constructor.
        @param boardSize The board size (number of points per row / column)
        in the range from one to GoPoint.MAX_SIZE */
    public Board(int boardSize)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(3);init(boardSize);
    }

    /** Check for two consecutive passes.
        @return true, if the last two moves were pass moves */
    @Override
	public boolean bothPassed()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(4);int n = getNumberMoves();
        return (n >= 2
                && m_stack.get(n - 1).m_move.getPoint() == null
                && m_stack.get(n - 2).m_move.getPoint() == null);
    }

    /** Check if board contains a point.
        @param point The point to check
        @return true, if the point is on the board */
    @Override
	public boolean contains(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(5);return point.isOnBoard(getSize());
    }

    /** Get points adjacent to a point.
        @param point The point.
        @return List of points adjacent. */
    @Override
	public ConstPointList getAdjacent(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(6);return m_constants.getAdjacent(point);
    }

    /** Get number of captured stones.
        @return The total number of stones of the given color captured by
        opponent moves or by suicide. */
    @Override
	public int getCaptured(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(7);return m_captured.get(c);
    }

    /** Get state of a point on the board.
        @return BLACK, WHITE or EMPTY */
    @Override
	public GoColor getColor(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(8);return m_color[p.getIndex()];
    }

    /** Get location of handicap stones for a given board size.
        @param n The number of handicap stones.
        @param size The board size.
        @return List of points (go.Point) corresponding to the handicap
        stone locations.
        @see BoardConstants#getHandicapStones */
    public static ConstPointList getHandicapStones(int size, int n)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(9);return BoardConstants.get(size).getHandicapStones(n);
    }

    /** Opponent stones captured in last move.
        Does not include player stones killed by suicide.
        Requires that there is a last move (or setup stone).
        @return List of opponent stones (go.Point) captured in last move;
        empty if none were killed or there is no last move.
        @see #getSuicide() */
    @Override
	public ConstPointList getKilled()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(10);int n = getNumberMoves();
        assert n > 0;
        return m_stack.get(n - 1).m_killed;
    }

    /** Return last move.
        @return Last move or null if there is no last move. */
    @Override
	public Move getLastMove()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(11);int n = getNumberMoves();
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(12);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(14) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(13);return null;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(15);return m_stack.get(n - 1).m_move;
    }

    /** Get the number of moves played so far.
        @return The number of moves.
        @see #getMove */
    @Override
	public int getNumberMoves()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(16);return m_stack.size();
    }

    /** Get a move from the sequence of moves played so far.
        @param i The number of the move (starting with zero).
        @return The move with the given number.
        @see #getNumberMoves() */
    @Override
	public Move getMove(int i)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(17);return m_stack.get(i).m_move;
    }

    /** Get initial setup stones of a color.
        @param c Black or White.
        @return Initial stones of this color placed on the board by calling
        <code>setup</code>.
        @see #setup */
    @Override
	public ConstPointList getSetup(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(18);return m_setup.get(c);
    }

    /** Get player of initial setup position.
        @return Player of initial setup position as used in the call to
        <code>setup</code>; <code>null</code> means unknown player color.
        @see #setup */
    @Override
	public GoColor getSetupPlayer()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(19);return m_setupPlayer;
    }

    /** Get board size.
        @return The board size. */
    @Override
	public int getSize()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(20);return m_size;
    }

    /** Get stones of a block. */
    @Override
	public void getStones(GoPoint p, GoColor color, PointList stones)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(21);assert m_mark.isCleared();
        findStones(p, color, stones);
        m_mark.clear(stones);
        //assert m_mark.isCleared();
    }

    /** Player stones killed by suicide in last move.
        Requires that there is a last move (or setup stone).
        @return List of stones (go.Point) killed by suicide in last move,
        including the stone played; empty if no stones were killed by suicide
        or if there is no last move.
        @see #getKilled() */
    @Override
	public ConstPointList getSuicide()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(22);int n = getNumberMoves();
        assert n > 0;
        return m_stack.get(n - 1).m_suicide;
    }

    /** Get color to move.
        @return The color to move. */
    @Override
	public GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(23);return m_toMove;
    }

    /** Initialize the board for a given board size.
        For changing the board size.
        Also calls clear().
        @param size The new board size (number of points per
        row / column) in the range from one to GoPoint.MAX_SIZE */
    public void init(int size)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(24);m_size = size;
        m_mark = new Marker(m_size);
        m_constants = BoardConstants.get(size);
        clear();
    }

    /** Check if a move would capture anything (including suicide).
        @param c The player color.
        @param p The point to check.
        @return true, if a move on the given point by the given player would
        capture any opponent stones, or be a suicide move. */
    @Override
	public boolean isCaptureOrSuicide(GoColor c, GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(25);if ((getColor(p) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(27) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(26);return false;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(28);play(c, p);
        boolean result = (getKilled().size() > 0 || getSuicide().size() > 0);
        undo();
        return result;
    }

    /** Check if a point is a handicap point.
        @param point The point to check.
        @return true, if the given point is a handicap point.
        @see BoardConstants#isHandicap */
    @Override
	public boolean isHandicap(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(29);return m_constants.isHandicap(point);
    }

    /** Check if move would violate the simple Ko rule.
        Assumes other color to move than the color of the last move.
        @param point The point to check
        @return true, if a move at this point would violate the simple ko
        rule */
    @Override
	public boolean isKo(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(30);return point == m_koPoint;
    }

    /** Check if any moves were played or setup stones placed on the board. */
    @Override
	public boolean isModified()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(31);return (! m_stack.isEmpty()
                || m_setup.get(BLACK).size() > 0
                || m_setup.get(WHITE).size() > 0
                || m_toMove != BLACK);
    }

    /** Check if the initial setup position was a handicap.
        @return <code>true</code>, if the initial position was setup by
        calling setupHandicap, <code>false</code> otherwise.
        @see #setupHandicap */
    @Override
	public boolean isSetupHandicap()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(32);return m_isSetupHandicap;
    }

    /** Check if a point would be a suicide move.
        @param c The player color to check.
        @param p The point to check.
        @return true, if a move at the given point by the given player
        would be a suicide move. */
    @Override
	public boolean isSuicide(GoColor c, GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(33);if ((getColor(p) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(35) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(34);return false;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(36);play(c, p);
        boolean result = (getSuicide().size() > 0);
        undo();
        return result;
    }

    @Override
	public Iterator<GoPoint> iterator()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(37);return new BoardIterator();
    }

    /** Clear board.
        Takes back the effects of any moves or setup stones on the board. */
    public void clear()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(38);for (GoPoint p : this)
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(43);setColor(p, EMPTY);}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(39);m_stack.clear();
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(40);for (GoColor c : BLACK_WHITE)
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(42);m_setup.get(c).clear();
            m_captured.set(c, 0);
        }
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(41);m_toMove = BLACK;
        m_koPoint = null;
        m_isSetupHandicap = false;
        m_setupPlayer = null;
    }

    /** Play a move.
        @param color The player who played the move.
        @param point The location of the move.
        @see #play(Move) */
    public void play(GoColor color, GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(44);play(Move.get(color, point));
    }

    /** Play a move.
        Never fails, even if ko rule is violated, suicide or play on occupied
        points. For example, when loading an SGF file with illegal moves,
        we still want to be able to load and execute the moves.
        A move will place a stone of the given color, capture all dead
        blocks adjacent to the stone, capture the block the stone is part of
        if it was a suicide move and switches the color to move.
        @param move The move (location and player) */
    public void play(Move move)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(45);StackEntry entry = new StackEntry(move);
        entry.execute(this);
        m_stack.add(entry);
    }

    /** Change the color to move.
        @param toMove The new color to move. */
    public void setToMove(GoColor toMove)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(46);m_toMove = toMove;
    }

    /** Setup position.
        Clears the board and move history and sets up a position.
        @param black Black stones to add on the board.
        @param white White stones to add on the board.
        @param player Color to play */
    public void setup(ConstPointList black, ConstPointList white,
                      GoColor player)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(47);clear();
        m_koPoint = null;
        m_setupPlayer = player;
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(48);if ((m_setupPlayer != null) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(50) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(49);m_toMove = player;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(51);for (GoColor c : BLACK_WHITE)
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(52);ConstPointList stones = (((c == BLACK) ? ($qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(53) || true) : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(54) && false)) ? black : white);
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(55);if ((stones == null) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(57) && false))
                {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(56);m_setup.set(c, new PointList());}
            else
            {
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(58);for (GoPoint p : stones)
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(60);setColor(p, c);}
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(59);m_setup.set(c, new PointList(stones));
            }
        }
    }

    /** Setup initial handicap stones.
        This function is similar to an initial setup with only black stones,
        but it is remembered that the setup was a handicap and it can later
        be checked with <code>isSetupHandicap</code>.
        @see #isSetupHandicap */
    public void setupHandicap(ConstPointList points)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(61);setup(points, null, WHITE);
        m_isSetupHandicap = true;
    }

    /** Undo the last move.
        Restores any stones removed by the last move (captured or
        suicide) and the color who was to move before the move. */
    public void undo()
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(62);int index = getNumberMoves() - 1;
        assert index >= 0;
        m_stack.get(index).undo(this);
        m_stack.remove(index);
    }

    /** Undo a number of moves.
        @param n Number of moves to undo. Must be between 0
        and getNumberMoves().
        @see #undo() */
    public void undo(int n)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(63);assert n >= 0;
        assert n <= getNumberMoves();
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(64);for (int i = 0; (i < n) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(66) && false); ++i)
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(65);undo();}
    }

    private static class StackEntry
    {
        public final Move m_move;

        public GoPoint m_oldKoPoint;

        public GoColor m_oldColor;

        public GoColor m_oldToMove;

        public PointList m_killed;

        public PointList m_suicide;

        public StackEntry(Move move)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(67);m_move = move;
        }

        public void execute(Board board)
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(68);GoPoint p = m_move.getPoint();
            GoColor c = m_move.getColor();
            GoColor otherColor = c.otherColor();
            m_killed = new PointList();
            m_suicide = new PointList();
            m_oldKoPoint = board.m_koPoint;
            board.m_koPoint = null;
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(69);if ((p != null) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(71) && false))
            {
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(70);m_oldColor = board.getColor(p);
                board.setColor(p, c);
                assert c != EMPTY;
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(72);for (GoPoint adj : board.getAdjacent(p))
                {
                    $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(79);int killedSize = m_killed.size();
                    $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(80);if ((board.getColor(adj) == otherColor) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(82) && false))
                        {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(81);board.checkKill(adj, m_killed);}
                    $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(83);if ((m_killed.size() == killedSize + 1) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(85) && false))
                        {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(84);board.m_koPoint = m_killed.get(killedSize);}
                }
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(73);board.checkKill(p, m_suicide);
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(74);if ((board.m_koPoint != null
                    && ! board.isSingleStoneSingleLib(p, c)) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(76) && false))
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(75);board.m_koPoint = null;}
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(77);board.m_captured.set(c,
                                     board.m_captured.get(c)
                                     + m_suicide.size());
                board.m_captured.set(otherColor,
                                     board.m_captured.get(otherColor)
                                     + m_killed.size());
            }
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(78);m_oldToMove = board.m_toMove;
            board.m_toMove = otherColor;
        }

        protected void undo(Board board)
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(86);GoPoint p = m_move.getPoint();
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(87);if ((p != null) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(89) && false))
            {
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(88);GoColor c = m_move.getColor();
                GoColor otherColor = c.otherColor();
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(90);for (GoPoint stone : m_suicide)
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(96);board.setColor(stone, c);}
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(91);board.setColor(p, m_oldColor);
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(92);for (GoPoint stone : m_killed)
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(95);board.setColor(stone, otherColor);}
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(93);board.m_captured.set(c,
                                     board.m_captured.get(c)
                                     - m_suicide.size());
                board.m_captured.set(otherColor,
                                     board.m_captured.get(otherColor)
                                     - m_killed.size());
            }
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(94);board.m_toMove = m_oldToMove;
            board.m_koPoint = m_oldKoPoint;
        }
    }

    private Marker m_mark;

    private int m_size;

    private final BlackWhiteSet<Integer> m_captured
        = new BlackWhiteSet<Integer>(0, 0);

    private final ArrayList<StackEntry> m_stack
        = new ArrayList<StackEntry>(361);

    /** Temporary variable reused for efficiency. */
    private final PointList m_checkKillStones = new PointList();

    /** Temporary variable reused for efficiency. */
    private final PointList m_checkKillStack = new PointList();

    private GoColor[] m_color = new GoColor[GoPoint.NUMBER_INDEXES];

    private GoColor m_toMove;

    private GoColor m_setupPlayer;

    private BoardConstants m_constants;

    private GoPoint m_koPoint;

    private final BlackWhiteSet<PointList> m_setup
        = new BlackWhiteSet<PointList>(new PointList(), new PointList());

    private boolean m_isSetupHandicap;

    private boolean isSingleStoneSingleLib(GoPoint point, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(97);if ((getColor(point) != color) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(99) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(98);return false;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(100);int lib = 0;
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(101);for (GoPoint adj : getAdjacent(point))
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(103);GoColor adjColor = getColor(adj);
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(104);if ((adjColor == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(106) && false))
            {
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(105);++lib;
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(107);if ((lib > 1) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(109) && false))
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(108);return false;}
            }
            else {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(110);if ((adjColor.equals(color)) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(112) && false))
                {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(111);return false;}}
        }
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(102);return true;
    }

    private void checkKill(GoPoint point, PointList killed)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(113);assert m_mark.isCleared();
        GoColor color = getColor(point);
        assert color != EMPTY;
        m_checkKillStack.clear();
        m_checkKillStack.add(point);
        m_mark.set(point);
        m_checkKillStones.clear();
        boolean isDead = true;
        // Recursion is unrolled using a stack for efficiency
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(114);while ((isDead && ! m_checkKillStack.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(116) && false))
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(115);GoPoint p = m_checkKillStack.pop();
            assert getColor(p) == color;
            m_checkKillStones.add(p);
            ConstPointList adjacent = getAdjacent(p);
            int nuAdjacent = adjacent.size();
            // Don't use an iterator for efficiency
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(124);for (int i = 0; (i < nuAdjacent) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(126) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(125);GoPoint adj = adjacent.get(i);
                GoColor c = getColor(adj);
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(127);if ((c == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(129) && false))
                {
                    $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(128);isDead = false;
                    break;
                }
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(130);if ((m_mark.get(adj) || ! c.equals(color)) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(132) && false))
                    {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(131);continue;}
                $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(133);m_checkKillStack.add(adj);
                m_mark.set(adj);
            }
        }
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(117);if ((isDead) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(119) && false))
        {
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(118);killed.addAll(m_checkKillStones);
            int nuKillStones = m_checkKillStones.size();
            // Don't use an iterator for efficiency
            $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(120);for (int i = 0; (i < nuKillStones) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(122) && false); ++i)
                {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(121);setColor(m_checkKillStones.get(i), EMPTY);}
        }
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(123);m_mark.clear(m_checkKillStack);
        m_mark.clear(m_checkKillStones);
        //assert m_mark.isCleared();
    }

    private void findStones(GoPoint p, GoColor color, PointList stones)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(134);if ((getColor(p) != color) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(136) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(135);return;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(137);if ((m_mark.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(139) && false))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(138);return;}
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(140);m_mark.set(p);
        stones.add(p);
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(141);for (GoPoint adj : getAdjacent(p))
            {$qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(142);findStones(adj, color, stones);}
    }

    private void setColor(GoPoint p, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_8b51f903a3c7a1e4(143);assert p != null;
        m_color[p.getIndex()] = c;
    }
}
