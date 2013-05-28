package edu.tum.cs.ccts.protobuf.embedded;

import java.util.Comparator;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("rawtypes")
public class CommonTreeImportOrderComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		CommonTree tree1 = (CommonTree) o1;
		CommonTree tree2 = (CommonTree) o2;

		if (tree1.equals(tree2)) {
			return 0;
		}

		if (tree1.getType() == ProtoParser.ENUM) {
			return -1;
		}
		if (tree2.getType() == ProtoParser.ENUM) {
			return 1;
		}

		String currentMessage = tree1.getChild(0).getText();
		if (currentMessage == null) {
			return 1;
		}
		for (int i = 1; i < TreeUtils.childTrees(tree2).size(); ++i) {
			CommonTree c = TreeUtils.childTrees(tree2).get(i);
			if (c == null || c.getChildCount() <= 1) {
				continue;
			}
			if (c.getChild(1).getText().equals(currentMessage)) {
				return -1;
			}
		}

		return 1;
	}

}
