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
// start of practice code

//  class Game() {
//    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
//    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
//    canvas.width = 600
//    canvas.height = 400
//
//
//    def clear() = {
//      this.ctx.clearRect(0, 0, canvas.width, canvas.height)
//    }
//
//    def start(): Unit = {
//      dom.document.body.appendChild(canvas)
//      js.timers.setInterval(28) {
//        updateGameArea()
//      }
//    }
//  }
//
//  class Component(x: Int, y: Int, width: Int, height: Int, colour: String) {
//    var pieceX = this.x
//
//    val ctx = myGameArea.ctx
//
//    def update() {
//      ctx.fillStyle = colour
//      ctx.fillRect(pieceX, y, width, height)
//    }
//  }
//  val myGameArea = new Game()
//  val myGamePiece = new Component(10, 120, 30, 30, Red)
//
//  def updateGameArea(): Unit = {
//    myGameArea.clear()
//    myGamePiece.update()
//
//  }
//
//  def startGame(): Unit = {
//    myGameArea.start()
//    myGamePiece.update()
//    myGamePiece.pieceX += 5
//  }
//}

  // end of practice code
  def createGame() = {

    var playerX = 100
    var playerY = 190


    var obstacleX = 590
    var obstacleY = 200
    var obstacleSpeed = 3

    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    val bgImage = new Image("images/background.png")

    canvas.width = 600
    canvas.height = 400


    dom.document.body.appendChild(canvas)

    def drawThings(): Unit = {
      //draw Canvas
      ctx.drawImage(bgImage.element, 0, 0, canvas.width, canvas.height)
      // drawRect(0, 0, canvas.width, canvas.height, Black)

      val flyingPig = new Image("images/flying-pig1.png")
      ctx.drawImage(flyingPig.element, playerX, playerY, 100, 100)
      //draw player
      //drawRect(playerX, playerY, 15, 15, Blue)

      //draw obstacle
      drawRect(obstacleX, obstacleY, 30, 30, Magenta)


    }

    def drawRect(x: Double, y: Double, width: Int, height: Int, colour: String) = {
      ctx.fillStyle = colour
      ctx.fillRect(x, y, width, height)
    }

    def moveThings(): Unit = {
      obstacleX -= obstacleSpeed
    }

    def crash(): Unit = {
      // println(s"$playerX $obstacleX")

      if ((playerX + 100) > obstacleX && playerX < obstacleX && (playerY + 100) > obstacleY && playerY < obstacleY) {
        obstacleSpeed = 0
        // drawRect(0, 0, canvas.width, canvas.height, Black)
        ctx.drawImage(bgImage.element, 0, 0, canvas.width, canvas.height)
        ctx.fillStyle = Black
        ctx.font = "40px Helvetica"
        ctx.fillText("Game Over", 200, 200, 200)
        println("crash")
      }
    }

    class Component(x: Int, y: Int, width: Int, height: Int, colour: String) {
      def draw() {
        drawRect(x, y, width, height, colour)
      }
    }


    js.timers.setInterval(28) {
      drawThings()
      moveThings()
      crash()
    }


    dom.window.addEventListener("keydown", (p: dom.KeyboardEvent) => {
      println("player x =" + playerX + " and player y = " + playerY)
      p.keyCode match {

        case 37 => playerX -= 3
        case 38 => playerY -= 3
        case 39 => playerX += 3
        case 40 => playerY += 3
        case _ => println("the keycode is " + p.keyCode);
      }
    }, false)


  }
}
