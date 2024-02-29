/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GameInfoDialog.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.Komi;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;

/** Dialog for editing game settings and other information. */
public final class GameInfoDialog
    extends JOptionPane
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameInfoDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8003352424338007646L,/* translation unit id   */ -5921008649632697123L,/* timestamp             */ 1709177902012L,/* source file name      */ "GameInfoDialog.java",/* probe size            */ 117);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void show(Component parent, GameInfo info,
                            MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(0);GameInfoDialog gameInfo = new GameInfoDialog(info);
        JDialog dialog = gameInfo.createDialog(parent, i18n("TIT_GAMEINFO"));
        boolean done = false;
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(1);while ((! done) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(3) && false))
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(2);dialog.setVisible(true);
            Object value = gameInfo.getValue();
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(5);if ((! (value instanceof Integer)
                || ((Integer)value).intValue() != JOptionPane.OK_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(7) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(6);return;}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(8);done = gameInfo.validate(parent, messageDialogs);
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(4);dialog.dispose();
        gameInfo.updateGameInfo(info);
    }

    private static class PlayerInfo
    {
        public Box m_box;

        public JTextField m_name;

        public JTextField m_rank;
    }

    private TimeField m_byoyomi;

    private JTextField m_byoyomiMoves;

    private final JTextField m_date;

    private final JTextField m_komi;

    private final PlayerInfo m_black;

    private final PlayerInfo m_white;

    private TimeField m_preByoyomi;

    private final JTextField m_result;

    private final JTextField m_rules;

    private GameInfoDialog(GameInfo info)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(9);Box outerBox = Box.createVerticalBox();
        m_white = createPlayerInfo(WHITE, info);
        m_white.m_box.setAlignmentX(Component.LEFT_ALIGNMENT);
        outerBox.add(m_white.m_box);
        outerBox.add(GuiUtil.createFiller());
        m_black = createPlayerInfo(BLACK, info);
        m_black.m_box.setAlignmentX(Component.LEFT_ALIGNMENT);
        outerBox.add(m_black.m_box);
        outerBox.add(GuiUtil.createFiller());
        outerBox.add(GuiUtil.createFiller());
        Box box = Box.createHorizontalBox();
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        outerBox.add(box);
        JPanel labels =
            new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        box.add(labels);
        box.add(GuiUtil.createSmallFiller());
        JPanel values =
            new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        box.add(values);
        m_result = createEntry("LB_GAMEINFO_RESULT", 12,
                               info.get(StringInfo.RESULT),
                               "TT_GAMEINFO_RESULT", labels, values);
        m_date = createEntry("LB_GAMEINFO_DATE", 12,
                             info.get(StringInfo.DATE),
                             "TT_GAMEINFO_DATE", labels, values);
        m_rules = createEntry("LB_GAMEINFO_RULES", 12,
                              info.get(StringInfo.RULES),
                              "TT_GAMEINFO_RULES", labels, values);
        String komi = "";
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(10);if ((info.getKomi() != null) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(12) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(11);komi = info.getKomi().toString();}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(13);m_komi = createEntry("LB_GAMEINFO_KOMI", 12, komi,
                             "TT_GAMEINFO_KOMI",
                             labels, values);
        createTime(info.getTimeSettings(), labels, values);
        setMessage(outerBox);
        setOptionType(OK_CANCEL_OPTION);
    }

    private JTextField createEntry(String labelText, int cols, String text,
                                   String toolTipText, JComponent labels,
                                   JComponent values)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(14);Box boxLabel = Box.createHorizontalBox();
        boxLabel.add(Box.createHorizontalGlue());
        JLabel label = new JLabel(i18n(labelText));
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        boxLabel.add(label);
        labels.add(boxLabel);
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JTextField field = new JTextField(cols);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setToolTipText(i18n(toolTipText));
        field.setText(text);
        fieldPanel.add(field);
        values.add(fieldPanel);
        return field;
    }

    private void createTime(TimeSettings timeSettings, JComponent labels,
                            JComponent values)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(15);Box boxLabel = Box.createHorizontalBox();
        boxLabel.add(Box.createHorizontalGlue());
        JLabel label = new JLabel(i18n("LB_GAMEINFO_TIME"));
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        boxLabel.add(label);
        labels.add(boxLabel);
        Box boxValue = Box.createVerticalBox();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        boxValue.add(Box.createVerticalGlue());
        boxValue.add(panel);
        boxValue.add(Box.createVerticalGlue());
        m_preByoyomi = new TimeField(3, "TT_GAMEINFO_TIME_MAIN");
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(16);if ((timeSettings != null) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(18) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(17);m_preByoyomi.setTime(timeSettings.getPreByoyomi());}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(19);panel.add(m_preByoyomi);
        panel.add(new JLabel(" + "));
        m_byoyomi = new TimeField(2, "TT_GAMEINFO_TIME_BYOYOMI");
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(20);if ((timeSettings != null && timeSettings.getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(22) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(21);m_byoyomi.setTime(timeSettings.getByoyomi());}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(23);panel.add(m_byoyomi);
        panel.add(new JLabel(" / "));
        m_byoyomiMoves = new JTextField(2);
        m_byoyomiMoves.setToolTipText(i18n("TT_GAMEINFO_TIME_BYOYOMI_MOVES"));
        m_byoyomiMoves.setHorizontalAlignment(SwingConstants.RIGHT);
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(24);if ((timeSettings != null && timeSettings.getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(26) && false))
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(25);int byoyomiMoves = timeSettings.getByoyomiMoves();
            m_byoyomiMoves.setText(Integer.toString(byoyomiMoves));
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(27);panel.add(m_byoyomiMoves);
        panel.add(new JLabel(" " + i18n("LB_GAMEINFO_TIME_MOVES")));
        values.add(boxValue);
    }

    private PlayerInfo createPlayerInfo(GoColor c, GameInfo info)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(28);assert c.isBlackWhite();
        PlayerInfo playerInfo = new PlayerInfo();
        Box box = Box.createHorizontalBox();
        JLabel label;
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(29);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(31) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(30);label = new JLabel(GuiUtil.getIcon("gogui-black-16x16",
                                               i18n("LB_BLACK")));}
        else
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(43);label = new JLabel(GuiUtil.getIcon("gogui-white-16x16",
                                               i18n("LB_WHITE")));}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(32);label.setAlignmentY(Component.CENTER_ALIGNMENT);
        box.add(label);
        box.add(GuiUtil.createFiller());
        playerInfo.m_box = box;
        playerInfo.m_name = new JTextField(18);
        playerInfo.m_name.setText(info.get(StringInfoColor.NAME, c));
        box.add(playerInfo.m_name);
        playerInfo.m_name.setHorizontalAlignment(SwingConstants.CENTER);
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(33);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(35) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(34);playerInfo.m_name.setToolTipText(i18n("TT_GAMEINFO_NAME_BLACK"));}
        else
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(42);playerInfo.m_name.setToolTipText(i18n("TT_GAMEINFO_NAME_WHITE"));}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(36);box.add(GuiUtil.createFiller());
        playerInfo.m_rank = new JTextField(5);
        playerInfo.m_rank.setHorizontalAlignment(SwingConstants.CENTER);
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(37);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(39) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(38);playerInfo.m_rank.setToolTipText(i18n("TT_GAMEINFO_RANK_BLACK"));}
        else
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(41);playerInfo.m_rank.setToolTipText(i18n("TT_GAMEINFO_RANK_WHITE"));}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(40);box.add(playerInfo.m_rank);
        playerInfo.m_rank.setText(info.get(StringInfoColor.RANK, c));
        box.setAlignmentY(Component.CENTER_ALIGNMENT);
        return playerInfo;
    }

    private static String getTextFieldContent(JTextField textField)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(44);return textField.getText().trim();
    }

    private boolean isEmpty(JTextField textField)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(45);return getTextFieldContent(textField).equals("");
    }

    private void updateGameInfo(GameInfo info)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(46);info.set(StringInfoColor.NAME, BLACK,
                 getTextFieldContent(m_black.m_name));
        info.set(StringInfoColor.NAME, WHITE,
                 getTextFieldContent(m_white.m_name));
        info.set(StringInfoColor.RANK, BLACK,
                 getTextFieldContent(m_black.m_rank));
        info.set(StringInfoColor.RANK, WHITE,
                 getTextFieldContent(m_white.m_rank));
        info.set(StringInfo.RULES, getTextFieldContent(m_rules));
        info.set(StringInfo.RESULT, getTextFieldContent(m_result));
        info.set(StringInfo.DATE, getTextFieldContent(m_date));
        String komiText = getTextFieldContent(m_komi);
        Komi komi = null;
        try
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(47);komi = Komi.parseKomi(komiText);
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(63);assert false; // already validated
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(48);info.setKomi(komi);
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(49);if ((m_preByoyomi.isEmpty() && m_byoyomi.isEmpty()
            && isEmpty(m_byoyomiMoves)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(51) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(50);info.setTimeSettings(null);}
        else
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(52);long preByoyomi = m_preByoyomi.getTime();
            long byoyomi = -1;
            int byoyomiMoves = -1;
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(53);if ((! m_byoyomi.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(55) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(54);byoyomi = m_byoyomi.getTime();}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(56);if ((! isEmpty(m_byoyomiMoves)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(58) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(57);byoyomiMoves =
                    Integer.parseInt(getTextFieldContent(m_byoyomiMoves));}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(59);if ((byoyomi > 0 && byoyomiMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(61) && false))
            {
                $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(60);TimeSettings settings =
                    new TimeSettings(preByoyomi, byoyomi, byoyomiMoves);
                info.setTimeSettings(settings);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(62);TimeSettings settings = new TimeSettings(preByoyomi);
                info.setTimeSettings(settings);
            }
        }
    }

    private boolean validate(Component parent, MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(64);if ((! validateKomi(parent, m_komi, messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(66) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(65);return false;}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(67);if ((! m_preByoyomi.validateTime(parent, messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(69) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(68);return false;}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(70);if ((! m_byoyomi.validateTime(parent, messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(72) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(71);return false;}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(73);if ((! validatePosIntOrEmpty(parent, m_byoyomiMoves,
                                    "MSG_GAMEINFO_INVALID_TIME",
                                    messageDialogs)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(75) && false))
            {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(74);return false;}
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(76);if ((m_byoyomi.isEmpty() != isEmpty(m_byoyomiMoves)) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(78) && false))
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(77);messageDialogs.showError(parent,
                                     i18n("MSG_GAMEINFO_INVALID_BYOYOMI"),
                                     i18n("MSG_GAMEINFO_INVALID_BYOYOMI_2"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(79);return true;
    }

    private boolean validateKomi(Component parent, JTextField textField,
                                 MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(80);String text = getTextFieldContent(textField);
        try
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(81);Komi.parseKomi(text);
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(83);messageDialogs.showError(parent,
                                     i18n("MSG_GAMEINFO_INVALID_KOMI"),
                                     i18n("MSG_GAMEINFO_INVALID_KOMI_2"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(82);return true;
    }

    private boolean validatePosIntOrEmpty(Component parent,
                                          JTextField textField,
                                          String errorMessage,
                                          MessageDialogs messageDialogs)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(84);String content = getTextFieldContent(textField);
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(85);if ((content.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(87) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(86);return true;}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(88);int value = Integer.parseInt(content);
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(89);if ((value <= 0) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(91) && false))
            {
                $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(90);messageDialogs.showError(parent, i18n(errorMessage),
                    i18n("MSG_GAMEINFO_NO_POSITIVE_NUMBER"),
                    false);
                return false;
            }
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(93);messageDialogs.showError(parent, i18n(errorMessage),
                                     i18n("MSG_GAMEINFO_NO_NUMBER"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(92);return true;
    }
}

class TimeField
    extends Box
{
    // See comment at m_comboBox
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TimeField.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8003352424338007646L,/* translation unit id   */ -5921008649632697123L,/* timestamp             */ 1709177902012L,/* source file name      */ "GameInfoDialog.java",/* probe size            */ 117);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}@SuppressWarnings("unchecked")
    public TimeField(int cols, String toolTipText)
    {
        super(BoxLayout.Y_AXIS);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(94);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(Box.createVerticalGlue());
        add(panel);
        add(Box.createVerticalGlue());
        m_textField = new JTextField(cols);
        m_textField.setHorizontalAlignment(SwingConstants.RIGHT);
        m_textField.setToolTipText(i18n(toolTipText));
        panel.add(m_textField);
        panel.add(GuiUtil.createSmallFiller());
        String[] units = { i18n("LB_GAMEINFO_MIN"),
                           i18n("LB_GAMEINFO_SEC") };
        m_comboBox = new JComboBox(units);
        panel.add(m_comboBox);
    }

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(95);return m_textField.getText().trim().equals("");
    }

    public long getTime()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(96);long units;
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(97);if ((m_comboBox.getSelectedIndex() == 0) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(99) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(98);units = 60000;}
            else
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(101);units = 1000;}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(100);return units * Long.parseLong(m_textField.getText().trim());
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(102);return 0;
        }
    }

    public void setTime(long millis)
    {
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(103);long seconds = millis / 1000L;
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(104);if ((seconds % 60 == 0) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(106) && false))
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(105);m_textField.setText(Long.toString(seconds / 60L));
            m_comboBox.setSelectedIndex(0);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(107);m_textField.setText(Long.toString(seconds));
            m_comboBox.setSelectedIndex(1);
        }
    }

    public boolean validateTime(Component parent,
                                MessageDialogs messageDialogs)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(108);if ((isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(110) && false))
                {$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(109);return true;}
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(111);int value = Integer.parseInt(m_textField.getText().trim());
            $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(112);if ((value < 0) ? true : (!$qualityscroll_cover_jacov_probe_add45a0106a0b4dd(114) && false))
            {
                $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(113);messageDialogs.showError(parent,
                                      i18n("MSG_GAMEINFO_INVALID_TIME"),
                                      i18n("MSG_GAMEINFO_NO_POSITIVE_NUMBER"),
                                      false);
                return false;
            }
        }
        catch (NumberFormatException e)
        {
                $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(116);messageDialogs.showError(parent,
                                         i18n("MSG_GAMEINFO_INVALID_TIME"),
                                         i18n("MSG_GAMEINFO_NO_NUMBER"),
                                         false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_add45a0106a0b4dd(115);return true;
    }

    private final JTextField m_textField;

    /** @note JComboBox is a generic type since Java 7. We use a raw type
        and suppress unchecked warnings where needed to be compatible with
        earlier Java versions. */
    private final JComboBox m_comboBox;
}
