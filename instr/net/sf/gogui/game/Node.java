/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// Node.java

package net.sf.gogui.game;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import net.sf.gogui.go.BlackWhiteSet;
import net.sf.gogui.go.BlackWhiteEmptySet;
import net.sf.gogui.go.ConstPointList;
import net.sf.gogui.go.GoColor;
import static net.sf.gogui.go.GoColor.BLACK;
import static net.sf.gogui.go.GoColor.WHITE;
import static net.sf.gogui.go.GoColor.EMPTY;
import static net.sf.gogui.go.GoColor.BLACK_WHITE_EMPTY;
import net.sf.gogui.go.Move;
import net.sf.gogui.go.PointList;
import net.sf.gogui.go.GoPoint;
import net.sf.gogui.util.StringUtil;

/** Extended info.
    Contains markups and value, because these are used in the large SGF
    search traces of Explorer. */
final class ExtraInfo
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ExtraInfo.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5034758415222156716L,/* translation unit id   */ -4992126129624337299L,/* timestamp             */ 1709177900006L,/* source file name      */ "Node.java",/* probe size            */ 259);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public Map<MarkType,PointList> m_marked;

    /** Node value.
        Float instead of double for space efficiency. */
    public float m_value = Float.NaN;

    public MoreExtraInfo m_moreExtraInfo;

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(0);return ((m_marked == null || m_marked.size() == 0)
                && Float.isNaN(m_value)
                && (m_moreExtraInfo == null || m_moreExtraInfo.isEmpty()));
    }
}

/** More extended info.
    Contains all the information typically not in large SGF traces. */
final class MoreExtraInfo
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = MoreExtraInfo.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5034758415222156716L,/* translation unit id   */ -4992126129624337299L,/* timestamp             */ 1709177900006L,/* source file name      */ "Node.java",/* probe size            */ 259);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public SetupInfo m_setupInfo;

    public TimeInfo m_timeInfo;

    public SgfProperties m_sgfProperties;

    public Map<GoPoint,String> m_label;

    public GameInfo m_info;

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(1);return ((m_setupInfo == null || m_setupInfo.isEmpty())
                && (m_timeInfo == null || m_timeInfo.isEmpty())
                && (m_sgfProperties == null || m_sgfProperties.isEmpty())
                && (m_label == null || m_label.size() == 0)
                && (m_info == null || m_info.isEmpty()));
    }
}

final class SetupInfo
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = SetupInfo.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5034758415222156716L,/* translation unit id   */ -4992126129624337299L,/* timestamp             */ 1709177900006L,/* source file name      */ "Node.java",/* probe size            */ 259);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public GoColor m_player;

    /** Stones added or removed.
        The array is indexed by Black, White, Empty. */
    public BlackWhiteEmptySet<PointList> m_stones
        = new BlackWhiteEmptySet<PointList>(new PointList(), new PointList(),
                                            new PointList());

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(2);return (m_player == null && m_stones.get(BLACK).size() == 0
                 && m_stones.get(WHITE).size() == 0
                && m_stones.get(EMPTY).size() == 0);
    }
}

final class TimeInfo
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TimeInfo.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5034758415222156716L,/* translation unit id   */ -4992126129624337299L,/* timestamp             */ 1709177900006L,/* source file name      */ "Node.java",/* probe size            */ 259);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public BlackWhiteSet<Integer> m_movesLeft
        = new BlackWhiteSet<Integer>(-1, -1);

    public BlackWhiteSet<Double> m_timeLeft
        = new BlackWhiteSet<Double>(Double.NaN, Double.NaN);

    public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(3);return (m_movesLeft.get(BLACK) == -1 && m_movesLeft.get(WHITE) == -1
                && Double.isNaN(m_timeLeft.get(BLACK))
                && Double.isNaN(m_timeLeft.get(WHITE)));
    }
}

/** Node in a game tree.
    The memory requirement is optimized for nodes containing only a move and
    comment property (e.g. for GNU Go's large SGF traces).
    The optimization also expects that most nodes have only one child. */
