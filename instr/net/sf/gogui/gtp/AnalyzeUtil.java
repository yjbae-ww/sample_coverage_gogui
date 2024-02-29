/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// AnalyzeUtil.java

package net.sf.gogui.gtp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public final class AnalyzeUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = AnalyzeUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 3786867765164867826L,/* translation unit id   */ 4924684577480232182L,/* timestamp             */ 1709177901321L,/* source file name      */ "AnalyzeUtil.java",/* probe size            */ 27);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Result of AnalyzeUtil.parseParameterLine(). */
    public static final class Result
    {
        public ParameterType m_type;

        /** Complete type metainformation. */
        public String m_typeInfo;

        public String m_key;

        public String m_value;
    }

    /** Get command for setting a parameter.
        See chapter "Analyze Commands" of the GoGui documentation. */
    public static String getParameterCommand(String command, String key,
                                             String value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(0);return command + " " + key + " " + value;
    }

    public static boolean
        hasParameterCommands(ArrayList<AnalyzeDefinition> analyzeCommands)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(1);for (AnalyzeDefinition definition : analyzeCommands)
            {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(3);if ((definition.getType() == AnalyzeType.PARAM) ? true : (!$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(5) && false))
                {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(4);return true;}}
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(2);return false;
    }

    /** Parse a line in the response of an analyze command of type "param".
        See chapter "Analyze Commands" of the GoGui documentation.
        @return The result or null, if line could not be parsed. */
    public static Result parseParameterLine(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(6);line = line.trim();
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(7);if ((line.startsWith("[") && line.endsWith("]")) ? true : (!$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(9) && false))
        {
            // Might be used as label for grouping parameters on tabbing
            // panes in a later version of GoGui, so we silently accept it
            $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(8);return null;
        }
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(10);Scanner scanner = new Scanner(line);
        Result result = new Result();
        try
        {
            $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(11);result.m_typeInfo = scanner.next("^\\[[^\\]]*\\]");
            line = line.substring(result.m_typeInfo.length()).trim();
            result.m_typeInfo =
                result.m_typeInfo.substring(1, result.m_typeInfo.length() - 1);
        }
        catch (NoSuchElementException e)
        {
            // Treat unknown types as string for compatibiliy with future
            // types
            $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(25);result.m_typeInfo = "string";
        }
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(12);int pos = line.indexOf(' ');
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(13);if ((pos < 0) ? true : (!$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(15) && false))
        {
            $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(14);result.m_key = line.trim();
            result.m_value = "";
        }
        else
        {
            $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(24);result.m_key = line.substring(0, pos).trim();
            result.m_value = line.substring(pos + 1).trim();
        }
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(16);if ((result.m_typeInfo.equals("bool")) ? true : (!$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(18) && false))
            {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(17);result.m_type = ParameterType.BOOL;}
        else {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(20);if ((result.m_typeInfo.startsWith("list/")) ? true : (!$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(22) && false))
            {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(21);result.m_type = ParameterType.LIST;}
        else
            // Treat unknown types as string for compatibiliy with future
            // types
            {$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(23);result.m_type = ParameterType.STRING;}}
        $qualityscroll_cover_jacov_probe_4457fe87f78dccf6(19);return result;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private AnalyzeUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_4457fe87f78dccf6(26);
    }
}
