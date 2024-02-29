/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// GameInfo.java

package net.sf.gogui.game;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import net.sf.gogui.go.BlackWhiteSet;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Score.ScoringMethod;
import static net.sf.gogui.go.Score.ScoringMethod.AREA;
import static net.sf.gogui.go.Score.ScoringMethod.TERRITORY;
import net.sf.gogui.util.ObjectUtil;
import net.sf.gogui.util.StringUtil;

/** Game information.
    Contains information about handicap, rules and players. */
public class GameInfo
    implements ConstGameInfo
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameInfo.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -5048952472526824318L,/* translation unit id   */ -3927930083712986736L,/* timestamp             */ 1709177899895L,/* source file name      */ "GameInfo.java",/* probe size            */ 61);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c97d306661b79190(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameInfo()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_c97d306661b79190(0);
    }

    public GameInfo(ConstGameInfo info)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c97d306661b79190(1);copyFrom(info);
    }

    public final void copyFrom(ConstGameInfo info)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(2);GameInfo infoNonConst = (GameInfo)info;
        m_handicap = infoNonConst.m_handicap;
        m_komi = infoNonConst.m_komi;
        m_timeSettings = infoNonConst.m_timeSettings;
        m_stringInfo.clear();
        m_stringInfo.putAll(infoNonConst.m_stringInfo);
        m_stringInfoColor.clear();
        $qualityscroll_cover_jacov_probe_c97d306661b79190(3);for (Map.Entry<StringInfoColor,BlackWhiteSet<String>> entry
                 : infoNonConst.m_stringInfoColor.entrySet())
        {
            $qualityscroll_cover_jacov_probe_c97d306661b79190(4);StringInfoColor type = entry.getKey();
            BlackWhiteSet<String> set = entry.getValue();
            assert set != null;
            BlackWhiteSet<String> newSet = new BlackWhiteSet<String>();
            newSet.set(BLACK, set.get(BLACK));
            newSet.set(WHITE, set.get(WHITE));
            m_stringInfoColor.put(type, newSet);
        }
    }

    @Override
	public boolean equals(Object object)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(5);if ((object == null || object.getClass() != getClass()) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(7) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(6);return false;}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(8);GameInfo info = (GameInfo)object;
        return (m_handicap == info.getHandicap()
                && ObjectUtil.equals(m_komi, info.getKomi())
                && ObjectUtil.equals(m_timeSettings, info.getTimeSettings())
                && m_stringInfo.equals(info.m_stringInfo)
                && m_stringInfoColor.equals(info.m_stringInfoColor));
    }

    @Override
	public String get(StringInfo type)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(9);return m_stringInfo.get(type);
    }

    @Override
	public String get(StringInfoColor type, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(10);BlackWhiteSet<String> set = m_stringInfoColor.get(type);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(11);if ((set == null) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(13) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(12);return null;}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(14);return set.get(c);
    }

    @Override
	public int getHandicap()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(15);return m_handicap;
    }

    /** Get komi.
        @return The komi or null if komi is unknown. */
    @Override
	public Komi getKomi()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(16);return m_komi;
    }

    @Override
	public TimeSettings getTimeSettings()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(17);return m_timeSettings;
    }

    /** Hash code dummy function (don't use).
        This class is not desgined to be used in a HashMap/HashTable. The
        function will trigger an assertion if assertions are enabled. */
    @Override
	public int hashCode()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(18);assert false : "hashCode not designed";
        return 0;
    }

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(19);return (m_handicap == 0 && m_komi == null && m_stringInfo.isEmpty()
                && m_stringInfoColor.isEmpty() && m_timeSettings == null);
    }

    /** Try to parse rules.
        @return Score.ScoringMethod.TERRITORY if rules string (to lowercase)
        is "japanese", Score.ScoringMethod.AREA otherwise. */
    @Override
	public ScoringMethod parseRules()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(20);ScoringMethod result = AREA;
        String rules = get(StringInfo.RULES);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(21);if ((rules != null) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(23) && false))
        {
            $qualityscroll_cover_jacov_probe_c97d306661b79190(22);rules = rules.trim().toLowerCase(Locale.ENGLISH);
            $qualityscroll_cover_jacov_probe_c97d306661b79190(24);if ((rules.equals("japanese")) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(26) && false))
                {$qualityscroll_cover_jacov_probe_c97d306661b79190(25);result = TERRITORY;}
        }
        $qualityscroll_cover_jacov_probe_c97d306661b79190(27);return result;
    }

    public void set(StringInfo type, String value)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(28);value = checkEmpty(value);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(29);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(31) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(30);m_stringInfo.remove(type);}
        else
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(32);m_stringInfo.put(type, value);}
    }

    public void set(StringInfoColor type, GoColor c, String value)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(33);value = checkEmpty(value);
        BlackWhiteSet<String> set = m_stringInfoColor.get(type);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(34);if ((set == null) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(36) && false))
        {
            $qualityscroll_cover_jacov_probe_c97d306661b79190(35);set = new BlackWhiteSet<String>();
            m_stringInfoColor.put(type, set);
        }
        $qualityscroll_cover_jacov_probe_c97d306661b79190(37);set.set(c, value);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(38);if ((set.get(BLACK) == null && set.get(WHITE) == null) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(40) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(39);m_stringInfoColor.remove(type);}
    }

    public void setHandicap(int handicap)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(41);m_handicap = handicap;
    }

    public void setKomi(Komi komi)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(42);m_komi = komi;
    }

    /** Set time settings. */
    public void setTimeSettings(TimeSettings timeSettings)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(43);m_timeSettings = timeSettings;
    }

    /** Suggest a game name from the player names.
        @return A game name built from the player names or null, if not at
        least one player name is known. */
    @Override
	public String suggestGameName()
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(44);String playerBlack = get(StringInfoColor.NAME, BLACK);
        String playerWhite = get(StringInfoColor.NAME, WHITE);
        boolean playerBlackKnown = ! StringUtil.isEmpty(playerBlack);
        boolean playerWhiteKnown = ! StringUtil.isEmpty(playerWhite);
        $qualityscroll_cover_jacov_probe_c97d306661b79190(45);if ((! playerBlackKnown && ! playerWhiteKnown) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(47) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(46);return null;}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(48);if ((playerBlackKnown) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(50) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(49);playerBlack = StringUtil.capitalize(playerBlack);}
        else
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(56);playerBlack = "Unknown";}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(51);if ((playerWhiteKnown) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(53) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(52);playerWhite = StringUtil.capitalize(playerWhite);}
        else
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(55);playerWhite = "Unknown";}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(54);return playerWhite + " vs. " + playerBlack + " (B)";
    }

    private int m_handicap;

    private Komi m_komi;

    private TimeSettings m_timeSettings;

    private Map<StringInfo,String> m_stringInfo =
        new TreeMap<StringInfo,String>();

    private Map<StringInfoColor,BlackWhiteSet<String>> m_stringInfoColor =
        new TreeMap<StringInfoColor,BlackWhiteSet<String>>();

    private String checkEmpty(String s)
    {
        $qualityscroll_cover_jacov_probe_c97d306661b79190(57);if ((s == null || s.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_c97d306661b79190(59) && false))
            {$qualityscroll_cover_jacov_probe_c97d306661b79190(58);return null;}
        $qualityscroll_cover_jacov_probe_c97d306661b79190(60);return s;
    }
}
