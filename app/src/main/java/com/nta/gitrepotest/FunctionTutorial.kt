package com.nta.gitrepotest

fun main(){
    print("Enter number to add : ")
    addOneToInput(readLine()?.toInt()!!)
}

fun addOneToInput(inputNumber : Int){
    var result = 0
    for (i in 1..inputNumber){
        result += i
    }
    println("The sum of the value from 1 to $inputNumber is $result")
}