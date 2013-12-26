name := "sweeper-redux"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions in Test ++= Seq("-Yrangepos")

fork in run := true

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.5"

libraryDependencies += "org.scalafx" %% "scalafx" % "1.0.0-M2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.6" % "test"

libraryDependencies += "org.spire-math" %% "spire" % "0.7.1" // I plan to use this to replace the current method for getfilename

unmanagedJars in Compile += Attributed.blank(
  file(scala.util.Properties.javaHome) / "lib" / "jfxrt.jar")

jfxSettings

org.scalastyle.sbt.ScalastylePlugin.Settings

