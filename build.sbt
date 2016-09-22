import scoverage.ScoverageKeys._
import CommonSettings._
import Dependencies._
import sbt._

name := "Sanskerta"
description := "Project Application Service for Sanskerta"
version := versionApp
scalaVersion := scala
sourcesInBase := false

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

lazy val scoverageSettings = Seq(
  coverageEnabled in Test := true,
  coverageMinimum := 80,
  coverageFailOnMinimum := false,

  scroogeThriftSourceFolder in Compile := baseDirectory.value / "../SanskertaThrift",
  scroogeThriftOutputFolder in Compile := baseDirectory.value / "../Common/src/main/scala"
)

lazy val commonSettings = Seq(
  version := versionApp,

  libraryDependencies ++= testDependencies
)

lazy val countrySettings = Seq(
  version := versionApp,

  maintainer := "Dimas Ragil T <dynastymasra@gmail.com>",
  dockerExposedPorts := Seq(7121),
  version in Docker := versionApp,

  libraryDependencies ++= testDependencies
)

lazy val sanskerta = (project in file("."))
  .enablePlugins(DockerPlugin)
  .aggregate(common, country)
  .dependsOn(common, country)

lazy val common = (
    BaseProject("Common")
      settings(scoverageSettings: _*)
      settings(commonSettings: _*)
  )

lazy val country = (
    ServiceProject("Country")
      settings(scoverageSettings: _*)
      settings(countrySettings: _*)
  ) dependsOn common