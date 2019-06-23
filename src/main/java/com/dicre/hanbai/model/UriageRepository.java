package com.dicre.hanbai.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UriageRepository extends JpaRepository <Uriage, Integer> {
	List<Uriage> findBySid(int sid);
}
