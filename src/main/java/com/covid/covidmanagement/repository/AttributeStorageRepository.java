package com.covid.covidmanagement.repository;

import com.covid.covidmanagement.exception.StorageAttributeException;
import com.covid.covidmanagement.model.StorageAttributeDto;
import com.covid.covidmanagement.model.StorageDto;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class AttributeStorageRepository {

//take concurrentHashMap for attributes
private static ConcurrentHashMap<String , ConcurrentHashMap<String, StorageAttributeDto>> storageAttribute = new ConcurrentHashMap<>();


public  void removeAttributeStorageKey(String key) throws StorageAttributeException {
	if(storageAttribute.contains(key))
	     storageAttribute.remove(key);
	else
		throw  new StorageAttributeException("Storage Key Does not exist");
}


public Set<String> secondaryIndexSearchscan(StorageAttributeDto strDto ){
	HashSet<String> strSet = new HashSet<>();
	     for(Map.Entry<String, ConcurrentHashMap<String, StorageAttributeDto>> mp: storageAttribute.entrySet()){
	     	ConcurrentHashMap<String ,StorageAttributeDto> attrMap = mp.getValue();
	     	String returningKey = mp.getKey();
			 for(Map.Entry<String,StorageAttributeDto> attrMapEntry : attrMap.entrySet())	 {
				 StorageAttributeDto storageAttributeDto =	 attrMapEntry.getValue();
			 	if(storageAttributeDto.getKey().equalsIgnoreCase(strDto.getKey())
				 &&  storageAttributeDto.getValue().equals(strDto.getValue()) )
					strSet.add(returningKey);
			 }
	     }
	return  strSet;
}

	public  void insertStorageAttributes(StorageDto storageDto) throws StorageAttributeException {

		if (storageAttribute.contains(storageDto.getKey())) {
			// update
			updateStorageAttributes(storageDto);
			} else
				addStorageAttributes(storageDto);
	}

	// updateStorageAttributes

	private  void updateStorageAttributes(StorageDto storageDto) throws StorageAttributeException {

		ConcurrentHashMap<String, StorageAttributeDto> attributeMap =
				storageAttribute.get(storageDto.getKey());
		for(StorageAttributeDto strAttrDto: storageDto.getAttributeDtoList()) {
		     if(attributeMap.contains(strAttrDto.getKey())) {
				StorageAttributeDto storageAttributeDto =  attributeMap.get(strAttrDto.getKey());
			 	String newDataType = getDataTypeFromObjectValue(strAttrDto.getValue());
				  if(storageAttributeDto.getDataType().equalsIgnoreCase(newDataType)) {
					  storageAttributeDto.setValue(strAttrDto.getValue());
					  attributeMap.put(strAttrDto.getKey(),storageAttributeDto);
				  }
				  else
				  	throw  new StorageAttributeException("Data type Mismatch : Earlier/Current");
		     }
		     else{
				 strAttrDto.setDataType(getDataTypeFromObjectValue(strAttrDto.getValue()));
				 attributeMap.put(strAttrDto.getKey(),strAttrDto);
			 }
		}
		//storageAttribute.put(storageKey,attributeMap );
	}

 // addStorageAttributes
	private  void addStorageAttributes(StorageDto storageDto) throws StorageAttributeException {

	System.out.println("INside addStorageAttributes");
		String storageKey = storageDto.getKey();
		ConcurrentHashMap<String, StorageAttributeDto> attributeMap = new ConcurrentHashMap<>();
		for(StorageAttributeDto strAttrDto: storageDto.getAttributeDtoList()) {
			strAttrDto.setDataType(	getDataTypeFromObjectValue(strAttrDto.getValue()));
			attributeMap.put(strAttrDto.getKey(),strAttrDto);
		}
		storageAttribute.put(storageKey,attributeMap );
		System.out.println("INside addStorageAttributes storageAttribute"+storageAttribute.toString() );
	}

     private  String getDataTypeFromObjectValue(Object value) throws StorageAttributeException{

		String dataType = "";
		 if(value instanceof  String) {
			 dataType ="string";
		 } else if(value instanceof  Double)
			 dataType ="double";
		 else if(value instanceof  Boolean)
			 dataType ="boolean";
		 else if(value instanceof  Integer)
			 dataType = "integer";
		 else
			 throw  new StorageAttributeException("Invalid data type while inserting");
            return  dataType;
	 }



}
