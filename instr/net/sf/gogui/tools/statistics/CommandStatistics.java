/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// CommandStatistics.java

package net.sf.gogui.tools.statistics;

import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.sf.gogui.util.Histogram;
import net.sf.gogui.util.Table;
import net.sf.gogui.util.TableUtil;

/** Collect GTP response statistics for a command. */
public final class CommandStatistics
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = CommandStatistics.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6251660872454493536L,/* translation unit id   */ -8120420498879805708L,/* timestamp             */ 1709177903527L,/* source file name      */ "CommandStatistics.java",/* probe size            */ 34);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8f4e7894817806f4(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public final boolean m_isBeginCommand;

    public final int m_maxMove;

    public final DecimalFormat m_format;

    public final PositionStatistics m_statisticsAll;

    public final PositionStatistics m_statisticsFinal;

    public final ArrayList<PositionStatistics> m_statisticsAtMove;

    public final Table m_tableAtMove;

    public CommandStatistics(String command, Table table, Table tableFinal,
                             File histoFile, File histoFileFinal,
                             Color color, int precision)
        throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(0);m_statisticsAll = new PositionStatistics(command, table, false, 0, 0);
        double min = m_statisticsAll.getMin();
        double max = m_statisticsAll.getMax();
        m_statisticsFinal
            = new PositionStatistics(command, tableFinal, true, min, max);
        m_statisticsAtMove = new ArrayList<PositionStatistics>();
        ArrayList<String> columnTitles = new ArrayList<String>();
        columnTitles.add("Move");
        columnTitles.add("Mean");
        columnTitles.add("Error");
        m_tableAtMove = new Table(columnTitles);
        Table tableAtMove;
        m_maxMove = (int)(TableUtil.getMax(table, "Move") + 1);
        boolean isBeginCommand = true;
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(1);for (int move = 1; (move <= m_maxMove) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(3) && false); ++move)
        {
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(2);tableAtMove = TableUtil.selectIntRange(table, "Move", move,
                                                    move);
            PositionStatistics statisticsAtMove
                = new PositionStatistics(command, tableAtMove, true, min,
                                         max);
            m_statisticsAtMove.add(statisticsAtMove);
            int count = statisticsAtMove.getCount();
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(11);if ((count > 0) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(13) && false))
            {
                $qualityscroll_cover_jacov_probe_8f4e7894817806f4(12);if ((move > 1) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(15) && false))
                    {$qualityscroll_cover_jacov_probe_8f4e7894817806f4(14);isBeginCommand = false;}
                $qualityscroll_cover_jacov_probe_8f4e7894817806f4(16);m_tableAtMove.startRow();
                m_tableAtMove.set("Move", move);
                m_tableAtMove.set("Mean", statisticsAtMove.getMean());
                m_tableAtMove.set("Error", statisticsAtMove.getError());
            }
        }
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(4);m_isBeginCommand = isBeginCommand;
        m_format = getFormat(precision, min, max);
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(5);if ((getCount() > 0) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(7) && false))
        {
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(6);Histogram histogram = m_statisticsAll.m_histogram;
            Table histoTable = TableUtil.fromHistogram(histogram, command);
            Plot plot = new Plot(200, 150, color, precision);
            setHistogramProperties(plot);
            plot.plot(histoFile, histoTable, command, "Count", null);
            histogram = m_statisticsFinal.m_histogram;
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(8);if ((m_statisticsFinal.getCount() > 0) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(10) && false))
            {
                $qualityscroll_cover_jacov_probe_8f4e7894817806f4(9);histoTable = TableUtil.fromHistogram(histogram, command);
                plot = new Plot(200, 150, color, precision);
                setHistogramProperties(plot);
                plot.plot(histoFileFinal, histoTable, command, "Count", null);
            }
        }
    }

    public int getCount()
    {
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(17);return m_statisticsAll.getCount();
    }

    public PositionStatistics getStatistics(int moveInterval)
    {
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(18);return m_statisticsAtMove.get(moveInterval);
    }

    public boolean onlyBoolValues()
    {
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(19);return m_statisticsAll.m_onlyBoolValues;
    }

    public void setHistogramProperties(Plot plot)
    {
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(20);Histogram histogram = m_statisticsAll.m_histogram;
        double step = histogram.getStep();
        plot.setPlotStyleBars(step);
        plot.setYMin(0);
        plot.setNoPlotYZero();
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(21);if ((onlyBoolValues()) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(23) && false))
        {
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(22);plot.setXLabelsBool();
        }
        else
        {
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(24);plot.setXMin(histogram.getMin() - step / 2);
            plot.setXMax(histogram.getMax() + step / 2);
            plot.setFormatX(m_format);
        }
    }

    private static DecimalFormat getFormat(int precision, double min,
                                           double max)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(25);DecimalFormat format = new DecimalFormat();
        double absMax = Math.max(Math.abs(min), Math.abs(max));
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(26);if ((absMax < 10000) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(28) && false))
        {
            $qualityscroll_cover_jacov_probe_8f4e7894817806f4(27);format.setMaximumFractionDigits(precision);
            format.setGroupingUsed(false);
            return format;
        }
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(29);StringBuilder pattern = new StringBuilder();
        pattern.append("0.");
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(30);for (int i = 0; (i < precision) ? true : (!$qualityscroll_cover_jacov_probe_8f4e7894817806f4(32) && false); ++i)
            {$qualityscroll_cover_jacov_probe_8f4e7894817806f4(31);pattern.append('#');}
        $qualityscroll_cover_jacov_probe_8f4e7894817806f4(33);pattern.append("E0");
        format.applyPattern(pattern.toString());
        return format;
    }
}
