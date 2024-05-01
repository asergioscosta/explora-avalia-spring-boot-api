package com.exploraavalia.controller;

import com.exploraavalia.model.entity.Viajante;
import com.exploraavalia.service.ViajanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/viajante")

public class ViajanteController {
    private final ViajanteService viajanteService;

    public ViajanteController(ViajanteService viajanteService) {
        this.viajanteService = viajanteService;
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(viajanteService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(viajanteService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Viajante viajante){
        try {
            return ResponseEntity.ok(viajanteService.save(viajante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity edit(@RequestBody Viajante viajante){
        try {
            return ResponseEntity.ok(viajanteService.save(viajante));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(viajanteService.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity getTotal(){
        return ResponseEntity.ok(viajanteService.count());
    }
}

