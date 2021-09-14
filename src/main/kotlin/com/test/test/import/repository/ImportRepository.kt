package com.test.test.import.repository

import com.test.test.import.model.Import
import com.test.test.import.model.ImportStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImportRepository : JpaRepository<Import, Long> {

    fun existsImportByStatus(status: ImportStatus): Boolean
}
