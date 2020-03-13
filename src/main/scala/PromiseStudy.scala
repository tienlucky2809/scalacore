import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Promise, Future}
import scala.concurrent.duration._

object PromiseStudy extends App {
  val promiseGetInt: Promise[Int] = Promise[Int]
  val promiseToFuture: Future[Int] = promiseGetInt.future

  val mappedFuture = promiseToFuture.map { i =>
    println(s"Fin. i: ${i}")
  }

  Future {
    Thread.sleep(1000)
    promiseGetInt.success(3)
  }

  Await.ready(mappedFuture, 10000.millisecond)
}