package com.test.test.config

import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.TransactionStatus
import javax.persistence.EntityManagerFactory

@Component(value = "transactionManager")
class FlexTransactionPlatform(
    private val transactionManagerProvider: TransactionManagerProvider,
    private var entityManagerFactory: EntityManagerFactory
) : PlatformTransactionManager {

    private lateinit var manager: JpaTransactionManager

    override fun getTransaction(p0: TransactionDefinition?): TransactionStatus {
        manager =  transactionManagerProvider.transactionManager(entityManagerFactory)
        return manager.getTransaction(p0)
    }

    override fun commit(p0: TransactionStatus) {
        manager.commit(p0)
    }

    override fun rollback(p0: TransactionStatus) {
        manager.rollback(p0)
    }
}
