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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

/**
 * A command-line tool that helps debugging the proto language parser.
 * 
 * @author wolfgang.schwitzer
 * @author nvpopa
 */
public class ProtoCommandLine {

	public static void main(String[] args) throws Exception {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String text = "";
		String line = console.readLine();
		while (true) {
			text += line + "\n";
			if (line.length() == 0) {
				ANTLRInputStream input = new ANTLRInputStream(
						new ByteArrayInputStream(text.getBytes()));
				ProtoLexer lexer = new ProtoLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				ProtoParser parser = new ProtoParser(tokens);
				TreePrintUtils.printTree(parser.proto().tree);
				System.out.println();
				text = "";
				line = console.readLine();
				if (line.length() == 0) {
					break;
				}
				continue;
			}
			line = console.readLine();
		}
	}

}
