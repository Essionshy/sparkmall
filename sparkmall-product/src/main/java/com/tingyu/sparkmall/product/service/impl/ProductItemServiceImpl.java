package com.tingyu.sparkmall.product.service.impl;

import com.tingyu.sparkmall.product.entity.ProductEntity;
import com.tingyu.sparkmall.product.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author essionshy
 * @Create 2020/6/7 18:04
 * @Version renren-fast
 */
public class ProductItemServiceImpl implements ProductItemService {

    @Qualifier("mainThreadPoolExecutor")
    @Autowired
    ThreadPoolExecutor mainThreadPoolExecutor;

    @Override
    public boolean save(ProductEntity productEntity) {

        /*1、保存商品*/


        return false;
    }

    @Override
    public List<ProductEntity> get()  {
        /*1、保存商品基本信息*/
//        CompletableFuture<ProductEntity> productEntityCompletableFuture=CompletableFuture.supplyAsync((id)->{
//            ProductEntity productEntity = new ProductEntity();
//
//            return productEntity;
//        }).whenComplete((r,e)->{
//            System.out.println("r:"+r);
//            System.out.println("e:"+e);
//        });
        CompletableFuture<Void> f1=CompletableFuture.runAsync(()->{
            System.out.println("this");
        },mainThreadPoolExecutor);


        CompletableFuture<ProductEntity> f2=CompletableFuture.supplyAsync(()->{
            return new ProductEntity();
        },mainThreadPoolExecutor).whenComplete((r,e)->{
            System.out.println("r:"+r);
            System.out.println("e:"+e);

        });


        /*2、保存商品属性信息*/
        /*3、保存商品优惠信息表*/
        /*4、保存商品信息表*/
        /*5、保存商品基本信息表*/

        /*当所有线程都运行结束后，才往下执行，同步阻塞*/
        try {
            CompletableFuture.allOf(f1,f2).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
