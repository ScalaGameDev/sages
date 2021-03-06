package name.brijest.sages.gui.impl.swing


import scala.swing._
import scala.swing.event._

import name.brijest.sages.gui._

import java.awt.Graphics2D

/**
 * A swing implementation of the canvas.
 */
class SwingCanvas extends Component with ModelCanvas with Music {
  listenTo(this, Mouse.clicks, Mouse.moves)
  reactions += {
    case ComponentResized(c) => onResize
    case MouseMoved(src, p, modif) => onMouseMove(p.x, p.y)
    case MouseDragged(src, p, modif) if (modif == 4096) =>
      onRightMouseDrag(p.x, p.y)
    case MouseDragged(src, p, modif) if (modif == 1024) =>
      onMouseMove(p.x, p.y)
    case MouseClicked(src, p, modif, cl, tpop) if (modif == 0) =>
      // left click
      onLeftMouseClick(p.x, p.y)
    case MouseClicked(src, p, modif, cl, tpop) if (modif == 256) =>
      // right click
      onRightMouseClick(p.x, p.y)
    case MousePressed(src, p, modif, cl, tpop) if (modif == 4096) =>
      // left pressed
      onRightMousePressed(p.x, p.y)
    case MouseReleased(src, p, modif, cl, tpop) if (modif == 256) =>
      // left released
      onRightMouseReleased(p.x, p.y)
  }
  
  def width = size.getWidth.toInt
  def height = size.getHeight.toInt
  
  override protected def paintComponent(g: java.awt.Graphics2D) = paintCanvas(new SwingDrawAdapter(g))
  def invokeRepaint = repaint
}






















