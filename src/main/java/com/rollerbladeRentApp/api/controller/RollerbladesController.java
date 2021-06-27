package com.rollerbladeRentApp.api.controller;

import com.rollerbladeRentApp.api.model.NewRollerblades;
import com.rollerbladeRentApp.api.model.Rollerblades;
import com.rollerbladeRentApp.api.model.UpdateRollerblades;
import com.rollerbladeRentApp.service.RollerbladesService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rollerblades")
@AllArgsConstructor
public class RollerbladesController {

    private final RollerbladesService rollerbladesService;

    @PostMapping
    public ResponseEntity createRollerblades(@RequestBody NewRollerblades newRollerblades, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(
                    bindingResult.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.toList()));
        } else {
            rollerbladesService.createRollerblades(newRollerblades);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRollerblades(@RequestBody UpdateRollerblades updateRollerblades) {
        rollerbladesService.updateRollerblades(updateRollerblades);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRollerblades(@PathVariable Long id) {
        rollerbladesService.deleteRollerblades(id);
    }

    @GetMapping("/{id}")
    public Rollerblades getById(@PathVariable Long id) {
        return rollerbladesService.getById(id);
    }

    @GetMapping
    public List<Rollerblades> getAll() {
        return rollerbladesService.getAll();
    }
}
