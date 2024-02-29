/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// RecentFileStorage.java

package net.sf.gogui.unfinished;

import java.net.URI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** Recent file storage according to the Freedesktop standard.
    http://standards.freedesktop.org/recent-file-spec/0.2/
    @todo Implementation not finished yet. Don't use this class. */
public final class RecentFileStorage
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = RecentFileStorage.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6996916398854364278L,/* translation unit id   */ -8524867622501838L,/* timestamp             */ 1709177903913L,/* source file name      */ "RecentFileStorage.java",/* probe size            */ 59);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static final int MAX_ITEMS = 500;

    public static void add(URI uri, String mimetype)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(0);add(uri, mimetype, null, false);
    }

    /** @todo create empty document, if read document is invalid (e.g.
        no RecentFiles element)? */
    public static void add(URI uri, String mimetype, String group,
                           boolean isPrivate)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(1);updateFromFile();
        NodeList list = s_document.getElementsByTagName("RecentFiles");
        int length = list.getLength();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(2);if ((length == 0) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(4) && false))
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(3);System.err.println("error: no tag RecentFiles");
            return;
        }
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(5);if ((length > 1) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(7) && false))
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(6);System.err.println("warning: multiple tags RecentFiles");}
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(8);Node recentFiles = list.item(0);
        Element recentItem = s_document.createElement("RecentItem");
        recentFiles.appendChild(recentItem);
        Element uriElement = s_document.createElement("URI");
        uriElement.appendChild(s_document.createTextNode(uri.toString()));
        recentItem.appendChild(uriElement);
        Element timestampElement = s_document.createElement("Timestamp");
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        timestampElement.appendChild(s_document.createTextNode(timestamp));
        recentItem.appendChild(timestampElement);
        writeFile();
    }

    public static ArrayList<String> getAllMimeType(String mimeType)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(9);updateFromFile();
        ArrayList<String> result = new ArrayList<String>();
        NodeList nodeList = s_document.getElementsByTagName("RecentItem");
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(10);for (int i = 0; (i < nodeList.getLength()) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(12) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(11);Node element = nodeList.item(i);
            NamedNodeMap attributes = element.getAttributes();
            Node nodeMimeType = attributes.getNamedItem("Mime-Type");
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(14);if ((nodeMimeType == null) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(16) && false))
                {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(15);continue;}
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(17);String value = nodeMimeType.getNodeValue();
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(18);if ((! value.equals(mimeType)) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(20) && false))
                {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(19);continue;}
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(21);result.add(value);
        }
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(13);return result;
    }

    /** @todo Implement */
    public static URI[] getAllGroup(String group)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(22);return new URI[0];
    }

    /** Check if file was changed by another application.
        @return True if file was changed since the last invocation of one of
        the getAll methods or if it was not read yet. */
    public static boolean wasChanged()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(23);if ((s_document == null) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(25) && false))
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(24);return true;}
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(26);if ((! s_file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(28) && false))
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(27);return true;}
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(29);long currentTime = System.currentTimeMillis();
        return s_file.lastModified() > currentTime;
    }

    /** For temporary testing.
        @todo Remove later */
    public static void main(String[] args)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(30);ArrayList<String> uriList = getAllMimeType("application/x-go-sgf");
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(31);for (int i = 0; (i < uriList.size()) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(33) && false); ++i)
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(32);System.err.println(uriList.get(i));}
        //add(FileUtil.getURI(new File("foobar")), "application/x-go-sgf");
    }

    //private static long m_timestamp;

    /** Content of the recent files file. */
    private static Document s_document;

    private static DocumentBuilder s_builder;

    private static File s_file
        = new File(System.getProperties().getProperty("user.home"),
                   ".recently-used");

    static
    {
        try
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(57);s_builder
                = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(58);System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private RecentFileStorage()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(34);
    }

    private static void updateFromFile()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(35);if ((! wasChanged()) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(37) && false))
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(36);return;}
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(38);if ((s_builder == null) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(40) && false))
            {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(39);return;}
        //m_timestamp = System.currentTimeMillis();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(41);if ((! s_file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(43) && false))
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(42);createEmptyDocument();
            return;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(44);s_document = s_builder.parse(s_file);
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(45);return;
        }
        catch (SAXException saxe)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(47);Exception e = saxe;
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(48);if ((saxe.getException() != null) ? true : (!$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(50) && false))
                {$qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(49);e = saxe.getException();}
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(51);e.printStackTrace();
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(52);System.err.println(e.getMessage());
            e.printStackTrace();
        }
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(46);createEmptyDocument();
    }

    private static void createEmptyDocument()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(53);assert s_builder != null;
        s_document = s_builder.newDocument();
        Element recentFiles = s_document.createElement("RecentFiles");
        s_document.appendChild(recentFiles);
    }

    private static void writeFile()
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(54);s_document.normalize();
            Source source = new DOMSource(s_document);
            Result result = new StreamResult(s_file);
            Transformer transformer
                = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(source, result);
        }
        catch (TransformerConfigurationException e)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(55);System.err.println(e.getMessage());
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            $qualityscroll_cover_jacov_probe_ffe1b6ad959a8232(56);System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
