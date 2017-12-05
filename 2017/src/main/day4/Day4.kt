package main.day4

import java.io.File

class Day4(private val passPhrasFile: String) {
    fun solve1(): Int {
        File(passPhrasFile).useLines { passwords ->
            return passwords.filter { p -> isValid(p) }
                    .count()
        }
    }

    /**
     * valid passwords can not have duplicate phrases
     */
    private fun isValid(passPhrase: String): Boolean {
        val passPhrases = mutableSetOf<String>()
        passPhrase.split(" ")
                .forEach{ phrase ->
                    if (passPhrases.contains(phrase)) {
                        return false
                    }
                    passPhrases.add(phrase)
                }
        return true
    }

    fun solve2(): Int {
        File(passPhrasFile).useLines { passwords ->
            return passwords.filter { p -> isNotAnAnagram(p) }
                    .count()
        }
    }

    /**
     * valid passwords can not have phrases that are anagrams of eachother
     */
    private fun isNotAnAnagram(passPhrase: String): Boolean {
        val sortedPassPhrases = mutableSetOf<String>()
        passPhrase.split(" ")
                .forEach{ phrase ->
                    val sortedPhrase = phrase.toCharArray().sortedArray().contentToString()
                    if (sortedPassPhrases.contains(sortedPhrase)) {
                        return false
                    }
                    sortedPassPhrases.add(sortedPhrase)
                }
        return true
    }
}

fun main(args: Array<String>) {
    val passPhrases = "src/main/day4/input2.txt"
    val solver = Day4(passPhrases)
    println("Valid phrases: ${solver.solve1()}")
    println("Valid phrases2: ${solver.solve2()}")
}