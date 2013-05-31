package edu.tum.cs.ccts.protobuf.embedded;

import com.google.common.base.Objects;
import edu.tum.cs.ccts.protobuf.embedded.ProtoParser;
import edu.tum.cs.ccts.protobuf.embedded.Protoc;
import edu.tum.cs.ccts.protobuf.embedded.TreeUtils;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EmbeddedCGenerator {
  private final HashMap<String,String> typeMap = new Function0<HashMap<String,String>>() {
    public HashMap<String,String> apply() {
      Pair<String,String> _mappedTo = Pair.<String, String>of("double", "double");
      Pair<String,String> _mappedTo_1 = Pair.<String, String>of("float", "float");
      Pair<String,String> _mappedTo_2 = Pair.<String, String>of("int32", "signed long");
      Pair<String,String> _mappedTo_3 = Pair.<String, String>of("int64", "signed long long");
      Pair<String,String> _mappedTo_4 = Pair.<String, String>of("uint32", "unsigned long");
      Pair<String,String> _mappedTo_5 = Pair.<String, String>of("uint64", "unsigned long long");
      Pair<String,String> _mappedTo_6 = Pair.<String, String>of("sint32", "signed long");
      Pair<String,String> _mappedTo_7 = Pair.<String, String>of("sint64", "signed long long");
      Pair<String,String> _mappedTo_8 = Pair.<String, String>of("fixed32", "unsigned long");
      Pair<String,String> _mappedTo_9 = Pair.<String, String>of("fixed64", "unsigned long long");
      Pair<String,String> _mappedTo_10 = Pair.<String, String>of("sfixed32", "signed long");
      Pair<String,String> _mappedTo_11 = Pair.<String, String>of("sfixed64", "signed long long");
      Pair<String,String> _mappedTo_12 = Pair.<String, String>of("bool", "char");
      Pair<String,String> _mappedTo_13 = Pair.<String, String>of("string", "char");
      Pair<String,String> _mappedTo_14 = Pair.<String, String>of("bytes", "char");
      HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12, _mappedTo_13, _mappedTo_14);
      return _newHashMap;
    }
  }.apply();
  
  private final HashMap<String,String> wireTypeMap = new Function0<HashMap<String,String>>() {
    public HashMap<String,String> apply() {
      Pair<String,String> _mappedTo = Pair.<String, String>of("int32", "0");
      Pair<String,String> _mappedTo_1 = Pair.<String, String>of("int64", "0");
      Pair<String,String> _mappedTo_2 = Pair.<String, String>of("sint32", "0");
      Pair<String,String> _mappedTo_3 = Pair.<String, String>of("sint64", "0");
      Pair<String,String> _mappedTo_4 = Pair.<String, String>of("uint32", "0");
      Pair<String,String> _mappedTo_5 = Pair.<String, String>of("uint64", "0");
      Pair<String,String> _mappedTo_6 = Pair.<String, String>of("string", "2");
      Pair<String,String> _mappedTo_7 = Pair.<String, String>of("bool", "0");
      Pair<String,String> _mappedTo_8 = Pair.<String, String>of("float", "5");
      Pair<String,String> _mappedTo_9 = Pair.<String, String>of("double", "1");
      Pair<String,String> _mappedTo_10 = Pair.<String, String>of("fixed32", "5");
      Pair<String,String> _mappedTo_11 = Pair.<String, String>of("fixed64", "1");
      Pair<String,String> _mappedTo_12 = Pair.<String, String>of("sfixed32", "5");
      Pair<String,String> _mappedTo_13 = Pair.<String, String>of("sfixed64", "1");
      Pair<String,String> _mappedTo_14 = Pair.<String, String>of("bytes", "2");
      HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12, _mappedTo_13, _mappedTo_14);
      return _newHashMap;
    }
  }.apply();
  
  private final HashSet<Object> enumSet = new Function0<HashSet<Object>>() {
    public HashSet<Object> apply() {
      HashSet<Object> _newHashSet = CollectionLiterals.<Object>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  private final HashMap<String,String> arrayTypes = new Function0<HashMap<String,String>>() {
    public HashMap<String,String> apply() {
      Pair<String,String> _mappedTo = Pair.<String, String>of("string", "[MAX_STRING_LENGTH]");
      Pair<String,String> _mappedTo_1 = Pair.<String, String>of("bytes", "[MAX_BYTES_LENGTH]");
      HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1);
      return _newHashMap;
    }
  }.apply();
  
  private final HashMap<String,String> readValues = new Function0<HashMap<String,String>>() {
    public HashMap<String,String> apply() {
      Pair<String,String> _mappedTo = Pair.<String, String>of("int32", "(signed long)tag");
      Pair<String,String> _mappedTo_1 = Pair.<String, String>of("int64", "(signed long long)value");
      Pair<String,String> _mappedTo_2 = Pair.<String, String>of("sint32", "decode_zig_zag32(tag)");
      Pair<String,String> _mappedTo_3 = Pair.<String, String>of("sint64", "decode_zig_zag64(value)");
      Pair<String,String> _mappedTo_4 = Pair.<String, String>of("uint32", "tag");
      Pair<String,String> _mappedTo_5 = Pair.<String, String>of("uint64", "value");
      Pair<String,String> _mappedTo_6 = Pair.<String, String>of("fixed32", "tag");
      Pair<String,String> _mappedTo_7 = Pair.<String, String>of("fixed64", "value");
      Pair<String,String> _mappedTo_8 = Pair.<String, String>of("sfixed32", "(signed long)tag");
      Pair<String,String> _mappedTo_9 = Pair.<String, String>of("sfixed64", "(signed long long)value");
      Pair<String,String> _mappedTo_10 = Pair.<String, String>of("bool", "tag & 1");
      HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10);
      return _newHashMap;
    }
  }.apply();
  
  private final HashMap<Object,Object> annotationMap = new Function0<HashMap<Object,Object>>() {
    public HashMap<Object,Object> apply() {
      HashMap<Object,Object> _newHashMap = CollectionLiterals.<Object, Object>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  public void doGenerate(final File outputDirectory, final String name, final CommonTree tree) {
    String _plus = (name + ".h");
    File _file = new File(outputDirectory, _plus);
    CharSequence _compileHeader = this.compileHeader(tree, name);
    this.generateFile(_file, _compileHeader);
    String _plus_1 = (name + ".c");
    File _file_1 = new File(outputDirectory, _plus_1);
    CharSequence _compileImplementation = this.compileImplementation(tree, name);
    this.generateFile(_file_1, _compileImplementation);
  }
  
  public CharSequence compileHeader(final CommonTree tree, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/******************************************************************* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Header file generated by Protoc for Embedded C.                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Version ");
    _builder.append(Protoc.VERSION, " ");
    _builder.append("                                      *");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2009-2013                                         *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Technische Universitaet Muenchen                                *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www4.in.tum.de/                                          *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Source : ");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, " ");
    _builder.append(".proto");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Do not edit.                                                    *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#ifndef _");
    String _firstUpper_1 = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper_1, "");
    _builder.append("_H");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _firstUpper_2 = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper_2, "");
    _builder.append("_H");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("extern \"C\" {");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    {
      List<CommonTree> _childTrees = TreeUtils.childTrees(tree);
      final Function1<CommonTree,Boolean> _function = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == ProtoParser.ANNOTATION);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter = IterableExtensions.<CommonTree>filter(_childTrees, _function);
      for(final CommonTree d : _filter) {
        String _define = this.getDefine(d);
        _builder.append(_define, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/*******************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* General functions");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* returns the size of a length delimited message which also ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* contains the first bytes for the length encoding.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("unsigned long Message_get_delimited_size(void *_buffer, int offset);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Tests whether a message can be completely read from the given buffer at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* the offset. The bytes [offset..offset+length-1] are interpreted.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Returns 1 (true) if buffer[offset..offset+length-1] contains a complete");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* message or 0 (false) otherwise.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("int Message_can_read_delimited_from(void *_buffer, int offset, unsigned int length);");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      List<CommonTree> _childTrees_1 = TreeUtils.childTrees(tree);
      final Function1<CommonTree,Boolean> _function_1 = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == ProtoParser.ENUM);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter_1 = IterableExtensions.<CommonTree>filter(_childTrees_1, _function_1);
      for(final CommonTree e : _filter_1) {
        _builder.append("/*******************************************************************");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Enumeration: ");
        String _firstUpper_3 = StringExtensions.toFirstUpper(name);
        _builder.append(_firstUpper_3, " ");
        _builder.append(".proto, line ");
        int _line = e.getLine();
        _builder.append(_line, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*******************************************************************/");
        _builder.newLine();
        String _enumHeader = this.getEnumHeader(e);
        _builder.append(_enumHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Iterable<CommonTree> _sortedChildTreesWithType = TreeUtils.sortedChildTreesWithType(tree, ProtoParser.MESSAGE);
      for(final CommonTree m : _sortedChildTreesWithType) {
        _builder.append("/*******************************************************************");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Message: ");
        String _firstUpper_4 = StringExtensions.toFirstUpper(name);
        _builder.append(_firstUpper_4, " ");
        _builder.append(".proto, line ");
        int _line_1 = m.getLine();
        _builder.append(_line_1, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*******************************************************************/");
        _builder.newLine();
        _builder.newLine();
        _builder.append("/* Maximum size of a serialized ");
        Tree _child = m.getChild(0);
        String _text = _child.getText();
        _builder.append(_text, "");
        _builder.append("-message, useful for buffer allocation. */");
        _builder.newLineIfNotEmpty();
        _builder.append("#define MAX_");
        Tree _child_1 = m.getChild(0);
        String _text_1 = _child_1.getText();
        _builder.append(_text_1, "");
        _builder.append("_SIZE ");
        int _maximumSerializedSize = this.getMaximumSerializedSize(m);
        _builder.append(_maximumSerializedSize, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        String _messageHeader = this.getMessageHeader(m);
        _builder.append(_messageHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Serialize a Person-message into the given buffer at offset and return");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* new offset for optional next message.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("int ");
        String _messageName = this.getMessageName(m);
        _builder.append(_messageName, "");
        _builder.append("_write_delimited_to(struct ");
        String _messageName_1 = this.getMessageName(m);
        _builder.append(_messageName_1, "");
        _builder.append(" *_");
        String _messageName_2 = this.getMessageName(m);
        _builder.append(_messageName_2, "");
        _builder.append(", void *_buffer, int offset);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Serialize a Person-message together with its tag into the given buffer ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* at offset and return new offset for optional next message.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Is useful if a Person-message is embedded in another message.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("int ");
        String _messageName_3 = this.getMessageName(m);
        _builder.append(_messageName_3, "");
        _builder.append("_write_with_tag(struct ");
        String _messageName_4 = this.getMessageName(m);
        _builder.append(_messageName_4, "");
        _builder.append(" *_");
        String _messageName_5 = this.getMessageName(m);
        _builder.append(_messageName_5, "");
        _builder.append(", void *_buffer, int offset, int tag);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("/*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Deserialize a Person-message from the given buffer at offset and return");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* new offset for optional next message.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Note: All fields in _Person will be reset to 0 before _buffer is interpreted.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("int ");
        String _messageName_6 = this.getMessageName(m);
        _builder.append(_messageName_6, "");
        _builder.append("_read_delimited_from(void *_buffer, struct ");
        String _messageName_7 = this.getMessageName(m);
        _builder.append(_messageName_7, "");
        _builder.append(" *_");
        String _messageName_8 = this.getMessageName(m);
        _builder.append(_messageName_8, "");
        _builder.append(", int offset);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public int getMaximumSerializedSize(final CommonTree m) {
    int _xblockexpression = (int) 0;
    {
      int messageSize = 2;
      List<CommonTree> _childTrees = TreeUtils.childTrees(m);
      Iterable<CommonTree> _tail = IterableExtensions.<CommonTree>tail(_childTrees);
      for (final CommonTree attr : _tail) {
        {
          List _children = attr.getChildren();
          Object _get = _children.get(1);
          final CommonTree type = ((CommonTree) _get);
          List _children_1 = attr.getChildren();
          Object _get_1 = _children_1.get(0);
          final CommonTree modifier = ((CommonTree) _get_1);
          Integer repeatedLength = null;
          String _text = modifier.getText();
          boolean _equals = _text.equals("repeated");
          if (_equals) {
            Object _get_2 = this.annotationMap.get("MAX_REPEATED_LENGTH");
            int _parseInt = Integer.parseInt(((String) _get_2));
            repeatedLength = Integer.valueOf(_parseInt);
            boolean _equals_1 = Objects.equal(repeatedLength, null);
            if (_equals_1) {
              repeatedLength = Integer.valueOf(32);
            }
          } else {
            repeatedLength = Integer.valueOf(1);
          }
          boolean _or = false;
          boolean _or_1 = false;
          boolean _or_2 = false;
          String _text_1 = type.getText();
          boolean _equals_2 = _text_1.equals("int32");
          if (_equals_2) {
            _or_2 = true;
          } else {
            String _text_2 = type.getText();
            boolean _equals_3 = _text_2.equals("int64");
            _or_2 = (_equals_2 || _equals_3);
          }
          if (_or_2) {
            _or_1 = true;
          } else {
            String _text_3 = type.getText();
            boolean _equals_4 = _text_3.equals("sint64");
            _or_1 = (_or_2 || _equals_4);
          }
          if (_or_1) {
            _or = true;
          } else {
            String _text_4 = type.getText();
            boolean _equals_5 = _text_4.equals("uint64");
            _or = (_or_1 || _equals_5);
          }
          if (_or) {
            int _plus = (2 + 10);
            int _multiply = ((repeatedLength).intValue() * _plus);
            int _plus_1 = (messageSize + _multiply);
            messageSize = _plus_1;
          } else {
            boolean _or_3 = false;
            String _text_5 = type.getText();
            boolean _equals_6 = _text_5.equals("sint32");
            if (_equals_6) {
              _or_3 = true;
            } else {
              String _text_6 = type.getText();
              boolean _equals_7 = _text_6.equals("uint32");
              _or_3 = (_equals_6 || _equals_7);
            }
            if (_or_3) {
              int _plus_2 = (2 + 5);
              int _multiply_1 = ((repeatedLength).intValue() * _plus_2);
              int _plus_3 = (messageSize + _multiply_1);
              messageSize = _plus_3;
            } else {
              String _text_7 = type.getText();
              boolean _equals_8 = _text_7.equals("string");
              if (_equals_8) {
                Object _get_3 = this.annotationMap.get("MAX_STRING_LENGTH");
                Integer stringLength = Integer.valueOf(Integer.parseInt(((String) _get_3)));
                boolean _equals_9 = Objects.equal(stringLength, null);
                if (_equals_9) {
                  stringLength = Integer.valueOf(32);
                }
                int _plus_4 = (2 + 1);
                int _plus_5 = (_plus_4 + (stringLength).intValue());
                int _multiply_2 = ((repeatedLength).intValue() * _plus_5);
                int _plus_6 = (messageSize + _multiply_2);
                messageSize = _plus_6;
              } else {
                boolean _or_4 = false;
                boolean _or_5 = false;
                String _text_8 = type.getText();
                boolean _equals_10 = _text_8.equals("float");
                if (_equals_10) {
                  _or_5 = true;
                } else {
                  String _text_9 = type.getText();
                  boolean _equals_11 = _text_9.equals("fixed32");
                  _or_5 = (_equals_10 || _equals_11);
                }
                if (_or_5) {
                  _or_4 = true;
                } else {
                  String _text_10 = type.getText();
                  boolean _equals_12 = _text_10.equals("sfixed32");
                  _or_4 = (_or_5 || _equals_12);
                }
                if (_or_4) {
                  int _plus_7 = (2 + 4);
                  int _multiply_3 = ((repeatedLength).intValue() * _plus_7);
                  int _plus_8 = (messageSize + _multiply_3);
                  messageSize = _plus_8;
                } else {
                  boolean _or_6 = false;
                  boolean _or_7 = false;
                  String _text_11 = type.getText();
                  boolean _equals_13 = _text_11.equals("fixed64");
                  if (_equals_13) {
                    _or_7 = true;
                  } else {
                    String _text_12 = type.getText();
                    boolean _equals_14 = _text_12.equals("sfixed64");
                    _or_7 = (_equals_13 || _equals_14);
                  }
                  if (_or_7) {
                    _or_6 = true;
                  } else {
                    String _text_13 = type.getText();
                    boolean _equals_15 = _text_13.equals("double");
                    _or_6 = (_or_7 || _equals_15);
                  }
                  if (_or_6) {
                    int _plus_9 = (2 + 8);
                    int _multiply_4 = ((repeatedLength).intValue() * _plus_9);
                    int _plus_10 = (messageSize + _multiply_4);
                    messageSize = _plus_10;
                  } else {
                    boolean _or_8 = false;
                    String _text_14 = type.getText();
                    boolean _equals_16 = _text_14.equals("bool");
                    if (_equals_16) {
                      _or_8 = true;
                    } else {
                      String _text_15 = type.getText();
                      boolean _contains = this.enumSet.contains(_text_15);
                      _or_8 = (_equals_16 || _contains);
                    }
                    if (_or_8) {
                      int _plus_11 = (2 + 1);
                      int _multiply_5 = ((repeatedLength).intValue() * _plus_11);
                      int _plus_12 = (messageSize + _multiply_5);
                      messageSize = _plus_12;
                    } else {
                      String _text_16 = type.getText();
                      boolean _equals_17 = _text_16.equals("bytes");
                      if (_equals_17) {
                        Object _get_4 = this.annotationMap.get("MAX_BYTES_LENGTH");
                        Integer bytesLength = Integer.valueOf(Integer.parseInt(((String) _get_4)));
                        boolean _equals_18 = Objects.equal(bytesLength, null);
                        if (_equals_18) {
                          bytesLength = Integer.valueOf(32);
                        }
                        int _plus_13 = (2 + 1);
                        int _plus_14 = (_plus_13 + (bytesLength).intValue());
                        int _multiply_6 = ((repeatedLength).intValue() * _plus_14);
                        int _plus_15 = (messageSize + _multiply_6);
                        messageSize = _plus_15;
                      } else {
                        String _text_17 = type.getText();
                        CommonTree _findMessage = this.findMessage(_text_17, m.parent);
                        int _maximumSerializedSize = this.getMaximumSerializedSize(_findMessage);
                        int _multiply_7 = ((repeatedLength).intValue() * _maximumSerializedSize);
                        int _plus_16 = (messageSize + _multiply_7);
                        messageSize = _plus_16;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = (messageSize);
    }
    return _xblockexpression;
  }
  
  public CommonTree findMessage(final String messageName, final CommonTree tree) {
    CommonTree _xblockexpression = null;
    {
      List<CommonTree> _childTrees = TreeUtils.childTrees(tree);
      final Function1<CommonTree,Boolean> _function = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == ProtoParser.MESSAGE);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter = IterableExtensions.<CommonTree>filter(_childTrees, _function);
      for (final CommonTree m : _filter) {
        Tree _child = m.getChild(0);
        String _text = _child.getText();
        boolean _equals = _text.equals(messageName);
        if (_equals) {
          return m;
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public String getMessageName(final CommonTree m) {
    String _xblockexpression = null;
    {
      List _children = m.getChildren();
      Object _get = _children.get(0);
      final CommonTree name = ((CommonTree) _get);
      String _text = name.getText();
      _xblockexpression = (_text);
    }
    return _xblockexpression;
  }
  
  public String getMessageHeader(final CommonTree m) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      StringBuilder messageValue = _stringBuilder;
      List _children = m.getChildren();
      Object _get = _children.get(0);
      final CommonTree name = ((CommonTree) _get);
      String _text = name.getText();
      String _plus = ("/* Structure that holds a deserialized " + _text);
      String _plus_1 = (_plus + "-message. */\n");
      messageValue.append(_plus_1);
      messageValue.append("struct ");
      String _text_1 = name.getText();
      String _plus_2 = (_text_1 + " {\n");
      messageValue.append(_plus_2);
      final String indent = "    ";
      List<CommonTree> _childTrees = TreeUtils.childTrees(m);
      Iterable<CommonTree> _tail = IterableExtensions.<CommonTree>tail(_childTrees);
      for (final CommonTree attr : _tail) {
        {
          List _children_1 = attr.getChildren();
          Object _get_1 = _children_1.get(0);
          final CommonTree modifier = ((CommonTree) _get_1);
          List _children_2 = attr.getChildren();
          Object _get_2 = _children_2.get(1);
          final CommonTree type = ((CommonTree) _get_2);
          List _children_3 = attr.getChildren();
          Object _get_3 = _children_3.get(2);
          final CommonTree attrName = ((CommonTree) _get_3);
          String _text_2 = type.getText();
          String cType = this.typeMap.get(_text_2);
          boolean _equals = Objects.equal(cType, null);
          if (_equals) {
            String _text_3 = type.getText();
            boolean _contains = this.enumSet.contains(_text_3);
            if (_contains) {
              String _text_4 = type.getText();
              String _plus_3 = ("enum " + _text_4);
              cType = _plus_3;
            } else {
              String _text_5 = type.getText();
              String _plus_4 = ("struct " + _text_5);
              cType = _plus_4;
            }
          }
          String repValue = "";
          String _text_6 = modifier.getText();
          boolean _equals_1 = _text_6.equals("repeated");
          if (_equals_1) {
            repValue = "[MAX_REPEATED_LENGTH]";
          }
          String _text_7 = type.getText();
          String typeArrayValue = this.arrayTypes.get(_text_7);
          boolean _equals_2 = Objects.equal(typeArrayValue, null);
          if (_equals_2) {
            typeArrayValue = "";
          }
          boolean _equals_3 = repValue.equals("");
          boolean _not = (!_equals_3);
          if (_not) {
            String _plus_5 = (indent + "int");
            String _plus_6 = (_plus_5 + " _");
            String _text_8 = attrName.getText();
            String _plus_7 = (_plus_6 + _text_8);
            String _plus_8 = (_plus_7 + "_repeated_len");
            String _plus_9 = (_plus_8 + ";\n");
            messageValue.append(_plus_9);
          }
          boolean _equals_4 = typeArrayValue.equals("");
          boolean _not_1 = (!_equals_4);
          if (_not_1) {
            String _plus_10 = (indent + "int");
            String _plus_11 = (_plus_10 + " _");
            String _text_9 = attrName.getText();
            String _plus_12 = (_plus_11 + _text_9);
            String _plus_13 = (_plus_12 + "_len");
            String _plus_14 = (_plus_13 + repValue);
            String _plus_15 = (_plus_14 + ";\n");
            messageValue.append(_plus_15);
          }
          String _plus_16 = (indent + cType);
          String _plus_17 = (_plus_16 + " _");
          String _text_10 = attrName.getText();
          String _plus_18 = (_plus_17 + _text_10);
          String _plus_19 = (_plus_18 + repValue);
          String _plus_20 = (_plus_19 + typeArrayValue);
          String _plus_21 = (_plus_20 + ";\n");
          messageValue.append(_plus_21);
        }
      }
      messageValue.append("};");
      String _string = messageValue.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String getEnumHeader(final CommonTree e) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      StringBuilder enumValue = _stringBuilder;
      enumValue.append("enum ");
      List _children = e.getChildren();
      Object _get = _children.get(0);
      final CommonTree name = ((CommonTree) _get);
      String _plus = (name + " {\n");
      enumValue.append(_plus);
      String _text = name.getText();
      this.enumSet.add(_text);
      final String indent = "    ";
      int i = 1;
      List _children_1 = e.getChildren();
      int _size = _children_1.size();
      int _minus = (_size - 1);
      boolean _lessThan = (i < _minus);
      boolean _while = _lessThan;
      while (_while) {
        {
          List _children_2 = e.getChildren();
          Object _get_1 = _children_2.get(i);
          List _children_3 = ((CommonTree) _get_1).getChildren();
          Object _get_2 = _children_3.get(0);
          final CommonTree value = ((CommonTree) _get_2);
          List _children_4 = e.getChildren();
          Object _get_3 = _children_4.get(i);
          List _children_5 = ((CommonTree) _get_3).getChildren();
          Object _get_4 = _children_5.get(1);
          final CommonTree id = ((CommonTree) _get_4);
          String _plus_1 = (indent + "_");
          String _text_1 = value.getText();
          String _plus_2 = (_plus_1 + _text_1);
          String _plus_3 = (_plus_2 + " = ");
          String _text_2 = id.getText();
          String _plus_4 = (_plus_3 + _text_2);
          String _plus_5 = (_plus_4 + ",\n");
          enumValue.append(_plus_5);
          int _plus_6 = (i + 1);
          i = _plus_6;
        }
        List _children_2 = e.getChildren();
        int _size_1 = _children_2.size();
        int _minus_1 = (_size_1 - 1);
        boolean _lessThan_1 = (i < _minus_1);
        _while = _lessThan_1;
      }
      List _children_2 = e.getChildren();
      Object _get_1 = _children_2.get(i);
      List _children_3 = ((CommonTree) _get_1).getChildren();
      Object _get_2 = _children_3.get(0);
      final CommonTree value = ((CommonTree) _get_2);
      List _children_4 = e.getChildren();
      Object _get_3 = _children_4.get(i);
      List _children_5 = ((CommonTree) _get_3).getChildren();
      Object _get_4 = _children_5.get(1);
      final CommonTree id = ((CommonTree) _get_4);
      String _plus_1 = (indent + "_");
      String _text_1 = value.getText();
      String _plus_2 = (_plus_1 + _text_1);
      String _plus_3 = (_plus_2 + " = ");
      String _text_2 = id.getText();
      String _plus_4 = (_plus_3 + _text_2);
      String _plus_5 = (_plus_4 + "\n");
      enumValue.append(_plus_5);
      enumValue.append("};");
      String _string = enumValue.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String getDefine(final CommonTree d) {
    String _xblockexpression = null;
    {
      String define = "#define ";
      List _children = d.getChildren();
      Object _get = _children.get(0);
      final CommonTree literal = ((CommonTree) _get);
      List _children_1 = d.getChildren();
      Object _get_1 = _children_1.get(1);
      final CommonTree number = ((CommonTree) _get_1);
      String _text = literal.getText();
      String _upperCase = _text.toUpperCase();
      String _text_1 = number.getText();
      this.annotationMap.put(_upperCase, _text_1);
      String _text_2 = literal.getText();
      String _upperCase_1 = _text_2.toUpperCase();
      String _plus = (define + _upperCase_1);
      String _plus_1 = (_plus + " ");
      define = _plus_1;
      String _text_3 = number.getText();
      String _plus_2 = (define + _text_3);
      String _define = define = _plus_2;
      _xblockexpression = (_define);
    }
    return _xblockexpression;
  }
  
  public CharSequence compileImplementation(final CommonTree tree, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/******************************************************************* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* C file generated by Protoc for Embedded C.                      *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Version ");
    _builder.append(Protoc.VERSION, " ");
    _builder.append("                                      *");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2009-2013                                         *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Technische Universitaet Muenchen                                *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www4.in.tum.de/                                          *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Source : ");
    _builder.append(name, " ");
    _builder.append(".proto");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*                                                                 *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Do not edit.                                                    *");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************/");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("#include \"");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append(".h\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("int _memcmp(const void *p1, const void *p2, unsigned int size) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("unsigned int i;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for(i = 0; i < size; ++ i) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(*((char*)p1 + i) > *((char*)p2 + i))");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return 1;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(*((char*)p1 + i) < *((char*)p2 + i))");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return -1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return 0;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("void _memset(void *msg_ptr, char init_val, unsigned int size) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("unsigned int i;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for(i = 0; i < size; ++ i)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*((char*)msg_ptr + i) = init_val;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int varint_packed_size(unsigned long value) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if ((value & (0xffffffff <<  7)) == 0) return 1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if ((value & (0xffffffff << 14)) == 0) return 2;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if ((value & (0xffffffff << 21)) == 0) return 3;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if ((value & (0xffffffff << 28)) == 0) return 4;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return 5;  ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_raw_byte(char value, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*((char *)_buffer + offset) = value;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return ++offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/** Write a little-endian 32-bit integer. */");
    _builder.newLine();
    _builder.append("int write_raw_little_endian32(unsigned long value, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value      ) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >>  8) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 16) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 24) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/** Write a little-endian 64-bit integer. */");
    _builder.newLine();
    _builder.append("int write_raw_little_endian64(unsigned long long value, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value      ) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >>  8) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 16) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 24) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 32) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 40) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 48) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_byte((char)((value >> 56) & 0xFF), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_raw_varint32(unsigned long value, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while (1) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ((value & ~0x7F) == 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("offset = write_raw_byte((char)value, _buffer, offset);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("offset = write_raw_byte((char)((value & 0x7F) | 0x80), _buffer, offset);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("value = value >> 7;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_raw_varint64(unsigned long long value, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while (1) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ((value & ~0x7FL) == 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("offset = write_raw_byte((char)value, _buffer, offset);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("offset = write_raw_byte((char)((value & 0x7F) | 0x80), _buffer, offset);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("value = value >> 7;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_raw_bytes(char *bytes, int bytes_size, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int i; ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for(i = 0; i < bytes_size; ++ i) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("offset = write_raw_byte((char)*(bytes + i), _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;   ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("unsigned long encode_zig_zag32(signed long n) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* Note:  the right-shift must be arithmetic. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (n << 1) ^ (n >> 31);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("unsigned long long encode_zig_zag64(signed long long n) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* Note:  the right-shift must be arithmetic. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (n << 1) ^ (n >> 63);");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("signed long decode_zig_zag32(unsigned long n) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (n >> 1) ^ -(n & 1);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("signed long long decode_zig_zag64(unsigned long long n) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (n >> 1) ^ -(n & 1);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int read_raw_byte(char *tag, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*tag = *((char *) _buffer + offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return ++offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/** Read a 32-bit little-endian integer from the stream. */");
    _builder.newLine();
    _builder.append("int read_raw_little_endian32(unsigned long *tag, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b1 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b2 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b3 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b4 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*tag = (((unsigned long)b1 & 0xff)      ) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long)b2 & 0xff) <<  8) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long)b3 & 0xff) << 16) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long)b4 & 0xff) << 24);");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/** Read a 64-bit little-endian integer from the stream. */");
    _builder.newLine();
    _builder.append("int read_raw_little_endian64(unsigned long long *tag, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b1 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b2 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b3 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b4 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b5 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b6 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b7 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)tag, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("char b8 = (char) *tag;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*tag = (((unsigned long long)b1 & 0xff)      ) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b2 & 0xff) <<  8) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b3 & 0xff) << 16) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b4 & 0xff) << 24) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b5 & 0xff) << 32) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b6 & 0xff) << 40) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b7 & 0xff) << 48) |");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("(((unsigned long long)b8 & 0xff) << 56);");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int read_raw_varint32(unsigned long *tag, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("signed char result;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (result >= 0) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*tag = result;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*tag = result & 0x7f;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (result >= 0) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*tag |= result << 7;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*tag |= (result & 0x7f) << 7;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (result >= 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("*tag |= result << 14;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("*tag |= (result & 0x7f) << 14;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if (result >= 0) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("*tag |= ((unsigned long)result) << 21;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("*tag |= (((unsigned long)result) & 0x7f) << 21;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("*tag |= ((unsigned long)result) << 28;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if (result < 0) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("/* Discard upper 32 bits. */");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("for (i = 0; i < 5; ++ i) {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("offset = read_raw_byte((char *)&result, _buffer, offset);");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("if (result >= 0) {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("/* Invalid state. */");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int read_raw_varint64(unsigned long long *tag, void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("short shift = 0;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("signed char b;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("*tag = 0;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while (shift < 64) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("offset = read_raw_byte((char *)&b, _buffer, offset);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("*tag |= (unsigned long long)(b & 0x7F) << shift;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if ((b & 0x80) == 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("shift += 7;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* return error code. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return -1;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int can_read_raw_varint32(void *_buffer, int offset, int length) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("signed char c;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* Bound length to valid range [0..5]. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (length < 0) length = 0; else");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (length > 5) length = 5;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while (length > 0) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("offset = read_raw_byte((char *)&c, _buffer, offset);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (c >= 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return 1; /* Can read (1 == true). */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("length--;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return 0; /* Cannot read (0 == false). */");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int can_read_raw_varint64(void *_buffer, int offset, int length) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("signed char c;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* Bound length to valid range [0..5]. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (length < 0) length = 0; else");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (length > 10) length = 10;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while (length > 0) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("offset = read_raw_byte((char *)&c, _buffer, offset);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (c >= 0) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return 1; /* Can read (1 == true). */");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("length--;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return 0; /* Cannot read (0 == false). */");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int Message_can_read_delimited_from(void *_buffer, int offset, unsigned int length) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("unsigned long size;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int payload_offset;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (length <= 0) return 0; /* Cannot read from empty or invalid message. */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (!can_read_raw_varint32(_buffer, offset, length)) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return 0; /* Could not even read the preceding size as varint32. */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("payload_offset = read_raw_varint32(&size, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("length = length - (payload_offset - offset);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (length >= size) ? 1 : 0;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("unsigned long Message_get_delimited_size(void *_buffer, int offset) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("unsigned long size = 0;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int old_offset = offset;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = read_raw_varint32(&size, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return size + offset - old_offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<CommonTree> _childTrees = TreeUtils.childTrees(tree);
      final Function1<CommonTree,Boolean> _function = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == ProtoParser.ENUM);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter = IterableExtensions.<CommonTree>filter(_childTrees, _function);
      for(final CommonTree e : _filter) {
        _builder.append("/*******************************************************************");
        _builder.newLine();
        _builder.append("* Enumeration: ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(name);
        _builder.append(_firstUpper_1, "");
        _builder.append(".proto, line ");
        int _line = e.getLine();
        _builder.append(_line, "");
        _builder.newLineIfNotEmpty();
        _builder.append("*******************************************************************/");
        _builder.newLine();
        CharSequence _enumImplementation = this.getEnumImplementation(e);
        _builder.append(_enumImplementation, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      List<CommonTree> _childTrees_1 = TreeUtils.childTrees(tree);
      final Function1<CommonTree,Boolean> _function_1 = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == ProtoParser.MESSAGE);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter_1 = IterableExtensions.<CommonTree>filter(_childTrees_1, _function_1);
      for(final CommonTree m : _filter_1) {
        _builder.append("/*******************************************************************");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Message: ");
        String _firstUpper_2 = StringExtensions.toFirstUpper(name);
        _builder.append(_firstUpper_2, " ");
        _builder.append(".proto, line ");
        int _line_1 = m.getLine();
        _builder.append(_line_1, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*******************************************************************/");
        _builder.newLine();
        _builder.newLine();
        _builder.append("void ");
        String _messageName = this.getMessageName(m);
        _builder.append(_messageName, "");
        _builder.append("_clear(struct ");
        String _messageName_1 = this.getMessageName(m);
        _builder.append(_messageName_1, "");
        _builder.append(" *_");
        String _messageName_2 = this.getMessageName(m);
        _builder.append(_messageName_2, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("_memset(_");
        String _messageName_3 = this.getMessageName(m);
        _builder.append(_messageName_3, "	");
        _builder.append(", 0, sizeof(struct ");
        String _messageName_4 = this.getMessageName(m);
        _builder.append(_messageName_4, "	");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("void ");
        String _messageName_5 = this.getMessageName(m);
        _builder.append(_messageName_5, "");
        _builder.append("_init_optional_attributes(struct ");
        String _messageName_6 = this.getMessageName(m);
        _builder.append(_messageName_6, "");
        _builder.append(" *_");
        String _messageName_7 = this.getMessageName(m);
        _builder.append(_messageName_7, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _initOptionalAttributes = this.initOptionalAttributes(m);
        _builder.append(_initOptionalAttributes, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_8 = this.getMessageName(m);
        _builder.append(_messageName_8, "");
        _builder.append("_is_default_message(struct ");
        String _messageName_9 = this.getMessageName(m);
        _builder.append(_messageName_9, "");
        _builder.append(" *_");
        String _messageName_10 = this.getMessageName(m);
        _builder.append(_messageName_10, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("return ");
        String _isDefaultMessage = this.isDefaultMessage(m);
        _builder.append(_isDefaultMessage, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_11 = this.getMessageName(m);
        _builder.append(_messageName_11, "");
        _builder.append("_write(struct ");
        String _messageName_12 = this.getMessageName(m);
        _builder.append(_messageName_12, "");
        _builder.append(" *_");
        String _messageName_13 = this.getMessageName(m);
        _builder.append(_messageName_13, "");
        _builder.append(", void *_buffer, int offset) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        StringBuilder _writeMessage = this.writeMessage(m);
        _builder.append(_writeMessage, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_14 = this.getMessageName(m);
        _builder.append(_messageName_14, "");
        _builder.append("_write_with_tag(struct ");
        String _messageName_15 = this.getMessageName(m);
        _builder.append(_messageName_15, "");
        _builder.append(" *_");
        String _messageName_16 = this.getMessageName(m);
        _builder.append(_messageName_16, "");
        _builder.append(", void *_buffer, int offset, int tag) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        StringBuilder _writeWithTag = this.writeWithTag(m);
        _builder.append(_writeWithTag, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_17 = this.getMessageName(m);
        _builder.append(_messageName_17, "");
        _builder.append("_write_delimited_to(struct ");
        String _messageName_18 = this.getMessageName(m);
        _builder.append(_messageName_18, "");
        _builder.append(" *_");
        String _messageName_19 = this.getMessageName(m);
        _builder.append(_messageName_19, "");
        _builder.append(", void *_buffer, int offset) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        StringBuilder _writeDelimitedTo = this.writeDelimitedTo(m);
        _builder.append(_writeDelimitedTo, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_20 = this.getMessageName(m);
        _builder.append(_messageName_20, "");
        _builder.append("_read(void *_buffer, struct ");
        String _messageName_21 = this.getMessageName(m);
        _builder.append(_messageName_21, "");
        _builder.append(" *_");
        String _messageName_22 = this.getMessageName(m);
        _builder.append(_messageName_22, "");
        _builder.append(", int offset, int limit) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        StringBuilder _readMessage = this.readMessage(m);
        _builder.append(_readMessage, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("int ");
        String _messageName_23 = this.getMessageName(m);
        _builder.append(_messageName_23, "");
        _builder.append("_read_delimited_from(void *_buffer, struct ");
        String _messageName_24 = this.getMessageName(m);
        _builder.append(_messageName_24, "");
        _builder.append(" *_");
        String _messageName_25 = this.getMessageName(m);
        _builder.append(_messageName_25, "");
        _builder.append(", int offset) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _readDelimitedFrom = this.readDelimitedFrom(m);
        _builder.append(_readDelimitedFrom, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence readDelimitedFrom(final CommonTree m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("unsigned long size;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("offset = read_raw_varint32(&size, _buffer, offset);");
    _builder.newLine();
    Tree _child = m.getChild(0);
    String _text = _child.getText();
    _builder.append(_text, "");
    _builder.append("_read(_buffer, _");
    Tree _child_1 = m.getChild(0);
    String _text_1 = _child_1.getText();
    _builder.append(_text_1, "");
    _builder.append(", offset, size + offset);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("return offset + size;");
    _builder.newLine();
    return _builder;
  }
  
  public StringBuilder readMessage(final CommonTree m) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder assignment = _stringBuilder;
      Tree _child = m.getChild(0);
      final CommonTree curMessage = ((CommonTree) _child);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("unsigned int i = 0;");
      _builder.newLine();
      _builder.append("unsigned long long value = i;");
      _builder.newLine();
      _builder.append("unsigned long tag = value;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* Reset all attributes to 0 in advance. */");
      _builder.newLine();
      String _text = curMessage.getText();
      _builder.append(_text, "");
      _builder.append("_clear(_");
      String _text_1 = curMessage.getText();
      _builder.append(_text_1, "");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("/* Assign the optional attributes. */");
      _builder.newLine();
      String _text_2 = curMessage.getText();
      _builder.append(_text_2, "");
      _builder.append("_init_optional_attributes(_");
      String _text_3 = curMessage.getText();
      _builder.append(_text_3, "");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Read/interpret all attributes from buffer offset until upper limit is reached. */");
      _builder.newLine();
      _builder.append("while(offset < limit) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("offset = read_raw_varint32(&tag, _buffer, offset);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("tag = tag>>3;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("switch(tag){");
      _builder.newLine();
      {
        List<CommonTree> _childTrees = TreeUtils.childTrees(m);
        Iterable<CommonTree> _tail = IterableExtensions.<CommonTree>tail(_childTrees);
        for(final CommonTree attr : _tail) {
          _builder.append("        ");
          CharSequence _caseElementTag = this.caseElementTag(attr, curMessage);
          _builder.append(_caseElementTag, "        ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("return offset;");
      _builder.newLine();
      StringBuilder _append = assignment.append(_builder.toString());
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public CharSequence caseElementTag(final CommonTree attr, final CommonTree parent) {
    CharSequence _xblockexpression = null;
    {
      List _children = attr.getChildren();
      Object _get = _children.get(3);
      final CommonTree tag = ((CommonTree) _get);
      List _children_1 = attr.getChildren();
      Object _get_1 = _children_1.get(2);
      final CommonTree attrName = ((CommonTree) _get_1);
      List _children_2 = attr.getChildren();
      Object _get_2 = _children_2.get(1);
      final CommonTree type = ((CommonTree) _get_2);
      List _children_3 = attr.getChildren();
      Object _get_3 = _children_3.get(0);
      final CommonTree modifier = ((CommonTree) _get_3);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* tag of: _");
      String _text = parent.getText();
      _builder.append(_text, "");
      _builder.append("._");
      String _text_1 = attrName.getText();
      _builder.append(_text_1, "");
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _builder.append("case ");
      _builder.append(tag, "");
      _builder.append(" :");
      _builder.newLineIfNotEmpty();
      {
        boolean _or = false;
        boolean _or_1 = false;
        boolean _or_2 = false;
        boolean _or_3 = false;
        String _text_2 = type.getText();
        boolean _equals = _text_2.equals("int32");
        if (_equals) {
          _or_3 = true;
        } else {
          String _text_3 = type.getText();
          boolean _equals_1 = _text_3.equals("sint32");
          _or_3 = (_equals || _equals_1);
        }
        if (_or_3) {
          _or_2 = true;
        } else {
          String _text_4 = type.getText();
          boolean _equals_2 = _text_4.equals("uint32");
          _or_2 = (_or_3 || _equals_2);
        }
        if (_or_2) {
          _or_1 = true;
        } else {
          String _text_5 = type.getText();
          boolean _equals_3 = _text_5.equals("bool");
          _or_1 = (_or_2 || _equals_3);
        }
        if (_or_1) {
          _or = true;
        } else {
          String _text_6 = type.getText();
          boolean _contains = this.enumSet.contains(_text_6);
          _or = (_or_1 || _contains);
        }
        if (_or) {
          _builder.append("\t");
          _builder.append("offset = read_raw_varint32(&tag, _buffer, offset);");
          _builder.newLine();
        } else {
          boolean _or_4 = false;
          String _text_7 = type.getText();
          boolean _equals_4 = _text_7.equals("string");
          if (_equals_4) {
            _or_4 = true;
          } else {
            String _text_8 = type.getText();
            boolean _equals_5 = _text_8.equals("bytes");
            _or_4 = (_equals_4 || _equals_5);
          }
          if (_or_4) {
            _builder.append("\t");
            _builder.append("/* Re-use \'tag\' to store string length. */");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("offset = read_raw_varint32(&tag, _buffer, offset);");
            _builder.newLine();
          } else {
            boolean _or_5 = false;
            boolean _or_6 = false;
            String _text_9 = type.getText();
            boolean _equals_6 = _text_9.equals("int64");
            if (_equals_6) {
              _or_6 = true;
            } else {
              String _text_10 = type.getText();
              boolean _equals_7 = _text_10.equals("uint64");
              _or_6 = (_equals_6 || _equals_7);
            }
            if (_or_6) {
              _or_5 = true;
            } else {
              String _text_11 = type.getText();
              boolean _equals_8 = _text_11.equals("sint64");
              _or_5 = (_or_6 || _equals_8);
            }
            if (_or_5) {
              _builder.append("\t");
              _builder.append("offset = read_raw_varint64(&value, _buffer, offset);");
              _builder.newLine();
            } else {
              boolean _or_7 = false;
              String _text_12 = type.getText();
              boolean _equals_9 = _text_12.equals("fixed32");
              if (_equals_9) {
                _or_7 = true;
              } else {
                String _text_13 = type.getText();
                boolean _equals_10 = _text_13.equals("sfixed32");
                _or_7 = (_equals_9 || _equals_10);
              }
              if (_or_7) {
                _builder.append("\t");
                _builder.append("offset = read_raw_little_endian32(&tag, _buffer, offset);");
                _builder.newLine();
              } else {
                boolean _or_8 = false;
                String _text_14 = type.getText();
                boolean _equals_11 = _text_14.equals("fixed64");
                if (_equals_11) {
                  _or_8 = true;
                } else {
                  String _text_15 = type.getText();
                  boolean _equals_12 = _text_15.equals("sfixed64");
                  _or_8 = (_equals_11 || _equals_12);
                }
                if (_or_8) {
                  _builder.append("\t");
                  _builder.append("offset = read_raw_little_endian64(&value, _buffer, offset);");
                  _builder.newLine();
                } else {
                  String _text_16 = type.getText();
                  boolean _equals_13 = _text_16.equals("float");
                  if (_equals_13) {
                    _builder.append("\t");
                    _builder.append("offset = read_raw_little_endian32(&tag, _buffer, offset);");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("float *");
                    String _text_17 = attrName.getText();
                    _builder.append(_text_17, "	");
                    _builder.append(" = (float *)(&tag);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    String _text_18 = type.getText();
                    boolean _equals_14 = _text_18.equals("double");
                    if (_equals_14) {
                      _builder.append("\t");
                      _builder.append("offset = read_raw_little_endian64(&value, _buffer, offset);");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("double *");
                      String _text_19 = attrName.getText();
                      _builder.append(_text_19, "	");
                      _builder.append(" = (double *)(&value);");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      {
        String _text_20 = type.getText();
        boolean _containsKey = this.readValues.containsKey(_text_20);
        if (_containsKey) {
          {
            String _text_21 = modifier.getText();
            boolean _equals_15 = _text_21.equals("repeated");
            if (_equals_15) {
              _builder.append("\t");
              _builder.append("_");
              String _text_22 = parent.getText();
              _builder.append(_text_22, "	");
              _builder.append("->_");
              String _text_23 = attrName.getText();
              _builder.append(_text_23, "	");
              _builder.append("[(int)_");
              String _text_24 = parent.getText();
              _builder.append(_text_24, "	");
              _builder.append("->_");
              String _text_25 = attrName.getText();
              _builder.append(_text_25, "	");
              _builder.append("_repeated_len++] = ");
              String _text_26 = type.getText();
              String _get_4 = this.readValues.get(_text_26);
              _builder.append(_get_4, "	");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("_");
              String _text_27 = parent.getText();
              _builder.append(_text_27, "	");
              _builder.append("->_");
              String _text_28 = attrName.getText();
              _builder.append(_text_28, "	");
              _builder.append(" = ");
              String _text_29 = type.getText();
              String _get_5 = this.readValues.get(_text_29);
              _builder.append(_get_5, "	");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          boolean _or_9 = false;
          String _text_30 = type.getText();
          boolean _equals_16 = _text_30.equals("string");
          if (_equals_16) {
            _or_9 = true;
          } else {
            String _text_31 = type.getText();
            boolean _equals_17 = _text_31.equals("bytes");
            _or_9 = (_equals_16 || _equals_17);
          }
          if (_or_9) {
            {
              String _text_32 = modifier.getText();
              boolean _equals_18 = _text_32.equals("repeated");
              if (_equals_18) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("/* Set length of current string. */");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("_");
                String _text_33 = parent.getText();
                _builder.append(_text_33, "	");
                _builder.append("->_");
                String _text_34 = attrName.getText();
                _builder.append(_text_34, "	");
                _builder.append("_len[(int)_");
                String _text_35 = parent.getText();
                _builder.append(_text_35, "	");
                _builder.append("->_");
                String _text_36 = attrName.getText();
                _builder.append(_text_36, "	");
                _builder.append("_repeated_len] = tag;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("/* Copy raw bytes of current string. */");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("for(i = 0; i < tag; ++ i) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("    ");
                _builder.append("offset = read_raw_byte(&_");
                String _text_37 = parent.getText();
                _builder.append(_text_37, "	    ");
                _builder.append("->_");
                String _text_38 = attrName.getText();
                _builder.append(_text_38, "	    ");
                _builder.append("[(int)_");
                String _text_39 = parent.getText();
                _builder.append(_text_39, "	    ");
                _builder.append("->_");
                String _text_40 = attrName.getText();
                _builder.append(_text_40, "	    ");
                _builder.append("_repeated_len][i], _buffer, offset);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("/* Advance to next string. */");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("_");
                String _text_41 = parent.getText();
                _builder.append(_text_41, "	");
                _builder.append("->_");
                String _text_42 = attrName.getText();
                _builder.append(_text_42, "	");
                _builder.append("_repeated_len++; ");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("_");
                String _text_43 = parent.getText();
                _builder.append(_text_43, "	");
                _builder.append("->_");
                String _text_44 = attrName.getText();
                _builder.append(_text_44, "	");
                _builder.append("_len = tag;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("for(i = 0; i < tag; ++ i) ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("    ");
                _builder.append("offset = read_raw_byte((_");
                String _text_45 = parent.getText();
                _builder.append(_text_45, "	    ");
                _builder.append("->_");
                String _text_46 = attrName.getText();
                _builder.append(_text_46, "	    ");
                _builder.append(" + i), _buffer, offset);");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            boolean _or_10 = false;
            String _text_47 = type.getText();
            boolean _equals_19 = _text_47.equals("float");
            if (_equals_19) {
              _or_10 = true;
            } else {
              String _text_48 = type.getText();
              boolean _equals_20 = _text_48.equals("double");
              _or_10 = (_equals_19 || _equals_20);
            }
            if (_or_10) {
              {
                String _text_49 = modifier.getText();
                boolean _equals_21 = _text_49.equals("repeated");
                if (_equals_21) {
                  _builder.append("\t");
                  _builder.append("_");
                  String _text_50 = parent.getText();
                  _builder.append(_text_50, "	");
                  _builder.append("->_");
                  String _text_51 = attrName.getText();
                  _builder.append(_text_51, "	");
                  _builder.append("[(int)_");
                  String _text_52 = parent.getText();
                  _builder.append(_text_52, "	");
                  _builder.append("->_");
                  String _text_53 = attrName.getText();
                  _builder.append(_text_53, "	");
                  _builder.append("_repeated_len++] = *");
                  String _text_54 = attrName.getText();
                  _builder.append(_text_54, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t");
                  _builder.append("_");
                  String _text_55 = parent.getText();
                  _builder.append(_text_55, "	");
                  _builder.append("->_");
                  String _text_56 = attrName.getText();
                  _builder.append(_text_56, "	");
                  _builder.append(" = *");
                  String _text_57 = attrName.getText();
                  _builder.append(_text_57, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              String _text_58 = type.getText();
              boolean _contains_1 = this.enumSet.contains(_text_58);
              if (_contains_1) {
                {
                  String _text_59 = modifier.getText();
                  boolean _equals_22 = _text_59.equals("repeated");
                  if (_equals_22) {
                    _builder.append("\t");
                    _builder.append("_");
                    String _text_60 = parent.getText();
                    _builder.append(_text_60, "	");
                    _builder.append("->_");
                    String _text_61 = attrName.getText();
                    _builder.append(_text_61, "	");
                    _builder.append("[(int)_");
                    String _text_62 = parent.getText();
                    _builder.append(_text_62, "	");
                    _builder.append("->_");
                    String _text_63 = attrName.getText();
                    _builder.append(_text_63, "	");
                    _builder.append("_repeated_len++] = tag;");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("_");
                    String _text_64 = parent.getText();
                    _builder.append(_text_64, "	");
                    _builder.append("->_");
                    String _text_65 = attrName.getText();
                    _builder.append(_text_65, "	");
                    _builder.append(" = tag;");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                {
                  String _text_66 = modifier.getText();
                  boolean _equals_23 = _text_66.equals("repeated");
                  if (_equals_23) {
                    _builder.append("\t");
                    _builder.append("offset = ");
                    String _text_67 = type.getText();
                    _builder.append(_text_67, "	");
                    _builder.append("_read_delimited_from(_buffer, &_");
                    String _text_68 = parent.getText();
                    _builder.append(_text_68, "	");
                    _builder.append("->_");
                    String _text_69 = attrName.getText();
                    _builder.append(_text_69, "	");
                    _builder.append("[(int)_");
                    String _text_70 = parent.getText();
                    _builder.append(_text_70, "	");
                    _builder.append("->_");
                    String _text_71 = attrName.getText();
                    _builder.append(_text_71, "	");
                    _builder.append("_repeated_len++], offset);");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("offset = ");
                    String _text_72 = type.getText();
                    _builder.append(_text_72, "	");
                    _builder.append("_read_delimited_from(_buffer, &_");
                    String _text_73 = parent.getText();
                    _builder.append(_text_73, "	");
                    _builder.append("->_");
                    String _text_74 = attrName.getText();
                    _builder.append(_text_74, "	");
                    _builder.append(", offset);");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("break;");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeDelimitedTo(final CommonTree m) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder assignment = _stringBuilder;
      Tree _child = m.getChild(0);
      final CommonTree curMessage = ((CommonTree) _child);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int i, shift, new_offset, size;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("new_offset = ");
      String _text = curMessage.getText();
      _builder.append(_text, "");
      _builder.append("_write(_");
      String _text_1 = curMessage.getText();
      _builder.append(_text_1, "");
      _builder.append(", _buffer, offset);");
      _builder.newLineIfNotEmpty();
      _builder.append("size = new_offset - offset;");
      _builder.newLine();
      _builder.append("shift = (size > 127) ? 2 : 1;");
      _builder.newLine();
      _builder.append("for (i = new_offset - 1; i >= offset; -- i)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("*((char *)_buffer + i + shift) = *((char *)_buffer + i);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("write_raw_varint32((unsigned long) size, _buffer, offset);         ");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("return new_offset + shift;");
      _builder.newLine();
      StringBuilder _append = assignment.append(_builder.toString());
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeWithTag(final CommonTree m) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder assignment = _stringBuilder;
      Tree _child = m.getChild(0);
      final CommonTree curMessage = ((CommonTree) _child);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* Write tag.*/");
      _builder.newLine();
      _builder.append("offset = write_raw_varint32((tag<<3)+2, _buffer, offset);");
      _builder.newLine();
      _builder.append("/* Write content.*/");
      _builder.newLine();
      _builder.append("offset = ");
      String _text = curMessage.getText();
      _builder.append(_text, "");
      _builder.append("_write_delimited_to(_");
      String _text_1 = curMessage.getText();
      _builder.append(_text_1, "");
      _builder.append(", _buffer, offset);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("return offset;");
      _builder.newLine();
      StringBuilder _append = assignment.append(_builder.toString());
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeMessage(final CommonTree m) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder assignment = _stringBuilder;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* Write content of each message element.*/");
      _builder.newLine();
      assignment.append(_builder.toString());
      Tree _child = m.getChild(0);
      final CommonTree curMessage = ((CommonTree) _child);
      List<CommonTree> _childTrees = TreeUtils.childTrees(m);
      Iterable<CommonTree> _tail = IterableExtensions.<CommonTree>tail(_childTrees);
      for (final CommonTree attr : _tail) {
        {
          List _children = attr.getChildren();
          Object _get = _children.get(0);
          final CommonTree modifier = ((CommonTree) _get);
          List _children_1 = attr.getChildren();
          Object _get_1 = _children_1.get(1);
          final CommonTree type = ((CommonTree) _get_1);
          List _children_2 = attr.getChildren();
          Object _get_2 = _children_2.get(2);
          final CommonTree attrName = ((CommonTree) _get_2);
          List _children_3 = attr.getChildren();
          Object _get_3 = _children_3.get(3);
          final CommonTree tag = ((CommonTree) _get_3);
          String defaultValue = "0";
          int _childCount = attr.getChildCount();
          boolean _greaterEqualsThan = (_childCount >= 5);
          if (_greaterEqualsThan) {
            List _children_4 = attr.getChildren();
            Object _get_4 = _children_4.get(4);
            String _text = ((CommonTree) _get_4).getText();
            defaultValue = _text;
            String _lowerCase = defaultValue.toLowerCase();
            boolean _equals = _lowerCase.equals("true");
            if (_equals) {
              defaultValue = "1";
            }
            String _lowerCase_1 = defaultValue.toLowerCase();
            boolean _equals_1 = _lowerCase_1.equals("false");
            if (_equals_1) {
              defaultValue = "0";
            }
            String _text_1 = type.getText();
            boolean _contains = this.enumSet.contains(_text_1);
            if (_contains) {
              String _plus = ("_" + defaultValue);
              defaultValue = _plus;
            }
          } else {
            boolean _containsKey = this.arrayTypes.containsKey(type);
            if (_containsKey) {
              defaultValue = "";
            }
          }
          String _text_2 = modifier.getText();
          boolean _equals_2 = _text_2.equals("repeated");
          if (_equals_2) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("int ");
            String _text_3 = attrName.getText();
            _builder_1.append(_text_3, "");
            _builder_1.append("_cnt;");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("for (");
            String _text_4 = attrName.getText();
            _builder_1.append(_text_4, "");
            _builder_1.append("_cnt = 0; ");
            String _text_5 = attrName.getText();
            _builder_1.append(_text_5, "");
            _builder_1.append("_cnt < _");
            String _text_6 = curMessage.getText();
            _builder_1.append(_text_6, "");
            _builder_1.append("->_");
            String _text_7 = attrName.getText();
            _builder_1.append(_text_7, "");
            _builder_1.append("_repeated_len; ++ ");
            String _text_8 = attrName.getText();
            _builder_1.append(_text_8, "");
            _builder_1.append("_cnt) {");
            _builder_1.newLineIfNotEmpty();
            {
              String _text_9 = type.getText();
              boolean _contains_1 = this.enumSet.contains(_text_9);
              boolean _not = (!_contains_1);
              if (_not) {
                _builder_1.append("    ");
                CharSequence _writeTag = this.writeTag(type, tag);
                _builder_1.append(_writeTag, "    ");
                _builder_1.newLineIfNotEmpty();
              }
            }
            _builder_1.append("    ");
            String _text_10 = attrName.getText();
            String _plus_1 = ("[" + _text_10);
            String _plus_2 = (_plus_1 + "_cnt]");
            CharSequence _writeTypeNoTag = this.writeTypeNoTag(attr, curMessage, _plus_2);
            _builder_1.append(_writeTypeNoTag, "    ");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("}");
            _builder_1.newLine();
            _builder_1.newLine();
            assignment.append(_builder_1.toString());
          } else {
            String _text_11 = modifier.getText();
            boolean _equals_3 = _text_11.equals("optional");
            if (_equals_3) {
              String arrayConditions = "";
              String _text_12 = type.getText();
              boolean _containsKey_1 = this.arrayTypes.containsKey(_text_12);
              if (_containsKey_1) {
                int i = 0;
                int _length = defaultValue.length();
                boolean _lessThan = (i < _length);
                boolean _while = _lessThan;
                while (_while) {
                  {
                    String _plus_3 = (arrayConditions + "\n    || _");
                    String _text_13 = curMessage.getText();
                    String _plus_4 = (_plus_3 + _text_13);
                    String _plus_5 = (_plus_4 + "->_");
                    String _text_14 = attrName.getText();
                    String _plus_6 = (_plus_5 + _text_14);
                    String _plus_7 = (_plus_6 + "[");
                    String _plus_8 = (_plus_7 + Integer.valueOf(i));
                    String _plus_9 = (_plus_8 + "]");
                    String _plus_10 = (_plus_9 + " != ");
                    String _plus_11 = (_plus_10 + "\'");
                    char _charAt = defaultValue.charAt(i);
                    String _plus_12 = (_plus_11 + Character.valueOf(_charAt));
                    String _plus_13 = (_plus_12 + "\'");
                    arrayConditions = _plus_13;
                    int _plus_14 = (i + 1);
                    i = _plus_14;
                  }
                  int _length_1 = defaultValue.length();
                  boolean _lessThan_1 = (i < _length_1);
                  _while = _lessThan_1;
                }
              }
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("/* Write the optional attribute only if it is different than the default value. */");
              _builder_2.newLine();
              {
                boolean _or = false;
                String _text_13 = type.getText();
                boolean _containsKey_2 = this.typeMap.containsKey(_text_13);
                if (_containsKey_2) {
                  _or = true;
                } else {
                  String _text_14 = type.getText();
                  boolean _contains_2 = this.enumSet.contains(_text_14);
                  _or = (_containsKey_2 || _contains_2);
                }
                if (_or) {
                  {
                    String _text_15 = type.getText();
                    boolean _containsKey_3 = this.arrayTypes.containsKey(_text_15);
                    if (_containsKey_3) {
                      _builder_2.append("if(_");
                      String _text_16 = curMessage.getText();
                      _builder_2.append(_text_16, "");
                      _builder_2.append("->_");
                      String _text_17 = attrName.getText();
                      _builder_2.append(_text_17, "");
                      _builder_2.append("_len != ");
                      int _length_1 = defaultValue.length();
                      _builder_2.append(_length_1, "");
                      _builder_2.append(arrayConditions, "");
                      _builder_2.append(") {");
                      _builder_2.newLineIfNotEmpty();
                    } else {
                      _builder_2.append("if(_");
                      String _text_18 = curMessage.getText();
                      _builder_2.append(_text_18, "");
                      _builder_2.append("->_");
                      String _text_19 = attrName.getText();
                      _builder_2.append(_text_19, "");
                      _builder_2.append(" != ");
                      _builder_2.append(defaultValue, "");
                      _builder_2.append(") {");
                      _builder_2.newLineIfNotEmpty();
                    }
                  }
                } else {
                  _builder_2.append("if(!");
                  String _text_20 = type.getText();
                  _builder_2.append(_text_20, "");
                  _builder_2.append("_is_default_message(&_");
                  String _text_21 = curMessage.getText();
                  _builder_2.append(_text_21, "");
                  _builder_2.append("->_");
                  _builder_2.append(attrName, "");
                  _builder_2.append(")) {");
                  _builder_2.newLineIfNotEmpty();
                }
              }
              {
                boolean _and = false;
                String _text_22 = type.getText();
                boolean _contains_3 = this.enumSet.contains(_text_22);
                boolean _not_1 = (!_contains_3);
                if (!_not_1) {
                  _and = false;
                } else {
                  String _text_23 = type.getText();
                  boolean _containsKey_4 = this.typeMap.containsKey(_text_23);
                  _and = (_not_1 && _containsKey_4);
                }
                if (_and) {
                  _builder_2.append("\t");
                  CharSequence _writeTag_1 = this.writeTag(type, tag);
                  _builder_2.append(_writeTag_1, "	");
                  _builder_2.newLineIfNotEmpty();
                }
              }
              _builder_2.append("    ");
              CharSequence _writeTypeNoTag_1 = this.writeTypeNoTag(attr, curMessage, "");
              _builder_2.append(_writeTypeNoTag_1, "    ");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("}");
              _builder_2.newLine();
              _builder_2.newLine();
              assignment.append(_builder_2.toString());
            } else {
              StringConcatenation _builder_3 = new StringConcatenation();
              {
                boolean _and_1 = false;
                String _text_24 = type.getText();
                boolean _contains_4 = this.enumSet.contains(_text_24);
                boolean _not_2 = (!_contains_4);
                if (!_not_2) {
                  _and_1 = false;
                } else {
                  String _text_25 = type.getText();
                  boolean _containsKey_5 = this.typeMap.containsKey(_text_25);
                  _and_1 = (_not_2 && _containsKey_5);
                }
                if (_and_1) {
                  CharSequence _writeTag_2 = this.writeTag(type, tag);
                  _builder_3.append(_writeTag_2, "");
                  _builder_3.newLineIfNotEmpty();
                }
              }
              CharSequence _writeTypeNoTag_2 = this.writeTypeNoTag(attr, curMessage, "");
              _builder_3.append(_writeTypeNoTag_2, "");
              _builder_3.newLineIfNotEmpty();
              _builder_3.newLine();
              assignment.append(_builder_3.toString());
            }
          }
        }
      }
      StringBuilder _append = assignment.append("return offset;\n");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  public CharSequence writeTypeNoTag(final CommonTree attr, final CommonTree curMessage, final String arrayPart) {
    CharSequence _xblockexpression = null;
    {
      List _children = attr.getChildren();
      Object _get = _children.get(1);
      final CommonTree type = ((CommonTree) _get);
      List _children_1 = attr.getChildren();
      Object _get_1 = _children_1.get(2);
      final CommonTree attrName = ((CommonTree) _get_1);
      List _children_2 = attr.getChildren();
      Object _get_2 = _children_2.get(3);
      final CommonTree tag = ((CommonTree) _get_2);
      CharSequence _xifexpression = null;
      String _text = type.getText();
      boolean _equals = _text.equals("int32");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("if (_");
        String _text_1 = curMessage.getText();
        _builder.append(_text_1, "");
        _builder.append("->_");
        String _text_2 = attrName.getText();
        String _plus = (_text_2 + arrayPart);
        _builder.append(_plus, "");
        _builder.append(" >= 0)");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("offset = write_raw_varint32(_");
        String _text_3 = curMessage.getText();
        _builder.append(_text_3, "    ");
        _builder.append("->_");
        String _text_4 = attrName.getText();
        String _plus_1 = (_text_4 + arrayPart);
        _builder.append(_plus_1, "    ");
        _builder.append(", _buffer, offset);");
        _builder.newLineIfNotEmpty();
        _builder.append("else");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("offset = write_raw_varint64(_");
        String _text_5 = curMessage.getText();
        _builder.append(_text_5, "    ");
        _builder.append("->_");
        String _text_6 = attrName.getText();
        String _plus_2 = (_text_6 + arrayPart);
        _builder.append(_plus_2, "    ");
        _builder.append(", _buffer, offset);\t    ");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _or = false;
        String _text_7 = type.getText();
        boolean _equals_1 = _text_7.equals("int64");
        if (_equals_1) {
          _or = true;
        } else {
          String _text_8 = type.getText();
          boolean _equals_2 = _text_8.equals("uint64");
          _or = (_equals_1 || _equals_2);
        }
        if (_or) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("offset = write_raw_varint64(_");
          String _text_9 = curMessage.getText();
          _builder_1.append(_text_9, "");
          _builder_1.append("->_");
          String _text_10 = attrName.getText();
          String _plus_3 = (_text_10 + arrayPart);
          _builder_1.append(_plus_3, "");
          _builder_1.append(", _buffer, offset);");
          _xifexpression_1 = _builder_1;
        } else {
          CharSequence _xifexpression_2 = null;
          String _text_11 = type.getText();
          boolean _equals_3 = _text_11.equals("sint32");
          if (_equals_3) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("offset = write_raw_varint32(encode_zig_zag32(_");
            String _text_12 = curMessage.getText();
            _builder_2.append(_text_12, "");
            _builder_2.append("->_");
            String _text_13 = attrName.getText();
            String _plus_4 = (_text_13 + arrayPart);
            _builder_2.append(_plus_4, "");
            _builder_2.append("), _buffer, offset);");
            _xifexpression_2 = _builder_2;
          } else {
            CharSequence _xifexpression_3 = null;
            String _text_14 = type.getText();
            boolean _equals_4 = _text_14.equals("sint64");
            if (_equals_4) {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("offset = write_raw_varint32(encode_zig_zag64(_");
              String _text_15 = curMessage.getText();
              _builder_3.append(_text_15, "");
              _builder_3.append("->_");
              String _text_16 = attrName.getText();
              String _plus_5 = (_text_16 + arrayPart);
              _builder_3.append(_plus_5, "");
              _builder_3.append("), _buffer, offset);");
              _xifexpression_3 = _builder_3;
            } else {
              CharSequence _xifexpression_4 = null;
              String _text_17 = type.getText();
              boolean _equals_5 = _text_17.equals("uint32");
              if (_equals_5) {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("offset = write_raw_varint32(_");
                String _text_18 = curMessage.getText();
                _builder_4.append(_text_18, "");
                _builder_4.append("->_");
                String _text_19 = attrName.getText();
                String _plus_6 = (_text_19 + arrayPart);
                _builder_4.append(_plus_6, "");
                _builder_4.append(", _buffer, offset);");
                _xifexpression_4 = _builder_4;
              } else {
                CharSequence _xifexpression_5 = null;
                boolean _or_1 = false;
                String _text_20 = type.getText();
                boolean _equals_6 = _text_20.equals("fixed32");
                if (_equals_6) {
                  _or_1 = true;
                } else {
                  String _text_21 = type.getText();
                  boolean _equals_7 = _text_21.equals("sfixed32");
                  _or_1 = (_equals_6 || _equals_7);
                }
                if (_or_1) {
                  StringConcatenation _builder_5 = new StringConcatenation();
                  _builder_5.append("offset = write_raw_little_endian32(_");
                  String _text_22 = curMessage.getText();
                  _builder_5.append(_text_22, "");
                  _builder_5.append("->_");
                  String _text_23 = attrName.getText();
                  String _plus_7 = (_text_23 + arrayPart);
                  _builder_5.append(_plus_7, "");
                  _builder_5.append(", _buffer, offset);");
                  _xifexpression_5 = _builder_5;
                } else {
                  CharSequence _xifexpression_6 = null;
                  boolean _or_2 = false;
                  String _text_24 = type.getText();
                  boolean _equals_8 = _text_24.equals("fixed64");
                  if (_equals_8) {
                    _or_2 = true;
                  } else {
                    String _text_25 = type.getText();
                    boolean _equals_9 = _text_25.equals("sfixed64");
                    _or_2 = (_equals_8 || _equals_9);
                  }
                  if (_or_2) {
                    StringConcatenation _builder_6 = new StringConcatenation();
                    _builder_6.append("offset = write_raw_little_endian64(_");
                    String _text_26 = curMessage.getText();
                    _builder_6.append(_text_26, "");
                    _builder_6.append("->_");
                    String _text_27 = attrName.getText();
                    String _plus_8 = (_text_27 + arrayPart);
                    _builder_6.append(_plus_8, "");
                    _builder_6.append(", _buffer, offset);");
                    _xifexpression_6 = _builder_6;
                  } else {
                    CharSequence _xifexpression_7 = null;
                    boolean _or_3 = false;
                    String _text_28 = type.getText();
                    boolean _equals_10 = _text_28.equals("bytes");
                    if (_equals_10) {
                      _or_3 = true;
                    } else {
                      String _text_29 = type.getText();
                      boolean _equals_11 = _text_29.equals("string");
                      _or_3 = (_equals_10 || _equals_11);
                    }
                    if (_or_3) {
                      StringConcatenation _builder_7 = new StringConcatenation();
                      _builder_7.append("offset = write_raw_varint32(_");
                      String _text_30 = curMessage.getText();
                      _builder_7.append(_text_30, "");
                      _builder_7.append("->_");
                      String _text_31 = attrName.getText();
                      _builder_7.append(_text_31, "");
                      _builder_7.append("_len");
                      _builder_7.append(arrayPart, "");
                      _builder_7.append(", _buffer, offset);");
                      _builder_7.newLineIfNotEmpty();
                      _builder_7.append("offset = write_raw_bytes(_");
                      String _text_32 = curMessage.getText();
                      _builder_7.append(_text_32, "");
                      _builder_7.append("->_");
                      String _text_33 = attrName.getText();
                      String _plus_9 = (_text_33 + arrayPart);
                      _builder_7.append(_plus_9, "");
                      _builder_7.append(", _");
                      String _text_34 = curMessage.getText();
                      _builder_7.append(_text_34, "");
                      _builder_7.append("->_");
                      String _text_35 = attrName.getText();
                      _builder_7.append(_text_35, "");
                      _builder_7.append("_len");
                      _builder_7.append(arrayPart, "");
                      _builder_7.append(", _buffer, offset);");
                      _builder_7.newLineIfNotEmpty();
                      _xifexpression_7 = _builder_7;
                    } else {
                      CharSequence _xifexpression_8 = null;
                      String _text_36 = type.getText();
                      boolean _equals_12 = _text_36.equals("bool");
                      if (_equals_12) {
                        StringConcatenation _builder_8 = new StringConcatenation();
                        _builder_8.append("offset = write_raw_byte(_");
                        String _text_37 = curMessage.getText();
                        _builder_8.append(_text_37, "");
                        _builder_8.append("->_");
                        String _text_38 = attrName.getText();
                        String _plus_10 = (_text_38 + arrayPart);
                        _builder_8.append(_plus_10, "");
                        _builder_8.append(", _buffer, offset);");
                        _xifexpression_8 = _builder_8;
                      } else {
                        CharSequence _xifexpression_9 = null;
                        String _text_39 = type.getText();
                        boolean _equals_13 = _text_39.equals("float");
                        if (_equals_13) {
                          StringConcatenation _builder_9 = new StringConcatenation();
                          _builder_9.append("unsigned long *");
                          String _text_40 = attrName.getText();
                          _builder_9.append(_text_40, "");
                          _builder_9.append("_ptr = (unsigned long *)&_");
                          String _text_41 = curMessage.getText();
                          _builder_9.append(_text_41, "");
                          _builder_9.append("->_");
                          String _text_42 = attrName.getText();
                          String _plus_11 = (_text_42 + arrayPart);
                          _builder_9.append(_plus_11, "");
                          _builder_9.append(";");
                          _builder_9.newLineIfNotEmpty();
                          _builder_9.append("offset = write_raw_little_endian32(*");
                          String _text_43 = attrName.getText();
                          _builder_9.append(_text_43, "");
                          _builder_9.append("_ptr, _buffer, offset);");
                          _builder_9.newLineIfNotEmpty();
                          _xifexpression_9 = _builder_9;
                        } else {
                          CharSequence _xifexpression_10 = null;
                          String _text_44 = type.getText();
                          boolean _equals_14 = _text_44.equals("double");
                          if (_equals_14) {
                            StringConcatenation _builder_10 = new StringConcatenation();
                            _builder_10.append("unsigned long long*");
                            String _text_45 = attrName.getText();
                            _builder_10.append(_text_45, "");
                            _builder_10.append("_ptr = (unsigned long long*)&_");
                            String _text_46 = curMessage.getText();
                            _builder_10.append(_text_46, "");
                            _builder_10.append("->_");
                            String _text_47 = attrName.getText();
                            String _plus_12 = (_text_47 + arrayPart);
                            _builder_10.append(_plus_12, "");
                            _builder_10.append(";");
                            _builder_10.newLineIfNotEmpty();
                            _builder_10.append("offset = write_raw_little_endian64(*");
                            String _text_48 = attrName.getText();
                            _builder_10.append(_text_48, "");
                            _builder_10.append("_ptr, _buffer, offset);");
                            _builder_10.newLineIfNotEmpty();
                            _xifexpression_10 = _builder_10;
                          } else {
                            CharSequence _xifexpression_11 = null;
                            boolean _or_4 = false;
                            String _text_49 = type.getText();
                            boolean _contains = this.enumSet.contains(_text_49);
                            if (_contains) {
                              _or_4 = true;
                            } else {
                              String _text_50 = type.getText();
                              boolean _containsKey = this.typeMap.containsKey(_text_50);
                              boolean _not = (!_containsKey);
                              _or_4 = (_contains || _not);
                            }
                            if (_or_4) {
                              StringConcatenation _builder_11 = new StringConcatenation();
                              _builder_11.append("offset = ");
                              String _text_51 = type.getText();
                              _builder_11.append(_text_51, "");
                              _builder_11.append("_write_with_tag(&_");
                              String _text_52 = curMessage.getText();
                              _builder_11.append(_text_52, "");
                              _builder_11.append("->_");
                              String _text_53 = attrName.getText();
                              String _plus_13 = (_text_53 + arrayPart);
                              _builder_11.append(_plus_13, "");
                              _builder_11.append(", _buffer, offset, ");
                              String _text_54 = tag.getText();
                              _builder_11.append(_text_54, "");
                              _builder_11.append(");");
                              _xifexpression_11 = _builder_11;
                            }
                            _xifexpression_10 = _xifexpression_11;
                          }
                          _xifexpression_9 = _xifexpression_10;
                        }
                        _xifexpression_8 = _xifexpression_9;
                      }
                      _xifexpression_7 = _xifexpression_8;
                    }
                    _xifexpression_6 = _xifexpression_7;
                  }
                  _xifexpression_5 = _xifexpression_6;
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CharSequence writeTag(final CommonTree type, final CommonTree tag) {
    CharSequence _xifexpression = null;
    String _text = type.getText();
    boolean _containsKey = this.wireTypeMap.containsKey(_text);
    if (_containsKey) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("offset = write_raw_varint32((");
      String _text_1 = tag.getText();
      _builder.append(_text_1, "");
      _builder.append("<<3)+");
      String _text_2 = type.getText();
      String _get = this.wireTypeMap.get(_text_2);
      _builder.append(_get, "");
      _builder.append(", _buffer, offset);");
      _builder.newLineIfNotEmpty();
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  public String isDefaultMessage(final CommonTree m) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder conditions = _stringBuilder;
      int i = 1;
      List _children = m.getChildren();
      int _size = _children.size();
      boolean _lessThan = (i < _size);
      boolean _while = _lessThan;
      while (_while) {
        {
          List _children_1 = m.getChildren();
          Object _get = _children_1.get(i);
          final CommonTree attr = ((CommonTree) _get);
          List _children_2 = attr.getChildren();
          Object _get_1 = _children_2.get(0);
          final CommonTree modifier = ((CommonTree) _get_1);
          List _children_3 = attr.getChildren();
          Object _get_2 = _children_3.get(1);
          final CommonTree type = ((CommonTree) _get_2);
          List _children_4 = attr.getChildren();
          Object _get_3 = _children_4.get(2);
          final CommonTree attrName = ((CommonTree) _get_3);
          String defaultValue = "0";
          int _childCount = attr.getChildCount();
          boolean _greaterEqualsThan = (_childCount >= 5);
          if (_greaterEqualsThan) {
            List _children_5 = attr.getChildren();
            Object _get_4 = _children_5.get(4);
            String _text = ((CommonTree) _get_4).getText();
            defaultValue = _text;
            String _lowerCase = defaultValue.toLowerCase();
            boolean _equals = _lowerCase.equals("true");
            if (_equals) {
              defaultValue = "1";
            }
            String _lowerCase_1 = defaultValue.toLowerCase();
            boolean _equals_1 = _lowerCase_1.equals("false");
            if (_equals_1) {
              defaultValue = "0";
            }
          }
          String _text_1 = type.getText();
          String cType = this.typeMap.get(_text_1);
          String condition = "";
          boolean _equals_2 = Objects.equal(cType, null);
          if (_equals_2) {
            String _text_2 = type.getText();
            boolean _contains = this.enumSet.contains(_text_2);
            if (_contains) {
              boolean _equals_3 = defaultValue.equals("0");
              boolean _not = (!_equals_3);
              if (_not) {
                String _plus = ("_" + defaultValue);
                defaultValue = _plus;
              }
              String _messageName = this.getMessageName(m);
              String _plus_1 = ("_" + _messageName);
              String _plus_2 = (_plus_1 + "->_");
              String _text_3 = attrName.getText();
              String _plus_3 = (_plus_2 + _text_3);
              String _plus_4 = (_plus_3 + " == ");
              String _plus_5 = (_plus_4 + defaultValue);
              String _plus_6 = (_plus_5 + "\n");
              condition = _plus_6;
            } else {
              String _text_4 = type.getText();
              String _plus_7 = (_text_4 + "_is_default_message(&_");
              String _messageName_1 = this.getMessageName(m);
              String _plus_8 = (_plus_7 + _messageName_1);
              String _plus_9 = (_plus_8 + "->_");
              String _text_5 = attrName.getText();
              String _plus_10 = (_plus_9 + _text_5);
              String _plus_11 = (_plus_10 + ")\n");
              condition = _plus_11;
            }
          } else {
            boolean _or = false;
            boolean _or_1 = false;
            boolean _or_2 = false;
            boolean _or_3 = false;
            boolean _equals_4 = cType.equals("signed long");
            if (_equals_4) {
              _or_3 = true;
            } else {
              boolean _equals_5 = cType.equals("signed long long");
              _or_3 = (_equals_4 || _equals_5);
            }
            if (_or_3) {
              _or_2 = true;
            } else {
              boolean _equals_6 = cType.equals("unsigned long");
              _or_2 = (_or_3 || _equals_6);
            }
            if (_or_2) {
              _or_1 = true;
            } else {
              boolean _equals_7 = cType.equals("unsigned long long");
              _or_1 = (_or_2 || _equals_7);
            }
            if (_or_1) {
              _or = true;
            } else {
              boolean _equals_8 = cType.equals("char");
              _or = (_or_1 || _equals_8);
            }
            if (_or) {
              String _text_6 = type.getText();
              boolean _containsKey = this.arrayTypes.containsKey(_text_6);
              if (_containsKey) {
                int length = 0;
                int _childCount_1 = attr.getChildCount();
                boolean _greaterEqualsThan_1 = (_childCount_1 >= 5);
                if (_greaterEqualsThan_1) {
                  int _length = defaultValue.length();
                  length = _length;
                }
                String _messageName_2 = this.getMessageName(m);
                String _plus_12 = ("_" + _messageName_2);
                String _plus_13 = (_plus_12 + "->_");
                String _text_7 = attrName.getText();
                String _plus_14 = (_plus_13 + _text_7);
                String _plus_15 = (_plus_14 + "_len");
                String _plus_16 = (_plus_15 + " == ");
                String _plus_17 = (_plus_16 + Integer.valueOf(length));
                String _plus_18 = (_plus_17 + "\n");
                condition = _plus_18;
                int j = 0;
                boolean _lessThan_1 = (j < length);
                boolean _while_1 = _lessThan_1;
                while (_while_1) {
                  {
                    String _plus_19 = (condition + " && _");
                    String _messageName_3 = this.getMessageName(m);
                    String _plus_20 = (_plus_19 + _messageName_3);
                    String _plus_21 = (_plus_20 + "->_");
                    String _text_8 = attrName.getText();
                    String _plus_22 = (_plus_21 + _text_8);
                    String _plus_23 = (_plus_22 + "[");
                    String _plus_24 = (_plus_23 + Integer.valueOf(j));
                    String _plus_25 = (_plus_24 + "]");
                    String _plus_26 = (_plus_25 + " == ");
                    String _plus_27 = (_plus_26 + "\'");
                    char _charAt = defaultValue.charAt(j);
                    String _plus_28 = (_plus_27 + Character.valueOf(_charAt));
                    String _plus_29 = (_plus_28 + "\'");
                    String _plus_30 = (_plus_29 + "\n");
                    condition = _plus_30;
                    int _plus_31 = (j + 1);
                    j = _plus_31;
                  }
                  boolean _lessThan_2 = (j < length);
                  _while_1 = _lessThan_2;
                }
              } else {
                String _messageName_3 = this.getMessageName(m);
                String _plus_19 = ("_" + _messageName_3);
                String _plus_20 = (_plus_19 + "->_");
                String _text_8 = attrName.getText();
                String _plus_21 = (_plus_20 + _text_8);
                String _plus_22 = (_plus_21 + " == ");
                String _plus_23 = (_plus_22 + defaultValue);
                String _plus_24 = (_plus_23 + "\n");
                condition = _plus_24;
              }
            }
            boolean _equals_9 = cType.equals("float");
            if (_equals_9) {
              boolean _equals_10 = defaultValue.equals("0");
              if (_equals_10) {
                defaultValue = "0.0f";
              }
              String _messageName_4 = this.getMessageName(m);
              String _plus_25 = ("_" + _messageName_4);
              String _plus_26 = (_plus_25 + "->_");
              String _text_9 = attrName.getText();
              String _plus_27 = (_plus_26 + _text_9);
              String _plus_28 = (_plus_27 + " == 0.0f\n");
              condition = _plus_28;
            }
            boolean _equals_11 = cType.equals("double");
            if (_equals_11) {
              boolean _equals_12 = defaultValue.equals("0");
              if (_equals_12) {
                defaultValue = "0.0";
              }
              String _messageName_5 = this.getMessageName(m);
              String _plus_29 = ("_" + _messageName_5);
              String _plus_30 = (_plus_29 + "->_");
              String _text_10 = attrName.getText();
              String _plus_31 = (_plus_30 + _text_10);
              String _plus_32 = (_plus_31 + " == 0.0\n");
              condition = _plus_32;
            }
          }
          List _children_6 = m.getChildren();
          int _size_1 = _children_6.size();
          int _minus = (_size_1 - 1);
          boolean _lessThan_2 = (i < _minus);
          if (_lessThan_2) {
            String _plus_33 = (condition + "\n && ");
            condition = _plus_33;
          } else {
            String _plus_34 = (condition + ";");
            condition = _plus_34;
          }
          String _text_11 = modifier.getText();
          boolean _equals_13 = _text_11.equals("repeated");
          boolean _not_1 = (!_equals_13);
          if (_not_1) {
            conditions.append(condition);
          }
          int _plus_35 = (i + 1);
          i = _plus_35;
        }
        List _children_1 = m.getChildren();
        int _size_1 = _children_1.size();
        boolean _lessThan_1 = (i < _size_1);
        _while = _lessThan_1;
      }
      String _string = conditions.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String initOptionalAttributes(final CommonTree m) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder assignments = _stringBuilder;
      List<CommonTree> _childTrees = TreeUtils.childTrees(m);
      Iterable<CommonTree> _tail = IterableExtensions.<CommonTree>tail(_childTrees);
      for (final CommonTree attr : _tail) {
        {
          List _children = attr.getChildren();
          Object _get = _children.get(0);
          final CommonTree modifier = ((CommonTree) _get);
          List _children_1 = attr.getChildren();
          Object _get_1 = _children_1.get(1);
          final CommonTree type = ((CommonTree) _get_1);
          List _children_2 = attr.getChildren();
          Object _get_2 = _children_2.get(2);
          final CommonTree attrName = ((CommonTree) _get_2);
          String defaultValue = "0";
          int _childCount = attr.getChildCount();
          boolean _greaterEqualsThan = (_childCount >= 5);
          if (_greaterEqualsThan) {
            List _children_3 = attr.getChildren();
            Object _get_3 = _children_3.get(4);
            String _text = ((CommonTree) _get_3).getText();
            defaultValue = _text;
            String _lowerCase = defaultValue.toLowerCase();
            boolean _equals = _lowerCase.equals("true");
            if (_equals) {
              defaultValue = "1";
            }
            String _lowerCase_1 = defaultValue.toLowerCase();
            boolean _equals_1 = _lowerCase_1.equals("false");
            if (_equals_1) {
              defaultValue = "0";
            }
          }
          String _text_1 = modifier.getText();
          boolean _equals_2 = _text_1.equals("optional");
          if (_equals_2) {
            String _text_2 = type.getText();
            String cType = this.typeMap.get(_text_2);
            String _text_3 = type.getText();
            boolean isArrayType = this.arrayTypes.containsKey(_text_3);
            String assignment = "";
            boolean _equals_3 = Objects.equal(cType, null);
            if (_equals_3) {
              String _text_4 = type.getText();
              boolean _contains = this.enumSet.contains(_text_4);
              if (_contains) {
                boolean _equals_4 = defaultValue.equals("0");
                boolean _not = (!_equals_4);
                if (_not) {
                  String _plus = ("_" + defaultValue);
                  defaultValue = _plus;
                }
                String _messageName = this.getMessageName(m);
                String _plus_1 = ("_" + _messageName);
                String _plus_2 = (_plus_1 + "->_");
                String _text_5 = attrName.getText();
                String _plus_3 = (_plus_2 + _text_5);
                String _plus_4 = (_plus_3 + " = ");
                String _plus_5 = (_plus_4 + defaultValue);
                String _plus_6 = (_plus_5 + ";");
                assignment = _plus_6;
              } else {
                String _text_6 = type.getText();
                String _plus_7 = (_text_6 + "_init_optional_attributes(&_");
                String _messageName_1 = this.getMessageName(m);
                String _plus_8 = (_plus_7 + _messageName_1);
                String _plus_9 = (_plus_8 + "->_");
                String _text_7 = attrName.getText();
                String _plus_10 = (_plus_9 + _text_7);
                String _plus_11 = (_plus_10 + ");");
                assignment = _plus_11;
              }
            } else {
              boolean _or = false;
              boolean _or_1 = false;
              boolean _or_2 = false;
              boolean _or_3 = false;
              boolean _equals_5 = cType.equals("signed long");
              if (_equals_5) {
                _or_3 = true;
              } else {
                boolean _equals_6 = cType.equals("signed long long");
                _or_3 = (_equals_5 || _equals_6);
              }
              if (_or_3) {
                _or_2 = true;
              } else {
                boolean _equals_7 = cType.equals("unsigned long");
                _or_2 = (_or_3 || _equals_7);
              }
              if (_or_2) {
                _or_1 = true;
              } else {
                boolean _equals_8 = cType.equals("unsigned long long");
                _or_1 = (_or_2 || _equals_8);
              }
              if (_or_1) {
                _or = true;
              } else {
                boolean _equals_9 = cType.equals("char");
                _or = (_or_1 || _equals_9);
              }
              if (_or) {
                if (isArrayType) {
                  int length = 0;
                  int _childCount_1 = attr.getChildCount();
                  boolean _greaterEqualsThan_1 = (_childCount_1 >= 5);
                  if (_greaterEqualsThan_1) {
                    int _length = defaultValue.length();
                    length = _length;
                  }
                  String _messageName_2 = this.getMessageName(m);
                  String _plus_12 = ("_" + _messageName_2);
                  String _plus_13 = (_plus_12 + "->_");
                  String _text_8 = attrName.getText();
                  String _plus_14 = (_plus_13 + _text_8);
                  String _plus_15 = (_plus_14 + "_len");
                  String _plus_16 = (_plus_15 + " = ");
                  String _plus_17 = (_plus_16 + Integer.valueOf(length));
                  String _plus_18 = (_plus_17 + ";\n");
                  assignment = _plus_18;
                  int j = 0;
                  boolean _lessThan = (j < length);
                  boolean _while = _lessThan;
                  while (_while) {
                    {
                      String _plus_19 = (assignment + "_");
                      String _messageName_3 = this.getMessageName(m);
                      String _plus_20 = (_plus_19 + _messageName_3);
                      String _plus_21 = (_plus_20 + "->_");
                      String _text_9 = attrName.getText();
                      String _plus_22 = (_plus_21 + _text_9);
                      String _plus_23 = (_plus_22 + "[");
                      String _plus_24 = (_plus_23 + Integer.valueOf(j));
                      String _plus_25 = (_plus_24 + "]");
                      String _plus_26 = (_plus_25 + " = ");
                      String _plus_27 = (_plus_26 + "\'");
                      char _charAt = defaultValue.charAt(j);
                      String _plus_28 = (_plus_27 + Character.valueOf(_charAt));
                      String _plus_29 = (_plus_28 + "\'");
                      String _plus_30 = (_plus_29 + ";");
                      assignment = _plus_30;
                      int _minus = (length - 1);
                      boolean _lessThan_1 = (j < _minus);
                      if (_lessThan_1) {
                        String _plus_31 = (assignment + "\n");
                        assignment = _plus_31;
                      }
                      int _plus_32 = (j + 1);
                      j = _plus_32;
                    }
                    boolean _lessThan_1 = (j < length);
                    _while = _lessThan_1;
                  }
                } else {
                  String _messageName_3 = this.getMessageName(m);
                  String _plus_19 = ("_" + _messageName_3);
                  String _plus_20 = (_plus_19 + "->_");
                  String _text_9 = attrName.getText();
                  String _plus_21 = (_plus_20 + _text_9);
                  String _plus_22 = (_plus_21 + " = ");
                  String _plus_23 = (_plus_22 + defaultValue);
                  String _plus_24 = (_plus_23 + ";");
                  assignment = _plus_24;
                }
              }
              boolean _equals_10 = cType.equals("float");
              if (_equals_10) {
                boolean _equals_11 = defaultValue.equals("0");
                if (_equals_11) {
                  defaultValue = "0.0f";
                }
                String _messageName_4 = this.getMessageName(m);
                String _plus_25 = ("_" + _messageName_4);
                String _plus_26 = (_plus_25 + "->_");
                String _text_10 = attrName.getText();
                String _plus_27 = (_plus_26 + _text_10);
                String _plus_28 = (_plus_27 + " = ");
                String _plus_29 = (_plus_28 + defaultValue);
                String _plus_30 = (_plus_29 + ";");
                assignment = _plus_30;
              }
              boolean _equals_12 = cType.equals("double");
              if (_equals_12) {
                boolean _equals_13 = defaultValue.equals("0");
                if (_equals_13) {
                  defaultValue = "0.0";
                }
                String _messageName_5 = this.getMessageName(m);
                String _plus_31 = ("_" + _messageName_5);
                String _plus_32 = (_plus_31 + "->_");
                String _text_11 = attrName.getText();
                String _plus_33 = (_plus_32 + _text_11);
                String _plus_34 = (_plus_33 + " = ");
                String _plus_35 = (_plus_34 + defaultValue);
                String _plus_36 = (_plus_35 + ";");
                assignment = _plus_36;
              }
            }
            String _plus_37 = (assignment + "\n\n");
            assignments.append(_plus_37);
          }
        }
      }
      String _string = assignments.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public CharSequence getEnumImplementation(final CommonTree e) {
    StringConcatenation _builder = new StringConcatenation();
    List _children = e.getChildren();
    Object _get = _children.get(0);
    final CommonTree name = ((CommonTree) _get);
    _builder.newLineIfNotEmpty();
    _builder.append("int ");
    String _text = name.getText();
    _builder.append(_text, "");
    _builder.append("_write_with_tag(enum ");
    String _text_1 = name.getText();
    _builder.append(_text_1, "");
    _builder.append(" *_");
    String _text_2 = name.getText();
    _builder.append(_text_2, "");
    _builder.append(", void *_buffer, int offset, int tag) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("/* Write tag.*/");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_varint32((tag<<3)+0, _buffer, offset);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* Write content.*/");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("offset = write_raw_varint32(*_");
    String _text_3 = name.getText();
    _builder.append(_text_3, "    ");
    _builder.append(", _buffer, offset);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return offset;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Creates the given file and writes the given contents to it.
   */
  public void generateFile(final File file, final CharSequence contents) {
    try {
      FileWriter _fileWriter = new FileWriter(file, false);
      final FileWriter writer = _fileWriter;
      String _string = contents.toString();
      writer.write(_string);
      writer.close();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
