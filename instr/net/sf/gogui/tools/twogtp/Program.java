/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Program.java

package net.sf.gogui.tools.twogtp;

import java.util.ArrayList;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpSynchronizer;
import net.sf.gogui.util.Table;

public class Program
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Program.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8791687206845627567L,/* translation unit id   */ 5078570351314822095L,/* timestamp             */ 1709177903842L,/* source file name      */ "Program.java",/* probe size            */ 57);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Program(String command, String defaultName, String logPrefix,
                   boolean verbose) throws GtpError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(0);m_defaultName = defaultName;
        m_gtp = new GtpClient(command, null, verbose, null);
        m_gtp.setLogPrefix(logPrefix);
        m_synchronizer = new GtpSynchronizer(m_gtp);
        m_gtp.queryProtocolVersion();
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(1);m_name = m_gtp.send("name");
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(2);if ((m_name.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(4) && false))
                {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(3);m_name = defaultName;}
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(8);m_name = defaultName;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(5);m_version = m_gtp.send("version");
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(7);m_version = "";
        }
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(6);m_gtp.querySupportedCommands();
        m_gtp.queryInterruptSupport();
    }

    public void close()
    {
        // Some programs don't handle closing input stream well, so
        // we send an explicit quit
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(9);m_gtp.send("quit");
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(11);
        }
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(10);m_gtp.close();
        m_gtp.waitForExit();
    }

    /** Get cputime since program start or last invocation of this
        function. */
    public double getAndClearCpuTime()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(12);double cpuTime;
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(13);if ((m_gtp.isCpuTimeSupported()) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(15) && false))
                {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(14);cpuTime = m_gtp.getCpuTime();}
            else
                {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(17);cpuTime = 0;}
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(18);cpuTime = 0;
        }
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(16);double result = Math.max(0, cpuTime - m_cpuTime);
        m_cpuTime = cpuTime;
        return result;
    }

    /** Get unique label.
        Call setLabel() first. */
    public String getLabel()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(19);return m_label;
    }

    public String getProgramCommand()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(20);return m_gtp.getProgramCommand();
    }

    public String getResult()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(21);return m_gtp.send("final_score");
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(22);return "?";
        }
    }

    public String getVersion()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(23);return m_version;
    }

    public void interruptProgram()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(24);if ((m_gtp.isInterruptSupported()) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(26) && false))
                {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(25);m_gtp.sendInterrupt();}
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(27);System.err.println(e);
        }
    }

    public boolean isOutOfSync()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(28);return m_synchronizer.isOutOfSync();
    }

    public boolean isProgramDead()
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(29);return m_gtp.isProgramDead();
    }

    public boolean isSupported(String command)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(30);return m_gtp.isSupported(command);
    }

    public String send(String command) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(31);return m_gtp.send(command);
    }

    public String sendCommandGenmove(GoColor color) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(32);return send(m_gtp.getCommandGenmove(color));
    }

    public void sendIfSupported(String cmd, String cmdLine)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(33);if ((! m_gtp.isSupported(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(35) && false))
            {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(34);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(36);m_gtp.send(cmdLine);
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(37);
        }
    }

    public void setIOCallback(GtpClient.IOCallback callback)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(38);m_gtp.setIOCallback(callback);
    }

    /** Choose a unique label for this program.
        The label will be the program name, if it is the only one with
        this name, otherwise the program name with the version appended
        (or numbers, if the version string is empty or more than 40
        characters).
        @param programs The list of all programs (must include this
        program) */
    public void setLabel(ArrayList<Program> programs)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(39);boolean isUnique = true;
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(40);for (Program program : programs)
            {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(48);if ((program != this && program.m_name.equals(m_name)) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(50) && false))
            {
                $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(49);isUnique = false;
                break;
            }}
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(41);if ((isUnique) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(43) && false))
            {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(42);m_label = m_name;}
        else {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(44);if ((! m_version.trim().equals("")
                 &&  m_version.length() <= 40) ? true : (!$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(46) && false))
            {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(45);m_label = m_name + ":" + m_version;}
        else
            {$qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(47);m_label = m_name + "[" + (programs.indexOf(this) + 1) + "]";}}
    }

    public void setTableProperties(Table table)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(51);table.setProperty(m_defaultName, m_name);
        table.setProperty(m_defaultName + "Version", m_version);
        table.setProperty(m_defaultName + "Label", m_label);
        table.setProperty(m_defaultName + "Command", getProgramCommand());
    }

    public void synchronize(ConstGame game) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(52);ConstNode node = game.getGameInfoNode();
            ConstGameInfo info = game.getGameInfo(node);
            m_synchronizer.synchronize(game.getBoard(), info.getKomi(),
                                       info.getTimeSettings());
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(53);throw new GtpError(m_label + ": " + e.getMessage());
        }
    }

    public void synchronizeInit(ConstGame game) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(54);ConstNode node = game.getGameInfoNode();
            ConstGameInfo info = game.getGameInfo(node);
            m_synchronizer.init(game.getBoard(), info.getKomi(),
                                info.getTimeSettings());
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(55);throw new GtpError(m_label + ": " + e.getMessage());
        }
    }

    public void updateAfterGenmove(ConstBoard board)
    {
        $qualityscroll_cover_jacov_probe_467ab4d3bcf363cf(56);m_synchronizer.updateAfterGenmove(board);
    }

    private double m_cpuTime;

    private final String m_defaultName;

    private String m_label;

    private final GtpClient m_gtp;

    private final GtpSynchronizer m_synchronizer;

    private String m_name;

    private String m_version;
}
