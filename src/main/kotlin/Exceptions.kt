import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val myHandle = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Exception Handled: ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(Dispatchers.Default+myHandle){
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("we have exception")
        }
        job.join()
//////////////////////////////////////////
        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("we have async exception")
        }
        try {
            deferred.await()
        }catch (e:Exception){
            println("Exception Async: ${e.localizedMessage}")
        }

    }

}