package com.test.test.import.service

import com.test.test.import.model.Import
import com.test.test.import.model.ImportStatus
import com.test.test.import.repository.ImportRepository
import org.springframework.stereotype.Service

@Service
class ImportService(private val repository: ImportRepository) {

    fun finalizeImport(id: Long) {
        repository.getById(id)
            .let {
                it.status = ImportStatus.FINISHED
                repository.save(it)
            }
    }

    fun startImport(name: String) = repository.save(Import(name))

    fun existsStartedImport() = repository.existsImportByStatus(ImportStatus.STARTED)
}
