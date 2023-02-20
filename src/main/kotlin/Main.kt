import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths


class Day01(input: String) {

    private val calories = parseInput(input)

    //tar de topp 3 resultaten från listan och adderar ihop dessa
    fun solvePart2(): Int =
        calories.take(3).sum()

//tar de första elementet i den redan sorterade listan
    fun solvePart1(): Int =
        calories.first()

    //Läser raderna, trimmar bort whitespace, splittar vid 2 blanka rader, gör om från sträng till ints och sen sorterar
    private fun parseInput(input: String): List<Int> =
        input
            .trim()
            .split("\n\n")
            .map { it.lines().sumOf(String::toInt) }
            .sortedDescending()


}


fun main(args: Array<String>) {
    //läser från .txt filen och gör om till en sträng
    val path = System.getProperty("user.dir") + "\\src\\main\\resources\\input.txt"
    val encoded = Files.readAllBytes(Paths.get(path))
    val lines = String(encoded)

    val day01 = Day01(lines)

    println(day01.solvePart1())
    println(day01.solvePart2())
}