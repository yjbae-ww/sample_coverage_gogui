/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// BoardSizeDialog.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import net.sf.gogui.go.GoPoint;
import static net.sf.gogui.gui.I18n.i18n;

/** Dialog for entering a board size. */
public final class BoardSizeDialog
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardSizeDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8336292988270032424L,/* translation unit id   */ 5395312155290108457L,/* timestamp             */ 1709177901791L,/* source file name      */ "BoardSizeDialog.java",/* probe size            */ 15);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Run dialog.
        @return Board size or -1 if aborted. */
    public static int show(Component parent, int size,
                           MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(0);Object value =
            JOptionPane.showInputDialog(parent, i18n("LB_BOARDSIZE_DIALOG"),
                                        i18n("TIT_INPUT"),
                                        JOptionPane.PLAIN_MESSAGE, null, null,
                                        Integer.toString(size));
        $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(1);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(3) && false))
            {$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(2);return -1;}
        $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(4);size = -1;
        try
        {
            $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(5);size = Integer.parseInt((String)value);
            $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(6);if ((size < 1 || size > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(8) && false))
                {$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(7);size = -1;}
        }
        catch (NumberFormatException e)
        {$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(13);
        }
        $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(9);if ((size == -1) ? true : (!$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(11) && false))
        {
            $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(10);String optionalMessage =
                MessageFormat.format(i18n("MSG_BOARDSIZE_DIALOG_INVALID_2"),
                                     GoPoint.MAX_SIZE);
            messageDialogs.showError(parent,
                                     i18n("MSG_BOARDSIZE_DIALOG_INVALID"),
                                     optionalMessage, false);
        }
        $qualityscroll_cover_jacov_probe_4adfffd1d46a0229(12);return size;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private BoardSizeDialog()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_4adfffd1d46a0229(14);
    }
}
