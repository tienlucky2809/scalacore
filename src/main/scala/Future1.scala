//import scala.concurrent.{Await, Future}
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.duration._
//import scala.language.postfixOps
//import scala.util.{Failure, Random, Success}
//
//object Future1 extends App{
//  val s= "Hello"
//  val random = new Random()
//  val waitMaxMilliSec = 3000
//  val f: Future[String] = Future{
//    Thread.sleep(1000)
//    s + "Future"
//  }
//
//  f.foreach{ case s: String =>
//    println(s)
//  }
//
//  println(f.isCompleted)//false
//  Thread.sleep(4500)//HelloFuture
//  println(f.isCompleted)//true
//
//
//  def futureMilliSec: Future[Int] = Future {
//    val waitMilliSec = random.nextInt(waitMaxMilliSec);
//    if(waitMilliSec < 1000) throw new RuntimeException(s"waitMilliSec is ${waitMilliSec}" )
//    Thread.sleep(waitMilliSec)
//    waitMilliSec
//  }
//  val futureSec: Future[Double] = futureMilliSec.Map(i => i.toDouble / 1000)
//
//  futureSec onComplete{
//    case Success(waitSec) => println(s"True,${waitSec} sec")
//    case Failure(t) => println(s"Failure] ${t.getMessage}")
//  }
//  Thread.sleep(3000)
//
//  val futureFirst: Future[Int] = Future{waitRandom("first")}
//  val futureSecond: Future[Int] = Future{waitRandom("second")}
//
//  val compositeFuture: Future[(Int, Int)] = for{
//    first <- futureFirst
//    second <- futureSecond
//  }yield (first, second)
//
//  compositeFuture onComplete{
//    case Success((first, second)) => println(s"True,first:${first} second:${second}")
//    case Failure(t) => println(s"Failure: ${t.getMessage}")
//  }
//
//  Thread.sleep(1000)
//}