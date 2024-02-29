/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.statistics;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Statistics main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8812236479905279948L,/* translation unit id   */ 3929047990412686255L,/* timestamp             */ 1709177903578L,/* source file name      */ "Main.java",/* probe size            */ 44);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3686c8548e02b3af(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(0);String options[] = {
                "analyze:",
                "backward",
                "begin:",
                "commands:",
                "config:",
                "final:",
                "force",
                "help",
                "max:",
                "min:",
                "output:",
                "precision:",
                "program:",
                "quiet",
                "random",
                "setup",
                "size:",
                "verbose",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(3) && false))
            {
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(2);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(6) && false))
            {
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(5);System.out.println("gogui-statistics " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(7);boolean analyze = opt.contains("analyze");
            boolean allowSetup = opt.contains("setup");
            boolean backward = opt.contains("backward");
            boolean random = opt.contains("random");
            String program = "";
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(8);if ((! analyze) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(10) && false))
            {
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(9);if ((! opt.contains("program")) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(12) && false))
                {
                    $qualityscroll_cover_jacov_probe_3686c8548e02b3af(11);System.out.println("Need option -program");
                    System.exit(1);
                }
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(13);program = opt.get("program");
            }
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(14);boolean verbose = opt.contains("verbose");
            boolean quiet = opt.contains("quiet");
            boolean force = opt.contains("force");
            int min = opt.getInteger("min", 0, 0);
            int max = opt.getInteger("max", Integer.MAX_VALUE, 0);
            int precision = opt.getInteger("precision", 3, 0);
            int boardSize = opt.getInteger("size", GoPoint.DEFAULT_SIZE, 1,
                                           GoPoint.MAX_SIZE);
            ArrayList<String> commands = parseCommands(opt, "commands");
            ArrayList<String> finalCommands = parseCommands(opt, "final");
            ArrayList<String> beginCommands = parseCommands(opt, "begin");
            ArrayList<String> arguments = opt.getArguments();
            int size = arguments.size();
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(15);if ((analyze) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(17) && false))
            {
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(16);if ((size > 0) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(19) && false))
                {
                    $qualityscroll_cover_jacov_probe_3686c8548e02b3af(18);printUsage(System.err);
                    System.exit(1);
                }
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(20);String fileName = opt.get("analyze");
                String output = opt.get("output");
                new Analyze(fileName, output, precision);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(21);if ((size < 1) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(23) && false))
                {
                    $qualityscroll_cover_jacov_probe_3686c8548e02b3af(22);printUsage(System.err);
                    System.exit(1);
                }
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(24);File output;
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(25);if ((opt.contains("output")) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(27) && false))
                    {$qualityscroll_cover_jacov_probe_3686c8548e02b3af(26);output = new File(opt.get("output"));}
                else
                    {$qualityscroll_cover_jacov_probe_3686c8548e02b3af(32);output = new File("statistics.dat");}
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(28);if ((output.exists() && ! force) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(30) && false))
                    {$qualityscroll_cover_jacov_probe_3686c8548e02b3af(29);throw new ErrorMessage("File \"" + output +
                                           "\" already exists");}
                $qualityscroll_cover_jacov_probe_3686c8548e02b3af(31);Statistics statistics = new Statistics();
                statistics.setMin(min);
                statistics.setMax(max);
                statistics.setQuiet(quiet);
                statistics.run(program, arguments, boardSize, commands,
                               beginCommands, finalCommands, verbose,
                               allowSetup, backward, random);
                statistics.saveTable(output);
            }
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(33);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_3686c8548e02b3af(34);
    }

    private static ArrayList<String> parseCommands(Options opt, String option)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3686c8548e02b3af(35);ArrayList<String> result = null;
        $qualityscroll_cover_jacov_probe_3686c8548e02b3af(36);if ((opt.contains(option)) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(38) && false))
        {
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(37);String string = opt.get(option);
            String[] array = StringUtil.split(string, ',');
            result = new ArrayList<String>(array.length);
            $qualityscroll_cover_jacov_probe_3686c8548e02b3af(39);for (int i = 0; (i < array.length) ? true : (!$qualityscroll_cover_jacov_probe_3686c8548e02b3af(41) && false); ++i)
                {$qualityscroll_cover_jacov_probe_3686c8548e02b3af(40);result.add(array[i].trim());}
        }
        $qualityscroll_cover_jacov_probe_3686c8548e02b3af(42);return result;
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3686c8548e02b3af(43);out.print("Usage: gogui-statistics -program program"
                  + " [options] file.sgf|dir [...]\n" +
                  "\n" +
                  "-analyze      Create HTML file from result file\n" +
                  "-backward     Iterate backward from end position\n" +
                  "-begin        GTP commands to run on begin positions\n" +
                  "-commands     GTP commands to run (comma separated)\n" +
                  "-config       Config file\n" +
                  "-final        GTP commands to run on final positions\n" +
                  "-force        Overwrite existing file\n" +
                  "-help         Display this help and exit\n" +
                  "-max          Only positions with maximum move number\n" +
                  "-min          Only positions with minimum move number\n" +
                  "-output       Filename prefix for output files\n" +
                  "-precision    Floating point precision for -analyze\n" +
                  "-quiet        Don't write logging messages\n" +
                  "-setup        Allow setup stones in root position\n" +
                  "-size         Board size of games\n" +
                  "-verbose      Log GTP stream to stderr\n" +
                  "-version      Display this help and exit\n");
    }
}
