package tutorial.webapp

import org.scalajs.dom
import tutorial.webapp.Color.Magenta
import scala.util.Random

class Obstacle(val ctx: dom.CanvasRenderingContext2D, var x: Int, var y: Int) {
  var speed = 3

  def draw(): Unit = {
    ctx.fillStyle = Magenta
    ctx.fillRect(x, y, 30, 30)
  }
  def move(): Unit = {
    x -= speed

    if ((x + 30) < 0) {
      x = 600
      y = Obstacle.random.nextInt(370)
    }
  }

  def isCollision(playerX: Int, playerY: Int): Boolean = {
    (playerX + 100) > x && playerX < x && (playerY + 100) > y && playerY > y
  }


}

object Obstacle {
  val random = new Random()

  def apply(ctx: dom.CanvasRenderingContext2D): Obstacle = {
    new Obstacle(ctx, 590, random.nextInt(370))
  }
}
