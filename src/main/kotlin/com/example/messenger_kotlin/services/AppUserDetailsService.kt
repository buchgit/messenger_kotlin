package com.example.messenger_kotlin.services

import com.example.messenger_kotlin.repositories.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class AppUserDetailsService(val userRepository: UserRepository):UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)?:throw UsernameNotFoundException("A user with the username $username doesn't exist")
        return User(user.username,user.password,ArrayList<GrantedAuthority>())
    }

}
