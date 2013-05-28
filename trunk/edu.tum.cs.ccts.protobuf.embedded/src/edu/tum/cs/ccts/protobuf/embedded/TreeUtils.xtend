package edu.tum.cs.ccts.protobuf.embedded

import org.antlr.runtime.tree.CommonTree
import java.util.List
import static extension edu.tum.cs.ccts.protobuf.embedded.TreeUtils.*
import java.util.Collections

class TreeUtils {
	
	def static String childText(CommonTree tree, String separator) {
		if (tree.childTrees == null)
			return tree.text
		TreeUtils::childTrees(tree).map[TreeUtils::childText(it, "")]
					.reduce(a, b | a + separator + b)
	}
	
	def static sortedChildTreesWithType(CommonTree tree, int type) { 
		var children = tree.children as List<CommonTree>
		
		Collections::sort(children, new CommonTreeImportOrderComparator)
		
//		for (CommonTree child : children.filter[it.type == type]) {
//			val currentMessage = child.getChild(0).text
//			println(currentMessage + "*");
//		}
		children.filter[it.type == type]
	}
	
	def static childTrees(CommonTree tree) { 
		tree.children as List<CommonTree>
	}
	
}