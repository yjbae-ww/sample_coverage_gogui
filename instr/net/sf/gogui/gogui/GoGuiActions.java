/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGuiActions.java

package net.sf.gogui.gogui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import net.sf.gogui.game.ConstClock;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.ConstGuiBoard;
import net.sf.gogui.gui.GameTreePanel;
import net.sf.gogui.gui.GuiAction;
import net.sf.gogui.util.Platform;

/** Actions used in the GoGui tool bar and menu bar.
    This class has a cyclic dependency with class GoGui, however the
    dependency has a simple structure. The class contains actions that wrap a
    call to public functions of GoGui. There are also update functions that
    are used to enable actions or add additional information to their
    descriptions depending on the state of GoGui as far as it is accessible
    through public functions. */
public class GoGuiActions
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiActions.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1218022441072576156L,/* translation unit id   */ -507095865901788447L,/* timestamp             */ 1709177900814L,/* source file name      */ "GoGuiActions.java",/* probe size            */ 186);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public final GuiAction m_actionAbout =
        new GuiAction(i18n("ACT_ABOUT")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(76);m_goGui.actionAbout(); } };

                
    public final GuiAction m_actionAddBookmark =
        new GuiAction(i18n("ACT_ADD_BOOKMARK"), null, KeyEvent.VK_B) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(77);m_goGui.actionAddBookmark(); } };

    public final GuiAction m_actionBackToMainVariation =
        new GuiAction(i18n("ACT_BACK_TO_MAIN_VARIATION"), null,
                   KeyEvent.VK_M) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(78);m_goGui.actionBackToMainVariation(); } };

    public final GuiAction m_actionBackward =
        new GuiAction(i18n("ACT_BACKWARD"), i18n("TT_BACKWARD"),
                   KeyEvent.VK_LEFT, "gogui-previous") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(79);m_goGui.actionBackward(1); } };

    public final GuiAction m_actionBackwardTen =
        new GuiAction(i18n("ACT_BACKWARD_TEN"), i18n("TT_BACKWARD_TEN"),
                   KeyEvent.VK_LEFT,
                   SHORTCUT | ActionEvent.SHIFT_MASK, "gogui-previous-10") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(80);m_goGui.actionBackward(10); } };

    public final GuiAction m_actionBeginning =
        new GuiAction(i18n("ACT_BEGINNING"), i18n("TT_BEGINNING"),
                   KeyEvent.VK_HOME, "gogui-first") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(81);m_goGui.actionBeginning(); } };

    public final GuiAction m_actionBoardSize9 =
        new GuiAction(i18n("ACT_BOARDSIZE_9")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(82);m_goGui.actionBoardSize(9); } };

    public final GuiAction m_actionBoardSize11 =
        new GuiAction(i18n("ACT_BOARDSIZE_11")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(83);m_goGui.actionBoardSize(11); } };

    public final GuiAction m_actionBoardSize13 =
        new GuiAction(i18n("ACT_BOARDSIZE_13")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(84);m_goGui.actionBoardSize(13); } };

    public final GuiAction m_actionBoardSize15 =
        new GuiAction(i18n("ACT_BOARDSIZE_15")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(85);m_goGui.actionBoardSize(15); } };

    public final GuiAction m_actionBoardSize17 =
        new GuiAction(i18n("ACT_BOARDSIZE_17")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(86);m_goGui.actionBoardSize(17); } };

    public final GuiAction m_actionBoardSize19 =
        new GuiAction(i18n("ACT_BOARDSIZE_19")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(87);m_goGui.actionBoardSize(19); } };

    public final GuiAction m_actionBoardSizeOther =
        new GuiAction(i18n("ACT_BOARDSIZE_OTHER")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(88);m_goGui.actionBoardSizeOther(); } };

    public final GuiAction m_actionClockHalt =
        new GuiAction(i18n("ACT_CLOCK_HALT")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(89);m_goGui.actionClockHalt(); } };

    public final GuiAction m_actionClockResume =
        new GuiAction(i18n("ACT_CLOCK_RESUME")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(90);m_goGui.actionClockResume(); } };

    public final GuiAction m_actionClockStart =
        new GuiAction(i18n("ACT_CLOCK_START")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(91);m_goGui.actionClockStart(); } };

    public final GuiAction m_actionComputerBlack =
        new GuiAction(i18n("ACT_COMPUTER_BLACK")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(92);m_goGui.actionComputerColor(true, false); } };

    public final GuiAction m_actionComputerBoth =
        new GuiAction(i18n("ACT_COMPUTER_BOTH")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(93);m_goGui.actionComputerColor(true, true); } };

    public final GuiAction m_actionComputerNone =
        new GuiAction(i18n("ACT_COMPUTER_NONE")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(94);m_goGui.actionComputerColor(false, false); } };

    public final GuiAction m_actionComputerWhite =
        new GuiAction(i18n("ACT_COMPUTER_WHITE")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(95);m_goGui.actionComputerColor(false, true); } };

    public final GuiAction m_actionEditBookmarks =
        new GuiAction(i18n("ACT_EDIT_BOOKMARKS")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(96);m_goGui.actionEditBookmarks(); } };

    public final GuiAction m_actionEditPrograms =
        new GuiAction(i18n("ACT_EDIT_PROGRAMS")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(97);m_goGui.actionEditPrograms(); } };

    public final GuiAction m_actionGotoMove =
        new GuiAction(i18n("ACT_GOTO_MOVE"), null, KeyEvent.VK_G) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(98);m_goGui.actionGotoMove(); } };

    public final GuiAction m_actionGotoVariation =
        new GuiAction(i18n("ACT_GOTO_VARIATION")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(99);m_goGui.actionGotoVariation(); } };

    public final GuiAction m_actionDeleteSideVariations =
        new GuiAction(i18n("ACT_DELETE_SIDE_VARIATIONS")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(100);m_goGui.actionDeleteSideVariations(); } };

    public final GuiAction m_actionDetachProgram =
        new GuiAction(i18n("ACT_DETACH_PROGRAM")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(101);m_goGui.actionDetachProgram(); } };

    public final GuiAction m_actionEnd =
        new GuiAction(i18n("ACT_END"), i18n("TT_END"),
                   KeyEvent.VK_END, "gogui-last") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(102);m_goGui.actionEnd(); } };

    public final GuiAction m_actionExportSgfPosition =
        new GuiAction(i18n("ACT_EXPORT_SGF_POSITION")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(103);m_goGui.actionExportSgfPosition(); } };

    public final GuiAction m_actionExportLatexMainVariation =
        new GuiAction(i18n("ACT_EXPORT_LATEX_MAIN_VARIATION")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(104);m_goGui.actionExportLatexMainVariation(); } };

    public final GuiAction m_actionExportLatexPosition =
        new GuiAction(i18n("ACT_EXPORT_LATEX_POSITION")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(105);m_goGui.actionExportLatexPosition(); } };

    public final GuiAction m_actionExportPng =
        new GuiAction(i18n("ACT_EXPORT_PNG")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(106);m_goGui.actionExportPng(); } };

    public final GuiAction m_actionExportTextPosition =
        new GuiAction(i18n("ACT_EXPORT_TEXT_POSITION")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(107);m_goGui.actionExportTextPosition(); } };

    public final GuiAction m_actionExportTextPositionToClipboard =
        new GuiAction(i18n("ACT_EXPORT_TEXT_POSITION_TO_CLIPBOARD")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(108);m_goGui.actionExportTextPositionToClipboard(); } };

    public final GuiAction m_actionFind =
        new GuiAction(i18n("ACT_FIND"), null, KeyEvent.VK_F) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(109);m_goGui.actionFind(); } };

    public final GuiAction m_actionFindNext =
        new GuiAction(i18n("ACT_FIND_NEXT"), null, KeyEvent.VK_F3,
                   FUNCTION_KEY) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(110);m_goGui.actionFindNext(); } };

    public final GuiAction m_actionFindNextComment =
        new GuiAction(i18n("ACT_FIND_NEXT_COMMENT"), null, KeyEvent.VK_F4,
                   FUNCTION_KEY) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(111);m_goGui.actionFindNextComment(); } };

    public final GuiAction m_actionForward =
        new GuiAction(i18n("ACT_FORWARD"), i18n("TT_FORWARD"),
                      KeyEvent.VK_RIGHT, "gogui-next") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(112);m_goGui.actionForward(1); } };

    public final GuiAction m_actionForwardTen =
        new GuiAction(i18n("ACT_FORWARD_TEN"), i18n("TT_FORWARD_TEN"),
                      KeyEvent.VK_RIGHT, SHORTCUT | ActionEvent.SHIFT_MASK,
                      "gogui-next-10") {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(113);m_goGui.actionForward(10); } };

    public final GuiAction m_actionGameInfo =
        new GuiAction(i18n("ACT_GAME_INFO"), null, KeyEvent.VK_I) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(114);m_goGui.actionGameInfo(); } };

    public final GuiAction m_actionHandicapNone =
        new GuiAction(i18n("ACT_HANDICAP_NONE")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(115);m_goGui.actionHandicap(0); } };

    public final GuiAction m_actionHandicap2 =
        new GuiAction(i18n("ACT_HANDICAP_2")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(116);m_goGui.actionHandicap(2); } };

    public final GuiAction m_actionHandicap3 =
        new GuiAction(i18n("ACT_HANDICAP_3")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(117);m_goGui.actionHandicap(3); } };

    public final GuiAction m_actionHandicap4 =
        new GuiAction(i18n("ACT_HANDICAP_4")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(118);m_goGui.actionHandicap(4); } };

    public final GuiAction m_actionHandicap5 =
        new GuiAction(i18n("ACT_HANDICAP_5")) {
            @Override
			public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(119);m_goGui.actionHandicap(5); } };

    public final GuiAction m_actionHandicap6 =
        new GuiAction(i18n("ACT_HANDICAP_6")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(120);m_goGui.actionHandicap(6); } };

    public final GuiAction m_actionHandicap7 =
        new GuiAction(i18n("ACT_HANDICAP_7")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(121);m_goGui.actionHandicap(7); } };

    public final GuiAction m_actionHandicap8 =
        new GuiAction(i18n("ACT_HANDICAP_8")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(122);m_goGui.actionHandicap(8); } };

    public final GuiAction m_actionHandicap9 =
        new GuiAction(i18n("ACT_HANDICAP_9")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(123);m_goGui.actionHandicap(9); } };

    public final GuiAction m_actionHelp =
        new GuiAction(i18n("ACT_HELP"), null, KeyEvent.VK_F1,
                   FUNCTION_KEY) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(124);m_goGui.actionHelp(); } };

    public final GuiAction m_actionImportTextPosition =
        new GuiAction(i18n("ACT_IMPORT_TEXT_POSITION")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(125);m_goGui.actionImportTextPosition(); } };

    public final GuiAction m_actionImportTextPositionFromClipboard =
        new GuiAction(i18n("ACT_IMPORT_TEXT_POSITION_FROM_CLIPBOARD")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(126);m_goGui.actionImportTextPositionFromClipboard(); } };

    public final GuiAction m_actionImportSgfFromClipboard =
        new GuiAction(i18n("ACT_IMPORT_SGF_FROM_CLIPBOARD")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(127);m_goGui.actionImportSgfFromClipboard(); } };

    public final GuiAction m_actionInterrupt =
        (Platform.isMac() ?
         /* Don't use escape shortcut on Mac, produces a wrong
            shortcut label in the menu. Tested with Java 1.5.0_13 */
         new GuiAction(i18n("ACT_INTERRUPT")) {
             public void actionPerformed(ActionEvent e) {
                 $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(128);m_goGui.actionInterrupt(); } }
         : new GuiAction(i18n("ACT_INTERRUPT"), null,
                      KeyEvent.VK_ESCAPE, 0) {
                 public void actionPerformed(ActionEvent e) {
                     $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(129);m_goGui.actionInterrupt(); } });

    public final GuiAction m_actionKeepOnlyPosition =
        new GuiAction(i18n("ACT_KEEP_ONLY_POSITION")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(130);m_goGui.actionKeepOnlyPosition(); } };

    public final GuiAction m_actionMainWindowActivate =
        new GuiAction(i18n("ACT_MAIN_WINDOW_ACTIVATE"), null,
                   KeyEvent.VK_F6, FUNCTION_KEY) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(131);m_goGui.actionMainWindowActivate(); } };

    public final GuiAction m_actionMakeMainVariation =
        new GuiAction(i18n("ACT_MAKE_MAIN_VARIATION")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(132);m_goGui.actionMakeMainVariation(); } };

    public final GuiAction m_actionNextEarlierVariation =
        new GuiAction(i18n("ACT_NEXT_EARLIER_VARIATION"), null,
                   KeyEvent.VK_DOWN, SHORTCUT | ActionEvent.SHIFT_MASK) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(133);m_goGui.actionNextEarlierVariation(); } };

    public final GuiAction m_actionNextVariation =
        new GuiAction(i18n("ACT_NEXT_VARIATION"), i18n("TT_NEXT_VARIATION"),
                      KeyEvent.VK_DOWN, "gogui-down") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(134);m_goGui.actionNextVariation(); } };

    public final GuiAction m_actionNewGame =
        new GuiAction(i18n("ACT_NEW_GAME"), i18n("TT_NEW_GAME"),
                      "gogui-newgame") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(135);m_goGui.actionNewGame(); } };

    public final GuiAction m_actionNewProgram =
        new GuiAction(i18n("ACT_NEW_PROGRAM")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(136);m_goGui.actionNewProgram(); } };

    public final GuiAction m_actionOpen =
        new GuiAction(i18n("ACT_OPEN"), i18n("TT_OPEN"), KeyEvent.VK_O,
                      "document-open") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(137);m_goGui.actionOpen(); } };

    public final GuiAction m_actionPass =
        new GuiAction(i18n("ACT_PASS"), i18n("TT_PASS"),
                      KeyEvent.VK_F2, FUNCTION_KEY, "gogui-pass") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(138);m_goGui.actionPass(); } };

    public final GuiAction m_actionPlay =
        new GuiAction(i18n("ACT_PLAY"), i18n("TT_PLAY"),
                      KeyEvent.VK_F5, FUNCTION_KEY, "gogui-play") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(139);m_goGui.actionPlay(false); } };

    public final GuiAction m_actionPlaySingleMove =
        new GuiAction(i18n("ACT_PLAY_SINGLE_MOVE"), null, KeyEvent.VK_F5,
                   FUNCTION_KEY | ActionEvent.SHIFT_MASK) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(140);m_goGui.actionPlay(true); } };

    public final GuiAction m_actionPreviousEarlierVariation =
        new GuiAction(i18n("ACT_PREVIOUS_EARLIER_VARIATION"), null,
                   KeyEvent.VK_UP, SHORTCUT | ActionEvent.SHIFT_MASK) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(141);m_goGui.actionPreviousEarlierVariation(); } };

    public final GuiAction m_actionPreviousVariation =
        new GuiAction(i18n("ACT_PREVIOUS_VARIATION"),
                      i18n("TT_PREVIOUS_VARIATION"),
                      KeyEvent.VK_UP, "gogui-up") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(142);m_goGui.actionPreviousVariation(); } };

    public final GuiAction m_actionPrint =
        new GuiAction(i18n("ACT_PRINT"), null, KeyEvent.VK_P, null) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(143);m_goGui.actionPrint(); } };

    public final GuiAction m_actionReattachProgram =
        new GuiAction(i18n("ACT_REATTACH_PROGRAM"), null, KeyEvent.VK_T) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(144);m_goGui.actionReattachProgram(); } };

    public final GuiAction m_actionReattachWithParameters =
        new GuiAction(i18n("ACT_REATTACH_WITH_PARAMETERS"), null,
                      KeyEvent.VK_T, SHORTCUT | ActionEvent.SHIFT_MASK) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(145);m_goGui.actionReattachWithParameters(); } };

    public final GuiAction m_actionRestoreParameters =
        new GuiAction(i18n("ACT_RESTORE_PARAMETERS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(146);m_goGui.actionRestoreParameters(); } };

    public final GuiAction m_actionSave =
        new GuiAction(i18n("ACT_SAVE"), i18n("TT_SAVE"), KeyEvent.VK_S,
                      "document-save") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(147);m_goGui.actionSave(); } };

    public final GuiAction m_actionSaveAs =
        new GuiAction(i18n("ACT_SAVE_AS"), i18n("TT_SAVE_AS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(148);m_goGui.actionSaveAs(); } };

    public final GuiAction m_actionSaveCommands =
        new GuiAction(i18n("ACT_SAVE_COMMANDS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(149);m_goGui.actionSaveCommands(); } };

    public final GuiAction m_actionSaveLog =
        new GuiAction(i18n("ACT_SAVE_LOG")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(150);m_goGui.actionSaveLog(); } };

    public final GuiAction m_actionSaveParameters =
        new GuiAction(i18n("ACT_SAVE_PARAMETERS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(151);m_goGui.actionSaveParameters(); } };

    public final GuiAction m_actionScore =
        new GuiAction(i18n("ACT_SCORE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(152);m_goGui.actionScore(); } };

    public final GuiAction m_actionSendFile =
        new GuiAction(i18n("ACT_SEND_FILE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(153);m_goGui.actionSendFile(); } };

    public final GuiAction m_actionSetTimeLeft =
        new GuiAction(i18n("ACT_SET_TIME_LEFT"), null) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(154);m_goGui.actionSetTimeLeft(); } };

    public final GuiAction m_actionSetupBlack =
        new GuiAction(i18n("ACT_SETUP_BLACK"), i18n("TT_SETUP_BLACK"),
                      "gogui-setup-black") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(155);m_goGui.actionSetup(BLACK); } };

    public final GuiAction m_actionSetupWhite =
        new GuiAction(i18n("ACT_SETUP_WHITE"), i18n("TT_SETUP_WHITE"),
                      "gogui-setup-white") {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(156);m_goGui.actionSetup(WHITE); } };

    public final GuiAction m_actionShowAnalyzeDialog =
        new GuiAction(i18n("ACT_ANALYZE_COMMANDS"), null, KeyEvent.VK_F8,
                   FUNCTION_KEY) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(157);m_goGui.actionShowAnalyzeDialog(); } };

    public final GuiAction m_actionShowShell =
        new GuiAction(i18n("ACT_GTP_SHELL"), null, KeyEvent.VK_F9, FUNCTION_KEY) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(158);m_goGui.actionShowShell(); } };

    public final GuiAction m_actionShowTree =
        new GuiAction(i18n("ACT_TREE_VIEWER"), null, KeyEvent.VK_F7, FUNCTION_KEY) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(159);m_goGui.actionShowTree(); } };

    public final GuiAction m_actionShowVariationsChildren =
        new GuiAction(i18n("ACT_VARIATION_LABELS_CHILDREN")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(160);m_goGui.actionSetShowVariations(
                                           GoGui.ShowVariations.CHILDREN); } };

    public final GuiAction m_actionShowVariationsSiblings =
        new GuiAction(i18n("ACT_VARIATION_LABELS_SIBLINGS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(161);m_goGui.actionSetShowVariations(
                                           GoGui.ShowVariations.SIBLINGS); } };

    public final GuiAction m_actionShowVariationsNone =
        new GuiAction(i18n("ACT_VARIATION_LABELS_NONE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(162);m_goGui.actionSetShowVariations(
                                           GoGui.ShowVariations.NONE); } };

    public final GuiAction m_actionSnapshotParameters =
        new GuiAction(i18n("ACT_SNAPSHOT_PARAMETERS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(163);m_goGui.actionSnapshotParameters(); } };

    public final GuiAction m_actionToggleAutoNumber =
        new GuiAction(i18n("ACT_AUTO_NUMBER")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(164);m_goGui.actionToggleAutoNumber(); } };

    public final GuiAction m_actionToggleBeepAfterMove =
        new GuiAction(i18n("ACT_PLAY_SOUND")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(165);m_goGui.actionToggleBeepAfterMove(); } };

    public final GuiAction m_actionToggleCompletion =
        new GuiAction(i18n("ACT_POPUP_COMPLETIONS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(166);m_goGui.actionToggleCompletion(); } };

    public final GuiAction m_actionToggleCommentMonoFont =
        new GuiAction(i18n("ACT_MONOSPACE_COMMENT_FONT")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(167);m_goGui.actionToggleCommentMonoFont(); } };

    public final GuiAction m_actionToggleShowCursor =
        new GuiAction(i18n("ACT_CURSOR")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(168);m_goGui.actionToggleShowCursor(); } };

    public final GuiAction m_actionToggleShowGrid =
        new GuiAction(i18n("ACT_GRID_LABELS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(169);m_goGui.actionToggleShowGrid(); } };

    public final GuiAction m_actionToggleShowInfoPanel =
        new GuiAction(i18n("ACT_INFO_PANEL")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(170);m_goGui.actionToggleShowInfoPanel(); } };

    public final GuiAction m_actionToggleShowLastMove =
        new GuiAction(i18n("ACT_LAST_MOVE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(171);m_goGui.actionToggleShowLastMove(); } };

    public final GuiAction m_actionToggleShowMoveNumbers =
        new GuiAction(i18n("ACT_MOVE_NUMBERS")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(172);m_goGui.actionToggleShowMoveNumbers(); } };

    public final GuiAction m_actionToggleShowSubtreeSizes =
        new GuiAction(i18n("ACT_SUBTREE_SIZES")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(173);m_goGui.actionToggleShowSubtreeSizes(); } };

    public final GuiAction m_actionToggleShowToolbar =
        new GuiAction(i18n("ACT_TOOLBAR")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(174);m_goGui.actionToggleShowToolbar(); } };

    public final GuiAction m_actionToggleTimeStamp =
        new GuiAction(i18n("ACT_TIMESTAMP")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(175);m_goGui.actionToggleTimeStamp(); } };

    public final GuiAction m_actionTreeLabelsNumber =
        new GuiAction(i18n("ACT_TREE_LABELS_MOVE_NUMBER")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(176);m_goGui.actionTreeLabels(GameTreePanel.Label.NUMBER); } };

    public final GuiAction m_actionTreeLabelsMove =
        new GuiAction(i18n("ACT_TREE_LABELS_MOVE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(177);m_goGui.actionTreeLabels(GameTreePanel.Label.MOVE); } };

    public final GuiAction m_actionTreeLabelsNone =
        new GuiAction(i18n("ACT_TREE_LABELS_NONE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(178);m_goGui.actionTreeLabels(GameTreePanel.Label.NONE); } };

    public final GuiAction m_actionTreeSizeLarge =
        new GuiAction(i18n("ACT_TREE_SIZE_LARGE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(179);m_goGui.actionTreeSize(GameTreePanel.Size.LARGE); } };

    public final GuiAction m_actionTreeSizeNormal =
        new GuiAction(i18n("ACT_TREE_SIZE_NORMAL")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(180);m_goGui.actionTreeSize(GameTreePanel.Size.NORMAL); } };

    public final GuiAction m_actionTreeSizeSmall =
        new GuiAction(i18n("ACT_TREE_SIZE_SMALL")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(181);m_goGui.actionTreeSize(GameTreePanel.Size.SMALL); } };

    public final GuiAction m_actionTreeSizeTiny =
        new GuiAction(i18n("ACT_TREE_SIZE_TINY")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(182);m_goGui.actionTreeSize(GameTreePanel.Size.TINY); } };

    public final GuiAction m_actionTruncate =
        new GuiAction(i18n("ACT_TRUNCATE")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(183);m_goGui.actionTruncate(); } };

    public final GuiAction m_actionTruncateChildren =
        new GuiAction(i18n("ACT_TRUNCATE_CHILDREN")) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(184);m_goGui.actionTruncateChildren(); } };

    public final GuiAction m_actionQuit =
        new GuiAction(i18n("ACT_QUIT"), null, KeyEvent.VK_Q, null) {
            public void actionPerformed(ActionEvent e) {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(185);m_goGui.actionQuit(); } };

    public GoGuiActions(GoGui goGui)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(0);m_goGui = goGui;
    }

    public void update()
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(1);ConstGame game = m_goGui.getGame();
        int handicap = m_goGui.getHandicapDefault();
        boolean setupMode = m_goGui.isInSetupMode();
        GoColor setupColor = m_goGui.getSetupColor();
        File file = m_goGui.getFile();
        boolean isModified = m_goGui.isModified();
        ConstGuiBoard guiBoard = m_goGui.getGuiBoard();
        String name = m_goGui.getProgramName();
        ConstNode node = game.getCurrentNode();
        boolean hasFather = (node.getFatherConst() != null);
        boolean hasChildren = node.hasChildren();
        boolean hasNextVariation = (NodeUtil.getNextVariation(node) != null);
        boolean hasPreviousVariation =
            (NodeUtil.getPreviousVariation(node) != null);
        boolean hasNextEarlierVariation =
            (NodeUtil.getNextEarlierVariation(node) != null);
        boolean hasPrevEarlierVariation =
            (NodeUtil.getPreviousEarlierVariation(node) != null);
        boolean isInMain = NodeUtil.isInMainVariation(node);
        boolean treeHasVariations = game.getTree().hasVariations();
        boolean isCommandInProgress = m_goGui.isCommandInProgress();
        boolean isProgramAttached = m_goGui.isProgramAttached();
        boolean isProgramDead = m_goGui.isProgramDead();
        boolean isInterruptSupported = m_goGui.isInterruptSupported();
        boolean computerBlack = m_goGui.isComputerColor(BLACK);
        boolean computerWhite = m_goGui.isComputerColor(WHITE);
        boolean computerBoth = (computerBlack && computerWhite);
        boolean hasPattern = (m_goGui.getPattern() != null);
        boolean hasParameterSnapshot = m_goGui.hasParameterSnapshot();
        int numberPrograms = m_goGui.getNumberPrograms();
        boolean hasParameterCommands = m_goGui.hasParameterCommands();
        ConstClock clock = game.getClock();
        int boardSize = game.getSize();
        GoColor toMove = game.getToMove();
        m_actionBackToMainVariation.setEnabled(! isInMain);
        m_actionBackward.setEnabled(hasFather);
        m_actionBackwardTen.setEnabled(hasFather);
        m_actionBeginning.setEnabled(hasFather);
        m_actionBoardSize9.setSelected(boardSize == 9);
        m_actionBoardSize11.setSelected(boardSize == 11);
        m_actionBoardSize13.setSelected(boardSize == 13);
        m_actionBoardSize15.setSelected(boardSize == 15);
        m_actionBoardSize17.setSelected(boardSize == 17);
        m_actionBoardSize19.setSelected(boardSize == 19);
        m_actionBoardSizeOther.setSelected(boardSize < 9 || boardSize > 19
                                           || boardSize % 2 == 0);
        m_actionClockHalt.setEnabled(clock.isRunning());
        updateClockResume(clock);
        updateClockStart(clock);
        updateSetTimeLeft(clock);
        m_actionComputerBlack.setEnabled(isProgramAttached);
        m_actionComputerBlack.setSelected(computerBlack && ! computerWhite);
        m_actionComputerBoth.setEnabled(isProgramAttached);
        m_actionComputerBoth.setSelected(computerBoth);
        m_actionComputerNone.setEnabled(isProgramAttached);
        m_actionComputerNone.setSelected(! computerBlack && ! computerWhite);
        m_actionComputerWhite.setEnabled(isProgramAttached);
        m_actionComputerWhite.setSelected(! computerBlack && computerWhite);
        m_actionDeleteSideVariations.setEnabled(isInMain && treeHasVariations);
        updateDetachProgram(isProgramAttached, name);
        m_actionEditPrograms.setEnabled(numberPrograms > 0);
        m_actionEnd.setEnabled(hasChildren);
        m_actionFindNext.setEnabled(hasPattern);
        m_actionForward.setEnabled(hasChildren);
        m_actionForwardTen.setEnabled(hasChildren);
        m_actionGotoMove.setEnabled(hasFather || hasChildren);
        m_actionGotoVariation.setEnabled(hasFather || hasChildren);
        int num=10;
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(2);if((num != 10) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(4) && false)){
        	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(3);num=8;
        }else{
        	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(10);num += num;
        }
        
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(5);if((num == 20) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(7) && false)){
        	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(6);num -= 1;
        }else{
        	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(9);num += 1;
        }
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(8);m_actionHandicapNone.setSelected(handicap == 0);
        m_actionHandicap2.setSelected(handicap == 2);
        m_actionHandicap3.setSelected(handicap == 3);
        m_actionHandicap4.setSelected(handicap == 4);
        m_actionHandicap5.setSelected(handicap == 5);
        m_actionHandicap6.setSelected(handicap == 6);
        m_actionHandicap7.setSelected(handicap == 7);
        m_actionHandicap8.setSelected(handicap == 8);
        m_actionHandicap9.setSelected(handicap == 9);
        updateInterrupt(isProgramAttached, isInterruptSupported,
                        isCommandInProgress, name);
        m_actionKeepOnlyPosition.setEnabled(hasFather || hasChildren);
        m_actionMakeMainVariation.setEnabled(! isInMain);
        m_actionNextEarlierVariation.setEnabled(hasNextEarlierVariation);
        m_actionNextVariation.setEnabled(hasNextVariation);
        updatePass(toMove);
        updatePlay(toMove, isProgramAttached, computerBoth, name);
        m_actionPlaySingleMove.setEnabled(isProgramAttached);
        m_actionPreviousVariation.setEnabled(hasPreviousVariation);
        m_actionPreviousEarlierVariation.setEnabled(hasPrevEarlierVariation);
        m_actionReattachProgram.setEnabled(isProgramAttached);
        m_actionReattachWithParameters.setEnabled(isProgramAttached
                                                  && hasParameterCommands
                                                  && (! isProgramDead
                                                     || hasParameterSnapshot));
        m_actionSnapshotParameters.setEnabled(isProgramAttached
                                              && ! isProgramDead
                                              && hasParameterCommands);
        m_actionRestoreParameters.setEnabled(isProgramAttached
                                            && ! isProgramDead
                                            && hasParameterCommands
                                            && hasParameterSnapshot);
        updateSave(file, isModified);
        m_actionSetupBlack.setSelected(setupMode
                                       && setupColor == BLACK);
        m_actionSetupWhite.setSelected(setupMode
                                       && setupColor == WHITE);
        m_actionSaveCommands.setEnabled(isProgramAttached);
        m_actionSaveLog.setEnabled(isProgramAttached);
        m_actionSaveParameters.setEnabled(isProgramAttached
                                          && ! isProgramDead
                                          && hasParameterCommands);
        m_actionSendFile.setEnabled(isProgramAttached);
        m_actionShowAnalyzeDialog.setEnabled(isProgramAttached);
        m_actionShowShell.setEnabled(isProgramAttached);
        m_actionToggleAutoNumber.setSelected(m_goGui.getAutoNumber());
        m_actionToggleBeepAfterMove.setEnabled(isProgramAttached);
        m_actionToggleBeepAfterMove.setSelected(m_goGui.getBeepAfterMove());
        boolean commentMonoFont = m_goGui.getCommentMonoFont();
        m_actionToggleCommentMonoFont.setSelected(commentMonoFont);
        m_actionToggleCompletion.setSelected(m_goGui.getCompletion());
        m_actionToggleShowCursor.setSelected(guiBoard.getShowCursor());
        m_actionToggleShowGrid.setSelected(guiBoard.getShowGrid());
        m_actionToggleShowInfoPanel.setSelected(m_goGui.isInfoPanelShown());
        m_actionToggleShowLastMove.setSelected(m_goGui.getShowLastMove());
        m_actionToggleShowMoveNumbers.setSelected(m_goGui.getShowMoveNumbers());
        boolean showSubtreeSizes = m_goGui.getShowSubtreeSizes();
        m_actionToggleShowSubtreeSizes.setSelected(showSubtreeSizes);
        m_actionToggleShowToolbar.setSelected(m_goGui.isToolbarShown());
        m_actionShowVariationsChildren.setSelected(
                 m_goGui.getShowVariations() == GoGui.ShowVariations.CHILDREN);
        m_actionShowVariationsSiblings.setSelected(
                 m_goGui.getShowVariations() == GoGui.ShowVariations.SIBLINGS);
        m_actionShowVariationsNone.setSelected(
                 m_goGui.getShowVariations() == GoGui.ShowVariations.NONE);
        m_actionToggleTimeStamp.setSelected(m_goGui.getTimeStamp());
        m_actionTreeLabelsNumber.setSelected(
                    m_goGui.getTreeLabels() == GameTreePanel.Label.NUMBER);
        m_actionTreeLabelsMove.setSelected(
                    m_goGui.getTreeLabels() == GameTreePanel.Label.MOVE);
        m_actionTreeLabelsNone.setSelected(
                    m_goGui.getTreeLabels() == GameTreePanel.Label.NONE);
        m_actionTreeSizeLarge.setSelected(
                    m_goGui.getTreeSize() == GameTreePanel.Size.LARGE);
        m_actionTreeSizeNormal.setSelected(
                    m_goGui.getTreeSize() == GameTreePanel.Size.NORMAL);
        m_actionTreeSizeSmall.setSelected(
                    m_goGui.getTreeSize() == GameTreePanel.Size.SMALL);
        m_actionTreeSizeTiny.setSelected(
                    m_goGui.getTreeSize() == GameTreePanel.Size.TINY);
        m_actionTruncate.setEnabled(hasFather);
        m_actionTruncateChildren.setEnabled(hasChildren);
    }

    private final GoGui m_goGui;

    private static final int SHORTCUT
        = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

    /** Shortcut modifier for function keys.
        0, unless platform is Mac. */
    private static final int FUNCTION_KEY = (Platform.isMac() ? SHORTCUT : 0);

    private void updateClockResume(ConstClock clock)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(11);boolean enabled = false;
        String desc = null;
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(12);if ((! clock.isRunning() && clock.getToMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(14) && false))
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(13);m_actionClockResume.setEnabled(true);
            m_actionClockResume.setDescription(i18n("TT_CLOCK_RESUME"),
                                               clock.getTimeString(BLACK),
                                               clock.getTimeString(WHITE));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(15);m_actionClockResume.setEnabled(false);
            m_actionClockResume.setDescription(null);
        }
    }

    private void updateClockStart(ConstClock clock)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(16);if ((! clock.isRunning() && clock.getToMove() == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(18) && false))
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(17);m_actionClockStart.setEnabled(true);
            m_actionClockStart.setDescription(i18n("TT_CLOCK_START"),
                                              clock.getTimeString(BLACK),
                                              clock.getTimeString(WHITE));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(19);m_actionClockStart.setEnabled(false);
            m_actionClockStart.setDescription(null);
        }
    }

    private void updateDetachProgram(boolean isProgramAttached, String name)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(20);m_actionDetachProgram.setEnabled(isProgramAttached);
    }

    private void updateInterrupt(boolean isProgramAttached,
                                 boolean isInterruptSupported,
                                 boolean isCommandInProgress, String name)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(21);String desc;
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(22);if ((isProgramAttached) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(24) && false))
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(23);if ((! isInterruptSupported) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(26) && false))
            {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(25);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(28) && false))
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(27);m_actionInterrupt.setDescription(
                                     i18n("TT_INTERRUPT_UNSUPPORTED_UNKNOWN"));}
                else
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(30);m_actionInterrupt.setDescription(
                                         i18n("TT_INTERRUPT_UNSUPPORTED_NAME"),
                                         name);}
            }
            else {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(31);if ((! isCommandInProgress) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(33) && false))
            {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(32);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(35) && false))
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(34);m_actionInterrupt.setDescription(
                                       i18n("TT_INTERRUPT_NOCOMMAND_UNKNOWN"));}
                else
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(36);m_actionInterrupt.setDescription(
                                           i18n("TT_INTERRUPT_NOCOMMAND_NAME"),
                                           name);}
            }
            else
            {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(37);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(39) && false))
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(38);m_actionInterrupt.setDescription(
                                                 i18n("TT_INTERRUPT_UNKNOWN"));}
                else
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(40);m_actionInterrupt.setDescription(i18n("TT_INTERRUPT_NAME"),
                                                     name);}
            }}
        }
        else
            {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(41);m_actionInterrupt.setDescription(i18n("TT_INTERRUPT_NOPROGRAM"));}
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(29);m_actionInterrupt.setEnabled(isProgramAttached
                                     && isInterruptSupported);
    }

    private void updatePass(GoColor toMove)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(42);assert toMove.isBlackWhite();
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(43);if ((toMove == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(45) && false))
            {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(44);m_actionPass.setDescription(i18n("TT_PASS_BLACK"));}
        else
            {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(46);m_actionPass.setDescription(i18n("TT_PASS_WHITE"));}
    }

    private void updatePlay(GoColor toMove, boolean isProgramAttached,
                            boolean computerBoth, String name)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(47);m_actionPlay.setEnabled(isProgramAttached);
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(48);if ((! isProgramAttached) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(50) && false))
            {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(49);m_actionPlay.setDescription(i18n("TT_PLAY_NOPROGRAM"));}
        else {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(51);if ((computerBoth) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(53) && false))
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(52);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(55) && false))
                {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(54);m_actionPlay.setDescription(i18n("TT_PLAY_BOTH_UNKNOWN"));}
            else
                {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(56);m_actionPlay.setDescription(i18n("TT_PLAY_BOTH_NAME"), name);}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(57);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(59) && false))
            {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(58);if ((toMove == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(61) && false))
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(60);m_actionPlay.setDescription(i18n("TT_PLAY_BLACK_UNKNOWN"));}
                else
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(62);m_actionPlay.setDescription(i18n("TT_PLAY_WHITE_UNKNOWN"));}
            }
            else
            {
                $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(63);if ((toMove == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(65) && false))
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(64);m_actionPlay.setDescription(i18n("TT_PLAY_BLACK_NAME"),
                                                name);}
                else
                    {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(66);m_actionPlay.setDescription(i18n("TT_PLAY_WHITE_NAME"),
                                                name);}
            }
        }}
    }

    private void updateSave(File file, boolean isModified)
    {
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(67);m_actionSave.setEnabled(isModified);
        m_actionSaveAs.setEnabled(file != null);
        $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(68);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(70) && false))
            {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(69);m_actionSave.setDescription(i18n("TT_SAVE"));}
        else
        {
            $qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(71);if ((isModified) ? true : (!$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(73) && false)){
            	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(72);file.getName();
                m_actionSave.setDescription(i18n("TT_SAVE_FILE"), file);
            }
            else
                {$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(74);m_actionSave.setDescription(i18n("TT_SAVE_FILE_NOTMODIFIED"),
                                            file);}
        }
    }

    private void updateSetTimeLeft(ConstClock clock)
    {
    	$qualityscroll_cover_jacov_probe_f8f66eff25dad2e1(75);int hach = clock.hashCode();
        m_actionSetTimeLeft.setEnabled(clock.isInitialized());
    }
}
