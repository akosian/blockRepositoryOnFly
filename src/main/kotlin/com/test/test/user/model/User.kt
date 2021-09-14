package com.test.test.user.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue

@Table(name = "USERS", schema = "private")
@Entity
@SequenceGenerator(
    name = "sequence", sequenceName = "seq_user",
    allocationSize = 1, schema = "private"
)
class User : Serializable {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    private var id = 0L

    lateinit var username: String

    lateinit var password: String

    lateinit var email: String
}
