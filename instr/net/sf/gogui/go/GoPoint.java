/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoPoint.java

package net.sf.gogui.go;

import java.util.Locale;
import net.sf.gogui.util.StringUtil;

/** Intersection on the Go board.
    This class is immutable and references to the same point are unique.
    Instances can be created with GoPoint.get().
    Point coordinates start with 0, the point (0,0) corresponds to "A1"
    and is on the lower left corner of the board, if the board is drawn on
    the screen. */
public final class GoPoint
    implements Comparable<GoPoint>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoPoint.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3887951805933409400L,/* translation unit id   */ -217727934763278331L,/* timestamp             */ 1709177900429L,/* source file name      */ "GoPoint.java",/* probe size            */ 83);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_fcfa7998cec16005(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Maximum board size.
        Set such that all points can be converted to strings with one letter
        and a number, i.e. the largest point is Z25. */
    public static final int MAX_SIZE = 25;

    /** Default board size. */
    public static final int DEFAULT_SIZE = 19;

    /** Upper limit (exclusive) for one-dimensional point index.
        @see #getIndex */
    public static final int NUMBER_INDEXES = MAX_SIZE * MAX_SIZE;

    /** Compare two points.
        The order of the points is: A1, B1, ..., A2, B2, ... */
    @Override
	public int compareTo(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(0);if ((m_index < p.m_index) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(2) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(1);return -1;}
        else {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(3);if ((m_index > p.m_index) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(5) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(4);return 1;}
        else
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(6);return 0;}}
    }

    /** Indicate if this object is equal to another object.
        Since point instances are unique, this function does the same as
        Object.equals and is only added explicitely to avoid warnings about
        classes with a compareTo, but no equals-function. */
    @Override
	public boolean equals(Object obj)
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(7);return (this == obj);
    }

    /** Compare, including the case that the points can be null. */
    public static boolean equals(GoPoint point1, GoPoint point2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(8);return (point1 == point2);
    }

    /** Factory method for creating a point.
        @param x x-coordinate <code>[0...GoPoint.MAX_SIZE - 1]</code>
        @param y y-coordinate <code>[0...GoPoint.MAX_SIZE - 1]</code>
        @return Unique reference to a point with these coordinates. */
    public static GoPoint get(int x, int y)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(9);assert x >= 0;
        assert y >= 0;
        assert x < MAX_SIZE;
        assert y < MAX_SIZE;
        GoPoint point = s_points[x][y];
        assert point != null;
        return point;
    }

    /** Integer for using points as indices in an array.
        The index of A1 is zero and the indices count upwards from left
        to right and bottom to top over a board with the maximum size
        GoPoint.MAX_SIZE. */
    public int getIndex()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(10);return m_index;
    }

    /** See getIndex(). */
    public static int getIndex(int x, int y)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(11);return y * MAX_SIZE + x;
    }

    @Override
	public int hashCode()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(12);return m_index;
    }

    /** Return point below.
        @return The point below this point (x, y - 1). */
    public GoPoint down()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(13);if ((m_y > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(15) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(14);return get(m_x, m_y - 1);}
        else
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(16);return this;}
    }

    /** X-Coordinate. */
    public int getX()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(17);return m_x;
    }

    /** Y-Coordinate. */
    public int getY()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(18);return m_y;
    }

    public boolean isOnBoard(int size)
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(19);assert size > 0;
        assert size <= MAX_SIZE;
        return (m_x < size && m_y < size);
    }

    /** Return point left.
        @return the point below this point (x - 1, y) */
    public GoPoint left()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(20);if ((m_x > 0) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(22) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(21);return get(m_x - 1, m_y);}
        else
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(23);return this;}
    }

    /** Parse point or null (PASS).
        Parsing is case-insensitive, leading and trailing whitespace is
        ignored. "PASS" returns null, invalid strings throw an
        InvalidPointException. */
    public static GoPoint parsePoint(String string, int boardSize)
        throws InvalidPointException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(24);string = string.trim().toUpperCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(25);if ((string.equals("PASS")) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(27) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(26);return null;}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(28);if ((string.length() < 2) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(30) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(29);throw new InvalidPointException(string);}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(31);char xChar = string.charAt(0);
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(32);if ((xChar >= 'J') ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(34) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(33);--xChar;}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(35);int x = xChar - 'A';
        int y;
        try
        {
            $qualityscroll_cover_jacov_probe_fcfa7998cec16005(36);y = Integer.parseInt(string.substring(1)) - 1;
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_fcfa7998cec16005(41);throw new InvalidPointException(string);
        }
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(37);if ((x < 0 || x >= boardSize || y < 0 || y >= boardSize) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(39) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(38);throw new InvalidPointException(string);}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(40);return GoPoint.get(x, y);
    }

    public static PointList parsePointList(String s, int boardSize)
        throws InvalidPointException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(42);PointList list = new PointList();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(43);for (String p : StringUtil.splitArguments(s))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(45);if ((! p.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(47) && false))
                {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(46);list.add(parsePoint(p, boardSize));}}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(44);return list;
    }

    /** Return point right.
        @param max Current board size.
        @return The point to the right of this point (x, y + 1)
        or this point if no such point exists. */
    public GoPoint right(int max)
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(48);if ((m_x < max - 1) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(50) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(49);return get(m_x + 1, m_y);}
        else
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(51);return this;}
    }

    /** Convert to a string.
        @return String representation of this point. */
    @Override
	public String toString()
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(52);return m_string;
    }

    /** Convert a point or null point (pass) to a string.
        @param point Point or null for pass moves
        @return point.toString() or "PASS" if point is null */
    public static String toString(GoPoint point)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(53);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(55) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(54);return "PASS";}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(56);return point.toString();
    }

    /** Convert a list of points to a string.
        Points are separated by a single space.
        If pointList is null, "(null)" is returned. */
    public static String toString(ConstPointList pointList)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(57);if ((pointList == null) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(59) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(58);return "(null)";}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(60);int length = pointList.size();
        StringBuilder buffer = new StringBuilder(length * 4);
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(61);for (int i = 0; (i < length) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(63) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_fcfa7998cec16005(62);buffer.append(pointList.get(i));
            $qualityscroll_cover_jacov_probe_fcfa7998cec16005(65);if ((i < length - 1) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(67) && false))
                {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(66);buffer.append(' ');}
        }
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(64);return buffer.toString();
    }

    /** Return point above.
        @param max Current board size.
        @return The point above this point (x, y + 1) or this point if no such
        point exists. */
    public GoPoint up(int max)
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(68);if ((m_y < max - 1) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(70) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(69);return get(m_x, m_y + 1);}
        else
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(71);return this;}
    }

    private static GoPoint[][] s_points;

    private final int m_x;

    private final int m_y;

    private final int m_index;

    private final String m_string;

    static
    {
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(77);s_points = new GoPoint[MAX_SIZE][MAX_SIZE];
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(78);for (int x = 0; (x < MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(80) && false); ++x)
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(79);for (int y = 0; (y < MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(82) && false); ++y)
                {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(81);s_points[x][y] = new GoPoint(x, y);}}
    }

    private GoPoint(int x, int y)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(72);m_x = x;
        m_y = y;
        char xChar = (char)('A' + x);
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(73);if ((xChar >= 'I') ? true : (!$qualityscroll_cover_jacov_probe_fcfa7998cec16005(75) && false))
            {$qualityscroll_cover_jacov_probe_fcfa7998cec16005(74);++xChar;}
        $qualityscroll_cover_jacov_probe_fcfa7998cec16005(76);m_string = xChar + Integer.toString(m_y + 1);
        m_index = getIndex(x, y);
    }
}
