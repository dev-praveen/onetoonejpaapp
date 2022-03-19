package com.praveen.associations.dao;

import com.praveen.associations.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<BranchEntity, Integer> {}
