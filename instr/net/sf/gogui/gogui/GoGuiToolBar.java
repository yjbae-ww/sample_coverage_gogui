/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGuiToolBar.java

package net.sf.gogui.gogui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import net.sf.gogui.util.Platform;

/** Tool bar for GoGui. */
public class GoGuiToolBar
    extends JToolBar
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiToolBar.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 676621976759584090L,/* translation unit id   */ 2235456129992705669L,/* timestamp             */ 1709177900928L,/* source file name      */ "GoGuiToolBar.java",/* probe size            */ 13);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Tool bar for GoGui. */
    public GoGuiToolBar(GoGui goGui)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(0);m_goGui = goGui;
        GoGuiActions actions = m_goGui.getActions();
        m_actions = actions;
        addButton(actions.m_actionOpen);
        addButton(actions.m_actionSave);
        addSeparator();
        addButton(actions.m_actionNewGame);
        addButton(actions.m_actionPass);
        addButton(actions.m_actionPlay);
        addSeparator();
        addToggleButton(actions.m_actionSetupBlack);
        addToggleButton(actions.m_actionSetupWhite);
        addSeparator();
        addButton(actions.m_actionBeginning);
        addButton(actions.m_actionBackwardTen);
        addButton(actions.m_actionBackward);
        addButton(actions.m_actionForward);
        addButton(actions.m_actionForwardTen);
        addButton(actions.m_actionEnd);
        addSeparator();
        addButton(actions.m_actionNextVariation);
        addButton(actions.m_actionPreviousVariation);
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(1);if ((! Platform.isMac()) ? true : (!$qualityscroll_cover_jacov_probe_1f05ef819b2f4685(3) && false))
            {$qualityscroll_cover_jacov_probe_1f05ef819b2f4685(2);setRollover(true);}
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(4);setFloatable(false);
    }

    private final GoGui m_goGui;

    private final GoGuiActions m_actions;

    private AbstractButton addButton(AbstractButton button)
    {
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(5);button.setFocusable(false);
        add(button);
        return button;
    }

    private JButton addButton(AbstractAction action)
    {
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(6);JButton button = new JButton(action);
        //button.putClientProperty("Quaqua.Button.style", "toolbar");
        setAction(button, action);
        addButton(button);
        return button;
    }

    private GoGuiToggleButton addToggleButton(AbstractAction action)
    {
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(7);GoGuiToggleButton button = new GoGuiToggleButton(action);
        setAction(button, action);
        addButton(button);
        return button;
    }

    private void setAction(AbstractButton button, Action action)
    {
        $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(8);button.setAction(action);
        button.setText(null);
    }
}

/** Toggle button with additional "selected" action property. */
class GoGuiToggleButton
    extends JToggleButton
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiToggleButton.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 676621976759584090L,/* translation unit id   */ 2235456129992705669L,/* timestamp             */ 1709177900928L,/* source file name      */ "GoGuiToolBar.java",/* probe size            */ 13);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GoGuiToggleButton(AbstractAction action)
    {
        super(action);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_1f05ef819b2f4685(9);
        action.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
				public void  propertyChange(PropertyChangeEvent e) {
                    $qualityscroll_cover_jacov_probe_1f05ef819b2f4685(10);if ((e.getPropertyName().equals("selected")) ? true : (!$qualityscroll_cover_jacov_probe_1f05ef819b2f4685(12) && false))
                        {$qualityscroll_cover_jacov_probe_1f05ef819b2f4685(11);setSelected(((Boolean)e.getNewValue()).booleanValue());}
                }
            });
    }
}
