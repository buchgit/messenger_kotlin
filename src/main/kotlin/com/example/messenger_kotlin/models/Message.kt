package com.example.messenger_kotlin.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
class Message(
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var sender: User? = null,
    @ManyToOne(optional = false)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    var recipient: User? = null,
    var body: String? = "",
    @ManyToOne(optional = false)
    @JoinColumn(name="conversation_id", referencedColumnName = "id")
    var conversation: Conversation? = null,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
    @DateTimeFormat
    var createdAt: Date = Date.from(Instant.now())
)