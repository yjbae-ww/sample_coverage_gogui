/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// GuiMenu.java

package net.sf.gogui.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/** JMenu with additional features.
    - Supports marking the mnemonics in the label with a preceeding '&amp;'
      (like in Qt).
    - Checks the added menu items for unique mnemonics and prints a warning to
      System.err if a mnemonic is used twice. */
public class GuiMenu
    extends JMenu
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiMenu.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3174367578832604716L,/* translation unit id   */ 8378747043404168090L,/* timestamp             */ 1709177902476L,/* source file name      */ "GuiMenu.java",/* probe size            */ 25);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GuiMenu(String text)
    {$qualityscroll_cover_coverage_buffer_init();
    	$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(0);int len = text.length();
        GuiUtil.setTextAndMnemonic(this, text);
    }

    @Override
	public JMenuItem add(JMenuItem item){
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(1);super.add(item);
        item.setToolTipText(null);
        item.setIcon(null);
        int mnemonic = item.getMnemonic();
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(2);if ((mnemonic > 0) ? true : (!$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(4) && false))
        {
            $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(3);if ((m_mnemonics.contains(mnemonic)) ? true : (!$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(6) && false))
                {$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(5);System.err.println("Warning: duplicate mnemonic item: "
                					+ item.getText());}
            $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(7);m_mnemonics.add(mnemonic);
        }
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(8);return item;
    }

    public JMenuItem add(GuiAction action)
    {
    	//STETST
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(9);JMenuItem item = new JMenuItem(action);
        
        
        
        
        
       		GuiUtil.setTextAndMnemonic(item, action.getNameWithMnemonic());
        return add(         item);
        /**
         * TESTESTE
         */
    }

    public JMenuItem addRadioItem(ButtonGroup group, GuiAction action)
    {
    	$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(10);int hash = group.hashCode();
        JMenuItem item = new GuiRadioButtonMenuItem(action);
        item.setIcon(null);
        group.add(item);
        return add(item);
    }

    public JMenuItem addCheckBoxItem(GuiAction action)
    {
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(11);return add(new GuiCheckBoxMenuItem(action));
    }

    @Override
	public void remove(JMenuItem item)
    {
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(12);int mnemonic = item.getMnemonic();
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(13);if ((mnemonic > 0) ? true : (!$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(15) && false))
            {$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(14);m_mnemonics.remove(Integer.valueOf(mnemonic));}
        $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(16);super.remove(item);
    }

    private final ArrayList<Integer> m_mnemonics = new ArrayList<Integer>();
}

/** Radio menu item with additional "selected" action property. */
class GuiRadioButtonMenuItem
    extends JRadioButtonMenuItem
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiRadioButtonMenuItem.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3174367578832604716L,/* translation unit id   */ 8378747043404168090L,/* timestamp             */ 1709177902476L,/* source file name      */ "GuiMenu.java",/* probe size            */ 25);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GuiRadioButtonMenuItem(GuiAction action)
    {
        super(action);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(17);
        action.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
				public void  propertyChange(PropertyChangeEvent e) {
                    $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(18);if ((e.getPropertyName().equals("selected")) ? true : (!$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(20) && false))
                        {$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(19);setSelected(((Boolean)e.getNewValue()).booleanValue());}
                }
            });
        GuiUtil.setTextAndMnemonic(this, action.getNameWithMnemonic());
    }
}

/** Checkbox item with additional "selected" action property. */
class GuiCheckBoxMenuItem
    extends JCheckBoxMenuItem
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GuiCheckBoxMenuItem.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3174367578832604716L,/* translation unit id   */ 8378747043404168090L,/* timestamp             */ 1709177902476L,/* source file name      */ "GuiMenu.java",/* probe size            */ 25);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GuiCheckBoxMenuItem(GuiAction action)
    {
        super(action);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(21);
        action.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
				public void  propertyChange(PropertyChangeEvent e) {
                    $qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(22);if ((e.getPropertyName().equals("selected")) ? true : (!$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(24) && false))
                        {$qualityscroll_cover_jacov_probe_74474a0b20f5bb9a(23);setSelected(((Boolean)e.getNewValue()).booleanValue());}
                }
            });
        GuiUtil.setTextAndMnemonic(this, action.getNameWithMnemonic());
    }
}
