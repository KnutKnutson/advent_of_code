package com.knutknut.advent.twenty

class Day5 {

  fun solvePart1(input: List<String>, numStacks: Int): String {
    val stacks = SupplyStacks(numStacks)

    var blankLine = 0
    for ((index, crateRow) in input.withIndex()) {
      if (crateRow.isBlank()) {
        blankLine = index
        break
      }
      stacks.parseRow(crateRow)
    }

    input.listIterator(blankLine + 1).forEach { moveLine ->
      val match = Regex("(\\w+) (\\d+) (\\w+) (\\d+) (\\w+) (\\d+)").find(moveLine)!!
      val (_, numCrates, _, toStack, _, fromStack) = match.destructured
      stacks.moveCrate(numCrates.toInt(), toStack.toInt(), fromStack.toInt())
    }

    return stacks.listTopStacks()
  }

  fun solvePart2(input: List<String>, numStacks: Int): String {
    val stacks = SupplyStacks(numStacks, false)

    var blankLine = 0
    for ((index, crateRow) in input.withIndex()) {
      if (crateRow.isBlank()) {
        blankLine = index
        break
      }
      stacks.parseRow(crateRow)
    }

    input.listIterator(blankLine + 1).forEach { moveLine ->
      val match = Regex("(\\w+) (\\d+) (\\w+) (\\d+) (\\w+) (\\d+)").find(moveLine)!!
      val (_, numCrates, _, toStack, _, fromStack) = match.destructured
      stacks.moveCrate(numCrates.toInt(), toStack.toInt(), fromStack.toInt())
    }

    return stacks.listTopStacks()
  }
}

class SupplyStacks(private val numStacks: Int, private val reverseMove: Boolean = true) {
  private val stacks = MutableList(numStacks) { mutableListOf<Char>() }

  fun parseRow(row: String) {
    prependStack(0, row[1])
    repeat(numStacks - 1) { i ->
      val stackNum = i + 1
      prependStack(stackNum, row[stackNum * 4 + 1])
    }
  }

  fun moveCrate(numCrates: Int, from: Int, to: Int) {
    val movedCrates = stacks[from-1].takeLast(numCrates)
    if (reverseMove) {
      stacks[to-1] += movedCrates.reversed()
    } else {
      stacks[to-1] += movedCrates
    }
    stacks[from-1] = stacks[from-1].dropLast(numCrates).toMutableList()
  }

  fun listTopStacks(): String {
    return stacks.map { it.last() }.joinToString("")
  }

  private fun prependStack(stackNum: Int, item: Char) {
    if (!item.isLetter()) return
    stacks[stackNum].add(0, item)
  }
}

/**
--- Day 5: Supply Stacks ---
The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

    [D]
[N] [C]
[Z] [M] [P]
1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]
[N] [C]
[Z] [M] [P]
1   2   3
In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

[Z]
[N]
[C] [D]
[M] [P]
1   2   3
Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

[Z]
[N]
[M]     [D]
[C]     [P]
1   2   3
Finally, one crate is moved from stack 1 to stack 2:

[Z]
[N]
[D]
[C] [M] [P]
1   2   3
The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?


 */

/**

 */