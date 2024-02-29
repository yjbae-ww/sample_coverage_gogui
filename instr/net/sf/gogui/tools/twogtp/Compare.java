/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// Compare.java

package net.sf.gogui.tools.twogtp;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.go.Board;
import net.sf.gogui.go.BoardUtil;
import net.sf.gogui.go.ConstBoard;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK_WHITE_EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.sgf.SgfReader;

/** Find duplicates in games. */
public final class Compare
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Compare.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 6376322932540545033L,/* translation unit id   */ 6718379807461019485L,/* timestamp             */ 1709177903794L,/* source file name      */ "Compare.java",/* probe size            */ 53);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static final class Placement
    {
        public boolean m_isSetup;

        public GoColor m_color;

        public GoPoint m_point;

        public Placement(boolean isSetup, GoColor color, GoPoint point)
        {$qualityscroll_cover_coverage_buffer_init();
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(0);m_isSetup = isSetup;
            m_color = color;
            m_point = point;
        }

        public Placement(Move move)
        {
            this(false, move.getColor(), move.getPoint());$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(1);
        }
    }

    /** Check if game already exists in game collection.
        All games must have the same board size.
        Also finds rotated duplicates.
        @param board Board with the correct size (only used for
        Board.rotate).
        @param moves Moves of game to check.
        @param games Games in collection. The key is the game number, the value
        is the sequence of moves.
        @param useAlternate If true, assume that players are exchanged every
        second game. Only check games where player played the same color.
        @param isAlternated If useAlternate, indicate if game to check
        had players exchanged.
        @return String containing number of first identical game in
        collection or "-" if no duplicate was found. If a nearly identical
        game is found (&lt;= 20% identical moves comparing moves by number),
        the game number is returned with a question mark appended. */
    public static String checkDuplicate(ConstBoard board,
                                      ArrayList<Placement> moves,
                                      Map<Integer, ArrayList<Placement>> games,
                                      boolean useAlternate,
                                      boolean isAlternated)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(2);String result = "-";
        int size = board.getSize();
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(3);for (Map.Entry<Integer, ArrayList<Placement>> entry : games.entrySet())
        {
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(5);int numberGame = entry.getKey();
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(6);if ((useAlternate && ((numberGame % 2 != 0) != isAlternated)) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(8) && false))
                {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(7);continue;}
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(9);ArrayList<Placement> gameMoves = entry.getValue();
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(10);for (int rot = 0; (rot < BoardUtil.NUMBER_ROTATIONS) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(12) && false); ++rot)
            {
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(11);int numberDifferent = 0;
                int moveNumber = moves.size();
                int maxDifferent = moveNumber / 5;
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(13);if ((gameMoves.size() != moveNumber) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(15) && false))
                {
                    $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(14);numberDifferent = Math.abs(gameMoves.size() - moveNumber);
                    moveNumber = Math.min(gameMoves.size(), moveNumber);
                }
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(16);for (int i = 0;
                     (numberDifferent <= maxDifferent && i < moveNumber) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(18) && false); ++i)
                {
                    $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(17);Placement move = moves.get(i);
                    Placement gameMove = gameMoves.get(i);
                    GoPoint gameRotatedPoint =
                        BoardUtil.rotate(rot, gameMove.m_point, size);
                    $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(25);if ((move.m_isSetup != gameMove.m_isSetup
                        || ! move.m_color.equals(gameMove.m_color)
                        || ! GoPoint.equals(move.m_point, gameRotatedPoint)) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(27) && false))
                        {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(26);++numberDifferent;}
                }
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(19);if ((numberDifferent == 0) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(21) && false))
                    {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(20);return Integer.toString(numberGame);}
                else {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(22);if ((numberDifferent < maxDifferent) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(24) && false))
                    {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(23);result = Integer.toString(numberGame) + "?";}}
            }
        }
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(4);return result;
    }

    /** Compare a set of SGF files.
        Prints the results to standard output, one line per game
        with the filename and the duplicate information as returned by
        Compare.checkDuplicate.
        @param filenames List of filenames
        @throws Exception If reading one of the files fails. */
    public static void compare(ArrayList<String> filenames) throws Exception
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(28);Board board = null;
        Map<Integer, ArrayList<Placement>> games =
            new TreeMap<Integer, ArrayList<Placement>>();
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(29);for (int gameNumber = 0; (gameNumber < filenames.size()) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(31) && false); ++gameNumber)
        {
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(30);String filename = filenames.get(gameNumber);
            File file = new File(filename);
            FileInputStream fileStream = new FileInputStream(file);
            SgfReader reader = new SgfReader(fileStream, file, null, 0);
            GameTree tree = reader.getTree();
            int size = tree.getBoardSize();
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(32);if ((board == null) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(34) && false))
                {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(33);board = new Board(size);}
            else {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(36);if ((size != board.getSize()) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(38) && false))
                {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(37);throw new Exception("Board size in " + filename +
                                    " does not match other games");}}
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(35);ArrayList<Placement> moves = getPlacements(tree.getRoot());
            String duplicate =
                checkDuplicate(board, moves, games, false, false);
            System.out.println(Integer.toString(gameNumber) + " " +
                               filename + " " + duplicate);
            games.put(gameNumber, moves);
        }
    }

    public static ArrayList<Placement> getPlacements(ConstNode node)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(39);ArrayList<Placement> result = new ArrayList<Placement>(512);
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(40);while ((node != null) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(42) && false))
        {
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(41);for (GoColor c : BLACK_WHITE_EMPTY)
            {
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(49);PointList list = new PointList(node.getSetup(c));
                Collections.sort(list);
                $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(50);for (GoPoint p : list)
                    {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(51);result.add(new Placement(true, c, p));}
            }
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(44);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(45);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(47) && false))
                {$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(46);result.add(new Placement(move));}
            $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(48);node = node.getChildConst();
        }
        $qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(43);return result;
    }

    /** Make constructor unavailable; class is for namespace only. */
    private Compare()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_5d3c7ad6e1df0f5d(52);
    }
}
