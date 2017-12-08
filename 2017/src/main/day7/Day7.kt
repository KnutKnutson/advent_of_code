package main.day7

import java.io.File

open class Program(var name: String) {

    var weight = 0
    var parent: Program? = null
    var children = mutableListOf<Program>()
}

class Day7(file: String)  {

    private val programs = mutableMapOf<String, Program>()

    init {
        File(file).useLines { lines ->
            lines.forEach { line ->
                parseLine(line)
            }
        }
    }

    fun solve1(): String {
        return programs.values.first { p -> p.parent == null }.name
    }

    private fun parseLine(programLine: String) {
        val program = programLine.split("(", ")", "->", ",")
                .map{ s -> s.trim()}
                .filter{ s -> !s.isBlank()}
                .toTypedArray()

        val p = programs.getOrPut(program[0]) { Program(program[0]) }
        p.weight = program[1].toInt()

        (2 until program.size).forEach { i ->
            val childName = program[i]
            val child = programs.getOrPut(childName) { Program(childName) }
            child.parent = p
            p.children.add(child)
        }
    }

    var idealWeight = 0

    fun solve2(): Int {
        val root = programs.values.first { p -> p.parent == null }
        sumChildWeight(root)
        return idealWeight
    }

    private fun sumChildWeight(program: Program):Int {
        val childWeights = mutableMapOf<String, Int>()
        program.children.forEach { c ->
            childWeights.put(c.name, sumChildWeight(c))
        }

        // Check if we found the first uneven weights
        if (idealWeight == 0 && !childWeightsAreEqual(childWeights.values.toList())) {
            idealWeight = getIdealChildWeight(childWeights.map { e -> Pair(e.key, e.value)})
        }

        return program.weight + childWeights.values.sum()
    }

    private fun childWeightsAreEqual(childWeights: List<Int>): Boolean {
        if (childWeights.isEmpty()) {
            return true
        }
        return childWeights.first() == childWeights.sum() / childWeights.size
    }

    private fun getIdealChildWeight(childWeights: List<Pair<String, Int>>): Int {
        val normalChildWeight = childWeights.map {c -> c.second}.sorted()[1]
        val oddChild = childWeights.find { i -> i.second != normalChildWeight }
        val childProgram = programs[oddChild?.first]
        return childProgram!!.weight + (normalChildWeight - oddChild!!.second)
    }

}

fun main(args: Array<String>) {
    val memoryBanksFile = "src/main/day7/input.txt"
    val solver = Day7(memoryBanksFile)
    println("Base Program: ${solver.solve1()}")
    println("Proper weight: ${solver.solve2()}")
}