package com.zhuk.repo;

import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandageRepo extends JpaRepository<Bandage, Long> {

    List<Bandage> findAllByMaterial(Material material);
}
