# Developers Guide #

This page is intended for all developers, which want to maintain or extend the Protobuf-Embedded-C software.

  1. Install **Java 7 JDK** from http://www.oracle.com/technetwork/java/javase/downloads/index.html .
  1. Download the **Eclipse IDE for Java Developers** from [here...](http://www.eclipse.org/downloads)
  1. Install **Subclipse**, a SVN client integration for Eclipse. Subclipse can be installed by using the Eclipse update manager url: http://subclipse.tigris.org/update_1.8.x
  1. Install the **C/C++ Development Tools** from the Eclipse update manager using the following url: http://download.eclipse.org/releases/juno
  1. Other prerequisites for the ANTLR IDE:
    * **Dynamic Language Toolkit (DLTK) Core** Version: 3.0.1 (**Note**: This version is no longer available in the Eclipse update site. Use this link http://www.eclipse.org/dltk/ for download)
    * **Zest** Version: 1.3.0+
    * **GEF** Version: 3.7.0+
  1. Install the **ANTLR IDE** via the update manager: http://antlrv3ide.sourceforge.net/updates or manually download it from http://sourceforge.net/projects/antlrv3ide/files/antlride/2.1.0/antlride-2.1.2.zip/download
  1. Download **ANTLR 3.4** http://www.antlr.org/wiki/display/ANTLR3/ANTLR+3.4+Release+Notes
  1. Add in the **ANTLR/Builder** tab of the Eclipse **Preferences** window the path to ANTLR 3.4. In the **ANTLR/Code Generator** tab check the _Project relative folder_ radio button and add _generated-src_ inside the corresponding text-box. Also select the _Append java package to output folder_ check box.
  1. Checkout the **edu.tum.cs.ccts.protobuf.embedded** project from the svn address https://protobuf-embedded-c.googlecode.com/svn/trunk/ in your workspace.
  1. Generate the **grammar** .g files.
  1. Download Google's Protocol Buffers version 2.4.1 from http://code.google.com/p/protobuf/downloads/list
  1. Make sure the protoc executable is set to your variable path.
  1. Generate the **java class** from the .proto-file in the test folder of the project. The batch script **generate-test-protos.bat** in the test folder of the project automatically does this for you if edited as follows: replace the _<INSERT YOUR WORKSPACE PATH HERE>_ value of the attribute _workspace_ with the path of the workspace.
  1. Now the Eclipse project should compile without errors :)
  1. Before running the Protoc.java class add: _-I=test --c\_out=test test.proto_ to the **Run configurations...**
  1. Now the .c and .h files are generated and need to be **compiled** (e.q.: _gcc -Wall Main.c Test.c -o Test_).
  1. In the end the **JUnit tests** can be executed by running the _TestWireFormat.java_ class in the _test-src_ folder of the project.