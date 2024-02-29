/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// TwoGtp.java

package net.sf.gogui.tools.twogtp;

import java.util.ArrayList;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.Game;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.BlackWhiteSet;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpCommand;
import net.sf.gogui.gtp.GtpEngine;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.ObjectUtil;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** GTP adapter for playing games between two Go programs. */
public class TwoGtp
    extends GtpEngine
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TwoGtp.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -5054803065813422292L,/* translation unit id   */ 1397166569375234022L,/* timestamp             */ 1709177903877L,/* source file name      */ "TwoGtp.java",/* probe size            */ 330);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param komi The fixed komi. See TwoGtp documentation for option
        -komi */
    public TwoGtp(Program black, Program white, Program referee,
                  String observer, int size, Komi komi, int numberGames,
                  boolean alternate, String filePrefix, boolean verbose,
                  Openings openings, TimeSettings timeSettings,
                  ResultFile resultFile)
        throws Exception
    {
        super(null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(0);
        assert size > 0;
        assert size <= GoPoint.MAX_SIZE;
        assert komi != null;
        m_filePrefix = filePrefix;
        m_allPrograms = new ArrayList<Program>();
        m_black = black;
        m_allPrograms.add(m_black);
        m_white = white;
        m_allPrograms.add(m_white);
        m_referee = referee;
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(1);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(3) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(2);m_allPrograms.add(m_referee);}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(4);if ((observer.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(6) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(5);m_observer = null;}
        else
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(10);m_observer = new Program(observer, "Observer", "O", verbose);
            m_allPrograms.add(m_observer);
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(7);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(9);program.setLabel(m_allPrograms);}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(8);m_size = size;
        m_komi = komi;
        m_alternate = alternate;
        m_numberGames = numberGames;
        m_openings = openings;
        m_verbose = verbose;
        m_timeSettings = timeSettings;
        m_resultFile = resultFile;
        initGame(size);
    }

    public void autoPlay() throws Exception
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(11);StringBuilder response = new StringBuilder(256);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(12);while (true)
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(13);try
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(21);newGame(m_size);
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(22);while ((! gameOver()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(24) && false))
                {
                    $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(23);response.setLength(0);
                    sendGenmove(getToMove(), response);
                }
            }
            catch (GtpError e)
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(25);if ((m_gameIndex == -1) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(27) && false))
                    {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(26);break;}
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(28);handleEndOfGame(true, e.getMessage());
            }
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(15);if ((m_black.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(17) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(16);throw new ErrorMessage("Black program died");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(18);if ((m_white.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(20) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(19);throw new ErrorMessage("White program died");}
    }

    public void close()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(29);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(30);program.close();}
    }

    public void handleCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(31);String command = cmd.getCommand();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(32);if ((command.equals("boardsize")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(34) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(33);cmdBoardSize(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(35);if ((command.equals("clear_board")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(37) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(36);cmdClearBoard(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(38);if ((command.equals("final_score")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(40) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(39);finalStatusCommand(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(41);if ((command.equals("final_status")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(43) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(42);finalStatusCommand(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(44);if ((command.equals("final_status_list")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(46) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(45);finalStatusCommand(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(47);if ((command.equals("gogui-interrupt")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(49) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(48);;}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(50);if ((command.equals("gogui-title")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(52) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(51);cmd.setResponse(getTitle());}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(53);if ((command.equals("gogui-twogtp-black")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(55) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(54);twogtpColor(m_black, cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(56);if ((command.equals("gogui-twogtp-white")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(58) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(57);twogtpColor(m_white, cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(59);if ((command.equals("gogui-twogtp-referee")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(61) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(60);twogtpReferee(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(62);if ((command.equals("gogui-twogtp-observer")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(64) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(63);twogtpObserver(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(65);if ((command.equals("quit")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(67) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(66);close();
            setQuit();
        }
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(68);if ((command.equals("play")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(70) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(69);cmdPlay(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(71);if ((command.equals("undo")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(73) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(72);cmdUndo(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(74);if ((command.equals("genmove")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(76) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(75);cmdGenmove(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(77);if ((command.equals("komi")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(79) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(78);komi(cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(80);if ((command.equals("scoring_system")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(82) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(81);sendIfSupported(command, cmd.getLine());}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(83);if ((command.equals("name")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(85) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(84);cmd.setResponse("gogui-twogtp");}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(86);if ((command.equals("version")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(88) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(87);cmd.setResponse(Version.get());}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(89);if ((command.equals("protocol_version")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(91) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(90);cmd.setResponse("2");}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(92);if ((command.equals("list_commands")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(94) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(93);cmd.setResponse("boardsize\n" +
                            "clear_board\n" +
                            "final_score\n" +
                            "final_status\n" +
                            "final_status_list\n" +
                            "genmove\n" +
                            "gogui-interrupt\n" +
                            "gogui-title\n" +
                            "komi\n" +
                            "list_commands\n" +
                            "name\n" +
                            "play\n" +
                            "quit\n" +
                            "scoring_system\n" +
                            "time_settings\n" +
                            "gogui-twogtp-black\n" +
                            "gogui-twogtp-observer\n" +
                            "gogui-twogtp-referee\n" +
                            "gogui-twogtp-white\n" +
                            "undo\n" +
                            "version\n");}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(95);if ((GtpUtil.isStateChangingCommand(command)) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(97) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(96);throw new GtpError("unknown command");}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(98);if ((command.equals("time_settings")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(100) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(99);sendIfSupported(command, cmd.getLine());}
        else
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(101);boolean isExtCommandBlack = m_black.isSupported(command);
            boolean isExtCommandWhite = m_white.isSupported(command);
            boolean isExtCommandReferee = false;
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(102);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(104) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(103);isExtCommandReferee = m_referee.isSupported(command);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(105);boolean isExtCommandObserver = false;
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(106);if ((m_observer != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(108) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(107);isExtCommandObserver = m_observer.isSupported(command);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(109);if ((isExtCommandBlack && ! isExtCommandObserver
                && ! isExtCommandWhite && ! isExtCommandReferee) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(111) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(110);forward(m_black, cmd);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(112);if ((isExtCommandWhite && ! isExtCommandObserver
                && ! isExtCommandBlack && ! isExtCommandReferee) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(114) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(113);forward(m_white, cmd);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(115);if ((isExtCommandReferee && ! isExtCommandObserver
                && ! isExtCommandBlack && ! isExtCommandWhite) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(117) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(116);forward(m_referee, cmd);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(118);if ((isExtCommandObserver && ! isExtCommandReferee
                && ! isExtCommandBlack && ! isExtCommandWhite) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(120) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(119);forward(m_observer, cmd);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(121);if ((! isExtCommandReferee
                && ! isExtCommandBlack
                && ! isExtCommandObserver
                && ! isExtCommandWhite) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(123) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(122);throw new GtpError("unknown command");}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(124);throw new GtpError("use gogui-twogtp-black/white/referee/observer");
        }}}}}}}}}}}}}}}}}}}}}}}
    }

    public void interruptCommand()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(125);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(126);program.interruptProgram();}
    }

    /** Store stderr of programs during move generation in SGF comments. */
    public void setDebugToComment(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(127);m_black.setIOCallback(null);
        m_white.setIOCallback(null);
        m_debugToComment = enable;
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(128);if ((m_debugToComment) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(130) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(129);m_black.setIOCallback(new GtpClient.IOCallback()
                {
                    public void receivedInvalidResponse(String s) { }

                    public void receivedResponse(boolean error, String s) { }

                    public void receivedStdErr(String s)
                    {
                        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(131);appendDebugToCommentBuffer(BLACK, s);
                    }

                    public void sentCommand(String s) { }
                });
            m_white.setIOCallback(new GtpClient.IOCallback()
                {
                    public void receivedInvalidResponse(String s) { }

                    public void receivedResponse(boolean error, String s) { }

                    public void receivedStdErr(String s)
                    {
                        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(132);appendDebugToCommentBuffer(WHITE, s);
                    }

                    public void sentCommand(String s) { }
                });
        }
    }

    /** Limit number of moves.
        @param maxMoves Maximum number of moves after which genmove will fail,
        -1 for no limit. */
    public void setMaxMoves(int maxMoves)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(133);m_maxMoves = maxMoves;
    }

    private final boolean m_alternate;

    private boolean m_gameSaved;

    private boolean m_debugToComment;

    private int m_maxMoves = 1000;

    private int m_gameIndex;

    private boolean m_resigned;

    private final boolean m_verbose;

    private final int m_numberGames;

    private final int m_size;

    /** Fixed komi. */
    private final Komi m_komi;

    private Game m_game;

    private GoColor m_resignColor;

    private final Openings m_openings;

    private final Program m_black;

    private final Program m_white;

    private final Program m_referee;

    private final Program m_observer;

    private final ArrayList<Program> m_allPrograms;

    private final BlackWhiteSet<Double> m_realTime =
        new BlackWhiteSet<Double>(0., 0.);

    private String m_openingFile;

    private final String m_filePrefix;

    private final ArrayList<ArrayList<Compare.Placement>> m_games
        = new ArrayList<ArrayList<Compare.Placement>>(100);

    private ResultFile m_resultFile;

    private final TimeSettings m_timeSettings;

    private ConstNode m_lastOpeningNode;

    /** Buffers for stderr of programs if setDebugToComment() is used.
        This member is used by two threads. Access only through synchronized
        functions. */
    private BlackWhiteSet<StringBuilder> m_debugToCommentBuffer =
        new BlackWhiteSet<StringBuilder>(new StringBuilder(),
                                         new StringBuilder());

    private synchronized void appendDebugToCommentBuffer(GoColor c, String s)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(134);m_debugToCommentBuffer.get(c).append(s);
    }

    private void checkInconsistentState() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(135);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(136);if ((program.isOutOfSync()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(138) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(137);throw new GtpError("Inconsistent state");}}
    }

    private synchronized void clearDebugToCommentBuffers()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(139);m_debugToCommentBuffer.get(BLACK).setLength(0);
        m_debugToCommentBuffer.get(WHITE).setLength(0);
    }

    private void cmdBoardSize(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(140);cmd.checkNuArg(1);
        int size = cmd.getIntArg(0, 1, GoPoint.MAX_SIZE);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(141);if ((size != m_size) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(143) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(142);throw new GtpError("Size must be " + m_size);}
    }

    private void cmdClearBoard(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(144);cmd.checkArgNone();
        newGame(m_size);
    }

    private void cmdGenmove(GtpCommand cmd) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(145);sendGenmove(cmd.getColorArg(), cmd.getResponse());
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(146);throw new GtpError(e.getMessage());
        }
    }

    private void cmdPlay(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(147);cmd.checkNuArg(2);
        checkInconsistentState();
        GoColor color = cmd.getColorArg(0);
        GoPoint point = cmd.getPointArg(1, m_size);
        Move move = Move.get(color, point);
        m_game.play(move);
        synchronize();
    }

    private void cmdUndo(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(148);cmd.checkArgNone();
        int moveNumber = m_game.getMoveNumber();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(149);if ((moveNumber == 0) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(151) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(150);throw new GtpError("cannot undo");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(152);m_game.gotoNode(getCurrentNode().getFatherConst());
        assert m_game.getMoveNumber() == moveNumber - 1;
        synchronize();
    }

    private void finalStatusCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(153);checkInconsistentState();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(154);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(156) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(155);forward(m_referee, cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(157);if ((m_black.isSupported("final_status")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(159) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(158);forward(m_black, cmd);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(160);if ((m_white.isSupported("final_status")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(162) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(161);forward(m_white, cmd);}
        else
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(163);throw new GtpError("neither player supports final_status");}}}
    }

    private void forward(Program program, GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(164);cmd.setResponse(program.send(cmd.getLine()));
    }

    private boolean gameOver()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(165);return (getBoard().bothPassed() || m_resigned);
    }

    private ConstBoard getBoard()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(166);return m_game.getBoard();
    }

    private ConstNode getCurrentNode()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(167);return m_game.getCurrentNode();
    }

    private synchronized String getDebugToCommentBuffer(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(168);return m_debugToCommentBuffer.get(color).toString();
    }

    private GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(169);return m_game.getToMove();
    }

    private ConstGameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(170);return m_game.getTree();
    }

    private String getTitle()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(171);StringBuilder buffer = new StringBuilder();
        String nameBlack = m_black.getLabel();
        String nameWhite = m_white.getLabel();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(172);if ((isAlternated()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(174) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(173);String tmpName = nameBlack;
            nameBlack = nameWhite;
            nameWhite = tmpName;
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(175);buffer.append(nameWhite);
        buffer.append(" vs. ");
        buffer.append(nameBlack);
        buffer.append(" (B)");
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(176);if ((! m_filePrefix.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(178) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(177);buffer.append(" (");
            buffer.append(m_gameIndex + 1);
            buffer.append(')');
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(179);return buffer.toString();
    }

    private void handleEndOfGame(boolean error, String errorMessage)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(180);String resultBlack;
        String resultWhite;
        String resultReferee;
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(181);if ((m_resigned) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(183) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(182);String result = (((m_resignColor == BLACK) ? ($qualityscroll_cover_jacov_probe_1363bb97a3a977e6(184) || true) : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(185) && false)) ? "W" : "B");
            result = result + "+R";
            resultBlack = result;
            resultWhite = result;
            resultReferee = result;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(218);resultBlack = m_black.getResult();
            resultWhite = m_white.getResult();
            resultReferee = "?";
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(219);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(221) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(220);resultReferee = m_referee.getResult();}
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(186);double cpuTimeBlack = m_black.getAndClearCpuTime();
        double cpuTimeWhite = m_white.getAndClearCpuTime();
        double realTimeBlack = m_realTime.get(BLACK);
        double realTimeWhite = m_realTime.get(WHITE);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(187);if ((isAlternated()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(189) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(188);resultBlack = inverseResult(resultBlack);
            resultWhite = inverseResult(resultWhite);
            resultReferee = inverseResult(resultReferee);
            realTimeBlack = m_realTime.get(WHITE);
            realTimeWhite = m_realTime.get(BLACK);
        }
        // If a program is dead we wait for a few seconds, because it
        // could be because the TwoGtp process was killed and we don't
        // want to write a result in this case.
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(190);if ((m_black.isProgramDead() || m_white.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(192) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(191);try
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(193);Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(217);assert false;
            }
        }

        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(194);String nameBlack = m_black.getLabel();
        String nameWhite = m_white.getLabel();
        String blackCommand = m_black.getProgramCommand();
        String whiteCommand = m_white.getProgramCommand();
        String blackVersion = m_black.getVersion();
        String whiteVersion = m_white.getVersion();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(195);if ((isAlternated()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(197) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(196);nameBlack = m_white.getLabel();
            nameWhite = m_black.getLabel();
            blackCommand = m_white.getProgramCommand();
            whiteCommand = m_black.getProgramCommand();
            blackVersion = m_white.getVersion();
            whiteVersion = m_black.getVersion();
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(198);m_game.setPlayer(BLACK, nameBlack);
        m_game.setPlayer(WHITE, nameWhite);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(199);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(201) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(200);m_game.setResult(resultReferee);}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(214);if ((resultBlack.equals(resultWhite) && ! resultBlack.equals("?")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(216) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(215);m_game.setResult(resultBlack);}}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(202);String host = Platform.getHostInfo();
        StringBuilder comment = new StringBuilder();
        comment.append("Black command: ");
        comment.append(blackCommand);
        comment.append("\nWhite command: ");
        comment.append(whiteCommand);
        comment.append("\nBlack version: ");
        comment.append(blackVersion);
        comment.append("\nWhite version: ");
        comment.append(whiteVersion);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(203);if ((m_openings != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(205) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(204);comment.append("\nOpening: ");
            comment.append(m_openingFile);
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(206);comment.append("\nResult[Black]: ");
        comment.append(resultBlack);
        comment.append("\nResult[White]: ");
        comment.append(resultWhite);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(207);if ((m_referee != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(209) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(208);comment.append("\nReferee: ");
            comment.append(m_referee.getProgramCommand());
            comment.append("\nResult[Referee]: ");
            comment.append(resultReferee);
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(210);comment.append("\nHost: ");
        comment.append(host);
        comment.append("\nDate: ");
        comment.append(StringUtil.getDate());
        m_game.setComment(comment.toString(), getTree().getRootConst());
        int moveNumber = NodeUtil.getMoveNumber(getCurrentNode());
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(211);if ((m_resultFile != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(213) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(212);m_resultFile.addResult(m_gameIndex, m_game, resultBlack,
                                   resultWhite, resultReferee, isAlternated(),
                                   moveNumber, error, errorMessage,
                                   realTimeBlack, realTimeWhite, cpuTimeBlack,
                                   cpuTimeWhite);}
    }

    private void initGame(int size) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(222);m_game = new Game(size, m_komi, null, null, null);
        m_realTime.set(BLACK, 0.);
        m_realTime.set(WHITE, 0.);
        // Clock is not needed
        m_game.haltClock();
        m_resigned = false;
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(223);if ((m_openings != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(225) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(224);int openingFileIndex;
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(226);if ((m_alternate) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(228) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(227);openingFileIndex = (m_gameIndex / 2) % m_openings.getNumber();}
            else
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(240);openingFileIndex = m_gameIndex % m_openings.getNumber();}
            try
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(229);m_openings.loadFile(openingFileIndex);
            }
            catch (Exception e)
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(239);throw new GtpError(e.getMessage());
            }
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(230);m_openingFile = m_openings.getFilename();
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(231);if ((m_verbose) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(233) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(232);System.err.println("Loaded opening " + m_openingFile);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(234);if ((m_openings.getBoardSize() != size) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(236) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(235);throw new GtpError("Wrong board size: " + m_openingFile);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(237);m_game.init(m_openings.getTree());
            m_game.setKomi(m_komi);
            m_lastOpeningNode = NodeUtil.getLast(getTree().getRootConst());
            // TODO: Check that root node contains no setup stones, if
            // TwoGtp is run as a GTP engine, see also comment in sendGenmove()
        }
        else
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(241);m_lastOpeningNode = null;}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(238);synchronizeInit();
    }

    private String inverseResult(String result)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(242);if ((result.indexOf('B') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(244) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(243);return result.replaceAll("B", "W");}
        else {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(245);if ((result.indexOf('W') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(247) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(246);return result.replaceAll("W", "B");}
        else
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(248);return result;}}
    }

    private boolean isAlternated()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(249);return (m_alternate && m_gameIndex % 2 != 0);
    }

    private boolean isInOpening()
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(250);if ((m_lastOpeningNode == null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(252) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(251);return false;}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(253);for (ConstNode node = getCurrentNode().getChildConst(); (node != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(255) && false);
             node = node.getChildConst())
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(254);if ((node == m_lastOpeningNode) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(258) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(257);return true;}}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(256);return false;
    }

    private void komi(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(259);String arg = cmd.getArg();
        try
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(260);Komi komi = Komi.parseKomi(arg);
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(261);if ((! ObjectUtil.equals(komi, m_komi)) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(263) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(262);throw new GtpError("komi is fixed at " + m_komi);}
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(264);throw new GtpError("invalid komi: " + arg);
        }
    }

    private void newGame(int size) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(265);if ((m_resultFile != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(267) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(266);m_gameIndex = m_resultFile.getNextGameIndex();}
        else
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(278);++m_gameIndex;
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(279);if ((m_numberGames > 0 && m_gameIndex > m_numberGames) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(281) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(280);m_gameIndex = -1;}
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(268);if ((m_gameIndex == -1) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(270) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(269);throw new GtpError("maximum number of games reached");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(271);if ((m_verbose) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(273) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(272);System.err.println("============================================");
            System.err.println("Game " + m_gameIndex);
            System.err.println("============================================");
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(274);m_black.getAndClearCpuTime();
        m_white.getAndClearCpuTime();
        initGame(size);
        m_gameSaved = false;
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(275);if ((m_timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(277) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(276);sendIfSupported("time_settings",
                            GtpUtil.getTimeSettingsCommand(m_timeSettings));}
    }

    private void sendGenmove(GoColor color, StringBuilder response)
        throws GtpError, ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(282);checkInconsistentState();
        int moveNumber = m_game.getMoveNumber();
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(283);if ((m_maxMoves >= 0 && moveNumber > m_maxMoves) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(285) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(284);throw new GtpError("move limit exceeded");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(286);if ((isInOpening()) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(288) && false))
        {
            // TODO: Check that node contains no setup stones or fully support
            // openings with setup stones and non-alternating moves in GTP
            // engine mode again (by transforming the opening file into a
            // sequence of alternating moves, replacing setup stones by moves
            // and filling in passes). See also comment in initGame() and
            // doc/manual/xml/reference-twogtp.xml
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(287);ConstNode child = getCurrentNode().getChildConst();
            Move move = child.getMove();
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(289);if ((move.getColor() != color) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(291) && false))
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(290);throw new GtpError("next opening move is " + move);}
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(292);m_game.gotoNode(child);
            synchronize();
            response.append(GoPoint.toString(move.getPoint()));
            return;
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(293);Program program;
        boolean exchangeColors =
            (color == BLACK && isAlternated())
            || (color == WHITE && ! isAlternated());
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(294);if ((exchangeColors) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(296) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(295);program = m_white;}
        else
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(314);program = m_black;}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(297);clearDebugToCommentBuffers();
        long timeMillis = System.currentTimeMillis();
        String responseGenmove = program.sendCommandGenmove(color);
        double time = (System.currentTimeMillis() - timeMillis) / 1000.;
        m_realTime.set(color, m_realTime.get(color) + time);
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(298);if ((responseGenmove.equalsIgnoreCase("resign")) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(300) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(299);response.append("resign");
            m_resigned = true;
            m_resignColor = color;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(304);ConstBoard board = getBoard();
            GoPoint point = null;
            try
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(305);point = GtpUtil.parsePoint(responseGenmove, board.getSize());
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(313);throw new GtpError(program.getLabel()
                                   + " played invalid move: "
                                   + responseGenmove);
            }
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(306);Move move = Move.get(color, point);
            m_game.play(move);
            program.updateAfterGenmove(board);
            synchronize();
            response.append(GoPoint.toString(move.getPoint()));
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(307);if ((m_debugToComment) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(309) && false))
            {
                // All stderr that was written by the program before the
                // response to genmove should have been received by now, but
                // maybe the IO callback thread had no chance to run yet, so we
                // wait for an extra 10 milliseconds
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(308);try
                {
                    $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(310);Thread.sleep(10);
                }
                catch (InterruptedException e)
                {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(312);
                }
                $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(311);m_game.setComment(getDebugToCommentBuffer(color));
            }
        }
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(301);if ((gameOver() && ! m_gameSaved) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(303) && false))
        {
            $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(302);handleEndOfGame(false, "");
            m_gameSaved = true;
        }
    }

    private void sendIfSupported(String cmd, String cmdLine)
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(315);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(316);program.sendIfSupported(cmd, cmdLine);}
    }

    private void synchronize() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(317);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(318);program.synchronize(m_game);}
    }

    private void synchronizeInit() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(319);for (Program program : m_allPrograms)
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(320);program.synchronizeInit(m_game);}
    }

    private void twogtpColor(Program program, GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(321);cmd.setResponse(program.send(cmd.getArgLine()));
    }

    private void twogtpObserver(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(322);if ((m_observer == null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(324) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(323);throw new GtpError("no observer enabled");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(325);twogtpColor(m_observer, cmd);
    }

    private void twogtpReferee(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(326);if ((m_referee == null) ? true : (!$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(328) && false))
            {$qualityscroll_cover_jacov_probe_1363bb97a3a977e6(327);throw new GtpError("no referee enabled");}
        $qualityscroll_cover_jacov_probe_1363bb97a3a977e6(329);twogtpColor(m_referee, cmd);
    }
}
