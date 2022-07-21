package com.example.todo.Controller.api.todo

import com.example.todo.model.http.TodoDto
import com.example.todo.service.TodoService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController (
    val todoService: TodoService
        ){

    //읽기
    @GetMapping("")
    fun read(@RequestParam(required = false)index:Int?): ResponseEntity<Any?> {
        return index?.let {
            todoService.read(it)
        }?.let {
            return ResponseEntity.ok(it)
        }?:kotlin.run {//데이터가 없다면 전체 조회로 이동
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION,"/api/todo/all")
                .build()
        }
    }
    @GetMapping("/all")
    fun readAll(): MutableList<TodoDto> {
        return todoService.readAll()
    }
    //만들기
    @PostMapping("")
    fun create(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }
    //업데이트     생성일댸는 201 업데이트는 200이 나와야 한다고 한다
    @PutMapping("")
    fun update(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }
    //제거
    @DeleteMapping("/{index}")
    fun delete(@PathVariable(name = "index")_index:Int): ResponseEntity<Any> {
        if(todoService.delete(_index)){
            return ResponseEntity.status(500).build()
        }
        return ResponseEntity.ok().build()
    }
}