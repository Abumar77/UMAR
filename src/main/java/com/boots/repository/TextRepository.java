package com.boots.repository;

import com.boots.entity.TextMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository  extends JpaRepository<TextMaterials, Integer> {
}
