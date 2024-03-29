/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Analyze.java

package net.sf.gogui.tools.twogtp;

import java.io.File;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.Histogram;
import net.sf.gogui.util.HtmlUtil;
import net.sf.gogui.util.Statistics;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.util.Table;

/** Analyze the game results and produce a HTML formatted report. */
public class Analyze
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Analyze.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8382470134129374928L,/* translation unit id   */ -8501373707003760862L,/* timestamp             */ 1709177903779L,/* source file name      */ "Analyze.java",/* probe size            */ 147);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8a050da7db31ef22(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Analyze(String filename, boolean force) throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(0);File file = new File(filename);
        readTable(file);
        File htmlFile =
            new File(FileUtil.replaceExtension(file, "dat", "html"));
        File dataFile =
            new File(FileUtil.replaceExtension(file, "dat", "summary.dat"));
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(1);if ((! force) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(3) && false))
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(2);if ((htmlFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(5) && false))
                {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(4);throw new ErrorMessage("File " + htmlFile + " exists");}
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(6);if ((dataFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(8) && false))
                {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(7);throw new ErrorMessage("File " + dataFile + " exists");}
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(9);calcStatistics();
        writeHtml(htmlFile);
        writeData(dataFile);
    }

    private static final class ResultStatistics
    {
        public Statistics m_unknownResult = new Statistics();

        public Statistics m_unknownScore = new Statistics();

        public Statistics m_win = new Statistics();

        public Histogram m_histo = new Histogram(-1000, 1000, 10);
    }

    private int m_duplicates;

    private int m_errors;

    private int m_games;

    private int m_gamesUsed;

    private static final String COLOR_HEADER = "#91aee8";

    private static final String COLOR_INFO = "#e0e0e0";

    private final ArrayList<Entry> m_entries = new ArrayList<Entry>(128);

    private final Statistics m_length = new Statistics();

    private final ResultStatistics m_statisticsBlack = new ResultStatistics();

    private final ResultStatistics m_statisticsReferee
        = new ResultStatistics();

    private final ResultStatistics m_statisticsWhite = new ResultStatistics();

    private final Statistics m_cpuBlack = new Statistics();

    private final Statistics m_cpuWhite = new Statistics();

    private final Statistics m_timeBlack = new Statistics();

    private final Statistics m_timeWhite = new Statistics();

    private Table m_table;

    private void calcStatistics()
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(10);for (Entry e : m_entries)
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(11);++m_games;
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(12);if ((e.m_error) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(14) && false))
            {
                $qualityscroll_cover_jacov_probe_8a050da7db31ef22(13);++m_errors;
                continue;
            }
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(15);if ((! e.m_duplicate.equals("") && ! e.m_duplicate.equals("-")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(17) && false))
            {
                $qualityscroll_cover_jacov_probe_8a050da7db31ef22(16);++m_duplicates;
                continue;
            }
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(18);++m_gamesUsed;
            parseResult(e.m_resultBlack, m_statisticsBlack);
            parseResult(e.m_resultWhite, m_statisticsWhite);
            parseResult(e.m_resultReferee, m_statisticsReferee);
            m_timeBlack.add(e.m_timeBlack);
            m_timeWhite.add(e.m_timeWhite);
            m_cpuBlack.add(e.m_cpuBlack);
            m_cpuWhite.add(e.m_cpuWhite);
            m_length.add(e.m_length);
        }
    }

    private void parseResult(String result, ResultStatistics statistics)
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(19);boolean hasResult = false;
        boolean hasScore = false;
        boolean win = false;
        double score = 0f;
        String s = result.trim();
        try
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(20);if ((! s.equals("?")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(22) && false))
            {
                $qualityscroll_cover_jacov_probe_8a050da7db31ef22(21);if ((s.startsWith("B+")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(24) && false))
                {
                    $qualityscroll_cover_jacov_probe_8a050da7db31ef22(23);hasResult = true;
                    win = true;
                    String scoreString = s.substring(2);
                    $qualityscroll_cover_jacov_probe_8a050da7db31ef22(25);if ((! scoreString.equals("") && ! scoreString.equals("R")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(27) && false))
                    {
                        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(26);score = Double.parseDouble(scoreString);
                        hasScore = true;
                    }
                }
                else {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(45);if ((s.startsWith("W+")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(47) && false))
                {
                    $qualityscroll_cover_jacov_probe_8a050da7db31ef22(46);hasResult = true;
                    win = false;
                    String scoreString = s.substring(2);
                    $qualityscroll_cover_jacov_probe_8a050da7db31ef22(48);if ((! scoreString.equals("") && ! scoreString.equals("R")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(50) && false))
                    {
                        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(49);score = -Double.parseDouble(scoreString);
                        hasScore = true;
                    }
                }
                else {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(51);if ((! s.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(53) && false))
                    {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(52);System.err.println("Ignored invalid result: " + result);}}}
            }
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(54);System.err.println("Ignored invalid score: " + result);
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(28);if ((hasScore &&
            (score < statistics.m_histo.getHistoMin()
             || score > statistics.m_histo.getHistoMax())) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(30) && false))
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(29);System.err.println("Ignored invalid score: " + result);
            hasScore = false;
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(31);statistics.m_unknownResult.add(((hasResult) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(32) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(33) && false)) ? 0 : 1);
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(34);if ((hasResult) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(36) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(35);statistics.m_win.add(((win) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(37) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(38) && false)) ? 1 : 0);}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(39);statistics.m_unknownScore.add(((hasScore) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(40) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(41) && false)) ? 0 : 1);
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(42);if ((hasScore) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(44) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(43);statistics.m_histo.add(score);}
    }

    private void readTable(File file) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(55);m_table = new Table();
        m_table.read(file);
        try
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(56);for (int i = 0; (i < m_table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(58) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_8a050da7db31ef22(57);int gameIndex = m_table.getInt("GAME", i);
                String resultBlack = m_table.get("RES_B", i);
                String resultWhite = m_table.get("RES_W", i);
                String resultReferee = m_table.get("RES_R", i);
                boolean alternated = (m_table.getInt("ALT", i) != 0);
                String duplicate = m_table.get("DUP", i);
                int length = m_table.getInt("LEN", i);
                double timeBlack = 0;
                double timeWhite = 0;
                try
                {
                    $qualityscroll_cover_jacov_probe_8a050da7db31ef22(59);timeBlack = m_table.getDouble("TIME_B", i);
                    timeWhite = m_table.getDouble("TIME_W", i);
                }
                catch (Table.InvalidLocation e)
                {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(61);
                    // twogtp versions before 1.1pre2 did not save TIME_B,
                    // TIME_W, we still support analyzing such old tables for
                    // a while
                }
                $qualityscroll_cover_jacov_probe_8a050da7db31ef22(60);double cpuBlack = m_table.getDouble("CPU_B", i);
                double cpuWhite = m_table.getDouble("CPU_W", i);
                boolean error = (m_table.getInt("ERR", i) != 0);
                String errorMessage = m_table.get("ERR_MSG", i);
                m_entries.add(new Entry(gameIndex, resultBlack, resultWhite,
                                        resultReferee, alternated, duplicate,
                                        length, timeBlack, timeWhite,
                                        cpuBlack, cpuWhite, error,
                                        errorMessage));
            }
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(62);throw new ErrorMessage("Wrong file format");
        }
    }

    private void writeHtml(File file) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(63);String gamePrefix = "game";
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(64);if ((file.getName().endsWith(".html")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(66) && false))
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(65);String name = file.getName();
            gamePrefix = name.substring(0, name.length() - 5);
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(67);PrintStream out = new PrintStream(file);
        NumberFormat format = StringUtil.getNumberFormat(1);
        String black;
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(68);if ((m_table.hasProperty("BlackLabel")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(70) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(69);black = m_table.getProperty("BlackLabel");}
        else {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(113);if ((m_table.hasProperty("Black")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(115) && false))
            // Older versions of TwoGtp do not have BlackLabel property
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(114);black = m_table.getProperty("Black");}
        else
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(116);black = "Black";}}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(71);String white;
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(72);if ((m_table.hasProperty("WhiteLabel")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(74) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(73);white = m_table.getProperty("WhiteLabel");}
        else {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(109);if ((m_table.hasProperty("White")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(111) && false))
            // Older versions of TwoGtp do not have WhiteLabel property
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(110);white = m_table.getProperty("White");}
        else
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(112);white = "Black";}}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(75);boolean useXml = (! m_table.getProperty("Xml", "0").equals("0"));
        out.print("<html>\n" +
                  "<head>\n" +
                  "<title>" + black + " - " + white + "</title>\n" +
                  HtmlUtil.getMeta("TwoGtp") +
                  "<style type=\"text/css\">\n" +
                  "<!--\n" +
                  "body { margin:0; }\n" +
                  "-->\n" +
                  "</style>\n" +
                  "</head>\n" +
                  "<body bgcolor=\"white\" text=\"black\" link=\"#0000ee\"" +
                  " vlink=\"#551a8b\">\n" +
                  "<table border=\"0\" width=\"100%\" bgcolor=\""
                  + COLOR_HEADER + "\">\n" +
                  "<tr><td>\n" +
                  "<h1>" + black + " - " + white
                  + "</h1>\n" +
                  "</td></tr>\n" +
                  "</table>\n" +
                  "<table width=\"100%\" bgcolor=\"" + COLOR_INFO
                  + "\">\n");
        String referee = m_table.getProperty("Referee", "");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(76);if ((referee.equals("-") || referee.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(78) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(77);referee = null;}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(79);writePropertyHtmlRow(out, "Black", "Black");
        writePropertyHtmlRow(out, "White", "White");
        writePropertyHtmlRow(out, "Size", "Size");
        writePropertyHtmlRow(out, "Komi", "Komi");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(80);if ((m_table.hasProperty("Openings")) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(82) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(81);writePropertyHtmlRow(out, "Openings", "Openings");}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(83);writePropertyHtmlRow(out, "Date", "Date");
        writePropertyHtmlRow(out, "Host", "Host");
        writePropertyHtmlRow(out, "Referee", "Referee");
        writePropertyHtmlRow(out, "BlackVersion", "Black version");
        writePropertyHtmlRow(out, "BlackCommand", "Black command");
        writePropertyHtmlRow(out, "WhiteVersion", "White version");
        writePropertyHtmlRow(out, "WhiteCommand", "White command");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(84);if ((referee != null) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(86) && false))
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(85);writePropertyHtmlRow(out, "RefereeVersion", "Referee version");
            writePropertyHtmlRow(out, "RefereeCommand", "Referee command");
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(87);writeHtmlRow(out, "Games", m_games);
        writeHtmlRow(out, "Errors", m_errors);
        writeHtmlRow(out, "Duplicates", m_duplicates);
        writeHtmlRow(out, "Games used", m_gamesUsed);
        writeHtmlRow(out, "Game length", m_length, format);
        writeHtmlRow(out, "Time Black", m_timeBlack, format);
        writeHtmlRow(out, "Time White", m_timeWhite, format);
        writeHtmlRow(out, "CPU Time Black", m_cpuBlack, format);
        writeHtmlRow(out, "CPU Time White", m_cpuWhite, format);
        out.print("</table>\n" +
                  "<hr>\n");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(88);if ((referee != null) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(90) && false))
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(89);writeHtmlResults(out, referee, m_statisticsReferee);
            out.println("<hr>");
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(91);writeHtmlResults(out, black, m_statisticsBlack);
        out.println("<hr>");
        writeHtmlResults(out, white, m_statisticsWhite);
        out.println("<hr>");
        out.print("<table border=\"0\" width=\"100%\" cellpadding=\"0\""
                  + " cellspacing=\"1\">\n" +
                  "<thead>\n" +
                  "<tr bgcolor=\"" + COLOR_HEADER + "\">\n" +
                  "<th>Game</th>\n");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(92);if ((referee != null) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(94) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(93);out.print("<th>Result " + referee + "</th>\n");}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(95);out.print("<th>Result " + black + "</th>\n" +
                  "<th>Result " + white + "</th>\n");
        out.print("<th>Colors Exchanged</th>\n" +
                  "<th>Duplicate</th>\n" +
                  "<th>Length</th>\n" +
                  "<th>Time " + black + "</th>\n" +
                  "<th>Time " + white + "</th>\n" +
                  "<th>CPU Time " + black + "</th>\n" +
                  "<th>CPU Time " + white + "</th>\n" +
                  "<th>Error</th>\n" +
                  "<th>Error Message</th>\n" +
                  "</tr>\n" +
                  "</thead>\n");
        String gameSuffix = (((useXml) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(96) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(97) && false)) ? ".xml" : ".sgf");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(98);for (Entry e : m_entries)
        {
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(100);String name = gamePrefix + "-" + e.m_gameIndex + gameSuffix;
            out.print("<tr align=\"center\" bgcolor=\"" + COLOR_INFO
                      + "\"><td><a href=\"" + name + "\">" + name
                      + "</a></td>\n");
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(101);if ((referee != null) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(103) && false))
                {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(102);out.print("<td>" + e.m_resultReferee + "</td>");}
            $qualityscroll_cover_jacov_probe_8a050da7db31ef22(104);out.print("<td>" + e.m_resultBlack + "</td>" +
                      "<td>" + e.m_resultWhite + "</td>");
            out.print("<td>" + (((e.m_alternated) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(105) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(106) && false)) ? "1" : "0") + "</td>" +
                      "<td>" + e.m_duplicate + "</td>" +
                      "<td>" + e.m_length + "</td>" +
                      "<td>" + e.m_timeBlack + "</td>" +
                      "<td>" + e.m_timeWhite + "</td>" +
                      "<td>" + e.m_cpuBlack + "</td>" +
                      "<td>" + e.m_cpuWhite + "</td>" +
                      "<td>" + (((e.m_error) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(107) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(108) && false)) ? "1" : "") + "</td>" +
                      "<td>" + e.m_errorMessage + "</td>" +
                      "</tr>\n");
        }
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(99);out.print("</table>\n" +
                  HtmlUtil.getFooter("TwoGtp") +
                  "</body>\n" +
                  "</html>\n");
        out.close();
    }

    private void writeHtmlResults(PrintStream out, String name,
                                  ResultStatistics statistics)
        throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(117);NumberFormat format = StringUtil.getNumberFormat(1);
        out.print("<div style=\"margin:1em\">\n" +
                  "<h2>Result " + name + "</h2>\n" +
                  "<p>\n" +
                  "<table border=\"0\">\n");
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(118);if ((statistics.m_histo.getCount() > 0) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(120) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(119);writeHtmlRow(out, "Black score", statistics.m_histo, format);}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(121);if ((statistics.m_win.getCount() > 0) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(123) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(122);writeHtmlRowPercentData(out, "Black wins", statistics.m_win,
                                    format);}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(124);out.print("<tr><th align=\"left\">Unknown result"
                  + ":</th><td align=\"left\">"
                  + format.format(statistics.m_unknownResult.getMean() * 100)
                  + "%" + "</td></tr>\n" +
                  "<tr><th align=\"left\">Unknown score"
                  + ":</th><td align=\"left\">"
                  + format.format(statistics.m_unknownScore.getMean() * 100)
                  + "%" + "</td></tr>\n" +
                  "</table>\n" +
                  "</p>\n");
        statistics.m_histo.printHtml(out);
        out.print("</div>\n");
    }

    private void writePropertyHtmlRow(PrintStream out, String key,
                                      String keyLabel)
        throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(125);String value = m_table.getProperty(key, "");
        writeHtmlRow(out, keyLabel, value);
    }

    private void writeHtmlRow(PrintStream out, String label,
                              String value) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(126);out.print("<tr><th align=\"left\" valign=\"top\" nowrap>" + label
                  + ":</th><td align=\"left\">" + value + "</td></tr>\n");
    }

    private void writeHtmlRow(PrintStream out, String label,
                              int value) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(127);writeHtmlRow(out, label, Integer.toString(value));
    }

    private void writeHtmlRow(PrintStream out, String label,
                              Statistics statistics,
                              NumberFormat format) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(128);String value;
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(129);if ((statistics.getCount() == 0) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(131) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(130);value = "";}
        else
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(133);value =
                format.format(statistics.getMean()) + " (&plusmn;"
                + format.format(statistics.getError())
                + ") <small>min=" + format.format(statistics.getMin())
                + " max=" + format.format(statistics.getMax())
                + " deviation=" + format.format(statistics.getDeviation())
                + "</small>";}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(132);writeHtmlRow(out, label, value);
    }

    private void writeHtmlRowPercentData(PrintStream out, String label,
                                         Statistics statistics,
                                         NumberFormat format) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(134);String value;
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(135);if ((statistics.getCount() == 0) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(137) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(136);value = "";}
        else
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(139);value =
                format.format(statistics.getMean() * 100) + "% (&plusmn;"
                + format.format(statistics.getError() * 100) + ")";}
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(138);writeHtmlRow(out, label, value);
    }

    private void writeData(File file) throws Exception
    {
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(140);PrintStream out = new PrintStream(file);
        NumberFormat format1 = StringUtil.getNumberFormat(1);
        NumberFormat format2 = StringUtil.getNumberFormat(3);
        Histogram histoBlack = m_statisticsBlack.m_histo;
        Histogram histoWhite = m_statisticsWhite.m_histo;
        Histogram histoReferee = m_statisticsReferee.m_histo;
        Statistics winBlack = m_statisticsBlack.m_win;
        Statistics winWhite = m_statisticsWhite.m_win;
        Statistics winReferee = m_statisticsReferee.m_win;
        Statistics unknownBlack = m_statisticsBlack.m_unknownScore;
        Statistics unknownWhite = m_statisticsWhite.m_unknownScore;
        Statistics unknownReferee = m_statisticsReferee.m_unknownScore;
        out.print("#GAMES\tERR\tDUP\tUSED\tRES_B\tERR_B\tWIN_B\tERRW_B\t"
                  + "UNKN_B\tRES_W\tERR_W\tWIN_W\tERRW_W\tUNKN_W\t"
                  + "RES_R\tERR_R\tWIN_R\tERRW_R\tUNKN_R\n" +
                  m_games + "\t" + m_errors + "\t" + m_duplicates + "\t"
                  + m_gamesUsed
                  + "\t" + format1.format(histoBlack.getMean())
                  + "\t" + format1.format(histoBlack.getError())
                  + "\t" + format2.format(winBlack.getMean())
                  + "\t" + format2.format(winBlack.getError())
                  + "\t" + format2.format(unknownBlack.getMean())
                  + "\t" + format1.format(histoWhite.getMean())
                  + "\t" + format1.format(histoWhite.getError())
                  + "\t" + format2.format(winWhite.getMean())
                  + "\t" + format2.format(winWhite.getError())
                  + "\t" + format2.format(unknownWhite.getMean())
                  + "\t" + format1.format(histoReferee.getMean())
                  + "\t" + format1.format(histoReferee.getError())
                  + "\t" + format2.format(winReferee.getMean())
                  + "\t" + format2.format(winReferee.getError())
                  + "\t" + format2.format(unknownReferee.getMean())
                  + "\n");
        out.close();
    }
}

