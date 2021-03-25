
package com.crawler.service;

import com.crawler.model.Search;
import com.crawler.repository.SearchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImp implements SearchService {
	
	@Autowired
	SearchRepository sr;

	@Override
	public void save(Search search) {
		sr.save(search);
	}

	@Override
	public boolean isExist(String resultTitle) {
		List<Search> allResults = sr.findAll();
		for (Search s: allResults) {
			if (s.getTitle().equals(resultTitle)) {
				return true;
			}
		}
		return false;
	}

//	@Override
//	public List<Search> getAllResults() {
//		return sr.findAll();
//	}

    @Override
    public List<Search> findAll() {
        
        return sr.findAll();
    }

}
