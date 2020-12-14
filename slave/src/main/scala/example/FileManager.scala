package Slave

import java.io.File

import scala.io.Source

object FileManager {
  def readAll() = {
    val fileList = getListOfFiles("./testData/slave1")

    for (filePath <- fileList) {
      val source = Source.fromFile(filePath)
      for (line <- source.getLines()) {
        val key = line.split(" ")(0)
        println(key)
      }
      source.close()
    }
  }

  def readSamples() = {
    val source = Source.fromFile(getListOfFiles("./testData/slave1")(0))
    val lines = source.getLines().take(10)

    val result = lines.map(x => x.split(" ")(0)).toList
    source.close()
    result
  }

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
}