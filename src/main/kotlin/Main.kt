import kotlin.Float.Companion.POSITIVE_INFINITY

fun main() {
    val p = intArrayOf(5, 10, 3, 12, 5, 50, 6)
    val n = p.size - 1
    val results = matrixChain(p)

    println("================")
    results.first.forEach { println(it.contentToString()) }
    println("================")
    results.second.forEach { println(it.contentToString()) }
    println("================")

    printOptimalParens(results.second, 0, n - 1)
}

fun matrixChain(p: IntArray): Pair<Array<IntArray>, Array<IntArray>> {
    val n = p.size - 1

    val m = Array(n) { IntArray(n) }
    val s = Array(n - 1) { IntArray(n) }

    for (i in 0 until n) {
        m[i][i] = 0
    }

    for (l in 1..n) {
        for (i in 0 until n - l) {
            val j = i + l
            m[i][j] = POSITIVE_INFINITY.toInt()
            for (k in i until j) {
                val q = m[i][k] + m[k + 1][j] + p[i].times(p[k + 1]).times(p[j + 1])
                if (q < m[i][j]) {
                    m[i][j] = q
                    s[i][j] = k + 1
                }
            }
        }
    }

    return Pair(m, s)
}

fun printOptimalParens(s: Array<IntArray>, i: Int, j: Int) : String {
    return if(i == j){
        "A${i + 1}"
    } else {
        print("(")
        print(printOptimalParens(s, i, s[i][j] - 1 ))
        print(printOptimalParens(s, s[i][j], j))
        print(")")
        ""
    }
}