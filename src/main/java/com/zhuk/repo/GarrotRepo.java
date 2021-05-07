package com.zhuk.repo;

import com.zhuk.domain.Garrot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarrotRepo extends JpaRepository<Garrot, Long> {
}
