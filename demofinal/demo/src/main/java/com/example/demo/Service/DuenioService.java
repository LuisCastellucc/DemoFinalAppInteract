package com.example.demo.Service;

import com.example.demo.Model.Duenio;
import com.example.demo.Repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository dr;

    public DuenioService(DuenioRepository dr){
        this.dr = dr;
    }

    public List<Duenio> getAll(){
        return dr.findAll();
    }

    public ResponseEntity add(Duenio d){
        try {
            dr.save(d);
            return ResponseEntity.status(CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity update(Integer id, Duenio d){
        try {
            Duenio du = dr.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST,"Dueño no encontrado"));
            du.setNombre(d.getNombre());
            du.setApellido(d.getApellido());
            du.setEdad(d.getEdad());
            dr.save(du);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity delete(Integer id){
        try {
            dr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }



}
