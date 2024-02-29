/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// ShowAnalyeText.java

package net.sf.gogui.gogui;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.PointList;
import net.sf.gogui.gtp.AnalyzeType;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.gui.GuiBoard;
import net.sf.gogui.gui.GuiBoardUtil;
import net.sf.gogui.gui.TextViewer;

/** Show multi-line text output from analyze command.
    Optionally can reuse window of last output. */
public final class ShowAnalyzeText
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ShowAnalyzeText.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -836365086792755339L,/* translation unit id   */ -6590371657043340375L,/* timestamp             */ 1709177901207L,/* source file name      */ "ShowAnalyzeText.java",/* probe size            */ 21);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ShowAnalyzeText(Frame owner, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(0);m_owner = owner;
        m_guiBoard = guiBoard;
    }

    public void show(AnalyzeType type, GoPoint pointArg, String title,
                     String response, boolean reuseWindow)
    {
        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(1);boolean highlight = (type == AnalyzeType.HSTRING
                             || type == AnalyzeType.HPSTRING);
        TextViewer.Listener listener = null;
        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(2);if ((type == AnalyzeType.PSTRING || type == AnalyzeType.HPSTRING) ? true : (!$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(4) && false))
            {$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(3);listener = new PointSelectionMarker(m_guiBoard);}
        // Remove first line, if empty (formatted responses frequently start
        // with an empty line to avoid text on the line with the status
        // character)
        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(5);response = response.replaceAll("\\A *\n", "");
        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(6);if ((reuseWindow && m_textViewer != null) ? true : (!$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(8) && false))
            {$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(7);m_textViewer.setText(title, response, highlight);}
        else
        {
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(9);m_textViewer = new TextViewer(m_owner, title, response, highlight,
                                          listener);
            m_textViewer.addWindowListener(new WindowAdapter() {
                    @Override
					public void windowClosing(WindowEvent e) {
                        $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(10);m_textViewer = null;
                    }
                });
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(11);if ((pointArg == null) ? true : (!$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(13) && false))
                {$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(12);m_textViewer.setLocationByPlatform(true);}
            else
            {
                $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(15);Point location = m_guiBoard.getLocationOnScreen(pointArg);
                m_textViewer.setLocation(location);
            }
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(14);m_textViewer.setVisible(true);
        }
    }

    private static class PointSelectionMarker
        implements TextViewer.Listener
    {
        public PointSelectionMarker(GuiBoard guiBoard)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(16);m_guiBoard = guiBoard;
        }

        @Override
		public void textSelected(String text)
        {
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(17);if ((! m_guiBoard.isShowing()) ? true : (!$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(19) && false))
                {$qualityscroll_cover_jacov_probe_a48a4be52c2113a9(18);return;}
            $qualityscroll_cover_jacov_probe_a48a4be52c2113a9(20);PointList points = GtpUtil.parsePointString(text);
            GuiBoardUtil.showPointList(m_guiBoard, points);
        }

        private final GuiBoard m_guiBoard;
    }

    private Frame m_owner;

    private GuiBoard m_guiBoard;

    private TextViewer m_textViewer;
}
