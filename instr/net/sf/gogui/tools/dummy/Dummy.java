/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Dummy.java

package net.sf.gogui.tools.dummy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.PointList;
import net.sf.gogui.gtp.GtpCallback;
import net.sf.gogui.gtp.GtpCommand;
import net.sf.gogui.gtp.GtpEngine;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.version.Version;

/** Dummy Go program for testing GTP controlling programs.
    See the gogui-dummy documentation for information about the extension
    commands. */
public class Dummy
    extends GtpEngine
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Dummy.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 7884025398699989274L,/* translation unit id   */ -7285278654982330447L,/* timestamp             */ 1709177903307L,/* source file name      */ "Dummy.java",/* probe size            */ 152);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Dummy(PrintStream log, boolean useRandomSeed, long randomSeed,
                 int resign)
        throws Exception
    {
        super(log);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(0);
        registerCommands();
        setName("gogui-dummy");
        setVersion(Version.get());
        m_random = new Random();
        m_resign = resign;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(1);if ((useRandomSeed) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(3) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(2);m_random.setSeed(randomSeed);}
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(4);initSize(GoPoint.DEFAULT_SIZE);
    }

    public void cmdBWBoard(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(5);cmd.getResponse().append('\n');
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(6);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(8) && false); ++x)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(7);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(10) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(9);cmd.getResponse().append(((m_random.nextBoolean()) ? ($qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(12) || true) : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(13) && false)) ? 'B' : 'W');
                $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(14);if ((y < m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(16) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(15);cmd.getResponse().append(' ');}
            }
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(11);cmd.getResponse().append('\n');
        }
    }

    public void cmdBoardsize(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(17);cmd.checkNuArg(1);
        int size = cmd.getIntArg(0, 1, GoPoint.MAX_SIZE);
        initSize(size);
    }

    public void cmdCrash(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(18);System.err.println("Aborting gogui-dummy");
        System.exit(1);
    }

    public void cmdClearBoard(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(19);initSize(m_size);
    }

    public void cmdEcho(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(20);cmd.setResponse(cmd.getArgLine());
    }

    public void cmdEchoErr(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(21);System.err.println(cmd.getArgLine());
    }

    public void cmdDelay(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(22);cmd.checkNuArgLessEqual(1);
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(23);if ((cmd.getNuArg() == 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(25) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(24);m_delay = cmd.getIntArg(0, 0, Integer.MAX_VALUE);}
        else
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(26);cmd.getResponse().append(m_delay);}
    }

    public void cmdFileOpen(GtpCommand cmd) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(27);File f = new File(cmd.getArg());
            cmd.setResponse("CanonicalPath: " + f.getCanonicalPath() + "\n" +
                            "Exists:        " + f.exists() + "\n" +
                            "CanRead:       " + f.canRead() + "\n" +
                            "CanWrite:      " + f.canWrite() + "\n");
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(28);throw new GtpError(e.getMessage());
        }
    }

    public void cmdFileSave(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(29);File file = new File(cmd.getArg());
        try
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(30);PrintStream out = new PrintStream(file);
            out.println("Hello world!");
            out.close();
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(31);throw new GtpError(e.getMessage());
        }
    }

    public void cmdEPList(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(32);if ((cmd.getNuArg() == 1 && cmd.getArg(0).equals("show")) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(34) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(33);cmd.setResponse(GoPoint.toString(m_ePList));}
        else
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(35);m_ePList = cmd.getPointListArg(m_size);}
    }

    public void cmdGfx(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(36);cmd.setResponse("LABEL A4 test\n" +
                        "COLOR green A5 A7 B9\n" +
                        "COLOR #980098 B7 B8\n" +
                        "SQUARE B5 C9\n" +
                        "MARK A6 B6\n" +
                        "TRIANGLE A9\n" +
                        "WHITE A1\n" +
                        "BLACK B1\n" +
                        "CIRCLE c8\n" +
                        "INFLUENCE a7 -1 b7 -0.75 c7 -0.5 d7 -0.25 e7 0"
                        + " f7 0.25 g7 0.5 h7 0.75 j7 1\n" +
                        "VAR b c1 w c2 b c3 b c4 w pass b c5\n" +
                        "TEXT Graphics Demo\n");
    }

    public void cmdGoGuiAnalyzeCommands(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(37);cmd.checkArgNone();
        String response =
            "bwboard/BWBoard/gogui-dummy-bwboard\n" +
            "none/Crash/gogui-dummy-crash\n" +
            "none/Delay/gogui-dummy-delay %o\n" +
            "eplist/EPList/gogui-dummy-eplist\n" +
            "string/File Open/gogui-dummy-file_open %r\n" +
            "none/File Save/gogui-dummy-file_save %w\n" +
            "gfx/Gfx/gogui-dummy-gfx\n" +
            "none/Invalid/gogui-dummy-invalid\n" +
            "none/Live Gfx/gogui-dummy-live_gfx\n" +
            "string/Long Response/gogui-dummy-long_response %s\n" +
            "none/Next Failure/gogui-dummy-next_failure %s\n" +
            "none/Next Success/gogui-dummy-next_success %s\n" +
            "sboard/SBoard/gogui-dummy-sboard\n" +
            "none/Sleep/gogui-dummy-sleep %s\n" +
            "none/Sleep 20s/gogui-dummy-sleep\n";
        cmd.setResponse(response);
    }

    public void cmdGenmove(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(38);++m_numberGenmove;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(39);if ((m_numberGenmove == m_resign) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(41) && false))
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(40);cmd.setResponse("resign");
            return;
        }
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(42);int numberPossibleMoves = 0;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(43);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(45) && false); ++x)
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(44);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(65) && false); ++y)
                {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(64);if ((! m_alreadyPlayed[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(67) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(66);++numberPossibleMoves;}}}
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(46);GoPoint point = null;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(47);if ((numberPossibleMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(49) && false))
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(48);int rand = m_random.nextInt(numberPossibleMoves);
            int index = 0;
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(50);for (int x = 0; (x < m_size && point == null) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(52) && false); ++x)
                {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(51);for (int y = 0; (y < m_size && point == null) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(58) && false); ++y)
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(57);if ((! m_alreadyPlayed[x][y]) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(60) && false))
                    {
                        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(59);if ((index == rand) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(62) && false))
                            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(61);point = GoPoint.get(x, y);}
                        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(63);++index;
                    }}}
        }
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(53);cmd.setResponse(GoPoint.toString(point));
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(54);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(56) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(55);m_alreadyPlayed[point.getX()][point.getY()] = true;}
    }

    public void cmdInterrupt(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(68);cmd.checkArgNone();
    }

    public void cmdInvalid(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(69);cmd.checkArgNone();
        printInvalidResponse("This is an invalid GTP response.\n" +
                             "It does not start with a status character.\n");
    }

    public void cmdLiveGfx(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(70);cmd.checkArgNone();
        System.err.println("gogui-gfx: TEXT Live Graphics Demo");
        System.err.println("gogui-gfx: LABEL A4 test");
        sleep(1000);
        System.err.println("gogui-gfx: COLOR green A5 A7 B9");
        sleep(1000);
        System.err.println("gogui-gfx: COLOR #980098 B7 B8");
        sleep(1000);
        System.err.println("gogui-gfx:\n" +
                           "SQUARE B5 C9\n" +
                           "MARK A6 B6\n" +
                           "TRIANGLE A9\n");
        sleep(1000);
        System.err.println("gogui-gfx: WHITE A1");
        sleep(1000);
        System.err.println("gogui-gfx: BLACK B1");
        sleep(1000);
        System.err.println("gogui-gfx: CIRCLE c8");
        sleep(1000);
        System.err.println("gogui-gfx: INFLUENCE a7 -1 b7 -0.75 c7 "
                           + "-0.5 d7 -0.25 e7 0 f7 0.25 g7 0.5 h7 0.75 "
                           + "j7 1");
        sleep(1000);
        System.err.println("gogui-gfx: VAR b c1 w c2 b c3 b c4 w pass "
                           + "b c5");
        sleep(1000);
        System.err.println("gogui-gfx: CLEAR");
    }

    public void cmdLongResponse(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(71);cmd.checkNuArg(1);
        int n = cmd.getIntArg(0, 1, Integer.MAX_VALUE);
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(72);for (int i = 1; (i <= n) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(74) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(73);cmd.getResponse().append(i);
            cmd.getResponse().append("\n");
        }
    }

    public void cmdNextFailure(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(75);nextResponseFixed(cmd, false);
    }

    public void cmdNextSuccess(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(76);nextResponseFixed(cmd, true);
    }

    public void cmdPlay(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(77);cmd.checkNuArg(2);
        cmd.getColorArg(0);
        GoPoint point = cmd.getPointArg(1, m_size);
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(78);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(80) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(79);m_alreadyPlayed[point.getX()][point.getY()] = true;}
    }

    public void cmdSBoard(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(81);cmd.getResponse().append('\n');
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(82);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(84) && false); ++x)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(83);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(86) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(85);if ((x == 1 && y == 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(89) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(88);cmd.getResponse().append("\"a b\"");}
                else {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(93);if ((x == 1 && y == 2) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(95) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(94);cmd.getResponse().append("ab   ");}
                else {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(96);if ((x == 1 && y == 3) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(98) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(97);cmd.getResponse().append("abc  ");}
                else {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(99);if ((x == 2 && y == 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(101) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(100);cmd.getResponse().append("abcde");}
                else
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(102);cmd.getResponse().append("\"\"   ");}}}}
                $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(90);if ((y < m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(92) && false))
                    {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(91);cmd.getResponse().append(' ');}
            }
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(87);cmd.getResponse().append('\n');
        }
    }

    public void cmdSleep(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(103);cmd.checkNuArgLessEqual(1);
        long millis = 20000;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(104);if ((cmd.getNuArg() == 1) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(106) && false))
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(105);millis = (long)(cmd.getDoubleArg(0) * 1000.0);}
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(107);long showProgressInterval = Math.max(millis / 100, 1000);
        long steps = millis / showProgressInterval;
        long remaining = millis - steps * showProgressInterval;
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(108);for (long i = 0; (i < steps && ! isInterrupted()) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(110) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(109);System.err.println("gogui-gfx: TEXT " + (100L * i / steps) + " %");
            sleep(showProgressInterval);
        }
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(111);sleep(remaining);
    }

    @Override
	public void handleCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(112);if ((m_nextResponseFixed) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(114) && false))
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(113);m_nextResponseFixed = false;
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(115);if ((! m_nextStatus) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(117) && false))
                {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(116);throw new GtpError(m_nextResponse);}
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(118);cmd.setResponse(m_nextResponse);
        }
        else
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(124);super.handleCommand(cmd);}
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(119);if ((m_delay > 0) ? true : (!$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(121) && false))
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(120);try
            {
                $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(122);Thread.sleep(1000L * m_delay);
            }
            catch (InterruptedException e)
            {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(123);
            }
        }
    }

    private boolean m_nextResponseFixed;

    private boolean m_nextStatus;

    /** Delay every command (seconds) */
    private int m_delay;

    private int m_numberGenmove;

    private final int m_resign;

    private int m_size;

    private boolean[][] m_alreadyPlayed;

    private final Random m_random;

    private String m_nextResponse;

    /** Editable point list for gogui-dummy-eplist command. */
    private PointList m_ePList = new PointList();

    private void initSize(int size)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(125);m_alreadyPlayed = new boolean[size][size];
        m_size = size;
        m_numberGenmove = 0;
    }

    private void nextResponseFixed(GtpCommand cmd, boolean nextStatus)
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(126);m_nextResponseFixed = true;
        m_nextStatus = nextStatus;
        m_nextResponse = cmd.getArgLine();
    }

    private void registerCommands()
    {
        $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(127);register("boardsize", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(128);cmdBoardsize(cmd); } });
        register("clear_board", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(129);cmdClearBoard(cmd); } });
        register("gogui-dummy-bwboard", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(130);cmdBWBoard(cmd); } });
        register("gogui-dummy-crash", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(131);cmdCrash(cmd); } });
        register("gogui-dummy-delay", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(132);cmdDelay(cmd); } });
        register("gogui-dummy-eplist", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(133);cmdEPList(cmd); } });
        register("gogui-dummy-file_open", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(134);cmdFileOpen(cmd); } });
        register("gogui-dummy-file_save", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(135);cmdFileSave(cmd); } });
        register("gogui-dummy-gfx", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(136);cmdGfx(cmd); } });
        register("gogui-dummy-invalid", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(137);cmdInvalid(cmd); } });
        register("gogui-dummy-live_gfx", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(138);cmdLiveGfx(cmd); } });
        register("gogui-dummy-long_response", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(139);cmdLongResponse(cmd); } });
        register("gogui-dummy-next_failure", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(140);cmdNextFailure(cmd); } });
        register("gogui-dummy-next_success", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(141);cmdNextSuccess(cmd); } });
        register("gogui-dummy-sboard", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(142);cmdSBoard(cmd); } });
        register("gogui-dummy-sleep", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(143);cmdSleep(cmd); } });
        register("echo", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(144);cmdEcho(cmd); } });
        register("echo_err", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(145);cmdEchoErr(cmd); } });
        register("genmove", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(146);cmdGenmove(cmd); } });
        register("gogui-analyze_commands", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(147);cmdGoGuiAnalyzeCommands(cmd); } });
        register("gogui-interrupt", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(148);cmdInterrupt(cmd); } });
        register("play", new GtpCallback() {
                public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(149);cmdPlay(cmd); } });
    }

    private void sleep(long millis)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(150);Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {$qualityscroll_cover_jacov_probe_9ae57da9900ae7b1(151);
        }
    }
}
