/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123822) $$ */// SgfUtil.java

package net.sf.gogui.sgf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.gogui.game.TimeSettings;

public final class SgfUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5205785599030017364L,/* translation unit id   */ -6768714879328117508L,/* timestamp             */ 1709177902892L,/* source file name      */ "SgfUtil.java",/* probe size            */ 56);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Result of parseOvertime(). */
    public static final class Overtime
    {
        public long m_byoyomi;

        public int m_byoyomiMoves;
    }

    /** Format byoyomi information for OT property.
        The format is "N moves / S min" or "N moves / S sec"
        This format is also recognized by parseOvertime.
        Returns null, if timeSettings does not define byoyomi */
    public static String getOvertime(TimeSettings timeSettings)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(0);if ((! timeSettings.getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(2) && false))
            {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(1);return null;}
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(3);StringBuilder result = new StringBuilder();
        int byoyomiMoves = timeSettings.getByoyomiMoves();
        long byoyomi = timeSettings.getByoyomi();
        result.append(byoyomiMoves);
        result.append(" moves / ");
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(4);if ((byoyomi % 60000 == 0) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(6) && false))
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(5);result.append(byoyomi / 60000L);
            result.append(" min");
        }
        else
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(8);result.append(byoyomi / 1000L);
            result.append(" sec");
        }
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(7);return result.toString();
    }

    public static Overtime parseOvertime(String value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(9);value = value.trim();
        Overtime result = null;

        /* Used by SgfWriter */
        result =
            parseOvertime(value, "(\\d+)\\s*moves\\s*/\\s*(\\d+)\\s*sec",
                          true, 1000L);
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(10);if ((result != null) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(12) && false))
            {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(11);return result;}

        /* Used by Smart Go */
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(13);result =
            parseOvertime(value, "(\\d+)\\s*moves\\s*/\\s*(\\d+)\\s*min",
                          true, 60000L);
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(14);if ((result != null) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(16) && false))
            {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(15);return result;}

        /* Used by Quarry, CGoban 2 */
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(17);result =
            parseOvertime(value, "(\\d+)/(\\d+)\\s*canadian", true, 1000L);
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(18);if ((result != null) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(20) && false))
            {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(19);return result;}

        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(21);return result;
    }

    /** Parse value of TM property.
        According to FF4, TM needs to be a real value, but older SGF versions
        allow a string with unspecified content. We try to parse a few known
        formats.
        @return The (pre-byoyomi-)time in milliseconds or -1, if the
        format was not recognized */
    public static long parseTime(String value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(22);value = value.trim();
        try
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(23);return (long)(Double.parseDouble(value) * 1000);
        }
        catch (NumberFormatException e1)
        {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(42);
        }
        try
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(24);Pattern pattern;
            Matcher matcher;

            // Pattern as written by CGoban 1.9.12
            pattern = Pattern.compile("(\\d{1,2}):(\\d{2})");
            matcher = pattern.matcher(value);
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(25);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(27) && false))
            {
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(26);assert matcher.groupCount() == 2;
                return (Integer.parseInt(matcher.group(1)) * 60000L
                        + Integer.parseInt(matcher.group(2)) * 1000L);
            }

            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(28);pattern = Pattern.compile("(\\d+):(\\d{2}):(\\d{2})");
            matcher = pattern.matcher(value);
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(29);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(31) && false))
            {
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(30);assert matcher.groupCount() == 3;
                return (Integer.parseInt(matcher.group(1)) * 3600000L
                        + Integer.parseInt(matcher.group(2)) * 60000L
                        + Integer.parseInt(matcher.group(3)) * 1000L);
            }

            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(32);pattern =
                Pattern.compile("(\\d+)\\s*(?:h|hr|hrs|hours|hours)(?:\\s+each)?+");
            matcher = pattern.matcher(value);
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(33);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(35) && false))
            {
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(34);assert matcher.groupCount() == 1;
                return Integer.parseInt(matcher.group(1)) * 3600000L;
            }

            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(36);pattern =
                Pattern.compile("(\\d+)\\s*(?:m|min)");
            matcher = pattern.matcher(value);
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(37);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(39) && false))
            {
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(38);assert matcher.groupCount() == 1;
                return Integer.parseInt(matcher.group(1)) * 60000L;
            }
        }
        catch (NumberFormatException e2)
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(41);assert false; // patterns should match only valid integers
        }
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(40);return -1;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private SgfUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(43);
    }

    private static Overtime parseOvertime(String value, String regex,
                                          boolean byoyomiMovesFirst,
                                          long timeUnitFactor)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(44);Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(45);if ((matcher.matches()) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(47) && false))
        {
            $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(46);assert matcher.groupCount() == 2;
            try
            {
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(48);String group1;
                String group2;
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(49);if ((byoyomiMovesFirst) ? true : (!$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(51) && false))
                {
                    $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(50);group1 = matcher.group(1);
                    group2 = matcher.group(2);
                }
                else
                {
                    $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(53);group1 = matcher.group(2);
                    group2 = matcher.group(1);
                }
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(52);Overtime overtime = new Overtime();
                overtime.m_byoyomiMoves = Integer.parseInt(group1);
                overtime.m_byoyomi =
                    (long)(Double.parseDouble(group2) * timeUnitFactor);
                return overtime;
            }
            catch (NumberFormatException e)
            {
                // should not happen if patterns match only integer
                $qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(54);assert false;
                return null;
            }
        }
        else
            {$qualityscroll_cover_jacov_probe_a210b1adefbf1cfc(55);return null;}
    }
}
