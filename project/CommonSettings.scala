import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import com.typesafe.sbt.packager.linux.LinuxPlugin.autoImport._
import sbt.Keys._
import sbt._

object CommonSettings {
  val projectSettings = Seq(
    scalaVersion := Dependencies.scala,
    version := "1.0.0",
    organization := "id.dynastymasra.sanskerta",
    resolvers ++= Dependencies.resolvers,
    crossPaths := false,
    sbtPlugin := true,
    parallelExecution in Test := false,
    scalaSource in Compile := baseDirectory.value / "src/main/scala",
    scalaSource in Test := baseDirectory.value / "src/test/scala",
    resourceDirectory in Compile := baseDirectory.value / "src/main/resources",
    resourceDirectory in Test := baseDirectory.value / "src/test/resources",

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
      enablePlugins (DockerPlugin, JavaAppPackaging)
    )
}