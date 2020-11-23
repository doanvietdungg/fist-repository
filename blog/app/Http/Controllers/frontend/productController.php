<?php

namespace App\Http\Controllers\frontend;
use App\model\{product,category,brand};
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class productController extends Controller
{
     function getproduct(){
         return view('frontend.product.shop');
     }


     function product_detail($id , $prd_brand){
         $data['prd']=product::find($id);
         $data['cate']=category::all();
         $data['brand']=brand::all();
         $data['prd_brand']=product::orderby('id','desc')->where('brand_id',$prd_brand)->paginate(3);
        return view('frontend.product.product-details',$data);
    }
}
