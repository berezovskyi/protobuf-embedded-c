# What is Protobuf-Embedded-C ?

A protocol buffers generator for resource constrained embedded applications written in the C programming language.

For example, you may employ Protobuf-Embedded-C to let tiny embedded devices communicate directly with each other or with servers running large scale business applications.

These following guidelines drive Protobuf-Embedded-C:

1. Generated C-code runs on low-power and low-memory embedded controllers.
2. Generated C-code runs on real-time systems with static memory allocation.
3. Code is completely generated, so it is self-contained (no libraries on the target device).
4. API is easy to learn and (where possible) close to the concepts of the original protobuf implementations by Google.

Please note, that these guidelines imply reduced functionality, yet powerful enough to get the typical protobuf communication jobs done.

# Publications

Wolfgang Schwitzer and Vlad Popa. [Using Protocol Buffers for Resource-Constrained Distributed Embedded Systems](http://www4.in.tum.de/publ/html.php?e=1267). Technical Report TUM-I1120, Technische Universitaet Muenchen, 2011.

# Examples

## Writing the Proto File

```
//File: phone.proto
//
//Optional Embedded C internal options:
//@max_repeated_length=100
//@max_string_length=32

enum PhoneType {
  MOBILE = 0;
  HOME = 1;
  WORK = 2;
}

message PhoneNumber {
  required string number = 1;
  required PhoneType type = 2;
}
```

## Compiling the Proto File

    java -jar protoc-1.0M4.jar phone.proto

*Be sure to have java (1.6), protoc-1.0M4.jar and phone.proto in your path.*

## Exploring the Generated API

Now, you should see the files phone.c and phone.h next to phone.proto, where phone.h provides you with the API to deal with PhoneNumber messages. The generated file phone.h will look similar like this:

```
/* Excerpt from generated file: phone.h */

#define MAX_REPEATED_LEN 100
#define MAX_STRING_LEN 32

enum PhoneType {
  _MOBILE = 0,
  _HOME = 1,
  _WORK = 2
};

#define MAX_PhoneNumber_SIZE 40

struct PhoneNumber {
  int _number_len;
  char _number[MAX_STRING_LEN];
  enum PhoneType _type;
};

int PhoneNumber_write_delimited_to(struct PhoneNumber *_PhoneNumber, void *_buffer, int offset);

int PhoneNumber_read_delimited_from(void *_buffer, struct PhoneNumber *_PhoneNumber, int offset);

```

# Platform support

Protobuf-Embedded-C has been reported to run successfully on the following target platform so far: **ARM Cortex M3**, **TI MSP430F5438**, **IA32** (in-the-loop tests).

# Development environment

This page is intended for all developers, which want to maintain or extend the Protobuf-Embedded-C software.

* Install Java 7 JDK from http://www.oracle.com/technetwork/java/javase/downloads/index.html .
* Download the Eclipse IDE for Java Developers from here...
* Install Subclipse, a SVN client integration for Eclipse. Subclipse can be installed by using the Eclipse update manager url: http://subclipse.tigris.org/update_1.8.x
* Install the C/C++ Development Tools from the Eclipse update manager using the following url: http://download.eclipse.org/releases/juno
* Other prerequisites for the ANTLR IDE:
    * Dynamic Language Toolkit (DLTK) Core Version: 3.0.1 (Note: This version is no longer available in the Eclipse update site. Use this link http://www.eclipse.org/dltk/ for download)
    * Zest Version: 1.3.0+
    * GEF Version: 3.7.0+
* Install the ANTLR IDE via the update manager: http://antlrv3ide.sourceforge.net/updates or manually download it from http://sourceforge.net/projects/antlrv3ide/files/antlride/2.1.0/antlride-2.1.2.zip/download
* Download ANTLR 3.4 http://www.antlr.org/wiki/display/ANTLR3/ANTLR+3.4+Release+Notes
* Add in the ANTLR/Builder tab of the Eclipse Preferences window the path to ANTLR 3.4. In the ANTLR/Code Generator tab check the Project relative folder radio button and add generated-src inside the corresponding text-box. Also select the Append java package to output folder check box.
* Checkout the edu.tum.cs.ccts.protobuf.embedded project from the svn address https://protobuf-embedded-c.googlecode.com/svn/trunk/ in your workspace.
* Generate the grammar .g files.
* Download Google's Protocol Buffers version 2.4.1 from http://code.google.com/p/protobuf/downloads/list
* Make sure the protoc executable is set to your variable path.
* Generate the java class from the .proto-file in the test folder of the project. The batch script generate-test-protos.bat in the test folder of the project automatically does this for you if edited as follows: replace the <INSERT YOUR WORKSPACE PATH HERE> value of the attribute workspace with the path of the workspace.
* Now the Eclipse project should compile without errors :)
* Before running the Protoc.java class add: -I=test --c_out=test test.proto to the Run configurations...
* Now the .c and .h files are generated and need to be compiled (e.q.: gcc -Wall Main.c Test.c -o Test).
* In the end the JUnit tests can be executed by running the TestWireFormat.java class in the test-src folder of the project.
