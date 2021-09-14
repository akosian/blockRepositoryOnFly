package com.test.test.config

import org.springframework.transaction.TransactionDefinition

class ReadOnlyTransactionDefinition : TransactionDefinition {

    override fun isReadOnly() = true
}
