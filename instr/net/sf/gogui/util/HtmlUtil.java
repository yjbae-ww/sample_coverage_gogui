/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// HtmlUtil.java

package net.sf.gogui.util;

import  net.sf.gogui.version.Version;

/** Static utility functions related to HTML writing. */
public final class HtmlUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = HtmlUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 526088279285490900L,/* translation unit id   */ -5418005829986346994L,/* timestamp             */ 1709177904001L,/* source file name      */ "HtmlUtil.java",/* probe size            */ 3);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_b4cf606748ab180e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Return a footer.
        Contains a horizontal line followed by an address element containing
        the generation (current) date, the generator (applicationName) and
        a link to the GoGui website. */
    public static String getFooter(String applicationName)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_b4cf606748ab180e(0);StringBuilder buffer = new StringBuilder(512);
        buffer.append("<hr style=\"margin-bottom:0\" size=\"1\">\n" +
                      "<p style=\"margin-top:1; margin-right:5\""
                      + " align=\"right\"><i>" +
                      "<small>Generated on ");
        buffer.append(StringUtil.getDateShort());
        buffer.append(" by ");
        buffer.append(applicationName);
        buffer.append(' ');
        buffer.append(Version.get());
        buffer.append(" (<a href=\"http://gogui.sf.net\">"
                      + "http://gogui.sf.net</a>)</small></i></p>\n");
        return buffer.toString();
    }

    /** Return meta tags for character set and generator. */
    public static String getMeta(String applicationName)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_b4cf606748ab180e(1);String charset = StringUtil.getDefaultEncoding();
        StringBuilder buffer = new StringBuilder(512);
        buffer.append("<meta http-equiv=\"Content-Type\""
                      + " content=\"text/html; charset=");
        buffer.append(charset);
        buffer.append("\">\n" +
                      "<meta name=\"generator\" content=\"");
        buffer.append(applicationName);
        buffer.append(' ');
        buffer.append(Version.get());
        buffer.append(" (http://gogui.sf.net)\">\n");
        return buffer.toString();
    }

    /** Make constructor unavailable; class is for namespace only. */
    private HtmlUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_b4cf606748ab180e(2);
    }
}
