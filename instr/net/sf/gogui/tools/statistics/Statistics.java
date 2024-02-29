/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Statistics.java

package net.sf.gogui.tools.statistics;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.Game;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.Move;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpClientBase;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpSynchronizer;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.util.Table;

/** Run commands of a GTP engine on all positions in a game collection. */
public class Statistics
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Statistics.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -938381457539623430L,/* translation unit id   */ -3957418674293683144L,/* timestamp             */ 1709177903661L,/* source file name      */ "Statistics.java",/* probe size            */ 187);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public void run(String program, ArrayList<String> sgfFiles, int size,
                    ArrayList<String> commands,
                    ArrayList<String> beginCommands,
                    ArrayList<String> finalCommands, boolean verbose,
                    boolean allowSetup, boolean backward, boolean random)
        throws ErrorMessage, GtpError, IOException
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(0);run(new GtpClient(program, null, verbose, null), program, sgfFiles,
            size, commands, beginCommands, finalCommands, allowSetup,
            backward, random);
    }

    /** Construct with existing GTP engine.
        @param gtp The GTP engine
        @param program Program command (null, if gtp is not an instance of
        GtpClient)
        @param sgfFiles List containing the SGF file names
        @param size The board size used in the games (all games must have the
        same board size)
        @param commands List containing the commands to run in every position
        @param beginCommands List containing the commands to run in the first
        position
        @param finalCommands List containing the commands to run in the last
        position
        @param allowSetup true, if setup stones in the games are allowed and
        should not generate en error
        @param backward true, if games should be iterated backwards (counting
        the moves starting with one at the last move)
        @param random true, if only one random position should be selected
        from each game */
    public void run(GtpClientBase gtp, String program,
                    ArrayList<String> sgfFiles, int size,
                    ArrayList<String> commands,
                    ArrayList<String> beginCommands,
                    ArrayList<String> finalCommands, boolean allowSetup,
                    boolean backward, boolean random)
        throws ErrorMessage, IOException
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(1);new FileCheck(sgfFiles, size, allowSetup);
        m_size = size;
        m_allowSetup = allowSetup;
        m_backward = backward;
        m_random = random;
        initCommands(commands, beginCommands, finalCommands);
        ArrayList<String> columnHeaders = new ArrayList<String>();
        columnHeaders.add("File");
        columnHeaders.add("Move");
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(2);for (int i = 0; (i < m_commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(4) && false); ++i)
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(3);columnHeaders.add(getCommand(i).m_columnTitle);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(5);m_table = new Table(columnHeaders);
        m_table.setProperty("Size", Integer.toString(size));
        m_gtp = gtp;
        m_synchronizer = new GtpSynchronizer(m_gtp);
        m_gtp.queryProtocolVersion();
        m_gtp.queryName();
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(6);if ((program != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(8) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(7);m_table.setProperty("Program", program);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(9);m_table.setProperty("Name", m_gtp.getLabel());
        m_table.setProperty("Version", m_gtp.queryVersion());
        String host = Platform.getHostInfo();
        m_table.setProperty("Host", host);
        m_table.setProperty("Date", StringUtil.getDate());
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(10);for (int i = 0; (i < sgfFiles.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(12) && false); ++i)
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(11);handleFile(sgfFiles.get(i));}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(13);m_gtp.send("quit");
        m_gtp.close();
        m_gtp.waitForExit();
        m_table.setProperty("Games", Integer.toString(m_numberGames));
        m_table.setProperty("Backward", ((backward) ? ($qualityscroll_cover_jacov_probe_c9146caedb3a4c38(14) || true) : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(15) && false)) ? "yes" : "no");
        m_table.setProperty("Random", ((random) ? ($qualityscroll_cover_jacov_probe_c9146caedb3a4c38(16) || true) : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(17) && false)) ? "yes" : "no");
    }

    /** Set maximum move number for positions to run the commands on.
        Default is Integer.MAX_VALUE. */
    public void setMax(int max)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(18);m_max = max;
    }

    /** Set minimum move number for positions to run the commands on.
        Default is zero. */
    public void setMin(int min)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(19);m_min = min;
    }

    /** Don't write information about progress.
        Default is false. */
    public void setQuiet(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(20);m_quiet = enable;
    }

    /** Save result table of last run. */
    public void saveTable(File output) throws IOException
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(21);FileWriter writer = new FileWriter(output);
        try
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(22);m_table.save(writer);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(23);writer.close();
        }
    }

    private static class Command
    {
        public boolean m_begin;

        public boolean m_final;

        public String m_command;

        public String m_columnTitle;
    }

    private boolean m_allowSetup;

    private boolean m_backward;

    private boolean m_random;

    private boolean m_quiet;

    private int m_max = Integer.MAX_VALUE;

    private int m_min = 0;

    private int m_numberGames;

    private int m_size;

    private double m_lastCpuTime = 0;

    private GtpClientBase m_gtp;

    private static final NumberFormat FORMAT1 = StringUtil.getNumberFormat(1);

    private static final NumberFormat FORMAT2 = StringUtil.getNumberFormat(2);

    private Table m_table;

    private ArrayList<Command> m_commands;

    private GtpSynchronizer m_synchronizer;

    private void addCommand(String commandLine, boolean isBegin,
                            boolean isFinal) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(24);commandLine = commandLine.trim();
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(25);if ((commandLine.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(27) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(26);throw new ErrorMessage("Empty command not allowed");}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(28);Command command = new Command();
        command.m_command = commandLine;
        command.m_begin = isBegin;
        command.m_final = isFinal;
        int numberSame = 0;
        Command firstSame = null;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(29);for (int i = 0; (i < m_commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(31) && false); ++i)
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(30);if ((getCommand(i).m_command.equals(commandLine)) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(41) && false))
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(40);firstSame = getCommand(i);
                ++numberSame;
            }}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(32);if ((numberSame == 0) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(34) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(33);command.m_columnTitle = commandLine;}
        else
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(36);if ((numberSame == 1) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(38) && false))
                {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(37);firstSame.m_columnTitle = firstSame.m_columnTitle + " (1)";}
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(39);command.m_columnTitle = commandLine + " ("
                + (numberSame + 1) + ")";
        }
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(35);m_commands.add(command);
    }

    private void addCommands(ArrayList<String> commands, boolean isBegin,
                             boolean isFinal) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(42);for (String c : commands)
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(43);addCommand(c, isBegin, isFinal);}
    }

    private void checkGame(ConstGameTree tree, String name) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(44);int size = tree.getBoardSize();
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(45);if ((size != m_size) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(47) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(46);throw new ErrorMessage(name + " has not size " + m_size);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(48);ConstNode root = tree.getRootConst();
        GoColor toMove = BLACK;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(49);for (ConstNode node = root; (node != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(51) && false); node = node.getChildConst())
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(50);if ((node.hasSetup()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(53) && false))
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(52);if ((m_allowSetup) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(55) && false))
                {
                    $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(54);if ((node == root) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(57) && false))
                        {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(56);toMove = EMPTY;}
                    else
                        {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(68);throw new ErrorMessage(name + " contains setup stones"
                                               + " in non-root position");}
                }
                else
                    {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(69);throw new ErrorMessage(name + " contains setup stones");}
            }
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(58);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(59);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(61) && false))
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(60);if ((toMove == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(63) && false))
                    {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(62);toMove = move.getColor();}
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(64);if ((move.getColor() != toMove) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(66) && false))
                    {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(65);throw new ErrorMessage(name
                                           + "has non-alternating moves");}
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(67);toMove = toMove.otherColor();
            }
        }
    }

    private String convertCommand(String command, GoColor toMove)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(70);if ((command.equals("reg_genmove")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(72) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(71);return command + ' ' + toMove;}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(73);return command;
    }

    private String convertResponse(String command, String response,
                                   GoColor toMove, Move move) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(74);if ((command.equals("cputime")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(76) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(75);try
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(77);double cpuTime = Double.parseDouble(response);
                double diff = cpuTime - m_lastCpuTime;
                m_lastCpuTime = cpuTime;
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(78);return FORMAT2.format(diff);
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(80);return response;
            }
        }
        else {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(81);if ((command.equals("estimate_score")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(83) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(82);String arg[] = StringUtil.splitArguments(response);
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(84);if ((arg.length == 0) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(86) && false))
                {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(85);return response;}
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(87);return convertScore(arg[0]);
        }
        else {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(88);if ((command.equals("final_score")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(90) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(89);return convertScore(response);
        }
        else {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(91);if ((command.equals("reg_genmove")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(93) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(92);if ((move == null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(95) && false))
                {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(94);return "";}
            try
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(96);GoPoint point = GoPoint.parsePoint(response, m_size);
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(97);return ((Move.get(toMove, point) == move) ? ($qualityscroll_cover_jacov_probe_c9146caedb3a4c38(98) || true) : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(99) && false)) ? "1" : "0";
            }
            catch (InvalidPointException e)
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(100);throw new GtpError("Program sent invalid move: " + response);
            }
        }}}}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(79);return response;
    }

    /** Tries to convert score into number.
        @return Score string or original string, if conversion fails. */
    private String convertScore(String string)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(101);String score = string.trim();
        double sign = 1;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(102);if ((score.startsWith("W+")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(104) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(103);score = score.substring(2);
            sign = -1;
        }
        else {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(107);if ((score.startsWith("B+")) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(109) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(108);score = score.substring(2);}}
        try
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(105);return FORMAT1.format(sign * Double.parseDouble(score));
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(106);return string;
        }
    }

    private void initCommands(ArrayList<String> commands,
                              ArrayList<String> beginCommands,
                              ArrayList<String> finalCommands)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(110);m_commands = new ArrayList<Command>();
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(111);if ((beginCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(113) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(112);addCommands(beginCommands, true, false);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(114);if ((commands != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(116) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(115);addCommands(commands, false, false);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(117);if ((finalCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(119) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(118);addCommands(finalCommands, false, true);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(120);if ((m_commands.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(122) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(121);throw new ErrorMessage("No commands defined");}
    }

    private Command getCommand(int index)
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(123);return m_commands.get(index);
    }

    private void handleFile(String name)
        throws ErrorMessage, FileNotFoundException, GtpError,
               SgfError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(124);File file = new File(name);
        InputStream in = new FileInputStream(file);
        SgfReader reader = new SgfReader(in, file, null, 0);
        ++m_numberGames;
        Game game = new Game(reader.getTree());
        checkGame(game.getTree(), name);
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(125);if ((m_random) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(127) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(126);iteratePositionsRandom(game, name);}
        else {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(128);if ((m_backward) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(130) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(129);iteratePositionsBackward(game, name);}
        else
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(131);iteratePositions(game, name);}}
    }

    private void handlePosition(String name, GoColor toMove, Move move,
                                int number, boolean beginCommands,
                                boolean regularCommands,
                                boolean finalCommands)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(132);if ((! m_quiet) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(134) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(133);System.err.println(name + ":" + number);}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(135);m_table.startRow();
        try
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(136);m_table.set("File", name);
            m_table.set("Move", number);
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(137);for (int i = 0; (i < m_commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(139) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(138);Command command = getCommand(i);
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(152);if ((command.m_begin && beginCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(154) && false))
                {
                    $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(153);String response = send(command.m_command, toMove, move);
                    m_table.set(command.m_columnTitle, response);
                }
            }
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(140);for (int i = 0; (i < m_commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(142) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(141);Command command = getCommand(i);
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(149);if ((! command.m_begin && ! command.m_final && regularCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(151) && false))
                {
                    $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(150);String response = send(command.m_command, toMove, move);
                    m_table.set(command.m_columnTitle, response);
                }
            }
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(143);for (int i = 0; (i < m_commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(145) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(144);Command command = getCommand(i);
                $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(146);if ((command.m_final && finalCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(148) && false))
                {
                    $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(147);String response = send(command.m_command, toMove, move);
                    m_table.set(command.m_columnTitle, response);
                }
            }
        }
        catch (Table.InvalidLocation e)
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(155);System.err.println(e.getMessage());
            // Table was created by this class in correct format
            assert false;
        }
    }

    private void iteratePositions(Game game, String name) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(156);int number = 0;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(157);for (ConstNode node = game.getRoot(); (node != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(159) && false);
             node = node.getChildConst())
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(158);game.gotoNode(node);
            synchronize(game);
            Move move = node.getMove();
            boolean beginCommands = ! node.hasFather();
            boolean regularCommands =
                ((move != null || node.hasSetup() || ! node.hasFather())
                 && number >= m_min && number <= m_max);
            boolean finalCommands = ! node.hasChildren();
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(160);if ((beginCommands || regularCommands || finalCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(162) && false))
                {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(161);handlePosition(name, node.getToMove(), move, number,
                               beginCommands, regularCommands, finalCommands);}
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(163);++number;
        }
    }

    private void iteratePositionsBackward(Game game, String name)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(164);int number = 0;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(165);for (ConstNode node = NodeUtil.getLast(game.getRoot()); (node != null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(167) && false);
             node = node.getFatherConst())
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(166);game.gotoNode(node);
            synchronize(game);
            Move move = node.getMove();
            boolean beginCommands = ! node.hasChildren();
            boolean regularCommands =
                ((move != null || node.hasSetup() || ! node.hasFather())
                 && number >= m_min && number <= m_max);
            boolean finalCommands = ! node.hasFather();
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(168);if ((beginCommands || regularCommands || finalCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(170) && false))
                {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(169);handlePosition(name, node.getToMove(), move, number,
                               beginCommands, regularCommands, finalCommands);}
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(171);++number;
        }
    }

    private void iteratePositionsRandom(Game game, String name)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(172);int minDepth;
        int maxDepth;
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(173);if ((m_backward) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(175) && false))
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(174);int depth = NodeUtil.getDepth(NodeUtil.getLast(game.getRoot()));
            minDepth = depth - m_max;
            maxDepth = depth - m_min;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(184);minDepth = m_min;
            maxDepth = m_max;
        }
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(176);ConstNode node = NodeUtil.selectRandom(game.getRoot(), minDepth,
                                               maxDepth);
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(177);if ((node == null) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(179) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(178);return;}
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(180);int number = NodeUtil.getDepth(node);
        game.gotoNode(node);
        synchronize(game);
        Move move = node.getMove();
        boolean beginCommands = ! node.hasChildren();
        boolean regularCommands =
            (move != null || node.hasSetup() || ! node.hasFather());
        boolean finalCommands = ! node.hasFather();
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(181);if ((beginCommands || regularCommands || finalCommands) ? true : (!$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(183) && false))
            {$qualityscroll_cover_jacov_probe_c9146caedb3a4c38(182);handlePosition(name, node.getToMove(), move, number,
                           beginCommands, regularCommands, finalCommands);}
    }

    private String send(String command, GoColor toMove, Move move)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(185);String cmd = convertCommand(command, toMove);
        String response = m_gtp.send(cmd).trim();
        response = response.replaceAll("\t", " ");
        response = response.replaceAll("\n", " ");
        return convertResponse(command, response, toMove, move);
    }

    private void synchronize(ConstGame game) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_c9146caedb3a4c38(186);ConstNode node = game.getGameInfoNode();
        ConstGameInfo info = game.getGameInfo(node);
        m_synchronizer.synchronize(game.getBoard(), info.getKomi(),
                                   info.getTimeSettings());
    }
}
