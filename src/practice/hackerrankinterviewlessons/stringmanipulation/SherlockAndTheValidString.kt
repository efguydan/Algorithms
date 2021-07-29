package practice.hackerrankinterviewlessons.stringmanipulation

import kotlin.math.abs

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * Progress: Done
 */

object SherlockAndTheValidString {

    @JvmStatic
    fun main(args: Array<String>) {
        val input1 = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"
        val input2 = "aaaabbcc"
        val input3 = "abcdefghhgfedecba"
        println(isValid(input3))
    }

    private fun isValid(s: String): String {
        val map = mutableMapOf<Char, Int>()
        for (char in s) {
            var temp = map[char] ?: 0
            map[char] = ++temp
        }

        val valuesMap = mutableMapOf<Int, Int>()
        for (key in map.keys) {
            var temp = valuesMap[map[key]!!] ?: 0
            valuesMap[map[key]!!] = ++temp
        }

        val keys = valuesMap.keys.toList()
        if (keys.size > 2) return "NO"
        if (keys.size < 2) return "YES"

        val first = keys[0]
        val second = keys[1]

        return if (abs(first - second) == 1 && (valuesMap[second]!! == 1 || valuesMap[first]!! == 1)) {
            "YES"
        } else if (first == 1 && valuesMap[first]!! == 1) {
            "YES"
        } else if (second == 1 && valuesMap[second]!! == 1) {
            "YES"
        } else {
            "NO"
        }
    }

}