/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GoGuiUtil.java

package net.sf.gogui.gogui;

import static java.text.MessageFormat.format;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.NodeUtil;
import net.sf.gogui.go.Move;
import static net.sf.gogui.gogui.I18n.i18n;
import net.sf.gogui.gui.StatusBar;

/** Utility functions for class GoGui. */
public final class GoGuiUtil
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GoGuiUtil.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ 4527911786769354019L,/* translation unit id   */ -2696987301700776699L,/* timestamp             */ 1709177900959L,/* source file name      */ "GoGuiUtil.java",/* probe size            */ 70);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_da9260569e62cd05(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public static void updateMoveText(StatusBar statusBar, ConstGame game)
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(0);statusBar.setToPlay(game.getToMove());
        ConstNode node = game.getCurrentNode();
        int moveNumber = NodeUtil.getMoveNumber(node);
        int movesLeft = NodeUtil.getMovesLeft(node);
        int totalMoves = moveNumber + movesLeft;
        Move move = node.getMove();
        String variation = NodeUtil.getVariationString(node);
        boolean mainVar = "".equals(variation);
        StringBuilder moveText = new StringBuilder(128);
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(1);if ((moveNumber > 0) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(3) && false))
        {
            $qualityscroll_cover_jacov_probe_da9260569e62cd05(2);moveText.append(moveNumber);
            moveText.append(' ');
        }
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(4);if ((movesLeft > 0) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(6) && false))
        {
            $qualityscroll_cover_jacov_probe_da9260569e62cd05(5);moveText.append('(');
            moveText.append(totalMoves);
            moveText.append(") ");
        }

        $qualityscroll_cover_jacov_probe_da9260569e62cd05(7);if ((move != null) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(9) && false))
        {
            $qualityscroll_cover_jacov_probe_da9260569e62cd05(8);moveText.append(move);
            moveText.append(' ');
        }
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(10);if ((! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(12) && false))
        {
            $qualityscroll_cover_jacov_probe_da9260569e62cd05(11);moveText.append('[');
            moveText.append(variation);
            moveText.append(']');
        }
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(13);String tip = null;
        boolean lastMove = (move != null);
        boolean noLastMove1 = (move == null && moveNumber == 1);
        boolean noLastMoveN = (move == null && moveNumber > 1);
        boolean noMovesLeft = (movesLeft == 0);
        boolean movesLeft1 = (movesLeft > 0 && totalMoves == 1);
        boolean movesLeftN = (movesLeft > 0 && totalMoves > 1);
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(14);if ((noLastMove1 && noMovesLeft && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(16) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(15);tip = i18n("TT_MOVETEXT_1");}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(18);if ((noLastMoveN && noMovesLeft && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(20) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(19);tip = format(i18n("TT_MOVETEXT_2"), moveNumber);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(21);if ((lastMove && noMovesLeft && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(23) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(22);tip = format(i18n("TT_MOVETEXT_3"), moveNumber, move);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(24);if ((noLastMove1 && movesLeft1 && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(26) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(25);tip = i18n("TT_MOVETEXT_4");}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(27);if ((noLastMoveN && movesLeft1 && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(29) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(28);tip = format(i18n("TT_MOVETEXT_5"), moveNumber);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(30);if ((lastMove && movesLeft1 && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(32) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(31);tip = format(i18n("TT_MOVETEXT_6"), moveNumber, move);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(33);if ((noLastMove1 && movesLeftN && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(35) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(34);tip = format(i18n("TT_MOVETEXT_7"), totalMoves);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(36);if ((noLastMoveN && movesLeftN && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(38) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(37);tip = format(i18n("TT_MOVETEXT_8"), moveNumber, totalMoves);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(39);if ((lastMove && movesLeftN && mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(41) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(40);tip = format(i18n("TT_MOVETEXT_9"), moveNumber, move, totalMoves);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(42);if ((noLastMove1 && noMovesLeft && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(44) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(43);tip = format(i18n("TT_MOVETEXT_10"), variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(45);if ((noLastMoveN && noMovesLeft && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(47) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(46);tip = format(i18n("TT_MOVETEXT_11"), moveNumber, variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(48);if ((lastMove && noMovesLeft && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(50) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(49);tip = format(i18n("TT_MOVETEXT_12"), moveNumber, move, variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(51);if ((noLastMove1 && movesLeft1 && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(53) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(52);tip = format(i18n("TT_MOVETEXT_13"), variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(54);if ((noLastMoveN && movesLeft1 && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(56) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(55);tip = format(i18n("TT_MOVETEXT_14"), moveNumber, variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(57);if ((lastMove && movesLeft1 && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(59) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(58);tip = format(i18n("TT_MOVETEXT_15"), moveNumber, move, variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(60);if ((noLastMove1 && movesLeftN && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(62) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(61);tip = format(i18n("TT_MOVETEXT_16"), totalMoves, variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(63);if ((noLastMoveN && movesLeftN && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(65) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(64);tip = format(i18n("TT_MOVETEXT_17"), moveNumber, totalMoves,
                         variation);}
        else {$qualityscroll_cover_jacov_probe_da9260569e62cd05(66);if ((lastMove && movesLeftN && ! mainVar) ? true : (!$qualityscroll_cover_jacov_probe_da9260569e62cd05(68) && false))
            {$qualityscroll_cover_jacov_probe_da9260569e62cd05(67);tip = format(i18n("TT_MOVETEXT_18"), moveNumber, move, totalMoves,
                         variation);}}}}}}}}}}}}}}}}}}
        $qualityscroll_cover_jacov_probe_da9260569e62cd05(17);statusBar.setMoveText(moveText.toString(), tip);
    }

    /** Make constructor unavailable; class is for namespace only. */
    private GoGuiUtil()
    {$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_da9260569e62cd05(69);
    }
}
