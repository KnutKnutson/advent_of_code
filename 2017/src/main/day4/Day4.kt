package main.day4

import java.io.File

class Day4(private val passPhrasFile: String) {
    fun solve1(): Int {
        File(passPhrasFile).useLines { passwords ->
            return passwords.filter { p -> isValid(p) }
                    .count()
        }
    }

    private fun isValid(passPhrase: String): Boolean {
        val passPhrases = mutableSetOf<String>()
        passPhrase.split(" ")
                .forEach{ passPhrase ->
                    if (passPhrases.contains(passPhrase)) {
                        return false
                    }
                    passPhrases.add(passPhrase)
                }
        return true
    }
}

fun main(args: Array<String>) {
    val passPhrases = "src/main/day4/input2.txt"
    val solver = Day4(passPhrases)
    println("Valid phrases: ${solver.solve1()}")
}