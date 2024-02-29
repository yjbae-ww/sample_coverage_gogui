/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// BoardPainterUtil.java

package net.sf.gogui.boardpainter;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

/** Utility functions for users of class BoardPainter. */
public final class BoardPainterUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardPainterUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8610853313487851746L,/* translation unit id   */ -6727723126573230231L,/* timestamp             */ 1709177899570L,/* source file name      */ "BoardPainterUtil.java",/* probe size            */ 15);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_a2a253761d6c1769(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static BufferedImage createImage(int width, int height)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(0);return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    /** Use a painter to paint the board in a buffered image.
        The image can be written to a file with writeImage(). */
    public static BufferedImage getImage(BoardPainter painter,
                                         ConstField[][] field, int width,
                                         int height)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(1);BufferedImage image = createImage(width, height);
        Graphics2D graphics = image.createGraphics();
        painter.draw(graphics, field, width, false);
        graphics.dispose();
        return image;
    }

    /** Write an image in PNG format to a file.
        @param metaData Optional PNG meta data (or null) */
    public static void writeImage(BufferedImage image, File file,
                                  Map<String,String> metaData)
        throws IOException
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(2);Iterator iter = ImageIO.getImageWritersBySuffix("png");
        ImageWriter writer = (ImageWriter)iter.next();
        IIOMetadata meta = null;
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(3);if ((metaData != null) ? true : (!$qualityscroll_cover_jacov_probe_a2a253761d6c1769(5) && false))
        {
            $qualityscroll_cover_jacov_probe_a2a253761d6c1769(4);ImageTypeSpecifier specifier = new ImageTypeSpecifier(image);
            meta = writer.getDefaultImageMetadata(specifier, null);
            String formatName = "javax_imageio_1.0";
            org.w3c.dom.Node node = meta.getAsTree(formatName);
            $qualityscroll_cover_jacov_probe_a2a253761d6c1769(6);for (Map.Entry<String,String> entry : metaData.entrySet())
            {
                $qualityscroll_cover_jacov_probe_a2a253761d6c1769(12);String key = entry.getKey();
                String value = entry.getValue();
                addMeta(node, key, value);
            }
            try
            {
                $qualityscroll_cover_jacov_probe_a2a253761d6c1769(7);meta.mergeTree(formatName, node);
            }
            catch (IIOInvalidTreeException e)
            {
                $qualityscroll_cover_jacov_probe_a2a253761d6c1769(11);assert false;
                return;
            }
        }
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(8);ImageOutputStream ios = ImageIO.createImageOutputStream(file);
        writer.setOutput(ios);
        try
        {
            $qualityscroll_cover_jacov_probe_a2a253761d6c1769(9);writer.write(null, new IIOImage(image, null, meta), null);
        }
        catch (IllegalStateException e)
        {
            // ImageWriter on Linux Java 1.5 throws an  IllegalStateException
            // instead of an IOException, if it has no write permissions
            $qualityscroll_cover_jacov_probe_a2a253761d6c1769(10);throw new IOException("Could not write to file " + file);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private BoardPainterUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_a2a253761d6c1769(13);
    }

    private static void addMeta(org.w3c.dom.Node node, String keyword,
                                String value)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_a2a253761d6c1769(14);IIOMetadataNode text = new IIOMetadataNode("Text");
        IIOMetadataNode textEntry = new IIOMetadataNode("TextEntry");
        textEntry.setAttribute("value", value);
        textEntry.setAttribute("keyword", keyword);
        textEntry.setAttribute("encoding", Locale.getDefault().toString());
        textEntry.setAttribute("language", "en");
        textEntry.setAttribute("compression", "none");
        text.appendChild(textEntry);
        node.appendChild(text);
    }
}
