package id.co.squarecode.sanskerta

import java.net.InetSocketAddress

import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import id.co.squarecode.common.contract.area.AreaService$FinagleService
import id.co.squarecode.sanskerta.controller.AreaController
import org.apache.thrift.protocol.TCompactProtocol
import org.slf4j.LoggerFactory

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
object App extends App {
  val logger = Logger(LoggerFactory.getLogger(this.getClass))

  val config = ConfigFactory.load("application.conf").getConfig("app")
  val host = config.getString("host")
  val port = config.getInt("port")

  logger.info(s"Start server user host:$host port:$port")
  logger.info("Server user running...")

  val service = new AreaService$FinagleService(new AreaController, new TCompactProtocol.Factory)
  val address = new InetSocketAddress(host, port)

  ServerBuilder()
    .keepAlive(true)
    .logChannelActivity(true)
    .codec(ThriftServerFramedCodec())
    .bindTo(address)
    .name("AreaService")
    .build(service)

}
