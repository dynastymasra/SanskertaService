# Service Application for Sanskerta Project Application

[![Scala](https://img.shields.io/badge/scala-2.11.8-red.svg)](http://www.scala-lang.org/)
[![Finagle](https://img.shields.io/badge/finagle-6.38.0-6B809C.svg)](https://twitter.github.io/finagle/)
[![License](https://img.shields.io/badge/license-MIT-44897A.svg)](https://github.com/dynastymasra/SanskertaThrift/blob/master/LICENSE)


Service application for `Sanskerta`, use scala, finagle and scrooge for thrift connection. 

used thrift file in [Sanskerta Thrift](https://github.com/dynastymasra/SanskertaThrift)

## Libraries

- Logback          : 1.1.7
- Thrift           : 0.9.3
- Scrooge          : 4.10.0
- Finagle          : Core, Thrift
- Typesafe         : Config(1.3.0), Scala Logging(3.5.0)
- Junit            : 4.12
- Scalatest        : 3.0.0

## Module structures

```
Sanskerta              (Base Project)
├── Common             (Module for code used in every module)
├── Country            (Module for define country)
├── Config             (Folder for place configuration file and other)
├── project            (Folder define configuration application and library)
├── SanskertaThrift    (Folder thrift definition)
├── Makefile           (File for define command in application)
├── build.sbt
├── LICENSE
└── README.md
```

## How to Install and Run

Use command `make` for run this application.

+ Available Command
    - `clean-thrift` (delete generated thrift file)
    - `gen-thrift` (generated thrift file to scala code)
    - `thrift-clean-gen` (delete and generate thrift file)
    - `test-local` (run test application)
    - `build` (build image docker all service)
    
## Application Flag

Application have `flag` to run, if not use flag application automate use config in file `application.conf`. 



