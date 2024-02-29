/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// StatusBar.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.Platform;

/** Status bar. */
public class StatusBar
    extends JPanel
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = StatusBar.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1428473728825656850L,/* translation unit id   */ -3937614021866254280L,/* timestamp             */ 1709177902785L,/* source file name      */ "StatusBar.java",/* probe size            */ 26);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public StatusBar()
    {
        super(new BorderLayout());$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(0);
        JPanel outerPanel = new JPanel(new BorderLayout());
        add(outerPanel, BorderLayout.CENTER);
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(1);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(3) && false))
        {
            // add some empty space so that status bar does not overlap the
            // window resize widget on Mac OS X
            $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(2);Dimension dimension = new Dimension(20, 1);
            Box.Filler filler =
                new Box.Filler(dimension, dimension, dimension);
            outerPanel.add(filler, BorderLayout.EAST);
        }
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(4);JPanel panel = new JPanel(new BorderLayout());
        //panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        outerPanel.add(panel, BorderLayout.CENTER);
        m_iconBox = Box.createHorizontalBox();
        panel.add(m_iconBox, BorderLayout.WEST);
        m_toPlayLabel = new JLabel();
        m_toPlayLabel.setMaximumSize(new Dimension(Short.MAX_VALUE,
                                                   Short.MAX_VALUE));
        setToPlay(BLACK);
        m_iconBox.add(m_toPlayLabel);

        m_labelSetup
            = new JLabel(GuiUtil.getIcon("gogui-setup-16x16",
                                         i18n("LB_STATUS_SETUP")));
        m_labelSetup.setVisible(false);
        m_labelSetup.setToolTipText(i18n("TT_STATUS_SETUP"));
        m_iconBox.add(m_labelSetup);

        m_iconBox.add(GuiUtil.createSmallFiller());

        m_text = new JLabel() {
                /** Use tool tip if text is truncated. */
                @Override
				protected void paintComponent(Graphics g)
                {
                    $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(5);super.paintComponent(g);
                    String text = super.getText();
                    $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(6);if ((text == null
                        || g.getFontMetrics().stringWidth(text) < getWidth()) ? true : (!$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(8) && false))
                        {$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(7);setToolTipText(null);}
                    else
                        {$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(9);setToolTipText(text);}
                }
            };
        setPreferredLabelSize(m_text, 10);
        panel.add(m_text, BorderLayout.CENTER);
        Box moveTextBox = Box.createHorizontalBox();
        panel.add(moveTextBox, BorderLayout.EAST);
        m_moveText = new JLabel();
        setPreferredLabelSize(m_moveText, 12);
        m_moveText.setHorizontalAlignment(SwingConstants.LEFT);
        m_moveTextSeparator = new JSeparator(SwingConstants.VERTICAL);
        moveTextBox.add(m_moveTextSeparator);
        moveTextBox.add(GuiUtil.createSmallFiller());
        moveTextBox.add(m_moveText);
    }

    public void clear()
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(10);setText("");
    }

    public String getText()
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(11);return m_text.getText();
    }

    public void immediatelyPaintMoveText(String text)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(12);assert SwingUtilities.isEventDispatchThread();
        setMoveText(text, null);
        GuiUtil.paintImmediately(m_moveText);
        GuiUtil.paintImmediately(m_moveTextSeparator);
    }

    public void immediatelyPaintText(String text)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(13);assert SwingUtilities.isEventDispatchThread();
        setText(text);
        GuiUtil.paintImmediately(m_text);
    }

    /** Set text with move information.
        This text is displayed right and contains e.g. information about
        the last move, current move number etc. */
    public void setMoveText(String text, String toolTip)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(14);if ((text.length() > 18) ? true : (!$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(16) && false))
            {$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(15);text = text.substring(0, 18) + "...";}
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(17);m_moveText.setText(text);
        m_moveText.setToolTipText(toolTip);
    }

    public void setSetupMode(boolean enabled)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(18);m_labelSetup.setVisible(enabled);
    }

    public void setText(String text)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(19);m_text.setText(text);
    }

    public final void setToPlay(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(20);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_c95ac8e8d4109038(22) && false))
        {
            $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(21);m_toPlayLabel.setIcon(ICON_BLACK);
            m_toPlayLabel.setToolTipText(i18n("LB_STATUS_TO_PLAY_BLACK"));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(23);assert color == WHITE;
            m_toPlayLabel.setIcon(ICON_WHITE);
            m_toPlayLabel.setToolTipText(i18n("LB_STATUS_TO_PLAY_WHITE"));
        }
    }

    /** Hide or show the text field for move information.
        @see #setMoveText */
    public void showMoveText(boolean show)
    {
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(24);m_moveText.setVisible(show);
        m_moveTextSeparator.setVisible(show);
    }

    private static final Icon ICON_BLACK =
        GuiUtil.getIcon("gogui-black-16x16", i18n("LB_BLACK"));

    private static final Icon ICON_WHITE =
        GuiUtil.getIcon("gogui-white-16x16", i18n("LB_WHITE"));

    private final Box m_iconBox;

    private final JLabel m_toPlayLabel;

    private final JLabel m_labelSetup;

    private final JLabel m_moveText;

    private final JLabel m_text;

    private final JSeparator m_moveTextSeparator;

    /** Set a preferred size, such that the layout does not change,
        if a text label on the status bar is empty.
        The preferred size is derived from the font. */
    private static void setPreferredLabelSize(JLabel label, int columns)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c95ac8e8d4109038(25);Font font = label.getFont();
        Insets insets = label.getInsets();
        int height = font.getSize() + insets.top + insets.bottom;
        int width =
            columns * font.getSize() + insets.left + insets.right;
        label.setPreferredSize(new Dimension(width, height));
    }
}
