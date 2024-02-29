/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiGtpClient.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.text.MessageFormat;
import javax.swing.SwingUtilities;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpClientBase;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpSynchronizer;
import static net.sf.gogui.gui.I18n.i18n;

/** Wrapper around gtp.GtpClient to be used in a GUI environment.
    Allows to send fast commands with the GtpClientBase.send() function
    immediately in the event dispatch thread and potentially slow commands in
    a separate thread with a callback in the event thread after the command
    finished.
    Fast commands are ones that the Go engine is supposed to answer quickly
    (like boardsize, play and undo), however they have a timeout to
    prevent the GUI to hang, if the program does not respond.
    After the timeout a dialog is opened that allows to kill the program or
    continue to wait.
    This class also contains a GtpSynchronizer. */
public class GuiGtpClient
    extends GtpClientBase
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiGtpClient.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3620867753564016146L,/* translation unit id   */ -6281151002742924170L,/* timestamp             */ 1709177902454L,/* source file name      */ "GuiGtpClient.java",/* probe size            */ 42);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GuiGtpClient(GtpClient gtp, Component owner,
                        GtpSynchronizer.Listener listener,
                        MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(0);m_gtp = gtp;
        m_owner = owner;
        m_messageDialogs = messageDialogs;
        m_gtpSynchronizer = new GtpSynchronizer(this, listener, false);
        Thread thread = new Thread() {
                @Override
				public void run() {
                    synchronized (m_mutex)
                    {
                        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(1);boolean firstWait = true;
                        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(2);while (true)
                        {
                            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(3);try
                            {
                                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(5);if ((m_command == null || ! firstWait) ? true : (!$qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(7) && false))
                                    {$qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(6);m_mutex.wait();}
                            }
                            catch (InterruptedException e)
                            {
                                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(12);System.err.println("Interrupted");
                            }
                            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(8);firstWait = false;
                            m_response = null;
                            m_exception = null;
                            try
                            {
                                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(9);m_response = m_gtp.send(m_command);
                            }
                            catch (GtpError e)
                            {
                                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(11);m_exception = e;
                            }
                            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(10);SwingUtilities.invokeLater(m_callback);
                        }
                    }
                }
            };
        thread.start();
    }

    @Override
	public void close()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(13);if ((! isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(15) && false))
        {
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(14);m_gtp.close();
            TimeoutCallback timeoutCallback = new TimeoutCallback(null);
            m_gtp.waitForExit(TIMEOUT, timeoutCallback);
        }
    }

    public void destroyGtp()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(16);m_gtp.destroyProcess();
    }

    public boolean getAnyCommandsResponded()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(17);return m_gtp.getAnyCommandsResponded();
    }

    /** Get exception of asynchronous command.
        You must call this before you are allowed to send new a command. */
    public GtpError getException()
    {
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(18);assert SwingUtilities.isEventDispatchThread();
            assert m_commandInProgress;
            m_commandInProgress = false;
            return m_exception;
        }
    }

    public String getProgramCommand()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(19);return m_gtp.getProgramCommand();
    }

    /** Get response to asynchronous command.
        You must call getException() first. */
    public String getResponse()
    {
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(20);assert SwingUtilities.isEventDispatchThread();
            assert ! m_commandInProgress;
            return m_response;
        }
    }

    public void initSynchronize(ConstBoard board, Komi komi,
                                TimeSettings timeSettings) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(21);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        m_gtpSynchronizer.init(board, komi, timeSettings);
    }

    public boolean isCommandInProgress()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(22);return m_commandInProgress;
    }

    public boolean isOutOfSync()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(23);return m_gtpSynchronizer.isOutOfSync();
    }

    @Override
	public boolean isProgramDead()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(24);assert SwingUtilities.isEventDispatchThread();
        return m_gtp.isProgramDead();
    }

    /** Send asynchronous command. */
    public void send(String command, Runnable callback)
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(25);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(26);m_command = command;
            m_callback = callback;
            m_commandInProgress = true;
            m_mutex.notifyAll();
        }
    }

    @Override
	public void sendComment(String comment)
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(27);m_gtp.sendComment(comment);
    }

    /** Send command in event dispatch thread. */
    @Override
	public String send(String command) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(28);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        TimeoutCallback timeoutCallback = new TimeoutCallback(command);
        return m_gtp.send(command, TIMEOUT, timeoutCallback);
    }

    public void setAutoNumber(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(29);m_gtp.setAutoNumber(enable);
    }

    public void synchronize(ConstBoard board, Komi komi,
                            TimeSettings timeSettings) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(30);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        m_gtpSynchronizer.synchronize(board, komi, timeSettings);
    }

    public void updateAfterGenmove(ConstBoard board)
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(31);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        m_gtpSynchronizer.updateAfterGenmove(board);
    }

    public void updateHumanMove(ConstBoard board, Move move) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(32);assert SwingUtilities.isEventDispatchThread();
        assert ! m_commandInProgress;
        m_gtpSynchronizer.updateHumanMove(board, move);
    }

    @Override
	public void waitForExit()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(33);m_gtp.waitForExit();
    }

    public boolean wasKilled()
    {
        $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(34);return m_gtp.wasKilled();
    }

    private class TimeoutCallback
        implements GtpClient.TimeoutCallback
    {
        TimeoutCallback(String command)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(35);m_command = command;
        }

        @Override
		public boolean askContinue()
        {
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(36);String mainMessage = i18n("MSG_PROGRAM_NOT_RESPONDING");
            String optionalMessage;
            String destructiveOption;
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(37);if ((m_command == null) ? true : (!$qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(39) && false))
            {
                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(38);optionalMessage = i18n("MSG_PROGRAM_NOT_RESPONDING_2");
                destructiveOption = i18n("LB_FORCE_QUIT_PROGRAM");
            }
            else
            {
                $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(41);optionalMessage =
                    MessageFormat.format(i18n("MSG_PROGRAM_NOT_RESPONDING_3"),
                                         m_command);
                destructiveOption = i18n("LB_TERMINATE_PROGRAM");
            }
            $qualityscroll_cover_jacov_probe_a8d4de7124eb5c76(40);return ! m_messageDialogs.showWarningQuestion(null, m_owner,
                                                          mainMessage,
                                                          optionalMessage,
                                                          destructiveOption,
                                                          i18n("LB_WAIT"),
                                                          true);
        }

        private final String m_command;
    };

    /** The timeout for commands that are expected to be fast.
        GoGui 0.9.4 used 8 sec, but this was not enough on some machines
        when starting up engines like Aya in the Wine emulator. */
    private static final int TIMEOUT = 15000;

    private boolean m_commandInProgress;

    private final GtpClient m_gtp;

    private GtpError m_exception;

    private final GtpSynchronizer m_gtpSynchronizer;

    private final Component m_owner;

    private final MessageDialogs m_messageDialogs;

    private final Object m_mutex = new Object();

    private Runnable m_callback;

    private String m_command;

    private String m_response;
}
