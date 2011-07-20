package name.brijest.sages.controller.impl.controllers


import name.brijest.sages.model.OpResult
import name.brijest.sages.model.ModelView
import name.brijest.sages.model.Model
import name.brijest.sages.model.Event

import name.brijest.sages.controller._



/**
 * Mock controller.
 */
class MockController(model: Model) extends Controller {
  model.setBeholder(this)
  
  def send(c: Command)(inf: OpResult=>Unit) = inf (model.execute(c.getExecution, c.senderIndex))
  def view(op: ModelView => Unit) = op(model)
  def receiveEvent(e: Event) = raise(e)
}














