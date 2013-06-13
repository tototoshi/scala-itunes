import sbt._
import sbt.Keys._

object ScalaitunesBuild extends Build {

  lazy val scalaitunes = Project(
    id = "scala-itunes",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-itunes",
      organization := "com.github.tototoshi",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      initialCommands += "import com.github.tototoshi.itunes.iTunes._",
      scalacOptions ++= Seq("-language:_")
    )
  )
}
