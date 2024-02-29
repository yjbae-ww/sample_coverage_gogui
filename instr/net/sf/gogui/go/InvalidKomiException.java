/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// InvalidKomiException.java

package net.sf.gogui.go;

import net.sf.gogui.util.ErrorMessage;

/** Exception thrown if parsing a komi from a string fails. */
public class InvalidKomiException
    extends ErrorMessage
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = InvalidKomiException.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4523567492060298436L,/* translation unit id   */ -3133727832261351133L,/* timestamp             */ 1709177900457L,/* source file name      */ "InvalidKomiException.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d482c323c74ea923(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public InvalidKomiException(String s)
    {
        super("Invalid komi: " + s);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d482c323c74ea923(0);
    }
}
