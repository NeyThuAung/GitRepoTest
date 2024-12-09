package com.nta.gitrepotest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.nta.gitrepotest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlin.system.measureTimeMillis

@OptIn(DelicateCoroutinesApi::class)
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //test
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Coroutines Context
//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d(TAG, "Starting coroutines in thread ${Thread.currentThread().name}")
//            val answer = doNetworkCall()
//            withContext(Dispatchers.Main){
//                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
//                findViewById<TextView>(R.id.tvHello).text = answer
//            }
//        }

//        Log.d(TAG, "Before running runBlocking")
//        runBlocking {
//            launch(Dispatchers.IO) {
//                delay(500L)
//                Log.d(TAG, "Fininshed IO Coroutine 1")
//            }
//
//            launch(Dispatchers.IO) {
//                delay(500L)
//                Log.d(TAG, "Fininshed IO Coroutine 2")
//            }
//
//            Log.d(TAG, "Start of runBlocking")
//            delay(700L)
//            Log.d(TAG, "End of runBlocking")
//        }
//        Log.d(TAG, "After running runBlocking")

        //withTimeOut example to cancel job after 3 seconds
//        GlobalScope.launch(Dispatchers.Default) {
//            Log.d(TAG, "Starting long calculation...")
//            withTimeout(3000L){
//                for (i in 30..40){
//                    if (isActive){
//                        Log.d(TAG, "Result for i = $i: ${fib(i)}")
//                    }
//                }
//            }
//        }

        // Async and Await Example
//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                val answer1 = async { networkCall1() }
//                val answer2 = async { networkCall2() }
//                Log.d(TAG, "Answer1 is ${answer1.await()}")
//                Log.d(TAG, "Answer2 is ${answer2.await()}")
//            }
//            Log.d(TAG, "Request took $time ms.")
//        }

        binding.ccpPhone.setOnClickListener {
            val countryCode = binding.ccpPhone.selectedCountryCode()
            Toast.makeText(this, "Country Code: $countryCode", Toast.LENGTH_SHORT).show()
        }

        binding.btnNextActivity.setOnClickListener{
            lifecycleScope.launch {
                while (true){
                    delay(1000L)
                    Log.d("MainActivity", "Still running...")
                }
            }

            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        val handler = CoroutineExceptionHandler { _, throwable ->
            println("Exception handled: throwable")
        }
        CoroutineScope(Dispatchers.IO + handler ).launch {
            launch {
                delay(300L)
                throw Exception("Coroutine 1 Error!")
            }
            launch {
                delay(300L)
                println("Coroutine 2 finished")
            }
        }

    }

    suspend fun networkCall1() : String {
        delay(3000L)
        return "Answer 1"
    }

    suspend fun networkCall2() : String {
        delay(3000L)
        return "Answer 2"
    }

    suspend fun doNetworkCall() : String{
        delay(800L)
        return "This is answer."
    }

    fun fib(n : Int) : Long{
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n-1) + fib(n-2)
    }

}