public final class Node
    implements ConstNode
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = Node.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 5034758415222156716L,/* translation unit id   */ -4992126129624337299L,/* timestamp             */ 1709177900006L,/* source file name      */ "Node.java",/* probe size            */ 259);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/** Construct empty node. */
    public Node()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(4);
    }

    /** Construct node containing a move.
        @param move The move to store in this node. */
    public Node(Move move)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(5);m_move = move;
    }

    /** Append a node as a child to this node.
        @param node The node to append. */
    @SuppressWarnings("unchecked")
    public void append(Node node)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(6);assert node.m_father == null;
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(7);if ((m_children == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(9) && false))
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(8);m_children = node;
        }
        else
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(11);if ((m_children instanceof Node) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(13) && false))
            {
                $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(12);ArrayList<Node> list = new ArrayList<Node>(2);
                list.add((Node)m_children);
                list.add(node);
                m_children = list;
            }
            else
            {
                $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(14);((ArrayList<Node>)m_children).add(node);
            }
        }
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(10);node.m_father = this;
    }

    /** Add a markup.
        @param point The location that should be marked.
        @param type The type of the markup from Node.MARK_TYPES. */
    public void addMarked(GoPoint point, MarkType type)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(15);assert point != null;
        Map<MarkType,PointList> marked = createMarked();
        PointList pointList = marked.get(type);
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(16);if ((pointList == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(18) && false))
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(17);pointList = new PointList(1);
            pointList.add(point);
            marked.put(type, pointList);
        }
        else {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(19);if ((! pointList.contains(point)) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(21) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(20);pointList.add(point);}}
    }

    /** Add other unspecified SGF property.
        Do not add SGF properties that can be set with other member functions.
        This is for preserving unknown SGF properties that are unknown to
        this program, or cannot be handled in all cases.
        Example: the OT property is handled only if the value string, whose
        format is not specified by the SGF standard, is in a known format used
        by some other programs. Otherwise it is should be put to the unknown
        SGF properties, so that the old value is preserved if no new value
        is set in GameInfo.
        @param label The name of the property
        @param values The values of the property */
    public void addSgfProperty(String label, ArrayList<String> values)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(22);createSgfProperties().add(label, values);
    }

    public void addSgfProperty(String label, String value)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(23);createSgfProperties().add(label, value);
    }

    /** Add or remove a setup stone.
        It is not checked, if this stone is already in the list of added
        or removed stones.
        @param c The color of the stone (Black or White; Empty for removal).
        @param p The location of the setup stone. */
    public void addStone(GoColor c, GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(24);assert p != null;
        createSetupInfo().m_stones.get(c).add(p);
    }

    /** Add or remove a list of setup stones.
        It is not checked, if this stone is already in the list of added
        or removed stones.
        @param c The color of the stone (Black or White; Empty for removal).
        @param list The locations of the setup stones. */
    public void addStones(GoColor c, ConstPointList list)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(25);assert list != null;
        createSetupInfo().m_stones.get(c).addAllFromConst(list);
    }

    /** Create game information or return it if already existing. */
    public GameInfo createGameInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(26);MoreExtraInfo moreExtraInfo = createMoreExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(27);if ((moreExtraInfo.m_info == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(29) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(28);moreExtraInfo.m_info = new GameInfo();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(30);return moreExtraInfo.m_info;
    }

    /** Child of main variation or null if no child.
        @return Node with index 0 or null, if no children. */
    public Node getChild()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(31);if ((! hasChildren()) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(33) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(32);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(34);return getChild(0);
    }

    /** Child of main variation or null if no child (const).
        @return Node with index 0 or null, if no children. */
    @Override
	public ConstNode getChildConst()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(35);return getChild();
    }

    /** Get child node.
        @param i Index of the child in [0...getNumberChildren() - 1]
        @return The child node */
    public Node getChild(int i)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(36);if ((getNumberChildren() == 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(38) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(37);return (Node)m_children;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(39);return (Node)((ArrayList)m_children).get(i);
    }

    /** Get child node (const).
        @param i Index of the child in [0...getNumberChildren() - 1]
        @return The child node */
    @Override
	public ConstNode getChildConst(int i)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(40);return getChild(i);
    }

    /** Get index of child node.
        @param child The child.
        @return Index of child or -1, if node is not a child of this node. */
    @Override
	public int getChildIndex(ConstNode child)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(41);for (int i = 0; (i < getNumberChildren()) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(43) && false); ++i)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(42);if ((getChildConst(i) == child) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(46) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(45);return i;}}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(44);return -1;
    }

    /** Get comment.
        @return Comment stored in this node or null, if node contains no
        comment. */
    @Override
	public String getComment()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(47);if ((m_comment == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(49) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(48);return null;}
        try
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(50);return new String(m_comment, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(51);return new String(m_comment);
        }
    }

    /** Get father node.
        @return Father node of this node or null, if no father. */
    public Node getFather()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(52);return m_father;
    }

    /** Get father node (const).
        @return Father node of this node or null, if no father. */
    @Override
	public ConstNode getFatherConst()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(53);return m_father;
    }

    public GameInfo getGameInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(54);if ((m_extraInfo == null || m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(56) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(55);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(57);return m_extraInfo.m_moreExtraInfo.m_info;
    }

    @Override
	public ConstGameInfo getGameInfoConst()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(58);return getGameInfo();
    }

    /** Get label for a location on the board.
        @param point The location.
        @return Label at location or null, if no label. */
    @Override
	public String getLabel(GoPoint point)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(59);Map<GoPoint,String> map = getLabels();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(60);if ((map == null || ! map.containsKey(point)) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(62) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(61);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(63);return map.get(point);
    }

    /** Get all labels on the board.
        @return Map containing (Point,String) pairs. */
    public Map<GoPoint,String> getLabels()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(64);if ((m_extraInfo == null || m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(66) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(65);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(67);return m_extraInfo.m_moreExtraInfo.m_label;
    }

    /** Get all labels on the board (unmodifiable). */
    @Override
	public Map<GoPoint,String> getLabelsUnmodifiable()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(68);Map<GoPoint,String> labels = getLabels();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(69);if ((labels == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(71) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(70);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(72);return Collections.unmodifiableMap(labels);
    }

    /** Get all markups of a type.
        @param type Markup type from Node.MARK_TYPES.
        @return Map containing (Point,String) pairs. */
    public PointList getMarked(MarkType type)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(73);if ((m_extraInfo == null || m_extraInfo.m_marked == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(75) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(74);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(76);return m_extraInfo.m_marked.get(type);
    }

    /** Get all markups of a type (const).
        @param type Markup type from Node.MARK_TYPES.
        @return Map containing (Point,String) pairs. */
    @Override
	public ConstPointList getMarkedConst(MarkType type)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(77);return getMarked(type);
    }

    /** Get move contained in this node.
        @return Move or null, if no move. */
    @Override
	public Move getMove()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(78);return m_move;
    }

    /** Moves left in byoyomi.
        @param c The color.
        @return Moves left in byoyomi for that color or -1 if not in byoyomi or
        unknown. */
    @Override
	public int getMovesLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(79);assert c.isBlackWhite();
        TimeInfo timeInfo = getTimeInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(80);if ((timeInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(82) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(81);return -1;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(83);return timeInfo.m_movesLeft.get(c);
    }

    /** Get number of children.
        @return Number of children. */
    @Override
	public int getNumberChildren()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(84);if ((m_children == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(86) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(85);return 0;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(87);if ((m_children instanceof Node) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(89) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(88);return 1;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(90);return ((ArrayList)m_children).size();
    }

    /** Color to play if explicitely set.
        @see #getToMove for getting the color to play.
        @return Color to play or null if color is not explicitely set. */
    @Override
	public GoColor getPlayer()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(91);SetupInfo setupInfo = getSetupInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(92);if ((setupInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(94) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(93);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(95);return setupInfo.m_player;
    }

    /** Get setup stones.
        @param c Color of the stones; EMPTY for removed stones.
        @return The added or removed stones. */
    @Override
	public ConstPointList getSetup(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(96);SetupInfo setupInfo = getSetupInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(97);if ((setupInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(99) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(98);return PointList.getEmptyList();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(100);return setupInfo.m_stones.get(c);
    }

    /** Get other unspecified SGF properties.
        @return The map with other SGF properties mapping String label
        to String value
        @see #addSgfProperty */
    public SgfProperties getSgfProperties()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(101);if ((m_extraInfo == null || m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(103) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(102);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(104);return m_extraInfo.m_moreExtraInfo.m_sgfProperties;
    }

    /** Get other unspecified SGF properties (const).
        @return The map with other SGF properties mapping String label
        to String value
        @see #addSgfProperty */
    @Override
	public ConstSgfProperties getSgfPropertiesConst()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(105);return getSgfProperties();
    }

    /** Time left for color after move was made.
        @param c The color
        @return Time left in seconds for this color or Double.NaN if unknown */
    @Override
	public double getTimeLeft(GoColor c)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(106);assert c.isBlackWhite();
        TimeInfo timeInfo = getTimeInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(107);if ((timeInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(109) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(108);return Double.NaN;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(110);return timeInfo.m_timeLeft.get(c);
    }

    /** Get color to move.
        If a player is explicitely set, it is returned, otherwise if the
        node contains a move, the color of the move is returned.
        @return The color to move or null if nothing is known about
        the color to move */
    @Override
	public GoColor getToMove()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(111);GoColor player = getPlayer();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(112);if ((player != null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(114) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(113);return player;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(115);if ((m_move != null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(117) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(116);return m_move.getColor().otherColor();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(118);return null;
    }

    /** Return a value for the node.
        The meaning of a value is according to the SGF property V[]
        @return The value, or Float.NaN, if node contains no value */
    @Override
	public float getValue()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(119);if ((m_extraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(121) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(120);return Float.NaN;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(122);return m_extraInfo.m_value;
    }

    @Override
	public boolean hasChildren()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(123);return (getNumberChildren() > 0);
    }

    /** Check if node contains a comment.
        More efficient than #getComment(), because getComment decodes the
        comment into a String, if it exists.
        @return true if node contains a comment */
    @Override
	public boolean hasComment()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(124);return (m_comment != null);
    }

    @Override
	public boolean hasFather()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(125);return (getFatherConst() != null);
    }

    /** Check if node has setup or delete stones.
        @return true, if node has setup or delete stones. */
    @Override
	public boolean hasSetup()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(126);for (GoColor c : BLACK_WHITE_EMPTY)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(128);if ((getSetup(c).size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(130) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(129);return true;}}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(127);return false;
    }

    /** Check if node is child of this node.
        @param node The node to check.
        @return true, if node is child node. */
    public boolean isChildOf(Node node)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(131);return (node.getChildIndex(this) != -1);
    }

    /** Return true, if node stores no information. */
    @Override
	public boolean isEmpty()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(132);return (m_comment == null && m_move == null
                && (m_extraInfo == null || m_extraInfo.isEmpty()));
    }

    /** Make child the first child of this node.
        @param child One of the child nodes of this node. */
    @SuppressWarnings("unchecked")
    public void makeFirstChild(Node child)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(133);assert child.isChildOf(this);
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(134);if ((getNumberChildren() <= 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(136) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(135);return;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(137);ArrayList<Node> list = (ArrayList<Node>)m_children;
        list.remove(child);
        list.add(0, child);
    }

    /** Remove child of this node.
        @param child Child to remove. */
    public void removeChild(Node child)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(138);assert child.isChildOf(this);
        int numberChildren = getNumberChildren();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(139);if ((numberChildren == 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(141) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(140);m_children = null;}
        else {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(143);if ((numberChildren >= 2) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(145) && false))
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(144);ArrayList list = (ArrayList)m_children;
            list.remove(child);
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(146);if ((numberChildren == 2) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(148) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(147);m_children = list.get(0);}
        }
        else
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(149);assert false;}}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(142);child.m_father = null;
    }

    /** Remove markup.
        @param point Location of the markup.
        @param type Type of the markup from Node.MARK_TYPES. */
    public void removeMarked(GoPoint point, MarkType type)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(150);assert point != null;
        Map<MarkType,PointList> marked = createMarked();
        PointList pointList = marked.get(type);
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(151);if ((pointList != null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(153) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(152);pointList.remove(point);}
    }

    /** Remove setup at point.
        Remove any setup that was added with #addStone at a point.
        @param p Location of the setup. */
    public void removeSetup(GoPoint p)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(154);assert p != null;
        SetupInfo setupInfo = getSetupInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(155);if ((setupInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(157) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(156);return;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(158);for (GoColor c : BLACK_WHITE_EMPTY)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(159);while ((setupInfo.m_stones.get(c).remove(p)) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(161) && false)){$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(160);;}}
    }

    /** Remove all children but the first. */
    public void removeVariations()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(162);if ((getNumberChildren() <= 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(164) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(163);return;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(165);Node child = getChild(0);
        m_children = child;
    }

    /** Store comment in this node.
        @param comment The comment. If the parameter is null, empty or
        contains only whitespaces, then the comment will be deleted from this
        node. */
    public void setComment(String comment)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(166);if ((StringUtil.isEmpty(comment)) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(168) && false))
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(167);m_comment = null;
            return;
        }
        try
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(169);m_comment = comment.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(170);m_comment = comment.getBytes();
        }
    }

    /** Set father of this node.
        @param father The new father. */
    public void setFather(Node father)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(171);m_father = father;
    }

    /** Add label at a location on the board.
        Whitespaces will be trimmed.
        @param point The location.
        @param label The text of the label; empty string or null to delete
        the label. */
    public void setLabel(GoPoint point, String label)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(172);assert point != null;
        Map<GoPoint,String> map = createLabel();
        map.remove(point);
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(173);if ((label == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(175) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(174);return;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(176);label = label.trim();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(177);if ((label.equals("")) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(179) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(178);return;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(180);map.put(point, label);
    }

    /** Set move stored in this node.
        @param move The move or null, if no move. */
    public void setMove(Move move)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(181);m_move = move;
    }

    /** Set byoyomi moves left.
        @param c The player.
        @param n Number of moves left. */
    public void setMovesLeft(GoColor c, int n)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(182);assert c.isBlackWhite();
        createTimeInfo().m_movesLeft.set(c, n);
    }

    /** Set byoyomi time left.
        @param c The player.
        @param seconds Time left in seconds. */
    public void setTimeLeft(GoColor c, double seconds)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(183);assert c.isBlackWhite();
        createTimeInfo().m_timeLeft.set(c, seconds);
    }

    /** Explicitely set color to play.
        @param color Color to play. */
    public void setPlayer(GoColor color)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(184);assert color.isBlackWhite();
        createSetupInfo().m_player = color;
    }

    /** Set value for this node.
        @see #getValue()
        @param value The value */
    public void setValue(float value)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(185);createExtraInfo();
        m_extraInfo.m_value = value;
    }

    /** Sort the lists of setup stones (add stones and remove stones.
        Sorted lists for setup stones make it easier to compare, if
        two nodes have the same lists. */
    public void sortSetup()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(186);for (GoColor c : BLACK_WHITE_EMPTY)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(187);if ((getSetup(c).size() > 0) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(189) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(188);Collections.sort(getSetupInfo().m_stones.get(c));}}
    }

    /** Return next child after a given child.
        @param child The child
        @return The next child or null, if there is no next child */
    @Override
	public ConstNode variationAfter(ConstNode child)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(190);int numberChildren = getNumberChildren();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(191);if ((numberChildren == 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(193) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(192);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(194);int i;
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(195);for (i = 0; (i < numberChildren) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(197) && false); ++i)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(196);if ((getChildConst(i) == child) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(203) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(202);break;}}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(198);if ((i == numberChildren - 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(200) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(199);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(201);return getChildConst(i + 1);
    }

    /** Return previous child before a given child.
        @param child The child
        @return The previous child or null, if there is no previous child */
    @Override
	public ConstNode variationBefore(ConstNode child)
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(204);int numberChildren = getNumberChildren();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(205);if ((numberChildren == 1) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(207) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(206);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(208);int i;
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(209);for (i = 0; (i < numberChildren) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(211) && false); ++i)
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(210);if ((getChildConst(i) == child) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(217) && false))
                {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(216);break;}}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(212);if ((i == 0) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(214) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(213);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(215);return getChildConst(i - 1);
    }

    /** Comment stored as bytes.
        Store comments in UTF-8, because that saves up to a factor of 2 in
        size compared to a string. */
    private byte[] m_comment;

    private ExtraInfo m_extraInfo;

    private Move m_move;

    private Node m_father;

    /** Node if one child only, ArrayList otherwise. */
    private Object m_children;

    private void createExtraInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(218);if ((m_extraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(220) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(219);m_extraInfo = new ExtraInfo();}
    }

    private MoreExtraInfo createMoreExtraInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(221);createExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(222);if ((m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(224) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(223);m_extraInfo.m_moreExtraInfo = new MoreExtraInfo();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(225);return m_extraInfo.m_moreExtraInfo;
    }

    private Map<GoPoint,String> createLabel()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(226);MoreExtraInfo moreExtraInfo = createMoreExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(227);if ((moreExtraInfo.m_label == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(229) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(228);moreExtraInfo.m_label = new TreeMap<GoPoint,String>();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(230);return moreExtraInfo.m_label;
    }

    private Map<MarkType,PointList> createMarked()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(231);createExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(232);if ((m_extraInfo.m_marked == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(234) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(233);m_extraInfo.m_marked = new TreeMap<MarkType,PointList>();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(235);return m_extraInfo.m_marked;
    }

    private SetupInfo createSetupInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(236);MoreExtraInfo moreExtraInfo = createMoreExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(237);if ((moreExtraInfo.m_setupInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(239) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(238);moreExtraInfo.m_setupInfo = new SetupInfo();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(240);return moreExtraInfo.m_setupInfo;
    }

    private SgfProperties createSgfProperties()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(241);MoreExtraInfo moreExtraInfo = createMoreExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(242);if ((moreExtraInfo.m_sgfProperties == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(244) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(243);moreExtraInfo.m_sgfProperties = new SgfProperties();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(245);return moreExtraInfo.m_sgfProperties;
    }

    private TimeInfo createTimeInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(246);MoreExtraInfo moreExtraInfo = createMoreExtraInfo();
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(247);if ((moreExtraInfo.m_timeInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(249) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(248);moreExtraInfo.m_timeInfo = new TimeInfo();}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(250);return moreExtraInfo.m_timeInfo;
    }

    private SetupInfo getSetupInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(251);if ((m_extraInfo == null || m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(253) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(252);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(254);return m_extraInfo.m_moreExtraInfo.m_setupInfo;
    }

    private TimeInfo getTimeInfo()
    {
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(255);if ((m_extraInfo == null || m_extraInfo.m_moreExtraInfo == null) ? true : (!$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(257) && false))
            {$qualityscroll_cover_jacov_probe_bab867bc09cbb46d(256);return null;}
        $qualityscroll_cover_jacov_probe_bab867bc09cbb46d(258);return m_extraInfo.m_moreExtraInfo.m_timeInfo;
    }
}
