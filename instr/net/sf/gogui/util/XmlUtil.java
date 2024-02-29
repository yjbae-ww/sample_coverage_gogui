/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// XmlUtil.java

package net.sf.gogui.util;

/** Static utility functions related to XML. */
public final class XmlUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = XmlUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -876437501066861554L,/* translation unit id   */ -4429214688878796032L,/* timestamp             */ 1709177904235L,/* source file name      */ "XmlUtil.java",/* probe size            */ 38);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_c28844b51b6fe300(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Escape XML special characters for attribute values.
        This assumes that the attribute will be quotes with ", it does
        not escape '. Also strips invalid XML characters. */
    public static String escapeAttr(String text)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(0);int len = text.length();
        StringBuilder result = new StringBuilder(len);
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(1);for (int i = 0; (i < len) ? true : (!$qualityscroll_cover_jacov_probe_c28844b51b6fe300(3) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(2);char c = text.charAt(i);
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(5);if ((isInvalidXml(c)) ? true : (!$qualityscroll_cover_jacov_probe_c28844b51b6fe300(7) && false))
                {$qualityscroll_cover_jacov_probe_c28844b51b6fe300(6);continue;}
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(8);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (c)
            {
            case '>':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(9); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(14);result.append("&gt;");
                break;
            case '<':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(10); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(15);result.append("&lt;");
                break;
            case '&':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(11); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(16);result.append("&amp;");
                break;
            case '"':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(12); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(17);result.append("&quot;");
                break;
            default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(13); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(18);result.append(c);
            }
        }
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(4);return result.toString();
    }

    /** Escape XML special characters for text content.
        Also strips invalid XML characters. */
    public static String escapeText(String text)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(19);int len = text.length();
        StringBuilder result = new StringBuilder(len);
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(20);for (int i = 0; (i < len) ? true : (!$qualityscroll_cover_jacov_probe_c28844b51b6fe300(22) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(21);char c = text.charAt(i);
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(24);if ((isInvalidXml(c)) ? true : (!$qualityscroll_cover_jacov_probe_c28844b51b6fe300(26) && false))
                {$qualityscroll_cover_jacov_probe_c28844b51b6fe300(25);continue;}
            $qualityscroll_cover_jacov_probe_c28844b51b6fe300(27);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (c)
            {
            case '>':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(28); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(32);result.append("&gt;");
                break;
            case '<':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(29); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(33);result.append("&lt;");
                break;
            case '&':if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(30); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(34);result.append("&amp;");
                break;
            default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_c28844b51b6fe300(31); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_c28844b51b6fe300(35);result.append(c);
            }
        }
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(23);return result.toString();
    }

    /** Make constructor unavailable; class is for namespace only. */
    private XmlUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_c28844b51b6fe300(36);
    }

    /** See http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char */
    private static boolean isInvalidXml(char c)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_c28844b51b6fe300(37);return ! (c == 0x9 || c == 0xA || c == 0xD
                  || (c >= 0x20 && c <= 0xD7FF)
                  || (c >= 0xE000 && c <= 0xFFFD)
                  || (c >= 0x10000 && c <= 0x10FFFF));
    }
}
