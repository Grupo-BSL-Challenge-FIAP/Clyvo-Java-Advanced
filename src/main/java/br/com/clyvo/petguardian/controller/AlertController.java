package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.AlertRequest;
import br.com.clyvo.petguardian.dto.response.AlertResponse;
import br.com.clyvo.petguardian.service.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertResponse create(@RequestBody @Valid AlertRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<AlertResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AlertResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/pet/{petId}")
    public List<AlertResponse> getByPet(@PathVariable Long petId) {
        return service.findByPet(petId);
    }

    @PutMapping("/{id}")
    public AlertResponse update(@PathVariable Long id, @RequestBody @Valid AlertRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}