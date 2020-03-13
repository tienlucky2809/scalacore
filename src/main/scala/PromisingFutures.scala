import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

  class PromisingFutures {
    val oneFuture: Future[Int] = Future {
      Thread.sleep(1000)
      1
    }
    val oneDangerousFuture = Future {
      Thread.sleep(2000)
      throw new SomeComputationException("Welcome to the Dark side !")
    }
    case class SomeComputationException(msg: String) extends Exception(msg)

    def printFuture[Try](future: Future[Try]): Unit = future.onComplete {
      case Success(result) => println(s"Success $result")
      case Failure(throwable) => println(s"Failure $throwable")
    }
  }


    object PromisingFutures{

      def main(args: Array[String]) {
        val promisingFutures=new PromisingFutures
        promisingFutures.printFuture(promisingFutures.oneFuture)
        promisingFutures.printFuture(promisingFutures.oneDangerousFuture)

        synchronized(wait(3000))
      }
    }
