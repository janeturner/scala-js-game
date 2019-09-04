package tutorial.webapp



import org.scalajs.dom
import dom.document
import org.scalajs.dom.html.Canvas
import org.scalajs.dom.raw.HTMLImageElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import tutorial.webapp.Color._


object TutorialApp {
  def main(args: Array[String]): Unit = {
    createGame()
  }


  def createGame() = {

    var playerX = 100
    var playerY = 190


    var obstacleX = 590
    var obstacleSpeed = 3

    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    canvas.width = 600
    canvas.height = 400


    dom.document.body.appendChild(canvas)

    def drawThings(): Unit = {
      //draw Canvas
      val bgImage = new Image("images/background.png")
      ctx.drawImage(bgImage.element, 0, 0, canvas.width, canvas.height)
     // drawRect(0, 0, canvas.width, canvas.height, Black)

      val flyingPig = new Image("images/flying-pig1.png")
      ctx.drawImage(flyingPig.element, playerX, playerY, 100, 100)
      //draw player
      //drawRect(playerX, playerY, 15, 15, Blue)

      //draw obstacle
      drawRect(obstacleX, 200, 10, 200, Magenta)

      if (playerX == obstacleX) stopGame()

    }

    def drawRect(x: Double, y: Double, width: Int, height: Int, colour: String) = {
      ctx.fillStyle = colour
      ctx.fillRect(x, y, width, height)
    }

    def moveThings(): Unit = {
      obstacleX -= obstacleSpeed
    }

    def stopGame() = {
      ctx.clearRect(0, 0, canvas.width, canvas.height)
    }
    class Image(src: String) {
      private var ready: Boolean = false

      val element = dom.document.createElement("img").asInstanceOf[HTMLImageElement]
      element.onload = (e: dom.Event) => ready = true
      element.src = src

      def isReady:Boolean = ready
    }

    class Component(x: Int, y: Int, width: Int, height: Int, colour: String) {
      def draw() {
        drawRect(x, y, width, height, colour)
      }
    }



    js.timers.setInterval(28) {
      drawThings()
      moveThings()
    }

    dom.window.addEventListener("keydown", (p: dom.KeyboardEvent) => {
      p.keyCode match {
        case 37 => playerX -= 3
        case 38 => playerY -= 3
        case 39 => playerX += 3
        case 40 => playerY += 3
        case _ => println("the keycode is " + p.keyCode)
      }
    }, false)


  }
}
