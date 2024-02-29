/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Histogram.java

package net.sf.gogui.util;

import java.io.PrintStream;

/** Histogram for data samples. */
public class Histogram
    extends Statistics
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Histogram.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -5250378137531650796L,/* translation unit id   */ 5074325445824216209L,/* timestamp             */ 1709177903985L,/* source file name      */ "Histogram.java",/* probe size            */ 29);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_466ba01ba913fc91(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Histogram(double min, double max, double step)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(0);m_min = min;
        m_max = max;
        m_step = step;
        m_size = Math.max(1, (int)Math.ceil((max - min) / step));
        m_array = new int[m_size];
    }

    @Override
	public void add(double value)
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(1);super.add(value);
        int i;
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(2);if ((value == m_max) ? true : (!$qualityscroll_cover_jacov_probe_466ba01ba913fc91(4) && false))
            {$qualityscroll_cover_jacov_probe_466ba01ba913fc91(3);i = m_size - 1;}
        else
            {$qualityscroll_cover_jacov_probe_466ba01ba913fc91(6);i = (int)((value - m_min) / m_step);}
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(5);++m_array[i];
    }

    public int getCount(int i)
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(7);return m_array[i];
    }

    public double getHistoMin()
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(8);return m_min;
    }

    public double getHistoMax()
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(9);return m_max;
    }

    /** Return number of intervals. */
    public int getSize()
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(10);return m_size;
    }

    public double getStep()
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(11);return m_step;
    }

    public double getValue(int i)
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(12);return m_min + i * m_step;
    }

    public void printHtml(PrintStream out)
    {
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(13);out.print("<p>\n" +
                  "<table border=\"0\" cellspacing=\"1\" cellpadding=\"0\""
                  + " rules=\"groups\">\n");
        int min;
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(14);for (min = 0; (min < m_size - 1 && m_array[min] == 0) ? true : (!$qualityscroll_cover_jacov_probe_466ba01ba913fc91(16) && false); ++min)
            {$qualityscroll_cover_jacov_probe_466ba01ba913fc91(15);;}
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(17);int max;
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(18);for (max = m_size - 1; (max > 0 && m_array[max] == 0) ? true : (!$qualityscroll_cover_jacov_probe_466ba01ba913fc91(20) && false); --max)
            {$qualityscroll_cover_jacov_probe_466ba01ba913fc91(19);;}
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(21);for (int i = min; (i <= max) ? true : (!$qualityscroll_cover_jacov_probe_466ba01ba913fc91(23) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_466ba01ba913fc91(22);int scale = 630;
            int width = m_array[i] * scale / getCount();
            $qualityscroll_cover_jacov_probe_466ba01ba913fc91(25);if ((getValue(i) >= 0 && getValue(i - 1) < 0) ? true : (!$qualityscroll_cover_jacov_probe_466ba01ba913fc91(27) && false))
                {$qualityscroll_cover_jacov_probe_466ba01ba913fc91(26);out.print("<tbody>\n");}
            $qualityscroll_cover_jacov_probe_466ba01ba913fc91(28);out.print("<tr><td align=\"right\"><small>" + getValue(i)
                      + "</small></td><td><table cellspacing=\"0\"" +
                      " cellpadding=\"0\" border=\"0\" width=\"" + scale
                      + "\"><tr>" +
                      "<td bgcolor=\"#666666\" width=\"" + width +
                      "\"></td>" + "<td bgcolor=\"#cccccc\" width=\""
                      + (scale - width) + "\"><small>"
                      + m_array[i]
                      + "</small></td></tr></table></td></tr>\n");
        }
        $qualityscroll_cover_jacov_probe_466ba01ba913fc91(24);out.print("</table>\n" +
                  "</p>\n");
    }

    private final int m_size;

    private final double m_max;

    private final double m_min;

    private final double m_step;

    private int[] m_array;
}
