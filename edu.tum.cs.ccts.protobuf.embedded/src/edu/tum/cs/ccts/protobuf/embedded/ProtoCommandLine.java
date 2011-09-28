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
