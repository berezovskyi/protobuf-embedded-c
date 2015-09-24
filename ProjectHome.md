## What is Protobuf-Embedded-C ? ##
A protocol buffers generator for resource constrained embedded applications written in the C programming language. 

For example, you may employ Protobuf-Embedded-C to let tiny embedded devices communicate directly with each other or with servers running large scale business applications.

These following guidelines drive Protobuf-Embedded-C:
  1. Generated C-code runs on low-power and low-memory embedded controllers.
  1. Generated C-code runs on real-time systems with static memory allocation.
  1. Code is completely generated, so it is self-contained (no libraries on the target device).
  1. API is easy to learn and (where possible) close to the concepts of the original protobuf implementations by Google.

Please note, that these guidelines imply reduced functionality, yet powerful enough to get the typical protobuf communication jobs done.

## New and Noteworthy ##
**June 2013:** Protobuf-Embedded-C Milestone 1.0M4 can be downloaded from [here](http://code.google.com/p/protobuf-embedded-c/downloads/list). The new enhancements are:
  * The generator now uses [Xtend](http://www.eclipse.org/xtend/).
  * Support for the **default** keyword.

**May 2013:** We are working on 1.0M4 and some of the more complex planned features made us think about using a flexible and maintainable solution for code generation. We are currently refactoring the generator to use [Xtend](http://www.eclipse.org/xtend/), which offers excellent tool support at development time and keeps the downloadable jar-file "pure Java" and lean at runtime.

**Jan 2013:** Protobuf-Embedded-C Milestone 1.0M3 is available! The new version can be downloaded from [here](http://code.google.com/p/protobuf-embedded-c/downloads/list). Compared to the previous release, the current version implements the following new features:
  * Support of **optional** fields for every data type. (Please note that the 'default' keyword is scheduled for Milestone 1.0M4. Until then the default values are filled with 0)
  * Added C++ compatibility for integrating the generated files into a C++ project.
  * Adapted the code to compile without warnings on more compilers.


## Publications ##
Wolfgang Schwitzer and Vlad Popa.
_Using Protocol Buffers for Resource-Constrained Distributed Embedded Systems._
Technical Report TUM-I1120, Technische Universitaet Muenchen, 2011.
[Download...](http://www4.in.tum.de/publ/html.php?e=1267).

## Quick Example ##
### Writing the Proto File ###
Suppose you write a file `phone.proto` like this:
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

### Compiling the Proto File ###
Next, call the `protoc` compiler from the command line like this:
```
java -jar protoc-1.0M4.jar phone.proto
```
_Be sure to have **java (1.6)**, **protoc-1.0M4.jar** and **phone.proto** in your path._

### Exploring the Generated API ###
Now, you should see the files `phone.c` and `phone.h` next to `phone.proto`, where `phone.h` provides you with the API to deal with `PhoneNumber` messages. The generated file phone.h will look similar like this:
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

## Which platforms is Protobuf-Embedded-C running on ? ##
Protobuf-Embedded-C has been reported to run successfully on the following target platform so far: **ARM Cortex M3**, **TI MSP430F5438**, **IA32** (in-the-loop tests).

## Milestone Plan ##
**Important notice for those waiting for the next milestones:**
a lot of things that need to be done in some other projects caused us to delay the work on milestones M3 and M4. Hopefully, M4 will be available around the end of May 2013.
Thanks for using/testing these early milestones already.
Please consider using one of the more advanced and stable projects for protobuf and C, if you / your project requires more features than currently supported.
| **Milestone** | **Date**    | **Themes** |
|:--------------|:------------|:-----------|
| 1.0M3         | Jan. 2013   | Support _optional_ fields.|
| 1.0M4         | May 2013    | Support _default_ values and per-field maximum length definitions.|

## API Compliance ##
| **Milestone** | **Google API** | **ANTLR API** |
|:--------------|:---------------|:--------------|
| 1.0M1         | 2.3            | 3.2           |
| 1.0M2         | 2.4.1          | 3.2           |
| 1.0M3         | 2.5.0          | 3.2           |

## Codebase Statistics and Progress ##
&lt;wiki:gadget url="http://www.ohloh.net/p/585433/widgets/project\_languages.xml" width="360" height="220" border="0" /&gt;

## Who are the people behind Protobuf-Embedded-C ? ##
Protobuf-Embedded-C is developed by the [embedded systems research group](http://www4.in.tum.de/research/embedded/index_en.shtml) of the [Chair IV - Software & Systems Engineering](http://www4.in.tum.de/index_en.shtml) at the [Technische Universität München (TUM)](http://www.in.tum.de/), Germany.

Parts of Protobuf-Embedded-C have been developed in the context of the embedded systems research project [SPES2020](http://spes2020.informatik.tu-muenchen.de/).


_Disclaimer: Note that any (registered) trademarks on this website like Google, ARM, TI, Intel and others belong to their respective owners._