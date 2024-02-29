/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiBoard.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;
import net.sf.gogui.boardpainter.BoardPainter;
import net.sf.gogui.boardpainter.ConstField;
import net.sf.gogui.boardpainter.Field;
import net.sf.gogui.go.BoardConstants;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.ObjectUtil;

/** Graphical display of a Go board.
    This class does not use go.Board, so it can be used with other board
    implementations. It uses go.GoPoint for coordinates. */
public final class GuiBoard
    extends JPanel
    implements ConstGuiBoard, Printable
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiBoard.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 9140554005828889898L,/* translation unit id   */ 6720031668632570102L,/* timestamp             */ 1709177902350L,/* source file name      */ "GuiBoard.java",/* probe size            */ 292);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_5d425932c83848f6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Callback for clicks on a field. */
    public interface Listener
    {
        /** Callback for click on a field.
            This callback is triggered with mouse clicks or the enter key
            if the cursor is shown.
            @param p The point clicked.
            @param modifiedSelect Modified select. True if the click was a
            double click or with the right mouse button or if a modifier key
            (Ctrl, Alt, Meta) was pressed while clicking, as long as it was
            not a (platform-dependent) popup menu trigger. */
        void fieldClicked(GoPoint p, boolean modifiedSelect);

        /** Callback for context menu.
            This callback is triggered with mouse clicks that trigger
            popup menus (platform-dependent).
            @param point The point clicked.
            @param invoker The awt.Component that was clicked on.
            @param x The x coordinate on the invoker component.
            @param y The y coordinate on the invoker component. */
        void contextMenu(GoPoint point, Component invoker, int x, int y);
    }

    /** Constructor.
        @param size The board size. */
    public GuiBoard(int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(0);m_painter = new BoardPainter();
        setPreferredFieldSize();
        initSize(size);
    }

    /** Clear every kind of markup. */
    public void clearAll()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(1);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(3) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(2);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(6) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(5);setFieldBackground(GoPoint.get(x, y), null);}}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(4);clearAllCrossHair();
        clearAllMarkup();
        clearAllSelect();
        clearAllInfluence();
        clearAllLabels();
        clearAllGhostStones();
        clearAllTerritory();
        clearLastMove();
    }

    /** Clear all crosshairs. */
    public void clearAllCrossHair()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(7);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(9) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(8);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(11) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(10);setCrossHair(GoPoint.get(x, y), false);}}
    }

    public void clearAllInfluence()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(12);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(14) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(13);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(16) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(15);clearInfluence(GoPoint.get(x, y));}}
    }

    /** Clear all markup.
        Clears mark, circle, square, triangle on all points. */
    public void clearAllMarkup()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(17);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(19) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(18);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(21) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_5d425932c83848f6(20);GoPoint point = GoPoint.get(x, y);
                setMark(point, false);
                setMarkCircle(point, false);
                setMarkSquare(point, false);
                setMarkTriangle(point, false);
            }}
    }

    /** Clear all selected points. */
    public void clearAllSelect()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(22);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(24) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(23);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(26) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(25);setSelect(GoPoint.get(x, y), false);}}
    }

    /** Clear all labels. */
    public void clearAllLabels()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(27);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(29) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(28);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(31) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(30);setLabel(GoPoint.get(x, y), "");}}
    }

    /** Clear all shadow stones. */
    public void clearAllGhostStones()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(32);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(34) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(33);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(36) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(35);setGhostStone(GoPoint.get(x, y), null);}}
    }

    /** Clear all territory. */
    public void clearAllTerritory()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(37);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(39) && false); ++x)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(38);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(41) && false); ++y)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(40);setTerritory(GoPoint.get(x, y), EMPTY);}}
    }

    /** Clear influence. */
    public void clearInfluence(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(42);getField(point).clearInfluence();
        repaint(point);
    }

    /** Trigger the context menu callback at the listener. */
    public void contextMenu(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(43);m_panel.contextMenu(point);
    }

    /** Get current board size. */
    @Override
	public int getBoardSize()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(44);return m_size;
    }

    /** Return a field.
        Returns only a const interface to the field, the field state should
        be modified using GuiBoard functions to guarantee the UI repaint after
        field changes. */
    @Override
	public ConstField getFieldConst(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(45);return getField(p);
    }

    @Override
	public Dimension getFieldSize()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(46);int size = m_painter.getFieldSize();
        return new Dimension(size, size);
    }

    /** Get label.
        @param point The point.
        @return Label or null if point has no label. */
    @Override
	public String getLabel(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(47);return getField(point).getLabel();
    }

    /** Get location on screen for a point.
        @param point The point.
        @return Location on screen of center of point. */
    @Override
	public Point getLocationOnScreen(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(48);Point center = m_painter.getCenter(point.getX(), point.getY());
        Point location = m_panel.getLocationOnScreen();
        location.x += center.x;
        location.y += center.y;
        return location;
    }

    /** Check if point is marked.
        This unspecified mark uses a diagonal cross.
        @param point The point.
        @return true, if point is marked. */
    @Override
	public boolean getMark(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(49);return getField(point).getMark();
    }

    /** Check if point is marked with a circle.
        @param point The point.
        @return true, if point is marked with a circle. */
    @Override
	public boolean getMarkCircle(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(50);return getField(point).getMarkCircle();
    }

    /** Check if point is marked with a square.
        @param point The point.
        @return true, if point is marked with a square. */
    @Override
	public boolean getMarkSquare(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(51);return getField(point).getMarkSquare();
    }

    /** Check if point is marked with a triangle.
        @param point The point.
        @return true, if point is marked with a triangle. */
    @Override
	public boolean getMarkTriangle(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(52);return getField(point).getMarkTriangle();
    }

    public Dimension getMinimumFieldSize()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(53);return m_minimumFieldSize;
    }

    public Dimension getPreferredFieldSize()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(54);return m_preferredFieldSize;
    }

    /** Check if point is selected.
        @param point The point.
        @return true, if point is selected. */
    @Override
	public boolean getSelect(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(55);return getField(point).getSelect();
    }

    /** Check if cursor is shown.
        @return true, if cursor is shown. */
    @Override
	public boolean getShowCursor()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(56);return m_showCursor;
    }

    @Override
	public boolean getShowGrid()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(57);return m_showGrid;
    }

    /** Change the board size.
        @param size The new board size. */
    public void initSize(int size)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(58);assert size > 0 && size <= GoPoint.MAX_SIZE;
        m_size = size;
        m_constants = BoardConstants.get(size);
        m_field = new Field[size][size];
        removeAll();
        m_cursor = null;
        setLayout(new SquareLayout());
        m_panel = new BoardPanel();
        m_panel.addFocusListener(new FocusAdapter() {
                @Override
				public void focusGained(FocusEvent event) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(59);if ((getShowCursor()) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(61) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(60);setCursor(m_cursor, true);}
                }

                @Override
				public void focusLost(FocusEvent event) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(62);if ((getShowCursor()) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(64) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(63);setCursor(m_cursor, false);}
                }
            });
        addFocusListener(new FocusAdapter() {
                @Override
				public void focusGained(FocusEvent event) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(65);m_panel.requestFocusInWindow();
                }
            });
        add(m_panel);
        m_panel.requestFocusInWindow();
        m_panel.addKeyListener(new KeyAdapter() {
                @Override
				public void keyPressed(KeyEvent event) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(66);GuiBoard.this.keyPressed(event);
                }
            });
        m_panel.addMouseListener(new MouseAdapter() {
                @Override
				public void mousePressed(MouseEvent e) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(67);GoPoint point = m_panel.getPoint(e);
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(68);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(70) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(69);return;}
                    // mousePressed and mouseReleased (platform dependency)
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(71);if ((e.isPopupTrigger()) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(73) && false))
                    {
                        $qualityscroll_cover_jacov_probe_5d425932c83848f6(72);contextMenu(point);
                        return;
                    }
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(74);int button = e.getButton();
                    int count = e.getClickCount();
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(75);if ((button != MouseEvent.BUTTON1) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(77) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(76);return;}
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(78);if ((count == 2) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(80) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(79);fieldClicked(point, true);}
                    else
                    {
                        $qualityscroll_cover_jacov_probe_5d425932c83848f6(81);int modifiers = e.getModifiers();
                        int mask = (ActionEvent.CTRL_MASK
                                    | ActionEvent.ALT_MASK
                                    | ActionEvent.META_MASK);
                        boolean modifiedSelect = ((modifiers & mask) != 0);
                        fieldClicked(point, modifiedSelect);
                    }
                }

                @Override
				public void mouseReleased(MouseEvent e) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(82);GoPoint point = m_panel.getPoint(e);
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(83);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(85) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(84);return;}
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(86);if ((e.isPopupTrigger()) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(88) && false))
                    {
                        $qualityscroll_cover_jacov_probe_5d425932c83848f6(87);contextMenu(point);
                        return;
                    }
                }
            });
        m_panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
				public void mouseMoved(MouseEvent e) {
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(89);m_panel.setToolTipText(null);
                    GoPoint point = m_panel.getPoint(e);
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(90);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(92) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(91);return;}
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(93);String label = getField(point).getLabel();
                    $qualityscroll_cover_jacov_probe_5d425932c83848f6(94);if ((label != null && label.length() > 3) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(96) && false))
                        {$qualityscroll_cover_jacov_probe_5d425932c83848f6(95);m_panel.setToolTipText(label);}
                }
            });
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(97);for (int y = size - 1; (y >= 0) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(99) && false); --y)
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(98);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(102) && false); ++x)
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(101);m_field[x][y] = new Field();}}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(100);m_lastMove = null;
        setCursor(GoPoint.get(m_size / 2, m_size / 2));
        revalidate();
        m_dirty = new Rectangle(0, 0, getWidth(), getHeight());
        repaint();
    }

    /** Mark point of last move on the board.
        The last move marker will be removed, if the parameter is null. */
    public void markLastMove(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(103);clearLastMove();
        m_lastMove = point;
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(104);if ((m_lastMove != null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(106) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(105);Field field = getField(m_lastMove);
            field.setLastMoveMarker(true);
            repaint(point);
            m_lastMove = point;
        }
    }

    public void paintImmediately(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(107);m_panel.paintImmediately(point);
    }

    @Override
	public int print(Graphics g, PageFormat format, int page)
        throws PrinterException
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(108);if ((page >= 1) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(110) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(109);return Printable.NO_SUCH_PAGE;
        }
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(111);double width = getSize().width;
        double height = getSize().height;
        double pageWidth = format.getImageableWidth();
        double pageHeight = format.getImageableHeight();
        double scale = 1;
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(112);if ((width >= pageWidth) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(114) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(113);scale = pageWidth / width;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(115);double xSpace = (pageWidth - width * scale) / 2;
        double ySpace = (pageHeight - height * scale) / 2;
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(format.getImageableX() + xSpace,
                      format.getImageableY() + ySpace);
        g2d.scale(scale, scale);
        print(g2d);
        return Printable.PAGE_EXISTS;
    }

    /** Set or remove stone.
        @param point The point.
        @param color The stone color or EMPTY to remove a stone,
        if existing. */
    public void setColor(GoPoint point, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(116);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(117);if ((field.getColor() != color) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(119) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(118);field.setColor(color);
            m_panel.repaintWithShadow(point);
        }
    }

    /** Set the cursor.
        @param point New location of the cursor. */
    public void setCursor(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(120);if ((point != null && ! point.isOnBoard(m_size)) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(122) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(121);point = null;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(123);if ((! GoPoint.equals(m_cursor, point)) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(125) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(124);setCursor(m_cursor, false);
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(126);if ((getShowCursor()) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(128) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(127);setCursor(point, true);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(129);m_cursor = point;
        }
    }

    /** Set the field background color.
        @param point The location of the field.
        @param color The color. */
    public void setFieldBackground(GoPoint point, Color color)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(130);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(131);if (((field.getFieldBackground() == null && color != null)
            || (field.getFieldBackground() != null
                && ! field.getFieldBackground().equals(color))) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(133) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(132);field.setFieldBackground(color);
            repaint(point);
        }
    }

    /** Set crosshair.
        @param point The point.
        @param crossHair True to set, false to remove crosshair. */
    public void setCrossHair(GoPoint point, boolean crossHair)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(134);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(135);if ((field.getCrossHair() != crossHair) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(137) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(136);field.setCrossHair(crossHair);
            repaint(point);
        }
    }

    public void setGhostStone(GoPoint point, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(138);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(139);if ((! ObjectUtil.equals(field.getGhostStone(), color)) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(141) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(140);field.setGhostStone(color);
            m_panel.repaintWithShadow(point);
        }
    }

    /** Set influence value.
        @param point The point.
        @param value The influence value between -1 and 1. */
    public void setInfluence(GoPoint point, double value)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(142);getField(point).setInfluence(value);
        repaint(point);
    }

    /** Set label.
        @param point The point.
        @param label The label. Should not be longer than 3 characters to
        avoid clipping. null to remove label. */
    public void setLabel(GoPoint point, String label)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(143);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(144);if (((field.getLabel() == null && label != null)
            || (field.getLabel() != null
                && ! field.getLabel().equals(label))) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(146) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(145);field.setLabel(label);
            repaint(point);
        }
    }

    /** Set the listener.
        @param listener The new listener; null to set no listener. */
    public void setListener(Listener listener)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(147);m_listener = listener;
    }

    /** Set markup.
        This unspecified markup uses a diagonal cross.
        @param point The point.
        @param mark True to set, false to remove. */
    public void setMark(GoPoint point, boolean mark)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(148);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(149);if ((field.getMark() != mark) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(151) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(150);getField(point).setMark(mark);
            repaint(point);
        }
    }

    /** Set circle markup.
        @param point The point.
        @param mark True to set, false to remove. */
    public void setMarkCircle(GoPoint point, boolean mark)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(152);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(153);if ((field.getMarkCircle() != mark) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(155) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(154);getField(point).setMarkCircle(mark);
            repaint(point);
        }
    }

    /** Set square markup.
        @param point The point.
        @param mark True to set, false to remove. */
    public void setMarkSquare(GoPoint point, boolean mark)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(156);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(157);if ((field.getMarkSquare() != mark) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(159) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(158);getField(point).setMarkSquare(mark);
            repaint(point);
        }
    }

    /** Set triangle markup.
        @param point The point.
        @param mark True to set, false to remove. */
    public void setMarkTriangle(GoPoint point, boolean mark)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(160);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(161);if ((field.getMarkTriangle() != mark) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(163) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(162);getField(point).setMarkTriangle(mark);
            repaint(point);
        }
    }

    public void setPreferredFieldSize(Dimension size)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(164);m_preferredFieldSize = size;
        m_panel.setPreferredFieldSize();
    }

    /** Set point selection markup.
        @param point The point.
        @param select True to set, false to remove. */
    public void setSelect(GoPoint point, boolean select)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(165);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(166);if ((field.getSelect() != select) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(168) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(167);getField(point).setSelect(select);
            repaint(point);
        }
    }

    /** Enable or disable cursor.
        @param showCursor true to enable cursor. */
    public void setShowCursor(boolean showCursor)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(169);setCursor(m_cursor, false);
        m_showCursor = showCursor;
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(170);if ((m_showCursor) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(172) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(171);setCursor(m_cursor, true);}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(173);m_panel.requestFocusInWindow();
    }

    /** Enable or disable grid coordinates.
        @param showGrid true to enable grid coordinates. */
    public void setShowGrid(boolean showGrid)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(174);if ((showGrid != m_showGrid) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(176) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(175);m_showGrid = showGrid;
            m_dirty = new Rectangle(0, 0, getWidth(), getHeight());
            repaint();
        }
    }

    /** Set territory.
        @param point The point.
        @param color The territory color for this point; EMPTY for
        no territory. */
    public void setTerritory(GoPoint point, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(177);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(178);if ((field.getTerritory() != color) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(180) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(179);field.setTerritory(color);
            repaint(point);
        }
    }

    private class BoardPanel
        extends JPanel
    {
        public BoardPanel()
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(181);setPreferredFieldSize();
            setFocusable(true);
            setOpaque(true);
        }

        public void contextMenu(GoPoint point)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(182);if ((m_listener == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(184) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(183);return;}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(185);Point center = m_painter.getCenter(point.getX(), point.getY());
            m_listener.contextMenu(point, this, center.x, center.y);
        }

        public GoPoint getPoint(MouseEvent event)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(186);return m_painter.getPoint(event.getPoint());
        }

        @Override
		public void paintComponent(Graphics graphics)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(187);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(189) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(188);System.err.println("BoardPanel.paintComponent "
                                   + graphics.getClipBounds().x + " "
                                   + graphics.getClipBounds().y + " "
                                   + graphics.getClipBounds().width + " "
                                   + graphics.getClipBounds().height);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(190);int width = getWidth();
            int height = getHeight();
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(191);if ((m_image == null || width != m_imageWidth
                || height != m_imageHeight) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(193) && false))
            {
                $qualityscroll_cover_jacov_probe_5d425932c83848f6(192);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(195) && false))
                    {$qualityscroll_cover_jacov_probe_5d425932c83848f6(194);System.err.println("createImage " + width + " " + height);}
                $qualityscroll_cover_jacov_probe_5d425932c83848f6(196);m_image = createImage(width, height);
                m_imageWidth = width;
                m_imageHeight = height;
                m_dirty = new Rectangle(0, 0, width, height);
            }
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(197);drawImage();
            graphics.drawImage(m_image, 0, 0, null);
        }

        public void paintImmediately(GoPoint point)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(198);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(200) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(199);System.err.println("paintImmediately " + point);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(201);Point location = m_painter.getLocation(point.getX(), point.getY());
            Rectangle dirty = new Rectangle();
            dirty.x = location.x;
            dirty.y = location.y;
            int offset = m_painter.getShadowOffset()
                - Field.getStoneMargin(m_painter.getFieldSize());
            dirty.width = m_painter.getFieldSize() + offset;
            dirty.height = m_painter.getFieldSize() + offset;
            addDirty(dirty);
            Rectangle oldDirty = m_dirty;
            m_dirty = dirty;
            paintImmediately(dirty);
            m_dirty = oldDirty;
        }

        public void repaint(GoPoint point)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(202);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(204) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(203);System.err.println("repaint " + point);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(205);Point location = m_painter.getLocation(point.getX(), point.getY());
            Rectangle dirty = new Rectangle();
            dirty.x = location.x;
            dirty.y = location.y;
            dirty.width = m_painter.getFieldSize();
            dirty.height = m_painter.getFieldSize();
            addDirty(dirty);
            repaint(dirty);
        }

        public void repaintWithShadow(GoPoint point)
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(206);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(208) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(207);System.err.println("repaintWithShadow " + point);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(209);Point location = m_painter.getLocation(point.getX(), point.getY());
            Rectangle dirty = new Rectangle();
            dirty.x = location.x;
            dirty.y = location.y;
            int offset = m_painter.getShadowOffset()
                - Field.getStoneMargin(m_painter.getFieldSize());
            dirty.width = m_painter.getFieldSize() + offset;
            dirty.height = m_painter.getFieldSize() + offset;
            addDirty(dirty);
            repaint(dirty);
        }

        public final void setPreferredFieldSize()
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(210);int preferredFieldSize = getPreferredFieldSize().width;
            setPreferredSize(BoardPainter.getPreferredSize(preferredFieldSize,
                                                          m_size, m_showGrid));
            int minimumSize = 4 * m_size + 2;
            setMinimumSize(new Dimension(minimumSize, minimumSize));
        }
    }

    private static final boolean DEBUG_REPAINT = false;

    private boolean m_showCursor = true;

    private boolean m_showGrid = true;

    private int m_imageHeight;

    private int m_imageWidth;

    private int m_size;

    private BoardConstants m_constants;

    private BoardPanel m_panel;

    private Dimension m_minimumFieldSize;

    private Dimension m_preferredFieldSize;

    private GoPoint m_cursor;

    private GoPoint m_lastMove;

    private final BoardPainter m_painter;

    private Field m_field[][];

    private Image m_image;

    private Listener m_listener;

    private Rectangle m_dirty = new Rectangle();

    private void addDirty(Rectangle rectangle)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(211);if ((m_dirty == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(213) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(212);m_dirty = rectangle;}
        else
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(214);m_dirty.add(rectangle);}
    }

    private void clearLastMove()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(215);if ((m_lastMove != null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(217) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(216);Field field = getField(m_lastMove);
            field.setLastMoveMarker(false);
            repaint(m_lastMove);
            m_lastMove = null;
        }
    }

    private void drawImage()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(218);if ((m_image == null || m_dirty == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(220) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(219);return;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(221);if ((DEBUG_REPAINT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(223) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(222);System.err.println("BoardPanel.drawImage " + m_dirty.x + " "
                               + m_dirty.y + " " + m_dirty.width + " "
                               + m_dirty.height);}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(224);Graphics graphics = m_image.getGraphics();
        graphics.setClip(m_dirty);
        m_painter.draw(graphics, m_field, m_imageWidth, m_showGrid);
        m_dirty = null;
    }

    private void fieldClicked(GoPoint p, boolean modifiedSelect)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(225);if ((m_listener != null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(227) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(226);m_listener.fieldClicked(p, modifiedSelect);}
    }

    private Field getField(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(228);assert p != null;
        return m_field[p.getX()][p.getY()];
    }

    private boolean isHandicapLineOrEdge(int line)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(229);return m_constants.isHandicapLine(line)
            || m_constants.isEdgeLine(line);
    }

    private void keyPressed(KeyEvent event)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(230);int code = event.getKeyCode();
        int modifiers = event.getModifiers();
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(231);if ((code == KeyEvent.VK_ENTER) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(233) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(232);int mask = (ActionEvent.CTRL_MASK
                        | ActionEvent.ALT_MASK
                        | ActionEvent.META_MASK);
            boolean modifiedSelect = ((modifiers & mask) != 0);
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(234);if ((getShowCursor() && m_cursor != null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(236) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(235);fieldClicked(m_cursor, modifiedSelect);}
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(237);return;
        }
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(238);if (((modifiers & ActionEvent.CTRL_MASK) != 0
            || ! getShowCursor() || m_cursor == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(240) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(239);return;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(241);boolean shiftModifier = ((modifiers & ActionEvent.SHIFT_MASK) != 0);
        GoPoint point = m_cursor;
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(242);if ((code == KeyEvent.VK_DOWN) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(244) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(243);point = point.down();
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(245);if ((shiftModifier) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(247) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(246);while ((! isHandicapLineOrEdge(point.getY())) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(249) && false))
                    {$qualityscroll_cover_jacov_probe_5d425932c83848f6(248);point = point.down();}}
        }
        else {$qualityscroll_cover_jacov_probe_5d425932c83848f6(251);if ((code == KeyEvent.VK_UP) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(253) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(252);point = point.up(m_size);
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(254);if ((shiftModifier) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(256) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(255);while ((! isHandicapLineOrEdge(point.getY())) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(258) && false))
                    {$qualityscroll_cover_jacov_probe_5d425932c83848f6(257);point = point.up(m_size);}}
        }
        else {$qualityscroll_cover_jacov_probe_5d425932c83848f6(259);if ((code == KeyEvent.VK_LEFT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(261) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(260);point = point.left();
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(262);if ((shiftModifier) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(264) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(263);while ((! isHandicapLineOrEdge(point.getX())) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(266) && false))
                    {$qualityscroll_cover_jacov_probe_5d425932c83848f6(265);point = point.left();}}
        }
        else {$qualityscroll_cover_jacov_probe_5d425932c83848f6(267);if ((code == KeyEvent.VK_RIGHT) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(269) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(268);point = point.right(m_size);
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(270);if ((shiftModifier) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(272) && false))
                {$qualityscroll_cover_jacov_probe_5d425932c83848f6(271);while ((! isHandicapLineOrEdge(point.getX())) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(274) && false))
                    {$qualityscroll_cover_jacov_probe_5d425932c83848f6(273);point = point.right(m_size);}}
        }}}}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(250);setCursor(point);
    }

    private void repaint(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(275);m_panel.repaint(point);
    }

    private void setCursor(GoPoint point, boolean cursor)
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(276);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(278) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(277);return;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(279);Field field = getField(point);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(280);if ((field.getCursor() != cursor) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(282) && false))
        {
            $qualityscroll_cover_jacov_probe_5d425932c83848f6(281);field.setCursor(cursor);
            repaint(point);
        }
    }

    private void setPreferredFieldSize()
    {
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(283);int size = (int)(GuiUtil.getDefaultMonoFontSize() * 2.5);
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(284);if ((size % 2 == 0) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(286) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(285);++size;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(287);m_preferredFieldSize = new Dimension(size, size);
        size = GuiUtil.getDefaultMonoFontSize();
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(288);if ((size % 2 == 0) ? true : (!$qualityscroll_cover_jacov_probe_5d425932c83848f6(290) && false))
            {$qualityscroll_cover_jacov_probe_5d425932c83848f6(289);++size;}
        $qualityscroll_cover_jacov_probe_5d425932c83848f6(291);m_minimumFieldSize = new Dimension(size, size);
    }
}
