/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// Main.java

package net.sf.gogui.gogui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.MalformedURLException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gui.GuiUtil;
import static net.sf.gogui.gui.GuiUtil.insertLineBreaks;
import net.sf.gogui.gui.MessageDialogs;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** GoGui main function. */
public final class Main
{
	public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4320934674789164968L,/* translation unit id   */ -1252824773708554116L,/* timestamp             */ 1709177901086L,/* source file name      */ "Main.java",/* probe size            */ 43);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}private static String TEST = "TEST";
	
	public static void testTestMonitor(){$qualityscroll_cover_coverage_buffer_init();
		$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(0);System.out.println("testTestMonitor");
	}
	
    /** GoGui main function. */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
    	//TESTTTTTT
    	
    	
    	
    	//????E?TSET?ES?T?E
    	$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(1);System.out.println(TEST);
        GoGuiSettings settings;
        try
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(2);settings =
                new GoGuiSettings(args,
                                  Class.forName("net.sf.gogui.gogui.GoGui"));
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(3);if ((settings.m_noStartup) ? true : (!$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(5) && false))
                {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(4);return;}
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(6);startGoGui(settings);
        }
        catch (RuntimeException e)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(7);showCrashDialog(e);
            System.exit(1);
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(8);System.err.println(e.getMessage());
            return;
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(9);showError("Unexpected failure", StringUtil.printException(t));
            System.exit(1);
        }
    }

    public static void main(GoGuiSettings settings)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(10);startGoGui(settings);
        }
        catch (RuntimeException e)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(11);showCrashDialog(e);
            System.exit(1);
        }
        catch (ErrorMessage e)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(12);System.err.println(e.getMessage());
            return;
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(13);showError("Unexpected failure", StringUtil.printException(t));
            System.exit(1);
        }
    }

    /** Flag if crash dialog is currently shown.
        Avoids that more than one crash dialog pops up, because events in the
        event dispatch thread can still be handled and cause more exceptions
        while the first crash dialog is shown. */
    private static boolean s_duringShowCrashDialog;

    /** Make constructor unavailable; class is for namespace only. */
    private Main(){$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(14);}

    private static void addFiller(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(15);Box.Filler filler = GuiUtil.createFiller();
        filler.setAlignmentX(Component.LEFT_ALIGNMENT);
        component.add(filler);
    }

    private static void startGoGui(final GoGuiSettings settings)
        throws GtpError, ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
