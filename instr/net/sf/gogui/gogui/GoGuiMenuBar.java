/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGuiMenuBar.java 

package net.sf.gogui.gogui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.GuiMenu;
import net.sf.gogui.gui.Bookmark;
import net.sf.gogui.gui.Program;
import net.sf.gogui.gui.RecentFileMenu;
import net.sf.gogui.util.Platform;

/** Menu bar for GoGui. */
public class GoGuiMenuBar
    extends JMenuBar
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiMenuBar.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6421410596417217753L,/* translation unit id   */ -6196570693021116900L,/* timestamp             */ 1709177900862L,/* source file name      */ "GoGuiMenuBar.java",/* probe size            */ 95);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_aa015bc918e1561c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Listener to events that are not handled by GoGuiActions. */
    public interface Listener
    {
        void actionGotoBookmark(int i);

        void actionAttachProgram(int i);
    }

    public GoGuiMenuBar(GoGuiActions actions,
                        RecentFileMenu.Listener recentListener,
                        RecentFileMenu.Listener recentGtpListener,
                        GoGuiMenuBar.Listener bookmarkListener)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(0);m_listener = bookmarkListener;
        add(createMenuFile(actions, recentListener));
        add(createMenuGame(actions));
        add(createMenuProgram(actions));
        add(createMenuGo(actions));
        add(createMenuEdit(actions));
        add(createMenuView(actions));
        m_menuBookmarks = createMenuBookmarks(actions);
        add(m_menuBookmarks);
        add(createMenuTools(actions, recentGtpListener));
        add(createMenuHelp(actions));
    }

    public void addRecent(File file)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(1);File canonicalFile = file.getCanonicalFile();
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(2);if ((canonicalFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(4) && false))
                {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(3);file = canonicalFile;}
        }
        catch (IOException e)
        {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(6);
        }
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(5);m_recent.add(file);
    }

    public void addRecentGtp(File file)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(7);File canonicalFile = file.getCanonicalFile();
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(8);if ((canonicalFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(10) && false))
                {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(9);file = canonicalFile;}
        }
        catch (IOException e)
        {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(12);
        }
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(11);m_recentGtp.add(file);
    }

    public void setBookmarks(ArrayList<Bookmark> bookmarks)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(13);for (int i = 0; (i < m_bookmarkItems.size()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(15) && false); ++i)
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(14);m_menuBookmarks.remove(m_bookmarkItems.get(i));}
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(16);if ((m_bookmarksSeparator != null) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(18) && false))
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(17);m_menuBookmarks.remove(m_bookmarksSeparator);
            m_bookmarksSeparator = null;
        }
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(19);if ((bookmarks.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(21) && false))
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(20);return;}
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(22);m_bookmarksSeparator = new JSeparator();
        m_menuBookmarks.add(m_bookmarksSeparator);
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(23);for (int i = 0; (i < bookmarks.size()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(25) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(24);Bookmark bookmark = bookmarks.get(i);
            JMenuItem item = new JMenuItem(bookmark.m_name);
            final int bookmarkIndex = i;
            item.addActionListener(new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent e) {
                        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(26);m_listener.actionGotoBookmark(bookmarkIndex);
                    }
                });
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(27);if ((bookmark.m_file != null) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(29) && false))
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(28);StringBuilder toolTip = new StringBuilder(256);
                toolTip.append(bookmark.m_file);
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(30);if ((bookmark.m_move > 0) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(32) && false))
                {
                    $qualityscroll_cover_jacov_probe_aa015bc918e1561c(31);toolTip.append(" (move ");
                    toolTip.append(bookmark.m_move);
                    toolTip.append(')');
                }
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(33);if ((! bookmark.m_variation.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(35) && false))
                {
                    $qualityscroll_cover_jacov_probe_aa015bc918e1561c(34);toolTip.append(" (variation ");
                    toolTip.append(bookmark.m_variation);
                    toolTip.append(')');
                }
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(36);item.setToolTipText(toolTip.toString());
            }
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(37);m_menuBookmarks.add(item);
            m_bookmarkItems.add(item);
        }
    }

    public void setPrograms(ArrayList<Program> programs)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(38);m_menuAttach.setEnabled(! programs.isEmpty());
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(39);for (int i = 0; (i < m_programItems.size()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(41) && false); ++i)
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(40);m_menuAttach.remove(m_programItems.get(i));}
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(42);if ((programs.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(44) && false))
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(43);return;}
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(45);for (int i = 0; (i < programs.size()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(47) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(46);Program program = programs.get(i);
            String[] mnemonicArray =
                { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C",
                  "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                  "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
            String text;
            String mnemonic;
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(48);if ((! Platform.isMac() && i < mnemonicArray.length) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(50) && false))
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(49);mnemonic = mnemonicArray[i];
                text = mnemonic + ": " + program.m_label;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(67);mnemonic = "";
                text = program.m_label;
            }
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(51);JMenuItem item = new JMenuItem(text);
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(52);if ((! mnemonic.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(54) && false))
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(53);KeyStroke keyStroke = KeyStroke.getKeyStroke(mnemonic);
                int code = keyStroke.getKeyCode();
                item.setMnemonic(code);
            }
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(55);final int index = i;
            item.addActionListener(new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent e) {
                        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(56);m_listener.actionAttachProgram(index);
                    }
                });
            StringBuilder toolTip = new StringBuilder(128);
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(57);if ((program.m_name != null) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(59) && false))
                {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(58);toolTip.append(program.m_name);}
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(60);if ((program.m_version != null && ! program.m_version.equals("")
                && program.m_version.length() < 40) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(62) && false))
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(61);toolTip.append(' ');
                toolTip.append(program.m_version);
            }
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(63);if ((program.m_command != null) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(65) && false))
            {
                $qualityscroll_cover_jacov_probe_aa015bc918e1561c(64);toolTip.append(" (");
                toolTip.append(program.m_command);
                toolTip.append(')');
            }
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(66);item.setToolTipText(toolTip.toString());
            m_menuAttach.add(item);
            m_programItems.add(item);
        }
    }

    public void update(boolean isProgramAttached, boolean isTreeShown,
                       boolean isShellShown)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(68);if ((isProgramAttached) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(70) && false))
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(69);m_recentGtp.updateEnabled();}
        else
            {$qualityscroll_cover_jacov_probe_aa015bc918e1561c(72);m_recentGtp.getMenu().setEnabled(false);}
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(71);m_recent.updateEnabled();
        m_computerColor.setEnabled(isProgramAttached);
        m_menuViewTree.setEnabled(isTreeShown);
        m_menuViewShell.setEnabled(isShellShown);
    }

    private final Listener m_listener;

    private final GuiMenu m_menuBookmarks;

    private GuiMenu m_menuAttach;

    private GuiMenu m_menuViewTree;

    private GuiMenu m_menuViewShell;

    private JSeparator m_bookmarksSeparator;

    private RecentFileMenu m_recent;

    private RecentFileMenu m_recentGtp;

    private final ArrayList<JMenuItem> m_bookmarkItems
        = new ArrayList<JMenuItem>();

    private final ArrayList<JMenuItem> m_programItems
        = new ArrayList<JMenuItem>();

    private GuiMenu m_computerColor;

    private GuiMenu createBoardSizeMenu(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(73);GuiMenu menu = new GuiMenu(i18n("MEN_BOARDSIZE"));
        ButtonGroup group = new ButtonGroup();
        menu.addRadioItem(group, actions.m_actionBoardSize9);
        menu.addRadioItem(group, actions.m_actionBoardSize11);
        menu.addRadioItem(group, actions.m_actionBoardSize13);
        menu.addRadioItem(group, actions.m_actionBoardSize15);
        menu.addRadioItem(group, actions.m_actionBoardSize17);
        menu.addRadioItem(group, actions.m_actionBoardSize19);
        menu.addRadioItem(group, actions.m_actionBoardSizeOther);
        return menu;
    }

    private GuiMenu createClockMenu(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(74);GuiMenu menu = new GuiMenu(i18n("MEN_CLOCK"));
        menu.add(actions.m_actionClockStart);
        menu.add(actions.m_actionClockHalt);
        menu.add(actions.m_actionClockResume);
        menu.add(actions.m_actionSetTimeLeft);
        return menu;
    }

    private GuiMenu createComputerColorMenu(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(75);ButtonGroup group = new ButtonGroup();
        GuiMenu menu = new GuiMenu(i18n("MEN_COMPUTER_COLOR"));
        menu.addRadioItem(group, actions.m_actionComputerBlack);
        menu.addRadioItem(group, actions.m_actionComputerWhite);
        menu.addRadioItem(group, actions.m_actionComputerBoth);
        menu.addRadioItem(group, actions.m_actionComputerNone);
        return menu;
    }

    private GuiMenu createHandicapMenu(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(76);GuiMenu menu = new GuiMenu(i18n("MEN_HANDICAP"));
        ButtonGroup group = new ButtonGroup();
        menu.addRadioItem(group, actions.m_actionHandicapNone);
        menu.addRadioItem(group, actions.m_actionHandicap2);
        menu.addRadioItem(group, actions.m_actionHandicap3);
        menu.addRadioItem(group, actions.m_actionHandicap4);
        menu.addRadioItem(group, actions.m_actionHandicap5);
        menu.addRadioItem(group, actions.m_actionHandicap6);
        menu.addRadioItem(group, actions.m_actionHandicap7);
        menu.addRadioItem(group, actions.m_actionHandicap8);
        menu.addRadioItem(group, actions.m_actionHandicap9);
        return menu;
    }

    private GuiMenu createMenuBookmarks(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(77);GuiMenu menu = new GuiMenu(i18n("MEN_BOOKMARKS"));
        menu.add(actions.m_actionAddBookmark);
        menu.add(actions.m_actionEditBookmarks);
        return menu;
    }

    private GuiMenu createMenuConfigureShell(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(78);m_menuViewShell = new GuiMenu(i18n("MEN_SHELL"));
        m_menuViewShell.addCheckBoxItem(actions.m_actionToggleCompletion);
        m_menuViewShell.addCheckBoxItem(actions.m_actionToggleAutoNumber);
        m_menuViewShell.addCheckBoxItem(actions.m_actionToggleTimeStamp);
        return m_menuViewShell;
    }

    private GuiMenu createMenuConfigureTree(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(79);m_menuViewTree = new GuiMenu(i18n("MEN_TREE"));
        GuiMenu menuLabel = new GuiMenu(i18n("MEN_TREE_LABELS"));
        ButtonGroup group = new ButtonGroup();
        menuLabel.addRadioItem(group, actions.m_actionTreeLabelsNumber);
        menuLabel.addRadioItem(group, actions.m_actionTreeLabelsMove);
        menuLabel.addRadioItem(group, actions.m_actionTreeLabelsNone);
        m_menuViewTree.add(menuLabel);
        GuiMenu menuSize = new GuiMenu(i18n("MEN_TREE_SIZE"));
        group = new ButtonGroup();
        menuSize.addRadioItem(group, actions.m_actionTreeSizeLarge);
        menuSize.addRadioItem(group, actions.m_actionTreeSizeNormal);
        menuSize.addRadioItem(group, actions.m_actionTreeSizeSmall);
        menuSize.addRadioItem(group, actions.m_actionTreeSizeTiny);
        m_menuViewTree.add(menuSize);
        m_menuViewTree.addCheckBoxItem(actions.m_actionToggleShowSubtreeSizes);
        return m_menuViewTree;
    }

    private GuiMenu createMenuEdit(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(80);GuiMenu menu = new GuiMenu(i18n("MEN_EDIT"));
        menu.add(actions.m_actionFind);
        menu.add(actions.m_actionFindNext);
        menu.add(actions.m_actionFindNextComment);
        menu.addSeparator();
        menu.add(actions.m_actionMakeMainVariation);
        menu.add(actions.m_actionDeleteSideVariations);
        menu.add(actions.m_actionKeepOnlyPosition);
        menu.add(actions.m_actionTruncate);
        menu.add(actions.m_actionTruncateChildren);
        menu.addSeparator();
        menu.addCheckBoxItem(actions.m_actionSetupBlack);
        menu.addCheckBoxItem(actions.m_actionSetupWhite);
        return menu;
    }

    private GuiMenu createMenuExport(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(81);GuiMenu menu = new GuiMenu(i18n("MEN_EXPORT"));
        menu.add(actions.m_actionExportSgfPosition);
        menu.add(actions.m_actionExportLatexMainVariation);
        menu.add(actions.m_actionExportLatexPosition);
        menu.add(actions.m_actionExportPng);
        menu.add(actions.m_actionExportTextPosition);
        menu.add(actions.m_actionExportTextPositionToClipboard);
        return menu;
    }

    private GuiMenu createMenuFile(GoGuiActions actions,
                                       RecentFileMenu.Listener listener)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(82);GuiMenu menu = new GuiMenu(i18n("MEN_FILE"));
        menu.add(actions.m_actionOpen);
        menu.add(createRecentMenu(listener));
        menu.add(actions.m_actionSave);
        menu.add(actions.m_actionSaveAs);
        menu.addSeparator();
        menu.add(createMenuImport(actions));
        menu.add(createMenuExport(actions));
        menu.addSeparator();
        menu.add(actions.m_actionPrint);
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(83);if ((! Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_aa015bc918e1561c(85) && false))
        {
            $qualityscroll_cover_jacov_probe_aa015bc918e1561c(84);menu.addSeparator();
            menu.add(actions.m_actionQuit);
        }
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(86);return menu;
    }

    private GuiMenu createMenuGame(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(87);GuiMenu menu = new GuiMenu(i18n("MEN_GAME"));
        menu.add(actions.m_actionNewGame);
        menu.addSeparator();
        menu.add(createBoardSizeMenu(actions));
        menu.add(createHandicapMenu(actions));
        menu.add(actions.m_actionGameInfo);
        menu.addSeparator();
        m_computerColor = createComputerColorMenu(actions);
        menu.add(m_computerColor);
        menu.addSeparator();
        menu.add(actions.m_actionPass);
        menu.add(createClockMenu(actions));
        menu.add(actions.m_actionScore);
        return menu;
    }

    private GuiMenu createMenuGo(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(88);GuiMenu menu = new GuiMenu(i18n("MEN_GO"));
        menu.add(actions.m_actionBeginning);
        menu.add(actions.m_actionBackwardTen);
        menu.add(actions.m_actionBackward);
        menu.add(actions.m_actionForward);
        menu.add(actions.m_actionForwardTen);
        menu.add(actions.m_actionEnd);
        menu.add(actions.m_actionGotoMove);
        menu.addSeparator();
        menu.add(actions.m_actionNextVariation);
        menu.add(actions.m_actionPreviousVariation);
        menu.add(actions.m_actionNextEarlierVariation);
        menu.add(actions.m_actionPreviousEarlierVariation);
        menu.add(actions.m_actionBackToMainVariation);
        menu.add(actions.m_actionGotoVariation);
        return menu;
    }

    private GuiMenu createMenuHelp(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(89);GuiMenu menu = new GuiMenu(i18n("MEN_HELP"));
        menu.add(actions.m_actionHelp);
        menu.add(actions.m_actionAbout);
        return menu;
    }

    private GuiMenu createMenuImport(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(90);GuiMenu menu = new GuiMenu(i18n("MEN_IMPORT"));
        menu.add(actions.m_actionImportTextPosition);
        menu.add(actions.m_actionImportTextPositionFromClipboard);
        menu.add(actions.m_actionImportSgfFromClipboard);
        return menu;
    }

    
    
    private GuiMenu createMenuProgram(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(91);GuiMenu menu = new GuiMenu(i18n("MEN_PROGRAM"));
        m_menuAttach = new GuiMenu(i18n("MEN_ATTACH"));
        m_menuAttach.setEnabled(false);
        menu.add(m_menuAttach);
        menu.add(actions.m_actionDetachProgram);
        menu.addSeparator();
        menu.add(actions.m_actionPlaySingleMove);
        menu.add(actions.m_actionInterrupt);
        menu.addSeparator();
        menu.add(actions.m_actionNewProgram);
        menu.add(actions.m_actionEditPrograms);
        return menu;
    }

    private GuiMenu createMenuTools(GoGuiActions actions,
                                    RecentFileMenu.Listener listener)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(92);GuiMenu menu = new GuiMenu(i18n("MEN_TOOLS"));
        menu.add(actions.m_actionShowTree);
        menu.add(actions.m_actionShowAnalyzeDialog);
        menu.add(actions.m_actionShowShell);
        menu.addSeparator();
        menu.add(actions.m_actionReattachProgram);
        menu.add(actions.m_actionReattachWithParameters);
        menu.add(actions.m_actionSnapshotParameters);
        menu.add(actions.m_actionRestoreParameters);
        menu.add(actions.m_actionSaveParameters);
        menu.addSeparator();
        menu.add(actions.m_actionSaveLog);
        menu.add(actions.m_actionSaveCommands);
        menu.add(actions.m_actionSendFile);
        m_recentGtp = new RecentFileMenu(i18n("MEN_SEND_RECENT"),
                                         "net/sf/gogui/recentgtpfiles",
                                         listener);
        menu.add(m_recentGtp.getMenu());
        return menu;
    }

    private GuiMenu createMenuView(GoGuiActions actions)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(93);GuiMenu menu = new GuiMenu(i18n("MEN_VIEW"));
        menu.addCheckBoxItem(actions.m_actionToggleShowToolbar);
        menu.addCheckBoxItem(actions.m_actionToggleShowInfoPanel);
        menu.addSeparator();
        menu.addCheckBoxItem(actions.m_actionToggleShowCursor);
        menu.addCheckBoxItem(actions.m_actionToggleShowGrid);
        menu.addCheckBoxItem(actions.m_actionToggleShowLastMove);
        menu.addCheckBoxItem(actions.m_actionToggleShowMoveNumbers);
        menu.addCheckBoxItem(actions.m_actionToggleBeepAfterMove);
        menu.addCheckBoxItem(actions.m_actionToggleCommentMonoFont);
        GuiMenu menuVarLabels = new GuiMenu(i18n("MEN_VARIATION_LABELS"));
        ButtonGroup group = new ButtonGroup();
        menuVarLabels.addRadioItem(group,
                                   actions.m_actionShowVariationsChildren);
        menuVarLabels.addRadioItem(group,
                                   actions.m_actionShowVariationsSiblings);
        menuVarLabels.addRadioItem(group, actions.m_actionShowVariationsNone);
        menu.add(menuVarLabels);
        menu.addSeparator();
        menu.add(createMenuConfigureTree(actions));
        menu.add(createMenuConfigureShell(actions));
        return menu;
    }

    private GuiMenu createRecentMenu(RecentFileMenu.Listener listener)
    {
        $qualityscroll_cover_jacov_probe_aa015bc918e1561c(94);m_recent = new RecentFileMenu(i18n("MEN_OPEN_RECENT"),
                                      "net/sf/gogui/recentfiles", listener);
        return m_recent.getMenu();
    }
}
