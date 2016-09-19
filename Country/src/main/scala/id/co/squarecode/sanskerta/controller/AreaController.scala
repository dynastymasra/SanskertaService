package id.co.squarecode.sanskerta.controller

import com.twitter.util.Future
import com.typesafe.scalalogging.Logger
import id.co.squarecode.common.contract.area.AreaService
import org.slf4j.LoggerFactory

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
class AreaController extends AreaService.FutureIface with CountryController {

  override val logger = Logger(LoggerFactory.getLogger(this.getClass))

  override def ping(): Future[String] = {
    logger.info("Request area ping...")
    Future.value("PONG!!!")
  }
}
