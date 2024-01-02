package issueservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class WebConfig(
  private val authUserHandlerArgumentResolver: AuthUserHandlerArgumentResolver,
): WebMvcConfigurationSupport() {
  
  override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
    argumentResolvers.apply { add(authUserHandlerArgumentResolver) }
  }
}

@Component
class AuthUserHandlerArgumentResolver: HandlerMethodArgumentResolver {
  
  override fun supportsParameter(
    parameter: org.springframework.core.MethodParameter
  ): Boolean {
    return AuthUser::class.java.isAssignableFrom(parameter.parameterType)
  }
  
  override fun resolveArgument(
    parameter: org.springframework.core.MethodParameter,
    mavContainer: ModelAndViewContainer?,
    webRequest: NativeWebRequest,
    binderFactory: WebDataBinderFactory?
  ): Any? {
    return AuthUser(1, "chris")
  }
}

data class AuthUser(
  val userId: Long,
  val username: String,
 )
