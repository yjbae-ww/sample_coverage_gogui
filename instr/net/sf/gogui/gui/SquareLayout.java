/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// SquareLayout.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/** Layout manager for 1:1 aspect ratio.
    Expects that the container to layout has only a single child component. */
public class SquareLayout
    implements LayoutManager
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SquareLayout.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -5820613630005129296L,/* translation unit id   */ -3347783606124103180L,/* timestamp             */ 1709177902770L,/* source file name      */ "SquareLayout.java",/* probe size            */ 7);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Unused.
        Does nothing, because this class will automatically layout the single
        child component of a container.
        @param name Unused
        @param comp Unused */
    @Override
	public void addLayoutComponent(String name, Component comp)
    {$qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(0);
    }

    /** Layout container.
        Contains an assertion that the container has exactly one child.
        This child is layout in the center of the container with  the maximum
        square size that fits into the container.
        @param parent The container to layout */
    @Override
	public void layoutContainer(Container parent)
    {
        $qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(1);assert parent.getComponentCount() == 1;
        Dimension size = parent.getSize();
        Insets insets = parent.getInsets();
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        int len = ((size.width < size.height) ? ($qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(2) || true) : (!$qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(3) && false)) ? size.width : size.height;
        int x = (size.width - len) / 2;
        int y = (size.height - len) / 2;
        parent.getComponent(0).setBounds(x + insets.left, y + insets.top,
                                         len, len);
    }

    /** Return minimum layout size.
        Contains an assertion that the container has exactly one child.
        @param parent The container to layout.
        @return The minimum size of the child. */
    @Override
	public Dimension minimumLayoutSize(Container parent)
    {
        $qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(4);assert parent.getComponentCount() == 1;
        return parent.getComponent(0).getMinimumSize();
    }

    /** Return preferred layout size.
        Contains an assertion that the container has exactly one child.
        @param parent The container to layout.
        @return The preferred size of the child. */
    @Override
	public Dimension preferredLayoutSize(Container parent)
    {
        $qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(5);assert parent.getComponentCount() == 1;
        return parent.getComponent(0).getPreferredSize();
    }

    /** Unused.
        Does nothing, because this class will automatically layout the single
        child component of a container.
        @param comp Unused */
    @Override
	public void removeLayoutComponent(Component comp)
    {$qualityscroll_cover_jacov_probe_d18a488c2c18b9f4(6);
    }
}
