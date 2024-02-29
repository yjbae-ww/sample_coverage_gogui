/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// I18n.java

package net.sf.gogui.game;

import java.util.Locale;
import java.util.ResourceBundle;

/** Internationalization for this package. */
final class I18n
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = I18n.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4611036423398860992L,/* translation unit id   */ -7818832963767006046L,/* timestamp             */ 1709177899959L,/* source file name      */ "I18n.java",/* probe size            */ 2);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_937decd86c8d8ca2(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static String i18n(String key)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_937decd86c8d8ca2(0);return s_bundle.getString(key);
    }

    private static ResourceBundle s_bundle =
        ResourceBundle.getBundle("net.sf.gogui.game.text",
                                 Locale.getDefault());

    /** Make constructor unavailable; class is for namespace only. */
    private I18n()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_937decd86c8d8ca2(1);
    }
}
