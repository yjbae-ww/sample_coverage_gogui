/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Terminal.java

package net.sf.gogui.tools.terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.GameInfo;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.game.Node;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.BoardUtil;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK_WHITE;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.gtp.GtpClient;
import net.sf.gogui.gtp.GtpError;
import net.sf.gogui.gtp.GtpResponseFormatError;
import net.sf.gogui.gtp.GtpUtil;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.sgf.SgfWriter;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.version.Version;

/** Simple text based interface to Go programs supporting GTP. */
public class Terminal
    implements GtpClient.IOCallback
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Terminal.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -6154377706670409369L,/* translation unit id   */ -2332677204071574101L,/* timestamp             */ 1709177903721L,/* source file name      */ "Terminal.java",/* probe size            */ 149);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Terminal(String program, int size, boolean verbose)
        throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(0);if ((program.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(2) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(1);throw new Exception("No program set");}
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(3);m_verbose = verbose;
        m_gtp = new GtpClient(program, null, verbose, this);
        m_gtp.queryProtocolVersion();
        m_gtp.querySupportedCommands();
        initGame(size);
    }

    public void close()
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(4);m_gtp.close();
        m_gtp.waitForExit();
    }

    public void mainLoop() throws IOException
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(5);newGame(m_board.getSize());
        printBoard();
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(6);while (true)
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(7);System.out.print("> ");
                String line = reader.readLine();
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(10);if ((line == null) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(12) && false))
                    {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(11);break;}
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(13);line = line.trim();
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(14);if ((line.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(16) && false))
                    {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(15);continue;}
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(17);if ((handleCommand(line)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(19) && false))
                    {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(18);break;}
            }
        }
        finally
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(9);System.out.println();
        }
    }

    @Override
	public void receivedInvalidResponse(String s)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(20);System.out.print(s);
    }

    @Override
	public void receivedResponse(boolean error, String s)
    {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(21);
    }

    @Override
	public void receivedStdErr(String s)
    {
        // If m_verbose, logging is already done by Gtp
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(22);if ((! m_verbose) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(24) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(23);System.err.print(s);}
    }

    @Override
	public void sentCommand(String s)
    {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(25);
    }

    /** Colorize go board text output.
        @see Argument color in
        net.sf.gogui.go.Board.toString(ConstBoard,boolean,boolean) */
    public void setColor(boolean enable)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(26);m_color = enable;
    }

    private final boolean m_verbose;

    private boolean m_color;

    private Board m_board;

    private GameTree m_tree;

    private final GtpClient m_gtp;

    private Node m_currentNode;

    private void cmdPlay(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(27);if ((! cmdPlay(m_board.getToMove(), point)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(29) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(28);return;}
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(30);printBoard();
        genmove();
    }

    private boolean cmdPlay(GoColor color, GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(31);String command = m_gtp.getCommandPlay(Move.get(color, point));
        StringBuilder response = new StringBuilder();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(32);if ((! send(command, response)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(34) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(33);System.out.println(response);
            return false;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(35);play(Move.get(color, point));
        return true;
    }

    private void genmove()
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(36);GoColor toMove = m_board.getToMove();
        String command = m_gtp.getCommandGenmove(toMove);
        StringBuilder response = new StringBuilder();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(37);if ((! send(command, response)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(39) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(38);System.out.println(response);
            return;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(40);GoPoint point =
                GtpUtil.parsePoint(response.toString(), m_board.getSize());
            System.out.println("Computer move: " + GoPoint.toString(point));
            play(Move.get(toMove, point));
            printBoard();
        }
        catch (GtpResponseFormatError e)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(41);System.out.println(response);
        }
    }

    /** Handle command line from user.
        @return true if quit command received. */
    private boolean handleCommand(String cmdLine)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(42);String[] cmdArray = StringUtil.splitArguments(cmdLine);
        String cmd = cmdArray[0];
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(43);if ((cmd.equals("quit")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(45) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(44);send("quit");
            return true;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(46);if ((cmd.equals("genmove")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(48) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(47);genmove();}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(50);if ((cmd.equals("help")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(52) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(51);help();}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(53);if ((cmd.equals("list")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(55) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(54);listCommands();}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(56);if ((cmd.equals("load")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(58) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(57);load(cmdArray);}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(59);if ((cmd.equals("newgame")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(61) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(60);newGame(cmdArray);}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(62);if ((cmd.equals("save")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(64) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(63);save(cmdArray);}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(65);if ((cmd.equals("undo")) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(67) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(66);undo(cmdArray);}
        else {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(68);if ((GtpUtil.isStateChangingCommand(cmd)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(70) && false))
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(69);System.out.println("Command not allowed");}
        else
        {
            try
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(71);GoPoint point
                    = GtpUtil.parsePoint(cmdLine, m_board.getSize());
                cmdPlay(point);
            }
            catch (GtpResponseFormatError e)
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(72);StringBuilder response = new StringBuilder();
                send(cmdLine, response);
                System.out.println(response);
            }
        }}}}}}}}
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(49);return false;
    }

    private void help()
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(73);String text =
            "Enter a move or one of the following commands:\n" +
            "genmove, help, load, list, newgame, save, undo, quit.\n" +
            "GTP commands that change the board state are not allowed.\n" +
            "Other GTP commands are forwarded to the program.\n";
        System.out.print(text);
    }

    private void initGame(int size)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(74);m_board = new Board(size);
        m_tree = new GameTree(size, null, null, null, null);
        setCurrentNode(m_tree.getRoot());
    }

    private void listCommands()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(75);m_gtp.querySupportedCommands();
        }
        catch (GtpError error)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(80);System.out.println(error.getMessage());
            return;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(76);ArrayList<String> commands = m_gtp.getSupportedCommands();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(77);for (int i = 0; (i < commands.size()) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(79) && false); ++i)
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(78);System.out.println(commands.get(i));}
    }

    private void load(String[] cmdArray)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(81);if ((cmdArray.length < 2) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(83) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(82);System.out.println("Need filename argument");
            return;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(84);File file = new File(cmdArray[1]);
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(85);FileInputStream fileStream = new FileInputStream(file);
            SgfReader reader = new SgfReader(fileStream, file, null, 0);
            String warnings = reader.getWarnings();
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(86);if ((warnings != null) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(88) && false))
                {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(87);System.out.print(warnings);}
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(89);GameTree tree = reader.getTree();
            GameInfo info = tree.getGameInfo(tree.getRoot());
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(90);if ((info.getHandicap() > 0) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(92) && false))
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(91);System.out.println("Handicap games not supported");
                return;
            }
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(93);if ((! newGame(tree.getBoardSize())) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(95) && false))
                {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(94);return;}
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(96);send("komi " + info.getKomi());
            ConstNode node = tree.getRoot();
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(97);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(99) && false))
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(98);for (GoColor c : BLACK_WHITE)
                {
                    $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(106);for (GoPoint stone : node.getSetup(c))
                        {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(107);if ((! cmdPlay(c, stone)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(109) && false))
                            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(108);return;}}
                }
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(101);Move move = node.getMove();
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(102);if ((move != null
                    && ! cmdPlay(move.getColor(), move.getPoint())) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(104) && false))
                        {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(103);return;}
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(105);node = node.getChildConst();
            }
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(100);printBoard();
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(110);System.out.println("File not found: " + file);
        }
        catch (SgfError e)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(111);System.out.println("Could not read file " + file
                               + ": " + e.getMessage());
        }
    }

    private boolean newGame(int size)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(112);String command;
        StringBuilder response = new StringBuilder();
        command = m_gtp.getCommandBoardsize(size);
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(113);if ((command != null && ! send(command, response)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(115) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(114);System.out.println(response);
            return false;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(116);command = m_gtp.getCommandClearBoard(size);
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(117);if ((! send(command, response)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(119) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(118);System.out.println(response);
            return false;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(120);initGame(size);
        return true;
    }

    private void newGame(String[] cmdArray)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(121);int size = m_board.getSize();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(122);if ((cmdArray.length > 1) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(124) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(123);try
            {
                $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(125);size = Integer.parseInt(cmdArray[1]);
            }
            catch (NumberFormatException exception)
            {$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(127);
            }
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(126);newGame(size);
        printBoard();
    }

    private void play(Move move)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(128);m_board.play(move);
        Node node = new Node(move);
        m_currentNode.append(node);
        m_currentNode = node;
    }

    private void printBoard()
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(129);System.out.print(BoardUtil.toString(m_board, true, m_color));
    }

    private void save(String[] cmdArray)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(130);if ((cmdArray.length < 2) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(132) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(131);System.out.println("Need filename argument");
            return;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(133);File file = new File(cmdArray[1]);
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(134);OutputStream out = new FileOutputStream(file);
            new SgfWriter(out, m_tree, "gogui-terminal", Version.get());
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(135);System.out.println("Write error");
            return;
        }
    }

    private String send(String cmd)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(136);StringBuilder response = new StringBuilder();
        send(cmd, response);
        return response.toString();
    }

    private boolean send(String cmd, StringBuilder response)
    {
        try
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(137);response.append(m_gtp.send(cmd));
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(138);return true;
        }
        catch (GtpError error)
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(139);response.append(error.getMessage());
            return false;
        }
    }

    private void setCurrentNode(ConstNode node)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(140);m_currentNode = m_tree.getNode(node);
    }

    private void undo(String[] cmdArray)
    {
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(141);if ((cmdArray.length > 1) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(143) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(142);System.out.println("undo command takes no arguments");
            return;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(144);StringBuilder response = new StringBuilder();
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(145);if ((! send("undo", response)) ? true : (!$qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(147) && false))
        {
            $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(146);System.out.println(response);
            return;
        }
        $qualityscroll_cover_jacov_probe_dfa0aa7123a995ab(148);m_board.undo();
        m_currentNode = m_currentNode.getFather();
        printBoard();
    }
}
