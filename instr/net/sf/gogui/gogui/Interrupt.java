/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// Interrupt.java

package net.sf.gogui.gogui;

import java.awt.Component;
import javax.swing.JOptionPane;
import net.sf.gogui.gtp.GtpError;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.GuiGtpClient;
import net.sf.gogui.gui.MessageDialogs;
import net.sf.gogui.util.Platform;

/** Interrupt command. */
public final class Interrupt
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Interrupt.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7556059271235613836L,/* translation unit id   */ -1844046604397825695L,/* timestamp             */ 1709177901050L,/* source file name      */ "Interrupt.java",/* probe size            */ 17);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e668a1622b9a3161(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Interrupt command.
        Confirm interrupt by user and send interrupt comment line if
        supported by the program, otherwise kill the program.
        @return true if interrupt comment line was sent. */
    public boolean run(Component parent, GuiGtpClient gtp,
                       MessageDialogs messageDialogs)
    {
        $qualityscroll_cover_jacov_probe_e668a1622b9a3161(0);if ((! gtp.isInterruptSupported()) ? true : (!$qualityscroll_cover_jacov_probe_e668a1622b9a3161(2) && false))
        {
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(1);Object[] options =
                { i18n("LB_INTERRUPT_TERMINATE"), i18n("LB_CANCEL") };
            Object message = i18n("MSG_INTERRUPT_NO_SUPPORT");
            int type = JOptionPane.WARNING_MESSAGE;
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(3);if ((Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_e668a1622b9a3161(5) && false))
                {$qualityscroll_cover_jacov_probe_e668a1622b9a3161(4);type = JOptionPane.PLAIN_MESSAGE;}
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(6);int n = JOptionPane.showOptionDialog(parent, message,
                                                 i18n("TIT_QUESTION"),
                                                 JOptionPane.YES_NO_OPTION,
                                                 type, null, options,
                                                 options[1]);
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(7);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_e668a1622b9a3161(9) && false))
                {$qualityscroll_cover_jacov_probe_e668a1622b9a3161(8);gtp.destroyGtp();}
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(10);return false;
        }
        $qualityscroll_cover_jacov_probe_e668a1622b9a3161(11);if ((! gtp.isCommandInProgress()) ? true : (!$qualityscroll_cover_jacov_probe_e668a1622b9a3161(13) && false))
            {$qualityscroll_cover_jacov_probe_e668a1622b9a3161(12);return false;}
        try
        {
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(14);gtp.sendInterrupt();
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_e668a1622b9a3161(16);messageDialogs.showError(parent, i18n("MSG_INTERRUPT_FAILED"), e);
            return false;
        }
        $qualityscroll_cover_jacov_probe_e668a1622b9a3161(15);return true;
    }
}
