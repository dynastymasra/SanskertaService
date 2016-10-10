package id.dynastymasra.sanskerta.area

import java.net.InetSocketAddress

import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import id.dynastymasra.sanskerta.area.controller.AreaController
import id.dynastymasra.sanskerta.common.contract.area.AreaService$FinagleService
import org.apache.thrift.protocol.TCompactProtocol
import org.slf4j.LoggerFactory

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
object Server extends App {
  val logger = Logger(LoggerFactory.getLogger(this.getClass))

  val config = ConfigFactory.load("application.conf").getConfig("app")
  val host = config.getString("host")
  val port = config.getInt("port")

  val address = new InetSocketAddress(host, port)

  logger.info(s"Start server user host:$host port:$port")
  serve(address)
  logger.info("Server area running...")

  def serve(address: InetSocketAddress) = {
    val protocol = new TCompactProtocol.Factory()
    val service = new AreaService$FinagleService(new AreaController, protocol)

    ServerBuilder()
      .keepAlive(true)
      .logChannelActivity(true)
      .codec(ThriftServerFramedCodec(protocol))
      .bindTo(address)
      .name("AreaService")
      .build(service)
  }
}
