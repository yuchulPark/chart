package com.example.demo.controller;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.MaskVO;
import com.google.gson.Gson;

@RestController
public class CoupangController {
	@RequestMapping(value="/mask.do", produces="application/json;charset=UTF-8")
	public String listMask() {
		ArrayList<MaskVO> maskList = new ArrayList<MaskVO>();
		String str = "";
		try {
			for(int i = 1; ;i++) {
				Document doc = Jsoup.connect("https://www.coupang.com/np/search?q=마스크&channel=user&component=&eventCategory=SRP&trcid=&traid=&sorter=scoreDesc&minPrice=&maxPrice=&priceRange=&filterType=&listSize=36&filter=&isPriceRange=false&brand=&offerCondition=&rating=0&page="+i+"&rocketAll=false&searchIndexingToken=1=4&backgroundColor=").get();
				if(doc == null) {
					break;
				}
				Elements list = doc.select(".search-product a");
				for(Element a : list) {
					if(!a.select(".rating").text().equals("")) {
						Double rating = Double.parseDouble(a.select(".rating").text());
						String arrival = a.select(".arrival-info em").first().text();
					
						if(rating >= 4 && (arrival.startsWith("내일") || arrival.startsWith("모래"))) {
							System.out.println(arrival);
							String url = a.attr("href");
							String name = a.select(".name").text();
							String price = a.select(".price-value").text();
							maskList.add(new MaskVO(name, url, price));
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		str = gson.toJson(maskList);
		return str;
	}
}
