// Generated from GodFather.g4 by ANTLR 4.7.1
package frontend;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GodFatherParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		LE=10, SEMI=11, OR=12, GT=13, ASSIGN=14, GE=15, EQ=16, PLUS=17, MINUS=18, 
		NE=19, MUL=20, LT=21, DIV=22, INT=23, BOOL=24, NUMBER=25, TRUE=26, FALSE=27, 
		ID=28, WS=29;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_decl = 2, RULE_stmts = 3, RULE_stmt = 4, 
		RULE_bool_expr = 5, RULE_arith_expr = 6, RULE_term = 7, RULE_factor = 8;
	public static final String[] ruleNames = {
		"program", "decls", "decl", "stmts", "stmt", "bool_expr", "arith_expr", 
		"term", "factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'while'", "'print'", 
		"'%'", "'<='", "';'", "'||'", "'>'", "'='", "'>='", "'=='", "'+'", "'-'", 
		"'!='", "'*'", "'<'", "'/'", "'int'", "'bool'", null, "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "LE", "SEMI", 
		"OR", "GT", "ASSIGN", "GE", "EQ", "PLUS", "MINUS", "NE", "MUL", "LT", 
		"DIV", "INT", "BOOL", "NUMBER", "TRUE", "FALSE", "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GodFather.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GodFatherParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			decls();
			setState(19);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclsContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==BOOL) {
				{
				{
				setState(21);
				decl();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Token type;
		public TerminalNode ID() { return getToken(GodFatherParser.ID, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			((DeclContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOL) ) {
				((DeclContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(28);
			match(ID);
			setState(29);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0)) {
				{
				{
				setState(31);
				stmt();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtWhileContext extends StmtContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtWhileContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtArithAssignContext extends StmtContext {
		public TerminalNode ID() { return getToken(GodFatherParser.ID, 0); }
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public StmtArithAssignContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtArithAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtArithAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtArithAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtIfContext extends StmtContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtBoolAssignContext extends StmtContext {
		public TerminalNode ID() { return getToken(GodFatherParser.ID, 0); }
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public StmtBoolAssignContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtBoolAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtBoolAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtBoolAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtPrintContext extends StmtContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public StmtPrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtIfElseContext extends StmtContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public StmtIfElseContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterStmtIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitStmtIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitStmtIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new StmtArithAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(ID);
				setState(38);
				match(ASSIGN);
				setState(39);
				arith_expr();
				setState(40);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new StmtBoolAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(ID);
				setState(43);
				match(ASSIGN);
				setState(44);
				bool_expr();
				setState(45);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(T__0);
				setState(48);
				match(T__1);
				setState(49);
				bool_expr();
				setState(50);
				match(T__2);
				setState(51);
				match(T__3);
				setState(52);
				stmts();
				setState(53);
				match(T__4);
				}
				break;
			case 4:
				_localctx = new StmtIfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(T__0);
				setState(56);
				match(T__1);
				setState(57);
				bool_expr();
				setState(58);
				match(T__2);
				setState(59);
				match(T__3);
				setState(60);
				stmts();
				setState(61);
				match(T__4);
				setState(62);
				match(T__5);
				setState(63);
				match(T__3);
				setState(64);
				stmts();
				setState(65);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new StmtWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				match(T__6);
				setState(68);
				match(T__1);
				setState(69);
				bool_expr();
				setState(70);
				match(T__2);
				setState(71);
				match(T__3);
				setState(72);
				stmts();
				setState(73);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new StmtPrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				match(T__7);
				setState(76);
				match(T__1);
				setState(77);
				arith_expr();
				setState(78);
				match(T__2);
				setState(79);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_exprContext extends ParserRuleContext {
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
	 
		public Bool_exprContext() { }
		public void copyFrom(Bool_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolExprCmpContext extends Bool_exprContext {
		public Token op;
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public BoolExprCmpContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterBoolExprCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitBoolExprCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitBoolExprCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprValueContext extends Bool_exprContext {
		public Token value;
		public BoolExprValueContext(Bool_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterBoolExprValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitBoolExprValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitBoolExprValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool_expr);
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case NUMBER:
			case ID:
				_localctx = new BoolExprCmpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				arith_expr();
				setState(84);
				((BoolExprCmpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << GT) | (1L << GE) | (1L << EQ) | (1L << NE) | (1L << LT))) != 0)) ) {
					((BoolExprCmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(85);
				arith_expr();
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolExprValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				((BoolExprValueContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((BoolExprValueContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_exprContext extends ParserRuleContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterArith_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitArith_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitArith_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arith_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			term();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(91);
				((Arith_exprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((Arith_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(92);
				term();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			factor();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MUL) | (1L << DIV))) != 0)) {
				{
				{
				setState(99);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MUL) | (1L << DIV))) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(100);
				factor();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GodFatherParser.NUMBER, 0); }
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode ID() { return getToken(GodFatherParser.ID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GodFatherListener ) ((GodFatherListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GodFatherVisitor ) return ((GodFatherVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_factor);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(NUMBER);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__1);
				setState(108);
				arith_expr();
				setState(109);
				match(T__2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\3\5\7\5#\n\5\f\5\16\5"+
		"&\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\5\7[\n\7\3\b\3\b\3\b\7\b`\n\b\f\b\16\bc\13\b\3\t\3\t\3\t\7\th\n\t\f"+
		"\t\16\tk\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5\ns\n\n\3\n\2\2\13\2\4\6\b\n\f"+
		"\16\20\22\2\7\3\2\31\32\7\2\f\f\17\17\21\22\25\25\27\27\3\2\34\35\3\2"+
		"\23\24\5\2\13\13\26\26\30\30\2w\2\24\3\2\2\2\4\32\3\2\2\2\6\35\3\2\2\2"+
		"\b$\3\2\2\2\nS\3\2\2\2\fZ\3\2\2\2\16\\\3\2\2\2\20d\3\2\2\2\22r\3\2\2\2"+
		"\24\25\5\4\3\2\25\26\5\b\5\2\26\3\3\2\2\2\27\31\5\6\4\2\30\27\3\2\2\2"+
		"\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2"+
		"\35\36\t\2\2\2\36\37\7\36\2\2\37 \7\r\2\2 \7\3\2\2\2!#\5\n\6\2\"!\3\2"+
		"\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\t\3\2\2\2&$\3\2\2\2\'(\7\36\2\2("+
		")\7\20\2\2)*\5\16\b\2*+\7\r\2\2+T\3\2\2\2,-\7\36\2\2-.\7\20\2\2./\5\f"+
		"\7\2/\60\7\r\2\2\60T\3\2\2\2\61\62\7\3\2\2\62\63\7\4\2\2\63\64\5\f\7\2"+
		"\64\65\7\5\2\2\65\66\7\6\2\2\66\67\5\b\5\2\678\7\7\2\28T\3\2\2\29:\7\3"+
		"\2\2:;\7\4\2\2;<\5\f\7\2<=\7\5\2\2=>\7\6\2\2>?\5\b\5\2?@\7\7\2\2@A\7\b"+
		"\2\2AB\7\6\2\2BC\5\b\5\2CD\7\7\2\2DT\3\2\2\2EF\7\t\2\2FG\7\4\2\2GH\5\f"+
		"\7\2HI\7\5\2\2IJ\7\6\2\2JK\5\b\5\2KL\7\7\2\2LT\3\2\2\2MN\7\n\2\2NO\7\4"+
		"\2\2OP\5\16\b\2PQ\7\5\2\2QR\7\r\2\2RT\3\2\2\2S\'\3\2\2\2S,\3\2\2\2S\61"+
		"\3\2\2\2S9\3\2\2\2SE\3\2\2\2SM\3\2\2\2T\13\3\2\2\2UV\5\16\b\2VW\t\3\2"+
		"\2WX\5\16\b\2X[\3\2\2\2Y[\t\4\2\2ZU\3\2\2\2ZY\3\2\2\2[\r\3\2\2\2\\a\5"+
		"\20\t\2]^\t\5\2\2^`\5\20\t\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b"+
		"\17\3\2\2\2ca\3\2\2\2di\5\22\n\2ef\t\6\2\2fh\5\22\n\2ge\3\2\2\2hk\3\2"+
		"\2\2ig\3\2\2\2ij\3\2\2\2j\21\3\2\2\2ki\3\2\2\2ls\7\33\2\2mn\7\4\2\2no"+
		"\5\16\b\2op\7\5\2\2ps\3\2\2\2qs\7\36\2\2rl\3\2\2\2rm\3\2\2\2rq\3\2\2\2"+
		"s\23\3\2\2\2\t\32$SZair";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}