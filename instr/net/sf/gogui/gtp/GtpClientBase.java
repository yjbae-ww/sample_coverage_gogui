/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpClientBase.java

package net.sf.gogui.gtp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.util.StringUtil;

/** Interface to a Go program that uses GTP.
    This class implements most of the functionality of a connection to a GTP
    command apart from how commands are actually sent to the program.
    Subclasses need to implement the abstract function send() and a few
    functions related to querying and using the ability to interrupt
    commands. */
public abstract class GtpClientBase
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpClientBase.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1277241204973478189L,/* translation unit id   */ 360934212713458009L,/* timestamp             */ 1709177901422L,/* source file name      */ "GtpClientBase.java",/* probe size            */ 116);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_5024bc110122959(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Close output connection.
        Should do nothing if the concrete class does not communicate through
        streams. */
    public abstract void close();

    /** Get command for setting the board size.
        Note: call queryProtocolVersion first
        @return The boardsize command for GTP version 2 programs,
        otherwise null. */
    public String getCommandBoardsize(int size)
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(0);if ((m_protocolVersion == 2) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(2) && false))
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(1);m_buffer.setLength(0);
            m_buffer.append("boardsize ");
            m_buffer.append(size);
            return m_buffer.toString();
        }
        else
            {$qualityscroll_cover_jacov_probe_5024bc110122959(3);return null;}
    }

    /** Get command for starting a new game.
        Note: call queryProtocolVersion first
        @return The boardsize command for GTP version 1 programs,
        otherwise the clear_board command. */
    public String getCommandClearBoard(int size)
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(4);if ((m_protocolVersion == 1) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(6) && false))
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(5);m_buffer.setLength(0);
            m_buffer.append("boardsize ");
            m_buffer.append(size);
            return m_buffer.toString();
        }
        else
            {$qualityscroll_cover_jacov_probe_5024bc110122959(7);return "clear_board";}
    }

    /** Get command for generating a move.
        Note: call queryProtocolVersion first
        @param color GoColor::BLACK or GoColor::WHITE
        @return The right command depending on the GTP version. */
    public String getCommandGenmove(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(8);assert color.isBlackWhite();
        $qualityscroll_cover_jacov_probe_5024bc110122959(9);if ((m_protocolVersion == 1) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(11) && false))
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(10);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(13) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(12);return "genmove_black";}
            else
                {$qualityscroll_cover_jacov_probe_5024bc110122959(14);return "genmove_white";}
        }
        $qualityscroll_cover_jacov_probe_5024bc110122959(15);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(17) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(16);return "genmove b";}
        else
            {$qualityscroll_cover_jacov_probe_5024bc110122959(18);return "genmove w";}
    }

    /** Get command for playing a move.
        Note: call queryProtocolVersion first
        @return The right command depending on the GTP version. */
    public String getCommandPlay(Move move)
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(19);m_buffer.setLength(0);
        $qualityscroll_cover_jacov_probe_5024bc110122959(20);if ((m_protocolVersion == 1) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(22) && false))
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(21);GoColor color = move.getColor();
            String point = GoPoint.toString(move.getPoint());
            $qualityscroll_cover_jacov_probe_5024bc110122959(23);if ((color == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(25) && false))
               {$qualityscroll_cover_jacov_probe_5024bc110122959(24);m_buffer.append("black ");}
            else {$qualityscroll_cover_jacov_probe_5024bc110122959(31);if ((color == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(33) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(32);m_buffer.append("white ");}}
            $qualityscroll_cover_jacov_probe_5024bc110122959(26);m_buffer.append(point);
        }
        else
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(34);m_buffer.append("play ");
            m_buffer.append(move);
        }
        $qualityscroll_cover_jacov_probe_5024bc110122959(27);if ((m_lowerCase) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(29) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(28);return m_buffer.toString().toLowerCase(Locale.ENGLISH);}
        $qualityscroll_cover_jacov_probe_5024bc110122959(30);return m_buffer.toString();
    }

    /** Send cputime command and convert the result to double.
        @throws GtpError if command fails or does not return a floating point
        number. */
    public double getCpuTime() throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(35);return Double.parseDouble(send("cputime"));
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(36);throw new GtpError("Invalid response to cputime command");
        }
    }

    /** Get program name or "Unknown Program" if unknown.
        If queryName() was not called or the name command failed, the
        string "Unknown Program" is returned. */
    public String getLabel()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(37);return (((m_name == null) ? ($qualityscroll_cover_jacov_probe_5024bc110122959(38) || true) : (!$qualityscroll_cover_jacov_probe_5024bc110122959(39) && false)) ? "Unknown Program" : m_name);
    }

    /** Get program name.
        If queryName() was not called or the name command failed, the
        string "Unknown Program" is returned. */
    public String getName()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(40);return m_name;
    }

    /** Get protocol version.
        You have to call queryProtocolVersion() first, otherwise this method
        will always return 2. */
    public int getProtocolVersion()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(41);return m_protocolVersion;
    }

    /** Get the supported commands.
        Note: call querySupportedCommands() first.
        @return A vector of strings with the supported commands. */
    public ArrayList<String> getSupportedCommands()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(42);ArrayList<String> result = new ArrayList<String>(128);
        $qualityscroll_cover_jacov_probe_5024bc110122959(43);if ((m_supportedCommands != null) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(45) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(44);for (int i = 0; (i < m_supportedCommands.length) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(47) && false); ++i)
                {$qualityscroll_cover_jacov_probe_5024bc110122959(46);result.add(m_supportedCommands[i]);}}
        $qualityscroll_cover_jacov_probe_5024bc110122959(48);return result;
    }

    /** Is the program in a state, that all subsequent commands will fail.
        Returns false, but can be reimplemented in a subclass. */
    public boolean isProgramDead()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(49);return false;
    }

    /** Check if a command is supported.
        Note: call querySupportedCommands() first. */
    public boolean isSupported(String command)
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(50);if ((m_supportedCommands == null) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(52) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(51);return false;}
        $qualityscroll_cover_jacov_probe_5024bc110122959(53);for (int i = 0; (i < m_supportedCommands.length) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(55) && false); ++i)
            {$qualityscroll_cover_jacov_probe_5024bc110122959(54);if ((m_supportedCommands[i].equals(command)) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(58) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(57);return true;}}
        $qualityscroll_cover_jacov_probe_5024bc110122959(56);return false;
    }

    /** Check if cputime command is supported.
        Note: call querySupportedCommands() first. */
    public boolean isCpuTimeSupported()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(59);return isSupported("cputime");
    }

    /** Check if a genmove command is supported.
        If list_commands is not supported, it is assumed that genmove is
        supported.
        Note: call querySupportedCommands() first. */
    public boolean isGenmoveSupported()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(60);if ((m_protocolVersion == 1) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(62) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(61);return (! isSupported("help") ||
                    (isSupported("genmove_black")
                     && isSupported("genmove_white")));}
        $qualityscroll_cover_jacov_probe_5024bc110122959(63);return (! isSupported("list_commands") || isSupported("genmove"));
    }

    /** Check if interrupting a command is supported.
        Interrupting can supported by ANSI C signals or the special
        comment line "# interrupt" as described in the GoGui documentation
        chapter "Interrupting commands".
        Note: call queryInterruptSupport() first. */
    public boolean isInterruptSupported()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(64);return (m_isInterruptCommentSupported || m_pid != null);
    }

    /** Query if interrupting is supported.
        @see GtpClient#isInterruptSupported */
    public void queryInterruptSupport()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(65);if ((isSupported("gogui-interrupt")) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(67) && false))
            {
                $qualityscroll_cover_jacov_probe_5024bc110122959(66);send("gogui-interrupt");
                m_isInterruptCommentSupported = true;
            }
            else {$qualityscroll_cover_jacov_probe_5024bc110122959(68);if ((isSupported("gogui_interrupt")) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(70) && false))
            {
                $qualityscroll_cover_jacov_probe_5024bc110122959(69);send("gogui_interrupt");
                m_isInterruptCommentSupported = true;
            }
            else {$qualityscroll_cover_jacov_probe_5024bc110122959(71);if ((isSupported("gogui-sigint")) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(73) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(72);m_pid = send("gogui-sigint").trim();}
            else {$qualityscroll_cover_jacov_probe_5024bc110122959(74);if ((isSupported("gogui_sigint")) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(76) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(75);m_pid = send("gogui_sigint").trim();}}}}
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_5024bc110122959(77);
        }
    }

    /** Queries the name.
        @see #getName() */
    public void queryName()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(78);m_name = send("name");
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_5024bc110122959(79);
        }
    }

    /** Query the protocol version.
        Assumes version 2 if the protocol_version command is not available,
        fails, or returns a version greater 2.
        @see GtpClientBase#getProtocolVersion */
    public void queryProtocolVersion()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(80);m_protocolVersion = 2;
        try
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(81);String response = send("protocol_version");
            int v = Integer.parseInt(response);
            $qualityscroll_cover_jacov_probe_5024bc110122959(82);if ((v == 1 || v == 2) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(84) && false))
                {$qualityscroll_cover_jacov_probe_5024bc110122959(83);m_protocolVersion = v;}
        }
        catch (NumberFormatException e)
        {$qualityscroll_cover_jacov_probe_5024bc110122959(85);
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_5024bc110122959(86);
        }
    }

    /** Query the supported commands.
        @see GtpClientBase#getSupportedCommands
        @see GtpClientBase#isSupported */
    public void querySupportedCommands() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(87);String command = (((m_protocolVersion == 1) ? ($qualityscroll_cover_jacov_probe_5024bc110122959(88) || true) : (!$qualityscroll_cover_jacov_probe_5024bc110122959(89) && false)) ? "help" : "list_commands");
        String response = send(command);
        m_supportedCommands = StringUtil.splitArguments(response);
        $qualityscroll_cover_jacov_probe_5024bc110122959(90);for (int i = 0; (i < m_supportedCommands.length) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(92) && false); ++i)
            {$qualityscroll_cover_jacov_probe_5024bc110122959(91);m_supportedCommands[i] = m_supportedCommands[i].trim();}
    }

    /** Queries the program version.
        @return The version or an empty string if the version command fails. */
    public String queryVersion()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(93);return send("version");
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(94);return "";
        }
    }

    /** Send a command.
        @return The response text of the successful response not including
        the status character.
        @throws GtpError containing the response if the command fails. */
    public abstract String send(String command) throws GtpError;

    /** Send comment.
        @param comment comment line (must start with '#'). */
    public abstract void sendComment(String comment);

    /** Send command for setting the board size.
        Send the command if it exists in the GTP protocol version.
        Note: call queryProtocolVersion first
        @see GtpClientBase#getCommandBoardsize */
    public void sendBoardsize(int size) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(95);String command = getCommandBoardsize(size);
        $qualityscroll_cover_jacov_probe_5024bc110122959(96);if ((command != null) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(98) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(97);send(command);}
    }

    /** Send command for staring a new game.
        Note: call queryProtocolVersion first
        @see GtpClientBase#getCommandClearBoard */
    public void sendClearBoard(int size) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(99);send(getCommandClearBoard(size));
    }

    /** Send command for playing a move.
        Note: call queryProtocolVersion first */
    public void sendPlay(Move move) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(100);send(getCommandPlay(move));
    }

    /** Interrupt current command.
        Can be called from a different thread during a send.
        Note: call queryInterruptSupport first
        @see GtpClient#isInterruptSupported
        @throws GtpError if interrupting commands is not supported. */
    public void sendInterrupt() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(101);if ((m_isInterruptCommentSupported) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(103) && false))
            {$qualityscroll_cover_jacov_probe_5024bc110122959(102);sendComment("# interrupt");}
        else {$qualityscroll_cover_jacov_probe_5024bc110122959(104);if ((m_pid != null) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(106) && false))
        {
            $qualityscroll_cover_jacov_probe_5024bc110122959(105);String command = "kill -INT " + m_pid;
            Runtime runtime = Runtime.getRuntime();
            try
            {
                $qualityscroll_cover_jacov_probe_5024bc110122959(107);Process process = runtime.exec(command);
                int result = process.waitFor();
                $qualityscroll_cover_jacov_probe_5024bc110122959(108);if ((result != 0) ? true : (!$qualityscroll_cover_jacov_probe_5024bc110122959(110) && false))
                    {$qualityscroll_cover_jacov_probe_5024bc110122959(109);throw new GtpError("Command \"" + command
                                        + "\" returned " + result);}
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_5024bc110122959(111);throw new GtpError("Could not run command " + command +
                                    ":\n" + e);
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_5024bc110122959(112);printInterrupted();
            }
        }
        else
            {$qualityscroll_cover_jacov_probe_5024bc110122959(113);throw new GtpError("Interrupt not supported");}}
    }

    /** Enable lower case mode for play commands.
        For engines that don't implement GTP correctly and understand
        only lower case moves in the play command. */
    public void setLowerCase()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(114);m_lowerCase = true;
    }

    /** Wait until the process of the program exits.
        Should do nothing if the concrete class does not create a process. */
    public abstract void waitForExit();

    private boolean m_isInterruptCommentSupported;

    protected String m_name;

    private String m_pid;

    /** Local variable in some functions, reused for efficiency. */
    private final StringBuilder m_buffer = new StringBuilder(128);

    private boolean m_lowerCase;

    private int m_protocolVersion = 2;

    private String[] m_supportedCommands;

    private void printInterrupted()
    {
        $qualityscroll_cover_jacov_probe_5024bc110122959(115);System.err.println("GtpClient: InterruptedException");
        Thread.dumpStack();
    }
}
