/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123824) $$ */// XmlReader.java

package net.sf.gogui.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.game.MarkType;
import net.sf.gogui.game.Node;
import net.sf.gogui.game.StringInfo;
import net.sf.gogui.game.StringInfoColor;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidKomiException;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.Komi;
import net.sf.gogui.go.Move;
import net.sf.gogui.sgf.SgfUtil;
import net.sf.gogui.util.ByteCountInputStream;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.ProgressShow;

/** Read files in Jago's XML format.
    This class reads files in Jago's XML format, see
    http://www.rene-grothmann.de/jago. It can understand valid XML files
    according to the go.dtd from the Jago webpage (10/2007) and also handles
    some deviations used by Jago or in the examples used on the Jago
    webpage, see also the appendix "XML Format" of the GoGui documentation.
    The implementation uses SAX for memory efficient parsing of large files. */
public final class XmlReader
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = XmlReader.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7325168419071720169L,/* translation unit id   */ 3494875535075614946L,/* timestamp             */ 1709177904269L,/* source file name      */ "XmlReader.java",/* probe size            */ 759);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_30804ac85262a0e2(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Construct reader and read.
        @param progressShow Callback to show progress, can be null
        @param streamSize Size of stream if progressShow != null */
    public XmlReader(InputStream in, ProgressShow progressShow,
                     long streamSize)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(0);m_progressShow = progressShow;
        m_streamSize = streamSize;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(1);if ((progressShow != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(3) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(2);progressShow.showProgress(0);
            m_byteCountInputStream = new ByteCountInputStream(in);
            in = m_byteCountInputStream;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(4);m_isFirstElement = true;
            m_isFirstNode = true;
            m_gameInfoPreByoyomi = -1;
            m_root = new Node();
            // Don't create game info yet, because implicit empty root
            // might be truncated later
            m_info = new GameInfo();
            m_node = m_root;
            XMLReader reader = XMLReaderFactory.createXMLReader();
            try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(5);reader.setFeature("http://xml.org/sax/features/validation",
                                  false);
            }
            catch (SAXException e)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(17);
            }
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(6);Handler handler = new Handler();
            reader.setContentHandler(handler);
            reader.setEntityResolver(handler);
            reader.setErrorHandler(handler);
            reader.parse(new InputSource(in));
            int size;
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(7);if ((m_isBoardSizeKnown) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(9) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(8);size = m_boardSize;}
            else
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(16);size = Math.max(DEFAULT_BOARDSIZE, m_boardSize);}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(10);m_tree = new GameTree(size, m_root);
            m_tree.getGameInfo(m_root).copyFrom(m_info);
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(11);if ((m_gameName != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(13) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(12);m_root.addSgfProperty("GN", m_gameName);}
        }
        catch (SAXException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(18);throw new ErrorMessage(e.getMessage());
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(19);throw new ErrorMessage(e.getMessage());
        }
        finally
        {
            try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(14);in.close();
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(15);
            }
        }
    }

    public GameTree getTree()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(20);return m_tree;
    }

    public String getWarnings()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(21);if ((m_warnings.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(23) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(22);return null;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(24);StringBuilder result = new StringBuilder(m_warnings.size() * 80);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(25);for (String s : m_warnings)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(27);result.append(s);
            result.append('\n');
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(26);return result.toString();
    }

    private class Handler
        extends DefaultHandler
    {
        public void startElement(String namespaceURI, String name,
                                 String qualifiedName, Attributes atts)
            throws SAXException
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(28);if ((m_progressShow != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(30) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(29);showProgress();}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(31);checkNoCharacters();
            m_element = name;
            m_atts = atts;
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(32);if ((m_isFirstElement) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(34) && false))
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(33);if ((! m_element.equals("Go")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(36) && false))
                    {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(35);throw new SAXException("Not a Go game");}
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(37);m_isFirstElement = false;
            }
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(38);if ((name.equals("Annotation")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(40) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(39);startInfoElemWithoutFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(42);if ((name.equals("Application")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(44) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(43);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(45);if ((name.equals("AddBlack")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(47) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(46);startSetup(BLACK);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(48);if ((name.equals("AddWhite")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(50) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(49);startSetup(WHITE);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(51);if ((name.equals("Arg")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(53) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(52);checkParent("SGF");}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(54);if ((name.equals("at")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(56) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(55);checkParent("Black", "White", "AddBlack", "AddWhite", "Delete",
                            "Mark");}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(57);if ((name.equals("Black")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(59) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(58);startMove(BLACK);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(60);if ((name.equals("BlackPlayer")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(62) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(61);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(63);if ((name.equals("BlackRank")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(65) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(64);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(66);if ((name.equals("BlackTeam")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(68) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(67);startInfoElemWithoutFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(69);if ((name.equals("BlackToPlay")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(71) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(70);startToPlay(BLACK);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(72);if ((name.equals("BoardSize")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(74) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(73);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(75);if ((name.equals("Comment")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(77) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(76);startComment();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(78);if ((name.equals("Copyright")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(80) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(79);startCopyright();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(81);if ((name.equals("Date")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(83) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(82);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(84);if ((name.equals("Delete")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(86) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(85);startSetup(EMPTY);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(87);if ((name.equals("Go")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(89) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(88);startGo();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(90);if ((name.equals("GoGame")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(92) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(91);startGoGame();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(93);if ((name.equals("Handicap")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(95) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(94);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(96);if ((name.equals("Information")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(98) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(97);startInformation();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(99);if ((name.equals("Line")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(101) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(100);startLine();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(102);if ((name.equals("Komi")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(104) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(103);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(105);if ((name.equals("Mark")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(107) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(106);startMark();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(108);if ((name.equals("Node")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(110) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(109);startNode();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(111);if ((name.equals("Nodes")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(113) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(112);startNodes();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(114);if ((name.equals("P")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(116) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(115);startP();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(117);if ((name.equals("Result")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(119) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(118);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(120);if ((name.equals("Round")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(122) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(121);startInfoElemWithoutFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(123);if ((name.equals("Rules")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(125) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(124);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(126);if ((name.equals("Source")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(128) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(127);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(129);if ((name.equals("SGF")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(131) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(130);startSGF();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(132);if ((name.equals("Time")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(134) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(133);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(135);if ((name.equals("User")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(137) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(136);startInfoElemWithoutFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(138);if ((name.equals("Variation")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(140) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(139);startVariation();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(141);if ((name.equals("White")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(143) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(142);startMove(WHITE);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(144);if ((name.equals("WhitePlayer")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(146) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(145);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(147);if ((name.equals("WhiteRank")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(149) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(148);startInfoElemWithFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(150);if ((name.equals("WhiteTeam")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(152) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(151);startInfoElemWithoutFormat();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(153);if ((name.equals("WhiteToPlay")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(155) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(154);startToPlay(WHITE);}
            else
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(156);setWarning("Ignoring unknown element: " + name);}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(41);m_elementStack.push(name);
            m_characters.setLength(0);
        }

        public void endElement(String namespaceURI, String name,
                               String qualifiedName) throws SAXException
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(157);m_element = m_elementStack.pop();
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(158);if ((name.equals("AddBlack")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(160) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(159);endSetup(BLACK);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(162);if ((name.equals("AddWhite")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(164) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(163);endSetup(WHITE);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(165);if ((name.equals("Annotation")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(167) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(166);m_info.set(StringInfo.ANNOTATION, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(168);if ((name.equals("Arg")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(170) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(169);m_sgfArgs.add(getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(171);if ((name.equals("at")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(173) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(172);endAt();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(174);if ((name.equals("Black")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(176) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(175);endMove(BLACK);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(177);if ((name.equals("BlackPlayer")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(179) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(178);m_info.set(StringInfoColor.NAME, BLACK, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(180);if ((name.equals("BlackRank")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(182) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(181);m_info.set(StringInfoColor.RANK, BLACK, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(183);if ((name.equals("BlackTeam")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(185) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(184);m_info.set(StringInfoColor.TEAM, BLACK, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(186);if ((name.equals("BlackToPlay")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(188) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(187);endToPlay();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(189);if ((name.equals("BoardSize")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(191) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(190);endBoardSize();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(192);if ((name.equals("Comment")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(194) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(193);endComment();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(195);if ((name.equals("Copyright")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(197) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(196);endCopyright();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(198);if ((name.equals("Date")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(200) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(199);m_info.set(StringInfo.DATE, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(201);if ((name.equals("Delete")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(203) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(202);endSetup(EMPTY);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(204);if ((name.equals("Go")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(206) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(205);checkNoCharacters();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(207);if ((name.equals("GoGame")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(209) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(208);checkNoCharacters();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(210);if ((name.equals("Handicap")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(212) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(211);endHandicap();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(213);if ((name.equals("Information")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(215) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(214);checkNoCharacters();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(216);if ((name.equals("Komi")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(218) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(217);endKomi();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(219);if ((name.equals("Mark")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(221) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(220);endMark();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(222);if ((name.equals("Node")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(224) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(223);endNode();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(225);if ((name.equals("Nodes")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(227) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(226);checkNoCharacters();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(228);if ((name.equals("P")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(230) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(229);endP();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(231);if ((name.equals("Result")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(233) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(232);m_info.set(StringInfo.RESULT, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(234);if ((name.equals("Round")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(236) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(235);m_info.set(StringInfo.ROUND, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(237);if ((name.equals("Rules")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(239) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(238);m_info.set(StringInfo.RULES, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(240);if ((name.equals("SGF")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(242) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(241);endSgf();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(243);if ((name.equals("Source")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(245) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(244);m_info.set(StringInfo.SOURCE, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(246);if ((name.equals("Time")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(248) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(247);endTime();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(249);if ((name.equals("User")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(251) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(250);m_info.set(StringInfo.USER, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(252);if ((name.equals("White")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(254) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(253);endMove(WHITE);}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(255);if ((name.equals("WhitePlayer")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(257) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(256);m_info.set(StringInfoColor.NAME, WHITE, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(258);if ((name.equals("WhiteRank")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(260) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(259);m_info.set(StringInfoColor.RANK, WHITE, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(261);if ((name.equals("WhiteTeam")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(263) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(262);m_info.set(StringInfoColor.TEAM, WHITE, getCharacters());}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(264);if ((name.equals("WhiteToPlay")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(266) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(265);endToPlay();}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(267);if ((name.equals("Variation")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(269) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(268);endVariation();}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(161);m_characters.setLength(0);
        }

        public void characters(char[] ch, int start, int length)
            throws SAXException
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(270);m_characters.append(ch, start, length);
        }

        public void fatalError(SAXParseException e) throws SAXException
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(271);throwError(e.getMessage());
        }

        /** Return a fake go.dtd, if go.dtd does not exist as file.
            GoGui does not validate the document anyway, but this avoids a
            missing entity error message, if an XML file references go.dtd,
            but it is not found. */
        public InputSource resolveEntity(String publicId, String systemId)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(272);if ((systemId == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(274) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(273);return null;}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(275);URI uri;
            try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(276);uri = new URI(systemId);
            }
            catch (URISyntaxException e)
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(285);return null;
            }
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(277);if ((! "file".equals(uri.getScheme())) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(279) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(278);return null;}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(280);File file = new File(uri.getPath());
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(281);if ((file.exists() || ! "go.dtd".equals(file.getName())) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(283) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(282);return null;}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(284);String text = "<?xml version='1.0' encoding='UTF-8'?>";
            return new InputSource(new ByteArrayInputStream(text.getBytes()));
        }

        public void setDocumentLocator(Locator locator)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(286);m_locator = locator;
        }

        public void error(SAXParseException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(287);setWarning(e.getMessage());
        }

        public void warning(SAXParseException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(288);setWarning(e.getMessage());
        }
    }

    private static final int DEFAULT_BOARDSIZE = 19;

    private boolean m_isFirstElement;

    private boolean m_isFirstNode;

    private boolean m_isBoardSizeKnown;

    private int m_numberGames;

    private int m_numberTrees;

    /** Board size.
        If board size is not explicitely set, this variable is used to track
        the maximum size necessary for all points seen. */
    private int m_boardSize;

    private int m_lastPercent;

    private final long m_streamSize;

    /** Element stack. */
    private Stack<String> m_elementStack = new Stack<String>();

    /** Current node. */
    private Node m_node;

    private Stack<Node> m_variation = new Stack<Node>();

    private GameInfo m_info = new GameInfo();

    private Node m_root;

    private GameTree m_tree;

    /** Current element */
    private String m_element;

    /** Attributes of current element */
    private Attributes m_atts;

    /** Type of current SGF element. */
    private String m_sgfType;

    /** Arguments of current SGF element. */
    private ArrayList<String> m_sgfArgs = new ArrayList<String>();

    /** Characters in current element. */
    private StringBuilder m_characters = new StringBuilder();

    /** Contains strings with warnings. */
    private final Set<String> m_warnings = new TreeSet<String>();

    private Locator m_locator;

    /** Current mark type in Mark element. */
    private MarkType m_markType;

    /** Current label in Mark element. */
    private String m_label;

    private String m_gameName;

    private ByteCountInputStream m_byteCountInputStream;

    private final ProgressShow m_progressShow;

    /** Time settings information for current node from legacy SGF
        properties. */
    private int m_byoyomiMoves;

    /** Time settings information for current node from legacy SGF
        properties. */
    private long m_byoyomi;

    /** Time settings information for current node from legacy SGF
        properties. */
    private long m_preByoyomi;

    private long m_gameInfoPreByoyomi;

    /** Has current node inconsistent SGF/FF3 overtime settings properties. */
    private boolean m_ignoreOvertime;

    private String m_paragraphElementText;

    private void checkAttributes(String... atts) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(289);List<String> list = Arrays.asList(atts);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(290);for (int i = 0; (i < m_atts.getLength()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(292) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(291);String name = m_atts.getLocalName(i);
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(293);if ((! list.contains(name)) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(295) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(294);setWarning("Unknown attribute \"" + name + "\" for element \""
                           + m_element + "\"");}
        }
    }

    private void checkNoCharacters() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(296);if ((! getCharacters().trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(298) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(297);setWarning("Cannot handle text content in element \"" + m_element
                       + "\"");}
    }

    private void checkRoot() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(299);String parent = parentElement();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(300);if ((parent != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(302) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(301);throwError("Element \"" + m_element + "\" cannot be child of \""
                       + parent + "\"");}
    }

    private void checkParent(String... parents) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(303);String parent = parentElement();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(304);if ((! Arrays.asList(parents).contains(parent)) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(306) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(305);throwError("Element \"" + m_element + "\" cannot be child of \""
                       + parent + "\"");}
    }

    private void createNode()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(307);Node node = new Node();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(308);if ((m_node != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(310) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(309);m_node.append(node);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(312);if ((! m_variation.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(314) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(313);m_variation.peek().getFather().append(node);}}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(311);m_node = node;
    }

    private void endAt() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(315);GoPoint p = getPoint(getCharacters());
        String parent = parentElement();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(316);if ((parent.equals("Black")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(318) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(317);m_node.setMove(Move.get(BLACK, p));}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(319);if ((parent.equals("White")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(321) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(320);m_node.setMove(Move.get(WHITE, p));}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(322);if ((parent.equals("AddBlack")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(324) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(323);m_node.addStone(BLACK, p);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(325);if ((parent.equals("AddWhite")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(327) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(326);m_node.addStone(WHITE, p);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(328);if ((parent.equals("Delete")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(330) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(329);m_node.addStone(EMPTY, p);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(331);if ((parent.equals("Mark")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(333) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(332);if ((m_markType != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(335) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(334);m_node.addMarked(p, m_markType);}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(336);if ((m_label != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(338) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(337);m_node.setLabel(p, m_label);}
        }}}}}}
    }

    private void endBoardSize() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(339);int boardSize = parseInt();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(340);if ((boardSize < 1 || boardSize > GoPoint.MAX_SIZE) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(342) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(341);throw new SAXException("Unsupported board size");}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(343);m_isBoardSizeKnown = true;
        m_boardSize = boardSize;
    }

    private void endComment()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(344);m_node.setComment(getParagraphElementText());
    }

    private void endCopyright()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(345);m_info.set(StringInfo.COPYRIGHT, getParagraphElementText());
    }

    private void endHandicap() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(346);int handicap = parseInt();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(347);if ((handicap == 1 || handicap < 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(349) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(348);setWarning("Ignoring invalid handicap: " + handicap);}
        else
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(350);m_info.setHandicap(handicap);}
    }

    private void endKomi() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(351);String komi = getCharacters();
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(352);m_info.setKomi(Komi.parseKomi(komi));
        }
        catch (InvalidKomiException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(353);setWarning("Invalid komi: " + komi);
        }
    }

    private void endMark() throws SAXException
    {
        // According to the DTD, mark cannot contain
        // text content, but we accept it, if the point is text content
        // instead of a at-subelement or an at-attribute
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(354);String value = getCharacters();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(355);if ((! value.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(357) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(356);GoPoint p = getPoint(value);
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(358);if ((m_markType != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(360) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(359);m_node.addMarked(p, m_markType);}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(361);if ((m_label != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(363) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(362);m_node.setLabel(p, m_label);}
        }
    }

    private void endMove(GoColor c) throws SAXException
    {
        // According to the DTD, Black and White cannot contain text
        // content, but we accept it, if the move is text content instead
        // of a at-subelement or an at-attribute
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(364);String value = getCharacters();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(365);if ((! value.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(367) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(366);m_node.setMove(Move.get(c, getPoint(value)));}
    }

    private void endNode() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(368);checkNoCharacters();
        setSgfTimeSettings();
    }

    private void endP() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(369);m_paragraphElementText =
            m_paragraphElementText + getMergedLines() + "\n";
    }

    private void endSetup(GoColor c) throws SAXException
    {
        // According to the DTD, AddBlack, AddWhite, and Delete cannot contain
        // text content, but we accept it, if the point is text content instead
        // of a at-subelement or an at-attribute
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(370);String value = getCharacters();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(371);if ((! value.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(373) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(372);m_node.addStone(c, getPoint(value));}
    }

    private void endSgf() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(374);checkNoCharacters();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(375);if ((m_sgfType == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(377) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(376);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(378);if ((m_sgfType.equals("AN")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(380) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(379);endSgfInfo(StringInfo.ANNOTATION);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(381);if ((m_sgfType.equals("BL")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(383) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(382);endSgfTimeLeft(BLACK);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(384);if ((m_sgfType.equals("BR")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(386) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(385);endSgfInfo(StringInfoColor.RANK, BLACK);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(387);if ((m_sgfType.equals("BT")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(389) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(388);endSgfInfo(StringInfoColor.TEAM, BLACK);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(390);if ((m_sgfType.equals("CP")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(392) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(391);endSgfInfo(StringInfo.COPYRIGHT);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(393);if ((m_sgfType.equals("DT")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(395) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(394);endSgfInfo(StringInfo.DATE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(396);if ((m_sgfType.equals("HA")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(398) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(397);endSgfHandicap();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(399);if ((m_sgfType.equals("OB")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(401) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(400);endSgfMovesLeft(BLACK);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(402);if ((m_sgfType.equals("OM")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(404) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(403);endSgfOvertimeMoves();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(405);if ((m_sgfType.equals("OP")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(407) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(406);endSgfOvertimePeriod();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(408);if ((m_sgfType.equals("OT")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(410) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(409);endSgfOvertime();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(411);if ((m_sgfType.equals("OW")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(413) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(412);endSgfMovesLeft(WHITE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(414);if ((m_sgfType.equals("KM")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(416) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(415);endSgfKomi();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(417);if ((m_sgfType.equals("PB")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(419) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(418);endSgfInfo(StringInfoColor.NAME, BLACK);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(420);if ((m_sgfType.equals("PW")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(422) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(421);endSgfInfo(StringInfoColor.NAME, WHITE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(423);if ((m_sgfType.equals("PL")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(425) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(424);endSgfPlayer();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(426);if ((m_sgfType.equals("RE")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(428) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(427);endSgfInfo(StringInfo.RESULT);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(429);if ((m_sgfType.equals("RO")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(431) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(430);endSgfInfo(StringInfo.ROUND);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(432);if ((m_sgfType.equals("RU")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(434) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(433);endSgfInfo(StringInfo.RULES);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(435);if ((m_sgfType.equals("SL")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(437) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(436);endSgfSelect();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(438);if ((m_sgfType.equals("WL")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(440) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(439);endSgfTimeLeft(WHITE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(441);if ((m_sgfType.equals("TM")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(443) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(442);endSgfTime();}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(444);if ((m_sgfType.equals("WR")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(446) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(445);endSgfInfo(StringInfoColor.RANK, WHITE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(447);if ((m_sgfType.equals("WT")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(449) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(448);endSgfInfo(StringInfoColor.TEAM, WHITE);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(450);if ((m_sgfType.equals("US")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(452) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(451);endSgfInfo(StringInfo.USER);}
        else
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(453);m_node.addSgfProperty(m_sgfType, m_sgfArgs);}}}}}}}}}}}}}}}}}}}}}}}}}
    }

    /** Handle non-root handicap info from SGF properties. */
    private void endSgfHandicap()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(454);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(456) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(455);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(457);int handicap = Integer.parseInt(m_sgfArgs.get(0));
            GameInfo info = m_node.createGameInfo();;
            info.setHandicap(handicap);
        }
        catch (NumberFormatException e)
        {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(458);
        }
    }

    /** Handle non-root game info from SGF properties. */
    private void endSgfInfo(StringInfo type)
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(459);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(461) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(460);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(462);GameInfo info = m_node.createGameInfo();;
        info.set(type, m_sgfArgs.get(0));
    }

    /** Handle non-root game info from SGF properties. */
    private void endSgfInfo(StringInfoColor type, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(463);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(465) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(464);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(466);GameInfo info = m_node.createGameInfo();;
        info.set(type, c, m_sgfArgs.get(0));
    }

    /** Handle non-root komi from SGF properties. */
    private void endSgfKomi()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(467);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(469) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(468);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(470);Komi komi = Komi.parseKomi(m_sgfArgs.get(0));
            GameInfo info = m_node.createGameInfo();;
            info.setKomi(komi);
        }
        catch (InvalidKomiException e)
        {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(471);
        }
    }

    private void endSgfMovesLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(472);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(474) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(473);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(475);int movesLeft = Integer.parseInt(m_sgfArgs.get(0));
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(476);if ((movesLeft >= 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(478) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(477);m_node.setMovesLeft(c, movesLeft);}
        }
        catch (NumberFormatException e)
        {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(479);
        }
    }

    /** FF4 OT property */
    private void endSgfOvertime()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(480);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(482) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(481);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(483);String value = m_sgfArgs.get(0).trim();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(484);if ((value.equals("") || value.equals("-")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(486) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(485);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(487);SgfUtil.Overtime overtime = SgfUtil.parseOvertime(value);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(488);if ((overtime == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(490) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(489);setWarning("Overtime settings in unknown format");
            m_node.addSgfProperty("OT", value); // Preserve information
        }
        else
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(491);m_byoyomi = overtime.m_byoyomi;
            m_byoyomiMoves = overtime.m_byoyomiMoves;
        }
    }

    /** FF3 OM property */
    private void endSgfOvertimeMoves()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(492);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(494) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(493);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(495);m_byoyomiMoves = Integer.parseInt(m_sgfArgs.get(0));
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(496);setWarning("Invalid value for byoyomi moves");
            m_ignoreOvertime = true;
        }
    }

    /** FF3 OP property */
    private void endSgfOvertimePeriod()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(497);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(499) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(498);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(500);m_byoyomi = (long)(Double.parseDouble(m_sgfArgs.get(0)) * 1000);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(501);setWarning("Invalid value for byoyomi time");
            m_ignoreOvertime = true;
        }
    }

    private void endSgfPlayer()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(502);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(504) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(503);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(505);String value = m_sgfArgs.get(0).trim().toLowerCase(Locale.ENGLISH);
        GoColor c;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(506);if ((value.equals("b") || value.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(508) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(507);c = BLACK;}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(510);if ((value.equals("w") || value.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(512) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(511);c = WHITE;}
        else
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(513);return;}}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(509);m_node.setPlayer(c);
    }

    private void endSgfSelect() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(514);for (int i = 0; (i < m_sgfArgs.size()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(516) && false); ++i)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(515);m_node.addMarked(getSgfPoint(m_sgfArgs.get(i)), MarkType.SELECT);}
    }

    /** Handle BL, WL SGF properties.
        XmlWriter uses these legacy SGF properties to preserve time left
        information that cannot be stored in a timleft-attribute of a move,
        because the node has no move or not a move of the corresponding color.
        Jago's blacktime/whitetime Node-attribute is not defined in
        go.dtd (2007) */
    private void endSgfTimeLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(517);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(519) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(518);return;}
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(520);double timeLeft = Double.parseDouble(m_sgfArgs.get(0));
            m_node.setTimeLeft(c, timeLeft);
        }
        catch (NumberFormatException e)
        {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(521);
        }
    }

    private void endSgfTime()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(522);if ((m_sgfArgs.size() == 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(524) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(523);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(525);String value = m_sgfArgs.get(0).trim();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(526);if ((value.equals("") || value.equals("-")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(528) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(527);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(529);long preByoyomi = SgfUtil.parseTime(value);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(530);if ((preByoyomi < 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(532) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(531);setWarning("Unknown format in time property");
            m_node.addSgfProperty("TM", value); // Preserve information
        }
        else
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(533);m_preByoyomi = preByoyomi;}

    }

    private void endTime() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(534);String value = getCharacters().trim();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(535);if ((value.equals("") || value.equals("-")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(537) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(536);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(538);long preByoyomi = SgfUtil.parseTime(value);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(539);if ((preByoyomi < 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(541) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(540);setWarning("Unknown format in Time element");
            m_node.addSgfProperty("TM", value); // Preserve information
        }
        else
        {
            // Set time settings now but also remember value, because time
            // settings could be overwritten in setSgfTimeSettings() after
            // overtime information is known from SGF element
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(542);m_gameInfoPreByoyomi = preByoyomi;
            TimeSettings timeSettings = new TimeSettings(preByoyomi);
            m_info.setTimeSettings(timeSettings);
        }
    }

    private void endToPlay() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(543);if ((! getCharacters().trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(545) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(544);setWarning("Ignoring text content in element \"" + m_element
                       + "\"");}
    }

    private void endVariation() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(546);checkNoCharacters();
        m_node = m_variation.pop();
    }

    private String getCharacters()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(547);return m_characters.toString();
    }

    private String getMergedLines()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(548);String chars = getCharacters();
        StringBuilder result = new StringBuilder(chars.length());
        BufferedReader reader = new BufferedReader(new StringReader(chars));
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(549);String line;
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(550);while (((line = reader.readLine()) != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(552) && false))
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(551);if ((result.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(555) && false))
                    {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(554);result.append(' ');}
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(556);result.append(line);
            }
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(557);assert(false);
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(553);return result.toString();
    }

    private String getParagraphElementText()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(558);String text = m_paragraphElementText;
        String mergedLines = getMergedLines();
        // Handle direct text content even if not allowed by DTD
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(559);if ((! mergedLines.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(561) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(560);text = text + mergedLines + "\n";}
        // Remove exactly one trailing newline
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(562);if ((text.endsWith("\n")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(564) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(563);text = text.substring(0, text.length() - 1);}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(565);return text;
    }

    private GoPoint getPoint(String value) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(566);value = value.trim();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(567);if ((value.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(569) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(568);return null;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(570);GoPoint p;
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(571);if ((m_isBoardSizeKnown) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(573) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(572);p = GoPoint.parsePoint(value, m_boardSize);}
            else
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(575);p = GoPoint.parsePoint(value, GoPoint.MAX_SIZE);
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(576);if ((p != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(578) && false))
                {
                    $qualityscroll_cover_jacov_probe_30804ac85262a0e2(577);m_boardSize = Math.max(m_boardSize, p.getX());
                    m_boardSize = Math.max(m_boardSize, p.getY());
                }
            }
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(574);return p;
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(580);throwError(e.getMessage());
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(579);return null; // Unreachable; avoid compiler error
    }

    private GoPoint getSgfPoint(String s) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(581);s = s.trim().toLowerCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(582);if ((s.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(584) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(583);return null;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(585);if ((s.length() > 2
            || (s.length() == 2 && s.charAt(1) < 'a' || s.charAt(1) > 'z')) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(587) && false))
            // Human-readable encoding as used by SmartGo
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(586);return getPoint(s);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(588);if ((s.length() != 2) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(590) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(589);throwError("Invalid SGF coordinates: " + s);}}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(591);if ((! m_isBoardSizeKnown) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(593) && false))
        {
            // We need to know the boardsize for parsing SGF points to mirror
            // the y-coordinate and the size is not allowed to change later
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(592);m_boardSize = DEFAULT_BOARDSIZE;
            m_isBoardSizeKnown = true;
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(594);if ((s.equals("tt") && m_boardSize <= 19) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(596) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(595);return null;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(597);int x = s.charAt(0) - 'a';
        int y = m_boardSize - (s.charAt(1) - 'a') - 1;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(598);if ((x < 0 || x >= m_boardSize || y < 0 || y >= m_boardSize) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(600) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(599);if ((x == m_boardSize && y == -1) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(602) && false))
                // Some programs encode pass moves, e.g. as jj for boardsize 9
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(601);return null;}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(603);throwError("Coordinates \"" + s + "\" outside board size "
                       + m_boardSize);
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(604);return GoPoint.get(x, y);
    }

    private void setSgfTimeSettings()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(605);long preByoyomi = m_preByoyomi;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(606);if ((m_node == m_root && preByoyomi < 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(608) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(607);preByoyomi = m_gameInfoPreByoyomi;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(609);TimeSettings s = null;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(610);if ((preByoyomi > 0
            && (m_ignoreOvertime || m_byoyomi <= 0 || m_byoyomiMoves <= 0)) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(612) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(611);s = new TimeSettings(preByoyomi);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(619);if ((preByoyomi <= 0 && ! m_ignoreOvertime && m_byoyomi > 0
                 && m_byoyomiMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(621) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(620);s = new TimeSettings(0, m_byoyomi, m_byoyomiMoves);}
        else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(622);if ((preByoyomi > 0  && ! m_ignoreOvertime && m_byoyomi > 0
                 && m_byoyomiMoves > 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(624) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(623);s = new TimeSettings(preByoyomi, m_byoyomi, m_byoyomiMoves);}}}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(613);if ((s != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(615) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(614);if ((m_node == m_root) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(617) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(616);m_info.setTimeSettings(s);}
            else
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(618);m_node.createGameInfo().setTimeSettings(s);}
        }
    }

    private void showProgress()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(625);int percent;
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(626);if ((m_streamSize > 0) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(628) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(627);long count = m_byteCountInputStream.getCount();
            percent = (int)(count * 100 / m_streamSize);
        }
        else
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(633);percent = 100;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(629);if ((percent != m_lastPercent) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(631) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(630);m_progressShow.showProgress(percent);}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(632);m_lastPercent = percent;
    }

    private void startComment() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(634);checkParent("Nodes", "Node", "Variation");
        checkAttributes();
        m_paragraphElementText = "";
    }

    private void startCopyright() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(635);checkParent("Information");
        checkAttributes();
        m_paragraphElementText = "";
    }

    private void startGo() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(636);checkRoot();
        checkAttributes();
    }

    private void startGoGame() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(637);checkParent("Go");
        checkAttributes("name");
        String name = m_atts.getValue("name");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(638);if ((name != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(640) && false))
            // Not supported in game.GameInformation, put it in later
            // in SGF properties
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(639);m_gameName = name;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(641);if ((++m_numberGames > 1) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(643) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(642);throwError("Multiple games per file not supported");}
    }

    private void startInfoElemWithFormat() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(644);checkParent("Information");
        checkAttributes("format");
        String format = m_atts.getValue("format");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(645);if ((format == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(647) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(646);return;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(648);format = format.trim().toLowerCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(649);if ((! format.equals("sgf")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(651) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(650);setWarning("Unknown format attribute \"" + format
                       + "\" for element \"" + m_element + "\"");}
    }

    private void startInfoElemWithoutFormat() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(652);checkParent("Information");
        checkAttributes();
    }

    private void startInformation() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(653);checkParent("GoGame");
        checkAttributes();
    }

    private void startLine() throws SAXException
    {
        // Line has no legal parent according to the DTD, so we
        // ignore it
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(654);setWarning("Element \"Line\" cannot be child of element \""
                   + parentElement() + "\"");
    }

    private void startMark() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(655);checkParent("Node");
        checkAttributes("at", "label", "territory", "type");
        m_markType = null;
        m_label = m_atts.getValue("label");
        String type = m_atts.getValue("type");
        String territory = m_atts.getValue("territory");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(656);if ((type != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(658) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(657);if ((type.equals("triangle")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(660) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(659);m_markType = MarkType.TRIANGLE;}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(683);if ((type.equals("circle")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(685) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(684);m_markType = MarkType.CIRCLE;}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(686);if ((type.equals("square")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(688) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(687);m_markType = MarkType.SQUARE;}
            else
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(689);setWarning("Unknown mark type " + type);}}}
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(661);if ((territory != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(663) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(662);if ((territory.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(665) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(664);m_markType = MarkType.TERRITORY_BLACK;}
            else {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(679);if ((territory.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(681) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(680);m_markType = MarkType.TERRITORY_WHITE;}
            else
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(682);setWarning("Unknown territory type " + territory);}}
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(666);if ((type == null && territory == null && m_label == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(668) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(667);m_markType = MarkType.MARK;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(669);String value = m_atts.getValue("at");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(670);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(672) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(671);GoPoint p = getPoint(value);
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(673);if ((m_markType != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(675) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(674);m_node.addMarked(p, m_markType);}
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(676);if ((m_label != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(678) && false))
                {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(677);m_node.setLabel(p, m_label);}
        }
    }

    private void startMove(GoColor c) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(690);checkParent("Node", "Nodes", "Variation");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(691);if ((! parentElement().equals("Node")) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(693) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(692);createNode();}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(694);checkAttributes("annotate", "at", "timeleft", "name", "number");
        String name = m_atts.getValue("name");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(695);if ((name != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(697) && false))
            // Not supported in game.Node, put it in SGF properties
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(696);m_node.addSgfProperty("N", name);}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(698);if ((m_atts.getValue("annotate") != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(700) && false))
            // Allowed by DTD, but unclear content and not supported in
            // game.Node
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(699);setWarning("Attribute \"annotate\" in element \""
                       + m_element + "\" not supported");}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(701);String value = m_atts.getValue("at");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(702);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(704) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(703);m_node.setMove(Move.get(c, getPoint(value)));}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(705);value = m_atts.getValue("timeleft");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(706);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(708) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(707);try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(709);m_node.setTimeLeft(c, Double.parseDouble(value));
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(710);
            }
        }
    }

    private void startNode() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(711);checkParent("Nodes", "Variation");
        // blacktime and whitetime are not allowed in the DTD, but used
        // by Jago 5.0
        checkAttributes("blacktime", "name", "whitetime");
        // Don't create new node, if this is the first node and nothing
        // was added to the root node yet. This allows having an implicit
        // root node to handle cases like Comment being the first child of
        // Nodes (example on Jago's webpage) without creating an unnecessary
        // node if the first child of Nodes is a Node
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(712);if ((! m_isFirstNode || ! m_node.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(714) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(713);createNode();}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(715);m_isFirstNode = false;
        String name = m_atts.getValue("name");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(716);if ((name != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(718) && false))
            // Not supported in game.Node, put it in SGF properties
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(717);m_node.addSgfProperty("N", name);}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(719);String value = m_atts.getValue("blacktime");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(720);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(722) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(721);try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(723);m_node.setTimeLeft(BLACK, Double.parseDouble(value));
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(731);
            }
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(724);value = m_atts.getValue("whitetime");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(725);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(727) && false))
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(726);try
            {
                $qualityscroll_cover_jacov_probe_30804ac85262a0e2(728);m_node.setTimeLeft(WHITE, Double.parseDouble(value));
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(730);
            }
        }
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(729);m_ignoreOvertime = false;
        m_byoyomiMoves = -1;
        m_byoyomi = -1;
        m_preByoyomi = -1;
    }

    private void startNodes() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(732);checkParent("GoGame");
        checkAttributes();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(733);if ((++m_numberTrees > 1) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(735) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(734);throwError("More than one Nodes element in element GoGame");}
    }

    private void startP() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(736);checkParent("Comment", "Copyright");
        checkAttributes();
    }

    private void startSetup(GoColor c) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(737);checkParent("Node");
        checkAttributes("at");
        String value = m_atts.getValue("at");
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(738);if ((value != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(740) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(739);m_node.addStone(c, getPoint(value));}
    }

    private void startSGF() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(741);checkParent("Node");
        checkAttributes("type");
        m_sgfType = m_atts.getValue("type");
        m_sgfArgs.clear();
    }

    private void startToPlay(GoColor c) throws SAXException
    {
        // According to the DTD, BlackToPlay and WhiteToPlay can never
        // occur in a valid document, because they have no legal parent.
        // I assume that they were meant to be child elements of Node
        // and set the player in setup positions
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(742);checkParent("Node");
        checkAttributes();
        m_node.setPlayer(c);
    }

    private void startVariation() throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(743);checkParent("Nodes", "Variation");
        checkAttributes();
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(744);if ((m_node == null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(746) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(745);throwError("Variation without main node");}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(747);assert m_node.hasFather();
        m_variation.push(m_node);
        m_node = null;
    }

    private String parentElement()
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(748);if ((m_elementStack.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(750) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(749);return null;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(751);return m_elementStack.peek();
    }

    private int parseInt() throws SAXException
    {
        try
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(752);return Integer.parseInt(getCharacters());
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_30804ac85262a0e2(753);throw new SAXException("Expected integer in element " + m_element);
        }
    }

    private void setWarning(String message)
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(754);m_warnings.add(message);
    }

    private void throwError(String message) throws SAXException
    {
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(755);if ((m_locator != null) ? true : (!$qualityscroll_cover_jacov_probe_30804ac85262a0e2(757) && false))
            {$qualityscroll_cover_jacov_probe_30804ac85262a0e2(756);message = "Line " + m_locator.getLineNumber() + ":"
                + m_locator.getColumnNumber() + ": " + message;}
        $qualityscroll_cover_jacov_probe_30804ac85262a0e2(758);throw new SAXException(message);
    }
}
