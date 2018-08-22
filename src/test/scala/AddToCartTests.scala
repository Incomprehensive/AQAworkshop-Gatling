import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef.http

import scala.language.postfixOps
import scala.concurrent.duration._

/**
  * Created by Nigel for workshop 22.08.18
  */

class AddToCartTests extends Simulation{

  val httpConf = http.baseURL(EnvConfig().getString("env.mainUrl"))

  val scn = scenario("AddToCart")
    .exec(AddToCartRequests.getAddToCart)

  setUp(scn.inject(constantUsersPerSec(
    EnvConfig().getInt("loading.usersCount")) during(
    EnvConfig().getInt("loading.duration") seconds)).protocols(httpConf))

}
