package main.day2

import java.io.File


class Day1(private val numbersFile: String) {

    fun solve1() {
        File(numbersFile).forEachLine { number ->
            println("number: $number \n solution: ${solve1(number)}")
        }
    }

    fun solve1(number: String) {
        val length = number.length
        (0..length).forEach { i ->
            val nextI = (i + 1) % length
        }
        number.byteInputStream()
    }

    fun sameAsNextValue(index: Int): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    val numbersFile = "src/main/day1/input.txt"
    val solver = Day1(numbersFile)
    solver.solve1()
    println("hello world")
}