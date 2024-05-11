package com.exploraavalia.controller;

import com.exploraavalia.model.entity.Dicas;
import com.exploraavalia.service.DicasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dicas")
public class DicasController {
    private final DicasService dicasService;
    public DicasController(DicasService dicasService) {
        this.dicasService = dicasService;
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(dicasService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(dicasService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Dicas dicas){
        try {
            return ResponseEntity.ok(dicasService.save(dicas));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity edit(@RequestBody Dicas dicas){
        try {
            return ResponseEntity.ok(dicasService.save(dicas));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(dicasService.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity getTotal(){
        return ResponseEntity.ok(dicasService.count());
    }
}