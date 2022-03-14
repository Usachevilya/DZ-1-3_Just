val convertingSecondsToHours = 3600 //60 * 60
val convertingSecondsToDays = 86400 //24 * 60 * 60
fun main() {
    println(agoToText(7201))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "Был(а) только что"
        in 61..convertingSecondsToDays -> "Был(а) " + translateSecond(seconds) + " назад"
        in convertingSecondsToDays + 1..2 * convertingSecondsToDays -> "Сегодня"
        in 2 * convertingSecondsToDays + 1..3 * convertingSecondsToDays -> "Вчера"
        else -> "Давно"
    }
}

fun translateSecond(seconds: Int): String {
    var total = ""
    if (seconds <= convertingSecondsToHours) {
        val minutes = (seconds / 60)
        if (minutes % 10 == 1) total = "$minutes минуту"
        if (minutes % 10 in 2..4) total = "$minutes минуты"
        if (minutes % 100 in 5..20 || minutes % 100 == 30 || minutes % 100 == 40 || minutes % 100 == 50) total =
            "$minutes минут"
    }
    if (seconds > convertingSecondsToHours) {
        val hours = (seconds / 60 / 60)
        if (hours % 10 == 1) total = "$hours час"
        if (hours % 10 in 2..4) total = "$hours часа"
        if (hours % 100 in 5..20) total = "$hours часов"
    }
    return total
}