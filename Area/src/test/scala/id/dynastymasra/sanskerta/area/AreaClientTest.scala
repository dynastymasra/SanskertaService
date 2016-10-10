package id.dynastymasra.sanskerta.area

import java.net.InetSocketAddress
import java.util.logging.Logger

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.thrift.ThriftClientFramedCodec
import id.co.squarecode.common.contract.area.AreaService$FinagleClient
import org.apache.thrift.protocol.TCompactProtocol

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
object AreaClientTest {
  def server(address: InetSocketAddress) = {
    val protocol = new TCompactProtocol.Factory()
    val serve = ClientBuilder()
      .failFast(false)
      .keepAlive(true)
      .hosts(address)
      .codec(ThriftClientFramedCodec().protocolFactory(protocol))
      .hostConnectionLimit(1)
      .retries(3)
      .logger(Logger.getLogger("Area Test"))
      .build()
    new AreaService$FinagleClient(serve, protocol)
  }
}
