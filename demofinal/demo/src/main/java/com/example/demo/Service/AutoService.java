package com.example.demo.Service;

import com.example.demo.Model.Auto;
import com.example.demo.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class AutoService {

    @Autowired
    private AutoRepository ar;

    public AutoService(AutoRepository ar){this.ar = ar;}

    public List<Auto> getAll(){
        return ar.findAll();
    }

    public ResponseEntity add(Auto a){
        try {
            ar.save(a);
            return ResponseEntity.status(CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity update(Integer id, Auto a){
        try {
            Auto au = ar.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST,"Auto no encontrado"));
            au.setMarca(a.getMarca());
            au.setAnio(a.getAnio());
            au.setKilometros(a.getKilometros());
            au.setDuenio(a.getDuenio());
            au.setNafta(a.getNafta());
            ar.save(au);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity delete(Integer id){
        try {
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity usar(Integer id, Auto a){
        try {
            Auto au = ar.findById(id).get();
            au.setNafta(a.getNafta() - 10);
            au.setKilometros(a.getKilometros() + 10);
            ar.save(au);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity cargarNafta(Integer id, Auto a){
        try {
            Auto au = ar.findById(id).get();
            au.setNafta(100);
            ar.save(au);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    

}
