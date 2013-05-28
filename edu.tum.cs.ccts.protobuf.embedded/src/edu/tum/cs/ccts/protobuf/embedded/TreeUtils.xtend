package edu.tum.cs.ccts.protobuf.embedded

import org.antlr.runtime.tree.CommonTree
import java.util.List
import static extension edu.tum.cs.ccts.protobuf.embedded.TreeUtils.*
import java.util.ArrayList

class TreeUtils {
	
	def static String childText(CommonTree tree, String separator) {
		if (tree.childTrees == null)
			return tree.text
		TreeUtils::childTrees(tree).map[TreeUtils::childText(it, "")]
					.reduce(a, b | a + separator + b)
	}
	
	def static sortedChildTreesWithType(CommonTree tree, int type) { 
		var children = tree.children as List<CommonTree>
		children.reverse
		for (CommonTree child : children.filter[it.type == type]) {
			val currentMessage = child.getChild(0).text
//			println(currentMessage + ":");
			for (CommonTree otherChild : children.filter[it.type == type && it.getChildIndex > child.getChildIndex]) { 
				for(CommonTree c : otherChild.childTrees.tail) {
					if(c.getChild(1).text.equals(currentMessage)) {
						// Swap elements for sorting by creating a new list with
						// the swapped elements
//							println("Swapped: " + child.getChild(0).text + " with " +
//									otherChild.getChild(0).text
//							);
						var tempChildren = new ArrayList<CommonTree>
						for (CommonTree el : children) {
							if (el.equals(otherChild)) {
								tempChildren.add(child);
							} else if (el.equals(child)) {
								tempChildren.add(otherChild);	
							} else {
								tempChildren.add(el);
							}
						}
						children = tempChildren
						
					}
				}
			}	
		}
		
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