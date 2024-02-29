/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Marker.java

package net.sf.gogui.go;

/** Mark points on a Go board. */
public class Marker
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Marker.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1948081127294626950L,/* translation unit id   */ -3993297762117008503L,/* timestamp             */ 1709177900514L,/* source file name      */ "Marker.java",/* probe size            */ 26);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c894f4d7bea74389(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param size Size of the board. */
    public Marker(int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(0);m_size = size;
        m_mark = new boolean[GoPoint.NUMBER_INDEXES];
    }

    /** Clear all marked points. */
    public void clear()
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(1);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(3) && false); ++x)
            {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(2);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(5) && false); ++y)
                {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(4);m_mark[GoPoint.getIndex(x, y)] = false;}}
    }

    /** Clear a marked point.
        @param p The point to clear. */
    public void clear(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(6);m_mark[p.getIndex()] = false;
    }

    /** Clear all points from a list.
        @param points List of points. */
    public void clear(ConstPointList points)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(7);int nuPoints = points.size();
        // Don't use an iterator for efficiency
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(8);for (int i = 0; (i < nuPoints) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(10) && false); ++i)
            {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(9);m_mark[points.get(i).getIndex()] = false;}
    }

    /** Check if a point is marked.
        @param p The point to check.
        @return true, if point is marked, false otherwise. */
    public boolean get(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(11);return m_mark[p.getIndex()];
    }

    /** Check if no point is marked.
        @return true, if no point is marked, false otherwise. */
    public boolean isCleared()
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(12);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(14) && false); ++x)
            {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(13);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(17) && false); ++y)
                {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(16);if ((m_mark[GoPoint.getIndex(x, y)]) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(19) && false))
                    {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(18);return false;}}}
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(15);return true;
    }

    /** Mark a point.
        @param p The point to mark. */
    public void set(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(20);m_mark[p.getIndex()] = true;
    }

    /** Mark or clear a point.
        @param p The point to mark or clear.
        @param value true, if point should be marked; false, if point should
        be cleared. */
    public void set(GoPoint p, boolean value)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(21);m_mark[p.getIndex()] = value;
    }

    /** Mark all points from a list.
        @param points List of points. */
    public void set(ConstPointList points)
    {
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(22);int nuPoints = points.size();
        // Don't use an iterator for efficiency
        $qualityscroll_cover_jacov_probe_c894f4d7bea74389(23);for (int i = 0; (i < nuPoints) ? true : (!$qualityscroll_cover_jacov_probe_c894f4d7bea74389(25) && false); ++i)
            {$qualityscroll_cover_jacov_probe_c894f4d7bea74389(24);m_mark[points.get(i).getIndex()] = true;}
    }

    private final int m_size;

    private boolean m_mark[];
}
