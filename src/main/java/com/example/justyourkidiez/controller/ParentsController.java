package com.example.justyourkidiez.controller;

import com.example.justyourkidiez.business.UseCases.Parent.CreateParentUseCase;
import com.example.justyourkidiez.business.UseCases.Parent.*;
import com.example.justyourkidiez.configuration.security.isauthenticated.IsAuthenticated;
import com.example.justyourkidiez.domain.Parent.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = {"http://localhost:3000"})
@RequiredArgsConstructor
public class ParentsController {
    private final GetParentUseCase getParentUseCase;
    private final GetParentsUseCase getParentsUseCase;
    private final CreateParentUseCase createParentUseCase;
    private final DeleteParentUseCase deleteParentUseCase;
    private final UpdateParentUseCase updateParentUseCase;

    @GetMapping("{id}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_PARENT"})
    public ResponseEntity<Parent> getParent(@PathVariable(value = "id") final long id) {
        final Optional<Parent> parentOptional = getParentUseCase.getParent(id);
        if (parentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(parentOptional.get());
    }

    @GetMapping
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<GetAllParentsResponse> getAllParents() {
        return ResponseEntity.ok(getParentsUseCase.getParents());

    }

    @DeleteMapping("{parentId}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<Void> deleteParent(@PathVariable int parentId) {
        deleteParentUseCase.deleteParent(parentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<CreateParentResponse> createParent(@RequestBody @Valid CreateParentRequest request) {
        CreateParentResponse response = createParentUseCase.createParent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    @PutMapping("{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable("id") long id, @RequestBody @Valid UpdateParentRequest request) {
        request.setId(id);
        updateParentUseCase.updateParent(request);
        return ResponseEntity.noContent().build();
    }
}
