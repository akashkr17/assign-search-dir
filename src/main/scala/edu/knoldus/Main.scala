package edu.knoldus
import edu.knoldus.Search.getFilesTree
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.Await

object Main extends App {

  val path = "./src"
  val resp = getFilesTree(path)
  Await.result(resp, Duration.Inf)
  resp map (paths => paths map println)

}
