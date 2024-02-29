/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GameTreeJunction.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

class GameTreeJunction
    extends JComponent
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameTreeJunction.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2845838060588844300L,/* translation unit id   */ -4125484859376739301L,/* timestamp             */ 1709177902076L,/* source file name      */ "GameTreeJunction.java",/* probe size            */ 5);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameTreeJunction(int[] childrenDy, GameTreePanel gameTreePanel)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(0);m_gameTreePanel = gameTreePanel;
        m_childrenDy = childrenDy;
        setOpaque(false);
        setFocusable(false);
        setFocusTraversalKeysEnabled(false);
        int fullSize = m_gameTreePanel.getNodeFullSize();
        int lastDy = childrenDy[childrenDy.length - 1];
        setPreferredSize(new Dimension(fullSize, lastDy));
    }

    @Override
	public void paintComponent(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(1);int size = m_gameTreePanel.getNodeSize();
        int fullSize = m_gameTreePanel.getNodeFullSize();
        int halfSize = size / 2;
        graphics.setColor(COLOR_GRID);
        int lastDy = m_childrenDy[m_childrenDy.length - 1];
        graphics.drawLine(halfSize, 0, halfSize, lastDy - fullSize);
        $qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(2);for (int i = 1; (i < m_childrenDy.length) ? true : (!$qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(4) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_c6bf5560ce98dc1b(3);int y = m_childrenDy[i] - fullSize;
            graphics.drawLine(halfSize, y, size, y + halfSize);
            graphics.drawLine(size, y + halfSize, fullSize, y + halfSize);
        }
    }

    private final int[] m_childrenDy;

    private final GameTreePanel m_gameTreePanel;

    private static final Color COLOR_GRID = new Color(148, 148, 148);
}
