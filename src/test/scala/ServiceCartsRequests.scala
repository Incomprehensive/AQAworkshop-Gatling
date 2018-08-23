import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by Nigel for workshop 22.08.18
  */
object ServiceCartsRequests {

  val requestName = EnvConfig.env + "-Service-Carts-API-"

  val postNewCartId = http(requestName + "carts")
    .post("v1/carts")
    .check(status.is(201))

}
