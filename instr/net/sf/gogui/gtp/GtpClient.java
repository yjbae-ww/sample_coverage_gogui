/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpClient.java

package net.sf.gogui.gtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import net.sf.gogui.go.Move;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.util.ProcessUtil;

/** Interface to a Go program that uses GTP over the standard I/O streams.
    <p>
    This class is final because it starts a thread in its constructor which
    might conflict with subclassing because the subclass constructor will
    be called after the thread is started.
    </p>
    <p>
    Callbacks can be registered to monitor the input, output and error stream
    and to handle timeout and invalid responses.
    </p> */
public final class GtpClient
    extends GtpClientBase
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpClient.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6411606258487015125L,/* translation unit id   */ 7985877268221445501L,/* timestamp             */ 1709177901370L,/* source file name      */ "GtpClient.java",/* probe size            */ 208);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_6ed389108034c57d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Exception thrown if executing a GTP engine failed. */
    public static class ExecFailed
        extends GtpError
    {
        public String m_program;

        public ExecFailed(String program, String message)
        {
            super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_6ed389108034c57d(0);
            m_program = program;
        }

        public ExecFailed(String program, IOException e)
        {
            this(program, e.getMessage());$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_6ed389108034c57d(1);
        }
    }

    /** Callback if a timeout occured. */
    public interface TimeoutCallback
    {
        /** Ask for continuation.
            If this function returns true, Gtp.send will wait for another
            timeout period, if it returns false, the program will be killed. */
        boolean askContinue();
    }

    /** Callback if an invalid response occured.
        Can be used to display invalid responses (without a status character)
        immediately, because send will not abort on an invalid response
        but continue to wait for a valid response line.
        This is necessary for some Go programs with broken GTP implementation
        which write debug data to standard output (e.g. Wallyplus 0.1.2). */
    public interface InvalidResponseCallback
    {
        void show(String line);
    }

    /** Callback interface for logging or displaying the GTP stream.
        Note that some of the callback functions are called from different
        threads. */
    public interface IOCallback
    {
        void receivedInvalidResponse(String s);

        void receivedResponse(boolean error, String s);

        void receivedStdErr(String s);

        void sentCommand(String s);
    }

    /** Constructor.
        @param program Command line for program.
        Will be split into words with respect to " as in StringUtil.tokenize.
        If the command line contains the string "%SRAND", it will be replaced
        by a random seed. This is useful if the random seed can be set by
        a command line option to produce deterministic randomness (the
        command returned by getProgramCommand() will contain the actual
        random seed used).
        @param workingDirectory The working directory to run the program in or
        null for the current directory
        @param log Log input, output and error stream to standard error.
        @param callback Callback for external display of the streams. */
    public GtpClient(String program, File workingDirectory, boolean log,
                     IOCallback callback)
        throws GtpClient.ExecFailed
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(2);if ((workingDirectory != null && ! workingDirectory.isDirectory()) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(4) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(3);throw new ExecFailed(program,
                                 "Invalid working directory \""
                                 + workingDirectory + "\"");}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(5);m_log = log;
        m_callback = callback;
        m_wasKilled = false;
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(6);if ((program.indexOf("%SRAND") >= 0) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(8) && false))
        {
            // RAND_MAX in stdlib.h ist at least 32767
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(7);int randMax = 32767;
            int rand = (int)(Math.random() * (randMax + 1));
            program =
                program.replaceAll("%SRAND", Integer.toString(rand));
        }
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(9);m_program = program;
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(10);if ((StringUtil.isEmpty(program)) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(12) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(11);throw new ExecFailed(program,
                                 "Command for invoking Go program must be"
                                 + " not empty.");}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(13);Runtime runtime = Runtime.getRuntime();
        try
        {
            // Create command array with StringUtil::splitArguments
            // because Runtime.exec(String) uses a default StringTokenizer
            // which does not respect ".
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(14);String[] cmdArray = StringUtil.splitArguments(program);
            // Make file name absolute, if working directory is not current
            // directory. With Java 1.5, it seems that Runtime.exec succeeds
            // if the relative path is valid from the current, but not from
            // the given working directory, but the process is not usable
            // (reading from its input stream immediately returns
            // end-of-stream)
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(15);if ((cmdArray.length > 0) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(17) && false))
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(16);File file = new File(cmdArray[0]);
                // Only replace if executable is a path to a file, not
                // an executable in the exec-path
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(18);if ((file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(20) && false))
                    {$qualityscroll_cover_jacov_probe_6ed389108034c57d(19);cmdArray[0] = file.getAbsolutePath();}
            }
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(21);m_process = runtime.exec(cmdArray, null, workingDirectory);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(23);throw new ExecFailed(program, e);
        }
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(22);init(m_process.getInputStream(), m_process.getOutputStream(),
             m_process.getErrorStream());
    }

    /** Constructor for given input and output streams. */
    public GtpClient(InputStream in, OutputStream out, boolean log,
                     IOCallback callback)
        throws GtpError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(24);m_log = log;
        m_callback = callback;
        m_program = "-";
        m_process = null;
        init(in, out, null);
    }

    /** Close the output stream to the program.
        Some engines don't handle closing the command stream without an
        explicit quit command well, so the preferred way to terminate a
        connection is to send a quit command. Closing the output stream after
        a quit is not strictly necessary, but may improve compatibility with
        engines that read the input stream in a different thread */
    @Override
	public void close()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(25);m_out.close();
    }

    /** Kill the Go program. */
    public void destroyProcess()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(26);if ((m_process != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(28) && false))
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(27);m_wasKilled = true;
            m_process.destroy();
        }
    }

    /** Did the engine ever send a valid response to a command? */
    public boolean getAnyCommandsResponded()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(29);return m_anyCommandsResponded;
    }

    /** Get response to last command sent. */
    public String getResponse()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(30);return m_response;
    }

    /** Get full response including status and ID and last command. */
    public String getFullResponse()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(31);return m_fullResponse;
    }

    /** Get the command line that was used for invoking the Go program.
        @return The command line that was given to the constructor. */
    public String getProgramCommand()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(32);return m_program;
    }

    /** Check if program is dead. */
    @Override
	public boolean isProgramDead()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(33);return m_isProgramDead;
    }

    /** Send a command.
        @return The response text of the successful response not including
        the status character.
        @throws GtpError containing the response if the command fails. */
    @Override
	public String send(String command) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(34);return send(command, -1, null);
    }

    public void queryName(long timeout, TimeoutCallback timeoutCallback)
        throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(35);m_name = send("name", timeout, timeoutCallback);
    }

    /** Send a command with timeout.
        @param command The command to send
        @param timeout Timeout in milliseconds or -1, if no timeout
        @param timeoutCallback Timeout callback or null if no timeout.
        @return The response text of the successful response not including
        the status character.
        @throws GtpError containing the response if the command fails.
        @see TimeoutCallback */
    public String send(String command, long timeout,
                       TimeoutCallback timeoutCallback) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(36);assert ! command.trim().equals("");
        assert ! command.trim().startsWith("#");
        m_timeoutCallback = timeoutCallback;
        m_fullResponse = "";
        m_response = "";
        ++m_commandNumber;
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(37);if ((m_autoNumber) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(39) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(38);command = Integer.toString(m_commandNumber) + " " + command;}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(40);if ((m_log) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(42) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(41);logOut(command);}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(43);m_out.println(command);
        m_out.flush();
        try
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(44);if ((m_out.checkError()) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(46) && false))
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(45);throwProgramDied();
            }
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(47);if ((m_callback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(49) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(48);m_callback.sentCommand(command);}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(50);readResponse(timeout);
            return m_response;
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(51);e.setCommand(command);
            throw e;
        }
    }

    public void sendPlay(Move move, long timeout,
                         TimeoutCallback timeoutCallback) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(52);send(getCommandPlay(move), timeout, timeoutCallback);
    }

    /** Send comment.
        @param comment comment line (must start with '#'). */
    @Override
	public void sendComment(String comment)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(53);assert comment.trim().startsWith("#");
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(54);if ((m_log) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(56) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(55);logOut(comment);}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(57);if ((m_callback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(59) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(58);m_callback.sentCommand(comment);}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(60);m_out.println(comment);
        m_out.flush();
    }

    /** Enable auto-numbering commands.
        Every command will be prepended by an integer as defined in the GTP
        standard, the integer is incremented after each command. */
    public void setAutoNumber(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(61);m_autoNumber = enable;
    }

    /** Set the callback for invalid responses.
        @see InvalidResponseCallback */
    public void setInvalidResponseCallback(InvalidResponseCallback callback)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(62);m_invalidResponseCallback = callback;
    }

    public void setIOCallback(GtpClient.IOCallback callback)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(63);m_callback = callback;
    }

    /** Set a prefix for logging to standard error.
        Only used if logging was enabled in the constructor. */
    public void setLogPrefix(String prefix)
    {
        synchronized (this)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(64);m_logPrefix = prefix;
        }
    }

    /** Wait until the process of the program exits. */
    @Override
	public void waitForExit()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(65);if ((m_process == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(67) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(66);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(68);m_process.waitFor();
            m_errorThread.join();
            m_inputThread.join();
        }
        catch (InterruptedException e)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(69);printInterrupted();
        }
    }

    /** More sophisticated version of waitFor with timeout. */
    public void waitForExit(int timeout, TimeoutCallback timeoutCallback)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(70);if ((m_process == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(72) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(71);return;}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(73);while (true)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(74);if ((ProcessUtil.waitForExit(m_process, timeout)) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(79) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(78);break;}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(80);if ((! timeoutCallback.askContinue()) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(82) && false))
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(81);m_process.destroy();
                return;
            }
        }
        try
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(76);m_errorThread.join(timeout);
            m_inputThread.join(timeout);
        }
        catch (InterruptedException e)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(77);printInterrupted();
        }
    }

    /** Was program forcefully terminated by calling destroyProcess() */
    public boolean wasKilled()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(83);return m_wasKilled;
    }

    private static final class Message
    {
        public Message(String text)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(84);m_text = text;
        }

        public String m_text;
    }

    private class InputThread
        extends Thread
    {
        InputThread(InputStream in, BlockingQueue<Message> queue)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(85);m_in = new BufferedReader(new InputStreamReader(in));
            m_queue = queue;
        }

        @Override
		public void run()
        {
            try
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(86);mainLoop();
            }
            catch (Throwable t)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(87);StringUtil.printException(t);
            }
        }

        private final BufferedReader m_in;

        private final BlockingQueue<Message> m_queue;

        private final StringBuilder m_buffer = new StringBuilder(1024);

        private void appendBuffer(String line)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(88);m_buffer.append(line);
            m_buffer.append('\n');
        }

        private boolean isResponseStart(String line)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(89);if ((line.length() < 1) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(91) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(90);return false;}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(92);char c = line.charAt(0);
            return (c == '=' || c == '?');
        }

        private void mainLoop() throws InterruptedException
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(93);while (true)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(94);String line = readLine();
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(96);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(98) && false))
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(97);putMessage(null);
                    return;
                }
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(99);appendBuffer(line);
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(100);if ((! isResponseStart(line)) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(102) && false))
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(101);if ((! line.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(104) && false))
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(103);if ((m_callback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(106) && false))
                            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(105);m_callback.receivedInvalidResponse(line);}
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(107);if ((m_invalidResponseCallback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(109) && false))
                            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(108);m_invalidResponseCallback.show(line);}
                    }
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(110);m_buffer.setLength(0);
                    continue;
                }
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(111);while (true)
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(112);line = readLine();
                    appendBuffer(line);
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(114);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(116) && false))
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(115);putMessage(null);
                        return;
                    }
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(117);if ((line.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(119) && false))
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(118);putMessage();
                        break;
                    }
                }
            }
        }

        private void putMessage()
        {
            // Calling Thread.yield increases the probability that the IO
            // callbacks for stderr and stdout are called in the right order
            // for the typical use case of a program writing to stderr
            // before writing the response. The yield costs some performance
            // however and could have a negative effect, if the program
            // writes to stderr immediately after the response (e.g. logging
            // output during pondering).
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(120);Thread.yield();
            putMessage(m_buffer.toString());
            m_buffer.setLength(0);
        }

        private void putMessage(String text)
        {
            try
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(121);m_queue.put(new Message(text));
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(122);printInterrupted();
            }
        }

        private String readLine()
        {
            try
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(123);String line = m_in.readLine();
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(124);if ((m_log && line != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(126) && false))
                    {$qualityscroll_cover_jacov_probe_6ed389108034c57d(125);logIn(line);}
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(127);return line;
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(128);return null;
            }
        }
    }

    private class ErrorThread
        extends Thread
    {
        public ErrorThread(InputStream in, BlockingQueue<Message> queue)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(129);m_in = new InputStreamReader(in);
            m_queue = queue;
        }

        @Override
		public void run()
        {
            try
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(130);char[] buffer = new char[4096];
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(131);while (true)
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(132);int n;
                    try
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(134);n = m_in.read(buffer);
                    }
                    catch (IOException e)
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(145);return;
                    }
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(135);if ((n <= 0) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(137) && false))
                        {$qualityscroll_cover_jacov_probe_6ed389108034c57d(136);return;}
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(138);String text = new String(buffer, 0, n);
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(139);if ((m_callback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(141) && false))
                        {$qualityscroll_cover_jacov_probe_6ed389108034c57d(140);m_callback.receivedStdErr(text);}
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(142);if ((m_log) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(144) && false))
                        {$qualityscroll_cover_jacov_probe_6ed389108034c57d(143);logError(text);}
                }
            }
            catch (Throwable t)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(146);StringUtil.printException(t);
            }
        }

        private final Reader m_in;
    }

    private InvalidResponseCallback m_invalidResponseCallback;

    private boolean m_autoNumber;

    private boolean m_anyCommandsResponded;

    private boolean m_isProgramDead;

    private boolean m_wasKilled;

    private final boolean m_log;

    private int m_commandNumber;

    private IOCallback m_callback;

    private PrintWriter m_out;

    private Process m_process;

    private String m_fullResponse;

    private String m_response;

    private String m_logPrefix;

    private final String m_program;

    private BlockingQueue<Message> m_queue;

    private TimeoutCallback m_timeoutCallback;

    private InputThread m_inputThread;

    private ErrorThread m_errorThread;

    private void init(InputStream in, OutputStream out, InputStream err)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(147);m_out = new PrintWriter(out);
        m_isProgramDead = false;
        m_queue = new ArrayBlockingQueue<Message>(10);
        m_inputThread = new InputThread(in, m_queue);
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(148);if ((err != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(150) && false))
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(149);m_errorThread = new ErrorThread(err, m_queue);
            m_errorThread.start();
        }
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(151);m_inputThread.start();
    }

    private synchronized void logError(String text)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(152);System.err.print(text);
    }

    private synchronized void logIn(String msg)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(153);if ((m_logPrefix != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(155) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(154);System.err.print(m_logPrefix);}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(156);System.err.print("<< ");
        System.err.println(msg);
    }

    private synchronized void logOut(String msg)
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(157);if ((m_logPrefix != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(159) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(158);System.err.print(m_logPrefix);}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(160);System.err.print(">> ");
        System.err.println(msg);
    }

    /** Print information about occurence of InterruptedException.
        An InterruptedException should never happen, because we don't call
        Thread.interrupt */
    private void printInterrupted()
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(161);System.err.println("GtpClient: InterruptedException");
        Thread.dumpStack();
    }

    private String readResponse(long timeout) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(162);while (true)
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(163);Message message = waitForMessage(timeout);
            String response = message.m_text;
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(165);if ((response == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(167) && false))
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(166);m_isProgramDead = true;
                throwProgramDied();
            }
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(168);m_anyCommandsResponded = true;
            boolean error = (response.charAt(0) != '=');
            m_fullResponse = response;
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(169);if ((m_callback != null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(171) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(170);m_callback.receivedResponse(error, m_fullResponse);}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(172);assert response.length() >= 3;
            int index = response.indexOf(' ');
            int length = response.length();
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(173);if ((index < 0) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(175) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(174);m_response = response.substring(1, length - 2);}
            else
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(180);m_response = response.substring(index + 1, length - 2);}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(176);if ((error) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(178) && false))
                {$qualityscroll_cover_jacov_probe_6ed389108034c57d(177);throw new GtpError(m_response);}
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(179);return m_response;
        }
    }

    private void throwProgramDied() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(181);m_isProgramDead = true;
        String name = m_name;
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(182);if ((name == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(184) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(183);name = "The Go program";}
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(185);if ((m_wasKilled) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(187) && false))
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(186);throw new GtpError(name + " terminated.");}
        else
            {$qualityscroll_cover_jacov_probe_6ed389108034c57d(188);throw new GtpError(name + " terminated unexpectedly.");}
    }

    private Message waitForMessage(long timeout) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(189);Message message = null;
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(190);if ((timeout < 0) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(192) && false))
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(191);try
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(193);message = m_queue.take();
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(195);printInterrupted();
                destroyProcess();
                throwProgramDied();
            }
        }
        else
        {
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(196);message = null;
            $qualityscroll_cover_jacov_probe_6ed389108034c57d(197);while ((message == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(199) && false))
            {
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(198);try
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(200);message = m_queue.poll(timeout, TimeUnit.MILLISECONDS);
                }
                catch (InterruptedException e)
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(207);printInterrupted();
                }
                $qualityscroll_cover_jacov_probe_6ed389108034c57d(201);if ((message == null) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(203) && false))
                {
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(202);assert m_timeoutCallback != null;
                    $qualityscroll_cover_jacov_probe_6ed389108034c57d(204);if ((! m_timeoutCallback.askContinue()) ? true : (!$qualityscroll_cover_jacov_probe_6ed389108034c57d(206) && false))
                    {
                        $qualityscroll_cover_jacov_probe_6ed389108034c57d(205);destroyProcess();
                        throwProgramDied();
                    }
                }
            }
        }
        $qualityscroll_cover_jacov_probe_6ed389108034c57d(194);return message;
    }
}
