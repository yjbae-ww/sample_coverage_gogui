/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GtpShellText.java

package net.sf.gogui.gui;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import net.sf.gogui.game.Clock;

class GtpShellText
    extends JTextPane
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpShellText.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3035624205405906665L,/* translation unit id   */ 5259152823934945609L,/* timestamp             */ 1709177902272L,/* source file name      */ "GtpShellText.java",/* probe size            */ 53);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_48fc43a112228949(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GtpShellText(int historyMin, int historyMax, boolean timeStamp)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_48fc43a112228949(0);GuiUtil.setMonospacedFont(this);
        m_startTime = System.currentTimeMillis();
        m_timeStamp = timeStamp;
        m_historyMin = historyMin;
        m_historyMax = historyMax;
        GuiUtil.addStyle(this, "error", Color.red);
        GuiUtil.addStyle(this, "warning", Color.decode("#ff7000"));
        GuiUtil.addStyle(this, "output", null, null, true);
        GuiUtil.addStyle(this, "log", new Color(0.5f, 0.5f, 0.5f));
        GuiUtil.addStyle(this, "livegfx", Color.decode("#5498B0"));
        GuiUtil.addStyle(this, "time", new Color(0, 0, 0.5f));
        GuiUtil.addStyle(this, "invalid", new Color(1.0f, 0.58f, 0.25f));
        setEditable(false);
    }

    public void appendComment(String text)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(1);m_isLastTextNonGTP = false;
        appendText(text, "log");
    }

    public void appendError(String text)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(2);m_isLastTextNonGTP = false;
        appendTimeStamp();
        appendText(text, "error");
    }

    public void appendInput(String text)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(3);m_isLastTextNonGTP = false;
        appendTimeStamp();
        appendText(text, null);
    }

    public void appendInvalidResponse(String text)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(4);m_isLastTextNonGTP = true;
        appendText(text, "invalid");
    }

    public void appendLog(String text, boolean isLiveGfx, boolean isWarning)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(5);m_isLastTextNonGTP = true;
        $qualityscroll_cover_jacov_probe_48fc43a112228949(6);if ((isLiveGfx) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(8) && false))
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(7);appendText(text, "livegfx");}
        else {$qualityscroll_cover_jacov_probe_48fc43a112228949(9);if ((isWarning) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(11) && false))
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(10);appendText(text, "warning");}
        else
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(12);appendText(text, "log");}}
    }

    public void appendOutput(String text)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(13);m_isLastTextNonGTP = false;
        appendTimeStamp();
        appendText(text, "output");
    }

    public static int findTruncateIndex(String text, int truncateLines)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_48fc43a112228949(14);int indexNewLine = 0;
        int lines = 0;
        $qualityscroll_cover_jacov_probe_48fc43a112228949(15);while (((indexNewLine = text.indexOf('\n', indexNewLine)) != -1) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(17) && false))
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(16);++indexNewLine;
            ++lines;
            $qualityscroll_cover_jacov_probe_48fc43a112228949(19);if ((lines == truncateLines) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(21) && false))
                {$qualityscroll_cover_jacov_probe_48fc43a112228949(20);return indexNewLine;}
        }
        $qualityscroll_cover_jacov_probe_48fc43a112228949(18);return -1;
    }

    public int getLinesTruncated()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(22);return m_truncated;
    }

    public String getLog()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(23);Document doc = getDocument();
        try
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(24);return doc.getText(0, doc.getLength());
        }
        catch (BadLocationException e)
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(25);assert false;
            return "";
        }
    }

    /** Check if last text appended is not part of the GTP streams.
        Returns true, if last text is standard error of program or invalid
        response lines. */
    public boolean isLastTextNonGTP()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(26);return m_isLastTextNonGTP;
    }

    public void setPositionToEnd()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(27);int length = getDocument().getLength();
        setCaretPosition(length);
    }

    public void setTimeStamp(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(28);m_timeStamp = enable;
    }

    private boolean m_isLastTextNonGTP;

    private boolean m_timeStamp;

    private final int m_historyMin;

    private final int m_historyMax;

    private int m_lines;

    private int m_truncated;

    private final long m_startTime;

    private void appendText(String text, String style)
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(29);assert SwingUtilities.isEventDispatchThread();
        $qualityscroll_cover_jacov_probe_48fc43a112228949(30);if ((text.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(32) && false))
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(31);return;}
        $qualityscroll_cover_jacov_probe_48fc43a112228949(33);int indexNewLine = 0;
        $qualityscroll_cover_jacov_probe_48fc43a112228949(34);while (((indexNewLine = text.indexOf('\n', indexNewLine)) != -1) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(36) && false))
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(35);++m_lines;
            ++indexNewLine;
        }
        $qualityscroll_cover_jacov_probe_48fc43a112228949(37);Document doc = getDocument();
        Style s = null;
        $qualityscroll_cover_jacov_probe_48fc43a112228949(38);if ((style != null) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(40) && false))
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(39);s = getStyle(style);}
        try
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(41);int length = doc.getLength();
            doc.insertString(length, text, s);
            setPositionToEnd();
        }
        catch (BadLocationException e)
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(45);assert false;
        }
        $qualityscroll_cover_jacov_probe_48fc43a112228949(42);if ((m_lines > m_historyMax) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(44) && false))
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(43);truncateHistory();
            setPositionToEnd();
        }
    }

    private void appendTimeStamp()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(46);if ((! m_timeStamp) ? true : (!$qualityscroll_cover_jacov_probe_48fc43a112228949(48) && false))
            {$qualityscroll_cover_jacov_probe_48fc43a112228949(47);return;}
        $qualityscroll_cover_jacov_probe_48fc43a112228949(49);long timeMillis = System.currentTimeMillis();
        double diff = (float)(timeMillis - m_startTime) / 1000;
        appendText(Clock.getTimeString(diff, -1) + " ", "time");
    }

    private void truncateHistory()
    {
        $qualityscroll_cover_jacov_probe_48fc43a112228949(50);int truncateLines = m_lines - m_historyMin;
        Document doc = getDocument();
        try
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(51);String text = doc.getText(0, doc.getLength());
            int truncateIndex = findTruncateIndex(text, truncateLines);
            assert truncateIndex != -1;
            doc.remove(0, truncateIndex);
            m_lines -= truncateLines;
            m_truncated += truncateLines;
        }
        catch (BadLocationException e)
        {
            $qualityscroll_cover_jacov_probe_48fc43a112228949(52);assert false;
        }
    }
}
