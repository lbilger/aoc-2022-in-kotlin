fun main() {
    fun caloriesList(input: List<String>) =
        input.fold(listOf<Int>()) { acc, line -> if (line.isEmpty()) acc + 0 else acc.dropLast(1) + ((acc.lastOrNull() ?: 0) + line.toInt()) }

    fun part1(input: List<String>): Int {
        return caloriesList(input).max()
    }

    fun part2(input: List<String>): Int {
        return caloriesList(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    checkTestAnswer(part1(testInput), 24000, part = 1)
    checkTestAnswer(part2(testInput), 45000, part = 2)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
