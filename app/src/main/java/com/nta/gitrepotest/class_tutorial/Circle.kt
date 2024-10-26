package com.nta.gitrepotest.class_tutorial

import com.nta.gitrepotest.ImportantNumbers
import kotlin.random.Random

class Circle(
    val radius: Double
) : Shape("Circle") {

    companion object{
        fun randomCircle() : Circle {
            val radius = Random.nextDouble(1.0,10.0)
            return Circle(radius)
        }
    }

    init {
        println("$name created with radius=$radius")
        println("$name area is ${area()}")
        println("$name perimeter is ${perimeter()}")
    }

    override fun area() = ImportantNumbers.PI * radius * radius

    override fun perimeter() = 2 * ImportantNumbers.PI * radius
}