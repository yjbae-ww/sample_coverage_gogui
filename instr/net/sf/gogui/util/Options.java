/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// Options.java

package net.sf.gogui.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

/** Parser for command line options.
    Options begin with a single '-' character. */
public class Options
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Options.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -487851980859177284L,/* translation unit id   */ 4411645875350773365L,/* timestamp             */ 1709177904049L,/* source file name      */ "Options.java",/* probe size            */ 100);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_3d39508cbb199e75(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Parse options.
        @param args Command line args from main method
        @param specs Specification of allowed options. Contains option names
        (without '-'). Options that need an argument must have a ':' appended.
        The special argument '--' stops option parsing, all following
        arguments are treated as non-option arguments.
        @throws ErrorMessage If options are not valid according to specs. */
    public Options(String[] args, String[] specs) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(0);for (String spec : specs)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(2);if ((spec.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(4) && false))
                {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(3);m_map.put(spec, null);}
        }
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(1);parseArgs(args);
    }

    /** Check if option is present. */
    public boolean contains(String option)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(5);String value = get(option, null);
        return (value != null);
    }

    /** Return string option value.
        @param option The option key.
        @return The option value or en empty string, if option is not
        present. */
    public String get(String option)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(6);return get(option, "");
    }

    /** Return string option value.
        @param option The option key.
        @param defaultValue The default value.
        @return The option value or defaultValue, if option is not present. */
    public String get(String option, String defaultValue)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(7);assert isValidOption(option);
        String value = getValue(option);
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(8);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(10) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(9);return defaultValue;}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(11);return value;
    }

    /** Get remaining arguments that are not options.
        @return The sequence of non-option arguments. */
    public ArrayList<String> getArguments()
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(12);return m_args;
    }

    /** Check that the number of non-option arguments is zero.
        @throws ErrorMessage If there are any non-option arguments. */
    public void checkNoArguments() throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(13);if ((! m_args.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(15) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(14);throw new ErrorMessage(
                      "Command does not allow arguments that are not options");}
    }

    /** Parse double option.
        @param option The option key.
        @return The option value or 0, if option is not present.
        @throws ErrorMessage If option value is not a double. */
    public double getDouble(String option) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(16);return getDouble(option, 0);
    }

    /** Parse double option.
        @param option The option key.
        @param defaultValue The default value.
        @return The option value or defaultValue, if option is not present.
        @throws ErrorMessage If option value is not a double. */
    public double getDouble(String option, double defaultValue)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(17);String value = get(option, Double.toString(defaultValue));
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(18);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(20) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(19);return defaultValue;}
        try
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(21);return Double.parseDouble(value);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(22);throw new ErrorMessage("Option -" + option
                                   + " needs float value");
        }
    }

    /** Parse integer option.
        @param option The option key.
        @return The option value or 0, if option is not present.
        @throws ErrorMessage If option value is not an integer. */
    public int getInteger(String option) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(23);return getInteger(option, 0);
    }

    /** Parse integer option.
        @param option The option key.
        @param defaultValue The default value.
        @return The option value or defaultValue, if option is not present.
        @throws ErrorMessage If option value is not an integer. */
    public int getInteger(String option, int defaultValue) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(24);String value = get(option, Integer.toString(defaultValue));
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(25);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(27) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(26);return defaultValue;}
        try
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(28);return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(29);throw new ErrorMessage("Option -" + option
                                   + " needs integer value");
        }
    }

    /** Parse integer option with range check.
        @param option The option key.
        @param defaultValue The default value.
        @param min The minimum valid value.
        @return The option value or defaultValue, if option is not present.
        @throws ErrorMessage If option value is less than min. */
    public int getInteger(String option, int defaultValue, int min)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(30);int value = getInteger(option, defaultValue);
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(31);if ((value < min) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(33) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(32);throw new ErrorMessage("Option -" + option
                                   + " must be greater than " + min);}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(34);return value;
    }

    /** Parse integer option with range check.
        @param option The option key.
        @param defaultValue The default value.
        @param min The minimum valid value.
        @param max The maximum valid value.
        @return The option value or defaultValue, if option is not present.
        @throws ErrorMessage If option value is less than min or greater than
        max. */
    public int getInteger(String option, int defaultValue, int min, int max)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(35);int value = getInteger(option, defaultValue);
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(36);if ((value < min || value > max) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(38) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(37);throw new ErrorMessage("Option -" + option + " must be in ["
                                   + min + ".." + max + "]");}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(39);return value;
    }

    /** Parse long integer option.
        @param option The option key.
        @return The option value or 0, if option is not present.
        @throws ErrorMessage If option value is not a long integer. */
    public long getLong(String option) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(40);return getLong(option, 0L);
    }

    /** Parse long integer  option.
        @param option The option key.
        @param defaultValue The default value.
        @return The option value or defaultValue, if option is not present.
        @throws ErrorMessage If option value is not a long integer. */
    public long getLong(String option, long defaultValue) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(41);String value = get(option, Long.toString(defaultValue));
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(42);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(44) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(43);return defaultValue;}
        try
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(45);return Long.parseLong(value);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(46);throw new ErrorMessage("Option -" + option
                                   + " needs long integer value");
        }
    }

    /** Read options from a file given with the option "config".
        Requires that "config" is an allowed option.
        @throws ErrorMessage If options in file are not valid according to
        the specification. */
    public void handleConfigOption() throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(47);if ((! contains("config")) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(49) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(48);return;}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(50);String filename = get("config");
        InputStream inputStream;
        try
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(51);inputStream = new FileInputStream(filename);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(65);throw new ErrorMessage("File not found: " + filename);
        }
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(52);Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(53);StringBuilder buffer = new StringBuilder(256);
            String line;
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(54);while (true)
            {
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(55);line = bufferedReader.readLine();
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(60);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(62) && false))
                    {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(61);break;}
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(63);buffer.append(line);
                buffer.append(' ');
            }
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(57);parseArgs(StringUtil.splitArguments(buffer.toString()));
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(64);StringUtil.printException(e);
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(58);bufferedReader.close();
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(59);StringUtil.printException(e);
            }
        }
    }

    /** Creates a new Options instance from command line.
        Automatically calls handleConfigOption.
        @param args The command line split into arguments.
        @param specs Option specification as in constructor.
        @return The new Options instance.
        @throws ErrorMessage If options are not valid according to specs. */
    public static Options parse(String[] args, String[] specs)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(66);Options opt = new Options(args, specs);
        opt.handleConfigOption();
        return opt;
    }

    private final ArrayList<String> m_args = new ArrayList<String>();

    private final Map<String,String> m_map = new TreeMap<String,String>();

    private String getSpec(String option) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(67);if ((m_map.containsKey(option)) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(69) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(68);return option;}
        else {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(70);if ((m_map.containsKey(option + ":")) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(72) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(71);return option + ":";}}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(73);throw new ErrorMessage("Unknown option -" + option);
    }

    private String getValue(String option)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(74);assert isValidOption(option);
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(75);if ((m_map.containsKey(option)) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(77) && false))
            {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(76);return m_map.get(option);}
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(78);return m_map.get(option + ":");
    }

    private boolean isOptionKey(String s)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(79);return (s.length() > 0 && s.charAt(0) == '-');
    }

    private boolean isValidOption(String option)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(80);return (m_map.containsKey(option) || m_map.containsKey(option + ":"));
    }

    private boolean needsValue(String spec)
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(81);return (spec.length() > 0
                && spec.substring(spec.length() - 1).equals(":"));
    }

    private void parseArgs(String args[]) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(82);boolean stopParse = false;
        int n = 0;
        $qualityscroll_cover_jacov_probe_3d39508cbb199e75(83);while ((n < args.length) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(85) && false))
        {
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(84);String s = args[n];
            ++n;
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(86);if ((s.equals("--")) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(88) && false))
            {
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(87);stopParse = true;
                continue;
            }
            $qualityscroll_cover_jacov_probe_3d39508cbb199e75(89);if ((isOptionKey(s) && ! stopParse) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(91) && false))
            {
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(90);String spec = getSpec(s.substring(1));
                $qualityscroll_cover_jacov_probe_3d39508cbb199e75(92);if ((needsValue(spec)) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(94) && false))
                {
                    $qualityscroll_cover_jacov_probe_3d39508cbb199e75(93);if ((n >= args.length) ? true : (!$qualityscroll_cover_jacov_probe_3d39508cbb199e75(96) && false))
                        {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(95);throw new ErrorMessage("Option " + s
                                               + " needs value");}
                    $qualityscroll_cover_jacov_probe_3d39508cbb199e75(97);String value = args[n];
                    ++n;
                    m_map.put(spec, value);
                }
                else
                    {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(98);m_map.put(spec, "1");}

            }
            else
                {$qualityscroll_cover_jacov_probe_3d39508cbb199e75(99);m_args.add(s);}
        }
    }
}
