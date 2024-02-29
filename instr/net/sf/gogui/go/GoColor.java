/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoColor.java

package net.sf.gogui.go;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Player color / state of a point on the board (black, white, empty). */
public enum GoColor
{
    /** Black stone or black player. */
    BLACK
    {
        @Override
		public String getCapitalizedName()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(0);return "Black";
        }

        @Override
		public String getUppercaseLetter()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(1);return "B";
        }

        @Override
		public boolean isBlackWhite()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(2);return true;
        }

        @Override
		public GoColor otherColor()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(3);return WHITE;
        }
    },

    /** White stone or white player. */
    WHITE
    {
        @Override
		public String getCapitalizedName()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(4);return "White";
        }

        @Override
		public String getUppercaseLetter()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(5);return "W";
        }

        @Override
		public boolean isBlackWhite()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(6);return true;
        }

        @Override
		public GoColor otherColor()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(7);return BLACK;
        }
    },

    /** Empty intersection. */
    EMPTY
    {
        @Override
		public String getCapitalizedName()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(8);return "Empty";
        }

        @Override
		public String getUppercaseLetter()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(9);return "E";
        }

        @Override
		public boolean isBlackWhite()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(10);return false;
        }

        @Override
		public GoColor otherColor()
        {
            $qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(11);return EMPTY;
        }
    };

    public static transient boolean[] $qualityscroll_cover_coverage_buffer;public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoColor.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -1166558380386673281L,/* translation unit id   */ 398210288948198867L,/* timestamp             */ 1709177900400L,/* source file name      */ "GoColor.java",/* probe size            */ 13);return $qualityscroll_cover_coverage_buffer;}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}}private static boolean $qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static final List<GoColor> BLACK_WHITE;

    public static final List<GoColor> WHITE_BLACK;

    public static final List<GoColor> BLACK_WHITE_EMPTY;

    static
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_586ba25e2a9bdd3(12);List<GoColor> blackWhite = new ArrayList<GoColor>(2);
        blackWhite.add(BLACK);
        blackWhite.add(WHITE);
        BLACK_WHITE = Collections.unmodifiableList(blackWhite);

        List<GoColor> whiteBlack = new ArrayList<GoColor>(2);
        whiteBlack.add(WHITE);
        whiteBlack.add(BLACK);
        WHITE_BLACK = Collections.unmodifiableList(whiteBlack);

        List<GoColor> blackWhiteEmpty = new ArrayList<GoColor>(3);
        blackWhiteEmpty.add(BLACK);
        blackWhiteEmpty.add(WHITE);
        blackWhiteEmpty.add(EMPTY);
        BLACK_WHITE_EMPTY = Collections.unmodifiableList(blackWhiteEmpty);
    }

    /** Return color name if used for specifying player.
        Returns the capitalized color name (e.g. "Black" for BLACK).
        This name will also potentially be internationalized in the future. */
    public abstract String getCapitalizedName();

    /** Return uppercase letter identifying the color.
        Returns "B", "W", or "E". This letter is not internationalized,
        such that it can be used for instance in standard language independent
        game results (e.g. "W+3"). */
    public abstract String getUppercaseLetter();

    /** Check if color is black or white.
        @return <code>true</code>, if color is <code>BLACK</code> or
        <code>WHITE</code>. */
    public abstract boolean isBlackWhite();

    /** Return other color.
        @return <code>BLACK</code> for <code>WHITE</code>, <code>WHITE</code>
        for <code>BLACK</code>, <code>EMPTY</code> for <code>EMPTY</code>. */
    public abstract GoColor otherColor();
}
