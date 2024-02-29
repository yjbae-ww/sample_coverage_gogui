/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// Platform.java

package net.sf.gogui.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.URL;
import java.util.Locale;

/** Static utility functions for platform detection and platform-dependent
    behavior. */
public class Platform
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Platform.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2556528876619468046L,/* translation unit id   */ -4519357398012510928L,/* timestamp             */ 1709177904067L,/* source file name      */ "Platform.java",/* probe size            */ 72);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c14804641e6e3d30(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Handler for events from the Application Menu on MacOS. */
    public interface SpecialMacHandler
    {
        /** Handle about menu event.
            @return true if event was handled successfully. */
        boolean handleAbout();

        /** Handle open file event.
            @param filename name of file.
            @return true if event was handled successfully. */
        boolean handleOpenFile(String filename);

        /** Handle quit application event.
            @return true if event was handled successfully, false if quit
            should be aborted. */
        boolean handleQuit();
    }

    public static String getJavaRuntimeName()
    {$qualityscroll_cover_coverage_buffer_init();
        // java.runtime.name is not a standard property
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(0);String name = System.getProperty("java.runtime.name");
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(1);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(3) && false))
            {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(2);name = System.getProperty("java.vm.name");}
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(4);return name;
    }

    /** Return information on this computer.
        Returns host name and cpu information (if /proc/cpuinfo exists). */
    public static String getHostInfo()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(5);String info;
        try
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(6);info = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e)
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(20);info = "?";
        }
        try
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(7);if ((existsProcCpuinfo()) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(9) && false))
            {
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(8);String[] cmdArray = { "/bin/sh", "-c",
                                      "grep '^model name' /proc/cpuinfo" };
                String result = ProcessUtil.runCommand(cmdArray);
                int start = result.indexOf(':');
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(10);if ((start >= 0) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(12) && false))
                {
                    $qualityscroll_cover_jacov_probe_c14804641e6e3d30(11);info = info + " (";
                    int end = result.indexOf("\n");
                    $qualityscroll_cover_jacov_probe_c14804641e6e3d30(13);if ((end >= 0) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(15) && false))
                        {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(14);info = info + result.substring(start + 1, end).trim();}
                    else
                        {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(18);info = info + result.substring(start + 1).trim();}
                    $qualityscroll_cover_jacov_probe_c14804641e6e3d30(16);info = info + ")";
                }
            }
        }
        catch (IOException e)
        {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(19);
        }
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(17);return info;
    }

    /** Check if the platform is Mac OS X. */
    public static boolean isMac()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(21);return s_isMac;
    }

    /** Check if the platform is Unix. */
    public static boolean isUnix()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(22);return s_isUnix;
    }

    /** Check if the platform is Windows. */
    public static boolean isWindows()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(23);return s_isWindows;
    }

    /** Try to open a URL in en external browser.
        Tries /usr/bin/open if Platform.isMac(),
        rundll32 url.dll,FileProtocolHandler if Platform.isWindows(),
        and if isUnix() in this order:
        - xdg-open
        - kfmclient (if KDE is running)
        - firefox
        - mozilla
        - opera
        @param url URL to open.
        @return false if everything failed. */
    public static boolean openInExternalBrowser(URL url)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(24);if ((isMac()) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(26) && false))
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(25);String[] cmd = { "/usr/bin/open", url.toString() };
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(27);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(29) && false))
                {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(28);return true;}
        }
        else {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(31);if ((isWindows()) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(33) && false))
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(32);String[] cmd = { "rundll32", "url.dll,FileProtocolHandler",
                             url.toString() };
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(34);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(36) && false))
                {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(35);return true;}
        }
        else {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(37);if ((isUnix()) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(39) && false))
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(38);{
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(40);String[] cmd = { "xdg-open", url.toString() };
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(41);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(43) && false))
                    {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(42);return true;}
            }
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(44);if ((checkKDERunning()) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(46) && false))
            {
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(45);String[] cmd = { "kfmclient", "openURL", url.toString() };
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(47);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(49) && false))
                    {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(48);return true;}
            }
            {
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(50);String[] cmd = { "firefox", url.toString() };
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(51);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(53) && false))
                    {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(52);return true;}
            }
            {
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(54);String[] cmd = { "mozilla", url.toString() };
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(55);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(57) && false))
                    {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(56);return true;}
            }
            {
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(58);String[] cmd = { "opera", url.toString() };
                $qualityscroll_cover_jacov_probe_c14804641e6e3d30(59);if ((runProcess(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_c14804641e6e3d30(61) && false))
                    {$qualityscroll_cover_jacov_probe_c14804641e6e3d30(60);return true;}
            }
        }}}
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(30);return false;
    }

    /** Register handler for events from the Application Menu on MacOS.
        @param handler Handler to register. */
    public static void registerSpecialMacHandler(SpecialMacHandler handler)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(62);Object[] args = { handler };
            Class[] arglist = { Platform.SpecialMacHandler.class };
            String name = "net.sf.gogui.specialmac.RegisterSpecialMacHandler";
            Class<?> registerClass = Class.forName(name);
            Constructor constructor = registerClass.getConstructor(arglist);
            constructor.newInstance(args);
        }
        catch (Throwable e)
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(63);System.err.println("Could not register handler for Mac events." +
                               " (com.apple.eawt classes not found)");
        }
    }

    private static boolean s_isMac;

    private static boolean s_isUnix;

    private static boolean s_isWindows;

    static
    {
        // See http://developer.apple.com/technotes/tn2002/tn2110.html
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(71);String name = System.getProperty("os.name");
        s_isMac = name.toLowerCase(Locale.getDefault()).startsWith("mac os x");
        s_isUnix = (name.indexOf("nix") >= 0 || name.indexOf("nux") >= 0);
        s_isWindows = name.startsWith("Windows");
    }

    private static boolean checkKDERunning()
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(64);String[] cmdArray = { "dcop" };
            String result = ProcessUtil.runCommand(cmdArray);
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(65);return (result.indexOf("kicker") >= 0);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(66);return false;
        }
    }

    private static boolean existsProcCpuinfo()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c14804641e6e3d30(67);return new File("/proc/cpuinfo").exists();
    }

    private static boolean runProcess(String[] cmd)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(68);ProcessUtil.runProcess(cmd);
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(69);return true;
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_c14804641e6e3d30(70);return false;
        }
    }
}
