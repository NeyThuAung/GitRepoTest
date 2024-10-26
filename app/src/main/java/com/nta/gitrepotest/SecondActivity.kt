package com.nta.gitrepotest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.nta.gitrepotest.databinding.ActivitySecondBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

data class Person(
    val name: String = "",
    val age: Int = -1
)

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tutorialDocument = Firebase.firestore.collection("coroutines")
            .document("tutorial")
        val peter = Person("Peter", 21)
        GlobalScope.launch {
            delay(3000L)
            tutorialDocument.set(peter).await()
            val person = tutorialDocument.get().await().toObject(Person::class.java)
            withContext(Dispatchers.Main) {
                binding.tvText.text = person.toString()
            }
        }


    }
}