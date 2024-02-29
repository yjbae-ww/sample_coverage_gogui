/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// StreamCopy.java

package net.sf.gogui.util;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/** Thread copying the output of one stream to another stream. */
public class StreamCopy
    implements Runnable
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = StreamCopy.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -3490118961042660103L,/* translation unit id   */ 9009397207005097372L,/* timestamp             */ 1709177904140L,/* source file name      */ "StreamCopy.java",/* probe size            */ 18);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param verbose Also copy everything to stderr
        @param src Source stream
        @param dest Destination stream
        @param close Close destination after eof in source */
    public StreamCopy(boolean verbose, InputStream src, OutputStream dest,
                      boolean close)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(0);m_verbose = verbose;
        m_src = src;
        m_dest = dest;
        m_close = close;
    }

    /** Run method.
        Exceptions caught are written to stderr. */
    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(1);byte buffer[] = new byte[1024];
            $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(2);while (true)
            {
                $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(3);int n = m_src.read(buffer);
                $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(10);if ((n < 0) ? true : (!$qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(12) && false))
                    {$qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(11);break;}
                $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(13);if ((m_verbose) ? true : (!$qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(15) && false))
                    {$qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(14);System.err.write(buffer, 0, n);}
                $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(16);m_dest.write(buffer, 0, n);
                m_dest.flush();
            }
        }
        catch (Throwable e)
        {
            $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(17);StringUtil.printException(e);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(5);if ((m_close) ? true : (!$qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(7) && false))
            {
                $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(6);try
                {
                    $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(8);m_dest.close();
                }
                catch (IOException e)
                {
                    $qualityscroll_cover_jacov_probe_7d07cf06a3ef6d9c(9);StringUtil.printException(e);
                }
            }
        }
    }

    private final boolean m_verbose;

    private final boolean m_close;

    private final InputStream m_src;

    private final OutputStream m_dest;
}
