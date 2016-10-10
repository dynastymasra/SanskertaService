logLevel := Level.Warn

resolvers += "twitter-repo" at "https://maven.twttr.com"

addSbtPlugin("com.twitter" % "scrooge-sbt-plugin" % "4.10.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.4.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.4")