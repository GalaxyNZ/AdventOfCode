import java.io.File

object Day3 {

    private val lines = File("Day03/puzzle_input").readLines()

    private var items = mutableMapOf<Char, Int>()

    private var priorityIndex = arrayOf(
        "",
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z',
        'A',
        'B',
        'C',
        'D',
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z'
    )

    @JvmStatic
    fun main(args: Array<String>) {
        part1()

        part2()
    }

    private fun part1() {
        for (sackPair in lines) {
            val sacks = arrayOf(
                sackPair.substring(0, sackPair.length / 2).toCharArray().toTypedArray(),
                sackPair.substring(sackPair.length / 2, sackPair.length).toCharArray().toTypedArray()
            )

            for (character in sacks[0]) {
                if (sacks[1].contains(character)) {
                    items[character] = items.getOrDefault(character, 0) + 1
                    break
                }
            }
        }


        println(calculateSum())
    }

    private fun part2() {
        items.clear()
        var group = mutableListOf<MutableList<Char>>()
        val groups = mutableListOf<MutableList<MutableList<Char>>>()

        var e = 0
        for (sack in lines) {
            if (e == 3) {
                e = 0
                groups.add(group)
                group = mutableListOf()
            }
            group.add(e, sack.toCharArray().toTypedArray().toMutableList())

            e++
        }

        groups.add(group)

        loop@ for (trio in groups) {
            for (character in trio[0]) {
                if (trio[1].contains(character) && trio[2].contains(character)) {
                    items[character] = items.getOrDefault(character, 0) + 1
                    continue@loop
                }
            }
        }

        println(calculateSum())
    }


    private fun calculateSum(): Int {
        var sum = 0

        for (item in items.keys) {
            sum += priorityIndex.indexOf(item) * items[item]!!
        }

        return sum
    }
}