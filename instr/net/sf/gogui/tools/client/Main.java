/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Main.java

package net.sf.gogui.tools.client;

import net.sf.gogui.util.Options;
import net.sf.gogui.util.StreamCopy;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

/** Connects to a remote Go program supporting GTP. */
public final class Main
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Main.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 331127650146578275L,/* translation unit id   */ -6689919685582472065L,/* timestamp             */ 1709177903180L,/* source file name      */ "Main.java",/* probe size            */ 37);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}private static Socket connect(String hostname, int port, int timeout)
        throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(0);int totalTime = 0;
        $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(1);while (true)
        {
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(2);try
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(4);return new Socket(hostname, port);
            }
            catch (ConnectException connectException)
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(5);if ((totalTime >= timeout) ? true : (!$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(7) && false))
                    {$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(6);throw connectException;}
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(8);String text = "Connect failed; retrying in 5 sec...";
                System.err.println(text);
                try
                {
                    $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(9);Thread.sleep(5000);
                }
                catch (InterruptedException interruptedException)
                {$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(11);
                }
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(10);totalTime += 5;
            }
        }
    }

    public Main(String hostname, int port, int timeout) throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(12);Socket socket = connect(hostname, port, timeout);
        Thread fromNet =
            new Thread(new StreamCopy(false, socket.getInputStream(),
                                      System.out, false));
        SocketOutputCopy toNet = new SocketOutputCopy(socket);
        fromNet.start();
        toNet.start();
        fromNet.join();
        // Actually I would expect that
        //   System.in.close();
        //   toNet.join();
        //   socket.close();
        // is good enough to terminate thread toNet, but the read on System.in
        // blocks even after a close(). Also it seems not to be possible to
        // use java.nio and have System.in as a interruptible channel. So
        // System.exit() is called to kill this thread. If you find a cleaner
        // solution to terminate both threads, please tell me.
        // The two possible reasons for termination of gogui-client are:
        // - System.in reaches EOF (no more GTP input)
        // - socket input stream reaches EOF (server closes connection
        //   after response to a quit command)
        System.exit(0);
    }

    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(13);String options[] = {
                "config:",
                "help",
                "timeout:",
                "version"
            };
            Options opt = Options.parse(args, options);
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(14);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(16) && false))
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(15);printUsage(System.out);
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(17);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(19) && false))
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(18);System.out.println("gogui-client " + Version.get());
                System.exit(0);
            }
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(20);int timeout = opt.getInteger("timeout", 10, 0);
            ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(21);if ((arguments.size() != 2) ? true : (!$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(23) && false))
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(22);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(24);String hostname = arguments.get(0);
            int port = Integer.parseInt(arguments.get(1));
            new Main(hostname, port, timeout);
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(25);StringUtil.printException(t);
            System.exit(1);
        }
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(26);String text =
            "Usage: gogui-client [options] hostname port\n" +
            "\n" +
            "-config  config file\n" +
            "-help    display this help and exit\n" +
            "-timeout stop trying to connect after n seconds (default 10)\n" +
            "-version print version and exit\n";
        out.print(text);
    }
}

class SocketOutputCopy
    extends Thread
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SocketOutputCopy.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 331127650146578275L,/* translation unit id   */ -6689919685582472065L,/* timestamp             */ 1709177903180L,/* source file name      */ "Main.java",/* probe size            */ 37);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public SocketOutputCopy(Socket socket)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(27);m_socket = socket;
    }

    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(28);InputStream src = System.in;
            OutputStream dest = m_socket.getOutputStream();
            byte buffer[] = new byte[1024];
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(29);while (true)
            {
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(30);int n = src.read(buffer);
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(32);if ((n < 0) ? true : (!$qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(34) && false))
                {
                    $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(33);m_socket.shutdownOutput();
                    break;
                }
                $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(35);dest.write(buffer, 0, n);
                dest.flush();
            }
        }
        catch (Throwable e)
        {
            $qualityscroll_cover_jacov_probe_a328a17d9cf6bc7f(36);StringUtil.printException(e);
        }
    }

    private final Socket m_socket;
}
