package br.com.clyvo.petguardian.controller;


import br.com.clyvo.petguardian.dto.request.ResponsibleRequest;
import br.com.clyvo.petguardian.dto.response.ResponsibleResponse;
import br.com.clyvo.petguardian.service.ResponsibleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("responsibles")
@RequiredArgsConstructor
@Tag(name = "Responsibles", description = "Gerenciamento dos responsáveis pelos pets")
public class ResponsibleController {

    private final ResponsibleService service;

    @PostMapping
    public ResponseEntity<ResponsibleResponse> create(@RequestBody @Valid ResponsibleRequest request) {
        ResponsibleResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponsibleResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsibleResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsibleResponse> update(@PathVariable Long id, @RequestBody @Valid ResponsibleRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
