<?php

namespace App\Http\Controllers\frontend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\model\{product,category,brand};
class indexController extends Controller
{
    function getindex(){
        $data['cate']=category::all();
        $data['brand']=brand::all();
       $data['prd']=product::orderby('id','desc')->where('featured',0)->paginate(6);
      //$data['prd']=product::orderby('id','desc')->where('category_id',$id)->paginate(6);
        return view('frontend.index',$data);
    }

    function cate_prd($id){
        $data['cate']=category::all();
        $data['brand']=brand::all();
        $data['prd']=product::orderby('id','desc')->where('category_id',$id)->paginate(6);
       //$data['prd']=product::orderby('id','desc')->where('featured',0)->paginate(6);

        return view('frontend.product_cate.product_cate',$data);
    }
    function getContact(){
        return view('frontend.contact-us');
    }
    function Login(){
        return view('frontend.login.login');
    }

    function notfound(){
        return view('frontend.404');
    }

    function brand_prd($id){
        $data['cate']=category::all();
        $data['brand']=brand::all();
        $data['prd']=product::orderby('id','desc')->where('brand_id',$id)->paginate(6);
       //$data['prd']=product::orderby('id','desc')->where('featured',0)->paginate(6);

        return view('frontend.index',$data);
    }

    
}
