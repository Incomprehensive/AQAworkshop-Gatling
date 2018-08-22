import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef.http

import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by Nigel for workshop 22.08.18
  */
class ServiceCartsTests extends Simulation{

  val httpConf = http.baseURL(EnvConfig().getString("dev.cartsUrl"))

  val scn = scenario("CartsServicePostNewCart").exec(ServiceCartsRequests.postNewCartId)

  setUp(scn.inject(constantUsersPerSec(
    EnvConfig().getInt("loading.usersCount")) during(
    EnvConfig().getInt("loading.duration") seconds)).protocols(httpConf))
}
