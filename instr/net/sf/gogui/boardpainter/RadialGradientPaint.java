/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// RadialGradientPaint.java

package net.sf.gogui.boardpainter;

import java.awt.Color;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

/** Creates a PaintContext for a radial gradient. */
public class RadialGradientPaint
    implements Paint
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = RadialGradientPaint.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 678222566319954047L,/* translation unit id   */ 928539849052441625L,/* timestamp             */ 1709177899694L,/* source file name      */ "RadialGradientPaint.java",/* probe size            */ 11);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ce2d612b690cc19(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Create a radial gradient paint.
        @param center The center point.
        @param radius1 The radius along the first axis of the ellipse.
        @param radius2 The radius along the second axis of the ellipse.
        @param focus Focus shift away from the center along second radius
        normalized to interval between zero and one.
        @param color1 First color.
        @param color2 Second color. */
    public RadialGradientPaint(Point2D center, Point2D radius1,
                               Point2D radius2, double focus, Color color1,
                               Color color2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(0);m_center = center;
        m_radius1 = radius1;
        m_radius2 = radius2;
        m_focus = focus;
        m_color1 = color1;
        m_color2 = color2;
        int alpha1 = color1.getAlpha();
        int alpha2 = color2.getAlpha();
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(1);if (((alpha1 & alpha2) == 0xff) ? true : (!$qualityscroll_cover_jacov_probe_ce2d612b690cc19(3) && false))
            {$qualityscroll_cover_jacov_probe_ce2d612b690cc19(2);m_transparency = OPAQUE;}
        else
            {$qualityscroll_cover_jacov_probe_ce2d612b690cc19(4);m_transparency = TRANSLUCENT;}
    }

    @Override
	public PaintContext createContext(ColorModel colorModel,
                                      Rectangle deviceBounds,
                                      Rectangle2D userBounds,
                                      AffineTransform xform,
                                      RenderingHints hints)
    {
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(5);Point2D transformedCenter = xform.transform(m_center, null);
        Point2D transformedRadius1 = xform.deltaTransform(m_radius1, null);
        Point2D transformedRadius2 = xform.deltaTransform(m_radius2, null);
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(6);if ((m_cachedContext != null
            && transformedCenter.equals(m_transformedCenter)
            && transformedRadius1.equals(m_transformedRadius1)
            && transformedRadius2.equals(m_transformedRadius2)) ? true : (!$qualityscroll_cover_jacov_probe_ce2d612b690cc19(8) && false))
            {$qualityscroll_cover_jacov_probe_ce2d612b690cc19(7);return m_cachedContext;}
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(9);m_transformedCenter = (Point2D)transformedCenter.clone();
        m_transformedRadius1 = (Point2D)transformedRadius1.clone();
        m_transformedRadius2 = (Point2D)transformedRadius2.clone();
        m_cachedContext =
            new RadialGradientContext(transformedCenter, transformedRadius1,
                                      transformedRadius2, m_focus,
                                      m_color1, m_color2);
        return m_cachedContext;
    }

    @Override
	public int getTransparency()
    {
        $qualityscroll_cover_jacov_probe_ce2d612b690cc19(10);return m_transparency;
    }

    private final int m_transparency;

    private Point2D m_transformedCenter;

    private Point2D m_transformedRadius1;

    private Point2D m_transformedRadius2;

    private RadialGradientContext m_cachedContext;

    private final double m_focus;

    private final Point2D m_center;

    private final Point2D m_radius1;

    private final Point2D m_radius2;

    private final Color m_color1;

    private final Color m_color2;
}
