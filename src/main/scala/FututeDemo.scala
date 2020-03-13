import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FututeDemo {
   def main(args: Array[String]):Unit = {
     print("1")
     val oneFuture: Future[Int] = Future {
       Thread.sleep(1000)
       1
     }


     def checkState(): Unit = {
       println("Before the job finishes")
       Thread.sleep(100)
       println(s"Completed : ${oneFuture.isCompleted}, Value : ${oneFuture.value}")

       println("After the job finishes")
       Thread.sleep(1100)
       println(s"Completed : ${oneFuture.isCompleted}, Value : ${oneFuture.value}")
     }
     checkState()


   }




}
