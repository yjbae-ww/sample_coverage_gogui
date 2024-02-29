/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Regress.java

package net.sf.gogui.tools.regress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.HtmlUtil;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;

/** Runs GTP regression tests. */
public class Regress
    implements GtpClient.IOCallback
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Regress.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1297040484877098935L,/* translation unit id   */ 1248356021941454333L,/* timestamp             */ 1709177903396L,/* source file name      */ "Regress.java",/* probe size            */ 376);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_11530d30190a45fd(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param gtpFile File with GTP commands to send at startup or
        <code>null</code> for no file. */
    public Regress(String program, ArrayList<String> tests, String output,
                   boolean longOutput, boolean verbose, File gtpFile)
        throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(0);tests = RegressUtil.expandTestSuites(tests);
        RegressUtil.checkFiles(tests);
        m_result = true;
        m_program = program;
        m_longOutput = longOutput;
        m_verbose = verbose;
        m_gtpFile = gtpFile;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(1);if ((output.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(3) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(2);m_prefix = "";}
        else
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(14);File file = new File(output);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(15);if ((! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(17) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(16);if ((! file.mkdir()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(19) && false))
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(18);throw new ErrorMessage("Could not create output directory '"
                                           + output + "'");}}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(20);m_prefix = output + File.separator;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(4);initOutNames(tests);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(5);for (int i = 0; (i < tests.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(7) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(6);String test = tests.get(i);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(9);if ((tests.size() > 1) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(11) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(10);m_outPrefix = test + " ";}
            else
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(13);m_outPrefix = "";}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(12);runTest(test);
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(8);writeSummary();
        writeData();
    }

    /** Return true if tests completed with no unexpected failures. */
    public boolean getResult()
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(21);return m_result;
    }

    public void receivedInvalidResponse(String s)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(22);printOutLine("invalid", "Invalid response: " + s);
    }

    public void receivedResponse(boolean error, String s)
    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(23);
    }

    public void receivedStdErr(String s)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(24);printOut("stderr", s, -1);
    }

    public void sentCommand(String s)
    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(25);
    }

    /** Exception thrown if Go program died. */
    private static class ProgramIsDeadException
        extends Exception
    {
        public String getMessage()
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(26);return "Program died";
        }
    }

    /** Information about one test and its result. */
    private static class Test
    {
        public int m_id;

        public int m_lastSgfMove;

        public boolean m_expectedFail;

        public boolean m_fail;

        public String m_command;

        public String m_required;

        public String m_response;

        public String m_lastSgf;

        public Test(int id, String command, boolean fail,
                    boolean expectedFail, String required, String response,
                    String lastSgf, int lastSgfMove)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(27);m_id = id;
            m_fail = fail;
            m_expectedFail = expectedFail;
            m_command = command;
            m_required = required;
            m_response = response;
            m_lastSgf = lastSgf;
            m_lastSgfMove = lastSgfMove;
        }
    }

    /** Information about test results of one test file. */
    private static class TestSummary
    {
        public File m_file;

        /** See Regress#m_outName */
        public String m_outName;

        public int m_numberTests;

        public int m_otherErrors;

        public int m_unexpectedFails;

        public int m_expectedFails;

        public int m_expectedPasses;

        public int m_unexpectedPasses;

        public long m_timeMillis;

        public double m_cpuTime;

        public int getNumberPasses()
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(28);return m_expectedPasses + m_unexpectedPasses;
        }
    }

    private boolean m_lastError;

    private final boolean m_longOutput;

    private boolean m_result;

    private final boolean m_verbose;

    private int m_lastCommandId;

    private int m_lastSgfMove;

    private int m_otherErrors;

    private File m_testFile;

    private PrintStream m_out;

    private static final String COLOR_ERROR = "#ffa954";

    private static final String COLOR_HEADER = "#91aee8";

    private static final String COLOR_INFO = "#e0e0e0";

    private static final String COLOR_BG_LIGHT = "#e0e0e0";

    private static final String COLOR_BG_GRAY = "#e0e0e0";

    private static final String COLOR_GREEN = "#5eaf5e";

    private static final String COLOR_RED = "#ff5454";

    /** Output file of the current test.
        The file contains an HTML formatted log of the GTP streams and
        the standard error of Go program. */
    private File m_outFile;

    private final File m_gtpFile;

    private String m_currentStyle;

    private String m_lastCommand;

    private String m_lastFullResponse;

    private String m_lastResponse;

    private String m_lastSgf;

    private String m_name;

    /** Name of m_outFile and the summary file of the test without directory
        and file extension for the current test. */
    private String m_outName;

    private String m_outFileRelativeName;

    private String m_outPrefix;

    private final String m_prefix;

    private final String m_program;

    /** Relative URI path between m_outFile and the directory of the current
        test. */
    private String m_relativePath;

    private String m_version;

    /** Name of m_outFile and the summary file of the test without directory
        and file extension for the all tests. */
    private TreeMap<String,String> m_outNames;

    private final ArrayList<Test> m_tests = new ArrayList<Test>();

    private final ArrayList<TestSummary> m_testSummaries
        = new ArrayList<TestSummary>();

    private GtpClient m_gtp;

    private void checkLastSgf(String line)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(29);String regex =
            "[0-9]*\\s*loadsgf\\s+(\\S+\\.[Ss][Gg][Ff])\\s+([0-9]+)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(30);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(32) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(31);m_lastSgf = matcher.group(1);
            try
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(33);m_lastSgfMove = Integer.parseInt(matcher.group(2));
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(34);return;
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(39);assert false;
            }
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(35);regex = "[0-9]*\\s*loadsgf\\s+(\\S+\\.[Ss][Gg][Ff])\\s*";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(line);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(36);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(38) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(37);m_lastSgf = matcher.group(1);
            m_lastSgfMove = -1;
        }

    }

    private void finishOutFile()
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(40);if ((m_currentStyle != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(42) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(41);m_out.print("</span>");}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(43);m_out.print("</pre>\n" +
                    HtmlUtil.getFooter("gogui-regress") +
                    "</body>\n" +
                    "</html>\n");
        m_out.close();
    }

    private int getId(String line)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(44);line = line.replaceAll("\\t", "\n");
        int index = line.indexOf(' ');
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(45);if ((index < 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(47) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(46);return -1;}
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(48);return Integer.parseInt(line.substring(0, index));
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(49);return -1;
        }
    }

    private TestSummary getTestSummary(long timeMillis, double cpuTime)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(50);TestSummary summary = new TestSummary();
        summary.m_file = m_testFile;
        summary.m_outName = m_outName;
        summary.m_timeMillis = timeMillis;
        summary.m_cpuTime = cpuTime;
        summary.m_otherErrors = m_otherErrors;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(51);for (int i = 0; (i < m_tests.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(53) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(52);Test t = m_tests.get(i);
            ++summary.m_numberTests;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(55);if ((t.m_fail && ! t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(57) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(56);++summary.m_unexpectedFails;}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(58);if ((t.m_fail && t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(60) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(59);++summary.m_expectedFails;}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(61);if ((! t.m_fail && ! t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(63) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(62);++summary.m_expectedPasses;}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(64);if ((! t.m_fail && t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(66) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(65);++summary.m_unexpectedPasses;}}}}
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(54);return summary;
    }

    private synchronized void handleLastResponse()
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(67);if ((m_lastCommandId >= 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(69) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(68);boolean fail = false;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(70);if ((m_lastError) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(72) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(71);printOutLine("fail", m_lastFullResponse);
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(73);if ((m_lastResponse.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(75) && false))
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(74);System.out.println(m_outPrefix
                                       + Integer.toString(m_lastCommandId)
                                       + " unexpected FAIL");}
                else
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(78);System.out.println(m_outPrefix
                                       + Integer.toString(m_lastCommandId)
                                       + " unexpected FAIL: '"
                                       + m_lastResponse + "'");}
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(76);fail = true;
            }
            else
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(79);printOutLine("test", m_lastFullResponse);}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(77);m_tests.add(new Test(m_lastCommandId, m_lastCommand, fail, false,
                                 "", m_lastResponse, m_lastSgf,
                                 m_lastSgfMove));
        }
        else
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(80);if ((m_lastError) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(82) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(81);printOutLine("error", m_lastFullResponse);
                ++m_otherErrors;
            }
            else
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(83);printOutLine(null, m_lastFullResponse);}
        }
    }

    private void handleLine(String line)
        throws ErrorMessage, ProgramIsDeadException
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(84);line = line.trim();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(85);if ((line.startsWith("#?")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(87) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(86);if ((m_lastFullResponse == null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(89) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(88);throw new ErrorMessage(m_testFile
                                       + ": Response pattern"
                                       + " without preceding test command: "
                                       + line);}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(90);printOutLine("test", line);
            handleTest(line.substring(2).trim());
            m_lastFullResponse = null;
            return;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(91);if ((m_lastFullResponse != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(93) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(92);handleLastResponse();
            m_lastFullResponse = null;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(94);if ((line.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(96) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(95);printOutLine(null, line);}
        else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(97);if ((line.startsWith("#")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(99) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(98);printOutLine("comment", line);}
        else
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(100);line = line.replaceAll("\\t", " ");
            m_lastCommandId = getId(line);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(101);if ((m_lastCommandId < 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(103) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(102);m_lastCommand = line;}
            else
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(113);int index = line.indexOf(' ');
                m_lastCommand = line.substring(index + 1);
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(104);printOutLine(((m_lastCommandId >= 0) ? ($qualityscroll_cover_jacov_probe_11530d30190a45fd(105) || true) : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(106) && false)) ? "test" : "command", line,
                         m_lastCommandId);
            checkLastSgf(line);
            m_lastError = false;
            assert m_lastFullResponse == null;
            try
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(107);m_lastResponse = m_gtp.send(line);
            }
            catch (GtpError error)
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(109);m_lastError = true;
                m_lastResponse = error.getMessage();
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(110);if ((m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(112) && false))
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(111);throw new ProgramIsDeadException();}
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(108);m_lastFullResponse = m_gtp.getFullResponse();
        }}
    }

    private void handleTest(String patternString) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(114);boolean expectedFail = false;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(115);if ((StringUtil.isEmpty(patternString)) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(117) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(116);handleLastResponse();
            return;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(118);if ((patternString.endsWith("*")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(120) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(119);expectedFail = true;
            patternString =
                patternString.substring(0, patternString.length() - 1);
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(121);if ((! patternString.startsWith("[")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(123) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(122);throw new ErrorMessage(m_testFile
                                   + ": Pattern has no opening bracket: "
                                   + patternString);}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(124);if ((! patternString.endsWith("]")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(126) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(125);throw new ErrorMessage(m_testFile
                                   + ": Pattern has no closing bracket: "
                                   + patternString);}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(127);patternString =
            patternString.substring(1, patternString.length() - 1).trim();
        String expectedResponse = patternString;
        boolean notPattern = false;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(128);if ((patternString.startsWith("!")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(130) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(129);notPattern = true;
            patternString = patternString.substring(1);
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(131);boolean fail = false;
        String response = "";
        int index = m_lastFullResponse.indexOf(' ');
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(132);if ((index >= 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(134) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(133);response = m_lastFullResponse.substring(index).trim();}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(135);if ((m_lastError) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(137) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(136);fail = true;}
        else
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(171);Pattern pattern
                = Pattern.compile(patternString,
                                  Pattern.MULTILINE | Pattern.DOTALL);
            Matcher matcher = pattern.matcher(response);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(172);if (((! matcher.matches() && ! notPattern)
                || (matcher.matches() && notPattern)) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(174) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(173);fail = true;}
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(138);if ((fail  && ! expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(140) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(139);m_result = false;}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(141);String style = null;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(142);if ((fail && ! expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(144) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(143);style = "fail";}
        else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(167);if ((! fail && expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(169) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(168);style = "pass";}
        else
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(170);style = "test";}}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(145);printOutLine(style, m_lastFullResponse);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(146);if ((m_longOutput) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(148) && false))
        {
            // Output compatible with eval.sh in GNU Go
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(147);if ((fail && ! expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(150) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(149);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " FAILED: Correct '"
                                   + expectedResponse + "', got '" + response
                                   + "'");}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(152);if ((fail && expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(154) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(153);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " failed: Correct '"
                                   + expectedResponse + "', got '" + response
                                   + "'");}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(155);if ((! fail && expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(157) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(156);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " PASSED");}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(158);if ((! fail && ! expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(160) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(159);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " passed");}}}}
        }
        else
        {
            // Output compatible with regress.sh in GNU Go
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(161);if ((fail && ! expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(163) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(162);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " unexpected FAIL: Correct '"
                                   + expectedResponse + "', got '" + response
                                   + "'");}
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(164);if ((! fail && expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(166) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(165);System.out.println(m_outPrefix
                                   + Integer.toString(m_lastCommandId)
                                   + " unexpected PASS!");}}
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(151);m_tests.add(new Test(m_lastCommandId, m_lastCommand, fail,
                             expectedFail, expectedResponse, response,
                             m_lastSgf, m_lastSgfMove));
    }

    /** Compute unique names for output directory.
        Appends a number, if tests with same name in different directories
        exist. */
    private void initOutNames(ArrayList<String> tests)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(175);m_outNames = new TreeMap<String,String>();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(176);for (int i = 0; (i < tests.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(178) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(177);String test = tests.get(i);
            File testFile = new File(test);
            String name =
                FileUtil.removeExtension(new File(testFile.getName()), "tst");
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(179);if ((m_outNames.containsValue(name)) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(181) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(180);for (int j = 2; ; ++j)
                {
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(183);String testName = name + "_" + j;
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(184);if ((! m_outNames.containsValue(testName)) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(186) && false))
                    {
                        $qualityscroll_cover_jacov_probe_11530d30190a45fd(185);name = testName;
                        break;
                    }
                }}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(182);m_outNames.put(test, name);
        }
    }

    private void initOutFile()
        throws Exception
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(187);m_outFileRelativeName = m_outName + ".out.html";
        m_outFile = new File(m_prefix + m_outFileRelativeName);
        File parent = m_outFile.getParentFile();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(188);if ((parent != null && ! parent.exists()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(190) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(189);if ((! parent.mkdir()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(192) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(191);throw new ErrorMessage("Could not create directory '"
                                       + parent + "'");}}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(193);m_currentStyle = null;
        m_out = new PrintStream(m_outFile);
        m_out.print("<html>\n" +
                    "<head>\n" +
                    "<title>Output: " + m_testFile + "</title>\n" +
                    HtmlUtil.getMeta("gogui-regress") +
                    "<style type=\"text/css\">\n" +
                    "<!--\n" +
                    "body { margin:0; }\n" +
                    "span.comment { color:#999999; }\n" +
                    "span.fail { font-weight:bold; color:" + COLOR_RED
                    + "; }\n" +
                    "span.error { font-weight:bold; color:" + COLOR_ERROR
                    + "; }\n" +
                    "span.stderr { color:#666666; }\n" +
                    "span.invalid { background:" + COLOR_RED + ";}\n" +
                    "span.pass { font-weight:bold; color:" + COLOR_GREEN
                    + "; }\n" +
                    "span.test { font-weight:bold; }\n" +
                    "-->\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body bgcolor=\"white\" text=\"black\"" +
                    " link=\"#0000ee\" vlink=\"#551a8b\">\n" +
                    "<table border=\"0\" width=\"100%\" bgcolor=\""
                    + COLOR_HEADER + "\" border=\"0\">\n" +
                    "<tr><td>\n" +
                    "<h1>Output: " + m_testFile + "</h1>\n" +
                    "</td></tr>\n" +
                    "</table>\n" +
                    "<table width=\"100%\" bgcolor=\"" + COLOR_INFO
                    + "\">\n");
        writeInfo(m_out, false);
        m_out.print("</table>\n" +
                    "<pre style=\"margin:1em\">\n");
    }

    private synchronized void printOut(String style, String line, int id)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(194);if ((line == null || line.length() == 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(196) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(195);return;}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(197);line = line.replaceAll("&", "&amp;");
        line = line.replaceAll(">", "&gt;");
        line = line.replaceAll("<", "&lt;");
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(198);if ((style != null
            && (style.equals("command") || style.equals("test"))) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(200) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(199);Pattern pattern = Pattern.compile("\\S*\\.[Ss][Gg][Ff]");
            Matcher matcher = pattern.matcher(line);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(201);if ((matcher.find()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(203) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(202);String sgf = matcher.group();
                StringBuilder stringBuffer = new StringBuilder();
                stringBuffer.append(line.substring(0, matcher.start()));
                stringBuffer.append("<a href=\"");
                stringBuffer.append(m_relativePath);
                stringBuffer.append(sgf);
                stringBuffer.append("\">");
                stringBuffer.append(sgf);
                stringBuffer.append("</a>");
                stringBuffer.append(line.substring(matcher.end()));
                line = stringBuffer.toString();
            }
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(204);if (((style == null && m_currentStyle != null)
            || (style != null && m_currentStyle == null)
            || (style != null && m_currentStyle != null
                && ! style.equals(m_currentStyle))) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(206) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(205);if ((m_currentStyle != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(208) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(207);m_out.print("</span>");}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(209);if ((style != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(211) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(210);m_out.print("<span class=\"" + style + "\">");}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(212);m_currentStyle = style;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(213);if ((id >= 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(215) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(214);m_out.print("<a name=\"" + id + "\">");}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(216);m_out.print(line);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(217);if ((id >= 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(219) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(218);m_out.print("</a>");}
    }

    private synchronized void printOutLine(String style, String line, int id)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(220);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(222) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(221);return;}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(223);if ((! line.endsWith("\n")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(225) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(224);line = line + "\n";}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(226);printOut(style, line, id);
    }

    private synchronized void printOutSeparator()
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(227);if ((m_currentStyle != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(229) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(228);m_out.print("</span>");}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(230);m_out.println("</pre>\n" +
                      "<hr style=\"margin:1em\" size=\"1\">\n" +
                      "<pre style=\"margin:1em\">");
    }

    private synchronized void printOutLine(String style, String line)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(231);printOutLine(style, line, -1);
    }

    private String send(String command) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(232);printOutLine(null, command);
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(233);return m_gtp.send(command);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(234);printOutLine(null, m_gtp.getFullResponse());
        }
    }

    private double getCpuTime()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(235);return Double.parseDouble(send("cputime"));
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(236);return 0;
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(237);return 0;
        }
    }

    private String getTimeString(double seconds)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(238);NumberFormat format1 = StringUtil.getNumberFormat(1);
        StringBuilder buffer = new StringBuilder(16);
        buffer.append(format1.format(seconds));
        buffer.append("&nbsp;(");
        buffer.append(StringUtil.formatTime((long)seconds));
        buffer.append(')');
        return buffer.toString();
    }

    private TestSummary getTotalSummary()
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(239);TestSummary total = new TestSummary();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(240);for (int i = 0; (i < m_testSummaries.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(242) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(241);TestSummary summary = m_testSummaries.get(i);
            total.m_numberTests += summary.m_numberTests;
            total.m_otherErrors += summary.m_otherErrors;
            total.m_unexpectedFails += summary.m_unexpectedFails;
            total.m_expectedFails += summary.m_expectedFails;
            total.m_expectedPasses += summary.m_expectedPasses;
            total.m_unexpectedPasses += summary.m_unexpectedPasses;
            total.m_timeMillis += summary.m_timeMillis;
            total.m_cpuTime += summary.m_cpuTime;
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(243);return total;
    }

    private void queryNameAndVersion() throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(244);m_name = send("name");
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(247);m_name = "";
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(248);if ((m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(250) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(249);throw e;}
        }
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(245);m_version = send("version");
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(246);m_version = "";
        }
    }

    private void runTest(String test) throws Exception
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(251);m_tests.clear();
        m_otherErrors = 0;
        m_testFile = new File(test);
        m_outName = m_outNames.get(test);
        initOutFile();
        File testFileDir = m_testFile.getAbsoluteFile().getParentFile();
        m_relativePath = FileUtil.getRelativeURI(m_outFile, testFileDir);
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(252);if ((! m_relativePath.equals("") && ! m_relativePath.endsWith("/")) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(254) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(253);m_relativePath = m_relativePath + "/";}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(255);FileReader fileReader = new FileReader(m_testFile);
        BufferedReader reader = new BufferedReader(fileReader);
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(256);m_gtp = new GtpClient(m_program, testFileDir, m_verbose, this);
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(257);if ((m_gtpFile != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(259) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(258);sendGtpFile();}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(260);m_lastSgf = null;
            queryNameAndVersion();
            double cpuTime = getCpuTime();
            long timeMillis = System.currentTimeMillis();
            printOutSeparator();
            String line;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(261);while (true)
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(262);line = reader.readLine();
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(277);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(279) && false))
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(278);break;}
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(280);handleLine(line);
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(264);timeMillis = System.currentTimeMillis() - timeMillis;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(265);if ((m_lastFullResponse != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(267) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(266);handleLastResponse();
                m_lastFullResponse = null;
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(268);printOutSeparator();
            cpuTime = getCpuTime() - cpuTime;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(269);if ((m_lastFullResponse != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(271) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(270);handleLastResponse();
                m_lastFullResponse = null;
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(272);if ((! m_gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(274) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(273);send("quit");
                m_gtp.close();
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(275);m_gtp.waitForExit();
            finishOutFile();
            TestSummary testSummary = getTestSummary(timeMillis, cpuTime);
            m_testSummaries.add(testSummary);
            writeTestSummary(testSummary);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(276);reader.close();
        }
    }

    private void sendGtpFile() throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(281);Reader reader;
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(282);reader = new FileReader(m_gtpFile);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(300);throw new ErrorMessage("GTP file not found: " + m_gtpFile);
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(283);java.io.BufferedReader in;
        in = new BufferedReader(reader);
        try
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(284);while (true)
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(285);try
                {
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(290);String line = in.readLine();
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(291);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(293) && false))
                        {$qualityscroll_cover_jacov_probe_11530d30190a45fd(292);break;}
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(294);if ((! GtpUtil.isCommand(line)) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(296) && false))
                        {$qualityscroll_cover_jacov_probe_11530d30190a45fd(295);continue;}
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(297);send(line);
                }
                catch (IOException e)
                {
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(298);throw new ErrorMessage("Error reading GTP file: "
                                           + e.getMessage());
                }
                catch (GtpError e)
                {
                    $qualityscroll_cover_jacov_probe_11530d30190a45fd(299);throw new ErrorMessage("GTP command '" + e.getCommand()
                                           + "' from file " + m_gtpFile
                                           + " failed: " + e.getMessage());
                }
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(287);printOutSeparator();
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(288);in.close();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(289);
            }
        }
    }

    private String truncate(String string)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(301);int maxLength = 25;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(302);if ((string.length() < maxLength) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(304) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(303);return string.trim();}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(305);return string.substring(0, maxLength).trim() + "...";
    }

    private void writeInfo(PrintStream out, boolean withName)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(306);String host = Platform.getHostInfo();
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(307);if ((withName) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(309) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(308);out.print("<tr><th align=\"left\">Name:</th><td>" + m_name
                      + "</td></tr>\n" +
                      "<tr><th align=\"left\">Version:</th><td>" + m_version
                      + "</td></tr>\n");}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(310);out.print("<tr><th align=\"left\">Date:</th><td>"
                  + StringUtil.getDate()
                  + "</td></tr>\n" +
                  "<tr><th align=\"left\">Host:</th><td>" + host
                  + "</td></tr>\n" +
                  "<tr><th align=\"left\" valign=\"top\">Command:</th>\n" +
                  "<td valign=\"top\"><tt>" + m_program
                  + "</tt></td></tr>\n");
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(311);if ((m_gtpFile != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(313) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(312);out.print("<tr><th align=\"left\">GtpFile:</th><td>" + m_gtpFile
                      + "</td></tr>\n");}
    }

    /** Write text based data file with summary information. */
    private void writeData() throws FileNotFoundException
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(314);File file = new File(m_prefix + "summary.dat");
        PrintStream out = new PrintStream(file);
        NumberFormat format1 = StringUtil.getNumberFormat(1);
        TestSummary s = getTotalSummary();
        double time = ((double)s.m_timeMillis) / 1000F;
        out.print("#Tests\tFAIL\tfail\tPASS\tpass\tError\tTime\tCpuTime\n" +
                  + s.m_numberTests + "\t"
                  + s.m_unexpectedFails + "\t"
                  + s.m_expectedFails + "\t"
                  + s.m_unexpectedPasses + "\t"
                  + s.m_expectedPasses + "\t"
                  + s.m_otherErrors + "\t"
                  + format1.format(time) + "\t"
                  + format1.format(s.m_cpuTime) + "\t"
                  + "\n");
        out.close();
    }

    private void writeSummary()
        throws FileNotFoundException
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(315);File file = new File(m_prefix + "index.html");
        PrintStream out = new PrintStream(file);
        out.print("<html>\n" +
                  "<head>\n" +
                  "<title>Regression Test Summary</title>\n" +
                  HtmlUtil.getMeta("gogui-regress") +
                  "<style type=\"text/css\">\n" +
                  "<!--\n" +
                  "body { margin:0; }\n" +
                  "-->\n" +
                  "</style>\n" +
                  "</head>\n" +
                  "<body bgcolor=\"white\" text=\"black\" link=\"blue\""
                  + " vlink=\"purple\" alink=\"red\">\n" +
                  "<table border=\"0\" width=\"100%\" bgcolor=\""
                  + COLOR_HEADER + "\">\n" +
                  "<tr><td>\n" +
                  "<h1>Regression Test Summary</h1>\n" +
                  "</td></tr>\n" +
                  "</table>\n" +
                  "<table width=\"100%\" bgcolor=\"" + COLOR_INFO
                  + "\">\n");
        writeInfo(out, true);
        out.print("</table>\n" +
                  "<table width=\"100%\" border=\"0\" cellpadding=\"0\""
                  + "cellspacing=\"1\">\n" +
                  "<colgroup>\n" +
                  "<col width=\"20%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "<col width=\"10%\">\n" +
                  "</colgroup>\n" +
                  "<thead align=\"center\">\n" +
                  "<tr bgcolor = \"" + COLOR_HEADER + "\">\n" +
                  "<th>File</th>\n" +
                  "<th>Tests</th>\n" +
                  "<th>FAIL</th>\n" +
                  "<th>fail</th>\n" +
                  "<th>PASS</th>\n" +
                  "<th>pass</th>\n" +
                  "<th>Error</th>\n" +
                  "<th>Time</th>\n" +
                  "<th>CpuTime</th>\n" +
                  "</tr>\n" +
                  "</thead>\n");
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(316);for (int i = 0; (i < m_testSummaries.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(318) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(317);TestSummary summary = m_testSummaries.get(i);
            writeSummaryRow(out, summary, true, false);
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(319);writeSummaryRow(out, getTotalSummary(), true, true);
        out.print("</table>\n" +
                  HtmlUtil.getFooter("gogui-regress") +
                  "</body>\n" +
                  "</html>\n");
        out.close();
    }

    private void writeSummaryRow(PrintStream out, TestSummary summary,
                                 boolean withFileName, boolean foot)
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(320);File file = summary.m_file;
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(321);if ((foot) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(323) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(322);out.print("<tfoot align=\"center\">\n");
            out.print("<tr align=\"center\" bgcolor=\""
                      + COLOR_HEADER + "\">\n");
        }
        else
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(346);out.print("<tr align=\"center\" bgcolor=\""
                      + COLOR_BG_GRAY + "\">\n");}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(324);if ((withFileName) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(326) && false))
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(325);if ((foot) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(328) && false))
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(327);out.print("<td><b>Total</b></td>");}
            else
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(345);out.print("<td><a href=\"" + summary.m_outName + ".html" +
                          "\">" + file + "</a></td>");}
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(329);double time = ((double)summary.m_timeMillis) / 1000F;
        String colorAttrUnexpectedFails = "";
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(330);if ((summary.m_unexpectedFails > 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(332) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(331);colorAttrUnexpectedFails = " bgcolor=\"" + COLOR_RED + "\"";}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(333);String colorAttrUnexpectedPasses = "";
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(334);if ((summary.m_unexpectedPasses > 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(336) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(335);colorAttrUnexpectedPasses = " bgcolor=\"" + COLOR_GREEN + "\"";}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(337);String colorAttrOtherErrors = "";
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(338);if ((summary.m_otherErrors > 0) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(340) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(339);colorAttrOtherErrors = " bgcolor=\"" + COLOR_ERROR + "\"";}
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(341);out.print("<td>" + summary.m_numberTests + "</td>\n" +
                  "<td" + colorAttrUnexpectedFails + ">"
                  + summary.m_unexpectedFails + "</td>\n" +
                  "<td>" + summary.m_expectedFails + "</td>\n" +
                  "<td" + colorAttrUnexpectedPasses + ">\n"
                  + summary.m_unexpectedPasses + "</td>\n" +
                  "<td>" + summary.m_expectedPasses + "</td>\n" +
                  "<td" + colorAttrOtherErrors + ">\n"
                  + summary.m_otherErrors + "</td>\n" +
                  "<td align=\"right\">" + getTimeString(time) + "</td>\n" +
                  "<td align=\"right\">" + getTimeString(summary.m_cpuTime) +
                  "</td>\n" +
                  "</tr>\n");
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(342);if ((foot) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(344) && false))
            {$qualityscroll_cover_jacov_probe_11530d30190a45fd(343);out.print("</tfoot>\n");}
    }

    private void writeTestSummary(TestSummary summary)
        throws FileNotFoundException
    {
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(347);if ((m_longOutput) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(349) && false))
        {
            // Output compatible with eval.sh in GNU Go
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(348);System.out.println("Summary: " + summary.getNumberPasses()
                               + "/" + summary.m_numberTests + " passes. "
                               + summary.m_unexpectedPasses
                               + " unexpected passes, "
                               + summary.m_unexpectedFails
                               + " unexpected failures");
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(350);File file = new File(m_prefix + m_outName + ".html");
        PrintStream out = new PrintStream(file);
        out.print("<html>\n" +
                  "<head>\n" +
                  "<title>Summary: " + m_testFile + "</title>\n" +
                  HtmlUtil.getMeta("gogui-regress") +
                  "<style type=\"text/css\">\n" +
                  "<!--\n" +
                  "body { margin:0; }\n" +
                  "-->\n" +
                  "</style>\n" +
                  "</head>\n" +
                  "<body bgcolor=\"white\" text=\"black\" link=\"blue\""
                  + " vlink=\"purple\" alink=\"red\">\n" +
                  "<table border=\"0\" width=\"100%\" bgcolor=\""
                  + COLOR_HEADER + "\">\n" +
                  "<tr><td>\n" +
                  "<h1>Summary: " + m_testFile + "</h1>\n" +
                  "</td></tr>\n" +
                  "</table>\n" +
                  "<table width=\"100%\" bgcolor=\"" + COLOR_INFO
                  + "\">\n");
        writeInfo(out, true);
        out.print("<tr><th align=\"left\">Output:</th><td><a href=\""
                  + m_outFileRelativeName + "\">"
                  + m_outFileRelativeName + "</a></td></tr>\n" +
                  "</table>\n" +
                  "<table width=\"100%\" border=\"0\" cellpadding=\"0\""
                  + " cellspacing=\"1\">\n" +
                  "<colgroup>\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "<col width=\"12%\">\n" +
                  "</colgroup>\n" +
                  "<thead align=\"center\">\n" +
                  "<tr bgcolor=\"" + COLOR_HEADER + "\">\n" +
                  "<th>Tests</th>\n" +
                  "<th>FAIL</th>\n" +
                  "<th>fail</th>\n" +
                  "<th>PASS</th>\n" +
                  "<th>pass</th>\n" +
                  "<th>Error</th>\n" +
                  "<th>Time</th>\n" +
                  "<th>CpuTime</th>\n" +
                  "</tr>\n" +
                  "</thead>\n");
        writeSummaryRow(out, summary, false, false);
        out.print("</table>\n" +
                  "<table width=\"100%\" border=\"0\" cellpadding=\"0\""
                  + " cellspacing=\"1\">\n" +
                  "<thead>\n" +
                  "<tr bgcolor=\"" + COLOR_HEADER + "\">\n" +
                  "<th>ID</th>\n" +
                  "<th>Status</th>\n" +
                  "<th>Command</th>\n" +
                  "<th>Output</th>\n" +
                  "<th>Required</th>\n" +
                  "<th>Last SGF</th>\n" +
                  "</tr>\n" +
                  "</thead>\n");
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(351);for (int i = 0; (i < m_tests.size()) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(353) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(352);Test t = m_tests.get(i);
            String rowBackground = COLOR_BG_LIGHT;
            String statusColor = rowBackground;
            String status = null;
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(355);if ((t.m_fail && t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(357) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(356);status = "fail";
            }
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(366);if ((t.m_fail && ! t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(368) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(367);statusColor = COLOR_RED;
                status = "FAIL";
            }
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(369);if ((! t.m_fail && t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(371) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(370);statusColor = COLOR_GREEN;
                status = "PASS";
            }
            else {$qualityscroll_cover_jacov_probe_11530d30190a45fd(372);if ((! t.m_fail && ! t.m_expectedFail) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(374) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(373);status = "pass";
            }
            else
                {$qualityscroll_cover_jacov_probe_11530d30190a45fd(375);assert false;}}}}
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(358);String lastSgf = "";
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(359);if ((t.m_lastSgf != null) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(361) && false))
            {
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(360);lastSgf = "<a href=\"" + m_relativePath + t.m_lastSgf + "\">"
                    + t.m_lastSgf + "</a>";
                $qualityscroll_cover_jacov_probe_11530d30190a45fd(362);if ((t.m_lastSgfMove != -1) ? true : (!$qualityscroll_cover_jacov_probe_11530d30190a45fd(364) && false))
                    {$qualityscroll_cover_jacov_probe_11530d30190a45fd(363);lastSgf += "&nbsp;" + t.m_lastSgfMove;}
            }
            $qualityscroll_cover_jacov_probe_11530d30190a45fd(365);String command = t.m_command.replaceAll(" ", "&nbsp;");
            out.print("<tr bgcolor=\"" + rowBackground + "\">\n" +
                      "<td align=\"right\"><a href=\"" + m_outFileRelativeName
                      + "#" + t.m_id + "\">" + t.m_id + "</a></td>\n" +
                      "<td align=\"center\" bgcolor=\"" + statusColor
                      + "\">" + status + "</td>\n" +
                      "<td>" + command + "</td>\n" +
                      "<td align=\"center\">" + truncate(t.m_response)
                      + "</td>\n" +
                      "<td align=\"center\">" + truncate(t.m_required)
                      + "</td>\n" +
                      "<td>" + lastSgf + "</td>\n" +
                      "</tr>\n");
        }
        $qualityscroll_cover_jacov_probe_11530d30190a45fd(354);out.print("</table>\n" +
                  HtmlUtil.getFooter("gogui-regress") +
                  "</body>\n" +
                  "</html>\n");
        out.close();
    }
}
