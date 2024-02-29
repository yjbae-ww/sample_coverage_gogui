/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GameInfoPanel.java

package net.sf.gogui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.MessageFormat;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import net.sf.gogui.game.ConstClock;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.Clock;
import net.sf.gogui.game.Game;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.go.BlackWhiteSet;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;
import static net.sf.gogui.go.GoColor.WHITE_BLACK;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.StringUtil;

/** Panel displaying information about the current position. */
public class GameInfoPanel
    extends JPanel
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameInfoPanel.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2206346349808818970L,/* translation unit id   */ 2647729116311241375L,/* timestamp             */ 1709177902048L,/* source file name      */ "GameInfoPanel.java",/* probe size            */ 58);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameInfoPanel(Game game)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(0);setBorder(GuiUtil.createEmptyBorder());
        JPanel panel =
            new JPanel(new GridLayout(0, 2, GuiUtil.PAD, GuiUtil.PAD));
        add(panel, BorderLayout.CENTER);
        m_game = game;
        
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(1);for (GoColor c : WHITE_BLACK)
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(4);Box box = Box.createVerticalBox();
            panel.add(box);
            ImageIcon icon;
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(5);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(7) && false))
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(6);icon = GuiUtil.getIcon("gogui-black-32x32", i18n("LB_BLACK"));}
            else
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(9);icon = GuiUtil.getIcon("gogui-white-32x32", i18n("LB_WHITE"));}
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(8);m_icon.set(c, new JLabel(icon));
            m_icon.get(c).setAlignmentX(Component.CENTER_ALIGNMENT);
            box.add(m_icon.get(c));
            box.add(GuiUtil.createFiller());
            m_clock.set(c, new GuiClock(c));
            m_clock.get(c).setAlignmentX(Component.CENTER_ALIGNMENT);
            box.add(m_clock.get(c));
            GoColor otherColor = c.otherColor();
            m_prisoners.set(otherColor, new Prisoners(otherColor));
            box.add(m_prisoners.get(otherColor));
        }
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(2);Clock.Listener listener = new Clock.Listener() {
                @Override
				public void clockChanged()
                {
                    $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(3);SwingUtilities.invokeLater(m_updateTime);
                }
            };
        game.setClockListener(listener);
    }

    public void update()
    {
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(10);ConstBoard board = m_game.getBoard();
        ConstNode node = m_game.getCurrentNode();
        ConstGameTree tree = m_game.getTree();
        ConstGameInfo info = tree.getGameInfoConst(node);
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(11);for (GoColor c : BLACK_WHITE)
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(12);String name = info.get(StringInfoColor.NAME, c);
            String rank = info.get(StringInfoColor.RANK, c);
            updatePlayerToolTip(m_icon.get(c), name, rank, c);
            m_prisoners.get(c).setCount(board.getCaptured(c));
            updateTimeFromClock(m_game.getClock(), c);
        }
    }

    private class UpdateTimeRunnable
        implements Runnable
    {
        @Override
		public void run()
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(13);for (GoColor c : BLACK_WHITE)
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(14);updateTimeFromClock(m_game.getClock(), c);}
        }
    }

    private final BlackWhiteSet<GuiClock> m_clock
        = new BlackWhiteSet<GuiClock>();

    private final BlackWhiteSet<JLabel> m_icon
        = new BlackWhiteSet<JLabel>();

    private final BlackWhiteSet<Prisoners> m_prisoners
        = new BlackWhiteSet<Prisoners>();

    private final Game m_game;

    private final UpdateTimeRunnable m_updateTime = new UpdateTimeRunnable();

    private void updatePlayerToolTip(JLabel label, String player, String rank,
                                     GoColor color)
    {
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(15);assert color.isBlackWhite();
        StringBuilder buffer = new StringBuilder(128);
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(16);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(18) && false))
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(17);buffer.append(i18n("TT_INFOPANEL_PLAYER_BLACK"));}
        else
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(28);buffer.append(i18n("TT_INFOPANEL_PLAYER_WHITE"));}
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(19);buffer.append(" (");
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(20);if ((StringUtil.isEmpty(player)) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(22) && false))
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(21);buffer.append(i18n("TT_INFOPANEL_UNKNOWN_NAME"));}
        else
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(24);buffer.append(player);
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(25);if ((! StringUtil.isEmpty(rank)) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(27) && false))
            {
                $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(26);buffer.append(' ');
                buffer.append(rank);
            }
        }
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(23);buffer.append(')');
        label.setToolTipText(buffer.toString());
    }

    private void updateTimeFromClock(ConstClock clock, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(29);assert c.isBlackWhite();
        String text = clock.getTimeString(c);
        m_clock.get(c).setText(text);
    }
}

class GuiClock
    extends JTextField
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiClock.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2206346349808818970L,/* translation unit id   */ 2647729116311241375L,/* timestamp             */ 1709177902048L,/* source file name      */ "GameInfoPanel.java",/* probe size            */ 58);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GuiClock(GoColor color)
    {
        super(COLUMNS);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(30);
        GuiUtil.setEditableFalse(this);
        setHorizontalAlignment(SwingConstants.CENTER);
        setMinimumSize(getPreferredSize());
        m_color = color;
        setText("00:00");
    }

    @Override
	public final void setText(String text)
    {
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(31);super.setText(text);
        String toolTip;
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(32);if ((m_color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(34) && false))
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(33);toolTip = i18n("TT_INFOPANEL_TIME_BLACK");}
        else
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(39);toolTip = i18n("TT_INFOPANEL_TIME_WHITE");}
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(35);if ((text.length() > COLUMNS) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(37) && false))
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(36);toolTip = toolTip + " (" + text + ")";}
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(38);setToolTipText(toolTip);
    }

    private static final int COLUMNS = 8;

    private final GoColor m_color;
}

class Prisoners
    extends JPanel
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Prisoners.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2206346349808818970L,/* translation unit id   */ 2647729116311241375L,/* timestamp             */ 1709177902048L,/* source file name      */ "GameInfoPanel.java",/* probe size            */ 58);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Prisoners(GoColor color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(40);m_color = color;
        Icon icon;
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(41);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(43) && false))
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(42);icon = GuiUtil.getIcon("gogui-black-16x16", i18n("LB_BLACK"));}
        else
            {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(45);icon = GuiUtil.getIcon("gogui-white-16x16", i18n("LB_WHITE"));}
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(44);JLabel labelStone = new JLabel(icon);
        add(labelStone, BorderLayout.WEST);
        m_text = new JLabel();
        add(m_text, BorderLayout.CENTER);
        setCount(0);
    }

    public final void setCount(int n)
    {
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(46);m_text.setText(Integer.toString(n));
        String tip;
        String jhs;
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(47);if ((m_color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(49) && false))
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(48);if ((n == 1) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(51) && false))
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(50);tip = i18n("TT_INFOPANEL_PRISONER_BLACK_ONE");}
            else
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(53);tip = MessageFormat.format(i18n("TT_INFOPANEL_PRISONER_BLACK"), n);}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(54);if ((n == 1) ? true : (!$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(56) && false))
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(55);tip = i18n("TT_INFOPANEL_PRISONER_WHITE_ONE");}
            else
                {$qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(57);tip = MessageFormat.format(i18n("TT_INFOPANEL_PRISONER_WHITE"), n);}
        }
        $qualityscroll_cover_jacov_probe_24be9f9a5f30c29f(52);setToolTipText(tip);
    }

    private final JLabel m_text;

    private final GoColor m_color;
}
