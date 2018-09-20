package fizzbuzz

import org.scalatest.WordSpec

class FizzBuzzTest extends WordSpec {
    "FizzBuzz" should {
        "play FizzBuzz from number" in {
            Seq(
                (1, "1"),
                (2, "2"),
                (3, "Fizz"),
                (5, "Buzz"),
                (10, "Buzz"),
                (12, "Fizz"),
                (15, "FizzBuzz"),
                (30, "FizzBuzz")
            ).foreach {
                case (x, expected) =>
                    assert(FizzBuzz.play(x) == expected)
            }
        }
    }
}
