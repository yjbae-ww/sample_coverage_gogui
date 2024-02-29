/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// ExportPng.java

package net.sf.gogui.gogui;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import net.sf.gogui.boardpainter.BoardPainter;
import net.sf.gogui.boardpainter.BoardPainterUtil;
import net.sf.gogui.boardpainter.ConstField;
import net.sf.gogui.go.GoPoint;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.ConstGuiBoard;
import net.sf.gogui.gui.FileDialogs;
import net.sf.gogui.gui.MessageDialogs;

public final class ExportPng
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ExportPng.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4929038338378751977L,/* translation unit id   */ -6291608980885876137L,/* timestamp             */ 1709177900626L,/* source file name      */ "ExportPng.java",/* probe size            */ 29);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void run(Component parent, ConstGuiBoard guiBoard,
                           Preferences prefs, MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(0);String value = Integer.toString(guiBoard.getWidth());
        boolean done = false;
        int width = 0;
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(1);while ((! done) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(3) && false))
        {
            $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(2);value =
                (String)JOptionPane.showInputDialog(parent,
                                                    i18n("TIT_EXPORTPNG_WIDTH"),
                                                    i18n("LB_EXPORTPNG_WIDTH"),
                                                    JOptionPane.PLAIN_MESSAGE,
                                                    null, null, value);
            $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(17);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(19) && false))
                {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(18);return;}
            try
            {
                $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(20);width = Integer.parseInt(value);
                $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(21);if ((width > 0) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(23) && false))
                    {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(22);done = true;}
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(27);
            }
            $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(24);if ((! done) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(26) && false))
            {
                $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(25);messageDialogs.showError(parent,
                                         i18n("MSG_EXPORTPNG_INVALID_WIDTH"),
                                         i18n("MSG_EXPORTPNG_INVALID_WIDTH_2"),
                                         false);
                continue;
            }
        }
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(4);File file = FileDialogs.showSave(parent, i18n("TIT_EXPORTPNG_FILE"),
                                         messageDialogs);
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(5);if ((file == null) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(7) && false))
            {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(6);return;}
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(8);BoardPainter painter = new BoardPainter();
        int size = guiBoard.getBoardSize();
        ConstField[][] fields = new ConstField[size][size];
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(9);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(11) && false); ++x)
            {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(10);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(16) && false); ++y)
                {$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(15);fields[x][y] = guiBoard.getFieldConst(GoPoint.get(x, y));}}
        $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(12);BufferedImage image
            = BoardPainterUtil.getImage(painter, fields, width, width);
        try
        {
            $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(13);BoardPainterUtil.writeImage(image, file, null);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(14);messageDialogs.showError(parent, i18n("MSG_EXPORTPNG_WRITE_FAIL"),
                                     e.getMessage());
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private ExportPng()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_a8afb6f75ca3d257(28);
    }
}
