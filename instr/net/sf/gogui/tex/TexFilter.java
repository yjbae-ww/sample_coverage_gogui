/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// TexFilter.java

package net.sf.gogui.tex;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import net.sf.gogui.util.FileUtil;

/** File filter for accepting LaTeX files. */
public class TexFilter
    extends FileFilter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TexFilter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1361815926069319017L,/* translation unit id   */ 6060051810455190176L,/* timestamp             */ 1709177902936L,/* source file name      */ "TexFilter.java",/* probe size            */ 5);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_5419a1039aa4faa0(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}@Override
	public boolean accept(File file)
    {
        $qualityscroll_cover_jacov_probe_5419a1039aa4faa0(0);if ((file.isDirectory()) ? true : (!$qualityscroll_cover_jacov_probe_5419a1039aa4faa0(2) && false))
            {$qualityscroll_cover_jacov_probe_5419a1039aa4faa0(1);return true;}
        $qualityscroll_cover_jacov_probe_5419a1039aa4faa0(3);return FileUtil.hasExtension(file, "tex");
    }

    @Override
	public String getDescription()
    {
        $qualityscroll_cover_jacov_probe_5419a1039aa4faa0(4);return "LaTex files (*.tex)";
    }

}
