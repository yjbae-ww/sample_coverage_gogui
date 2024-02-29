/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// ProgramEditor.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static net.sf.gogui.gui.GuiUtil.insertLineBreaks;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.StringUtil;

/** Dialog for displaying and editing a program. */
public class ProgramEditor
    implements ObjectListEditor.ItemEditor<Program>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ProgramEditor.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6888014368526003119L,/* translation unit id   */ -6778766873626800950L,/* timestamp             */ 1709177902678L,/* source file name      */ "ProgramEditor.java",/* probe size            */ 77);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}@Override
	public Program editItem(Component parent, Program object,
                           MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(0);return editItem(parent, i18n("TIT_PROGRAMEDIT"),
                        object, false, false, messageDialogs);
    }

    /** Edit an instance of Program.
        @param parent Parent component for message dialog
        @param title Title for this dialog
        @param program Program instance to edit
        @param editOnlyCommand Show and edit only command and working directory
        (as a first step, such that name, version and suggested label can be
        set after querying the program)
        @param editOnlyLabel Edit only the label (show the other information
        non-editable)
        @param messageDialogs Message dialog manager */
    public Program editItem(Component parent, String title, Program program,
                            boolean editOnlyCommand, boolean editOnlyLabel,
                            MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(1);m_editOnlyCommand = editOnlyCommand;
        m_editOnlyLabel = editOnlyLabel;
        JPanel panel = new JPanel(new BorderLayout(GuiUtil.SMALL_PAD, 0));
        Box box = null;
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(2);if ((editOnlyCommand || editOnlyLabel) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(4) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(3);box = Box.createVerticalBox();
            panel.add(box, BorderLayout.NORTH);
            String mainMessage;
            String optionalMessage;
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(5);if ((editOnlyCommand) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(7) && false))
            {
                $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(6);mainMessage = i18n("MSG_PROGRAMEDIT_EDIT_COMMAND");
                optionalMessage = i18n("MSG_PROGRAMEDIT_EDIT_COMMAND_2");
            }
            else
            {
                $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(38);mainMessage = i18n("MSG_PROGRAMEDIT_EDIT_LABEL");
                optionalMessage = i18n("MSG_PROGRAMEDIT_EDIT_LABEL_2");
            }
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(8);String css = GuiUtil.getMessageCss();
            JLabel label =
                new JLabel("<html>" + css + "<b>"
                           + insertLineBreaks(mainMessage) + "</b><p>"
                           + insertLineBreaks(optionalMessage) + "</p>");
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            box.add(label);

            addFiller(box);
            addFiller(box);
            addFiller(box);
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(9);m_panelLeft = new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        panel.add(m_panelLeft, BorderLayout.WEST);
        m_panelRight = new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        panel.add(m_panelRight, BorderLayout.CENTER);
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(10);if ((! editOnlyCommand) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(12) && false))
            {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(11);m_label = createEntry("LB_PROGRAMEDIT_LABEL", 20, program.m_label);}
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(13);m_command = createFileEntry("LB_PROGRAMEDIT_COMMAND",
                                    program.m_command,
                                    "TT_PROGRAMEDIT_COMMAND",
                                    "TIT_PROGRAMEDIT_COMMAND",
                                    ! m_editOnlyLabel);
        m_workingDirectory = createEntry("LB_PROGRAMEDIT_DIR",
                                         30, program.m_workingDirectory,
                                         ! m_editOnlyLabel);
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(14);if ((! editOnlyCommand) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(16) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(15);m_name = createEntry("LB_PROGRAMEDIT_NAME", 20, program.m_name,
                                 false);
            m_version = createEntry("LB_PROGRAMEDIT_VERSION", 20,
                                    program.m_version, false);
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(17);JOptionPane optionPane = new JOptionPane(panel,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 JOptionPane.OK_CANCEL_OPTION);
        m_dialog = optionPane.createDialog(parent, title);
        m_dialog.addWindowListener(new WindowAdapter() {
                @Override
				public void windowActivated(WindowEvent e) {
                    $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(18);if ((m_label == null) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(20) && false))
                        {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(19);m_command.requestFocusInWindow();}
                    else
                        {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(21);m_label.requestFocusInWindow();}
                }
            });
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(22);if ((box != null) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(24) && false))
        {
            // Workaround for Sun Bug ID 4545951 (still in Linux JDK
            // 1.5.0_04-b05 or Mac 1.4.2_12)
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(23);box.invalidate();
            m_dialog.pack();
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(25);boolean done = false;
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(26);while ((! done) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(28) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(27);m_dialog.setVisible(true);
            Object value = optionPane.getValue();
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(34);if ((! (value instanceof Integer)
                || ((Integer)value).intValue() != JOptionPane.OK_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(36) && false))
                {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(35);return null;}
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(37);done = validate(parent, messageDialogs);
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(29);String newLabel = "";
        String newName = "";
        String newVersion = "";
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(30);if ((! editOnlyCommand) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(32) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(31);newLabel = m_label.getText().trim();
            newName = m_name.getText().trim();
            newVersion = m_version.getText().trim();
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(33);String newCommand = m_command.getText().trim();
        String newWorkingDirectory = m_workingDirectory.getText().trim();
        Program newProgram = new Program(newLabel, newName, newVersion,
                                         newCommand, newWorkingDirectory);
        m_dialog.dispose();
        return newProgram;
    }

    @Override
	public String getItemLabel(Program object)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(39);return object.m_label;
    }

    @Override
	public Program cloneItem(Program object)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(40);return new Program(object);
    }

    private JPanel m_panelLeft;

    private JPanel m_panelRight;

    private JTextField m_label;

    private JTextField m_name;

    private JTextField m_version;

    private JTextField m_command;

    private JTextField m_workingDirectory;

    private JDialog m_dialog;

    private boolean m_editOnlyCommand;

    private boolean m_editOnlyLabel;

    private static void addFiller(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(41);Box.Filler filler = GuiUtil.createFiller();
        filler.setAlignmentX(Component.LEFT_ALIGNMENT);
        component.add(filler);
    }

    private JTextField createEntry(String labelText, int cols, String text)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(42);return createEntry(labelText, cols, text, true);
    }

    private JTextField createEntry(String labelText, int cols, String text,
                                   boolean editable)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(43);JComponent label = createEntryLabel(labelText);
        m_panelLeft.add(label);
        Box box = Box.createVerticalBox();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        box.add(Box.createVerticalGlue());
        box.add(panel);
        box.add(Box.createVerticalGlue());
        JTextField field = new JTextField(cols);
        field.setText(text);
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(44);if ((! editable) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(46) && false))
            {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(45);GuiUtil.setEditableFalse(field);}
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(47);panel.add(field);
        m_panelRight.add(box);
        return field;
    }

    private JComponent createEntryLabel(String text)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(48);Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        JLabel label = new JLabel(i18n(text));
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        box.add(label);
        return box;
    }

    private JTextField createFileEntry(String label, String text,
                                       String browseToolTip,
                                       final String title,
                                       boolean editable)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(49);m_panelLeft.add(createEntryLabel(label));
        Box box = Box.createVerticalBox();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        box.add(Box.createVerticalGlue());
        box.add(panel);
        box.add(Box.createVerticalGlue());
        final JTextField field = new JTextField(30);
        field.setText(text);
        panel.add(field);
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(50);if ((editable) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(52) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(51);panel.add(GuiUtil.createSmallFiller());
            JButton button = new JButton();
            panel.add(button);
            button.setIcon(GuiUtil.getIcon("document-open-16x16",
                                           i18n("LB_BROWSE")));
            GuiUtil.setMacBevelButton(button);
            button.setToolTipText(i18n(browseToolTip));
            button.addActionListener(new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent e) {
                        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(53);File file =
                            FileDialogs.showOpen(m_dialog, i18n(title));
                        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(54);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(56) && false))
                            {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(55);return;}
                        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(57);String text = file.toString();
                        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(58);if ((text.indexOf(' ') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(60) && false))
                            {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(59);text = "\"" + text + "\"";}
                        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(61);field.setText(text);
                        field.setCaretPosition(text.length());
                        field.requestFocusInWindow();
                    }
                });
        }
        else
            {$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(63);GuiUtil.setEditableFalse(field);}
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(62);m_panelRight.add(box);
        return field;
    }

    private boolean validate(Component parent, MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(64);if ((! m_editOnlyCommand) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(66) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(65);if ((StringUtil.isEmpty(m_label.getText())) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(68) && false))
            {
                $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(67);String mainMessage = i18n("MSG_PROGRAMEDIT_EMPTY_LABEL");
                String optionalMessage = i18n("MSG_PROGRAMEDIT_EMPTY_LABEL_2");
                messageDialogs.showError(parent, mainMessage, optionalMessage,
                                         false);
                return false;
            }
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(69);if ((m_command.getText().trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(71) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(70);String mainMessage = i18n("MSG_PROGRAMEDIT_EMPTY_COMMAND");
            String optionalMessage = i18n("MSG_PROGRAMEDIT_EMPTY_COMMAND_2");
            messageDialogs.showError(parent, mainMessage, optionalMessage,
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(72);String workingDirectory = m_workingDirectory.getText().trim();
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(73);if ((! workingDirectory.equals("")
            && ! new File(workingDirectory).isDirectory()) ? true : (!$qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(75) && false))
        {
            $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(74);String mainMessage = i18n("MSG_PROGRAMEDIT_INVALID_DIR");
            String optionalMessage = i18n("MSG_PROGRAMEDIT_INVALID_DIR_2");
            messageDialogs.showError(parent, mainMessage, optionalMessage,
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_a1ecfb71a24a0cca(76);return true;
    }
}
