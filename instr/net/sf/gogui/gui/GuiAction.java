/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiAction.java

package net.sf.gogui.gui;

import java.awt.Toolkit;
import static java.text.MessageFormat.format;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import static javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
import javax.swing.KeyStroke;

/** AbstractAction with additional features.
    Keeps a global variable that stores all actions to allow to register
    the accelerator keys at windows and dialogs with a single function
    call (GuiAction.registerAll()).
    The action name may contain a mnemomic marked with a preceding '&amp;'
    (like in Qt). This mnemonic is intended for use in a menu, it is not set
    as the global mnemonic for the action, but only stored for later use
    (see GuiAction.getNameWithMnemonic(), GuiUtil.setTextAndMnemonic()). */
public abstract class GuiAction
    extends AbstractAction
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiAction.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -841870383985319662L,/* translation unit id   */ -3470555328666893352L,/* timestamp             */ 1709177902308L,/* source file name      */ "GuiAction.java",/* probe size            */ 31);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static final ArrayList<GuiAction> s_allActions
        = new ArrayList<GuiAction>();

    public GuiAction(String name)
    {
        this(name, null, null, 0, null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(0);
    }

    public GuiAction(String name, String desc)
    {
        this(name, desc, null, 0, null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(1);
    }

    public GuiAction(String name, String desc, String icon)
    {
        this(name, desc, null, 0, icon);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(2);
    }

    public GuiAction(String name, String desc, int accel, String icon)
    {
        this(name, desc, accel, SHORTCUT, icon);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(3);
    }

    public GuiAction(String name, String desc, int accel)
    {
        this(name, desc, accel, SHORTCUT, null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(4);
    }

    public GuiAction(String name, String desc, int accel, int modifier)
    {
        this(name, desc, accel, modifier, null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(5);
    }

    public GuiAction(String name, String desc, Integer accel, int modifier,
                     String icon)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(6);m_nameWithMnemonic = name;
        name = name.replace("&", "");
        putValue(Action.NAME, name);
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(7);if ((desc != null) ? true : (!$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(9) && false))
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(8);putValue(Action.SHORT_DESCRIPTION, desc);}
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(10);if ((accel != null) ? true : (!$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(12) && false))
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(11);putValue(Action.ACCELERATOR_KEY,
                     getKeyStroke(accel.intValue(), modifier));}
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(13);if ((icon != null) ? true : (!$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(15) && false))
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(14);putValue(Action.SMALL_ICON, GuiUtil.getIcon(icon, name));}
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(16);s_allActions.add(this);
    }

    /** Get the name of the action with the mnemonic marked with a preceeding
        '&amp;' (like in Qt). */
    public String getNameWithMnemonic()
    {
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(17);return m_nameWithMnemonic;
    }

    /** Register the accelerator key of an action at a component. */
    public static void register(JComponent component, GuiAction action)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(18);KeyStroke keyStroke =
            (KeyStroke)action.getValue(Action.ACCELERATOR_KEY);
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(19);if ((keyStroke != null) ? true : (!$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(21) && false))
        {
            $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(20);String name = (String)action.getValue(Action.NAME);
            InputMap inputMap =
                component.getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            inputMap.put(keyStroke, name);
            component.getActionMap().put(name, action);
        }
    }

    /** Register the accelerator keys of all actions at a component. */
    public static void registerAll(JComponent component)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(22);for (GuiAction action : s_allActions)
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(23);register(component, action);}
    }

    public final void setDescription(String desc)
    {
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(24);if ((desc == null) ? true : (!$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(26) && false))
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(25);putValue(Action.SHORT_DESCRIPTION, null);}
        else
            {$qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(27);putValue(Action.SHORT_DESCRIPTION, desc);}
    }

    public void setDescription(String desc, Object... args)
    {
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(28);putValue(Action.SHORT_DESCRIPTION, format(desc, args));
    }

    public void setSelected(boolean selected)
    {
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(29);putValue("selected", Boolean.valueOf(selected));
    }

    private static final int SHORTCUT
        = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

    private String m_nameWithMnemonic;

    private static KeyStroke getKeyStroke(int keyCode, int modifier)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cfd61c50fd7883d8(30);return KeyStroke.getKeyStroke(keyCode, modifier);
    }
}
