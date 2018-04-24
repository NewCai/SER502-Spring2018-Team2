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
TODO

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
Execute following script will compile and run all test cases in the data folder.
```
./run.sh
```
Or you can compile and run by yourself.
```
./build/libs/GFCompiler.jar [.gf source code]
```
```
./build/libs/GFRuntime.jar [.inter intermedia code]
```

## YouTube Video Link
The presentation for this project can be found [here](https://youtu.be/tl4U1tQNHRo).
