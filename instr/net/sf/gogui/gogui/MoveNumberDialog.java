/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// MoveNumberDialog.java

package net.sf.gogui.gogui;

import java.awt.Component;
import javax.swing.JOptionPane;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.gui.MessageDialogs;
import static net.sf.gogui.gogui.I18n.i18n;

/** Ask for a move number in a variation given by a node. */
public final class MoveNumberDialog
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = MoveNumberDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4587981950827672735L,/* translation unit id   */ -5731253798361724647L,/* timestamp             */ 1709177901149L,/* source file name      */ "MoveNumberDialog.java",/* probe size            */ 11);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_b0767f092f0a8919(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static ConstNode show(Component parent, ConstNode node,
                                 MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_b0767f092f0a8919(0);int number = NodeUtil.getMoveNumber(node);
        Object value =
            JOptionPane.showInputDialog(parent, i18n("LB_MOVENUMBER"),
                                        i18n("TIT_INPUT"),
                                        JOptionPane.PLAIN_MESSAGE, null, null,
                                        Integer.toString(number));
        $qualityscroll_cover_jacov_probe_b0767f092f0a8919(1);if ((value == null || value.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_b0767f092f0a8919(3) && false))
            {$qualityscroll_cover_jacov_probe_b0767f092f0a8919(2);return null;}
        try
        {
            $qualityscroll_cover_jacov_probe_b0767f092f0a8919(4);number = Integer.parseInt((String)value);
            node = NodeUtil.findByMoveNumber(node, number);
            $qualityscroll_cover_jacov_probe_b0767f092f0a8919(5);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_b0767f092f0a8919(7) && false))
            {
                $qualityscroll_cover_jacov_probe_b0767f092f0a8919(6);messageDialogs.showError(parent,
                                         i18n("MSG_MOVENUMBER_NOT_EXISTING"),
                                         i18n("MSG_MOVENUMBER_NOT_EXISTING_2"),
                                         false);
                return null;
            }
            $qualityscroll_cover_jacov_probe_b0767f092f0a8919(8);return node;
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_b0767f092f0a8919(9);messageDialogs.showError(parent,
                                     i18n("MSG_MOVENUMBER_NO_NUMBER"),
                                     i18n("MSG_MOVENUMBER_NO_NUMBER_2"),
                                     false);
            return null;
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private MoveNumberDialog()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_b0767f092f0a8919(10);
    }
}
