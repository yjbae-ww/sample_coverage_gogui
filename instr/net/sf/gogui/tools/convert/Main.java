/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.gamefile.GameReader;
import net.sf.gogui.sgf.SgfWriter;
import net.sf.gogui.tex.TexWriter;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;
import net.sf.gogui.xml.XmlWriter;

/** Convert SGF and Jago XML Go game files to other formats. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 7915326584914369156L,/* translation unit id   */ 1501120700517470594L,/* timestamp             */ 1709177903198L,/* source file name      */ "Main.java",/* probe size            */ 51);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_14d50d52e7545182(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(0);String options[] = {
                "check",
                "config:",
                "force",
                "format:",
                "help",
                "title:",
                "version",
                "werror"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(3) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(2);printUsage(System.out);
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(6) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(5);System.out.println("gogui-convert " + Version.get());
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(7);boolean force = opt.contains("force");
            String title = opt.get("title", "");
            boolean werror = opt.contains("werror");
            boolean checkOnly = opt.contains("check");
            ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(8);if ((! (arguments.size() == 2
                   || (arguments.size() == 1 && checkOnly))) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(10) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(9);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(11);File in = new File(arguments.get(0));
            File out = null;
            String format = null;
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(12);if ((! checkOnly) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(14) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(13);out = new File(arguments.get(1));
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(15);if ((opt.contains("format")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(17) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(16);format = opt.get("format");}
                else
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(47);format =
                        FileUtil.getExtension(out).toLowerCase(Locale.ENGLISH);}
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(18);if ((! format.equals("sgf")
                    && ! format.equals("tex")
                    && ! format.equals("xml")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(20) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(19);throw new ErrorMessage("Unknown format");}
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(21);if ((out.exists() && ! force) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(23) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(22);throw new ErrorMessage("File \"" + out
                                           + "\" already exists");}
            }
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(24);if ((! in.exists()) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(26) && false))
                {$qualityscroll_cover_jacov_probe_14d50d52e7545182(25);throw new ErrorMessage("File \"" + in + "\" not found");}
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(27);GameReader reader = new GameReader(in);
            ConstGameTree tree = reader.getTree();
            String warnings = reader.getWarnings();
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(28);if ((warnings != null) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(30) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(29);System.err.print(warnings);
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(31);if ((werror) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(33) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(32);System.exit(1);}
            }
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(34);if ((! checkOnly) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(36) && false))
            {
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(35);String version = Version.get();
                $qualityscroll_cover_jacov_probe_14d50d52e7545182(37);if ((format.equals("xml")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(39) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(38);new XmlWriter(new FileOutputStream(out), tree,
                                  "gogui-convert:" + version);}
                else {$qualityscroll_cover_jacov_probe_14d50d52e7545182(40);if ((format.equals("sgf")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(42) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(41);new SgfWriter(new FileOutputStream(out), tree,
                                  "gogui-convert", version);}
                else {$qualityscroll_cover_jacov_probe_14d50d52e7545182(43);if ((format.equals("tex")) ? true : (!$qualityscroll_cover_jacov_probe_14d50d52e7545182(45) && false))
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(44);new TexWriter(title, new FileOutputStream(out), tree);}
                else
                    {$qualityscroll_cover_jacov_probe_14d50d52e7545182(46);assert false;}}} // checked above
            }
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_14d50d52e7545182(48);StringUtil.printException(t);
            System.exit(1);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_14d50d52e7545182(49);
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14d50d52e7545182(50);out.print("Usage: gogui-convert infile outfile\n" +
                  "\n" +
                  "-check   only check reading a file\n" +
                  "-config  config file\n" +
                  "-force   overwrite existing files\n" +
                  "-format  output format (sgf,tex,xml)\n" +
                  "-help    display this help and exit\n" +
                  "-title   use title\n" +
                  "-version print version and exit\n" +
                  "-werror  handle read warnings as errors\n");
    }
}
