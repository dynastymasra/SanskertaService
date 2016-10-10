SHELL := bash

.PHONY: clean-thrift gen-thrift thrift-clean-gen build test-local

clean-thrift:
	rm -rvf Common/src/main/scala/id/dynastymasra/sanskerta/common/contract

gen-thrift:
	sbt clean compile

thrift-clean-gen: clean-thrift gen-thrift

test-local: clean-thrift
	sbt clean coverage test coverageAggregate
	sbt coverageReport
	sbt coverageAggregate

build: clean-thrift
	sbt docker:publishLocal




