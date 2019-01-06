package Festival

import scala.collection.mutable.ArrayBuffer

/**
  * Created by alexandre on 28/12/2016.
  */
object Logs{
  var loglist = ArrayBuffer.empty[String]
  def log(str: String): Unit ={
    loglist += str
  }
  def print: Unit = {
    for (x <- loglist){
      println(x)
    }
  }
  def deleteLogs: Unit = {
    loglist = ArrayBuffer.empty[String]
  }
}