// $ANTLR 3.5 /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g 2013-05-30 20:27:18

package edu.tum.cs.ccts.protobuf.embedded;

import java.util.Collections;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
/**
 * A tree grammar that walks an Proto-language AST and generates output by
 * a string template.
 *
 * @author wolfgang.schwitzer
 * @author nvpopa
 */
@SuppressWarnings("all")
public class EmbeddedCGen extends TreeParser {
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


	public EmbeddedCGen(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public EmbeddedCGen(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("EmbeddedCGenTemplates", AngleBracketTemplateLexer.class);

	public void setTemplateLib(StringTemplateGroup templateLib) {
	  this.templateLib = templateLib;
	}
	public StringTemplateGroup getTemplateLib() {
	  return templateLib;
	}
	/** allows convenient multi-value initialization:
	 *  "new STAttrMap().put(...).put(...)"
	 */
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return EmbeddedCGen.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g"; }


	String filename;
	HashMap<String, String> typeMap = new HashMap<String, String>();
	HashMap<String, Integer> annotationMap = new HashMap<String, Integer>();
	HashMap<String, Integer> topologicalOrder;
	int messageSize;
	int elementCount;
	int bigValues;


	public static class proto_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "proto"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:50:1: proto[String filename, HashMap<String, Integer> topologicalOrder] : ^( PROTO (p+= packageDecl )? (i+= importDecl )* (d+= declaration )* ) -> proto(packageDecl=$pimportDecls=$ideclarations=$dfilename=$filename);
	public final EmbeddedCGen.proto_return proto(String filename, HashMap<String, Integer> topologicalOrder) throws RecognitionException {
		EmbeddedCGen.proto_return retval = new EmbeddedCGen.proto_return();
		retval.start = input.LT(1);

		List<Object> list_p=null;
		List<Object> list_i=null;
		List<Object> list_d=null;
		RuleReturnScope p = null;
		RuleReturnScope i = null;
		RuleReturnScope d = null;
		 this.filename = filename; this.topologicalOrder = topologicalOrder;
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:2: ( ^( PROTO (p+= packageDecl )? (i+= importDecl )* (d+= declaration )* ) -> proto(packageDecl=$pimportDecls=$ideclarations=$dfilename=$filename))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:4: ^( PROTO (p+= packageDecl )? (i+= importDecl )* (d+= declaration )* )
			{
			match(input,PROTO,FOLLOW_PROTO_in_proto69); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:13: (p+= packageDecl )?
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==PACKAGE) ) {
					alt1=1;
				}
				switch (alt1) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:13: p+= packageDecl
						{
						pushFollow(FOLLOW_packageDecl_in_proto73);
						p=packageDecl();
						state._fsp--;

						if (list_p==null) list_p=new ArrayList<Object>();
						list_p.add(p.getTemplate());
						}
						break;

				}

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:28: (i+= importDecl )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==IMPORT) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:29: i+= importDecl
						{
						pushFollow(FOLLOW_importDecl_in_proto79);
						i=importDecl();
						state._fsp--;

						if (list_i==null) list_i=new ArrayList<Object>();
						list_i.add(i.getTemplate());
						}
						break;

