package tutorial.webapp

import org.scalajs.dom
import tutorial.webapp.Color.Magenta

import scala.collection.mutable.ArrayBuffer

class Obstacles(ctx: dom.CanvasRenderingContext2D) {
  val obstacles = ArrayBuffer[Obstacle]()
  obstacles += Obstacle(ctx)
  obstacles += Obstacle(ctx)

  def isCollision(playerX: Int, playerY: Int) :Boolean = {
  obstacles.map(o => o.isCollision(playerX,playerY)).foldLeft(false)(_ || _)
  }

  def draw(): Unit = {
  obstacles.foreach(_.draw())
  }
  def move(): Unit = {
    obstacles.foreach(_.move())
  }

  def stop(): Unit = {
    obstacles.foreach(o => o.speed=0)
  }
}
