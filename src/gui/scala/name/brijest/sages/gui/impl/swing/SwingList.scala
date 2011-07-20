package name.brijest.sages.gui.impl.swing


import javax.swing._

import scala.swing._

import name.brijest.sages.model.Instance
import name.brijest.sages.gui.Fundamental._
import name.brijest.sages.gui._


abstract class ImagePanel extends javax.swing.JPanel {
  class ImageSlot(instance: Instance, drawer: Drawer) extends JComponent with java.awt.event.MouseListener {
    setPreferredSize(new java.awt.Dimension(towniconsize._1, towniconsize._2))
    override def paintComponent(gold: java.awt.Graphics) {
      val g = gold.asInstanceOf[java.awt.Graphics2D]
      drawer.draw(0, 0, new SwingDrawAdapter(g))
    }
    def mouseExited(e: java.awt.event.MouseEvent) {
    }
    def mouseEntered(e: java.awt.event.MouseEvent) {
    }
    def mouseReleased(e: java.awt.event.MouseEvent) {
    }
    def mousePressed(e: java.awt.event.MouseEvent) {
    }
    def mouseClicked(e: java.awt.event.MouseEvent) {
      onSlotClick(instance)
    }
  }
  
  def onSlotClick(inst: Instance): Unit
  def refill(lst: List[(Instance, Drawer)]) {
    removeAll
    setLayout(new java.awt.BorderLayout)
    val toppanel = new javax.swing.JPanel
    val botpanel = new javax.swing.JPanel
    add(toppanel, java.awt.BorderLayout.NORTH)
    add(botpanel, java.awt.BorderLayout.CENTER)
    toppanel.setLayout(new javax.swing.BoxLayout(toppanel, javax.swing.BoxLayout.Y_AXIS))
    for ((inst, drawer) <- lst) toppanel.add(new ImageSlot(inst, drawer))
  }
}

abstract class SwingList extends ScrollPane {
  peer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS)
  peer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER)
  val imgpan = new ImagePanel {
    def onSlotClick(inst: Instance) = slotClicked(inst)
  }
  val contentPane = new Panel {
    override lazy val peer = imgpan
  }
  viewportView = contentPane
  preferredSize = new java.awt.Dimension(towniconsize._1 + 2 + UIManager.get("ScrollBar.width").asInstanceOf[Int], 400)
  minimumSize = preferredSize
  maximumSize = preferredSize
  
  def slotClicked(inst: Instance): Unit
  def width = size.width
  def height = size.height
}

class SwingTownList extends SwingList with TownList {
  def refillTowns(lst: List[(Instance, Drawer)]) = imgpan.refill(lst)
  def slotClicked(inst: Instance) = onTownClick(inst)
}

class SwingSageList extends SwingList with SageList {
  def refillSages(lst: List[(Instance, Drawer)]) = imgpan.refill(lst)
  def slotClicked(inst: Instance) = onSageClick(inst)
}














