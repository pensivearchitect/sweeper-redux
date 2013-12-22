package image {
import java.awt._
import java.util.Calendar
import java.io._
import javax.imageio.ImageIO
  object generate {
  val robot = new Robot()
  val awtException = new AWTException("I failed as a programmer and introduced a 'bug'")
  val calendar = Calendar.getInstance()
// val colors = srgb(0.5137, 0.4078, 0.2824)

  // User input, will be variable in subsequent snapshots
  var mapX: Int = 0
  var mapY: Int = 0
  var MAP_LENGTH: Int = 330 //I'm fudging this but functionality > accuracy
  var mapXLength: Int = WINDOW_LENGTH
  var mapYLength: Int = WINDOW_LENGTH
  
  val filename = (calendar.getTimeInMillis + ".png").toString
  val screenSize = Toolkit.getDefaultToolkit.getScreenSize
  var rect = new Rectangle(  0, 0,  screenSize.width, screenSize.height)
  val bufferedImage = robot.createScreenCapture(rect)
  ImageIO.write(bufferedImage, "png", new File(filename))
  }
}
