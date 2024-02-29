/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GameFileFilter.java

package net.sf.gogui.gamefile;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import static net.sf.gogui.gamefile.I18n.i18n;
import net.sf.gogui.util.FileUtil;

/** Swing file filter for SGF or Jago XML files. */
public class GameFileFilter
    extends FileFilter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameFileFilter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1389044533349129972L,/* translation unit id   */ 5059817296601190222L,/* timestamp             */ 1709177900163L,/* source file name      */ "GameFileFilter.java",/* probe size            */ 5);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_46381505f04a8f4e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Accept function.
        @param file The file to check.
        @return true if file has extension .sgf or .SGF or is a directory */
    @Override
	public boolean accept(File file)
    {
        $qualityscroll_cover_jacov_probe_46381505f04a8f4e(0);if ((file.isDirectory()) ? true : (!$qualityscroll_cover_jacov_probe_46381505f04a8f4e(2) && false))
            {$qualityscroll_cover_jacov_probe_46381505f04a8f4e(1);return true;}
        $qualityscroll_cover_jacov_probe_46381505f04a8f4e(3);return (FileUtil.hasExtension(file, "sgf")
                || FileUtil.hasExtension(file, "SGF")
                || FileUtil.hasExtension(file, "xml")
                || FileUtil.hasExtension(file, "XML"));
    }

    @Override
	public String getDescription()
    {
        $qualityscroll_cover_jacov_probe_46381505f04a8f4e(4);return i18n("LB_GOGAME");
    }
}
