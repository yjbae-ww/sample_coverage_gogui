/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// ParseError.java

package net.sf.gogui.text;

import net.sf.gogui.util.ErrorMessage;

/** Exception indicating the failure of TextParser. */
public class ParseError
    extends ErrorMessage
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ParseError.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5520423141194026241L,/* translation unit id   */ 5536953258898925072L,/* timestamp             */ 1709177902996L,/* source file name      */ "ParseError.java",/* probe size            */ 1);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4cd735a7269ca610(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ParseError(String s)
    {
        super(s);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_4cd735a7269ca610(0);
    }
}
