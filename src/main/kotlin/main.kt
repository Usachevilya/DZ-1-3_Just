val translationInHours = 60 * 60
val translationInDay = 24 * 60 * 60
fun main(){
println(agoToText(61))
}

fun agoToText(second : Int) : String {
    return when (second) {
        in 0 .. 60 -> "Был(а) только что"
        in 61 .. translationInHours -> "Был(а) " + minToText(second) + " назад"
        in translationInHours + 1 .. translationInDay -> "Был(а) " + hourToText(second) + " назад"
        in translationInDay + 1 .. 2 * translationInDay -> "Сегодня"
        in 2 * translationInDay + 1 .. 3 * translationInDay -> "Вчера"
        else -> "Давно"
    }
}

fun minToText(second : Int): String {
    val minute = (second / 60)
    var total = ""

    if (minute % 10 == 1) total = "$minute минуту"
    if (minute % 10 in 2..4) total = "$minute минуты"
    if (minute % 100 in 5..20 || minute % 100 == 30 || minute % 100 == 40 || minute % 100 == 50 ) total = "$minute минут"
    return total
}
fun hourToText(second : Int): String {
    val hour = (second / 60 / 60)
    var total = ""

    if (hour % 10 == 1) total = "$hour час"
    if (hour % 10 in 2..4) total = "$hour часа"
    if (hour % 100 in 5..20) total = "$hour часов"
    return total
}