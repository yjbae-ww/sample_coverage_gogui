/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// BookmarkEditor.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static net.sf.gogui.gui.I18n.i18n;

/** Dialog for displaying and editing a bookmark. */
public class BookmarkEditor
    implements ObjectListEditor.ItemEditor<Bookmark>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BookmarkEditor.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 352286628081381173L,/* translation unit id   */ -2164490847590811791L,/* timestamp             */ 1709177901851L,/* source file name      */ "BookmarkEditor.java",/* probe size            */ 42);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}@Override
	public Bookmark editItem(Component parent, Bookmark object,
                             MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(0);return editItem(parent, i18n("TIT_BOOKMARKEDITOR"),
                        object, false, messageDialogs);
    }

    public Bookmark editItem(Component parent, String title,
                             Bookmark bookmark, boolean selectName,
                             MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(1);JPanel panel = new JPanel(new BorderLayout(GuiUtil.SMALL_PAD, 0));
        m_panelLeft = new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        panel.add(m_panelLeft, BorderLayout.WEST);
        m_panelRight =
            new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        panel.add(m_panelRight, BorderLayout.CENTER);
        m_name = createEntry("LB_BOOKMARKEDITOR_NAME", 25, bookmark.m_name);
        String file = "";
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(2);if ((bookmark.m_file != null) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(4) && false))
            {$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(3);file = bookmark.m_file.toString();}
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(5);m_file = createEntry("LB_BOOKMARKEDITOR_FILE", 25, file);
        String move = "";
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(6);if ((bookmark.m_move > 0) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(8) && false))
            {$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(7);move = Integer.toString(bookmark.m_move);}
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(9);m_move = createEntry("LB_BOOKMARKEDITOR_MOVE", 10, move);
        m_variation = createEntry("LB_BOOKMARKEDITOR_VARIATION", 10,
                                  bookmark.m_variation);
        JOptionPane optionPane = new JOptionPane(panel,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(parent, title);
        boolean done = false;
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(10);while ((! done) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(12) && false))
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(11);if ((selectName) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(15) && false))
                {$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(14);m_name.selectAll();}
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(16);dialog.addWindowListener(new WindowAdapter() {
                    @Override
					public void windowActivated(WindowEvent e) {
                        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(17);m_name.requestFocusInWindow();
                    }
                });
            dialog.setVisible(true);
            Object value = optionPane.getValue();
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(18);if ((! (value instanceof Integer)
                || ((Integer)value).intValue() != JOptionPane.OK_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(20) && false))
                {$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(19);return null;}
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(21);done = validate(parent, messageDialogs);
        }
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(13);String newName = m_name.getText().trim();
        File newFile = new File(m_file.getText());
        int newMove = getMove();
        String newVariation = m_variation.getText().trim();
        Bookmark newBookmark =
            new Bookmark(newName, newFile, newMove, newVariation);
        dialog.dispose();
        return newBookmark;
    }

    @Override
	public String getItemLabel(Bookmark object)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(22);return object.m_name;
    }

    @Override
	public Bookmark cloneItem(Bookmark object)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(23);return new Bookmark(object);
    }

    private JPanel m_panelLeft;

    private JPanel m_panelRight;

    private JTextField m_name;

    private JTextField m_file;

    private JTextField m_move;

    private JTextField m_variation;

    private JTextField createEntry(String labelText, int cols, String text)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(24);Box boxLabel = Box.createHorizontalBox();
        boxLabel.add(Box.createHorizontalGlue());
        JLabel label = new JLabel(i18n(labelText));
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        boxLabel.add(label);
        m_panelLeft.add(boxLabel);
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JTextField field = new JTextField(cols);
        field.setText(text);
        fieldPanel.add(field);
        m_panelRight.add(fieldPanel);
        return field;
    }

    private int getMove()
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(25);String text = m_move.getText().trim();
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(26);if ((text.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(28) && false))
            {$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(27);return 0;}
        try
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(29);return Integer.parseInt(text);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(30);return -1;
        }
    }

    private boolean validate(Component parent, MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(31);if ((m_name.getText().trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(33) && false))
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(32);messageDialogs.showError(parent,
                                     i18n("MSG_BOOKMARKEDITOR_EMPTYNAME"),
                                     i18n("MSG_BOOKMARKEDITOR_EMPTYNAME_2"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(34);if ((getMove() < 0) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(36) && false))
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(35);messageDialogs.showError(parent,
                                     i18n("MSG_BOOKMARKEDITOR_INVALIDMOVE"),
                                     i18n("MSG_BOOKMARKEDITOR_INVALIDMOVE_2"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(37);File file = new File(m_file.getText().trim());
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(38);if ((! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(40) && false))
        {
            $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(39);messageDialogs.showError(parent,
                                     i18n("MSG_BOOKMARKEDITOR_FILENOTEXIST"),
                                     i18n("MSG_BOOKMARKEDITOR_FILENOTEXIST_2"),
                                     false);
            return false;
        }
        $qualityscroll_cover_jacov_probe_e1f62f0ac5c3f771(41);return true;
    }
}
