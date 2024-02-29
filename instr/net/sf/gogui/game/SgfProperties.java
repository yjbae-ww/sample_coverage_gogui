/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// SgfProperties.java

package net.sf.gogui.game;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/** Unknown SGF properties.
    Non-type-checked SGF properties for preserving unknown properties.
    Should only be used for unknown properties.
    @todo Iteration is inefficient, reimplement (but without sacrificing
    const-correctness) */
public final class SgfProperties
    implements ConstSgfProperties
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SgfProperties.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 7218579085095574707L,/* translation unit id   */ -2695560573885401830L,/* timestamp             */ 1709177900107L,/* source file name      */ "SgfProperties.java",/* probe size            */ 19);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_da9771f09303351a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public SgfProperties()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_da9771f09303351a(0);m_properties = new TreeMap<String,ArrayList<String>>();
    }

    public SgfProperties(ConstSgfProperties props)
    {
        this();$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_da9771f09303351a(1);
        $qualityscroll_cover_jacov_probe_da9771f09303351a(2);if ((props == null) ? true : (!$qualityscroll_cover_jacov_probe_da9771f09303351a(4) && false))
            {$qualityscroll_cover_jacov_probe_da9771f09303351a(3);return;}
        $qualityscroll_cover_jacov_probe_da9771f09303351a(5);for (Map.Entry<String,ArrayList<String>> entry :
                 ((SgfProperties)props).m_properties.entrySet())
            {$qualityscroll_cover_jacov_probe_da9771f09303351a(6);add(entry.getKey(), entry.getValue());}
    }

    public void add(String key, ArrayList<String> values)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(7);m_properties.put(key, new ArrayList<String>(values));
    }

    public void add(String key, String value)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(8);ArrayList<String> values = new ArrayList<String>();
        values.add(value);
        m_properties.put(key, values);
    }

    /** Get a list of all keys.
        This list is a copy of the keys at the time of the function call. */
    @Override
	public ArrayList<String> getKeys()
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(9);return new ArrayList<String>(m_properties.keySet());
    }

    /** Return number of values for a key.
        @return Number of values or -1, if key does not exist. */
    @Override
	public int getNumberValues(String key)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(10);ArrayList<String> values = m_properties.get(key);
        $qualityscroll_cover_jacov_probe_da9771f09303351a(11);if ((values == null) ? true : (!$qualityscroll_cover_jacov_probe_da9771f09303351a(13) && false))
            {$qualityscroll_cover_jacov_probe_da9771f09303351a(12);return -1;}
        $qualityscroll_cover_jacov_probe_da9771f09303351a(14);return values.size();
    }

    @Override
	public String getValue(String key, int index)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(15);return m_properties.get(key).get(index);
    }

    @Override
	public boolean hasKey(String key)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(16);return (getNumberValues(key) >= 0);
    }

    @Override
	public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(17);return (m_properties.size() == 0);
    }

    public void remove(String key)
    {
        $qualityscroll_cover_jacov_probe_da9771f09303351a(18);m_properties.remove(key);
    }

    private Map<String,ArrayList<String>> m_properties;
}
