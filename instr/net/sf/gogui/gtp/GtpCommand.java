/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// GtpCommand.java

package net.sf.gogui.gtp;

import java.util.Locale;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.PointList;
import net.sf.gogui.util.StringUtil;

/** GTP command.
    Handles parsing the command line and storing the response to the command.
    Arguments containing whitespaces can be quoted with double quotes (").
    The responses are allowed to contain consecutive new lines.
    They will be replaced in GtpEngine.mainLoop() by lines containing a single
    space to form a valid GTP response. */
public class GtpCommand
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GtpCommand.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 8817492095938683246L,/* translation unit id   */ 3362426659531532230L,/* timestamp             */ 1709177901493L,/* source file name      */ "GtpCommand.java",/* probe size            */ 87);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Construct command from command line.
        @param line The full command line including ID. */
    public GtpCommand(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(0);StringBuilder buffer = preprocessLine(line);
        assert ! line.trim().equals("");
        String[] array = StringUtil.splitArguments(buffer.toString());
        assert array.length > 0;
        int commandIndex = 0;
        try
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(1);m_id = Integer.parseInt(array[0]);
            m_hasId = true;
            m_line = buffer.substring(array[0].length()).trim();
            commandIndex = 1;
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(10);m_hasId = false;
            m_id = -1;
            m_line = buffer.toString();
        }
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(2);m_response = new StringBuilder();
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(3);if ((commandIndex >= array.length) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(5) && false))
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(4);m_command = "";
            m_arg = null;
            return;
        }
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(6);m_command = array[commandIndex];
        int nuArg = array.length - commandIndex - 1;
        m_arg = new String[nuArg];
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(7);for (int i = 0; (i < nuArg) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(9) && false); ++i)
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(8);m_arg[i] = array[commandIndex + i + 1];}
    }

    /** Check that command has no arguments.
        @throws GtpError If command has any arguments. */
    public void checkArgNone() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(11);checkNuArg(0);
    }

    /** Check that command has n arguments.
        @throws GtpError If command has not n arguments. */
    public void checkNuArg(int n) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(12);if ((getNuArg() != n) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(14) && false))
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(13);if ((n == 0) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(16) && false))
                {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(15);throw new GtpError("no arguments allowed");}
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(17);if ((n == 1) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(19) && false))
                {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(18);throw new GtpError("need argument");}
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(20);throw new GtpError("need " + n + " arguments");
        }
    }

    /** Check that command has not more than n arguments.
        @throws GtpError If command has more than n arguments. */
    public void checkNuArgLessEqual(int n) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(21);if ((getNuArg() > n) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(23) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(22);throw new GtpError("too many arguments");}
    }

    /** Check if command has an ID.
        @return true, if command has an ID. */
    public boolean hasId()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(24);return m_hasId;
    }

    public String getArg() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(25);checkNuArg(1);
        return getArg(0);
    }

    /** Get argument.
        @param i The index of the argument (starting with zero).
        @return The argument.
        @throws GtpError If command has not enough arguments. */
    public String getArg(int i) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(26);if ((i >= getNuArg()) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(28) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(27);throw new GtpError("missing argument " + (i + 1));}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(29);return m_arg[i];
    }

    /** Get argument line.
        Get a string containing all arguments (the command line without
        ID and command; leading and trailing whitespaces trimmed).
        @return The argument line. */
    public String getArgLine()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(30);int pos = m_line.indexOf(m_command) + m_command.length();
        return m_line.substring(pos).trim();
    }

    /** Get single color argument.
        Valid color strings are "b", "w", "black", "white" and the
        corresponding uppercase strings.
        @return The color.
        @throws GtpError If command has not exactly one argument or argument
        is not a color. */
    public GoColor getColorArg() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(31);checkNuArg(1);
        return getColorArg(0);
    }

    /** Get color argument.
        Valid color strings are "b", "w", "black", "white" and the
        corresponding uppercase strings.
        @param i The index of the argument (starting with zero).
        @return The color.
        @throws GtpError If command has not enough arguments or argument is
        not a color. */
    public GoColor getColorArg(int i) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(32);String arg = getArg(i).toLowerCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(33);if ((arg.equals("b") || arg.equals("black")) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(35) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(34);return BLACK;}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(36);if ((arg.equals("w") || arg.equals("white")) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(38) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(37);return WHITE;}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(39);throw new GtpError("argument " + (i + 1) + " must be black or white");
    }

    /** Get command.
        @return The command string (command line without ID and arguments,
        leading and trailing whitespaces trimmed). */
    public String getCommand()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(40);return m_command;
    }

    /** Get single floating point number argument.
        @return The color.
        @throws GtpError If command has not exactly one argument or argument
        is not a floating point number. */
    public double getDoubleArg() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(41);checkNuArg(1);
        return getDoubleArg(0);
    }

    /** Get floating point number argument.
        @param i The index of the argument (starting with zero).
        @return The color.
        @throws GtpError If command has not enough arguments or argument is
        not a floating point number. */
    public double getDoubleArg(int i) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(42);String arg = getArg(i);
        try
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(43);return Double.parseDouble(arg);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(44);throw new GtpError("argument " + (i + 1) + " must be float");
        }
    }

    /** Get single integer argument.
        @return The color.
        @throws GtpError If command has not exactly one argument or argument
        is not an integer. */
    public int getIntArg() throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(45);checkNuArg(1);
        return getIntArg(0);
    }

    /** Get integer argument.
        @param i The index of the argument (starting with zero).
        @return The color.
        @throws GtpError If command has not enough arguments or argument is
        not an integer. */
    public int getIntArg(int i) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(46);String arg = getArg(i);
        try
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(47);return Integer.parseInt(arg);
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(48);throw new GtpError("argument " + (i + 1) + " must be integer");
        }
    }

    /** Get integer argument in a range.
        @param i The index of the argument (starting with zero).
        @param min Minimum allowed value.
        @param max Maximum allowed value.
        @return The color.
        @throws GtpError If command has not enough arguments or argument is
        not an integer in the allowed range. */
    public int getIntArg(int i, int min, int max) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(49);int n = getIntArg(i);
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(50);if ((n < min) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(52) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(51);throw new GtpError("argument " + (i + 1)
                               + " must be greater/equal " + min);}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(53);if ((n > max) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(55) && false))
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(54);throw new GtpError("argument " + (i + 1)
                               + " must be less/equal " + max);}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(56);return n;
    }

    /** Get point argument.
        Valid point strings are as in GtpUtil.parsePoint (uppercase or
        lowercase coordinates, e.g. "A1", or "pass").
        @param i The index of the argument (starting with zero).
        @param boardSize The board size (points will be checked to be within
        this board size).
        @return The point.
        @throws GtpError If command has not enough arguments or argument is
        not a valid point. */
    public GoPoint getPointArg(int i, int boardSize) throws GtpError
    {
        try
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(57);return GoPoint.parsePoint(getArg(i), boardSize);
        }
        catch (InvalidPointException e)
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(58);throw new GtpError("argument " + (i + 1) + " is not a point");
        }
    }

    /** Get point arguments.
        Valid point strings are as in GtpUtil.parsePoint (uppercase or
        lowercase coordinates, e.g. "A1", or "pass").
        All arguments will be parsed as points.
        @param boardSize The board size (points will be checked to be within
        this board size).
        @return Point list containg the points.
        @throws GtpError If at least one argument is not a valid point. */
    public PointList getPointListArg(int boardSize) throws GtpError
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(59);PointList pointList = new PointList();
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(60);for (int i = 0; (i < getNuArg()) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(62) && false); ++i)
            {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(61);pointList.add(getPointArg(i, boardSize));}
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(63);return pointList;
    }

    /** Full command line without ID.
        @return The command line without ID. */
    public String getLine()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(64);return m_line;
    }

    /** Get number of arguments.
        @return The number of arguments. */
    public int getNuArg()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(65);return m_arg.length;
    }

    /** Get string buffer for construction the response.
        The response to the command can be constructed by appending to this
        string buffer. */
    public StringBuilder getResponse()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(66);return m_response;
    }

    /** Get command ID.
        It is allowed to call this function if command has no ID, but the
        returned value is undefined.
        @return The command ID. */
    public int getId()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(67);return m_id;
    }

    /** Check if command is quit command.
        DEPRECATED: Fix GtpEngine to use only GtpEngine.m_quit
        @return true, if command name is "quit". */
    public boolean isQuit()
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(68);return m_line.trim().equals("quit");
    }

    /** Set the response.
        Clears the string buffer containg the response and sets it to the
        given string.
        @param response The string containing the new response. */
    public void setResponse(String response)
    {
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(69);m_response.setLength(0);
        m_response.append(response);
    }

    private boolean m_hasId;

    private int m_id;

    private String m_line;

    private final String m_command;

    private final String[] m_arg;

    private final StringBuilder m_response;

    /** Preprocess command line.
        Replaces control characters by spaces, removes redundant spaces
        and appended comment. */
    private static StringBuilder preprocessLine(String line)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(70);int len = line.length();
        StringBuilder buffer = new StringBuilder(len);
        boolean wasLastSpace = false;
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(71);for (int i = 0; (i < len) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(73) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(72);char c = line.charAt(i);
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(75);if ((c == '#') ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(77) && false))
                {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(76);break;}
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(78);if ((Character.isISOControl(c)) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(80) && false))
                {$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(79);continue;}
            $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(81);if ((Character.isWhitespace(c)) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(83) && false))
            {
                $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(82);if ((! wasLastSpace) ? true : (!$qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(85) && false))
                {
                    $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(84);buffer.append(' ');
                    wasLastSpace = true;
                }
            }
            else
            {
                $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(86);buffer.append(c);
                wasLastSpace = false;
            }
        }
        $qualityscroll_cover_jacov_probe_2ea9bd3b60ae27c6(74);return buffer;
    }
}
