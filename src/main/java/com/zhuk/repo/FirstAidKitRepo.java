package com.zhuk.repo;

import com.zhuk.domain.FirstAidKit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstAidKitRepo extends JpaRepository<FirstAidKit, Long> {
}
