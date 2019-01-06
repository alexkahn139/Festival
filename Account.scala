package Festival

import scala.collection.mutable.ArrayBuffer
import java.util.Calendar
/**
  * Created by alexandre on 02/12/2016.
  */
class Account(name: String, age: Int, email: String, var budget: Int) {
  private val now = Calendar.getInstance() // Dient zodat we de tijd kunnen opvragen
  // Based from: http://alvinalexander.com/scala/scala-get-current-date-time-hour-calendar-example
  private var goodsToMail = ArrayBuffer.empty[Goods]
  var ticketsToMail = ArrayBuffer.empty[Goods]
  //We maken lege ArrayBuffers die we opvullen met de opties die geaccepteerd worden
  def addBudget(money: Int): Unit ={
    budget+= money
  }
  private var totalPrice: Int = 0
  private def orderInstance(goods: Goods){
    if (goods.price < budget){
      budget = budget - goods.price
      if (goods.isInstanceOf[TicketType]){
        orderTicket(goods)
      }
      else {
        totalPrice = totalPrice + goods.price
        goodsToMail += goods
      }
    }
    else {
      println("You don't have enough budget")
    }
    val currentMinute = now.get(Calendar.MINUTE)
    val currentHour = now.get(Calendar.HOUR_OF_DAY)
    Logs.log(s"Order of $name is confirmed at: $currentHour:$currentMinute")

  }
  private def orderTicket(goods: Goods): Unit ={
    if (!goods.isInstanceOf[EarlyBird] && age < 16){
      println("You are to young to buy this type of ticket")
    }
    else if (TicketDatabase.checkName(goods.name)){
      println(s"You can only buy one ticket. ${goods.name} already has a ticket.")
    }
    else {
      totalPrice = totalPrice + goods.price
      TicketDatabase.add(goods)
      ticketsToMail += goods
    }
    val currentMinute = now.get(Calendar.MINUTE)
    val currentHour = now.get(Calendar.HOUR_OF_DAY)
    Logs.log(s"Age of $name is checked at: $currentHour : $currentMinute")
  }
  def placeOrder(list: List[Goods]): Unit ={ //Hoofdfunctie om een bestelling te plaatsen
    list.foreach(i => orderInstance(i)) //Loopt over de lijst van bestellingen
    sendMail(goodsToMail, ticketsToMail) //Eens dit gedaan is een mail sturen naar de klant
   // totalPrice = 0
  }
  private def sendMail(goodsToEmail: ArrayBuffer[Goods],ticketsToEmail: ArrayBuffer[Goods]): Unit = {
    //Geen echte mail, maar wordt geprint
    var goodslist = goodsToEmail
    var ticketlist = ticketsToEmail
    ticketlist = ticketlist.sortWith(_.name < _.name)
    goodslist = ticketlist ++ goodslist
    goodslist = goodslist.sortWith(_.price > _.price)
    if (goodslist.nonEmpty) {
      println(s"Dear $name,")
      println("You have ordered: ")
      for (x <- goodslist) {
        val price = x.price
        if (x.isInstanceOf[TicketType]) {
          val name: String = x.name
          printf(s"$x for ")
          printf(name)
          println(": $price")
        } else println(s"$x : $price")
      }
      println(s"The total is €$totalPrice")
      // Alles terug op nul zetten voor de volgende bestelling
      goodsToMail = ArrayBuffer.empty[Goods]
      ticketsToMail = ArrayBuffer.empty[Goods]
      totalPrice = 0
    }
  }
}
