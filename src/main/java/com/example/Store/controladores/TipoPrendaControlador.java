package com.example.Store.controladores;

import com.example.Store.modelos.TipoPrenda;
import com.example.Store.servicios.TipoPrendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/tipoprenda")

public class TipoPrendaControlador {
    @Autowired
    TipoPrendaServicio tipoPrendaServicio;


    @PostMapping
    public ResponseEntity<?> guardartipoPrenda(@RequestBody TipoPrenda datostipoPrenda){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendaServicio.guardarTipoPrenda(datostipoPrenda));
        }catch(Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }


    @GetMapping("{id}")
    public ResponseEntity<?> consultarTipoPrendaPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendaServicio.consultarTipoPrendaId(id));

        } catch (Exception error) {
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarTipoPrendas(){
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(tipoPrendaServicio.buscarTodosTipoPrenda());

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }
}
