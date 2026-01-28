package com.danvhae.oscar.console.badapple

object BitMaskUtil {
    private val int2set = HashMap<Int, Set<Int>>()
    private val set2int = HashMap<Set<Int>, Int>()

    init{
        val queue = ArrayList<List<Int>>()
        queue.add(emptyList())

        repeat(8){
            val number = it + 1
            queue.addAll(queue.map { list -> list.toMutableList().apply { add(number) } })
        }
        for(list in queue){
            val set = list.toSet()
            var current = 0
            repeat(8){
                val number = it + 1
                if(number in set){
                    current += (2 shl it)
                }
            }
            int2set[current] = set
            set2int[set] = current
        }
    }
}