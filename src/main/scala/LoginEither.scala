sealed trait LoginError
case object InvalidPassword extends LoginError
case object UserNotFound extends LoginError
case object PasswordLocked extends LoginError

case class User(id: Long, name: String, password: String)

object LoginEither extends App {
  def login(name: String, password: String): Either[LoginError, User] = {
    (name, password) match {
      case ("Yamada", "pass1234") => Right(User(1, name, password))
      case ("Yamada", _) => Left(InvalidPassword)
      case (_, _) => Left(UserNotFound)
    }
  }
  login(name = "Yamada", password ="pass123") match{
    case Right(user) => println(s"success! Your ID is ${user.id}.")
    case Left(InvalidPassword) => println(s"Invalid Password...")
    case Left(UserNotFound) => println(s"Not Found your User...")
    case Left(PasswordLocked) => println(s"Password is Locked...")
  }
}