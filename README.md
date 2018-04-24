# SER502-Spring2018-Team2

## Members

Zeyong Cai <br/>

Huichuan Wu <br/>

Binbin Yan <br/>

Zitong Wei <br/>

## Platform
```
MacOS
Windows
```

## Tools
[ANTLR](http://www.antlr.org) (ANother Tool for Language Recognition) is a powerful parser generator for reading, processing, executing, or translating structured text or binary files. It's widely used to build languages, tools, and frameworks. From a grammar, ANTLR generates a parser that can build and walk parse trees.

*We use ANTLR to generate the **lexer** and **parser**, and use the correspoinding **visitor** in the intermedia code generator to walk the parse tree.*

[Gradle](https://gradle.org/) is an open-source build automation system that builds upon the concepts of Apache Ant and Apache Maven and introduces a Groovy-based domain-specific language (DSL) instead of the XML form used by Apache Maven for declaring the project configuration.

*We use Gradls to build our Java project.*

[JUnit](https://junit.org/junit4/) is a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.

*We use Junit to do unit tests.*

## Install

Install [Gradle](https://gradle.org/) by following the [install instruction](https://gradle.org/install/).

## Build
This project uses Gradle as build system.
Executables can be found at the following directory after the building is done.
```
./build/libs
```
### Method1: Script
```
./build.sh
```

### Method2: Command
Build Compiler
```
gralde build_compiler
```
Build Runtime
```
gradle build_runtime
```

## Run
Execute the following script will compile and run all test cases in the data folder.
```
./run.sh
```
Or you can compile and run by yourself:
```
./build/libs/GFCompiler.jar [.gf source code]
```
```
./build/libs/GFRuntime.jar [.inter intermedia code]
```

## YouTube Video Link
The presentation for this project can be found [here](https://youtu.be/tl4U1tQNHRo).
