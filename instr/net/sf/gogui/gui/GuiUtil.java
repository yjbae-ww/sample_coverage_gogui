/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiUtil.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.ProgressShow;

/** GUI utility classes and static functions. */
public class GuiUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6865687916172766731L,/* translation unit id   */ 7936824572243757208L,/* timestamp             */ 1709177902492L,/* source file name      */ "GuiUtil.java",/* probe size            */ 154);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Runnable for running protected by modal progress dialog.
        @see #runProgress */
    public interface ProgressRunnable
    {
        /** Function to run.
            The function is expected to call ProgressShow.showProgress
            regularly to indicate progress made. */
        void run(ProgressShow progressShow) throws Throwable;
    }

    /** Constant used for padding in dialogs. */
    public static final int PAD = 5;

    /** Constant used for small padding in dialogs. */
    public static final int SMALL_PAD = 2;

    public static void addStyle(JTextPane pane, String name, Color foreground,
                                Color background)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(0);StyledDocument doc = pane.getStyledDocument();
        StyleContext context = StyleContext.getDefaultStyleContext();
        Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
        Style style = doc.addStyle(name, defaultStyle);
        StyleConstants.setForeground(style, foreground);
        StyleConstants.setBackground(style, background);
    }

    public static void copyToClipboard(String text)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(1);StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner owner = new ClipboardOwner() {
                @Override
				public void lostOwnership(Clipboard clipboard,
                                          Transferable contents)
                {
                }
            };
        clipboard.setContents(selection, owner);
    }

    /** Wrapper object for JComboBox items.
        JComboBox can have focus and keyboard navigation problems if duplicate
        String objects are added. See JDK 1.5 doc for JComboBox.addItem. */
    public static Object createComboBoxItem(final String item)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(2);return new Object() {
                @Override
				public String toString() {
                    $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(3);return item; } };
    }

    /** Create empty border with normal padding.
        @see #PAD */
    public static Border createEmptyBorder()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(4);return EMPTY_BORDER;
    }

    /** Create empty box with size of normal padding.
        @see #PAD */
    public static Box.Filler createFiller()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(5);return new Box.Filler(FILLER_DIMENSION, FILLER_DIMENSION,
                              FILLER_DIMENSION);
    }

    /** Create empty border with small padding.
        @see #SMALL_PAD */
    public static Border createSmallEmptyBorder()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(6);return SMALL_EMPTY_BORDER;
    }

    /** Create empty box with size of small padding.
        @see #SMALL_PAD */
    public static Box.Filler createSmallFiller()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(7);return new Box.Filler(SMALL_FILLER_DIMENSION, SMALL_FILLER_DIMENSION,
                              SMALL_FILLER_DIMENSION);
    }

    public static String getClipboardText()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(8);Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable content = clipboard.getContents(null);
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(9);if ((content == null
            || ! content.isDataFlavorSupported(DataFlavor.stringFlavor)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(11) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(10);return null;}
        try
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(12);return (String)content.getTransferData(DataFlavor.stringFlavor);
        }
        catch (UnsupportedFlavorException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(13);return null;
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(14);return null;
        }
    }

    /** Return a style sheet for message labels using HTML.
        @return A string with a HTML-head tag containing a style tag
        with formatting options or an empty string. */
    public static String getMessageCss()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(15);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(17) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(16);return
                "<head><style type=\"text/css\">" +
                "b { font: 13pt \"Lucida Grande\" }" +
                "p { font: 11pt \"Lucida Grande\"; margin-top: 8px }" +
                "</style></head>";}
        else
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(18);return
                "<head><style type=\"text/css\">" +
                "p { margin-top: 8px }" +
                "</style></head>";}
    }

    /** Get size of default monspaced font.
        Can be used for setting the initial size of some GUI elements. */
    public static int getDefaultMonoFontSize()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(19);return MONOSPACED_FONT.getSize();
    }

    public static ImageIcon getIcon(String icon, String name)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(20);String resource = "net/sf/gogui/images/" + icon + ".png";
        URL url = GuiUtil.class.getClassLoader().getResource(resource);
        return new ImageIcon(url, name);
    }

    /** Init look and feel.
        If parameter is empty string, no initialization will be done.
        If parameter is null, try to use plasticxp (jwindows on Windows), but
        don't show an error message, if it fails.
        Otherwise use parameter as class name or shortcut as decoumented
        in the GoGui reference, and show message on failure. */
    public static void initLookAndFeel(String laf)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(21);if ((laf == null
            || (! laf.equals("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")
                && ! laf.equals("gtk"))) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(23) && false))
        {
            // Disables renaming mode in Sun Java 1.5, which makes using the
            // JFileChooser a pain and is also enabled for open dialogs for no
            // good reason. Unfortunately that sacrifices the new directory
            // button, which is useful for save dialogs
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(22);UIManager.put("FileChooser.readOnly", Boolean.TRUE);
        }
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(24);if (("".equals(laf) || "default".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(26) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(25);return;}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(27);boolean showError = true;
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(28);if ((laf == null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(30) && false))
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(29);showError = false;
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(31);if ((Platform.isWindows()) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(33) && false))
                {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(32);laf = "system";}
            else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(60);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(62) && false))
                {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(61);laf = "quaqua";}
            else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(63);if ((Platform.isUnix()) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(65) && false))
                {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(64);laf = "system";}
            else
                {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(66);return;}}}
        }
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(34);if (("cross".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(36) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(35);laf = UIManager.getCrossPlatformLookAndFeelClassName();}
        else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(45);if (("gtk".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(47) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(46);laf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";}
        else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(48);if (("motif".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(50) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(49);laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";}
        else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(51);if (("quaqua".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(53) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(52);laf = "ch.randelshofer.quaqua.QuaquaLookAndFeel";}
        else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(54);if (("system".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(56) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(55);laf = UIManager.getSystemLookAndFeelClassName();}
        else {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(57);if (("windows".equals(laf)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(59) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(58);laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";}}}}}}
        try
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(37);UIManager.setLookAndFeel(laf);
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(38);if ((laf.equals("ch.randelshofer.quaqua.QuaquaLookAndFeel")) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(40) && false))
            {
                // Auto-generation of badged icons does not work in Quaqua
                // 3.7.2 (the GoGui app icon shows filled white), and Apple
                // style guide says that alert icons badged with app icon
                // should be used only in rare cases anyway
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(39);Object icon = LookAndFeel.makeIcon(GuiUtil.class,
                                                   "gogui-64x64.png");
                UIManager.put("OptionPane.errorIcon", icon);
                UIManager.put("OptionPane.informationIcon", icon);
                UIManager.put("OptionPane.questionIcon", icon);
                UIManager.put("OptionPane.warningIcon", icon);
            }
        }
        catch (ClassNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(41);handleLookAndFeelError(showError, laf);

        }
        catch (InstantiationException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(42);handleLookAndFeelError(showError, laf);

        }
        catch (IllegalAccessException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(43);handleLookAndFeelError(showError, laf);

        }
        catch (UnsupportedLookAndFeelException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(44);handleLookAndFeelError(showError, laf);

        }
    }

    /** Manually break message into multiple lines for multi-line labels.
        Needed for multi-line messages in option panes, because pack() on
        JOptionPane does not compute the option pane size correctly, if a
        maximum width is set and the label text is automatically broken into
        multiple lines. The workaround with calling invalidate() and pack() a
        second time does not work either in this case. See also Sun Bug ID
        4545951 (still in Linux JDK 1.5.0_04-b05 or Mac 1.4.2_12) */
    public static String insertLineBreaks(String message)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(67);final int MAX_CHAR_PER_LINE = 72;
        int length = message.length();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(68);if ((length < MAX_CHAR_PER_LINE) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(70) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(69);return message;}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(71);StringBuilder buffer = new StringBuilder();
        int startLine = 0;
        int lastWhiteSpace = -1;
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(72);for (int pos = 0; (pos < length) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(74) && false); ++pos)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(73);char c = message.charAt(pos);
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(79);if ((pos - startLine > 72) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(81) && false))
            {
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(80);int endLine =
                    (((lastWhiteSpace > startLine) ? ($qualityscroll_cover_jacov_probe_6e2543e5b92e4898(82) || true) : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(83) && false)) ? lastWhiteSpace : pos);
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(84);if ((buffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(86) && false))
                    {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(85);buffer.append("<br>");}
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(87);buffer.append(message.substring(startLine, endLine));
                startLine = endLine;
            }
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(88);if ((Character.isWhitespace(c)) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(90) && false))
                {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(89);lastWhiteSpace = pos;}
        }
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(75);if ((buffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(77) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(76);buffer.append("<br>");}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(78);buffer.append(message.substring(startLine));
        return buffer.toString();
    }

    /** Call SwingUtilities.invokeAndWait.
        Ignores possible exceptions (apart from printing a warning to
        System.err */
    public static void invokeAndWait(Runnable runnable)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(91);SwingUtilities.invokeAndWait(runnable);
        }
        catch (InterruptedException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(92);System.err.println("Thread interrupted");
        }
        catch (java.lang.reflect.InvocationTargetException e)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(93);System.err.println("InvocationTargetException");
        }
    }

    public static boolean isActiveWindow(Window window)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(94);KeyboardFocusManager manager =
            KeyboardFocusManager.getCurrentKeyboardFocusManager();
        return (manager.getActiveWindow() == window);
    }

    /** Check window for normal state.
        Checks if window is not maximized (in either or both directions) and
        not iconified. */
    public static boolean isNormalSizeMode(JFrame window)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(95);int state = window.getExtendedState();
        int mask = Frame.MAXIMIZED_BOTH | Frame.MAXIMIZED_VERT
            | Frame.MAXIMIZED_HORIZ | Frame.ICONIFIED;
        return ((state & mask) == 0);
    }

    public static void paintImmediately(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(96);component.paintImmediately(component.getVisibleRect());
    }

    public static void removeKeyBinding(JComponent component, String key)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(97);int condition = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        InputMap inputMap = component.getInputMap(condition);
        // According to the docs, null should remove the action, but it does
        // not seem to work with Sun Java 1.4.2, new Object() works
        inputMap.put(KeyStroke.getKeyStroke(key), new Object());
    }

    /** Run in separate thread protected by a modal progress dialog.
        Replacement for javax.swing.ProgressMonitor, which does not create
        a modal dialog.
        Ensures that the GUI gets repaint events while the runnable is
        running, but cannot get other events and displays a progress bar
        as a user feedback.
        The progress dialog is displayed for at least one second.
        @param owner Parent for the progress dialog.
        @param message Title for the progress dialog.
        @param runnable Runnable to run.
        @throws Throwable Any exception that ProgressRunnable.run throwed,
        you have to use instanceof to check for specific exception classes. */
    public static void runProgress(Frame owner, String message,
                                   ProgressRunnable runnable)
        throws Throwable
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(98);assert SwingUtilities.isEventDispatchThread();
        JDialog dialog = new JDialog(owner, message, true);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);
        JProgressBar progressBar = new JProgressBar(0, 100);
        //progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        JPanel panel = new JPanel();
        panel.setBorder(createSmallEmptyBorder());
        panel.add(progressBar);
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(owner);
        ProgressThread thread =
            new ProgressThread(dialog, runnable, progressBar);
        thread.start();
        dialog.setVisible(true);
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(99);if ((thread.getThrowable() != null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(101) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(100);throw thread.getThrowable();}
    }

    /** Set antialias rendering hint if graphics is instance of Graphics2D. */
    public static void setAntiAlias(Graphics graphics)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(102);if ((graphics instanceof Graphics2D) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(104) && false))
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(103);Graphics2D graphics2D = (Graphics2D)graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
        }
    }

    /** Set text field non-editable.
        Also sets it non-focusable. */
    public static void setEditableFalse(JTextField field)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(105);field.setEditable(false);
        field.setFocusable(false);
    }

    /** Set Go icon on frame. */
    public static void setGoIcon(Frame frame)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(106);URL url = s_iconURL;
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(107);if ((url != null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(109) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(108);frame.setIconImage(new ImageIcon(url).getImage());}
    }

    /** Parse text that has the mnemonic marked with a preceding'&amp;'
        (like in Qt) and set the text and mnemonic of the button. */
    public static void setTextAndMnemonic(AbstractButton button, String text)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(110);int pos = text.indexOf('&');
        text = text.replace("&", "");
        button.setText(text);
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(111);if ((pos >= 0 && pos < text.length()) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(113) && false))
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(112);String mnemonic = text.substring(pos, pos + 1).toUpperCase();
            KeyStroke keyStroke = KeyStroke.getKeyStroke(mnemonic);
            int code = keyStroke.getKeyCode();
            button.setMnemonic(code);
            button.setDisplayedMnemonicIndex(pos);
        }
    }

    /** Set property to render button in bevel style on the Mac.
        Only has an effect if Quaqua Look and Feel is used. */
    public static void setMacBevelButton(JButton button)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(114);button.putClientProperty("Quaqua.Button.style", "bevel");
        // Works since Apple Java 5
        button.putClientProperty("JButton.buttonType", "bevel");
    }

    public static void setMonospacedFont(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(115);if ((MONOSPACED_FONT != null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(117) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(116);component.setFont(MONOSPACED_FONT);}
    }

    public static void addStyle(JTextPane textPane, String name,
                                Color foreground)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(118);addStyle(textPane, name, foreground, null, false);
    }

    public static void addStyle(JTextPane textPane, String name,
                                Color foreground, Color background,
                                boolean bold)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(119);StyledDocument doc = textPane.getStyledDocument();
        StyleContext context = StyleContext.getDefaultStyleContext();
        Style def = context.getStyle(StyleContext.DEFAULT_STYLE);
        Style style = doc.addStyle(name, def);
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(120);if ((foreground != null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(122) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(121);StyleConstants.setForeground(style, foreground);}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(123);if ((background != null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(125) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(124);StyleConstants.setBackground(style, background);}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(126);StyleConstants.setBold(style, bold);
    }

    public static void setStyle(JTextPane textPane, int start, int length,
                                String name)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(127);StyledDocument doc = textPane.getStyledDocument();
        Style style;
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(128);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(130) && false))
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(129);StyleContext context = StyleContext.getDefaultStyleContext();
            style = context.getStyle(StyleContext.DEFAULT_STYLE);
        }
        else
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(132);style = doc.getStyle(name);}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(131);doc.setCharacterAttributes(start, length, style, true);
    }

    public static void setUnlimitedSize(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(133);Dimension size = new Dimension(Short.MAX_VALUE, Short.MAX_VALUE);
        component.setMaximumSize(size);
    }

    static
    {
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(153);ClassLoader loader = ClassLoader.getSystemClassLoader();
        // There are problems on some platforms with transparency (e.g. Linux
        // Sun Java 1.5.0). Best solution for now is to take an icon without
        // transparency
        s_iconURL =
            loader.getResource("net/sf/gogui/images/gogui-48x48-notrans.png");
    }

    private static class ProgressThread
        extends Thread
        implements ProgressShow
    {
        public ProgressThread(Dialog dialog, ProgressRunnable runnable,
                              JProgressBar progressBar)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(134);m_dialog = dialog;
            m_runnable = runnable;
            m_progressBar = progressBar;
        }

        public Throwable getThrowable()
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(135);return m_throwable;
        }

        @Override
		public void run()
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(136);long startTime = System.currentTimeMillis();
            try
            {
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(137);m_runnable.run(this);
            }
            catch (Throwable t)
            {
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(146);m_throwable = t;
            }
            // Show progress dialog for at least 1 sec
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(138);long timeDiff = System.currentTimeMillis() - startTime;
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(139);if ((timeDiff < 1000) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(141) && false))
            {
                $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(140);try
                {
                    $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(142);Thread.sleep(1000 - timeDiff);
                }
                catch (InterruptedException e)
                {
                    $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(145);assert false;
                }
            }
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(143);SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
					public void run()
                    {
                        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(144);m_dialog.dispose();
                    }
                });
        }

        @Override
		public void showProgress(int percent)
        {
            $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(147);m_percent = percent;
            SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
					public void run()
                    {
                        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(148);m_progressBar.setValue(m_percent);
                    }
                });
        }

        private int m_percent;

        private final Dialog m_dialog;

        private final JProgressBar m_progressBar;

        private final ProgressRunnable m_runnable;

        private Throwable m_throwable;
    }

    private static final Font MONOSPACED_FONT = Font.decode("Monospaced");

    private static final Border EMPTY_BORDER =
        BorderFactory.createEmptyBorder(PAD, PAD, PAD, PAD);

    private static final Border SMALL_EMPTY_BORDER =
        BorderFactory.createEmptyBorder(SMALL_PAD, SMALL_PAD,
                                        SMALL_PAD, SMALL_PAD);

    private static final Dimension FILLER_DIMENSION =
        new Dimension(PAD, PAD);

    private static final Dimension SMALL_FILLER_DIMENSION =
        new Dimension(SMALL_PAD, SMALL_PAD);

    private static URL s_iconURL;

    private static void handleLookAndFeelError(boolean showError, String laf)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(149);if ((! showError) ? true : (!$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(151) && false))
            {$qualityscroll_cover_jacov_probe_6e2543e5b92e4898(150);return;}
        $qualityscroll_cover_jacov_probe_6e2543e5b92e4898(152);MessageDialogs messageDialogs = new MessageDialogs();
        messageDialogs.showWarning(null,
                                   i18n("MSG_LAF_ERROR"),
                                   MessageFormat.format(i18n("MSG_LAF_ERROR_2"),
                                                        laf),
                                   false);
    }
}
