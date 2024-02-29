/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Server.java

package net.sf.gogui.tools.server;

import net.sf.gogui.util.Options;
import net.sf.gogui.util.ProcessUtil;
import net.sf.gogui.util.StreamCopy;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/** Connects a Go program supporting GTP to a socket. */
public final class Server
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Server.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2490385079809280421L,/* translation unit id   */ -2372507836320626601L,/* timestamp             */ 1709177903454L,/* source file name      */ "Server.java",/* probe size            */ 65);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_df1328b165474857(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Constructor.
        @param verbose Log everything sent and received to stderr
        @param loop Restart program and wait for new connection after
        connection is closed (only for incoming connections)
        @param program Command line for Go program
        @param remoteHost If null then the server waits for incoming
        connections, otherwise it connects to a remote computer with this
        name.
        @param port Port number at remote host
        @param userFile file containing login information that is sent to the
        @param timeout Timeout in seconds, zero for no timeout.
        remote host. Only used if remoteHost is set. */
    public Server(boolean verbose, boolean loop, String program,
                  String remoteHost, int port, String userFile,
                  int timeout)
        throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_df1328b165474857(0);Runtime runtime = Runtime.getRuntime();
        ServerSocket serverSocket = null;
        $qualityscroll_cover_jacov_probe_df1328b165474857(1);if ((remoteHost == null) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(3) && false))
            {$qualityscroll_cover_jacov_probe_df1328b165474857(2);serverSocket = new ServerSocket(port, 1);}
        $qualityscroll_cover_jacov_probe_df1328b165474857(4);while (true)
        {
            $qualityscroll_cover_jacov_probe_df1328b165474857(5);Process process
                = runtime.exec(StringUtil.splitArguments(program));
            Thread stdErrThread = new ProcessUtil.StdErrThread(process);
            stdErrThread.start();
            Socket socket;
            $qualityscroll_cover_jacov_probe_df1328b165474857(10);if ((serverSocket == null) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(12) && false))
                {$qualityscroll_cover_jacov_probe_df1328b165474857(11);socket = connectToRemote(remoteHost, port, userFile);}
            else
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(23);if ((verbose) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(25) && false))
                    {$qualityscroll_cover_jacov_probe_df1328b165474857(24);System.err.println("Waiting for connection...");}
                $qualityscroll_cover_jacov_probe_df1328b165474857(26);socket = serverSocket.accept();
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(13);if ((verbose) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(15) && false))
                {$qualityscroll_cover_jacov_probe_df1328b165474857(14);System.err.println("gogui-server: Connected with "
                                   + socket.getInetAddress());}
            $qualityscroll_cover_jacov_probe_df1328b165474857(16);if ((timeout >= 0) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(18) && false))
                {$qualityscroll_cover_jacov_probe_df1328b165474857(17);socket.setSoTimeout(timeout * 1000);}
            $qualityscroll_cover_jacov_probe_df1328b165474857(19);Thread fromNet =
                new Thread(new StreamCopy(verbose, socket.getInputStream(),
                                          process.getOutputStream(), true));
            Thread toNet =
                new Thread(new StreamCopy(verbose, process.getInputStream(),
                                          socket.getOutputStream(), false));
            fromNet.start();
            toNet.start();
            toNet.join();
            socket.shutdownOutput();
            fromNet.join();
            socket.close();
            process.waitFor();
            $qualityscroll_cover_jacov_probe_df1328b165474857(20);if ((remoteHost != null || ! loop) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(22) && false))
                {$qualityscroll_cover_jacov_probe_df1328b165474857(21);break;}
        }
        $qualityscroll_cover_jacov_probe_df1328b165474857(7);if ((serverSocket != null) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(9) && false))
            {$qualityscroll_cover_jacov_probe_df1328b165474857(8);serverSocket.close();}
    }

    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_df1328b165474857(27);String options[] = {
                "config:",
                "help",
                "loop",
                "port:",
                "remote:",
                "timeout:",
                "user:",
                "verbose",
                "version",
            };
            Options opt = Options.parse(args, options);
            boolean verbose = opt.contains("verbose");
            boolean loop = opt.contains("loop");
            $qualityscroll_cover_jacov_probe_df1328b165474857(28);if ((loop && opt.contains("remote")) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(30) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(29);System.err.println("Option -loop can't be used with -remote");
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(31);if ((opt.contains("help")) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(33) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(32);printUsage(System.out);
                return;
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(34);if ((opt.contains("version")) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(36) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(35);System.out.println("gogui-server " + Version.get());
                return;
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(37);if ((! opt.contains("port")) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(39) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(38);System.err.println("Please specify port with option -port");
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(40);int port = opt.getInteger("port");
            String remoteHost = opt.get("remote", null);
            String userFile = opt.get("user", null);
            int timeout = opt.getInteger("timeout", 0, 0);
            $qualityscroll_cover_jacov_probe_df1328b165474857(41);if ((userFile != null && remoteHost == null) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(43) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(42);System.err.println("Option -user only valid with -remote");
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(44);ArrayList<String> arguments = opt.getArguments();
            $qualityscroll_cover_jacov_probe_df1328b165474857(45);if ((arguments.size() != 1) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(47) && false))
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(46);printUsage(System.err);
                System.exit(1);
            }
            $qualityscroll_cover_jacov_probe_df1328b165474857(48);String program = arguments.get(0);
            new Server(verbose, loop, program, remoteHost, port, userFile,
                       timeout);
        }
        catch (Throwable t)
        {
            $qualityscroll_cover_jacov_probe_df1328b165474857(49);StringUtil.printException(t);
            System.exit(1);
        }
    }

    private static Socket connectToRemote(String remoteHost, int port,
                                          String userFile) throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_df1328b165474857(50);System.err.println("Connecting to " + remoteHost + " " + port);
        Socket socket = new Socket(remoteHost, port);
        $qualityscroll_cover_jacov_probe_df1328b165474857(51);if ((userFile != null) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(53) && false))
        {
            $qualityscroll_cover_jacov_probe_df1328b165474857(52);System.err.println("Sending login information from file "
                               + userFile);
            InputStream inputStream = new FileInputStream(new File(userFile));
            try
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(54);OutputStream outputStream = socket.getOutputStream();
                byte buffer[] = new byte[1024];
                $qualityscroll_cover_jacov_probe_df1328b165474857(55);while (true)
                {
                    $qualityscroll_cover_jacov_probe_df1328b165474857(56);int n = inputStream.read(buffer);
                    $qualityscroll_cover_jacov_probe_df1328b165474857(60);if ((n < 0) ? true : (!$qualityscroll_cover_jacov_probe_df1328b165474857(62) && false))
                        {$qualityscroll_cover_jacov_probe_df1328b165474857(61);break;}
                    $qualityscroll_cover_jacov_probe_df1328b165474857(63);outputStream.write(buffer, 0, n);
                }
            }
            finally
            {
                $qualityscroll_cover_jacov_probe_df1328b165474857(58);inputStream.close();
            }
        }
        $qualityscroll_cover_jacov_probe_df1328b165474857(59);System.err.println("Connected");
        return socket;
    }

    private static void printUsage(PrintStream out)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_df1328b165474857(64);out.print("Usage: gogui-server [options] program\n" +
                  "\n" +
                  "-config  config file\n" +
                  "-help    display this help and exit\n" +
                  "-loop    restart after connection finished\n" +
                  "-port    port of network connection\n" +
                  "-remote  connect to remote host\n" +
                  "-timeout timeout seconds for closing idle connections\n" +
                  "-user    login information for remote host\n" +
                  "-verbose print debugging messages\n" +
                  "-version print version and exit\n");
    }
}
