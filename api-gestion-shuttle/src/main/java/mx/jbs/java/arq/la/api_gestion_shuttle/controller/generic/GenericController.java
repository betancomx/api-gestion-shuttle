package mx.jbs.java.arq.la.api_gestion_shuttle.controller.generic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class GenericController {
    protected ResponseEntity<?> badRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    protected ResponseEntity<List<?>> query(List<?> list) {
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    protected ResponseEntity<?> save(Long id) {
        if(Objects.isNull(id)){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(Map.of("Message","Record Created","Id",id.toString()),HttpStatus.CREATED);
    }
}

