// 자바 스태틱 대신에 사용
// 정적인 메서드, 변수 사용할때 companion object 사용
class Book private constructor (val id : Int, val name: String) {

    // companion object는 인터페이스구현도 가능
    companion object BookFactory: IdProvider {
        val myBook = "new book"

        fun create() = Book(getId(), myBook)

        override fun getId(): Int {
            return 333
        }
    }
}

interface IdProvider {
    fun getId(): Int
}

fun main() {
//    Book클래스가 private으로 선언 되어있어서 인스턴스를 만들지 못함
//    val book = Book()

    val book = Book.create() // companion object에 정의된 클래스가 생성

    val bookId = Book.BookFactory.getId()
    println("${book.id}  ${book.name}")
}

