package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;



public class ArrayProducer {

    private final String[] dictionary;


    
    public ArrayProducer(String filePath) {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);

        try (GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(file));
            var br = new BufferedReader(new InputStreamReader(gzip));) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        dictionary = stringList.toArray(String[]::new);
        
    }

    public String[] getDictionary() {
        return dictionary;
    }
}