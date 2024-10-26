package com.nta.gitrepotest

class CustomTriple<A : Any,B : Any,C : Any>(
    val first : A,
    val second : B,
    val third : C
) {

    fun printTypes(){
        println("The type of first is ${first::class}")
        println("The type of second is ${second::class}")
        println("The type of third is ${third::class}")
    }
}