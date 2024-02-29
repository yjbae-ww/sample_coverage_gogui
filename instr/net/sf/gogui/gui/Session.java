/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// Session.java

package net.sf.gogui.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import net.sf.gogui.util.PrefUtil;
import net.sf.gogui.util.StringUtil;

/** Utilities for saving and restoring windows between session.
    Window sizes and locations are saved separately for different Go board
    sizes.
*/
public final class Session
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Session.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 9121725247542232429L,/* translation unit id   */ 7091502713555495090L,/* timestamp             */ 1709177902744L,/* source file name      */ "Session.java",/* probe size            */ 95);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_626a14254531a8b2(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param path Absolute path for saving the preferences using
        java.util.prefs.
    */
    public Session(String path)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(0);assert ! StringUtil.isEmpty(path);
        m_path = path;
    }

    public boolean isVisible(String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(1);Preferences prefs = getNode(null);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(2);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(4) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(3);return false;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(5);return prefs.getBoolean("show-" + name, false);
    }

    public void restoreLocation(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(6);Preferences prefs = getNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(7);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(9) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(8);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(10);int x = prefs.getInt("x", Integer.MIN_VALUE);
        int y = prefs.getInt("y", Integer.MIN_VALUE);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(11);if ((x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(13) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(12);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(14);setLocationChecked(window, x, y);
    }

    public void restoreLocation(Window window, Window owner, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(15);int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        Preferences prefs = getNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(16);if ((prefs != null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(18) && false))
        {
            $qualityscroll_cover_jacov_probe_626a14254531a8b2(17);x = prefs.getInt("x", Integer.MIN_VALUE);
            y = prefs.getInt("y", Integer.MIN_VALUE);
        }
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(19);if ((x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(21) && false))
        {
            $qualityscroll_cover_jacov_probe_626a14254531a8b2(20);if ((! window.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(23) && false))
                // use a platform-dependent default (setLocationByPlatform can
                // only be used, if window not already visible)
                {$qualityscroll_cover_jacov_probe_626a14254531a8b2(22);window.setLocationByPlatform(true);}
            $qualityscroll_cover_jacov_probe_626a14254531a8b2(24);return;
        }
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(25);Point ownerLocation = owner.getLocation();
        setLocationChecked(window, x + ownerLocation.x,  y + ownerLocation.y);
    }

    public void restoreSize(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(26);Preferences prefs = getNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(27);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(29) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(28);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(30);int x = prefs.getInt("x", Integer.MIN_VALUE);
        int y = prefs.getInt("y", Integer.MIN_VALUE);
        int width = prefs.getInt("width", Integer.MIN_VALUE);
        int height = prefs.getInt("height", Integer.MIN_VALUE);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(31);if ((x == Integer.MIN_VALUE || y == Integer.MIN_VALUE
            || width == Integer.MIN_VALUE || height == Integer.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(33) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(32);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(34);setSizeChecked(window, width, height);
        // Restore location after size, because some window managers move a
        // window, if the size changes in a way that it would not be fully
        // visible
        setLocationChecked(window, x, y);
    }

    public void restoreSize(Window window, Window owner, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(35);int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        Preferences prefs = getNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(36);if ((prefs != null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(38) && false))
        {
            $qualityscroll_cover_jacov_probe_626a14254531a8b2(37);width = prefs.getInt("width", Integer.MIN_VALUE);
            height = prefs.getInt("height", Integer.MIN_VALUE);
        }
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(39);if ((width == Integer.MIN_VALUE || height == Integer.MIN_VALUE) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(41) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(40);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(42);setSizeChecked(window, width, height);
        // Restore location after size, because some window managers move a
        // window, if the size changes in a way that it would not be fully
        // visible
        restoreLocation(window, owner, name);
    }

    public void saveLocation(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(43);if ((isFrameSpecialMode(window)) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(45) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(44);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(46);Preferences prefs = createNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(47);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(49) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(48);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(50);Point location = window.getLocation();
        prefs.putInt("x", location.x);
        prefs.putInt("y", location.y);
    }

    public void saveLocation(Window window, Window owner, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(51);if ((isFrameSpecialMode(window)) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(53) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(52);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(54);Preferences prefs = createNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(55);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(57) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(56);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(58);Point location = window.getLocation();
        Point ownerLocation = owner.getLocation();
        prefs.putInt("x", location.x - ownerLocation.x);
        prefs.putInt("y", location.y - ownerLocation.y);
    }

    public void saveSize(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(59);if ((isFrameSpecialMode(window) || ! window.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(61) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(60);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(62);saveLocation(window, name);
        saveWidthHeight(window, name);
    }

    public void saveSize(Window window, Window owner, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(63);if ((isFrameSpecialMode(window) || ! window.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(65) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(64);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(66);saveLocation(window, owner, name);
        saveWidthHeight(window, name);
    }

    public void saveVisible(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(67);boolean isVisible = (window != null && window.isVisible());
        Preferences prefs = createNode(null);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(68);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(70) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(69);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(71);prefs.putBoolean("show-" + name, isVisible);
    }

    private final String m_path;

    private Preferences createNode(String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(72);return PrefUtil.createNode(getPath(name));
    }

    private Preferences getNode(String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(73);return PrefUtil.getNode(getPath(name));
    }

    private String getPath(String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(74);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(76) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(75);return m_path;}
        else
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(77);return m_path + "/" + name;}
    }

    private static Dimension getScreenSize()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(78);return Toolkit.getDefaultToolkit().getScreenSize();
    }

    private static boolean isFrameSpecialMode(Window window)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(79);return (window instanceof JFrame
                && ! GuiUtil.isNormalSizeMode((JFrame)window));
    }

    private void saveWidthHeight(Window window, String name)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(80);Preferences prefs = createNode(name);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(81);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(83) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(82);return;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(84);Dimension size = window.getSize();
        prefs.putInt("width", size.width);
        prefs.putInt("height", size.height);
    }

    private void setLocationChecked(Window window, int x, int y)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(85);Dimension screenSize = getScreenSize();
        x = Math.max(0, x);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(86);if ((x > screenSize.width) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(88) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(87);x = 0;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(89);y = Math.max(0, y);
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(90);if ((y > screenSize.height) ? true : (!$qualityscroll_cover_jacov_probe_626a14254531a8b2(92) && false))
            {$qualityscroll_cover_jacov_probe_626a14254531a8b2(91);y = 0;}
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(93);window.setLocation(x, y);
    }

    private void setSizeChecked(Window window, int width, int height)
    {
        $qualityscroll_cover_jacov_probe_626a14254531a8b2(94);Dimension screenSize = getScreenSize();
        width = Math.min(width, screenSize.width);
        height = Math.min(height, screenSize.height);
        window.setSize(width, height);
        window.validate();
    }
}
