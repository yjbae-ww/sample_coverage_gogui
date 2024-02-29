/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpEngine.java

package net.sf.gogui.gtp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.PointList;
import net.sf.gogui.util.StringUtil;

/** Base class for Go programs and tools implementing GTP. */
public class GtpEngine
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpEngine.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1134460561349127291L,/* translation unit id   */ 387515321157326563L,/* timestamp             */ 1709177901536L,/* source file name      */ "GtpEngine.java",/* probe size            */ 112);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_560bb21a69a96e3(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GtpEngine(PrintStream log)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(0);m_log = log;
        register("known_command", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(1);cmdKnownCommand(cmd); } });
        register("list_commands", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(2);cmdListCommands(cmd); } });
        register("name", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(3);cmdName(cmd); } });
        register("protocol_version", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(4);cmdProtocolVersion(cmd); } });
        register("quit", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(5);cmdQuit(cmd); } });
        register("version", new GtpCallback() {
                @Override
				public void run(GtpCommand cmd) throws GtpError {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(6);cmdVersion(cmd); } });
    }

    public void cmdKnownCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(7);String name = cmd.getArg();
        cmd.setResponse(((m_commands.containsKey(name)) ? ($qualityscroll_cover_jacov_probe_560bb21a69a96e3(8) || true) : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(9) && false)) ? "true" : "false");
    }

    public void cmdListCommands(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(10);cmd.checkArgNone();
        StringBuilder response = cmd.getResponse();
        Iterator it = m_commands.keySet().iterator();
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(11);while ((it.hasNext()) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(13) && false))
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(12);response.append(it.next());
            response.append('\n');
        }
    }

    public void cmdName(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(14);cmd.checkArgNone();
        cmd.setResponse(m_name);
    }

    public void cmdProtocolVersion(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(15);cmd.checkArgNone();
        cmd.setResponse("2");
    }

    public void cmdQuit(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(16);cmd.checkArgNone();
        setQuit();
    }

    public void cmdUnknown(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(17);throw new GtpError("unknown command: " + cmd.getCommand());
    }

    public void cmdVersion(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(18);cmd.checkArgNone();
        cmd.setResponse(m_version);
    }

    /** Callback for interrupting commands.
        This callback will be invoked if the special comment line
        "# interrupt" is received. It will be invoked from a different
        thread. */
    public void interruptCommand()
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(19);m_interrupted = true;
    }

    /** Handle command.
        The default implementation looks up the command within the registered
        commands and calls the registered callback. */
    public void handleCommand(GtpCommand cmd) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(20);m_interrupted = false;
        String name = cmd.getCommand();
        GtpCallback callback = m_commands.get(name);
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(21);if ((callback == null) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(23) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(22);cmdUnknown(cmd);}
        else
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(24);callback.run(cmd);}
    }

    public boolean isRegistered(String command)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(25);return m_commands.containsKey(command);
    }

    public synchronized void log(String line)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(26);assert m_log != null;
        m_log.println(line);
    }

    /** Main command loop.
        Reads commands and calls GtpEngine.handleCommand until the end of
        the input stream or the quit command is reached. */
    public void mainLoop(InputStream in, OutputStream out) throws IOException
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(27);m_out = new PrintStream(out);
        m_in = in;
        ReadThread readThread = new ReadThread(this, m_in, m_log != null);
        readThread.start();
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(28);while (true)
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(29);GtpCommand cmd = readThread.getCommand();
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(31);if ((cmd == null) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(33) && false))
                {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(32);return;}
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(34);boolean status = true;
            String response;
            try
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(35);handleCommand(cmd);
                response = cmd.getResponse().toString();
            }
            catch (GtpError e)
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(40);response = e.getMessage();
                status = false;
            }
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(36);String sanitizedResponse = response.replaceAll("\\n\\n", "\n \n");
            respond(status, cmd.hasId(), cmd.getId(), sanitizedResponse);
            // TODO: Use only quit flag not GtpCommand.isQuit once all
            // subclasses use the new registered quit command
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(37);if ((m_quit || cmd.isQuit()) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(39) && false))
                {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(38);return;}
        }
    }

    /** Utility function for parsing a point argument.
        @param cmdArray Command line split into words.
        @param boardSize Board size is needed for parsing the point
        @return GoPoint argument */
    public static GoPoint parsePointArgument(String[] cmdArray, int boardSize)
        throws GtpError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(41);if ((cmdArray.length != 2) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(43) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(42);throw new GtpError("Missing point argument");}
        try
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(44);return GoPoint.parsePoint(cmdArray[1], boardSize);
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(45);throw new GtpError(e.getMessage());
        }
    }

    /** Utility function for parsing an point list argument.
        @param cmdArray Command line split into words.
        @param boardSize Board size is needed for parsing the points
        @return Point list argument */
    public static PointList parsePointListArgument(String[] cmdArray,
                                                   int boardSize)
        throws GtpError
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(46);int length = cmdArray.length;
            assert length >= 1;
            PointList pointList = new PointList();
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(47);for (int i = 1; (i < length) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(49) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(48);GoPoint p = GoPoint.parsePoint(cmdArray[i], boardSize);
                pointList.add(p);
            }
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(50);return pointList;
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(51);throw new GtpError(e.getMessage());
        }
    }

    /** Print invalid response directly to output stream.
        Should only be used for simulationg broken GTP implementations
        like used in the gogui-dummy_invalid command.
        @param text Text to print to output stream.
        No newline will be appended. */
    public void printInvalidResponse(String text)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(52);m_out.print(text);
    }

    /** Register new command.
        If a command was already registered with the same name,
        it will be replaced by the new command. */
    public final void register(String command, GtpCallback callback)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(53);unregister(command);
        m_commands.put(command, callback);
    }

    public void respond(boolean status, boolean hasId, int id,
                        String response)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(54);StringBuilder fullResponse = new StringBuilder(256);
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(55);if ((status) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(57) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(56);fullResponse.append('=');}
        else
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(69);fullResponse.append('?');}
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(58);if ((hasId) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(60) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(59);fullResponse.append(id);}
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(61);fullResponse.append(' ');
        fullResponse.append(response);
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(62);if ((response.length() == 0
            || response.charAt(response.length() - 1) != '\n') ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(64) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(63);fullResponse.append('\n');}
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(65);m_out.println(fullResponse);
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(66);if ((m_log != null) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(68) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(67);m_log.println(fullResponse);}
    }

    /** Set quit flag for terminating command loop. */
    public void setQuit()
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(70);m_quit = true;
    }

    /** Set name for name command. */
    public void setName(String name)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(71);m_name = name;
    }

    /** Set version for version command. */
    public void setVersion(String version)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(72);m_version = version;
    }

    public final void unregister(String command)
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(73);if ((m_commands.containsKey(command)) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(75) && false))
            {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(74);m_commands.remove(command);}
    }

    protected boolean isInterrupted()
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(76);return m_interrupted;
    }

    private volatile boolean m_interrupted;

    private boolean m_quit;

    private String m_name = "Unknown";

    /** Engine version.
        The GTP standard says to return empty string, if no meaningful reponse
        is available. */
    private String m_version;

    /** Mapping from command to callback. */
    private final Map<String,GtpCallback> m_commands
        = new TreeMap<String,GtpCallback>();

    private InputStream m_in;

    private final PrintStream m_log;

    private PrintStream m_out;
}

