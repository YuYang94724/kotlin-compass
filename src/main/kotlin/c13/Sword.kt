package c13

import java.util.*

class Sword(_name: String) {
    var name = _name
        get() = "The Legenddary $field"
        set(value) {
            field = value.lowercase(Locale.getDefault()).reversed()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    //多餘的
//    init {
//        name = _name
//    }
}