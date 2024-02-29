/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ThumbnailUtil.java

package net.sf.gogui.thumbnail;

import java.io.File;
import java.io.IOException;
import net.sf.gogui.game.BoardUpdater;
import net.sf.gogui.game.ConstGameTree;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.Board;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.util.FileUtil;

/** Untility functions for managing the thumbnail directory. */
public final class ThumbnailUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ThumbnailUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1701406912534827082L,/* translation unit id   */ 7361529516950359815L,/* timestamp             */ 1709177903088L,/* source file name      */ "ThumbnailUtil.java",/* probe size            */ 38);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_66296817b5610f07(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Expire all thumbnails older than a certain age.
        NOTE: This function is still experimental, it may not work yet */
    public static void expire(int seconds, boolean checkOnly)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_66296817b5610f07(0);if ((! ThumbnailPlatform.checkThumbnailSupport()) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(2) && false))
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(1);System.err.println("Thumbnails not supported on this platform.");
            return;
        }
        $qualityscroll_cover_jacov_probe_66296817b5610f07(3);File dir = ThumbnailPlatform.getNormalDir();
        long currentTimeSeconds = System.currentTimeMillis() / 1000L;
        System.err.println("Expiring thumbnails. Time: "
                           + currentTimeSeconds);
        $qualityscroll_cover_jacov_probe_66296817b5610f07(4);for (File file : dir.listFiles())
            {$qualityscroll_cover_jacov_probe_66296817b5610f07(5);expire(file, currentTimeSeconds, seconds, checkOnly);}
    }

    /** Expire thumbnails if older than a certain age.
        NOTE: This function is still experimental, it may not work yet */
    public static void expire(File file, long currentTimeSeconds,
                              long seconds, boolean checkOnly)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_66296817b5610f07(6);if ((! file.isFile()) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(8) && false))
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(7);System.err.println("Not a normal file: " + file);
            return;
        }
        $qualityscroll_cover_jacov_probe_66296817b5610f07(9);if ((! FileUtil.hasExtension(file, "png")) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(11) && false))
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(10);System.err.println("Not a thumbnail: " + file);
            return;
        }
        $qualityscroll_cover_jacov_probe_66296817b5610f07(12);ThumbnailReader.MetaData metaData;
        try
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(13);metaData = ThumbnailReader.read(file);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(30);System.err.println("Could not read meta data: " + file);
            return;
        }
        $qualityscroll_cover_jacov_probe_66296817b5610f07(14);System.err.println("File: " + file);
        System.err.println("  URI: " + metaData.m_uri);
        System.err.println("  MTime: " + metaData.m_lastModified);
        System.err.println("  MimeType: " + metaData.m_mimeType);
        System.err.println("  Software: " + metaData.m_software);
        System.err.println("  Description: " + metaData.m_description);
        $qualityscroll_cover_jacov_probe_66296817b5610f07(15);if ((metaData.m_lastModified == 0) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(17) && false))
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(16);System.err.println("  No MTime meta data");
            return;
        }
        $qualityscroll_cover_jacov_probe_66296817b5610f07(18);long age = currentTimeSeconds - metaData.m_lastModified;
        $qualityscroll_cover_jacov_probe_66296817b5610f07(19);if ((age > seconds) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(21) && false))
        {
            $qualityscroll_cover_jacov_probe_66296817b5610f07(20);if ((checkOnly) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(23) && false))
                {$qualityscroll_cover_jacov_probe_66296817b5610f07(22);System.err.println("  Would expire");}
            else
            {
                $qualityscroll_cover_jacov_probe_66296817b5610f07(25);System.err.println("  Expiring");
                $qualityscroll_cover_jacov_probe_66296817b5610f07(26);if ((! file.delete()) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(28) && false))
                    {$qualityscroll_cover_jacov_probe_66296817b5610f07(27);System.err.println("  Could not delete file");}
            }
        }
        else
            {$qualityscroll_cover_jacov_probe_66296817b5610f07(29);System.err.println("  Not expiring");}
        $qualityscroll_cover_jacov_probe_66296817b5610f07(24);System.err.println();
    }

    /** Get a node from the tree to be used for the thumbnail.
        The position selected is the last position in the main variation or the
        first position in the main variation that contains both black and
        white setup stones. The rationale for this is that one usually wants
        to see the last position of a game, which may contain black handicap
        setup stones before the moves, but the thumbnail shouldn't show the
        solution of files containing Go problems. */
    public static ConstNode getNode(ConstGameTree tree)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_66296817b5610f07(31);ConstNode node = tree.getRootConst();
        $qualityscroll_cover_jacov_probe_66296817b5610f07(32);while ((node.hasChildren()
               && ! (node.getSetup(BLACK).size() > 0
                     && node.getSetup(WHITE).size() > 0)) ? true : (!$qualityscroll_cover_jacov_probe_66296817b5610f07(34) && false))
            {$qualityscroll_cover_jacov_probe_66296817b5610f07(33);node = node.getChildConst();}
        $qualityscroll_cover_jacov_probe_66296817b5610f07(35);return node;
    }

    /** Get a position from the tree to be used for the thumbnail.
        @see #getPosition() */
    public static ConstBoard getPosition(ConstGameTree tree)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_66296817b5610f07(36);Board board = new Board(tree.getBoardSize());
        new BoardUpdater().update(tree, getNode(tree), board);
        return board;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private ThumbnailUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_66296817b5610f07(37);
    }
}
