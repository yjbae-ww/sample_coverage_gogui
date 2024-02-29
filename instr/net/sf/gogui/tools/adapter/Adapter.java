/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Adapter.java

package net.sf.gogui.tools.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.BoardUpdater;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.gamefile.GameReader;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.BoardUtil;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.gtp.GtpCallback;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpClientBase;
import net.sf.gogui.gtp.GtpCommand;
import net.sf.gogui.gtp.GtpEngine;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpSynchronizer;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.util.ErrorMessage;

/** GTP adapter for logging or protocol translations. */
public class Adapter
    extends GtpEngine
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Adapter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8663922607700103886L,/* translation unit id   */ -2247577640488651774L,/* timestamp             */ 1709177903125L,/* source file name      */ "Adapter.java",/* probe size            */ 208);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e0cf000b4d903402(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param program Command line for executing the actual GTP engine.
        @param log Stream to log commands and responses of the adapter.
        @param gtpFile File with GTP commands to send engine at startup.
        @param verbose Enable logging of commands sent from the adapter to
        the actual GTP engine to standard error.
        @param noScore Hide final_score and final_status_list commands, even
        if the angine supports them.
        @param version1 Whether the adapter reports and implements GTP version
        1 commands.
        @param fillPasses Fill moves of non-alternating colors with pass
        moves.
        @param lowerCase Translate move commands to the engine to lower-case.
        @param size Board size at startup. */
    public Adapter(String program, PrintStream log, String gtpFile,
                   boolean verbose, boolean noScore, boolean version1,
                   boolean fillPasses, boolean lowerCase, int size)
        throws Exception
    {
        super(log);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0cf000b4d903402(0);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(1);if ((program.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(3) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(2);throw new Exception("No program is set.");}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(4);m_gtp = new GtpClient(program, null, verbose, null);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(5);if ((lowerCase) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(7) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(6);m_gtp.setLowerCase();}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(8);m_synchronizer = new GtpSynchronizer(m_gtp, null, fillPasses);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(9);if ((gtpFile != null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(11) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(10);sendGtpFile(gtpFile);}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(12);init(noScore, version1, size);
    }

    /** Construct with existing GtpClientBase.
        For testing this class. */
    public Adapter(GtpClientBase gtp, PrintStream log, boolean noScore,
                   boolean version1, boolean lowerCase, int size)
        throws GtpError
    {
        super(log);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0cf000b4d903402(13);
        m_gtp = gtp;
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(14);if ((lowerCase) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(16) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(15);m_gtp.setLowerCase();}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(17);m_synchronizer = new GtpSynchronizer(m_gtp, null, false);
        init(noScore, version1, size);
    }

    public void close()
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(18);m_gtp.close();
        m_gtp.waitForExit();
    }

    public void cmdBlack(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(19);cmd.checkNuArg(1);
        play(BLACK, getPointArg(cmd, 0));
    }

    public void cmdBoardsize(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(20);cmd.checkNuArg(1);
        int size = cmd.getIntArg(0, 1, GoPoint.MAX_SIZE);
        m_board.init(size);
        synchronize();
    }

    public void cmdClearBoard(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(21);cmd.checkArgNone();
        m_board.init(m_board.getSize());
        synchronize();
    }

    public void cmdForward(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(22);send(cmd.getLine(), cmd.getResponse());
    }

    public void cmdGenmove(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(23);GoColor c = cmd.getColorArg();
        cmdGenmove(c, cmd, m_gtp.getCommandGenmove(c));
    }

    public void cmdGenmoveCleanup(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(24);GoColor c = cmd.getColorArg();
        cmdGenmove(c, cmd, "kgs-genmove_cleanup " + c.getUppercaseLetter());
    }

    public void cmdGenmoveBlack(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(25);cmdGenmove(BLACK, cmd, m_gtp.getCommandGenmove(BLACK));
    }

    public void cmdGenmoveWhite(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(26);cmdGenmove(WHITE, cmd, m_gtp.getCommandGenmove(WHITE));
    }

    public void cmdGGUndo(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(27);cmd.checkNuArgLessEqual(1);
        int n = 1;
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(28);if ((cmd.getNuArg() == 1) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(30) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(29);n = cmd.getIntArg(0, 1, m_board.getNumberMoves());}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(31);m_board.undo(n);
        synchronize();
    }

    public void cmdGoGuiAnalyzeCommands(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(32);cmd.checkArgNone();
        String response =
            "string/Adapter ShowBoard/gogui-adapter-showboard\n";
        String command = null;
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(33);if ((m_gtp.isSupported("gogui-analyze_commands")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(35) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(34);command = "gogui-analyze_commands";}
        else {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(40);if ((m_gtp.isSupported("gogui_analyze_commands")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(42) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(41);command = "gogui_analyze_commands";}} // deprecated
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(36);if ((command != null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(38) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(37);response += send(command);}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(39);cmd.setResponse(response);
    }

    public void cmdAdapterShowBoard(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(43);cmd.getResponse().append("\n");
        cmd.getResponse().append(BoardUtil.toString(m_board, true, false));
    }

    public void cmdKomi(GtpCommand cmd) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(44);m_komi = Komi.parseKomi(cmd.getArg());
            synchronize();
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(45);throw new GtpError("invalid komi");
        }
    }

    public void cmdLoad(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(46);cmd.checkNuArgLessEqual(2);
        File file = new File(cmd.getArg(0));
        int moveNumber = -1;
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(47);if ((cmd.getNuArg() == 2) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(49) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(48);moveNumber = cmd.getIntArg(1);}
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(50);GameReader reader = new GameReader(file);
            GameTree tree = reader.getTree();
            ConstNode node = tree.getRoot();
            int n = 0;
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(51);while (true)
            {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(52);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(60) && false))
                    {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(59);++n;}
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(61);if ((moveNumber >= 0 && n == moveNumber - 1) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(63) && false))
                    {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(62);break;}
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(64);ConstNode child = node.getChildConst();
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(65);if ((child == null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(67) && false))
                    {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(66);break;}
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(68);node = child;
            }
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(54);if ((moveNumber >= 0 && n < moveNumber - 1) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(56) && false))
                {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(55);throw new GtpError("invalid move number");}
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(57);BoardUpdater boardUpdater = new BoardUpdater();
            boardUpdater.update(tree, node, m_board);
            m_komi = tree.getGameInfoConst(node).getKomi();
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(69);throw new GtpError(e.getMessage());
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(58);synchronize();
    }

    public void cmdPlaceFreeHandicap(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(70);ConstPointList stones;
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(71);if ((m_gtp.isSupported("place_free_handicap")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(73) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(72);String response = send(cmd.getLine());
            try
            {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(74);stones = GtpUtil.parsePointList(response, m_board.getSize());
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(83);throw new GtpError(e.getMessage());
            }
        }
        else
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(84);int n = cmd.getIntArg();
            stones = Board.getHandicapStones(m_board.getSize(), n);
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(85);if  ((stones == null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(87) && false))
                {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(86);throw new GtpError("Invalid number of handicap stones");}
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(75);StringBuilder response = new StringBuilder(128);
        PointList points = new PointList();
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(76);for (GoPoint p : stones)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(78);points.add(p);
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(79);if ((response.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(81) && false))
                {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(80);response.append(' ');}
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(82);response.append(p);
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(77);m_board.setup(points, null, null);
        cmd.setResponse(response.toString());
        synchronize();
    }

    public void cmdPlay(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(88);cmd.checkNuArg(2);
        GoColor color = cmd.getColorArg(0);
        GoPoint point = getPointArg(cmd, 1);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(89);if ((point != null && m_board.getColor(point) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(91) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(90);throw new GtpError("point is occupied");}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(92);play(color, point);
    }

    public void cmdProtocolVersion1(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(93);cmd.checkArgNone();
        cmd.setResponse("1");
    }

    @Override
	public void cmdQuit(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(94);send("quit");
        super.cmdQuit(cmd);
    }

    public void cmdSetFreeHandicap(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(95);PointList points = new PointList();
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(96);for (int i = 0; (i < cmd.getNuArg()) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(98) && false); ++i)
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(97);points.add(getPointArg(cmd, i));}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(99);m_board.setup(points, null, null);
        synchronize();
    }

    public void cmdTimeSettings(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(100);cmd.checkNuArg(3);
        long mainTime = cmd.getIntArg(0, 0, Integer.MAX_VALUE) * 1000L;
        long byoyomiTime = cmd.getIntArg(0, 0, Integer.MAX_VALUE) * 1000L;
        int byoyomiStones = cmd.getIntArg(0, 0, Integer.MAX_VALUE);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(101);if ((byoyomiTime == 0) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(103) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(102);m_timeSettings = new TimeSettings(mainTime);}
        else {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(104);if ((byoyomiStones == 0) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(106) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(105);m_timeSettings = null;}
        else
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(107);m_timeSettings =
                new TimeSettings(mainTime, byoyomiTime, byoyomiStones);}}
    }

    public void cmdUndo(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(108);cmd.checkArgNone();
        m_board.undo();
        synchronize();
    }

    public void cmdWhite(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(109);cmd.checkNuArg(1);
        play(WHITE, getPointArg(cmd, 0));
    }

    @Override
	public void interruptCommand()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(110);if ((m_gtp.isInterruptSupported()) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(112) && false))
                {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(111);m_gtp.sendInterrupt();}
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(113);System.err.println(e);
        }
    }

    @Override
	public void setName(String name)
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(114);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(116) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(115);register("name", m_callbackForward);
            register("version", m_callbackForward);
            return;
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(117);int index = name.indexOf(':');
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(118);if ((index < 0) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(120) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(119);super.setName(name);
            super.setVersion("");
        }
        else
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(124);super.setName(name.substring(0, index));
            super.setVersion(name.substring(index + 1));
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(121);register("name", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(122);cmdName(cmd); } });
        register("version", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(123);cmdVersion(cmd); } });
    }

    private Board m_board;

    private final GtpCallback m_callbackForward = new GtpCallback() {
            @Override
			public void run(GtpCommand cmd) throws GtpError {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(207);cmdForward(cmd); } };

    private final GtpClientBase m_gtp;

    private final GtpSynchronizer m_synchronizer;

    private Komi m_komi;

    private TimeSettings m_timeSettings;

    private void cmdGenmove(GoColor color, GtpCommand cmd, String command)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(125);String response = send(command);
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(126);if ((response.toLowerCase(Locale.ENGLISH).trim().equals("resign")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(128) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(127);cmd.setResponse("resign");
            return;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(129);GoPoint point = GtpUtil.parsePoint(response, m_board.getSize());
            m_board.play(color, point);
            m_synchronizer.updateAfterGenmove(m_board);
            cmd.setResponse(response);
        }
        catch (GtpResponseFormatError e)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(130);throw new GtpError(e.getMessage());
        }
    }

    private GoPoint getPointArg(GtpCommand cmd, int i) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(131);return cmd.getPointArg(i, m_board.getSize());
    }

    private void init(boolean noScore, boolean version1, int size)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(132);m_gtp.queryProtocolVersion();
        m_gtp.querySupportedCommands();
        m_board = new Board(size);
        registerCommands(noScore, version1);
        synchronize();
    }

    private void play(GoColor color, GoPoint point) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(133);Move move = Move.get(color, point);
        m_board.play(move);
        synchronize();
    }

    private void registerCommands(boolean noScore, boolean version1)
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(134);ArrayList<String> commands = m_gtp.getSupportedCommands();
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(135);for (int i = 0; (i < commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(137) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(136);String command = commands.get(i);
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(177);if ((! GtpUtil.isStateChangingCommand(command)) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(179) && false))
                {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(178);register(command, m_callbackForward);}
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(138);if ((m_gtp.isSupported("kgs-genmove_cleanup")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(140) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(139);register("kgs-genmove_cleanup", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(141);cmdGenmoveCleanup(cmd); } });}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(142);register("boardsize", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(143);cmdBoardsize(cmd); } });
        register("gogui-analyze_commands", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(144);cmdGoGuiAnalyzeCommands(cmd); } });
        register("gogui-adapter-showboard", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(145);cmdAdapterShowBoard(cmd); } });
        register("komi", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(146);cmdKomi(cmd); } });
        register("loadsgf", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(147);cmdLoad(cmd); } });
        register("loadxml", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(148);cmdLoad(cmd); } });
        setName(null);
        register("place_free_handicap", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(149);cmdPlaceFreeHandicap(cmd); } });
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(150);if ((version1) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(152) && false))
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(151);register("protocol_version", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(153);cmdProtocolVersion1(cmd); } });}
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(154);register("set_free_handicap", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(155);cmdSetFreeHandicap(cmd); } });
        register("time_settings", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(156);cmdTimeSettings(cmd); } });
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(157);if ((noScore) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(159) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(158);unregister("final_score");
            unregister("final_status_list");
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(160);if ((version1) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(162) && false))
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(161);register("black", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(163);cmdBlack(cmd); } });
            register("genmove_black", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(164);cmdGenmoveBlack(cmd); } });
            register("genmove_white", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(165);cmdGenmoveWhite(cmd); } });
            register("help", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(166);cmdListCommands(cmd); } });
            unregister("list_commands");
            register("white", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(167);cmdWhite(cmd); } });
        }
        else
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(171);register("clear_board", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(172);cmdClearBoard(cmd); } });
            register("genmove", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(173);cmdGenmove(cmd); } });
            unregister("help");
            register("known_command", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(174);cmdKnownCommand(cmd); } });
            register("list_commands", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(175);cmdListCommands(cmd); } });
            register("play", new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(176);cmdPlay(cmd); } });
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(168);register("undo", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(169);cmdUndo(cmd); } });
        register("gg-undo", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(170);cmdGGUndo(cmd); } });
    }

    private String send(String cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(180);return m_gtp.send(cmd);
    }

    private void send(String cmd, StringBuilder response) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(181);response.append(m_gtp.send(cmd));
    }

    private void sendGtpFile(String filename)
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(182);java.io.Reader reader;
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(183);reader = new FileReader(new File(filename));
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(205);System.err.println("File not found: " + filename);
            return;
        }
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(184);java.io.BufferedReader in;
        in = new BufferedReader(reader);
        try
        {
            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(185);while (true)
            {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(186);try
                {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(190);String line = in.readLine();
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(191);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(193) && false))
                    {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(192);in.close();
                        break;
                    }
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(194);line = line.trim();
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(195);if ((line.equals("") || line.startsWith("#")) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(197) && false))
                        {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(196);continue;}
                    try
                    {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(198);GtpCommand cmd = new GtpCommand(line);
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(199);if ((GtpUtil.isStateChangingCommand(cmd.getCommand())) ? true : (!$qualityscroll_cover_jacov_probe_e0cf000b4d903402(201) && false))
                        {
                            $qualityscroll_cover_jacov_probe_e0cf000b4d903402(200);System.err.println("Command " + cmd.getCommand()
                                               + " not allowed in GTP file");
                            break;
                        }
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(202);send(line);
                    }
                    catch (GtpError e)
                    {
                        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(203);System.err.println("Sending commands aborted:"
                                           + e.getMessage());
                        break;
                    }
                }
                catch (IOException e)
                {
                    $qualityscroll_cover_jacov_probe_e0cf000b4d903402(204);System.err.println("Sending commands aborted:"
                                       + e.getMessage());
                    break;
                }
            }
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_e0cf000b4d903402(188);in.close();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_e0cf000b4d903402(189);
            }
        }
    }

    private void synchronize() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_e0cf000b4d903402(206);m_synchronizer.synchronize(m_board, m_komi, m_timeSettings);
    }
}
