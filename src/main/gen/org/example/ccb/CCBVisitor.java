// Generated from C:/java-learn/antlr-ccb/src/main/java/org/example/ccb\CCB.g4 by ANTLR 4.10.1

package org.example.ccb;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CCBParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CCBVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CCBParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(CCBParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCBParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CCBParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCBParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(CCBParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCBParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(CCBParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCBParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(CCBParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCBParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(CCBParser.Stat_blockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(CCBParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link CCBParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(CCBParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(CCBParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAtom(CCBParser.IntegerAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatAtom(CCBParser.FloatAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(CCBParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(CCBParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link CCBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(CCBParser.StringAtomContext ctx);
}