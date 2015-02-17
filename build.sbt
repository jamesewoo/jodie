val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

lazy val commonSettings = Seq(
  organization := "org.jodie",
  version := "1.0",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "jodie",
    libraryDependencies += scalatest
  )