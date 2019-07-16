package com.example.randomnumbergenerator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {
	companion object {
		const val TOTAL_COUNT = "total_count"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_second)
		showRandomNumber()
	}

	fun showRandomNumber() {
		// Get the count from the intent extras
		val count = intent.getIntExtra(TOTAL_COUNT, 0)

		// Generate the random number
		val random = Random()
		var randomInt = 0
		// Add one because the bound is exclusive
		if (count > 0) {
			// Add one because the bound is exclusive
			randomInt = random.nextInt(count + 1)
		}

		// Display the random number.
		findViewById<TextView>(R.id.random_number_label).text = Integer.toString(randomInt)

		// Substitute the max value into the string resource
		// for the heading, and update the heading
		findViewById<TextView>(R.id.random_number_heading_label).text = getString(R.string.random_heading, count)
	}

	fun goBackMe(view: View) {
		// Create an Intent to start the main activity
		val mainIntent = Intent(this, MainActivity::class.java)

		// Get the text view
		val showCountTextView = findViewById<TextView>(R.id.random_number_label)

		// Get the value of the text view.
		val countString = showCountTextView.text.toString()

		// Convert the count to an int
		val count = Integer.parseInt(countString)

		// Add the count to the extras for the Intent.
		mainIntent.putExtra(MainActivity.DEFAULT_NUMBER, count)

		// Start the new activity.
		startActivity(mainIntent)
	}
}
