package com.example.elasticsearch.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;

public class ProductSearchUtil {
    public static Supplier<Query> supplier(){
        return ()->Query.of(q->q.matchAll(matchAllQuery()));
    }
    public static MatchAllQuery matchAllQuery(){
        var matchAllQuery = new MatchAllQuery.Builder();
        return matchAllQuery.build();
    }
}
