/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// Statistics.java

package net.sf.gogui.util;

/** Collects statistical features of sample values. */
public class Statistics
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Statistics.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2709138413426234314L,/* translation unit id   */ 5506067078254006714L,/* timestamp             */ 1709177904126L,/* source file name      */ "Statistics.java",/* probe size            */ 22);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Add value.
        @param value The value to add. */
    public void add(double value)
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(0);m_min = Math.min(value, m_min);
        m_max = Math.max(value, m_max);
        m_sum += value;
        m_sumSq += (value * value);
        ++m_count;
    }

    /** Get number of values added.
        @return Number of values added. */
    public int getCount()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(1);return m_count;
    }

    /** Get standard deviation.
        @return The standard deviation (square root of variance). */
    public double getDeviation()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(2);return Math.sqrt(getVariance());
    }

    /** Get standard error.
        @return The standard error (standard deviation divided by square root
        of the number of values). */
    public double getError()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(3);if ((m_count == 0) ? true : (!$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(5) && false))
            {$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(4);return 0;}
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(6);return getDeviation() / Math.sqrt(m_count);
    }

    /** Get mean value.
        @return The mean of all values. */
    public double getMean()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(7);if ((m_count == 0) ? true : (!$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(9) && false))
            {$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(8);return 0;}
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(10);return m_sum / m_count;
    }

    /** Get maximum value.
        @return The maximum of the value or Double.NEGATIVE_INFINITY, if no
        values. */
    public double getMax()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(11);return m_max;
    }

    /** Get maximum error.
        Returns the error assuming that every n values are 100 per cent
        correlated.
        @param n The number of values that are assumed to be 100 per cent
        correlated.
        @return The standard error for this assumption (standard deviation
        divided by square root of number of values divided by n). */
    public double getMaxError(int n)
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(12);if ((m_count == 0) ? true : (!$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(14) && false))
            {$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(13);return 0;}
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(15);return getDeviation() / Math.sqrt((double)m_count / n);
    }

    /** Get minumum value.
        @return The minumum of the value or Double.POSITIVE_INFINITY, if no
        values. */
    public double getMin()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(16);return m_min;
    }

    /** Get sum of values.
        @return The sum of all values. */
    public double getSum()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(17);return m_sum;
    }

    /** Get variance.
        @return The variance (sum of squares of differences between values
        and mean). */
    public double getVariance()
    {
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(18);if ((m_count == 0) ? true : (!$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(20) && false))
            {$qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(19);return 0;}
        $qualityscroll_cover_jacov_probe_4c697ad5d4cd91ba(21);double mean = getMean();
        return m_sumSq / m_count - mean * mean;
    }

    private int m_count;

    private double m_max = Double.NEGATIVE_INFINITY;

    private double m_min = Double.POSITIVE_INFINITY;

    private double m_sum;

    private double m_sumSq;
}
