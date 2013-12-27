package actorAPI

import java.awt.image.BufferedImage
import java.io._
import java.util.Calendar
import javax.imageio.ImageIO
import akka.actor.Actor
import akka.actor.Props
import akka.dispatch._
import akka.event.Logging

abstract class genericActor extends Actor
  with RequiresMessageQueue[BoundedMessageQueueSemantics] {
  import context._
  val log = Logging(context.system, this)
  def actorProperties(name: String): Props = Props(classOf[genericActor], name)

}

trait ImageTraits {
  val calendar = Calendar.getInstance()
  val filename = (calendar.getTimeInMillis + ".png").toString
  case class WriteableImage(image: BufferedImage)

}

object AsyncImageWriter extends genericActor with ImageTraits {
  def receive: Receive = {
    case WriteableImage =>
      sender ! ImageIO.write(_: BufferedImage, "png", new File(filename))

  }
}

