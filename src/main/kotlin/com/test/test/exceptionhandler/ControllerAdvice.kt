package com.test.test.exceptionhandler

import com.test.test.import.service.ImportService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaSystemException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.*

@ControllerAdvice
class ControllerAdvice(private val importService: ImportService) : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handlerManager(exception: Exception, locale: Locale) =
        when (exception) {
            is JpaSystemException -> {
                if (importService.existsStartedImport()) {
                    baseHandleException("Cannot update while import")
                } else {
                    baseHandleException(exception.message.toString())
                }
            }
            else -> baseHandleException("Test")
        }

    private fun baseHandleException(message: String): ResponseEntity<Any> {
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = message
        return ResponseEntity(body, HttpHeaders(), HttpStatus.BAD_REQUEST)
    }
}
