package com.danvhae.oscar.console.badapple.processors

import com.danvhae.oscar.console.badapple.utils.BrailleUtil.toBraille
import com.danvhae.oscar.console.badapple.utils.BitMaskUtil
import org.bytedeco.javacpp.indexer.UByteIndexer

object ImageProcessor {

    fun calculateAverage(indexer: UByteIndexer, i: Long, j: Long, scale: Int, originWidth: Int, originHeight: Int) : Int{
        var sum = 0
        var count = 0
        repeat(scale){dx ->
            val px = scale * i + dx
            repeat(scale){dy ->
                val py = scale * j + dy
                sum += indexer[py.coerceIn(0, originHeight - 1L), px.coerceIn(0, originWidth - 1L)]
                count++

            }
        }
        return if(count > 0) sum / count else 0
    }

    fun brailleAt(indexer: UByteIndexer, x: Long, y: Long, scale: Int, originWidth: Int, originHeight: Int): Char{
        val pixelsAt = HashSet<Int>()
        repeat(2){dx ->
            repeat(4){ dy ->
                val pixel = calculateAverage(
                    indexer,
                    2 * x  + dx,
                    4 * y  + dy,
                    scale, originWidth, originHeight
                )
                if(pixel >= 128){
                    val pixelNumber = when(val pixelIndex = 4 * dx + dy){
                        0, 1, 2, 7 -> pixelIndex + 1
                        3 -> 7
                        4, 5, 6 -> pixelIndex
                        else -> {
                            throw IllegalStateException("dx : $dx dy: $dy pixel index $pixelIndex is invalid")
                        }
                    }
                    pixelsAt.add(pixelNumber)
                }
            }
        }
        return BitMaskUtil[pixelsAt].toBraille()
    }

    fun process(indexer: UByteIndexer, scale: Int, originWidth: Int, originHeight: Int): String{
        val lines = ArrayList<String>()
        val numberOfX = originWidth / (scale * 2)
        val numberOfY = originHeight / (scale * 4)
        repeat(numberOfY){ y ->
            val yLong = y.toLong()
            var builder = StringBuilder()
            repeat(numberOfX){ x ->
                builder = builder.append(brailleAt(indexer, x.toLong(), yLong, scale, originWidth, originHeight))
            }
            lines.add(builder.toString())
        }
        return lines.joinToString("\n")
    }


}