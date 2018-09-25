package user

import org.scalatest.FunSpec

class UserSpec extends FunSpec {

    describe("User") {

        val correctPassword = "12345678"
        val wrongPassword = "1234567"
        val userName = "田中太郎"
        val companyName = "株式会社ほげ"

        describe("validate") {
            it("パスワードが8文字以上の場合にはtrue") {
                // Arrange
                val user = User("", "", "", correctPassword)
                // Act
                val actual = user.validate
                // Assert
                assert(actual == "OK")
            }

            it("パスワードが8文字未満の場合にはfalse") {
                // Arrange
                val user = User("","","", wrongPassword)
                // Act
                val actual = user.validate
                // Assert
                assert(actual == "NG")
            }
        }

        describe("getSignature") {
            it("会社名がある場合は会社名も表示") {
                // Arrange
                val user = User(userName, companyName, "", correctPassword)
                // Act
                val actualSignature = user.getSignature
                val expectedSignature = "株式会社ほげ: 田中太郎 OK"
                // Assert
                assert(actualSignature == expectedSignature)
            }

            it("会社名がない場合は氏名のみ表示") {
                // Arrange
                val user = User(userName, "", "", correctPassword)
                // Act
                val actualSignature = user.getSignature
                val expectedSignature = "田中太郎 OK"
                // Assert
                assert(actualSignature == expectedSignature)
            }
        }

    }
}
