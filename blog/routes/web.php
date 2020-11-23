<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
Route::get('/','frontend\indexController@getindex');
Route::get('/{id}','frontend\indexController@cate_prd');
Route::get('/{id}','frontend\indexController@brand_prd');
Route::get('contact', 'frontend\indexController@getContact');
Route::get('login', 'frontend\indexController@Login');
Route::get('404-notfound', 'frontend\indexController@notfound');
Route::group(['prefix' => 'product'], function () {
    Route::get('/', 'frontend\productController@getproduct');
    Route::get('product_detail/{id}/{brand_id}', 'frontend\productController@product_detail');
   
});

Route::group(['prefix' => 'category'], function () {
    Route::get('/{id}', 'frontend\categoryController@cate_prd');
    
});

Route::group(['prefix' => 'cart'], function () {
    Route::get('/','frontend\cartController@getcart');
});

Route::group(['prefix' => 'blog'], function () {
    Route::get('/', 'frontend\blogController@getBlog');
    Route::get('blog-single', 'frontend\blogController@Blogsingle');

});

// Backend

Route::get('login','backend\login@getLogin')->middleware('checklogout');
Route::post('login', 'backend\login@postLogin');


Route::group(['prefix' => 'admin','middleware'=>'checklogin'], function () {
    Route::get('/', 'backend\indexController@getindex');
    Route::get('logout', 'backend\indexController@logout');

    
    Route::group(['prefix' => 'category'], function() {
        
        Route::get('/', 'backend\categoryController@getCate');
        Route::get('add_category', 'backend\categoryController@add_cate');
        Route::post('add_category', 'backend\categoryController@post_category');
        Route::get('edit_category/{id}', 'backend\categoryController@edit_category');
        Route::post('edit_category/{id}', 'backend\categoryController@postedit_category');
        Route::get('delete/{id}', 'backend\categoryController@delete');
        Route::get('show/{id}', 'backend\categoryController@show');
        Route::get('hidde/{id}', 'backend\categoryController@hidde');
    });
    Route::group(['prefix' => 'brand'], function () {
        Route::get('/', 'backend\brandController@getBrand');
        Route::get('add_brand', 'backend\brandController@getAddBrand');
        Route::post('add_brand', 'backend\brandController@postAddBrand');
        Route::get('edit_brand/{id}', 'backend\brandController@getEditBrand');
        Route::post('edit_brand/{id}', 'backend\brandController@postEditBrand');
        Route::get('delete/{id}', 'backend\brandController@delete');
        Route::get('show/{id}', 'backend\brandController@show');
        Route::get('hidde/{id}', 'backend\brandController@hidde');
    });

    Route::group(['prefix' => 'product'], function () {
        Route::get('/', 'backend\productController@getproduct');
        Route::get('add_product', 'backend\productController@add_product');
        Route::post('add_product', 'backend\productController@post_product');
        Route::get('edit_prd/{id}', 'backend\productController@edit_product');
        Route::post('edit_prd/{id}', 'backend\productController@postedit_product');
        Route::get('delete/{id}', 'backend\productController@delete');
        Route::get('show/{id}', 'backend\productController@show');
        Route::get('hidde/{id}', 'backend\productController@hidde');
       
            
      
    });
   
   
    
    Route::group(['prefix' => 'UI-elements'], function() {
        Route::get('/', 'backend\elements@');
    });
    
    
});