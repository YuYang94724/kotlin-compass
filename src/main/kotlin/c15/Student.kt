package c15


fun main() {
    val studentA = Student(StudentStatus.Active("Kotlin101"))
    println(studentMessage(studentA.status))
    val studentB = Student(StudentStatus.NotEnrolled)
    println(studentMessage(studentB.status))
}

class Student(val status: StudentStatus)

//enum class StudentStatus {
//    NOT_ENROLLED,
//    ACTIVE,
//    GRADUATED
//}

sealed class StudentStatus {
    object NotEnrolled : StudentStatus()
    class Active(val courseId: String) : StudentStatus()
    object Graduated : StudentStatus()
}

fun studentMessage(status: StudentStatus): String {
    return when (status) {
        is StudentStatus.NotEnrolled -> "Please choose a course!"
        is StudentStatus.Active -> "You are enrolled in: ${status.courseId}"
        is StudentStatus.Graduated -> "Congratulations!"
    }
}
