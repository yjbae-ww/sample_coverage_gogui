/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// Table.java

package net.sf.gogui.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/** Table of string elements. */
public class Table
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Table.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6763766938469605879L,/* translation unit id   */ -3806224148189519958L,/* timestamp             */ 1709177904191L,/* source file name      */ "Table.java",/* probe size            */ 121);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Error thrown on invalid table location argument. */
    public static class InvalidLocation
        extends ErrorMessage
    {
        public InvalidLocation(String message)
        {
            super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(0);
        }
    }

    /** Error thrown on invalid file format when reading a table. */
    public static class InvalidFormat
        extends ErrorMessage
    {
        public InvalidFormat(String message)
        {
            super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(1);
        }
    }

    /** Error thrown if table element has not the expected type. */
    public static class InvalidElement
        extends ErrorMessage
    {
        public InvalidElement(String message)
        {
            super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(2);
        }
    }

    public Table()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(3);m_columnTitles = new ArrayList<String>();
        m_numberColumns = 0;
    }

    public Table(ArrayList<String> columnTitles)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(4);m_columnTitles = columnTitles;
        m_numberColumns = columnTitles.size();
    }

    public String get(int column, int row)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(5);return getRow(row).get(column);
    }

    public String get(String columnTitle, int row) throws InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(6);return get(getColumnIndex(columnTitle), row);
    }

    public double getDouble(int column, int row)
        throws InvalidLocation, InvalidElement
    {
        try
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(7);String s = get(column, row);
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(8);if ((s == null) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(10) && false))
                {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(9);s = "";}
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(11);return Double.parseDouble(s);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(12);throw new InvalidElement("Expected floating point number in "
                                     + "table (column=" + column + ", row="
                                     + row + ")");
        }
    }

    public double getDouble(String columnTitle, int row)
        throws InvalidLocation, InvalidElement
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(13);return getDouble(getColumnIndex(columnTitle), row);
    }

    public int getInt(int column, int row) throws InvalidElement
    {
        try
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(14);String s = get(column, row);
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(15);if ((s == null) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(17) && false))
                {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(16);s = "";}
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(18);return Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(19);throw new InvalidElement("Expected integer in table (column="
                                     + column + ", row=" + row + ")");
        }
    }

    public int getInt(String columnTitle, int row)
        throws InvalidLocation, InvalidElement
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(20);return getInt(getColumnIndex(columnTitle), row);
    }

    public int getColumnIndex(String column) throws InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(21);for (int i = 0; (i < m_numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(23) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(22);String title = getColumnTitle(i);
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(25);if ((title.equals(column)) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(27) && false))
                {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(26);return i;}
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(24);throw new InvalidLocation("No such column in table: " + column);
    }

    public String getColumnTitle(int index)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(28);return m_columnTitles.get(index);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> getColumnTitles()
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(29);return (ArrayList<String>)m_columnTitles.clone();
    }

    public int getNumberColumns()
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(30);return m_columnTitles.size();
    }

    public int getNumberRows()
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(31);return m_rows.size();
    }

    /** Get meta information.
        @param key the property key
        @return The property value or null, if it dows not exist */
    public String getProperty(String key)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(32);return getProperty(key, null);
    }

    /** Get meta information.
        @param key the property key
        @param def the default value, if this property does not exist */
    public String getProperty(String key, String def)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(33);if ((! hasProperty(key)) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(35) && false))
            {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(34);return def;}
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(36);return m_properties.get(key);
    }

    public boolean hasProperty(String key)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(37);return m_properties.containsKey(key);
    }

    public void read(File file) throws FileNotFoundException, IOException,
                                       InvalidFormat
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(38);read(new FileReader(file));
    }

    public void read(Reader reader) throws IOException, InvalidFormat
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(39);BufferedReader bufferedReader = new BufferedReader(reader);
        m_lineNumber = 0;
        m_propertiesRead = false;
        String line = null;
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(40);while (((line = bufferedReader.readLine()) != null) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(42) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(41);++m_lineNumber;
            handleLine(line);
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(43);bufferedReader.close();
    }

    public void save(File file) throws IOException
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(44);FileWriter writer = new FileWriter(file);
        try
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(45);save(writer);
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(46);writer.close();
        }
    }

    public void save(Writer out) throws IOException
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(47);save(out, true);
    }

    public void save(Writer out, boolean withHeader) throws IOException
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(48);if ((withHeader) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(50) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(49);for (Map.Entry<String,String> entry : m_properties.entrySet())
            {
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(72);String key = entry.getKey();
                String value = entry.getValue();
                out.write("# " + key + ": " + value + "\n");
            }
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(51);out.write("#\n#");
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(52);for (int i = 0; (i < m_numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(54) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(53);out.write(getColumnTitle(i));
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(68);if ((i < m_numberColumns - 1) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(70) && false))
                    {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(69);out.write('\t');}
                else
                    {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(71);out.write('\n');}
            }
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(55);for (int i = 0; (i < m_rows.size()) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(57) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(56);ArrayList<String> row = m_rows.get(i);
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(58);for (int j = 0; (j < m_numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(60) && false); ++j)
            {
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(59);String value = row.get(j);
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(61);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(63) && false))
                    {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(62);out.write(value);}
                $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(64);if ((j < m_numberColumns - 1) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(66) && false))
                    {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(65);out.write('\t');}
                else
                    {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(67);out.write('\n');}
            }
        }
    }

    /** Set element in last row.
        @param column Column in last row.
        @param value The value (must not contain newlines or tabs). */
    public void set(int column, String value)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(73);assert m_lastRow.get(column) == null;
        // Values containing newlines and tabs are not supported by save()
        // yet
        assert value == null || value.indexOf("\n") < 0;
        assert value == null || value.indexOf("\t") < 0;
        m_lastRow.set(column, value);
    }

    public void set(String column, int value) throws InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(74);set(column, Integer.toString(value));
    }

    public void set(String column, double value) throws InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(75);set(column, Double.toString(value));
    }

    public void set(String column, String value) throws InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(76);set(getColumnIndex(column), value);
    }

    /** Set meta information.
        @param key the property key
        @param value the property value */
    public Object setProperty(String key, String value)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(77);return m_properties.put(key, value);
    }

    public void startRow()
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(78);ArrayList<String> row = new ArrayList<String>(m_numberColumns);
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(79);for (int i = 0; (i < m_numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(81) && false); ++i)
            {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(80);row.add(null);}
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(82);m_rows.add(row);
        m_lastRow = row;
    }

    public void sortByIntColumn(int column, int rowBegin,
                                int rowEnd) throws InvalidElement
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(83);for (int row1 = rowBegin; (row1 < rowEnd - 1) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(85) && false); ++row1)
            {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(84);for (int row2 = row1 + 1; (row2 < rowEnd) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(87) && false); ++row2)
                {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(86);if ((getInt(column, row2) < getInt(column, row1)) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(89) && false))
                {
                    $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(88);ArrayList<String> tmp = m_rows.get(row1);
                    m_rows.set(row1, m_rows.get(row2));
                    m_rows.set(row2, tmp);
                }}}
    }

    public void sortByIntColumn(String columnTitle, int rowBegin,
                                int rowEnd)
        throws InvalidElement, InvalidLocation
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(90);sortByIntColumn(getColumnIndex(columnTitle), rowBegin, rowEnd);
    }

    private boolean m_propertiesRead;

    private int m_lineNumber;

    private int m_numberColumns;

    private final Map<String,String> m_properties =
        new TreeMap<String,String>();

    private final ArrayList<String> m_columnTitles;

    private ArrayList<String> m_lastRow;

    private final ArrayList<ArrayList<String>> m_rows
        = new ArrayList<ArrayList<String>>();

    private void addColumnTitle(String columnTitle)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(91);m_columnTitles.add(columnTitle);
        ++m_numberColumns;
    }

    private ArrayList<String> getRow(int index)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(92);return m_rows.get(index);
    }

    private void handleComment(String comment)
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(93);comment = comment.trim();
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(94);if ((m_propertiesRead) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(96) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(95);String[] array = comment.split("\\t");
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(97);for (int i = 0; (i < array.length) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(99) && false); ++i)
                {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(98);addColumnTitle(array[i]);}
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(100);return;
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(101);if ((comment.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(103) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(102);m_propertiesRead = true;
            return;
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(104);int pos = comment.indexOf(':');
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(105);if ((pos < 0) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(107) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(106);System.err.println("Invalid line " + m_lineNumber + ": "
                               + comment);
            return;
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(108);String key = comment.substring(0, pos).trim();
        String value = comment.substring(pos + 1).trim();
        setProperty(key, value);
    }

    private void handleLine(String line) throws InvalidFormat
    {
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(109);line = line.trim();
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(110);if ((line.startsWith("#")) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(112) && false))
        {
            $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(111);handleComment(line.substring(1));
            return;
        }
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(113);String[] array = line.split("\\t");
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(114);if ((array.length > getNumberColumns()) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(116) && false))
            {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(115);throw new InvalidFormat("Invalid line " + m_lineNumber
                                    + ": " + line);}
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(117);startRow();
        $qualityscroll_cover_jacov_probe_cb2d934dafa65faa(118);for (int i = 0; (i < array.length) ? true : (!$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(120) && false); ++i)
            {$qualityscroll_cover_jacov_probe_cb2d934dafa65faa(119);set(i, array[i]);}
    }
}
