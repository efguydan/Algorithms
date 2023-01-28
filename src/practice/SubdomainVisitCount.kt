package practice

/**
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/subdomain-visit-count
 * Progress: Done
 */
object SubdomainVisitCount {

    @JvmStatic
    fun main(args: Array<String>) {
        println(subdomainVisits(arrayOf("9001 discuss.leetcode.com")))
        println(subdomainVisits(arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")))
    }

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val map = mutableMapOf<String, Int>()
        val answer = mutableListOf<String>()
        for (domain in cpdomains) {
            val split = domain.split(" ")
            val count = split[0].toInt()
            var url = split[1]
            while (true) {
                map[url] = (map[url] ?: 0) + count
                val firstIndex = url.indexOf('.')
                if (firstIndex != -1) {
                    url = url.removeRange(0, firstIndex+1)
                } else {
                    break
                }
            }
        }
        for (key in map.keys) {
            answer.add("${map[key]} $key")
        }
        return answer
    }
}
