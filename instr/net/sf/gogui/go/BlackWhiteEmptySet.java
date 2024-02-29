/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// BlackWhiteEmptySet.java

package net.sf.gogui.go;

import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;

/** A set containing one element for Black, one for White, and one for
    Empty. */
public class BlackWhiteEmptySet<T>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BlackWhiteEmptySet.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1111599117292347383L,/* translation unit id   */ 2473545418745256227L,/* timestamp             */ 1709177900233L,/* source file name      */ "BlackWhiteEmptySet.java",/* probe size            */ 16);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_2253cc73f41b1923(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public BlackWhiteEmptySet()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_2253cc73f41b1923(0);
    }

    public BlackWhiteEmptySet(T elementBlack, T elementWhite, T elementEmpty)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_2253cc73f41b1923(1);m_elementBlack = elementBlack;
        m_elementWhite = elementWhite;
        m_elementEmpty = elementEmpty;
    }

    public T get(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_2253cc73f41b1923(2);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_2253cc73f41b1923(4) && false))
            {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(3);return m_elementBlack;}
        else {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(5);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_2253cc73f41b1923(7) && false))
            {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(6);return m_elementWhite;}
        else
        {
            $qualityscroll_cover_jacov_probe_2253cc73f41b1923(8);assert c == EMPTY;
            return m_elementEmpty;
        }}
    }

    public void set(GoColor c, T element)
    {
        $qualityscroll_cover_jacov_probe_2253cc73f41b1923(9);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_2253cc73f41b1923(11) && false))
            {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(10);m_elementBlack = element;}
        else {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(12);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_2253cc73f41b1923(14) && false))
            {$qualityscroll_cover_jacov_probe_2253cc73f41b1923(13);m_elementWhite = element;}
        else
        {
            $qualityscroll_cover_jacov_probe_2253cc73f41b1923(15);assert c == EMPTY;
            m_elementEmpty = element;
        }}
    }

    private T m_elementBlack;

    private T m_elementWhite;

    private T m_elementEmpty;
}
