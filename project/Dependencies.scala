import sbt._

object Dependencies {
  val scala = "2.11.8"
  val versionApp = "1.0.0"

  lazy val versions = new {
    val finagle = "6.38.0"
    val scrooge = "4.10.0"
    val libthrift = "0.9.3"
    val scalatest = "3.0.0"
    val junit = "4.12"
    val config = "1.3.0"
    val scalalogging = "3.5.0"
    val logback = "1.1.7"
  }

  val resolvers = Seq(
    "Typesafe repository snapshots"    at "http://repo.typesafe.com/typesafe/snapshots/",
    "Typesafe repository releases"     at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
    "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
    "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
    "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
    "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
    "Twitter Repository"               at "http://maven.twttr.com"
  )

  val logback = "ch.qos.logback" % "logback-classic" % versions.logback
  val libthrift = "org.apache.thrift" % "libthrift" % versions.libthrift
  val scrooge = "com.twitter" %% "scrooge-core" % versions.scrooge

  object finagle {
    val core   = "com.twitter" %% "finagle-core" % versions.finagle
    val thrift = "com.twitter" %% "finagle-thrift" % versions.finagle
  }

  object typesafe {
    val config  = "com.typesafe" % "config" % versions.config
    val logging = "com.typesafe.scala-logging" %% "scala-logging" % versions.scalalogging
  }

  object test {
    val junit     = "junit" % "junit" % versions.junit % "test"
    val scalatest = "org.scalatest" %% "scalatest" % versions.scalatest % "test"
  }

  val coreDependencies: Seq[ModuleID] = Seq(
    finagle.core,
    finagle.thrift,
    typesafe.config,
    typesafe.logging,
    logback,
    libthrift,
    scrooge
  )

  val testDependencies: Seq[ModuleID] = coreDependencies ++ Seq(
    test.junit,
    test.scalatest
  )
}