/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// LineReader.java

package net.sf.gogui.util;

/** Allows to read lines from a buffer without blocking. */
public class LineReader
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = LineReader.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2858312439856873071L,/* translation unit id   */ -2470272297275579163L,/* timestamp             */ 1709177904015L,/* source file name      */ "LineReader.java",/* probe size            */ 7);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Add text to buffer. */
    public void add(String s)
    {
        $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(0);m_buffer.append(s);
    }

    /** Check if the buffer contains at least one line. */
    public boolean hasLines()
    {
        $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(1);return m_buffer.toString().contains("\n");
    }

    public String getLine()
    {
        $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(2);String s = m_buffer.toString();
        int pos = s.indexOf('\n');
        $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(3);if ((pos < 0) ? true : (!$qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(5) && false))
            {$qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(4);return "";}
        $qualityscroll_cover_jacov_probe_ddb7d46f0666a4e5(6);String result = s.substring(0, pos + 1);
        m_buffer.delete(0, pos + 1);
        return result;
    }

    private final StringBuilder m_buffer = new StringBuilder(1024);
}
