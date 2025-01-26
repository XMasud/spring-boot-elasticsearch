package com.example.elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.elasticsearch.util.ProductSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class SearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Map> matchAllServices() throws IOException {

        Supplier<Query> supplier = ProductSearchUtil.supplier();
        System.out.println("Elastic search query: "+supplier.get().toString());
        return elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);
    }
}
