package model

import java.io.File

import play.api.Play

import sys.process._

/**
 * A home for our functions that call out to the shell
 */
object ShellService {


  val dir = Play.current.configuration.getString("flashspeak.shell.dir")

  val praatExe = Play.current.configuration.getString("flashspeak.praat.path")

  /**
   * Sanity checks this is working, by doing a shell echo and returning the result
   * @return whatever you gave it
   */
  def echoBack(s:String):String = Seq("echo",s).!!

  /**
   * The script we really want to run to process the file
   */
  def echoLs(f:File):String = {
    println(f.getCanonicalPath)

    Seq("ls", "-l", f.getCanonicalPath).!!
  }


  /**
   * The script we really want to run to process the file
   */
  def process(f:File) = {
    val ourShellScript = "shell/script.praat" // TODO: this is relying on us setting up a symlink from wherever sbt is running
    Seq("ffmpeg", "-i", f.getAbsolutePath, f.getCanonicalPath + ".wav").!!
    (praatExe.toSeq ++ Seq("--run", ourShellScript, f.getAbsolutePath + ".wav", f.getCanonicalPath + ".png")).!!
    f.getCanonicalPath + ".png"
  }

  def process(f:File, script:String) = {

  }

}
