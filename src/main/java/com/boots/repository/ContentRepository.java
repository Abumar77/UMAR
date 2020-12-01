package com.boots.repository;

import com.boots.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository  extends JpaRepository<Content, Integer> {
}