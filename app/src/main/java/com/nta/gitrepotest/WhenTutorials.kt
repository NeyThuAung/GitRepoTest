package com.nta.gitrepotest

fun main(){
    val age = readLine()?.toInt()

    when(age){
        in 0..5 -> println("You are a young kid")
        in 6..17 -> println("You are a teenager")
        18 -> println("Finally, You are 18!")
        19, 20 -> println("You are a young adult")
        in 21..65 -> println("You are an adult")
        else -> println("You are really old")
    }

    if (age in 0..5){
        println("You are a young kid")
    }else if (age in 6..17){
        println("You are a teenager")
    }else if (age == 18){
        println("Finally, You are 18!")
    }else if (age == 19 || age == 20){
        println("You are a young adult")
    }else if (age in 21..65){
        println("You are an adult")
    }else{
        println("You are really old")
    }
}