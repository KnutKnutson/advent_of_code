package main.day2

import java.io.File


class Day2(private val numbersFile: String) {

    fun solve1(): Int {
        File(numbersFile).useLines { lines ->
            return lines.map { line -> difference(line) }
                    .sum()
        }
    }

    fun solve2(): Int {
        File(numbersFile).useLines { lines ->
            return lines.map { line -> divide(line) }
                    .sum()
        }
    }

    private fun difference(lineOfNumbers: String): Int {
        val max = lineOfNumbers.split("\\s+".toRegex())
                .map {num -> num.toInt()}
                .max()
        val min = lineOfNumbers.split("\\s+".toRegex())
                .map {num -> num.toInt()}
                .min()
        return max!! - min!!
    }

    /**
     * Find the only two numbers in each row where one evenly divides the other, and divide them.
     */
    private fun divide(lineOfNumbers: String): Int {
        val nums = lineOfNumbers.split("\\s+".toRegex())
        (0 until nums.size).forEach { i ->
            (0 until nums.size).forEach { i2 ->
                if (i == i2) {
                    return@forEach
                }
                val remainder = nums[i].toInt().rem(nums[i2].toInt())
                if (remainder == 0) {
                    return nums[i].toInt().div(nums[i2].toInt())
                }
            }
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val numbersFile = "src/main/day2/spreadsheet2.txt"
    val solver = Day2(numbersFile)
    println("Checksum: ${solver.solve1()}")
    println("Divide sum: ${solver.solve2()}")
}