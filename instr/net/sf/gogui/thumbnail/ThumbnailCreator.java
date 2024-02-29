/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ThumbnailCreator.java

package net.sf.gogui.thumbnail;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.sf.gogui.boardpainter.BoardPainter;
import net.sf.gogui.boardpainter.BoardPainterUtil;
import net.sf.gogui.boardpainter.Field;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstGameInfo;
import net.sf.gogui.gamefile.GameFile;
import net.sf.gogui.gamefile.GameReader;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.version.Version;

/** Thumbnail creator.
    Creates thumbnails according to the freedesktop.org standard. */
public final class ThumbnailCreator
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ThumbnailCreator.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4872892444875118902L,/* translation unit id   */ 4862624858164124156L,/* timestamp             */ 1709177903042L,/* source file name      */ "ThumbnailCreator.java",/* probe size            */ 73);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_437b838b92db59fc(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Error thrown if thumbnail creation fails. */
    public static class Error
        extends ErrorMessage
    {
        public Error(String message)
        {
            super(message);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_437b838b92db59fc(0);
        }
    }

    public ThumbnailCreator(boolean verbose)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(1);m_verbose = verbose;
        m_painter = new BoardPainter();
    }

    /** Create thumbnail at standard location.
        Does not create the thumnbail if an up-to-date thumbnail already
        exists. */
    public void create(File input) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(2);File file = getThumbnailFileNormalSize(input);
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(3);if ((file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(5) && false))
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(4);URI uri = getURI(input);
            long lastModified = getLastModified(input);
            try
            {
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(6);ThumbnailReader.MetaData data = ThumbnailReader.read(file);
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(7);if ((uri.equals(data.m_uri)
                    && data.m_lastModified == lastModified) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(9) && false))
                {
                    $qualityscroll_cover_jacov_probe_437b838b92db59fc(8);m_lastThumbnail = file;
                    m_description = data.m_description;
                    return;
                }
            }
            catch (IOException e)
            {$qualityscroll_cover_jacov_probe_437b838b92db59fc(11);
            }
        }
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(10);create(input, null, 128, false);
    }

    /** Create thumbnail.
        @param input The SGF file
        @param output The output thumbnail. Null for standard filename in
        .thumbnails/normal
        @param thumbnailSize The image size of the thumbnail.
        @param scale If true thumbnailSize will be scaled down for boards
        smaller than 19. */
    public void create(File input, File output, int thumbnailSize,
                       boolean scale) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(12);assert thumbnailSize > 0;
        m_lastThumbnail = null;
        try
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(13);log("File: " + input);
            URI uri = getURI(input);
            log("URI: " + uri);
            m_description = "";
            ConstBoard board = readFile(input);
            int size = board.getSize();
            Field[][] fields = new Field[size][size];
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(14);for (int x = 0; (x < size) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(16) && false); ++x)
                {$qualityscroll_cover_jacov_probe_437b838b92db59fc(15);for (int y = 0; (y < size) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(41) && false); ++y)
                {
                    $qualityscroll_cover_jacov_probe_437b838b92db59fc(40);fields[x][y] = new Field();
                    GoColor color = board.getColor(GoPoint.get(x, y));
                    fields[x][y].setColor(color);
                }}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(17);int imageSize = thumbnailSize;
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(18);if ((scale) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(20) && false))
                {$qualityscroll_cover_jacov_probe_437b838b92db59fc(19);imageSize = Math.min(thumbnailSize * size / 19,
                                     thumbnailSize);}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(21);BufferedImage image;
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(22);if ((imageSize < 256) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(24) && false))
            {
                // Create large image and scale down, looks better than
                // creating small image
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(23);image = BoardPainterUtil.getImage(m_painter, fields,
                                                  2 * imageSize,
                                                  2 * imageSize);
                BufferedImage newImage
                    = BoardPainterUtil.createImage(imageSize, imageSize);
                Graphics2D graphics = newImage.createGraphics();
                Image scaledInstance
                    = image.getScaledInstance(imageSize, imageSize,
                                              Image.SCALE_SMOOTH);
                graphics.drawImage(scaledInstance, 0, 0, null);
                image = newImage;
            }
            else
                {$qualityscroll_cover_jacov_probe_437b838b92db59fc(39);image = BoardPainterUtil.getImage(m_painter, fields,
                                                  imageSize, imageSize);}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(25);if ((output == null) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(27) && false))
                {$qualityscroll_cover_jacov_probe_437b838b92db59fc(26);output = getThumbnailFileNormalSize(input);}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(28);long lastModified = getLastModified(input);
            Map<String,String> metaData = new TreeMap<String,String>();
            metaData.put("Thumb::URI", uri.toASCIIString());
            metaData.put("Thumb::MTime", Long.toString(lastModified));
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(29);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (m_gameFile.m_format)
            {
            case XML:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_437b838b92db59fc(30); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(33);metaData.put("Thumb::Mimetype", "application/x-go-sgf");
                break;
            case SGF:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_437b838b92db59fc(31); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(38);metaData.put("Thumb::Mimetype", "application/x-go+xml");
            default: if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_437b838b92db59fc(32); $qualityscroll_cover_jacov_switch_bool_0 = true; }  break;}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(34);if ((! m_description.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(36) && false))
                {$qualityscroll_cover_jacov_probe_437b838b92db59fc(35);metaData.put("Description", m_description);}
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(37);metaData.put("Software", "GoGui " + Version.get());
            // Renaming a temporary file as required by the standard does
            // not work, because File.renameTo may fail on some platforms
            //File tempFile = File.createTempFile("gogui-thumbnail", ".png");
            //tempFile.deleteOnExit();
            //ImageOutputStream ios
            //    = ImageIO.createImageOutputStream(tempFile);
            BoardPainterUtil.writeImage(image, output, metaData);
            //if (! tempFile.renameTo(output))
            //    throw new Error("Could not rename " + tempFile + " to "
            //                    + output);
            m_lastThumbnail = output;
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(42);throw new Error("File not found: " + input);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(43);throw new Error(e.getMessage());
        }
        catch (SgfError e)
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(44);throw new Error(e.getMessage());
        }
    }

    public String getLastDescription()
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(45);return m_description;
    }

    public File getLastThumbnail()
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(46);return m_lastThumbnail;
    }

    private final boolean m_verbose;

    private String m_description;

    private File m_lastThumbnail;

    private final BoardPainter m_painter;

    private GameFile m_gameFile;

    /** Read a file and return a position to use for the thumbnail.
        The position is the first position in the main variation that contains
        setup stones (unless they are handicap stones) or, if no such position
        exists, the last position. */
    private ConstBoard readFile(File file) throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(47);GameReader reader = new GameReader(file);
        m_gameFile = reader.getFile();
        ConstGameTree tree = reader.getTree();
        ConstGameInfo info = tree.getGameInfoConst(tree.getRootConst());
        m_description = info.suggestGameName();
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(48);if ((m_description == null) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(50) && false))
            {$qualityscroll_cover_jacov_probe_437b838b92db59fc(49);m_description = "";}
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(51);return ThumbnailUtil.getPosition(tree);
    }

    private long getLastModified(File file) throws Error
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(52);long lastModified = file.lastModified() / 1000L;
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(53);if ((lastModified == 0L) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(55) && false))
            {$qualityscroll_cover_jacov_probe_437b838b92db59fc(54);throw new Error("Could not get last modification time: " + file);}
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(56);return lastModified;
    }

    private String getMD5(String string) throws Error
    {
        try
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(57);MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] md5 = digest.digest(string.getBytes());
            StringBuilder buffer = new StringBuilder();
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(58);for (int i = 0; (i < md5.length) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(60) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_437b838b92db59fc(59);buffer.append(Integer.toHexString((md5[i] >> 4) & 0x0F));
                buffer.append(Integer.toHexString(md5[i] & 0x0F));
            }
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(61);return buffer.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            $qualityscroll_cover_jacov_probe_437b838b92db59fc(62);throw new Error("No MD5 message digest found");
        }
    }

    private File getThumbnailFileNormalSize(File file) throws Error
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(63);URI uri = getURI(file);
        String md5 = getMD5(uri.toASCIIString());
        return new File(ThumbnailPlatform.getNormalDir(), md5 + ".png");
    }

    private URI getURI(File file) throws Error
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(64);URI uri = FileUtil.getURI(file);
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(65);if ((uri == null) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(67) && false))
            {$qualityscroll_cover_jacov_probe_437b838b92db59fc(66);throw new Error("Invalid file name");}
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(68);return uri;
    }

    private void log(String line)
    {
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(69);if ((! m_verbose) ? true : (!$qualityscroll_cover_jacov_probe_437b838b92db59fc(71) && false))
            {$qualityscroll_cover_jacov_probe_437b838b92db59fc(70);return;}
        $qualityscroll_cover_jacov_probe_437b838b92db59fc(72);System.err.println(line);
    }
}
