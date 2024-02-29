/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// FileDialogs.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.prefs.Preferences;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.sf.gogui.gamefile.GameFileFilter;
import net.sf.gogui.thumbnail.ThumbnailCreator;
import net.sf.gogui.thumbnail.ThumbnailPlatform;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;
import static net.sf.gogui.gui.I18n.i18n;

/** File dialogs. */
public final class FileDialogs
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = FileDialogs.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3558375391844468238L,/* translation unit id   */ -7973497978625052197L,/* timestamp             */ 1709177901945L,/* source file name      */ "FileDialogs.java",/* probe size            */ 147);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_915871d576c231db(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static File showOpen(Component parent, String title)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(0);return showFileChooser(parent, Type.FILE_OPEN, null, false, title);
    }

    public static File showOpenSgf(Component parent)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(1);return showFileChooser(parent, Type.FILE_OPEN, null, true, null);
    }

    public static File showSave(Component parent, String title,
                                MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(2);return showFileChooserSave(parent, null, false, title,
                                   messageDialogs);
    }

    public static File showSaveSgf(Frame parent,
                                   MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(3);return showFileChooserSave(parent, s_lastFile, true, null,
                                   messageDialogs);
    }

    /** File selection, unknown whether for load or save. */
    public static File showSelectFile(Component parent, String title)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(4);return showFileChooser(parent, Type.FILE_SELECT, s_lastFile, false,
                               title);
    }

    public static void setLastFile(File file)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(5);s_lastFile = file;
    }

    private enum Type
    {
        /** Dialog type for opening a file. */
        FILE_OPEN,

        /** Dialog type for saving to a file. */
        FILE_SAVE,

        /** Dialog type for selecting a file.
            Use this type, if a file name should be selected, but it is not
            known what the file name is used for and if the file already
            exists.
            @deprecated Not supported by native AWT FileDialog */
        FILE_SELECT
    }

    /** Use native AWT-dialogs.
        They are used on Mac OS X because JFileChooser looks too different
        from the native dialogs (Java 1.5), and on Windows because
        JFileChooser is too slow on Windows XP (startup and directory changing
        takes up to 10 sec; Java 1.6) */
    private static final boolean NATIVE_DIALOGS =
        (Platform.isMac() || Platform.isWindows());

    private static File s_lastFile;

    /** Make constructor unavailable; class is for namespace only. */
    private FileDialogs()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_915871d576c231db(6);
    }

    /** Find first parent that is a Frame.
        @return null If no such parent. */
    private static Frame findParentFrame(Component component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(7);while ((component != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(9) && false))
            {$qualityscroll_cover_jacov_probe_915871d576c231db(8);if ((component instanceof Frame) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(12) && false))
                {$qualityscroll_cover_jacov_probe_915871d576c231db(11);return (Frame)component;}
            else
                {$qualityscroll_cover_jacov_probe_915871d576c231db(13);component = component.getParent();}}
        $qualityscroll_cover_jacov_probe_915871d576c231db(10);return null;
    }

    private static File showFileChooser(Component parent, Type type,
                                        File lastFile, boolean setSgfFilter,
                                        String title)
    {$qualityscroll_cover_coverage_buffer_init();
        // Use native dialogs for some platforms. but not for type select
        // There is no native dialog for select
        $qualityscroll_cover_jacov_probe_915871d576c231db(14);if ((NATIVE_DIALOGS && type != Type.FILE_SELECT) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(16) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(15);Frame frame = findParentFrame(parent);
            return showFileChooserAWT(frame, type, title);
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(17);return showFileChooserSwing(parent, type, lastFile, setSgfFilter,
                                    title);
    }

    private static File showFileChooserSave(Component parent,
                                            File lastFile,
                                            boolean setSgfFilter,
                                            String title,
                                            MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(18);File file = showFileChooser(parent, Type.FILE_SAVE, lastFile,
                                    setSgfFilter, title);
        $qualityscroll_cover_jacov_probe_915871d576c231db(19);if ((NATIVE_DIALOGS) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(21) && false))
            // Overwrite warning is already part of FileDialog
            {$qualityscroll_cover_jacov_probe_915871d576c231db(20);return file;}
        $qualityscroll_cover_jacov_probe_915871d576c231db(22);while ((file != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(24) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(23);if ((file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(27) && false))
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(26);String mainMessage =
                    MessageFormat.format(i18n("MSG_REPLACE_FILE"),
                                         file.getName());
                String optionalMessage = i18n("MSG_REPLACE_FILE_2");
                $qualityscroll_cover_jacov_probe_915871d576c231db(28);if ((! messageDialogs.showQuestion(parent, mainMessage,
                                                  optionalMessage,
                                                  i18n("LB_REPLACE"), true)) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(30) && false))
                {
                    $qualityscroll_cover_jacov_probe_915871d576c231db(29);file = showFileChooser(parent, Type.FILE_SAVE, lastFile,
                                           setSgfFilter, title);
                    continue;
                }
            }
            $qualityscroll_cover_jacov_probe_915871d576c231db(31);break;
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(25);return file;
    }

    private static File showFileChooserAWT(Frame parent, Type type,
                                           String title)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(32);FileDialog dialog = new FileDialog(parent);
        $qualityscroll_cover_jacov_probe_915871d576c231db(33);if ((title == null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(35) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(34);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (type)
            {
            case FILE_OPEN:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(36); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_915871d576c231db(39);title = i18n("TIT_OPEN");
                break;
            case FILE_SAVE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(37); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_915871d576c231db(49);title = i18n("TIT_SAVE");
                break;
            default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(38); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_915871d576c231db(50);assert false;
            }
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(40);dialog.setTitle(title);
        int mode = FileDialog.LOAD;
        $qualityscroll_cover_jacov_probe_915871d576c231db(41);if ((type == Type.FILE_SAVE) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(43) && false))
            {$qualityscroll_cover_jacov_probe_915871d576c231db(42);mode = FileDialog.SAVE;}
        $qualityscroll_cover_jacov_probe_915871d576c231db(44);dialog.setMode(mode);
        /* Commented out, because there is no way to change the filter by the
           user (at least not on Linux)
        if (setSgfFilter)
            dialog.setFilenameFilter(new FilenameFilter() {
                    public boolean accept(File dir, String name)
                    {
                        return name.toLowerCase().endsWith("sgf");
                    }
                });
        */
        //dialog.setLocationRelativeTo(parent); // Java <= 1.4
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
        $qualityscroll_cover_jacov_probe_915871d576c231db(45);if ((dialog.getFile() == null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(47) && false))
            {$qualityscroll_cover_jacov_probe_915871d576c231db(46);return null;}
        $qualityscroll_cover_jacov_probe_915871d576c231db(48);return new File(dialog.getDirectory(), dialog.getFile());
    }

    private static File showFileChooserSwing(Component parent, Type type,
                                             File lastFile,
                                             boolean setSgfFilter,
                                             String title)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(51);JFileChooser chooser;
        $qualityscroll_cover_jacov_probe_915871d576c231db(52);if ((s_lastFile == null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(54) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(53);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(56) && false))
                // user.dir is application directory on Mac, which is bad
                // I have not found a way to set it to user home in Info.plist
                // so I use null here, which sets is to the user home
                {$qualityscroll_cover_jacov_probe_915871d576c231db(55);chooser = new JFileChooser((String)null);}
            else
                {$qualityscroll_cover_jacov_probe_915871d576c231db(85);chooser = new JFileChooser(System.getProperty("user.dir"));}
        }
        else
            {$qualityscroll_cover_jacov_probe_915871d576c231db(86);chooser = new JFileChooser(s_lastFile);}
        $qualityscroll_cover_jacov_probe_915871d576c231db(57);chooser.setMultiSelectionEnabled(false);
        javax.swing.filechooser.FileFilter filter = new GameFileFilter();
        chooser.addChoosableFileFilter(filter);
        $qualityscroll_cover_jacov_probe_915871d576c231db(58);if ((setSgfFilter) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(60) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(59);chooser.setFileFilter(filter);
            $qualityscroll_cover_jacov_probe_915871d576c231db(61);if ((ThumbnailPlatform.checkThumbnailSupport()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(63) && false))
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(62);SgfPreview preview = new SgfPreview();
                chooser.setAccessory(preview);
                chooser.addPropertyChangeListener(preview);
            }
        }
        else
            {$qualityscroll_cover_jacov_probe_915871d576c231db(84);chooser.setFileFilter(chooser.getAcceptAllFileFilter());}
        $qualityscroll_cover_jacov_probe_915871d576c231db(64);if ((type == Type.FILE_SAVE) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(66) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(65);if ((lastFile != null && lastFile.isFile() && lastFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(68) && false))
                {$qualityscroll_cover_jacov_probe_915871d576c231db(67);chooser.setSelectedFile(lastFile);}
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(69);if ((title != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(71) && false))
            {$qualityscroll_cover_jacov_probe_915871d576c231db(70);chooser.setDialogTitle(title);}
        $qualityscroll_cover_jacov_probe_915871d576c231db(72);int ret;
        $qualityscroll_cover_jacov_probe_915871d576c231db(73);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (type)
        {
        case FILE_SAVE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(74); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_915871d576c231db(77);ret = chooser.showSaveDialog(parent);
            break;
        case FILE_OPEN:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(75); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_915871d576c231db(82);ret = chooser.showOpenDialog(parent);
            break;
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_915871d576c231db(76); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_915871d576c231db(83);ret = chooser.showDialog(parent, i18n("TIT_SELECT"));
            break;
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(78);if ((ret != JFileChooser.APPROVE_OPTION) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(80) && false))
            {$qualityscroll_cover_jacov_probe_915871d576c231db(79);return null;}
        $qualityscroll_cover_jacov_probe_915871d576c231db(81);File file = chooser.getSelectedFile();
        s_lastFile = file;
        return file;
    }
}

