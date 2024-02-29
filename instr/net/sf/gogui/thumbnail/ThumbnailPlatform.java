/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ThumbnailPlatform.java

package net.sf.gogui.thumbnail;

import java.io.File;
import net.sf.gogui.util.Platform;

/** Thumbnail platform settings. */
public final class ThumbnailPlatform
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ThumbnailPlatform.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5738685168228507782L,/* translation unit id   */ -3817951096391257679L,/* timestamp             */ 1709177903057L,/* source file name      */ "ThumbnailPlatform.java",/* probe size            */ 6);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static boolean checkThumbnailSupport()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(0);if ((Platform.isWindows()) ? true : (!$qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(2) && false))
            {$qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(1);return false;}
        // Don't try to create the directory, because we cannot create it with
        // the right permissions from Java
        $qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(3);return getNormalDir().exists();
    }

    /** Get directory for normal size thumbnails. */
    public static File getNormalDir()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(4);String home = System.getProperty("user.home", "");
        return new File(new File(home, ".thumbnails"), "normal");
    }

    /** Make constructor unavailable; class is for namespace only. */
    private ThumbnailPlatform()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cb03e9b4c9c931b1(5);
    }
}
