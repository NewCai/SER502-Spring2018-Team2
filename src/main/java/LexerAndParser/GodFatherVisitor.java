// Generated from /Users/zeyongcai-macpro/Development/SER502-Spring2018-Team2/src/main/resources/GodFather.g4 by ANTLR 4.7
package LexerAndParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GodFatherParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GodFatherVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GodFatherParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(GodFatherParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(GodFatherParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(GodFatherParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtArithAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtArithAssign(GodFatherParser.StmtArithAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtBoolAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBoolAssign(GodFatherParser.StmtBoolAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtIf}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtIf(GodFatherParser.StmtIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtIfElse}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtIfElse(GodFatherParser.StmtIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtWhile}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtWhile(GodFatherParser.StmtWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExprCmp}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExprCmp(GodFatherParser.BoolExprCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExprValue}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExprValue(GodFatherParser.BoolExprValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(GodFatherParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(GodFatherParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GodFatherParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(GodFatherParser.FactorContext ctx);
}
