package services
import models._

class MyBadgesServiceSolution(badgeDao: BadgeDao) {

  /*  possible solution for "Should return an empty list when there are no badges to earn"
  def unearnedBadgesUnlockedFor(earnerHandle: String): List[Badge] = {
    val allBadges = badgeDao.getAllBadges()
    val badgesForEarner = badgeDao.getBadgesForEarner(earnerHandle)
    Nil
  }
  */

  /*  possible solution for "should filter out an earned badge"
  def unearnedBadgesUnlockedFor(earnerHandle: String): List[Badge] = {
    val allBadges = badgeDao.getAllBadges()
    val badgesForEarner = badgeDao.getBadgesForEarner(earnerHandle)
    val badgeNamesForEarner = badgesForEarner.map(badge => badge.badgeName).toSet
    allBadges.filterNot(badge => badgeNamesForEarner.contains(badge.name))
  }
  */

  /*  possible solution for "should remove suprise badges, so the earner doesn't know they exist"
  def unearnedBadgesUnlockedFor(earnerHandle: String): List[Badge] = {
    val allBadges = badgeDao.getAllBadges()
    val badgesForEarner = badgeDao.getBadgesForEarner(earnerHandle)
    val badgeNamesForEarner = badgesForEarner.map(badge => badge.badgeName).toSet
    allBadges.filterNot(badge => badgeNamesForEarner.contains(badge.name) || badge.badgeType == Surprise())
  }
  */
  
  // possible solution for "should obscure mystery badges, so the earner doesn't know what they are or how to earn them"
  def unearnedBadgesUnlockedFor(earnerHandle: String): List[Badge] = {
    val allBadges = badgeDao.getAllBadges()
    val badgeNamesForEarner = badgeDao.getBadgesForEarner(earnerHandle).map(badge => badge.badgeName).toSet
    val unearnedNotSupriseBadges = allBadges.filterNot(badge => badgeNamesForEarner.contains(badge.name) || badge.badgeType == Surprise())
    unearnedNotSupriseBadges.map(badge => {
      if(badge.badgeType == Mystery()) {
        Badge("?", Mystery())
      } else {
        badge
      }
    })
  }
  
}