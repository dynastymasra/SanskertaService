package id.dynastymasra.sanskerta.area.controller

import com.twitter.util.Future
import com.typesafe.scalalogging.Logger
import id.dynastymasra.sanskerta.common.contract.area.{Country, CountryService}
import org.slf4j.LoggerFactory

/**
  * Author   : Dynastymasra
  * Name     : Dimas Ragil T
  * Email    : dynastymasra@gmail.com
  * LinkedIn : http://www.linkedin.com/in/dynastymasra
  * Backend Developer
  */
trait CountryController extends CountryService.FutureIface {

  val logger = Logger(LoggerFactory.getLogger(this.getClass))

  override def create(country: Country): Future[Country] = ???

  override def createCountry(country: Country): Future[Country] = ???

  override def getCountryById(idCountry: String): Future[Country] = ???

  override def softDeleteCountry(idCountry: String): Future[Unit] = ???

  override def getCountryByName(name: String): Future[Country] = ???

  override def updateCountry(idCountry: String, country: Country): Future[Country] = ???

  override def getCountryByCallingCode(code: Int): Future[Country] = ???

  override def removeCountry(idCountry: String): Future[Unit] = ???

  override def getAllCountry(): Future[Seq[Country]] = ???
}
