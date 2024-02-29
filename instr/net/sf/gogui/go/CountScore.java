/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// CountScore.java

package net.sf.gogui.go;

import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import net.sf.gogui.go.Score.ScoringMethod;
import static net.sf.gogui.go.Score.ScoringMethod.AREA;
import static net.sf.gogui.go.Score.ScoringMethod.TERRITORY;

/** Count the final score on a Go board.
    Allows to mark stones as dead and count the territory surrounded by
    alive stones of one color.
    The reason why all stones in a dead block have to marked as dead is that
    Go engines return a list of dead stones on the final_status GTP command.
    It could happen that the program returns nonsense (e.g. a contiguous block
    of stones with only some stones dead) and this class should not crash
    if that happens (even if the score will be no longer meaningful). */
public class CountScore
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = CountScore.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8311125534162130706L,/* translation unit id   */ 6169255785757396883L,/* timestamp             */ 1709177900370L,/* source file name      */ "CountScore.java",/* probe size            */ 111);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_559d99737697cf93(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Begin counting a score.
        @param board The board.
        @param deadStones Initial set of stones to be marked as dead. */
    public void begin(ConstBoard board, ConstPointList deadStones)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(0);m_board = board;
        int size = board.getSize();
        m_dead = new Marker(size);
        m_score = new GoColor[size][size];
        $qualityscroll_cover_jacov_probe_559d99737697cf93(1);for (GoPoint p : m_board)
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(7);m_dead.clear(p);}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(2);if ((deadStones != null) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(4) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(3);for (GoPoint p : deadStones)
                {$qualityscroll_cover_jacov_probe_559d99737697cf93(6);m_dead.set(p);}}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(5);compute();
    }

    /** Change the life and death status of a group of stones.
        Will change the life and death status of all stones of the same color
        in the connected region surrounded by opponent stones, if all
        surrounding opponent stones are alive. Otherwise it only changes the
        life death status of all stones in the block the stone belongs to.
        @param p Location of a stone.
        @return List of all points that changed their life and death status. */
    public PointList changeStatus(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(8);GoColor c = m_board.getColor(p);
        assert c.isBlackWhite();
        PointList stones = new PointList();
        Marker marker = new Marker(m_board.getSize());
        boolean allSurroundingAlive = findRegion(p, c, marker, stones);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(9);if ((! allSurroundingAlive) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(11) && false))
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(10);stones.clear();
            m_board.getStones(p, c, stones);
        }
        $qualityscroll_cover_jacov_probe_559d99737697cf93(12);boolean isDead = ! isDead(p);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(13);for (GoPoint stone : stones)
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(15);setDead(stone, isDead);}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(14);return stones;
    }

    /** Update score after changing the life-death status of stones. */
    public void compute()
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(16);Marker mark = new Marker(m_board.getSize());
        boolean allEmpty = true;
        $qualityscroll_cover_jacov_probe_559d99737697cf93(17);for (GoPoint p : m_board)
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(34);GoColor c = m_board.getColor(p);
            setScore(p, EMPTY);
            $qualityscroll_cover_jacov_probe_559d99737697cf93(35);if ((c != EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(37) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(36);allEmpty = false;
                $qualityscroll_cover_jacov_probe_559d99737697cf93(38);if ((! m_dead.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(40) && false))
                    {$qualityscroll_cover_jacov_probe_559d99737697cf93(39);setScore(p, c);}
            }
        }
        $qualityscroll_cover_jacov_probe_559d99737697cf93(18);if ((allEmpty) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(20) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(19);return;}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(21);PointList territory = new PointList();
        $qualityscroll_cover_jacov_probe_559d99737697cf93(22);for (GoPoint p : m_board)
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(23);if ((! mark.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(25) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(24);territory.clear();
                $qualityscroll_cover_jacov_probe_559d99737697cf93(26);if ((isTerritory(mark, p, territory, BLACK)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(28) && false))
                    {$qualityscroll_cover_jacov_probe_559d99737697cf93(27);setScore(territory, BLACK);}
                else
                {
                    $qualityscroll_cover_jacov_probe_559d99737697cf93(29);mark.clear(territory);
                    $qualityscroll_cover_jacov_probe_559d99737697cf93(30);if ((isTerritory(mark, p, territory, WHITE)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(32) && false))
                        {$qualityscroll_cover_jacov_probe_559d99737697cf93(31);setScore(territory, WHITE);}
                    else
                        {$qualityscroll_cover_jacov_probe_559d99737697cf93(33);mark.clear(territory);}
                }
            }
        }
    }

    /** Get the owner of a point.
        @param p The point (empty or occupied)
        @return BLACK, if point belongs to Black; WHITE, if
        point belongs to White; EMPTY, if point is neutral. */
    public GoColor getColor(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(41);return m_score[p.getX()][p.getY()];
    }

    /** Get the life-death status of a stone.
        @param p The stone.
        @return true, if stone is dead, false if stone is alive. */
    public boolean isDead(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(42);return m_dead.get(p);
    }

    /** Get the score.
        @param komi The komi.
        @param rules The scoring method */
    public Score getScore(Komi komi, ScoringMethod rules)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(43);Score s = new Score();
        s.m_rules = rules;
        s.m_komi = komi;
        s.m_capturedBlack = m_board.getCaptured(BLACK);
        s.m_capturedWhite = m_board.getCaptured(WHITE);
        int areaDiff = 0;
        int territoryDiff = 0;
        $qualityscroll_cover_jacov_probe_559d99737697cf93(44);for (GoPoint p : m_board)
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(54);GoColor c = m_board.getColor(p);
            GoColor sc = getColor(p);
            $qualityscroll_cover_jacov_probe_559d99737697cf93(55);if ((sc == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(57) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(56);++s.m_areaBlack;
                ++areaDiff;
            }
            else {$qualityscroll_cover_jacov_probe_559d99737697cf93(72);if ((sc == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(74) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(73);++s.m_areaWhite;
                --areaDiff;
            }}
            $qualityscroll_cover_jacov_probe_559d99737697cf93(58);if ((c == EMPTY) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(60) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(59);if ((sc == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(62) && false))
                {
                    $qualityscroll_cover_jacov_probe_559d99737697cf93(61);++s.m_territoryBlack;
                    ++territoryDiff;
                }
                else {$qualityscroll_cover_jacov_probe_559d99737697cf93(69);if ((sc == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(71) && false))
                {
                    $qualityscroll_cover_jacov_probe_559d99737697cf93(70);++s.m_territoryWhite;
                    --territoryDiff;
                }}
            }
            $qualityscroll_cover_jacov_probe_559d99737697cf93(63);if ((c == BLACK && sc == WHITE) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(65) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(64);++s.m_capturedBlack;
                ++s.m_territoryWhite;
                --territoryDiff;
            }
            $qualityscroll_cover_jacov_probe_559d99737697cf93(66);if ((c == WHITE && sc == BLACK) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(68) && false))
            {
                $qualityscroll_cover_jacov_probe_559d99737697cf93(67);++s.m_capturedWhite;
                ++s.m_territoryBlack;
                ++territoryDiff;
            }
        }
        $qualityscroll_cover_jacov_probe_559d99737697cf93(45);s.m_resultArea = areaDiff;
        s.m_resultTerritory =
            s.m_capturedWhite - s.m_capturedBlack + territoryDiff;
        $qualityscroll_cover_jacov_probe_559d99737697cf93(46);if ((komi != null) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(48) && false))
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(47);s.m_resultArea -= komi.toDouble();
            s.m_resultTerritory -= komi.toDouble();
        }
        $qualityscroll_cover_jacov_probe_559d99737697cf93(49);if ((rules == TERRITORY) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(51) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(50);s.m_result = s.m_resultTerritory;}
        else
        {
            $qualityscroll_cover_jacov_probe_559d99737697cf93(53);assert rules == AREA;
            s.m_result = s.m_resultArea;
        }
        $qualityscroll_cover_jacov_probe_559d99737697cf93(52);return s;
    }

    /** Change the life-death status of a stone.
        All stones in a block have to be marked as dead or alive (see comment
        in the description of this class).
        You have to call #compute to update the score after changing the
        life-death status of one or more stones.
        @param p The stone.
        @param value true, if stone is dead, false if stone is alive. */
    public void setDead(GoPoint p, boolean value)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(75);m_dead.set(p, value);
    }

    private Marker m_dead;

    private GoColor m_score[][];

    private ConstBoard m_board;

    private boolean findRegion(GoPoint p, GoColor color, Marker marker,
                               PointList stones)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(76);if ((marker.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(78) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(77);return true;}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(79);GoColor c = m_board.getColor(p);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(80);if ((c == color.otherColor()) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(82) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(81);return ! isDead(p);}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(83);marker.set(p);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(84);if ((c == color) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(86) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(85);stones.add(p);}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(87);for (GoPoint adj : m_board.getAdjacent(p))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(89);if ((! findRegion(adj, color, marker, stones)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(91) && false))
                {$qualityscroll_cover_jacov_probe_559d99737697cf93(90);return false;}}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(88);return true;
    }

    private boolean isTerritory(Marker mark, GoPoint p,
                                PointList territory, GoColor color)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(92);GoColor c = getColor(p);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(93);if ((c == color.otherColor() && ! m_dead.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(95) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(94);return false;}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(96);if ((c.equals(color)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(98) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(97);return (! m_dead.get(p));}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(99);if ((mark.get(p)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(101) && false))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(100);return true;}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(102);mark.set(p);
        territory.add(p);
        $qualityscroll_cover_jacov_probe_559d99737697cf93(103);for (GoPoint adj : m_board.getAdjacent(p))
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(105);if ((! isTerritory(mark, adj, territory, color)) ? true : (!$qualityscroll_cover_jacov_probe_559d99737697cf93(107) && false))
                {$qualityscroll_cover_jacov_probe_559d99737697cf93(106);return false;}}
        $qualityscroll_cover_jacov_probe_559d99737697cf93(104);return true;
    }

    private void setScore(GoPoint p, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(108);assert c != null;
        m_score[p.getX()][p.getY()] = c;
    }

    private void setScore(ConstPointList points, GoColor c)
    {
        $qualityscroll_cover_jacov_probe_559d99737697cf93(109);for (GoPoint p : points)
            {$qualityscroll_cover_jacov_probe_559d99737697cf93(110);setScore(p, c);}
    }
}
