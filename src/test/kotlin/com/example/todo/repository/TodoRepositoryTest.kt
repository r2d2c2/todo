package com.example.todo.repository

import com.example.todo.config.AppConfig
import com.example.todo.database.Todo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)//확장 긴능 사용
@SpringBootTest(classes = [TodoRepositorImpl::class,AppConfig::class])//클래스 파일만 테스트()사용 안하면 모든것을 불러온다
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepositorImpl: TodoRepositorImpl

    @BeforeEach//확장 기능 각 메소드 테스트를 실행 할때 마다 실행
    fun before(){
        todoRepositorImpl.todoDataBase.init()//초기화
    }

    @Test//매소드만 test가능
    fun saveTest(){
        val todo=Todo().apply {
            this.title="테스트 일정"
            this.description="테스트"
            this.schedule= LocalDateTime.now()

        }
        val result=todoRepositorImpl.save(todo)

        Assertions.assertEquals(1,result?.index)//(기대 하는 값 ,들어오는 값
        Assertions.assertNotNull(result?.createaAt)
        Assertions.assertNotNull(result?.updatedAt)
        Assertions.assertEquals("테스트 일정",result?.title)
        Assertions.assertEquals("테스트",result?.description)
    }

    @Test
    fun saveAllTest(){
        val todoList= mutableListOf(
            Todo().apply {
                this.title="테스트 일정"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            },
            Todo().apply {
                this.title="테스트 일정"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            },
            Todo().apply {
                this.title="테스트 일정"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            }
        )
        val result=todoRepositorImpl.saveAll(todoList)
        Assertions.assertEquals(true,result)
    }
    @Test
    fun findOneTest(){

        val todoList= mutableListOf(
            Todo().apply {
                this.title="테스트 일정1"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            },
            Todo().apply {
                this.title="테스트 일정2"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            },
            Todo().apply {
                this.title="테스트 일정3"
                this.description="테스트"
                this.schedule= LocalDateTime.now()
            }
        )
        todoRepositorImpl.saveAll(todoList)
        val result=todoRepositorImpl.findOne(2)

        Assertions.assertNotNull(result)
        println(result)
        Assertions.assertEquals("테스트 일정2",result?.title)
    }
    @Test
    fun updateTest(){
        val todo=Todo().apply {
            this.title="테스트 일정"
            this.description="테스트"
            this.schedule= LocalDateTime.now()

        }
        val inserTodo=todoRepositorImpl.save(todo)


        val newTodo=Todo().apply {
            this.index=inserTodo?.index
            this.title="업데이트 일정"
            this.description="업데이트 테스트"
            this.schedule= LocalDateTime.now()

        }

        val result=todoRepositorImpl.save(newTodo)

        Assertions.assertNotNull(result)
        Assertions.assertEquals(inserTodo?.index,result?.index)
        Assertions.assertEquals("업데이트 일정",result?.title)
        Assertions.assertEquals("업데이트 테스트",result?.description)
    }

}