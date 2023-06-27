package com.sparta.posting.repository;




import java.util.List;
import com.sparta.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findAllByOrderByCreatedAtDesc();
    List<Posting> findAllById(Long id);
}
