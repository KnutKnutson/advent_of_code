package main.day8

import java.io.File

class Day8(file: String)  {

    private val INCREASE = "inc"
    private val DECREASE = "dec"
    private val GREATER = ">"
    private val GREATER_OR_EQ = ">="
    private val LESS = "<"
    private val LESS_OR_EQ = "<="
    private val EQ = "=="
    private val NOT_EQ = "!="

    private val instructions = mutableListOf<List<String>>()
    private val registerToValue = mutableMapOf<String, Int>()

    private var highestSeen = 0

    init {
        File(file).useLines { lines ->
            lines.forEach { line ->
                parseLine(line)
            }
        }
        runInstructions()
    }

    fun solve1(): Int {
        return registerToValue.values.max()!!
    }

    fun solve2(): Int {
        return highestSeen
    }

    private fun parseLine(programLine: String) {
        instructions.add(programLine.split("\\s+".toRegex()))
    }

    private fun runInstructions() {
        instructions.forEach { i ->
            if (conditionIsTrue(i[4], i[5], i[6])) {
                takeAction(i[0], i[1], i[2])
            }
        }
    }

    private fun conditionIsTrue(register: String, comparator: String, value: String): Boolean {
        return when (comparator) {
            GREATER -> registerToValue.getOrPut(register) {0} > value.toInt()
            GREATER_OR_EQ -> registerToValue.getOrPut(register) {0} >= value.toInt()
            LESS -> registerToValue.getOrPut(register) {0} < value.toInt()
            LESS_OR_EQ -> registerToValue.getOrPut(register) {0} <= value.toInt()
            EQ -> registerToValue.getOrPut(register) {0} == value.toInt()
            NOT_EQ -> registerToValue.getOrPut(register) {0} != value.toInt()
            else -> {
                false
            }
        }
    }

    private fun takeAction(register: String, action: String, value: String) {
        val curVal = registerToValue.getOrDefault(register, 0)
         when (action) {
            INCREASE -> registerToValue.put(register, curVal + value.toInt())
            DECREASE -> registerToValue.put(register, curVal - value.toInt())
        }
        val newVal = registerToValue[register]!!
        if (newVal > highestSeen) {
            highestSeen = newVal
        }
    }
}

fun main(args: Array<String>) {
    val file = "src/main/day8/input.txt"
    val solver = Day8(file)
    println("Largest Value: ${solver.solve1()}")
    println("Highest Seen: ${solver.solve2()}")
}