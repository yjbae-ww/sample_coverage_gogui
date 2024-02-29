/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.twogtp;

import java.io.File;
import java.util.ArrayList;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Komi;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Options;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** TwoGtp main function. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3220491651141959329L,/* translation unit id   */ 515513650111533781L,/* timestamp             */ 1709177903811L,/* source file name      */ "Main.java",/* probe size            */ 97);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_72778eef7c352d5(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** TwoGtp main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_72778eef7c352d5(0);boolean exitError = false;
        try
        {
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(1);String options[] = {
                "alternate",
                "analyze:",
                "auto",
                "black:",
                "compare",
                "config:",
                "debugtocomment",
                "force",
                "games:",
                "help",
                "komi:",
                "maxmoves:",
                "observer:",
                "openings:",
                "referee:",
                "sgffile:",
                "size:",
                "threads:",
                "time:",
                "verbose",
                "version",
                "white:",
                "xml"
            };
            Options opt = Options.parse(args, options);
            opt.checkNoArguments();
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(2);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(4) && false))
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(3);String helpText =
                   "Usage: gogui-twogtp [options]\n" +
                   "\n" +
                   "-alternate      alternate colors\n" +
                   "-analyze file   analyze result file\n" +
                   "-auto           autoplay games\n" +
                   "-black          command for black program\n" +
                   "-compare        compare list of sgf files\n" +
                   "-config         config file\n" +
                   "-debugtocomment save stderr of programs in SGF comments\n" +
                   "-force          overwrite existing files\n" +
                   "-games          number of games (0=unlimited)\n" +
                   "-help           display this help and exit\n" +
                   "-komi           komi\n" +
                   "-maxmoves       move limit\n" +
                   "-observer       command for observer program\n" +
                   "-openings       directory with opening sgf files\n" +
                   "-referee        command for referee program\n" +
                   "-sgffile        filename prefix\n" +
                   "-size           board size for autoplay (default 19)\n" +
                   "-threads n      number of threads\n" +
                   "-time spec      set time limits (min[+min/moves])\n" +
                   "-verbose        log GTP streams to stderr\n" +
                   "-version        print version and exit\n" +
                   "-white          command for white program\n" +
                   "-xml            save games in XML format\n";
                System.out.print(helpText);
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(5);boolean compare = opt.contains("compare");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(6);if ((compare) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(8) && false))
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(7);Compare.compare(opt.getArguments());
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(9);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(11) && false))
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(10);System.out.println("gogui-twogtp " + Version.get());
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(12);boolean force = opt.contains("force");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(13);if ((opt.contains("analyze")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(15) && false))
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(14);String filename = opt.get("analyze");
                new Analyze(filename, force);
                return;
            }
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(16);boolean alternate = opt.contains("alternate");
            boolean auto = opt.contains("auto");
            boolean debugToComment = opt.contains("debugtocomment");
            boolean verbose = opt.contains("verbose");
            String black = opt.get("black", "");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(17);if ((black.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(19) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(18);throw new ErrorMessage("No black program set");}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(20);String white = opt.get("white", "");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(21);if ((white.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(23) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(22);throw new ErrorMessage("No white program set");}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(24);String referee = opt.get("referee", "");
            String observer = opt.get("observer", "");
            int size = opt.getInteger("size", GoPoint.DEFAULT_SIZE, 1,
                                      GoPoint.MAX_SIZE);
            Komi komi = new Komi(6.5);
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(25);if ((opt.contains("komi")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(27) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(26);komi = Komi.parseKomi(opt.get("komi"));}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(28);int maxMoves = opt.getInteger("maxmoves", 1000, -1);
            TimeSettings timeSettings = null;
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(29);if ((opt.contains("time")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(31) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(30);timeSettings = TimeSettings.parse(opt.get("time"));}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(32);int defaultGames = (((auto) ? ($qualityscroll_cover_jacov_probe_72778eef7c352d5(33) || true) : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(34) && false)) ? 1 : 0);
            int numberGames = opt.getInteger("games", defaultGames, 0);
            int numberThreads = opt.getInteger("threads", 1, 1);
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(35);if ((numberThreads > 1 && ! auto) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(37) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(36);throw new ErrorMessage("Option -threads needs option -auto");}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(38);String sgfFile = opt.get("sgffile", "");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(39);if ((opt.contains("games") && sgfFile.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(41) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(40);throw new ErrorMessage("Use option -sgffile with -games");}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(42);Openings openings = null;
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(43);if ((opt.contains("openings")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(45) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(44);openings = new Openings(new File(opt.get("openings")));}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(46);boolean useXml = opt.contains("xml");
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(47);if ((auto) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(49) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(48);System.in.close();}

            $qualityscroll_cover_jacov_probe_72778eef7c352d5(50);TwoGtp twoGtp[] = new TwoGtp[numberThreads];
            TwoGtpThread thread[] = new TwoGtpThread[numberThreads];
            ResultFile resultFile = null;
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(51);for (int i = 0; (i < numberThreads) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(53) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(52);ArrayList<Program> allPrograms = new ArrayList<Program>();
                Program blackProgram =
                    new Program(black, "Black", "B", verbose);
                allPrograms.add(blackProgram);
                Program whiteProgram =
                    new Program(white, "White", "W", verbose);
                allPrograms.add(whiteProgram);
                Program refereeProgram;
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(71);if ((referee.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(73) && false))
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(72);refereeProgram = null;}
                else
                {
                    $qualityscroll_cover_jacov_probe_72778eef7c352d5(89);refereeProgram =
                        new Program(referee, "Referee", "R", verbose);
                    allPrograms.add(refereeProgram);
                }
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(74);for (Program program : allPrograms)
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(88);program.setLabel(allPrograms);}
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(75);if ((! sgfFile.equals("") && resultFile == null) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(77) && false))
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(76);resultFile =
                        new ResultFile(force, blackProgram, whiteProgram,
                                       refereeProgram, numberGames, size,
                                       komi, sgfFile, openings, alternate,
                                       useXml, numberThreads);}
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(78);if ((i > 0) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(80) && false))
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(79);verbose = false;}
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(81);twoGtp[i] = new TwoGtp(blackProgram, whiteProgram,
                                       refereeProgram, observer, size, komi,
                                       numberGames, alternate, sgfFile,
                                       verbose, openings, timeSettings,
                                       resultFile);
                twoGtp[i].setMaxMoves(maxMoves);
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(82);if ((debugToComment) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(84) && false))
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(83);twoGtp[i].setDebugToComment(true);}
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(85);if ((auto) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(87) && false))
                {
                    $qualityscroll_cover_jacov_probe_72778eef7c352d5(86);thread[i] = new TwoGtpThread(twoGtp[i]);
                    thread[i].start();
                }
            }
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(54);if ((auto) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(56) && false))
            {
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(55);for (int i = 0; (i < numberThreads) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(58) && false); ++i)
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(57);thread[i].join();}
                $qualityscroll_cover_jacov_probe_72778eef7c352d5(59);for (int i = 0; (i < numberThreads) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(61) && false); ++i)
                    {$qualityscroll_cover_jacov_probe_72778eef7c352d5(60);if ((thread[i].getException() != null) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(69) && false))
                    {
                        $qualityscroll_cover_jacov_probe_72778eef7c352d5(68);StringUtil.printException(thread[i].getException());
                        exitError = true;
                    }}
            }
            else
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(70);twoGtp[0].mainLoop(System.in, System.out);}
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(62);if ((resultFile != null) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(64) && false))
                {$qualityscroll_cover_jacov_probe_72778eef7c352d5(63);resultFile.close();}
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(90);StringUtil.printException(t);
            exitError = true;
        }
        $qualityscroll_cover_jacov_probe_72778eef7c352d5(65);if ((exitError) ? true : (!$qualityscroll_cover_jacov_probe_72778eef7c352d5(67) && false))
            {$qualityscroll_cover_jacov_probe_72778eef7c352d5(66);System.exit(1);}
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Main()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_72778eef7c352d5(91);
    }
}

class TwoGtpThread
    extends Thread
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TwoGtpThread.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3220491651141959329L,/* translation unit id   */ 515513650111533781L,/* timestamp             */ 1709177903811L,/* source file name      */ "Main.java",/* probe size            */ 97);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_72778eef7c352d5(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public TwoGtpThread(TwoGtp twoGtp)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_72778eef7c352d5(92);m_twoGtp = twoGtp;
    }

    public Exception getException()
    {
        $qualityscroll_cover_jacov_probe_72778eef7c352d5(93);return m_exception;
    }

    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(94);m_twoGtp.autoPlay();
        }
        catch (Exception e)
        {
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(96);m_exception = e;
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_72778eef7c352d5(95);m_twoGtp.close();
        }
    }

    private Exception m_exception;

    private TwoGtp m_twoGtp;
}