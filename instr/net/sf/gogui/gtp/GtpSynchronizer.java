/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpSynchronizer.java

package net.sf.gogui.gtp;

import java.util.ArrayList;
import java.util.List;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;
import static net.sf.gogui.go.GoColor.WHITE_BLACK;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.util.ObjectUtil;

/** Synchronizes a GTP engine with a Go board.
    Handles different capabilities of different engines.
    If GtpSynchronizer is used, no game state changing GTP commands (like
    clear_board, play, undo, komi, time_settings) should be sent to this
    engine outside this class. */
public class GtpSynchronizer
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpSynchronizer.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -498076177157181839L,/* translation unit id   */ 4072911299210419756L,/* timestamp             */ 1709177901618L,/* source file name      */ "GtpSynchronizer.java",/* probe size            */ 149);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Callback that is called after each change in the engine's move
        number.
        Necessary, because sending multiple undo or play commands can be
        a slow operation. */
    public interface Listener
    {
        void moveNumberChanged(int moveNumber);
    }

    public GtpSynchronizer(GtpClientBase gtp)
    {
        this(gtp, null, false);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(0);
    }

    public GtpSynchronizer(GtpClientBase gtp, Listener listener,
                           boolean fillPasses)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(1);m_fillPasses = fillPasses;
        m_gtp = gtp;
        m_listener = listener;
        m_isOutOfSync = true;
        m_komi = null;
        m_timeSettings = null;
    }

    /** Did the last GtpSynchronizer.synchronize() fail? */
    public boolean isOutOfSync()
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(2);return m_isOutOfSync;
    }

    public void init(ConstBoard board, Komi komi, TimeSettings timeSettings)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(3);initSupportedCommands();
        m_isOutOfSync = true;
        int size = board.getSize();
        m_engineState = null;
        m_gtp.sendBoardsize(size);
        m_engineState = new Board(size);
        m_gtp.sendClearBoard(size);
        sendGameInfo(komi, timeSettings);
        ConstBoard targetState = computeTargetState(board);
        setup(targetState);
        ArrayList<Move> moves = new ArrayList<Move>();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(4);for (int i = 0; (i < targetState.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(6) && false); ++i)
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(5);moves.add(targetState.getMove(i));}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(7);play(moves);
        m_isOutOfSync = false;
    }

    public void synchronize(ConstBoard board, Komi komi,
                            TimeSettings timeSettings) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(8);int size = board.getSize();
        ConstBoard targetState = computeTargetState(board);
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(9);if ((m_engineState == null || size != m_engineState.getSize()
            || isSetupDifferent(targetState)) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(11) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(10);init(board, komi, timeSettings);
            return;
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(12);m_isOutOfSync = true;
        ArrayList<Move> moves = new ArrayList<Move>();
        int numberUndo = computeToPlay(moves, targetState);
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(13);if ((numberUndo == 0 || m_isSupportedUndo || m_isSupportedGGUndo) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(15) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(14);try
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(16);undo(numberUndo);
            }
            catch (GtpError e)
            {
                // According to the GTP standard, undo may fail even if it is
                // supported and there were moves played. In this case, we
                // fall back to a full initialization.
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(18);init(board, komi, timeSettings);
                return;
            }
            // Send komi/time_settings before play commands, some engines
            // cannot handle them otherwise
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(17);sendGameInfo(komi, timeSettings);
            play(moves);
            m_isOutOfSync = false;
        }
        else
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(19);init(board, komi, timeSettings);}
    }

    /** Send human move to engine.
        The move is not played on the board yet. This function is useful,
        if it should be first tested, if the engine accepts a move, before
        playing it on the board, e.g. after a new human move was entered. */
    public void updateHumanMove(ConstBoard board, Move move) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(20);ConstBoard targetState = computeTargetState(board);
        assert findNumberCommonMoves(targetState)
            == targetState.getNumberMoves();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(21);if ((m_fillPasses && m_engineState.getNumberMoves() > 0) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(23) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(22);Move lastMove = m_engineState.getLastMove();
            GoColor c = move.getColor();
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(24);if ((lastMove.getColor() == c) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(26) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(25);play(Move.getPass(c.otherColor()));}
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(27);play(move);
    }

    /** Update internal state after genmove.
        Needs to be called after each genmove (or kgs-genmove_cleanup)
        command. The computer move is expected to be already played on the
        board, but does not need to be transmitted to the program anymore,
        because genmove already executes the move at the program's side. */
    public void updateAfterGenmove(ConstBoard board)
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(28);Move move = board.getLastMove();
        assert move != null;
        m_engineState.play(move);
        try
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(29);ConstBoard targetState = computeTargetState(board);
            assert findNumberCommonMoves(targetState)
                == targetState.getNumberMoves();
        }
        catch (GtpError e)
        {
            // computeTargetState should not throw (no new setup
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(30);assert false;
        }
    }

    private boolean m_fillPasses;

    private boolean m_isOutOfSync;

    private boolean m_isSupportedHandicap;

    private boolean m_isSupportedPlaySequence;

    private boolean m_isSupportedSetupPlayer;

    private boolean m_isSupportedGGUndo;

    private boolean m_isSupportedUndo;

    private boolean m_isSupportedSetup;

    private Komi m_komi;

    private TimeSettings m_timeSettings;

    private final Listener m_listener;

    private GtpClientBase m_gtp;

    private Board m_engineState;

    /** Computes all actions to execute.
        Replaces setup stones by moves, if setup is not supported.
        Fills in passes between moves of same color if m_fillPasses. */
    private Board computeTargetState(ConstBoard board) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(31);int size = board.getSize();
        Board targetState = new Board(size);
        ConstPointList setupBlack = board.getSetup(BLACK);
        ConstPointList setupWhite = board.getSetup(WHITE);
        GoColor setupPlayer = board.getSetupPlayer();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(32);if ((setupBlack.size() > 0 || setupWhite.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(34) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(33);targetState.clear();
            boolean isHandicap = board.isSetupHandicap();
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(35);if ((isHandicap && m_isSupportedHandicap) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(37) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(36);targetState.setupHandicap(setupBlack);}
            else {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(46);if ((m_isSupportedSetup) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(48) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(47);targetState.setup(setupBlack, setupWhite, setupPlayer);}
            else
            {
                // Translate setup into moves
                // Send moves of color to move first, such that the right color
                // is to move after the setup (works only if there are setup
                // stones by both colors)
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(49);List<GoColor> colors;
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(50);if ((setupPlayer == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(52) && false))
                    {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(51);colors = BLACK_WHITE;}
                else
                    {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(59);colors = WHITE_BLACK;}
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(53);for (GoColor c : colors)
                {
                    $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(54);for (GoPoint p : board.getSetup(c))
                    {
                        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(55);if ((targetState.isCaptureOrSuicide(c, p)) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(57) && false))
                        {
                            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(56);String message =
                                "cannot transmit setup as " +
                                "move if stones are captured";
                            throw new GtpError(message);
                        }
                        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(58);targetState.play(Move.get(c, p));
                    }
                }
            }}
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(38);for (int i = 0; (i < board.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(40) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(39);Move move = board.getMove(i);
            GoColor toMove = targetState.getToMove();
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(42);if ((m_fillPasses && move.getColor() != toMove) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(44) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(43);targetState.play(Move.getPass(toMove));}
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(45);targetState.play(move);
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(41);return targetState;
    }

    /** Compute number of moves to undo and moves to execute.
        @return Number of moves to undo. */
    private int computeToPlay(ArrayList<Move> moves, ConstBoard targetState)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(60);int numberCommonMoves = findNumberCommonMoves(targetState);
        int numberUndo = m_engineState.getNumberMoves() - numberCommonMoves;
        moves.clear();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(61);for (int i = numberCommonMoves; (i < targetState.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(63) && false); ++i)
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(62);moves.add(targetState.getMove(i));}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(64);return numberUndo;
    }

    private int findNumberCommonMoves(ConstBoard targetState)
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(65);int i;
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(66);for (i = 0; (i < targetState.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(68) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(67);if ((i >= m_engineState.getNumberMoves()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(71) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(70);break;}
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(72);Move move = targetState.getMove(i);
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(73);if ((! move.equals(m_engineState.getMove(i))) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(75) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(74);break;}
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(69);return i;
    }

    private boolean isSetupDifferent(ConstBoard targetState)
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(76);if ((m_engineState.isSetupHandicap() != targetState.isSetupHandicap()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(78) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(77);return true;}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(79);if ((! ObjectUtil.equals(m_engineState.getSetupPlayer(),
                                targetState.getSetupPlayer())) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(81) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(80);return true;}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(82);for (GoColor c : BLACK_WHITE)
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(84);if ((! m_engineState.getSetup(c).equals(targetState.getSetup(c))) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(86) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(85);return true;}}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(83);return false;
    }

    private void initSupportedCommands()
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(87);m_isSupportedPlaySequence =
            GtpClientUtil.isPlaySequenceSupported(m_gtp);
        m_isSupportedUndo = isSupported("undo");
        m_isSupportedGGUndo = isSupported("gg-undo");
        m_isSupportedSetup = isSupported("gogui-setup");
        m_isSupportedSetupPlayer = isSupported("gogui-setup_player");
        m_isSupportedHandicap = isSupported("set_free_handicap");
    }

    private boolean isSupported(String command)
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(88);return m_gtp.isSupported(command);
    }

    private void play(Move move) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(89);m_gtp.sendPlay(move);
        m_engineState.play(move);
    }

    private void play(ArrayList<Move> moves) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(90);if ((moves.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(92) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(91);return;}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(93);if ((moves.size() > 1 && m_isSupportedPlaySequence) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(95) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(94);String cmd = GtpClientUtil.getPlaySequenceCommand(m_gtp, moves);
            m_gtp.send(cmd);
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(96);for (int i = 0; (i < moves.size()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(98) && false); ++i)
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(97);m_engineState.play(moves.get(i));}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(99);for (int i = 0; (i < moves.size()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(101) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(100);play(moves.get(i));
                updateListener();
            }
        }
    }

    private void sendGameInfo(Komi komi, TimeSettings timeSettings)
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(102);if ((! ObjectUtil.equals(komi, m_komi)) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(104) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(103);m_komi = komi;
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(105);if ((m_gtp.isSupported("komi")) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(107) && false))
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(106);try
                {
                    // Use Komi.toString(Komi), which interprets null argument
                    // (undefined komi) as zero komi. If we did nothing if the
                    // komi value is not defined, the engine would use the
                    // old komi value if a komi was set previously (e.g. from a
                    // previously loaded file)
                    $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(108);m_gtp.send("komi " + Komi.toString(komi));
                }
                catch (GtpError e)
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(117);
                }
            }
        }
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(109);if ((! ObjectUtil.equals(timeSettings, m_timeSettings)) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(111) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(110);m_timeSettings = timeSettings;
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(112);if ((m_gtp.isSupported("time_settings")) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(114) && false))
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(113);try
                {
                    $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(115);m_gtp.send(GtpUtil.getTimeSettingsCommand(timeSettings));
                }
                catch (GtpError e)
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(116);
                }
            }
        }
    }

    private void setup(ConstBoard targetState) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(118);ConstPointList setupBlack = targetState.getSetup(BLACK);
        ConstPointList setupWhite = targetState.getSetup(WHITE);
        GoColor setupPlayer = targetState.getSetupPlayer();
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(119);if ((setupBlack.size() == 0 && setupWhite.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(121) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(120);return;}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(122);if ((targetState.isSetupHandicap()) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(124) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(123);StringBuilder command = new StringBuilder(128);
            command.append("set_free_handicap");
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(125);for (GoPoint p : setupBlack)
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(127);command.append(' ');
                command.append(p);
            }
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(126);m_gtp.send(command.toString());
            m_engineState.setupHandicap(setupBlack);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(128);StringBuilder command = new StringBuilder(128);
            command.append("gogui-setup");
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(129);for (GoColor c : BLACK_WHITE)
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(134);for (GoPoint p : targetState.getSetup(c))
                {
                    $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(135);command.append(' ');
                    command.append(Move.get(c, p));
                }
            }
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(130);m_gtp.send(command.toString());
            m_engineState.setup(setupBlack, setupWhite, setupPlayer);
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(131);if ((setupPlayer != null && m_isSupportedSetupPlayer) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(133) && false))
                {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(132);m_gtp.send("gogui-setup_player "
                           + setupPlayer.getUppercaseLetter());}
        }
    }

    private void undo(int n) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(136);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(138) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(137);return;}
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(139);if ((m_isSupportedGGUndo && (n > 1 || ! m_isSupportedUndo)) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(141) && false))
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(140);m_gtp.send("gg-undo " + n);
            m_engineState.undo(n);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(142);assert m_isSupportedUndo;
            $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(143);for (int i = 0; (i < n) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(145) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(144);m_gtp.send("undo");
                m_engineState.undo();
                updateListener();
            }
        }
    }

    private void updateListener()
    {
        $qualityscroll_cover_jacov_probe_3885e33f571c9e2c(146);if ((m_listener != null) ? true : (!$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(148) && false))
            {$qualityscroll_cover_jacov_probe_3885e33f571c9e2c(147);m_listener.moveNumberChanged(m_engineState.getNumberMoves());}
    }
}
