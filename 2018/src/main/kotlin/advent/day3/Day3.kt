package advent.day3

import advent.Day

/**
 * --- Day 3: No Matter How You Slice It ---
 */
class Day3(private val size: Pair<Int, Int>): Day<Int, String?>() {

  private val fabric = (1..size.first).flatMap { x ->
    (1..size.second).map { y ->
      Point(x, y) to mutableSetOf<Claim>()
    }
  }.toMap()

  override fun solve1(inputResource: String): Int {
    val claims = resourceContents(inputResource).lines().map { stringToClaim(it) }
    addClaimsToFabric(claims)
    return fabric.count { it.value.size > 1 }
  }

  override fun solve2(inputResource: String): String? {
    return null
  }

  private fun addClaimsToFabric(claims: List<Claim>) {
    claims.forEach { claim ->
      val x = claim.bottomLeftPoint.x
      val y = claim.bottomLeftPoint.y
      (x until claim.size.first+x).forEach { xClaim ->
        (y until claim.size.second+y).forEach { yClaim ->
          fabric.getValue(Point(xClaim, yClaim)).add(claim)
        }
      }
    }
  }

  private fun stringToClaim(s: String): Claim {
    // #1 @ 55,885: 22x10
    val tokens = s.split(" ")
    val blpTokens = tokens[2].split(",")
    val sizeTokens = tokens[3].split("x")
    val bottomLeftPoint = Point(
            x = blpTokens.first().toInt() + 1,
            y = blpTokens.last().trim(':').toInt() + 1
    )
    return Claim(
            id = tokens[0],
            bottomLeftPoint = bottomLeftPoint,
            size = sizeTokens.first().toInt() to sizeTokens.last().toInt()
    )
  }

  private fun printFabric() {
    (1..size.first).forEach { x ->
      println((1..size.second).map { y ->
        val p = fabric.getValue(Point(x, y))
        when (p.size) {
          0 -> "."
          1 -> p.first().id.trim('#')
          else -> "X"
        }
      }.joinToString(" "))
    }
  }

  data class Point(val x: Int, val y: Int)

  /**
   * #1 @ 55,885: 22x10
   */
  data class Claim(
          val id: String,
          val bottomLeftPoint: Point,
          // width, height
          val size: Pair<Int, Int>
  )
}