// Generated from parser\RichRail.g4 by ANTLR 4.7.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RichRailLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WAGONTYPE=11, ID=12, NUMBER=13, WHITESPACE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "WAGONTYPE", "ID", "NUMBER", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'train'", "'wagon'", "'numseats'", "'add'", "'to'", "'getnumseats'", 
		"'delete'", "'remove'", "'from'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WAGONTYPE", 
		"ID", "NUMBER", "WHITESPACE"
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


	public RichRailLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RichRail.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0085\n\f\3\r\3\r\7\r\u0089\n\r\f"+
		"\r\16\r\u008c\13\r\3\16\6\16\u008f\n\16\r\16\16\16\u0090\3\17\3\17\3\17"+
		"\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\3\2\4\4\2\62;c|\5\2\13\f\16\17\"\"\2\u0099\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5#\3\2\2\2\7)\3\2\2\2\t/\3\2\2\2"+
		"\138\3\2\2\2\r<\3\2\2\2\17?\3\2\2\2\21K\3\2\2\2\23R\3\2\2\2\25Y\3\2\2"+
		"\2\27\u0084\3\2\2\2\31\u0086\3\2\2\2\33\u008e\3\2\2\2\35\u0092\3\2\2\2"+
		"\37 \7p\2\2 !\7g\2\2!\"\7y\2\2\"\4\3\2\2\2#$\7v\2\2$%\7t\2\2%&\7c\2\2"+
		"&\'\7k\2\2\'(\7p\2\2(\6\3\2\2\2)*\7y\2\2*+\7c\2\2+,\7i\2\2,-\7q\2\2-."+
		"\7p\2\2.\b\3\2\2\2/\60\7p\2\2\60\61\7w\2\2\61\62\7o\2\2\62\63\7u\2\2\63"+
		"\64\7g\2\2\64\65\7c\2\2\65\66\7v\2\2\66\67\7u\2\2\67\n\3\2\2\289\7c\2"+
		"\29:\7f\2\2:;\7f\2\2;\f\3\2\2\2<=\7v\2\2=>\7q\2\2>\16\3\2\2\2?@\7i\2\2"+
		"@A\7g\2\2AB\7v\2\2BC\7p\2\2CD\7w\2\2DE\7o\2\2EF\7u\2\2FG\7g\2\2GH\7c\2"+
		"\2HI\7v\2\2IJ\7u\2\2J\20\3\2\2\2KL\7f\2\2LM\7g\2\2MN\7n\2\2NO\7g\2\2O"+
		"P\7v\2\2PQ\7g\2\2Q\22\3\2\2\2RS\7t\2\2ST\7g\2\2TU\7o\2\2UV\7q\2\2VW\7"+
		"x\2\2WX\7g\2\2X\24\3\2\2\2YZ\7h\2\2Z[\7t\2\2[\\\7q\2\2\\]\7o\2\2]\26\3"+
		"\2\2\2^_\7r\2\2_`\7c\2\2`a\7u\2\2ab\7u\2\2bc\7g\2\2cd\7p\2\2de\7i\2\2"+
		"ef\7g\2\2fg\7t\2\2gh\7y\2\2hi\7c\2\2ij\7i\2\2jk\7q\2\2k\u0085\7p\2\2l"+
		"m\7v\2\2mn\7t\2\2no\7c\2\2op\7p\2\2pq\7u\2\2qr\7r\2\2rs\7q\2\2st\7t\2"+
		"\2tu\7v\2\2uv\7y\2\2vw\7c\2\2wx\7i\2\2xy\7q\2\2y\u0085\7p\2\2z{\7n\2\2"+
		"{|\7q\2\2|}\7e\2\2}~\7q\2\2~\177\7o\2\2\177\u0080\7q\2\2\u0080\u0081\7"+
		"v\2\2\u0081\u0082\7k\2\2\u0082\u0083\7x\2\2\u0083\u0085\7g\2\2\u0084^"+
		"\3\2\2\2\u0084l\3\2\2\2\u0084z\3\2\2\2\u0085\30\3\2\2\2\u0086\u008a\4"+
		"c|\2\u0087\u0089\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\32\3\2\2\2\u008c\u008a\3\2\2"+
		"\2\u008d\u008f\4\62;\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\34\3\2\2\2\u0092\u0093\t\3\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\b\17\2\2\u0095\36\3\2\2\2\6\2\u0084\u008a\u0090"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}