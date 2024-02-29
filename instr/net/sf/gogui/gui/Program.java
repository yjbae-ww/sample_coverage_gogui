/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// Program.java

package net.sf.gogui.gui;

import java.util.ArrayList;
import java.util.prefs.Preferences;
import static net.sf.gogui.gui.I18n.i18n;
import net.sf.gogui.util.PrefUtil;
import net.sf.gogui.util.ObjectUtil;
import net.sf.gogui.util.StringUtil;

/** Command line and other information to run a GTP engine. */
public final class Program
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Program.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8762248326741758126L,/* translation unit id   */ -3488853578989532636L,/* timestamp             */ 1709177902664L,/* source file name      */ "Program.java",/* probe size            */ 75);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public String m_label;

    public String m_name;

    public String m_version;

    public String m_command;

    public String m_workingDirectory;

    public Program(Program program)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(0);copyFrom(program);
    }

    public Program(String label, String name, String version, String command,
                   String workingDirectory)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(1);init(label, name, version, command, workingDirectory);
    }

    public void copyFrom(Program program)
    {
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(2);init(program.m_label, program.m_name, program.m_version,
             program.m_command, program.m_workingDirectory);
    }

    /** Find program info for a given command in a list of program infos.
        @return The program info or null if no program with this comamnd
        exists */
    public static Program findProgram(ArrayList<Program> programs,
                                      String command)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(3);for (Program p : programs)
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(5);if ((p.m_command.equals(command)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(7) && false))
                {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(6);return p;}}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(4);return null;
    }

    public static ArrayList<Program> load()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(8);ArrayList<Program> programs = new ArrayList<Program>();
        Preferences prefs = PrefUtil.getNode("net/sf/gogui/gui/program");
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(9);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(11) && false))
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(10);return programs;}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(12);int size = prefs.getInt("size", 0);
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(13);for (int i = 0; (i < size) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(15) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(14);prefs = PrefUtil.getNode("net/sf/gogui/gui/program/" + i);
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(17);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(19) && false))
                {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(18);break;}
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(20);String label = prefs.get("label", null);
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(21);if ((label == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(23) && false))
                {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(22);break;}
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(24);String name = prefs.get("name", "");
            String version = prefs.get("version", "");
            String command = prefs.get("command", "");
            String workingDirectory = prefs.get("working-directory", "");
            programs.add(new Program(label, name, version, command,
                                     workingDirectory));
        }
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(16);return programs;
    }

    public static void save(ArrayList<Program> programs)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(25);Preferences prefs = PrefUtil.createNode("net/sf/gogui/gui/program");
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(26);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(28) && false))
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(27);return;}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(29);prefs.putInt("size", programs.size());
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(30);for (int i = 0; (i < programs.size()) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(32) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(31);prefs = PrefUtil.createNode("net/sf/gogui/gui/program/" + i);
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(33);if ((prefs == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(35) && false))
                {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(34);break;}
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(36);Program p = programs.get(i);
            prefs.put("label", p.m_label);
            prefs.put("name", p.m_name);
            prefs.put("version", p.m_version);
            prefs.put("command", p.m_command);
            prefs.put("working-directory", p.m_workingDirectory);
        }
    }

    /** Suggest and set a label derived from program name without
        collision with an existing array of programs. */
    public void setUniqueLabel(ArrayList<Program> programs)
    {
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(37);String label = m_name;
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(38);if ((StringUtil.isEmpty(label)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(40) && false))
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(39);label = i18n("LB_UNKNOWN_PROGRAM");}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(41);String tryLabel = label;
        boolean alreadyExists = false;
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(42);for (int i = 0; (i < programs.size()) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(44) && false); ++i)
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(43);if ((tryLabel.equals((programs.get(i)).m_label)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(59) && false))
            {
                $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(58);alreadyExists = true;
                break;
            }}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(45);if ((! alreadyExists) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(47) && false))
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(46);m_label = tryLabel;
            return;
        }
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(48);for (int i = 2; ; ++i)
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(49);tryLabel = label + " (" + i + ")";
            alreadyExists = false;
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(50);for (int j = 0; (j < programs.size()) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(52) && false); ++j)
                {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(51);if ((tryLabel.equals((programs.get(j)).m_label)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(57) && false))
                {
                    $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(56);alreadyExists = true;
                    break;
                }}
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(53);if ((! alreadyExists) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(55) && false))
            {
                $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(54);m_label = tryLabel;
                return;
            }
        }
    }

    /** Update program information if changed.
        Useful, if a program was replaced, and reports a different name or
        version than at the last invocation.
        @param name Program name at current invovation (may be null)
        @param version Program name at current invovation (may be null)
        @return true, if name or version program was updated */
    public boolean updateInfo(String name, String version)
    {
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(60);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(62) && false))
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(61);name = "";}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(63);if ((version == null) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(65) && false))
            {$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(64);version = "";}
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(66);boolean changed = false;
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(67);if ((! ObjectUtil.equals(m_name, name)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(69) && false))
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(68);m_name = name;
            changed = true;
        }
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(70);if ((! ObjectUtil.equals(m_version, version)) ? true : (!$qualityscroll_cover_jacov_probe_cf951a2796fa8a24(72) && false))
        {
            $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(71);m_version = version;
            changed = true;
        }
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(73);return changed;
    }

    private void init(String label, String name, String version,
                      String command, String workingDirectory)
    {
        $qualityscroll_cover_jacov_probe_cf951a2796fa8a24(74);m_label = label.trim();
        m_name = name.trim();
        m_version = version.trim();
        m_command = command.trim();
        m_workingDirectory = workingDirectory.trim();
    }
}
