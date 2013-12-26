package persistentList

import java.awt.image.BufferedImage
import scala.collection.mutable.ListBuffer

abstract class listBuffer {
  val ImmutableImageList = new ListBuffer[BufferedImage]
}
 class ImageOperations extends listBuffer {
   def appendToList(newImage: BufferedImage): List[BufferedImage] = {
    val newList = ImmutableImageList += newImage
     newList.toList
   }
}










