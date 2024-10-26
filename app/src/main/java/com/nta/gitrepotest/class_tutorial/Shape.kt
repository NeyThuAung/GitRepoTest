package com.nta.gitrepotest.class_tutorial

abstract open class Shape(
    var name : String
) {

    constructor(name: String, vararg dimensions : Double) : this(name)

    init {
        println("I am super class!")
    }

    abstract fun area() : Double

    abstract fun perimeter() : Double

    fun changeName(newName : String){
        name = newName
    }
}