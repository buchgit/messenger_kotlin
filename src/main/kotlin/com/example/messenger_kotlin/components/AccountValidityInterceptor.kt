package com.example.messenger_kotlin.components

import UserDeactivatedException
import com.example.messenger_kotlin.models.User
import com.example.messenger_kotlin.repositories.UserRepository
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import java.security.Principal
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws


@Component
class AccountValidityInterceptor(val userRepository: UserRepository):HandlerInterceptorAdapter() {

    @Throws(UserDeactivatedException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        return super.preHandle(request, response, handler)

        val principal:Principal? = request.userPrincipal

        if (principal!=null){
            val user = userRepository.findByUsername(principal.name) as User
            if (user.accountStatus == "deactivated"){
                throw UserDeactivatedException("The account has been deactivated");
            }
        }
        return super.preHandle(request, response, handler)

    }

}