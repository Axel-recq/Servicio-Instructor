package com.example.demo.RestController;


import com.example.demo.Modelo.Instructor;
import com.example.demo.Servicio.ServicioInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerInstructor {

    @Autowired
    private ServicioInstructor servicioInstructor;


    @PostMapping("/create")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = servicioInstructor.createInstructor(instructor);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);  // Código 201 Created
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = servicioInstructor.obtenerInstructires();
        return new ResponseEntity<>(instructors, HttpStatus.OK);  // Código 200 OK
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean deleted = servicioInstructor.deleteInstructor(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Código 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Código 404 Not Found
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Integer id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = servicioInstructor.ActualizarInstructor(id, instructor);
        if (updatedInstructor != null) {
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);  // Código 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Código 404 Not Found
        }
    }
}
