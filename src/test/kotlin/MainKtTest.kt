import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

internal class MainKtTest {

    @Test
    fun matrixChain() {
        val p = intArrayOf(30, 35, 15, 5, 10, 20, 25)
        val n = p.size - 1
        val results = matrixChain(p)

        println("================")
        results.first.forEach { println(it.contentToString()) }
        println("================")
        results.second.forEach { println(it.contentToString()) }
        println("================")

        val m = arrayOf(
            intArrayOf(0, 15750, 7875, 9375, 11875, 15125),
            intArrayOf(0, 0, 2625, 4375, 7125, 10500),
            intArrayOf(0, 0, 0, 750, 2500, 5375),
            intArrayOf(0, 0, 0, 0, 1000, 3500),
            intArrayOf(0, 0, 0, 0, 0, 5000),
            intArrayOf(0, 0, 0, 0, 0, 0)
        )

        val s = arrayOf(
            intArrayOf(0, 1, 1, 3, 3, 3),
            intArrayOf(0, 0, 2, 3, 3, 3),
            intArrayOf(0, 0, 0, 3, 3, 3),
            intArrayOf(0, 0, 0, 0, 4, 5),
            intArrayOf(0, 0, 0, 0, 0, 5)
        )

        results.first.forEachIndexed { index, item ->
            assertContentEquals(m[index], item)
        }

        results.second.forEachIndexed { index, item ->
            assertContentEquals(s[index], item)
        }

        printOptimalParens(results.second, 0, n - 1)

        println()

    }
}