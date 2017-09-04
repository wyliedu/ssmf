package com.wylie.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Value("${server}")
	public String port;
	
	@Autowired  
    private HttpSolrClient client; 
	
	public String getPort(){
		return this.port;
	}
	
	public void testSolr() throws SolrServerException, IOException{
		//创建查询对象
        SolrQuery query = new SolrQuery();
        //q 查询字符串，如果查询所有*:*
        query.set("q", "userName:*s* AND nick_name:fd");
        //范围查询：         AND id:[1 TO  20]  
        //fq 过滤条件，过滤是基于查询结果中的过滤
        //query.set("fq", "product_catalog_name:幽默杂货");
        //sort 排序，请注意，如果一个字段没有被索引，那么它是无法排序的
//        query.set("sort", "product_price desc");
        //start row 分页信息，与mysql的limit的两个参数一致效果
        query.setStart(0);
        query.setRows(10);
        //fl 查询哪些结果出来，不写的话，就查询全部，所以我这里就不写了
//        query.set("fl", "");
        //df 默认搜索的域
        //query.set("df", "product_keywords");
        
        //======高亮设置===
        //开启高亮
        query.setHighlight(true);
        //高亮域
        query.addHighlightField("userName");
        //前缀
        query.setHighlightSimplePre("<span style='color:red'>");
        //后缀
        query.setHighlightSimplePost("</span>");
        
        
        //执行搜索
        QueryResponse queryResponse = client.query(query);
        //搜索结果
        SolrDocumentList results = queryResponse.getResults();
        //查询出来的数量
        long numFound = results.getNumFound();
        //queryResponse.getBeans(type)
        System.out.println("总查询出:" + numFound + "条记录");
	}
	
	public void upadteIndex() throws SolrServerException, IOException{
        SolrInputDocument doc = new SolrInputDocument();
        
        doc.addField("id", "zxj1");
        doc.addField("userName", "javaWEB技术");
        doc.addField("nick_name", "1");
        
        client.add(doc);
        client.commit();
        
        client.close();
    }
	
	public void deleteIndex()throws Exception{
        //1.删除一个
        client.deleteById("zxj1");
        
        //2.删除多个
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        client.deleteById(ids);
        
        //3.根据查询条件删除数据,这里的条件只能有一个，不能以逗号相隔
        client.deleteByQuery("id:zxj1");
        
        //4.删除全部，删除不可恢复
        //client.deleteByQuery("*:*");
        
        //一定要记得提交，否则不起作用
        client.commit();
        client.close();
    }
}
