/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// BlackWhiteSet.java

package net.sf.gogui.go;

import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.util.ObjectUtil;

/** A set containing one element for Black and one for White. */
public class BlackWhiteSet<T>
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BlackWhiteSet.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5001128345843383423L,/* translation unit id   */ -7493621382144732038L,/* timestamp             */ 1709177900247L,/* source file name      */ "BlackWhiteSet.java",/* probe size            */ 22);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public BlackWhiteSet()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(0);
    }

    public BlackWhiteSet(T elementBlack, T elementWhite)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(1);m_elementBlack = elementBlack;
        m_elementWhite = elementWhite;
    }

    @Override
	public boolean equals(Object object)
    {
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(2);if ((object == null || object.getClass() != getClass()) ? true : (!$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(4) && false))
            {$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(3);return false;}
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(5);BlackWhiteSet set = (BlackWhiteSet)object;
        return (ObjectUtil.equals(set.m_elementBlack, m_elementBlack)
                && ObjectUtil.equals(set.m_elementWhite, m_elementWhite));
    }

    public T get(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(6);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(8) && false))
            {$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(7);return m_elementBlack;}
        else
        {
            $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(9);assert c == WHITE;
            return m_elementWhite;
        }
    }

    @Override
	public int hashCode()
    {
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(10);int hashCode = 0;
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(11);if ((m_elementBlack != null) ? true : (!$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(13) && false))
            {$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(12);hashCode |= m_elementBlack.hashCode();}
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(14);if ((m_elementWhite != null) ? true : (!$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(16) && false))
            {$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(15);hashCode |= m_elementWhite.hashCode();}
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(17);return hashCode;
    }

    public void set(GoColor c, T element)
    {
        $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(18);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(20) && false))
            {$qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(19);m_elementBlack = element;}
        else
        {
            $qualityscroll_cover_jacov_probe_98014f0e4bfdd47a(21);assert c == WHITE;
            m_elementWhite = element;
        }
    }

    private T m_elementBlack;

    private T m_elementWhite;
}
