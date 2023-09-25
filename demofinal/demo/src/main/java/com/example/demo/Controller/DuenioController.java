package com.example.demo.Controller;

import com.example.demo.Model.Duenio;
import com.example.demo.Service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController()
@RequestMapping("/Duenio")
public class DuenioController {

        @Autowired
        private DuenioService ds;

        @GetMapping("")
        public List<Duenio> getAll(){
            return ds.getAll();
        }

        @PostMapping("")
        public ResponseEntity add(@RequestBody Duenio d){return ds.add(d);}


        @PostMapping("/{id}/update")
        public ResponseEntity update(@PathVariable Integer id, @RequestBody Duenio d){return ds.update(id,d);}

        @PostMapping("/{id}/delete")
        public ResponseEntity delete(@PathVariable Integer id){return ds.delete(id);}






    }


