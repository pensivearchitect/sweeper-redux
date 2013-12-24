name := "sweeper-redux"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.5"

libraryDependencies += "org.scalafx" %% "scalafx" % "1.0.0-M2"

unmanagedJars in Compile += Attributed.blank(
  file(scala.util.Properties.javaHome) / "lib" / "jfxrt.jar")

fork in run := true

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.6" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

jfxSettings

org.scalastyle.sbt.ScalastylePlugin.Settings