//        assert ! settings.m_noStartup;
        // Create thread group to catch errors from Swing event thread
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(16);ThreadGroup group = new ThreadGroup("catch-runtime-exceptions") {
                @Override
				public void uncaughtException(Thread t, Throwable e) {
                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(17);if ((s_duringShowCrashDialog) ? true : (!$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(19) && false))
                        {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(18);return;}
                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(20);StringUtil.printException(e);
                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(21);if ((e instanceof RuntimeException
                        || e instanceof AssertionError) ? true : (!$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(23) && false))
                        {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(22);showCrashDialog(e);}
                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(24);System.exit(1);
                }
            };
        Runnable runnable = new Runnable() {
                @Override
				public void run() {
                    // Fix wrong taskbar title in Gnome 3. See
      // http://elliotth.blogspot.com/2007/02/fixing-wmclass-for-your-java.html
              // and http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6528430
                    try
                    {
                        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(25);Toolkit toolkit = Toolkit.getDefaultToolkit();
                        java.lang.reflect.Field field =
                            toolkit.getClass()
                            .getDeclaredField("awtAppClassName");
                        field.setAccessible(true);
                        field.set(toolkit, "GoGui");
                    }
                    catch (Exception e)
                    {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(29);
                    }

                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(26);GuiUtil.initLookAndFeel(settings.m_lookAndFeel);
                    try
                    {
                        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(27);new GoGui(settings.m_program, settings.m_file,
                                  settings.m_move, settings.m_time,
                                  settings.m_verbose,
                                  settings.m_initComputerColor,
                                  settings.m_computerBlack,
                                  settings.m_computerWhite, settings.m_auto,
                                  settings.m_register, settings.m_gtpFile,
                                  settings.m_gtpCommand,
                                  settings.m_analyzeCommands);
                    }
                    catch (ErrorMessage e)
                    {
                        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(28);System.err.println(e.getMessage());
                        return;
                    }
                }
            };
        Thread thread = new Thread(group, runnable);
        thread.start();
    }

    private static void showCrashDialog(Throwable e)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(30);s_duringShowCrashDialog = true;
        JPanel panel = new JPanel(new BorderLayout());
        Box box = Box.createVerticalBox();
        panel.add(box, BorderLayout.NORTH);

        String css = GuiUtil.getMessageCss();

        JLabel mainMessageLabel =
            new JLabel("<html>" + css +
                       "<b>The application GoGui has quit unexpectedly</b>");
        mainMessageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(mainMessageLabel);
        addFiller(box);

        String optionalMessage;
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(31);if ((Version.get().indexOf("GIT") >= 0) ? true : (!$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(33) && false))
            {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(32);optionalMessage =
                "You are running an unreleased version of GoGui. Please don't report this bug to\n" +
                "the GoGui bug tracker, but email the author of GoGui directly instead.\n";}
        else
            {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(41);optionalMessage =
                "Please take a moment to submit a bug report at the GoGui bug tracker.\n";}
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(34);optionalMessage = optionalMessage +
                "Include a short summary of the problem together with the following information:";
        JLabel optionalMessageLabel =
            new JLabel("<html>" + css + "<p>"
                       + insertLineBreaks(optionalMessage) + "</p>");
        optionalMessageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(optionalMessageLabel);

        box.add(GuiUtil.createSmallFiller());
        JTextArea textArea = new JTextArea();
        textArea.setForeground(Color.black);
        textArea.setBackground(Color.white);
        textArea.setBorder(GuiUtil.createEmptyBorder());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        JButton copyButton = new JButton("Copy Information");
        final String goguiVersion = "GoGui version: " + Version.get();
        final String javaVersion = "Java version: " +
            Platform.getJavaRuntimeName() + " " +
            System.getProperty("java.version");
        final String osVersion = "Operating system: " +
            System.getProperty("os.name");
        final StringWriter stackTrace = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stackTrace);
        e.printStackTrace(printWriter);
        copyButton.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(35);GuiUtil.copyToClipboard(goguiVersion + "\n" +
                                            javaVersion  + "\n" +
                                            osVersion + "\n\n" +
                                            stackTrace);
                }
            });

        JButton urlButton = new JButton("Go to Bug Tracker");
        urlButton.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    try
                    {
                        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(36);URL url =
                            new URL("http://sf.net/tracker/?group_id=59117&atid=489964");
                        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(37);if ((! Platform.openInExternalBrowser(url)) ? true : (!$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(39) && false))
                            {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(38);showError("Could not open URL in external browser",
                                      "");}
                    }
                    catch (MalformedURLException e2)
                    {$qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(40);
                    }
                }
            });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(urlButton);
        buttonPanel.add(copyButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        scrollPane.setPreferredSize(new Dimension(512, 256));
        String text = goguiVersion + "\n" + javaVersion + "\n" + osVersion
            + "\n\n" + stackTrace;
        textArea.setText(text);
        Object[] options = { "Close" };
        JOptionPane optionPane =
            new JOptionPane(panel, JOptionPane.ERROR_MESSAGE,
                            JOptionPane.DEFAULT_OPTION, null, options,
                            options[0]);
        JDialog dialog = optionPane.createDialog(null, "Error");
        // Workaround for Sun Bug ID 4545951 (still in Linux JDK 1.5.0_04-b05)
        panel.invalidate();
        dialog.pack();
        dialog.setVisible(true);
        dialog.dispose();
    }

    private static void showError(String mainMessage, String optionalMessage)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ee9d12818d4ae07c(42);MessageDialogs messageDialogs = new MessageDialogs();
        messageDialogs.showError(null, mainMessage, optionalMessage);
    }
}
