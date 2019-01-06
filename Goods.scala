package Festival

import scala.collection.mutable.ArrayBuffer

/**
  * Created by alexandre on 02/12/2016.
  */

abstract class Goods{
  val price: Int
  val name: String = null
}
trait FoodAndDrinks extends Goods

class Hamburger extends FoodAndDrinks{
  override val price: Int = 5
}

class Beer extends Goods{
  override val price: Int = 2
}
class Cola extends Goods {
  override val price: Int = 1
}
object Ticket {
  private[this] var id: Int = 0
  def generateId(): Int = {
    id = id + 1; id
  }
}

trait TicketType extends Goods{
  val name: String
  val id: Int = Ticket.generateId()
}
class EarlyBird(newname: String) extends TicketType{
  override val price: Int =  50
  override val name: String = newname

}
class Normal(newname: String) extends TicketType{
  override val price: Int =  100
  override val name: String = newname
}

class VIP(newname: String) extends TicketType {
  override val price: Int = 200
  override val name: String = newname
}
object TicketDatabase{
  val database = ArrayBuffer.empty[Goods]   // Zou mooier zijn op ticket, maar maakt het onnodig moeilijk
  def add (goods: Goods): Unit ={
    database += goods
  }
  def checkName(nameToCheck: String) = database.exists(_.name == nameToCheck)
}


