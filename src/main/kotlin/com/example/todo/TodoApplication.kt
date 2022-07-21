package com.example.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoApplication
//여기서 사용하는 건 메모리 데이터이고 데이터 베이스 연결 부분은 없다(강의에도....)
fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}
