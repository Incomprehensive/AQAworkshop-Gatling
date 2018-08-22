import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by Nigel for workshop 22.08.18
  */

object AddToCartRequests {

  val requestName = EnvConfig.env + "-Add-To-cart-"

  // Get Add Template And OnCart offer to Cart
  val getAddTemplateAndOnCartOfferToCart = http(requestName + "dev")
    .get("cart.php?add=55048&addOffer=804")
    .check(status.is(200))

  val getAddOnCartOfferToCart = http(requestName + "dev")
    .get("cart.php?addOffer=457")
    .check(status.is(200))

  val getTemplateTypesToCart = http(requestName + "dev")
    .get("cart.php?add=70062,66176,62226")
    .check(status.is(200))
}
