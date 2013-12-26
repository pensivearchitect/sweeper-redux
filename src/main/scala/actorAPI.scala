package actorAPI
import java.awt.image.BufferedImage
import akka.event.Logging
import akka.dispatch._
import akka.actor.Actor
import java.util.Calendar
import akka.io.{ IO, Tcp }
import akka.actor.Props
import akka.dispatch.RequiresMessageQueue
import akka.dispatch.BoundedMessageQueueSemantics
import java.io._
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

