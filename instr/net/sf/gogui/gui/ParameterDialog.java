/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// ParameterDialog.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import static java.lang.Math.max;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.UNINITIALIZED_VALUE;
import static javax.swing.JOptionPane.VALUE_PROPERTY;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.sf.gogui.gtp.AnalyzeUtil;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.ParameterType;
import static net.sf.gogui.gui.GuiUtil.SMALL_PAD;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.ObjectUtil;
import net.sf.gogui.util.StringUtil;

/** Dialog for editing parameters in response to an analyze command of type
    <i>param</i>. */
public class ParameterDialog
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ParameterDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8901872752849122192L,/* translation unit id   */ -3428309042344931027L,/* timestamp             */ 1709177902648L,/* source file name      */ "ParameterDialog.java",/* probe size            */ 92);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d06c331706c5512d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void editParameters(final String paramCommand, Frame owner,
                                      String title, String response,
                                      final GuiGtpClient gtp,
                                      final MessageDialogs messageDialogs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(0);final ArrayList<Parameter> parameters = parseResponse(response);
        Component mainComponent = createMainComponent(parameters);
        final Object options[] = { i18n("LB_OK"), i18n("LB_CANCEL") };
        final JOptionPane optionPane =
            new JOptionPane(mainComponent, PLAIN_MESSAGE, OK_CANCEL_OPTION,
                            null, options, options[0]);
        final JDialog dialog = new JDialog(owner, title, true);
        dialog.setContentPane(optionPane);

        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
				public void propertyChange(PropertyChangeEvent event) {
                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(1);String prop = event.getPropertyName();
                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(2);if ((dialog.isVisible() && event.getSource() == optionPane
                        && prop.equals(VALUE_PROPERTY)) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(4) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d06c331706c5512d(3);Object value = optionPane.getValue();
                        $qualityscroll_cover_jacov_probe_d06c331706c5512d(5);if ((ObjectUtil.equals(value, UNINITIALIZED_VALUE)) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(7) && false))
                            {$qualityscroll_cover_jacov_probe_d06c331706c5512d(6);return;}
                        $qualityscroll_cover_jacov_probe_d06c331706c5512d(8);if ((ObjectUtil.equals(value, options[0])) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(10) && false))
                        {
                            $qualityscroll_cover_jacov_probe_d06c331706c5512d(9);for (int i = 0; (i < parameters.size()) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(12) && false); ++i)
                            {
                                $qualityscroll_cover_jacov_probe_d06c331706c5512d(11);Parameter parameter = parameters.get(i);
                                $qualityscroll_cover_jacov_probe_d06c331706c5512d(14);if ((! parameter.isChanged()) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(16) && false))
                                    {$qualityscroll_cover_jacov_probe_d06c331706c5512d(15);continue;}
                                try
                                {
                                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(17);String command =
                                        getNewValueCommand(paramCommand,
                                                           parameter);
                                    gtp.send(command);
                                }
                                catch (GtpError e)
                                {
                                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(18);showError(dialog, messageDialogs,
                                              parameter, e);
                                    optionPane.setValue(UNINITIALIZED_VALUE);
                                    return;
                                }
                            }
                        }
                        $qualityscroll_cover_jacov_probe_d06c331706c5512d(13);dialog.setVisible(false);
                    }
                }
            });
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.addWindowListener(new WindowAdapter() {
                @Override
				public void  windowOpened(WindowEvent e) {
                    // JDK 1.5 docs require to invoke selectInitialValue after
                    // the window is made visible
                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(19);optionPane.selectInitialValue();
                } });
        dialog.setVisible(true);
    }

    /** Length of a textfield for editing string parameters. */
    private static final int TEXTFIELD_LEN = 13;

    private static final int MAX_PARAM_PER_COLUMN = 15;

    private abstract static class Parameter
    {
        public Parameter(String key, String value)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(20);m_key = key;
            m_value = value;
            m_label = StringUtil.capitalize(key.replace('_', ' '));
        }

        public String getKey()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(21);return m_key;
        }

        public String getLabel()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(22);return m_label;
        }

        public String getValue()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(23);return m_value;
        }

        public abstract String getNewValue();

        public abstract boolean isChanged();

        public abstract void createComponents(int gridy, JPanel panel,
                                              GridBagLayout gridbag);

        private final String m_key;

        private final String m_label;

        private final String m_value;
    }

    private static class BoolParameter
        extends Parameter
    {
        public BoolParameter(String key, String value)
        {
            super(key, value);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d06c331706c5512d(24);
            try
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(25);m_initialValue = (Integer.parseInt(value) != 0);
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(26);m_initialValue = false;
            }
        }

        @Override
		public String getNewValue()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(27);if ((m_checkBox.isSelected()) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(29) && false))
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(28);return "1";}
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(30);return "0";
        }

        @Override
		public boolean isChanged()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(31);return (m_checkBox.isSelected() != m_initialValue);
        }

        @Override
		public void createComponents(int gridy, JPanel panel,
                                     GridBagLayout gridbag)
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(32);m_checkBox = new JCheckBox(getLabel(), m_initialValue);
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = gridy;
            constraints.gridwidth = GridBagConstraints.REMAINDER;
            constraints.weightx = 1.0;
            constraints.anchor = GridBagConstraints.WEST;
            gridbag.setConstraints(m_checkBox, constraints);
            panel.add(m_checkBox);
        }

        private boolean m_initialValue;

        private JCheckBox m_checkBox;
    }

    private static class ListParameter
        extends Parameter
    {
        public ListParameter(String type, String key, String value)
        {
            super(key, value);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d06c331706c5512d(33);
            String[] args = type.split("/");
            assert args[0].equals("list");
            m_items = new String[args.length - 1];
            m_labels = new String[args.length - 1];
            int initialIndex = 0;
            int maxLength = 0;
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(34);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(36) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(35);String item = args[i];
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(38);if ((item.equals(value)) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(40) && false))
                    {$qualityscroll_cover_jacov_probe_d06c331706c5512d(39);initialIndex = i - 1;}
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(41);maxLength = max(item.length(), maxLength);
                m_items[i - 1] = item;
                m_labels[i - 1] =
                    StringUtil.capitalize(item.replace('_', ' '));
            }
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(37);m_initialIndex = initialIndex;
        }

        @Override
		public String getNewValue()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(42);return m_items[m_comboBox.getSelectedIndex()];
        }

        @Override
		public boolean isChanged()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(43);return (m_comboBox.getSelectedIndex() != m_initialIndex);
        }

        // See comment at m_comboBox
        @Override
		@SuppressWarnings("unchecked")
        public void createComponents(int gridy, JPanel panel,
                                     GridBagLayout gridbag)
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(44);JLabel label = new JLabel(getLabel() + ":");
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = gridy;
            constraints.weightx = 1.0;
            constraints.ipadx = SMALL_PAD;
            constraints.insets = new Insets(SMALL_PAD, 0, 0, 0);
            constraints.anchor = GridBagConstraints.EAST;
            gridbag.setConstraints(label, constraints);
            panel.add(label);

            m_comboBox = new JComboBox(m_labels);
            m_comboBox.setSelectedIndex(m_initialIndex);
            constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = gridy;
            constraints.weightx = 1.0;
            constraints.insets = new Insets(SMALL_PAD, 0, 0, 0);
            constraints.anchor = GridBagConstraints.WEST;
            gridbag.setConstraints(m_comboBox, constraints);
            panel.add(m_comboBox);
        }

        private final int m_initialIndex;

        private final String[] m_items;

        private final String[] m_labels;

        /** @note JComboBox is a generic type since Java 7. We use a raw type
            and suppress unchecked warnings where needed to be compatible with
            earlier Java versions. */
        private JComboBox m_comboBox;
    }

    private static class StringParameter
        extends Parameter
    {
        public StringParameter(String key, String value)
        {
            super(key, value);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d06c331706c5512d(45);
        }

        @Override
		public String getNewValue()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(46);return m_textField.getText().trim();
        }

        @Override
		public boolean isChanged()
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(47);return ! getNewValue().equals(getValue());
        }

        @Override
		public void createComponents(int gridy, JPanel panel,
                                     GridBagLayout gridbag)
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(48);JLabel label = new JLabel(getLabel() + ":");
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = gridy;
            constraints.weightx = 1.0;
            constraints.ipadx = SMALL_PAD;
            constraints.insets = new Insets(SMALL_PAD, 0, 0, 0);
            constraints.anchor = GridBagConstraints.EAST;
            gridbag.setConstraints(label, constraints);
            panel.add(label);

            m_textField = new JTextField(TEXTFIELD_LEN);
            m_textField.setText(getValue());
            constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = gridy;
            constraints.weightx = 1.0;
            constraints.insets = new Insets(SMALL_PAD, 0, 0, 0);
            constraints.anchor = GridBagConstraints.WEST;
            gridbag.setConstraints(m_textField, constraints);
            panel.add(m_textField);
        }

        private JTextField m_textField;
    }

    private static ArrayList<Parameter> parseResponse(String response)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(49);ArrayList<Parameter> parameters = new ArrayList<Parameter>();
        BufferedReader reader =
            new BufferedReader(new StringReader(response));
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(50);while (true)
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(51);String line = null;
            try
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(54);line = reader.readLine();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_d06c331706c5512d(69);
            }
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(55);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(57) && false))
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(56);break;}
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(58);AnalyzeUtil.Result result = AnalyzeUtil.parseParameterLine(line);
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(59);if ((result == null) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(61) && false))
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(60);continue;}
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(62);if ((result.m_type == ParameterType.BOOL) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(64) && false))
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(63);parameters.add(new BoolParameter(result.m_key,
                                                 result.m_value));}
            else {$qualityscroll_cover_jacov_probe_d06c331706c5512d(65);if ((result.m_type == ParameterType.LIST) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(67) && false))
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(66);parameters.add(new ListParameter(result.m_typeInfo,
                                                 result.m_key,
                                                 result.m_value));}
            else
                // Treat unknown types as string for compatibiliy with future
                // types
                {$qualityscroll_cover_jacov_probe_d06c331706c5512d(68);parameters.add(new StringParameter(result.m_key,
                                                   result.m_value));}}
        }
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(53);return parameters;
    }

    private static Component
        createMainComponent(ArrayList<Parameter> parameters)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(70);int numberParameters = parameters.size();
        Box outerBox = Box.createHorizontalBox();
        int i = 0;
        int numberColumns = 0;
        JPanel panel = null;
        GridBagLayout gridbag = null;
        int gridy = 0;
        int paramPerColumn =
            (numberParameters + 1)
            / (numberParameters / MAX_PARAM_PER_COLUMN + 1);
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(71);while ((i < numberParameters) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(73) && false))
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(72);if ((i % paramPerColumn == 0) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(82) && false))
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(81);if ((panel != null) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(84) && false))
                {
                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(83);if ((numberColumns > 0) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(86) && false))
                    {
                        $qualityscroll_cover_jacov_probe_d06c331706c5512d(85);outerBox.add(GuiUtil.createFiller());
                        outerBox.add(new JSeparator(SwingConstants.VERTICAL));
                        outerBox.add(GuiUtil.createFiller());
                    }
                    $qualityscroll_cover_jacov_probe_d06c331706c5512d(87);outerBox.add(panel);
                    ++numberColumns;
                }
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(88);gridbag = new GridBagLayout();
                panel = new JPanel(gridbag);
                gridy = 0;
            }
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(89);parameters.get(i).createComponents(gridy, panel, gridbag);
            ++gridy;
            ++i;
        }
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(74);if ((panel != null) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(76) && false))
        {
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(75);if ((numberColumns > 0) ? true : (!$qualityscroll_cover_jacov_probe_d06c331706c5512d(78) && false))
            {
                $qualityscroll_cover_jacov_probe_d06c331706c5512d(77);outerBox.add(GuiUtil.createFiller());
                outerBox.add(new JSeparator(SwingConstants.VERTICAL));
                outerBox.add(GuiUtil.createFiller());
            }
            $qualityscroll_cover_jacov_probe_d06c331706c5512d(79);outerBox.add(panel);
        }
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(80);return outerBox;
    }

    private static String getNewValueCommand(String paramCommand,
                                             Parameter parameter)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(90);String key = parameter.getKey();
        String value = parameter.getNewValue();
        return AnalyzeUtil.getParameterCommand(paramCommand, key, value);
    }

    private static void showError(JDialog owner, MessageDialogs messageDialogs,
                                  Parameter parameter, GtpError e)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d06c331706c5512d(91);String mainMessage =
            MessageFormat.format(i18n("MSG_PARAMDIALOG_COULD_NOT_CHANGE"),
                                 parameter.getLabel());
        String optionalMessage = StringUtil.capitalize(e.getMessage());
        messageDialogs.showError(owner, mainMessage, optionalMessage);
    }
}
