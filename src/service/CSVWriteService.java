package service;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVWriteService {
    public static CSVWriteService instance = null;

    public static CSVWriteService getInstance(){
        if (instance == null)
            instance = new CSVWriteService();
        return instance;
    }

    private CSVWriteService() {}

    public <T> void write(Class<T> type, T data, String file) throws IOException{

        try {
            OutputStream out = new FileOutputStream(file);

            List<Field> allFields = new ArrayList<>();

            allFields.addAll(Arrays.asList(type.getDeclaredFields()));

            for (Field field : allFields)
            {
                field.setAccessible(true);
            }

            List<String> values = new ArrayList<>();
            allFields.forEach(
                    field -> {
                        Object value;
                        try {
                            value = field.get(data);
                        }
                        catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return;
                        }
                        values.add(value.toString());
                    }
            );

            String line = String.join(",", values);

            byte[] dataBytes = line.getBytes();

            out.write(dataBytes);

            out.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }


    }
}
