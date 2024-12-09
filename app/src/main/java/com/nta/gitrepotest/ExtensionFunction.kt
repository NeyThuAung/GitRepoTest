package com.nta.gitrepotest


        fun main(){
            val number = 4
            if (number.isEven()){
                println("$number is an even number")
            }else{
                println("$number is not an even number")
            }
        }

        fun Int.isEven(): Boolean{
            return this % 2 == 0
        }




