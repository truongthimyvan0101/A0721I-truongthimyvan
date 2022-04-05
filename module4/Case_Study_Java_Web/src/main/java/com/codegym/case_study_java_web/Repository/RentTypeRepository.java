package com.codegym.case_study_java_web.Repository;


import com.codegym.case_study_java_web.model.RentType;
import com.codegym.case_study_java_web.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
