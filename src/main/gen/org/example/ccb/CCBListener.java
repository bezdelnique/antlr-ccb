// Generated from C:/java-learn/antlr-ccb/src/main/java/org/example/ccb\CCB.g4 by ANTLR 4.10.1

package org.example.ccb;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CCBParser}.
 */
public interface CCBListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CCBParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(CCBParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(CCBParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCBParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CCBParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CCBParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCBParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CCBParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CCBParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCBParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(CCBParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(CCBParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCBParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(CCBParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(CCBParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCBParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(CCBParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCBParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(CCBParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(CCBParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(CCBParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(CCBParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(CCBParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(CCBParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(CCBParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntegerAtom(CCBParser.IntegerAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntegerAtom(CCBParser.IntegerAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFloatAtom(CCBParser.FloatAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFloatAtom(CCBParser.FloatAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(CCBParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(CCBParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(CCBParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(CCBParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(CCBParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(CCBParser.StringAtomContext ctx);
}