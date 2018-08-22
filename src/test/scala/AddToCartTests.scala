import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.PopulationBuilder
import io.gatling.http.Predef.http

import scala.language.postfixOps
import scala.concurrent.duration._

/**
  * Created by Nigel for workshop 22.08.18
  */

class AddToCartTests extends Simulation{

  val httpConf = http.baseURL(EnvConfig().getString("dev.mainUrl"))

  val addTemplateAndOnCartOffer = scenario("AddTemplateAndOnCartOffer")
    .exec(AddToCartRequests.getAddTemplateAndOnCartOfferToCart)

  val addOnCartOffertToCart = scenario("AddOnCartOffer")
    .exec(AddToCartRequests.getAddOnCartOfferToCart)

  val addTemplateTypesToCart = scenario("AddTemplateTypes")
    .exec(AddToCartRequests.getTemplateTypesToCart)

  val listScenario:
    List[PopulationBuilder] = List(
    addTemplateAndOnCartOffer.inject(constantUsersPerSec(
      EnvConfig().getInt("loading.usersCount")) during(
      EnvConfig().getInt("loading.duration") seconds)).protocols(httpConf)
    addTemplateTypesToCart.inject(constantUsersPerSec(
      EnvConfig().getInt("loading.usersCount")) during(
      EnvConfig().getInt("loading.duration") seconds)).protocols(httpConf),
    addOnCartOffertToCart.inject(constantUsersPerSec(
      EnvConfig().getInt("loading.usersCount")) during(
      EnvConfig().getInt("loading.duration") seconds)).protocols(httpConf),
  )

  setUp(
    listScenario
  )
}
