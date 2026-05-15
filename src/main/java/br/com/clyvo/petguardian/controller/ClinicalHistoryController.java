package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.ClinicalHistoryRequest;
import br.com.clyvo.petguardian.dto.response.ClinicalHistoryResponse;
import br.com.clyvo.petguardian.service.ClinicalHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("clinical-histories")
@RequiredArgsConstructor
public class ClinicalHistoryController {

    private final ClinicalHistoryService service;

    @PostMapping
    public ClinicalHistoryResponse create(@RequestBody @Valid ClinicalHistoryRequest request) {
        return service.create(request);
    }

    @GetMapping("/pet/{petId}")
    public List<ClinicalHistoryResponse> getByPet(@PathVariable Long petId) {
        return service.findByPet(petId);
    }
}