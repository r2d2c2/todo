package com.example.todo.handler

import com.example.todo.Controller.api.todo.TodoApiController
import com.example.todo.model.http.Error
import com.example.todo.model.http.ErrorRespons
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackageClasses = [TodoApiController::class])
//TodoApiController에만 아래 작업을 실행
class TodoApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
     fun methodA(e: MethodArgumentNotValidException,result: HttpServletRequest): ResponseEntity<ErrorRespons> {
        val errors= mutableListOf<Error>()

         e.bindingResult.allErrors.forEach {errorObject ->

             val error=Error().apply {
                 this.field=(errorObject as FieldError).field
                 this.message=errorObject.defaultMessage
                 this.value=errorObject.rejectedValue
             }
             errors.add(error)
         }//forEach end

        val errorResponse=ErrorRespons().apply {
            this.resultCode="FAIL"
            this.httpStatus=HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod=result.requestURI
            this.message=""
            this.timestamp= LocalDateTime.now()
            this.error=errors
        }
        return ResponseEntity.badRequest().body(errorResponse)

     }

}