/*-----------------------------------------------------------------------+
 | edu.tum.cs.ccts.protobuf.embedded
 |                                                                       |
 |                                                                       |
 | Copyright (c)  2004-2011 Technische Universitaet Muenchen             |
 |                                                                       |
 | Technische Universitaet Muenchen               #########  ##########  |
 | Institut fuer Informatik - Lehrstuhl IV           ##  ##  ##  ##  ##  |
 | Prof. Dr. Dr. h.c. Manfred Broy                   ##  ##  ##  ##  ##  |
 | Boltzmannstr. 3                                   ##  ##  ##  ##  ##  |
 | 85748 Garching bei Muenchen                       ##  ##  ##  ##  ##  |
 | Germany                                           ##  ######  ##  ##  |
 +-----------------------------------------------------------------------*/

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
