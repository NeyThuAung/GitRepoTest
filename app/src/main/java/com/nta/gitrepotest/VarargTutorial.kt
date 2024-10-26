package com.nta.gitrepotest

fun main(){
    val array = intArrayOf(20,50,60)
    val max = getMax(1,2,5,*array,10,11,6)
    println("The max value is $max")
}

fun getMax(vararg numbers : Int) : Int{
    var max = numbers[0]
    for(number in numbers){
        if(number > max){
            max = number
        }
    }
    return max
}
