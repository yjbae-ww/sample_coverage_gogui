/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// MainWrapper.java

package net.sf.gogui.gogui;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import net.sf.gogui.util.ErrorMessage;

/** Wrapper for starting GoGui.
    Loads the main class with the reflection API to set Mac AWT and other
    properties before any AWT class is loaded. */
public final class MainWrapper
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = MainWrapper.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3657938663359515894L,/* translation unit id   */ 7251821085692709935L,/* timestamp             */ 1709177901125L,/* source file name      */ "MainWrapper.java",/* probe size            */ 9);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void main(String[] args) throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(0);System.setProperty("apple.awt.brushMetalLook", "true");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name",
                           "GoGui");
        // Use GDI rendering on Windows, there are repaint problems using
        // DDraw (last tested with Java 1.6 on Windows 7).
        // Also, using DDraw does not work well with Wine (http://winehq.com,
        // last tested versions 1.2.2 and 1.3.16) and Wine can be useful to
        // test the Windows installer for GoGui on Linux.
        System.setProperty("sun.java2d.noddraw", "true");
        GoGuiSettings settings;
        try
        {
            $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(1);settings =
                new GoGuiSettings(args,
                                  Class.forName("net.sf.gogui.gogui.GoGui"));
            $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(2);if ((settings.m_noStartup) ? true : (!$qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(4) && false))
                {$qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(3);return;}
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(6);System.err.println(e.getMessage());
            return;
        }
        catch (ClassNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(7);System.err.println(e.getMessage());
            return;
        }
        $qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(5);Class<?> mainClass = Class.forName("net.sf.gogui.gogui.Main");
        Class<?> settingsClass =
            Class.forName("net.sf.gogui.gogui.GoGuiSettings");
        Method mainMethod = mainClass.getMethod("main", settingsClass);
        assert (mainMethod.getModifiers() & Modifier.STATIC) != 0;
        assert mainMethod.getReturnType() == void.class;
        mainMethod.invoke(null, settings);
    }

    /** Make constructor unavailable; class is for namespace only. */
    private MainWrapper()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_64a3a4db0b66cc2f(8);
    }
}
