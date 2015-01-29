package model

import java.io.File

import sys.process._

/**
 * A home for our functions that call out to the shell
 */
object ShellService {

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
    val ourShellScript = "processIt.sh"

    Seq(ourShellScript, f.getCanonicalPath).!!
  }

}
