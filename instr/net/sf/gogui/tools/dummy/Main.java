/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.dummy;

import java.io.File;
import java.io.PrintStream;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Dummy main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1730587578635017519L,/* translation unit id   */ -3912749476897359776L,/* timestamp             */ 1709177903340L,/* source file name      */ "Main.java",/* probe size            */ 21);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Dummy main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(0);String options[] = {
                "config:",
                "help",
                "log:",
                "resign:",
                "srand:",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(3) && false))
            {
                $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(2);String helpText =
                    "Usage: gogui-dummy [options]\n" +
                    "\n" +
                    "-config    config file\n" +
                    "-help      display this help and exit\n" +
                    "-log file  log GTP stream to file\n" +
                    "-resign n  resign at n'th genmove\n" +
                    "-srand n   random seed\n" +
                    "-version   print version and exit\n";
                System.out.print(helpText);
                return;
            }
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(6) && false))
            {
                $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(5);System.out.println("gogui-dummy " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(7);PrintStream log = null;
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(8);if ((opt.contains("log")) ? true : (!$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(10) && false))
            {
                $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(9);File file = new File(opt.get("log"));
                log = new PrintStream(file);
            }
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(11);long randomSeed = 0;
            boolean useRandomSeed = false;
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(12);if ((opt.contains("srand")) ? true : (!$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(14) && false))
            {
                $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(13);randomSeed = opt.getLong("srand");
                useRandomSeed = true;
            }
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(15);int resign = opt.getInteger("resign", -1);
            Dummy dummy = new Dummy(log, useRandomSeed, randomSeed, resign);
            dummy.mainLoop(System.in, System.out);
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(16);if ((log != null) ? true : (!$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(18) && false))
                {$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(17);log.close();}
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_c9b31f14d66ff860(19);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_c9b31f14d66ff860(20);
    }
}
