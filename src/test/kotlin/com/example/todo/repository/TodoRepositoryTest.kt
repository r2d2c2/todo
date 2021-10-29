package com.example.todo.repository

import com.example.todo.config.AppConfig
import com.example.todo.database.Todo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest(classes = [TodoRepositorImpl::class,AppConfig::class])//클래스 파일만 테스트()사용 안하면 모든것을 불러온다
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepositorImpl: TodoRepositorImpl

    @Test
    fun saveTest(){
        val todo=Todo().apply {
            this.title="테스트 일정정"
            this.description="테스트"
            this.schedule= LocalDateTime.now()

        }
        val result=todoRepositorImpl.save(todo)

        Assertions.assertEquals(1,result.index)//(기대 하는 값 ,들어오는 값

    }

}