/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// TableUtil.java

package net.sf.gogui.util;

import java.util.ArrayList;

/** Utility functions for class Table. */
public final class TableUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TableUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -9166879532914373091L,/* translation unit id   */ -3157368601557371991L,/* timestamp             */ 1709177904209L,/* source file name      */ "TableUtil.java",/* probe size            */ 122);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Check if all elements in a column are empty.
        @param table The table.
        @param column The column title.
        @return True, if all elements in this column are null or strings
        containing only whitespaces. */
    public static boolean allEmpty(Table table, String column)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(0);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(2) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(1);String value = table.get(column, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(4);if ((! StringUtil.isEmpty(value)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(6) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(5);return false;}
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(3);return true;
    }

    /** Append row from other table.
        The tables need to have the same number of columns.
        @param to The table to append to.
        @param from The table to take the row from.
        @param row The index of the row in table from. */
    public static void appendRow(Table to, Table from, int row)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(7);assert to.getNumberColumns() == from.getNumberColumns();
        to.startRow();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(8);for (int column = 0; (column < to.getNumberColumns()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(10) && false); ++column)
            {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(9);to.set(column, from.get(column, row));}
    }

    /** Find row with required values for two columns.
        @param table The table.
        @param compareColumn1 The first column title.
        @param compareValue1 The required value for the first column.
        @param compareColumn2 The second column title.
        @param compareValue2 The required value for the second column.
        @return The row with matching values for both columns or -1,
        if no such row exists. */
    public static int findRow(Table table,
                              String compareColumn1, String compareValue1,
                              String compareColumn2, String compareValue2)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(11);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(13) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(12);String value1 = table.get(compareColumn1, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(15);if ((value1 == null || ! value1.equals(compareValue1)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(17) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(16);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(18);String value2 = table.get(compareColumn2, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(19);if ((value2 == null || ! value2.equals(compareValue2)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(21) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(20);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(22);return row;
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(14);return -1;
    }

    public static Table fromHistogram(Histogram histogram, String name)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(23);ArrayList<String> columnTitles = new ArrayList<String>(2);
        columnTitles.add(name);
        columnTitles.add("Count");
        Table result = new Table(columnTitles);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(24);for (int i = 0; (i < histogram.getSize()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(26) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(25);int count = histogram.getCount(i);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(28);if ((count == 0) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(30) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(29);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(31);result.startRow();
            try
            {
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(32);result.set(name, histogram.getValue(i));
                result.set("Count", count);
            }
            catch (Table.InvalidLocation e)
            {
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(33);assert false;
            }
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(27);return result;
    }

    /** Get elements of a column without null and whitespace-only elements. */
    public static ArrayList<String> getColumnNotEmpty(Table table,
                                                      String column)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(34);ArrayList<String> result = new ArrayList<String>();
        int col = table.getColumnIndex(column);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(35);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(37) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(36);String value = table.get(col, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(39);if ((! StringUtil.isEmpty(value)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(41) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(40);result.add(value);}
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(38);return result;
    }

    public static ArrayList<String> getColumnUnique(Table table, String column)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(42);ArrayList<String> result = new ArrayList<String>();
        int col = table.getColumnIndex(column);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(43);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(45) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(44);String value = table.get(col, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(47);if ((value != null && ! value.equals("")
                && ! result.contains(value)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(49) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(48);result.add(value);}
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(46);return result;
    }

    public static double getMax(Table table, String column)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(50);double max = Double.NEGATIVE_INFINITY;
        int col = table.getColumnIndex(column);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(51);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(53) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(52);try
            {
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(55);double value = Double.parseDouble(table.get(col, row));
                max = Math.max(max, value);
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(56);
            }
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(54);return max;
    }

    public static Statistics getStatistics(Table table, String column)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(57);Statistics statistics = new Statistics();
        int col = table.getColumnIndex(column);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(58);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(60) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(59);try
            {
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(62);String value = table.get(col, row);
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(63);if ((value == null) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(65) && false))
                    {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(64);continue;}
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(66);double doubleValue = Double.parseDouble(value);
                statistics.add(doubleValue);
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(67);
            }
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(61);return statistics;
    }

    public static boolean isNumberValue(String string)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(68);if ((string == null) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(70) && false))
            {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(69);return false;}
        try
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(71);Double.parseDouble(string);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(73);return false;
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(72);return true;
    }

    public static boolean isBoolValue(String string)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(74);return (string.equals("0") || string.equals("1"));
    }

    public static boolean isIntValue(String string)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(75);Integer.parseInt(string);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(77);return false;
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(76);return true;
    }

    public static Table select(Table table, String compareColumn,
                               String compareValue)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(78);Table result = new Table(table.getColumnTitles());
        int numberColumns = table.getNumberColumns();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(79);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(81) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(80);String value = table.get(compareColumn, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(83);if ((value == null || ! value.equals(compareValue)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(85) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(84);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(86);result.startRow();
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(87);for (int column = 0; (column < numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(89) && false); ++column)
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(88);result.set(column, table.get(column, row));}
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(82);return result;
    }

    public static Table select(Table table, String compareColumn,
                               String compareValue, String selectColumn)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(90);ArrayList<String> columnTitles = new ArrayList<String>(1);
        columnTitles.add(selectColumn);
        Table result = new Table(columnTitles);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(91);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(93) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(92);String value = table.get(compareColumn, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(95);if ((value == null || ! value.equals(compareValue)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(97) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(96);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(98);result.startRow();
            result.set(selectColumn, table.get(selectColumn, row));
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(94);return result;
    }

    public static Table select(Table table, String compareColumn,
                               String compareValue, String selectColumn1,
                               String selectColumn2)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(99);ArrayList<String> columnTitles = new ArrayList<String>(2);
        columnTitles.add(selectColumn1);
        columnTitles.add(selectColumn2);
        Table result = new Table(columnTitles);
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(100);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(102) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(101);String value = table.get(compareColumn, row);
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(104);if ((value == null || ! value.equals(compareValue)) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(106) && false))
                {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(105);continue;}
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(107);result.startRow();
            result.set(selectColumn1, table.get(selectColumn1, row));
            result.set(selectColumn2, table.get(selectColumn2, row));
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(103);return result;
    }

    public static Table selectIntRange(Table table, String compareColumn,
                                       int min, int max)
        throws Table.InvalidLocation
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(108);Table result = new Table(table.getColumnTitles());
        int numberColumns = table.getNumberColumns();
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(109);for (int row = 0; (row < table.getNumberRows()) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(111) && false); ++row)
        {
            $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(110);String value = table.get(compareColumn, row);
            try
            {
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(113);int intValue = Integer.parseInt(value);
                $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(114);if ((intValue >= min && intValue <= max) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(116) && false))
                {
                    $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(115);result.startRow();
                    $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(117);for (int column = 0; (column < numberColumns) ? true : (!$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(119) && false); ++column)
                        {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(118);result.set(column, table.get(column, row));}
                }

            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(120);
            }
        }
        $qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(112);return result;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private TableUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_d42ec5fc3f3373a9(121);
    }
}
