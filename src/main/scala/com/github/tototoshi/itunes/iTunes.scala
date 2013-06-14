package com.github.tototoshi.itunes

import scala.sys.process._
import java.io.ByteArrayOutputStream

object iTunes {

  case class Result(status: Int, message: String)

  private def createProcess(command: Seq[String]): ProcessBuilder = Process(List("itunes") ++ command)

  private def execute(command: Seq[String]): Result = {
    val b = new ByteArrayOutputStream()
    try {
      val status = (createProcess(command) #> b).!
      Result(status, b.toString.trim)
    } finally {
      b.close()
    }
  }

  def play() = execute(Seq("play"))

  def pause() = execute(Seq("pause"))

  def stop() = execute(Seq("stop"))

  def next() = execute(Seq("next"))

  def prev() = execute(Seq("prev"))

  def info() = execute(Seq("info"))

  def search(target: String, word: String) = execute(Seq("search", target, word))

  def search(word: String) = execute(Seq("search", "all", word))

  def shuffle() = execute(Seq("shuffle"))

  def repeat() = execute(Seq("repeat"))

  def playlist() = execute(Seq("playlist"))

  def playlists() = execute(Seq("playlists"))

  def vol(i: Int) = execute(Seq("vol", i.toString))

  def vol(s: String) = execute(Seq("vol", s))

  def mute() = execute(Seq("mute"))

  def unmute() = execute(Seq("unmute"))

  def sysvol(i: Int) = execute(Seq("sysvol", i.toString))

  def sysvol(s: String) = execute(Seq("sysvol", s))

  def sysmute() = execute(Seq("sysmute"))

  def sysunmute() = execute(Seq("sysunmute"))

  def open() = execute(Seq("open"))

  def quit() = execute(Seq("quit"))

  def show() = execute(Seq("show"))

  def hide() = execute(Seq("hide"))

  def version() = execute(Seq("version"))

  def help() = execute(Seq("help"))

  def plugins() = execute(Seq("plugins"))

}
