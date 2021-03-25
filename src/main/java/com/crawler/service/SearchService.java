
package com.crawler.service;

import com.crawler.model.Search;
import java.util.List;


public interface SearchService {
	
	public void save(Search search);
	public boolean isExist(String resultTitle);
//	public List<Search> getAllResults();

    public List<Search> findAll();
}

