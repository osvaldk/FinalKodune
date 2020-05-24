package com.company;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static ArrayList<Shelf> shelf;

    public Warehouse() {
        shelf = new ArrayList<>();
    }

    public void receive(Product product, String shelfName) {
        shelf.add(new Shelf(shelfName, product));
    }

    public String dispatch(Product product) {
        for (Shelf s : shelf) {
            if (s.getProduct().equals(product)) {
                shelf.remove(s);
                return s.getShelfName();
            }
        }
        return null;
    }

    public Integer getItemCount(Product product) {
        int count = 0;
        for (Shelf s : shelf) {
            if (s.getProduct().equals(product)) {
                count++;
            }
        }
        return count;
    }

    public void writeData(String path) {
        File file = new File(path);

        try {

            FileWriter targetFile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(targetFile);

            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Shelf", "Product"});
            for (Shelf s : shelf) {
                data.add(new String[]{s.getShelfName(), s.getProduct().toString()});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
