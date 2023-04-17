fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1)
    )
    println(KWeakestRows(matrix, k=3).joinToString())
}

fun KWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    // Store number of rows
    val n = mat.size

    // Store number of columns
    val m = mat[0].size

    // Create list of pairs (row_index, row_strength)
    val rowsWithStrength: MutableList<Pair<Int,Int>> = mutableListOf()

    // Calculate strength of each row in matrix
    var i = 0
    while (i < n) {
        var j = 0
        var strength = 0
        while (j < m) {
            if (mat[i][j] == 1) {
                strength++
            } else {
                rowsWithStrength.add(Pair(i, strength))
                strength = 0
                break;
            }
            j++
        }
        if (strength > 0) {
            rowsWithStrength.add(Pair(i, strength))
        }
        i++
    }

    // Sort rows firstly by strength and secondly by index
    rowsWithStrength.sortWith(compareBy({it.second}, {it.first}))    
    
    // Store sorted rows
    val sortedRows: MutableList<Int> = mutableListOf()
    rowsWithStrength.forEach { sortedRows.add(it.first) }

    // Copy sorted rows in result (first k rows = K Weakest Rows)
    val result: MutableList<Int> = mutableListOf()
    for(index in 0..k-1) {
        result.add(sortedRows[index])
    }

    return result.toIntArray()
}