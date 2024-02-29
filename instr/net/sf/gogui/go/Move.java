/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Move.java

package net.sf.gogui.go;

import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;

/** Move containing a point and a color.
    The point can be <code>null</code> (for pass move).
    The color is black or white.
    This class is immutable, references are unique. */
public final class Move
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Move.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8377368235637036921L,/* translation unit id   */ 94021739354955124L,/* timestamp             */ 1709177900533L,/* source file name      */ "Move.java",/* probe size            */ 26);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_14e0846176a9d74(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Factory method for constructing a move.
        @param color The color of the move
        @param x Column in <code>[0..GoPoint.MAX_SIZE - 1]</code>
        @param y Row in <code>[0..GoPoint.MAX_SIZE - 1]</code>
        @return Reference to this move */
    public static Move get(GoColor color, int x, int y)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(0);return get(color, GoPoint.get(x, y));
    }

    /** Factory method for constructing a move.
        @param color The color of the move (empty can still be used for
        removing a stone on the board, but this will be deprecated in the
        future)
        @param point Location of the move (null for pass move)
        @return Reference to this move */
    public static Move get(GoColor color, GoPoint point)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(1);assert color.isBlackWhite();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(2);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_14e0846176a9d74(4) && false))
        {
            $qualityscroll_cover_jacov_probe_14e0846176a9d74(3);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_14e0846176a9d74(6) && false))
                {$qualityscroll_cover_jacov_probe_14e0846176a9d74(5);return s_passBlack;}
            else
                {$qualityscroll_cover_jacov_probe_14e0846176a9d74(7);return s_passWhite;}
        }
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(8);int x = point.getX();
        int y = point.getY();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(9);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_14e0846176a9d74(11) && false))
            {$qualityscroll_cover_jacov_probe_14e0846176a9d74(10);return s_movesBlack[x][y];}
        else
            {$qualityscroll_cover_jacov_probe_14e0846176a9d74(12);return s_movesWhite[x][y];}
    }

    /** Factory method for constructing a pass move.
        @param c The color of the move.
        @return Reference to this move */
    public static Move getPass(GoColor c)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(13);assert c.isBlackWhite();
        return get(c, null);
    }

    /** Get color of move.
        @return Color of move */
    public GoColor getColor()
    {
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(14);return m_color;
    }

    /** Get stone location of move.
        @return Location of move; null for pass move */
    public GoPoint getPoint()
    {
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(15);return m_point;
    }

    /** Get string representation of move.
        @return String representation using an uppercase letter for the color
        and an uppercase string for the point (e.g. B C3, W PASS). This
        representation is also guaranteed to be compatible with the formats
        used in the Go Text Protocol. */
    @Override
	public String toString()
    {
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(16);return m_string;
    }

    private static Move s_passBlack;

    private static Move s_passWhite;

    private static Move[][] s_movesBlack;

    private static Move[][] s_movesWhite;

    private final GoColor m_color;

    private final GoPoint m_point;

    private final String m_string;

    static
    {
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(25);s_passBlack = new Move(BLACK, null, "B PASS");
        s_passWhite = new Move(WHITE, null, "W PASS");
        s_movesBlack = init(BLACK);
        s_movesWhite = init(WHITE);
    }

    private static Move[][] init(GoColor color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(17);Move[][] result = new Move[GoPoint.MAX_SIZE][GoPoint.MAX_SIZE];
        StringBuilder buffer = new StringBuilder(8);
        String colorString = color.getUppercaseLetter();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(18);for (int x = 0; (x < GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_14e0846176a9d74(20) && false); ++x)
            {$qualityscroll_cover_jacov_probe_14e0846176a9d74(19);for (int y = 0; (y < GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_14e0846176a9d74(23) && false); ++y)
            {
                $qualityscroll_cover_jacov_probe_14e0846176a9d74(22);GoPoint p = GoPoint.get(x, y);
                buffer.setLength(0);
                buffer.append(colorString);
                buffer.append(' ');
                buffer.append(p);
                result[x][y] = new Move(color, p, buffer.toString());
            }}
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(21);return result;
    }

    private Move(GoColor color, GoPoint point, String string)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_14e0846176a9d74(24);m_point = point;
        m_color = color;
        m_string = string;
    }
}
