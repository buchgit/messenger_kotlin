package com.example.messenger_kotlin.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
class Message (
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    var sender:User? = null,
    @ManyToOne(optional = false)
    @JoinColumn(name = "recipient_id", referencedColumnName = "user_id")
    var recipient:User? = null,
    @ManyToOne(optional = false)
    @JoinColumn(name = "conversation_id", referencedColumnName = "id")
    var conversation:Conversation? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0,
    @DateTimeFormat
    var createAt:Date = Date.from(Instant.now())
)