package com.test.test.import.controller

import com.test.test.import.service.ImportService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/imports")
class ImportController(private val service: ImportService) {

    @GetMapping("/{id}/finalize")
    fun finalizeImport(@PathVariable id: Long) {
        service.finalizeImport(id)
    }

    @PostMapping
    fun startImport(name: String) {
        service.startImport(name)
    }
}
