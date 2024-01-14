package com.example.myfireauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoggedInActivity2 : AppCompatActivity() {
    var myAuth  = FirebaseAuth.getInstance()
    lateinit var btn : Button
    lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in2)
        btn = findViewById(R.id.logout)
        textView = findViewById(R.id.textView)
        var myIntent : Intent = intent
        var myUserEmail = myIntent.getStringExtra("id")
        textView.text = myUserEmail

        btn.setOnClickListener { view->

            Toast.makeText(this,"Logging Out ...",Toast.LENGTH_LONG).show()
            signOut()
        }

        myAuth.addAuthStateListener {
            if (myAuth.currentUser==null){
                this.finish()
            }
        }
    }

    private fun signOut() {
        myAuth.signOut()
    }
}