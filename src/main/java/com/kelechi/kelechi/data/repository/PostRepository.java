package com.kelechi.kelechi.data.repository;

import com.kelechi.kelechi.data.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


}
