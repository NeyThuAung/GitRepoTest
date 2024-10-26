package com.nta.gitrepotest

fun main(){
    print("Enter a number : ")
    val number = readLine()?.toInt()
    if (number != null){
        if (number.isPrime()){
            println("$number is a prime number")
        }else{
            println("$number is not a prime number")
        }
    }
}

fun Int.isPrime(): Boolean{
    return this % 2 == 0
}