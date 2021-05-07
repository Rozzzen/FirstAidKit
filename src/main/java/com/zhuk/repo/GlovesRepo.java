package com.zhuk.repo;

import com.zhuk.domain.Gloves;
import com.zhuk.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlovesRepo extends JpaRepository<Gloves, Long> {

    List<Gloves> findAllByMaterial(Material material);
}
