/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// MessageDialogs.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.util.TreeSet;
import java.util.Set;
import java.util.prefs.Preferences;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static net.sf.gogui.gui.I18n.i18n;
import static net.sf.gogui.gui.GuiUtil.insertLineBreaks;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.PrefUtil;
import net.sf.gogui.util.StringUtil;

/** Simple message dialogs. */
public final class MessageDialogs
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = MessageDialogs.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2468092957456748899L,/* translation unit id   */ 2240837306563027278L,/* timestamp             */ 1709177902600L,/* source file name      */ "MessageDialogs.java",/* probe size            */ 118);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1f190da86921e14e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public MessageDialogs()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_1f190da86921e14e(0);
    }

    public void showError(Component frame, String mainMessage,
                          String optionalMessage)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(1);showError(frame, mainMessage, optionalMessage, true);
    }

    public void showError(Component frame, String mainMessage,
                          String optionalMessage, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(2);int type;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(3);if ((isCritical) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(5) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(4);type = JOptionPane.ERROR_MESSAGE;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(7);type = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(6);Object[] options = { i18n("LB_CLOSE") };
        Object defaultOption = options[0];
        show(null, frame, "", mainMessage, optionalMessage, type,
             JOptionPane.DEFAULT_OPTION, options, defaultOption, -1);
    }

    public void showError(Component frame, String message, Exception e)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(8);showError(frame, message, e, true);
    }

    public void showError(Component frame, String message, Exception e,
                          boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(9);showError(frame, message, StringUtil.getErrorMessage(e), isCritical);
    }

    public void showInfo(Component frame, String mainMessage,
                         String optionalMessage, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(10);showInfo(null, frame, mainMessage, optionalMessage, isCritical);
    }

    public void showInfo(String disableKey, Component frame,
                         String mainMessage, String optionalMessage,
                         boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(11);if ((checkDisabled(disableKey)) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(13) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(12);return;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(14);int type;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(15);if ((isCritical) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(17) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(16);type = JOptionPane.INFORMATION_MESSAGE;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(19);type = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(18);Object[] options = { i18n("LB_CLOSE") };
        Object defaultOption = options[0];
        show(disableKey, frame, "", mainMessage, optionalMessage,
             type, JOptionPane.DEFAULT_OPTION, options, defaultOption, -1);
    }

    public int showYesNoCancelQuestion(Component parent, String mainMessage,
                                       String optionalMessage,
                                       String destructiveOption,
                                       String nonDestructiveOption)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(20);return showYesNoCancelQuestion(null, parent, mainMessage,
                                       optionalMessage, destructiveOption,
                                       nonDestructiveOption);
    }

    /** Show a question with two options and cancel.
        @return 0 for the destructive option; 1 for the non-destructive
        option; 2 for cancel */
    public int showYesNoCancelQuestion(String disableKey, Component parent,
                                       String mainMessage,
                                       String optionalMessage,
                                       String destructiveOption,
                                       String nonDestructiveOption)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(21);if ((checkDisabled(disableKey)) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(23) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(22);return 0;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(24);Object[] options = new Object[3];
        int destructiveIndex;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(25);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(27) && false))
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(26);options[0] = nonDestructiveOption;
            options[1] = i18n("LB_CANCEL");
            options[2] = destructiveOption;
            destructiveIndex = 2;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(37);options[0] = nonDestructiveOption;
            options[1] = destructiveOption;
            options[2] = i18n("LB_CANCEL");
            destructiveIndex = -1;
        }
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(28);Object defaultOption = options[0];
        int type = JOptionPane.QUESTION_MESSAGE;
        Object value = show(disableKey, parent, "", mainMessage,
                            optionalMessage, type,
                            JOptionPane.YES_NO_CANCEL_OPTION, options,
                            defaultOption, destructiveIndex);
        int result;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(29);if ((value == destructiveOption) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(31) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(30);result = 0;}
        else {$qualityscroll_cover_jacov_probe_1f190da86921e14e(33);if ((value == nonDestructiveOption) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(35) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(34);result = 1;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(36);result = 2;}}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(32);return result;
    }

    public void showWarning(Component parent, String mainMessage,
                            String optionalMessage, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(38);showWarning(null, parent, mainMessage, optionalMessage, isCritical);
    }

    public void showWarning(String disableKey, Component parent,
                            String mainMessage, String optionalMessage,
                            boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(39);if ((checkDisabled(disableKey)) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(41) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(40);return;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(42);int type;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(43);if ((isCritical) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(45) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(44);type = JOptionPane.WARNING_MESSAGE;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(47);type = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(46);Object[] options = { i18n("LB_CLOSE") };
        Object defaultOption = options[0];
        show(disableKey, parent, "", mainMessage, optionalMessage, type,
             JOptionPane.DEFAULT_OPTION, options, defaultOption, -1);
    }

    public boolean showQuestion(Component parent, String mainMessage,
                                String optionalMessage,
                                String destructiveOption, boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(48);return showQuestion(null, parent, mainMessage, optionalMessage,
                            destructiveOption, isCritical);
    }

    public boolean showQuestion(String disableKey, Component parent,
                                String mainMessage,
                                String optionalMessage,
                                String destructiveOption,
                                boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(49);return showQuestion(disableKey, parent, mainMessage, optionalMessage,
                            destructiveOption, i18n("LB_CANCEL"),
                            isCritical);
    }

    /** Show warning message to confirm destructive actions.
        @return true, if destructive was chosen; false if cancel was
        chosen. */
    public boolean showQuestion(String disableKey, Component parent,
                                String mainMessage,
                                String optionalMessage,
                                String affirmativeOption,
                                String cancelOption,
                                boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(50);if ((checkDisabled(disableKey)) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(52) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(51);return true;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(53);Object[] options = new Object[2];
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(54);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(56) && false))
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(55);options[0] = cancelOption;
            options[1] = affirmativeOption;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(63);options[0] = affirmativeOption;
            options[1] = cancelOption;
        }
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(57);Object defaultOption = affirmativeOption;
        int type;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(58);if ((isCritical) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(60) && false))
            // No reason to show a warning icon for confirmation dialogs
            // of frequent actions
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(59);type = JOptionPane.QUESTION_MESSAGE;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(62);type = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(61);Object result = show(disableKey, parent, "", mainMessage,
                             optionalMessage, type, JOptionPane.YES_NO_OPTION,
                             options, defaultOption, -1);
        return (result == affirmativeOption);
    }

    public boolean showWarningQuestion(Component parent, String mainMessage,
                                       String optionalMessage,
                                       String destructiveOption,
                                       boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(64);return showWarningQuestion(null, parent, mainMessage, optionalMessage,
                                   destructiveOption, isCritical);
    }

    public boolean showWarningQuestion(String disableKey, Component parent,
                                       String mainMessage,
                                       String optionalMessage,
                                       String destructiveOption,
                                       boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(65);return showWarningQuestion(disableKey, parent, mainMessage,
                                   optionalMessage, destructiveOption,
                                   i18n("LB_CANCEL"), isCritical);
    }

    /** Show warning message to confirm destructive actions.
        @return true, if destructive was chosen; false if cancel was chosen. */
    public boolean showWarningQuestion(String disableKey, Component parent,
                                       String mainMessage,
                                       String optionalMessage,
                                       String destructiveOption,
                                       String nonDestructiveOption,
                                       boolean isCritical)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(66);if ((checkDisabled(disableKey)) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(68) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(67);return true;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(69);Object[] options = new Object[2];
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(70);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(72) && false))
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(71);options[0] = nonDestructiveOption;
            options[1] = destructiveOption;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(79);options[0] = destructiveOption;
            options[1] = nonDestructiveOption;
        }
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(73);Object defaultOption = nonDestructiveOption;
        int type;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(74);if ((isCritical) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(76) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(75);type = JOptionPane.WARNING_MESSAGE;}
        else
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(78);type = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(77);Object result = show(disableKey, parent, "", mainMessage,
                             optionalMessage, type, JOptionPane.YES_NO_OPTION,
                             options, defaultOption, -1);
        return (result == destructiveOption);
    }

    private final Set<String> m_disabled = new TreeSet<String>();

    private static void addFiller(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(80);Box.Filler filler = GuiUtil.createFiller();
        filler.setAlignmentX(Component.LEFT_ALIGNMENT);
        component.add(filler);
    }

    private boolean checkDisabled(String disableKey)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(81);if ((disableKey == null) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(83) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(82);return false;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(84);Preferences prefs =
            PrefUtil.createNode("net/sf/gogui/gui/messagedialogs/disabled");
        boolean permanentlyDisabled = prefs.getBoolean(disableKey, false);
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(85);if ((permanentlyDisabled) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(87) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(86);return true;}
        // Make sure this entry exists (right now these settings can only
        // be directly edited in the backing store)
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(88);prefs.putBoolean(disableKey, permanentlyDisabled);
        return m_disabled.contains(disableKey);
    }

    private Object show(String disableKey, Component parent, String title,
                        String mainMessage, String optionalMessage,
                        int messageType, int optionType, Object[] options,
                        Object defaultOption, int destructiveIndex)
    {
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(89);if ((optionalMessage == null) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(91) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(90);optionalMessage = "";}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(92);boolean isMac = Platform.isMac();
        Box box = Box.createVerticalBox();

        String css = GuiUtil.getMessageCss();

        JLabel label =
            new JLabel("<html>" + css + "<b>" + insertLineBreaks(mainMessage)
                       + "</b><p>"
                       + insertLineBreaks(optionalMessage) + "</p>");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(label);

        addFiller(box);
        addFiller(box);
        JCheckBox disableCheckBox = null;
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(93);if ((disableKey != null) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(95) && false))
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(94);if ((messageType == JOptionPane.QUESTION_MESSAGE) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(97) && false))
                {$qualityscroll_cover_jacov_probe_1f190da86921e14e(96);disableCheckBox = new JCheckBox(i18n("LB_DO_NOT_ASK_AGAIN"));}
            else {$qualityscroll_cover_jacov_probe_1f190da86921e14e(114);if ((messageType == JOptionPane.WARNING_MESSAGE) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(116) && false))
                {$qualityscroll_cover_jacov_probe_1f190da86921e14e(115);disableCheckBox =
                    new JCheckBox(i18n("LB_DO_NOT_WARN_AGAIN"));}
            else
                {$qualityscroll_cover_jacov_probe_1f190da86921e14e(117);disableCheckBox =
                    new JCheckBox(i18n("LB_DO_NOT_SHOW_AGAIN"));}}
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(98);disableCheckBox.setToolTipText(i18n("TT_DO_NOT_SHOW_AGAIN"));
            disableCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
            box.add(disableCheckBox);
        }
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(99);if ((isMac) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(101) && false))
            // Don't show icons on Mac, problem with icon generation in
            // Quaqua 3.7.2
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(100);messageType = JOptionPane.PLAIN_MESSAGE;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(102);JOptionPane optionPane =
            new JOptionPane(box, messageType, optionType, null, options,
                            defaultOption);
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(103);if ((destructiveIndex >= 0) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(105) && false))
        {
            $qualityscroll_cover_jacov_probe_1f190da86921e14e(104);String key = "Quaqua.OptionPane.destructiveOption";
            optionPane.putClientProperty(key,
                                         Integer.valueOf(destructiveIndex));
        }
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(106);if ((isMac && parent.isVisible()) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(108) && false))
            // Dialogs don't have titles on the Mac
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(107);title = null;}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(109);JDialog dialog = optionPane.createDialog(parent, title);
        dialog.setVisible(true);
        dialog.dispose();
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(110);if ((disableKey != null && disableCheckBox.isSelected()) ? true : (!$qualityscroll_cover_jacov_probe_1f190da86921e14e(112) && false))
            {$qualityscroll_cover_jacov_probe_1f190da86921e14e(111);m_disabled.add(disableKey);}
        $qualityscroll_cover_jacov_probe_1f190da86921e14e(113);return optionPane.getValue();
    }
}
