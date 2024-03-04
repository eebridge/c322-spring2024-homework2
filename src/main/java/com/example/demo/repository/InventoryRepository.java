package com.example.demo.repository;

import com.example.demo.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryRepository {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String DATABASE_NAME = "guitars_database.txt";

    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public boolean addGuitar(Guitar guitar) throws IOException{
        Path path = Paths.get(DATABASE_NAME);
        String data = guitar.getSerialNumber() + "," +
                guitar.getPrice() + "," +
                guitar.getBuilder() + "," +
                guitar.getModel() + "," +
                guitar.getType() + "," +
                guitar.getBackWood() + "," +
                guitar.getTopWood();
        appendToFile(path, data + NEW_LINE);
        return true;
    }

    public Guitar getGuitar(String s) throws IOException {
        Guitar guitar = new Guitar();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            String[] words = line.split(",");
            System.out.println(words[0]);
            if(words[0].equals(s)){
                guitar.setSerialNumber(words[0]);
                guitar.setPrice(Float.parseFloat(words[1]));
                guitar.setBuilder(words[2]);
                guitar.setModel(words[3]);
                guitar.setType(words[4]);
                guitar.setBackWood(words[5]);
                guitar.setTopWood(words[6]);
                break;
            }
        }
        return guitar;
    }

    public List<Guitar> search(Guitar g) throws IOException {
        Guitar guitar = new Guitar();
        List<Guitar> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            String[] words = line.split(",");
            if(words[0].equals(g.getSerialNumber()) ||
                    Float.parseFloat(words[1]) == g.getPrice() ||
                    words[2].equals(g.getBuilder()) ||
                    words[3].equals(g.getModel()) ||
                    words[4].equals(g.getType()) ||
                    words[5].equals(g.getBackWood()) ||
                    words[6].equals(g.getTopWood())){
                guitar.setSerialNumber(words[0]);
                guitar.setPrice(Float.parseFloat(words[1]));
                guitar.setBuilder(words[2]);
                guitar.setModel(words[3]);
                guitar.setType(words[4]);
                guitar.setBackWood(words[5]);
                guitar.setTopWood(words[6]);
                result.add(guitar);
            }
        }
        return result;
    }

    public List<Guitar> findAll() throws IOException {
        Guitar guitar = new Guitar();
        List<Guitar> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            String[] words = line.split(",");
            guitar.setSerialNumber(words[0]);
            guitar.setPrice(Float.parseFloat(words[1]));
            guitar.setBuilder(words[2]);
            guitar.setModel(words[3]);
            guitar.setType(words[4]);
            guitar.setBackWood(words[5]);
            guitar.setTopWood(words[6]);
            result.add(guitar);
        }
        return result;
    }
}
