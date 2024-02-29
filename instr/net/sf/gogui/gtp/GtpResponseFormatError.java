/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpResponseFormatError.java

package net.sf.gogui.gtp;

/** Error used if parsing a GTP response fails.
    This error is used if the response to a GTP command is expected to be
    in a particular format (e.g. a point), but is in a different format. */
public class GtpResponseFormatError
    extends Exception
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpResponseFormatError.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 7365585242560400813L,/* translation unit id   */ 1732215127408878962L,/* timestamp             */ 1709177901596L,/* source file name      */ "GtpResponseFormatError.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_180a107b0fc3a572(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GtpResponseFormatError(String s)
    {
        super(s);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_180a107b0fc3a572(0);
    }
}
