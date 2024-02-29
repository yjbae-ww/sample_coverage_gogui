/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ErrorMessage.java

package net.sf.gogui.util;

/** Error with error message.
    ErrorMessage are exceptions with a message meaningful for presentation
    to the user. */
public class ErrorMessage
    extends Exception
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ErrorMessage.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3711201927240909492L,/* translation unit id   */ -8585597305498345225L,/* timestamp             */ 1709177903950L,/* source file name      */ "ErrorMessage.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_88d9d4bd353860f7(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param message The error message text. */
    public ErrorMessage(String message)
    {
        super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_88d9d4bd353860f7(0);
    }
}
