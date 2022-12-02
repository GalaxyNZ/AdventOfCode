import java.io.File

object Day2 {


    private val scoreMap = mapOf(
        Pair("AX", arrayOf(1 + 3, 1 + 3)),      // RR
        Pair("AY", arrayOf(1 + 0, 2 + 6)),      // RP
        Pair("AZ", arrayOf(1 + 6, 3 + 0)),      // RS
        Pair("BX", arrayOf(2 + 6, 1 + 0)),      // PR
        Pair("BY", arrayOf(2 + 3, 2 + 3)),      // PP
        Pair("BZ", arrayOf(2 + 0, 3 + 6)),      // PS
        Pair("CX", arrayOf(3 + 0, 1 + 6)),      // SR
        Pair("CY", arrayOf(3 + 6, 2 + 0)),      // SP
        Pair("CZ", arrayOf(3 + 3, 3 + 3)),      // SS

        Pair("A", arrayOf(4, 4)),
        Pair("B", arrayOf(5, 5)),
        Pair("C", arrayOf(6, 6)),
    )

    private val winMap = mapOf(
        Pair("A", "Y"),
        Pair("B", "Z"),
        Pair("C", "X")
    )

    private val loseMap = mapOf(
        Pair("A", "Z"),
        Pair("B", "X"),
        Pair("C", "Y")
    )

    var ourScore = 0
    var theirScore = 0


    private val rounds = File("Day02/puzzle_input").readLines()

    @JvmStatic
    fun main(args: Array<String>) {

        partOne()

        resetScores()

        partTwo()
    }

    private fun partOne() {
        for (line in rounds) {

            val scores = scoreMap[line.replace(" ", "")]
            theirScore += scores?.get(0)!!
            ourScore += scores[1]
        }

        println(ourScore)
    }

    private fun partTwo() {
        for (line in rounds) {
            val move = line.split(" ")
            var them = move[0]

            when (move[1]) {
                "X" -> them += loseMap[them] // Lose
                "Z" -> them += winMap[them] // Win
            }
            val scores = scoreMap[them]

            theirScore += scores?.get(0)!!
            ourScore += scores[1]

        }
        println(ourScore)
    }

    private fun resetScores() {
        ourScore = 0
        theirScore = 0
    }

}