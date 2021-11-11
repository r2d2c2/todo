package com.example.todo.service

import com.example.todo.database.Todo
import com.example.todo.database.convertTodoDto
import com.example.todo.model.http.TodoDto
import com.example.todo.model.http.convertTodo
import com.example.todo.repository.TodoRepositorImpl
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepositorImpl: TodoRepositorImpl
) {

    fun create(todoDto: TodoDto): TodoDto?{
        return todoDto.let {
            Todo().convertTodoDto(it)
        }.let {
            todoRepositorImpl.save(it)
        }?.let {
            TodoDto().convertTodo(it)
        }
    }

    fun read(index:Int):Todo?{
        return todoRepositorImpl.findOne(index)
    }
    fun readAll():MutableList<Todo>{
        return todoRepositorImpl.findAll()
    }

    fun update(todoDto: TodoDto): Todo?{
        return todoDto.let {
            Todo().convertTodoDto(it)
        }.let {
            todoRepositorImpl.save(it)
        }
    }

    fun delete(index:Int): Boolean {
        return todoRepositorImpl.delete(index)
    }
}