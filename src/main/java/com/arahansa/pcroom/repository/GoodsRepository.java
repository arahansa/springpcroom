package com.arahansa.pcroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arahansa.pcroom.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long>{
	
}
