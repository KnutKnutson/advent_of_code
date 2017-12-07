package main.day6

import java.io.File

class Day6(private val memoryBanks: IntArray)  {

    private val banksLength = memoryBanks.size

    fun solve1(): Int {
        val seen = mutableListOf(memoryBanks.contentToString())
        val banks = memoryBanks.copyOf()
        var redistributionCount = 0
        while (true) {
            redistribute(banks)
            redistributionCount++
            if (seen.contains(banks.contentToString())) {
                return redistributionCount
            }
            seen.add(banks.contentToString())
        }
    }

    private fun redistribute(banks: IntArray) {
        val max = banks.max()!!
        var index = banks.indexOf(max)
        banks[index] = 0
        (1..max).forEach {
            index = (index + 1) % banksLength
            banks[index]++
        }
    }

    fun solve2(): Int {
        val seen = mutableListOf(memoryBanks.contentToString())
        val banks = memoryBanks.copyOf()
        while (true) {
            redistribute(banks)
            val value = banks.contentToString()
            if (seen.contains(value)) {
                return seen.size - seen.indexOf(value)
            }
            seen.add(value)
        }
    }
}

fun main(args: Array<String>) {
    val memoryBanksFile = "src/main/day6/input.txt"
    File(memoryBanksFile).useLines { lines ->
        lines.forEach { line ->
            val solver = Day6(line.split("\\s+".toRegex()).map{i->Integer.parseInt(i)}.toIntArray())
            println("Redistributions: ${solver.solve1()}")
            println("Cycles in loop: ${solver.solve2()}")
        }
    }
}