					default :
						break loop2;
					}
				}

				// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:45: (d+= declaration )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ANNOTATION||LA3_0==ENUM||LA3_0==MESSAGE||LA3_0==OPTION) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:63:46: d+= declaration
						{
						pushFollow(FOLLOW_declaration_in_proto86);
						d=declaration();
						state._fsp--;

						if (list_d==null) list_d=new ArrayList<Object>();
						list_d.add(d.getTemplate());
						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			 
						Collections.sort(list_d, new TemplateOrderComparator(topologicalOrder, false));
			      
			// TEMPLATE REWRITE
			// 67:4: -> proto(packageDecl=$pimportDecls=$ideclarations=$dfilename=$filename)
			{
				retval.st = templateLib.getInstanceOf("proto",new STAttrMap().put("packageDecl", list_p).put("importDecls", list_i).put("declarations", list_d).put("filename", filename));
			}



			}


					Integer repeatedLength = annotationMap.get("max_repeated_length");
					if (repeatedLength == null) repeatedLength = 32;
					Integer stringLength = annotationMap.get("max_string_length");
					if (stringLength == null) stringLength = 32;
					Integer bytesLength = annotationMap.get("max_bytes_length");
					if (bytesLength == null) bytesLength = 32;
					retval.st.setAttribute("max_repeated_length", repeatedLength);
					retval.st.setAttribute("max_string_length", stringLength);
					retval.st.setAttribute("max_bytes_length", bytesLength);
				
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "proto"


	public static class packageDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "packageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:70:1: packageDecl : ^( PACKAGE qualifiedID ) -> packageDecl(qualifiedID=$qualifiedID.st);
	public final EmbeddedCGen.packageDecl_return packageDecl() throws RecognitionException {
		EmbeddedCGen.packageDecl_return retval = new EmbeddedCGen.packageDecl_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope qualifiedID1 =null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:71:2: ( ^( PACKAGE qualifiedID ) -> packageDecl(qualifiedID=$qualifiedID.st))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:71:4: ^( PACKAGE qualifiedID )
			{
			match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDecl150); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_qualifiedID_in_packageDecl152);
			qualifiedID1=qualifiedID();
			state._fsp--;

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 72:4: -> packageDecl(qualifiedID=$qualifiedID.st)
			{
				retval.st = templateLib.getInstanceOf("packageDecl",new STAttrMap().put("qualifiedID", (qualifiedID1!=null?((StringTemplate)qualifiedID1.getTemplate()):null)));
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
		return retval;
	}
	// $ANTLR end "packageDecl"


	public static class importDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "importDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:75:1: importDecl : ^( IMPORT STRING ) -> importDecl(name=$STRING.text);
	public final EmbeddedCGen.importDecl_return importDecl() throws RecognitionException {
		EmbeddedCGen.importDecl_return retval = new EmbeddedCGen.importDecl_return();
		retval.start = input.LT(1);

		CommonTree STRING2=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:76:2: ( ^( IMPORT STRING ) -> importDecl(name=$STRING.text))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:76:4: ^( IMPORT STRING )
			{
			match(input,IMPORT,FOLLOW_IMPORT_in_importDecl179); 
			match(input, Token.DOWN, null); 
			STRING2=(CommonTree)match(input,STRING,FOLLOW_STRING_in_importDecl181); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 77:4: -> importDecl(name=$STRING.text)
			{
				retval.st = templateLib.getInstanceOf("importDecl",new STAttrMap().put("name", (STRING2!=null?STRING2.getText():null)));
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
		return retval;
	}
	// $ANTLR end "importDecl"


	public static class declaration_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "declaration"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:80:1: declaration : ( optionDecl | enumDecl -> {$enumDecl.st}| messageDecl -> {$messageDecl.st}| annotationDecl );
	public final EmbeddedCGen.declaration_return declaration() throws RecognitionException {
		EmbeddedCGen.declaration_return retval = new EmbeddedCGen.declaration_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope enumDecl3 =null;
		TreeRuleReturnScope messageDecl4 =null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:81:2: ( optionDecl | enumDecl -> {$enumDecl.st}| messageDecl -> {$messageDecl.st}| annotationDecl )
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
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:81:4: optionDecl
					{
					pushFollow(FOLLOW_optionDecl_in_declaration207);
					optionDecl();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:82:4: enumDecl
					{
					pushFollow(FOLLOW_enumDecl_in_declaration213);
					enumDecl3=enumDecl();
					state._fsp--;

					// TEMPLATE REWRITE
					// 82:13: -> {$enumDecl.st}
					{
						retval.st = (enumDecl3!=null?((StringTemplate)enumDecl3.getTemplate()):null);
					}



					}
					break;
				case 3 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:83:4: messageDecl
					{
					pushFollow(FOLLOW_messageDecl_in_declaration222);
					messageDecl4=messageDecl();
					state._fsp--;

					// TEMPLATE REWRITE
					// 83:16: -> {$messageDecl.st}
					{
						retval.st = (messageDecl4!=null?((StringTemplate)messageDecl4.getTemplate()):null);
					}



					}
					break;
				case 4 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:84:4: annotationDecl
					{
					pushFollow(FOLLOW_annotationDecl_in_declaration231);
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
		return retval;
	}
	// $ANTLR end "declaration"


	public static class optionDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "optionDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:87:1: optionDecl : ^( OPTION ID STRING ) ;
	public final EmbeddedCGen.optionDecl_return optionDecl() throws RecognitionException {
		EmbeddedCGen.optionDecl_return retval = new EmbeddedCGen.optionDecl_return();
		retval.start = input.LT(1);

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:88:3: ( ^( OPTION ID STRING ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:88:5: ^( OPTION ID STRING )
			{
			match(input,OPTION,FOLLOW_OPTION_in_optionDecl245); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_optionDecl247); 
			match(input,STRING,FOLLOW_STRING_in_optionDecl249); 
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
		return retval;
	}
	// $ANTLR end "optionDecl"


	public static class enumDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "enumDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:91:1: enumDecl : ^( ENUM ID (e+= enumElement )* ) -> enumDecl(name=$ID.textelements=$efilename=filenameline=$ENUM.line);
	public final EmbeddedCGen.enumDecl_return enumDecl() throws RecognitionException {
		EmbeddedCGen.enumDecl_return retval = new EmbeddedCGen.enumDecl_return();
		retval.start = input.LT(1);

		CommonTree ID5=null;
		CommonTree ENUM6=null;
		List<Object> list_e=null;
		RuleReturnScope e = null;
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:92:2: ( ^( ENUM ID (e+= enumElement )* ) -> enumDecl(name=$ID.textelements=$efilename=filenameline=$ENUM.line))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:92:4: ^( ENUM ID (e+= enumElement )* )
			{
			ENUM6=(CommonTree)match(input,ENUM,FOLLOW_ENUM_in_enumDecl265); 
			match(input, Token.DOWN, null); 
			ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_enumDecl267); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:92:14: (e+= enumElement )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ASSIGN) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:92:15: e+= enumElement
					{
					pushFollow(FOLLOW_enumElement_in_enumDecl272);
					e=enumElement();
					state._fsp--;

					if (list_e==null) list_e=new ArrayList<Object>();
					list_e.add(e.getTemplate());
					}
					break;

				default :
					break loop5;
				}
			}

			match(input, Token.UP, null); 

			typeMap.put((ID5!=null?ID5.getText():null), "enum");
			// TEMPLATE REWRITE
			// 94:4: -> enumDecl(name=$ID.textelements=$efilename=filenameline=$ENUM.line)
			{
				retval.st = templateLib.getInstanceOf("enumDecl",new STAttrMap().put("name", (ID5!=null?ID5.getText():null)).put("elements", list_e).put("filename", filename).put("line", (ENUM6!=null?ENUM6.getLine():0)));
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
		return retval;
	}
	// $ANTLR end "enumDecl"


	public static class enumElement_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "enumElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:97:1: enumElement : ^( ASSIGN ID INTEGER ) -> enumElement(name=$ID.textvalue=$INTEGER.text);
	public final EmbeddedCGen.enumElement_return enumElement() throws RecognitionException {
		EmbeddedCGen.enumElement_return retval = new EmbeddedCGen.enumElement_return();
		retval.start = input.LT(1);

		CommonTree ID7=null;
		CommonTree INTEGER8=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:98:2: ( ^( ASSIGN ID INTEGER ) -> enumElement(name=$ID.textvalue=$INTEGER.text))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:98:4: ^( ASSIGN ID INTEGER )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_enumElement320); 
			match(input, Token.DOWN, null); 
			ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_enumElement322); 
			INTEGER8=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_enumElement324); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 99:4: -> enumElement(name=$ID.textvalue=$INTEGER.text)
			{
				retval.st = templateLib.getInstanceOf("enumElement",new STAttrMap().put("name", (ID7!=null?ID7.getText():null)).put("value", (INTEGER8!=null?INTEGER8.getText():null)));
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
		return retval;
	}
	// $ANTLR end "enumElement"


	public static class messageDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "messageDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:102:1: messageDecl : ^( MESSAGE ID (e+= messageElement )* ) -> messageDecl(name=$ID.textelements=$efilename=filenameline=$MESSAGE.line);
	public final EmbeddedCGen.messageDecl_return messageDecl() throws RecognitionException {
		EmbeddedCGen.messageDecl_return retval = new EmbeddedCGen.messageDecl_return();
		retval.start = input.LT(1);

		CommonTree ID9=null;
		CommonTree MESSAGE10=null;
		List<Object> list_e=null;
		RuleReturnScope e = null;
		 
		          messageSize = 2; /* 2 bytes length for (write|read)delimited. */
		          elementCount = 0; /* initialisation of number of elements. */ 
		          bigValues = 0;
		        
		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:113:2: ( ^( MESSAGE ID (e+= messageElement )* ) -> messageDecl(name=$ID.textelements=$efilename=filenameline=$MESSAGE.line))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:113:4: ^( MESSAGE ID (e+= messageElement )* )
			{
			MESSAGE10=(CommonTree)match(input,MESSAGE,FOLLOW_MESSAGE_in_messageDecl368); 
			match(input, Token.DOWN, null); 
			ID9=(CommonTree)match(input,ID,FOLLOW_ID_in_messageDecl370); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:113:17: (e+= messageElement )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==ASSIGN) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:113:18: e+= messageElement
					{
					pushFollow(FOLLOW_messageElement_in_messageDecl375);
					e=messageElement();
					state._fsp--;

					if (list_e==null) list_e=new ArrayList<Object>();
					list_e.add(e.getTemplate());
					}
					break;

				default :
					break loop6;
				}
			}

			match(input, Token.UP, null); 

			typeMap.put((ID9!=null?ID9.getText():null), "message");
			// TEMPLATE REWRITE
			// 115:4: -> messageDecl(name=$ID.textelements=$efilename=filenameline=$MESSAGE.line)
			{
				retval.st = templateLib.getInstanceOf("messageDecl",new STAttrMap().put("name", (ID9!=null?ID9.getText():null)).put("elements", list_e).put("filename", filename).put("line", (MESSAGE10!=null?MESSAGE10.getLine():0)));
			}



			}

			 
			           retval.st.setAttribute("maxsize", messageSize);
			           retval.st.setAttribute("empty", elementCount <= 0 ? Boolean.TRUE : Boolean.FALSE);
			           retval.st.setAttribute("bigvalues", bigValues > 0 ? Boolean.TRUE : Boolean.FALSE);
			         
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "messageDecl"


	public static class annotationDecl_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "annotationDecl"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:121:1: annotationDecl : ^( ANNOTATION ID INTEGER ) ;
	public final EmbeddedCGen.annotationDecl_return annotationDecl() throws RecognitionException {
		EmbeddedCGen.annotationDecl_return retval = new EmbeddedCGen.annotationDecl_return();
		retval.start = input.LT(1);

		CommonTree ID11=null;
		CommonTree INTEGER12=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:122:2: ( ^( ANNOTATION ID INTEGER ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:122:4: ^( ANNOTATION ID INTEGER )
			{
			match(input,ANNOTATION,FOLLOW_ANNOTATION_in_annotationDecl479); 
			match(input, Token.DOWN, null); 
			ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_annotationDecl481); 
			INTEGER12=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_annotationDecl483); 
			match(input, Token.UP, null); 


						annotationMap.put((ID11!=null?ID11.getText():null), Integer.parseInt((INTEGER12!=null?INTEGER12.getText():null)));
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotationDecl"


	public static class messageElement_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "messageElement"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:128:1: messageElement : ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID INTEGER ) -> messageAttribute(modifier=$MODIFIER.texttypeName=$t.texttypeClass=typeMap.containsKey($t.text)?typeMap.get($t.text):\"native\"name=$n.texttag=$INTEGER.textdef=null);
	public final EmbeddedCGen.messageElement_return messageElement() throws RecognitionException {
		EmbeddedCGen.messageElement_return retval = new EmbeddedCGen.messageElement_return();
		retval.start = input.LT(1);

		CommonTree t=null;
		CommonTree n=null;
		CommonTree MODIFIER13=null;
		CommonTree INTEGER14=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:129:2: ( ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID INTEGER ) -> messageAttribute(modifier=$MODIFIER.texttypeName=$t.texttypeClass=typeMap.containsKey($t.text)?typeMap.get($t.text):\"native\"name=$n.texttag=$INTEGER.textdef=null))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:129:4: ^( ASSIGN MODIFIER (t= TYPE |t= ID ) n= ID INTEGER )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_messageElement500); 
			match(input, Token.DOWN, null); 
			MODIFIER13=(CommonTree)match(input,MODIFIER,FOLLOW_MODIFIER_in_messageElement502); 
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:129:22: (t= TYPE |t= ID )
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
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:129:23: t= TYPE
					{
					t=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_messageElement507); 
					}
					break;
				case 2 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:129:32: t= ID
					{
					t=(CommonTree)match(input,ID,FOLLOW_ID_in_messageElement513); 
					}
					break;

			}

			n=(CommonTree)match(input,ID,FOLLOW_ID_in_messageElement518); 
			INTEGER14=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_messageElement520); 
			match(input, Token.UP, null); 


				      ++ elementCount;
			         Integer repeatedLength;
			         if ((MODIFIER13!=null?MODIFIER13.getText():null).equals("repeated")) {
			         	repeatedLength = annotationMap.get("max_repeated_length");
				     	if (repeatedLength == null) repeatedLength = 32;
				     } else {
				     	repeatedLength = 1;
				     }
				     String type = (t!=null?t.getText():null);
				     if (type.equals("int32")) {
				       messageSize += repeatedLength * (2 + 10);
				     } else if (type.equals("int64")) {
				       ++ bigValues;
			         messageSize += repeatedLength * (2 + 10);
			       } else if (type.equals("sint32")) {
			         messageSize += repeatedLength * (2 + 5);
			       } else if (type.equals("sint64")) {
			         ++ bigValues;
			         messageSize += repeatedLength * (2 + 10);
			       } else if (type.equals("uint32")) {
			         messageSize += repeatedLength * (2 + 5);
			       } else if (type.equals("uint64")) {
			         ++ bigValues;
			         messageSize += repeatedLength * (2 + 10);
			       } else if (type.equals("string")) {
				       Integer stringLength = annotationMap.get("max_string_length");
				       if (stringLength == null) stringLength = 32;
				       messageSize += repeatedLength * (2 + 1 + stringLength);
				     } else if (type.equals("float")) {
				       messageSize += repeatedLength * (2 + 4);
				     } else if (type.equals("fixed32")) {
				       messageSize += repeatedLength * (2 + 4);
				     } else if (type.equals("fixed64")) {
				       ++ bigValues;
				       messageSize += repeatedLength * (2 + 8);
				     } else if (type.equals("sfixed32")) {
				       messageSize += repeatedLength * (2 + 4);
				     } else if (type.equals("sfixed64")) {
				       ++ bigValues;
				       messageSize += repeatedLength * (2 + 8);
				     } else if (type.equals("double")) {
				       ++ bigValues;
			         messageSize += repeatedLength * (2 + 8);
				     } else if (type.equals("bool")) {
			         messageSize += repeatedLength * (2 + 1);
				     } else if (type.equals("bytes")) {
				       Integer bytesLength = annotationMap.get("max_bytes_length");
			         if (bytesLength == null) bytesLength = 32;
			         messageSize += repeatedLength * (2 + 1 + bytesLength);
			       } else if (type.equals("enum")){ 
			         messageSize += repeatedLength * (2 + 1);
			       } else {
			         //embedded messages
			         //TODO: compute the maximum length of the message
			         messageSize += repeatedLength * (2 + 1);
			       }
				   
			// TEMPLATE REWRITE
			// 188:4: -> messageAttribute(modifier=$MODIFIER.texttypeName=$t.texttypeClass=typeMap.containsKey($t.text)?typeMap.get($t.text):\"native\"name=$n.texttag=$INTEGER.textdef=null)
			{
				retval.st = templateLib.getInstanceOf("messageAttribute",new STAttrMap().put("modifier", (MODIFIER13!=null?MODIFIER13.getText():null)).put("typeName", (t!=null?t.getText():null)).put("typeClass", typeMap.containsKey((t!=null?t.getText():null))?typeMap.get((t!=null?t.getText():null)):"native").put("name", (n!=null?n.getText():null)).put("tag", (INTEGER14!=null?INTEGER14.getText():null)).put("def", null));
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
		return retval;
	}
	// $ANTLR end "messageElement"


	public static class elementDefault_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "elementDefault"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:197:1: elementDefault : ^( ASSIGN DEFAULT def_val= ID ) ;
	public final EmbeddedCGen.elementDefault_return elementDefault() throws RecognitionException {
		EmbeddedCGen.elementDefault_return retval = new EmbeddedCGen.elementDefault_return();
		retval.start = input.LT(1);

		CommonTree def_val=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:198:3: ( ^( ASSIGN DEFAULT def_val= ID ) )
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:198:5: ^( ASSIGN DEFAULT def_val= ID )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_elementDefault630); 
			match(input, Token.DOWN, null); 
			match(input,DEFAULT,FOLLOW_DEFAULT_in_elementDefault632); 
			def_val=(CommonTree)match(input,ID,FOLLOW_ID_in_elementDefault636); 
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
		return retval;
	}
	// $ANTLR end "elementDefault"


	public static class qualifiedID_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "qualifiedID"
	// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:201:1: qualifiedID : (i+= ID )+ -> qualifiedID(ids=$i);
	public final EmbeddedCGen.qualifiedID_return qualifiedID() throws RecognitionException {
		EmbeddedCGen.qualifiedID_return retval = new EmbeddedCGen.qualifiedID_return();
		retval.start = input.LT(1);

		CommonTree i=null;
		List<Object> list_i=null;

		try {
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:202:2: ( (i+= ID )+ -> qualifiedID(ids=$i))
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:202:4: (i+= ID )+
			{
			// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:202:4: (i+= ID )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ID) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/vlad/Documents/ProtobufWorkspace/edu.tum.cs.ccts.protobuf.embedded/grammar/EmbeddedCGen.g:202:5: i+= ID
					{
					i=(CommonTree)match(input,ID,FOLLOW_ID_in_qualifiedID652); 
					if (list_i==null) list_i=new ArrayList<Object>();
					list_i.add(i);
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// TEMPLATE REWRITE
			// 203:4: -> qualifiedID(ids=$i)
			{
				retval.st = templateLib.getInstanceOf("qualifiedID",new STAttrMap().put("ids", list_i));
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
		return retval;
	}
	// $ANTLR end "qualifiedID"

	// Delegated rules



	public static final BitSet FOLLOW_PROTO_in_proto69 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_packageDecl_in_proto73 = new BitSet(new long[]{0x00000000000A4818L});
	public static final BitSet FOLLOW_importDecl_in_proto79 = new BitSet(new long[]{0x00000000000A4818L});
	public static final BitSet FOLLOW_declaration_in_proto86 = new BitSet(new long[]{0x00000000000A0818L});
	public static final BitSet FOLLOW_PACKAGE_in_packageDecl150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_qualifiedID_in_packageDecl152 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IMPORT_in_importDecl179 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STRING_in_importDecl181 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_optionDecl_in_declaration207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enumDecl_in_declaration213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_messageDecl_in_declaration222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotationDecl_in_declaration231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_optionDecl245 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_optionDecl247 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_in_optionDecl249 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ENUM_in_enumDecl265 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_enumDecl267 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_enumElement_in_enumDecl272 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_ASSIGN_in_enumElement320 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_enumElement322 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_enumElement324 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MESSAGE_in_messageDecl368 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_messageDecl370 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_messageElement_in_messageDecl375 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_ANNOTATION_in_annotationDecl479 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_annotationDecl481 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_annotationDecl483 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_messageElement500 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_MODIFIER_in_messageElement502 = new BitSet(new long[]{0x0000000002002000L});
	public static final BitSet FOLLOW_TYPE_in_messageElement507 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageElement513 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_messageElement518 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_INTEGER_in_messageElement520 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_elementDefault630 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_DEFAULT_in_elementDefault632 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_elementDefault636 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_qualifiedID652 = new BitSet(new long[]{0x0000000000002002L});
}
