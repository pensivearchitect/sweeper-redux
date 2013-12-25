package generateImage
import java.awt._
import java.awt.image.BufferedImage
import persistentList.ImageOperations
import scala._
import actorAPI._

trait createImage { // Not sure what to call it, this is merely a placeholder
 lazy val robot = new Robot() // It would be best to lazily evaluate class instantiation to demand less of the heap
 lazy val awtException = new AWTException("I failed as a programmer and introduced a bug") // Honesty is the best policy
 lazy val calendar = Calendar.getInstance()
 lazy val createList = new ImageOperations

  def getUserSelectedAreaAsImage: BufferedImage = { // I've been reading too much of the Java stdlib.
    lazy val screenSize = Toolkit.getDefaultToolkit.getScreenSize
    var rect = new Rectangle(0, 0, screenSize.width, screenSize.height)
    return robot.createScreenCapture(rect)
  }

  def returnCurrentImage(bufferedImage: BufferedImage): BufferedImage = {
   lazy val newList = createList.appendToList(bufferedImage)
    newList.toList
    return newList.head
  }

  // TODO: Write images asynchronously
  def writeCurrentImage(currentImage: BufferedImage) = {
   lazy val filename = (calendar.getTimeInMillis + ".png").toString // I am considering using map in lieu of OOP.
    ImageIO.write(currentImage, "png", new File(filename))
  }
}

