package com.nta.gitrepotest.class_tutorial

fun main(){
    val rectangle = Rectangle(10.0,2.0)
    rectangle.changeName("Ney Thu")
    println("The  name of the rectangle is ${rectangle.name}")

    val circle = Circle(5.0)
    circle.changeName("Hnin Thiri")
    println("The name of the circle is ${circle.name}")

    val maxRecCir = maxArea(rectangle,circle)
    val maxThreeShape = maxArea(rectangle,circle,Rectangle(1.4, 5.4))

    println("The maximum area of the rectangle and circle is $maxRecCir")
    println("The maximum area of the rectangle and circle and other is $maxThreeShape")

    val circleArea = Circle.randomCircle()
}


fun maxArea(shape1 : Shape, shape2 : Shape) : Double{
    val areaShape1 = shape1.area()
    val areaShape2 = shape2.area()

    if (areaShape1 > areaShape2)
        return areaShape1
    else
        return areaShape2
}

//overloading functions
fun maxArea(shape1 : Shape, shape2: Shape, shape3 : Shape) : Double{
    val maxAreaShape1Shape2 = maxArea(shape1,shape2)
    val areaShape3 = shape3.area()
    return if (maxAreaShape1Shape2 > areaShape3) maxAreaShape1Shape2 else areaShape3
}