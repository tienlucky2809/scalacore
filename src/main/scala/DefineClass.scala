class DefineClass {
  class NameInfo(val id: Long, val firstname: String, val lastname: String, val fullname:Fullname = new Fullname) {
    def getFullname() = this.fullname.get(firstname,lastname)
  }

  class Fullname() {
    def get(firstname: String, lastname: String) = firstname + " " + lastname
  }

  val nameinfo = new  NameInfo(1,"Taro","Yamada")
  println(nameinfo.getFullname())

}
