package com.example.justyourkidiez.controller;

import com.example.justyourkidiez.business.UseCases.Coach.GetCoachUseCase;
import com.example.justyourkidiez.business.UseCases.CreateCoachUseCase;
import com.example.justyourkidiez.configuration.security.isauthenticated.IsAuthenticated;
import com.example.justyourkidiez.domain.Coach.Coach;
import com.example.justyourkidiez.domain.Coach.CreateCoachRequest;
import com.example.justyourkidiez.domain.Coach.CreateCoachResponse;
import com.example.justyourkidiez.domain.Parent.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/coaches")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class CoachesController {
    private final CreateCoachUseCase createCoachUseCase;
    private final GetCoachUseCase getCoachUseCase;

    @PostMapping()
    public ResponseEntity<CreateCoachResponse> createResponse(@RequestBody @Valid CreateCoachRequest request) {
        CreateCoachResponse response = createCoachUseCase.createCoach(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
//    @IsAuthenticated
//    @RolesAllowed({"ROLE_COACH"})
    public ResponseEntity<Coach> getCoach(@PathVariable(value = "id") final long id) {
        final Optional<Coach> coachOptional = getCoachUseCase.getCoach( id);
        if (coachOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(coachOptional.get());
    }
}
