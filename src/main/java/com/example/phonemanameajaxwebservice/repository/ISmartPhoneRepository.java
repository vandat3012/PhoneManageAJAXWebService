package com.example.phonemanameajaxwebservice.repository;

import com.example.phonemanameajaxwebservice.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone,Long> {
}
