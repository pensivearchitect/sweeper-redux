package actorAPI
import java.awt.image.BufferedImage
import akka.actor._
import akka.event.Logging
import akka.dispatch._
import java.utl.Calendar
import akka.io.{ IO, Tcp }
import java.io._
// import akka.actor.mailbox.filebased.FileBasedMailBoxType
import javax.imageio.ImageIO
import system._

abstract class genericActor extends Actor
  with RequiresMessageQueue[BoundedMessageQueueSemantics] {
}

trait ActorTraits extends genericActor {
  val log = Logging(context.system, this)
  def actorProperties(name: String): Props = Props(classOf[genericActor], name)
}

class AsynchronousImageWriter extends ActorTraits {
  val calendar = Calendar.getInstance()
  val filename = (calendar.getTimeInMillis + ".png").toString
  // I might consider writing the cons of the array atomically, hence the name of the val
  writeDispatcher = akka.actor.mailbox.filebased.FileBasedMailBoxType
  ImageIO.write(image, "png", new File(filename))
  val actorDispatcher = system.actorOf(Props[actorProperties].
    withDispatcher("writeDispatcher"), name = "dispatcher")
}

