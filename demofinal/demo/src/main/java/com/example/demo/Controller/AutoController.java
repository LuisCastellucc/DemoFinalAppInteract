package com.example.demo.Controller;

import com.example.demo.Model.Auto;
import com.example.demo.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Auto")
public class AutoController {

    @Autowired
    private AutoService as;

    @GetMapping("")
    public List<Auto> getAll(){
        return as.getAll();
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody Auto a){return as.add(a);}


    @PostMapping("/{id}/update")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Auto a){return as.update(id,a);}

    @PostMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Integer id){return as.delete(id);}

    @PostMapping("/{id}/usar")
    public ResponseEntity usar(@PathVariable Integer id, @RequestBody Auto a){return as.usar(id,a);}

    @PostMapping("/{id}/cargarNafta")
    public ResponseEntity cargarNafta(@PathVariable Integer id, @RequestBody Auto a){return as.cargarNafta(id,a);}

}
