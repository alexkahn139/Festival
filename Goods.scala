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


class Goods[+T] (val goodsType: List[T] = List.empty[T]){
  def insert [S >:T](x:S):Goods[S] = new Goods[S](x::goodsType)
}




