package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  val pasteForm = Form(
    "label" -> nonEmptyText
  )
  
  def index = Action {
    Ok(views.html.index(pasteForm))
  }
  
}
