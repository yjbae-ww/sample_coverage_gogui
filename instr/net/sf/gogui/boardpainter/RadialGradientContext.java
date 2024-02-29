/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// RadialGradientContext.java

package net.sf.gogui.boardpainter;

import java.awt.Color;
import java.awt.PaintContext;
import java.awt.geom.Point2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/** Creates a raster with a radial color gradient. */
public class RadialGradientContext
    implements PaintContext
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = RadialGradientContext.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 501573903608127831L,/* translation unit id   */ 2995460215618166585L,/* timestamp             */ 1709177899673L,/* source file name      */ "RadialGradientContext.java",/* probe size            */ 20);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_299203320abc5f39(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Create a radial gradient context.
        @param center The center point.
        @param radius1 The radius along the first axis of the ellipse.
        @param radius2 The radius along the second axis of the ellipse.
        @param focus Focus shift away from the center along second radius
        normalized to interval between zero and one.
        @param color1 First color.
        @param color2 Second color. */
    public RadialGradientContext(Point2D center, Point2D radius1,
                                 Point2D radius2, double focus, Color color1,
                                 Color color2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_299203320abc5f39(0);m_center = center;
        m_radius1 = radius1;
        m_radius2 = radius2;
        m_length1 = radius1.distance(0, 0);
        m_length2 = radius2.distance(0, 0);
        m_focus = focus;
        m_red1 = color1.getRed();
        m_green1 = color1.getGreen();
        m_blue1 = color1.getBlue();
        m_alpha1 = color1.getAlpha();
        m_redDiff = color2.getRed() - m_red1;
        m_greenDiff = color2.getGreen() - m_green1;
        m_blueDiff = color2.getBlue() - m_blue1;
        m_alphaDiff = color2.getAlpha() - m_alpha1;
    }

    @Override
	public void dispose()
    {$qualityscroll_cover_jacov_probe_299203320abc5f39(1);
    }

    @Override
	public ColorModel getColorModel()
    {
        $qualityscroll_cover_jacov_probe_299203320abc5f39(2);return ColorModel.getRGBdefault();
    }

    @Override
	public Raster getRaster(int x, int y, int width, int height)
    {
        $qualityscroll_cover_jacov_probe_299203320abc5f39(3);if ((m_raster != null && x == m_x && y == m_y && width == m_width
            && height == m_height) ? true : (!$qualityscroll_cover_jacov_probe_299203320abc5f39(5) && false))
            {$qualityscroll_cover_jacov_probe_299203320abc5f39(4);return m_raster;}
        $qualityscroll_cover_jacov_probe_299203320abc5f39(6);m_x = x;
        m_y = y;
        m_height = height;
        m_width = width;
        ColorModel colorModel = getColorModel();
        m_raster = colorModel.createCompatibleWritableRaster(width, height);
        int[] data = new int[width * height * 4];
        int index = -1;
        $qualityscroll_cover_jacov_probe_299203320abc5f39(7);for (int j = 0; (j < height) ? true : (!$qualityscroll_cover_jacov_probe_299203320abc5f39(9) && false); ++j)
            {$qualityscroll_cover_jacov_probe_299203320abc5f39(8);for (int i = 0; (i < width) ? true : (!$qualityscroll_cover_jacov_probe_299203320abc5f39(12) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_299203320abc5f39(11);Point2D p = new Point2D.Double(x + i, y + j);
                Point2D d = getDifference(p, m_center);
                double distance1 = getScalarProduct(d, m_radius1) / m_length1;
                double ratio1 = Math.abs(distance1) / m_length1;
                double distance2 = getScalarProduct(d, m_radius2) / m_length2;
                double ratio2 = distance2 / m_length2;
                $qualityscroll_cover_jacov_probe_299203320abc5f39(13);if ((ratio2 > m_focus) ? true : (!$qualityscroll_cover_jacov_probe_299203320abc5f39(15) && false))
                    {$qualityscroll_cover_jacov_probe_299203320abc5f39(14);ratio2 = (ratio2 - m_focus) / (1.0 - m_focus);}
                else
                    {$qualityscroll_cover_jacov_probe_299203320abc5f39(17);ratio2 = (ratio2 - m_focus) / (-1.0 - m_focus);}
                $qualityscroll_cover_jacov_probe_299203320abc5f39(16);double ratio = Math.sqrt(ratio1 * ratio1 + ratio2 * ratio2);
                ratio = Math.min(ratio, 1.0);
                data[++index] = (int)(m_red1 + ratio * m_redDiff);
                data[++index] = (int)(m_green1 + ratio * m_greenDiff);
                data[++index] = (int)(m_blue1 + ratio * m_blueDiff);
                data[++index] = (int)(m_alpha1 + ratio * m_alphaDiff);
            }}
        $qualityscroll_cover_jacov_probe_299203320abc5f39(10);m_raster.setPixels(0, 0, width, height, data);
        return m_raster;
    }

    private final int m_red1;

    private final int m_redDiff;

    private final int m_green1;

    private final int m_greenDiff;

    private final int m_blue1;

    private final int m_blueDiff;

    private final int m_alpha1;

    private final int m_alphaDiff;

    private int m_x;

    private int m_y;

    private int m_height;

    private int m_width;

    private final double m_length1;

    private final double m_length2;

    private final double m_focus;

    private final Point2D m_center;

    private final Point2D m_radius1;

    private final Point2D m_radius2;

    private WritableRaster m_raster;

    private static Point2D getDifference(Point2D p1, Point2D p2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_299203320abc5f39(18);return new Point2D.Double(p1.getX() - p2.getX(),
                                  p1.getY() - p2.getY());
    }

    private static double getScalarProduct(Point2D p1, Point2D p2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_299203320abc5f39(19);return (p1.getX() * p2.getX() + p1.getY() * p2.getY());
    }
}
