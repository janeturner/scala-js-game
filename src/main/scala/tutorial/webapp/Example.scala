package tutorial.webapp

object Color {
  def rgb(r: Int, g: Int, b: Int) = s"rgb($r, $g, $b)"
  val White = rgb(255, 255, 255)
  val Red = rgb(255, 0, 0)
  val Green = rgb(0, 255, 0)
  val Blue = rgb(0, 0, 255)
  val Turquoise = rgb(0, 255, 255)
  val Magenta = rgb(255, 0, 255)
  val Yellow = rgb(255, 255, 0)
  val Black = rgb (0, 0, 0)
  val Orange = rgb(255, 165, 0)
  val Grey = rgb(192, 192, 192)
  val all = Seq(
    White,
    Red,
    Green,
    Blue,
    Turquoise,
    Magenta,
    Yellow,
    Black,
    Orange,
    Grey
  )
}