final class Entry
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Entry.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8382470134129374928L,/* translation unit id   */ -8501373707003760862L,/* timestamp             */ 1709177903779L,/* source file name      */ "Analyze.java",/* probe size            */ 147);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8a050da7db31ef22(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public int m_gameIndex;

    public String m_resultBlack;

    public String m_resultReferee;

    public String m_resultWhite;

    public boolean m_alternated;

    public String m_duplicate;

    public int m_length;

    public double m_timeBlack;

    public double m_timeWhite;

    public double m_cpuBlack;

    public double m_cpuWhite;

    public boolean m_error;

    public String m_errorMessage;

    public Entry(int gameIndex, String resultBlack, String resultWhite,
                 String resultReferee, boolean alternated, String duplicate,
                 int length, double timeBlack, double timeWhite,
                 double cpuBlack, double cpuWhite, boolean error,
                 String errorMessage)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(141);m_gameIndex = gameIndex;
        m_resultBlack = resultBlack;
        m_resultWhite = resultWhite;
        m_resultReferee = resultReferee;
        m_alternated = alternated;
        m_duplicate = (((duplicate.equals("-")) ? ($qualityscroll_cover_jacov_probe_8a050da7db31ef22(142) || true) : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(143) && false)) ? "" : duplicate);
        m_length = length;
        m_timeBlack = timeBlack;
        m_timeWhite = timeWhite;
        m_cpuBlack = cpuBlack;
        m_cpuWhite = cpuWhite;
        m_error = error;
        m_errorMessage = errorMessage;
        $qualityscroll_cover_jacov_probe_8a050da7db31ef22(144);if ((m_errorMessage == null) ? true : (!$qualityscroll_cover_jacov_probe_8a050da7db31ef22(146) && false))
            {$qualityscroll_cover_jacov_probe_8a050da7db31ef22(145);m_errorMessage = "";}
    }
}
