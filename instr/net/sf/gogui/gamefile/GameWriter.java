/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GameWriter.java

package net.sf.gogui.gamefile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.sgf.SgfWriter;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.xml.XmlWriter;

public class GameWriter
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameWriter.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -595707766127251685L,/* translation unit id   */ -1626694653249479999L,/* timestamp             */ 1709177900204L,/* source file name      */ "GameWriter.java",/* probe size            */ 13);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GameWriter(GameFile gameFile, ConstGameTree tree,
                      String application, String version) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(0);OutputStream out;
        try
        {
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(1);out = new FileOutputStream(gameFile.m_file);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(12);throw new ErrorMessage(e.getMessage());
        }
        $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(2);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (gameFile.m_format)
        {
        case SGF:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(3); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(6);new SgfWriter(out, tree, application, version);
            break;
        case XML:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(4); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(7);String xmlApplication = application;
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(8);if ((xmlApplication != null && version != null) ? true : (!$qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(10) && false))
                {$qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(9);xmlApplication = xmlApplication + ":" + version;}
            $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(11);new XmlWriter(out, tree, xmlApplication);
            break;
        default: if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e96cd1d4db099ac1(5); $qualityscroll_cover_jacov_switch_bool_0 = true; }  break;}
    }
}
