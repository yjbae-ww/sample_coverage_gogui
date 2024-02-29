/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Openings.java

package net.sf.gogui.tools.twogtp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileFilter;
import java.io.IOException;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;

class Filter
    implements FileFilter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Filter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1546904077089267758L,/* translation unit id   */ -898007846321239660L,/* timestamp             */ 1709177903825L,/* source file name      */ "Openings.java",/* probe size            */ 23);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f389a29f22824994(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}@Override
	public boolean accept(File f)
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(0);return FileUtil.hasExtension(f, "sgf");
    }
}

/** Access opening SGF files from directory. */
public class Openings
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Openings.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1546904077089267758L,/* translation unit id   */ -898007846321239660L,/* timestamp             */ 1709177903825L,/* source file name      */ "Openings.java",/* probe size            */ 23);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f389a29f22824994(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Openings(File directory) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f389a29f22824994(1);if ((! directory.isDirectory()) ? true : (!$qualityscroll_cover_jacov_probe_f389a29f22824994(3) && false))
            {$qualityscroll_cover_jacov_probe_f389a29f22824994(2);throw new ErrorMessage(directory + " is not a directory");}
        $qualityscroll_cover_jacov_probe_f389a29f22824994(4);m_directory = directory;
        m_files = directory.listFiles(new Filter());
        $qualityscroll_cover_jacov_probe_f389a29f22824994(5);if ((m_files.length == 0) ? true : (!$qualityscroll_cover_jacov_probe_f389a29f22824994(7) && false))
            {$qualityscroll_cover_jacov_probe_f389a29f22824994(6);throw new ErrorMessage("No SGF files found in " + directory);}
        $qualityscroll_cover_jacov_probe_f389a29f22824994(8);sortFiles();
        m_currentFile = -1;
    }

    public int getBoardSize()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(9);return getTree().getBoardSize();
    }

    /** Get name of directory. */
    public String getDirectory()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(10);return m_directory.toString();
    }

    /** Get name of currently loaded file. */
    public String getFilename()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(11);return m_files[m_currentFile].toString();
    }

    /** Get game information of currently loaded file. */
    public GameInfo getGameInfo()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(12);return m_tree.getGameInfo(m_tree.getRoot());
    }

    /** Get game tree of currently loaded file. */
    public GameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(13);return m_tree;
    }

    /** Get number of opening files in directory. */
    public int getNumber()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(14);return m_files.length;
    }

    /** Load opening file number i. */
    public void loadFile(int i) throws IOException, SgfError
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(15);File file = m_files[i];
        FileInputStream fileStream = new FileInputStream(file);
        SgfReader reader = new SgfReader(fileStream, file, null, 0);
        m_tree = reader.getTree();
        m_currentFile = i;
    }

    private int m_currentFile;

    private final File m_directory;

    private File[] m_files;

    private GameTree m_tree;

    private void sortFiles()
    {
        $qualityscroll_cover_jacov_probe_f389a29f22824994(16);for (int i = 0; (i < m_files.length - 1) ? true : (!$qualityscroll_cover_jacov_probe_f389a29f22824994(18) && false); ++i)
            {$qualityscroll_cover_jacov_probe_f389a29f22824994(17);for (int j = i + 1; (j < m_files.length) ? true : (!$qualityscroll_cover_jacov_probe_f389a29f22824994(20) && false); ++j)
                {$qualityscroll_cover_jacov_probe_f389a29f22824994(19);if ((m_files[i].compareTo(m_files[j]) > 0) ? true : (!$qualityscroll_cover_jacov_probe_f389a29f22824994(22) && false))
                {
                    $qualityscroll_cover_jacov_probe_f389a29f22824994(21);File tmp = m_files[i];
                    m_files[i] = m_files[j];
                    m_files[j] = tmp;
                }}}
    }
}
