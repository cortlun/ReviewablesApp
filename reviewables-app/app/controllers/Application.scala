package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current

object Application extends Controller {

  def index = Action {
    val ds = DB.getDataSource("graph")
    val con = ds.getConnection()
    val statement = con.createStatement()
    val rs = statement.executeQuery("MATCH (arnold {name:'Arnold Schwarzenegger'})-[*1..4]-(related) RETURN DISTINCT related.name")
    val sb = new StringBuilder()
    if (rs.next() != null){
      do {
        val s = rs.next().toString()
        sb.append(s + System.getProperty("line.separator"))
        
      } while (rs.next())
  }
    Ok(views.html.index("Searching nodes related to Arnold Schwarzenegger: " + rs.toString())) 
  }
}