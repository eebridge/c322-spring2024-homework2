package com.example.demo.controllers;

import com.example.demo.model.Guitar;
import com.example.demo.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class InventoryController {

    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(value = "serialNumber", required = false) String serialNumber,
                               @RequestParam(value = "price", required = false) String price,
                               @RequestParam(value = "builder", required = false) String builder,
                               @RequestParam(value = "model", required = false) String model,
                               @RequestParam(value = "type", required = false) String type,
                               @RequestParam(value = "backWood", required = false) String backWood,
                               @RequestParam(value = "topWood", required = false) String topWood){
        try{
            Guitar guitar = new Guitar();
            guitar.setSerialNumber(serialNumber);
            guitar.setPrice(Float.parseFloat(price));
            guitar.setBuilder(builder);
            guitar.setModel(model);
            guitar.setType(type);
            guitar.setBackWood(backWood);
            guitar.setTopWood(topWood);
            return inventoryRepository.search(guitar);
        } catch (IOException e){
            return null;
        }
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Guitar guitar){
        try {
            return inventoryRepository.addGuitar(guitar);
        } catch (IOException e) {
            return false;
        }
    }

    @GetMapping("/find")
    public Guitar find(@RequestParam String serialNumber){
        try {
            return inventoryRepository.getGuitar(serialNumber);
        } catch (IOException e) {
            return null;
        }
    }

    @GetMapping
    public List<Guitar> findAll() {
        try {
            return inventoryRepository.findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
