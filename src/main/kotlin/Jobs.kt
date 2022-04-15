import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
//            delay(3000)
            println("job1 launched")
            val job2 = launch {
                println("job2 launched")

                delay(3000)
                println("job2 Finishing")

            }
            job2.invokeOnCompletion {
                println("Job2 Completed")
            }
            val job3 = launch {
                println("job3 launched")

                delay(3000)
                println("job3 Finishing")

            }
            job3.invokeOnCompletion {
                println("Job3 Completed")
            }
        }
        job1.invokeOnCompletion {
            println("Jo1 Completed")
        }
        delay(500L)
        println("Job will be cancelled ")
        job1.cancel()
    }
}