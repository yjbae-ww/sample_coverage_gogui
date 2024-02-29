/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.thumbnailer;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import net.sf.gogui.thumbnail.ThumbnailCreator;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** GoGuiThumbnailer main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2432940833713340806L,/* translation unit id   */ 6039456136886870539L,/* timestamp             */ 1709177903757L,/* source file name      */ "Main.java",/* probe size            */ 21);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_53d0755babb1e20b(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** GoGuiThumbnailer main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(0);String options[] = {
                //"check-expire:", // experimental; needs more testing
                "config:",
                //"expire:", // experimental; needs more testing
                "help",
                "scale",
                "size:",
                "verbose",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_53d0755babb1e20b(3) && false))
            {
                $qualityscroll_cover_jacov_probe_53d0755babb1e20b(2);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_53d0755babb1e20b(6) && false))
            {
                $qualityscroll_cover_jacov_probe_53d0755babb1e20b(5);System.out.println("gogui-thumbnailer " + Version.get());
                return;
            }
            /*
            if (opt.contains("expire"))
            {
                int seconds = opt.getInteger("expire", 0, 0);
                ThumbnailUtil.expire(seconds, false);
                return;
            }
            if (opt.contains("check-expire"))
            {
                int seconds = opt.getInteger("expire", 0, 0);
                ThumbnailUtil.expire(seconds, true);
                return;
            } */
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(7);boolean verbose = opt.contains("verbose");
            boolean scale = opt.contains("scale");
            ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(8);if ((arguments.isEmpty() || arguments.size() > 2) ? true : (!$qualityscroll_cover_jacov_probe_53d0755babb1e20b(10) && false))
            {
                $qualityscroll_cover_jacov_probe_53d0755babb1e20b(9);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(11);File input = new File(arguments.get(0));
            File output = null;
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(12);if ((arguments.size() == 2) ? true : (!$qualityscroll_cover_jacov_probe_53d0755babb1e20b(14) && false))
                {$qualityscroll_cover_jacov_probe_53d0755babb1e20b(13);output = new File(arguments.get(1));}
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(15);int size = opt.getInteger("size", 128, 1);
            ThumbnailCreator thumbnailCreator = new ThumbnailCreator(verbose);
            try
            {
                $qualityscroll_cover_jacov_probe_53d0755babb1e20b(16);thumbnailCreator.create(input, output, size, scale);
            }
            catch (ThumbnailCreator.Error e)
            {
                $qualityscroll_cover_jacov_probe_53d0755babb1e20b(17);System.err.println(e.getMessage());
                System.exit(1);
            }
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_53d0755babb1e20b(18);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_53d0755babb1e20b(19);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_53d0755babb1e20b(20);String helpText =
            "Usage: gogui-thumbnailer [options] input [output]\n" +
            "Options:\n" +
            "-config    config file\n" +
            "-help      Print help and exit\n" +
            "-scale     Scale size for board sizes other than 19x19\n" +
            "-size      Thumbnail size in pixels\n" +
            "-verbose   Print logging messages to stderr\n" +
            "-version   Print version and exit\n";
        out.print(helpText);
    }
}
