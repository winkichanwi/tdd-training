package user

case class User(
   userName: String,
   companyName: String,
   email: String,
   password: String) {

    def validate: String = if (password.length >= 8) "OK" else "NG"

    def getSignature: String = {
        if (companyName.isEmpty) {
            s"$userName $validate"
        } else {
            s"$companyName: $userName $validate"
        }
    }
}
