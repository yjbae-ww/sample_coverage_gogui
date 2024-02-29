/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpClientUtil.java

package net.sf.gogui.gtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import net.sf.gogui.go.Move;
import static net.sf.gogui.gtp.AnalyzeUtil.getParameterCommand;
import static net.sf.gogui.gtp.AnalyzeUtil.parseParameterLine;
import net.sf.gogui.util.ErrorMessage;

/** Utility functions for using a GtpClient. */
public final class GtpClientUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpClientUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2171217495317066964L,/* translation unit id   */ 2086633299496659581L,/* timestamp             */ 1709177901469L,/* source file name      */ "GtpClientUtil.java",/* probe size            */ 61);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Query analyze commands configuration from the program.
        Sends the command gogui-analyze_commands (or gogui_analyze_commands
        as used by older versions of GoGui, if the program does not support
        the new command).
        Note: call GtpClientBase.querySupportedCommands() first.
        @return The response to gogui-analyze_commands or null, if this
        command is not supported or returns an error. */
    public static String getAnalyzeCommands(GtpClientBase gtp)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(0);String command;
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(1);if ((gtp.isSupported("gogui-analyze_commands")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(3) && false))
            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(2);command = "gogui-analyze_commands";}
        else {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(6);if ((gtp.isSupported("gogui_analyze_commands")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(8) && false))
            // Used by old versions of GoGui
            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(7);command = "gogui_analyze_commands";}
        else
            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(9);return null;}}
        try
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(4);return gtp.send(command);
        }
        catch (GtpError e)
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(5);return null;
        }
    }

    /** Construct a gogui-play_sequence command from a list of moves. */
    public static String getPlaySequenceCommand(GtpClientBase gtp,
                                                ArrayList<Move> moves)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(10);assert isPlaySequenceSupported(gtp);
        StringBuilder cmd = new StringBuilder(2048);
        cmd.append(getPlaySequenceCommand(gtp));
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(11);for (int i = 0; (i < moves.size()) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(13) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(12);cmd.append(' ');
            cmd.append(moves.get(i));
        }
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(14);return cmd.toString();
    }

    public static String getPlaySequenceCommand(GtpClientBase gtp)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(15);if ((gtp.isSupported("gogui-play_sequence")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(17) && false))
            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(16);return "gogui-play_sequence";}
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(18);if ((gtp.isSupported("play_sequence")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(20) && false))
            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(19);return "play_sequence";}
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(21);return null;
    }

    /** Get title for current game from program.
        Uses gogui-title (see GoGui documentation) or the deprectated
        command gogui_title.
        Note: call GtpClientBase.querySupportedCommands() first.
        @return The response to the command or null, if neither command
        is supported or the command failed. */
    public static String getTitle(GtpClientBase gtp)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(22);if ((gtp.isSupported("gogui-title")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(24) && false))
                {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(23);return gtp.send("gogui-title");}
            else {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(25);if ((gtp.isSupported("gogui_title")) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(27) && false))
                {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(26);return gtp.send("gogui_title");}}
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(29);
        }
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(28);return null;
    }

    public static boolean isPlaySequenceSupported(GtpClientBase gtp)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(30);return (getPlaySequenceCommand(gtp) != null);
    }

    /** Save parameters to a GTP file.
        Sends all analyze commands of type "param" to the program to query the
        current parameter values and creates a config file with GTP commands
        that allows to restore the values.
        @param gtp The GTP connection.
        @param analyzeCommands The analyze command definitions for this
        program (e.g. from AnalyzeDefinition.read()).
        @throws ErrorMessage If writing the file fails or none of the analyze
        commands have the type "param" (error responses from the program are
        written in comment lines in the resulting file).
        See GoGui documentation, chapter "Analyze Commands" */
    public static void
        saveParameters(GtpClientBase gtp,
                       ArrayList<AnalyzeDefinition> analyzeCommands,
                       File file) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(31);PrintStream out = null;
        try
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(32);out = new PrintStream(file);
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(33);for (AnalyzeDefinition definition : analyzeCommands)
                {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(37);if ((definition.getType() == AnalyzeType.PARAM) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(39) && false))
                {
                    $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(38);out.print("# ");
                    out.println(definition.getLabel());
                    String response;
                    try
                    {
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(40);response = gtp.send(definition.getCommand());
                    }
                    catch (GtpError e)
                    {
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(54);out.print("# ? ");
                        out.println(e.getMessage());
                        out.println();
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(55);if ((gtp.isProgramDead()) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(57) && false))
                            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(56);throw new ErrorMessage("The Go program has" +
                                                   " terminated.");}
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(58);continue;
                    }
                    $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(41);BufferedReader reader
                        = new BufferedReader(new StringReader(response));
                    $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(42);while (true)
                    {
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(43);String line = reader.readLine();
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(46);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(48) && false))
                            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(47);break;}
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(49);AnalyzeUtil.Result result = parseParameterLine(line);
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(50);if ((result == null) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(52) && false))
                            {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(51);continue;}
                        $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(53);String command =
                            getParameterCommand(definition.getCommand(),
                                                result.m_key, result.m_value);
                        out.println(command);
                    }
                    $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(45);out.println();
                }}
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(59);throw new ErrorMessage(e.getMessage());
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(34);if ((out != null) ? true : (!$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(36) && false))
                {$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(35);out.close();}
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private GtpClientUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_1cf535ee30ffea7d(60);
    }
}
