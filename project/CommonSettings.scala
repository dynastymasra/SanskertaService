import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import com.typesafe.sbt.packager.linux.LinuxPlugin.autoImport._
import sbt.Keys._
import sbt._

object CommonSettings {
  val projectSettings = Seq(
    scalaVersion := Dependencies.scala,
    organization := "id.co.squarecode.dynastymasra",
    resolvers ++= Dependencies.resolvers,
    crossPaths := false,
    sbtPlugin := true,
    fork in Test := true,
    parallelExecution in Test := false,
    scalaSource in Compile := baseDirectory.value / "src/main/scala",
    scalaSource in Test := baseDirectory.value / "src/test/scala",
    resourceDirectory in Compile := baseDirectory.value / "src/main/resources",
    resourceDirectory in Test := baseDirectory.value / "src/test/resources",
    sources in(Compile, doc) := Seq.empty,
    publishArtifact in(Compile, packageDoc) := false,

    dockerRepository := Some("dynastymasra"),
    dockerBaseImage := "flangelier/scala:latest",
    dockerExposedVolumes in Docker := Seq("/sanskerta/docker/logs"),
    dockerUpdateLatest := true,
    daemonUser in Docker := "root"
  )

  def BaseProject(name: String): Project = (
    Project(name, file(name))
      settings (projectSettings: _*)
    )

  def ServiceProject(name: String): Project = (
    BaseProject(name)
      enablePlugins DockerPlugin
      enablePlugins JavaAppPackaging
    )
}