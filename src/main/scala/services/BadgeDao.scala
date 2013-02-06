package services
import models.Badge
import models.EarnedBadge

// For our exercise, we always use a Mockito mock of BadgeDao, so we don't need a real implementation.
class BadgeDao {
	def getAllBadges(): List[Badge] = Nil
	def getBadgesForEarner(earnerName: String): List[EarnedBadge] = Nil
	def getLeveledBadges() = Nil
}
