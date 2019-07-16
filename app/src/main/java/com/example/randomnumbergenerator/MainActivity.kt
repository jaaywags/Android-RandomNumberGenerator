package com.example.randomnumbergenerator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
	companion object {
		const val DEFAULT_NUMBER = "0"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setStartNumber()
	}

	fun setStartNumber() {
		// Get the count from the intent extras
		val count = intent.getIntExtra(DEFAULT_NUMBER, 0)

		// Display the random number.
		findViewById<TextView>(R.id.generated_number_text).text = Integer.toString(count)
	}

	fun toastMe(view: View) {
		// val myToast = Toast.makeText(this, message, duration);
		val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
		myToast.show()
	}

	fun countMe (view: View) {
		// Get the text view
		val showCountTextView = findViewById<TextView>(R.id.generated_number_text)

		// Get the value of the text view.
		val countString = showCountTextView.text.toString()

		// Convert value to a number and increment it
		var count: Int = Integer.parseInt(countString)
		count++

		// Display the new value in the text view.
		showCountTextView.text = count.toString();
	}

	fun randomMe(view: View) {
		// Create an Intent to start the second activity
		val randomIntent = Intent(this, SecondActivity::class.java)

		// Get the text view
		val showCountTextView = findViewById<TextView>(R.id.generated_number_text)

		// Get the value of the text view.
		val countString = showCountTextView.text.toString()

		// Convert the count to an int
		val count = Integer.parseInt(countString)

		// Add the count to the extras for the Intent.
		randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

		// Start the new activity.
		startActivity(randomIntent)
	}
}
