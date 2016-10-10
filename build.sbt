import scoverage.ScoverageKeys._
import CommonSettings._
import Dependencies._
import sbt._

name := "Sanskerta"
description := "Project Application Service for Sanskerta"
sourcesInBase := false

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

lazy val scoverageSettings = Seq(
  coverageEnabled in Test := true,
  coverageMinimum := 80,
  coverageFailOnMinimum := false,
  coverageExcludedPackages := "<empty>;id.dynastymasra.sanskerta.common.contract.*",

  scroogeThriftSourceFolder in Compile := baseDirectory.value / "../SanskertaThrift",
  scroogeThriftOutputFolder in Compile := baseDirectory.value / "../Common/src/main/scala"
)

lazy val commonSettings = Seq(
  libraryDependencies ++= testDependencies
)

lazy val areaSettings = Seq(
  packageName in Docker := "sanskerta-area",
  maintainer := "Dimas Ragil T <dynastymasra@gmail.com>",
  dockerExposedPorts := Seq(7121),

  libraryDependencies ++= testDependencies
)

lazy val sanskerta = (project in file("."))
  .aggregate(common, area)
  .dependsOn(common, area)

lazy val common = (
    BaseProject("Common")
      settings(scoverageSettings: _*)
      settings(commonSettings: _*)
  )

lazy val area = (
    ServiceProject("Area")
      settings(scoverageSettings: _*)
      settings(areaSettings: _*)
  ) dependsOn common