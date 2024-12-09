package com.nta.gitrepotest



        fun main(){
            // List - Immutable (read-only)
            val immutableList: List<String> = listOf("Apple", "Banana", "Cherry")
            println("List (Immutable): $immutableList")

            // Array - Fixed size, mutable elements
            val fruitArray: Array<String> = arrayOf("Date", "Elderberry", "Fig")
            fruitArray[1] = "Dragonfruit"  // Mutable elements
            println("Array (Fixed Size, Mutable Elements): ${fruitArray.joinToString()}")

            // MutableList - Dynamic size, fully mutable
            val mutableList: MutableList<String> = mutableListOf("Grape", "Honeydew")
            mutableList.add("Kiwi")
            mutableList.removeAt(0)
            println("MutableList (Dynamic, Mutable): $mutableList")

            // ArrayList - Specific type of MutableList, backed by an array
            val arrayList: ArrayList<String> = arrayListOf("Lemon", "Mango")
            arrayList.add("Nectarine")
            arrayList[1] = "Melon"
            println("ArrayList (Backed by Array): $arrayList")
        }






