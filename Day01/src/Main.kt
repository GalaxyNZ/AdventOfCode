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

        // Iterate through each line
        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            if (!line.isNullOrBlank()) { // if it is a number
                calories += line.toInt()
            } else { // if it is a blank line
                calories_list += calories
                calories = 0
            }
        }

        // sort list and return
        calories_list.sort()
        return calories_list
    }

    fun part2(): Int {
        // Reverse the list
        calories_list.reverse()

        // Add the first 3 and return
        return calories_list[0] + calories_list[1] + calories_list[2]
    }
}
