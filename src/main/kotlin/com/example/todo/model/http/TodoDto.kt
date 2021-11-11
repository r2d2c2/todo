package com.example.todo.model.http

import com.example.todo.database.Todo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

data class TodoDto (
    var index:Int?=null,   //일정 인덱스
    @field:NotBlank //필수 값으로 빈공간이 없도록
    var title:String?=null, //일정 타이틀

    var description:String?=null,//일정 설명
    @field:NotBlank
    var schedule: String?=null,//일정시간

    var createaAt: LocalDateTime?=null,//생성 시간

    var updatedAt: LocalDateTime?=null//업데이트 시간
){
    @AssertTrue(message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")//어노 테이션 만들기
    fun isValid():Boolean{
        return try {
            LocalDateTime.parse(schedule.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e :Exception){
            false
        }
    }
}

fun TodoDto.convertTodo(todo: Todo): TodoDto {
    return TodoDto().apply {
        this.index=todo.index
        this.title=todo.title
        this.description=todo.description
        this.schedule= todo.schedule?.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createaAt=todo.createaAt
        this.updatedAt=todo.updatedAt
    }
}
