/**
 * This is a Java interface named StorageService.
 * It defines a method called readAllData() which returns a list of PlayerBean objects.
 * Implementations of this interface will provide functionality to read all data.
 */
package com.example.csvrestapi.service.storage;

import java.util.List;

public interface StorageService {

    List<PlayerBean> readAllData();

}
