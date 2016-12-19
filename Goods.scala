/**
  * Created by alexandre on 02/12/2016.
  */

abstract class GoodsType
class Hamburger extends GoodsType{
  val price: Int = 5
}
class Beer extends GoodsType{
  val price: Int = 2
}
class Cola extends GoodsType{
  val price: Int = 1
}
object Goods
class Goods[+T] (val goodsType: List[T] = List.empty[T]){
  def insert [S >:T](x:S):Goods[S] = new Goods[S](x::goodsType)
}


abstract class TicketType
class EarlyBird extends TicketType{
  val price: Int = 50
}
class Normal extends TicketType{
  val price: Int = 100
}
class VIP extends TicketType {
  val price: Int = 200
}
object Ticket{
  private[this] var id: Int = 0
  private def generateId(): Int = {id = id + 1; id}
}

class Ticket[+T] (val ticketType: List[T] = List.empty[T]) {
  val id: Int = Ticket.generateId()
  def insert [S >:T](x:S):Ticket[S] = new Ticket[S](x:: ticketType)
}
class EarlyBirdTicket extends  Ticket[EarlyBird]
class NormalTicket extends Ticket[Normal]
class VIPTicket extends Ticket[VIP]


