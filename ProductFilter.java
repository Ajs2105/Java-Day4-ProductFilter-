

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductFilter {
    public static void main(String[] args) {
        String inputFile = "products.csv";     // input file
        String outputFile = "expensive_products.csv"; // output file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split CSV line -> "Name,Price"
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);

                // Condition: price > 1000
                if (price > 1000) {
                    writer.write(name + "," + price + "\n");
                }
            }

            System.out.println("✅ Filtering complete! Check " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
