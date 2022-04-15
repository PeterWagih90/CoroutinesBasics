import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(2000)
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(3000)
}
