package models

abstract class BadgeType(value: String)
case class Standard() extends BadgeType("standard")
case class Mystery() extends BadgeType("mystery")
case class Surprise() extends BadgeType("surprised")

case class Badge(name: String, badgeType: BadgeType)

case class EarnedBadge(earner: String, badgeName: String)

