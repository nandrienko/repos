import ReleaseTransformations._

val SlickVersion = "3.1.1"

val AkkaVersion = "2.4.1"

scalaVersion := "2.11.7"

organization := "com.trueaccord.repos"

name := "repos"

releasePublishArtifactsAction := PgpKeys.publishSigned.value

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  pushChanges,
  ReleaseStep(action = Command.process("sonatypeReleaseAll", _))
)

libraryDependencies ++= Seq(
    "commons-codec" % "commons-codec" % "1.8",
    "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream-experimental" % "2.0.3",
    "com.typesafe.akka" %% "akka-http-experimental" % "2.0.3",
    "com.typesafe.slick" %% "slick" % SlickVersion,
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.scala-lang.modules" %% "scala-async" % "0.9.5",
    "org.xerial.snappy" % "snappy-java" % "1.1.1.6",

    "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % "test",
    "com.h2database" % "h2" % "1.4.189" % "test",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

