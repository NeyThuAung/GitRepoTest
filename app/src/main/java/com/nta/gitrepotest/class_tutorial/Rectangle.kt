package com.nta.gitrepotest.class_tutorial

class Rectangle(
    val width: Double,
    val height: Double
) : Shape("Rectangle") {

    //overloading constructor
    // call this constructor when user input only one value
    constructor(width: Double) : this(width, width)

    // call this constructor when user input values with Int type and change to Double Type
    constructor(width : Int, height : Int) : this(width.toDouble(), height.toDouble())

    init {
        println("Rectangle created with width=$width and height=$height")
        println("$name area is ${area()}")
        println("$name perimeter is ${perimeter()}")
    }

    override fun area() = width * height

    override fun perimeter() = 2 * width + 2 * height

    fun isSquare() = width == height

}