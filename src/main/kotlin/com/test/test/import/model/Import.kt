package com.test.test.import.model

import java.io.Serializable
import javax.persistence.*

@Table(name = "IMPORTS", schema = "private")
@Entity
@SequenceGenerator(
    name = "sequence", sequenceName = "seq_imports", schema = "private",  allocationSize = 1
)
class Import(private val name: String) : Serializable {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    private var id = 0L

    @Enumerated(EnumType.STRING)
    var status: ImportStatus = ImportStatus.STARTED
}
