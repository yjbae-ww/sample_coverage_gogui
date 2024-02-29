/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// Clock.java

package net.sf.gogui.game;

import java.util.TimerTask;
import java.util.Timer;
import net.sf.gogui.go.BlackWhiteSet;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.util.StringUtil;

/** Time control for a Go game.
    If the clock is not initialized with Clock.setTimeSettings, the clock
    will count upwards, otherwise the time settings with main and/or
    byoyomi time are used. The time unit is milliseconds. */
public final class Clock
    implements ConstClock
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Clock.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1707107241083558688L,/* translation unit id   */ 3943839259758188415L,/* timestamp             */ 1709177899768L,/* source file name      */ "Clock.java",/* probe size            */ 123);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_36bb54e95120577f(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Provides the time for a clock. */
    public interface TimeSource
    {
        long currentTimeMillis();
    }

    /** Time source using the system time. */
    public static final class SystemTimeSource
        implements TimeSource
    {
        @Override
		public long currentTimeMillis()
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(0);return System.currentTimeMillis();
        }
    }

    /** Listener to clock changes.
        This function will be called from a different thread at regular
        intervals. */
    public interface Listener
    {
        void clockChanged();
    }

    public Clock()
    {
        this(new SystemTimeSource());$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_36bb54e95120577f(1);
    }

    public Clock(TimeSource timeSource)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(2);m_timeSource = timeSource;
        reset();
    }

    /** Get moves left.
        Requires: getUseByoyomi() and isInByoyomi(color) */
    @Override
	public int getMovesLeft(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(3);assert getUseByoyomi() && isInByoyomi(color);
        return getRecord(color).m_movesLeft;
    }

    /** Get time left.
        Requires: isInitialized() */
    @Override
	public long getTimeLeft(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(4);assert isInitialized();
        TimeRecord record = getRecord(color);
        long time = record.m_time;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(5);if ((getUseByoyomi() && isInByoyomi(color)) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(7) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(6);return (getByoyomi() - time);}
        else
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(8);return (getPreByoyomi() - time);}
    }

    @Override
	public TimeSettings getTimeSettings()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(9);return m_timeSettings;
    }

    @Override
	public String getTimeString(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(10);assert color.isBlackWhite();
        TimeRecord record = getRecord(color);
        long time = record.m_time;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(11);if ((color.equals(m_toMove)) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(13) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(12);time += currentTimeMillis() - m_startTime;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(14);if ((isInitialized()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(16) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(15);if ((record.m_isInByoyomi) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(18) && false))
                {$qualityscroll_cover_jacov_probe_36bb54e95120577f(17);time = getByoyomi() - time;}
            else
                {$qualityscroll_cover_jacov_probe_36bb54e95120577f(24);time = getPreByoyomi() - time;}
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(19);int movesLeft = -1;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(20);if ((isInitialized() && record.m_isInByoyomi) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(22) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(21);movesLeft = record.m_movesLeft;
        }
        // Round time to seconds
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(23);time = time / 1000L;
        return getTimeString(time, movesLeft);
    }

    /** Format time left to a string.
        If movesLeft &lt; 0, only the time will be returned, otherwise
        after the time string, a slash and the number of moves left will be
        appended. */
    public static String getTimeString(double timeLeft, int movesLeft)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(25);StringBuilder buffer = new StringBuilder(8);
        buffer.append(StringUtil.formatTime((long)timeLeft));
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(26);if ((movesLeft >= 0) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(28) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(27);buffer.append('/');
            buffer.append(movesLeft);
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(29);return buffer.toString();
    }

    /** Return color the clock is currently measuring the time for.
        Returns null, if clock is between a #stopMove and #startMove. */
    @Override
	public GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(30);return m_toMove;
    }

    @Override
	public boolean getUseByoyomi()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(31);return m_timeSettings.getUseByoyomi();
    }

    public void halt()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(32);if ((! m_isRunning) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(34) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(33);return;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(35);TimeRecord record = getRecord(m_toMove);
        long currentTime = currentTimeMillis();
        long time = currentTime - m_startTime;
        m_startTime = currentTime;
        record.m_time += time;
        m_isRunning = false;
        updateListener();
        stopTimer();
    }

    @Override
	public boolean isInitialized()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(36);return (m_timeSettings != null);
    }

    @Override
	public boolean isInByoyomi(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(37);return getUseByoyomi() && getRecord(color).m_isInByoyomi;
    }

    @Override
	public boolean isRunning()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(38);return m_isRunning;
    }

    @Override
	public boolean lostOnTime(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(39);if ((! isInitialized()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(41) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(40);return false;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(42);TimeRecord record = getRecord(color);
        long time = record.m_time;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(43);if ((getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(45) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(44);return record.m_byoyomiExceeded;}
        else
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(46);return (time > getPreByoyomi());}
    }

    /** Parses a time string.
        The expected format is <tt>[[H:]MM:]SS</tt>.
        @return The time in milliseconds or -1, if the time string is not
        valid. */
    public static long parseTimeString(String s)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(47);String a[] = s.split(":");
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(48);if ((a.length == 0 || a.length > 3) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(50) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(49);return -1;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(51);int hours = 0;
        int minutes = 0;
        int seconds = 0;
        try
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(52);if ((a.length == 3) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(54) && false))
            {
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(53);hours = Integer.parseInt(a[0]);
                minutes = Integer.parseInt(a[1]);
                seconds = Integer.parseInt(a[2]);
            }
            else {$qualityscroll_cover_jacov_probe_36bb54e95120577f(59);if ((a.length == 2) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(61) && false))
            {
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(60);minutes = Integer.parseInt(a[0]);
                seconds = Integer.parseInt(a[1]);
            }
            else
            {
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(62);assert a.length == 1;
                seconds = Integer.parseInt(a[0]);
            }}
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(63);return -1;
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(55);if ((minutes < 0 || minutes > 60 || seconds < 0 ||seconds > 60) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(57) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(56);return -1;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(58);return 1000L * (seconds + minutes * 60L + hours * 3600L);
    }

    public void reset()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(64);reset(BLACK);
        reset(WHITE);
        m_toMove = null;
        m_isRunning = false;
        updateListener();
    }

    public void reset(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(65);TimeRecord timeRecord = getRecord(color);
        timeRecord.m_time = 0;
        timeRecord.m_movesLeft = 0;
        timeRecord.m_isInByoyomi = false;
        timeRecord.m_byoyomiExceeded = false;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(66);if ((isInitialized() && getPreByoyomi() == 0) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(68) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(67);assert getByoyomiMoves() > 0;
            timeRecord.m_movesLeft = getByoyomiMoves();
            timeRecord.m_isInByoyomi = true;
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(69);updateListener();
    }

    /** Resume clock, if it was halted during a player's move time. */
    public void resume()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(70);if ((m_isRunning) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(72) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(71);return;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(73);assert m_toMove != null;
        m_startTime = currentTimeMillis();
        m_isRunning = true;
        startTimer();
    }

    /** Register listener for clock changes.
        Only one listener supported at the moment.
        If the clock has a listener, the clock should be stopped with halt()
        if it is no longer used, otherwise the timer thread can keep an
        application from terminating. */
    public void setListener(Listener listener)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(74);m_listener = listener;
    }

    /** Set time settings.
        Changing the time settings does not change the current state of the
        clock. The time settings are only used when the clock is reset or
        the next byoyomi period is initialized. */
    public void setTimeSettings(TimeSettings settings)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(75);m_timeSettings = settings;
    }

    /** Set time left.
        @param color Color to set the time for.
        @param time New value for time left.
        @param movesLeft -1, if not in byoyomi. */
    public void setTimeLeft(GoColor color, long time, int movesLeft)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(76);halt();
        boolean isInByoyomi = (movesLeft >= 0);
        TimeRecord record = getRecord(color);
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(77);if ((isInByoyomi) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(79) && false))
        {
            // We cannot handle setting the time left in overtime if we don't
            // know the overtime settings (e.g. if an SGF file was loaded
            // that has TM,OT and BL/WL/OB/OW properties but we couldn't parse
            // the value of OT, which is not standardized in SGF, or could
            // use an overtime system not supported by GoGui (GoGui supports
            // only the Canadian overtime system as used by the time_settings
            // GTP command
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(78);if ((! m_timeSettings.getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(81) && false))
                {$qualityscroll_cover_jacov_probe_36bb54e95120577f(80);return;}
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(82);record.m_isInByoyomi = isInByoyomi;
            record.m_time = getByoyomi() - time;
            record.m_movesLeft = movesLeft;
            record.m_byoyomiExceeded = time > 0;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(87);record.m_time = getPreByoyomi() - time;
            record.m_movesLeft = -1;
            record.m_byoyomiExceeded = false;
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(83);if ((m_toMove != null) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(85) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(84);startMove(m_toMove);}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(86);updateListener();
    }

    /** Start time for a move.
        If the clock was already running, the passed time for the current move
        is discarded. */
    public void startMove(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(88);assert color.isBlackWhite();
        m_toMove = color;
        m_isRunning = true;
        m_startTime = currentTimeMillis();
        startTimer();
    }

    /** Stop time for a move.
        If the clock was running, the time for the move is added to the
        total time for the color the clock was running for; otherwise
        this function does nothing. */
    public void stopMove()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(89);if ((! m_isRunning) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(91) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(90);return;}
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(92);TimeRecord record = getRecord(m_toMove);
        long time = currentTimeMillis() - m_startTime;
        record.m_time += time;
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(93);if ((isInitialized() && getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(95) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(94);if ((! record.m_isInByoyomi
                && record.m_time > getPreByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(97) && false))
            {
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(96);record.m_isInByoyomi = true;
                record.m_time -= getPreByoyomi();
                assert getByoyomiMoves() > 0;
                record.m_movesLeft = getByoyomiMoves();
            }
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(98);if ((record.m_isInByoyomi) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(100) && false))
            {
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(99);if ((record.m_time > getByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(102) && false))
                    {$qualityscroll_cover_jacov_probe_36bb54e95120577f(101);record.m_byoyomiExceeded = true;}
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(103);assert record.m_movesLeft > 0;
                --record.m_movesLeft;
                $qualityscroll_cover_jacov_probe_36bb54e95120577f(104);if ((record.m_movesLeft == 0) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(106) && false))
                {
                    $qualityscroll_cover_jacov_probe_36bb54e95120577f(105);record.m_time = 0;
                    assert getByoyomiMoves() > 0;
                    record.m_movesLeft = getByoyomiMoves();
                }
            }
        }
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(107);m_toMove = null;
        m_isRunning = false;
        updateListener();
    }

    private static class TimeRecord
    {
        public boolean m_isInByoyomi;

        public boolean m_byoyomiExceeded;

        public int m_movesLeft;

        public long m_time;
    }

    private boolean m_isRunning = false;

    private long m_startTime;

    private GoColor m_toMove;

    private final BlackWhiteSet<TimeRecord> m_timeRecord
        = new BlackWhiteSet<TimeRecord>(new TimeRecord(), new TimeRecord());

    private TimeSettings m_timeSettings;

    private Listener m_listener;

    private Timer m_timer;

    private final TimeSource m_timeSource;

    private long currentTimeMillis()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(108);return m_timeSource.currentTimeMillis();
    }

    private TimeRecord getRecord(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(109);return m_timeRecord.get(c);
    }

    private long getByoyomi()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(110);return m_timeSettings.getByoyomi();
    }

    private int getByoyomiMoves()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(111);return m_timeSettings.getByoyomiMoves();
    }

    private long getPreByoyomi()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(112);return m_timeSettings.getPreByoyomi();
    }

    private void startTimer()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(113);if ((m_timer == null && m_listener != null) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(115) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(114);m_timer = new Timer();
            TimerTask task = new TimerTask() {
                    @Override
					public void run() {
                        $qualityscroll_cover_jacov_probe_36bb54e95120577f(116);updateListener();
                    }
                };
            m_timer.scheduleAtFixedRate(task, 1000, 1000);
        }
    }

    private void stopTimer()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(117);if ((m_timer != null) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(119) && false))
        {
            $qualityscroll_cover_jacov_probe_36bb54e95120577f(118);m_timer.cancel();
            m_timer = null;
        }
    }

    private void updateListener()
    {
        $qualityscroll_cover_jacov_probe_36bb54e95120577f(120);if ((m_listener != null) ? true : (!$qualityscroll_cover_jacov_probe_36bb54e95120577f(122) && false))
            {$qualityscroll_cover_jacov_probe_36bb54e95120577f(121);m_listener.clockChanged();}
    }
}
