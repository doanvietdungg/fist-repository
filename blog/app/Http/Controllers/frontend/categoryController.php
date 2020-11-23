<?php

namespace App\Http\Controllers\frontend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\model\{product,category,brand};
class categoryController extends Controller
{
    function cate_prd($id){
        $data['cate']=category::all();
        $data['brand']=brand::all();
        $data['prd']=product::orderby('id','desc')->where('category_id',$id)->paginate(6);
        return view('frontend.index',$data);
    }
}
