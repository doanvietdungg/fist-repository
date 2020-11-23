<?php

namespace App\Http\Controllers\backend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\model\category;
use App\model\product;
use App\model\brand;
use Illuminate\Support\Str;
use App\Http\Requests\{addprd,editprd};
use DB;
class productController extends Controller
{
    function getproduct(){
       
        $data['prd']=product::orderby('id','desc')->paginate(10);
        return view('backend.product.product',$data);
    }

    function add_product(){
        $cate['cate']=category::all();
        $brand['brand']=brand::all();
        return \view('backend.product.add_product',$cate,$brand);
    }

    function post_product(addprd $r){
$prd=new product;
$prd->product_code=$r->code;
$prd->name=$r->name;
$prd->price=$r->price;
$prd->featured=$r->feature;
$prd->state=$r->state;
$prd->describe=$r->des;
$prd->status=$r->status;
$prd->category_id=$r->category_id;
$prd->brand_id=$r->brand_id;
if ($r->hasFile('img'))
{
    $file = $r->img;
    $filename = Str::slug($r->name,'-').'.'.$file->getClientOriginalExtension();
    $file->move('backend/images',$filename);
   
    $prd->img= $filename;
}
else
{
   $prd->img = 'no-img.jpg';
}

$prd->save();
return redirect('/admin/product');

    }

    function show($id,request $r){
        DB::table('product')->where('id',$id)->update(['status'=>0]);
        return  redirect('/admin/product')->with('thongbao','hien thi');
    }

    function hidde($id,request $r){
        DB::table('product')->where('id',$id)->update(['status'=>1]);
        return  redirect('/admin/product')->with('thongbao','hien thi');
    }

    function delete($id){
        $brand=product::find($id);
        $brand->delete();
        return redirect('/admin/product');
    }
    
    function edit_product($id){
$data['prd']=product::find($id);
$data['cate']=category::all();
$data['brand']=brand::all();

return view('/backend/product/edit_product',$data);

    }

    function postedit_product(editprd $r, $id){
        $prd=product::find($id);
        $prd->product_code=$r->code;      
$prd->name=$r->name;
$prd->price=$r->price;
$prd->featured=$r->feature;
$prd->state=$r->state;
$prd->describe=$r->des;
$prd->status=$r->status;
$prd->category_id=$r->category_id;
$prd->brand_id=$r->brand_id;
if ($r->hasFile('img'))
{
    if ($prd->img!='no-img.jpg')
    {
        unlink('backend/images/'.$prd->img);
    }
    $file = $r->img;
    $filename = Str::slug($r->name,'-').'.'.$file->getClientOriginalExtension();
    $file->move('backend/images',$filename);
    
    $prd->img= $filename;
}
     $prd->save();
return redirect('/admin/product');
    
}
}
