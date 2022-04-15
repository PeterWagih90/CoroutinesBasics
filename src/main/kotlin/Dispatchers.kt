import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch(Dispatchers.IO) {
            //network
        }
        launch(Dispatchers.Main) {
            //UI
            println("Main dispatcher. Thread: ${Thread.currentThread().name}")

        }
        launch(Dispatchers.Default) {
            //CPU

        }
        launch(Dispatchers.Unconfined) {
            //use the same dispatcher that it was called from

        }
        launch(newSingleThreadContext("MyThread")) {

        }
    }
}