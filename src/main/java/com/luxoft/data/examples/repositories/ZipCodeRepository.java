package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {

    ZipCode findByCodeValue(Integer codeValue);

}
