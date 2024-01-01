package issueservice.exception

import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
  
  private val logger = KotlinLogging.logger {}
  
  @ExceptionHandler(ServerException::class)
  fun handleServerException(e: ServerException): ErrorResponse {
    logger.error(e.message)
    return ErrorResponse(e.code, e.message)
  }
}
