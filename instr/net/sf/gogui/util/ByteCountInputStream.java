/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ErrorMessage.java

package net.sf.gogui.util;

import java.io.InputStream;
import java.io.IOException;

public class ByteCountInputStream
    extends InputStream
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ByteCountInputStream.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8902725129685483563L,/* translation unit id   */ -2563856143407109079L,/* timestamp             */ 1709177903936L,/* source file name      */ "ByteCountInputStream.java",/* probe size            */ 17);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ByteCountInputStream(InputStream in)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(0);m_in = in;
    }

    public long getCount()
    {
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(1);return m_byteCount;
    }

    @Override
	public int read() throws IOException
    {
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(2);int result = m_in.read();
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(3);if ((result > 0) ? true : (!$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(5) && false))
            {$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(4);++m_byteCount;}
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(6);return result;
    }

    @Override
	public int read(byte[] b) throws IOException
    {
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(7);int result = m_in.read(b);
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(8);if ((result > 0) ? true : (!$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(10) && false))
            {$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(9);m_byteCount += result;}
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(11);return result;
    }

    @Override
	public int read(byte[] b, int off, int len) throws IOException
    {
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(12);int result = m_in.read(b, off, len);
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(13);if ((result > 0) ? true : (!$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(15) && false))
            {$qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(14);m_byteCount += result;}
        $qualityscroll_cover_jacov_probe_dc6b5a6be5042c29(16);return result;
    }

    private long m_byteCount;

    private final InputStream m_in;
}
