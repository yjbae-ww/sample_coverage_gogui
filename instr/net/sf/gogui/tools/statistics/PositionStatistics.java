/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// PositionStatistics.java

package net.sf.gogui.tools.statistics;

import net.sf.gogui.util.Histogram;
import net.sf.gogui.util.Statistics;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Table;
import net.sf.gogui.util.TableUtil;

/** Collect GTP response statistics for a set of positions. */
public final class PositionStatistics
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = PositionStatistics.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -902937569852105182L,/* translation unit id   */ 104374285011708418L,/* timestamp             */ 1709177903635L,/* source file name      */ "PositionStatistics.java",/* probe size            */ 49);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public final boolean m_onlyBoolValues;

    public final boolean m_onlyIntValues;

    public final int m_numberNoResult;

    public final Histogram m_histogram;

    public final Statistics m_statistics;

    public final Table m_histoTable;

    public PositionStatistics(String command, Table table,
                              boolean noAutoScaleHisto,
                              double histoMin, double histoMax)
        throws Table.InvalidLocation, ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(0);m_statistics = new Statistics();
        boolean onlyIntValues = true;
        int numberNoResult = 0;
        boolean onlyBoolValues = true;
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(1);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(3) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(2);String value = table.get(command, row);
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(22);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(24) && false))
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(23);++numberNoResult;
                continue;
            }
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(25);if ((TableUtil.isNumberValue(value)) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(27) && false))
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(26);if ((! TableUtil.isIntValue(value)) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(29) && false))
                    {$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(28);onlyIntValues = false;}
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(30);if ((! TableUtil.isBoolValue(value)) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(32) && false))
                    {$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(31);onlyBoolValues = false;}
            }
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(33);int move;
            try
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(34);move = Integer.parseInt(table.get("Move", row));
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(40);throw new ErrorMessage("Invalid move in table");
            }
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(35);if ((move < 0) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(37) && false))
                {$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(36);throw new ErrorMessage("Invalid move in table");}
            try
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(38);m_statistics.add(Double.parseDouble(value));
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(39);++numberNoResult;
            }
        }
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(4);m_onlyBoolValues = onlyBoolValues;
        m_onlyIntValues = onlyIntValues;
        m_numberNoResult = numberNoResult;
        double min = m_statistics.getMin();
        double max = m_statistics.getMax();
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(5);if ((! noAutoScaleHisto) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(7) && false))
        {
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(6);histoMin = min;
            histoMax = max;
        }
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(8);double diff = histoMax - histoMin;
        int maxBins = 20;
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(9);if ((onlyIntValues) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(11) && false))
        {
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(10);int step = Math.max(1, (int)(diff / maxBins + 1));
            m_histogram = new Histogram(histoMin, histoMax, step);
        }
        else
            {$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(21);m_histogram = new Histogram(histoMin, histoMax, diff / maxBins);}
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(12);for (int i = 0; (i < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(14) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(13);String value = table.get(command, i);
            $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(16);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(18) && false))
                {$qualityscroll_cover_jacov_probe_172cfdbf5ceea02(17);continue;}
            try
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(19);m_histogram.add(Double.parseDouble(value));
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(20);continue;
            }
        }
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(15);m_histoTable = TableUtil.fromHistogram(m_histogram, command);
    }

    public int getCount()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(41);return m_statistics.getCount();
    }

    public double getError()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(42);return m_statistics.getError();
    }

    public double getDeviation()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(43);return m_statistics.getDeviation();
    }

    public double getMax()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(44);return m_statistics.getMax();
    }

    public double getMaxError(int n)
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(45);return m_statistics.getMaxError(n);
    }

    public double getMean()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(46);return m_statistics.getMean();
    }

    public double getMin()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(47);return m_statistics.getMin();
    }

    public double getSum()
    {
        $qualityscroll_cover_jacov_probe_172cfdbf5ceea02(48);return m_statistics.getSum();
    }
}
