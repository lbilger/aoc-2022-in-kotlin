enum class Shape {
    ROCK, PAPER, SCISSORS
}

enum class Outcome {
    LOSS, DRAW, WIN
}
fun main() {
    fun String.toShape() = when (this) {
        "A", "X" -> Shape.ROCK
        "B", "Y" -> Shape.PAPER
        "C", "Z" -> Shape.SCISSORS
        else -> error("Unexpected input $this")
    }

    fun String.toOutcome() = when (this) {
        "X" -> Outcome.LOSS
        "Y" -> Outcome.DRAW
        "Z" -> Outcome.WIN
        else -> error("Unexpected input $this")
    }

    fun shapeScore(shape: Shape) = when (shape) {
        Shape.ROCK -> 1
        Shape.PAPER -> 2
        Shape.SCISSORS -> 3
    }

    fun resultScore(opponentShape: Shape, myShape: Shape) = when (opponentShape) {
        myShape -> 3
        Shape.ROCK -> if (myShape == Shape.PAPER) 6 else 0
        Shape.PAPER -> if (myShape == Shape.SCISSORS) 6 else 0
        Shape.SCISSORS -> if (myShape == Shape.ROCK) 6 else 0
    }

    fun part1(input: List<String>): Int {
        return input.map { it.split(" ") }.sumOf { shapeScore(it[1].toShape()) + resultScore(it[0].toShape(), it[1].toShape()) }
    }

    fun myShape(opponentShape: Shape, desiredOutcome: Outcome) = when(desiredOutcome) {
        Outcome.DRAW->opponentShape
        Outcome.WIN -> Shape.values()[(opponentShape.ordinal + 1) % 3]
        Outcome.LOSS -> Shape.values()[(opponentShape.ordinal - 1 + 3) % 3]
    }
    fun part2(input: List<String>): Int {
        return input.map { it.split(" ") }.sumOf {
            val opponentShape = it[0].toShape()
            val myShape = myShape(opponentShape, it[1].toOutcome())
            shapeScore(myShape) + resultScore(opponentShape, myShape)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    checkTestAnswer(part1(testInput), 15, part = 1)
    checkTestAnswer(part2(testInput), 12, part = 2)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
