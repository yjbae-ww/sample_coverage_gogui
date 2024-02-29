/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// StringUtil.java

package net.sf.gogui.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ArrayList;

/** Static utility functions related to strings. */
public final class StringUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = StringUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7932599342093635620L,/* translation unit id   */ -2896868489615706395L,/* timestamp             */ 1709177904172L,/* source file name      */ "StringUtil.java",/* probe size            */ 103);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Capitalize the first word and trim whitespaces. */
    public static String capitalize(String message)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(0);message = message.trim();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(1);if ((message.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(3) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(2);return message;}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(4);StringBuilder buffer = new StringBuilder(message);
        char first = buffer.charAt(0);
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(5);if ((! Character.isUpperCase(first)) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(7) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(6);buffer.setCharAt(0, Character.toUpperCase(first));}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(8);return buffer.toString();
    }

    /** Format elapsed time as [[h+]:[mm]]:ss. */
    public static String formatTime(long seconds)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(9);StringBuilder buffer = new StringBuilder(8);
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(10);if ((seconds < 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(12) && false))
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(11);buffer.append('-');
            seconds *= -1;
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(13);long hours = seconds / 3600;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(14);if ((hours > 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(16) && false))
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(15);if ((hours > 9999) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(18) && false))
                // Extremely large numbers are likely a problem in
                // Date.getTime(), as it can happen when running in the
                // netbeans profiler (version 5.5)
                {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(17);return "--:--";}
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(19);buffer.append(hours);
            buffer.append(':');
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(20);seconds %= 3600;
        long minutes = seconds / 60;
        seconds %= 60;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(21);if ((minutes >= 10) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(23) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(22);buffer.append(minutes);}
        else
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(30);buffer.append('0');
            buffer.append(minutes);
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(24);buffer.append(':');
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(25);if ((seconds >= 10) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(27) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(26);buffer.append(seconds);}
        else
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(29);buffer.append('0');
            buffer.append(seconds);
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(28);return buffer.toString();
    }

    /** Return the current time and date as a string using a long format.
        The time and date is formatted using DateFormat.LONG and
        Locale.ENGLISH. */
    public static String getDate()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(31);DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG,
                                                           DateFormat.LONG,
                                                           Locale.ENGLISH);
        Date date = Calendar.getInstance().getTime();
        return format.format(date);
    }

    /** Return the current time and date as a string using a short format.
        The time and date is formatted using DateFormat.SHORT and
        Locale.ENGLISH. */
    public static String getDateShort()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(32);DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                                                           DateFormat.SHORT,
                                                           Locale.ENGLISH);
        Date date = Calendar.getInstance().getTime();
        return format.format(date);
    }

    /** Get default encoding. */
    public static String getDefaultEncoding()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(33);String encoding = System.getProperty("file.encoding");
        // Java 1.5 docs for System.getProperties do not guarantee the
        // existance of file.encoding
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(34);if ((encoding != null) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(36) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(35);return encoding;}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(37);OutputStreamWriter out =
            new OutputStreamWriter(new ByteArrayOutputStream());
        return out.getEncoding();
    }

    /** Return a printable error message for an exception.
        Returns the error message is for instances of ErrorMessage or
        for other exceptions the class name with the exception message
        appended, if not empty. */
    public static String getErrorMessage(Throwable e)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(38);String message = e.getMessage();
        boolean hasMessage = ! StringUtil.isEmpty(message);
        String className = e.getClass().getName();
        String result;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(39);if ((e instanceof ErrorMessage) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(41) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(40);result = message;}
        else {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(43);if ((hasMessage) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(45) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(44);result = className + ":\n" + message;}
        else
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(46);result = className;}}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(42);return result;
    }

    /** Return a number formatter with maximum fraction digits,
        no grouping, locale ENGLISH. */
    public static NumberFormat getNumberFormat(int maximumFractionDigits)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(47);NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        format.setMaximumFractionDigits(maximumFractionDigits);
        format.setGroupingUsed(false);
        return format;
    }

    /** Check if string is null, empty, or contains only whitespaces. */
    public static boolean isEmpty(String s)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(48);if ((s == null) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(50) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(49);return true;}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(51);for (int i = 0; (i < s.length()) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(53) && false); ++i)
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(52);if ((! Character.isWhitespace(s.charAt(i))) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(56) && false))
                {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(55);return false;}}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(54);return true;
    }

    /** Print exception to standard error.
        Prints the class name and message to standard error.
        For exceptions of type Error or RuntimeException, a stack trace
        is printed in addition.
        @return A slightly differently formatted error message
        for display in an error dialog. */
    public static String printException(Throwable exception)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(57);String result = getErrorMessage(exception);
        System.err.println(result);
        boolean isSevere = (exception instanceof RuntimeException
                            || exception instanceof Error);
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(58);if ((isSevere) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(60) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(59);exception.printStackTrace();}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(61);return result;
    }

    /** Split string into tokens. */
    public static String[] split(String s, char separator)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(62);int count = 1;
        int pos = -1;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(63);while (((pos = s.indexOf(separator, pos + 1)) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(65) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(64);++count;}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(66);String result[] = new String[count];
        pos = 0;
        int newPos;
        int i = 0;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(67);while (((newPos = s.indexOf(separator, pos)) >= 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(69) && false))
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(68);result[i] = s.substring(pos, newPos);
            ++i;
            pos = newPos + 1;
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(70);result[i] = s.substring(pos);
        return result;
    }

    /** Split command line into arguments.
        Allows " for words containing whitespaces. */
    public static String[] splitArguments(String string)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(71);assert string != null;
        ArrayList<String> result = new ArrayList<String>();
        boolean escape = false;
        boolean inString = false;
        StringBuilder token = new StringBuilder();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(72);for (int i = 0; (i < string.length()) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(74) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(73);char c = string.charAt(i);
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(79);if ((c == '"' && ! escape) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(81) && false))
            {
                $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(80);if ((inString) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(83) && false))
                {
                    $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(82);result.add(token.toString());
                    token.setLength(0);
                }
                $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(84);inString = ! inString;
            }
            else {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(86);if ((Character.isWhitespace(c) && ! inString) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(88) && false))
            {
                $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(87);if ((token.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(90) && false))
                {
                    $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(89);result.add(token.toString());
                    token.setLength(0);
                }
            }
            else
                {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(91);token.append(c);}}
            $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(85);escape = (c == '\\' && ! escape);
        }
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(75);if ((token.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(77) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(76);result.add(token.toString());}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(78);return result.toArray(new String[result.size()]);
    }

    /** Trim trailing whitespaces. */
    public static String trimTrailing(String s)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(92);int i;
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(93);for (i = s.length() - 1; (i >= 0) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(95) && false); --i)
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(94);if ((! Character.isWhitespace(s.charAt(i))) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(101) && false))
                {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(100);break;}}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(96);if ((i <= 0 || i == s.length() - 1) ? true : (!$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(98) && false))
            {$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(97);return s;}
        $qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(99);return s.substring(0, i + 1);
    }

    /** Make constructor unavailable; class is for namespace only. */
    private StringUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d7cc4174fb6ef6e5(102);
    }
}
