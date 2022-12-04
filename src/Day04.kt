fun main() {
    fun <T: Comparable<T>> ClosedRange<T>.containsAll(other: ClosedRange<T>) = start <= other.start && endInclusive >= other.endInclusive

    fun String.toRange(): IntRange {
        val parts = split("-")
        return parts[0].toInt()..parts[1].toInt()
    }

    fun ranges(input: List<String>) = input.map { it.split(",").map { it.toRange() } }

    fun part1(input: List<String>): Int {
        return ranges(input)
            .count { it[0].containsAll(it[1]) || it[1].containsAll(it[0]) }
    }

    fun part2(input: List<String>): Int {
        return ranges(input)
            .count { it[0].intersect(it[1]).isNotEmpty() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    checkTestAnswer(part1(testInput), 2, part = 1)
    checkTestAnswer(part2(testInput), 4, part = 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
