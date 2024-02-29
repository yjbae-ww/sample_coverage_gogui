/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// I18n.java

package net.sf.gogui.gogui;

import java.util.Locale;
import java.util.ResourceBundle;

/** Internationalization for this package. */
final class I18n
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = I18n.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6110551203284535839L,/* translation unit id   */ -4003513416986465978L,/* timestamp             */ 1709177901019L,/* source file name      */ "I18n.java",/* probe size            */ 2);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c870a9c23f02e946(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static String i18n(String key)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c870a9c23f02e946(0);return s_bundle.getString(key);
    }

    private static ResourceBundle s_bundle =
        ResourceBundle.getBundle("net.sf.gogui.gogui.text",
                                 Locale.getDefault());

    /** Make constructor unavailable; class is for namespace only. */
    private I18n()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_c870a9c23f02e946(1);
    }
}
