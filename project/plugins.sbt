logLevel := Level.Warn

resolvers += "twitter-repo" at "https://maven.twttr.com"

addSbtPlugin("com.twitter" % "scrooge-sbt-plugin" % "4.7.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.1")