package imageInstantiationAndWritingAPI

import scalafx.application.Platform
import scalafx.geometry.Insets
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout.Priority
import scalafx.scene.layout.VBox
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import scalafx.Includes._
import generateImage._

class createWindow extends VBox with handleImage {
  def imageDisplay = new VBox {
    val verticalPriority = Priority.ALWAYS
    val horizontalPriority = Priority.ALWAYS
    spacing = 10
    padding = Insets(20)
    content = List(
      new ImageView {
        val getImage = {
          val currentImage: BufferedImage = getUserSelectedAreaAsImage
          def obtainedImage = returnCurrentImage(currentImage)
        }
        fitHeight = 300
        fitWidth = 300
        preserveRatio = true
        smooth = true

      })
  }
}

