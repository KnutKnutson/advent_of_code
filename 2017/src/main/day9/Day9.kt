package main.day9

import java.io.File

class Day9(private val stream: String)  {

    private val START_GROUP = '{'
    private val END_GROUP = '}'
    private val START_GARBAGE = '<'
    private val END_GARBAGE = '>'
    private val IGNORE_NEXT = '!'

    private var currentGroupScore = 0
    private var totalGroupScore = 0
    private var garbageCount = 0

    private var ignoreNext = false
    private var garbageStream = false

    init {
        stream.forEach { c ->
            processChar(c)
        }
    }

    fun solve1(): Int {
        return totalGroupScore
    }

    fun solve2(): Int {
        return garbageCount
    }

    private fun processChar(streamItem: Char) {
        if (ignoreNext) {
            ignoreNext = false
            return
        }

        if (garbageStream) {
            when(streamItem) {
                IGNORE_NEXT -> ignoreNext = true
                END_GARBAGE -> garbageStream = false
                else -> {
                    garbageCount++
                }
            }
            return
        }

        when(streamItem) {
            START_GROUP -> {
                currentGroupScore++
                totalGroupScore += currentGroupScore
            }
            END_GROUP -> currentGroupScore--
            START_GARBAGE -> garbageStream = true
        }
    }
}

fun main(args: Array<String>) {
    val file = "src/main/day9/input.txt"
    File(file).useLines { lines ->
        lines.forEach { line ->
            val solver = Day9(line)
            println("Score: ${solver.solve1()}")
            println("Garbage count: ${solver.solve2()}")
        }
    }
}