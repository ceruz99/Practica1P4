package com.example.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val resultado : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    fun calcular(selected1:String, selected2:String,valor:Double){
        if(selected1=="Peso"){
            if(selected2=="Peso"){
                resultado.value= valor
            }
            else if(selected2=="Dolar"){
                resultado.value = valor * 0.00021;
            }
            else{
                resultado.value = valor * 0.00019;
            }
        }
        else if(selected1=="Dolar"){
            if(selected2=="Dolar"){
                resultado.value = valor
            }
            else if(selected2=="Peso"){
                resultado.value = valor * 4813.43
            }
            else{
                resultado.value = valor * 0.93
            }
        }
        else{
            if(selected2=="Euro"){
                resultado.value = valor
            }
            else if(selected2=="Peso"){
                resultado.value = valor * 5184.59
            }
            else{
                resultado.value = valor * 1.08
            }
        }
    }
}