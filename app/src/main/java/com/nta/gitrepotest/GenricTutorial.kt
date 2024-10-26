package com.nta.gitrepotest

import com.nta.gitrepotest.class_tutorial.Circle
import com.nta.gitrepotest.class_tutorial.Rectangle
import com.nta.gitrepotest.class_tutorial.Shape

fun main(){

    val circle1 = Circle(5.0)
    val circle2 = Circle(3.5)

    val rectangle1 = Rectangle(6.0)
    val rectangle2 = Rectangle(4.0, 3.0)

    var integers = (1..10).toList().customFilter1 { it>5 }

    val triple = Triple<String, Int, Boolean>("Hello",10,true)
    val customTriple  = CustomTriple("Hello",10,true)
    customTriple.printTypes()

    var shapes = listOf(circle1, circle2, rectangle1, rectangle2)
    // this is normal filter
//    shapes = shapes.filter { it.area() > 20 }.sortedBy { it.area() }

    // custom filter function with lumbda function
    shapes = shapes.customFilter1{ it.area() > 20 }.sortedBy { it.area() }

    for (shape in shapes) {
        println("${shape.name}: Area = ${shape.area()}")
    }

}

fun <T> List<T>.customFilter1(filterFunction: (T) -> Boolean): List<T> {
    val resultList = mutableListOf<T>()
    for (item in this) {
        if (filterFunction(item)) {
            resultList.add(item)
        }
    }

    return resultList
}