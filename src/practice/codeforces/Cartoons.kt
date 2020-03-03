package practice.codeforces

fun main() {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val numberOfCartoons = readLine()!!.toInt()
        val mutableList = mutableListOf<Pair<Int, Int>>()
        var min = 0
        var max = 0
        for (j in 0 until numberOfCartoons) {
            val l = readLine()!!.split(" ")
            val x = Pair(l[0].toInt(), l[1].toInt())
            mutableList.add(x)

            if (j == 0) {
                min = l[0].toInt()
                max = l[1].toInt()
            } else {
                if (min > l[0].toInt()) min = l[0].toInt()
                if (max < l[1].toInt()) max = l[1].toInt()
            }
        }

        var foundOnce: Boolean
        var valid: Boolean
        for (i in min until max + 1) {
            println("Trying $i")
            foundOnce = false
            valid = false
            for (pair in mutableList) {
                if (i in min..max) {
                    if (!foundOnce) {
                        foundOnce = true
                        valid = true
                    } else {
                        valid = false
                    }
                }
            }
            if (foundOnce && valid) {
                println(i)
                break
            }
        }



//        var available = mutableListOf(Pair(min, max))
//        var temp = mutableListOf<Pair<Int, Int>>()
//        for (pair in mutableList) {
//            if (mutableList.size == 1) break
//            temp.clear()
//            for (avail in available) {
//                if (avail.first < pair.first && avail.second > pair.second) {
//                    temp.add(Pair(avail.first, pair.first - 1))
//                    temp.add(Pair(pair.second + 1, avail.second))
//                } else if (avail.first < pair.first) {
//                    temp.add(Pair(avail.first, pair.first-1))
//                } else if (avail.second > pair.second) {
//                    temp.add(Pair(pair.second+1, avail.second))
//                } else if (avail.first == pair.first && avail.second == pair.second) {
//                    temp.add(avail)
//                }
//            }
//            available.clear()
//            available.addAll(temp)
//        }
//        if (available.isNotEmpty()) {
//            println(available[0].first)
//        } else println(-1)
    }
}