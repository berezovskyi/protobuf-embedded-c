package edu.tum.cs.ccts.protobuf.embedded

import org.antlr.runtime.tree.CommonTree
import java.util.List

class TreeUtils {
	
	def static String childText(CommonTree tree, String separator) {
		if (TreeUtils::childTrees(tree) == null)
			return tree.text
		TreeUtils::childTrees(tree).map[TreeUtils::childText(it, "")]
					.reduce(a, b | a + separator + b)
	}
	
	def static childTrees(CommonTree tree) { 
		tree.children as List<CommonTree>
	}

	
}