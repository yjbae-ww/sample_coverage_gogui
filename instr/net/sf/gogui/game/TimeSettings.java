/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// TimeSettings.java

package net.sf.gogui.game;

import net.sf.gogui.util.ErrorMessage;

/** Time settings.
    Time settings consist of a base time for the game and an optional
    overtime (Canadian byoyomi) for overtime periods. Overtime periods also
    have a number of moves assigned, which need to be played during an
    overtime period. The base time can be zero. If no overtime periods are
    used, the whole game must be finished in the base time.
    This class is immutable. */
public final class TimeSettings
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TimeSettings.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5969617874698443373L,/* translation unit id   */ 1125168013823878638L,/* timestamp             */ 1709177900134L,/* source file name      */ "TimeSettings.java",/* probe size            */ 61);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Construct with total time for game.
        @param totalTime Total time for game in milliseconds. */
    public TimeSettings(long totalTime)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(0);assert totalTime > 0;
        m_preByoyomi = totalTime;
        m_byoyomi = 0;
        m_byoyomiMoves = -1;
    }

    /** Construct with base time and overtime.
        @param preByoyomi Base time for game in milliseconds.
        @param byoyomi Time for overtime period in milliseconds.
        @param byoyomiMoves Number of moves per overtime period. */
    public TimeSettings(long preByoyomi, long byoyomi, int byoyomiMoves)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(1);assert preByoyomi >= 0;
        assert byoyomi > 0;
        assert byoyomiMoves > 0;
        m_preByoyomi = preByoyomi;
        m_byoyomi = byoyomi;
        m_byoyomiMoves = byoyomiMoves;
    }

    @Override
	public boolean equals(Object object)
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(2);if ((object == null || object.getClass() != getClass()) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(4) && false))
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(3);return false;}
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(5);TimeSettings settings = (TimeSettings)object;
        return (settings.m_preByoyomi == m_preByoyomi
                && settings.m_byoyomi == m_byoyomi
                && settings.m_byoyomiMoves == m_byoyomiMoves);

    }

    /** Get time for overtime period.
        @return Time for overtime period in milliseconds; undefined if there
        are no overtime periods in this time settings. */
    public long getByoyomi()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(6);assert getUseByoyomi();
        return m_byoyomi;
    }

    /** Get number of moves per overtime period.
        @return Number of moves per overtime period; undefined if there are
        no overtime periods in this time settings. */
    public int getByoyomiMoves()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(7);assert getUseByoyomi();
        return m_byoyomiMoves;
    }

    /** Get base time for game.
        @return Base time for game in milliseconds; this corresponds to
        the total time for the game, if there are no overtime periods. */
    public long getPreByoyomi()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(8);return m_preByoyomi;
    }

    /** Check if overtime periods are used.
        @return True, if overtime periods are used in this time settings. */
    public boolean getUseByoyomi()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(9);return (m_byoyomiMoves > 0);
    }

    /** Hash code dummy function (don't use).
        This class is not desgined to be used in a HashMap/HashTable. The
        function will trigger an assertion if assertions are enabled. */
    @Override
	public int hashCode()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(10);assert false : "hashCode not designed";
        return 0;
    }

    /** Parse time settings from a string.
        The string is expected to be in the format:
        basetime[+overtime/moves] <br>
        The base time and overtime (byoyomi) can have an optional unit
        specifier (m or min for minutes; s or sec for seconds; default is
        minutes).
        @param s The string.
        @return TimeSettings The time settings corresponding to this string.
        @throws ErrorMessage On syntax error or invalid values. */
    public static TimeSettings parse(String s) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(11);boolean useByoyomi = false;
        long preByoyomi = 0;
        long byoyomi = 0;
        int byoyomiMoves = 0;
        int idx = s.indexOf('+');
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(12);if ((idx < 0) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(14) && false))
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(13);preByoyomi = parseTime(s);}
        else
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(28);useByoyomi = true;
            preByoyomi = parseTime(s.substring(0, idx));
            int idx2 = s.indexOf('/');
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(29);if ((idx2 <= idx) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(31) && false))
                {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(30);throw new ErrorMessage("Invalid time specification");}
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(32);byoyomi = parseTime(s.substring(idx + 1, idx2));
            try
            {
                $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(33);byoyomiMoves = Integer.parseInt(s.substring(idx2 + 1));
            }
            catch (NumberFormatException e)
            {
                $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(34);throw new ErrorMessage("Invalid specification for byoyomi"
                                       + " moves");
            }
        }
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(15);if ((preByoyomi <= 0) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(17) && false))
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(16);throw new ErrorMessage("Pre-byoyomi time must be positive");}
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(18);if ((useByoyomi) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(20) && false))
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(19);if ((byoyomi <= 0) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(22) && false))
                {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(21);throw new ErrorMessage("Byoyomi time must be positive");}
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(23);if ((byoyomiMoves <= 0) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(25) && false))
                {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(24);throw new ErrorMessage("Byoyomi moves must be positive");}
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(26);return new TimeSettings(preByoyomi, byoyomi, byoyomiMoves);
        }
        else
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(27);return new TimeSettings(preByoyomi);}
    }

    @Override
	public String toString()
    {
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(35);StringBuilder buffer = new StringBuilder(64);
        buffer.append(toString(m_preByoyomi));
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(36);if ((getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(38) && false))
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(37);buffer.append(" + ");
            buffer.append(toString(m_byoyomi));
            buffer.append(" / ");
            buffer.append(m_byoyomiMoves);
            buffer.append(" moves");
        }
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(39);return buffer.toString();
    }

    private static final long MSEC_PER_MIN = 60000L;

    private static final long MSEC_PER_SEC = 1000L;

    private final long m_preByoyomi;

    private final long m_byoyomi;

    private final int m_byoyomiMoves;

    private static long parseTime(String s) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(40);long factor = MSEC_PER_MIN;
        s = s.trim();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(41);if ((s.endsWith("m")) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(43) && false))
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(42);s = s.substring(0, s.length() - "m".length());}
        else {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(46);if ((s.endsWith("min")) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(48) && false))
            {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(47);s = s.substring(0, s.length() - "min".length());}
        else {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(49);if ((s.endsWith("s")) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(51) && false))
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(50);s = s.substring(0, s.length() - "s".length());
            factor = MSEC_PER_SEC;
        }
        else {$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(52);if ((s.endsWith("sec")) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(54) && false))
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(53);s = s.substring(0, s.length() - "sec".length());
            factor = MSEC_PER_SEC;
        }}}}
        try
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(44);return (Long.parseLong(s.trim()) * factor);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(45);throw new ErrorMessage("Invalid time specification: '" + s + "'");
        }
    }

    private static String toString(long millisec)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(55);StringBuilder buffer = new StringBuilder(64);
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(56);if ((millisec % MSEC_PER_MIN == 0) ? true : (!$qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(58) && false))
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(57);buffer.append(millisec / MSEC_PER_MIN);
            buffer.append(" min");
        }
        else
        {
            $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(60);buffer.append(millisec / MSEC_PER_SEC);
            buffer.append(" sec");
        }
        $qualityscroll_cover_jacov_probe_f9d6658e09aa5ee(59);return buffer.toString();
    }
}
