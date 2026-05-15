package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.VeterinarianRequest;
import br.com.clyvo.petguardian.dto.response.VeterinarianResponse;
import br.com.clyvo.petguardian.service.VeterinarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("veterinarians")
@RequiredArgsConstructor
public class VeterinarianController {

    private final VeterinarianService service;

    @PostMapping
    public VeterinarianResponse create(@RequestBody @Valid VeterinarianRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<VeterinarianResponse> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public VeterinarianResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public VeterinarianResponse update(@PathVariable Long id, @RequestBody @Valid VeterinarianRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}