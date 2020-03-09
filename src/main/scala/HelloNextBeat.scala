

object HelloNextBeat {
  implicit class RichString(val src:String){
    def res:String= src + "さん,こんにちは"
  }
  def main(args: Array[String]):Unit ={
  println("-----------define class-------------")
    val nameinfo = new  NameInfo(1,"Taro","Yamada")
    println(nameinfo.getFullname())
  }
  println("-----------implicit convension-------------")
  val richString:String = "TienLucky".res
  println(richString)
  println("-----------implicit parameter-------------")
  def payLoan(amount: Float)(implicit interestRate: Float): Float = amount + amount * interestRate
  val pay = payLoan(2201100)(3.0F)
  println(pay)

//  implicit val interestRate: Float = 2.0F
//  println(payLoan(22001100))


  println("-----------implicit funtion-------------")
  implicit def interestRate(implicit isFriend: Boolean): Float = if (isFriend) 0.3F else 0.0F
  implicit val isFriend = false
  println(payLoan(2201100))
}

class NameInfo(val id: Long, val firstname: String, val lastname: String) {
  def getFullname() = this.firstname + " " + this.lastname
}

//class NameInfo(val id: Long, val firstname: String, val lastname: String, val fullname: Fullname = new Fullname) {
//  def getFullname() = this.fullname.get(firstname,lastname)
//}


class Fullname() {
  def get(firstname: String, lastname: String):String = firstname + " " + lastname
}




