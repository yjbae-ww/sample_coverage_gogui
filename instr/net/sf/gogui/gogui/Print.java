/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// Print.java

package net.sf.gogui.gogui;

import java.awt.Component;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import net.sf.gogui.gui.MessageDialogs;
import static net.sf.gogui.gogui.I18n.i18n;

/** Print a printable. */
public final class Print
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Print.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7078743691292111761L,/* translation unit id   */ -8913863210729678559L,/* timestamp             */ 1709177901178L,/* source file name      */ "Print.java",/* probe size            */ 7);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_844b98a33408d921(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void run(Component parent, Printable printable,
                           MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_844b98a33408d921(0);PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);
        $qualityscroll_cover_jacov_probe_844b98a33408d921(1);if ((! job.printDialog()) ? true : (!$qualityscroll_cover_jacov_probe_844b98a33408d921(3) && false))
            {$qualityscroll_cover_jacov_probe_844b98a33408d921(2);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_844b98a33408d921(4);job.print();
        }
        catch (Exception e)
        {
            $qualityscroll_cover_jacov_probe_844b98a33408d921(5);messageDialogs.showError(parent, i18n("MSG_PRINT_FAIL"), "");
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Print()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_844b98a33408d921(6);
    }
}
