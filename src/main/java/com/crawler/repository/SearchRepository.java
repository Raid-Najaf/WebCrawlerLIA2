
package com.crawler.repository;

import com.crawler.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long>{

}

