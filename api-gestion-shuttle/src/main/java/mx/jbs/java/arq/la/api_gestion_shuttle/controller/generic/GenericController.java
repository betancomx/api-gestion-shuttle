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
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(e -> {
            errores.put(e.getField(), e.getCode());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    protected ResponseEntity<?> query(List<?> list){
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    protected ResponseEntity<?> save(Long id){
        if(Objects.isNull(id)){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(Map.of("Message:","Registro Creado","ID:",id),HttpStatus.CREATED);
    }
}

