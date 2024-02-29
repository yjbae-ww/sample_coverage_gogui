/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.adapter;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Adapter main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8109974980946416333L,/* translation unit id   */ -918761933620563543L,/* timestamp             */ 1709177903158L,/* source file name      */ "Main.java",/* probe size            */ 29);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Adapter main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(0);String options[] = {
                "config:",
                "fillpasses",
                "gtpfile:",
                "help",
                "log:",
                "lowercase",
                "noscore",
                "name:",
                "size:",
                "verbose",
                "version",
                "version1"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(3) && false))
            {
                $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(2);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(6) && false))
            {
                $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(5);if ((opt.getArguments().size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(8) && false))
                    {$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(7);throw new ErrorMessage("No arguments allowed with"
                                           + " option -version");}
                $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(9);System.out.println("gogui-adapter " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(10);boolean verbose = opt.contains("verbose");
            boolean noScore = opt.contains("noscore");
            boolean version1 = opt.contains("version1");
            boolean fillPasses = opt.contains("fillpasses");
            boolean lowerCase = opt.contains("lowercase");
            String name = opt.get("name", null);
            String gtpFile = opt.get("gtpfile", null);
            ArrayList<String> arguments = opt.getArguments();
            int size = opt.getInteger("size", 19, 1, GoPoint.MAX_SIZE);
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(11);if ((arguments.size() != 1) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(13) && false))
            {
                $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(12);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(14);PrintStream log = null;
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(15);if ((opt.contains("log")) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(17) && false))
            {
                $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(16);File file = new File(opt.get("log"));
                log = new PrintStream(file);
            }
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(18);String program = arguments.get(0);
            Adapter adapter = new Adapter(program, log, gtpFile, verbose,
                                          noScore, version1, fillPasses,
                                          lowerCase, size);
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(19);if ((name != null) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(21) && false))
                {$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(20);adapter.setName(name);}
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(22);adapter.mainLoop(System.in, System.out);
            adapter.close();
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(23);if ((log != null) ? true : (!$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(25) && false))
                {$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(24);log.close();}
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(26);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(27);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f33fe6e3a16531a9(28);String helpText =
            "Usage: gogui-adapter program\n" +
            "\n" +
            "-config       config file\n" +
            "-fillpasses   fill non-alternating moves with pass moves\n" +
            "-gtpfile      file with GTP commands to send at startup\n" +
            "-help         print help and exit\n" +
            "-log file     log GTP stream to file\n" +
            "-lowercase    translate move commands to lowercase\n" +
            "-noscore      hide score commands\n" +
            "-resign score resign if estimated score is below threshold\n" +
            "-size         accept only this board size\n" +
            "-verbose      log GTP stream to stderr\n" +
            "-version      print version and exit\n" +
            "-version1     report GTP version 1 in protocol_version\n";
        out.print(helpText);
    }
}
