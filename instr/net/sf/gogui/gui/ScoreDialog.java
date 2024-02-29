/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// ScoreDialog.java

package net.sf.gogui.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import net.sf.gogui.go.CountScore;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Score;
import net.sf.gogui.go.Score.ScoringMethod;
import static net.sf.gogui.go.Score.ScoringMethod.AREA;
import static net.sf.gogui.go.Score.ScoringMethod.TERRITORY;
import static net.sf.gogui.gui.I18n.i18n;

/** Dialog for displaying the game score and result. */
public class ScoreDialog
    extends JDialog
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ScoreDialog.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2568737044678353814L,/* translation unit id   */ -4941945381360048736L,/* timestamp             */ 1709177902724L,/* source file name      */ "ScoreDialog.java",/* probe size            */ 42);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Callback to be called when a score was computed and accepted. */
    public interface Listener
    {
        void actionScoreDone(Score score);
    }

    public ScoreDialog(Frame owner, final Listener listener,
                       ScoringMethod initialRules)
    {
        super(owner, i18n("TIT_SCORE"));$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(0);
        m_initialRules = initialRules;
        WindowAdapter windowAdapter = new WindowAdapter() {
                @Override
				public void windowClosing(WindowEvent event) {
                    $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(1);listener.actionScoreDone(null);
                    dispose();
                }
            };
        addWindowListener(windowAdapter);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Box outerBox = Box.createVerticalBox();

        Box box = Box.createHorizontalBox();
        outerBox.add(box);
        JPanel labels = new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        box.add(labels);
        box.add(GuiUtil.createSmallFiller());
        JPanel values = new JPanel(new GridLayout(0, 1, 0, GuiUtil.PAD));
        box.add(values);
        m_area = createColorEntry("LB_SCORE_AREA", 3,
                                  "TT_SCORE_AREA_BLACK",
                                  "TT_SCORE_AREA_WHITE", labels, values);
        m_territory = createColorEntry("LB_SCORE_TERRITORY", 3,
                                       "TT_SCORE_TERRITORY_BLACK",
                                       "TT_SCORE_TERRITORY_WHITE", labels,
                                       values);
        m_prisoners = createColorEntry("LB_SCORE_PRISONERS", 3,
                                       "TT_SCORE_PRISONERS_BLACK",
                                       "TT_SCORE_PRISONERS_WHITE", labels,
                                       values);
        m_komi = createKomiEntry(3, labels, values);
        m_resultArea = createEntry("LB_SCORE_RESULT_AREA", 8,
                                   "TT_SCORE_RESULT_AREA", labels, values);
        m_resultTerritory = createEntry("LB_SCORE_RESULT_TERRITORY", 8,
                                        "TT_SCORE_RESULT_TERRITORY",
                                        labels, values);
        createRulesEntry(labels, values);
        m_result = createEntry("LB_SCORE_RESULT", 8,
                               "TT_SCORE_RESULT", labels, values);

        JButton okButton = new JButton(i18n("LB_OK"));
        okButton.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(2);listener.actionScoreDone(m_score);
            } });
        m_cancelButton = new JButton(i18n("LB_CANCEL"));
        m_cancelButton.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(3);listener.actionScoreDone(null);
            } });
        Object options[] = { okButton, m_cancelButton };
        JOptionPane optionPane = new JOptionPane(outerBox,
                                                 JOptionPane.PLAIN_MESSAGE,
                                                 JOptionPane.OK_CANCEL_OPTION,
                                                 null, options, options[0]);
        setContentPane(optionPane);
        pack();
    }

    public void showScore(CountScore countScore, Komi komi)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(4);ScoringMethod rules = m_initialRules;
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(5);if ((m_score != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(7) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(6);rules = m_score.m_rules;}
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(8);m_score = countScore.getScore(komi, rules);
        showScore();
    }

    private static class ColorFields
    {
        public JTextField m_black;

        public JTextField m_white;
    }

    private final ScoringMethod m_initialRules;

    private final JButton m_cancelButton;

    private final ColorFields m_territory;

    private final ColorFields m_area;

    private final ColorFields m_prisoners;

    private final JTextField m_komi;

    private final JTextField m_resultArea;

    private final JTextField m_resultTerritory;

    private JRadioButton m_useArea;

    private JRadioButton m_useTerritory;

    private final JTextField m_result;

    private Score m_score;

    private static final ImageIcon ICON_BLACK =
        GuiUtil.getIcon("gogui-black-16x16", i18n("LB_BLACK"));

    private static final ImageIcon ICON_WHITE =
        GuiUtil.getIcon("gogui-white-16x16", i18n("LB_WHITE"));

    private JComponent createEntryLabel(String text)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(9);Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        JLabel label = new JLabel(i18n(text));
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        box.add(label);
        return box;
    }

    private JTextField createEntry(String labelText, int cols, String toolTip,
                                   JComponent labels, JComponent values)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(10);labels.add(createEntryLabel(labelText));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        JTextField field = new JTextField(cols);
        GuiUtil.setEditableFalse(field);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setToolTipText(i18n(toolTip));
        panel.add(field);
        values.add(panel);
        return field;
    }

    private ColorFields createColorEntry(String labelText, int cols,
                                         String toolTipBlack,
                                         String toolTipWhite,
                                         JComponent labels,
                                         JComponent values)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(11);labels.add(createEntryLabel(labelText));
        ColorFields colorFields = new ColorFields();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panel.add(new JLabel(ICON_BLACK));
        panel.add(GuiUtil.createSmallFiller());
        JTextField black = new JTextField(cols);
        black.setHorizontalAlignment(SwingConstants.CENTER);
        colorFields.m_black = black;
        GuiUtil.setEditableFalse(black);
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(12);if ((toolTipBlack != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(14) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(13);black.setToolTipText(i18n(toolTipBlack));}
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(15);panel.add(black);
        panel.add(GuiUtil.createFiller());
        panel.add(new JLabel(ICON_WHITE));
        panel.add(GuiUtil.createSmallFiller());
        JTextField white = new JTextField(cols);
        white.setHorizontalAlignment(SwingConstants.CENTER);
        colorFields.m_white = white;
        GuiUtil.setEditableFalse(white);
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(16);if ((toolTipWhite != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(18) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(17);white.setToolTipText(i18n(toolTipWhite));}
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(19);panel.add(white);
        values.add(panel);
        return colorFields;
    }

    private JTextField createKomiEntry(int cols, JComponent labels,
                                       JComponent values)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(20);labels.add(createEntryLabel("LB_SCORE_KOMI"));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panel.add(new JLabel(ICON_WHITE));
        panel.add(GuiUtil.createSmallFiller());
        JTextField field = new JTextField(cols);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        GuiUtil.setEditableFalse(field);
        field.setToolTipText(i18n("TT_SCORE_KOMI"));
        panel.add(field);
        values.add(panel);
        return field;
    }

    private void createRulesEntry(JComponent labels, JComponent values)
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(21);labels.add(createEntryLabel("LB_SCORE_METHOD"));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        ButtonGroup group = new ButtonGroup();
        m_useArea = new JRadioButton(i18n("LB_SCORE_METHOD_AREA"));
        m_useArea.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(22);if ((m_score != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(24) && false))
                    {
                        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(23);m_score.updateRules(AREA);
                        showScore();
                    }
                }
            });
        m_useArea.setToolTipText(i18n("TT_SCORE_METHOD_AREA"));
        group.add(m_useArea);
        panel.add(m_useArea);
        panel.add(GuiUtil.createFiller());
        m_useTerritory = new JRadioButton(i18n("LB_SCORE_METHOD_TERRITORY"));
        m_useTerritory.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(25);if ((m_score != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(27) && false))
                    {
                        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(26);m_score.updateRules(TERRITORY);
                        showScore();
                    }
                }
            });
        m_useTerritory.setToolTipText(i18n("TT_SCORE_METHOD_TERRITORY"));
        group.add(m_useTerritory);
        panel.add(m_useTerritory);
        values.add(panel);
    }

    private static void setTextInteger(JTextField field, int value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(28);field.setText(Integer.toString(value));
    }

    private void showScore()
    {
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(29);if ((m_score == null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(31) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(30);return;}
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(32);setTextInteger(m_territory.m_black, m_score.m_territoryBlack);
        setTextInteger(m_territory.m_white, m_score.m_territoryWhite);
        setTextInteger(m_area.m_black, m_score.m_areaBlack);
        setTextInteger(m_area.m_white, m_score.m_areaWhite);
        setTextInteger(m_prisoners.m_black, m_score.m_capturedWhite);
        setTextInteger(m_prisoners.m_white, m_score.m_capturedBlack);
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(33);if ((m_score.m_komi != null) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(35) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(34);m_komi.setText(m_score.m_komi.toString());}
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(36);double resultArea = m_score.m_resultArea;
        m_resultArea.setText(Score.formatResult(resultArea));
        double resultTerritory = m_score.m_resultTerritory;
        m_resultTerritory.setText(Score.formatResult(resultTerritory));
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(37);if ((m_score.m_rules == TERRITORY) ? true : (!$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(39) && false))
            {$qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(38);m_useTerritory.setSelected(true);}
        else
        {
            $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(41);assert m_score.m_rules == AREA;
            m_useArea.setSelected(true);
        }
        $qualityscroll_cover_jacov_probe_bb6aaedbf4a6e5a0(40);m_result.setText(m_score.formatResult());
    }
}
