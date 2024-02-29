/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// SgfError.java

package net.sf.gogui.sgf;

import net.sf.gogui.util.ErrorMessage;

/** SGF read error. */
public class SgfError
    extends ErrorMessage
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfError.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7910920250174767455L,/* translation unit id   */ 4458747471761949400L,/* timestamp             */ 1709177902833L,/* source file name      */ "SgfError.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3de0a733bd8ac2d8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param message Error message. */
    public SgfError(String message)
    {
        super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_3de0a733bd8ac2d8(0);
    }
}
