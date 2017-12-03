package main.day3

import kotlin.math.absoluteValue

class Day3(private val number: Int) {

    fun solve1(): Int {
        val out = out()
        return out + over(out)
    }

    /**
     * As numbers spiral out they form a ring around the number 1. The count of numbers in that ring is a multiple of 8.
     * The multiple represents the distance out from the number 1 the ring is.
     */
    fun out(): Int {
        if (number == 1) { return 0 }
        var minCircle = 2
        for (i in 1..number) {
            val maxCircle = minCircle + i * 8
            if ((minCircle until maxCircle).contains(number)) {
                return i
            }
            minCircle = maxCircle
        }
        return 0
    }

    /**
     * The grid of numbers around 1 have x/y axis out from 2,4,6,8. The ring containing the number in question has
     * a corresponding axis number. The closes distance to the axis is the 'over' number
     */
    fun over(out: Int): Int {
        if (number == 1) { return 0 }
        var axises = arrayOf(2, 4, 6, 8)
        var step = arrayOf(1, 3, 5, 7)
        (1 until out).forEach { i ->
            (0..3).forEach { j ->
                var a = axises[j]
                var newA = a + (step[j] + i * 8)
                axises.set(j, newA)
            }
        }
        return axises.map { a -> (a - number).absoluteValue }
                .min()!!
    }
}

fun main(args: Array<String>) {
    val inputNumber = 347991
    val solver = Day3(inputNumber)
    println("Distance: ${solver.solve1()}")
}