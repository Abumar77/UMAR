package com.boots.repository;


import com.boots.entity.VideoMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository  extends JpaRepository<VideoMaterials, Integer> {
}