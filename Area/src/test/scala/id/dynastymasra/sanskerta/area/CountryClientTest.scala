package id.dynastymasra.sanskerta.area

import java.net.InetSocketAddress

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.thrift.ThriftClientFramedCodec
import id.co.squarecode.common.contract.area.CountryService$FinagleClient
import org.apache.thrift.protocol.TCompactProtocol
import java.util.logging.Logger

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
object CountryClientTest {
  def serverCountry(address: InetSocketAddress) = {
    val protocol = new TCompactProtocol.Factory()
    val serve = ClientBuilder()
      .failFast(false)
      .keepAlive(true)
      .hosts(address)
      .codec(ThriftClientFramedCodec().protocolFactory(protocol))
      .hostConnectionCoresize(1)
      .retries(3)
      .logger(Logger.getLogger("Country Test"))
      .build()
    new CountryService$FinagleClient(serve, protocol)
  }
}
