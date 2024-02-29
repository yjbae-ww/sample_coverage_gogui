/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// AboutDialog.java

package net.sf.gogui.gogui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.net.URL;
import static java.text.MessageFormat.format;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.EditorKit;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.GuiUtil;
import net.sf.gogui.gui.MessageDialogs;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.XmlUtil;
import net.sf.gogui.version.Version;

/** About dialog for GoGui. */
public final class AboutDialog
    extends JOptionPane
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = AboutDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2954188254233832640L,/* translation unit id   */ -1878354027567389925L,/* timestamp             */ 1709177900610L,/* source file name      */ "AboutDialog.java",/* probe size            */ 56);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void show(Component parent, String name, String version,
                            String command, MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(0);AboutDialog aboutDialog = new AboutDialog(name, version, command,
                                                  messageDialogs);
        JDialog dialog = aboutDialog.createDialog(parent, i18n("TIT_ABOUT"));
        // Workaround for Sun Bug ID 4545951 (still in Linux JDK 1.5.0_04-b05)
        aboutDialog.m_tabbedPane.invalidate();
        dialog.pack();
        dialog.setVisible(true);
        dialog.dispose();
    }

    private final JTabbedPane m_tabbedPane;

    private final MessageDialogs m_messageDialogs;

    private AboutDialog(String name, String version, String command,
                        MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(1);m_messageDialogs = messageDialogs;
        m_tabbedPane = new JTabbedPane();
        boolean isProgramAvailable = (name != null && ! name.equals(""));
        int tabIndex = 0;
        m_tabbedPane.add(i18n("LB_GOGUI"), createPanelGoGui());
        m_tabbedPane.setMnemonicAt(tabIndex, KeyEvent.VK_G);
        m_tabbedPane.setSelectedIndex(tabIndex);
        ++tabIndex;
        JPanel programPanel;
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(2);if ((isProgramAvailable) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(4) && false))
        {
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(3);int width = GuiUtil.getDefaultMonoFontSize() * 25;
            String versionInfo = "";
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(5);if ((version != null && ! version.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(7) && false))
            {
                $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(6);if ((version.length() > 40) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(9) && false))
                    {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(8);version = version.substring(0, 40) + "...";}
                $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(10);versionInfo = "<p align=\"center\" width=\"" + width + "\">"
                    + XmlUtil.escapeText(format(i18n("MSG_ABOUT_VERSION"), version))
                    + "</p>";
            }
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(11);programPanel =
                createPanel("<p align=\"center\"><img src=\""
                            + getImage("gogui-program.png") + "\"></p>" +
                            "<p align=\"center\" width=\"" + width + "\"><b>"
                            + XmlUtil.escapeText(name) + "</b></p>" +
                            versionInfo +
                            "<p align=\"center\" width=\"" + width + "\">"
                            + XmlUtil.escapeText(i18n("MSG_ABOUT_COMMAND"))
                            + "<br>" + command + "</p>");
        }
        else
            {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(13);programPanel = new JPanel();}
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(12);m_tabbedPane.add(i18n("LB_ABOUT_PROGRAM"), programPanel);
        m_tabbedPane.setMnemonicAt(tabIndex, KeyEvent.VK_P);
        m_tabbedPane.setEnabledAt(tabIndex, isProgramAvailable);
        ++tabIndex;
        m_tabbedPane.add(i18n("LB_ABOUT_JAVA"), createPanelJava());
        m_tabbedPane.setMnemonicAt(tabIndex, KeyEvent.VK_J);
        ++tabIndex;
        setMessage(m_tabbedPane);
        Object[] options = { i18n("LB_CLOSE") };
        setOptions(options);
    }

    private JPanel createPanel(String text)
    {
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(14);JPanel panel = new JPanel(new GridLayout(1, 1));
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBorder(GuiUtil.createEmptyBorder());
        editorPane.setEditable(false);
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(15);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(17) && false))
        {
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(16);editorPane.setForeground(UIManager.getColor("Label.foreground"));
            editorPane.setBackground(UIManager.getColor("Label.background"));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(26);editorPane.setForeground(Color.black);
            editorPane.setBackground(Color.white);
        }
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(18);panel.add(editorPane);
        EditorKit editorKit =
            JEditorPane.createEditorKitForContentType("text/html");
        editorPane.setEditorKit(editorKit);
        editorPane.setText(text);
        editorPane.addHyperlinkListener(new HyperlinkListener()
            {
                @Override
				public void hyperlinkUpdate(HyperlinkEvent event)
                {
                    $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(19);HyperlinkEvent.EventType type = event.getEventType();
                    $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(20);if ((type == HyperlinkEvent.EventType.ACTIVATED) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(22) && false))
                    {
                        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(21);URL url = event.getURL();
                        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(23);if ((! Platform.openInExternalBrowser(url)) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(25) && false))
                            {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(24);m_messageDialogs.showError(null,
                                                       i18n("MSG_ABOUT_OPEN_URL_FAIL"),
                                                       "", false);}
                    }
                }
            });
        return panel;
    }

    private JPanel createPanelGoGui()
    {
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(27);URL imageUrl = getImage("project-support.png");
        String projectUrl = "http://gogui.sf.net";
        String supportUrl =
            "https://www.paypal.com/cgi-bin/webscr?item_name=Donation+to+GoGui&cmd=_donations&business=enz%40users.sourceforge.net";
        return createPanel("<p align=\"center\"><img src=\""
                           + getImage("gogui-48x48.png") + "\"></p>" +
                           "<p align=\"center\"><b>" +
                           XmlUtil.escapeText(i18n("LB_GOGUI"))
                           + "</b></p>" +
                           "<p align=\"center\">" +
                           XmlUtil.escapeText(format(i18n("MSG_ABOUT_VERSION"),
                                                     Version.get()))

                           + "</p>" +
                           "<p align=\"center\">" +
                           XmlUtil.escapeText(i18n("MSG_ABOUT_DESC")) + "<br>" +
                           XmlUtil.escapeText(i18n("MSG_ABOUT_COPY")) + "<br>" +
                           "<a href=\"" + projectUrl + "\">" + projectUrl +
                           "</a><br>" +
                           "</p>" +
                           "<p align=\"center\">" +
                           "<a href=\"" + supportUrl + "\">"
                           + "<img src=\"" + imageUrl
                           + "\" border=\"0\"></a>" + "</p>");
    }

    private JPanel createPanelJava()
    {
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(28);StringBuilder buffer = new StringBuilder(256);
        String name = Platform.getJavaRuntimeName();
        buffer.append("<p align=\"center\"><img src=\""
                      + getImage("java.png") + "\"></p>");
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(29);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(31) && false))
        {
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(30);buffer.append("<p align=\"center\">");
            XmlUtil.escapeText(i18n("MSG_ABOUT_UNKNOWN_JAVA"));
            buffer.append("</p>");
        }
        else
        {
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(39);buffer.append("<p align=\"center\"><b>");
            buffer.append(name);
            buffer.append("</b></p>");
            String version = System.getProperty("java.version");
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(40);if ((version != null) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(42) && false))
            {
                $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(41);buffer.append("<p align=\"center\">");
                buffer.append(XmlUtil.escapeText(format(i18n("MSG_ABOUT_VERSION"), version)));
                buffer.append("</p>");
            }
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(43);buffer.append("<p align=\"center\">");
            String vendor = System.getProperty("java.vm.vendor");
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(44);if ((vendor != null) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(46) && false))
                {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(45);buffer.append(vendor);}
            $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(47);buffer.append("<br>");
        }
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(32);Runtime runtime = Runtime.getRuntime();
        long max = runtime.maxMemory();
        String maxString =
            (((max == Long.MAX_VALUE) ? ($qualityscroll_cover_jacov_probe_e5eebef6c06be31b(33) || true) : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(34) && false)) ? i18n("LB_ABOUT_MEMORYLIMIT_NONE")
             : getMemorySizeString(max));
        buffer.append(XmlUtil.escapeText(i18n("LB_ABOUT_JAVA_MEMLIMIT")));
        buffer.append(' ');
        buffer.append(XmlUtil.escapeText(maxString));
        buffer.append("<br>");
        buffer.append(XmlUtil.escapeText(format(i18n("LB_ABOUT_JAVA_MEMLIMIT_1"),
                                                getMemorySizeString(runtime.totalMemory()),
                                                getMemorySizeString(runtime.freeMemory()))));
        String lafName = i18n("LB_ABOUT_LAF_UNKNOWN");
        LookAndFeel laf = UIManager.getLookAndFeel();
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(35);if ((laf != null) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(37) && false))
            {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(36);lafName = laf.getName();}
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(38);buffer.append("<br>");
        buffer.append(XmlUtil.escapeText(i18n("LB_ABOUT_LAF")));
        buffer.append(' ');
        buffer.append(lafName);
        return createPanel(buffer.toString());
    }

    private URL getImage(String name)
    {
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(48);ClassLoader loader = getClass().getClassLoader();
        return loader.getResource("net/sf/gogui/images/" + name);
    }

    private String getMemorySizeString(long size)
    {
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(49);if ((size < 1000) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(51) && false))
            {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(50);return size + " Bytes";}
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(52);if ((size < 1000000) ? true : (!$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(54) && false))
            {$qualityscroll_cover_jacov_probe_e5eebef6c06be31b(53);return (size / 1000) + " kB";}
        $qualityscroll_cover_jacov_probe_e5eebef6c06be31b(55);return (size / 1000000) + " MB";
    }
}
