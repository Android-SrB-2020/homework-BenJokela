package com.example.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var name = "Dave"
    var salutation: Int = R.string.sal_1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        salutation = savedInstanceState?.getInt("SAL", 0)?: salutation

//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivity = this
        binding.doitButton.setOnClickListener{
            salutation = when (salutation){
                R.string.sal_1 -> R.string.sal_2
                R.string.sal_2 -> R.string.sal_3
                else -> R.string.sal_1
            }
            //refresh the binding
            binding.invalidateAll()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SAL", salutation)
    }
}
