package services
import org.scalatest._

class FunctionalTest extends FunSpec with ShouldMatchers {
  
  describe("Functions to solve 'should filter out an earned badge'") {
    
    case class Vegetable(name: String, nasty: Boolean)
    
    val veggies = List(
        Vegetable("corn", nasty=false), 
        Vegetable("lima beans", nasty=false), 
        Vegetable("beets", nasty=true),
        Vegetable("broccoli", nasty=true)
    )
    
    it("is good to know List.map()") {
      val veggieNames = veggies.map(veggie => veggie.name)
      veggieNames should be(List("corn", "lima beans", "beets", "broccoli"))
    }
    
    it("is good to know List.toSet") {
      val veggieNames = veggies.map(veggie => veggie.name).toSet
      veggieNames should be(Set("corn", "lima beans", "beets", "broccoli"))
    }
    
    it("is good to know List.filter / List.filterNot") {
      val goodVeggies = veggies.filterNot(veggie => veggie.nasty)
      val nastyVeggies = veggies.filter(veggie => veggie.nasty)
      
      goodVeggies.map(veggie => veggie.name) should be(List("corn", "lima beans"))
      nastyVeggies.map(veggie => veggie.name) should be(List("beets", "broccoli"))
  	}
  
  }

}