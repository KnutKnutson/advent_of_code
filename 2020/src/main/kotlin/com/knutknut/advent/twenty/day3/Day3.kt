package com.knutknut.advent.twenty.day3

class Day3 {
  fun solve1(slope: Slope): Int {
    return countTreesForSlope(slope, 3, 1)
  }

  fun solve2(slope: Slope): Long {
    val trajectories = listOf(
      1 to 1,
      3 to 1,
      5 to 1,
      7 to 1,
      1 to 2
    )
    return trajectories
      .map { pair -> countTreesForSlope(slope, pair.first, pair.second).toLong() }
      .reduce { acc, i -> acc * i }
  }

  internal fun countTreesForSlope(slope: Slope, rightTrajectory: Int, downTrajectory: Int): Int {
    var rightSlope = -rightTrajectory
    return slope.treeLines.mapIndexed { downSlope, treeLine ->
      val skipLine = downSlope % downTrajectory != 0
      if (skipLine) {
        0
      } else {
        rightSlope += rightTrajectory
        if (treeLine.get(rightSlope).isClear()) 0 else 1
      }
    }.sum()
  }
}

data class Slope(
  val treeLines: List<TreeLine>
)

data class TreeLine(
  private val line: List<Point>
) {
  private val size = line.size
  fun get(point: Int): Point = line[point % size]
}

data class Point(
  private val c: Char
) {
  fun isClear(): Boolean = c == '.'
}