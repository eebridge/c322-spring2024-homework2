package com.example.demo.repository;

import com.example.demo.model.Guitar;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar1() throws IOException {
        Guitar guitar = new Guitar();
        InventoryRepository inventoryRepository = new InventoryRepository();
        guitar.setSerialNumber("32145");
        guitar.setPrice(Float.parseFloat("1234"));
        guitar.setBuilder("gibson");
        guitar.setModel("model1");
        guitar.setType("electric");
        guitar.setBackWood("maple");
        guitar.setTopWood("cedar");
        assertTrue(inventoryRepository.addGuitar(guitar));
    }

    @Test
    void addGuitar2() throws IOException {
        Guitar guitar = new Guitar();
        InventoryRepository inventoryRepository = new InventoryRepository();
        guitar.setSerialNumber(null);
        guitar.setPrice(Float.parseFloat("4321"));
        guitar.setBuilder("gibson");
        guitar.setModel(null);
        guitar.setType("acoustic");
        guitar.setBackWood("maple");
        guitar.setTopWood("cedar");
        assertTrue(inventoryRepository.addGuitar(guitar));
    }

    @Test
    void getGuitar() throws IOException {
        Guitar guitar = new Guitar();
        guitar.setSerialNumber("12345");
        guitar.setPrice(Float.parseFloat("123.99"));
        guitar.setBuilder("prs");
        guitar.setModel("model1");
        guitar.setType("acoustic");
        guitar.setBackWood("alder");
        guitar.setTopWood("cedar");
        InventoryRepository inventoryRepository = new InventoryRepository();
        Guitar expected = inventoryRepository.getGuitar("12345");
        assertTrue(guitar.getSerialNumber().equals(expected.getSerialNumber()) &&
                guitar.getPrice() == expected.getPrice() &&
                guitar.getBuilder().equals(expected.getBuilder()) &&
                guitar.getModel().equals(expected.getModel()) &&
                guitar.getType().equals(expected.getType()) &&
                guitar.getBackWood().equals(expected.getBackWood()) &&
                guitar.getTopWood().equals(expected.getTopWood()));
    }

    @Test
    void search() throws IOException {
        Guitar guitar = new Guitar();
        guitar.setSerialNumber("12345");
        guitar.setPrice(Float.parseFloat("123.99"));
        guitar.setBuilder("prs");
        guitar.setModel("model1");
        guitar.setType("electric");
        guitar.setBackWood("alder");
        guitar.setTopWood("cedar");
        Guitar search = new Guitar();
        search.setBuilder("prs");
        search.setBackWood("alder");
        InventoryRepository inventoryRepository = new InventoryRepository();
        List<Guitar> expected = inventoryRepository.search(search);
        assertTrue(expected.size() == 1);

    }
}