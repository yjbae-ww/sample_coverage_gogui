/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// InvalidPointException.java

package net.sf.gogui.go;

/** Thrown if parsing a string representation of a GoPoint fails. */
public class InvalidPointException
    extends Exception
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = InvalidPointException.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 477392894843726621L,/* translation unit id   */ -7714659932081697114L,/* timestamp             */ 1709177900481L,/* source file name      */ "InvalidPointException.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_94f005aa7154cea6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param text The text that could not be parsed as a point. */
    public InvalidPointException(String text)
    {
        super("Invalid point \"" + text + "\"");$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_94f005aa7154cea6(0);
    }
}
