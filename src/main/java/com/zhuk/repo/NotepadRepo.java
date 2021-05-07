package com.zhuk.repo;

import com.zhuk.domain.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotepadRepo extends JpaRepository<Notepad, Long> {
    List<Notepad> findAllByPageNumber(Integer pageNumber);
}
