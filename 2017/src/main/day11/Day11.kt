package main.day11

import java.io.File
import kotlin.math.absoluteValue


class Day11(private val rawDirections: String) {

    private val NORTH = "n"
    private val NORTH_EAST = "ne"
    private val NORTH_WEST = "nw"
    private val SOUTH = "s"
    private val SOUTH_EAST = "se"
    private val SOUTH_WEST = "sw"

    private var directionToCount = rawDirections.split(",")
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

    /**
     * Returns the distance from origin.
     */
    fun solve1(): Int {
        simplify()
        return directionToCount.values.sum()
    }

    /**
     * Returns a simplified list of directions. Redundant directions such as n, s are removed,
     * and directions such as se, sw are simplified to s.
     */
    private fun simplify() {
        var oldDirectionsCount = directionToCount.values.sum()
        condense()
        removeOpposites()

        while (oldDirectionsCount != directionToCount.values.sum()) {
            condense()
            removeOpposites()
            oldDirectionsCount = directionToCount.values.sum()
        }
    }

    /**
     * Changes n, se to the simpler ne
     */
    private fun condense() {

        directionToCount[NORTH_EAST] = dirVal(NORTH_EAST) + listOf(dirVal(NORTH), dirVal(SOUTH_EAST)).min()!!
        if (dirVal(NORTH) > dirVal(SOUTH_EAST)) {
            directionToCount[NORTH] = dirVal(NORTH) - dirVal(SOUTH_EAST)
            directionToCount[SOUTH_EAST] = 0
        } else {
            directionToCount[SOUTH_EAST] = dirVal(SOUTH_EAST) - dirVal(NORTH)
            directionToCount[NORTH] = 0
        }

        directionToCount[SOUTH_EAST] = dirVal(SOUTH_EAST) + listOf(dirVal(NORTH_EAST), dirVal(SOUTH)).min()!!
        if (dirVal(NORTH_EAST) > dirVal(SOUTH)) {
            directionToCount[NORTH_EAST] = dirVal(NORTH_EAST) - dirVal(SOUTH)
            directionToCount[SOUTH] = 0
        } else {
            directionToCount[SOUTH] = dirVal(SOUTH) - dirVal(NORTH_EAST)
            directionToCount[NORTH_EAST] = 0
        }

        directionToCount[SOUTH] = dirVal(SOUTH) + listOf(dirVal(SOUTH_EAST), dirVal(SOUTH_WEST)).min()!!
        if (dirVal(SOUTH_EAST) > dirVal(SOUTH_WEST)) {
            directionToCount[SOUTH_EAST] = dirVal(SOUTH_EAST) - dirVal(SOUTH_WEST)
            directionToCount[SOUTH_WEST] = 0
        } else {
            directionToCount[SOUTH_WEST] = dirVal(SOUTH_WEST) - dirVal(SOUTH_EAST)
            directionToCount[SOUTH_EAST] = 0
        }

        directionToCount[SOUTH_WEST] = dirVal(SOUTH_WEST) + listOf(dirVal(SOUTH), dirVal(NORTH_WEST)).min()!!
        if (dirVal(SOUTH) > dirVal(NORTH_WEST)) {
            directionToCount[SOUTH] = dirVal(SOUTH) - dirVal(NORTH_WEST)
            directionToCount[NORTH_WEST] = 0
        } else {
            directionToCount[NORTH_WEST] = dirVal(NORTH_WEST) - dirVal(SOUTH)
            directionToCount[SOUTH] = 0
        }

        directionToCount[NORTH_WEST] = dirVal(NORTH_WEST) + listOf(dirVal(SOUTH_WEST), dirVal(NORTH)).min()!!
        if (dirVal(SOUTH_WEST) > dirVal(NORTH)) {
            directionToCount[SOUTH_WEST] = dirVal(SOUTH_WEST) - dirVal(NORTH)
            directionToCount[NORTH] = 0
        } else {
            directionToCount[NORTH] = dirVal(NORTH) - dirVal(SOUTH_WEST)
            directionToCount[SOUTH_WEST] = 0
        }

        directionToCount[NORTH] = dirVal(NORTH) + listOf(dirVal(NORTH_WEST), dirVal(NORTH_EAST)).min()!!
        if (dirVal(NORTH_WEST) > dirVal(NORTH_EAST)) {
            directionToCount[NORTH_WEST] = dirVal(NORTH_WEST) - dirVal(NORTH_EAST)
            directionToCount[NORTH_EAST] = 0
        } else {
            directionToCount[NORTH_EAST] = dirVal(NORTH_EAST) - dirVal(NORTH_WEST)
            directionToCount[NORTH_WEST] = 0
        }
    }

    /**
     * removes opposite directions. e.g. n, s
     */
    private fun removeOpposites() {

        if (dirVal(NORTH_EAST) > dirVal(SOUTH_WEST)) {
            directionToCount[NORTH_EAST] = dirVal(NORTH_EAST) - dirVal(SOUTH_WEST)
            directionToCount[SOUTH_WEST] = 0
        } else {
            directionToCount[SOUTH_WEST] = dirVal(SOUTH_WEST) - dirVal(NORTH_EAST)
            directionToCount[NORTH_EAST] = 0
        }

        if (dirVal(NORTH_WEST) > dirVal(SOUTH_EAST)) {
            directionToCount[NORTH_WEST] = dirVal(NORTH_WEST) - dirVal(SOUTH_EAST)
            directionToCount[SOUTH_EAST] = 0
        } else {
            directionToCount[SOUTH_EAST] = dirVal(SOUTH_EAST) - dirVal(NORTH_WEST)
            directionToCount[NORTH_WEST] = 0
        }

        if (dirVal(NORTH) > dirVal(SOUTH)) {
            directionToCount[NORTH] = dirVal(NORTH) - dirVal(SOUTH)
            directionToCount[SOUTH] = 0
        } else {
            directionToCount[SOUTH] = dirVal(SOUTH) - dirVal(NORTH)
            directionToCount[NORTH] = 0
        }
    }

    fun dirVal(dir: String): Int {
        return directionToCount.getOrPut(dir) { 0 }
    }
}

fun main(args: Array<String>) {
    val file = "src/main/day11/input.txt"
    File(file).useLines { lines ->
        lines.forEach { line ->
            val solver = Day11(line)
            println("Distance from origin: ${solver.solve1()}")
        }
    }
}