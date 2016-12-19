package Festival

/**
  * Created by alexandre on 19/12/2016.
  */
class TicketType
class EarlyBird extends TicketType{
  val price : Int = 50
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
