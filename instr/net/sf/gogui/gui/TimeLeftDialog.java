/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// TimeLeftDialog.java

package net.sf.gogui.gui;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.game.Clock;
import net.sf.gogui.game.ConstClock;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.Game;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;

public final class TimeLeftDialog
    extends JOptionPane
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TimeLeftDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4010755782700874830L,/* translation unit id   */ 240840614669732446L,/* timestamp             */ 1709177902815L,/* source file name      */ "TimeLeftDialog.java",/* probe size            */ 61);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_357a34354e04a5e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void show(Component parent, Game game, ConstNode node,
                            MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(0);ConstGameInfo info = game.getGameInfoNode(node).getGameInfoConst();
        Clock clock = null;
        TimeSettings timeSettings = info.getTimeSettings();
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(1);if ((timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(3) && false))
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(2);clock = new Clock();
            clock.setTimeSettings(timeSettings);
            NodeUtil.restoreClock(node, clock);
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(4);TimeLeftDialog timeLeftDialog = new TimeLeftDialog(clock);
        JDialog dialog = timeLeftDialog.createDialog(parent,
                                                     i18n("TIT_TIME_LEFT"));
        boolean done = false;
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(5);while ((! done) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(7) && false))
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(6);dialog.setVisible(true);
            Object value = timeLeftDialog.getValue();
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(15);if ((! (value instanceof Integer)
                || ((Integer)value).intValue() != JOptionPane.OK_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(17) && false))
                {$qualityscroll_cover_jacov_probe_357a34354e04a5e(16);return;}
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(18);done = timeLeftDialog.validate(parent, messageDialogs);
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(8);for (GoColor c : BLACK_WHITE)
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(10);long timeLeft = timeLeftDialog.getTimeLeft(c);
            game.setTimeLeft(node, c, timeLeft / 1000L);
            int movesLeft = timeLeftDialog.getMovesLeft(c);
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(11);if ((movesLeft >= 0) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(13) && false))
                {$qualityscroll_cover_jacov_probe_357a34354e04a5e(12);game.setMovesLeft(node, c, movesLeft);}
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(14);game.restoreClock();
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(9);dialog.dispose();
    }

    private static class PlayerTime
    {
        public Box m_box;

        public JTextField m_timeLeft;

        public JTextField m_movesLeft;
    }

    private final PlayerTime m_black;

    private final PlayerTime m_white;

    private TimeLeftDialog(ConstClock clock)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(19);Box box = Box.createVerticalBox();
        m_white = createPlayerTime(WHITE, clock);
        m_white.m_box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(m_white.m_box);
        box.add(GuiUtil.createFiller());
        m_black = createPlayerTime(BLACK, clock);
        m_black.m_box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(m_black.m_box);
        setMessage(box);
        setOptionType(OK_CANCEL_OPTION);
    }

    private PlayerTime createPlayerTime(GoColor c, ConstClock clock)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(20);assert c.isBlackWhite();
        PlayerTime playerInfo = new PlayerTime();
        Box box = Box.createHorizontalBox();
        JLabel label;
        String tooltipTimeLeft;
        String tooltipMovesLeft;
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(21);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(23) && false))
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(22);label = new JLabel(GuiUtil.getIcon("gogui-black-16x16",
                                               i18n("LB_BLACK")));
            tooltipTimeLeft = "TT_TIMELEFT_TIME_BLACK";
            tooltipMovesLeft = "TT_TIMELEFT_MOVES_BLACK";
        }
        else
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(32);label = new JLabel(GuiUtil.getIcon("gogui-white-16x16",
                                               i18n("LB_WHITE")));
            tooltipTimeLeft = "TT_TIMELEFT_TIME_WHITE";
            tooltipMovesLeft = "TT_TIMELEFT_MOVES_WHITE";
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(24);label.setAlignmentY(Component.CENTER_ALIGNMENT);
        box.add(label);
        box.add(GuiUtil.createFiller());
        playerInfo.m_box = box;
        playerInfo.m_timeLeft = new JTextField(9);
        playerInfo.m_timeLeft.setToolTipText(i18n(tooltipTimeLeft));
        box.add(playerInfo.m_timeLeft);
        playerInfo.m_timeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        box.add(GuiUtil.createFiller());
        playerInfo.m_movesLeft = new JTextField(3);
        playerInfo.m_movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
        playerInfo.m_movesLeft.setToolTipText(i18n(tooltipMovesLeft));
        box.add(playerInfo.m_movesLeft);
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(25);if ((clock != null) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(27) && false))
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(26);String timeLeft =
                Clock.getTimeString(clock.getTimeLeft(c) / 1000L, -1);
            playerInfo.m_timeLeft.setText(timeLeft);
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(28);if ((clock.getUseByoyomi() && clock.isInByoyomi(c)) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(30) && false))
            {
                $qualityscroll_cover_jacov_probe_357a34354e04a5e(29);String movesLeft = Integer.toString(clock.getMovesLeft(c));
                playerInfo.m_movesLeft.setText(movesLeft);
            }
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(31);box.setAlignmentY(Component.CENTER_ALIGNMENT);
        return playerInfo;
    }

    private int getMovesLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(33);JTextField textField =
            (((c == BLACK) ? ($qualityscroll_cover_jacov_probe_357a34354e04a5e(34) || true) : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(35) && false)) ? m_black.m_movesLeft : m_white.m_movesLeft);
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(36);if ((isEmpty(textField)) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(38) && false))
            {$qualityscroll_cover_jacov_probe_357a34354e04a5e(37);return -1;}
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(39);return Integer.parseInt(getTextFieldContent(textField));
    }

    private static String getTextFieldContent(JTextField textField)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(40);return textField.getText().trim();
    }

    private long getTimeLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(41);JTextField textField =
            (((c == BLACK) ? ($qualityscroll_cover_jacov_probe_357a34354e04a5e(42) || true) : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(43) && false)) ? m_black.m_timeLeft : m_white.m_timeLeft);
        long timeLeft = Clock.parseTimeString(getTextFieldContent(textField));
        assert timeLeft >= 0;
        return timeLeft;
    }

    private boolean isEmpty(JTextField textField)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(44);return getTextFieldContent(textField).equals("");
    }

    private boolean validate(Component parent, MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(45);return (validatePosIntOrEmpty(parent, m_black.m_movesLeft,
                                      "MSG_TIMELEFT_INVALID_MOVESLEFT",
                                      messageDialogs)
                && validatePosIntOrEmpty(parent, m_white.m_movesLeft,
                                         "MSG_TIMELEFT_INVALID_MOVESLEFT",
                                         messageDialogs)
                && validateTime(parent, m_black.m_timeLeft,
                                "MSG_TIMELEFT_INVALID_TIMELEFT",
                                messageDialogs)
                && validateTime(parent, m_white.m_timeLeft,
                                "MSG_TIMELEFT_INVALID_TIMELEFT",
                                messageDialogs));
    }

    private boolean validatePosIntOrEmpty(Component parent,
                                          JTextField textField,
                                          String errorMessage,
                                          MessageDialogs messageDialogs)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(46);String content = getTextFieldContent(textField);
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(47);if ((content.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(49) && false))
                {$qualityscroll_cover_jacov_probe_357a34354e04a5e(48);return true;}
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(50);int value = Integer.parseInt(content);
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(51);if ((value < 0) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(53) && false))
            {
                $qualityscroll_cover_jacov_probe_357a34354e04a5e(52);messageDialogs.showError(parent, i18n(errorMessage),
                    i18n("MSG_TIMELEFT_NEGATIVE_NUMBER"),
                    false);
                return false;
            }
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(55);messageDialogs.showError(parent, i18n(errorMessage),
                                     i18n("MSG_TIMELEFT_NO_NUMBER"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(54);return true;
    }

    private boolean validateTime(Component parent,
                                 JTextField textField,
                                 String errorMessage,
                                 MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(56);long timeLeft = Clock.parseTimeString(getTextFieldContent(textField));
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(57);if ((timeLeft < 0) ? true : (!$qualityscroll_cover_jacov_probe_357a34354e04a5e(59) && false))
        {
            $qualityscroll_cover_jacov_probe_357a34354e04a5e(58);messageDialogs.showError(parent, i18n(errorMessage),
                                     i18n("MSG_TIMELEFT_NO_TIME"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_357a34354e04a5e(60);return true;
    }
}
