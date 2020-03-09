object HelloWorld{
  def main(args: Array[String]):Unit ={
  val x =10;
  var y =10;
  //x = 100;
  y = 100;
    println(x)
    println(y)
    println(sum(x,y))
}
  def sum(x : Int, y : Int) = x + y
}