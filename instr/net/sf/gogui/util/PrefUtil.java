/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// PrefUtil.java

package net.sf.gogui.util;

import java.util.ArrayList;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

/** Utils for using java.util.prefs package. */
public final class PrefUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = PrefUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8633836047646360907L,/* translation unit id   */ 7058090489993269622L,/* timestamp             */ 1709177904093L,/* source file name      */ "PrefUtil.java",/* probe size            */ 33);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Get node path, create if not already existing.
        @param path The absolute path name of the node.
        @return The node */
    public static Preferences createNode(String path)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(0);assert ! path.startsWith("/");
        return Preferences.userRoot().node(path);
    }

    /** Get a list of strings from preferences.
        The list is stored as a size property end element_N properties with
        N being the element index.
        @param path The absolute path name of the node.
        @return The list of strings. */
    public static ArrayList<String> getList(String path)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(1);Preferences prefs = getNode(path);
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(2);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(4) && false))
            {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(3);return new ArrayList<String>();}
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(5);int size = prefs.getInt("size", 0);
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(6);if ((size <= 0) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(8) && false))
            {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(7);return new ArrayList<String>();}
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(9);ArrayList<String> result = new ArrayList<String>(size);
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(10);for (int i = 0; (i < size) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(12) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(11);String element = prefs.get("element_" + i, null);
            $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(14);if ((element == null) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(16) && false))
                // Should not happen
                {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(15);break;}
            $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(17);result.add(element);
        }
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(13);return result;
    }

    /** Get node for package and path, return null if not already existing.
        @param path The absolute path name of the node.
        @return The node or null, if node does not exist or failure in the
        backing store. */
    public static Preferences getNode(String path)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(18);assert ! path.startsWith("/");
        Preferences prefs = Preferences.userRoot();
        try
        {
            $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(19);if ((! prefs.nodeExists(path)) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(21) && false))
                {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(20);return null;}
        }
        catch (BackingStoreException e)
        {
            $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(23);return null;
        }
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(22);return prefs.node(path);
    }

    /** Put a list of strings to preferences.
        The list is stored as a size property end element_N properties with
        N being the element index.
        @param path The absolute path name of the node.
        @param list The list of strings. */
    public static void putList(String path, ArrayList<String> list)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(24);Preferences prefs = createNode(path);
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(25);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(27) && false))
            {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(26);return;}
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(28);prefs.putInt("size", list.size());
        $qualityscroll_cover_jacov_probe_61f35fe7c09c9176(29);for (int i = 0; (i < list.size()) ? true : (!$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(31) && false); ++i)
            {$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(30);prefs.put("element_" + i, list.get(i));}
    }

    /** Make constructor unavailable; class is for namespace only. */
    private PrefUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_61f35fe7c09c9176(32);
    }
}
