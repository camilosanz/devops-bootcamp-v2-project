package services;

import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// import models.Student;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadDataService<T> {
    public ReadDataService() {}

    public List<T> readDataFromJson(String rawPath, Class<T[]> class1) {
        List<T> students = null;
                
        try {
            Gson gson = new Gson();
            var path = (Paths.get(rawPath));
            Reader reader = Files.newBufferedReader(path);

            students = Arrays.asList(gson.fromJson(reader, class1));
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return students;
    }
}
