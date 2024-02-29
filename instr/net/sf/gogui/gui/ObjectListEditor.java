/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// ObjectListEditor.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static net.sf.gogui.gui.I18n.i18n;

/** Dialog for displaying and editing a list of objects. */
public class ObjectListEditor<OBJECT>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ObjectListEditor.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5611862131557336889L,/* translation unit id   */ -5956622461615673536L,/* timestamp             */ 1709177902621L,/* source file name      */ "ObjectListEditor.java",/* probe size            */ 71);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Edit properties of object. */
    public interface ItemEditor<OBJECT>
    {
        OBJECT editItem(Component parent, OBJECT object,
                        MessageDialogs messageDialogs);

        String getItemLabel(OBJECT object);

        OBJECT cloneItem(OBJECT object);
    }

    public boolean edit(Component parent, String title,
                        ArrayList<OBJECT> objects,
                        ItemEditor<OBJECT> editor,
                        MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(0);m_messageDialogs = messageDialogs;
        m_editor = editor;
        m_actionListener = new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent event) {
                    $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(3);String command = event.getActionCommand();
                    $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(4);if ((command.equals("edit")) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(6) && false))
                        {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(5);cbEdit();}
                    else {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(7);if ((command.equals("move-up")) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(9) && false))
                        {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(8);cbMoveUp();}
                    else {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(10);if ((command.equals("move-down")) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(12) && false))
                        {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(11);cbMoveDown();}
                    else {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(13);if ((command.equals("remove")) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(15) && false))
                        {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(14);cbRemove();}
                    else
                        {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(16);assert false;}}}}
                }
            };
        JPanel panel = new JPanel(new BorderLayout(GuiUtil.PAD, 0));
        m_list = new JList();
        m_list.addListSelectionListener(new ListSelectionListener() {
                @Override
				public void valueChanged(ListSelectionEvent e) {
                    $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(17);selectionChanged();
                }
            });
        m_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int rows = Math.min(Math.max(objects.size(), 8), 15);
        m_list.setVisibleRowCount(rows);
        JScrollPane scrollPane = new JScrollPane(m_list);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(createButtonPanel(), BorderLayout.EAST);
        JOptionPane optionPane = new JOptionPane(panel,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 JOptionPane.OK_CANCEL_OPTION);
        m_objects = new ArrayList<OBJECT>();
        copyObjects(objects, m_objects);
        updateList(((m_objects.isEmpty()) ? ($qualityscroll_cover_jacov_probe_ad55d36e4248ef40(1) || true) : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(2) && false)) ? -1 : 0);
        m_dialog = optionPane.createDialog(parent, title);
        m_dialog.setVisible(true);
        Object value = optionPane.getValue();
        boolean result = true;
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(18);if ((! (value instanceof Integer)
            || ((Integer)value).intValue() != JOptionPane.OK_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(20) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(19);result = false;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(21);m_dialog.dispose();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(22);if ((result) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(24) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(23);copyObjects(m_objects, objects);}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(25);return result;
    }

    private ActionListener m_actionListener;

    private JButton m_edit;

    private JButton m_moveDown;

    private JButton m_moveUp;

    private JButton m_remove;

    /** @note JList is a generic type since Java 7. We use a raw type
        and suppress unchecked warnings where needed to be compatible with
        earlier Java versions. */
    private JList m_list;

    private JDialog m_dialog;

    private ArrayList<OBJECT> m_objects;

    private ItemEditor<OBJECT> m_editor;

    private MessageDialogs m_messageDialogs;

    private void cbMoveDown()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(26);int index = m_list.getSelectedIndex();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(27);if ((index < 0 || index >= m_objects.size() - 1) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(29) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(28);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(30);OBJECT temp = m_objects.get(index);
        m_objects.set(index, m_objects.get(index + 1));
        m_objects.set(index + 1, temp);
        updateList(index + 1);
    }

    private void cbEdit()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(31);int index = m_list.getSelectedIndex();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(32);if ((index == -1) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(34) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(33);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(35);OBJECT object = m_editor.editItem(m_dialog, getObject(index),
                                          m_messageDialogs);
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(36);if ((object == null) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(38) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(37);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(39);m_objects.set(index, object);
        updateList(index);
    }

    private void cbMoveUp()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(40);int index = m_list.getSelectedIndex();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(41);if ((index < 0 || index == 0) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(43) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(42);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(44);OBJECT temp = m_objects.get(index);
        m_objects.set(index, m_objects.get(index - 1));
        m_objects.set(index - 1, temp);
        updateList(index - 1);
    }

    private void cbRemove()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(45);int index = m_list.getSelectedIndex();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(46);if ((index == -1) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(48) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(47);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(49);OBJECT object = getObject(index);
        String name = m_editor.getItemLabel(object);
        String disableKey = "net.sf.gogui.gui.ObjectListEditor.remove";
        String mainMessage =
            MessageFormat.format(i18n("MSG_LISTEDITOR_REALLY_REMOVE"),
                                 name);
        String optionalMessage = i18n("MSG_LISTEDITOR_REALLY_REMOVE_2");
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(50);if ((! m_messageDialogs.showQuestion(disableKey, m_dialog, mainMessage,
                                            optionalMessage,
                                            i18n("LB_REMOVE"), false)) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(52) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(51);return;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(53);m_objects.remove(object);
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(54);if ((index >= m_objects.size()) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(56) && false))
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(55);index = -1;}
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(57);updateList(index);
    }

    private void copyObjects(ArrayList<OBJECT> from, ArrayList<OBJECT> to)
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(58);to.clear();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(59);for (int i = 0; (i < from.size()) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(61) && false); ++i)
            {$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(60);to.add(m_editor.cloneItem(from.get(i)));}
    }

    private JButton createButton(String label, String command)
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(62);JButton button = new JButton(i18n(label));
        button.setEnabled(false);
        button.setActionCommand(command);
        button.addActionListener(m_actionListener);
        return button;
    }

    private JPanel createButtonPanel()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(63);JPanel buttonPanel
            = new JPanel(new GridLayout(0, 1, GuiUtil.PAD, GuiUtil.PAD));
        m_moveUp = createButton("LB_LISTEDITOR_MOVE_UP", "move-up");
        GuiUtil.setMacBevelButton(m_moveUp);
        buttonPanel.add(m_moveUp);
        m_moveDown = createButton("LB_LISTEDITOR_MOVE_DOWN", "move-down");
        GuiUtil.setMacBevelButton(m_moveDown);
        buttonPanel.add(m_moveDown);
        m_edit = createButton("LB_EDIT", "edit");
        GuiUtil.setMacBevelButton(m_edit);
        buttonPanel.add(m_edit);
        m_remove = createButton("LB_REMOVE", "remove");
        GuiUtil.setMacBevelButton(m_remove);
        buttonPanel.add(m_remove);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        return panel;
    }

    private OBJECT getObject(int i)
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(64);return m_objects.get(i);
    }

    private void selectionChanged()
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(65);int index = m_list.getSelectedIndex();
        m_edit.setEnabled(index >= 0);
        m_remove.setEnabled(index >= 0);
        m_moveUp.setEnabled(index >= 1);
        m_moveDown.setEnabled(index < m_objects.size() - 1);
    }

    // See comment at m_list
    @SuppressWarnings("unchecked")
    private void updateList(int selectedIndex)
    {
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(66);ArrayList<String> data = new ArrayList<String>();
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(67);for (int i = 0; (i < m_objects.size()) ? true : (!$qualityscroll_cover_jacov_probe_ad55d36e4248ef40(69) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(68);String name = m_editor.getItemLabel(getObject(i));
            data.add(name);
        }
        $qualityscroll_cover_jacov_probe_ad55d36e4248ef40(70);m_list.setListData(data.toArray());
        m_list.setSelectedIndex(selectedIndex);
        m_list.ensureIndexIsVisible(selectedIndex);
    }
}
