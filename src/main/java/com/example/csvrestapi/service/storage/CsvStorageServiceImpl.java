/**
 * CsvStorageServiceImpl.java
 * <p>
 * This file contains the implementation of the StorageService interface for CSV file storage.
 * It provides methods to read data from a CSV file and convert it into a list of PlayerBean objects.
 * <p>
 * The CsvStorageServiceImpl class uses the opencsv library to parse the CSV file.
 * It retrieves the CSV file path from the application properties file using the @Value annotation.
 * The readAllData method reads the CSV file, skips the header line, and maps the columns to the PlayerBean class.
 * It then returns a list of PlayerBean objects.
 * <p>
 * The setColumMapping method sets the column mapping strategy for the CSV parser.
 * It specifies the column names and their corresponding fields in the PlayerBean class.
 */

package com.example.csvrestapi.service.storage;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

@Service
public class CsvStorageServiceImpl implements StorageService {

    @Value("${csv.path}")
    private Path csvPath;

    /**
     * Reads all data from the CSV file and converts it into a list of PlayerBean objects.
     *
     * @return a list of PlayerBean objects
     * @throws RuntimeException if the CSV file is not found
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<PlayerBean> readAllData() {
        try {
            return new CsvToBeanBuilder(new FileReader(csvPath.toFile()))
                    .withType(PlayerBean.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}