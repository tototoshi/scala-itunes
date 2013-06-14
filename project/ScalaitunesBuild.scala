import sbt._
import sbt.Keys._

object ScalaitunesBuild extends Build {

  lazy val scalaitunes = Project(
    id = "scala-itunes",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-itunes",
      organization := "com.github.tototoshi",
      version := "0.1.0",
      scalaVersion := "2.10.2",
      crossScalaVersions ++= Seq("2.9.0", "2.9.1", "2.9.2", "2.10.0"),
      initialCommands += "import com.github.tototoshi.itunes.iTunes._",
      scalacOptions <<= scalaVersion.map { sv =>
        if (sv.startsWith("2.10")) {
          Seq("-deprecation", "-language:_")
        } else {
          Seq("-deprecation")
        }
      }
    ) ++ publishingSettings
  )

  val publishingSettings = Seq(
    publishMavenStyle := true,
    publishTo <<= version { (v: String) => _publishTo(v) },
    publishArtifact in Test := false,
    pomExtra := _pomExtra
  )

  def _publishTo(v: String) = {
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }

  val _pomExtra =
    <url>http://github.com/tototoshi/scala-itunes</url>
      <licenses>
        <license>
          <name>Creative Commons Attribution-Share Alike 2.0 UK: England &amp; Wales License</name>
          <url>http://creativecommons.org/licenses/by-sa/2.0/uk/</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:tototoshi/scala-itunes</url>
        <connection>scm:git:git@github.com:tototoshi/scala-itunes.git</connection>
      </scm>
      <developers>
        <developer>
          <id>tototoshi</id>
          <name>Toshiyuki Takahashi</name>
          <url>http://tototoshi.github.com</url>
        </developer>
      </developers>


}
