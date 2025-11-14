package com.data.connection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpReposotory extends JpaRepository<EmpEntity,Long> {

}
