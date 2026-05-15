package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.ClinicalHistoryRequest;
import br.com.clyvo.petguardian.dto.response.ClinicalHistoryResponse;
import br.com.clyvo.petguardian.service.ClinicalHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinical-histories")
@RequiredArgsConstructor
public class ClinicalHistoryController {

    private final ClinicalHistoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicalHistoryResponse create(@RequestBody @Valid ClinicalHistoryRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<ClinicalHistoryResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ClinicalHistoryResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/pet/{petId}")
    public List<ClinicalHistoryResponse> getByPet(@PathVariable Long petId) {
        return service.findByPet(petId);
    }

    @PutMapping("/{id}")
    public ClinicalHistoryResponse update(@PathVariable Long id, @RequestBody @Valid ClinicalHistoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}