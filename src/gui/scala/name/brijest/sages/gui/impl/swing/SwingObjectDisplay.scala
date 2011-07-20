package name.brijest.sages.gui.impl.swing


import scala.swing._

import name.brijest.sages.model.Instance
import name.brijest.sages.gui._


class SwingObjectDisplay extends Panel with ObjectDisplay {
  preferredSize = new java.awt.Dimension(150, 250)
  maximumSize = new java.awt.Dimension(150, 250)
  
  def onSelect(inst: Option[Instance]) {
    // TODO
  }
  def width = size.width
  def height = size.height
}
