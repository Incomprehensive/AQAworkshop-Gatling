import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by Nigel for workshop 22.08.18
  */

object AddToCartRequests {

  val requestName = EnvConfig.env + "-Add-To-cart-"

  // Get Request
  val getAddToCart = http(requestName + "dev")
    .get("cart.php?add=55048&addOffer=888")
    .check(status.is(200))

}
