/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ThumbnailReader.java

package net.sf.gogui.thumbnail;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import net.sf.gogui.util.StringUtil;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/** Thumbnail reader. */
public final class ThumbnailReader
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ThumbnailReader.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1351564497272744643L,/* translation unit id   */ -8840905113051742280L,/* timestamp             */ 1709177903071L,/* source file name      */ "ThumbnailReader.java",/* probe size            */ 45);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Information about the original file stored in a thumbnail. */
    public static class MetaData
    {
        public URI m_uri;

        public long m_lastModified;

        public String m_mimeType;

        public String m_description;

        public String m_software;
    }

    public static void main(String argv[]) throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(0);for (String arg : argv)
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(1);System.out.println(arg);
            MetaData metaData = read(new File(arg));
            System.out.println("URI: " + metaData.m_uri);
            System.out.println("MTime: " + metaData.m_lastModified);
            System.out.println("MimeType: " + metaData.m_mimeType);
            System.out.println("Description: " + metaData.m_description);
            System.out.println("Software: " + metaData.m_software);
            System.out.println();
        }
    }

    public static MetaData read(File file) throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(2);MetaData metaData = new MetaData();
        ImageInputStream stream = ImageIO.createImageInputStream(file);
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(3);if ((stream == null) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(5) && false))
            {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(4);return metaData;}
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(6);Iterator iter = ImageIO.getImageReaders(stream);
        ImageReader reader = (ImageReader)iter.next();
        reader.setInput(stream, true);
        IIOMetadata metadata;
        try
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(7);metadata = reader.getImageMetadata(0);
        }
        catch (Throwable t)
        {
            // Some PNGs generate a NegativeArraySizeException in
            // com.sun.imageio.plugins.png.PNGImageReader.readMetadata
            // with Java 1.5. Ignore these PNGs until the problem is
            // understood.
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(21);StringUtil.printException(t);
            throw new IOException("Internal error reading PNG meta data");
        }
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(8);String formatName = "javax_imageio_1.0";
        Node root = metadata.getAsTree(formatName);
        String uri = getMeta(root, "Thumb::URI");
        try
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(9);if ((uri == null) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(11) && false))
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(10);warning(file, "no Thumb::URI");}
            else
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(19);metaData.m_uri = new URI(uri);}
        }
        catch (URISyntaxException e)
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(20);warning(file, "invalid Thumb::URI " + uri);
        }
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(12);String lastModified = getMeta(root, "Thumb::MTime");
        try
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(13);if ((lastModified == null) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(15) && false))
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(14);warning(file, "no Thumb::MTime");}
            else
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(17);metaData.m_lastModified =
                    Long.parseLong(getMeta(root, "Thumb::MTime"));}
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(18);warning(file, "invalid Thumb::MTime " + lastModified);
        }
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(16);metaData.m_mimeType = getMeta(root, "Thumb::Mimetype");
        metaData.m_description = getMeta(root, "Description");
        metaData.m_software = getMeta(root, "Software");
        return metaData;
    }

    /** Get meta data.
        @param node the (root) node of the meta data tree.
        @param key the key for the meta data.
        @return value or empty string if meta data does not exist. */
    private static String getMeta(Node node, String key)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(22);if (("TextEntry".equalsIgnoreCase(node.getNodeName())) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(24) && false))
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(23);String keyword = null;
            String value = null;
            NamedNodeMap attributes = node.getAttributes();
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(25);for (int i = 0; (i < attributes.getLength()) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(27) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(26);Node attribute = attributes.item(i);
                $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(38);if ((attribute.getNodeName().equals("keyword")) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(40) && false))
                    {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(39);keyword = attribute.getNodeValue();}
                else {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(41);if ((attribute.getNodeName().equals("value")) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(43) && false))
                    {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(42);value = attribute.getNodeValue();}}
            }
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(28);if ((key.equals(keyword)) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(30) && false))
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(29);return value;}
        }
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(31);for (Node child = node.getFirstChild(); (child != null) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(33) && false);
             child = child.getNextSibling())
        {
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(32);String value = getMeta(child, key);
            $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(35);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(37) && false))
                {$qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(36);return value;}
        }
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(34);return null;
    }

    private static void warning(File file, String message)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_854ecba40b9dbfb8(44);System.err.println(file + ": " + message);
    }
}
