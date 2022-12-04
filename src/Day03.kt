fun main() {
    fun Char.priority() = if (isUpperCase()) this - 'A' + 27 else this - 'a' + 1

    fun part1(input: List<String>): Int {
        return input.map { it.chunked(it.length / 2) }
            .map { it[0].toSet().intersect(it[1].toSet()).single() }
            .sumOf { it.priority() }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3)
            .map {
                it.map { it.toSet() }
                    .reduce { acc, chars -> acc.intersect(chars) }
                    .single()
            }
            .sumOf { it.priority() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    checkTestAnswer(part1(testInput), 157, part = 1)
    checkTestAnswer(part2(testInput), 70, part = 2)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
