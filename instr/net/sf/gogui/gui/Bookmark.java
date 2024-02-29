/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// Bookmark.java

package net.sf.gogui.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.PrefUtil;

/** Link to a position in a game file. */
public final class Bookmark
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Bookmark.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8374130876724780798L,/* translation unit id   */ -7010063528180375779L,/* timestamp             */ 1709177901819L,/* source file name      */ "Bookmark.java",/* probe size            */ 57);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public int m_move;

    public File m_file;

    public String m_name;

    public String m_variation;

    public Bookmark(Bookmark bookmark)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(0);copyFrom(bookmark);
    }

    public Bookmark(String name, File file, int move, String variation)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(1);init(name, file, move, variation);
    }

    public Bookmark(File file, int move, String variation)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(2);String name = "";
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(3);if ((file != null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(5) && false))
        {
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(4);File fileNoExt;
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(6);if ((FileUtil.hasExtension(file, "xml")) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(8) && false))
                {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(7);fileNoExt = new File(FileUtil.removeExtension(file, "xml"));}
            else
                {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(25);fileNoExt = new File(FileUtil.removeExtension(file, "sgf"));}
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(9);name = fileNoExt.getName();
            boolean hasVariation = ! variation.trim().equals("");
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(10);if ((move > 0 || hasVariation) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(12) && false))
            {
                $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(11);name = name + " (";
                $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(13);if ((hasVariation) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(15) && false))
                {
                    $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(14);name = name + variation;
                    $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(16);if ((move > 0) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(18) && false))
                        {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(17);name = name + "/";}
                }
                $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(19);if ((move > 0) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(21) && false))
                    {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(20);name = name + move;}
                $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(22);name = name + ")";
            }
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(23);file = file.getAbsoluteFile();
        }
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(24);init(name, file, move, variation);
    }

    public void copyFrom(Bookmark bookmark)
    {
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(26);init(bookmark.m_name, bookmark.m_file, bookmark.m_move,
             bookmark.m_variation);
    }

    public static ArrayList<Bookmark> load()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(27);ArrayList<Bookmark> bookmarks = new ArrayList<Bookmark>();
        Preferences prefs = PrefUtil.getNode("net/sf/gogui/gui/bookmark");
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(28);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(30) && false))
            {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(29);return bookmarks;}
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(31);int size = prefs.getInt("size", 0);
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(32);for (int i = 0; (i < size) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(34) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(33);prefs = PrefUtil.getNode("net/sf/gogui/gui/bookmark/" + i);
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(36);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(38) && false))
                {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(37);break;}
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(39);String name = prefs.get("name", null);
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(40);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(42) && false))
                {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(41);break;}
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(43);String fileName = prefs.get("file", "");
            int move = prefs.getInt("move", 0);
            String variation = prefs.get("variation", "");
            Bookmark b = new Bookmark(name, new File(fileName), move,
                                      variation);
            bookmarks.add(b);
        }
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(35);return bookmarks;
    }

    public static void save(ArrayList<Bookmark> bookmarks)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(44);Preferences prefs = PrefUtil.createNode("net/sf/gogui/gui/bookmark");
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(45);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(47) && false))
            {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(46);return;}
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(48);prefs.putInt("size", bookmarks.size());
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(49);for (int i = 0; (i < bookmarks.size()) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(51) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(50);prefs = PrefUtil.createNode("net/sf/gogui/gui/bookmark/" + i);
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(52);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(54) && false))
                {$qualityscroll_cover_jacov_probe_9eb7405cade31f1d(53);break;}
            $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(55);Bookmark b = bookmarks.get(i);
            prefs.put("name", b.m_name);
            prefs.put("file", b.m_file.toString());
            prefs.put("move", Integer.toString(b.m_move));
            prefs.put("variation" , b.m_variation);
        }
    }

    private void init(String name, File file, int move, String variation)
    {
        $qualityscroll_cover_jacov_probe_9eb7405cade31f1d(56);assert move >= 0;
        m_file = file;
        m_move = move;
        m_variation = variation.trim();
        m_name = name;
    }
}
