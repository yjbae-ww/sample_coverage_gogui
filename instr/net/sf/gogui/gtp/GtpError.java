/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpError.java

package net.sf.gogui.gtp;

import net.sf.gogui.util.ErrorMessage;

/** Exception indicating the failure of a GTP command. */
public class GtpError
    extends ErrorMessage
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpError.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -4071757949676059627L,/* translation unit id   */ -5609849502061056313L,/* timestamp             */ 1709177901573L,/* source file name      */ "GtpError.java",/* probe size            */ 3);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_b225cf99a23faec7(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GtpError(String s)
    {
        super(s);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_b225cf99a23faec7(0);
    }

    /** The command that caused the error.
        Can return null, if the command is not known. */
    public String getCommand()
    {
        $qualityscroll_cover_jacov_probe_b225cf99a23faec7(1);return m_command;
    }

    public void setCommand(String command)
    {
        $qualityscroll_cover_jacov_probe_b225cf99a23faec7(2);m_command = command;
    }

    private String m_command;
}
