import kotlinx.coroutines.*

fun main(){
    println("Program will now block")
    runBlocking {
        launch {
            delay(1000L)
            println("Blocking Task")
        }
        GlobalScope.launch {
            delay(500L)
            println("Task from Global")
        }
        coroutineScope {
            launch { delay(1500L)
                println("Task from coroutineScope")
            }
        }
    }
    println("Program execution will continue")

}