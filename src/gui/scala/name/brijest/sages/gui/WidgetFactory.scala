package name.brijest.sages.gui



/**
 * An abstract factory used to provide implementations of the traits
 * used in UI. Various implementation kits will provide different
 * widget implementations.
 * Calling these methods does not create a new instance of the object - it
 * must always return the same instance. Another factory may return it's
 * own instances, but repetitive calls to methods of the same factory always
 * return the same objects.
 */
trait WidgetFactory {
  def canvas: ModelCanvas
  def miniMap: MiniMap
  def townList: TownList
  def sageList: SageList
  def objectDisplay: ObjectDisplay
}







