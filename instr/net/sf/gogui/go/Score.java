/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Score.java

package net.sf.gogui.go;

/** Result of a game.
    Includes information about the score under Chinese and Japanese rules,
    the rules and komi used, territory, area (stones and territory) and
    number of captured stones. */
public class Score
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Score.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8926815836772509751L,/* translation unit id   */ -6233005296099304769L,/* timestamp             */ 1709177900592L,/* source file name      */ "Score.java",/* probe size            */ 18);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a97feab502df5abf(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public enum ScoringMethod
    {
        /** Constant for area scoring method (Chinese). */
        AREA,

        /** Constant for territory scoring method (Japanese). */
        TERRITORY;
    }

    public int m_areaBlack;

    public int m_areaWhite;

    public int m_capturedBlack;

    public int m_capturedWhite;

    public Komi m_komi;

    public double m_result;

    public double m_resultArea;

    public double m_resultTerritory;

    public ScoringMethod m_rules;

    public int m_territoryBlack;

    public int m_territoryWhite;

    public String formatResult()
    {
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(0);return formatResult(m_result);
    }

    public static String formatResult(double result)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(1);long intResult = Math.round(result * 2);
        String strResult;
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(2);if ((intResult % 2 == 0) ? true : (!$qualityscroll_cover_jacov_probe_a97feab502df5abf(4) && false))
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(3);strResult = Long.toString(intResult / 2);}
        else
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(12);strResult = Long.toString(intResult / 2) + ".5";}
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(5);if ((intResult > 0) ? true : (!$qualityscroll_cover_jacov_probe_a97feab502df5abf(7) && false))
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(6);return "B+" + strResult;}
        else {$qualityscroll_cover_jacov_probe_a97feab502df5abf(8);if ((intResult < 0) ? true : (!$qualityscroll_cover_jacov_probe_a97feab502df5abf(10) && false))
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(9);return "W+" + (-result);}
        else
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(11);return "0";}}
    }

    public void updateRules(ScoringMethod rules)
    {
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(13);m_rules = rules;
        $qualityscroll_cover_jacov_probe_a97feab502df5abf(14);if ((rules == ScoringMethod.TERRITORY) ? true : (!$qualityscroll_cover_jacov_probe_a97feab502df5abf(16) && false))
            {$qualityscroll_cover_jacov_probe_a97feab502df5abf(15);m_result = m_resultTerritory;}
        else
        {
            $qualityscroll_cover_jacov_probe_a97feab502df5abf(17);assert rules == ScoringMethod.AREA;
            m_result = m_resultArea;
        }
    }
}
