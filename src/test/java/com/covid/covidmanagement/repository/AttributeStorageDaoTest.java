package com.covid.covidmanagement.repository;

import com.covid.covidmanagement.exception.StorageAttributeException;
import com.covid.covidmanagement.model.StorageAttributeDto;
import com.covid.covidmanagement.model.StorageDto;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AttributeStorageDaoTest {

    AttributeStorageRepository attributeStorageRepository = new AttributeStorageRepository();

@BeforeEach
public  void setUp() throws StorageAttributeException {
    StorageDto storageDto = new StorageDto();
    storageDto.setKey("delhi");
     List<StorageAttributeDto> lstStorageAttr = new ArrayList<>();
    StorageAttributeDto str1storage1 = new StorageAttributeDto();
       str1storage1.setKey("population_level");
       str1storage1.setValue("high");
    lstStorageAttr.add(str1storage1);
     storageDto.setAttributeDtoList(lstStorageAttr);
     System.out.println(storageDto);
    attributeStorageRepository.insertStorageAttributes(storageDto);

    StorageDto storageDto1 = new StorageDto();
    storageDto1.setKey("Valsad");
    List<StorageAttributeDto> lstStorageAttr1 = new ArrayList<>();
    StorageAttributeDto str1storage2 = new StorageAttributeDto();
    str1storage2.setKey("population_level");
    str1storage2.setValue("high");
    lstStorageAttr1.add(str1storage2);
    storageDto1.setAttributeDtoList(lstStorageAttr1);
    System.out.println(storageDto1);
    attributeStorageRepository.insertStorageAttributes(storageDto);
}

    @Test
  public  void  testSecondarySearch() {
      System.out.println("secondarySearch");
        StorageAttributeDto strSecondarySearch = new StorageAttributeDto();
        strSecondarySearch.setKey("population_level");
        strSecondarySearch.setValue("high");
       Set<String> stringSet =  attributeStorageRepository.secondaryIndexSearchscan(strSecondarySearch);
        System.out.println(stringSet);
       // assertEquals();
  }

}
