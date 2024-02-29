/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123821) $$ */// AnalyzeShow.java

package net.sf.gogui.gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.InvalidPointException;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.gtp.AnalyzeCommand;
import net.sf.gogui.gtp.AnalyzeType;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.util.StringUtil;

/** Show response to an AnalyzeCommand in the GUI. */
public final class AnalyzeShow
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = AnalyzeShow.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -206988838951278021L,/* translation unit id   */ -1685439924484389946L,/* timestamp             */ 1709177901762L,/* source file name      */ "AnalyzeShow.java",/* probe size            */ 231);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Parse analyze command response and display it on the board.
        @param showTextBuffer If not null, text lines from AnalyzeType.GFX
        commands will not be shown immediately in the status bar, but appended
        to the text buffer. This is for allowing multiline text in gfx commands
        that will be shown in a separate window later. */
    public static void show(AnalyzeCommand command, GuiBoard guiBoard,
                            StatusBar statusBar, ConstBoard board,
                            String response, StringBuilder showTextBuffer)
        throws GtpResponseFormatError
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(0);GoPoint pointArg = command.getPointArg();
        PointList pointListArg = command.getPointListArg();
        guiBoard.clearAllSelect();
        GuiBoardUtil.setSelect(guiBoard, pointListArg, true);
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(1);if ((pointArg != null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(3) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(2);guiBoard.setSelect(pointArg, true);}
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(4);AnalyzeType type = command.getType();
        int size = board.getSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(5);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (type)
        {
        case BWBOARD:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(6); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(22);String b[][] = GtpUtil.parseStringBoard(response, size);
                GuiBoardUtil.showBWBoard(guiBoard, b);
            }
            break;
        case CBOARD:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(7); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(23);String colors[][] = GtpUtil.parseStringBoard(response, size);
                GuiBoardUtil.showColorBoard(guiBoard, colors);
            }
            break;
        case DBOARD:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(8); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(24);double b[][] = GtpUtil.parseDoubleBoard(response, size);
                GuiBoardUtil.showDoubleBoard(guiBoard, b);
            }
            break;
        case GFX:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(9); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(25);showGfx(response, guiBoard, statusBar, showTextBuffer);
            }
            break;
        case PLIST:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(10); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(26);PointList points = GtpUtil.parsePointList(response, size);
                GuiBoardUtil.showPointList(guiBoard, points);
            }
            break;
        case HPSTRING:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(11); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
        case PSTRING:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(12); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(27);PointList points = GtpUtil.parsePointString(response, size);
                GuiBoardUtil.showPointList(guiBoard, points);
            }
            break;
        case PSPAIRS:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(13); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(28);PointList pointList = new PointList(32);
                ArrayList<String> stringList = new ArrayList<String>(32);
                GtpUtil.parsePointStringList(response, pointList, stringList,
                                             size);
                GuiBoardUtil.showPointStringList(guiBoard, pointList,
                                                  stringList);
            }
            break;
        case SBOARD:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(14); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(29);String b[][] = GtpUtil.parseStringBoard(response, size);
                GuiBoardUtil.showStringBoard(guiBoard, b);
            }
            break;
        case VAR:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(15); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(30);showVariation(guiBoard, response, board.getToMove());
            }
            break;
        case VARB:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(16); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(31);showVariation(guiBoard, response, BLACK);
            }
            break;
        case VARC:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(17); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(32);showVariation(guiBoard, response, command.getColorArg());
            }
            break;
        case VARW:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(18); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(33);showVariation(guiBoard, response, WHITE);
            }
            break;
        case VARP:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(19); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(34);GoColor c = getColor(board, pointArg, pointListArg);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(35);if ((c != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(37) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(36);showVariation(guiBoard, response, c);}
            }
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(38);break;
        case VARPO:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(20); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(39);GoColor c = getColor(board, pointArg, pointListArg);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(40);if ((c != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(42) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(41);showVariation(guiBoard, response, c.otherColor());}
            }
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(43);break;
        default:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(21); $qualityscroll_cover_jacov_switch_bool_0 = true; } 
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(44);break;
        }
    }

    /** Parse gfx analyze command response and display it on the board.
        @param showTextBuffer See AnalyzeShow.show() */
    public static void showGfx(String response, GuiBoard guiBoard,
                               StatusBar statusBar,
                               StringBuilder showTextBuffer)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(45);BufferedReader reader
            = new BufferedReader(new StringReader(response));
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(46);while (true)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(47);String line;
            try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(49);line = reader.readLine();
            }
            catch (IOException e)
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(54);assert false;
                break;
            }
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(50);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(52) && false))
                {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(51);break;}
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(53);showGfxLine(line, guiBoard, statusBar, showTextBuffer);
        }
    }

    public static void showGfxCircle(String[] arg, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(55);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(56);for (int i = 1; (i < arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(58) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(57);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(59);GoPoint point = GoPoint.parsePoint(arg[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(60);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(62) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(61);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(63);guiBoard.setMarkCircle(point, true);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(64);
            }
        }
    }

    public static void showGfxColor(String[] arg, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(65);if ((arg.length < 2) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(67) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(66);return;}
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(68);int size = guiBoard.getBoardSize();
        Color color = GuiBoardUtil.getColor(arg[1]);
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(69);for (int i = 2; (i < arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(71) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(70);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(72);GoPoint point = GoPoint.parsePoint(arg[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(73);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(75) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(74);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(76);guiBoard.setFieldBackground(point, color);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(77);
            }
        }
    }

    public static void showGfxInfluence(String[] arg, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(78);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(79);for (int i = 1; (i < arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(81) && false); i += 2)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(80);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(82);GoPoint point = GoPoint.parsePoint(arg[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(83);if ((i + 1 >= arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(85) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(84);break;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(86);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(88) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(87);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(89);double value = Double.parseDouble(arg[i + 1]);
                guiBoard.setInfluence(point, value);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(90);
            }
            catch (NumberFormatException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(91);
            }
        }
    }

    public static void showGfxLabel(String[] arg, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(92);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(93);for (int i = 1; (i < arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(95) && false); i += 2)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(94);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(96);GoPoint point = GoPoint.parsePoint(arg[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(97);if ((i + 1 >= arg.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(99) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(98);break;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(100);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(102) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(101);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(103);guiBoard.setLabel(point, arg[i + 1]);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(104);
            }
        }
    }

    /** Parse gfx analyze command response line and display it on the board.
        @param showTextBuffer See AnalyzeShow.show() */
    public static void showGfxLine(String line, GuiBoard guiBoard,
                                   StatusBar statusBar,
                                   StringBuilder showTextBuffer)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(105);String[] args = StringUtil.splitArguments(line);
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(106);if ((args.length == 0) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(108) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(107);return;}
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(109);String cmd = args[0].toUpperCase(Locale.ENGLISH);
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(110);if ((cmd.equals("BLACK")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(112) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(111);showGfxTerritory(args, BLACK, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(113);if ((cmd.equals("CIRCLE")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(115) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(114);showGfxCircle(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(116);if ((cmd.equals("CLEAR")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(118) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(117);guiBoard.clearAll();}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(119);if ((cmd.equals("COLOR")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(121) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(120);showGfxColor(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(122);if ((cmd.equals("INFLUENCE")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(124) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(123);showGfxInfluence(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(125);if ((cmd.equals("LABEL")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(127) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(126);showGfxLabel(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(128);if ((cmd.equals("MARK")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(130) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(129);showGfxMark(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(131);if ((cmd.equals("SQUARE")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(133) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(132);showGfxSquare(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(134);if ((cmd.equals("TEXT")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(136) && false))
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(135);line = line.trim();
            int pos = line.indexOf(' ');
            String text = "";
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(137);if ((pos > 0) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(139) && false))
                {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(138);text = line.substring(pos + 1);}
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(140);if ((showTextBuffer == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(142) && false))
                {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(141);statusBar.setText(text);}
            else
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(143);if ((showTextBuffer.length() > 0) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(145) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(144);showTextBuffer.append('\n');}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(146);showTextBuffer.append(text);
            }
        }
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(147);if ((cmd.equals("TRIANGLE")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(149) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(148);showGfxTriangle(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(150);if ((cmd.equals("VAR")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(152) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(151);showGfxVariation(args, guiBoard);}
        else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(153);if ((cmd.equals("WHITE")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(155) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(154);showGfxTerritory(args, WHITE, guiBoard);}}}}}}}}}}}}
    }

    public static void showGfxMark(String[] args, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(156);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(157);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(159) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(158);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(160);GoPoint point = GoPoint.parsePoint(args[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(161);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(163) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(162);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(164);guiBoard.setMark(point, true);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(165);
            }
        }
    }

    public static void showGfxSquare(String[] args, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(166);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(167);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(169) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(168);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(170);GoPoint point = GoPoint.parsePoint(args[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(171);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(173) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(172);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(174);guiBoard.setMarkSquare(point, true);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(175);
            }
        }
    }

    public static void showGfxTriangle(String[] args, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(176);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(177);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(179) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(178);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(180);GoPoint point = GoPoint.parsePoint(args[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(181);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(183) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(182);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(184);guiBoard.setMarkTriangle(point, true);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(185);
            }
        }
    }

    public static void showGfxTerritory(String[] args, GoColor color,
                                        GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(186);int size = guiBoard.getBoardSize();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(187);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(189) && false); ++i)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(188);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(190);GoPoint point = GoPoint.parsePoint(args[i], size);
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(191);if ((point == null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(193) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(192);continue;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(194);guiBoard.setTerritory(point, color);
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(195);
            }
        }
    }

    public static void showGfxVariation(String[] args, GuiBoard guiBoard)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(196);int size = guiBoard.getBoardSize();
        int n = 0;
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(197);for (int i = 1; (i < args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(199) && false); i += 2)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(198);try
            {
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(200);GoColor color;
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(201);if ((args[i].equalsIgnoreCase("b")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(203) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(202);color = BLACK;}
                else {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(211);if ((args[i].equalsIgnoreCase("w")) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(213) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(212);color = WHITE;}
                else
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(214);break;}}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(204);if ((i + 1 >= args.length) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(206) && false))
                    {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(205);break;}
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(207);GoPoint point = GoPoint.parsePoint(args[i + 1], size);
                ++n;
                $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(208);if ((point != null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(210) && false))
                {
                    $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(209);guiBoard.setGhostStone(point, color);
                    guiBoard.setLabel(point, Integer.toString(n));
                }
            }
            catch (InvalidPointException e)
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(215);
            }
        }
    }

    /** Make constructor unavailable; class is for namespace only. */
    private AnalyzeShow()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(216);
    }

    private static GoColor getColor(ConstBoard board, GoPoint pointArg,
                                    ConstPointList pointListArg)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(217);GoColor color = EMPTY;
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(218);if ((pointArg != null) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(220) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(219);color = board.getColor(pointArg);}
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(221);if ((color != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(223) && false))
            {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(222);return color;}
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(224);for (GoPoint point : pointListArg)
        {
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(226);color = board.getColor(point);
            $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(227);if ((color != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(229) && false))
                {$qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(228);break;}
        }
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(225);return color;
    }

    private static void showVariation(GuiBoard guiBoard, String response,
                                      GoColor color)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_e89c1d518ad8c3c6(230);int size = guiBoard.getBoardSize();
        Move moves[] = GtpUtil.parseVariation(response, color, size);
        GuiBoardUtil.showVariation(guiBoard, moves);
    }
}
