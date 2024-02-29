/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// RegressUtil.java

package net.sf.gogui.tools.regress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;

/** Utility functions used in this package. */
public class RegressUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = RegressUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -5742105054227219913L,/* translation unit id   */ 4561267167099942842L,/* timestamp             */ 1709177903434L,/* source file name      */ "RegressUtil.java",/* probe size            */ 32);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Check if files exist.
        @param list List of file names (as strings)
        @throws ErrorMessage If one of the files is not a normal file or
        not readable. */
    public static void checkFiles(ArrayList<String> list) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(0);for (int i = 0; (i < list.size()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(2) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(1);File file = new File(list.get(i));
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(3);if ((! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(5) && false))
                {$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(4);throw new ErrorMessage("File not found: " + file);}
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(6);if ((! file.isFile()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(8) && false))
                {$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(7);throw new ErrorMessage("Not a normal file: " + file);}
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(9);if ((! file.canRead()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(11) && false))
                {$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(10);throw new ErrorMessage("No read permissions: " + file);}
        }
    }

    /** Expands all test suites (names starting with '@') by the tests in
        the test suite file (without the '@').
        The file is expected to be in a format as used by
        FileUtil.readStringListFromFile.
        The expansion is done recursively.
        @param list List of test names (as strings)
        @return List of test names (as strings) with all test suites
        expanded. */
    public static ArrayList<String> expandTestSuites(ArrayList<String> list)
        throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(12);while ((containsTestSuite(list)) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(14) && false))
        {
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(13);ArrayList<String> newList = new ArrayList<String>();
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(16);for (int i = 0; (i < list.size()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(18) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(17);String name = list.get(i);
                $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(20);if ((name.startsWith("@")) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(22) && false))
                {
                    $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(21);File file = new File(name.substring(1));
                    newList.addAll(FileUtil.readStringListFromFile(file));
                }
                else
                    {$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(23);newList.add(name);}
            }
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(19);list = newList;
        }
        $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(15);return list;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private RegressUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(24);
    }

    private static boolean containsTestSuite(ArrayList<String> list)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(25);for (int i = 0; (i < list.size()) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(27) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(26);String name = list.get(i);
            $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(29);if ((name.startsWith("@")) ? true : (!$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(31) && false))
                {$qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(30);return true;}
        }
        $qualityscroll_cover_jacov_probe_3f4ce05264a4f7ba(28);return false;
    }
}
