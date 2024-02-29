/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGui.java

package net.sf.gogui.gogui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import static java.text.MessageFormat.format;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import net.sf.gogui.game.ConstClock;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.Game;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.gamefile.GameFile;
import net.sf.gogui.gamefile.GameReader;
import net.sf.gogui.gamefile.GameWriter;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.BoardUtil;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.CountScore;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.go.Score;
import net.sf.gogui.go.Score.ScoringMethod;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gtp.AnalyzeCommand;
import net.sf.gogui.gtp.AnalyzeDefinition;
import net.sf.gogui.gtp.AnalyzeType;
import net.sf.gogui.gtp.AnalyzeUtil;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpClientUtil;
import net.sf.gogui.gtp.GtpCommand;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpSynchronizer;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.gui.AnalyzeDialog;
import net.sf.gogui.gui.AnalyzeShow;
import net.sf.gogui.gui.BoardSizeDialog;
import net.sf.gogui.gui.Bookmark;
import net.sf.gogui.gui.BookmarkEditor;
import net.sf.gogui.gui.Comment;
import net.sf.gogui.gui.ConstGuiBoard;
import net.sf.gogui.gui.ContextMenu;
import net.sf.gogui.gui.FindDialog;
import net.sf.gogui.gui.GameInfoDialog;
import net.sf.gogui.gui.GameInfoPanel;
import net.sf.gogui.gui.GameTreePanel;
import net.sf.gogui.gui.GameTreeViewer;
import net.sf.gogui.gui.GtpShell;
import net.sf.gogui.gui.GuiAction;
import net.sf.gogui.gui.GuiBoard;
import net.sf.gogui.gui.GuiBoardUtil;
import net.sf.gogui.gui.GuiGtpClient;
import net.sf.gogui.gui.GuiUtil;
import net.sf.gogui.gui.FileDialogs;
import net.sf.gogui.gui.Help;
import net.sf.gogui.gui.LiveGfx;
import net.sf.gogui.gui.MessageDialogs;
import net.sf.gogui.gui.ObjectListEditor;
import net.sf.gogui.gui.ParameterDialog;
import net.sf.gogui.gui.Program;
import net.sf.gogui.gui.ProgramEditor;
import net.sf.gogui.gui.RecentFileMenu;
import net.sf.gogui.gui.Session;
import net.sf.gogui.gui.ScoreDialog;
import net.sf.gogui.gui.StatusBar;
import net.sf.gogui.gui.TimeLeftDialog;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.sgf.SgfWriter;
import net.sf.gogui.tex.TexWriter;
import net.sf.gogui.text.TextParser;
import net.sf.gogui.text.ParseError;
import net.sf.gogui.thumbnail.ThumbnailCreator;
import net.sf.gogui.thumbnail.ThumbnailPlatform;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.ObjectUtil;
import net.sf.gogui.util.LineReader;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.ProgressShow;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Graphical user interface to a Go program. */
public class GoGui
    extends JFrame
    implements AnalyzeDialog.Listener, GuiBoard.Listener,
               GameTreeViewer.Listener, GtpShell.Listener,
               ScoreDialog.Listener, GoGuiMenuBar.Listener,
               ContextMenu.Listener, LiveGfx.Listener
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGui.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7025709486078913899L,/* translation unit id   */ -3069249878803912549L,/* timestamp             */ 1709177900679L,/* source file name      */ "GoGui.java",/* probe size            */ 1805);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d567d57f2efb689b(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public enum ShowVariations
    {
        CHILDREN,

        SIBLINGS,

        NONE
    }

    public GoGui(String program, File file, int move, String time,
                 boolean verbose, boolean initComputerColor,
                 boolean computerBlack, boolean computerWhite, boolean auto,
                 boolean register, String gtpFile, String gtpCommand,
                 File analyzeCommandsFile)
        throws GtpError, ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(0);int boardSize = m_prefs.getInt("boardsize", GoPoint.DEFAULT_SIZE);
        m_beepAfterMove = m_prefs.getBoolean("beep-after-move", true);
        m_initialFile = file;
        m_gtpFile = gtpFile;
        m_gtpCommand = gtpCommand;
        m_analyzeCommandsFile = analyzeCommandsFile;
        m_move = move;
        m_register = register;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1);if ((initComputerColor) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(3) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(2);m_computerBlack = computerBlack;
            m_computerWhite = computerWhite;
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(27);if ((m_prefs.getBoolean("computer-none", false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(29) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(28);m_computerBlack = false;
            m_computerWhite = false;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(30);m_computerBlack = false;
            m_computerWhite = true;
        }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(4);m_auto = auto;
        m_verbose = verbose;
        m_showInfoPanel = true;
        m_showToolbar = false;

        Container contentPane = getContentPane();
        m_innerPanel = new JPanel(new BorderLayout());
        contentPane.add(m_innerPanel, BorderLayout.CENTER);
        m_toolBar = new GoGuiToolBar(this);

        m_infoPanel = new JPanel(new BorderLayout());
        m_game = new Game(boardSize);
        m_gameInfoPanel = new GameInfoPanel(m_game);
        m_gameInfoPanel.setBorder(GuiUtil.createSmallEmptyBorder());
        m_infoPanel.add(m_gameInfoPanel, BorderLayout.NORTH);
        m_guiBoard = new GuiBoard(boardSize);
        m_showAnalyzeText = new ShowAnalyzeText(this, m_guiBoard);

        m_statusBar = new StatusBar();
        m_innerPanel.add(m_statusBar, BorderLayout.SOUTH);
        Comment.Listener commentListener = new Comment.Listener()
            {
                public void changed(String comment)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(5);m_game.setComment(comment);
                    // Cannot call updateViews, which calls
                    // Comment.setComment(), in comment callback
                    SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(6);updateViews(false);
                            } });
                }

                public void textSelected(String text)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(7);GoGui.this.textSelected(text);
                }
            };
        m_comment = new Comment(commentListener);
        boolean monoFont = m_prefs.getBoolean("comment-font-fixed", false);
        m_comment.setMonoFont(monoFont);
        m_infoPanel.add(m_comment, BorderLayout.CENTER);
        m_splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     m_guiBoard, m_infoPanel);
        m_splitPane.setResizeWeight(1);
        m_innerPanel.add(m_splitPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
                public void windowActivated(WindowEvent e) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(8);m_guiBoard.requestFocusInWindow();
                }

                public void windowClosing(WindowEvent event) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(9);close();
                }
            });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        GuiUtil.setGoIcon(this);
        RecentFileMenu.Listener recentListener = new RecentFileMenu.Listener()
            {
                public void fileSelected(String label, File file) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(10);actionOpenFile(file);
                }
            };
        RecentFileMenu.Listener recentGtp = new RecentFileMenu.Listener() {
                public void fileSelected(String label, File file) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(11);actionSendFile(file);
                }
            };
        m_menuBar = new GoGuiMenuBar(m_actions, recentListener, recentGtp,
                                     this);
        // enums are stored as int's for compatibility with earlier versions
        // of GoGui
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(12);m_treeLabels =
                GameTreePanel.Label.values()[
                         m_prefs.getInt("gametree-labels",
                                        GameTreePanel.Label.NUMBER.ordinal())];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(26);m_treeLabels = GameTreePanel.Label.NUMBER;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(13);m_treeSize =
                GameTreePanel.Size.values()[
                         m_prefs.getInt("gametree-size",
                                        GameTreePanel.Size.NORMAL.ordinal())];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(25);m_treeSize = GameTreePanel.Size.NORMAL;
        }

        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(14);m_showVariations =
                ShowVariations.values()[
                           m_prefs.getInt("show-variations",
                                          ShowVariations.CHILDREN.ordinal())];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(24);m_showVariations = ShowVariations.CHILDREN;
        }

        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(15);m_showSubtreeSizes =
            m_prefs.getBoolean("gametree-show-subtree-sizes", false);
        m_autoNumber = m_prefs.getBoolean("gtpshell-autonumber", false);
        m_commandCompletion =
            ! m_prefs.getBoolean("gtpshell-disable-completions", false);
        m_timeStamp = m_prefs.getBoolean("gtpshell-timestamp", false);
        m_showLastMove = m_prefs.getBoolean("show-last-move", true);
        m_showMoveNumbers = m_prefs.getBoolean("show-move-numbers", false);
        boolean showCursor = m_prefs.getBoolean("show-cursor", false);
        boolean showGrid = m_prefs.getBoolean("show-grid", false);
        m_guiBoard.setShowCursor(showCursor);
        m_guiBoard.setShowGrid(showGrid);
        setJMenuBar(m_menuBar);
        setMinimumSize();
        m_programCommand = program;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(16);if ((m_programCommand != null && m_programCommand.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(18) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(17);m_programCommand = null;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(19);if ((time != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(21) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(20);m_timeSettings = TimeSettings.parse(time);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(22);protectGui(); // Show wait cursor
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(23);initialize();
                } });
    }

    public void actionAbout()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(31);String command = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(32);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(34) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(33);command = m_gtp.getProgramCommand();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(35);AboutDialog.show(this, getProgramLabel(), m_version, command,
                         m_messageDialogs);
    }

    public void actionAddBookmark()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(36);if ((m_gameFile == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(38) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(37);showError(i18n("MSG_CANNOT_SET_BOOKMARK_NO_FILE"),
                      i18n("MSG_CANNOT_SET_BOOKMARK_NO_FILE_2"),
                      false);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(39);if ((isModified()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(41) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(40);showError(i18n("MSG_CANNOT_SET_BOOKMARK_MODIFIED"),
                      i18n("MSG_CANNOT_SET_BOOKMARK_MODIFIED_2"),
                      false);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(42);if ((getCurrentNode().getFatherConst() != null
            && getCurrentNode().getMove() == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(44) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(43);showError(i18n("MSG_CANNOT_SET_BOOKMARK_NODE"),
                      i18n("MSG_CANNOT_SET_BOOKMARK_NODE_2"),
                      false);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(45);String variation = NodeUtil.getVariationString(getCurrentNode());
        int move = NodeUtil.getMoveNumber(getCurrentNode());
        Bookmark bookmark = new Bookmark(m_gameFile.m_file, move, variation);
        BookmarkEditor editor = new BookmarkEditor();
        bookmark = editor.editItem(this, i18n("TIT_ADD_BOOKMARK"), bookmark,
                                   true, m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(46);if ((bookmark == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(48) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(47);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(49);m_bookmarks.add(bookmark);
        m_menuBar.setBookmarks(m_bookmarks);
        Bookmark.save(m_bookmarks);
    }

    public void actionAttachProgram(int index)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(50);m_prefs.putInt("program", index);
        actionAttachProgram(m_programs.get(index));
    }

    public void actionAttachProgram(final Program program)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(51);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(53) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(52);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(54);protectGui();
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(55);attachNewProgram(program.m_command, program);
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(56);unprotectGui();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionBackToMainVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(57);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(59) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(58);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(60);ConstNode node = NodeUtil.getBackToMainVariation(getCurrentNode());
        actionGotoNode(node);
    }

    public void actionBackward(int n)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(61);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(63) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(62);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(64);boolean protectGui = (m_gtp != null
                              && (n > 1 || ! m_gtp.isSupported("undo")));
        actionGotoNode(NodeUtil.backward(getCurrentNode(), n), protectGui);
    }

    public void actionBeginning()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(65);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(67) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(66);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(68);actionBackward(NodeUtil.getDepth(getCurrentNode()));
    }

    public void actionBoardSize(int size)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(69);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(71) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(70);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(72);actionNewGame(size);
        m_prefs.putInt("boardsize", size);
    }

    public void actionBoardSizeOther()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(73);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(75) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(74);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(76);int size = BoardSizeDialog.show(this, getBoardSize(),
                                        m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(77);if ((size < 1 || size > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(79) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(78);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(80);actionBoardSize(size);
    }

    public void actionClearAnalyzeCommand()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(81);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(83) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(82);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(84);clearAnalyzeCommand();
    }

    public void actionClockHalt()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(85);if ((! getClock().isRunning()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(87) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(86);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(88);m_game.haltClock();
        updateViews(false);
    }

    public void actionClockResume()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(89);if ((getClock().isRunning()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(91) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(90);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(92);m_game.resumeClock();
        updateViews(false);
    }

    public void actionClockStart()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(93);if ((getClock().isRunning()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(95) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(94);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(96);m_game.startClock();
        updateViews(false);
    }

    public void actionComputerColor(boolean isBlack, boolean isWhite)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(97);boolean computerNone = (! isBlack && ! isWhite);
        m_prefs.putBoolean("computer-none", computerNone);
        m_computerBlack = isBlack;
        m_computerWhite = isWhite;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(98);if ((! isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(100) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(99);checkComputerMove();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(101);updateViews(false);
    }

    public void actionDeleteSideVariations()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(102);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(104) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(103);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(105);if ((! NodeUtil.isInMainVariation(getCurrentNode())) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(107) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(106);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(108);String disableKey = "net.sf.gogui.gogui.GoGui.delete-side-variations";
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(109);if ((! m_messageDialogs.showQuestion(disableKey, this,
                                            i18n("MSG_DELETE_VARIATIONS"),
                                            i18n("MSG_DELETE_VARIATIONS_2"),
                                            i18n("LB_DELETE"),
                                            false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(111) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(110);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(112);m_game.keepOnlyMainVariation();
        boardChangedBegin(false, true);
    }

    public void actionDetachProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(113);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(115) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(114);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(116);if ((isCommandInProgress()
            && ! showQuestion(format(i18n("MSG_TERMINATE_COMMAND_IN_PROGRESS"),
                                     getProgramLabel()),
                              i18n("MSG_TERMINATE_COMMAND_IN_PROGRESS_2"),
                              i18n("LB_TERMINATE"), true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(118) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(117);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(119);m_prefs.putInt("program", -1);
        protectGui();
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(120);saveSession();
                        detachProgram();
                        updateViews(false);
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(121);unprotectGui();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionDisposeAnalyzeDialog()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(122);if ((m_analyzeDialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(124) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(123);clearAnalyzeCommand();
            saveSession();
            m_analyzeDialog.dispose();
            m_analyzeDialog = null;
        }
    }

    public void actionDisposeTree()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(125);if ((m_gameTreeViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(127) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(126);saveSession();
            m_gameTreeViewer.dispose();
            m_gameTreeViewer = null;
            updateViews(false);
        }
    }

    public void actionHelp()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(128);ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("net/sf/gogui/doc/index.html");
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(129);if ((url == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(131) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(130);showError(i18n("MSG_HELP_NOT_FOUND"), "");
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(132);if ((m_help == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(134) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(133);m_help = new Help(url, m_messageDialogs,
                              i18n("TIT_HELP") + " - " + i18n("LB_GOGUI"));
            m_session.restoreSize(m_help.getWindow(), "help");
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(135);m_help.getWindow().setVisible(true);
        m_help.getWindow().toFront();
    }

    public void actionEditBookmarks()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(136);BookmarkEditor editor = new BookmarkEditor();
        ObjectListEditor<Bookmark> listEditor =
            new ObjectListEditor<Bookmark>();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(137);if ((! listEditor.edit(this, i18n("TIT_EDIT_BOOKMARKS"), m_bookmarks,
                              editor, m_messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(139) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(138);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(140);m_menuBar.setBookmarks(m_bookmarks);
        Bookmark.save(m_bookmarks);
    }

    public void actionEditLabel(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(141);String value = getCurrentNode().getLabel(point);
        Object message = format(i18n("MSG_EDIT_LABEL"), point);
        value = (String)JOptionPane.showInputDialog(this, message,
                                                    i18n("TIT_EDIT_LABEL"),
                                                    JOptionPane.PLAIN_MESSAGE,
                                                    null, null, value);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(142);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(144) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(143);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(145);m_game.setLabel(point, value);
        m_guiBoard.setLabel(point, value);
        updateViews(false);
    }

    public void actionEditPrograms()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(146);ProgramEditor editor = new ProgramEditor();
        ObjectListEditor<Program> listEditor = new ObjectListEditor<Program>();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(147);if ((! listEditor.edit(this, i18n("TIT_EDIT_PROGRAMS"), m_programs,
                              editor, m_messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(149) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(148);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(150);m_menuBar.setPrograms(m_programs);
        m_prefs.putInt("program", -1);
        Program.save(m_programs);
    }

    public void actionEnd()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(151);actionForward(NodeUtil.getNodesLeft(getCurrentNode()));
    }

    public void actionExportLatexMainVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(152);File file = showSave(i18n("TIT_EXPORT_LATEX"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(153);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(155) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(154);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(156);OutputStream out = new FileOutputStream(file);
            String title =
                FileUtil.removeExtension(new File(file.getName()), "tex");
            new TexWriter(title, out, getTree());
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(157);showError(i18n("MSG_EXPORT_FAILED"), e);
        }
    }

    public void actionExportLatexPosition()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(158);File file = showSave(i18n("TIT_EXPORT_LATEX_POSITION"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(159);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(161) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(160);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(162);OutputStream out = new FileOutputStream(file);
            String title = FileUtil.removeExtension(new File(file.getName()),
                                                     "tex");
            new TexWriter(title, out, getBoard(),
                          GuiBoardUtil.getLabels(m_guiBoard),
                          GuiBoardUtil.getMark(m_guiBoard),
                          GuiBoardUtil.getMarkTriangle(m_guiBoard),
                          GuiBoardUtil.getMarkCircle(m_guiBoard),
                          GuiBoardUtil.getMarkSquare(m_guiBoard),
                          GuiBoardUtil.getSelects(m_guiBoard));
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(163);showError(i18n("MSG_EXPORT_FAILED"), e);
        }
    }

    public void actionExportSgfPosition()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(164);File file = FileDialogs.showSaveSgf(this, m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(165);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(167) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(166);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(168);savePosition(file);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(169);showError(i18n("MSG_EXPORT_FAILED"), e);
        }
    }

    public void actionExportTextPosition()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(170);File file = showSave(i18n("MSG_EXPORT_TEXT"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(171);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(173) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(172);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(174);String text = BoardUtil.toString(getBoard(), false, false);
            PrintStream out = new PrintStream(file);
            out.print(text);
            out.close();
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(175);showError(i18n("MSG_EXPORT_FAILED"), e);
        }
    }

    public void actionExportPng()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(176);ExportPng.run(this, m_guiBoard, m_prefs, m_messageDialogs);
    }

    public void actionExportTextPositionToClipboard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(177);GuiUtil.copyToClipboard(BoardUtil.toString(getBoard(), false, false));
    }

    public void actionFind()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(178);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(180) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(179);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(181);Pattern pattern = FindDialog.run(this, m_comment.getSelectedText(),
                                         m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(182);if ((pattern == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(184) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(183);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(185);m_pattern = pattern;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(186);if ((NodeUtil.commentContains(getCurrentNode(), m_pattern)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(188) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(187);m_comment.markAll(m_pattern);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(189);actionFindNext();}
    }

    public void actionFindNext()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(190);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(192) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(191);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(193);if ((m_pattern == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(195) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(194);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(196);protectGui();
        showStatus(i18n("STAT_FIND_SEARCHING_COMMENTS"));
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(197);ConstNode root = getTree().getRootConst();
                        ConstNode currentNode = getCurrentNode();
                        ConstNode node =
                            NodeUtil.findInComments(currentNode, m_pattern);
                        boolean cancel = false;
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(198);if ((node == null && getCurrentNode() != root) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(200) && false))
                        {
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(199);unprotectGui();
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(201);if ((showQuestion(i18n("MSG_FIND_CONTINUE"),
                                             i18n("MSG_FIND_CONTINUE_2"),
                                             i18n("LB_FIND_CONTINUE"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(203) && false))
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(202);protectGui();
                                node = root;
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(204);if ((! NodeUtil.commentContains(node,
                                                               m_pattern)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(206) && false))
                                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(205);node =
                                        NodeUtil.findInComments(node,
                                                                m_pattern);}
                            }
                            else
                                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(214);cancel = true;}
                        }
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(207);if ((! cancel) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(209) && false))
                        {
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(208);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(211) && false))
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(210);unprotectGui();
                                showInfo(i18n("MSG_FIND_NOT_FOUND"),
                                         format(i18n("MSG_FIND_NOT_FOUND_2"),
                                                m_pattern),
                                         false);
                                m_pattern = null;
                            }
                            else
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(213);gotoNode(node);
                                boardChangedBegin(false, false);
                                m_comment.markAll(m_pattern);
                            }
                        }
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(212);unprotectGui();
                        clearStatus();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionFindNextComment()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(215);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(217) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(216);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(218);protectGui();
        showStatus(i18n("STAT_FIND_SEARCHING_COMMENTS"));
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(219);ConstNode root = getTree().getRootConst();
                        ConstNode currentNode = getCurrentNode();
                        ConstNode node = NodeUtil.findNextComment(currentNode);
                        boolean cancel = false;
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(220);if ((node == null && getCurrentNode() != root) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(222) && false))
                        {
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(221);unprotectGui();
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(223);if ((showQuestion(i18n("MSG_FIND_CONTINUE"),
                                             i18n("MSG_FIND_CONTINUE_2"),
                                             i18n("LB_FIND_CONTINUE"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(225) && false))
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(224);protectGui();
                                node = root;
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(226);if ((! node.hasComment()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(228) && false))
                                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(227);node = NodeUtil.findNextComment(node);}
                            }
                            else
                                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(236);cancel = true;}
                        }
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(229);if ((! cancel) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(231) && false))
                        {
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(230);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(233) && false))
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(232);unprotectGui();
                                showInfo(i18n("MSG_FIND_NO_COMMENT_FOUND"),
                                         null, false);
                            }
                            else
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(235);gotoNode(node);
                                boardChangedBegin(false, false);
                            }
                        }
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(234);unprotectGui();
                        clearStatus();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionForward(int n)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(237);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(239) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(238);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(240);boolean protectGui = (m_gtp != null && n > 1);
        actionGotoNode(NodeUtil.forward(getCurrentNode(), n), protectGui);
    }

    public void actionGameInfo()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(241);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(243) && false))
            // Changes in game info may send GTP commands
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(242);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(244);ConstNode node = m_game.getGameInfoNode();
        GameInfo info = new GameInfo(node.getGameInfoConst());
        GameInfoDialog.show(this, info, m_messageDialogs);
        m_game.setGameInfo(info, node);
        currentNodeChanged(); // updates komi, time settings
        Komi prefsKomi = getPrefsKomi();
        Komi komi = info.getKomi();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(245);if ((komi != null && ! komi.equals(prefsKomi) && info.getHandicap() == 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(247) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(246);m_prefs.put("komi", komi.toString());}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(248);if ((info.getTimeSettings() != null
            && ! info.getTimeSettings().equals(m_timeSettings)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(250) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(249);TimeSettings timeSettings = info.getTimeSettings();
            m_game.setTimeSettings(timeSettings);
            m_timeSettings = timeSettings;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(251);setTitle();
        updateViews(false);
    }

    public void actionGotoBookmark(int i)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(252);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(254) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(253);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(255);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(257) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(256);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(258);if ((i < 0 || i >= m_bookmarks.size()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(260) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(259);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(261);Bookmark bookmark = m_bookmarks.get(i);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(262);if ((! loadFile(bookmark.m_file, -1)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(264) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(263);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(265);updateViews(true);
        String variation = bookmark.m_variation;
        ConstNode node = getTree().getRootConst();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(266);if ((! variation.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(268) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(267);node = NodeUtil.findByVariation(node, variation);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(269);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(271) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(270);showError(i18n("MSG_BOOKMARK_INVALID_VARIATION"), "");
                return;
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(272);node = NodeUtil.findByMoveNumber(node, bookmark.m_move);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(273);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(275) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(274);showError(i18n("MSG_BOOKMARK_INVALID_MOVE_NUMBER"), "");
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(276);actionGotoNode(node);
    }

    public void actionGotoMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(277);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(279) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(278);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(280);ConstNode node = MoveNumberDialog.show(this, getCurrentNode(),
                                               m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(281);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(283) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(282);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(284);actionGotoNode(node);
    }

    public void actionGotoNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(285);boolean protectGui = (m_gtp != null);
        actionGotoNode(node, protectGui);
    }

    private void actionGotoNode(final ConstNode node, final boolean protectGui)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(286);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(288) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(287);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(289);if ((protectGui) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(291) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(290);protectGui();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(292);Runnable runnable = new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(293);gotoNode(node);
                    boardChangedBegin(false, false);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(294);if ((protectGui) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(296) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(295);unprotectGui();}
                }
            };
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(297);if ((protectGui) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(299) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(298);SwingUtilities.invokeLater(runnable);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(300);runnable.run();}
    }

    public void actionGotoVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(301);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(303) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(302);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(304);ConstNode node = GotoVariationDialog.show(this, getTree(),
                                                  getCurrentNode(),
                                                  m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(305);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(307) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(306);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(308);actionGotoNode(node);
    }

    public void actionHandicap(int handicap)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(309);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(311) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(310);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(312);m_handicap = handicap;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(313);if ((isModified()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(315) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(314);showInfo(i18n("MSG_HANDICAP_NEXT_GAME"),
                     i18n("MSG_HANDICAP_NEXT_GAME_2"), true);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(316);m_computerBlack = false;
            m_computerWhite = false;
            newGame(getBoardSize());
            updateViews(true);
        }
    }

    public void actionImportSgfFromClipboard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(317);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(319) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(318);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(320);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(322) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(321);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(323);String text = GuiUtil.getClipboardText();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(324);if ((text == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(326) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(325);showError(i18n("MSG_NO_TEXT_IN_CLIPBOARD"), "", false);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(327);ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(328);SgfReader reader = new SgfReader(in, null, null, 0);
            GameTree tree = reader.getTree();
            m_game.init(tree);
        }
        catch (SgfError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(330);showError(i18n("MSG_IMPORT_FAILED"), e);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(329);m_guiBoard.initSize(getBoard().getSize());
        initGtp();
        m_computerBlack = false;
        m_computerWhite = false;
        boardChangedBegin(false, true);
    }

    public void actionImportTextPosition()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(331);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(333) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(332);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(334);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(336) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(335);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(337);File file = FileDialogs.showOpen(this, i18n("TIT_IMPORT_TEXT"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(338);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(340) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(339);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(341);importTextPosition(new FileReader(file));
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(342);showError(i18n("MSG_FILE_NOT_FOUND"), "", false);
        }
    }

    public void actionImportTextPositionFromClipboard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(343);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(345) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(344);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(346);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(348) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(347);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(349);String text = GuiUtil.getClipboardText();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(350);if ((text == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(352) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(351);showError(i18n("MSG_NO_TEXT_IN_CLIPBOARD"), "", false);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(353);importTextPosition(new StringReader(text));}
    }

    public void actionInterrupt()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(354);if ((m_gtp == null || m_gtp.isProgramDead() || ! isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(356) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(355);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(357);if ((m_interrupt.run(this, m_gtp, m_messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(359) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(358);showStatus(i18n("STAT_INTERRUPT"));
            m_interruptComputerBoth = true;
        }
    }

    public void actionKeepOnlyPosition()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(360);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(362) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(361);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(363);if ((! showQuestion(i18n("MSG_KEEP_ONLY_POSITION"),
                           i18n("MSG_KEEP_ONLY_POSITION_2"),
                           i18n("LB_DELETE"), true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(365) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(364);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(366);m_game.keepOnlyPosition();
        initGtp();
        boardChangedBegin(false, true);
    }

    public void actionMainWindowActivate()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(367);requestFocus();
    }

    public void actionMakeMainVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(368);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(370) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(369);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(371);String disableKey = "net.sf.gogui.gogui.GoGui.make-main-variation";
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(372);if ((! m_messageDialogs.showQuestion(disableKey, this,
                                            i18n("MSG_MAKE_MAIN_VAR"),
                                            i18n("MSG_MAKE_MAIN_VAR_2"),
                                            i18n("LB_MAKE_MAIN_VAR"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(374) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(373);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(375);m_game.makeMainVariation();
        boardChangedBegin(false, true);
    }

    public void actionMark(GoPoint point, MarkType type, boolean mark)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(376);if ((mark) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(378) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(377);m_game.addMarked(point, type);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(392);m_game.removeMarked(point, type);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(379);if ((type == MarkType.MARK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(381) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(380);m_guiBoard.setMark(point, mark);}
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(383);if ((type == MarkType.CIRCLE) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(385) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(384);m_guiBoard.setMarkCircle(point, mark);}
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(386);if ((type == MarkType.SQUARE) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(388) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(387);m_guiBoard.setMarkSquare(point, mark);}
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(389);if ((type == MarkType.TRIANGLE) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(391) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(390);m_guiBoard.setMarkTriangle(point, mark);}}}}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(382);updateViews(false);
    }

    public void actionNewGame()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(393);actionNewGame(getBoardSize());
    }

    public void actionNewGame(int size)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(394);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(396) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(395);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(397);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(399) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(398);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(400);setFile(null);
        newGame(size);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(401);if ((m_gtp != null && ! m_gtp.isGenmoveSupported()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(403) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(402);m_computerBlack = false;
            m_computerWhite = false;
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(405);if ((m_computerBlack || m_computerWhite) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(407) && false))
        {
            // Set computer color to the color not to move to avoid automatic
            // move generation after starting a new game
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(406);if ((m_handicap == 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(409) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(408);m_computerBlack = false;
                m_computerWhite = true;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(410);m_computerBlack = true;
                m_computerWhite = false;
            }
        }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(404);boardChangedBegin(true, true);
    }

    public void actionNewProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(411);m_newProgram = new Program("", "", "", "", "");
        final ProgramEditor editor = new ProgramEditor();
        m_newProgram =
            editor.editItem(this, i18n("TIT_NEW_PROGRAM"), m_newProgram, true,
                            false, m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(412);if ((m_newProgram == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(414) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(413);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(415);protectGui();
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(416);attachNewProgram(m_newProgram.m_command, m_newProgram);
                    unprotectGui();
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(417);if ((m_gtp == null || m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(419) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(418);m_newProgram = editor.editItem(GoGui.this,
                                                       i18n("TIT_NEW_PROGRAM"),
                                                       m_newProgram, true,
                                                       false,
                                                       m_messageDialogs);
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(420);if ((m_newProgram == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(422) && false))
                            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(421);return;}
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(423);SwingUtilities.invokeLater(this);
                        return;
                    }
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(424);m_newProgram.m_name = m_gtp.getLabel();
                    m_newProgram.m_version = m_version;
                    m_newProgram.setUniqueLabel(m_programs);
                    m_newProgram = editor.editItem(GoGui.this,
                                                   i18n("TIT_NEW_PROGRAM"),
                                                   m_newProgram, false, true,
                                                   m_messageDialogs);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(425);if ((m_newProgram == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(427) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(426);actionDetachProgram();
                        return;
                    }
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(428);m_programs.add(m_newProgram);
                    m_program = m_newProgram;
                    m_prefs.putInt("program", m_programs.size() - 1);
                    m_menuBar.setPrograms(m_programs);
                    Program.save(m_programs);
                    updateViews(false);
                }
            });
    }

    public void actionNextEarlierVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(429);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(431) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(430);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(432);ConstNode node = NodeUtil.getNextEarlierVariation(getCurrentNode());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(433);if ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(435) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(434);actionGotoNode(node);}
    }

    public void actionNextVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(436);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(438) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(437);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(439);ConstNode node = NodeUtil.getNextVariation(getCurrentNode());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(440);if ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(442) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(441);actionGotoNode(node);}
    }

    public void actionOpen()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(443);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(445) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(444);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(446);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(448) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(447);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(449);File file = FileDialogs.showOpenSgf(this);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(450);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(452) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(451);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(453);actionOpenFile(file);
    }

    public void actionOpenFile(final File file)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(454);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(456) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(455);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(457);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(459) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(458);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(460);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(462) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(461);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(463);final boolean protectGui = (m_gtp != null);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(464);if ((protectGui) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(466) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(465);protectGui();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(467);SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(468);loadFile(file, -1);
                    boardChangedBegin(false, true);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(469);if ((protectGui) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(471) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(470);unprotectGui();}
                }
            });
    }

    public void actionPass()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(472);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(474) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(473);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(475);if ((! showOptionalQuestion("pass", i18n("MSG_PASS"),
                                   i18n("MSG_PASS_2"), i18n("LB_PASS"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(477) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(476);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(478);humanMoved(Move.getPass(getToMove()));
    }

    public void actionPlay(boolean isSingleMove)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(479);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(481) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(480);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(482);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(484) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(483);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(485);if ((! isSingleMove && ! isComputerBoth()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(487) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(486);m_computerBlack = false;
            m_computerWhite = false;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(488);if ((getToMove() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(490) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(489);m_computerBlack = true;}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(492);m_computerWhite = true;}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(491);generateMove(isSingleMove);
        m_game.startClock();
    }

    public void actionPreviousEarlierVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(493);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(495) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(494);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(496);ConstNode node =
            NodeUtil.getPreviousEarlierVariation(getCurrentNode());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(497);if ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(499) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(498);actionGotoNode(node);}
    }

    public void actionPreviousVariation()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(500);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(502) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(501);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(503);ConstNode node = NodeUtil.getPreviousVariation(getCurrentNode());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(504);if ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(506) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(505);actionGotoNode(node);}
    }

    public void actionPrint()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(507);Print.run(this, m_guiBoard, m_messageDialogs);
    }

    public void actionReattachProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(508);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(510) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(509);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(511);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(513) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(512);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(514);protectGui();
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(515);attachNewProgram(m_programCommand, m_program);
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(516);unprotectGui();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionReattachWithParameters()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(517);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(519) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(518);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(520);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(522) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(521);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(523);final boolean fromSnapshot =
            (isProgramDead() && m_parameterSnapshot != null);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(524);if ((! fromSnapshot) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(526) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(525);if ((! checkHasParameterCommands()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(528) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(527);return;}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(529);protectGui();
        Runnable runnable = new Runnable() {
                public void run() {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(530);File file;
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(531);if ((fromSnapshot) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(533) && false))
                            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(532);file = m_parameterSnapshot;}
                        else
                        {
                            try
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(539);file = File.createTempFile("gogui-param",
                                                           ".gtp");
                            }
                            catch (IOException e)
                            {
                                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(543);showError(i18n("MSG_PARAM_TMP_FILE_ERROR"), e);
                                return;
                            }
                            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(540);if ((! saveParameters(file)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(542) && false))
                                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(541);return;}
                        }
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(534);if ((! attachNewProgram(m_programCommand, m_program)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(536) && false))
                            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(535);return;}
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(537);sendGtpFile(file);
                    }
                    finally
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(538);unprotectGui();
                    }
                }
            };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionRestoreParameters()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(544);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(546) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(545);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(547);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(549) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(548);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(550);if ((m_parameterSnapshot == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(552) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(551);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(553);sendGtpFile(m_parameterSnapshot);
    }

    public void actionSave()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(554);if ((! isModified()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(556) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(555);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(557);if ((m_gameFile == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(559) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(558);actionSaveAs();}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(561);File file = m_gameFile.m_file;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(562);if ((file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(564) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(563);String mainMessage = format(i18n("MSG_REPLACE_FILE"),
                                            file.getName());
                String optionalMessage = i18n("MSG_REPLACE_FILE_2");
                String disableKey = "net.sf.gogui.GoGui.overwrite";
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(565);if ((! m_messageDialogs.showQuestion(disableKey, this,
                                                    mainMessage,
                                                    optionalMessage,
                                                    i18n("LB_REPLACE_FILE"),
                                                    true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(567) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(566);return;}
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(568);save(m_gameFile);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(560);updateViews(false);
    }

    public void actionSaveAs()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(569);saveDialog();
        updateViews(false);
    }

    public void actionSaveCommands()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(570);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(572) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(571);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(573);m_shell.saveCommands(this);
    }

    public void actionSaveLog()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(574);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(576) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(575);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(577);m_shell.saveLog(this);
    }

    public void actionSaveParameters()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(578);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(580) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(579);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(581);if ((! checkHasParameterCommands()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(583) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(582);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(584);File file = showSave(i18n("TIT_SAVE_PARAM"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(585);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(587) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(586);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(588);saveParameters(file);
    }

    public void actionSnapshotParameters()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(589);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(591) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(590);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(592);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(594) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(593);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(595);if ((! checkHasParameterCommands()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(597) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(596);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(598);if ((m_parameterSnapshot == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(600) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(599);try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(601);m_parameterSnapshot =
                    File.createTempFile("gogui-param", ".gtp");
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(603);showError(i18n("MSG_PARAM_TMP_FILE_ERROR"), e);
                return;
            }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(602);saveParameters(m_parameterSnapshot);
        updateViews(false);
    }

    public void actionScore()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(604);if ((m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(606) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(605);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(607);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(609) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(608);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(610);boolean programReady = (m_gtp != null && synchronizeProgram());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(611);if ((m_gtp == null || ! programReady) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(613) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(612);String disableKey = "net.sf.gogui.gogui.GoGui.score-no-program";
            String optionalMessage;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(614);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(616) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(615);optionalMessage = "MSG_SCORE_NO_PROGRAM";}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(618);optionalMessage = "MSG_SCORE_CANNOT_USE_PROGRAM";}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(617);m_messageDialogs.showInfo(disableKey, this,
                                      i18n("MSG_SCORE_MANUAL"),
                                      i18n(optionalMessage), true);
            updateViews(false);
            initScore(null);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(619);if ((m_gtp.isSupported("final_status_list")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(621) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(620);Runnable callback = new Runnable() {
                    public void run() {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(622);scoreContinue();
                    }
                };
            runLengthyCommand("final_status_list dead", callback);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(623);String disableKey =
                "net.sf.gogui.gogui.GoGui.score-not-supported";
            String optionalMessage;
            String name = getProgramName();
            optionalMessage = format(i18n("MSG_SCORE_NO_SUPPORT"), name);
            m_messageDialogs.showInfo(disableKey, this,
                                      i18n("MSG_SCORE_MANUAL"),
                                      optionalMessage, true);
            updateViews(false);
            initScore(null);
        }
    }

    public void actionScoreDone(Score score)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(624);if ((! m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(626) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(625);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(627);scoreDone(score);
        updateViews(false);
    }

    public void actionSendCommand(String command, final boolean isCritical,
                                  final boolean showError)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(628);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(630) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(629);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(631);if ((GtpUtil.isStateChangingCommand(command)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(633) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(632);showError(i18n("MSG_BOARD_CHANGING_COMMAND"), "", false);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(634);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(636) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(635);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(637);Runnable callback = new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(638);endLengthyCommand(isCritical, showError);
                }
            };
        m_gtp.send(command, callback);
        beginLengthyCommand();
    }

    public void actionSendFile()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(639);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(641) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(640);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(642);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(644) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(643);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(645);File file = FileDialogs.showOpen(this, i18n("TIT_CHOOSE_GTP_FILE"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(646);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(648) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(647);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(649);actionSendFile(file);
    }

    public void actionSendFile(File file)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(650);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(652) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(651);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(653);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(655) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(654);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(656);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(658) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(657);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(659);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(661) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(660);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(662);sendGtpFile(file);
        m_menuBar.addRecentGtp(file);
        updateViews(false);
    }

    public void actionSetAnalyzeCommand(AnalyzeCommand command)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(663);actionSetAnalyzeCommand(command, false, true, true, false);
    }

    public void actionSetAnalyzeCommand(AnalyzeCommand command,
                                        boolean autoRun, boolean clearBoard,
                                        boolean oneRunOnly,
                                        boolean reuseTextWindow)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(664);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(666) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(665);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(667);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(669) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(668);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(670);initAnalyzeCommand(command, autoRun, clearBoard, reuseTextWindow);
        m_analyzeOneRunOnly = oneRunOnly;
        boolean needsPointArg = m_analyzeCommand.needsPointArg();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(671);if ((needsPointArg && ! m_analyzeCommand.isPointArgMissing()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(673) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(672);m_guiBoard.clearAllSelect();
            m_guiBoard.setSelect(m_analyzeCommand.getPointArg(), true);
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(675);if ((needsPointArg || m_analyzeCommand.needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(677) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(676);m_guiBoard.clearAllSelect();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(678);if ((m_analyzeCommand.getType() == AnalyzeType.EPLIST) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(680) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(679);GuiBoardUtil.setSelect(m_guiBoard,
                                       m_analyzeCommand.getPointListArg(),
                                       true);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(681);toFront();
            return;
        }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(674);analyzeBegin(false);
    }

    public void actionSetShowVariations(ShowVariations mode)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(682);m_showVariations = mode;
        m_prefs.putInt("show-variations", m_showVariations.ordinal());
        resetBoard();
        updateViews(false);
    }

    public void actionSetTimeLeft()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(683);TimeLeftDialog.show(this, m_game, getCurrentNode(), m_messageDialogs);
        updateViews(false);
    }

    public void actionSetup(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(684);assert color.isBlackWhite();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(685);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(687) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(686);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(688);if ((m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(690) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(689);scoreDone(null);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(691);ConstNode node = getCurrentNode();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(692);if ((m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(694) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(693);if ((color == m_setupColor) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(696) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(695);setupDone();
                boardChangedBegin(false, true);
            }
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(704);m_setupColor = color;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(697);updateViews(false);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(705);resetBoard();
            m_setupMode = true;
            m_setupColor = color;
            m_setupNodeCreated = (node.getMove() != null || node.hasChildren());
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(706);if ((m_setupNodeCreated) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(708) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(707);m_game.createNewChild();
                currentNodeChanged();
                updateViews(true);
            }
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(709);updateViews(false);}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(698);if ((m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(700) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(699);if ((m_setupColor == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(702) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(701);showStatus(i18n("STAT_SETUP_BLACK"));}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(703);showStatus(i18n("STAT_SETUP_WHITE"));}
        }
    }

    public void actionShowAnalyzeDialog()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(710);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(712) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(711);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(713);if ((m_analyzeDialog == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(715) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(714);createAnalyzeDialog();}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(716);m_analyzeDialog.toFront();}
    }

    public void actionShowShell()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(717);showShell();
    }

    public void actionShowTree()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(718);if ((m_gameTreeViewer == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(720) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(719);createTree();
            updateViews(false);
        }
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(721);m_gameTreeViewer.toFront();}
    }

    public void actionToggleBeepAfterMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(722);m_beepAfterMove = ! m_beepAfterMove;
        m_prefs.putBoolean("beep-after-move", m_beepAfterMove);
    }

    public void actionToggleAutoNumber()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(723);m_autoNumber = ! m_autoNumber;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(724);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(726) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(725);m_gtp.setAutoNumber(m_autoNumber);}
    }

    public void actionToggleCommentMonoFont()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(727);boolean monoFont = ! m_comment.getMonoFont();
        m_comment.setMonoFont(monoFont);
        m_prefs.putBoolean("comment-font-fixed", monoFont);
    }

    public void actionToggleCompletion()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(728);m_commandCompletion = ! m_commandCompletion;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(729);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(731) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(730);m_shell.setCommandCompletion(m_commandCompletion);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(732);m_prefs.putBoolean("gtpshell-disable-completions",
                           ! m_commandCompletion);
    }

    public void actionToggleShowCursor()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(733);boolean showCursor = ! m_guiBoard.getShowCursor();
        m_guiBoard.setShowCursor(showCursor);
        m_prefs.putBoolean("show-cursor", showCursor);
    }

    public void actionToggleShowGrid()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(734);boolean showGrid = ! m_guiBoard.getShowGrid();
        m_guiBoard.setShowGrid(showGrid);
        m_prefs.putBoolean("show-grid", showGrid);
    }

    public void actionToggleShowInfoPanel()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(735);if ((GuiUtil.isNormalSizeMode(this)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(737) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(736);if ((m_showInfoPanel) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(739) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(738);m_comment.setPreferredSize(m_comment.getSize());}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(740);m_guiBoard.setPreferredFieldSize(m_guiBoard.getFieldSize());
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(741);showInfoPanel(! m_showInfoPanel);
        updateViews(false);
    }

    public void actionToggleShowLastMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(742);m_showLastMove = ! m_showLastMove;
        m_prefs.putBoolean("show-last-move", m_showLastMove);
        updateFromGoBoard();
        updateViews(false);
    }

    public void actionToggleShowMoveNumbers()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(743);if ((m_showMoveNumbers) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(745) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(744);m_guiBoard.clearAllLabels();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(746);m_showMoveNumbers = ! m_showMoveNumbers;
        m_prefs.putBoolean("show-move-numbers", m_showMoveNumbers);
        updateFromGoBoard();
        updateViews(false);
    }

    public void actionToggleShowSubtreeSizes()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(747);m_showSubtreeSizes = ! m_showSubtreeSizes;
        m_prefs.putBoolean("gametree-show-subtree-sizes", m_showSubtreeSizes);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(748);if ((m_gameTreeViewer == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(750) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(749);updateViews(false);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(751);m_gameTreeViewer.setShowSubtreeSizes(m_showSubtreeSizes);
            updateViews(true);
        }
    }

    public void actionToggleShowToolbar()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(752);if ((GuiUtil.isNormalSizeMode(this)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(754) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(753);if ((m_showInfoPanel) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(756) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(755);m_comment.setPreferredSize(m_comment.getSize());}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(757);m_guiBoard.setPreferredFieldSize(m_guiBoard.getFieldSize());
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(758);showToolbar(! m_showToolbar);
        updateViews(false);
    }

    public void actionToggleTimeStamp()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(759);m_timeStamp = ! m_timeStamp;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(760);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(762) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(761);m_shell.setTimeStamp(m_timeStamp);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(763);m_prefs.putBoolean("gtpshell-timestamp", m_timeStamp);
        updateViews(false);
    }

    public void actionTreeLabels(GameTreePanel.Label mode)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(764);m_treeLabels = mode;
        m_prefs.putInt("gametree-labels", mode.ordinal());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(765);if ((m_gameTreeViewer == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(767) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(766);updateViews(false);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(768);m_gameTreeViewer.setLabelMode(mode);
            updateViews(true);
        }
    }

    public void actionTreeSize(GameTreePanel.Size mode)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(769);m_treeSize = mode;
        m_prefs.putInt("gametree-size", mode.ordinal());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(770);if ((m_gameTreeViewer == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(772) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(771);updateViews(false);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(773);m_gameTreeViewer.setSizeMode(mode);
            updateViews(true);
        }
    }

    public void actionTruncate()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(774);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(776) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(775);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(777);if ((! getCurrentNode().hasFather()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(779) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(778);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(780);String disableKey = "net.sf.gogui.gogui.GoGui.truncate";
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(781);if ((! m_messageDialogs.showQuestion(disableKey, this,
                                            i18n("MSG_TRUNCATE"),
                                            i18n("MSG_TRUNCATE_2"),
                                            i18n("LB_TRUNCATE"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(783) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(782);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(784);m_game.truncate();
        actionGotoNode(getCurrentNode());
        boardChangedBegin(false, true);
    }

    public void actionTruncateChildren()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(785);if ((! checkStateChangePossible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(787) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(786);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(788);int numberChildren = getCurrentNode().getNumberChildren();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(789);if ((numberChildren == 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(791) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(790);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(792);String disableKey = "net.sf.gogui.gogui.GoGui.truncate-children";
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(793);if ((! m_messageDialogs.showQuestion(disableKey, this,
                                            i18n("MSG_TRUNCATE_CHILDREN"),
                                            i18n("MSG_TRUNCATE_CHILDREN_2"),
                                            i18n("LB_TRUNCATE"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(795) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(794);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(796);m_game.truncateChildren();
        boardChangedBegin(false, true);
    }

    public void actionQuit()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(797);close();
    }

    public boolean getAutoNumber()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(798);return m_autoNumber;
    }

    public boolean getBeepAfterMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(799);return m_beepAfterMove;
    }

    public boolean getCommentMonoFont()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(800);return m_comment.getMonoFont();
    }

    public boolean getCompletion()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(801);return m_commandCompletion;
    }

    /** Get name of currently attached program.
        @return Name or null, if no program is attached or name is not
        known. */
    public String getProgramName()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(802);String name = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(803);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(805) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(804);name = m_gtp.getName();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(806);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(808) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(807);name = i18n("MSG_UNKNOWN_PROGRAM_NAME");}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(809);return name;
    }

    public int getNumberPrograms()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(810);return m_programs.size();
    }

    /** Get label for currently attached program.
        @return Label from Program instance, if program was created with a
        Program instance, otherwise label as in GtpClientBase#getLabel; null
        if no program is attached. */
    public String getProgramLabel()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(811);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(813) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(812);return null;}
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(814);if ((m_program != null && ! StringUtil.isEmpty(m_program.m_label)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(816) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(815);return m_program.m_label;}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(817);return m_gtp.getLabel();}}
    }

    public GoColor getSetupColor()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(818);return m_setupColor;
    }

    public boolean getShowLastMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(819);return m_showLastMove;
    }

    public boolean getShowMoveNumbers()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(820);return m_showMoveNumbers;
    }

    public boolean getShowSubtreeSizes()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(821);return m_showSubtreeSizes;
    }

    public ShowVariations getShowVariations()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(822);return m_showVariations;
    }

    public boolean getTimeStamp()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(823);return m_timeStamp;
    }

    public GameTreePanel.Label getTreeLabels()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(824);return m_treeLabels;
    }

    public GameTreePanel.Size getTreeSize()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(825);return m_treeSize;
    }

    /** Return whether the currently attached program has analyze commands of
        type "param". */
    public boolean hasParameterCommands()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(826);if ((m_analyzeCommands == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(828) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(827);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(829);return AnalyzeUtil.hasParameterCommands(m_analyzeCommands);
    }

    public boolean hasParameterSnapshot()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(830);return m_parameterSnapshot != null;
    }

    public boolean isAnalyzeDialogShown()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(831);return (m_analyzeDialog != null);
    }

    public boolean isCommandInProgress()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(832);return (m_gtp != null && m_gtp.isCommandInProgress());
    }

    /** Check if computer plays a color (or both). */
    public boolean isComputerColor(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(833);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(835) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(834);return m_computerBlack;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(836);assert color == WHITE;
        return m_computerWhite;
    }

    public boolean isInfoPanelShown()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(837);return m_showInfoPanel;
    }

    public boolean isShellShown()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(838);return (m_shell != null && m_shell.isVisible());
    }

    public boolean isToolbarShown()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(839);return m_showToolbar;
    }

    public boolean isTreeShown()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(840);return (m_gameTreeViewer != null);
    }

    public void contextMenu(GoPoint point, Component invoker, int x, int y)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(841);if ((m_setupMode
            || (m_analyzeCommand != null
                && m_analyzeCommand.needsPointListArg())) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(843) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(842);fieldClicked(point, true);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(844);ContextMenu contextMenu = createContextMenu(point);
        contextMenu.show(invoker, x, y);
    }

    public void fieldClicked(GoPoint p, boolean modifiedSelect)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(845);if ((m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(847) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(846);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(849) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(848);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(850);GoColor color;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(851);if ((modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(853) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(852);color = m_setupColor.otherColor();}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(858);color = m_setupColor;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(854);if ((getBoard().getColor(p) == color) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(856) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(855);color = EMPTY;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(857);setup(p, color);
            updateViews(false);
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(859);if ((m_analyzeCommand != null && m_analyzeCommand.needsPointArg()
                 && ! modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(861) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(860);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(863) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(862);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(864);m_analyzeCommand.setPointArg(p);
            m_guiBoard.clearAllSelect();
            m_guiBoard.setSelect(p, true);
            analyzeBegin(false);
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(865);if ((m_analyzeCommand != null
                 && m_analyzeCommand.needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(867) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(866);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(869) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(868);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(870);PointList pointListArg = m_analyzeCommand.getPointListArg();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(871);if ((pointListArg.contains(p)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(873) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(872);pointListArg.remove(p);
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(874);if ((modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(876) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(875);pointListArg.add(p);}
            }
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(881);pointListArg.add(p);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(877);m_guiBoard.clearAllSelect();
            GuiBoardUtil.setSelect(m_guiBoard, pointListArg, true);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(878);if ((modifiedSelect && pointListArg.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(880) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(879);analyzeBegin(false);}
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(882);if ((m_scoreMode && ! modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(884) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(883);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(886) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(885);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(887);GuiBoardUtil.scoreSetDead(m_guiBoard, m_countScore, getBoard(), p);
            Komi komi = getGameInfo().getKomi();
            m_scoreDialog.showScore(m_countScore, komi);
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(888);if ((modifiedSelect) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(890) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(889);m_guiBoard.contextMenu(p);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(891);if ((getBoard().getColor(p) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(893) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(892);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(894);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(896) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(895);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(897);if ((getBoard().isSuicide(getToMove(), p)
                && ! showQuestion(i18n("MSG_SUICIDE"), i18n("MSG_SUICIDE_2"),
                                  i18n("LB_SUICIDE"),false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(899) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(898);return;}
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(900);if ((getBoard().isKo(p)
                     && ! showQuestion(i18n("MSG_ILLEGAL_KO"),
                                       i18n("MSG_ILLEGAL_KO_2"),
                                       i18n("LB_ILLEGAL_KO"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(902) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(901);return;}}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(903);Move move = Move.get(getToMove(), p);
            humanMoved(move);
        }}}}}
    }

    public GoGuiActions getActions()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(904);return m_actions;
    }

    public File getFile()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(905);if ((m_gameFile == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(907) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(906);return null;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(908);return m_gameFile.m_file;
    }

    public ConstGame getGame()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(909);return m_game;
    }

    public ConstGuiBoard getGuiBoard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(910);return m_guiBoard;
    }

    public int getHandicapDefault()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(911);return m_handicap;
    }

    public boolean getMonoFont()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(912);return m_comment.getMonoFont();
    }

    /** Get currently used pattern for search in comments. */
    public Pattern getPattern()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(913);return m_pattern;
    }

    public boolean isInSetupMode()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(914);return m_setupMode;
    }

    /** Callback for selected text.
        This is a callback for text selection exents in different components.
        It parses the text for valid points and marks them on the board. */
    public void textSelected(String text)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(915);if ((text == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(917) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(916);text = "";}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(918);PointList points = GtpUtil.parsePointString(text, getBoardSize());
        GuiBoardUtil.showPointList(m_guiBoard, points);
    }

    public void initAnalyzeCommand(AnalyzeCommand command, boolean autoRun,
                                   boolean clearBoard, boolean reuseTextWindow)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(919);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(921) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(920);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(922);m_analyzeCommand = command;
        m_analyzeAutoRun = autoRun;
        m_analyzeClearBoard = clearBoard;
        m_analyzeReuseTextWindow = reuseTextWindow;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(923);if ((command.needsPointArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(925) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(924);setBoardCursor(Cursor.HAND_CURSOR);
            showStatusSelectTarget();
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(926);if ((command.needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(928) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(927);setBoardCursor(Cursor.HAND_CURSOR);
            showStatusSelectPointList();
        }}
    }

    public boolean isInterruptSupported()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(929);return (m_gtp != null && m_gtp.isInterruptSupported());
    }

    public boolean isModified()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(930);return m_game.isModified();
    }

    /** Return if a program is currently attached.
        Also returns true, if a program is attached but dead, which can be
        checked with isProgramDead() */
    public boolean isProgramAttached()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(931);return (m_gtp != null);
    }

    public boolean isProgramDead()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(932);return (m_gtp != null && m_gtp.isProgramDead());
    }

    public void showLiveGfx(String text)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(933);assert SwingUtilities.isEventDispatchThread();
        // The live gfx events can arrive delayed, we don't want to allow
        // them to paint on the board, if no command is currently running
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(934);if ((! isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(936) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(935);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(937);m_guiBoard.clearAll();
        GuiBoardUtil.updateFromGoBoard(m_guiBoard, getBoard(), false, false);
        AnalyzeShow.showGfx(text, m_guiBoard, m_statusBar, null);
    }

    private class AnalyzeContinue
        implements Runnable
    {
        public AnalyzeContinue(boolean checkComputerMove)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(938);m_checkComputerMove = checkComputerMove;
        }

        public void run()
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(939);analyzeContinue(m_checkComputerMove);
        }

        private final boolean m_checkComputerMove;
    }

    private class ShowInvalidResponse
        implements Runnable
    {
        public ShowInvalidResponse(String line)
        {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d567d57f2efb689b(940);
        }

        public void run()
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(941);String name = getProgramName();
            String mainMessage = format(i18n("MSG_INVALID_RESPONSE"), name);
            String disableKey = "net.sf.gogui.gogui.GoGui.invalid-response";
            String optionalMessage =
                format(i18n("MSG_INVALID_NOSTATUS_RESPONSE"), name);
            m_messageDialogs.showWarning(disableKey, GoGui.this, mainMessage,
                                         optionalMessage, true);
        }
    }

    private static class LoadFileRunnable
        implements GuiUtil.ProgressRunnable
    {
        public LoadFileRunnable(File file)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(942);m_file = file;
        }

        public GameTree getTree()
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(943);return m_reader.getTree();
        }

        public String getWarnings()
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(944);return m_reader.getWarnings();
        }

        public GameFile getGameFile()
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(945);return m_reader.getFile();
        }

        public void run(ProgressShow progressShow) throws Throwable
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(946);m_reader = new GameReader(m_file, progressShow);
        }

        private final File m_file;

        private GameReader m_reader;
    }

    private boolean m_analyzeAutoRun;

    private boolean m_analyzeClearBoard;

    private boolean m_analyzeOneRunOnly;

    private boolean m_analyzeReuseTextWindow;

    private boolean m_autoNumber;

    private boolean m_commandCompletion;

    /** Automatically register program in Program menu if GoGui was invoked
        with the option -program */
    private final boolean m_register;

    private boolean m_timeStamp;

    private final boolean m_auto;

    private boolean m_beepAfterMove;

    private boolean m_computerBlack;

    private boolean m_computerWhite;

    /** State variable used between generateMove and computerMoved.
        Flag is set in actionInterrupt. */
    private boolean m_interruptComputerBoth;

    /** State variable used between generateMove and computerMoved. */
    private boolean m_isSingleMove;

    private boolean m_lostOnTimeShown;

    private boolean m_resigned;

    private boolean m_scoreMode;

    private boolean m_setupMode;

    private boolean m_showInfoPanel;

    private boolean m_showLastMove;

    private boolean m_showMoveNumbers;

    private boolean m_showSubtreeSizes;

    private boolean m_showToolbar;

    private ShowVariations m_showVariations;

    private boolean m_setupNodeCreated;

    private final boolean m_verbose;

    private int m_handicap;

    private final int m_move;

    private GameTreePanel.Label m_treeLabels;

    private GameTreePanel.Size m_treeSize;

    private final GuiBoard m_guiBoard;

    private GuiGtpClient m_gtp;

    private final Comment m_comment;

    private final Interrupt m_interrupt = new Interrupt();

    /** File corresponding to the current game. */
    private GameFile m_gameFile;

    private File m_initialFile;

    private final GameInfoPanel m_gameInfoPanel;

    private GtpShell m_shell;

    private GameTreeViewer m_gameTreeViewer;

    private Help m_help;

    private final JPanel m_infoPanel;

    private final JPanel m_innerPanel;

    private final JSplitPane m_splitPane;

    private final GoGuiMenuBar m_menuBar;

    private final Game m_game;

    private GoColor m_setupColor;

    private final MessageDialogs m_messageDialogs = new MessageDialogs();

    private Pattern m_pattern;

    private final File m_analyzeCommandsFile;

    private AnalyzeCommand m_analyzeCommand;

    private final Session m_session =
        new Session("net/sf/gogui/gogui/session");

    private final CountScore m_countScore = new CountScore();

    private final StatusBar m_statusBar;

    private final String m_gtpCommand;

    private final String m_gtpFile;

    private String m_lastAnalyzeCommand;

    private String m_programCommand;

    private String m_titleFromProgram;

    private String m_version = "";

    private AnalyzeDialog m_analyzeDialog;

    private final Preferences m_prefs =
        Preferences.userNodeForPackage(getClass());

    private ScoreDialog m_scoreDialog;

    private ArrayList<AnalyzeDefinition> m_analyzeCommands;

    /** Program information.
        Can be null even if a program is attached, if only m_programName
        is known. */
    private Program m_program;

    /** Program currently being edited in actionNewProgram() */
    private Program m_newProgram;

    private final ThumbnailCreator m_thumbnailCreator =
        new ThumbnailCreator(false);

    private TimeSettings m_timeSettings;

    private final GoGuiActions m_actions = new GoGuiActions(this);

    private final GoGuiToolBar m_toolBar;

    private ArrayList<Bookmark> m_bookmarks;

    private ArrayList<Program> m_programs;

    private ShowAnalyzeText m_showAnalyzeText;

    /** Snapshot used in actionSnapshotParameters and actionRestoreParameters. */
    private File m_parameterSnapshot;

    private void analyzeBegin(boolean checkComputerMove)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(947);if ((m_gtp == null || m_analyzeCommand == null
            || m_analyzeCommand.isPointArgMissing()
            || ! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(949) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(948);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(950);GoColor toMove = getToMove();
        m_lastAnalyzeCommand = m_analyzeCommand.replaceWildCards(toMove);
        runLengthyCommand(m_lastAnalyzeCommand,
                          new AnalyzeContinue(checkComputerMove));
        showStatus(format(i18n("STAT_RUNNING"),
                          m_analyzeCommand.getResultTitle()));
    }

    private void analyzeContinue(boolean checkComputerMove)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(951);if ((m_analyzeClearBoard) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(953) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(952);resetBoard();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(954);boolean isCritical = (m_gtp != null && m_gtp.isProgramDead());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(955);if ((! endLengthyCommand(isCritical)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(957) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(956);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(958);clearStatus();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(959);if ((m_analyzeCommand == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(961) && false))
        {
            // Program was detached while running the analyze command
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(960);resetBoard();
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(962);String title = m_analyzeCommand.getResultTitle();
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(963);String response = m_gtp.getResponse();
            StringBuilder showTextBuffer = new StringBuilder(256);
            AnalyzeShow.show(m_analyzeCommand, m_guiBoard, m_statusBar,
                             getBoard(), response, showTextBuffer);
            AnalyzeType type = m_analyzeCommand.getType();
            GoPoint pointArg = null;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(964);if ((m_analyzeCommand.needsPointArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(966) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(965);pointArg = m_analyzeCommand.getPointArg();}
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(995);if ((m_analyzeCommand.needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(997) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(996);ConstPointList list = m_analyzeCommand.getPointListArg();
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(998);if ((list.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1000) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(999);pointArg = list.get(list.size() - 1);}
            }}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(967);if ((type == AnalyzeType.PARAM) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(969) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(968);ParameterDialog.editParameters(m_lastAnalyzeCommand, this,
                                               title, response, m_gtp,
                                               m_messageDialogs);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(970);boolean isTextType = m_analyzeCommand.isTextType();
            String showText = null;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(971);if ((showTextBuffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(973) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(972);showText = showTextBuffer.toString();}
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(992);if ((isTextType) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(994) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(993);showText = response;}}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(974);if ((showText != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(976) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(975);if ((showText.indexOf("\n") < 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(978) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(977);if ((isTextType && showText.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(980) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(979);showText = i18n("STAT_ANALYZE_TEXT_EMPTY_RESPONSE");}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(981);showStatus(format(i18n("STAT_ANALYZE_TEXT_RESPONSE"),
                                      title, showText));
                }
                else
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(991);m_showAnalyzeText.show(type, pointArg, title, showText,
                                           m_analyzeReuseTextWindow);
                }
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(982);if (("".equals(m_statusBar.getText()) && type != AnalyzeType.PARAM) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(984) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(983);showStatus(title);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(985);if ((checkComputerMove) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(987) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(986);checkComputerMove();}
        }
        catch (GtpResponseFormatError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1001);showStatus(title);
            showError(e);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(988);if ((m_analyzeOneRunOnly) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(990) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(989);clearAnalyzeCommand(false);}
        }
    }

    private boolean attachNewProgram(String command, Program program)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1002);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1004) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1003);saveSession();
            detachProgram();
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1005);if ((! attachProgram(command, program, false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1007) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1006);m_prefs.putInt("program", -1);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1008);if ((m_gtp == null || m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1010) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1009);if ((! m_shell.isVisible() && m_shell.isLastTextNonGTP()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1012) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1011);showShell();}}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1013);updateViews(false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1014);if ((m_shell != null && m_session.isVisible("shell")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1016) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1015);m_shell.setVisible(true);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1017);if ((m_session.isVisible("analyze")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1019) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1018);createAnalyzeDialog();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1020);toFrontLater();
        updateViews(false);
        return true;
    }

    /** Attach program.
        @param programCommand Command line for running program.
        @param program Program information (may be null)
        @param register Create an entry for this program in the Program menu.
        @return true if program was successfully attached. */
    private boolean attachProgram(String programCommand, Program program,
                                  boolean register)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1021);programCommand = programCommand.trim();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1022);if ((programCommand.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1024) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1023);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1025);m_program = program;
        m_programCommand = programCommand;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1026);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1028) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1027);m_shell.dispose();
            m_shell = null;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1029);m_shell = new GtpShell(this, this, m_messageDialogs);
        GuiAction.registerAll(m_shell.getLayeredPane());
        m_shell.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1030);saveSession();
                    hideShell();
                }
            });
        restoreSize(m_shell, "shell");
        m_shell.setProgramCommand(programCommand);
        m_shell.setTimeStamp(m_timeStamp);
        m_shell.setCommandCompletion(m_commandCompletion);
        GtpClient.InvalidResponseCallback invalidResponseCallback =
            new GtpClient.InvalidResponseCallback()
            {
                public void show(String line)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1031);Runnable runnable = new ShowInvalidResponse(line);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1032);if ((SwingUtilities.isEventDispatchThread()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1034) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1033);runnable.run();}
                    else
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1035);GuiUtil.invokeAndWait(runnable);}
                }
            };
        GtpClient.IOCallback ioCallback = new GtpClient.IOCallback()
            {
                public void receivedInvalidResponse(String s)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1036);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1038) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1037);return;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1039);boolean invokeLater = true;
                    m_shell.receivedInvalidResponse(s, invokeLater);
                }

                public void receivedResponse(boolean error, String s)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1040);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1042) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1041);return;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1043);boolean invokeLater = true;
                    m_shell.receivedResponse(error, s, invokeLater);
                }

                public void receivedStdErr(String s)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1044);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1046) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1045);return;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1047);m_lineReader.add(s);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1048);while ((m_lineReader.hasLines()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1050) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1049);String line = m_lineReader.getLine();
                        boolean isLiveGfx = m_liveGfx.handleLine(line);
                        boolean isWarning =
                            line.startsWith("warning:")
                            || line.startsWith("Warning:")
                            || line.startsWith("WARNING:");
                        boolean invokeLater = true;
                        m_shell.receivedStdErr(line, invokeLater, isLiveGfx,
                                               isWarning);
                    }
                }

                public void sentCommand(String s)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1051);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1053) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1052);m_shell.sentCommand(s);}
                }

                private final LineReader m_lineReader = new LineReader();

                private LiveGfx m_liveGfx = new LiveGfx(GoGui.this);
            };
        GtpSynchronizer.Listener synchronizerCallback =
            new GtpSynchronizer.Listener() {
                public void moveNumberChanged(int moveNumber) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1054);String text = "[" + moveNumber + "]";
                    m_statusBar.immediatelyPaintMoveText(text);
                }
            };
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1055);showStatusImmediately(i18n("STAT_ATTACHING_PROGRAM"));
            File workingDirectory = null;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1056);if ((program != null
                && ! StringUtil.isEmpty(program.m_workingDirectory)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1058) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1057);workingDirectory = new File(program.m_workingDirectory);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1059);GtpClient gtp =
                new GtpClient(m_programCommand, workingDirectory,
                              m_verbose, ioCallback);
            gtp.setInvalidResponseCallback(invalidResponseCallback);
            gtp.setAutoNumber(m_autoNumber);
            m_gtp = new GuiGtpClient(gtp, this, synchronizerCallback,
                                     m_messageDialogs);
            m_gtp.queryName();
            m_gtp.queryProtocolVersion();
            try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1060);m_version = m_gtp.queryVersion();
                m_shell.setProgramVersion(m_version);
                m_gtp.querySupportedCommands();
                m_gtp.queryInterruptSupport();
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1061);if ((m_program == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1063) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1062);m_program =
                        Program.findProgram(m_programs, programCommand);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1064);if ((m_program == null && m_register) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1066) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1065);m_program = new Program("", m_gtp.getName(), m_version,
                                                programCommand, "");
                        m_program.setUniqueLabel(m_programs);
                        m_programs.add(m_program);
                        m_menuBar.setPrograms(m_programs);
                        Program.save(m_programs);
                    }
                }
            }
            catch (GtpError e)
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1086);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1067);if ((m_program != null
                && m_program.updateInfo(getProgramName(), m_version)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1069) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1068);Program.save(m_programs);
                m_menuBar.setPrograms(m_programs);
            }
            try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1070);String programAnalyzeCommands
                    = GtpClientUtil.getAnalyzeCommands(m_gtp);
                m_analyzeCommands
                    = AnalyzeDefinition.read(m_gtp.getSupportedCommands(),
                                             m_analyzeCommandsFile,
                                             programAnalyzeCommands);
            }
            catch (ErrorMessage e)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1085);showError(i18n("MSG_COULD_NOT_READ_ANALYZE_CONFIGURATION"), e);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1071);restoreSize(m_shell, "shell");
            m_shell.setProgramName(getProgramLabel());
            ArrayList<String> supportedCommands =
                m_gtp.getSupportedCommands();
            m_shell.setInitialCompletions(supportedCommands);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1072);if ((! m_gtp.isGenmoveSupported()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1074) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1073);m_computerBlack = false;
                m_computerWhite = false;
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1075);initGtp();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1076);if ((! m_gtpFile.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1078) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1077);sendGtpFile(new File(m_gtpFile));}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1079);if ((! m_gtpCommand.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1081) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1080);sendGtpString(m_gtpCommand);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1082);setTitle();
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1087);showError(e);
            return false;
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1083);clearStatus();
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1084);currentNodeChanged();
        return true;
    }

    private void beginLengthyCommand()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1088);setBoardCursor(Cursor.WAIT_CURSOR);
        m_shell.setCommandInProgess(true);
        showStatus(format(i18n("STAT_THINKING"), getProgramName()));
        updateViews(false);
    }

    private void boardChangedBegin(boolean doCheckComputerMove,
                                   boolean gameTreeChanged)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1089);updateFromGoBoard();
        updateViews(gameTreeChanged);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1090);if ((m_analyzeDialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1092) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1091);m_analyzeDialog.setSelectedColor(getToMove());}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1093);if ((m_gtp != null
            && ! isOutOfSync()
            && m_analyzeCommand != null
            && m_analyzeAutoRun
            && ! m_analyzeCommand.isPointArgMissing()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1095) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1094);analyzeBegin(doCheckComputerMove);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1096);resetBoard();
            clearStatus();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1097);if ((doCheckComputerMove) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1099) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1098);checkComputerMove();}
        }
    }

    private boolean checkCommandInProgress()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1100);if ((isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1102) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1101);showError(i18n("MSG_CANNOT_EXECUTE_WHILE_THINKING"),
                      i18n("MSG_CANNOT_EXECUTE_WHILE_THINKING_2"), false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1103);return true;
    }

    private void checkComputerMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1104);if ((m_gtp == null || isOutOfSync() || m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1106) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1105);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1107);int moveNumber = NodeUtil.getMoveNumber(getCurrentNode());
        boolean bothPassed = (moveNumber >= 2 && getBoard().bothPassed());
        boolean gameFinished = (bothPassed || m_resigned);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1108);if ((isComputerBoth()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1110) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1109);if ((gameFinished) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1112) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1111);if ((m_auto) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1114) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1113);newGame(getBoardSize());
                    updateViews(true, true);
                    checkComputerMove();
                    return;
                }
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1115);m_game.haltClock();
                showGameFinished();
                return;
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1116);generateMove(false);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1117);if ((gameFinished) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1119) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1118);m_game.haltClock();
                showGameFinished();
                return;
            }
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1120);if ((computerToMove()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1122) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1121);generateMove(false);}}
        }
    }

    private boolean checkHasParameterCommands()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1123);if ((! AnalyzeUtil.hasParameterCommands(m_analyzeCommands)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1125) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1124);String optionalMessage =
                format(i18n("MSG_NO_PARAM_COMMANDS_2"), getProgramName());
            showError(i18n("MSG_NO_PARAM_COMMANDS"), optionalMessage);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1126);return true;
    }

    private void checkLostOnTime(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1127);if ((getClock().lostOnTime(color)
            && ! getClock().lostOnTime(color.otherColor())
            && ! m_lostOnTimeShown) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1129) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1128);String result = color.otherColor().getUppercaseLetter() + "+Time";
            String mainMessage;
            String optionalMessage;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1130);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1132) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1131);mainMessage = i18n("MSG_LOST_ON_TIME_BLACK");
                optionalMessage = format(i18n("MSG_LOST_ON_TIME_BLACK_2"),
                                         result);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1134);mainMessage = i18n("MSG_LOST_ON_TIME_WHITE");
                optionalMessage = format(i18n("MSG_LOST_ON_TIME_WHITE_2"),
                                         result);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1133);showInfo(mainMessage, optionalMessage, false);
            setResult(result);
            m_lostOnTimeShown = true;
        }
    }

    private boolean checkSaveGame()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1135);return checkSaveGame(false);
    }

    /** Ask for saving file if it was modified.
        @return true If file was not modified, user chose not to save it
        or file was saved successfully */
    private boolean checkSaveGame(boolean isProgramTerminating)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1136);if ((! isModified()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1138) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1137);return true;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1139);String mainMessage = i18n("MSG_SAVE_CURRENT");
        String optionalMessage = i18n("MSG_SAVE_CURRENT_2");
        int result;
        String disableKey = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1140);if ((! isProgramTerminating) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1142) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1141);disableKey = "net.sf.gogui.gogui.GoGui.save";}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1143);result = m_messageDialogs.showYesNoCancelQuestion(disableKey, this,
                                                          mainMessage,
                                                          optionalMessage,
                                                          i18n("LB_DONT_SAVE"),
                                                          i18n("LB_SAVE"));
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1144);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (result)
        {
        case 0:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1145); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1149);m_game.clearModified();
            return true;
        case 1:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1146); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1150);if ((m_gameFile == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1152) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1151);return saveDialog();}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1153);return save(m_gameFile);}
        case 2:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1147); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1154);return false;
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1148); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1155);assert false;
            return true;
        }
    }

    /** Check if command is in progress or setup or score mode. */
    private boolean checkStateChangePossible()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1156);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1158) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1157);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1159);if ((m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1161) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1160);setupDone();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1162);if ((m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1164) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1163);scoreDone(null);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1165);return true;
    }

    private void clearAnalyzeCommand()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1166);clearAnalyzeCommand(true);
    }

    private void clearAnalyzeCommand(boolean resetBoard)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1167);if ((m_analyzeCommand != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1169) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1168);m_analyzeCommand = null;
            setBoardCursorDefault();
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1170);if ((resetBoard) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1172) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1171);resetBoard();
            clearStatus();
        }
    }

    private void clearStatus()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1173);m_statusBar.clear();
    }

    private void close()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1174);if ((! checkSaveGame(true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1176) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1175);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1177);saveSession();
        setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1178);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1180) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1179);m_analyzeCommand = null;
                        detachProgram();
                    }
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1181);dispose();
                    System.exit(0);
                }
            });
    }

    private void computerMoved()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1182);if ((! endLengthyCommand()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1184) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1183);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1185);if ((m_beepAfterMove) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1187) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1186);Toolkit.getDefaultToolkit().beep();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1188);GoColor toMove = getToMove();
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1189);String response = m_gtp.getResponse();
            checkLostOnTime(toMove);
            boolean gameTreeChanged = false;
            String name = getProgramName();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1190);if ((response.equalsIgnoreCase("resign")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1192) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1191);String result =
                    toMove.otherColor().getUppercaseLetter() + "+Resign";
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1193);if ((! m_auto) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1195) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1194);String mainMessage = format(i18n("MSG_RESIGN"), name);
                    String optionalMessage =
                        format(i18n("MSG_RESIGN_2"), result);
                    showInfo(mainMessage, optionalMessage, false);
                }
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1196);m_resigned = true;
                setResult(result);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1198);GoPoint point = GtpUtil.parsePoint(response, getBoardSize());
                ConstBoard board = getBoard();
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1199);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1201) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1200);if ((board.getColor(point) != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1203) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1202);String mainMessage =
                            format(i18n("MSG_NONEMPTY"), name);
                        String optionalMessage =
                            format(i18n("MSG_NONEMPTY_2"), name);
                        showWarning(mainMessage, optionalMessage, true);
                        m_computerBlack = false;
                        m_computerWhite = false;
                    }
                    else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1215);if ((board.isKo(point)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1217) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1216);String mainMessage =
                            format(i18n("MSG_VIOLATE_KO"), name);
                        showWarning(mainMessage, i18n("MSG_VIOLATE_KO_2"),
                                    true);
                        m_computerBlack = false;
                        m_computerWhite = false;
                    }}
                }
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1204);Move move = Move.get(toMove, point);
                m_game.play(move);
                m_gtp.updateAfterGenmove(getBoard());
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1205);if ((point == null && ! isComputerBoth()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1207) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1206);String disableKey =
                        "net.sf.gogui.gogui.GoGui.computer-passed";
                    String mainMessage =
                        format(i18n("MSG_PROGRAM_PASS"), name);
                    String optionalMessage =
                        format(i18n("MSG_PROGRAM_PASS_2"), name);
                    m_messageDialogs.showInfo(disableKey, this, mainMessage,
                                              optionalMessage, false);
                }
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1208);m_resigned = false;
                gameTreeChanged = true;
                ConstNode currentNode = getCurrentNode();
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1209);if ((currentNode.getFatherConst().getNumberChildren() == 1) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1211) && false))
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1210);if ((m_gameTreeViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1213) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1212);m_gameTreeViewer.addNewSingleChild(currentNode);}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1214);gameTreeChanged = false;
                }
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1197);boolean doCheckComputerMove
                = (! m_isSingleMove
                   && ! (isComputerBoth() && m_interruptComputerBoth));
            boardChangedBegin(doCheckComputerMove, gameTreeChanged);
        }
        catch (GtpResponseFormatError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1218);showError(e);
            clearStatus();
        }
    }

    private boolean computerToMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1219);if ((getToMove() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1221) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1220);return m_computerBlack;}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1222);return m_computerWhite;}
    }

    private void createAnalyzeDialog()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1223);m_analyzeDialog = new AnalyzeDialog(this, this, m_analyzeCommands,
                                            m_gtp, m_messageDialogs);
        m_analyzeDialog.setReuseTextWindow(
                        m_prefs.getBoolean("analyze-reuse-text-window", false));
        GuiAction.registerAll(m_analyzeDialog.getLayeredPane());
        m_analyzeDialog.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1224);actionDisposeAnalyzeDialog();
                }
            });
        m_analyzeDialog.setBoardSize(getBoardSize());
        m_analyzeDialog.setSelectedColor(getToMove());
        restoreSize(m_analyzeDialog, "analyze");
        m_analyzeDialog.setVisible(true);
    }

    private ContextMenu createContextMenu(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1225);boolean noProgram = (m_gtp == null);
        return new ContextMenu(point, m_guiBoard.getMark(point),
                               m_guiBoard.getMarkCircle(point),
                               m_guiBoard.getMarkSquare(point),
                               m_guiBoard.getMarkTriangle(point),
                               this);
    }

    private void createTree()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1226);m_gameTreeViewer = new GameTreeViewer(this, this, m_messageDialogs);
        m_gameTreeViewer.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1227);actionDisposeTree();
                }
            });
        GuiAction.registerAll(m_gameTreeViewer.getLayeredPane());
        m_gameTreeViewer.setLabelMode(m_treeLabels);
        m_gameTreeViewer.setSizeMode(m_treeSize);
        m_gameTreeViewer.setShowSubtreeSizes(m_showSubtreeSizes);
        restoreSize(m_gameTreeViewer, "tree");
        m_gameTreeViewer.update(getTree(), getCurrentNode());
        m_gameTreeViewer.setVisible(true);
    }

    private void createThumbnail(File file)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1228);if ((! ThumbnailPlatform.checkThumbnailSupport()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1230) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1229);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1231);String path = file.getAbsolutePath();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1232);if ((! path.startsWith("/tmp") && ! path.startsWith("/var/tmp")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1234) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1233);try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1235);m_thumbnailCreator.create(file);
            }
            catch (ErrorMessage e)
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1236);
            }
        }
    }

    private void currentNodeChanged()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1237);updateFromGoBoard();
    }

    private void detachProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1238);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1240) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1239);showStatusImmediately(i18n("STAT_DETACHING"));}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1241);if ((isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1243) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1242);m_gtp.destroyGtp();
            m_gtp.close();
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1253);if ((m_gtp != null && ! m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1255) && false))
            {
                // Some programs do not handle closing the GTP stream
                // correctly, so we send a quit before
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1254);try
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1256);if ((m_gtp.isSupported("quit")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1258) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1257);m_gtp.send("quit");}
                }
                catch (GtpError e)
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1260);
                }
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1259);m_gtp.close();
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1244);m_gtp = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1245);if ((m_analyzeCommand != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1247) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1246);clearAnalyzeCommand();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1248);m_version = null;
        m_shell.dispose();
        m_shell = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1249);if ((m_analyzeDialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1251) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1250);m_analyzeDialog.saveRecent();
            m_analyzeDialog.dispose();
            m_analyzeDialog = null;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1252);resetBoard();
        clearStatus();
        setTitle();
    }

    private boolean endLengthyCommand()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1261);return endLengthyCommand(true, true);
    }

    private boolean endLengthyCommand(boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1262);return endLengthyCommand(isCritical, true);
    }

    private boolean endLengthyCommand(boolean isCritical,
                                      boolean showError)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1263);restoreBoardCursor();
        clearStatus();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1264);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1266) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1265);m_shell.setCommandInProgess(false);}
        // Program could have been killed in actionDetachProgram()
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1267);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1269) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1268);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1270);GtpError error = m_gtp.getException();
        updateViews(false);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1271);if ((error != null && showError) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1273) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1272);showError(error, isCritical);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1274);return true;
    }

    private String formatCommand(String command)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1275);if ((command.length() < 20) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1277) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1276);return command;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1278);GtpCommand cmd = new GtpCommand(command);
        return cmd.getCommand() + " [...]";
    }

    private void generateMove(boolean isSingleMove)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1279);if ((! synchronizeProgram()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1281) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1280);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1282);GoColor toMove = getToMove();
        ConstNode node = getCurrentNode();
        ConstNode father = node.getFatherConst();
        ConstGameInfo info = getGameInfo();
        String playerToMove = info.get(StringInfoColor.NAME, toMove);
        String playerOther =
            info.get(StringInfoColor.NAME, toMove.otherColor());
        String name = getProgramLabel();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1283);if ((! isSingleMove && m_gameFile == null && playerToMove == null
            && (father == null
                || (! father.hasFather()
                    && (playerOther == null || playerOther.equals(name))))) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1285) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1284);m_game.setPlayer(toMove, name);
            updateViews(false);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1286);String command;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1287);if ((NodeUtil.isInCleanup(getCurrentNode())
            && m_gtp.isSupported("kgs-genmove_cleanup")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1289) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1288);command = "kgs-genmove_cleanup";
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1290);if ((toMove == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1292) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1291);command += " b";}
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1299);if ((toMove == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1301) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1300);command += " w";}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1302);assert false;}}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1303);command = m_gtp.getCommandGenmove(toMove);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1293);m_isSingleMove = isSingleMove;
        m_interruptComputerBoth = false;
        Runnable callback = new Runnable()
            {
                public void run()
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1294);computerMoved();
                }
            };
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1295);if ((getClock().isInitialized()
            && NodeUtil.isTimeLeftKnown(getCurrentNode(), toMove)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1297) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1296);GtpUtil.sendTimeLeft(m_gtp, getClock(), toMove);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1298);m_game.startClock();
        runLengthyCommand(command, callback);
    }

    private ConstBoard getBoard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1304);return m_game.getBoard();
    }

    private int getBoardSize()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1305);return m_game.getSize();
    }

    private ConstClock getClock()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1306);return m_game.getClock();
    }

    private ConstNode getCurrentNode()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1307);return m_game.getCurrentNode();
    }

    private ConstGameInfo getGameInfo()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1308);return m_game.getGameInfo(getCurrentNode());
    }

    private Komi getPrefsKomi()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1309);String s = m_prefs.get("komi", "6.5");
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1310);return Komi.parseKomi(s);
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1311);return null;
        }
    }

    private GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1312);return m_game.getToMove();
    }

    private ConstGameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1313);return m_game.getTree();
    }

    /** Change current node.
        Automatically restores the clock, or halts it, if no time settings
        are known. */
    private void gotoNode(ConstNode node)
    {
        // GameTreeViewer is not disabled in score mode
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1314);if ((m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1316) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1315);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1317);m_game.gotoNode(node);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1318);if ((getClock().isInitialized()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1320) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1319);m_game.restoreClock();}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1322);m_game.haltClock();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1321);currentNodeChanged();
    }

    private void hideShell()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1323);if ((m_shell == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1325) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1324);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1326);saveSession();
        m_shell.setVisible(false);
    }

    private void humanMoved(Move move)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1327);GoPoint p = move.getPoint();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1328);if ((p != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1330) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1329);paintImmediately(p, move.getColor(), true);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1331);if ((m_gtp != null && ! isComputerNone() && ! isOutOfSync()
            && ! m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1333) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1332);synchronizeProgram();
            try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1334);m_gtp.updateHumanMove(getBoard(), move);
            }
            catch (GtpError e)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1348);showError(e);
                boardChangedBegin(false, false);
                return;
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1335);boolean newNodeCreated = false;
        ConstNode node = NodeUtil.getChildWithMove(getCurrentNode(), move);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1336);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1338) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1337);newNodeCreated = true;
            m_game.play(move);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1347);m_game.haltClock();
            m_game.gotoNode(node);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1339);checkLostOnTime(move.getColor());
        m_resigned = false;
        boolean gameTreeChanged = newNodeCreated;
        ConstNode currentNode = getCurrentNode();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1340);if ((newNodeCreated
            && currentNode.getFatherConst().getNumberChildren() == 1) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1342) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1341);if ((m_gameTreeViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1344) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1343);m_gameTreeViewer.addNewSingleChild(currentNode);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1345);gameTreeChanged = false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1346);boardChangedBegin(true, gameTreeChanged);
    }

    private void importTextPosition(Reader reader)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1349);TextParser parser = new TextParser();
            parser.parse(reader);
            GameTree tree =
                NodeUtil.makeTreeFromPosition(null, parser.getBoard());
            m_game.init(tree);
        }
        catch (ParseError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1351);showError(i18n("MSG_IMPORT_FAILED"), e);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1350);m_guiBoard.initSize(getBoard().getSize());
        initGtp();
        m_computerBlack = false;
        m_computerWhite = false;
        boardChangedBegin(false, true);
    }

    private void initGame(int size)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1352);int oldSize = getBoardSize();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1353);if ((size != oldSize) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1355) && false))
        {
            // Clear analyze command when board size changes, because eplist
            // could contain points out of board)
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1354);clearAnalyzeCommand();
            saveSession();
            m_guiBoard.initSize(size);
            restoreMainWindow(size);
            JLayeredPane layeredPane = getLayeredPane();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1356);if ((layeredPane.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1358) && false))
            {
                // Loading a file with program attached can take long
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1357);GuiUtil.paintImmediately(layeredPane);
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1359);Komi komi = (((m_handicap == 0) ? ($qualityscroll_cover_jacov_probe_d567d57f2efb689b(1360) || true) : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1361) && false)) ? getPrefsKomi() : new Komi(0));
        ConstPointList handicap = Board.getHandicapStones(size, m_handicap);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1362);if ((handicap == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1364) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1363);showWarning(i18n("MSG_HANDICAP_UNDEFINED"),
                        format(i18n("MSG_HANDICAP_UNDEFINED_2"), m_handicap,
                               size), false);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1365);m_game.init(size, komi, handicap, m_prefs.get("rules", ""),
                    m_timeSettings);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1366);if ((size != oldSize) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1368) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1367);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1370) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1369);restoreSize(m_shell, "shell");}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1371);if ((m_analyzeDialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1373) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1372);restoreSize(m_analyzeDialog, "analyze");
                m_analyzeDialog.setBoardSize(size);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1374);if ((m_gameTreeViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1376) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1375);restoreSize(m_gameTreeViewer, "tree");}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1377);updateFromGoBoard();
        resetBoard();
        m_game.resetClock();
        m_lostOnTimeShown = false;
        m_resigned = false;
        m_pattern = null;
    }

    private boolean initGtp()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1378);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1380) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1379);try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1381);ConstGameInfo info = getGameInfo();
                m_gtp.initSynchronize(getBoard(), info.getKomi(),
                                      info.getTimeSettings());
            }
            catch (GtpError error)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1383);showError(error);
                return false;
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1382);currentNodeChanged();
        return ! isOutOfSync();
    }

    private void initialize()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1384);m_guiBoard.setListener(this);
        m_guiBoard.addMouseWheelListener(new MouseWheelListener() {
                public void mouseWheelMoved(MouseWheelEvent e) {
                    // Silently ignore mouse wheel events if command in
                    // progress because it is easy to generate multiple events
                    // while using the wheel and if an analyze command is
                    // enabled to automatically run after each board change,
                    // actionForward() and actionBackward() would pop up an
                    // error dialog if the analyze command is still in progress
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1385);if ((isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1387) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1386);return;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1388);int n = e.getWheelRotation();
                    int mod = e.getModifiers();
                    int scale = (((mod == ActionEvent.SHIFT_MASK) ? ($qualityscroll_cover_jacov_probe_d567d57f2efb689b(1389) || true) : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1390) && false)) ? 10 : 1);
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1391);if ((n > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1393) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1392);actionForward(scale * n);}
                    else
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1394);actionBackward(-scale * n);}
                }
            });

        GuiUtil.removeKeyBinding(m_splitPane, "F8");
        GuiAction.registerAll(getLayeredPane());

        m_bookmarks = Bookmark.load();
        m_menuBar.setBookmarks(m_bookmarks);
        m_programs = Program.load();
        m_menuBar.setPrograms(m_programs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1395);if ((m_programCommand == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1397) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1396);int index = m_prefs.getInt("program", -1);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1398);if ((index >= 0 && index < m_programs.size()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1400) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1399);m_program = m_programs.get(index);
                m_programCommand = m_program.m_command;
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1401);if ((m_initialFile == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1403) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1402);newGame(getBoardSize());}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1428);newGameFile(getBoardSize(), m_move);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1404);if ((! m_prefs.getBoolean("show-info-panel", true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1406) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1405);showInfoPanel(false);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1407);if ((m_prefs.getBoolean("show-toolbar", true)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1409) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1408);showToolbar(true);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1410);restoreMainWindow(getBoardSize());
        // Attaching a program can take some time, so we want to make
        // the window visible, but not draw the window content yet
        getLayeredPane().setVisible(false);
        setVisible(true);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1411);if ((m_programCommand != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1413) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1412);attachProgram(m_programCommand, m_program, m_register);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1414);if ((m_gtp == null || m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1416) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1415);m_prefs.putInt("program", -1);}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1417);setTitle();
        registerSpecialMacHandler();
        // Children dialogs should be set visible after main window, otherwise
        // they get minimize window buttons and a taskbar entry (KDE 3.4)
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1418);if ((m_shell != null && m_session.isVisible("shell")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1420) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1419);m_shell.setVisible(true);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1421);if ((m_session.isVisible("tree")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1423) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1422);createTree();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1424);if ((m_gtp != null && m_session.isVisible("analyze")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1426) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1425);createAnalyzeDialog();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1427);setTitleFromProgram();
        updateViews(true);
        getLayeredPane().setVisible(true);
        unprotectGui();
        toFrontLater();
        checkComputerMove();
    }

    private void initScore(ConstPointList deadStones)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1429);resetBoard();
        GuiBoardUtil.scoreBegin(m_guiBoard, m_countScore, getBoard(),
                                deadStones);
        m_scoreMode = true;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1430);if ((m_scoreDialog == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1432) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1431);ScoringMethod scoringMethod = getGameInfo().parseRules();
            m_scoreDialog = new ScoreDialog(this, this, scoringMethod);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1433);restoreLocation(m_scoreDialog, "score");
        Komi komi = getGameInfo().getKomi();
        m_scoreDialog.showScore(m_countScore, komi);
        m_scoreDialog.setVisible(true);
        showStatus(i18n("STAT_SCORE"));
    }

    private boolean isComputerBoth()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1434);return (m_computerBlack && m_computerWhite);
    }

    private boolean isComputerNone()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1435);return ! (m_computerBlack || m_computerWhite);
    }

    private boolean isOutOfSync()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1436);return (m_gtp != null && m_gtp.isOutOfSync());
    }

    private boolean loadFile(File file, int move)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1437);LoadFileRunnable runnable = new LoadFileRunnable(file);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1438);if ((file.length() > 500000) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1440) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1439);newGame(getBoardSize()); // Frees space if already large tree
                GuiUtil.runProgress(this, i18n("LB_LOADING"), runnable);
            }
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1454);runnable.run(null);}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1441);GameTree tree = runnable.getTree();
            initGame(tree.getBoardSize());
            m_menuBar.addRecent(file);
            m_game.init(tree);
            initGtp();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1442);if ((move > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1444) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1443);ConstNode node =
                    NodeUtil.findByMoveNumber(getCurrentNode(), move);
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1445);if ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1447) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1446);m_game.gotoNode(node);}
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1448);setFile(runnable.getGameFile());
            FileDialogs.setLastFile(file);
            String warnings = runnable.getWarnings();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1449);if ((warnings != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1451) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1450);String optionalMessage =
                    i18n("MSG_FILE_FORMAT_WARNING_2")
                    + "\n(" +
                    warnings.replaceAll("\n\\z", "").replaceAll("\n", ")\n(")
                    + ")";
                showWarning(i18n("MSG_FILE_FORMAT_WARNING"), optionalMessage,
                            true);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1452);m_computerBlack = false;
            m_computerWhite = false;
            createThumbnail(file);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1455);showError(i18n("MSG_FILE_NOT_FOUND"), e);
            return false;
        }
        catch (SgfError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1456);showError(i18n("MSG_COULD_NOT_READ_FILE"), e);
            return false;
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1457);showError(i18n("MSG_COULD_NOT_READ_FILE"), e);
            return false;
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1458);t.printStackTrace();
            assert false;
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1453);return true;
    }

    private void newGame(int size)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1459);initGame(size);
        initGtp();
        updateFromGoBoard();
        setTitle();
        setTitleFromProgram();
        clearStatus();
    }

    private void newGameFile(int size, int move)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1460);initGame(size);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1461);if ((! loadFile(m_initialFile, move)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1463) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1462);m_gameFile = null;}
    }

    /** Paint point immediately to pretend better responsiveness.
        Necessary because waiting for a repaint of the Go board can be slow
        due to the updating game tree or response to GTP commands. */
    private void paintImmediately(GoPoint point, GoColor color, boolean isMove)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1464);m_guiBoard.setColor(point, color);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1465);if ((isMove && m_showLastMove) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1467) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1466);m_guiBoard.markLastMove(point);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1468);m_guiBoard.paintImmediately(point);
    }

    private void protectGui()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1469);getGlassPane().setVisible(true);
        setCursor(getGlassPane(), Cursor.WAIT_CURSOR);
    }

    private void registerSpecialMacHandler()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1470);if ((! Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1472) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1471);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1473);Platform.SpecialMacHandler handler = new Platform.SpecialMacHandler()
            {
                public boolean handleAbout()
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1474);assert SwingUtilities.isEventDispatchThread();
                    actionAbout();
                    return true;
                }

                public boolean handleOpenFile(String filename)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1475);assert SwingUtilities.isEventDispatchThread();
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1476);if ((! checkSaveGame()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1478) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1477);return true;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1479);loadFile(new File(filename), -1);
                    boardChangedBegin(false, true);
                    return true;
                }

                public boolean handleQuit()
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1480);assert SwingUtilities.isEventDispatchThread();
                    close();
                    // close() calls System.exit() if not cancelled
                    return false;
                }
            };
        Platform.registerSpecialMacHandler(handler);
    }

    private void resetBoard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1481);clearStatus();
        m_guiBoard.clearAll();
        updateFromGoBoard();
        updateGuiBoard();
    }

    private void restoreBoardCursor()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1482);if ((m_analyzeCommand != null
            && (m_analyzeCommand.needsPointArg()
                || m_analyzeCommand.needsPointListArg())) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1484) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1483);setBoardCursor(Cursor.HAND_CURSOR);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1485);setBoardCursorDefault();}
    }

    private void restoreLocation(JDialog dialog, String name)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1486);m_session.restoreLocation(dialog, this, name + "-" + getBoardSize());
    }

    private void restoreMainWindow(int size)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1487);setState(Frame.NORMAL);
        m_session.restoreLocation(this, "main-" + size);
        String path = "windows/main/size-" + size + "/fieldsize";
        int fieldSize = m_prefs.getInt(path, -1);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1488);if ((fieldSize > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1490) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1489);m_guiBoard.setPreferredFieldSize(new Dimension(fieldSize,
                                                           fieldSize));}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1491);path = "windows/main/size-" + size + "/comment";
        int width = m_prefs.getInt(path + "/width", -1);
        int height = m_prefs.getInt(path + "/height", -1);
        Dimension preferredCommentSize = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1492);if ((width > 0 && height > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1494) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1493);preferredCommentSize = new Dimension(width, height);
            m_comment.setPreferredSize(preferredCommentSize);
        }
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1499);m_comment.setPreferredSize();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1495);m_splitPane.resetToPreferredSizes();
        pack();
        // To avoid smallish empty borders (less than one field size) on top
        // and bottom borders of the board we adjust the comment size slightly
        // if necessary
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1496);if ((m_infoPanel.getHeight() - m_guiBoard.getHeight() < 2 * fieldSize
            && preferredCommentSize != null && fieldSize > 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1498) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1497);preferredCommentSize.height -= 2 * fieldSize;
            m_comment.setPreferredSize(preferredCommentSize);
            m_splitPane.resetToPreferredSizes();
            pack();
        }
    }

    private void restoreSize(JDialog dialog, String name)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1500);m_session.restoreSize(dialog, this, name + "-" + getBoardSize());
    }

    private void runLengthyCommand(String cmd, Runnable callback)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1501);assert m_gtp != null;
        m_gtp.send(cmd, callback);
        beginLengthyCommand();
    }

    /** Save game to file.
        @return true If successfully saved. */
    private boolean save(GameFile gameFile)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1502);new GameWriter(gameFile, getTree(), i18n("LB_GOGUI"),
                           Version.get());
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1504);showError(i18n("MSG_SAVING_FAILED"), e);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1503);m_menuBar.addRecent(gameFile.m_file);
        createThumbnail(gameFile.m_file);
        setFile(gameFile);
        m_game.clearModified();
        updateViews(false);
        return true;
    }

    private boolean saveDialog()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1505);File file = FileDialogs.showSaveSgf(this, m_messageDialogs);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1506);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1508) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1507);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1509);GameFile gameFile = new GameFile();
        gameFile.m_file = file;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1510);if ((FileUtil.hasExtension(file, "xml")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1512) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1511);gameFile.m_format = GameFile.Format.XML;}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1514);gameFile.m_format = GameFile.Format.SGF;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1513);return save(gameFile);
    }

    private boolean saveParameters(File file)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1515);GtpClientUtil.saveParameters(m_gtp, m_analyzeCommands, file);
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1517);showError(i18n("MSG_COULD_NOT_SAVE_PARAMETERS"), e);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1516);return true;
    }

    private void savePosition(File file) throws FileNotFoundException
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1518);OutputStream out = new FileOutputStream(file);
        new SgfWriter(out, getBoard(), i18n("LB_GOGUI"), Version.get());
        m_menuBar.addRecent(file);
        updateViews(false);
    }

    private void saveSession()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1519);if ((m_shell != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1521) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1520);m_shell.saveHistory();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1522);if ((m_analyzeDialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1524) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1523);m_analyzeDialog.saveRecent();
            m_prefs.putBoolean("analyze-reuse-text-window",
                               m_analyzeDialog.getReuseTextWindow());
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1525);if ((! isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1527) && false)) // can that happen?
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1526);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1528);if ((m_help != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1530) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1529);m_session.saveSize(m_help.getWindow(), "help");}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1531);saveSizeAndVisible(m_gameTreeViewer, "tree");
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1532);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1534) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1533);saveSizeAndVisible(m_shell, "shell");
            saveSizeAndVisible(m_analyzeDialog, "analyze");
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1535);m_session.saveLocation(this, "main-" + getBoardSize());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1536);if ((GuiUtil.isNormalSizeMode(this)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1538) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1537);String name = "windows/main/size-" + getBoardSize() + "/fieldsize";
            int fieldSize = m_guiBoard.getFieldSize().width;
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1539);if ((fieldSize == 0) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1541) && false)) // BoardPainter was never invoked
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1540);return;}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1542);m_prefs.putInt(name, fieldSize);
            name = "windows/main/size-" + getBoardSize() + "/comment/width";
            m_prefs.putInt(name, m_comment.getWidth());
            name = "windows/main/size-" + getBoardSize() + "/comment/height";
            m_prefs.putInt(name, m_comment.getHeight());
        }
        // GoGui's program logic does currently not depend on syncing the
        // preferences to disk immediately, but we do it anyway to work around
        // a bug in OpenJDK 1.6.0_20 on Linux (Ubuntu 10.10), which fails to
        // perform the automatic syncing of class Preferences on shutdown of
        // the VM (probably because of a BadWindow X Error on window closing)
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1543);m_prefs.sync();
        }
        catch (BackingStoreException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1544);System.err.println(e.getMessage());
        }
    }

    private void saveLocation(JDialog dialog, String name)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1545);m_session.saveLocation(dialog, this, name + "-" + getBoardSize());
    }

    private void saveSizeAndVisible(JDialog dialog, String name)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1546);int size = getBoardSize();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1547);if ((dialog != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1549) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1548);m_session.saveSize(dialog, this, name + "-" + size);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1550);m_session.saveVisible(dialog, name);
    }

    private void scoreContinue()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1551);boolean success = endLengthyCommand();
        clearStatus();
        PointList isDeadStone = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1552);if ((success) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1554) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1553);String response = m_gtp.getResponse();
            try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1555);isDeadStone
                    = GtpUtil.parsePointList(response, getBoardSize());
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1557);showError(e);
            }
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1556);updateViews(false);
        initScore(isDeadStone);
    }

    private void scoreDone(Score score)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1558);if ((! m_scoreMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1560) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1559);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1561);m_scoreMode = false;
        saveLocation(m_scoreDialog, "score");
        m_scoreDialog.setVisible(false);
        clearStatus();
        m_guiBoard.clearAll();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1562);if ((score != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1564) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1563);setResult(score.formatResult());}
    }

    private void sendGtp(Reader reader)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1565);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1567) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1566);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1568);java.io.BufferedReader in;
        in = new BufferedReader(reader);
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1569);while (true)
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1570);try
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1574);String line = in.readLine();
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1575);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1577) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1576);break;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1578);if ((! GtpUtil.isCommand(line)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1580) && false))
                        {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1579);continue;}
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1581);if ((GtpUtil.isStateChangingCommand(line)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1583) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1582);showError(i18n("MSG_BOARD_CHANGING_COMMAND"), "");
                        break;
                    }
                    try
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1584);m_gtp.send(line);
                    }
                    catch (GtpError e)
                    {
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1585);showError(e);
                        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1586);if ((m_gtp.isProgramDead()
                            || ! showQuestion(i18n("MSG_CONTINUE_SEND"), "",
                                              i18n("LB_CONTINUE_SEND"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1588) && false))
                            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1587);break;}
                    }
                }
                catch (IOException e)
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1589);showError(i18n("MSG_COULD_NOT_READ_FILE"), e);
                    break;
                }
            }
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1572);in.close();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1573);
            }
        }
    }

    private void sendGtpFile(File file)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1590);sendGtp(new FileReader(file));
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1591);showError(i18n("MSG_FILE_NOT_FOUND"), e);
        }
    }

    private void sendGtpString(String commands)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1592);commands = commands.replaceAll("\\\\n", "\n");
        sendGtp(new StringReader(commands));
    }

    private void setBoardCursor(int type)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1593);setCursor(m_guiBoard, type);
    }

    private void setBoardCursorDefault()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1594);setCursorDefault(m_guiBoard);
    }

    private void setCursor(Component component, int type)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1595);Cursor cursor = Cursor.getPredefinedCursor(type);
        component.setCursor(cursor);
    }

    private void setCursorDefault(Component component)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1596);component.setCursor(Cursor.getDefaultCursor());
    }

    private void setFile(GameFile gameFile)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1597);m_gameFile = gameFile;
        setTitle();
    }

    private void setMinimumSize()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1598);int width = 128;
        int height = 32;
        Insets rootInsets = getRootPane().getInsets();
        int rootInsetsWidth = rootInsets.left + rootInsets.right;
        Dimension menuBarSize = getJMenuBar().getPreferredSize();
        width = Math.max(width, (int)menuBarSize.getWidth() + rootInsetsWidth);
        height = Math.max(height, (int)menuBarSize.getHeight());
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1599);if ((m_showToolbar) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1601) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1600);Insets contentInsets = getContentPane().getInsets();
            int contentInsetsWidth = contentInsets.left + contentInsets.right;
            Dimension toolBarSize = m_toolBar.getPreferredSize();
            width = Math.max(width,
                             (int)toolBarSize.getWidth() + rootInsetsWidth
                             + contentInsetsWidth + GuiUtil.PAD);
            height += (int)toolBarSize.getHeight();
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1602);height += 224;
        setMinimumSize(new Dimension(width, height));
    }

    private void setResult(String result)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1603);String oldResult = getGameInfo().get(StringInfo.RESULT);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1604);if ((! (oldResult == null || oldResult.equals("")
               || oldResult.equals(result))
            && ! showQuestion(format(i18n("MSG_REPLACE_RESULT"), oldResult,
                                     result),
                              i18n("MSG_REPLACE_RESULT_2"),
                              i18n("LB_REPLACE_RESULT"), false)) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1606) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1605);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1607);m_game.setResult(result);
    }

    private void setTitle()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1608);if ((m_titleFromProgram != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1610) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1609);setTitle(m_titleFromProgram);
            return;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1611);String appName = i18n("LB_GOGUI");
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1612);if ((m_gtp != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1614) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1613);appName = getProgramLabel();}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1615);String filename = null;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1616);if ((m_gameFile != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1618) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1617);filename = m_gameFile.m_file.getName();
            // On the Mac, a modified document is indicated by setting the
            // windowModified property in updateViews()
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1619);if ((isModified() && ! Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1621) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1620);filename = filename + "*";}
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1622);ConstGameInfo info = getGameInfo();
        String gameName = info.suggestGameName();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1623);if ((gameName != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1625) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1624);if ((filename != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1627) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1626);gameName = filename + "  " + gameName;}
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1636);if ((filename != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1638) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1637);gameName = filename;}}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1628);if ((gameName == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1630) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1629);setTitle(appName);}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1631);String name = getProgramLabel();
            String nameBlack = info.get(StringInfoColor.NAME, BLACK);
            String nameWhite = info.get(StringInfoColor.NAME, WHITE);
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1632);if ((! appName.equals(i18n("LB_GOGUI"))
                && (ObjectUtil.equals(nameBlack, name)
                    || ObjectUtil.equals(nameWhite, name))) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1634) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1633);setTitle(gameName);}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1635);setTitle(gameName + " - " + appName);}
        }
    }

    private void setTitleFromProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1639);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1641) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1640);m_titleFromProgram = null;}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1645);m_titleFromProgram = GtpClientUtil.getTitle(m_gtp);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1642);if ((m_titleFromProgram != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1644) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1643);setTitle(m_titleFromProgram);}
    }

    private void setup(GoPoint point, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1646);assert point != null;
        m_game.setup(point, color);
    }

    private void setupDone()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1647);if ((! m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1649) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1648);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1650);m_setupMode = false;
        ConstNode currentNode = getCurrentNode();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1651);if ((currentNode.hasSetup() || m_setupColor != getToMove()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1653) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1652);m_game.setToMove(m_setupColor);}
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1655);if ((m_setupNodeCreated && currentNode.isEmpty()
                 && currentNode.hasFather()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1657) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1656);m_game.truncate();}}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1654);currentNodeChanged();
    }

    private void showError(String message, Exception e)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1658);showError(message, e, true);
    }

    private void showError(String message, Exception e, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1659);m_messageDialogs.showError(this, message, e, isCritical);
    }

    private void showError(GtpError error)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1660);showError(error, true);
    }

    private void showError(GtpResponseFormatError e)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1661);String name = getProgramName();
        String mainMessage = format(i18n("MSG_INVALID_RESPONSE"), name);
        String optionalMessage =
            format(i18n("MSG_INVALID_RESPONSE_2"), name, e.getMessage());
        showError(mainMessage, optionalMessage, true);
    }

    private void showError(GtpError e, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1662);String name = getProgramName();
        String mainMessage;
        String optionalMessage;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1663);if ((m_gtp != null && m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1665) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1664);if ((m_gtp.wasKilled()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1667) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1666);mainMessage = format(i18n("MSG_PROGRAM_TERMINATED"), name);}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1677);mainMessage = i18n("MSG_PROGRAM_TERMINATED_UNEXPECTEDLY");}
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1668);boolean hasErrorOutput = m_shell.isLastTextNonGTP();
            boolean anyResponses = m_gtp.getAnyCommandsResponded();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1669);if ((hasErrorOutput && ! anyResponses) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1671) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1670);optionalMessage =
                    format(i18n("MSG_PROGRAM_TERMINATED_2"), name);}
            else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1673);if ((hasErrorOutput && anyResponses) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1675) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1674);optionalMessage =
                    format(i18n("MSG_PROGRAM_TERMINATED_3"), name);}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1676);optionalMessage = i18n("MSG_PROGRAM_TERMINATED_4");}}
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1678);if ((e instanceof GtpClient.ExecFailed) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1680) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1679);mainMessage = i18n("MSG_COULD_NOT_EXECUTE");
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1681);if ((StringUtil.isEmpty(e.getMessage())) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1683) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1682);optionalMessage = i18n("MSG_COULD_NOT_EXECUTE_2");}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1684);optionalMessage =
                    format(i18n("MSG_COULD_NOT_EXECUTE_3"), e.getMessage());}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1685);mainMessage = i18n("MSG_COMMAND_FAILED");
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1686);if ((e.getMessage().trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1688) && false))
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1687);optionalMessage =
                    format(i18n("MSG_COMMAND_FAILED_2"), e.getCommand());}
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1689);optionalMessage =
                    format(i18n("MSG_COMMAND_FAILED_3"), e.getCommand(),
                           e.getMessage());}
        }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1672);showError(mainMessage, optionalMessage, isCritical);
        updateViews(false); // If program died, menu items need to be updated
    }

    private void showError(String mainMessage, String optionalMessage)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1690);showError(mainMessage, optionalMessage, true);
    }

    private void showError(String mainMessage, String optionalMessage,
                           boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1691);m_messageDialogs.showError(this, mainMessage, optionalMessage,
                                   isCritical);
    }

    private void showGameFinished()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1692);if ((m_resigned) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1694) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1693);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1695);String disableKey = "net.sf.gogui.gogui.GoGui.game-finished";
        m_messageDialogs.showInfo(disableKey, this,
                                  i18n("MSG_GAME_FINISHED"),
                                  i18n("MSG_GAME_FINISHED_2"), false);
    }

    private void showInfo(String mainMessage, String optionalMessage,
                          boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1696);m_messageDialogs.showInfo(this, mainMessage, optionalMessage,
                                  isCritical);
    }

    private void showInfoPanel(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1697);if ((enable == m_showInfoPanel) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1699) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1698);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1700);m_prefs.putBoolean("show-info-panel", enable);
        m_showInfoPanel = enable;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1701);if ((enable) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1703) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1702);m_innerPanel.remove(m_guiBoard);
            m_splitPane.add(m_guiBoard);
            m_innerPanel.add(m_splitPane);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1705);m_splitPane.remove(m_guiBoard);
            m_innerPanel.remove(m_splitPane);
            m_innerPanel.add(m_guiBoard);
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1704);m_splitPane.resetToPreferredSizes();
        pack();
    }

    private boolean showOptionalQuestion(String id, String mainMessage,
                                         String optionalMessage,
                                         String destructiveOption,
                                         boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1706);String disableKey = "net.sf.gogui.gogui.GoGui" + id;
        return m_messageDialogs.showQuestion(disableKey, this, mainMessage,
                                             optionalMessage,
                                             destructiveOption, isCritical);
    }

    private boolean showQuestion(String mainMessage, String optionalMessage,
                                 String destructiveOption, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1707);return m_messageDialogs.showQuestion(this, mainMessage,
                                             optionalMessage,
                                             destructiveOption, isCritical);
    }

    private File showSave(String title)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1708);return FileDialogs.showSave(this, title, m_messageDialogs);
    }

    private void showShell()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1709);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1711) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1710);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1712);if ((m_shell.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1714) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1713);m_shell.toFront();}
        else
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1715);restoreSize(m_shell, "shell");
            m_shell.setVisible(true);
        }
    }

    private void showStatus(String text)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1716);m_statusBar.setText(text);
    }

    private void showStatusImmediately(String text)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1717);m_statusBar.immediatelyPaintText(text);
    }

    private void showStatusSelectPointList()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1718);showStatus(format(i18n("STAT_SELECT_POINTLIST"),
                          m_analyzeCommand.getLabel()));
    }

    private void showStatusSelectTarget()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1719);showStatus(format(i18n("STAT_SELECT_TARGET"),
                          m_analyzeCommand.getResultTitle()));
    }

    private void showToolbar(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1720);if ((enable == m_showToolbar) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1722) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1721);return;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1723);m_prefs.putBoolean("show-toolbar", enable);
        m_showToolbar = enable;
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1724);if ((enable) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1726) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1725);getContentPane().add(m_toolBar, BorderLayout.NORTH);}
        else
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1728);getContentPane().remove(m_toolBar);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1727);m_splitPane.resetToPreferredSizes();
        setMinimumSize();
        pack();
    }

    private void showWarning(String mainMessage, String optionalMessage,
                             boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1729);m_messageDialogs.showWarning(this, mainMessage, optionalMessage,
                                     isCritical);
    }

    private boolean synchronizeProgram()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1730);if ((m_gtp == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1732) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1731);showError(i18n("MSG_NO_PROGRAM_ATTACHED"), "", false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1733);if ((! checkCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1735) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1734);return false;}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1736);String name = getProgramName();
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1737);if ((m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1739) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1738);String mainMessage = format(i18n("MSG_PROGRAM_TERMINATED"), name);
            String optionalMessage = "";
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1740);if ((m_shell.isLastTextNonGTP()) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1742) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1741);showShell();
                optionalMessage =
                    format(i18n("MSG_PROGRAM_TERMINATED_CHECK_GTP"), name);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1744);showShell();
                optionalMessage =
                    format(i18n("MSG_PROGRAM_TERMINATED_REATTACH"), name);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1743);showError(mainMessage, optionalMessage, false);
            // If program died, menu items need to be updated
            updateViews(false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1745);boolean wasOutOfSync = isOutOfSync();
        try
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1746);ConstGameInfo info = getGameInfo();
            m_gtp.synchronize(getBoard(), info.getKomi(),
                              info.getTimeSettings());
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1748);if ((wasOutOfSync) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1750) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1749);String mainMessage = format(i18n("MSG_OUT_OF_SYNC"), name);
                String optionalMessage = format(i18n("MSG_OUT_OF_SYNC_2"),
                                                name);
                showError(mainMessage, optionalMessage, false);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1752);String mainMessage = format(i18n("MSG_NOSYNC"), name);
                String command = null;
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1753);if ((e.getCommand() != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1755) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1754);command = formatCommand(e.getCommand());}
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1756);String message = e.getMessage();
                String response = null;
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1757);if ((! message.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1759) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1758);response = message;}
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1760);String optionalMessage;
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1761);if ((command == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1763) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1762);optionalMessage =
                        format(i18n("MSG_NOSYNC_ERROR"), name, message);}
                else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1765);if ((response == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1767) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1766);optionalMessage =
                        format(i18n("MSG_NOSYNC_FAILURE"),
                               command, name);}
                else
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1768);optionalMessage =
                        format(i18n("MSG_NOSYNC_FAILURE_RESPONSE"),
                               command, name, response);}}
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1764);showWarning(mainMessage, optionalMessage, true);
                // If the program died, menu items need to be updated
                updateViews(false);
            }
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1751);return false;
        }
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1747);return true;
    }

    private void toFrontLater()
    {
        // Calling toFront() directly does not give the focus to this
        // frame, if dialogs are open
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1769);SwingUtilities.invokeLater(new Runnable() {
                public void run()
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1770);requestFocus();
                    toFront();
                }
            });
    }

    private void unprotectGui()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1771);getGlassPane().setVisible(false);
        setCursor(getGlassPane(), Cursor.DEFAULT_CURSOR);
    }

    private void updateViews(boolean gameTreeChanged)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1772);updateViews(gameTreeChanged, false);
    }

    /** Update all views.
        @param gameTreeChanged If nodes were added to or removed from the game
        tree, which will trigger a full and potentially slow game tree update
        @param sync Update game tree within the event handler if the gameTree
        has changed. */
    private void updateViews(boolean gameTreeChanged, boolean sync)
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1773);m_actions.update();
        m_menuBar.update(isProgramAttached(), isTreeShown(), isShellShown());
        m_gameInfoPanel.update();
        m_comment.setComment(getCurrentNode().getComment());
        updateFromGoBoard();
        updateGuiBoard();
        getRootPane().putClientProperty("windowModified",
                                        Boolean.valueOf(isModified()));
        setTitle();
        GoGuiUtil.updateMoveText(m_statusBar, getGame());
        m_statusBar.setSetupMode(m_setupMode);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1774);if ((m_setupMode) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1776) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1775);m_statusBar.setToPlay(m_setupColor);}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1777);if ((m_gameTreeViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1779) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1778);if ((gameTreeChanged) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1781) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1780);if ((sync) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1783) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1782);m_gameTreeViewer.update(getTree(), getCurrentNode());}
                else
                {
                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1784);protectGui();
                    showStatus(i18n("STAT_UPDATING_TREE"));
                    Runnable runnable = new Runnable() {
                            public void run() {
                                try
                                {
                                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1785);m_gameTreeViewer.update(getTree(),
                                                            getCurrentNode());
                                }
                                finally
                                {
                                    $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1786);unprotectGui();
                                    clearStatus();
                                }
                            }
                        };
                    SwingUtilities.invokeLater(runnable);
                }
            }
            else
                {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1787);m_gameTreeViewer.update(getCurrentNode());}
        }
    }

    private void updateFromGoBoard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1788);boolean showLastMove =
            (m_showLastMove
             && ! (m_showVariations == ShowVariations.SIBLINGS
                   && NodeUtil.hasSiblingMoves(getCurrentNode())));
        GuiBoardUtil.updateFromGoBoard(m_guiBoard, getBoard(), m_showLastMove,
                                       m_showMoveNumbers);
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1789);if ((! showLastMove || getCurrentNode().getMove() == null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1791) && false))
            {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1790);m_guiBoard.markLastMove(null);}
    }

    private void updateGuiBoard()
    {
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1792);if ((m_showVariations == ShowVariations.CHILDREN) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1794) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1793);ConstPointList moves = NodeUtil.getChildrenMoves(getCurrentNode());
            GuiBoardUtil.showMoves(m_guiBoard, moves);
        }
        else {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1796);if ((m_showVariations == ShowVariations.SIBLINGS
                 && NodeUtil.hasSiblingMoves(getCurrentNode())) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1798) && false))
        {
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1797);ConstNode father = getCurrentNode().getFatherConst();
            $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1799);if ((father != null) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1801) && false))
            {
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1800);ConstPointList moves = NodeUtil.getChildrenMoves(father);
                $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1802);if ((moves.size() > 1) ? true : (!$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1804) && false))
                    {$qualityscroll_cover_jacov_probe_d567d57f2efb689b(1803);GuiBoardUtil.showMoves(m_guiBoard, moves);}
            }
        }}
        $qualityscroll_cover_jacov_probe_d567d57f2efb689b(1795);GuiBoardUtil.showMarkup(m_guiBoard, getCurrentNode());
    }
}
