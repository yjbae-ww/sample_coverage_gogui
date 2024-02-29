/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Komi.java

package net.sf.gogui.go;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/** Value of komi.
    This class is immutable. */
public final class Komi
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Komi.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8614406590041829683L,/* translation unit id   */ 554101784107391081L,/* timestamp             */ 1709177900498L,/* source file name      */ "Komi.java",/* probe size            */ 20);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_7b090a30b219869(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param komi The value for the komi. */
    public Komi(double komi)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_7b090a30b219869(0);m_value = komi;
    }

    @Override
	public boolean equals(Object object)
    {
        $qualityscroll_cover_jacov_probe_7b090a30b219869(1);if ((object == null || object.getClass() != getClass()) ? true : (!$qualityscroll_cover_jacov_probe_7b090a30b219869(3) && false))
            {$qualityscroll_cover_jacov_probe_7b090a30b219869(2);return false;}
        $qualityscroll_cover_jacov_probe_7b090a30b219869(4);Komi komi = (Komi)object;
        return (komi.m_value == m_value);
    }

    @Override
	public int hashCode()
    {
        // As in Double.hashCode()
        $qualityscroll_cover_jacov_probe_7b090a30b219869(5);long v = Double.doubleToLongBits(m_value);
        return (int)(v ^ (v >>> 32));
    }

    public boolean isMultipleOf(double multiple)
    {
        $qualityscroll_cover_jacov_probe_7b090a30b219869(6);return Math.IEEEremainder(m_value, multiple) == 0;
    }

    /** Parse komi from string.
        @param s The string (null not allowed), empty string means unknown
        komi.
        @return The komi or null if unknown komi. */
    public static Komi parseKomi(String s) throws InvalidKomiException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_7b090a30b219869(7);assert s != null;
        $qualityscroll_cover_jacov_probe_7b090a30b219869(8);if ((s.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_7b090a30b219869(10) && false))
            {$qualityscroll_cover_jacov_probe_7b090a30b219869(9);return null;}
        try
        {
            // Also accept , instead of .
            $qualityscroll_cover_jacov_probe_7b090a30b219869(11);double komi = Double.parseDouble(s.replace(',', '.'));
            $qualityscroll_cover_jacov_probe_7b090a30b219869(12);return new Komi(komi);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_7b090a30b219869(13);throw new InvalidKomiException(s);
        }
    }

    public double toDouble()
    {
        $qualityscroll_cover_jacov_probe_7b090a30b219869(14);return m_value;
    }

    /** Like Komi.toString() but interprets null argument as zero komi. */
    static public String toString(Komi komi)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_7b090a30b219869(15);if ((komi == null) ? true : (!$qualityscroll_cover_jacov_probe_7b090a30b219869(17) && false))
            {$qualityscroll_cover_jacov_probe_7b090a30b219869(16);return "0";}
        $qualityscroll_cover_jacov_probe_7b090a30b219869(18);return komi.toString();
    }

    @Override
	public String toString()
    {
        $qualityscroll_cover_jacov_probe_7b090a30b219869(19);DecimalFormat format =
            (DecimalFormat)(NumberFormat.getInstance(Locale.ENGLISH));
        format.setGroupingUsed(false);
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(m_value);
    }

    private final double m_value;
}
