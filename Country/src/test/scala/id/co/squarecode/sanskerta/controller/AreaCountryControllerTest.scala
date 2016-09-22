package id.co.squarecode.sanskerta.controller

import java.net.InetSocketAddress

import com.twitter.util.Await
import com.typesafe.config.ConfigFactory
import id.co.squarecode.common.contract.area.AreaService$FinagleClient
import id.co.squarecode.sanskerta.AreaClientTest
import id.co.squarecode.sanskerta.util.UtilTest
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterAll
import org.scalatest.junit.JUnitRunner

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
@RunWith(classOf[JUnitRunner])
class AreaCountryControllerTest extends UtilTest with BeforeAndAfterAll {
  var server: com.twitter.finagle.builder.Server = _
  var client: AreaService$FinagleClient = _

  override protected def beforeAll(): Unit = {
    val config = ConfigFactory.load("application.conf").getConfig("app")
    val host = config.getString("host")
    val port = config.getInt("port")

    server = id.co.squarecode.sanskerta.Server.serve(new InetSocketAddress(host, port))
    client = AreaClientTest.server(new InetSocketAddress(host, port))
  }

  override protected def afterAll(): Unit = {
    server.close()
  }

  "Area Controller" should "area ping controller" in {
    val result = Await.result(client.ping())

    result shouldBe "PONG!!!"
  }
}
