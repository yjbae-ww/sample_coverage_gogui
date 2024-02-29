/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.display;

import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.gui.GuiUtil;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Display main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6600981757986305759L,/* translation unit id   */ -7280625954342997745L,/* timestamp             */ 1709177903266L,/* source file name      */ "Main.java",/* probe size            */ 19);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_9af60544d8e5710f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(0);String options[] = {
                "config:",
                "help",
                "laf:",
                "verbose",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_9af60544d8e5710f(3) && false))
            {
                $qualityscroll_cover_jacov_probe_9af60544d8e5710f(2);printUsage(System.out);
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_9af60544d8e5710f(6) && false))
            {
                $qualityscroll_cover_jacov_probe_9af60544d8e5710f(5);System.out.println("gogui-display " + Version.get());
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(7);boolean verbose = opt.contains("verbose");
            String lookAndFeel = opt.get("laf", null);
            ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(8);if ((arguments.size() > 1) ? true : (!$qualityscroll_cover_jacov_probe_9af60544d8e5710f(10) && false))
            {
                $qualityscroll_cover_jacov_probe_9af60544d8e5710f(9);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(11);String program = null;
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(12);if ((arguments.size() == 1) ? true : (!$qualityscroll_cover_jacov_probe_9af60544d8e5710f(14) && false))
                {$qualityscroll_cover_jacov_probe_9af60544d8e5710f(13);program = arguments.get(0);}
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(15);GuiUtil.initLookAndFeel(lookAndFeel);
            Display display = new Display(program, verbose);
            display.mainLoop(System.in, System.out);
            display.close();
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_9af60544d8e5710f(16);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_9af60544d8e5710f(17);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9af60544d8e5710f(18);String helpText =
            "Usage: gogui-display program\n" +
            "\n" +
            "-config       Config file\n" +
            "-help         Print help and exit\n" +
            "-laf          Set Swing look and feel\n" +
            "-verbose      Log GTP stream to stderr\n" +
            "-version      Print version and exit\n";
        out.print(helpText);
    }
}
