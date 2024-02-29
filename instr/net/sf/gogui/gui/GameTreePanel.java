/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GameTreePanel.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.NodeUtil;
import static net.sf.gogui.gui.I18n.i18n;

/** Panel displaying a game tree. */
public class GameTreePanel
    extends JPanel
    implements Scrollable
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameTreePanel.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 7776677369138834581L,/* translation unit id   */ 5528174245731991989L,/* timestamp             */ 1709177902151L,/* source file name      */ "GameTreePanel.java",/* probe size            */ 230);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public enum Label
    {
        NUMBER,

        MOVE,

        NONE
    }

    public enum Size
    {
        LARGE,

        NORMAL,

        SMALL,

        TINY
    }

    public static final Color BACKGROUND = new Color(192, 192, 192);

    public GameTreePanel(JDialog owner, GameTreeViewer.Listener listener,
                         Label labelMode, Size sizeMode,
                         MessageDialogs messageDialogs)
    {
        super(new SpringLayout());$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(0);
        m_messageDialogs = messageDialogs;
        m_owner = owner;
        setBackground(BACKGROUND);
        m_labelMode = labelMode;
        m_sizeMode = sizeMode;
        initSize(sizeMode);
        setFocusable(false);
        setFocusTraversalKeysEnabled(false);
        setAutoscrolls(true);
        addMouseMotionListener(new GameTreePanel.MouseMotionListener());
        m_listener = listener;
        m_mouseListener = new MouseAdapter()
            {
                @Override
				public void mouseClicked(MouseEvent event)
                {
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(1);if ((event.getButton() != MouseEvent.BUTTON1) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(3) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(2);return;}
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(4);GameTreeNode gameNode = (GameTreeNode)event.getSource();
                    gotoNode(gameNode.getNode());
                }

                @Override
				public void mousePressed(MouseEvent event)
                {
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(5);if ((event.isPopupTrigger()) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(7) && false))
                    {
                        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(6);GameTreeNode gameNode
                            = (GameTreeNode)event.getSource();
                        int x = event.getX();
                        int y = event.getY();
                        showPopup(x, y, gameNode);
                    }
                }

                @Override
				public void mouseReleased(MouseEvent event)
                {
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(8);if ((event.isPopupTrigger()) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(10) && false))
                    {
                        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(9);GameTreeNode gameNode
                            = (GameTreeNode)event.getSource();
                        int x = event.getX();
                        int y = event.getY();
                        showPopup(x, y, gameNode);
                    }
                }
            };
    }

    public ConstNode getCurrentNode()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(11);return m_currentNode;
    }

    public Label getLabelMode()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(12);return m_labelMode;
    }

    public int getNodeFullSize()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(13);return m_nodeFullSize;
    }

    public int getNodeSize()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(14);return m_nodeSize;
    }

    @Override
	public Dimension getPreferredScrollableViewportSize()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(15);return new Dimension(m_nodeFullSize * 10, m_nodeFullSize * 3);
    }

    @Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
                                           int orientation, int direction)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(16);int result;
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(17);if ((orientation == SwingConstants.VERTICAL) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(19) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(18);result = visibleRect.height;}
        else
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(21);result = visibleRect.width;}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(20);result = (result / m_nodeFullSize) * m_nodeFullSize;
        return result;
    }

    @Override
	public boolean getScrollableTracksViewportHeight()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(22);return false;
    }

    @Override
	public boolean getScrollableTracksViewportWidth()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(23);return false;
    }

    @Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
                                          int orientation, int direction)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(24);return m_nodeFullSize;
    }

    public boolean getShowSubtreeSizes()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(25);return m_showSubtreeSizes;
    }

    public Size getSizeMode()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(26);return m_sizeMode;
    }

    public void gotoNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(27);if ((m_listener != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(29) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(28);m_listener.actionGotoNode(node);}
    }

    public boolean isCurrent(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(30);return node == m_currentNode;
    }

    public boolean isExpanded(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(31);return m_isExpanded.contains(node);
    }

    @Override
	public void paintComponent(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(32);GuiUtil.setAntiAlias(graphics);
        super.paintComponent(graphics);
    }

    public void redrawCurrentNode()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(33);GameTreeNode gameNode = getGameTreeNode(m_currentNode);
        gameNode.repaint();
    }

    public void scrollToCurrent()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(34);scrollRectToVisible(new Rectangle(m_currentNodeX - 2 * m_nodeSize,
                                          m_currentNodeY - m_nodeSize,
                                          5 * m_nodeSize,
                                          3 * m_nodeSize));
    }

    public void setLabelMode(Label mode)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(35);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (mode)
        {
        case NUMBER:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(36); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case MOVE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(37); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case NONE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(38); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(40);m_labelMode = mode;
            break;
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(39); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(41);assert false;
            break;
        }
    }

    /** Only used for a workaround on Mac Java 1.4.2,
        which causes the scrollpane to lose focus after a new layout of
        this panel. If scrollPane is not null, a requestFocusOnWindow will
        be called after each new layout */
    public void setScrollPane(JScrollPane scrollPane)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(42);m_scrollPane = scrollPane;
    }

    public void setShowSubtreeSizes(boolean showSubtreeSizes)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(43);m_showSubtreeSizes = showSubtreeSizes;
    }

    public void setSizeMode(Size mode)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(44);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (mode)
        {
        case LARGE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(45); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case NORMAL:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(46); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case SMALL:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(47); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case TINY:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(48); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(50);if ((mode != m_sizeMode) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(52) && false))
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(51);m_sizeMode = mode;
                initSize(m_sizeMode);
            }
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(53);break;
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(49); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(54);assert false;
            break;
        }
    }

    /** Faster than update if a new node was added as the first child. */
    public void addNewSingleChild(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(55);assert ! node.hasChildren();
        ConstNode father = node.getFatherConst();
        assert father != null;
        assert father.getNumberChildren() == 1;
        GameTreeNode fatherGameNode = getGameTreeNode(father);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(56);if ((fatherGameNode == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(58) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(57);assert false;
            return;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(59);int moveNumber = NodeUtil.getMoveNumber(node);
        GameTreeNode gameNode = createNode(node, moveNumber);
        m_map.put(node, gameNode);
        add(gameNode);
        putConstraint(fatherGameNode, gameNode, m_nodeFullSize, 0);
        gameNode.setLocation(fatherGameNode.getX() + m_nodeFullSize,
                             fatherGameNode.getY());
        gameNode.setSize(m_nodeFullSize, m_nodeFullSize);
        m_maxX = Math.max(fatherGameNode.getX() + 2 * m_nodeFullSize, m_maxX);
        setPreferredSize(new Dimension(m_maxX + m_nodeFullSize + MARGIN,
                                       m_maxY + m_nodeFullSize + MARGIN));
    }

    public void showPopup()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(60);if ((m_currentNode == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(62) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(61);return;}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(63);scrollToCurrent();
        GameTreeNode gameNode = getGameTreeNode(m_currentNode);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(64);if ((gameNode == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(66) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(65);return;}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(67);showPopup(gameNode.getWidth() / 2, gameNode.getHeight() / 2,
                  gameNode);
    }

    public void update(ConstGameTree tree, ConstNode currentNode,
                       int minWidth, int minHeight)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(68);assert currentNode != null;
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        m_minWidth = minWidth;
        m_minHeight = minHeight;
        boolean gameTreeChanged = (tree != m_tree);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(69);if ((gameTreeChanged) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(71) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(70);m_isExpanded.clear();}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(72);ensureVisible(currentNode);
        m_tree = tree;
        m_currentNode = currentNode;
        removeAll();
        m_map.clear();
        m_maxX = minWidth;
        m_maxY = minHeight;
        try
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(73);ConstNode root = m_tree.getRootConst();
            createNodes(this, root, 0, 0, MARGIN, MARGIN, 0);
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(74);if ((gameTreeChanged
                && ! NodeUtil.subtreeGreaterThan(root, 10000)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(76) && false))
                {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(75);showSubtree(root);}
        }
        catch (OutOfMemoryError e)
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(82);m_isExpanded.clear();
            removeAll();
            m_messageDialogs.showError(m_owner,
                                       i18n("MSG_TREE_OUTOFMEM"),
                                       i18n("MSG_TREE_OUTOFMEM_2"));
            update(tree, currentNode, minWidth, minHeight);
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(77);setPreferredSize(new Dimension(m_maxX + m_nodeFullSize + MARGIN,
                                       m_maxY + m_nodeFullSize + MARGIN));
        revalidate();
        scrollToCurrent();
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(78);if ((m_scrollPane != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(80) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(79);m_scrollPane.requestFocusInWindow();}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(81);setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void update(ConstNode currentNode, int minWidth, int minHeight)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(83);assert currentNode != null;
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(84);if ((ensureVisible(currentNode)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(86) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(85);update(m_tree, currentNode, minWidth, minHeight);
            return;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(87);GameTreeNode gameNode = getGameTreeNode(m_currentNode);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(88);if ((gameNode == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(90) && false))
        {
            // The following warning was previously an assert false.
            // But it can can happen, because GoGui does sometimes defer a full
            // update of the tree with SwingUtilities::invokeLater to be
            // able to show a busy cursor and it can happen that a lightweight
            // update (which assumes that the tree structure has not changed)
            // is called before the full update event is dispatched.
            // In the future, it would be easier to do all full updates in
            // the event dispatch tree, even if they take long, but then we
            // need another method to show the busy cursor while the UI is
            // non-responsive
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(89);System.err.println("GameTreePanel: current node not found");
            return;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(91);gameNode.repaint();
        gameNode = getGameTreeNode(currentNode);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(92);if ((gameNode == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(94) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(93);update(m_tree, currentNode, minWidth, minHeight);
            return;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(95);Point location = gameNode.getLocation();
        m_currentNodeX = location.x;
        m_currentNodeY = location.y;
        gameNode.repaint();
        gameNode.updateToolTip();
        m_currentNode = currentNode;
        scrollToCurrent();
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(96);if ((m_scrollPane != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(98) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(97);m_scrollPane.requestFocusInWindow();}
    }

    private static class MouseMotionListener
        extends MouseMotionAdapter
    {
        @Override
		public void mouseDragged(MouseEvent event)
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(99);int x = event.getX();
            int y = event.getY();
            JPanel panel = (JPanel)event.getSource();
            Rectangle rectangle = new Rectangle(x, y, 1, 1);
            panel.scrollRectToVisible(rectangle);
        }
    }

    private boolean m_showSubtreeSizes;

    private int m_currentNodeX;

    private int m_currentNodeY;

    private Label m_labelMode;

    private int m_minHeight;

    private int m_minWidth;

    private Size m_sizeMode;

    private int m_nodeSize;

    private int m_nodeFullSize;

    private static final int MARGIN = 15;

    private int m_maxX;

    private int m_maxY;

    private Dimension m_preferredNodeSize;

    private Font m_font;

    private ConstGameTree m_tree;

    private final GameTreeViewer.Listener m_listener;

    private final JDialog m_owner;

    /** Used for focus workaround on Mac Java 1.4.2 if not null. */
    private JScrollPane m_scrollPane;

    private ConstNode m_currentNode;

    private ConstNode m_popupNode;

    private final HashMap<ConstNode,GameTreeNode> m_map =
        new HashMap<ConstNode,GameTreeNode>(500, 0.8f);

    private final HashSet<ConstNode> m_isExpanded
        = new HashSet<ConstNode>(200);

    private final MouseListener m_mouseListener;

    private Point m_popupLocation;

    private ImageIcon m_iconBlack;

    private ImageIcon m_iconWhite;

    private ImageIcon m_iconSetup;

    private final MessageDialogs m_messageDialogs;

    private JPopupMenu m_popup;

    private JMenuItem m_itemGoto;

    private JMenuItem m_itemScrollToCurrent;

    private JMenuItem m_itemHideSubtree;

    private JMenuItem m_itemShowSubtree;

    private JMenuItem m_itemShowChildren;

    private void initSize(Size sizeMode)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(100);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (sizeMode)
        {
        case LARGE:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(101); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(106);m_nodeSize = 32;
            m_nodeFullSize = 40;
            m_iconBlack = GuiUtil.getIcon("gogui-black-32x32", "");
            m_iconWhite = GuiUtil.getIcon("gogui-white-32x32", "");
            m_iconSetup = GuiUtil.getIcon("gogui-setup-32x32", "");
            break;
        case SMALL:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(102); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(108);m_nodeSize = 16;
            m_nodeFullSize = 20;
            m_iconBlack = GuiUtil.getIcon("gogui-black-16x16", "");
            m_iconWhite = GuiUtil.getIcon("gogui-white-16x16", "");
            m_iconSetup = GuiUtil.getIcon("gogui-setup-16x16", "");
            break;
        case TINY:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(103); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(109);m_nodeSize = 8;
            m_nodeFullSize = 10;
            m_iconBlack = GuiUtil.getIcon("gogui-black-8x8", "");
            m_iconWhite = GuiUtil.getIcon("gogui-white-8x8", "");
            m_iconSetup = GuiUtil.getIcon("gogui-setup-8x8", "");
            break;
        case NORMAL:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(104); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(110);m_nodeSize = 24;
            m_nodeFullSize = 30;
            m_iconBlack = GuiUtil.getIcon("gogui-black-24x24", "");
            m_iconWhite = GuiUtil.getIcon("gogui-white-24x24", "");
            m_iconSetup = GuiUtil.getIcon("gogui-setup-24x24", "");
        default: if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(105); $qualityscroll_cover_jacov_switch_bool_0 = true; }  break;}


        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(107);m_font = new Font("Dialog", Font.PLAIN, (int)(0.4 * m_nodeSize));
        m_preferredNodeSize = new Dimension(m_nodeFullSize, m_nodeFullSize);
    }

    private GameTreeNode createNode(ConstNode node, int moveNumber)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(111);return new GameTreeNode(node, moveNumber, this, m_mouseListener,
                                m_font, m_iconBlack.getImage(),
                                m_iconWhite.getImage(),
                                m_iconSetup.getImage(),
                                m_preferredNodeSize);
    }

    private int createNodes(Component father, ConstNode node, int x, int y,
                            int dx, int dy, int moveNumber)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(112);m_maxX = Math.max(x, m_maxX);
        m_maxY = Math.max(y, m_maxY);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(113);if ((node.getMove() != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(115) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(114);++moveNumber;}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(116);GameTreeNode gameNode = createNode(node, moveNumber);
        m_map.put(node, gameNode);
        add(gameNode);
        putConstraint(father, gameNode, dx, dy);
        int numberChildren = node.getNumberChildren();
        dx = m_nodeFullSize;
        dy = 0;
        boolean isExpanded = isExpanded(node);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(117);if ((isExpanded) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(119) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(118);int[] childrenDy = new int[numberChildren];
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(120);for (int i = 0; (i < numberChildren) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(122) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(121);childrenDy[i] = dy;
                dy += createNodes(gameNode, node.getChildConst(i),
                                  x + dx, y + dy, dx, dy, moveNumber);
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(130);if ((i < numberChildren - 1) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(132) && false))
                    {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(131);dy += m_nodeFullSize;}
            }
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(123);if ((numberChildren > 1) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(125) && false))
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(124);GameTreeJunction junction =
                    new GameTreeJunction(childrenDy, this);
                add(junction);
                putConstraint(gameNode, junction, 0, m_nodeFullSize);
            }
        }
        else
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(133);if ((m_showSubtreeSizes && node.hasChildren()) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(135) && false))
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(134);int subtreeSize = NodeUtil.subtreeSize(node) - 1;
                String text = Integer.toString(subtreeSize);
                // Use upper limit for textWidth
                int textWidth = text.length() + m_font.getSize();
                int textHeight = m_font.getSize();
                int pad = GuiUtil.SMALL_PAD;
                m_maxX = Math.max(x + textWidth + pad, m_maxX);
                JLabel label = new JLabel(text);
                label.setFont(m_font);
                add(label);
                putConstraint(gameNode, label, dx + pad,
                              (m_nodeSize - textHeight) / 2);
            }
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(126);if ((node == m_currentNode) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(128) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(127);m_currentNodeX = x;
            m_currentNodeY = y;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(129);return dy;
    }

    private void createPopup()
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(136);m_popup = new JPopupMenu();
        ActionListener listener = new ActionListener()
            {
                @Override
				public void actionPerformed(ActionEvent event)
                {
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(137);String command = event.getActionCommand();
                    $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(138);if ((command.equals("goto")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(140) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(139);gotoNode(m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(141);if ((command.equals("show-variations")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(143) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(142);showChildren(m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(144);if ((command.equals("show-subtree")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(146) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(145);showSubtree(m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(147);if ((command.equals("hide-others")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(149) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(148);hideOthers(m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(150);if ((command.equals("hide-subtree")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(152) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(151);hideSubtree(m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(153);if ((command.equals("node-info")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(155) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(154);nodeInfo(m_popupLocation, m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(156);if ((command.equals("scroll-to-current")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(158) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(157);scrollTo(m_currentNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(159);if ((command.equals("tree-info")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(161) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(160);treeInfo(m_popupLocation, m_popupNode);}
                    else {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(162);if ((command.equals("cancel")) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(164) && false))
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(163);m_popup.setVisible(false);}
                    else
                        {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(165);assert false;}}}}}}}}}
                }
            };
        JMenuItem item;
        item = new JMenuItem(i18n("MN_TREE_GOTO"));
        item.setActionCommand("goto");
        item.addActionListener(listener);
        m_popup.add(item);
        m_itemGoto = item;
        item = new JMenuItem(i18n("MN_TREE_SCROLL_TO_CURRENT"));
        item.setActionCommand("scroll-to-current");
        item.addActionListener(listener);
        m_popup.add(item);
        m_itemScrollToCurrent = item;
        m_popup.addSeparator();
        item = new JMenuItem(i18n("MN_TREE_HIDE_SUBTREE"));
        m_itemHideSubtree = item;
        item.setActionCommand("hide-subtree");
        item.addActionListener(listener);
        m_popup.add(item);
        item = new JMenuItem(i18n("MN_TREE_HIDE_OTHERS"));
        item.setActionCommand("hide-others");
        item.addActionListener(listener);
        m_popup.add(item);
        item = new JMenuItem(i18n("MN_TREE_SHOW_CHILDREN"));
        m_itemShowChildren = item;
        item.setActionCommand("show-variations");
        item.addActionListener(listener);
        m_popup.add(item);
        item = new JMenuItem(i18n("MN_TREE_SHOW_SUBTREE"));
        m_itemShowSubtree = item;
        item.setActionCommand("show-subtree");
        item.addActionListener(listener);
        m_popup.add(item);
        m_popup.addSeparator();
        item = new JMenuItem(i18n("MN_TREE_NODE_INFO"));
        item.setActionCommand("node-info");
        item.addActionListener(listener);
        m_popup.add(item);
        item = new JMenuItem(i18n("MN_TREE_SUBTREE_STATISTICS"));
        item.setActionCommand("tree-info");
        item.addActionListener(listener);
        m_popup.add(item);
        m_popup.addSeparator();
        item = new JMenuItem(i18n("LB_CANCEL"));
        item.setActionCommand("cancel");
        item.addActionListener(listener);
        m_popup.add(item);
    }

    private GameTreeNode getGameTreeNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(166);return m_map.get(node);
    }

    private boolean ensureVisible(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(167);boolean changed = false;
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(168);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(170) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(169);ConstNode father = node.getFatherConst();
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(172);if ((father != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(174) && false))
                {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(173);if ((m_isExpanded.add(father)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(176) && false))
                    {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(175);changed = true;}}
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(177);node = father;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(171);return changed;
    }

    private void hideOthers(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(178);m_isExpanded.clear();
        ensureVisible(node);
        update(m_tree, m_currentNode, getWidth(), getHeight());
    }

    private void hideSubtree(ConstNode root)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(179);boolean changed = false;
        boolean currentChanged = false;
        int depth = NodeUtil.getDepth(root);
        ConstNode node = root;
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(180);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(182) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(181);if ((node == m_currentNode) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(190) && false))
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(189);m_currentNode = root;
                currentChanged = true;
                changed = true;
            }
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(191);if ((m_isExpanded.remove(node)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(193) && false))
                {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(192);changed = true;}
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(194);node = NodeUtil.nextNode(node, depth);
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(183);if ((currentChanged) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(185) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(184);gotoNode(m_currentNode);
            root = m_currentNode;
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(186);if ((changed) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(188) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(187);update(m_tree, m_currentNode, getWidth(), getHeight());
            scrollTo(root);
        }
    }

    private void nodeInfo(Point location, ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(195);String nodeInfo = NodeUtil.nodeInfo(node);
        String title = i18n("TIT_NODE_INFO");
        TextViewer textViewer = new TextViewer(m_owner, title, nodeInfo, true,
                                               null);
        textViewer.setLocation(location);
        textViewer.setVisible(true);
    }

    private void putConstraint(Component father, Component son,
                               int west, int north)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(196);SpringLayout layout = (SpringLayout)getLayout();
        layout.putConstraint(SpringLayout.WEST, son, west,
                             SpringLayout.WEST, father);
        layout.putConstraint(SpringLayout.NORTH, son, north,
                             SpringLayout.NORTH, father);
    }

    private void scrollTo(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(197);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(199) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(198);return;}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(200);GameTreeNode gameNode = getGameTreeNode(node);
        Rectangle rectangle = new Rectangle();
        rectangle.x = gameNode.getLocation().x;
        rectangle.y = gameNode.getLocation().y;
        // Make rectangle large so that children are visible
        rectangle.width = 3 * m_nodeFullSize;
        rectangle.height = 3 * m_nodeFullSize;
        scrollRectToVisible(rectangle);
    }

    private void showPopup(int x, int y, GameTreeNode gameNode)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(201);ConstNode node = gameNode.getNode();
        m_popupNode = node;
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(202);if ((m_popup == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(204) && false))
            {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(203);createPopup();}
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(205);m_itemGoto.setEnabled(node != m_currentNode);
        m_itemScrollToCurrent.setEnabled(node != m_currentNode);
        boolean hasChildren = node.hasChildren();
        m_itemHideSubtree.setEnabled(hasChildren);
        m_itemShowSubtree.setEnabled(hasChildren);
        m_itemShowChildren.setEnabled(hasChildren);
        m_popup.show(gameNode, x, y);
        m_popupLocation = m_popup.getLocationOnScreen();
    }

    private void showSubtree(ConstNode root)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(206);if ((NodeUtil.subtreeGreaterThan(root, 10000)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(208) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(207);String mainMessage = i18n("MSG_TREE_EXPAND_LARGE");
            String optionalMessage = i18n("MSG_TREE_EXPAND_LARGE_2");
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(209);if ((! m_messageDialogs.showWarningQuestion(m_owner, mainMessage,
                                                       optionalMessage,
                                                       i18n("LB_TREE_EXPAND"),
                                                       true)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(211) && false))
                {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(210);return;}
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(212);boolean changed = false;
        ConstNode node = root;
        int depth = NodeUtil.getDepth(node);
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(213);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(215) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(214);if ((m_isExpanded.add(node)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(224) && false))
                {$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(223);changed = true;}
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(225);node = NodeUtil.nextNode(node, depth);
        }
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(216);if ((changed) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(218) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(217);update(m_tree, m_currentNode, m_minWidth, m_minHeight);
            // Game node could have disappeared, because after out of memory
            // error all nodes are hidden but main variation
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(219);if ((getGameTreeNode(root) == null) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(221) && false))
            {
                $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(220);ensureVisible(root);
                update(m_tree, m_currentNode, m_minWidth, m_minHeight);
            }
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(222);scrollTo(root);
        }
    }

    private void showChildren(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(226);if ((m_isExpanded.add(node)) ? true : (!$qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(228) && false))
        {
            $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(227);update(m_tree, m_currentNode, m_minWidth, m_minHeight);
            scrollTo(node);
        }
    }

    private void treeInfo(Point location, ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_4cb8052fdd5181b5(229);String treeInfo = NodeUtil.treeInfo(node);
        String title = i18n("TIT_SUBTREE_INFO");
        TextViewer textViewer = new TextViewer(m_owner, title, treeInfo, true,
                                               null);
        textViewer.setLocation(location);
        textViewer.setVisible(true);
    }
}
