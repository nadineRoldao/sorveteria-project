package com.sorveteria.sorvetes.repository;

import com.sorveteria.sorvetes.model.Sorvete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SorveteRepository extends JpaRepository<Sorvete, String> {}
