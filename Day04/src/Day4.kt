import java.io.File

object Day4 {

    private val lines = File("Day04/puzzle_input").readLines()

    @JvmStatic
    fun main(args: Array<String>) {
        part1()

        part2()
    }

    private fun part1() {
        var sum = 0
        for (line in lines) {
            val sectionsStr = line.split(",", "-")
            val sectionsInt = mutableListOf<Int>()

            for (section in sectionsStr) {
                sectionsInt.add(section.toInt())
            }

            if (
                (sectionsInt[0] <= sectionsInt[2] && sectionsInt[1] >= sectionsInt[3]) ||
                (sectionsInt[0] >= sectionsInt[2] && sectionsInt[1] <= sectionsInt[3])
            ) {
                sum++
            }
        }
        println(sum)
    }

    private fun part2() {
        var sum = 0
        for (line in lines) {
            val sectionsStr = line.split(",", "-")
            val sections = mutableListOf<Int>()

            for (section in sectionsStr) {
                sections.add(section.toInt())
            }

            if (
                !(sections[0] > sections[3] || sections[2] > sections[1])
            ) {
                sum++
            }
        }
        println(sum)
    }
}