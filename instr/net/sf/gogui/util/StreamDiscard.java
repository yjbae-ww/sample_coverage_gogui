/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// StreamDiscard.java

package net.sf.gogui.util;

import java.io.InputStream;

/** Thread discarding an output stream. */
public class StreamDiscard
    extends Thread
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = StreamDiscard.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4912258872579910255L,/* translation unit id   */ -7437859367277853401L,/* timestamp             */ 1709177904155L,/* source file name      */ "StreamDiscard.java",/* probe size            */ 12);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_98c76a501c178527(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public StreamDiscard(InputStream src)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_98c76a501c178527(0);m_src = src;
    }

    /** Run method.
        Exceptions caught are written to stderr. */
    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_98c76a501c178527(1);byte buffer[] = new byte[1024];
            $qualityscroll_cover_jacov_probe_98c76a501c178527(2);while (true)
            {
                $qualityscroll_cover_jacov_probe_98c76a501c178527(3);int n = m_src.read(buffer);
                $qualityscroll_cover_jacov_probe_98c76a501c178527(5);if ((n < 0) ? true : (!$qualityscroll_cover_jacov_probe_98c76a501c178527(7) && false))
                    {$qualityscroll_cover_jacov_probe_98c76a501c178527(6);break;}
                $qualityscroll_cover_jacov_probe_98c76a501c178527(8);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_98c76a501c178527(10) && false))
                {
                    // Not sure if this is necessary.
                    $qualityscroll_cover_jacov_probe_98c76a501c178527(9);sleep(100);
                    continue;
                }
            }
        }
        catch (Throwable e)
        {
            $qualityscroll_cover_jacov_probe_98c76a501c178527(11);StringUtil.printException(e);
        }
    }

    private final InputStream m_src;
}
