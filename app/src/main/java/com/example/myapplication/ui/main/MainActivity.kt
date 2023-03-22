package com.example.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = mainBinding.root;
        setContentView(view)

        val calcularObserver = Observer<Double>{resultado->
            mainBinding.resultTextview.text=resultado.toString()
        }
        mainViewModel.resultado.observe(this,calcularObserver)

        var selected1:String="";
        var selected2:String="";

        //Configuracion spinners
        val monedas=resources.getStringArray(R.array.opciones);
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainBinding.spinner1.adapter=adapter;
        mainBinding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selected1=monedas[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        mainBinding.spinner2.adapter=adapter;
        mainBinding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selected2=monedas[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        mainBinding.convertButton.setOnClickListener{
            if(mainBinding.valorTextview.text.toString().isDigitsOnly()){
                mainViewModel.calcular(selected1,selected2,mainBinding.valorTextview.text.toString().toDouble())
            }
        }
    }
}