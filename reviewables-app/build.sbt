name := """reviewables-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

EclipseKeys.createSrc := EclipseCreateSrc.All

libraryDependencies += "org.neo4j" % "neo4j-jdbc" % "2.1.4"

resolvers += "neo4j" at "http://m2.neo4j.org/service/local/repositories/releases/content"

fork in run := false