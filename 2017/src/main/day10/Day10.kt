package main.day10

import java.io.File

class Day10(inputsFile: String, private val circleSize: Int)  {

    private val salt = listOf(17, 31, 73, 47, 23)

    private var inputs = mutableListOf<Int>()
    private var circle = IntArray(circleSize)

    init {
        File(inputsFile).useLines { lines ->
            lines.forEach { line ->
                line.chars().forEach { c ->
                    inputs.add(c)
                }
            }
        }

        inputs.addAll(salt)

        (0 until circleSize).forEach { i ->
            circle[i] = i
        }

        hashKnot()
    }

    fun solve1(): Int {
        return circle[0] * circle[1]
    }

    fun solve2(): String {
        return hexDenseHash()
    }

    private fun hashKnot() {
        var curPosition = 0
        var skipSize = 0
        (0 until 64).forEach {
            inputs.forEach { i ->
                reverseSection(curPosition, i).forEach { newValue ->
                    circle[curPosition] = newValue
                    curPosition = (curPosition + 1) % circleSize
                }
                curPosition = (curPosition + skipSize) % circleSize
                skipSize++
            }
        }
    }

    private fun reverseSection(start: Int, length: Int): IntArray {
        val section = IntArray(length)
        var position = start
        (0 until length).forEach { i ->
            section[i] = circle[position]
            position = (position + 1) % circleSize
        }
        return section.reversedArray()
    }

    private fun hexDenseHash(): String {
        return circle.asList()
                .chunked(16) { c -> c.reduce { i, i2 -> i.xor(i2) }}
                .map { i -> Integer.toHexString(i) }
                .joinToString("") { h -> if (h.length < 2) "0" + h else h }
    }
}

fun main(args: Array<String>) {
    val file = "src/main/day10/input.txt"
    val solver = Day10(file, 256)
    println("Knot Hash: ${solver.solve2()}")
}