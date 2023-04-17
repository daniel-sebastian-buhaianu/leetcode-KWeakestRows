fun main() {
    val matrix = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 0),
        arrayOf(1, 0, 0, 0, 0),
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 1)
    )
    println(KWeakestRows(matrix, k=3).joinToString())
}

fun KWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    return arrayOf(1, 2, 3)
}