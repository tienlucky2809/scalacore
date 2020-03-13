

object CollectionDemo{


  def main(args: Array[String]):Unit = {

    println("Step 1: How to initialize a Sequence of donuts")
    val donuts1: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
    val arr = List(1,2,3,4,5)
    //println(s"Elements of donuts1 = $donuts1")
    donuts1.foreach(println(_))
    arr.foreach(println(_))

    for(x <- arr){
      print(s"$x  " + " ")
    }

  }
}