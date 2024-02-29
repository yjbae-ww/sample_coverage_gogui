/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// AnalyzeDefinition.java

package net.sf.gogui.gtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.StringUtil;

/** Definition of an analyze command.
    See GoGui documentation, chapter "Analyze Commands".
    This class is immutable. */
public class AnalyzeDefinition
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = AnalyzeDefinition.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 2254088018843213432L,/* translation unit id   */ 6303401658435389870L,/* timestamp             */ 1709177901277L,/* source file name      */ "AnalyzeDefinition.java",/* probe size            */ 117);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_577a2e6957a649ae(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public AnalyzeDefinition(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(0);String array[] = line.split("/");
        String typeStr = array[0];
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(1);if ((typeStr.equals("bwboard")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(3) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(2);m_type = AnalyzeType.BWBOARD;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(5);if ((typeStr.equals("cboard")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(7) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(6);m_type = AnalyzeType.CBOARD;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(8);if ((typeStr.equals("dboard")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(10) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(9);m_type = AnalyzeType.DBOARD;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(11);if ((typeStr.equals("eplist")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(13) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(12);m_type = AnalyzeType.EPLIST;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(14);if ((typeStr.equals("gfx")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(16) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(15);m_type = AnalyzeType.GFX;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(17);if ((typeStr.equals("hstring")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(19) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(18);m_type = AnalyzeType.HSTRING;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(20);if ((typeStr.equals("hpstring")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(22) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(21);m_type = AnalyzeType.HPSTRING;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(23);if ((typeStr.equals("param")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(25) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(24);m_type = AnalyzeType.PARAM;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(26);if ((typeStr.equals("plist")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(28) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(27);m_type = AnalyzeType.PLIST;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(29);if ((typeStr.equals("pspairs")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(31) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(30);m_type = AnalyzeType.PSPAIRS;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(32);if ((typeStr.equals("pstring")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(34) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(33);m_type = AnalyzeType.PSTRING;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(35);if ((typeStr.equals("string")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(37) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(36);m_type = AnalyzeType.STRING;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(38);if ((typeStr.equals("sboard")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(40) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(39);m_type = AnalyzeType.SBOARD;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(41);if ((typeStr.equals("var")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(43) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(42);m_type = AnalyzeType.VAR;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(44);if ((typeStr.equals("varb")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(46) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(45);m_type = AnalyzeType.VARB;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(47);if ((typeStr.equals("varc")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(49) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(48);m_type = AnalyzeType.VARC;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(50);if ((typeStr.equals("varp")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(52) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(51);m_type = AnalyzeType.VARP;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(53);if ((typeStr.equals("varpo")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(55) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(54);m_type = AnalyzeType.VARPO;}
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(56);if ((typeStr.equals("varw")) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(58) && false))
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(57);m_type = AnalyzeType.VARW;}
        else
            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(59);m_type = AnalyzeType.NONE;}}}}}}}}}}}}}}}}}}}
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(4);m_label = array[1];
        m_command = array[2];
    }

    public AnalyzeDefinition(AnalyzeType type, String label, String command)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(60);m_type = type;
        m_label = label;
        m_command = command;
    }

    public String getCommand()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(61);return m_command;
    }

    public String getLabel()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(62);return m_label;
    }

    public AnalyzeType getType()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(63);return m_type;
    }

    /** Should the response be shown as text.
        Returns true for types that should be shown (not necessarily only)
        as text to the user.
        That is string and variation commands. */
    public boolean isTextType()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(64);return m_type == AnalyzeType.STRING
            || m_type == AnalyzeType.HSTRING
            || m_type == AnalyzeType.HPSTRING
            || m_type == AnalyzeType.PSTRING
            || m_type == AnalyzeType.VAR
            || m_type == AnalyzeType.VARC
            || m_type == AnalyzeType.VARW
            || m_type == AnalyzeType.VARB
            || m_type == AnalyzeType.VARP
            || m_type == AnalyzeType.VARPO;
    }

    public boolean needsColorArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(65);return (m_command.indexOf("%c") >= 0);
    }

    public boolean needsFileArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(66);return (m_command.indexOf("%f") >= 0);
    }

    public boolean needsFileOpenArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(67);return (m_command.indexOf("%r") >= 0);
    }

    public boolean needsFileSaveArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(68);return (m_command.indexOf("%w") >= 0);
    }

    public boolean needsOnlyPointArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(69);return (needsPointArg()
                && ! needsColorArg()
                && ! needsFileArg()
                && ! needsFileOpenArg()
                && ! needsFileSaveArg()
                && ! needsPointListArg()
                && ! needsStringArg()
                && ! needsOptStringArg());
    }

    public boolean needsOnlyPointAndColorArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(70);return (needsPointArg() && needsColorArg()
                && ! needsFileArg()
                && ! needsFileOpenArg()
                && ! needsFileSaveArg()
                && ! needsPointListArg()
                && ! needsStringArg()
                && ! needsOptStringArg());
    }

    public boolean needsPointArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(71);return (m_command.indexOf("%p") >= 0);
    }

    public boolean needsPointListArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(72);return (m_command.indexOf("%P") >= 0 || m_type == AnalyzeType.EPLIST);
    }

    public boolean needsStringArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(73);return (m_command.indexOf("%s") >= 0);
    }

    public boolean needsOptStringArg()
    {
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(74);return (m_command.indexOf("%o") >= 0);
    }

    public static ArrayList<AnalyzeDefinition>
        read(ArrayList<String> supportedCommands, File analyzeCommands,
             String programAnalyzeCommands)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(75);if ((analyzeCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(77) && false))
        {
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(76);try
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(78);Reader fileReader = new FileReader(analyzeCommands);
                BufferedReader reader = new BufferedReader(fileReader);
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(79);return readConfig(reader, analyzeCommands.getName(), null);
            }
            catch (FileNotFoundException e)
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(80);throw new ErrorMessage("File \"" + analyzeCommands
                                       + "\" not found");
            }
        }
        else {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(81);if ((programAnalyzeCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(83) && false))
        {
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(82);Reader stringReader = new StringReader(programAnalyzeCommands);
            BufferedReader reader = new BufferedReader(stringReader);
            return readConfig(reader,
                              "program response to gogui-analyze_commands",
                              null);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(84);String resource = "net/sf/gogui/gui/analyze-commands";
            URL url = ClassLoader.getSystemClassLoader().getResource(resource);
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(85);if ((url == null) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(87) && false))
                {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(86);return new ArrayList<AnalyzeDefinition>();}
            try
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(88);InputStream inputStream = url.openStream();
                Reader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(89);return readConfig(reader, "builtin default commands",
                                  supportedCommands);
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(90);throw new ErrorMessage(e.getMessage());
            }
        }}
    }

    private final AnalyzeType m_type;

    private final String m_label;

    private final String m_command;

    private static ArrayList<AnalyzeDefinition>
        readConfig(BufferedReader reader, String name,
                   ArrayList<String> supportedCommands) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(91);ArrayList<AnalyzeDefinition> result
            = new ArrayList<AnalyzeDefinition>();
        ArrayList<String> labels = new ArrayList<String>();
        try
        {
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(92);String line;
            int lineNumber = 0;
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(93);while (((line = reader.readLine()) != null) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(95) && false))
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(94);++lineNumber;
                line = line.trim();
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(97);if ((line.length() > 0 && line.charAt(0) != '#') ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(99) && false))
                {
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(98);String array[] = line.split("/");
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(100);if ((array.length < 3 || array.length > 5) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(102) && false))
                        {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(101);throw new ErrorMessage("Error in " + name + " line "
                                               + lineNumber);}
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(103);if ((supportedCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(105) && false))
                    {
                        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(104);String[] cmdArray
                            = StringUtil.splitArguments(array[2].trim());
                        $qualityscroll_cover_jacov_probe_577a2e6957a649ae(106);if ((cmdArray.length == 0
                            || ! supportedCommands.contains(cmdArray[0])) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(108) && false))
                            {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(107);continue;}
                    }
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(109);String label = array[1];
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(110);if ((labels.contains(label)) ? true : (!$qualityscroll_cover_jacov_probe_577a2e6957a649ae(112) && false))
                        {$qualityscroll_cover_jacov_probe_577a2e6957a649ae(111);continue;}
                    $qualityscroll_cover_jacov_probe_577a2e6957a649ae(113);labels.add(label);
                    result.add(new AnalyzeDefinition(line));
                }
            }
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(96);return result;
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_577a2e6957a649ae(116);throw new ErrorMessage("Error reading " + name);
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(114);reader.close();
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_577a2e6957a649ae(115);throw new ErrorMessage("Error reading " + name);
            }
        }
    }
}
