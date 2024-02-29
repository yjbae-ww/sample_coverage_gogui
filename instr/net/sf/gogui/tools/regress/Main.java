/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.regress;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Regress main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6885035009428070359L,/* translation unit id   */ 2739216173015514296L,/* timestamp             */ 1709177903365L,/* source file name      */ "Main.java",/* probe size            */ 21);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_2603a698ab983cb8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(0);String options[] = {
                "config:",
                "gtpfile:",
                "help",
                "long",
                "output:",
                "verbose",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_2603a698ab983cb8(3) && false))
            {
                $qualityscroll_cover_jacov_probe_2603a698ab983cb8(2);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_2603a698ab983cb8(6) && false))
            {
                $qualityscroll_cover_jacov_probe_2603a698ab983cb8(5);System.out.println("gogui-regress " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(7);boolean verbose = opt.contains("verbose");
            boolean longOutput = opt.contains("long");
            String output = opt.get("output", "");
            File gtpFile = null;
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(8);if ((opt.contains("gtpfile")) ? true : (!$qualityscroll_cover_jacov_probe_2603a698ab983cb8(10) && false))
                {$qualityscroll_cover_jacov_probe_2603a698ab983cb8(9);gtpFile = new File(opt.get("gtpfile")).getAbsoluteFile();}
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(11);ArrayList<String> arguments = opt.getArguments();
            int size = arguments.size();
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(12);if ((size < 2) ? true : (!$qualityscroll_cover_jacov_probe_2603a698ab983cb8(14) && false))
            {
                $qualityscroll_cover_jacov_probe_2603a698ab983cb8(13);printUsage(System.err);
                System.exit(2);
            }
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(15);String program = arguments.get(0);
            ArrayList<String> tests = new ArrayList<String>(arguments);
            tests.remove(0);
            Regress regress = new Regress(program, tests, output, longOutput,
                                          verbose, gtpFile);
            System.exit(((regress.getResult()) ? ($qualityscroll_cover_jacov_probe_2603a698ab983cb8(16) || true) : (!$qualityscroll_cover_jacov_probe_2603a698ab983cb8(17) && false)) ? 0 : 1);
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_2603a698ab983cb8(18);StringUtil.printException(t);
            System.exit(2);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_2603a698ab983cb8(19);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_2603a698ab983cb8(20);out.print("Usage: gogui-regress [options] program test.tst"
                  + " [...]\n" +
                  "\n" +
                  "-config       Config file\n" +
                  "-gtpfile      GTP file to execute before each test\n" +
                  "-help         Display this help and exit\n" +
                  "-long         Longer output to standard out\n" +
                  "-output       Output directory\n" +
                  "-verbose      Log GTP stream to stderr\n" +
                  "-version      Display this help and exit\n");
    }
}
