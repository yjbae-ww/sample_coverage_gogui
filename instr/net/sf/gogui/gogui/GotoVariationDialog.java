/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GotoVariationDialog.java

package net.sf.gogui.gogui;

import java.awt.Component;
import javax.swing.JOptionPane;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.gui.MessageDialogs;
import static net.sf.gogui.gogui.I18n.i18n;

/** Ask for a variation. */
public final class GotoVariationDialog
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GotoVariationDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -392858955616651560L,/* translation unit id   */ -8434613944912412781L,/* timestamp             */ 1709177900990L,/* source file name      */ "GotoVariationDialog.java",/* probe size            */ 10);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static ConstNode show(Component parent, ConstGameTree tree,
                                 ConstNode currentNode,
                                 MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(0);String variation = NodeUtil.getVariationString(currentNode);
        Object value =
            JOptionPane.showInputDialog(parent, i18n("LB_VARIATION"),
                                        i18n("TIT_INPUT"),
                                        JOptionPane.PLAIN_MESSAGE, null, null,
                                        variation);
        $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(1);if ((value == null || value.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(3) && false))
            {$qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(2);return null;}
        $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(4);ConstNode root = tree.getRootConst();
        ConstNode node = NodeUtil.findByVariation(root, (String)value);
        $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(5);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(7) && false))
            {$qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(6);messageDialogs.showError(parent, i18n("MSG_VARIATION_INVALID"),
                                     i18n("MSG_VARIATION_INVALID_2"),
                                     false);}
        $qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(8);return node;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private GotoVariationDialog()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_8af23b4e3bf07f93(9);
    }
}
