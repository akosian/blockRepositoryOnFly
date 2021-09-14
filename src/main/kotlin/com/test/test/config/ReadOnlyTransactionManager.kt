package com.test.test.config

import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.TransactionDefinition
import javax.persistence.EntityManagerFactory

class ReadOnlyTransactionManager(entityManagerFactory: EntityManagerFactory): JpaTransactionManager(entityManagerFactory) {

    override fun doBegin(transaction: Any, definition: TransactionDefinition) {
        super.doBegin(transaction, ReadOnlyTransactionDefinition())
    }
}
