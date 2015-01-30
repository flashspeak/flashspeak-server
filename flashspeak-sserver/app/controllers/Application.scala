package controllers

import model.ShellService
import play.api._
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  var lastImageFN = "";


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  /**
   * Receives
   * @param proj some unique string for this collection of stuff (just set it to 'foo' for now)
   * @return
   */
  def process = Action(parse.temporaryFile) { request =>
    this.lastImageFN = ShellService.process(request.body.file)
    Ok(lastImageFN)
  }

  def lastImage = Action { request =>
    val file = new java.io.File(lastImageFN)
    val fileContent: Enumerator[Array[Byte]] = Enumerator.fromFile(file)

    Result(
      header = ResponseHeader(200),
      body = fileContent
    )
  }

  /**
   * Tests the link to the shell is working -- echoes the string you give it and then returns it
   */
  def echoBack(s:String) = Action { request =>
    Ok(ShellService.echoBack(s))
  }

  /**
   * Tests file handling is working -- receives a file, runs a shell script to get its length, and returns the length
   */
  def echoLs = Action(parse.temporaryFile) { request =>
    Ok(ShellService.echoLs(request.body.file))
  }







}