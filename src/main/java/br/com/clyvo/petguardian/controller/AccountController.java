package br.com.clyvo.petguardian.controller;


import br.com.clyvo.petguardian.request.AccountRequest;
import br.com.clyvo.petguardian.response.AccountResponse;
import br.com.clyvo.petguardian.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public AccountResponse create(@RequestBody @Valid AccountRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<AccountResponse> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public AccountResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public AccountResponse update(@PathVariable Long id, @RequestBody @Valid AccountRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}