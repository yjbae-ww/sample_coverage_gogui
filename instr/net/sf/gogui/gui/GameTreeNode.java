/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GameTreeNode.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.font.LineMetrics;
import javax.swing.JComponent;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.BLACK_WHITE_EMPTY;
import net.sf.gogui.go.Move;
import static net.sf.gogui.gui.I18n.i18n;

class GameTreeNode
    extends JComponent
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameTreeNode.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7856680274575157580L,/* translation unit id   */ -668970300335735829L,/* timestamp             */ 1709177902107L,/* source file name      */ "GameTreeNode.java",/* probe size            */ 86);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameTreeNode(ConstNode node, int moveNumber,
                        GameTreePanel gameTreePanel,
                        MouseListener mouseListener, Font font,
                        Image imageBlack, Image imageWhite, Image imageSetup,
                        Dimension size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(0);m_gameTreePanel = gameTreePanel;
        m_node = node;
        m_moveNumber = moveNumber;
        addMouseListener(mouseListener);
        setOpaque(false);
        setFocusable(false);
        setFocusTraversalKeysEnabled(false);
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(1);if ((font != null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(3) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(2);setFont(font);}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(4);m_imageBlack = imageBlack;
        m_imageWhite = imageWhite;
        m_imageSetup = imageSetup;
        updateToolTip();
        setPreferredSize(size);
    }

    public ConstNode getNode()
    {
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(5);return m_node;
    }

    @Override
	public void paintComponent(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(6);int size = m_gameTreePanel.getNodeSize();
        int fullSize = m_gameTreePanel.getNodeFullSize();
        int halfSize = size / 2;
        int numberChildren = m_node.getNumberChildren();
        boolean isExpanded = m_gameTreePanel.isExpanded(m_node);
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(7);if ((m_gameTreePanel.isCurrent(m_node)) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(9) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(8);graphics.setColor(COLOR_CURSOR);
            graphics.fillRect(0, 0, size, ((size > 10) ? ($qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(10) || true) : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(11) && false)) ? size : fullSize - 1);
        }
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(12);graphics.setColor(COLOR_GRID);
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(13);if ((numberChildren > 0) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(15) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(14);graphics.drawLine(size, halfSize, fullSize, halfSize);}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(16);if ((numberChildren > 1 && isExpanded) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(18) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(17);graphics.drawLine(halfSize, size, halfSize, fullSize);}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(19);Move move = m_node.getMove();
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(20);if ((m_node.hasSetup()) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(22) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(21);graphics.drawImage(m_imageSetup, 0, 0, null);}
        else {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(26);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(28) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(27);graphics.setColor(COLOR_GRID);
            int[] xPoints = { halfSize, size, halfSize, 0 };
            int[] yPoints = { 0, halfSize, size, halfSize };
            graphics.fillPolygon(xPoints, yPoints, 4);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(29);if ((move.getColor() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(31) && false))
                {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(30);graphics.drawImage(m_imageBlack, 0, 0, null);}
            else
                {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(33);graphics.drawImage(m_imageWhite, 0, 0, null);}
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(32);drawText(graphics);
        }}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(23);if ((m_node.hasComment()) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(25) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(24);graphics.setColor(COLOR_LIGHT_BLUE);
            int y = size + (fullSize - size) / 4;
            int d = size / 5;
            graphics.drawLine(d, y, size - d, y);
        }
    }

    public final void updateToolTip()
    {
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(34);StringBuilder toolTip = new StringBuilder(128);
        Move move = m_node.getMove();
        GoColor player = m_node.getPlayer();
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(35);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(37) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(36);toolTip.append(m_moveNumber);
            toolTip.append(' ');
            toolTip.append(move);
        }
        else {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(49);if ((m_node.hasSetup() || player != null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(51) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(50);toolTip.append(i18n("TT_NODE_SETUP"));
            toolTip.append(" (");
            boolean anyStones = false;
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(52);for (GoColor c : BLACK_WHITE_EMPTY)
            {
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(60);int n = m_node.getSetup(c).size();
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(61);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(63) && false))
                    {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(62);continue;}
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(64);if ((anyStones) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(66) && false))
                    {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(65);toolTip.append(", ");}
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(67);anyStones = true;
                toolTip.append(c.getUppercaseLetter());
                toolTip.append(' ');
                toolTip.append(n);
            }
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(53);if ((player != null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(55) && false))
            {
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(54);if ((anyStones) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(57) && false))
                    {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(56);toolTip.append(", ");}
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(58);toolTip.append(i18n("TT_NODE_PLAYER"));
                toolTip.append(' ');
                toolTip.append(player.getUppercaseLetter());
            }
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(59);toolTip.append(')');
        }}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(38);String comment = NodeUtil.getCommentStart(m_node, false, 80);
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(39);if ((comment != null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(41) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(40);comment = comment.replaceAll("\n *\n", "\n");
            comment = comment.replaceAll("\n", "<br>");
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(42);if ((comment.length() > 50) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(44) && false))
            {
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(43);toolTip.append("<p width=\"250\">");
                toolTip.append(comment);
                toolTip.append("</p>");
            }
            else
            {
                $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(48);toolTip.append("<p>");
                toolTip.append(comment);
                toolTip.append("</p>");
            }
        }
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(45);if ((toolTip.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(47) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(46);setToolTipText("<html>" + toolTip.toString() + "</html>");}
    }

    private final int m_moveNumber;

    private static final Color COLOR_LIGHT_BLUE = new Color(103, 122, 164);

    private static final Color COLOR_CURSOR = new Color(142, 168, 226);

    private static final Color COLOR_GRID = new Color(148, 148, 148);

    private final GameTreePanel m_gameTreePanel;

    private final ConstNode m_node;

    private final Image m_imageBlack;

    private final Image m_imageWhite;

    private final Image m_imageSetup;

    private void drawText(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(68);GameTreePanel.Label labelMode = m_gameTreePanel.getLabelMode();
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(69);if ((labelMode == GameTreePanel.Label.NONE) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(71) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(70);return;}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(72);Move move = m_node.getMove();
        int size = m_gameTreePanel.getNodeSize();
        String text;
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(73);if ((labelMode == GameTreePanel.Label.MOVE) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(75) && false))
        {
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(74);if ((move.getPoint() == null) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(77) && false))
                {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(76);return;}
            $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(78);text = move.getPoint().toString();
        }
        else
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(85);text = Integer.toString(m_moveNumber);}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(79);FontMetrics fontMetrics = graphics.getFontMetrics();
        LineMetrics lineMetrics = fontMetrics.getLineMetrics(text, graphics);
        int textWidth = fontMetrics.stringWidth(text);
        int ascent = (int)lineMetrics.getAscent();
        int xText = (size - textWidth) / 2;
        int yText = (ascent + size) / 2;
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(80);if ((move.getColor() == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(82) && false))
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(81);graphics.setColor(Color.white);}
        else
            {$qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(84);graphics.setColor(Color.black);}
        $qualityscroll_cover_jacov_probe_f6b7570e6333bbeb(83);graphics.drawString(text, xText, yText);
    }
}
