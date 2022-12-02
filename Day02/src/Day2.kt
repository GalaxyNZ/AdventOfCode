import java.io.File

object Day2 {


    val scoreMap = mapOf<String, Array<Int>>(
        Pair("AX", arrayOf(1 + 3, 1 + 3)),      // RR
        Pair("AY", arrayOf(1 + 0, 2 + 6)),      // RP
        Pair("AZ", arrayOf(1 + 6, 3 + 0)),      // RS
        Pair("BX", arrayOf(2 + 6, 1 + 0)),      // PR
        Pair("BY", arrayOf(2 + 3, 2 + 3)),      // PP
        Pair("BZ", arrayOf(2 + 0, 3 + 6)),      // PS
        Pair("CX", arrayOf(3 + 0, 1 + 6)),      // SR
        Pair("CY", arrayOf(3 + 6, 2 + 0)),      // SP
        Pair("CZ", arrayOf(3 + 3, 3 + 3)),      // SS
    )

    val winMap = mapOf<String, String>(
        Pair("A", "Y"),
        Pair("B", "Z"),
        Pair("C", "X")
    )

    val loseMap = mapOf<String, String>(
        Pair("A", "Z"),
        Pair("B", "Z"),
        Pair("C", "Y")
    )

    var ourScore = 0
    var theirScore = 0


    private val rounds = File("Day02/puzzle_input").readLines()

    @JvmStatic
    fun main(args: Array<String>) {

        partOne()

        partTwo()
    }

    fun partOne() {

        for (line in rounds) {
            var move = line.replace(" ", "")

            var scores = scoreMap[move]
            theirScore += scores?.get(0)!!
            ourScore += scores?.get(1)!!
        }

        println(theirScore)
        println(ourScore)
    }

    fun partTwo() {

    }

}