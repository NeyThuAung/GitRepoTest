package com.nta.gitrepotest

fun main(){
    println("Enter a number : ")

    val input = try {
         readln()?.toInt()
    }catch (e: NumberFormatException){
        0
    }finally {
        println("This is from finally block")
    }

    println("You entered: $input")

}