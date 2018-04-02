// Generated from /Users/zeyongcai-macpro/Development/SER502-Spring2018-Team2/src/main/resources/GodFather.g4 by ANTLR 4.7
package LexerAndParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GodFatherParser}.
 */
public interface GodFatherListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GodFatherParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GodFatherParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(GodFatherParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(GodFatherParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(GodFatherParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(GodFatherParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(GodFatherParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(GodFatherParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtArithAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtArithAssign(GodFatherParser.StmtArithAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtArithAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtArithAssign(GodFatherParser.StmtArithAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtBoolAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtBoolAssign(GodFatherParser.StmtBoolAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtBoolAssign}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtBoolAssign(GodFatherParser.StmtBoolAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtIf}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtIf(GodFatherParser.StmtIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtIf}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtIf(GodFatherParser.StmtIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtIfElse}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtIfElse(GodFatherParser.StmtIfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtIfElse}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtIfElse(GodFatherParser.StmtIfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtWhile}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtWhile(GodFatherParser.StmtWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtWhile}
	 * labeled alternative in {@link GodFatherParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtWhile(GodFatherParser.StmtWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExprCmp}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExprCmp(GodFatherParser.BoolExprCmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExprCmp}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExprCmp(GodFatherParser.BoolExprCmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExprValue}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExprValue(GodFatherParser.BoolExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExprValue}
	 * labeled alternative in {@link GodFatherParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExprValue(GodFatherParser.BoolExprValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(GodFatherParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(GodFatherParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GodFatherParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GodFatherParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GodFatherParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GodFatherParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GodFatherParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GodFatherParser.FactorContext ctx);
}
