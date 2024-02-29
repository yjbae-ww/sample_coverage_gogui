/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Plot.java

package net.sf.gogui.tools.statistics;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import net.sf.gogui.gui.GuiUtil;
import net.sf.gogui.util.Table;
import net.sf.gogui.util.TableUtil;

/** Produce a PNG plot from table data. */
public class Plot
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Plot.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8745653256727078497L,/* translation unit id   */ 4603901250874437249L,/* timestamp             */ 1709177903602L,/* source file name      */ "Plot.java",/* probe size            */ 205);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Plot(int imgWidth, int imgHeight, Color color, int precision)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(0);m_precision = precision;
        m_color = color;
        m_imgWidth = imgWidth;
        m_imgHeight = imgHeight;
    }

    public void plot(File file, Table table, String columnX, String columnY,
                     String errorColumn)
        throws IOException
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(1);int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage image
            = new BufferedImage(m_imgWidth, m_imgHeight, type);
        m_graphics2D = image.createGraphics();
        GuiUtil.setAntiAlias(m_graphics2D);
        Font font = m_graphics2D.getFont();
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(2);if ((font != null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(4) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(3);font = font.deriveFont((float)(font.getSize() * 0.8));
            m_graphics2D.setFont(font);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(5);m_metrics = m_graphics2D.getFontMetrics();
        m_fontHeight = m_metrics.getHeight();
        m_left = 4 * m_fontHeight;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(6);if ((m_title == null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(8) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(7);m_top = (int)(m_fontHeight * 0.5);}
        else
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(10);m_top = (int)(m_fontHeight * 1.7);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(9);m_right = m_imgWidth - (int)(m_fontHeight * 0.5);
        m_bottom = m_imgHeight - (int)(m_fontHeight * 1.5);
        m_width = m_right - m_left;
        m_height = m_bottom - m_top;
        initScale(table, columnX, columnY);
        drawBackground();
        drawGrid();
        drawData(table, columnX, columnY, errorColumn, m_withBars);
        m_graphics2D.dispose();
        ImageIO.write(image, "png", file);
    }

    /** Set number format for x-axis.
        @param format The format. */
    public void setFormatX(DecimalFormat format)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(11);m_formatX = format;
    }

    /** Set number format for y-axis.
        @param format The format. */
    public void setFormatY(DecimalFormat format)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(12);m_formatY = format;
    }

    /** Set plot style to bars.
        Default is plotting points connected by lines.
        @param barWidth The width of each bar. */
    public void setPlotStyleBars(double barWidth)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(13);m_withBars = true;
        m_barWidth = barWidth;
    }

    /** Don't connect plotted points with lines. */
    public void setPlotStyleNoLines()
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(14);m_noLines = true;
    }

    /** Disable drawing the zero axis for the y-coordinates. */
    public void setNoPlotYZero()
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(15);m_plotYZero = false;
    }

    /** Enable drawing of solid lines at certain x-intervals.
        NOTE: The new implementation does no longer use solid lines, but
        changes white and gray background color at the solid line interval.
        @param solidLineInterval The interval for the solid lines. */
    public void setSolidLineInterval(double solidLineInterval)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(16);m_solidLineInterval = solidLineInterval;
        m_useSolidLineInterval = true;
    }

    /** Set x-label intervals.
        By default, every x-tic (grid line) gets an x-label.
        NOTE: Misleading name, should be tics per x-label.
        @param xLabelPerTic The number of tics per x-label. */
    public void setXLabelPerTic(int xLabelPerTic)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(17);m_xLabelPerTic = xLabelPerTic;
    }

    /** Plot only x labels for 0 and 1. */
    public void setXLabelsBool()
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(18);m_xLabelsBool = true;
        setXMin(-5);
        setXMax(5);
        setXTics(1);
    }

    /** Set maximum x value.
        @param max The maximum. */
    public void setXMax(double max)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(19);m_maxX = max;
        m_autoXMax = false;
    }

    /** Set minimum x value.
        @param min The minimum. */
    public void setXMin(double min)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(20);m_minX = min;
        m_autoXMin = false;
    }

    /** Set x-tics.
        Sets the grid line distance for the x-axis.
        @param tics The distance. */
    public void setXTics(double tics)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(21);m_xTics = tics;
        m_autoXTics = false;
    }

    /** Set maximum y value.
        @param max The maximum. */
    public void setYMax(double max)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(22);m_maxY = max;
        m_autoYMax = false;
    }

    /** Set minimum x value.
        @param min The minimum. */
    public void setYMin(double min)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(23);m_minY = min;
        m_autoYMin = false;
    }

    /** Set y-tics.
        Sets the grid line distance for the y-axis.
        @param tics The distance. */
    public void setYTics(double tics)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(24);m_yTics = tics;
        m_autoYTics = false;
    }

    /** Set plot title.
        @param title The title. */
    public void setTitle(String title)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(25);m_title = title;
    }

    private boolean m_autoXMax = true;

    private boolean m_autoXMin = true;

    private boolean m_autoXTics = true;

    private boolean m_autoYMin = true;

    private boolean m_autoYMax = true;

    private boolean m_autoYTics = true;

    private boolean m_noLines = false;

    private boolean m_onlyBoolValues;

    private boolean m_onlyIntValuesX;

    private boolean m_onlyIntValuesY;

    private boolean m_plotYZero = true;

    private boolean m_useSolidLineInterval = false;

    private boolean m_withBars;

    private boolean m_xLabelsBool;

    private int m_fontHeight;

    private int m_bottom;

    private int m_height;

    private final int m_imgHeight;

    private final int m_imgWidth;

    private int m_left;

    private final int m_precision;

    private int m_right;

    private int m_top;

    private int m_width;

    private int m_xLabelPerTic = 1;

    private double m_barWidth;

    private double m_minX;

    private double m_maxX;

    private double m_minY;

    private double m_maxY;

    private double m_solidLineInterval;

    private double m_xRange;

    private double m_xTics;

    private double m_xTicsMin;

    private double m_yRange;

    private double m_yTics;

    private double m_yTicsMin;

    private final Color m_color;

    private DecimalFormat m_formatX;

    private DecimalFormat m_formatY;

    private FontMetrics m_metrics;

    private Graphics2D m_graphics2D;

    private String m_title;

    private void drawBackground()
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(26);m_graphics2D.setColor(Color.decode("#e0e0e0"));
        m_graphics2D.fillRect(0, 0, m_imgWidth, m_imgHeight);
        m_graphics2D.setColor(Color.WHITE);
        m_graphics2D.fillRect(m_left, m_top, m_width, m_height);
        m_graphics2D.setColor(Color.BLACK);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(27);if ((m_title != null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(29) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(28);int width = m_metrics.stringWidth(m_title) + 10;
            int height = (int)(m_fontHeight * 1.4);
            int x = m_left + (m_width - width) / 2;
            int y = (m_top - height) / 2;
            m_graphics2D.setColor(Color.decode("#ffffe1"));
            m_graphics2D.fillRect(x, y, width, height);
            m_graphics2D.setColor(Color.DARK_GRAY);
            m_graphics2D.drawRect(x, y, width, height);
            drawString(m_title, m_left + m_width / 2, m_top / 2);
        }
    }

    private void drawData(Table table, String columnX, String columnY,
                          String errorColumn, boolean withBars)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(30);m_graphics2D.setColor(m_color);
        Point last = null;
        int barWidthPixels = getPoint(m_barWidth, 0).x
            - getPoint(0, 0).x - 2;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(31);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(33) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(32);try
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(34);double x = table.getDouble(columnX, row);
                double y = table.getDouble(columnY, row);
                Point point = getPoint(x, y);
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(35);if ((withBars) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(37) && false))
                {
                    $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(36);Point bottom = getPoint(x, 0);
                    m_graphics2D.fillRect(point.x - barWidthPixels / 2 + 1,
                                          point.y,
                                          barWidthPixels,
                                          bottom.y - point.y);
                }
                else {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(45);if ((last != null && ! m_noLines) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(47) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(46);m_graphics2D.drawLine(last.x, last.y, point.x, point.y);}}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(38);if ((errorColumn != null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(40) && false))
                {
                    $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(39);double err = table.getDouble(errorColumn, row);
                    Point top = getPoint(x, y + err);
                    Point bottom = getPoint(x, y - err);
                    m_graphics2D.drawLine(top.x, top.y, bottom.x, bottom.y);
                }
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(41);if ((! withBars) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(43) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(42);m_graphics2D.fillRect(point.x - 1, point.y - 1, 3, 3);}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(44);last = point;
            }
            catch (Table.InvalidElement e)
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(48);last = null;
            }
            catch (Table.InvalidLocation e)
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(49);last = null;
            }
        }
    }

    private void drawGrid()
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(50);Stroke oldStroke = m_graphics2D.getStroke();
        Stroke dottedStroke
            = new BasicStroke(1f, BasicStroke.CAP_ROUND,
                              BasicStroke.JOIN_ROUND, 1f, new float[] {2f},
                              0f);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(51);if ((m_useSolidLineInterval) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(53) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(52);double min =
                (int)(m_xTicsMin / m_solidLineInterval) * m_solidLineInterval;
            int n = 0;
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(54);for (double x = min; (x < m_maxX) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(56) && false); x += m_solidLineInterval, ++n)
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(55);Point bottom = getPoint(x, m_minY);
                Point top = getPoint(x, m_maxY);
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(91);if ((n % 2 == 0) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(93) && false))
                {
                    $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(92);m_graphics2D.setColor(Color.decode("#f0f0f0"));
                    Point right = getPoint(x + m_solidLineInterval, m_maxY);
                    m_graphics2D.fillRect(top.x, top.y,
                                          Math.min(right.x - top.x,
                                                   m_right - top.x),
                                          bottom.y - top.y);
                }
            }
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(57);m_graphics2D.setStroke(dottedStroke);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(58);for (double x = m_xTicsMin; (x < m_maxX) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(60) && false); x += m_xTics)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(59);Point bottom = getPoint(x, m_minY);
            Point top = getPoint(x, m_maxY);
            m_graphics2D.setColor(Color.LIGHT_GRAY);
            m_graphics2D.drawLine(top.x, top.y, bottom.x, bottom.y);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(61);m_graphics2D.setStroke(oldStroke);
        m_graphics2D.setStroke(dottedStroke);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(62);for (double y = m_yTicsMin; (y < m_maxY) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(64) && false); y += m_yTics)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(63);Point left = getPoint(m_minX, y);
            Point right = getPoint(m_maxX, y);
            m_graphics2D.setColor(Color.LIGHT_GRAY);
            m_graphics2D.drawLine(left.x, left.y, right.x, right.y);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(65);m_graphics2D.setStroke(oldStroke);
        m_graphics2D.setColor(Color.GRAY);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(66);if ((m_minX <= 0 && m_maxX >= 0) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(68) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(67);Point top = getPoint(0, m_minY);
            Point bottom = getPoint(0, m_maxY);
            m_graphics2D.drawLine(top.x, top.y, bottom.x, bottom.y);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(69);if ((m_minY <= 0 && m_maxY >= 0) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(71) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(70);Point left = getPoint(m_minX, 0);
            Point right = getPoint(m_maxX, 0);
            m_graphics2D.drawLine(left.x, left.y, right.x, right.y);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(72);if ((m_formatX == null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(74) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(73);m_formatX = getFormat(m_onlyIntValuesX);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(75);if ((m_formatY == null) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(77) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(76);m_formatY = getFormat(m_onlyIntValuesY);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(78);for (double x = m_xTicsMin; (x < m_maxX) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(80) && false); x += m_xLabelPerTic * m_xTics)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(79);if ((m_xLabelsBool && Math.round(x) != 0 && Math.round(x) != 1) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(89) && false))
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(88);continue;}
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(90);Point bottom = getPoint(x, m_minY);
            String label;
            label = m_formatX.format(x);
            m_graphics2D.setColor(Color.GRAY);
            m_graphics2D.drawLine(bottom.x, bottom.y, bottom.x, bottom.y + 3);
            m_graphics2D.setColor(Color.BLACK);
            drawString(label, bottom.x,
                       m_bottom + (m_imgHeight - m_bottom) / 2);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(81);for (double y = m_yTicsMin; (y < m_maxY) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(83) && false); y += m_yTics)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(82);if ((! m_plotYZero && Math.round(y) == 0) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(86) && false))
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(85);continue;}
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(87);Point point = getPoint(m_minX, y);
            String label;
            label = m_formatY.format(y);
            m_graphics2D.setColor(Color.GRAY);
            m_graphics2D.drawLine(point.x, point.y, point.x - 3, point.y);
            m_graphics2D.setColor(Color.BLACK);
            drawStringRightAlign(label, m_left - 5, point.y);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(84);m_graphics2D.setColor(Color.LIGHT_GRAY);
        m_graphics2D.drawRect(m_left, m_top, m_width, m_height);
        m_graphics2D.setColor(Color.GRAY);
        m_graphics2D.drawLine(m_left, m_top, m_left, m_bottom);
        m_graphics2D.drawLine(m_left, m_bottom, m_right, m_bottom);
        m_graphics2D.setStroke(oldStroke);
    }

    private void drawString(String string, int x, int y)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(94);FontMetrics metrics = m_graphics2D.getFontMetrics();
        int width = metrics.stringWidth(string);
        int height = m_fontHeight;
        m_graphics2D.drawString(string, x - width / 2, y + height / 2);
    }

    private void drawStringRightAlign(String string, int x, int y)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(95);FontMetrics metrics = m_graphics2D.getFontMetrics();
        int width = metrics.stringWidth(string);
        int height = m_fontHeight;
        m_graphics2D.drawString(string, x - width, y + height / 2);
    }

    private DecimalFormat getFormat(boolean onlyIntValues)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(96);DecimalFormat format = new DecimalFormat();
        format.setGroupingUsed(false);
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(97);if ((onlyIntValues) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(99) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(98);format.setMaximumFractionDigits(0);}
        else
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(101);format.setMaximumFractionDigits(m_precision);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(100);return format;
    }

    private Point getPoint(double x, double y)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(102);int intX = (int)(m_left + (x - m_minX) / m_xRange * m_width);
        int intY = (int)(m_bottom - (y - m_minY) / m_yRange * m_height);
        return new Point(intX, intY);
    }

    /** Find tics interval.
        Tries to respect maxNumberTics, as long as there are at least two
        visible tics. */
    private double getTics(double range, int maxNumberTics)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(103);maxNumberTics = Math.max(maxNumberTics, 2);
        double maxTics = range / 2.1; // Make sure 2 tics are visible
        double tics = 1;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(104);if ((range / maxNumberTics < 1) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(106) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(105);while ((range / (tics / 2) < maxNumberTics || tics > maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(108) && false))
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(107);tics /= 2;
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(110);if ((range / (tics / 2) > maxNumberTics && tics < maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(112) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(111);break;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(113);tics /= 2;
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(114);if ((range / (tics / 2.5) > maxNumberTics && tics < maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(116) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(115);break;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(117);tics /= 2.5;
            }
        }
        else
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(118);while ((range / tics > maxNumberTics && tics * 2 < maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(120) && false))
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(119);tics *= 2;
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(121);if ((range / tics <= maxNumberTics || tics * 2.5 > maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(123) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(122);break;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(124);tics *= 2.5;
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(125);if ((range / tics <= maxNumberTics || tics * 2 > maxTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(127) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(126);break;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(128);tics *= 2;
            }
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(109);return tics;
    }

    private double getTicsMin(double tics, double min)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(129);double result = (int)(min / tics) * tics;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(130);if ((result < min) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(132) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(131);result += tics;}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(133);return result;
    }

    private void initScale(Table table, String columnX, String columnY)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(134);double minX = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;
        m_onlyBoolValues = true;
        m_onlyIntValuesX = true;
        m_onlyIntValuesY = true;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(135);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(137) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(136);try
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(139);String xValue = table.get(columnX, row);
                String yValue = table.get(columnY, row);
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(140);if ((xValue == null || yValue == null
                    || ! TableUtil.isNumberValue(yValue)) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(142) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(141);continue;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(143);if ((! TableUtil.isBoolValue(yValue)) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(145) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(144);m_onlyBoolValues = false;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(146);if ((! TableUtil.isIntValue(xValue)) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(148) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(147);m_onlyIntValuesX = false;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(149);if ((! TableUtil.isIntValue(yValue)) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(151) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(150);m_onlyIntValuesY = false;}
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(152);double x = Double.parseDouble(xValue);
                double y = Double.parseDouble(yValue);
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            catch (Table.InvalidLocation e)
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(153);
            }
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(138);initScaleX(minX, maxX);
        initScaleY(minY, maxY);
    }

    private void initScaleX(double min, double max)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(154);if ((m_autoXMin) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(156) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(155);m_minX = min - 0.05 * (max - min);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(157);if ((m_autoXMax) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(159) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(158);m_maxX = max + 0.05 * (max - m_minX);}
        // Try to inlude 0 in plot
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(160);if ((m_minX > 0 && m_minX < 0.3 * m_maxX) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(162) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(161);m_minX = 0;}
        // Avoid empty ranges
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(163);if ((m_maxX - m_minX < Double.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(165) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(164);m_minX -= 1.1;
            m_maxX += 1.1;
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(166);m_xRange = m_maxX - m_minX;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(167);if ((m_autoXTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(169) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(168);double absMax = Math.max(Math.abs(m_minX), Math.abs(m_maxX));
            final double log10 = Math.log(10);
            int maxLength = (int)(Math.log(absMax) / log10) + m_precision + 3;
            int maxPixels = (int)(maxLength * (0.7 * m_fontHeight));
            int numberTics = m_width / maxPixels;
            m_xTics = getTics(m_xRange, numberTics);
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(170);if ((m_onlyIntValuesX) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(172) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(171);m_xTics = Math.max(1, m_xTics);}
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(173);m_xTicsMin = getTicsMin(m_xTics, m_minX);
    }

    private void initScaleY(double min, double max)
    {
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(174);if ((m_autoYMin) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(176) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(175);if ((m_onlyBoolValues) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(178) && false))
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(177);m_minY = 0;}
            else
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(204);m_minY = min;}
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(179);if ((m_autoYMax) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(181) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(180);if ((m_onlyBoolValues) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(183) && false))
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(182);m_maxY = 1.1;}
            else
                {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(203);m_maxY = max + 0.05 * (max - m_minY);}
        }
        // Try to inlude 0 in plot
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(184);if ((m_autoYMin && m_minY > 0 && m_minY < 0.3 * m_maxY) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(186) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(185);m_minY = 0;}
        // Avoid empty ranges
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(187);if ((m_maxY - m_minY < Double.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(189) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(188);m_minY -= 1.1;
            m_maxY += 1.1;
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(190);m_yRange = m_maxY - m_minY;
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(191);if ((m_autoYTics) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(193) && false))
        {
            $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(192);if ((m_onlyBoolValues) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(195) && false))
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(194);m_yTics = 1;
                m_yTicsMin = 0;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(199);int maxNumberTics = (int)(m_height / (1.5 * m_fontHeight));
                m_yTics = getTics(m_yRange, maxNumberTics);
                $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(200);if ((m_onlyIntValuesY) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(202) && false))
                    {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(201);m_yTics = Math.max(1, m_yTics);}
            }
        }
        $qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(196);if ((! m_onlyBoolValues) ? true : (!$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(198) && false))
            {$qualityscroll_cover_jacov_probe_3fe457cb8f58ee81(197);m_yTicsMin = getTicsMin(m_yTics, m_minY);}
    }
}
