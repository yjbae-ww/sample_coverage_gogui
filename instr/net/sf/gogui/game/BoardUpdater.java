/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123819) $$ */// BoardUpdater.java

package net.sf.gogui.game;

import java.util.ArrayList;
import java.util.function.Function;

import net.sf.gogui.go.Board;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;

/** Updates a go.Board to a node in a GameTree. */
public class BoardUpdater
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = BoardUpdater.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 319296138306162243L,/* translation unit id   */ 1255190102594613870L,/* timestamp             */ 1709177899725L,/* source file name      */ "BoardUpdater.java",/* probe size            */ 55);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public BoardUpdater()
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(0);m_nodes = new ArrayList<ConstNode>(400);
    }

    public void update(ConstGameTree tree, ConstNode currentNode, Board board)
    {
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(1);board.init(tree.getBoardSize());
        int handicap = tree.getGameInfoConst(currentNode).getHandicap();
        NodeUtil.getPathToRoot(currentNode, m_nodes);
        int nuMoves = 0;
        boolean isFirstPlacement = true;
        boolean isHandicapSetupDone = false;
        boolean isInInitialBlackMoveSequence = true;
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(2);for (int i = m_nodes.size() - 1; (i >= 0) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(4) && false); --i)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(3);Function<String, Integer> func = (x) ->//test
                1;
            ConstNode node = m_nodes.get(i);
            GoColor player = node.getPlayer();
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(5);if ((node.hasSetup()) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(7) && false))
            {
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(6);ConstPointList setupBlack = node.getSetup(BLACK);
                ConstPointList setupWhite = node.getSetup(WHITE);
                ConstPointList setupEmpty = node.getSetup(EMPTY);
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(8);if ((handicap > 0 && isFirstPlacement
                    && setupBlack.size() == handicap && setupWhite.isEmpty()
                    && setupEmpty.isEmpty()) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(10) && false))
                {
                    $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(9);board.setupHandicap(setupBlack);
                    isHandicapSetupDone = true;
                }
                else
                    {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(22);newSetup(board, setupBlack, setupWhite, setupEmpty, player);}
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(11);isFirstPlacement = false;
                isInInitialBlackMoveSequence = false;
            }
            else {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(23);if ((player != null) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(25) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(24);board.setToMove(player);}}
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(12);Move move = node.getMove();
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(13);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(15) && false))
            {
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(14);board.play(move);
                ++nuMoves;
                isFirstPlacement = false;
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(16);if ((move.getColor() != BLACK) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(18) && false))
                    {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(17);isInInitialBlackMoveSequence = false;}
                // Files from the KGS Go server with Chines rules store
                // handicap stones as moves, not as setup as specified by SGF
                $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(19);if ((handicap > 0 && ! isHandicapSetupDone &&
                    isInInitialBlackMoveSequence && nuMoves == handicap) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(21) && false))
                {
                    $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(20);setupMovesAsHandicap(board);
                    isHandicapSetupDone = true;
                }
            }
        }
    }

    /** Local variable used in update.
        Member variable for avoiding frequent new memory allocations. */
    private final ArrayList<ConstNode> m_nodes;

    /** Initialize board with new setup from merging the current position
        with the setup properties from a node. */
    private void newSetup(Board board, ConstPointList setupBlack,
                          ConstPointList setupWhite, ConstPointList setupEmpty,
                          GoColor player)
    {
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(26);PointList black = new PointList();
        PointList white = new PointList();
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(27);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(41);GoColor c = board.getColor(p);
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(42);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(44) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(43);black.add(p);}
            else {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(45);if ((c == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(47) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(46);white.add(p);}}
        }
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(28);for (GoPoint p : setupBlack)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(37);white.remove(p);
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(38);if ((! black.contains(p)) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(40) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(39);black.add(p);}
        }
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(29);for (GoPoint p : setupWhite)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(33);black.remove(p);
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(34);if ((! white.contains(p)) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(36) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(35);white.add(p);}
        }
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(30);for (GoPoint p : setupEmpty)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(32);black.remove(p);
            white.remove(p);
        }
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(31);board.setup(black, white, player);
    }

    void setupMovesAsHandicap(Board board)
    {
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(48);PointList black = new PointList();
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(49);for (GoPoint p : board)
        {
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(51);GoColor c = board.getColor(p);
            assert c != WHITE;
            $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(52);if ((c == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(54) && false))
                {$qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(53);black.add(p);}
        }
        $qualityscroll_cover_jacov_probe_116b54bf7ebcf26e(50);board.setupHandicap(black);
    }
}
