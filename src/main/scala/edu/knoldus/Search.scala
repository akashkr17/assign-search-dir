package edu.knoldus

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future
import scala.language.postfixOps

object Search {

  def getFilesTree(path: String): Future[List[String]] = Future {
    def getFilesHelper(dir: File, acc: Boolean = true): List[File] = {
      val files = dir.listFiles
      files ++
        files
          .filter(_.isDirectory)
          .filter(_ => acc)
          .flatMap(getFilesHelper(_, acc))
    }.toList
    val list: Seq[File] = getFilesHelper(new File(path))
    list.asInstanceOf[List[String]]
  }
}