/** Thread reading the command stream.
    Reading is done in a seperate thread to allow the notification
    of Server about an asynchronous interrupt received using
    the special comment line '# interrupt'. */
class ReadThread
    extends Thread
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ReadThread.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1134460561349127291L,/* translation unit id   */ 387515321157326563L,/* timestamp             */ 1709177901536L,/* source file name      */ "GtpEngine.java",/* probe size            */ 112);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_560bb21a69a96e3(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ReadThread(GtpEngine server, InputStream in, boolean log)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(77);m_in = new BufferedReader(new InputStreamReader(in));
        m_server = server;
        m_log = log;
    }

    public synchronized boolean endOfFile()
    {
        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(78);return m_endOfFile;
    }

    public GtpCommand getCommand()
    {
        synchronized (this)
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(79);assert ! m_waitCommand;
            m_waitCommand = true;
            notifyAll();
            try
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(80);wait();
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(82);System.err.println("Interrupted");
            }
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(81);assert m_endOfFile || ! m_waitCommand;
            GtpCommand result = m_command;
            m_command = null;
            return result;
        }
    }

    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(83);while (true)
            {
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(84);String line = m_in.readLine();
                $qualityscroll_cover_jacov_probe_560bb21a69a96e3(86);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(88) && false))
                {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(87);synchronized (this)
                    {
                        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(89);m_endOfFile = true;
                    }
                }
                else
                {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(101);if ((m_log) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(103) && false))
                        {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(102);m_server.log(line);}
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(104);line = line.trim();
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(105);if ((line.equals("# interrupt")) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(107) && false))
                    {
                        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(106);m_server.interruptCommand();
                    }
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(108);if ((line.equals("") || line.charAt(0) == '#') ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(110) && false))
                        {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(109);continue;}
                }
                synchronized (this)
                {
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(90);while ((! m_waitCommand) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(92) && false))
                    {
                        $qualityscroll_cover_jacov_probe_560bb21a69a96e3(91);wait();
                    }
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(93);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(95) && false))
                        {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(94);m_command = null;}
                    else
                        {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(100);m_command = new GtpCommand(line);}
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(96);notifyAll();
                    m_waitCommand = false;
                    $qualityscroll_cover_jacov_probe_560bb21a69a96e3(97);if ((m_command == null || m_command.isQuit()) ? true : (!$qualityscroll_cover_jacov_probe_560bb21a69a96e3(99) && false))
                        {$qualityscroll_cover_jacov_probe_560bb21a69a96e3(98);return;}
                }
            }
        }
        catch (Throwable e)
        {
            $qualityscroll_cover_jacov_probe_560bb21a69a96e3(111);StringUtil.printException(e);
        }
    }

    private boolean m_endOfFile;

    private final boolean m_log;

    private boolean m_waitCommand;

    private final BufferedReader m_in;

    private GtpCommand m_command;

    private final GtpEngine m_server;
}
