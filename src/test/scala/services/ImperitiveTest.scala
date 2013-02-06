package services
import org.scalatest._

class ImperativeTest extends FunSpec with ShouldMatchers {
  
  describe("Functions to solve 'should filter out an earned badge'") {
    
    case class Vegetable(name: String, nasty: Boolean)
    
    val veggies = List(
        Vegetable("corn", nasty=false), 
        Vegetable("lima beans", nasty=false), 
        Vegetable("beets", nasty=true),
        Vegetable("broccoli", nasty=true)
    )
    
    it("is ok to build a list in a loop, but using List.map might be better (see FunctionalTest)") {
      var veggieNames: List[String] = Nil
      veggies.foreach(veggie => veggieNames = veggie.name :: veggieNames)
      veggieNames = veggieNames.reverse
      veggieNames should be(List("corn", "lima beans", "beets", "broccoli"))
    }
    
    it("is ok to build a set in a loop, but using List.toSet might be better (see FunctionalTest)") {
      var veggieNames: Set[String] = Set()
      veggies.foreach(veggie => veggieNames = veggieNames + veggie.name)
      veggieNames should be(Set("corn", "lima beans", "beets", "broccoli"))
    }
      
  }

}