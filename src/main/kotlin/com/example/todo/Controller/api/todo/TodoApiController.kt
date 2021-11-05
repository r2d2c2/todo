package com.example.todo.Controller.api.todo

import com.example.todo.model.http.TodoDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController {

    //읽기
    @GetMapping("")
    fun read(@RequestParam(required = false)index:Int?){

    }
    //만들기
    @PostMapping("")
    fun create(@Valid @RequestBody todoDto: TodoDto){

    }
    //업데이트
    @PutMapping("")
    fun update(@Valid @RequestBody todoDto: TodoDto){

    }
    //제거
    @DeleteMapping("/{index}")
    fun delete(@PathVariable(name = "index")_index:Int){

    }
}