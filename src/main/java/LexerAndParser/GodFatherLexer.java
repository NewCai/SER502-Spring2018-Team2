// Generated from /Users/zeyongcai-macpro/Development/SER502-Spring2018-Team2/src/main/resources/GodFather.g4 by ANTLR 4.7
package LexerAndParser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GodFatherLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		LE=10, SEMI=11, OR=12, GT=13, ASSIGN=14, GE=15, EQ=16, PLUS=17, MINUS=18, 
		NE=19, MUL=20, LT=21, DIV=22, INT=23, BOOL=24, NUMBER=25, TRUE=26, FALSE=27, 
		ID=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"LE", "SEMI", "OR", "GT", "ASSIGN", "GE", "EQ", "PLUS", "MINUS", "NE", 
		"MUL", "LT", "DIV", "INT", "BOOL", "NUMBER", "TRUE", "FALSE", "ID", "WS"
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


	public GodFatherLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GodFather.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\6\32\u0085\n\32\r\32\16\32\u0086\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\6\35\u0095\n\35\r\35"+
		"\16\35\u0096\3\36\6\36\u009a\n\36\r\36\16\36\u009b\3\36\3\36\2\2\37\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3"+
		"\2\5\3\2\62;\5\2C\\c|~~\5\2\13\f\17\17\"\"\2\u00a1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5@\3"+
		"\2\2\2\7B\3\2\2\2\tD\3\2\2\2\13F\3\2\2\2\rH\3\2\2\2\17M\3\2\2\2\21S\3"+
		"\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33c\3\2\2\2\35"+
		"e\3\2\2\2\37g\3\2\2\2!j\3\2\2\2#m\3\2\2\2%o\3\2\2\2\'q\3\2\2\2)t\3\2\2"+
		"\2+v\3\2\2\2-x\3\2\2\2/z\3\2\2\2\61~\3\2\2\2\63\u0084\3\2\2\2\65\u0088"+
		"\3\2\2\2\67\u008d\3\2\2\29\u0094\3\2\2\2;\u0099\3\2\2\2=>\7k\2\2>?\7h"+
		"\2\2?\4\3\2\2\2@A\7*\2\2A\6\3\2\2\2BC\7+\2\2C\b\3\2\2\2DE\7}\2\2E\n\3"+
		"\2\2\2FG\7\177\2\2G\f\3\2\2\2HI\7g\2\2IJ\7n\2\2JK\7u\2\2KL\7g\2\2L\16"+
		"\3\2\2\2MN\7y\2\2NO\7j\2\2OP\7k\2\2PQ\7n\2\2QR\7g\2\2R\20\3\2\2\2ST\7"+
		"r\2\2TU\7t\2\2UV\7k\2\2VW\7p\2\2WX\7v\2\2X\22\3\2\2\2YZ\7\'\2\2Z\24\3"+
		"\2\2\2[\\\7>\2\2\\]\7?\2\2]\26\3\2\2\2^_\7=\2\2_\30\3\2\2\2`a\7~\2\2a"+
		"b\7~\2\2b\32\3\2\2\2cd\7@\2\2d\34\3\2\2\2ef\7?\2\2f\36\3\2\2\2gh\7@\2"+
		"\2hi\7?\2\2i \3\2\2\2jk\7?\2\2kl\7?\2\2l\"\3\2\2\2mn\7-\2\2n$\3\2\2\2"+
		"op\7/\2\2p&\3\2\2\2qr\7#\2\2rs\7?\2\2s(\3\2\2\2tu\7,\2\2u*\3\2\2\2vw\7"+
		">\2\2w,\3\2\2\2xy\7\61\2\2y.\3\2\2\2z{\7k\2\2{|\7p\2\2|}\7v\2\2}\60\3"+
		"\2\2\2~\177\7d\2\2\177\u0080\7q\2\2\u0080\u0081\7q\2\2\u0081\u0082\7n"+
		"\2\2\u0082\62\3\2\2\2\u0083\u0085\t\2\2\2\u0084\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\64\3\2\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7t\2\2\u008a\u008b\7w\2\2\u008b\u008c\7g\2\2"+
		"\u008c\66\3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f\7c\2\2\u008f\u0090\7"+
		"n\2\2\u0090\u0091\7u\2\2\u0091\u0092\7g\2\2\u00928\3\2\2\2\u0093\u0095"+
		"\t\3\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097:\3\2\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\b\36\2\2\u009e<\3\2\2\2\6\2\u0086\u0096\u009b\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}