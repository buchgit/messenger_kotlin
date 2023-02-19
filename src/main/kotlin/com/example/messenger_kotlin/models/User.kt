package com.example.messenger_kotlin.models

import com.example.messenger_kotlin.listeners.UserListener
import jakarta.validation.constraints.Size
import org.intellij.lang.annotations.Pattern
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "'user'")
@EntityListeners(UserListener::class)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @DateTimeFormat
    var createAt: Date = Date.from(Instant.now()),
    @Column(unique = true)
    @Size(min = 2)
    var username: String = "",
    @Size(min = 11)
    @Pattern(value = "")
    var phoneNumber: String = "",
    @Size(min = 60, max = 60)
    var password: String = "",
    var status: String = "",
    @Pattern(value = "")
    var accountStatus: String = "activated"

){
    @OneToMany(mappedBy = "sender", targetEntity = Message::class)
    private var sentMessages:Collection<Message>? = null
    @OneToMany(mappedBy = "recipient", targetEntity = Message::class)
    private var recipientMessages:Collection<Message>? = null
}