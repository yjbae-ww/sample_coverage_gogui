/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// PointList.java

package net.sf.gogui.go;

import java.util.ArrayList;
import java.util.Iterator;

/** List containing points. */
public final class PointList
    extends ArrayList<GoPoint>
    implements ConstPointList
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = PointList.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 1871933261930440796L,/* translation unit id   */ -2286125247300198524L,/* timestamp             */ 1709177900576L,/* source file name      */ "PointList.java",/* probe size            */ 27);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e0460d33329e9f84(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public class ConstIterator
        implements Iterator<GoPoint>
    {
        @Override
		public boolean hasNext()
        {
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(0);return (m_index < size());
        }

        @Override
		public GoPoint next()
        {
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(1);return get(m_index++);
        }

        @Override
		public void remove()
        {
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(2);throw new UnsupportedOperationException();
        }

        private int m_index;
    }

    /** Construct empty point list. */
    public PointList()
    {
        this(0);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0460d33329e9f84(3);
    }

    /** Construct empty point list with initial capacity.
        @param initialCapacity The number of points to reserve memory for. */
    public PointList(int initialCapacity)
    {
        super(initialCapacity);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0460d33329e9f84(4);
    }

    /** Construct point list with a single element.
        @param p The initial point element. */
    public PointList(GoPoint p)
    {
        this(1);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0460d33329e9f84(5);
        add(p);
    }

    /** Construct point list as a copy of another point list.
        @param list The list to copy the points from. */
    public PointList(ConstPointList list)
    {
        super((PointList)list);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e0460d33329e9f84(6);
    }

    /** Add points of another list  at the end of this list. */
    public void addAllFromConst(ConstPointList list)
    {
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(7);addAll((PointList)list);
    }

    /** Get an empty constant point list.
        Can be used at places where an empty temporary point list is needed
        that is never modified to avoid memory allocation. */
    public static ConstPointList getEmptyList()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(8);return EMPTY_LIST;
    }

    /** Returns an iterator over the points elements in this list.
        An iterator of type PointList.ConstIterator is returned, which
        does not support Iterator.remove(), to allow for-each-loops for
        ConstPointList references. */
    @Override
	public Iterator<GoPoint> iterator()
    {
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(9);return new ConstIterator();
    }

    /** Remove and return last element.
        Requires that list is not empty. */
    public GoPoint pop()
    {
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(10);int index = size() - 1;
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(11);if ((index < 0) ? true : (!$qualityscroll_cover_jacov_probe_e0460d33329e9f84(13) && false))
        {
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(12);assert false;
            return null;
        }
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(14);GoPoint p = get(index);
        remove(index);
        return p;
    }

    @Override
	public String toString()
    {
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(15);StringBuilder buffer = new StringBuilder();
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(16);for (int i = 0; (i < size()) ? true : (!$qualityscroll_cover_jacov_probe_e0460d33329e9f84(18) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(17);if ((i > 0) ? true : (!$qualityscroll_cover_jacov_probe_e0460d33329e9f84(21) && false))
                {$qualityscroll_cover_jacov_probe_e0460d33329e9f84(20);buffer.append(' ');}
            $qualityscroll_cover_jacov_probe_e0460d33329e9f84(22);buffer.append(get(i));
        }
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(19);return buffer.toString();
    }

    /** Convert point list to string.
        Null arguments will be converted to an empty string. */
    public static String toString(ConstPointList list)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e0460d33329e9f84(23);if ((list == null) ? true : (!$qualityscroll_cover_jacov_probe_e0460d33329e9f84(25) && false))
            {$qualityscroll_cover_jacov_probe_e0460d33329e9f84(24);return "";}
        else
            {$qualityscroll_cover_jacov_probe_e0460d33329e9f84(26);return list.toString();}
    }

    private static final ConstPointList EMPTY_LIST = new PointList();
}
