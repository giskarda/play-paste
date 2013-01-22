package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import gpasties.HbaseHelper

object Paste extends Controller {

  val pasteForm = Form(
    "Paste" -> nonEmptyText
  )

  val hbase = new HbaseHelper

  def newPaste = Action { implicit request =>
    pasteForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(errors)),
      label => {
	lazy val key = hbase.put(label)
	Redirect(routes.Paste.showPaste(key))
      }
    )
  }

  def showPaste(id: String) = Action {
    var value = hbase.get(id)
    Ok(views.html.showPaste(id,value))
  }
    
}
