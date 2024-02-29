/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.terminal;

import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Terminal main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1863219103135687389L,/* translation unit id   */ 6239243426632381295L,/* timestamp             */ 1709177903691L,/* source file name      */ "Main.java",/* probe size            */ 15);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Terminal main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(0);String options[] = {
                "color",
                "config:",
                "help",
                "size:",
                "verbose",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_56963ed6ef9d336f(3) && false))
            {
                $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(2);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_56963ed6ef9d336f(6) && false))
            {
                $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(5);System.out.println("gogui-terminal " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(7);int size = opt.getInteger("size", GoPoint.DEFAULT_SIZE, 1,
                                      GoPoint.MAX_SIZE);
            boolean verbose = opt.contains("verbose");
            boolean color = opt.contains("color");
            ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(8);if ((arguments.size() != 1) ? true : (!$qualityscroll_cover_jacov_probe_56963ed6ef9d336f(10) && false))
            {
                $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(9);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(11);String program = arguments.get(0);
            Terminal terminal = new Terminal(program, size, verbose);
            terminal.setColor(color);
            terminal.mainLoop();
            terminal.close();
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(12);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_56963ed6ef9d336f(13);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_56963ed6ef9d336f(14);String helpText =
            "Usage: gogui-terminal program\n" +
            "\n" +
            "-color        colorize go board\n" +
            "-config       config file\n" +
            "-help         print help and exit\n" +
            "-size n       board size (default 19)\n" +
            "-verbose      print debug information\n" +
            "-version      print version and exit\n";
        out.print(helpText);
    }
}
