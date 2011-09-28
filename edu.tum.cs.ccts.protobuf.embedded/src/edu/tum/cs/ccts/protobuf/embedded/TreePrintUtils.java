/*--------------------------------------------------------------------------+
|                                                                          |
| Copyright 2008-2011 Technische Universitaet Muenchen                     |
|                                                                          |
| Licensed under the Apache License, Version 2.0 (the "License");          |
| you may not use this file except in compliance with the License.         |
| You may obtain a copy of the License at                                  |
|                                                                          |
|    http://www.apache.org/licenses/LICENSE-2.0                            |
|                                                                          |
| Unless required by applicable law or agreed to in writing, software      |
| distributed under the License is distributed on an "AS IS" BASIS,        |
| WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
| See the License for the specific language governing permissions and      |
| limitations under the License.                                           |
+--------------------------------------------------------------------------*/

package edu.tum.cs.ccts.protobuf.embedded;

import java.util.Arrays;

import org.antlr.runtime.tree.Tree;

/**
 * A static helper class that allows for printing antlr's tree structures in
 * text format.
 * 
 * @author wolfgang.schwitzer
 * @author nvpopa
 */
public class TreePrintUtils {

	private static boolean[] levelClosed = {};

	public static void printTree(Tree tree) {
		printTree(tree, 0);
	}

	private static void printTree(Tree tree, int level) {
		if (level == 0) {
			Arrays.fill(levelClosed, false);
		}
		if (level >= levelClosed.length) {
			levelClosed = Arrays.copyOf(levelClosed, levelClosed.length + 10);
		}
		levelClosed[level] = false;
		indent(level - 1);
		if (level > 0) {
			Tree parent = tree.getParent();
			if (parent.getChild(parent.getChildCount() - 1) == tree) {
				p("└─");
				levelClosed[level] = true;
			} else {
				p("├─");
			}
		}
		if (tree.getChildCount() > 0) {
			p("○ ");
		} else {
			p("○ ");
		}
		p(tree);
		if (tree.getChildCount() > 0) {
			p(" ");
		}
		pln();
		for (int i = 0; i < tree.getChildCount(); i++) {
			printTree(tree.getChild(i), level + 1);
		}
	}

	private static void indent(int level) {
		for (int i = 0; i < level; i++) {
			if (levelClosed[i + 1]) {
				p("  ");
			} else {
				p("│ ");
			}
		}
	}

	private static void p(Object text) {
		System.out.print(text);
	}

	private static void pln() {
		System.out.println();
	}
}
