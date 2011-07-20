package name.brijest.sages.gui.initializer


import name.brijest.sages.model.Instance
import name.brijest.sages.model.Event
import name.brijest.sages.model.RemoveInstanceEvent
import name.brijest.sages.controller.EventListener

import name.brijest.sages.gui._



object SelectObjectListening extends InitializionPart {
  def init(in: Initializer) {
    import in._
    
    // set selected object listener
    factory.canvas.addObjectActionListener(new ObjectActionAdapter {
      override def onObjectClick(inst: Instance) {
        factory.objectDisplay.selected = Some(inst)
        guistate.selectedObject = Some(inst)
//        println("selected " + guistate.selectedObject)
      }
    })
    factory.canvas.addTerrainActionListener(new TerrainActionAdapter {
      override def onTerrainRightClick(t: (Int, Int)) {
        factory.objectDisplay.selected = None
        guistate.selectedObject = None
        
        if (guistate.pathDecorations != None) {
          val Some(decs) = guistate.pathDecorations
          factory.canvas.removeTerrainDecorationList(decs)
          guistate.pathDecorations = None
        }
      }
    })
    ctrl.addListener(new EventListener {
      def listens = classOf[RemoveInstanceEvent] :: Nil
      def onEvent(e: Event) = e match {
        case RemoveInstanceEvent(loc, inst) => if (guistate.selectedObjectIndex == inst.index) {
          guistate.selectedObject = None
          factory.objectDisplay.selected = None
        }
      }
    })
  }
}













