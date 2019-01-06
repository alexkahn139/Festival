package Festival

/**
  * Created by alexandre on 24/12/2016.
  */
object Main extends App {
  val alex = new Account("alex", 22, "alexkahn@vub.be", 20)
  alex.placeOrder(List(new VIP("Alexandre"), new VIP("Jos"), new Beer, new Beer, new Beer, new Hamburger, new Hamburger)) //Een eerste keer bestellen, zou moeten zeggen dat er niet genoeg geld is
  alex.addBudget(500) // Extra geld bij doen enkel het eten en drinken zijn erdoor gekomen
  alex.placeOrder(List(new VIP("Alexandre"), new VIP("Jos"), new Beer))  // Nu werkt het wel

  //We gaan de logs checken
  Logs.print
  //We gaan ze hierna leegmaken om het overzichtelijker te maken
  Logs.deleteLogs

  // Jan is te jong voor een normaal ticket of een VIP, maar een earlybird gaat wel
  val jan = new Account("jan", 13, "jan@jan.be", 100)
  jan.placeOrder(List(new Normal("Jan"), new Cola, new Cola, new Hamburger))
  jan.placeOrder(List(new EarlyBird("Jan")))

  // Bij Jos zal zijn ticket er niet doorkomen, aangezien dit al besteld is via alex
  val jos = new Account("jos", 18, "jos@jos.be", 200)
  jos.placeOrder(List(new Normal("Jos")))

  //Hierna gaan we nogmaals de logs checken
  Logs.print
}
