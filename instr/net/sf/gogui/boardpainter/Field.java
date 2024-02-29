/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// Field.java

package net.sf.gogui.boardpainter;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.font.LineMetrics;
import java.awt.geom.Point2D;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;

/** State of a field on the board. */
public class Field
    implements ConstField
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Field.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5285692283392135311L,/* translation unit id   */ -5018503876749967128L,/* timestamp             */ 1709177899626L,/* source file name      */ "Field.java",/* probe size            */ 199);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Field()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(0);
    }

    public void clearInfluence()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(1);m_influenceSet = false;
        m_influence = 0;
    }

    @Override
	public void draw(Graphics graphics, int size, int x, int y,
                     Image boardImage, int boardWidth)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(2);if ((! graphics.hitClip(x, y, size, size)) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(4) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(3);return;}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(5);m_graphics = graphics.create(x, y, size, size);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(6);if ((m_graphics instanceof Graphics2D) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(8) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(7);m_graphics2D = (Graphics2D)m_graphics;}
        else
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(45);m_graphics2D = null;}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(9);m_size = size;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(10);if ((m_fieldColor != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(12) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(11);drawFieldColor();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(13);if ((m_territory != EMPTY && m_graphics2D == null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(15) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(14);drawTerritoryGraphics();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(16);if ((m_color != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(18) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(17);drawStone(m_color, false);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(19);if ((m_ghostStone != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(21) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(20);drawStone(m_ghostStone, true);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(22);if ((m_label != null && ! m_label.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(24) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(23);drawLabel(x, y, graphics, boardImage, boardWidth);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(25);if ((m_territory != EMPTY && m_graphics2D != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(27) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(26);drawTerritoryGraphics2D();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(28);if ((m_influenceSet) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(30) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(29);drawInfluence();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(31);drawMarks();
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(32);if ((m_crossHair) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(34) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(33);drawCrossHair();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(35);if ((m_lastMoveMarker) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(37) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(36);drawLastMoveMarker();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(38);if ((m_select) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(40) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(39);drawSelect();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(41);if ((m_cursor) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(43) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(42);drawCursor();}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(44);m_graphics = null;
    }

    @Override
	public GoColor getColor()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(46);return m_color;
    }

    @Override
	public boolean getCursor()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(47);return m_cursor;
    }

    @Override
	public boolean getCrossHair()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(48);return m_crossHair;
    }

    @Override
	public Color getFieldBackground()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(49);return m_fieldColor;
    }

    @Override
	public boolean getMark()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(50);return m_mark;
    }

    @Override
	public boolean getMarkCircle()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(51);return m_markCircle;
    }

    @Override
	public boolean getMarkSquare()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(52);return m_markSquare;
    }

    @Override
	public boolean getMarkTriangle()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(53);return m_markTriangle;
    }

    @Override
	public boolean getSelect()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(54);return m_select;
    }

    /** @see #setGhostStone */
    @Override
	public GoColor getGhostStone()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(55);return m_ghostStone;
    }

    public static int getStoneMargin(int size)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(56);return size / 17;
    }

    @Override
	public String getLabel()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(57);return m_label;
    }

    @Override
	public GoColor getTerritory()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(58);return m_territory;
    }

    @Override
	public boolean isInfluenceSet()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(59);return m_influenceSet;
    }

    public void setFieldBackground(Color color)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(60);m_fieldColor = color;
    }

    public void setColor(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(61);m_color = color;
    }

    public void setCrossHair(boolean crossHair)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(62);m_crossHair = crossHair;
    }

    public void setCursor(boolean cursor)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(63);m_cursor = cursor;
    }

    public void setInfluence(double value)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(64);if ((value > 1.) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(66) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(65);value = 1.;}
        else {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(68);if ((value < -1.) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(70) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(69);value = -1.;}}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(67);m_influence = value;
        m_influenceSet = true;
    }

    public void setLastMoveMarker(boolean lastMoveMarker)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(71);m_lastMoveMarker = lastMoveMarker;
    }

    public void setMark(boolean mark)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(72);m_mark = mark;
    }

    public void setMarkCircle(boolean mark)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(73);m_markCircle = mark;
    }

    public void setMarkSquare(boolean mark)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(74);m_markSquare = mark;
    }

    public void setMarkTriangle(boolean mark)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(75);m_markTriangle = mark;
    }

    public void setSelect(boolean select)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(76);m_select = select;
    }

    /** Set a shadow stone at this field.
        A shadow stone is a stone which is drawn with some transparency.
        It can be used to display stones which are not part of the current
        board position (e.g. search variations)
        @param color The color of the shadow stone or null to remove a
        shadow stone. */
    public void setGhostStone(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(77);m_ghostStone = color;
    }

    public void setLabel(String s)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(78);m_label = s;
    }

    public void setTerritory(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(79);assert color != null;
        m_territory = color;
    }

    private boolean m_crossHair;

    private boolean m_cursor;

    private boolean m_lastMoveMarker;

    private boolean m_mark;

    private boolean m_markCircle;

    private boolean m_markSquare;

    private boolean m_markTriangle;

    private boolean m_influenceSet;

    private boolean m_select;

    private static int s_cachedFontFieldSize;

    private int m_paintSizeBlack;

    private int m_paintSizeWhite;

    private int m_size;

    private double m_influence;

    private static final AlphaComposite COMPOSITE_4
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);

    private static final AlphaComposite COMPOSITE_5
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

    private static final AlphaComposite COMPOSITE_6
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);

    private static final AlphaComposite COMPOSITE_7
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);

    private static final AlphaComposite COMPOSITE_8
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);

    private static final AlphaComposite COMPOSITE_95
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.95f);

    private static final AlphaComposite COMPOSITE_97
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.97f);

    private static final Stroke THICK_STROKE
        = new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    private String m_label = "";

    private Color m_fieldColor;

    private GoColor m_territory = EMPTY;

    private static final Color COLOR_INFLUENCE_BLACK = Color.gray;

    private static final Color COLOR_INFLUENCE_WHITE = Color.white;

    private static final Color COLOR_LAST_MOVE
        = Color.decode("#888888");

    private static final Color COLOR_MARK = Color.decode("#4040ff");

    private static final Color COLOR_STONE_BLACK = Color.decode("#3b3d3a");

    private static final Color COLOR_STONE_BLACK_BRIGHT
        = Color.decode("#99998c");

    private static final Color COLOR_STONE_WHITE = Color.decode("#d3d7cf");

    private static final Color COLOR_STONE_WHITE_BRIGHT
        = Color.decode("#ffffff");

    private static Font s_cachedFont;

    private GoColor m_color = EMPTY;

    private GoColor m_ghostStone;

    private Graphics m_graphics;

    private Graphics2D m_graphics2D;

    private RadialGradientPaint m_paintBlack;

    private RadialGradientPaint m_paintWhite;

    private void drawCircle(Color color)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(80);m_graphics.setColor(color);
        int d = m_size * 4 / 10;
        int w = m_size - 2 * d;
        m_graphics.fillOval(d, d, w, w);
    }

    private void drawCrossHair()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(81);setComposite(COMPOSITE_7);
        int d = m_size / 5;
        int center = m_size / 2;
        m_graphics.setColor(Color.red);
        m_graphics.drawLine(d, center, m_size - d, center);
        m_graphics.drawLine(center, d, center, m_size - d);
        m_graphics.setPaintMode();
    }

    private void drawCursor()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(82);setComposite(COMPOSITE_7);
        int d = m_size / 6;
        int w = m_size;
        int d2 = 2 * d;
        m_graphics.setColor(COLOR_LAST_MOVE);
        Stroke oldStroke = null;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(83);if ((m_graphics2D != null && m_size > 10) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(85) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(84);oldStroke = m_graphics2D.getStroke();
            m_graphics2D.setStroke(THICK_STROKE);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(86);m_graphics.drawLine(d, d, d2, d);
        m_graphics.drawLine(d, d, d, d2);
        m_graphics.drawLine(d, w - d2 - 1, d, w - d - 1);
        m_graphics.drawLine(d, w - d - 1, d2, w - d - 1);
        m_graphics.drawLine(w - d2 - 1, d, w - d - 1, d);
        m_graphics.drawLine(w - d - 1, d, w - d - 1, d2);
        m_graphics.drawLine(w - d - 1, w - d - 1, w - d - 1, w - d2 - 1);
        m_graphics.drawLine(w - d - 1, w - d - 1, w - d2 - 1, w - d - 1);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(87);if ((oldStroke != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(89) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(88);m_graphics2D.setStroke(oldStroke);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(90);m_graphics.setPaintMode();
    }

    private void drawFieldColor()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(91);setComposite(COMPOSITE_5);
        m_graphics.setColor(m_fieldColor);
        m_graphics.fillRect(0, 0, m_size, m_size);
        m_graphics.setPaintMode();
    }

    private void drawInfluence()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(92);double d = Math.abs(m_influence);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(93);if ((d < 0.01) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(95) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(94);return;}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(96);setComposite(COMPOSITE_6);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(97);if ((m_influence > 0) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(99) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(98);m_graphics.setColor(COLOR_INFLUENCE_BLACK);}
        else
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(101);m_graphics.setColor(COLOR_INFLUENCE_WHITE);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(100);int dd = (int)(m_size * (0.38 + (1 - d) * 0.62));
        int width = m_size - dd;
        m_graphics.fillRect(dd / 2, dd / 2, width, width);
    }

    private void drawLabel(int fieldX, int fieldY, Graphics boardGraphics,
                           Image boardImage, int boardWidth)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(102);setComposite(COMPOSITE_97);
        setFont(m_graphics, m_size);
        FontMetrics fontMetrics = m_graphics.getFontMetrics();
        LineMetrics lineMetrics =
            fontMetrics.getLineMetrics(m_label, m_graphics);
        int width = fontMetrics.stringWidth(m_label);
        int height = fontMetrics.getHeight();
        int ascent = (int)lineMetrics.getAscent();
        int x = Math.max((m_size - width) / 2, 0);
        int y = (ascent + m_size) / 2;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(103);if ((m_ghostStone == null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(105) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(104);if ((m_color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(107) && false))
                {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(106);m_graphics.setColor(Color.white);}
            else
                {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(117);m_graphics.setColor(Color.black);}
        }
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(118);if ((m_ghostStone == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(120) && false))
                {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(119);m_graphics.setColor(Color.white);}
            else
                {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(121);m_graphics.setColor(Color.black);}
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(108);Rectangle oldClip = m_graphics.getClipBounds();
        width = Math.min(width, (int)(0.95 * m_size));
        m_graphics.setClip(x, y - ascent, width, height);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(109);if ((m_color == EMPTY && m_ghostStone == null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(111) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(110);Rectangle oldBoardClip = boardGraphics.getClipBounds();
            boardGraphics.setClip(fieldX + x, fieldY + y - ascent,
                                  width, height);
            boardGraphics.drawImage(boardImage, 0, 0, boardWidth, boardWidth,
                                    null);
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(112);if ((m_fieldColor != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(114) && false))
                {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(113);drawFieldColor();}
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(115);boardGraphics.setClip(oldBoardClip);
            m_graphics.setColor(Color.black);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(116);m_graphics.drawString(m_label, x, y);
        m_graphics.setClip(oldClip);
    }

    private void drawLastMoveMarker()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(122);setComposite(COMPOSITE_7);
        drawCircle(COLOR_LAST_MOVE);
        m_graphics.setPaintMode();
    }

    private void drawMarks()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(123);setComposite(COMPOSITE_95);
        int d = m_size / 4;
        int width = m_size - 2 * d;
        m_graphics.setColor(COLOR_MARK);
        Stroke oldStroke = null;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(124);if ((m_graphics2D != null && m_size > 10) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(126) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(125);oldStroke = m_graphics2D.getStroke();
            m_graphics2D.setStroke(THICK_STROKE);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(127);if ((m_mark) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(129) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(128);m_graphics.drawLine(d, d, d + width, d + width);
            m_graphics.drawLine(d, d + width, d + width, d);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(130);if ((m_markCircle) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(132) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(131);m_graphics.drawOval(d, d, width - 1, width - 1);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(133);if ((m_markSquare) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(135) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(134);m_graphics.drawRect(d, d, width - 1, width - 1);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(136);if ((m_markTriangle) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(138) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(137);int height = (int)(0.866 * width);
            int top = (int)(0.866 * (width - height) / 2);
            int bottom = top + height - 1;
            m_graphics.drawLine(d, d + bottom, d + width / 2, d + top);
            m_graphics.drawLine(d + width / 2, d + top,
                                d + width, d + bottom);
            m_graphics.drawLine(d + width, d + bottom, d, d + bottom);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(139);if ((oldStroke != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(141) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(140);m_graphics2D.setStroke(oldStroke);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(142);m_graphics.setPaintMode();
    }

    private void drawSelect()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(143);setComposite(COMPOSITE_95);
        drawCircle(COLOR_MARK);
        m_graphics.setPaintMode();
    }

    private void drawStone(GoColor color, boolean isGhostStone)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(144);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(146) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(145);drawStone(color, COLOR_STONE_BLACK, COLOR_STONE_BLACK_BRIGHT,
                      isGhostStone);}
        else {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(147);if ((color == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(149) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(148);drawStone(color, COLOR_STONE_WHITE, COLOR_STONE_WHITE_BRIGHT,
                      isGhostStone);}}
    }

    private void drawStone(GoColor color, Color colorNormal,
                           Color colorBright, boolean isGhostStone)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(150);int margin = getStoneMargin(m_size);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(151);if ((m_graphics2D != null && m_size >= 7) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(153) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(152);RadialGradientPaint paint =
                getPaint(color, m_size, colorNormal, colorBright);
            m_graphics2D.setPaint(paint);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(158);m_graphics.setColor(colorNormal);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(154);if ((isGhostStone) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(156) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(155);setComposite(COMPOSITE_8);}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(157);m_graphics.fillOval(margin, margin,
                            m_size - 2 * margin, m_size - 2 * margin);
    }

    private void drawTerritoryGraphics()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(159);if ((m_territory == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(161) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(160);m_graphics.setColor(Color.darkGray);}
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(163);assert m_territory == WHITE;
            m_graphics.setColor(Color.lightGray);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(162);m_graphics.fillRect(0, 0, m_size, m_size);
    }

    private void drawTerritoryGraphics2D()
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(164);setComposite(COMPOSITE_4);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(165);if ((m_territory == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(167) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(166);m_graphics2D.setColor(Color.darkGray);}
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(169);assert m_territory == WHITE;
            m_graphics2D.setColor(Color.white);
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(168);m_graphics2D.fillRect(0, 0, m_size, m_size);
        m_graphics2D.setPaintMode();
    }

    private RadialGradientPaint getPaint(GoColor color, int size,
                                         Color colorNormal,
                                         Color colorBright)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(170);RadialGradientPaint paint;
        int paintSize;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(171);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(173) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(172);paint = m_paintBlack;
            paintSize = m_paintSizeBlack;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(183);assert color == WHITE;
            paint = m_paintWhite;
            paintSize = m_paintSizeWhite;
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(174);if ((size == paintSize && paint != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(176) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(175);return paint;}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(177);Point2D.Double center = new Point2D.Double(0.43 * size, 0.21 * size);
        Point2D.Double radius1 = new Point2D.Double(0.47 * size, -0.15 * size);
        Point2D.Double radius2 = new Point2D.Double(0.08 * size, 0.25 * size);
        double focus = -0.4;
        paint = new RadialGradientPaint(center, radius1, radius2, focus,
                                        colorBright, colorNormal);
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(178);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(180) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(179);m_paintBlack = paint;
            m_paintSizeBlack = size;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(182);m_paintWhite = paint;
            m_paintSizeWhite = size;
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(181);return paint;
    }

    private void setComposite(AlphaComposite composite)
    {
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(184);if ((m_graphics2D != null) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(186) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(185);m_graphics2D.setComposite(composite);}
    }

    private static void setFont(Graphics graphics, int fieldSize)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(187);if ((s_cachedFont != null && s_cachedFontFieldSize == fieldSize) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(189) && false))
        {
            $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(188);graphics.setFont(s_cachedFont);
            return;
        }
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(190);int fontSize;
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(191);if ((fieldSize < 29) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(193) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(192);fontSize = (int)(0.45 * fieldSize);}
        else {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(195);if ((fieldSize < 40) ? true : (!$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(197) && false))
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(196);fontSize = 13;}
        else
            {$qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(198);fontSize = (int)(13 + 0.15 * (fieldSize - 40));}}
        $qualityscroll_cover_jacov_probe_ba5ab1503265c0e8(194);s_cachedFont = new Font("Dialog", Font.PLAIN, fontSize);
        s_cachedFontFieldSize = fieldSize;
        graphics.setFont(s_cachedFont);
    }
}
