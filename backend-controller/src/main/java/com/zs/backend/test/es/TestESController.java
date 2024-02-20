package com.zs.backend.test.es;

import com.zs.backend.Result;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestESController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private RestHighLevelClient client;

    @GetMapping("/news")
    public Object news(){
        return "111";
    }

    @GetMapping("/aaa")
    public Object aaa(){
        xxzc();
        return "111";
    }


    // 区间查询
    public void xxzc()  {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price");
        rangeQueryBuilder.gte(1);
        rangeQueryBuilder.lte(90000);
        boolQueryBuilder.must(rangeQueryBuilder);
        Iterable<Product> list = productDao.search(boolQueryBuilder);
        for(Product s:list){
            System.out.println(s);
        }

    }

    @GetMapping("/news/save")
    public Object saves(){
        saveAll();
        return "111";
    }



    @RequestMapping("/findAll")
    public Result test3() {
        findAll();
        return Result.result("test,ok");
    }


    /**
     * 新增
     */
    public void save(){
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        Product save = productDao.save(product);
        System.out.println("save: " + save);
    }
    //修改
    public void update(){
        Product product = new Product();
        product.setId(1L);
        product.setTitle("小米 2 手机");
        product.setCategory("手机");
        product.setPrice(9999.0);
        product.setImages("http://www.atguigu/xm.jpg");
        Product save = productDao.save(product);
        System.out.println("update: " + save);
    }
    //根据 id 查询
    public void findById(){
        Product product = productDao.findById(1L).get();
        System.out.println(product);
    }

    //查询所有
    public void findAll(){
        Iterable<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    //删除
    public void delete(){
        Product product = new Product();
        product.setId(1L);
        productDao.delete(product);
    }


    //批量新增
    public void saveAll(){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setTitle("["+i+"]小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0+i);
            product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    //分页查询
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage=0;//当前页，第一页从 0 开始，1 表示第二页
        int pageSize = 5;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product Product : productPage.getContent()) {
            System.out.println(Product);
        }
    }

}
