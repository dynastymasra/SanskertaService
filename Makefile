SHELL := bash

VERSION ?= latest

.PHONY: clean-thrift gen-thrift thrift-clean-gen build test-local

clean-thrift:
	rm -rvf Common/src/main/scala/id/co/squarecode/common/contract

gen-thrift:
	sbt clean compile

thrift-clean-gen: clean-thrift gen-thrift

run: clean-thrift
	sbt clean
	sbt run

test-local: clean-thrift
	sbt coverage test
	sbt coverageReport

build:
	sbt docker:publishLocal




