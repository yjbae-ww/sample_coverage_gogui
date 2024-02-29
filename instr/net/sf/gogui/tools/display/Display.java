/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Display.java

package net.sf.gogui.tools.display;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.gtp.GtpCallback;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpCommand;
import net.sf.gogui.gtp.GtpEngine;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.gui.AnalyzeShow;
import net.sf.gogui.gui.GuiBoard;
import net.sf.gogui.gui.GuiBoardUtil;
import net.sf.gogui.gui.GuiUtil;
import net.sf.gogui.gui.LiveGfx;
import net.sf.gogui.gui.MessageDialogs;
import net.sf.gogui.gui.StatusBar;
import net.sf.gogui.util.LineReader;
import net.sf.gogui.util.StringUtil;

/** GTP adapter showing the current board in a window. */
public class Display
    extends GtpEngine
    implements LiveGfx.Listener
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Display.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2081820475309487048L,/* translation unit id   */ 11308331154767414L,/* timestamp             */ 1709177903219L,/* source file name      */ "Display.java",/* probe size            */ 162);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_282cde057b7e36(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Display(String program, boolean verbose)
        throws Exception
    {
        super(null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_282cde057b7e36(0);
        m_size = GoPoint.DEFAULT_SIZE;
        m_board = new Board(m_size);
        m_frame = new JFrame();
        m_frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        WindowAdapter windowAdapter = new WindowAdapter() {
                @Override
				public void windowClosing(WindowEvent event) {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(1);closeFrame();
                }
            };
        m_frame.addWindowListener(windowAdapter);
        Container contentPane = m_frame.getContentPane();
        m_guiBoard = new GuiBoard(m_size);
        m_guiBoard.setListener(new GuiBoard.Listener() {
                @Override
				public void contextMenu(GoPoint point, Component invoker,
                                        int x, int y)
                {
                }

                @Override
				public void fieldClicked(GoPoint point,
                                         boolean modifiedSelect)
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(2);cbFieldClicked(point, modifiedSelect);
                }
            });
        contentPane.add(m_guiBoard);
        m_statusBar = new StatusBar();
        m_statusBar.showMoveText(false);
        contentPane.add(m_statusBar, BorderLayout.SOUTH);
        $qualityscroll_cover_jacov_probe_282cde057b7e36(3);if ((! StringUtil.isEmpty(program)) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(5) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(4);GtpClient.IOCallback ioCallback = new GtpClient.IOCallback() {
                    @Override
					public void receivedInvalidResponse(String s) {
                    }

                    @Override
					public void receivedResponse(boolean error, String s) {
                    }

                    @Override
					public void receivedStdErr(String s) {
                        $qualityscroll_cover_jacov_probe_282cde057b7e36(6);m_lineReader.add(s);
                        $qualityscroll_cover_jacov_probe_282cde057b7e36(7);while ((m_lineReader.hasLines()) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(9) && false))
                            {$qualityscroll_cover_jacov_probe_282cde057b7e36(8);m_liveGfx.handleLine(m_lineReader.getLine());}
                    }

                    @Override
					public void sentCommand(String s) {
                    }

                    private final LineReader m_lineReader = new LineReader();

                    private LiveGfx m_liveGfx = new LiveGfx(Display.this);
                };
            m_gtp = new GtpClient(program, null, verbose, ioCallback);
            m_gtp.queryProtocolVersion();
            m_gtp.querySupportedCommands();
            m_guiBoard.setShowCursor(false);
            m_gtp.queryName();
            m_name = m_gtp.getLabel();
            String title = "gogui-display - " + m_name;
            m_frame.setTitle(title);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(11);m_gtp = null;
            m_name = null;
            m_frame.setTitle("gogui-display");
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(10);registerCommands();
        GuiUtil.setGoIcon(m_frame);
        m_frame.pack();
        m_frame.setVisible(true);
    }

    public void close()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(12);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(14) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(13);m_gtp.close();
            m_gtp.waitForExit();
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(15);GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(16);if ((m_frame != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(18) && false))
                    {
                        $qualityscroll_cover_jacov_probe_282cde057b7e36(17);m_messageDialogs.showInfo(m_frame,
                                                  "GTP stream was closed",
                                                  "", true);
                        showStatus("GTP stream was closed");
                    }
                    else {$qualityscroll_cover_jacov_probe_282cde057b7e36(19);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(21) && false))
                        {$qualityscroll_cover_jacov_probe_282cde057b7e36(20);System.exit(0);}}
                }
            });
    }

    public void cmdForward(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(22);send(cmd.getLine(), cmd.getResponse());
    }

    @Override
	public void cmdName(GtpCommand cmd)
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(23);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(25) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(24);cmd.setResponse("gogui-display");}
        else
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(26);cmd.setResponse(m_name);}
    }

    @Override
	public void cmdQuit(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(27);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(29) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(28);send("quit", cmd.getResponse());}
        $qualityscroll_cover_jacov_probe_282cde057b7e36(30);setQuit();
    }

    @Override
	public void handleCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(31);showStatus(cmd.getLine());
        super.handleCommand(cmd);
    }

    @Override
	public void interruptCommand()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(32);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(34) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(33);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(35);if ((m_gtp.isInterruptSupported()) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(37) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(36);m_gtp.sendInterrupt();}
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(38);System.err.println(e);
        }
    }

    @Override
	public void showLiveGfx(final String text)
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(39);assert SwingUtilities.isEventDispatchThread();
        m_guiBoard.clearAll();
        GuiBoardUtil.updateFromGoBoard(m_guiBoard, m_board, false, false);
        AnalyzeShow.showGfx(text, m_guiBoard, m_statusBar, null);
    }

    /** Only accept this board size.
        A value of -1 means accept any size. */
    private int m_size;

    private final Board m_board;

    private GoColor m_color;

    private final GuiBoard m_guiBoard;

    private GoPoint m_fieldClicked;

    private final GtpClient m_gtp;

    private Move m_move;

    private final Object m_mutex = new Object();

    private JFrame m_frame;

    private final StatusBar m_statusBar;

    private final String m_name;

    private final MessageDialogs m_messageDialogs = new MessageDialogs();

    private void cbFieldClicked(GoPoint point, boolean modifiedSelect)
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(40);assert SwingUtilities.isEventDispatchThread();
        $qualityscroll_cover_jacov_probe_282cde057b7e36(41);if ((m_board.getColor(point) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(43) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(42);return;}
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(44);if ((modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(46) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(45);m_fieldClicked = null;}
            else
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(48);m_fieldClicked = point;}
            $qualityscroll_cover_jacov_probe_282cde057b7e36(47);m_mutex.notifyAll();
        }
    }

    private void clearStatus()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(49);m_statusBar.clear();
    }

    private void closeFrame()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(50);assert SwingUtilities.isEventDispatchThread();
        $qualityscroll_cover_jacov_probe_282cde057b7e36(51);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(53) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(52);if ((! m_messageDialogs.showQuestion(m_frame,
                                                "Terminate gogui-display?",
                                                "", "Terminate", true)) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(55) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(54);return;}
            $qualityscroll_cover_jacov_probe_282cde057b7e36(56);System.exit(0);
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(57);m_frame.dispose();
        m_frame = null;
    }

    private void cmdBoardsize(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(58);cmd.checkNuArg(1);
        int size = cmd.getIntArg(0, 1, GoPoint.MAX_SIZE);
        $qualityscroll_cover_jacov_probe_282cde057b7e36(59);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(61) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(60);String command = m_gtp.getCommandBoardsize(size);
            $qualityscroll_cover_jacov_probe_282cde057b7e36(62);if ((command != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(64) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(63);send(command);}
            $qualityscroll_cover_jacov_probe_282cde057b7e36(65);command = m_gtp.getCommandClearBoard(size);
            send(command);
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(66);m_size = size;
        GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(67);m_board.init(m_size);
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(68);if ((m_guiBoard.getBoardSize() != m_size) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(70) && false))
                    {
                        $qualityscroll_cover_jacov_probe_282cde057b7e36(69);m_guiBoard.initSize(m_size);
                        m_frame.pack();
                    }
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(71);updateFromGoBoard();
                }
            });
    }

    private void cmdClearBoard(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(72);cmd.checkArgNone();
        $qualityscroll_cover_jacov_probe_282cde057b7e36(73);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(75) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(74);String command = m_gtp.getCommandClearBoard(m_size);
            send(command);
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(76);GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(77);m_board.clear();
                    updateFromGoBoard();
                }
            });
    }

    private void cmdGenmove(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(78);GoColor color = cmd.getColorArg();
        GoPoint point;
        $qualityscroll_cover_jacov_probe_282cde057b7e36(79);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(81) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(80);if ((m_frame == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(83) && false))
                // can that happen?
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(82);throw new GtpError("gogui-display terminated");}
            $qualityscroll_cover_jacov_probe_282cde057b7e36(84);m_color = color;
            showStatus("Input move for " + m_color
                       + " (Ctrl-button and click for pass)");
            synchronized (m_mutex)
            {
                try
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(85);m_mutex.wait();
                }
                catch (InterruptedException e)
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(92);System.err.println("InterruptedException");
                }
                $qualityscroll_cover_jacov_probe_282cde057b7e36(86);point = m_fieldClicked;
            }
            cmd.setResponse(GoPoint.toString(point));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(93);String command = m_gtp.getCommandGenmove(color);
            StringBuilder response = cmd.getResponse();
            send(command, response);
            $qualityscroll_cover_jacov_probe_282cde057b7e36(94);if ((response.toString().trim().equalsIgnoreCase("resign")) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(96) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(95);return;}
            try
            {
                $qualityscroll_cover_jacov_probe_282cde057b7e36(97);point = GtpUtil.parsePoint(response.toString(), m_size);
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_282cde057b7e36(98);throw new GtpError(e.getMessage());
            }
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(87);m_move = Move.get(color, point);
        GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(88);m_board.play(m_move);
                    updateFromGoBoard();
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(89);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(91) && false))
                        {$qualityscroll_cover_jacov_probe_282cde057b7e36(90);clearStatus();}
                }
            });
    }

    private void cmdKomi(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(99);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(101) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(100);return;}
        $qualityscroll_cover_jacov_probe_282cde057b7e36(102);send(cmd.getLine(), cmd.getResponse());
    }

    private void cmdPlaceFreeHandicap(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(103);int n = cmd.getIntArg();
        ConstPointList stones = Board.getHandicapStones(m_size, n);
        $qualityscroll_cover_jacov_probe_282cde057b7e36(104);if  ((stones == null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(106) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(105);throw new GtpError("Invalid number of handicap stones");}
        $qualityscroll_cover_jacov_probe_282cde057b7e36(107);StringBuilder pointList = new StringBuilder(128);
        $qualityscroll_cover_jacov_probe_282cde057b7e36(108);for (GoPoint p : stones)
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(110);play(BLACK, p);
            $qualityscroll_cover_jacov_probe_282cde057b7e36(111);if ((pointList.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(113) && false))
                {$qualityscroll_cover_jacov_probe_282cde057b7e36(112);pointList.append(' ');}
            $qualityscroll_cover_jacov_probe_282cde057b7e36(114);pointList.append(p);
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(109);cmd.setResponse(pointList.toString());
    }

    private void cmdPlay(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(115);cmd.checkNuArg(2);
        GoColor color = cmd.getColorArg(0);
        GoPoint point = cmd.getPointArg(1, m_size);
        play(color, point);
    }

    private void cmdSetFreeHandicap(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(116);for (int i = 0; (i < cmd.getNuArg()) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(118) && false); ++i)
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(117);play(BLACK, cmd.getPointArg(i, m_size));}
    }

    private void cmdUndo(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(119);cmd.checkArgNone();
        undo();
    }

    private void play(GoColor color, GoPoint point) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(120);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(122) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(121);String command = m_gtp.getCommandPlay(Move.get(color, point));
            send(command);
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(123);m_move = Move.get(color, point);
        GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(124);m_board.play(m_move);
                    updateFromGoBoard();
                }
            });
    }

    private void registerCommands()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(125);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(127) && false))
        {
            $qualityscroll_cover_jacov_probe_282cde057b7e36(126);GtpCallback forwardCallback = new GtpCallback() {
                    @Override
					public void run(GtpCommand cmd) throws GtpError {
                        $qualityscroll_cover_jacov_probe_282cde057b7e36(128);cmdForward(cmd); } };
            ArrayList<String> commands = m_gtp.getSupportedCommands();
            $qualityscroll_cover_jacov_probe_282cde057b7e36(129);for (String c : commands)
            {
                $qualityscroll_cover_jacov_probe_282cde057b7e36(142);if ((GtpUtil.isStateChangingCommand(c)
                    || c.equals("help")
                    || c.equals("known_command")
                    || c.equals("komi")
                    || c.equals("list_commands")
                    || c.equals("protocol_version")) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(144) && false))
                    {$qualityscroll_cover_jacov_probe_282cde057b7e36(143);continue;}
                $qualityscroll_cover_jacov_probe_282cde057b7e36(145);register(c, forwardCallback);
            }
        }
        $qualityscroll_cover_jacov_probe_282cde057b7e36(130);register("boardsize", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(131);cmdBoardsize(cmd); } });
        register("clear_board", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(132);cmdClearBoard(cmd); } });
        register("genmove", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(133);cmdGenmove(cmd); } });
        register("komi", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(134);cmdKomi(cmd); } });
        register("name", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(135);cmdName(cmd); } });
        register("place_free_handicap", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(136);cmdPlaceFreeHandicap(cmd); } });
        register("play", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(137);cmdPlay(cmd); } });
        register("quit", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(138);cmdQuit(cmd); } });
        register("set_free_handicap", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(139);cmdSetFreeHandicap(cmd); } });
        register("undo", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(140);cmdUndo(cmd); } });
        register("version", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(141);cmdVersion(cmd); } });
    }

    private void send(String cmd, StringBuilder response) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(146);response.append(m_gtp.send(cmd));
    }

    private void send(String cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(147);m_gtp.send(cmd);
    }

    private void showStatus(final String text)
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(148);Runnable runnable = new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(149);if ((m_frame != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(151) && false))
                        {$qualityscroll_cover_jacov_probe_282cde057b7e36(150);m_statusBar.setText(text);}
                }
            };
        $qualityscroll_cover_jacov_probe_282cde057b7e36(152);if ((SwingUtilities.isEventDispatchThread()) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(154) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(153);runnable.run();}
        else
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(155);GuiUtil.invokeAndWait(runnable);}
    }

    private void undo() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(156);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_282cde057b7e36(158) && false))
            {$qualityscroll_cover_jacov_probe_282cde057b7e36(157);send("undo");}
        $qualityscroll_cover_jacov_probe_282cde057b7e36(159);GuiUtil.invokeAndWait(new Runnable()
            {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_282cde057b7e36(160);m_board.undo();
                    updateFromGoBoard();
                }
            });
    }

    private void updateFromGoBoard()
    {
        $qualityscroll_cover_jacov_probe_282cde057b7e36(161);m_guiBoard.clearAll(); // Live Gfx markup
        GuiBoardUtil.updateFromGoBoard(m_guiBoard, m_board, true, false);
        m_statusBar.clear();
        m_statusBar.setToPlay(m_board.getToMove());
    }
}
