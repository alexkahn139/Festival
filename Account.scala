package Festival

import scala.collection.mutable.ArrayBuffer
/**
  * Created by alexandre on 02/12/2016.
  */
class Account(name: String, age: Int, email: String, var budget: Int) {
  var boughtGoods = Set.empty[Ticket[TicketType]]
  def buyEarlybird: Unit ={
    val name: EarlyBird = new EarlyBird
    if (budget > name.price){
      budget = budget - name.price
      //boughtGoods.add
    }
    else {
    printf("Not enough budget")
    }
  }

}