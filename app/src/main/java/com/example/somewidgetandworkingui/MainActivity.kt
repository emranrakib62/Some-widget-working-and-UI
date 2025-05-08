package com.example.somewidgetandworkingui



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.somewidgetandworkingui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle the Material Switch for "Bamboo Recommended"
        binding.bamboSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Bamboo Recommended: On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bamboo Recommended: Off", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle the payment options from the RadioGroup (Cash/Card)
        var isPaymentSelected = false
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            isPaymentSelected = when (checkedId) {
                R.id.cash -> true
                R.id.card -> true
                else -> false
            }
        }

        // Handle the Submit button click
        binding.submit.setOnClickListener {
            // Get the name input
            val name = binding.nameedit.text.toString().trim()

            // Validation logic for input fields
            if (name.isEmpty()) {
                binding.nameedit.error = "Name field is required"
            } else if (!isPaymentSelected) {
                Toast.makeText(this, "You have to select a payment option", Toast.LENGTH_SHORT).show()
            } else if (!binding.cheainfo.isChecked || !binding.cheakagree.isChecked) {
                Toast.makeText(this, "You need to agree to the terms", Toast.LENGTH_SHORT).show()
            } else {
                // All validations passed, proceed with further logic (e.g., show success message)
                Toast.makeText(this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
