
package com.crawler.controller;

import com.crawler.model.Search;
import com.crawler.service.KeywordService;
import com.crawler.service.SearchService;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class SearchController {

    @Autowired
    SearchService ss;
    
    @Autowired
    KeywordService ks;
    

    

    @GetMapping("/")
    public String viewResult(Model model) throws IOException {

        
        String url = "https://se.jooble.org/SearchResult?rgns=Stockholm&ukw=praktik";

        Document doc = Jsoup.connect(url).get();

        Elements links = doc.getElementsByClass("_085f3");

        for (Element link : links) {

            String title = link.text();

            if (!ss.isExist(title)) {

                Search search = new Search();
                search.setTitle(title);
                ss.save(search);
                
            }
        }

        List<Search> resultRubrik = ss.findAll();
        
        model.addAttribute("resultRubrik", resultRubrik);
       
        return "/newhtml";
    }

    
}
