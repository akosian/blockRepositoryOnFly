package com.test.test.config

import com.test.test.import.service.ImportService
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import javax.persistence.EntityManagerFactory

@Component
class TransactionManagerProvider(private val importService: ImportService) {

    fun transactionManager(entityManagerFactory: EntityManagerFactory) =
        if (importService.existsStartedImport()) {
            ReadOnlyTransactionManager(entityManagerFactory)
        } else {
            JpaTransactionManager(entityManagerFactory)
        }
}
