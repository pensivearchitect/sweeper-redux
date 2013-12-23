package generateImage
import java.awt._
import java.awt.image.BufferedImage
import java.io._
import java.util.Calendar
import javax.imageio.ImageIO
import persistentList.ImageOperations
import scala._

class createImage { // Not sure what to call it, this is merely a placeholder
  val robot = new Robot() // It would be best to lazily evaluate class instantiation to demand less of the heap
  val awtException = new AWTException("I failed as a programmer and introduced a bug") // Honesty is the best policy
  val calendar = Calendar.getInstance()
  val createList = new ImageOperations
  // val colors = srgb(0.5137, 0.4078, 0.2824) // Colors of the map, will probably default to user selection however.
  def getUserSelectedAreaAsImage = { // I've been reading too much of the Java stdlib.


    lazy val screenSize = Toolkit.getDefaultToolkit.getScreenSize

    var rect = new Rectangle(0, 0, screenSize.width, screenSize.height)

    val currentCapturedImage = robot.createScreenCapture(rect)
  }
  def returnCurrentImage(bufferedImage: BufferedImage) = {
    val newList = createList.appendToList(bufferedImage)
    newList.toList
    val currentImage = newList.head
  }

 // def writeCurrentImageAsychronously(currentImage: BufferedImage) = {
  def writeCurrentImage(currentImage: BufferedImage) = { // TODO: Write images asynchronously
    
    val filename = (calendar.getTimeInMillis + ".png").toString // I am considering using map in lieu of OOP.


    ImageIO.write(currentImage, "png", new File(filename))
  }
}

