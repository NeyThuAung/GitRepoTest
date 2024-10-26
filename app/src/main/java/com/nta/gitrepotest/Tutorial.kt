package com.nta.gitrepotest

fun main(){
    val list = mutableListOf<Int>()
    for (i in 1..5) {
        val x = readLine()?.toInt()
        if (x != null) {
            list.add(x)
        }
    }
    val y = list.size
    println("Reversed List")
    for (i in (y-1) downTo 0){
        println(list[i])
    }
}