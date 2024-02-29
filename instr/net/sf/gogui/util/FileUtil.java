/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// FileUtil.java

package net.sf.gogui.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/** Static file utility functions. */
public final class FileUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = FileUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8843138155789039108L,/* translation unit id   */ -8163345234499138341L,/* timestamp             */ 1709177903966L,/* source file name      */ "FileUtil.java",/* probe size            */ 59);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Return the file extension of a file name.
        @param file The file.
        @return File extension or null if file name has no extension. */
    public static String getExtension(File file)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(0);String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(1);if ((i > 0 &&  i < s.length() - 1) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(3) && false))
            {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(2);ext = s.substring(i + 1);}
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(4);return ext;
    }

    /** Returns relative URI between to files.
        Can be used instead of URI.relativize(), which  does not compute
        relative URI's correctly, if toFile is not a subdirectory of fromFile
        (Sun's Java 1.5.0).
        @todo Handle special charcters and file names containing slashes.
        @param fromFile File to compute the URI relative to.
        @param toFile Target file or directory.
        @return Relative URI. */
    public static String getRelativeURI(File fromFile, File toFile)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(5);assert ! fromFile.exists() || ! fromFile.isDirectory();
        fromFile = fromFile.getAbsoluteFile().getParentFile();
        assert fromFile != null;
        ArrayList<String> fromList = splitFile(fromFile);
        ArrayList<String> toList = splitFile(toFile);
        int fromSize = fromList.size();
        int toSize = toList.size();
        int i = 0;
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(6);while ((i < fromSize && i < toSize
               && fromList.get(i).equals(toList.get(i))) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(8) && false))
            {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(7);++i;}
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(9);StringBuilder result = new StringBuilder();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(10);for (int j = i; (j < fromSize) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(12) && false); ++j)
            {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(11);result.append("../");}
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(13);for (int j = i; (j < toSize) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(15) && false); ++j)
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(14);result.append(toList.get(j));
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(17);if ((j < toSize - 1) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(19) && false))
                {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(18);result.append('/');}
        }
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(16);return result.toString();
    }

    /** Return URI for file.
        Replacement for File.toURI() with defined (empty) authority. */
    public static URI getURI(File file)
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(20);return new URI("file", "", file.toURI().getPath(), null, null);
        }
        catch (URISyntaxException e)
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(21);return null;
        }
    }

    /** Check for extension (case-insensitive). */
    public static boolean hasExtension(File f, String extension)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(22);String ext = getExtension(f);
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(23);if ((ext == null) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(25) && false))
            {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(24);return false;}
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(26);return ext.equalsIgnoreCase(extension);
    }

    /** Read a list of strings from a file.
        The file is expected to contain one string per line; leading and
        trailing whitespaces are removed. Empty lines or lines beginning
        with the comment character '#' are ignored. */
    public static ArrayList<String> readStringListFromFile(File file)
        throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(27);ArrayList<String> result = new ArrayList<String>();
        FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);
        try
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(28);while (true)
            {
                $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(29);String line = in.readLine();
                $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(32);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(34) && false))
                    {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(33);break;}
                $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(35);line = line.trim();
                $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(36);if ((! line.equals("") && ! line.startsWith("#")) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(38) && false))
                    {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(37);result.add(line);}
            }
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(31);return result;
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(39);in.close();
        }
    }

    /** Remove extension in file name.
        If the file does not have the extension oldExtension,
        the extension will not be removed. */
    public static String removeExtension(File file, String oldExtension)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(40);String name = file.toString();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(41);if ((hasExtension(file, oldExtension)) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(43) && false))
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(42);int index = name.lastIndexOf('.');
            assert index >= 0;
            return name.substring(0, index);
        }
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(44);return name;
    }

    /** Replace extension in file name.
        If the file does not have the extension oldExtension,
        the extension will not be replaced but the new extension will be
        appended. */
    public static String replaceExtension(File file, String oldExtension,
                                          String newExtension)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(45);String name = file.toString();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(46);if ((hasExtension(file, oldExtension)) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(48) && false))
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(47);int index = name.lastIndexOf('.');
            assert index >= 0;
            return name.substring(0, index) + "." + newExtension;
        }
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(49);return name + "." + newExtension;
    }

    public static String replaceExtension(String file, String oldExtension,
                                          String newExtension)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(50);return replaceExtension(new File(file), oldExtension, newExtension);
    }

    /** Make constructor unavailable; class is for namespace only. */
    private FileUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(51);
    }

    private static ArrayList<String> splitFile(File file)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(52);ArrayList<String> list = new ArrayList<String>();
        file = file.getAbsoluteFile();
        try
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(53);file = file.getCanonicalFile();
        }
        catch (IOException e)
        {$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(58);
        }
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(54);while ((file != null) ? true : (!$qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(56) && false))
        {
            $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(55);list.add(0, file.getName());
            file = file.getParentFile();
        }
        $qualityscroll_cover_jacov_probe_8eb5f8c2aecd0cdb(57);return list;
    }
}
