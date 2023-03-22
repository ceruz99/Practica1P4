package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root;
        setContentView(view)


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
            if(selected1=="Peso"){
                if(selected2=="Peso"){
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else if(selected2=="Dolar"){
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *= 0.00021;
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else{
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *= 0.00019;
                    mainBinding.resultTextview.text=resultado.toString()
                }
            }
            else if(selected1=="Dolar"){
                if(selected2=="Dolar"){
                    var resultado:Double= mainBinding.valorTextview.text.toString().toDouble()
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else if(selected2=="Peso"){
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *= 4813.43;
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else{
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *=0.93;
                    mainBinding.resultTextview.text=resultado.toString()
                }
            }
            else{
                if(selected2=="Euro"){
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else if(selected2=="Peso"){
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *= 5184.59;
                    mainBinding.resultTextview.text=resultado.toString()
                }
                else{
                    var resultado= mainBinding.valorTextview.text.toString().toDouble()
                    resultado *=1.08;
                    mainBinding.resultTextview.text=resultado.toString()
                }
            }
        }
    }
}