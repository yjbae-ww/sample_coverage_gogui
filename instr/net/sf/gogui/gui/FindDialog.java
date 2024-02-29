/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// FindDialog.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.text.MessageFormat.format;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.PrefUtil;
import net.sf.gogui.util.StringUtil;

/** Dialog for entering a search pattern. */
public class FindDialog
    extends JDialog
    implements ActionListener
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = FindDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8079704971656257031L,/* translation unit id   */ 6712413173434742700L,/* timestamp             */ 1709177901980L,/* source file name      */ "FindDialog.java",/* probe size            */ 47);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_5d274837a43af7ac(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public FindDialog(Frame owner, String initialValue)
    {
        super(owner, i18n("TIT_FIND"), true);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_5d274837a43af7ac(0);
        m_initialValue = initialValue;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.add(createPanel(), BorderLayout.CENTER);
        contentPane.add(createButtons(), BorderLayout.SOUTH);
        pack();
    }

    // See comment at m_comboBox
    @Override
	@SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent event)
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(1);String command = event.getActionCommand();
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(2);if ((command.equals("cancel")) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(4) && false))
            {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(3);dispose();}
        else {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(5);if ((command.equals("comboBoxEdited") || command.equals("find")) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(7) && false))
        {
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(6);m_pattern = m_comboBox.getSelectedItem().toString();
            m_comboBox.insertItemAt(m_pattern, 0);
            putHistory();
            dispose();
        }}
    }

    public void keyPressed(KeyEvent e)
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(8);if ((e.getKeyCode() == KeyEvent.VK_ESCAPE
            && ! m_comboBox.isPopupVisible()) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(10) && false))
            {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(9);dispose();}
    }

    public static Pattern run(Frame owner, String initialValue,
                              MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(11);while (true)
        {
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(12);FindDialog dialog = new FindDialog(owner, initialValue);
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
            String regex = dialog.m_pattern;
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(14);if ((StringUtil.isEmpty(regex)) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(16) && false))
                {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(15);return null;}
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(17);int flags = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE;
            try
            {
                $qualityscroll_cover_jacov_probe_5d274837a43af7ac(18);return Pattern.compile(regex, flags);
            }
            catch (PatternSyntaxException e)
            {
                $qualityscroll_cover_jacov_probe_5d274837a43af7ac(19);String mainMessage = i18n("MSG_FINDDIALOG_INVALID_PATTERN");
                String optionalMessage =
                    format(i18n("MSG_FINDDIALOG_INVALID_PATTERN_2"),
                           e.getDescription());
                messageDialogs.showError(owner, mainMessage, optionalMessage,
                                         false);
                initialValue = regex;
            }
        }
    }

    /** @note JComboBox is a generic type since Java 7. We use a raw type
        and suppress unchecked warnings where needed to be compatible with
        earlier Java versions. */
    private JComboBox m_comboBox;

    private JTextField m_textField;

    private final String m_initialValue;

    private String m_pattern;

    private JPanel createButtons()
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(20);JPanel innerPanel = new JPanel(new GridLayout(1, 0, GuiUtil.PAD, 0));
        innerPanel.setBorder(GuiUtil.createEmptyBorder());
        JButton findButton = new JButton(i18n("LB_FIND"));
        findButton.setActionCommand("find");
        findButton.addActionListener(this);
        findButton.setMnemonic(KeyEvent.VK_F);
        getRootPane().setDefaultButton(findButton);
        innerPanel.add(findButton);
        JButton cancelButton = new JButton(i18n("LB_CANCEL"));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);
        cancelButton.setMnemonic(KeyEvent.VK_C);
        innerPanel.add(cancelButton);
        JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        outerPanel.add(innerPanel);
        return outerPanel;
    }

    private JPanel createPanel()
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(21);JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(GuiUtil.createEmptyBorder());
        JLabel label = new JLabel(i18n("LB_FIND_SEARCH_PATTERN"));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(label);
        panel.add(createInputPanel());
        return panel;
    }

    // See comment at m_comboBox
    @SuppressWarnings("unchecked")
    private JPanel createInputPanel()
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(22);JPanel outerPanel = new JPanel(new BorderLayout());
        JPanel innerPanel = new JPanel(new BorderLayout());
        m_comboBox = new JComboBox(getHistory().toArray());
        StringBuilder prototype = new StringBuilder(70);
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(23);for (int i = 0; (i < 40) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(25) && false); ++i)
            {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(24);prototype.append('-');}
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(26);m_comboBox.setPrototypeDisplayValue(prototype.toString());
        m_comboBox.setEditable(true);
        ComboBoxEditor editor = m_comboBox.getEditor();
        m_comboBox.addActionListener(this);
        m_textField = (JTextField)editor.getEditorComponent();
        m_textField.selectAll();
        KeyListener keyListener = new KeyAdapter()
            {
                @Override
				public void keyPressed(KeyEvent e)
                {
                    $qualityscroll_cover_jacov_probe_5d274837a43af7ac(27);int c = e.getKeyCode();
                    $qualityscroll_cover_jacov_probe_5d274837a43af7ac(28);if ((c == KeyEvent.VK_ESCAPE
                        && ! m_comboBox.isPopupVisible()) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(30) && false))
                        {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(29);dispose();}
                }
            };
        m_textField.addKeyListener(keyListener);
        GuiUtil.setMonospacedFont(m_comboBox);
        innerPanel.add(m_comboBox, BorderLayout.CENTER);
        outerPanel.add(innerPanel, BorderLayout.NORTH);
        return outerPanel;
    }

    private void putHistory()
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(31);ArrayList<String> history = new ArrayList<String>(32);
        int maxHistory = 20;
        int itemCount = m_comboBox.getItemCount();
        int n = itemCount;
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(32);if ((n > maxHistory) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(34) && false))
            {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(33);n = maxHistory;}
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(35);for (int i = 0; (i < n) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(37) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(36);String element = m_comboBox.getItemAt(i).toString().trim();
            $qualityscroll_cover_jacov_probe_5d274837a43af7ac(39);if ((! history.contains(element)) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(41) && false))
                {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(40);history.add(element);}
        }
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(38);PrefUtil.putList("net/sf/gogui/gui/finddialog", history);
    }

    private ArrayList<String> getHistory()
    {
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(42);ArrayList<String> result
            = PrefUtil.getList("net/sf/gogui/gui/finddialog");
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(43);if ((m_initialValue != null) ? true : (!$qualityscroll_cover_jacov_probe_5d274837a43af7ac(45) && false))
            {$qualityscroll_cover_jacov_probe_5d274837a43af7ac(44);result.add(0, m_initialValue);}
        $qualityscroll_cover_jacov_probe_5d274837a43af7ac(46);return result;
    }
}
