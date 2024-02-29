/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// ProcessUtil.java

package net.sf.gogui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class ExitWaiter
    extends Thread
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ExitWaiter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1791550152350610138L,/* translation unit id   */ 7920554082132716256L,/* timestamp             */ 1709177904110L,/* source file name      */ "ProcessUtil.java",/* probe size            */ 24);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ExitWaiter(Object monitor, Process process)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(0);m_monitor = monitor;
        m_process = process;
    }

    public boolean isFinished()
    {
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(1);return m_isFinished;
        }
    }

    @Override
	public void run()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(2);m_process.waitFor();
        }
        catch (InterruptedException e)
        {$qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(5);
        }
        synchronized (m_mutex)
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(3);m_isFinished = true;
        }
        synchronized (m_monitor)
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(4);m_monitor.notifyAll();
        }
    }

    private boolean m_isFinished;

    private final Object m_monitor;

    private final Object m_mutex = new Object();

    private final Process m_process;
};

/** Static utility functions and classes related to processes. */
public class ProcessUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ProcessUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1791550152350610138L,/* translation unit id   */ 7920554082132716256L,/* timestamp             */ 1709177904110L,/* source file name      */ "ProcessUtil.java",/* probe size            */ 24);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Copies standard error of a process to System.err. */
    public static class StdErrThread
        extends Thread
    {
        public StdErrThread(Process process)
        {
            super(new StreamCopy(false, process.getErrorStream(), System.err,
                                 false));$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(6);
        }
    }

    /** Run a process and return its standard output as a string. */
    public static String runCommand(String[] cmdArray) throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(7);Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmdArray);
        Thread discardErr = new StreamDiscard(process.getErrorStream());
        discardErr.start();
        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(8);StringBuilder result = new StringBuilder();
            String line;
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(9);while (((line = reader.readLine()) != null) ? true : (!$qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(11) && false))
            {
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(10);result.append(line);
                result.append('\n');
            }
            try
            {
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(12);if ((process.waitFor() != 0) ? true : (!$qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(14) && false))
                    {$qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(13);throw new IOException("Process returned error status");}
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(16);throw new IOException("InterruptedException");
            }
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(15);return result.toString();
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(17);reader.close();
        }
    }

    /** Run a process.
        Forwards the stdout/stderr of the child process to stderr of the
        calling process. */
    public static void runProcess(String[] cmdArray) throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(18);Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmdArray);
        Thread copyOut =
            new Thread(new StreamCopy(false, process.getInputStream(),
                                      System.err, false));
        copyOut.start();
        Thread copyErr =
            new Thread(new StreamCopy(false, process.getErrorStream(),
                                      System.err, false));
        copyErr.start();
    }

    public static boolean waitForExit(Process process, long timeout)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(19);Object monitor = new Object();
        ExitWaiter exitWaiter = new ExitWaiter(monitor, process);
        synchronized (monitor)
        {
            $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(20);exitWaiter.start();
            try
            {
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(21);monitor.wait(timeout);
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(22);return exitWaiter.isFinished();
            }
            catch (InterruptedException e)
            {
                $qualityscroll_cover_jacov_probe_6deb75f909ca6ae0(23);return false;
            }
        }
    }
}
