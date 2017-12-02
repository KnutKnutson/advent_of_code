package main.day1

import java.io.File

class Day1(private val number: String) {

    fun solve1(number: String): Int {
        val length = number.length
        return (0 until length).filter { i -> sameAsNextValue(i) }
                .map{i -> number[i].toString().toInt()}
                .sum()
    }

    fun solve2(number: String): Int {
        val length = number.length
        return (0 until length).filter { i -> sameAsHalfwayArouncValue(i) }
                .map{i -> number[i].toString().toInt()}
                .sum()
    }

    private fun sameAsNextValue(index: Int): Boolean {
        return number[index] == number[nextIndex(index)]
    }

    private fun nextIndex(index: Int): Int {
        return (index + 1) % number.length
    }

    private fun sameAsHalfwayArouncValue(index: Int): Boolean {
        return number[index] == number[(number.length / 2 + index) % number.length]
    }
}

fun main(args: Array<String>) {
    val numbersFile = "src/main/day1/input.txt"
    File(numbersFile).forEachLine { number ->
        val solver = Day1(number)
        println("number: $number \n solution1: ${solver.solve1(number)} \n" +
                " solution2: ${solver.solve2(number)}")
    }
}