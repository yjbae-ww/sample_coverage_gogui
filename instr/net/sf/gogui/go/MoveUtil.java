/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// MoveUtil.java

package net.sf.gogui.go;

import java.util.ArrayList;

/** Static utility functions related to class Move. */
public final class MoveUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = MoveUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6035145080870896210L,/* translation unit id   */ 8822782595979532264L,/* timestamp             */ 1709177900561L,/* source file name      */ "MoveUtil.java",/* probe size            */ 11);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Fill a list of moves with pass moves.
        The resulting list will contain all moves of the original list
        in the same order, but ensure it starts with a move of color toMove
        and have no subsequent moves of the same color. */
    public static ArrayList<Move> fillPasses(ArrayList<Move> moves,
                                             GoColor toMove)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(0);ArrayList<Move> result = new ArrayList<Move>(moves.size() * 2);
        $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(1);if ((moves.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(3) && false))
            {$qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(2);return result;}
        $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(4);for (Move move : moves)
        {
            $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(6);if ((move.getColor() != toMove) ? true : (!$qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(8) && false))
                {$qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(7);result.add(Move.getPass(toMove));}
            $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(9);result.add(move);
            toMove = move.getColor().otherColor();
        }
        $qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(5);return result;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private MoveUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_7a70d206a3dbd7e8(10);
    }
}
