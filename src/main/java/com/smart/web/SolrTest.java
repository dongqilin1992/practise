package com.smart.web;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/17 14:30
 */
public class SolrTest {
    public static void main(String[] args) throws IOException, SolrServerException {

        /*String urlString = "http://192.168.175.128:8080/solr";
        SolrServer solr = new HttpSolrServer(urlString);
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id","1");
        document.setField("user_name", "test");
        solr.add(document);
        solr.commit();*/

        search();
    }
    public static void search() throws SolrServerException {
        String urlString = "http://192.168.175.128:8080/solr";
        SolrServer solrServer = new HttpSolrServer(urlString);
        //创建查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery("user_name:test");
        //设置分页
        query.setStart(0);
        query.setRows(1);
        //设置默认搜素域
        query.set("df", "item_keywords");
        //根据查询条件查询索引库
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        List<String> list = new ArrayList<String>();
        for (SolrDocument solrDocument : solrDocumentList) {
            list.add((String) solrDocument.get("id"));
            list.add((String) solrDocument.get("user_name"));

        }
        System.out.println("结果是："+list);
    }
}
