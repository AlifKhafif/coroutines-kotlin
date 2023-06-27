import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun getCapitalAsc(): Int {
    delay(1000L)
    return 50000
}

suspend fun getIncomeAsc(): Int {
    delay(1000L)
    return 75000
}

fun main() = runBlocking {
    val timeOne = measureTimeMillis {
        val capitalAsc = getCapitalAsc()
        val incomeAsc = getIncomeAsc()
        println("Your profit is ${incomeAsc - capitalAsc}")
    }

    val timeTwo = measureTimeMillis {
        val capitalAsc = async { getCapitalAsc() }
        val incomeAsc = async { getIncomeAsc() }
        println("Your profit is ${incomeAsc.await() - capitalAsc.await()}")
    }

    println("Completed in $timeOne ms vs $timeTwo ms")
}