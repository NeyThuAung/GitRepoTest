package com.nta.gitrepotest

import com.nta.gitrepotest.class_tutorial.Circle
import com.nta.gitrepotest.class_tutorial.Rectangle
import com.nta.gitrepotest.class_tutorial.Shape

fun main() {

    val circle1 = Circle(5.0)
    val circle2 = Circle(3.5)

    val rectangle1 = Rectangle(6.0)
    val rectangle2 = Rectangle(4.0, 3.0)

    var shapes = listOf(circle1, circle2, rectangle1, rectangle2)

    // this is normal filter
//    shapes = shapes.filter { it.area() > 20 }.sortedBy { it.area() }

    // custom filter function with lumbda function
//    shapes = shapes.customFilter{ it.area() > 20 }.sortedBy { it.area() }
    shapes = shapes.customFilter { shape, string ->
        shape.area() > 20
    }

    for (shape in shapes) {
        println("${shape.name}: Area = ${shape.area()}")
    }

}

fun List<Shape>.customFilter(filterFunction: (Shape,String) -> Boolean): List<Shape> {
    val resultList = mutableListOf<Shape>()
    for (shape in this) {
        if (filterFunction(shape,"Hello")) {
            resultList.add(shape)
        }
    }

    return resultList
}