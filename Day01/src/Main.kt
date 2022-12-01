import java.io.File
import java.util.*

object Main {

    var calories_list = arrayOf<Int>()
    var calories = 0

    @JvmStatic
    fun main(args: Array<String>) {
        println(part1().last())

        println(part2())
    }

    fun part1(): Array<Int> {
        // Set up scanner
        val scanner = Scanner(File("Day01/puzzle_input"))

        while (scanner.hasNext()) {
            val line = scanner.nextLine()
            // if it is a number
            if (!line.isNullOrBlank()) {
                calories += line.toInt()
            } else {
                calories_list += calories
                calories = 0
            }
        }

        calories_list.sort()
        return calories_list
    }

    fun part2(): Int {
        calories_list.reverse()

        return calories_list[0] + calories_list[1] + calories_list[2]
    }
}
