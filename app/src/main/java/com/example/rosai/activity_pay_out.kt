package com.example.rosai

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rosai.databinding.ActivityPayOutBinding
import com.example.rosai.databinding.FragmentCartBinding

class activity_pay_out : AppCompatActivity() {
    private lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PlaceMyOrder.setOnClickListener{
            val bottomSheetDialog=CongratsButtonSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

    }
}