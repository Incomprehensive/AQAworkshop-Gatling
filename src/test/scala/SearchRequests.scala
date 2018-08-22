import io.gatling.core.Predef._
import io.gatling.http.Predef._

object SearchRequests {

  val requestName = EnvConfig.env + "-Search-"

  // Get Request
  val getSearch = http(requestName + "index")
    .get("cart.php?add=55048&addOffer=888")
    .check(status.is(200))

}
