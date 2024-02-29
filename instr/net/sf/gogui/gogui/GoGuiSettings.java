/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGuiSettings.java

package net.sf.gogui.gogui;

import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Options;
import net.sf.gogui.version.Version;

/** Parse command line options.
    Also modifies the persistent preferences if some command line options
    are set (e.g. komi) and handles some simple options that don't require
    the graphical   startup of GoGui (e.g. -help). */
public final class GoGuiSettings
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiSettings.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 453791890594575220L,/* translation unit id   */ -5258862089685146099L,/* timestamp             */ 1709177900902L,/* source file name      */ "GoGuiSettings.java",/* probe size            */ 49);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_b704c4cac58c660d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public boolean m_auto;

    public boolean m_register;

    public boolean m_initComputerColor;

    public boolean m_computerBlack;

    public boolean m_computerWhite;

    /** True if no startup is required.
        This happens for the -help and -version options which are already
        handled in the constructor. */
    public boolean m_noStartup;

    public boolean m_verbose;

    public int m_move;

    public File m_file;

    public File m_analyzeCommands;

    public String m_gtpCommand;

    public String m_gtpFile;

    public String m_lookAndFeel;

    public String m_program;

    public String m_time;

    public GoGuiSettings(String args[], Class c) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(0);m_prefs = Preferences.userNodeForPackage(c);
        String options[] = {
            "analyze-commands:",
            "auto",
            "command:",
            "computer-black",
            "computer-both",
            "computer-none",
            "computer-white",
            "config:",
            "gtpfile:",
            "help",
            "komi:",
            "laf:",
            "move:",
            "program:",
            "register",
            "size:",
            "time:",
            "verbose",
            "version"
        };
        Options opt = Options.parse(args, options);
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(1);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(3) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(2);printHelp();
            m_noStartup = true;
            return;
        }
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(4);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(6) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(5);m_noStartup = true;
            System.out.println("GoGui " + Version.get());
            return;
        }
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(7);String analyzeCommandsFilename = opt.get("analyze-commands", null);
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(8);if ((analyzeCommandsFilename != null) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(10) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(9);m_analyzeCommands = new File(analyzeCommandsFilename);}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(11);m_auto = opt.contains("auto");
        m_initComputerColor = false;
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(12);if ((opt.contains("computer-none")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(14) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(13);m_computerBlack = false;
            m_computerWhite = false;
            m_initComputerColor = true;
        }
        else {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(35);if ((opt.contains("computer-black")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(37) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(36);m_computerBlack = true;
            m_computerWhite = false;
            m_initComputerColor = true;
        }
        else {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(38);if ((opt.contains("computer-white")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(40) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(39);m_computerBlack = false;
            m_computerWhite = true;
            m_initComputerColor = true;
        }
        else {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(41);if ((opt.contains("computer-both")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(43) && false))
        {
            $qualityscroll_cover_jacov_probe_b704c4cac58c660d(42);m_computerBlack = true;
            m_computerWhite = true;
            m_initComputerColor = true;
        }}}}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(15);m_program = opt.get("program", null);
        m_register = opt.contains("register");
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(16);if ((m_register && m_program == null) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(18) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(17);throw new ErrorMessage(
                     "Option -register can be used only with option -program");}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(19);m_gtpFile = opt.get("gtpfile", "");
        m_gtpCommand = opt.get("command", "");
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(20);if ((opt.contains("komi")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(22) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(21);m_prefs.putDouble("komi", opt.getDouble("komi"));}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(23);m_lookAndFeel = opt.get("laf", null);
        m_move = opt.getInteger("move", -1);
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(24);if ((opt.contains("size")) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(26) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(25);m_prefs.putInt("boardsize", opt.getInteger("size"));}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(27);m_time = opt.get("time", null);
        m_verbose = opt.contains("verbose");
        ArrayList<String> arguments = opt.getArguments();
        m_file = null;
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(28);if ((arguments.size() == 1) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(30) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(29);m_file = new File(arguments.get(0));}
        else {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(32);if ((arguments.size() > 1) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(34) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(33);throw new ErrorMessage("Only one argument allowed");}}
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(31);validate();
    }

    private final Preferences m_prefs;

    private void printHelp()
    {
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(44);String helpText =
            "Usage: gogui [options] [file]\n" +
            "Graphical user interface for Go programs\n" +
            "using the Go Text Protocol.\n" +
            "\n" +
            "-analyze          Initialize analyze command\n" +
            "-analyze-commands Use analyze commands configuration file\n" +
            "-auto             Auto play games (if computer both)\n" +
            "-command          Send GTP command at startup\n" +
            "-computer-black   Computer plays black\n" +
            "-computer-both    Computer plays both sides\n" +
            "-computer-none    Computer plays no side\n" +
            "-computer-white   Computer plays white\n" +
            "-config           Config file\n" +
            "-gtpfile          Send GTP file at startup\n" +
            "-help             Display this help and exit\n" +
            "-komi             Set komi\n" +
            "-laf              Set Swing look and feel\n" +
            "-move             Load SGF file until move number\n" +
            "-program          Go program to attach\n" +
            "-size             Set board size\n" +
            "-time             Set time limits (min[+min/moves])\n" +
            "-verbose          Print debugging messages\n" +
            "-version          Print version and exit\n";
        System.out.print(helpText);
    }

    private void validate() throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(45);int size = m_prefs.getInt("boardsize", GoPoint.DEFAULT_SIZE);
        $qualityscroll_cover_jacov_probe_b704c4cac58c660d(46);if ((size < 1 || size > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_b704c4cac58c660d(48) && false))
            {$qualityscroll_cover_jacov_probe_b704c4cac58c660d(47);throw new ErrorMessage("Invalid board size: " + size);}
    }
}
