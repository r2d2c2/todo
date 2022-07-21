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

    fun read(index:Int):TodoDto?{
        return todoRepositorImpl.findOne(index)?.let {
            TodoDto().convertTodo(it)
        }
    }
    fun readAll():MutableList<TodoDto>{
        return todoRepositorImpl.findAll().map {
            TodoDto().convertTodo(it)
        }.toMutableList()
    }

    fun update(todoDto: TodoDto): TodoDto?{
        return todoDto.let {
            Todo().convertTodoDto(it)
        }.let {
            todoRepositorImpl.save(it)
        }?.let {
            TodoDto().convertTodo(it)
        }
    }

    fun delete(index:Int): Boolean {
        return todoRepositorImpl.delete(index)
    }
}