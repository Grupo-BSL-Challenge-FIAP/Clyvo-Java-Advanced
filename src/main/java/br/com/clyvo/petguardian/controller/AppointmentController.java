package br.com.clyvo.petguardian.controller;

import br.com.clyvo.petguardian.dto.request.AppointmentRequest;
import br.com.clyvo.petguardian.dto.response.AppointmentResponse;
import br.com.clyvo.petguardian.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse create(@RequestBody @Valid AppointmentRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public AppointmentResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<AppointmentResponse> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/{id}")
    public AppointmentResponse update(@PathVariable Long id, @RequestBody @Valid AppointmentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}