package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
import com.furnitureapp.service.stockcontrol.ProductCategoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductCategoryServiceImplTest {

     private static ProductCategoryService categoryService = ProductCategoryServiceImpl.getCategoryService();
     private static ProductCategory category = ProductCategoryFactory.createProductCategory
             ("Beds and Mattresses");

     @Test
     public void d_list() {
         Set<ProductCategory> categories = categoryService.list();
         Assert.assertEquals(1, categories.size());
         System.out.println(" Category details: " + categories);
     }

     @Test
     public void a_create() {
         ProductCategory created = categoryService.create(category);
         Assert.assertEquals(category.getCategoryCode(), created.getCategoryCode());
         System.out.println("Created: " + created);
     }

     @Test
     public void b_read() {
         ProductCategory read = categoryService.read(category.getCategoryCode());
         Assert.assertEquals(category.getCategoryCode(), read.getCategoryCode());
         System.out.println("Read: " + read);
     }

     @Test
     public void c_update() {
         ProductCategory updated = new ProductCategory.ProductCategoryBuilder().copy(category).setCategoryName("Tables").build();
         updated = categoryService.update(updated);
         Assert.assertNotEquals(updated, category);
         System.out.println("Updated: " + updated);
     }

     @Test
     public void e_delete() {
         boolean deleted = categoryService.delete(category.getCategoryCode());
         Assert.assertTrue(deleted);
         System.out.println("Category name deleted: " + deleted);

     }
 }