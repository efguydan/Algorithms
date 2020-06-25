package practice

//fun twoStrings(s1: String, s2: String): String  = s2.toSet().let {
//    for (char in s1.toSet()) if (it.contains(char)) return "YES"
//    return "NO"
//}

fun twoStrings(s1: String, s2: String): String  = if (s1.toSet().intersect(s2.toSet()).isNotEmpty()) "YES" else "NO"
