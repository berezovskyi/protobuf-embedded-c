package edu.tum.cs.ccts.protobuf.embedded;

import com.google.common.base.Objects;
import edu.tum.cs.ccts.protobuf.embedded.CommonTreeImportOrderComparator;
import java.util.Collections;
import java.util.List;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class TreeUtils {
  public static String childText(final CommonTree tree, final String separator) {
    String _xblockexpression = null;
    {
      List<CommonTree> _childTrees = TreeUtils.childTrees(tree);
      boolean _equals = Objects.equal(_childTrees, null);
      if (_equals) {
        return tree.getText();
      }
      List<CommonTree> _childTrees_1 = TreeUtils.childTrees(tree);
      final Function1<CommonTree,String> _function = new Function1<CommonTree,String>() {
          public String apply(final CommonTree it) {
            String _childText = TreeUtils.childText(it, "");
            return _childText;
          }
        };
      List<String> _map = ListExtensions.<CommonTree, String>map(_childTrees_1, _function);
      final Function2<String,String,String> _function_1 = new Function2<String,String,String>() {
          public String apply(final String a, final String b) {
            String _plus = (a + separator);
            String _plus_1 = (_plus + b);
            return _plus_1;
          }
        };
      String _reduce = IterableExtensions.<String>reduce(_map, _function_1);
      _xblockexpression = (_reduce);
    }
    return _xblockexpression;
  }
  
  public static Iterable<CommonTree> sortedChildTreesWithType(final CommonTree tree, final int type) {
    Iterable<CommonTree> _xblockexpression = null;
    {
      List _children = tree.getChildren();
      List<CommonTree> children = ((List<CommonTree>) _children);
      CommonTreeImportOrderComparator _commonTreeImportOrderComparator = new CommonTreeImportOrderComparator();
      Collections.<CommonTree>sort(children, _commonTreeImportOrderComparator);
      final Function1<CommonTree,Boolean> _function = new Function1<CommonTree,Boolean>() {
          public Boolean apply(final CommonTree it) {
            int _type = it.getType();
            boolean _equals = (_type == type);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<CommonTree> _filter = IterableExtensions.<CommonTree>filter(children, _function);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  public static List<CommonTree> childTrees(final CommonTree tree) {
    List _children = tree.getChildren();
    return ((List<CommonTree>) _children);
  }
}
