package user

case class User(
   userName: String,
   companyName: String,
   email: String,
   password: String) {

    def validate: Boolean = password.length >= 8

    def getSignature: String = if (companyName.isEmpty) {
        if (validate) {
            userName + " OK"
        } else {
            userName + " NG"
        }
    } else {
        if (validate) {
            companyName + ": " +  userName + " OK"
        } else {
            companyName + ": " +  userName + " NG"
        }
    }
}
