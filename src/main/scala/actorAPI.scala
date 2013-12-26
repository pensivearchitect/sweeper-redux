package actorAPI

import dispatch._
import java.awt.image.BufferedImage
import java.io._
import java.util.Calendar
import javax.imageio.ImageIO

abstract class genericActor extends Actor
  with RequiresMessageQueue[BoundedMessageQueueSemantics] {
}

trait ActorTraits extends genericActor {
  val log = Logging(context.system, this)
  def actorProperties(name: String): Props = Props(classOf[genericActor], name)
}

abstract class AsynchronousImageWriter extends ActorTraits {
  val calendar = Calendar.getInstance()
  val filename = (calendar.getTimeInMillis + ".png").toString
  ImageIO.write(_: BufferedImage, "png", new File(filename))
 // val actorDispatcher = // TODO: Write dispatcher
}

