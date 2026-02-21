package mx.jbs.java.arq.la.api_gestion_shuttle.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import mx.jbs.java.arq.la.api_gestion_shuttle.controller.generic.GenericController;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.service.UnidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unidad")
@RequiredArgsConstructor
public class UnidadController extends GenericController {

    private final UnidadService unidadService;

    @GetMapping
    public ResponseEntity<List<?>> findAll(){
        return super.query(unidadService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UnidadRequestDto unidadRequestDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return super.badRequest(bindingResult);
        }
        Long id = unidadService.save(unidadRequestDto);
        return super.save(id);
    }
}