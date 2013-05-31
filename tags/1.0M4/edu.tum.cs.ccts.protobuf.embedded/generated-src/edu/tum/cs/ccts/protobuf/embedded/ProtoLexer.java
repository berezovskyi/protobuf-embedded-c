// $ANTLR 3.5 /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g 2013-05-30 20:27:22

package edu.tum.cs.ccts.protobuf.embedded;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class ProtoLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int ANNOTATION=4;
	public static final int ASSIGN=5;
	public static final int AT=6;
	public static final int COMMENT=7;
	public static final int DEFAULT=8;
	public static final int DIGIT=9;
	public static final int DOT=10;
	public static final int ENUM=11;
	public static final int EXPONENT=12;
	public static final int ID=13;
	public static final int IMPORT=14;
	public static final int INTEGER=15;
	public static final int LETTER=16;
	public static final int MESSAGE=17;
	public static final int MODIFIER=18;
	public static final int OPTION=19;
	public static final int PACKAGE=20;
	public static final int PROTO=21;
	public static final int REAL=22;
	public static final int SIGN=23;
	public static final int STRING=24;
	public static final int TYPE=25;
	public static final int WHITESPACE=26;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ProtoLexer() {} 
	public ProtoLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ProtoLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g"; }

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:6:8: ( '=' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:6:10: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:7:9: ( 'default' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:7:11: 'default'
			{
			match("default"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:8:6: ( 'enum' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:8:8: 'enum'
			{
			match("enum"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENUM"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:9:8: ( 'import' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:9:10: 'import'
			{
			match("import"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "MESSAGE"
	public final void mMESSAGE() throws RecognitionException {
		try {
			int _type = MESSAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:10:9: ( 'message' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:10:11: 'message'
			{
			match("message"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MESSAGE"

	// $ANTLR start "OPTION"
	public final void mOPTION() throws RecognitionException {
		try {
			int _type = OPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:11:8: ( 'option' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:11:10: 'option'
			{
			match("option"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTION"

	// $ANTLR start "PACKAGE"
	public final void mPACKAGE() throws RecognitionException {
		try {
			int _type = PACKAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:12:9: ( 'package' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:12:11: 'package'
			{
			match("package"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PACKAGE"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:13:7: ( ';' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:13:9: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:14:7: ( '[' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:14:9: '['
			{
			match('['); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:15:7: ( ']' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:15:9: ']'
			{
			match(']'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:16:7: ( '{' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:16:9: '{'
			{
			match('{'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:17:7: ( '}' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:17:9: '}'
			{
			match('}'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "MODIFIER"
	public final void mMODIFIER() throws RecognitionException {
		try {
			int _type = MODIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:102:2: ( 'required' | 'repeated' | 'optional' )
			int alt1=3;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='r') ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='e') ) {
					int LA1_3 = input.LA(3);
					if ( (LA1_3=='q') ) {
						alt1=1;
					}
					else if ( (LA1_3=='p') ) {
						alt1=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='o') ) {
				alt1=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:102:4: 'required'
					{
					match("required"); if (state.failed) return;

					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:102:17: 'repeated'
					{
					match("repeated"); if (state.failed) return;

					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:102:30: 'optional'
					{
					match("optional"); if (state.failed) return;

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MODIFIER"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:2: ( 'float' | 'double' | 'int32' | 'int64' | 'sint32' | 'sint64' | 'uint32' | 'unit64' | 'bool' | 'string' | 'fixed32' | 'fixed64' | 'sfixed32' | 'sfixed64' | 'bytes' )
			int alt2=15;
			switch ( input.LA(1) ) {
			case 'f':
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='l') ) {
					alt2=1;
				}
				else if ( (LA2_1=='i') ) {
					int LA2_8 = input.LA(3);
					if ( (LA2_8=='x') ) {
						int LA2_17 = input.LA(4);
						if ( (LA2_17=='e') ) {
							int LA2_21 = input.LA(5);
							if ( (LA2_21=='d') ) {
								int LA2_26 = input.LA(6);
								if ( (LA2_26=='3') ) {
									alt2=11;
								}
								else if ( (LA2_26=='6') ) {
									alt2=12;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 26, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 21, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'd':
				{
				alt2=2;
				}
				break;
			case 'i':
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3=='n') ) {
					int LA2_9 = input.LA(3);
					if ( (LA2_9=='t') ) {
						int LA2_18 = input.LA(4);
						if ( (LA2_18=='3') ) {
							alt2=3;
						}
						else if ( (LA2_18=='6') ) {
							alt2=4;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 's':
				{
				switch ( input.LA(2) ) {
				case 'i':
					{
					int LA2_10 = input.LA(3);
					if ( (LA2_10=='n') ) {
						int LA2_19 = input.LA(4);
						if ( (LA2_19=='t') ) {
							int LA2_24 = input.LA(5);
							if ( (LA2_24=='3') ) {
								alt2=5;
							}
							else if ( (LA2_24=='6') ) {
								alt2=6;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 24, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 19, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 10, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 't':
					{
					alt2=10;
					}
					break;
				case 'f':
					{
					int LA2_12 = input.LA(3);
					if ( (LA2_12=='i') ) {
						int LA2_20 = input.LA(4);
						if ( (LA2_20=='x') ) {
							int LA2_25 = input.LA(5);
							if ( (LA2_25=='e') ) {
								int LA2_29 = input.LA(6);
								if ( (LA2_29=='d') ) {
									int LA2_32 = input.LA(7);
									if ( (LA2_32=='3') ) {
										alt2=13;
									}
									else if ( (LA2_32=='6') ) {
										alt2=14;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 2, 32, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 29, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 25, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 12, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 'u':
				{
				int LA2_5 = input.LA(2);
				if ( (LA2_5=='i') ) {
					alt2=7;
				}
				else if ( (LA2_5=='n') ) {
					alt2=8;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'b':
				{
				int LA2_6 = input.LA(2);
				if ( (LA2_6=='o') ) {
					alt2=9;
				}
				else if ( (LA2_6=='y') ) {
					alt2=15;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:4: 'float'
					{
					match("float"); if (state.failed) return;

					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:14: 'double'
					{
					match("double"); if (state.failed) return;

					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:25: 'int32'
					{
					match("int32"); if (state.failed) return;

					}
					break;
				case 4 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:35: 'int64'
					{
					match("int64"); if (state.failed) return;

					}
					break;
				case 5 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:45: 'sint32'
					{
					match("sint32"); if (state.failed) return;

					}
					break;
				case 6 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:106:56: 'sint64'
					{
					match("sint64"); if (state.failed) return;

					}
					break;
				case 7 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:6: 'uint32'
					{
					match("uint32"); if (state.failed) return;

					}
					break;
				case 8 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:17: 'unit64'
					{
					match("unit64"); if (state.failed) return;

					}
					break;
				case 9 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:28: 'bool'
					{
					match("bool"); if (state.failed) return;

					}
					break;
				case 10 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:37: 'string'
					{
					match("string"); if (state.failed) return;

					}
					break;
				case 11 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:48: 'fixed32'
					{
					match("fixed32"); if (state.failed) return;

					}
					break;
				case 12 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:107:60: 'fixed64'
					{
					match("fixed64"); if (state.failed) return;

					}
					break;
				case 13 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:108:8: 'sfixed32'
					{
					match("sfixed32"); if (state.failed) return;

					}
					break;
				case 14 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:108:21: 'sfixed64'
					{
					match("sfixed64"); if (state.failed) return;

					}
					break;
				case 15 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:108:34: 'bytes'
					{
					match("bytes"); if (state.failed) return;

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:112:5: ( '\"' (~ ( '\"' | '\\n' | '\\r' ) | '\\\\\"' )* '\"' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:112:9: '\"' (~ ( '\"' | '\\n' | '\\r' ) | '\\\\\"' )* '\"'
			{
			match('\"'); if (state.failed) return;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:112:13: (~ ( '\"' | '\\n' | '\\r' ) | '\\\\\"' )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\\') ) {
					int LA3_2 = input.LA(2);
					if ( (LA3_2=='\"') ) {
						int LA3_4 = input.LA(3);
						if ( ((LA3_4 >= '\u0000' && LA3_4 <= '\t')||(LA3_4 >= '\u000B' && LA3_4 <= '\f')||(LA3_4 >= '\u000E' && LA3_4 <= '\uFFFF')) ) {
							alt3=2;
						}
						else {
							alt3=1;
						}

					}
					else if ( ((LA3_2 >= '\u0000' && LA3_2 <= '\t')||(LA3_2 >= '\u000B' && LA3_2 <= '\f')||(LA3_2 >= '\u000E' && LA3_2 <= '!')||(LA3_2 >= '#' && LA3_2 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:112:14: ~ ( '\"' | '\\n' | '\\r' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:112:33: '\\\\\"'
					{
					match("\\\""); if (state.failed) return;

					}
					break;

				default :
					break loop3;
				}
			}

			match('\"'); if (state.failed) return;
			if ( state.backtracking==0 ) {
			            /* Trim quotes and replace escaped quotes. */
			            setText(getText().substring(1, getText().length() - 1).replace("\\\"", "\""));
			        }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:120:5: ( LETTER ( LETTER | DIGIT )* )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:120:9: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); if (state.failed) return;

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:120:16: ( LETTER | DIGIT )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:124:5: ( '.' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:124:9: '.'
			{
			match('.'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:128:2: ( '//' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:128:4: '//'
			{
			match("//"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:132:2: ( '@' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:132:4: '@'
			{
			match('@'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:136:5: ( ( SIGN )? ( DIGIT )+ )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:136:9: ( SIGN )? ( DIGIT )+
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:136:9: ( SIGN )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='+'||LA5_0=='-') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:136:15: ( DIGIT )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "REAL"
	public final void mREAL() throws RecognitionException {
		try {
			int _type = REAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:140:5: ( ( SIGN )? ( DIGIT )+ ( ( DOT DIGIT )=> DOT ( DIGIT )+ ( EXPONENT )? | EXPONENT |) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:140:9: ( SIGN )? ( DIGIT )+ ( ( DOT DIGIT )=> DOT ( DIGIT )+ ( EXPONENT )? | EXPONENT |)
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:140:9: ( SIGN )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='+'||LA7_0=='-') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:140:15: ( DIGIT )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:140:22: ( ( DOT DIGIT )=> DOT ( DIGIT )+ ( EXPONENT )? | EXPONENT |)
			int alt11=3;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='.') && (synpred1_Proto())) {
				alt11=1;
			}
			else if ( (LA11_0=='E'||LA11_0=='e') ) {
				alt11=2;
			}

			else {
				alt11=3;
			}

			switch (alt11) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:13: ( DOT DIGIT )=> DOT ( DIGIT )+ ( EXPONENT )?
					{
					mDOT(); if (state.failed) return;

					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:32: ( DIGIT )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:39: ( EXPONENT )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='E'||LA10_0=='e') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:39: EXPONENT
							{
							mEXPONENT(); if (state.failed) return;

							}
							break;

					}

					if ( state.backtracking==0 ) {_type=REAL;}
					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:142:15: EXPONENT
					{
					mEXPONENT(); if (state.failed) return;

					if ( state.backtracking==0 ) {_type=REAL;}
					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:143:15: 
					{
					if ( state.backtracking==0 ) {_type=INTEGER;}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REAL"

	// $ANTLR start "ANNOTATION"
	public final void mANNOTATION() throws RecognitionException {
		try {
			int _type = ANNOTATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:148:5: ( COMMENT ( ( AT )=> AT | (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )? ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:148:9: COMMENT ( ( AT )=> AT | (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )? )
			{
			mCOMMENT(); if (state.failed) return;

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:148:17: ( ( AT )=> AT | (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )? )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='@') ) {
				int LA15_1 = input.LA(2);
				if ( (synpred2_Proto()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

			}

			else {
				alt15=2;
			}

			switch (alt15) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:149:7: ( AT )=> AT
					{
					mAT(); if (state.failed) return;

					if ( state.backtracking==0 ) {_type=ANNOTATION; setText("@");}
					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:9: (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )?
					{
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:9: (~ ( '\\n' | '\\r' ) )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop12;
						}
					}

					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:27: ( '\\n' | '\\r' ( '\\n' )? )?
					int alt14=3;
					int LA14_0 = input.LA(1);
					if ( (LA14_0=='\n') ) {
						alt14=1;
					}
					else if ( (LA14_0=='\r') ) {
						alt14=2;
					}
					switch (alt14) {
						case 1 :
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:28: '\\n'
							{
							match('\n'); if (state.failed) return;
							}
							break;
						case 2 :
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:35: '\\r' ( '\\n' )?
							{
							match('\r'); if (state.failed) return;
							// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:39: ( '\\n' )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0=='\n') ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:150:40: '\\n'
									{
									match('\n'); if (state.failed) return;
									}
									break;

							}

							}
							break;

					}

					if ( state.backtracking==0 ) {_channel=HIDDEN;}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANNOTATION"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:155:5: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:155:9: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:155:21: ( '+' | '-' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='+'||LA16_0=='-') ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:155:34: ( DIGIT )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:159:5: ( '0' .. '9' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:163:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "SIGN"
	public final void mSIGN() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:169:5: ( '+' | '-' )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
			{
			if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIGN"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:173:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:173:9: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:173:9: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( ((LA18_0 >= '\t' && LA18_0 <= '\n')||(LA18_0 >= '\f' && LA18_0 <= '\r')||LA18_0==' ') ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			if ( state.backtracking==0 ) {_channel=HIDDEN;}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:8: ( ASSIGN | DEFAULT | ENUM | IMPORT | MESSAGE | OPTION | PACKAGE | T__27 | T__28 | T__29 | T__30 | T__31 | MODIFIER | TYPE | STRING | ID | DOT | COMMENT | AT | INTEGER | REAL | ANNOTATION | WHITESPACE )
		int alt19=23;
		alt19 = dfa19.predict(input);
		switch (alt19) {
			case 1 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:10: ASSIGN
				{
				mASSIGN(); if (state.failed) return;

				}
				break;
			case 2 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:17: DEFAULT
				{
				mDEFAULT(); if (state.failed) return;

				}
				break;
			case 3 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:25: ENUM
				{
				mENUM(); if (state.failed) return;

				}
				break;
			case 4 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:30: IMPORT
				{
				mIMPORT(); if (state.failed) return;

				}
				break;
			case 5 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:37: MESSAGE
				{
				mMESSAGE(); if (state.failed) return;

				}
				break;
			case 6 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:45: OPTION
				{
				mOPTION(); if (state.failed) return;

				}
				break;
			case 7 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:52: PACKAGE
				{
				mPACKAGE(); if (state.failed) return;

				}
				break;
			case 8 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:60: T__27
				{
				mT__27(); if (state.failed) return;

				}
				break;
			case 9 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:66: T__28
				{
				mT__28(); if (state.failed) return;

				}
				break;
			case 10 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:72: T__29
				{
				mT__29(); if (state.failed) return;

				}
				break;
			case 11 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:78: T__30
				{
				mT__30(); if (state.failed) return;

				}
				break;
			case 12 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:84: T__31
				{
				mT__31(); if (state.failed) return;

				}
				break;
			case 13 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:90: MODIFIER
				{
				mMODIFIER(); if (state.failed) return;

				}
				break;
			case 14 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:99: TYPE
				{
				mTYPE(); if (state.failed) return;

				}
				break;
			case 15 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:104: STRING
				{
				mSTRING(); if (state.failed) return;

				}
				break;
			case 16 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:111: ID
				{
				mID(); if (state.failed) return;

				}
				break;
			case 17 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:114: DOT
				{
				mDOT(); if (state.failed) return;

				}
				break;
			case 18 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:118: COMMENT
				{
				mCOMMENT(); if (state.failed) return;

				}
				break;
			case 19 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:126: AT
				{
				mAT(); if (state.failed) return;

				}
				break;
			case 20 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:129: INTEGER
				{
				mINTEGER(); if (state.failed) return;

				}
				break;
			case 21 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:137: REAL
				{
				mREAL(); if (state.failed) return;

				}
				break;
			case 22 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:142: ANNOTATION
				{
				mANNOTATION(); if (state.failed) return;

				}
				break;
			case 23 :
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:1:153: WHITESPACE
				{
				mWHITESPACE(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_Proto
	public final void synpred1_Proto_fragment() throws RecognitionException {
		// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:13: ( DOT DIGIT )
		// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:141:14: DOT DIGIT
		{
		mDOT(); if (state.failed) return;

		mDIGIT(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Proto

	// $ANTLR start synpred2_Proto
	public final void synpred2_Proto_fragment() throws RecognitionException {
		// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:149:7: ( AT )
		// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:
		{
		if ( input.LA(1)=='@' ) {
			input.consume();
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			recover(mse);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred2_Proto

	public final boolean synpred2_Proto() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Proto_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_Proto() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Proto_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA19 dfa19 = new DFA19(this);
	static final String DFA19_eotS =
		"\2\uffff\6\23\5\uffff\5\23\6\uffff\1\55\1\uffff\22\23\1\102\2\uffff\23"+
		"\23\2\uffff\2\23\1\132\17\23\1\153\3\23\1\uffff\1\23\2\153\5\23\1\153"+
		"\7\23\1\uffff\1\153\1\23\1\153\1\176\1\23\1\u0081\5\23\3\153\1\23\2\153"+
		"\1\u0089\1\uffff\1\u008a\1\23\1\uffff\1\u008c\2\23\2\153\2\23\2\uffff"+
		"\1\u0091\1\uffff\2\u0091\2\153\1\uffff";
	static final String DFA19_eofS =
		"\u0092\uffff";
	static final String DFA19_minS =
		"\1\11\1\uffff\1\145\1\156\1\155\1\145\1\160\1\141\5\uffff\1\145\1\151"+
		"\1\146\1\151\1\157\3\uffff\1\57\1\uffff\1\60\1\56\1\uffff\1\146\2\165"+
		"\1\160\1\164\1\163\1\164\1\143\1\160\1\157\1\170\1\156\1\162\1\151\1\156"+
		"\1\151\1\157\1\164\1\0\2\uffff\1\141\1\142\1\155\1\157\1\63\1\163\1\151"+
		"\1\153\1\165\1\145\1\141\1\145\1\164\1\151\1\170\2\164\1\154\1\145\2\uffff"+
		"\1\165\1\154\1\60\1\162\1\62\1\64\1\141\1\157\1\141\1\151\1\141\1\164"+
		"\1\144\1\63\1\156\1\145\1\63\1\66\1\60\1\163\1\154\1\145\1\uffff\1\164"+
		"\2\60\1\147\1\156\1\147\1\162\1\164\1\60\1\63\1\62\1\64\1\147\1\144\1"+
		"\62\1\64\1\uffff\1\60\1\164\2\60\1\145\1\60\3\145\1\62\1\64\3\60\1\63"+
		"\3\60\1\uffff\1\60\1\154\1\uffff\1\60\2\144\2\60\1\62\1\64\2\uffff\1\60"+
		"\1\uffff\4\60\1\uffff";
	static final String DFA19_maxS =
		"\1\175\1\uffff\1\157\2\156\1\145\1\160\1\141\5\uffff\1\145\1\154\1\164"+
		"\1\156\1\171\3\uffff\1\57\1\uffff\1\71\1\145\1\uffff\1\146\2\165\1\160"+
		"\1\164\1\163\1\164\1\143\1\161\1\157\1\170\1\156\1\162\1\151\1\156\1\151"+
		"\1\157\1\164\1\uffff\2\uffff\1\141\1\142\1\155\1\157\1\66\1\163\1\151"+
		"\1\153\1\165\1\145\1\141\1\145\1\164\1\151\1\170\2\164\1\154\1\145\2\uffff"+
		"\1\165\1\154\1\172\1\162\1\62\1\64\1\141\1\157\1\141\1\151\1\141\1\164"+
		"\1\144\1\66\1\156\1\145\1\63\1\66\1\172\1\163\1\154\1\145\1\uffff\1\164"+
		"\2\172\1\147\1\156\1\147\1\162\1\164\1\172\1\66\1\62\1\64\1\147\1\144"+
		"\1\62\1\64\1\uffff\1\172\1\164\2\172\1\145\1\172\3\145\1\62\1\64\3\172"+
		"\1\66\3\172\1\uffff\1\172\1\154\1\uffff\1\172\2\144\2\172\1\62\1\64\2"+
		"\uffff\1\172\1\uffff\4\172\1\uffff";
	static final String DFA19_acceptS =
		"\1\uffff\1\1\6\uffff\1\10\1\11\1\12\1\13\1\14\5\uffff\1\17\1\20\1\21\1"+
		"\uffff\1\23\2\uffff\1\27\23\uffff\1\24\1\25\23\uffff\1\22\1\26\26\uffff"+
		"\1\3\20\uffff\1\16\22\uffff\1\4\2\uffff\1\6\7\uffff\1\2\1\5\1\uffff\1"+
		"\7\4\uffff\1\15";
	static final String DFA19_specialS =
		"\54\uffff\1\0\145\uffff}>";
	static final String[] DFA19_transitionS = {
			"\2\31\1\uffff\2\31\22\uffff\1\31\1\uffff\1\22\10\uffff\1\27\1\uffff\1"+
			"\27\1\24\1\25\12\30\1\uffff\1\10\1\uffff\1\1\2\uffff\1\26\32\23\1\11"+
			"\1\uffff\1\12\1\uffff\1\23\1\uffff\1\23\1\21\1\23\1\2\1\3\1\16\2\23\1"+
			"\4\3\23\1\5\1\23\1\6\1\7\1\23\1\15\1\17\1\23\1\20\5\23\1\13\1\uffff\1"+
			"\14",
			"",
			"\1\32\11\uffff\1\33",
			"\1\34",
			"\1\35\1\36",
			"\1\37",
			"\1\40",
			"\1\41",
			"",
			"",
			"",
			"",
			"",
			"\1\42",
			"\1\44\2\uffff\1\43",
			"\1\47\2\uffff\1\45\12\uffff\1\46",
			"\1\50\4\uffff\1\51",
			"\1\52\11\uffff\1\53",
			"",
			"",
			"",
			"\1\54",
			"",
			"\12\30",
			"\1\56\1\uffff\12\30\13\uffff\1\56\37\uffff\1\56",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\70\1\67",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\0\103",
			"",
			"",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110\2\uffff\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"",
			"",
			"\1\130",
			"\1\131",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145\2\uffff\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\154",
			"\1\155",
			"\1\156",
			"",
			"\1\157",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\165\2\uffff\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\175",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\177",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\1\u0080\31\23",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u0087\2\uffff\1\u0088",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u008b",
			"",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u008d",
			"\1\u008e",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u008f",
			"\1\u0090",
			"",
			"",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			""
	};

	static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
	static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
	static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
	static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
	static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
	static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
	static final short[][] DFA19_transition;

	static {
		int numStates = DFA19_transitionS.length;
		DFA19_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
		}
	}

	protected class DFA19 extends DFA {

		public DFA19(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 19;
			this.eot = DFA19_eot;
			this.eof = DFA19_eof;
			this.min = DFA19_min;
			this.max = DFA19_max;
			this.accept = DFA19_accept;
			this.special = DFA19_special;
			this.transition = DFA19_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ASSIGN | DEFAULT | ENUM | IMPORT | MESSAGE | OPTION | PACKAGE | T__27 | T__28 | T__29 | T__30 | T__31 | MODIFIER | TYPE | STRING | ID | DOT | COMMENT | AT | INTEGER | REAL | ANNOTATION | WHITESPACE );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA19_44 = input.LA(1);
						s = -1;
						if ( ((LA19_44 >= '\u0000' && LA19_44 <= '\uFFFF')) ) {s = 67;}
						else s = 66;
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 19, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
