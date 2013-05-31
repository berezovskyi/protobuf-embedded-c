// $ANTLR 3.5 /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g 2013-05-30 20:27:22

package edu.tum.cs.ccts.protobuf.embedded;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


/**
 * A grammar for an embedded systems specific subset of the Proto-language
 * of google's protocol buffers.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */
@SuppressWarnings("all")
public class ProtoParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ProtoParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ProtoParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ProtoParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g"; }


	public static class proto_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "proto"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:53:1: proto : ( packageDecl )? ( importDecl )* ( declaration )* -> ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* ) ;
	public final ProtoParser.proto_return proto() throws RecognitionException {
		ProtoParser.proto_return retval = new ProtoParser.proto_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope packageDecl1 =null;
		ParserRuleReturnScope importDecl2 =null;
		ParserRuleReturnScope declaration3 =null;

		RewriteRuleSubtreeStream stream_importDecl=new RewriteRuleSubtreeStream(adaptor,"rule importDecl");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
		RewriteRuleSubtreeStream stream_packageDecl=new RewriteRuleSubtreeStream(adaptor,"rule packageDecl");

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:2: ( ( packageDecl )? ( importDecl )* ( declaration )* -> ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:4: ( packageDecl )? ( importDecl )* ( declaration )*
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:4: ( packageDecl )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==PACKAGE) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:4: packageDecl
					{
					pushFollow(FOLLOW_packageDecl_in_proto129);
					packageDecl1=packageDecl();
					state._fsp--;

					stream_packageDecl.add(packageDecl1.getTree());
					}
					break;

			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:17: ( importDecl )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==IMPORT) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:17: importDecl
					{
					pushFollow(FOLLOW_importDecl_in_proto132);
					importDecl2=importDecl();
					state._fsp--;

					stream_importDecl.add(importDecl2.getTree());
					}
					break;

				default :
					break loop2;
				}
			}

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:29: ( declaration )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ANNOTATION||LA3_0==ENUM||LA3_0==MESSAGE||LA3_0==OPTION) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:54:29: declaration
					{
					pushFollow(FOLLOW_declaration_in_proto135);
					declaration3=declaration();
					state._fsp--;

					stream_declaration.add(declaration3.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			// AST REWRITE
			// elements: importDecl, packageDecl, declaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 55:7: -> ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* )
			{
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:55:10: ^( PROTO ( packageDecl )? ( importDecl )* ( declaration )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROTO, "PROTO"), root_1);
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:55:18: ( packageDecl )?
				if ( stream_packageDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_packageDecl.nextTree());
				}
				stream_packageDecl.reset();

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:55:31: ( importDecl )*
				while ( stream_importDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_importDecl.nextTree());
				}
				stream_importDecl.reset();

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:55:43: ( declaration )*
				while ( stream_declaration.hasNext() ) {
					adaptor.addChild(root_1, stream_declaration.nextTree());
				}
				stream_declaration.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "proto"


	public static class packageDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "packageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:58:1: packageDecl : PACKAGE ^ qualifiedID ';' !;
	public final ProtoParser.packageDecl_return packageDecl() throws RecognitionException {
		ProtoParser.packageDecl_return retval = new ProtoParser.packageDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PACKAGE4=null;
		Token char_literal6=null;
		ParserRuleReturnScope qualifiedID5 =null;

		CommonTree PACKAGE4_tree=null;
		CommonTree char_literal6_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:59:2: ( PACKAGE ^ qualifiedID ';' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:59:4: PACKAGE ^ qualifiedID ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			PACKAGE4=(Token)match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDecl186); 
			PACKAGE4_tree = (CommonTree)adaptor.create(PACKAGE4);
			root_0 = (CommonTree)adaptor.becomeRoot(PACKAGE4_tree, root_0);

			pushFollow(FOLLOW_qualifiedID_in_packageDecl189);
			qualifiedID5=qualifiedID();
			state._fsp--;

			adaptor.addChild(root_0, qualifiedID5.getTree());

			char_literal6=(Token)match(input,27,FOLLOW_27_in_packageDecl191); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "packageDecl"


	public static class importDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "importDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:62:1: importDecl : IMPORT ^ STRING ';' !;
	public final ProtoParser.importDecl_return importDecl() throws RecognitionException {
		ProtoParser.importDecl_return retval = new ProtoParser.importDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IMPORT7=null;
		Token STRING8=null;
		Token char_literal9=null;

		CommonTree IMPORT7_tree=null;
		CommonTree STRING8_tree=null;
		CommonTree char_literal9_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:63:2: ( IMPORT ^ STRING ';' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:63:4: IMPORT ^ STRING ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			IMPORT7=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_importDecl204); 
			IMPORT7_tree = (CommonTree)adaptor.create(IMPORT7);
			root_0 = (CommonTree)adaptor.becomeRoot(IMPORT7_tree, root_0);

			STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_importDecl207); 
			STRING8_tree = (CommonTree)adaptor.create(STRING8);
			adaptor.addChild(root_0, STRING8_tree);

			char_literal9=(Token)match(input,27,FOLLOW_27_in_importDecl209); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "importDecl"


	public static class declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:66:1: declaration : ( optionDecl | enumDecl | messageDecl | annotationDecl );
	public final ProtoParser.declaration_return declaration() throws RecognitionException {
		ProtoParser.declaration_return retval = new ProtoParser.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope optionDecl10 =null;
		ParserRuleReturnScope enumDecl11 =null;
		ParserRuleReturnScope messageDecl12 =null;
		ParserRuleReturnScope annotationDecl13 =null;


		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:67:2: ( optionDecl | enumDecl | messageDecl | annotationDecl )
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
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:67:4: optionDecl
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_optionDecl_in_declaration222);
					optionDecl10=optionDecl();
					state._fsp--;

					adaptor.addChild(root_0, optionDecl10.getTree());

					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:68:4: enumDecl
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_enumDecl_in_declaration227);
					enumDecl11=enumDecl();
					state._fsp--;

					adaptor.addChild(root_0, enumDecl11.getTree());

					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:69:4: messageDecl
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_messageDecl_in_declaration232);
					messageDecl12=messageDecl();
					state._fsp--;

					adaptor.addChild(root_0, messageDecl12.getTree());

					}
					break;
				case 4 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:70:4: annotationDecl
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_annotationDecl_in_declaration237);
					annotationDecl13=annotationDecl();
					state._fsp--;

					adaptor.addChild(root_0, annotationDecl13.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class optionDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optionDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:73:1: optionDecl : OPTION ^ ID ASSIGN ! STRING ';' !;
	public final ProtoParser.optionDecl_return optionDecl() throws RecognitionException {
		ProtoParser.optionDecl_return retval = new ProtoParser.optionDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OPTION14=null;
		Token ID15=null;
		Token ASSIGN16=null;
		Token STRING17=null;
		Token char_literal18=null;

		CommonTree OPTION14_tree=null;
		CommonTree ID15_tree=null;
		CommonTree ASSIGN16_tree=null;
		CommonTree STRING17_tree=null;
		CommonTree char_literal18_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:74:2: ( OPTION ^ ID ASSIGN ! STRING ';' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:74:4: OPTION ^ ID ASSIGN ! STRING ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			OPTION14=(Token)match(input,OPTION,FOLLOW_OPTION_in_optionDecl249); 
			OPTION14_tree = (CommonTree)adaptor.create(OPTION14);
			root_0 = (CommonTree)adaptor.becomeRoot(OPTION14_tree, root_0);

			ID15=(Token)match(input,ID,FOLLOW_ID_in_optionDecl252); 
			ID15_tree = (CommonTree)adaptor.create(ID15);
			adaptor.addChild(root_0, ID15_tree);

			ASSIGN16=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_optionDecl254); 
			STRING17=(Token)match(input,STRING,FOLLOW_STRING_in_optionDecl257); 
			STRING17_tree = (CommonTree)adaptor.create(STRING17);
			adaptor.addChild(root_0, STRING17_tree);

			char_literal18=(Token)match(input,27,FOLLOW_27_in_optionDecl259); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optionDecl"


	public static class enumDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "enumDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:77:1: enumDecl : ENUM ^ ID '{' ! ( enumElement )* '}' !;
	public final ProtoParser.enumDecl_return enumDecl() throws RecognitionException {
		ProtoParser.enumDecl_return retval = new ProtoParser.enumDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ENUM19=null;
		Token ID20=null;
		Token char_literal21=null;
		Token char_literal23=null;
		ParserRuleReturnScope enumElement22 =null;

		CommonTree ENUM19_tree=null;
		CommonTree ID20_tree=null;
		CommonTree char_literal21_tree=null;
		CommonTree char_literal23_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:78:2: ( ENUM ^ ID '{' ! ( enumElement )* '}' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:78:4: ENUM ^ ID '{' ! ( enumElement )* '}' !
			{
			root_0 = (CommonTree)adaptor.nil();


			ENUM19=(Token)match(input,ENUM,FOLLOW_ENUM_in_enumDecl271); 
			ENUM19_tree = (CommonTree)adaptor.create(ENUM19);
			root_0 = (CommonTree)adaptor.becomeRoot(ENUM19_tree, root_0);

			ID20=(Token)match(input,ID,FOLLOW_ID_in_enumDecl274); 
			ID20_tree = (CommonTree)adaptor.create(ID20);
			adaptor.addChild(root_0, ID20_tree);

			char_literal21=(Token)match(input,30,FOLLOW_30_in_enumDecl276); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:78:19: ( enumElement )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ID) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:78:19: enumElement
					{
					pushFollow(FOLLOW_enumElement_in_enumDecl280);
					enumElement22=enumElement();
					state._fsp--;

					adaptor.addChild(root_0, enumElement22.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			char_literal23=(Token)match(input,31,FOLLOW_31_in_enumDecl283); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enumDecl"


	public static class enumElement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "enumElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:81:1: enumElement : ID ASSIGN ^ INTEGER ';' !;
	public final ProtoParser.enumElement_return enumElement() throws RecognitionException {
		ProtoParser.enumElement_return retval = new ProtoParser.enumElement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID24=null;
		Token ASSIGN25=null;
		Token INTEGER26=null;
		Token char_literal27=null;

		CommonTree ID24_tree=null;
		CommonTree ASSIGN25_tree=null;
		CommonTree INTEGER26_tree=null;
		CommonTree char_literal27_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:82:2: ( ID ASSIGN ^ INTEGER ';' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:82:4: ID ASSIGN ^ INTEGER ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			ID24=(Token)match(input,ID,FOLLOW_ID_in_enumElement295); 
			ID24_tree = (CommonTree)adaptor.create(ID24);
			adaptor.addChild(root_0, ID24_tree);

			ASSIGN25=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enumElement297); 
			ASSIGN25_tree = (CommonTree)adaptor.create(ASSIGN25);
			root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN25_tree, root_0);

			INTEGER26=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_enumElement300); 
			INTEGER26_tree = (CommonTree)adaptor.create(INTEGER26);
			adaptor.addChild(root_0, INTEGER26_tree);

			char_literal27=(Token)match(input,27,FOLLOW_27_in_enumElement302); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enumElement"


	public static class messageDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "messageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:85:1: messageDecl : MESSAGE ^ ID '{' ! ( messageElement )* '}' !;
	public final ProtoParser.messageDecl_return messageDecl() throws RecognitionException {
		ProtoParser.messageDecl_return retval = new ProtoParser.messageDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MESSAGE28=null;
		Token ID29=null;
		Token char_literal30=null;
		Token char_literal32=null;
		ParserRuleReturnScope messageElement31 =null;

		CommonTree MESSAGE28_tree=null;
		CommonTree ID29_tree=null;
		CommonTree char_literal30_tree=null;
		CommonTree char_literal32_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:86:2: ( MESSAGE ^ ID '{' ! ( messageElement )* '}' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:86:4: MESSAGE ^ ID '{' ! ( messageElement )* '}' !
			{
			root_0 = (CommonTree)adaptor.nil();


			MESSAGE28=(Token)match(input,MESSAGE,FOLLOW_MESSAGE_in_messageDecl314); 
			MESSAGE28_tree = (CommonTree)adaptor.create(MESSAGE28);
			root_0 = (CommonTree)adaptor.becomeRoot(MESSAGE28_tree, root_0);

			ID29=(Token)match(input,ID,FOLLOW_ID_in_messageDecl317); 
			ID29_tree = (CommonTree)adaptor.create(ID29);
			adaptor.addChild(root_0, ID29_tree);

			char_literal30=(Token)match(input,30,FOLLOW_30_in_messageDecl319); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:86:21: ( messageElement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==MODIFIER) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:86:21: messageElement
					{
					pushFollow(FOLLOW_messageElement_in_messageDecl322);
					messageElement31=messageElement();
					state._fsp--;

					adaptor.addChild(root_0, messageElement31.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			char_literal32=(Token)match(input,31,FOLLOW_31_in_messageDecl325); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "messageDecl"


	public static class annotationDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "annotationDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:89:1: annotationDecl : ANNOTATION ^ ID ASSIGN ! INTEGER ;
	public final ProtoParser.annotationDecl_return annotationDecl() throws RecognitionException {
		ProtoParser.annotationDecl_return retval = new ProtoParser.annotationDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ANNOTATION33=null;
		Token ID34=null;
		Token ASSIGN35=null;
		Token INTEGER36=null;

		CommonTree ANNOTATION33_tree=null;
		CommonTree ID34_tree=null;
		CommonTree ASSIGN35_tree=null;
		CommonTree INTEGER36_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:90:2: ( ANNOTATION ^ ID ASSIGN ! INTEGER )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:90:4: ANNOTATION ^ ID ASSIGN ! INTEGER
			{
			root_0 = (CommonTree)adaptor.nil();


			ANNOTATION33=(Token)match(input,ANNOTATION,FOLLOW_ANNOTATION_in_annotationDecl338); 
			ANNOTATION33_tree = (CommonTree)adaptor.create(ANNOTATION33);
			root_0 = (CommonTree)adaptor.becomeRoot(ANNOTATION33_tree, root_0);

			ID34=(Token)match(input,ID,FOLLOW_ID_in_annotationDecl341); 
			ID34_tree = (CommonTree)adaptor.create(ID34);
			adaptor.addChild(root_0, ID34_tree);

			ASSIGN35=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_annotationDecl343); 
			INTEGER36=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_annotationDecl346); 
			INTEGER36_tree = (CommonTree)adaptor.create(INTEGER36);
			adaptor.addChild(root_0, INTEGER36_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotationDecl"


	public static class messageElement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "messageElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:93:1: messageElement : MODIFIER ( TYPE | ID ) ID ASSIGN ^ INTEGER ( '[' ! DEFAULT ! ASSIGN ! ( INTEGER | REAL | STRING | ID ) ']' !)? ';' !;
	public final ProtoParser.messageElement_return messageElement() throws RecognitionException {
		ProtoParser.messageElement_return retval = new ProtoParser.messageElement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MODIFIER37=null;
		Token set38=null;
		Token ID39=null;
		Token ASSIGN40=null;
		Token INTEGER41=null;
		Token char_literal42=null;
		Token DEFAULT43=null;
		Token ASSIGN44=null;
		Token set45=null;
		Token char_literal46=null;
		Token char_literal47=null;

		CommonTree MODIFIER37_tree=null;
		CommonTree set38_tree=null;
		CommonTree ID39_tree=null;
		CommonTree ASSIGN40_tree=null;
		CommonTree INTEGER41_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree DEFAULT43_tree=null;
		CommonTree ASSIGN44_tree=null;
		CommonTree set45_tree=null;
		CommonTree char_literal46_tree=null;
		CommonTree char_literal47_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:94:2: ( MODIFIER ( TYPE | ID ) ID ASSIGN ^ INTEGER ( '[' ! DEFAULT ! ASSIGN ! ( INTEGER | REAL | STRING | ID ) ']' !)? ';' !)
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:94:4: MODIFIER ( TYPE | ID ) ID ASSIGN ^ INTEGER ( '[' ! DEFAULT ! ASSIGN ! ( INTEGER | REAL | STRING | ID ) ']' !)? ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			MODIFIER37=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_messageElement357); 
			MODIFIER37_tree = (CommonTree)adaptor.create(MODIFIER37);
			adaptor.addChild(root_0, MODIFIER37_tree);

			set38=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==TYPE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set38));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			ID39=(Token)match(input,ID,FOLLOW_ID_in_messageElement367); 
			ID39_tree = (CommonTree)adaptor.create(ID39);
			adaptor.addChild(root_0, ID39_tree);

			ASSIGN40=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_messageElement369); 
			ASSIGN40_tree = (CommonTree)adaptor.create(ASSIGN40);
			root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN40_tree, root_0);

			INTEGER41=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_messageElement372); 
			INTEGER41_tree = (CommonTree)adaptor.create(INTEGER41);
			adaptor.addChild(root_0, INTEGER41_tree);

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:94:44: ( '[' ! DEFAULT ! ASSIGN ! ( INTEGER | REAL | STRING | ID ) ']' !)?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==28) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:94:45: '[' ! DEFAULT ! ASSIGN ! ( INTEGER | REAL | STRING | ID ) ']' !
					{
					char_literal42=(Token)match(input,28,FOLLOW_28_in_messageElement375); 
					DEFAULT43=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_messageElement378); 
					ASSIGN44=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_messageElement381); 
					set45=input.LT(1);
					if ( input.LA(1)==ID||input.LA(1)==INTEGER||input.LA(1)==REAL||input.LA(1)==STRING ) {
						input.consume();
						adaptor.addChild(root_0, (CommonTree)adaptor.create(set45));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					char_literal46=(Token)match(input,29,FOLLOW_29_in_messageElement400); 
					}
					break;

			}

			char_literal47=(Token)match(input,27,FOLLOW_27_in_messageElement405); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "messageElement"


	public static class qualifiedID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qualifiedID"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:97:1: qualifiedID : ID ( '.' ! ID )* ;
	public final ProtoParser.qualifiedID_return qualifiedID() throws RecognitionException {
		ProtoParser.qualifiedID_return retval = new ProtoParser.qualifiedID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID48=null;
		Token char_literal49=null;
		Token ID50=null;

		CommonTree ID48_tree=null;
		CommonTree char_literal49_tree=null;
		CommonTree ID50_tree=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:98:2: ( ID ( '.' ! ID )* )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:98:4: ID ( '.' ! ID )*
			{
			root_0 = (CommonTree)adaptor.nil();


			ID48=(Token)match(input,ID,FOLLOW_ID_in_qualifiedID417); 
			ID48_tree = (CommonTree)adaptor.create(ID48);
			adaptor.addChild(root_0, ID48_tree);

			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:98:7: ( '.' ! ID )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DOT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/Proto.g:98:8: '.' ! ID
					{
					char_literal49=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedID420); 
					ID50=(Token)match(input,ID,FOLLOW_ID_in_qualifiedID423); 
					ID50_tree = (CommonTree)adaptor.create(ID50);
					adaptor.addChild(root_0, ID50_tree);

					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "qualifiedID"

	// Delegated rules



	public static final BitSet FOLLOW_packageDecl_in_proto129 = new BitSet(new long[]{0x00000000000A4812L});
	public static final BitSet FOLLOW_importDecl_in_proto132 = new BitSet(new long[]{0x00000000000A4812L});
	public static final BitSet FOLLOW_declaration_in_proto135 = new BitSet(new long[]{0x00000000000A0812L});
	public static final BitSet FOLLOW_PACKAGE_in_packageDecl186 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_qualifiedID_in_packageDecl189 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_packageDecl191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_importDecl204 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_in_importDecl207 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_importDecl209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_optionDecl_in_declaration222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enumDecl_in_declaration227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_messageDecl_in_declaration232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotationDecl_in_declaration237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_optionDecl249 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_optionDecl252 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_optionDecl254 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_in_optionDecl257 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_optionDecl259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENUM_in_enumDecl271 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_enumDecl274 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_enumDecl276 = new BitSet(new long[]{0x0000000080002000L});
	public static final BitSet FOLLOW_enumElement_in_enumDecl280 = new BitSet(new long[]{0x0000000080002000L});
	public static final BitSet FOLLOW_31_in_enumDecl283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_enumElement295 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_enumElement297 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_enumElement300 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_enumElement302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MESSAGE_in_messageDecl314 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageDecl317 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_messageDecl319 = new BitSet(new long[]{0x0000000080040000L});
	public static final BitSet FOLLOW_messageElement_in_messageDecl322 = new BitSet(new long[]{0x0000000080040000L});
	public static final BitSet FOLLOW_31_in_messageDecl325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANNOTATION_in_annotationDecl338 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_annotationDecl341 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_annotationDecl343 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_annotationDecl346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODIFIER_in_messageElement357 = new BitSet(new long[]{0x0000000002002000L});
	public static final BitSet FOLLOW_set_in_messageElement359 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageElement367 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_messageElement369 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_messageElement372 = new BitSet(new long[]{0x0000000018000000L});
	public static final BitSet FOLLOW_28_in_messageElement375 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DEFAULT_in_messageElement378 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_messageElement381 = new BitSet(new long[]{0x000000000140A000L});
	public static final BitSet FOLLOW_set_in_messageElement384 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_messageElement400 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_messageElement405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_qualifiedID417 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_DOT_in_qualifiedID420 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_qualifiedID423 = new BitSet(new long[]{0x0000000000000402L});
}
