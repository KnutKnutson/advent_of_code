package main.day5

import java.io.File

class Day5(private val instructionsFile: String)  {

    fun solve1(): Int {
        File(instructionsFile).useLines { maze ->
            return stepsToExit(maze.map{i -> i.trim().toInt()}.toList().toIntArray())
        }
    }

    private fun stepsToExit(maze: IntArray): Int {
        var currentInstruction = 0
        var steps = 0
        while (true) {
            var jumpTo = maze.getOrNull(currentInstruction)
            if (jumpTo == null) {
                return steps
            }
            maze[currentInstruction] = jumpTo + 1
            currentInstruction += jumpTo
            steps++
        }
        return steps
    }

    fun solve2(): Int {
        File(instructionsFile).useLines { maze ->
            return stepsToExit2(maze.map{i -> i.trim().toInt()}.toList().toIntArray())
        }
    }

    private fun stepsToExit2(maze: IntArray): Int {
        var currentInstruction = 0
        var steps = 0
        while (true) {
            var jumpTo = maze.getOrNull(currentInstruction)
            if (jumpTo == null) {
                return steps
            }
            maze[currentInstruction] = if (jumpTo < 3) (jumpTo + 1) else (jumpTo - 1)
            currentInstruction += jumpTo
            steps++
        }
        return steps
    }
}

fun main(args: Array<String>) {
    val instructions = "src/main/day5/my_input.txt"
    val solver = Day5(instructions)
    println("Steps to exit: ${solver.solve1()}")
    println("Steps2: ${solver.solve2()}")
}