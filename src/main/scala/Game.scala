import java.nio.file.Paths

import javafx.scene.media.{Media, MediaPlayer}

import scala.concurrent.Future
import scala.io.{Source, StdIn}
import scala.util.{Random, Try}


class Game(conf : Configuration) {
  implicit val ec = scala.concurrent.ExecutionContext.global
  def start() = {
    Random.setSeed(1)
    val startTime = System.currentTimeMillis() / 1000
    val result = (1 to 10).map(new Problem(_)).count{_.isCorrect}
    println(s"$result/10 せんかい")
    val endTime = System.currentTimeMillis() / 1000
    println(s"${endTime - startTime}びょう")
  }


}


