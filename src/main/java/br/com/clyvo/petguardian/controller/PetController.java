package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.PetRequest;
import br.com.clyvo.petguardian.dto.response.PetResponse;
import br.com.clyvo.petguardian.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @PostMapping
    public PetResponse create(@RequestBody @Valid PetRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<PetResponse> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public PetResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
}