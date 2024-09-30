package com.example.demo.Servicio;

import com.example.demo.Modelo.Instructor;
import com.example.demo.Repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioInstructor {

    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    public List<Instructor> obtenerInstructires(){
        return  instructorRepo.findAll();
    }

    public boolean deleteInstructor(Integer id) {
        if (instructorRepo.existsById(id)) {
            instructorRepo.deleteById(id);
            return true;
        }
        return false;
    }



    public Instructor ActualizarInstructor(Integer id , @RequestBody Instructor nuevosDatos) {
        //validar si existe el instructor
        if(instructorRepo.existsById(id) == true){

            Instructor instructorUpdate = new Instructor();
            instructorUpdate.setInstructorId(id);
            instructorUpdate.setNombre(nuevosDatos.getNombre());
            instructorUpdate.setApellidos(nuevosDatos.getApellidos());
            instructorUpdate.setPassword(nuevosDatos.getPassword());
            instructorUpdate.setEmail(nuevosDatos.getEmail());
            return instructorRepo.save(instructorUpdate);
        }else {
            return  null ;
        }
    }

}
