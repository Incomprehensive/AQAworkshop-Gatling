import com.typesafe.config._

/**
  * Created by rocky
  */
object EnvConfig {
  val env = System.getProperty("mainEnv", "test")
  println("env: " + env)

  val cartsAPI = System.getProperty("cartsUrl", "test")
  println("carts: " + cartsAPI)

  val conf = ConfigFactory.load(env)
  def apply() = conf.getConfig("conf")
}