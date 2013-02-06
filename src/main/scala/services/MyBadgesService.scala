package services
import models._

class MyBadgesService(badgeDao: BadgeDao) {

  // TODO:  implement commented-out tests in UnearnedBadgesTest.scala
  def unearnedBadgesUnlockedFor(earner: String): List[Badge] = {
    val allBadges = badgeDao.getAllBadges()
    val badgesForEarner = badgeDao.getBadgesForEarner(earner)
    Nil
  }
  
}