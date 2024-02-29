/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpUtil.java

package net.sf.gogui.gtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.gogui.game.ConstClock;
import net.sf.gogui.game.TimeSettings;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.util.StringUtil;

/** Utility functions used in package gtp. */
public final class GtpUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4311221312062446792L,/* translation unit id   */ 7340838406107159596L,/* timestamp             */ 1709177901662L,/* source file name      */ "GtpUtil.java",/* probe size            */ 97);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Get GTP time settings command .
        @param settings The time settings. If null, this function will return
        a GTP command for "no time limit" ("time_settings 0 1 0" with zero
        byoyomi stones), which could confuse some programs, so it should be
        only sent if necessary (when changing from a state with time settings
        to a state with no time settings). */
    public static String getTimeSettingsCommand(TimeSettings settings)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(0);if ((settings == null) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(2) && false))
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(1);return "time_settings 0 1 0";}
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(3);long preByoyomi = settings.getPreByoyomi() / 1000;
        long byoyomi = 0;
        long byoyomiMoves = 0;
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(4);if ((settings.getUseByoyomi()) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(6) && false))
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(5);byoyomi = settings.getByoyomi() / 1000;
            byoyomiMoves = settings.getByoyomiMoves();
        }
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(7);return "time_settings " + preByoyomi + " " + byoyomi + " "
            + byoyomiMoves;
    }

    /** Check if command line contains a command.
        @return false if command line contains only whitespaces or only a
        comment */
    public static boolean isCommand(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(8);line = line.trim();
        return (! line.equals("") && ! line.startsWith("#"));
    }

    /** Check if command changes the board state.
        Compares command to known GTP commands that change the board state,
        such that a controller that keeps track of the board state cannot
        blindly forward them to a GTP engine without updating its internal
        board state too. Includes all such commands from GTP protocol version
        1 and 2, the <code>quit</code> command, and some known GTP extension
        commands (e.g. <code>gg-undo</code> from GNU Go and
        <code>gogui-play_sequence</code> from GoGui). Does not include
        non-criticlal state changing commands like <code>komi</code>.
        @param line The command or complete command line
        @return <code>true</code> if command is a state-changing command */
    public static boolean isStateChangingCommand(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(9);GtpCommand cmd = new GtpCommand(line);
        String c = cmd.getCommand();
        return (c.equals("boardsize")
                || c.equals("black")
                || c.equals("clear_board")
                || c.equals("fixed_handicap")
                || c.equals("genmove")
                || c.equals("genmove_black")
                || c.equals("genmove_cleanup")
                || c.equals("genmove_white")
                || c.equals("gg-undo")
                || c.equals("gogui-play_sequence")
                || c.equals("kgs-genmove_cleanup")
                || c.equals("loadsgf")
                || c.equals("place_free_handicap")
                || c.equals("play")
                || c.equals("play_sequence")
                || c.equals("quit")
                || c.equals("set_free_handicap")
                || c.equals("undo")
                || c.equals("white"));
    }

    public static double[][] parseDoubleBoard(String response, int boardSize)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(10);double result[][] = new double[boardSize][boardSize];
            String s[][] = parseStringBoard(response, boardSize);
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(11);for (int x = 0; (x < boardSize) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(13) && false); ++x)
                {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(12);for (int y = 0; (y < boardSize) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(16) && false); ++y)
                    {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(15);result[x][y] = Double.parseDouble(s[x][y]);}}
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(14);return result;
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(17);throw new GtpResponseFormatError("Floating point number expected");
        }
    }

    public static GoPoint parsePoint(String s, int boardSize)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(18);return GoPoint.parsePoint(s, boardSize);
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(19);throw new GtpResponseFormatError("Invalid point " + s + " (size "
                                          + boardSize + ")");
        }
    }

    public static PointList parsePointList(String s, int boardSize)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        try
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(20);return GoPoint.parsePointList(s, boardSize);
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(21);throw new GtpResponseFormatError(e.getMessage());
        }
    }

    /** Find all points contained in string. */
    public static PointList parsePointString(String text)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(22);return parsePointString(text, GoPoint.MAX_SIZE);
    }

    /** Find all points contained in string. */
    public static PointList parsePointString(String text, int boardSize)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(23);String regex = "\\b([Pp][Aa][Ss][Ss]|[A-Ta-t](1\\d|[1-9]))\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        PointList list = new PointList(32);
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(24);while ((matcher.find()) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(26) && false))
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(25);int start = matcher.start();
            int end = matcher.end();
            GoPoint point;
            try
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(28);point = parsePoint(text.substring(start, end), boardSize);
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(30);assert false;
                continue;
            }
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(29);list.add(point);
        }
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(27);return list;
    }

    public static void parsePointStringList(String s, PointList pointList,
                                            ArrayList<String> stringList,
                                            int boardsize)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(31);pointList.clear();
        stringList.clear();
        String array[] = StringUtil.splitArguments(s);
        boolean nextIsPoint = true;
        GoPoint point = null;
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(32);for (int i = 0; (i < array.length) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(34) && false); ++i)
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(33);if ((! array[i].equals("")) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(39) && false))
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(38);if ((nextIsPoint) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(41) && false))
                {
                    $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(40);point = parsePoint(array[i], boardsize);
                    nextIsPoint = false;
                }
                else
                {
                    $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(42);nextIsPoint = true;
                    pointList.add(point);
                    stringList.add(array[i]);
                }
            }}
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(35);if ((! nextIsPoint) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(37) && false))
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(36);throw new GtpResponseFormatError("Missing string");}
    }

    public static String[][] parseStringBoard(String s, int boardSize)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(43);String result[][] = new String[boardSize][boardSize];
        try
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(44);BufferedReader reader = new BufferedReader(new StringReader(s));
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(45);for (int y = boardSize - 1; (y >= 0) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(47) && false); --y)
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(46);String line = reader.readLine();
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(49);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(51) && false))
                    {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(50);throw new GtpResponseFormatError("Incomplete string board");}
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(52);if ((line.trim().equals("")) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(54) && false))
                {
                    $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(53);++y;
                    continue;
                }
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(55);String[] args = StringUtil.splitArguments(line);
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(56);if ((args.length < boardSize) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(58) && false))
                    {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(57);throw new GtpResponseFormatError("Incomplete string board");}
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(59);for (int x = 0; (x < boardSize) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(61) && false); ++x)
                    {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(60);result[x][y] = args[x];}
            }
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(62);throw new GtpResponseFormatError("I/O error");
        }
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(48);return result;
    }

    /** Find all moves contained in string. */
    public static Move[] parseVariation(String s, GoColor toMove,
                                        int boardSize)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(63);ArrayList<Move> list = new ArrayList<Move>(32);
        String token[] = StringUtil.splitArguments(s);
        boolean isColorSet = true;
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(64);for (int i = 0; (i < token.length) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(66) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(65);String t = token[i].toLowerCase(Locale.ENGLISH);
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(72);if ((t.equals("b") || t.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(74) && false))
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(73);toMove = BLACK;
                isColorSet = true;
            }
            else {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(75);if ((t.equals("w") || t.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(77) && false))
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(76);toMove = WHITE;
                isColorSet = true;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(78);GoPoint point;
                try
                {
                    $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(79);point = parsePoint(t, boardSize);
                }
                catch (GtpResponseFormatError e)
                {
                    $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(84);continue;
                }
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(80);if ((! isColorSet) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(82) && false))
                    {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(81);toMove = toMove.otherColor();}
                $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(83);list.add(Move.get(toMove, point));
                isColorSet = false;
            }}
        }
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(67);Move result[] = new Move[list.size()];
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(68);for (int i = 0; (i < result.length) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(70) && false); ++i)
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(69);result[i] = list.get(i);}
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(71);return result;
    }

    /** Inform a GTP engine about the clock state.
        Sends the clock state to the engine, if the clock is initialized and
        the engine supports the time_left standard GTP command. Otherwise,
        does nothing. */
    public static void sendTimeLeft(GtpClientBase gtp, ConstClock clock,
                                    GoColor c)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(85);if ((! clock.isInitialized() || ! gtp.isSupported("time_left")) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(87) && false))
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(86);return;}
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(88);String color = (((c == BLACK) ? ($qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(89) || true) : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(90) && false)) ? "b" : "w");
        long timeLeft = clock.getTimeLeft(c) / 1000;
        long movesLeft = 0;
        $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(91);if ((clock.getTimeSettings().getUseByoyomi()
            && clock.isInByoyomi(c)) ? true : (!$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(93) && false))
            {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(92);movesLeft = clock.getMovesLeft(c);}
        try
        {
            $qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(94);gtp.send("time_left " + color + " " + timeLeft + " "
                     + movesLeft);
        }
        catch (GtpError e)
        {$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(95);
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private GtpUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_65dfe5a30d8fdc2c(96);
    }
}
