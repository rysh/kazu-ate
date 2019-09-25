import scala.io.StdIn
import scala.util.{Random, Try}

class Problem(val no: Int) {

  val a = random(10)
  val b = random(13 - a)



  showStatement()

  val ans = waitToInputAnswer()

  val message = answer()

  feedback()

  Thread.sleep(300)

  private def random(n: Int):Int = {
    val r = Random.nextInt(n)
    if (r != 0) {
      r
    } else {
      random(n)
    }
  }

  private def showStatement() = {
    println(s"$a + $b あわせていくつ？")
  }

  private def waitToInputAnswer() = {
    Try {
      val c = StdIn.readLine()
      println(c)
      val i = c.toString.toInt
      println(i)
      i
    }
  }

  private def answer() = {
    ans.map(answer => {
      println(s"$a + $b = $answer")
      val isCorrect = a + b == answer
      if (isCorrect) {
        "せいかい"
      } else {
        s"まちがい! $a + $b = ${a+b} だよ"
      }
    }).getOrElse("すうじをおしてね")
  }

  private def feedback() = {
    println(message)
  }

  def isCorrect() = ans.getOrElse(Int.MaxValue) == a + b
}
