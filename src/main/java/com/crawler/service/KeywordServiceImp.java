/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crawler.service;

import com.crawler.model.Keyword;
import com.crawler.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImp implements KeywordService{
    
    @Autowired
    KeywordRepository krepo;

    @Override
    public void saveProduct(Keyword keyword) {
        
        krepo.save(keyword);
        
    }
    
}
