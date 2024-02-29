/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ *///----------------------------------------------------------------------------
// The file Version.java is automatically created from Version.java.in.
// Do not edit Version.java.
//----------------------------------------------------------------------------

package net.sf.gogui.version;

/** Version information for all packages. */
public final class Version
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Version.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4610443631131075382L,/* translation unit id   */ -5761137322180338736L,/* timestamp             */ 1709177904250L,/* source file name      */ "Version.java",/* probe size            */ 2);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_b00c542119321bd0(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Get version for packages in net.sf.gogui.
        @return Version string, no assumptions about the format should be
        made.
    */
    public static String get()
    {$qualityscroll_cover_coverage_buffer_init();
		
        $qualityscroll_cover_jacov_probe_b00c542119321bd0(0);return "1.4.9";
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Version()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_b00c542119321bd0(1);
    }
}
