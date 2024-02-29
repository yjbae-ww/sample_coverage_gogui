/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// BoardPainter.java

package net.sf.gogui.boardpainter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.net.URL;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.BoardConstants;

/** Draws a board. */
public class BoardPainter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardPainter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1413560201050969229L,/* translation unit id   */ -3508268376539095472L,/* timestamp             */ 1709177899502L,/* source file name      */ "BoardPainter.java",/* probe size            */ 144);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public BoardPainter()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(0);ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("net/sf/gogui/images/wood.png");
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(1);if ((url == null) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(3) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(2);m_image = null;}
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(4);m_image = loadImage(url);}
    }

    /** Draw a board into graphics object.
        @param graphics The graphics object.
        @param field The fields.
        @param width The width/height of the image.
        @param showGrid Show grid coordinates. */
    public void draw(Graphics graphics, ConstField[][] field, int width,
                     boolean showGrid)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(5);if ((graphics instanceof Graphics2D) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(7) && false))
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(6);Graphics2D graphics2D = (Graphics2D)graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(8);m_width = width;
        m_size = field.length;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(9);if ((m_constants == null || m_constants.getSize() != m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(11) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(10);m_constants = BoardConstants.get(m_size);}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(12);assert m_size <= GoPoint.MAX_SIZE;
        double borderSize;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(13);if ((showGrid) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(15) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(14);borderSize = BORDER_SIZE;}
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(21);borderSize = BORDER_SIZE_NOGRID;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(16);m_fieldSize =
            Math.round((float)Math.floor(width / (m_size + 2 * borderSize)));
        m_fieldOffset = (width - m_size * m_fieldSize) / 2;
        drawBackground(graphics);
        drawGrid(graphics);
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(17);if ((showGrid) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(19) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(18);drawGridLabels(graphics);}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(20);drawShadows(graphics, field);
        drawFields(graphics, field);
    }

    public Point getCenter(int x, int y)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(22);Point point = getLocation(x, y);
        point.x += m_fieldSize / 2;
        point.y += m_fieldSize / 2;
        return point;
    }

    public int getFieldSize()
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(23);return m_fieldSize;
    }

    public Point getLocation(int x, int y)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(24);Point point = new Point();
        point.x = m_fieldOffset + x * m_fieldSize;
        point.y = m_fieldOffset + (m_size - y - 1) * m_fieldSize;
        return point;
    }

    public GoPoint getPoint(Point point)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(25);if ((m_fieldSize == 0) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(27) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(26);return null;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(28);int x = ((int)point.getX() - m_fieldOffset) / m_fieldSize;
        int y = ((int)point.getY() - m_fieldOffset) / m_fieldSize;
        y = m_size - y - 1;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(29);if ((x >= 0 && x < m_size && y >= 0 && y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(31) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(30);return GoPoint.get(x, y);}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(32);return null;
    }

    /** Get preferred board size given a preferred field size.
        The drawer can draw any board size. The border has a variable size
        to ensure that all fields have exactly the same size (in pixels).
        If a preferred field size is known (e.g. from a different board size,
        or from the last settings), then using the board size returned by this
        function will draw the board such that the field size is exactly the
        preferred one. */
    public static Dimension getPreferredSize(int preferredFieldSize,
                                             int boardSize, boolean showGrid)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(33);double borderSize;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(34);if ((showGrid) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(36) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(35);borderSize = BORDER_SIZE * preferredFieldSize;}
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(38);borderSize = BORDER_SIZE_NOGRID * preferredFieldSize;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(37);int preferredSize = (preferredFieldSize * boardSize
                             + 2 * Math.round((float)Math.ceil(borderSize)));
        return new Dimension(preferredSize, preferredSize);
    }

    public int getShadowOffset()
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(39);return (m_fieldSize  - 2 * Field.getStoneMargin(m_fieldSize)) / 12;
    }

    /** Preferred border size (in fraction of field size) if grid is drawn. */
    private static final double BORDER_SIZE = 0.6;

    /** Preferred border size (in fraction of field size) if grid is drawn. */
    private static final double BORDER_SIZE_NOGRID = 0.2;

    private int m_fieldSize;

    private int m_fieldOffset;

    private int m_size;

    private int m_width;

    private static int s_cachedFontFieldSize;

    private static final AlphaComposite COMPOSITE_3
        = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);

    private BoardConstants m_constants;

    private final Color m_gridLabelColor = new Color(96, 96, 96);

    private final Color m_gridColor = new Color(80, 80, 80);

    private static Font s_cachedFont;

    private final Image m_image;

    private void drawBackground(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(40);if ((m_image == null) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(42) && false))
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(41);graphics.setColor(new Color(212, 167, 102));
            graphics.fillRect(0, 0, m_width, m_width);
        }
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(43);graphics.drawImage(m_image, 0, 0, m_width, m_width, null);}
    }

    private void drawFields(Graphics graphics, ConstField field[][])
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(44);assert field.length == m_size;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(45);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(47) && false); ++x)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(46);assert field[x].length == m_size;
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(48);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(50) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(49);Point location = getLocation(x, y);
                field[x][y].draw(graphics, m_fieldSize, location.x,
                                 location.y, m_image, m_width);
            }
        }
    }

    private void drawGrid(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(51);if ((m_fieldSize < 2) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(53) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(52);return;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(54);graphics.setColor(Color.darkGray);
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(55);if ((graphics instanceof Graphics2D) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(57) && false))
        {
            // Temporarily disable antialiasing, which causes lines to
            // appear too thick with OpenJDK (version 6b09)
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(56);Graphics2D graphics2D = (Graphics2D)graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(58);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(60) && false); ++y)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(59);if ((y == 0 || y == m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(92) && false))
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(91);graphics.setColor(Color.black);}
            else
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(94);graphics.setColor(m_gridColor);}
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(93);Point left = getCenter(0, y);
            Point right = getCenter(m_size - 1, y);
            graphics.drawLine(left.x, left.y, right.x, right.y);
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(61);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(63) && false); ++x)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(62);if ((x == 0 || x == m_size - 1) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(88) && false))
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(87);graphics.setColor(Color.black);}
            else
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(90);graphics.setColor(m_gridColor);}
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(89);Point top = getCenter(x, 0);
            Point bottom = getCenter(x, m_size - 1);
            graphics.drawLine(top.x, top.y, bottom.x, bottom.y);
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(64);if ((graphics instanceof Graphics2D) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(66) && false))
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(65);Graphics2D graphics2D = (Graphics2D)graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(67);int r;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(68);if ((m_fieldSize <= 7) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(70) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(69);return;}
        else {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(71);if ((m_fieldSize <= 33) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(73) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(72);r = 1;}
        else {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(83);if ((m_fieldSize <= 60) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(85) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(84);r = 2;}
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(86);r = 3;}}}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(74);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(76) && false); ++x)
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(75);if ((m_constants.isHandicapLine(x)) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(78) && false))
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(77);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(80) && false); ++y)
                    {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(79);if ((m_constants.isHandicapLine(y)) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(82) && false))
                    {
                        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(81);Point point = getCenter(x, y);
                        graphics.fillOval(point.x - r, point.y - r,
                                          2 * r + 1, 2 * r + 1);
                    }}}}
    }

    private void drawGridLabels(Graphics graphics)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(95);if ((m_fieldSize < 15) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(97) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(96);return;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(98);graphics.setColor(m_gridLabelColor);
        setFont(graphics, m_fieldSize);
        int offset = (m_fieldSize + m_fieldOffset) / 2;
        Point point;
        char c = 'A';
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(99);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(101) && false); ++x)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(100);String string = Character.toString(c);
            point = getLocation(x, 0);
            point.y += offset;
            drawLabel(graphics, point, string);
            point = getLocation(x, m_size - 1);
            point.y -= offset;
            drawLabel(graphics, point, string);
            ++c;
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(105);if ((c == 'I') ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(107) && false))
                {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(106);++c;}
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(102);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(104) && false); ++y)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(103);String string = Integer.toString(y + 1);
            point = getLocation(0, y);
            point.x -= offset;
            drawLabel(graphics, point, string);
            point = getLocation(m_size - 1, y);
            point.x += offset;
            drawLabel(graphics, point, string);
        }
    }

    private void drawShadows(Graphics graphics, ConstField[][] field)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(108);if ((m_fieldSize <= 5) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(110) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(109);return;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(111);Graphics2D graphics2D =
            ((graphics instanceof Graphics2D) ? ($qualityscroll_cover_jacov_probe_cf50207fc7a69e50(112) || true) : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(113) && false)) ? (Graphics2D)graphics : null;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(114);if ((graphics2D == null) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(116) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(115);return;}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(117);graphics2D.setComposite(COMPOSITE_3);
        int size = m_fieldSize - 2 * Field.getStoneMargin(m_fieldSize);
        int offsetX = getShadowOffset() / 2; // Relates to stone gradient
        int offsetY = getShadowOffset();
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(118);for (int x = 0; (x < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(120) && false); ++x)
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(119);for (int y = 0; (y < m_size) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(123) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(122);if ((field[x][y].getColor() == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(125) && false))
                    {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(124);continue;}
                $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(126);Point location = getCenter(x, y);
                graphics.setColor(Color.black);
                graphics.fillOval(location.x - size / 2 + offsetX,
                                  location.y - size / 2 + offsetY,
                                  size, size);
            }}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(121);graphics.setPaintMode();
    }

    private void drawLabel(Graphics graphics, Point location,
                           String string)
    {
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(127);FontMetrics metrics = graphics.getFontMetrics();
        int stringWidth = metrics.stringWidth(string);
        int stringHeight = metrics.getAscent();
        int x = Math.max((m_fieldSize - stringWidth) / 2, 0);
        int y = stringHeight + (m_fieldSize - stringHeight) / 2;
        graphics.drawString(string, location.x + x, location.y + y);
    }

    private static Image loadImage(URL url)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(128);Image image = Toolkit.getDefaultToolkit().getImage(url);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        try
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(129);mediaTracker.waitForID(0);
        }
        catch (InterruptedException e)
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(131);return null;
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(130);return image;
    }

    private static void setFont(Graphics graphics, int fieldSize)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(132);if ((s_cachedFont != null && s_cachedFontFieldSize == fieldSize) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(134) && false))
        {
            $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(133);graphics.setFont(s_cachedFont);
           
            return;
        }
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(135);int fontSize;
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(136);if ((fieldSize < 29) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(138) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(137);fontSize = (int)(0.33 * fieldSize);}
        else {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(140);if ((fieldSize < 40) ? true : (!$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(142) && false))
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(141);fontSize = 10;}
        else
            {$qualityscroll_cover_jacov_probe_cf50207fc7a69e50(143);fontSize = (int)(10 + 0.1 * (fieldSize - 40));}}
        $qualityscroll_cover_jacov_probe_cf50207fc7a69e50(139);s_cachedFont = new Font("SansSerif", Font.PLAIN, fontSize);
        s_cachedFontFieldSize = fieldSize;
        graphics.setFont(s_cachedFont);
    }
}
