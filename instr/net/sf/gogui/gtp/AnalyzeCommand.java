/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// AnalyzeCommand.java

package net.sf.gogui.gtp;

import java.io.File;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.PointList;

/** Concrete analyze command including data for wildcard replacements.
    See GoGui documentation, chapter "Analyze Commands" */
public class AnalyzeCommand
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = AnalyzeCommand.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -2184216721918547736L,/* translation unit id   */ 36770392937883802L,/* timestamp             */ 1709177901245L,/* source file name      */ "AnalyzeCommand.java",/* probe size            */ 101);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_82a27a4150689a(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public AnalyzeCommand(AnalyzeDefinition definition)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_82a27a4150689a(0);m_definition = definition;
    }

    public String getLabel()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(1);return m_definition.getLabel();
    }

    public GoColor getColorArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(2);return m_colorArg;
    }

    public GoPoint getPointArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(3);return m_pointArg;
    }

    public PointList getPointListArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(4);return m_pointListArg;
    }

    public AnalyzeType getType()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(5);return m_definition.getType();
    }

    public String getResultTitle()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(6);StringBuilder buffer = new StringBuilder(getLabel());
        $qualityscroll_cover_jacov_probe_82a27a4150689a(7);if ((needsColorArg() && m_colorArg != null) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(9) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(8);if ((m_colorArg == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(11) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(10);buffer.append(" Black");}
            else
            {
                $qualityscroll_cover_jacov_probe_82a27a4150689a(23);assert m_colorArg == WHITE;
                buffer.append(" White");
            }
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(12);if ((needsPointArg() && m_pointArg != null) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(14) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(13);buffer.append(' ');
            buffer.append(m_pointArg);
        }
        else {$qualityscroll_cover_jacov_probe_82a27a4150689a(19);if ((needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(21) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(20);for (GoPoint p : m_pointListArg)
            {
                $qualityscroll_cover_jacov_probe_82a27a4150689a(22);buffer.append(' ');
                buffer.append(p);
            }
        }}
        $qualityscroll_cover_jacov_probe_82a27a4150689a(15);if ((needsStringArg() && m_stringArg != null) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(17) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(16);buffer.append(' ');
            buffer.append(m_stringArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(18);return buffer.toString();
    }

    public boolean isPointArgMissing()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(24);if ((needsPointArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(26) && false))
            {$qualityscroll_cover_jacov_probe_82a27a4150689a(25);return (m_pointArg == null);}
        $qualityscroll_cover_jacov_probe_82a27a4150689a(27);if ((needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(29) && false))
            {$qualityscroll_cover_jacov_probe_82a27a4150689a(28);return m_pointListArg.isEmpty();}
        $qualityscroll_cover_jacov_probe_82a27a4150689a(30);return false;
    }

    public boolean isTextType()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(31);return m_definition.isTextType();
    }

    public boolean needsColorArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(32);return m_definition.needsColorArg();
    }

    public boolean needsFileArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(33);return m_definition.needsFileArg();
    }

    public boolean needsFileOpenArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(34);return m_definition.needsFileOpenArg();
    }

    public boolean needsFileSaveArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(35);return m_definition.needsFileSaveArg();
    }

    public boolean needsOnlyPointArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(36);return m_definition.needsOnlyPointArg();
    }

    public boolean needsOnlyPointAndColorArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(37);return m_definition.needsOnlyPointAndColorArg();
    }

    public boolean needsPointArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(38);return m_definition.needsPointArg();
    }

    public boolean needsPointListArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(39);return m_definition.needsPointListArg();
    }

    public boolean needsStringArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(40);return m_definition.needsStringArg();
    }

    public boolean needsOptStringArg()
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(41);return m_definition.needsOptStringArg();
    }

    public String replaceWildCards(GoColor toMove)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(42);String command = m_definition.getCommand();
        String toMoveString = (((toMove == BLACK) ? ($qualityscroll_cover_jacov_probe_82a27a4150689a(43) || true) : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(44) && false)) ? "b" : "w");
        String result = command.replace("%m", toMoveString);
        $qualityscroll_cover_jacov_probe_82a27a4150689a(45);if ((needsPointArg() && m_pointArg != null) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(47) && false))
            {$qualityscroll_cover_jacov_probe_82a27a4150689a(46);result = result.replace("%p", m_pointArg.toString());}
        $qualityscroll_cover_jacov_probe_82a27a4150689a(48);if ((needsPointListArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(50) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(49);String pointList = GoPoint.toString(m_pointListArg);
            $qualityscroll_cover_jacov_probe_82a27a4150689a(51);if ((getType() == AnalyzeType.EPLIST
                && m_pointListArg.size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(53) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(52);result = result + ' ' + pointList;}
            else
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(92);result = result.replace("%P", pointList);}
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(54);if ((needsFileArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(56) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(55);String fileArg = m_fileArg.toString();
            $qualityscroll_cover_jacov_probe_82a27a4150689a(57);if ((fileArg.indexOf(' ') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(59) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(58);fileArg = "\"" + fileArg + "\"";}
            $qualityscroll_cover_jacov_probe_82a27a4150689a(60);result = result.replace("%f", fileArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(61);if ((needsFileOpenArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(63) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(62);String fileOpenArg = m_fileOpenArg.toString();
            $qualityscroll_cover_jacov_probe_82a27a4150689a(64);if ((fileOpenArg.indexOf(' ') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(66) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(65);fileOpenArg = "\"" + fileOpenArg + "\"";}
            $qualityscroll_cover_jacov_probe_82a27a4150689a(67);result = result.replace("%r", fileOpenArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(68);if ((needsFileSaveArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(70) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(69);String fileSaveArg = m_fileSaveArg.toString();
            $qualityscroll_cover_jacov_probe_82a27a4150689a(71);if ((fileSaveArg.indexOf(' ') >= 0) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(73) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(72);fileSaveArg = "\"" + fileSaveArg + "\"";}
            $qualityscroll_cover_jacov_probe_82a27a4150689a(74);result = result.replace("%w", fileSaveArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(75);if ((needsStringArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(77) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(76);assert m_stringArg != null;
            result = result.replace("%s", m_stringArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(78);if ((needsOptStringArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(80) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(79);assert m_optStringArg != null;
            result = result.replace("%o", m_optStringArg);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(81);if ((needsColorArg()) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(83) && false))
        {
            $qualityscroll_cover_jacov_probe_82a27a4150689a(82);String colorString = "empty";
            $qualityscroll_cover_jacov_probe_82a27a4150689a(84);if ((m_colorArg == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(86) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(85);colorString = "b";}
            else {$qualityscroll_cover_jacov_probe_82a27a4150689a(89);if ((m_colorArg == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_82a27a4150689a(91) && false))
                {$qualityscroll_cover_jacov_probe_82a27a4150689a(90);colorString = "w";}}
            $qualityscroll_cover_jacov_probe_82a27a4150689a(87);result = result.replace("%c", colorString);
        }
        $qualityscroll_cover_jacov_probe_82a27a4150689a(88);return result;
    }

    public void setColorArg(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(93);assert needsColorArg();
        m_colorArg = color;
    }

    public void setFileArg(File file)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(94);assert needsFileArg();
        m_fileArg = file;
    }

    public void setFileOpenArg(File file)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(95);assert needsFileOpenArg();
        m_fileOpenArg = file;
    }

    public void setFileSaveArg(File file)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(96);assert needsFileSaveArg();
        m_fileSaveArg = file;
    }

    public void setPointArg(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(97);m_pointArg = point;
    }

    public void setPointListArg(ConstPointList pointList)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(98);m_pointListArg = new PointList(pointList);
    }

    public void setStringArg(String value)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(99);assert needsStringArg();
        m_stringArg = value;
    }

    public void setOptStringArg(String value)
    {
        $qualityscroll_cover_jacov_probe_82a27a4150689a(100);assert needsOptStringArg();
        m_optStringArg = value;
    }

    private final AnalyzeDefinition m_definition;

    private GoColor m_colorArg;

    private File m_fileArg;

    private File m_fileOpenArg;

    private File m_fileSaveArg;

    private String m_optStringArg;

    private String m_stringArg;

    private GoPoint m_pointArg;

    private PointList m_pointListArg = new PointList();
}
