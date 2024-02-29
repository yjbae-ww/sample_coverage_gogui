/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// ObjectUtil.java

package net.sf.gogui.util;

/** Utils for using class java.lang.Object. */
public final class ObjectUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ObjectUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -715049842572558604L,/* translation unit id   */ -1782540955118382134L,/* timestamp             */ 1709177904032L,/* source file name      */ "ObjectUtil.java",/* probe size            */ 11);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e7432472149553ca(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Compare including the case that arguments can be null. */
    public static boolean equals(Object object1, Object object2)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e7432472149553ca(0);if ((object1 == null && object2 == null) ? true : (!$qualityscroll_cover_jacov_probe_e7432472149553ca(2) && false))
            {$qualityscroll_cover_jacov_probe_e7432472149553ca(1);return true;}
        $qualityscroll_cover_jacov_probe_e7432472149553ca(3);if ((object1 == null && object2 != null) ? true : (!$qualityscroll_cover_jacov_probe_e7432472149553ca(5) && false))
            {$qualityscroll_cover_jacov_probe_e7432472149553ca(4);return false;}
        $qualityscroll_cover_jacov_probe_e7432472149553ca(6);if ((object1 != null && object2 == null) ? true : (!$qualityscroll_cover_jacov_probe_e7432472149553ca(8) && false))
            {$qualityscroll_cover_jacov_probe_e7432472149553ca(7);return false;}
        $qualityscroll_cover_jacov_probe_e7432472149553ca(9);assert object1 != null && object2 != null;
        return object1.equals(object2);
    }

    /** Make constructor unavailable; class is for namespace only. */
    private ObjectUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e7432472149553ca(10);
    }
}
