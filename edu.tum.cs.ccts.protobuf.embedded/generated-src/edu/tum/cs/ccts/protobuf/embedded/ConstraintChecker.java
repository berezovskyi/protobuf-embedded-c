// $ANTLR 3.5 /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g 2013-05-30 20:27:24

package edu.tum.cs.ccts.protobuf.embedded;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * A tree grammar that walks an Proto-language AST and checks syntactic and
 * semantic constraints.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */
@SuppressWarnings("all")
public class ConstraintChecker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANNOTATION", "ASSIGN", "AT", 
		"COMMENT", "DEFAULT", "DIGIT", "DOT", "ENUM", "EXPONENT", "ID", "IMPORT", 
		"INTEGER", "LETTER", "MESSAGE", "MODIFIER", "OPTION", "PACKAGE", "PROTO", 
		"REAL", "SIGN", "STRING", "TYPE", "WHITESPACE", "';'", "'['", "']'", "'{'", 
		"'}'"
	};
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public ConstraintChecker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ConstraintChecker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ConstraintChecker.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g"; }


	private HashSet<String> nameScope = new HashSet<String>();
	private HashSet<Integer> valueScope = new HashSet<Integer>();
	String[] types = { "int32", "int64", "sint32", "sint64", "uint32", "uint64", "bool", "bytes", 
	                    "string", "float", "double", "fixed32", "fixed64", "sfixed32", "sfixed64" };
	private final HashSet<String> dataTypes = new HashSet<String>(Arrays.asList(types));
	private HashSet<String> globalNameScope = new HashSet<String>();
	public int constraintErrors = 0;
	protected void constraintError(int line, String msg) { 
	  System.err.println("Error in line " + line + ": " + msg);
	  constraintErrors++;
	}
	private HashSet<String> annotations = new HashSet<String>();
	public HashMap<String, Integer> topologicalOrder = new HashMap<String, Integer>();




	// $ANTLR start "proto"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:58:1: proto : ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* ) ;
	public final void proto() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:2: ( ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:4: ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* )
			{
			match(input,PROTO,FOLLOW_PROTO_in_proto50); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:12: ( packageDecl )?
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==PACKAGE) ) {
					alt1=1;
				}
				switch (alt1) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:12: packageDecl
						{
						pushFollow(FOLLOW_packageDecl_in_proto52);
						packageDecl();
						state._fsp--;

						}
						break;

				}

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:25: ( importDecl )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==IMPORT) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:25: importDecl
						{
						pushFollow(FOLLOW_importDecl_in_proto55);
						importDecl();
						state._fsp--;

						}
						break;

					default :
						break loop2;
					}
				}

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:37: ( declaration )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ANNOTATION||LA3_0==ENUM||LA3_0==MESSAGE||LA3_0==OPTION) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:59:37: declaration
						{
						pushFollow(FOLLOW_declaration_in_proto58);
						declaration();
						state._fsp--;

						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "proto"



	// $ANTLR start "packageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:62:1: packageDecl : ^( PACKAGE qualifiedID ) ;
	public final void packageDecl() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:63:2: ( ^( PACKAGE qualifiedID ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:63:4: ^( PACKAGE qualifiedID )
			{
			match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDecl88); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_qualifiedID_in_packageDecl90);
			qualifiedID();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "packageDecl"



	// $ANTLR start "importDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:66:1: importDecl : ^( IMPORT STRING ) ;
	public final void importDecl() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:67:2: ( ^( IMPORT STRING ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:67:4: ^( IMPORT STRING )
			{
			match(input,IMPORT,FOLLOW_IMPORT_in_importDecl104); 
			match(input, Token.DOWN, null); 
			match(input,STRING,FOLLOW_STRING_in_importDecl106); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "importDecl"



	// $ANTLR start "declaration"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:70:1: declaration : ( optionDecl | enumDecl | messageDecl | annotationDecl );
	public final void declaration() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:71:2: ( optionDecl | enumDecl | messageDecl | annotationDecl )
			int alt4=4;
			switch ( input.LA(1) ) {
			case OPTION:
				{
				alt4=1;
				}
				break;
			case ENUM:
				{
				alt4=2;
				}
				break;
			case MESSAGE:
				{
				alt4=3;
				}
				break;
			case ANNOTATION:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:71:4: optionDecl
					{
					pushFollow(FOLLOW_optionDecl_in_declaration120);
					optionDecl();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:72:4: enumDecl
					{
					pushFollow(FOLLOW_enumDecl_in_declaration126);
					enumDecl();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:73:4: messageDecl
					{
					pushFollow(FOLLOW_messageDecl_in_declaration131);
					messageDecl();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:74:4: annotationDecl
					{
					pushFollow(FOLLOW_annotationDecl_in_declaration136);
					annotationDecl();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "optionDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:77:1: optionDecl : ^( OPTION ID STRING ) ;
	public final void optionDecl() throws RecognitionException {
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:78:3: ( ^( OPTION ID STRING ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:78:5: ^( OPTION ID STRING )
			{
			match(input,OPTION,FOLLOW_OPTION_in_optionDecl150); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_optionDecl152); 
			match(input,STRING,FOLLOW_STRING_in_optionDecl154); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "optionDecl"



	// $ANTLR start "enumDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:81:1: enumDecl : ^( ENUM ID ( enumElement )* ) ;
	public final void enumDecl() throws RecognitionException {
		CommonTree ID1=null;

		 nameScope.clear(); valueScope.clear(); 
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:83:2: ( ^( ENUM ID ( enumElement )* ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:83:4: ^( ENUM ID ( enumElement )* )
			{
			match(input,ENUM,FOLLOW_ENUM_in_enumDecl177); 
			match(input, Token.DOWN, null); 
			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_enumDecl179); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:83:14: ( enumElement )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ASSIGN) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:83:14: enumElement
					{
					pushFollow(FOLLOW_enumElement_in_enumDecl181);
					enumElement();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			match(input, Token.UP, null); 


				    dataTypes.add((ID1!=null?ID1.getText():null));
				    if (globalNameScope.contains((ID1!=null?ID1.getText():null)))
					    constraintError((ID1!=null?ID1.getLine():0), "duplicate enum name " + (ID1!=null?ID1.getText():null));
				    globalNameScope.add((ID1!=null?ID1.getText():null));
				  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "enumDecl"



	// $ANTLR start "enumElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:92:1: enumElement : ^( ASSIGN ID INTEGER ) ;
	public final void enumElement() throws RecognitionException {
		CommonTree INTEGER2=null;
		CommonTree ID3=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:93:2: ( ^( ASSIGN ID INTEGER ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:93:4: ^( ASSIGN ID INTEGER )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_enumElement200); 
			match(input, Token.DOWN, null); 
			ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_enumElement202); 
			INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_enumElement204); 
			match(input, Token.UP, null); 


					  int index = Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null));
					  if (index < 0 || index > 127)
					    constraintError((INTEGER2!=null?INTEGER2.getLine():0), "enum element " + index + " out of valid range [0..127]");
					  if (nameScope.contains((ID3!=null?ID3.getText():null)))
					    constraintError((ID3!=null?ID3.getLine():0), "duplicate element name " + (ID3!=null?ID3.getText():null));
					  nameScope.add((ID3!=null?ID3.getText():null));
					  if (valueScope.contains(index))
					    constraintError((INTEGER2!=null?INTEGER2.getLine():0), "duplicate element value " + index);
					  valueScope.add(index);
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "enumElement"


	protected static class messageDecl_scope {
		String name;
	}
	protected Stack<messageDecl_scope> messageDecl_stack = new Stack<messageDecl_scope>();


	// $ANTLR start "messageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:107:1: messageDecl : ^( MESSAGE ID ( messageElement )* ) ;
	public final void messageDecl() throws RecognitionException {
		messageDecl_stack.push(new messageDecl_scope());
		CommonTree ID4=null;

		 nameScope.clear(); valueScope.clear();
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:112:2: ( ^( MESSAGE ID ( messageElement )* ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:112:4: ^( MESSAGE ID ( messageElement )* )
			{
			match(input,MESSAGE,FOLLOW_MESSAGE_in_messageDecl234); 
			match(input, Token.DOWN, null); 
			ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_messageDecl236); 
			messageDecl_stack.peek().name =(ID4!=null?ID4.getText():null);
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:112:48: ( messageElement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==ASSIGN) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:112:48: messageElement
					{
					pushFollow(FOLLOW_messageElement_in_messageDecl240);
					messageElement();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			match(input, Token.UP, null); 


					  if (globalNameScope.contains((ID4!=null?ID4.getText():null)))
			        constraintError((ID4!=null?ID4.getLine():0), "duplicate message name " + (ID4!=null?ID4.getText():null));
			      globalNameScope.add((ID4!=null?ID4.getText():null));
			      if (!topologicalOrder.containsKey((ID4!=null?ID4.getText():null)))
			        topologicalOrder.put((ID4!=null?ID4.getText():null), 0);
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			messageDecl_stack.pop();
		}
	}
	// $ANTLR end "messageDecl"



	// $ANTLR start "annotationDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:122:1: annotationDecl : ^( ANNOTATION ID INTEGER ) ;
	public final void annotationDecl() throws RecognitionException {
		CommonTree ID5=null;
		CommonTree INTEGER6=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:123:2: ( ^( ANNOTATION ID INTEGER ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:123:4: ^( ANNOTATION ID INTEGER )
			{
			match(input,ANNOTATION,FOLLOW_ANNOTATION_in_annotationDecl258); 
			match(input, Token.DOWN, null); 
			ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_annotationDecl260); 
			INTEGER6=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_annotationDecl262); 
			match(input, Token.UP, null); 


						if (!globalNameScope.isEmpty())
							constraintError((ID5!=null?ID5.getLine():0), "cannot use annotations after message/enum declarations");
						String name = (ID5!=null?ID5.getText():null);
						if (!name.equals("max_repeated_length") && !name.equals("max_string_length") && !name.equals("max_bytes_length"))
							constraintError((ID5!=null?ID5.getLine():0), "unknown annotation " + name);
						if (annotations.contains(name))
							constraintError((ID5!=null?ID5.getLine():0), "duplicate annotation " + name);
						/* 
						 * 2^7 * 2^7 == 2^14 for "repated string".
						 * That's OK for size (maximum 2 byte varint), which has 14bit payload.
						 */
						int v = Integer.parseInt((INTEGER6!=null?INTEGER6.getText():null));
						if (v < 2 || v > 127)
							constraintError((ID5!=null?ID5.getLine():0), name + " must be within [2..127], but was " + v);
						annotations.add(name);
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "annotationDecl"



	// $ANTLR start "messageElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:143:1: messageElement : ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID tagVal= INTEGER (defaultVal= ( INTEGER | REAL | STRING | ID ) )? ) ;
	public final void messageElement() throws RecognitionException {
		CommonTree t=null;
		CommonTree n=null;
		CommonTree tagVal=null;
		CommonTree defaultVal=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:2: ( ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID tagVal= INTEGER (defaultVal= ( INTEGER | REAL | STRING | ID ) )? ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:4: ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID tagVal= INTEGER (defaultVal= ( INTEGER | REAL | STRING | ID ) )? )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_messageElement279); 
			match(input, Token.DOWN, null); 
			match(input,MODIFIER,FOLLOW_MODIFIER_in_messageElement281); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:22: (t= TYPE |t= ID )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==TYPE) ) {
				alt7=1;
			}
			else if ( (LA7_0==ID) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:23: t= TYPE
					{
					t=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_messageElement286); 
					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:32: t= ID
					{
					t=(CommonTree)match(input,ID,FOLLOW_ID_in_messageElement292); 
					}
					break;

			}

			n=(CommonTree)match(input,ID,FOLLOW_ID_in_messageElement297); 
			tagVal=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_messageElement301); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:58: (defaultVal= ( INTEGER | REAL | STRING | ID ) )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID||LA8_0==INTEGER||LA8_0==REAL||LA8_0==STRING) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:144:59: defaultVal= ( INTEGER | REAL | STRING | ID )
					{
					defaultVal=(CommonTree)input.LT(1);
					if ( input.LA(1)==ID||input.LA(1)==INTEGER||input.LA(1)==REAL||input.LA(1)==STRING ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			match(input, Token.UP, null); 


				     int tag = Integer.parseInt((tagVal!=null?tagVal.getText():null));
				     if (tag <= 0 || tag > 4095)
				       constraintError((tagVal!=null?tagVal.getLine():0), "tag: " + tag + " out of valid range [1..4095]");
				     if (nameScope.contains((n!=null?n.getText():null)))
			         constraintError((n!=null?n.getLine():0), "duplicate element name " + (n!=null?n.getText():null));
				     nameScope.add((n!=null?n.getText():null));
				     if (valueScope.contains(tag))
			         constraintError((tagVal!=null?tagVal.getLine():0), "duplicate tag value " + tag);
			       valueScope.add(tag);
			       //if (!dataTypes.contains((t!=null?t.getText():null)) && globalNameScope.contains((t!=null?t.getText():null)))
			         //constraintError((t!=null?t.getLine():0), "unsupported data type: " + (t!=null?t.getText():null) + "\nData types must be natives, enums or embedded messages");
			       if (!dataTypes.contains((t!=null?t.getText():null))) {
			         Integer elementOrder = topologicalOrder.get((t!=null?t.getText():null));
			         if (elementOrder == null)
			           elementOrder = 0;
			         Integer messageOrder = topologicalOrder.get(messageDecl_stack.peek().name);
			         if (messageOrder == null)
			           messageOrder = 0;
			         elementOrder = Math.max(elementOrder, messageOrder + 1);
			         topologicalOrder.put((t!=null?t.getText():null), elementOrder);
			       }
				   
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "messageElement"



	// $ANTLR start "qualifiedID"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:170:1: qualifiedID : (i+= ID )+ ;
	public final void qualifiedID() throws RecognitionException {
		CommonTree i=null;
		List<Object> list_i=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:171:2: ( (i+= ID )+ )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:171:4: (i+= ID )+
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:171:4: (i+= ID )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ID) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/ConstraintChecker.g:171:5: i+= ID
					{
					i=(CommonTree)match(input,ID,FOLLOW_ID_in_qualifiedID343); 
					if (list_i==null) list_i=new ArrayList<Object>();
					list_i.add(i);
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "qualifiedID"

	// Delegated rules



	public static final BitSet FOLLOW_PROTO_in_proto50 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_packageDecl_in_proto52 = new BitSet(new long[]{0x00000000000A4818L});
	public static final BitSet FOLLOW_importDecl_in_proto55 = new BitSet(new long[]{0x00000000000A4818L});
	public static final BitSet FOLLOW_declaration_in_proto58 = new BitSet(new long[]{0x00000000000A0818L});
	public static final BitSet FOLLOW_PACKAGE_in_packageDecl88 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_qualifiedID_in_packageDecl90 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IMPORT_in_importDecl104 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STRING_in_importDecl106 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_optionDecl_in_declaration120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enumDecl_in_declaration126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_messageDecl_in_declaration131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotationDecl_in_declaration136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_optionDecl150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_optionDecl152 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_in_optionDecl154 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ENUM_in_enumDecl177 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_enumDecl179 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_enumElement_in_enumDecl181 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_ASSIGN_in_enumElement200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_enumElement202 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_enumElement204 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MESSAGE_in_messageDecl234 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_messageDecl236 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_messageElement_in_messageDecl240 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_ANNOTATION_in_annotationDecl258 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_annotationDecl260 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_annotationDecl262 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_messageElement279 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_MODIFIER_in_messageElement281 = new BitSet(new long[]{0x0000000002002000L});
	public static final BitSet FOLLOW_TYPE_in_messageElement286 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageElement292 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageElement297 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_messageElement301 = new BitSet(new long[]{0x000000000140A008L});
	public static final BitSet FOLLOW_set_in_messageElement306 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_qualifiedID343 = new BitSet(new long[]{0x0000000000002002L});
}
