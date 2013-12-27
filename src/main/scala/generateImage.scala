package generateImage
import java.awt._
import java.awt.image.BufferedImage
import persistentList.ImageOperations
import actorAPI.AsyncImageWriter

trait createImage { 
  lazy val robot = new Robot() // It would be best to lazily evaluate instantiation to demand less of the heap
  lazy val createList = new ImageOperations

  def getUserSelectedAreaAsImage: BufferedImage = { 
    lazy val screenSize = Toolkit.getDefaultToolkit.getScreenSize
    var rect = new Rectangle(0, 0, screenSize.width, screenSize.height)
    return robot.createScreenCapture(rect)
  }

  def returnCurrentImage(bufferedImage: BufferedImage): BufferedImage = {
    lazy val newList = createList.appendToList(bufferedImage)
    newList.toList
    return newList.head
  }

  def writeCurrentImage(currentImage: BufferedImage) = {
    AsyncImageWriter.receive(currentImage)
  }

}

