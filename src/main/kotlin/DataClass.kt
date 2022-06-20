import java.util.Date

class DataClass {
}
// 데이터클래스 -> 자바에서 pojo클래스와 비슷
// pojo클래스(어떤 메서드가 작동하는게 아니라 틀 역할을 하는 클래스들)를 만들기위해서 자바는 하나하나 만들어줬어야 하지만 코틀린에서는 데이터클래스만 사용하면 됨
// 생성자 + toString() + hashCode() + equals(), copy()를 컴파일러가 자동으로 만들어 줌
data class Ticket(val companyName:String, val name: String, var date: String, var seatNumber: Int)

class TicketNormal(val companyName:String, val name: String, var date: String, var seatNumber: Int)


fun main() {
    val ticketA = Ticket("대한 항공", "nameA", "2022.12.24", 33)
    val ticketB = TicketNormal("대한 항공", "nameA", "2022.12.24", 33)

    // data 클래스와 일반 클래스 차이
    println(ticketA) // Ticket(companyName=대한 항공, name=nameA, date=2022.12.24, seatNumber=33)
    println(ticketB) // TicketNormal@a09ee92
}
