/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// FileCheck.java

package net.sf.gogui.tools.statistics;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.Move;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.util.ErrorMessage;

/** Check that SGF files meet the requirements for a Statistics run. */
public class FileCheck
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = FileCheck.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8491264469193663037L,/* translation unit id   */ -6367599210711658702L,/* timestamp             */ 1709177903548L,/* source file name      */ "FileCheck.java",/* probe size            */ 34);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a7a1be413d794f32(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public FileCheck(ArrayList<String> sgfFiles, int size, boolean allowSetup)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(0);m_size = size;
        m_allowSetup = allowSetup;
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(1);for (int i = 0; (i < sgfFiles.size()) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(3) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(2);m_file = new File(sgfFiles.get(i));
            checkFile();
        }
    }

    private final boolean m_allowSetup;

    private final int m_size;

    private File m_file;

    private void checkFile() throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(4);InputStream in = null;
        try
        {
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(5);in = new FileInputStream(m_file);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(32);throwError("file not found");
        }
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(6);SgfReader reader = new SgfReader(in, m_file, null, 0);
        GameTree tree = reader.getTree();
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(7);if ((tree.getBoardSize() != m_size) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(9) && false))
            {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(8);throwError("size is not " + m_size);}
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(10);ConstNode root = tree.getRoot();
        GoColor toMove = BLACK;
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(11);for (ConstNode node = root; (node != null) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(13) && false); node = node.getChildConst())
        {
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(12);if ((node.hasSetup()) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(15) && false))
            {
                $qualityscroll_cover_jacov_probe_a7a1be413d794f32(14);if ((m_allowSetup) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(17) && false))
                {
                    $qualityscroll_cover_jacov_probe_a7a1be413d794f32(16);if ((node == root) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(19) && false))
                        {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(18);toMove = EMPTY;}
                    else
                        {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(30);throw new ErrorMessage("setup stones"
                                               + " in non-root position");}
                }
                else
                    {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(31);throw new ErrorMessage("contains setup stones");}
            }
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(20);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_a7a1be413d794f32(21);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(23) && false))
            {
                $qualityscroll_cover_jacov_probe_a7a1be413d794f32(22);if ((toMove == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(25) && false))
                    {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(24);toMove = move.getColor();}
                $qualityscroll_cover_jacov_probe_a7a1be413d794f32(26);if ((move.getColor() != toMove) ? true : (!$qualityscroll_cover_jacov_probe_a7a1be413d794f32(28) && false))
                    {$qualityscroll_cover_jacov_probe_a7a1be413d794f32(27);throwError("non-alternating moves");}
                $qualityscroll_cover_jacov_probe_a7a1be413d794f32(29);toMove = toMove.otherColor();
            }
        }
    }

    private void throwError(String reason) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_a7a1be413d794f32(33);throw new ErrorMessage(m_file + ": " + reason);
    }
}
