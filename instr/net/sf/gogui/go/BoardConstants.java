/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// BoardConstants.java

package net.sf.gogui.go;

/** Some values that are constant for a given board size.
    Instances of this class are immutable. */
public final class BoardConstants
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardConstants.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7499518990426720383L,/* translation unit id   */ -4413490283549072337L,/* timestamp             */ 1709177900310L,/* source file name      */ "BoardConstants.java",/* probe size            */ 80);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c2c021f8856b642f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Get board constants for a given board size.
        The instance is created if it did not exist before, otherwise a
        reference to the existing one is returned.
        The creation is done in a thread-safe way.
        @param boardSize The new board size (number of points per
        row / column) in the range from one to GoPoint.MAX_SIZE
        @return The board constants. */
    public static BoardConstants get(int boardSize)
    {$qualityscroll_cover_coverage_buffer_init();
        synchronized (s_boardConstants)
        {
            $qualityscroll_cover_jacov_probe_c2c021f8856b642f(0);if ((s_boardConstants[boardSize] == null) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(2) && false))
                {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(1);s_boardConstants[boardSize] = new BoardConstants(boardSize);}
        }
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(3);return s_boardConstants[boardSize];
    }

    public ConstPointList getAdjacent(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(4);return m_adjacent[p.getIndex()];
    }

    /** Get location of handicap stones.
        The handicap stone locations are defined as in the GTP version 2
        specification (section 4.1.1 Fixed Handicap Placement).
        Even board sizes and sizes smaller than 9 support up to 4 handicap
        stones; other sizes up to 9 handicap stones.
        @param n The number of handicap stones.
        @return List of points (go.Point) corresponding to the handicap
        stone locations; null if handicap locations are not defined for
        this combination of number of handicap stones and board size; empty
        list for zero handicap stones. */
    public ConstPointList getHandicapStones(int n)
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(5);PointList result = new PointList(9);
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(6);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(8) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(7);return result;}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(9);int line1 = m_handicapLine1;
        int line2 = m_handicapLine2;
        int line3 = m_handicapLine3;
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(10);if ((line1 < 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(12) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(11);return null;}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(13);if ((n == 1 || n > 9 || (n > 4 && line2 < 0)) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(15) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(14);return null;}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(16);if ((n >= 1) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(18) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(17);result.add(GoPoint.get(line1, line1));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(19);if ((n >= 2) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(21) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(20);result.add(GoPoint.get(line3, line3));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(22);if ((n >= 3) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(24) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(23);result.add(GoPoint.get(line1, line3));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(25);if ((n >= 4) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(27) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(26);result.add(GoPoint.get(line3, line1));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(28);if ((n >= 5 && n % 2 != 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(30) && false))
        {
            $qualityscroll_cover_jacov_probe_c2c021f8856b642f(29);result.add(GoPoint.get(line2, line2));
            --n;
        }
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(31);if ((n >= 5) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(33) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(32);result.add(GoPoint.get(line1, line2));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(34);if ((n >= 6) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(36) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(35);result.add(GoPoint.get(line3, line2));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(37);if ((n >= 7) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(39) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(38);result.add(GoPoint.get(line2, line1));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(40);if ((n >= 8) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(42) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(41);result.add(GoPoint.get(line2, line3));}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(43);return result;
    }

    /** Get list containing all points on the board. */
    public ConstPointList getPoints()
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(44);return m_allPoints;
    }

    /** Get board size. */
    public int getSize()
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(45);return m_size;
    }

    /** Check if line is on the edge of the board.
        @param i The value of the constant coordinate shared by all points
        on the line.
        @return <code>true</code>, if the constant coordinate has the smallest
        or largest possible value (<code>0</code> or
        <code>getSize() - 1</code>). */
    public boolean isEdgeLine(int i)
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(46);return (i == 0 || i == m_size - 1);
    }

    /** Check if line is a line containing handicap points.
        @param i The value of the constant coordinate shared by all points
        on the line.
        @return <code>true</code>, if the line contains handicap points.
        @see #getHandicapStones */
    public boolean isHandicapLine(int i)
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(47);return (i == m_handicapLine1 || i == m_handicapLine2
                || i == m_handicapLine3);
    }

    /** Check if point is a potential location of a handicap stone.
        @param p The point to check.
        @return true, if point is a potential location of a handicap stone.
        @see #getHandicapStones */
    public boolean isHandicap(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(48);int x = p.getX();
        int y = p.getY();
        return (isHandicapLine(x) && isHandicapLine(y));
    }

    private static BoardConstants[] s_boardConstants
        = new BoardConstants[GoPoint.MAX_SIZE + 1];

    private final int m_size;

    private final int m_handicapLine1;

    private final int m_handicapLine2;

    private final int m_handicapLine3;

    private final PointList m_allPoints;

    private final ConstPointList[] m_adjacent;

    private BoardConstants(int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(49);m_size = size;
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(50);if ((size >= 13) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(52) && false))
        {
            $qualityscroll_cover_jacov_probe_c2c021f8856b642f(51);m_handicapLine1 = 3;
            m_handicapLine3 = size - 4;
        }
        else {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(76);if ((size >= 7) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(78) && false))
        {
            $qualityscroll_cover_jacov_probe_c2c021f8856b642f(77);m_handicapLine1 = 2;
            m_handicapLine3 = size - 3;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_c2c021f8856b642f(79);m_handicapLine1 = -1;
            m_handicapLine3 = -1;
        }}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(53);if ((size >= 9 && size % 2 != 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(55) && false))
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(54);m_handicapLine2 = size / 2;}
        else
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(75);m_handicapLine2 = -1;}
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(56);m_allPoints = new PointList();
        m_adjacent = new ConstPointList[GoPoint.NUMBER_INDEXES];
        $qualityscroll_cover_jacov_probe_c2c021f8856b642f(57);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(59) && false); ++x)
            {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(58);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(61) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(60);GoPoint p = GoPoint.get(x, y);
                m_allPoints.add(p);
                PointList adjacent = new PointList();
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(62);if ((x > 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(64) && false))
                    {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(63);adjacent.add(GoPoint.get(x - 1, y));}
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(65);if ((x < m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(67) && false))
                    {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(66);adjacent.add(GoPoint.get(x + 1, y));}
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(68);if ((y > 0) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(70) && false))
                    {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(69);adjacent.add(GoPoint.get(x, y - 1));}
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(71);if ((y < m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_c2c021f8856b642f(73) && false))
                    {$qualityscroll_cover_jacov_probe_c2c021f8856b642f(72);adjacent.add(GoPoint.get(x, y + 1));}
                $qualityscroll_cover_jacov_probe_c2c021f8856b642f(74);m_adjacent[p.getIndex()] = adjacent;
            }}
    }
}
