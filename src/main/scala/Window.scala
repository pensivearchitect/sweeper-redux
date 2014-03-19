package Window

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import javafx.scene.image._
import javafx.scene.control.Label

class Picture extends Application {
  override def start(primaryStage: Stage) = {
    val pane: StackPane = new StackPane
    val scene: Scene = new Scene(pane)
    primaryStage.setTitle("Sweeper")
    primaryStage.setScene(scene)
    primaryStage.show()
    // TODO get actual image
    var img: Image = new Image("nameofImage")
    val view: ImageView = new ImageView(img)
    pane.getChildren().add(view)
  }
}
