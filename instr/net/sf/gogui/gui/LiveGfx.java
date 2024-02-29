/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// LiveGfx.java

package net.sf.gogui.gui;

import javax.swing.SwingUtilities;

/** Parse standard error of a GTP engine for GoGui live graphics commands.
    See chapter "Live Graphics" in the GoGui documentation. */
public class LiveGfx
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = LiveGfx.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5494148969099003739L,/* translation unit id   */ -9048543937116809036L,/* timestamp             */ 1709177902585L,/* source file name      */ "LiveGfx.java",/* probe size            */ 21);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_826d1d3afda358b4(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public interface Listener
    {
        void showLiveGfx(String text);
    }

    public LiveGfx(Listener listener)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(0);m_listener = listener;
        m_duringMultiLineResponse = false;
    }

    /** Parse line.
        This function can be called from a different thread than the Swing
        event dispatch thread.
        @param s The line received from standard error (may or may not be
        a live gfx line).
        @return true, if the line was a live gfx line */
    public boolean handleLine(String s)
    {
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(1);s = s.trim();
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(2);if ((m_duringMultiLineResponse) ? true : (!$qualityscroll_cover_jacov_probe_826d1d3afda358b4(4) && false))
        {
            $qualityscroll_cover_jacov_probe_826d1d3afda358b4(3);if ((s.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_826d1d3afda358b4(6) && false))
            {
                $qualityscroll_cover_jacov_probe_826d1d3afda358b4(5);showGfx(m_response.toString());
                m_duringMultiLineResponse = false;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_826d1d3afda358b4(8);m_response.append(s);
                m_response.append('\n');
            }
            $qualityscroll_cover_jacov_probe_826d1d3afda358b4(7);return true;
        }
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(9);s = s.trim();
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(10);if ((s.startsWith("gogui-gfx:")) ? true : (!$qualityscroll_cover_jacov_probe_826d1d3afda358b4(12) && false))
        {
            $qualityscroll_cover_jacov_probe_826d1d3afda358b4(11);int pos = s.indexOf(':');
            String response = s.substring(pos + 1);
            $qualityscroll_cover_jacov_probe_826d1d3afda358b4(13);if ((response.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_826d1d3afda358b4(15) && false))
            {
                $qualityscroll_cover_jacov_probe_826d1d3afda358b4(14);m_response.setLength(0);
                m_duringMultiLineResponse = true;
            }
            else
                {$qualityscroll_cover_jacov_probe_826d1d3afda358b4(17);showGfx(response);}
            $qualityscroll_cover_jacov_probe_826d1d3afda358b4(16);return true;
        }
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(18);return false;
    }

    private boolean m_duringMultiLineResponse;

    private Listener m_listener;

    private final StringBuilder m_response = new StringBuilder(1024);

    private void showGfx(final String text)
    {
        $qualityscroll_cover_jacov_probe_826d1d3afda358b4(19);SwingUtilities.invokeLater(new Runnable() {
                @Override
				public void run()
                {
                    $qualityscroll_cover_jacov_probe_826d1d3afda358b4(20);m_listener.showLiveGfx(text);
                }
            });
    }
}