class SgfPreview
    extends JPanel
    implements PropertyChangeListener
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfPreview.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3558375391844468238L,/* translation unit id   */ -7973497978625052197L,/* timestamp             */ 1709177901945L,/* source file name      */ "FileDialogs.java",/* probe size            */ 147);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_915871d576c231db(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public SgfPreview()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(87);setLayout(new BorderLayout());
        JPanel previewPanel = new JPanel();
        previewPanel.setBorder(GuiUtil.createEmptyBorder());
        previewPanel.setLayout(new BoxLayout(previewPanel, BoxLayout.Y_AXIS));
        previewPanel.add(Box.createVerticalGlue());
        Dimension dimension = new Dimension(140, 140);
        previewPanel.setPreferredSize(dimension);
        add(previewPanel);
        m_imagePanel = new ImagePanel();
        previewPanel.add(m_imagePanel);
        previewPanel.add(Box.createVerticalGlue());
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        m_auto = new JCheckBox(i18n("LB_AUTOMATIC_PREVIEW"));
        m_auto.setSelected(m_prefs.getBoolean("auto-preview", false));
        m_auto.addChangeListener(new ChangeListener() {
                @Override
				public void stateChanged(ChangeEvent e) {
                    $qualityscroll_cover_jacov_probe_915871d576c231db(88);boolean isSelected = m_auto.isSelected();
                    m_prefs.putBoolean("auto-preview", isSelected);
                    $qualityscroll_cover_jacov_probe_915871d576c231db(89);if ((isSelected) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(91) && false))
                        {$qualityscroll_cover_jacov_probe_915871d576c231db(90);preview();}
                } });
        buttonPanel.add(m_auto);
        m_preview = new JButton(i18n("LB_PREVIEW"));
        m_preview.setActionCommand("preview");
        m_preview.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent event) {
                    $qualityscroll_cover_jacov_probe_915871d576c231db(92);if ((event.getActionCommand().equals("preview")) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(94) && false))
                        {$qualityscroll_cover_jacov_probe_915871d576c231db(93);preview();}
                } });
        m_preview.setEnabled(false);
        buttonPanel.add(m_preview);
    }

    @Override
	public void propertyChange(PropertyChangeEvent event)
    {
        $qualityscroll_cover_jacov_probe_915871d576c231db(95);String propertyName = event.getPropertyName();
        $qualityscroll_cover_jacov_probe_915871d576c231db(96);if ((propertyName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(98) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(97);m_file = null;
            m_preview.setEnabled(false);
            File file = (File)event.getNewValue();
            $qualityscroll_cover_jacov_probe_915871d576c231db(99);if ((file != null && ! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(101) && false)) // user entered new filename
                {$qualityscroll_cover_jacov_probe_915871d576c231db(100);file = null;}
            $qualityscroll_cover_jacov_probe_915871d576c231db(102);if ((file != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(104) && false))
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(103);String name = file.getAbsolutePath();
                $qualityscroll_cover_jacov_probe_915871d576c231db(105);if ((name == null
                    || ! (name.toLowerCase(Locale.ENGLISH).endsWith(".sgf")
                          || name.toLowerCase(Locale.ENGLISH).endsWith(".xml"))) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(107) && false))
                    {$qualityscroll_cover_jacov_probe_915871d576c231db(106);file = null;}
            }
            $qualityscroll_cover_jacov_probe_915871d576c231db(108);m_file = file;
            $qualityscroll_cover_jacov_probe_915871d576c231db(109);if ((file != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(111) && false))
                {$qualityscroll_cover_jacov_probe_915871d576c231db(110);m_preview.setEnabled(true);}
            $qualityscroll_cover_jacov_probe_915871d576c231db(112);if ((m_auto.isSelected()) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(114) && false))
                {$qualityscroll_cover_jacov_probe_915871d576c231db(113);preview();}
        }
    }

    private class ImagePanel
        extends JPanel
    {
        public ImagePanel()
        {$qualityscroll_cover_coverage_buffer_init();
            // Image size is 128x128
            $qualityscroll_cover_jacov_probe_915871d576c231db(115);Dimension dimension = new Dimension(140, 140);
            setPreferredSize(dimension);
            setMaximumSize(dimension);
        }

        @Override
		public void paintComponent(Graphics graphics)
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(116);graphics.setColor(getBackground());
            graphics.fillRect(0, 0, getWidth(), getHeight());
            $qualityscroll_cover_jacov_probe_915871d576c231db(117);if ((m_image != null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(119) && false))
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(118);int imageWidth = m_image.getWidth(null);
                int imageHeight = m_image.getHeight(null);
                int x = (getWidth() - imageWidth) / 2;
                int y = (getHeight() - imageHeight) / 2;
                graphics.drawImage(m_image, x, y, imageWidth, imageHeight,
                                   null);
            }
        }
    }

    private File m_file;

    private File m_lastFailure;

    private String m_lastError;

    private final JButton m_preview;

    private final JCheckBox m_auto;

    private Image m_image;

    private final ImagePanel m_imagePanel;

    private final ThumbnailCreator m_thumbnailCreator
        = new ThumbnailCreator(false);

    private final Preferences m_prefs =
        Preferences.userNodeForPackage(getClass());

    private static final Image MISSING_IMAGE =
        GuiUtil.getIcon("image-missing", i18n("LB_NO_PREVIEW")).getImage();

    public void preview()
    {
        $qualityscroll_cover_jacov_probe_915871d576c231db(120);if ((m_file == null) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(122) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(121);m_image = null;
            m_imagePanel.setToolTipText(null);
        }
        else {$qualityscroll_cover_jacov_probe_915871d576c231db(124);if ((m_file.equals(m_lastFailure)) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(126) && false))
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(125);m_image = MISSING_IMAGE;
            m_imagePanel.setToolTipText(m_lastError);
        }
        else
        {
            try
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(127);if ((m_file.length() > 500000) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(129) && false))
                    {$qualityscroll_cover_jacov_probe_915871d576c231db(128);throw new ThumbnailCreator.Error(i18n("MSG_TOO_LARGE_FOR_PREVIEW"));}
                $qualityscroll_cover_jacov_probe_915871d576c231db(130);m_thumbnailCreator.create(m_file);
                File thumbnail = m_thumbnailCreator.getLastThumbnail();
                m_image = loadImage(thumbnail);
                String description = m_thumbnailCreator.getLastDescription();
                $qualityscroll_cover_jacov_probe_915871d576c231db(131);if ((! StringUtil.isEmpty(description)) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(133) && false))
                    {$qualityscroll_cover_jacov_probe_915871d576c231db(132);m_imagePanel.setToolTipText(description);}
                else
                    {$qualityscroll_cover_jacov_probe_915871d576c231db(134);m_imagePanel.setToolTipText(null);}
            }
            catch (ErrorMessage e)
            {
                $qualityscroll_cover_jacov_probe_915871d576c231db(135);m_image = MISSING_IMAGE;
                m_lastError = e.getMessage();
                $qualityscroll_cover_jacov_probe_915871d576c231db(136);if ((m_lastError != null && m_lastError.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_915871d576c231db(138) && false))
                    {$qualityscroll_cover_jacov_probe_915871d576c231db(137);m_lastError = null;}
                $qualityscroll_cover_jacov_probe_915871d576c231db(139);m_imagePanel.setToolTipText(m_lastError);
                m_lastFailure = m_file;
            }
        }}
        $qualityscroll_cover_jacov_probe_915871d576c231db(123);m_imagePanel.repaint();
        m_preview.setEnabled(false);
    }

    private static Image loadImage(File file)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_915871d576c231db(140);URL url;
        try
        {
            // File.toURL() is deprecated in Java 1.6
            $qualityscroll_cover_jacov_probe_915871d576c231db(141);url = file.toURI().toURL();
        }
        catch (MalformedURLException e)
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(146);assert false; // Cannot happen
            return null;
        }
        // Don't use Toolkit.getImage(). It caches images, which would cause old
        // thumbnails to be shown, if a file was modified, saved and opened in
        // the same session of GoGui
        $qualityscroll_cover_jacov_probe_915871d576c231db(142);Image image = Toolkit.getDefaultToolkit().createImage(url);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        try
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(143);mediaTracker.waitForID(0);
        }
        catch (InterruptedException e)
        {
            $qualityscroll_cover_jacov_probe_915871d576c231db(145);return null;
        }
        $qualityscroll_cover_jacov_probe_915871d576c231db(144);return image;
    }
}
