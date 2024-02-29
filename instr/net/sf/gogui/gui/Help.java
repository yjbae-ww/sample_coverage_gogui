/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// Help.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.Platform;

/** Window for displaying help in HTML format.
    The window is a JFrame on all platforms but the Mac, where it is a
    parent-less JDialog (to avoid the brushed-metal look, which shouldn't be
    used for the help window) */
public class Help
    implements ActionListener, HyperlinkListener
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Help.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1488507242177391899L,/* translation unit id   */ 5651689337337976825L,/* timestamp             */ 1709177902538L,/* source file name      */ "Help.java",/* probe size            */ 58);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Help(URL contents, MessageDialogs messageDialogs,
                String title)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(0);m_messageDialogs = messageDialogs;
        m_contents = contents;
        Container contentPane;
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(1);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(3) && false))
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(2);JDialog dialog = new JDialog((Frame)null, title);
            contentPane = dialog.getContentPane();
            m_window = dialog;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(9);JFrame frame = new JFrame(title);
            GuiUtil.setGoIcon(frame);
            contentPane = frame.getContentPane();
            m_window = frame;
        }
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(4);JPanel panel = new JPanel(new BorderLayout());
        contentPane.add(panel);
        panel.add(createButtons(), BorderLayout.NORTH);
        m_editorPane = new JEditorPane();
        m_editorPane.setEditable(false);
        m_editorPane.addHyperlinkListener(this);
        int width = GuiUtil.getDefaultMonoFontSize() * 50;
        int height = GuiUtil.getDefaultMonoFontSize() * 60;
        JScrollPane scrollPane =
            new JScrollPane(m_editorPane,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(5);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(7) && false))
            // Default Apple L&F uses no border, but Quaqua 3.7.4 does
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(6);scrollPane.setBorder(null);}
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(8);scrollPane.setPreferredSize(new Dimension(width, height));
        panel.add(scrollPane, BorderLayout.CENTER);
        m_window.pack();
        loadURL(m_contents);
        appendHistory(m_contents);
    }

    @Override
	public void actionPerformed(ActionEvent event)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(10);String command = event.getActionCommand();
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(11);if ((command.equals("back")) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(13) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(12);back();}
        else {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(14);if ((command.equals("close")) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(16) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(15);m_window.setVisible(false);}
        else {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(17);if ((command.equals("contents")) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(19) && false))
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(18);loadURL(m_contents);
            appendHistory(m_contents);
        }
        else {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(20);if ((command.equals("forward")) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(22) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(21);forward();}}}}
    }

    public Window getWindow()
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(23);return m_window;
    }

    @Override
	public void hyperlinkUpdate(HyperlinkEvent e)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(24);if ((e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(26) && false))
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(25);URL url = e.getURL();
            String protocol = url.getProtocol();
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(27);if ((protocol.equals("jar") || protocol.equals("file")) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(29) && false))
            {
                $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(28);loadURL(url);
                appendHistory(url);
            }
            else
                {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(30);openExternal(url);}
        }
    }

    private int m_historyIndex = -1;

    private JButton m_buttonBack;

    private JButton m_buttonForward;

    private final JEditorPane m_editorPane;

    private java.util.List<URL> m_history = new ArrayList<URL>();

    private final URL m_contents;

    private final MessageDialogs m_messageDialogs;

    private final Window m_window;

    private void appendHistory(URL url)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(31);if ((m_historyIndex >= 0 && historyEquals(m_historyIndex, url)) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(33) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(32);return;}
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(34);if ((m_historyIndex + 1 < m_history.size()) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(36) && false))
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(35);if ((! historyEquals(m_historyIndex + 1, url)) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(38) && false))
            {
                $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(37);m_history = m_history.subList(0, m_historyIndex + 1);
                m_history.add(url);
            }
        }
        else
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(40);m_history.add(url);}
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(39);++m_historyIndex;
        historyChanged();
    }

    private void back()
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(41);assert m_historyIndex > 0;
        assert m_historyIndex < m_history.size();
        --m_historyIndex;
        loadURL(getHistory(m_historyIndex));
        historyChanged();
    }

    private JComponent createButtons()
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(42);JToolBar toolBar = new JToolBar();
        toolBar.add(createToolBarButton("go-home", "contents", "TT_HELP_TOC"));
        m_buttonBack = createToolBarButton("go-previous", "back",
                                           "TT_HELP_BACK");
        toolBar.add(m_buttonBack);
        m_buttonForward = createToolBarButton("go-next", "forward",
                                              "TT_HELP_FORWARD");
        toolBar.add(m_buttonForward);
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(43);if ((! Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(45) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(44);toolBar.setRollover(true);}
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(46);toolBar.setFloatable(false);
        return toolBar;
    }

    private JButton createToolBarButton(String icon, String command,
                                        String toolTip)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(47);JButton button = new JButton();
        button.setActionCommand(command);
        button.setToolTipText(i18n(toolTip));
        button.addActionListener(this);
        button.setIcon(GuiUtil.getIcon(icon, command));
        button.setFocusable(false);
        return button;
    }

    private void forward()
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(48);assert m_historyIndex + 1 < m_history.size();
        ++m_historyIndex;
        loadURL(getHistory(m_historyIndex));
        historyChanged();
    }

    private URL getHistory(int index)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(49);return m_history.get(index);
    }

    private void historyChanged()
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(50);boolean backPossible = (m_historyIndex > 0);
        boolean forwardPossible = (m_historyIndex < m_history.size() - 1);
        m_buttonBack.setEnabled(backPossible);
        m_buttonForward.setEnabled(forwardPossible);
    }

    private boolean historyEquals(int index, URL url)
    {
        // Compare as strings to avoid Findbugs warning about potentially
        // blocking URL.equals()
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(51);return getHistory(index).toString().equals(url.toString());
    }

    private void loadURL(URL url)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(52);m_editorPane.setPage(url);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(53);String mainMessage =
                MessageFormat.format("MSG_HELP_LOAD_FAILURE", url.toString());
            m_messageDialogs.showError(m_window, mainMessage, e.getMessage(),
                                       false);
        }
    }

    /** Open URL in external browser if possible.
        If it doesn't work, the URL is opened inside this dialog. */
    private void openExternal(URL url)
    {
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(54);if ((! Platform.openInExternalBrowser(url)) ? true : (!$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(56) && false))
            {$qualityscroll_cover_jacov_probe_4e6ed58224e497f9(55);loadURL(url);}
        $qualityscroll_cover_jacov_probe_4e6ed58224e497f9(57);appendHistory(url);
    }
}
