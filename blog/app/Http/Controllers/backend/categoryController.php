<?php

namespace App\Http\Controllers\backend;
use App\model\category;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use DB;
class categoryController extends Controller
{
  


   function getCate(){
       $data['cate']=category::orderby('id','ASC')->paginate(10);
    return \view('backend.category.category',$data);
   }

   function add_Cate(){
    return \view('backend.category.add_category');
}

   function post_category(request $r){
$data=new category;
$data->name=$r->name;
$data->mota=$r->des;
$data->status=$r->status;
$data->save();
return redirect('/admin/category');


   }

   function edit_category(request $r,$id){
       $data['cate']=category::find($id);
       return \view('backend.category.edit_cate',$data);
   }
   function postedit_category(request $r, $id)
   {
    $cate=category::find($id);
    $cate->name=$r->name;
    $cate->mota=$r->des;
    $cate->status=$r->status;
    $cate->save();
    return redirect('/admin/category');
   }

   function delete($id){
$data=category::find($id);
$data->delete();
return redirect()->back();
   }

   function show($id){
    DB::table('category')->where('id',$id)->update(['status'=>0]);
   return  redirect('/admin/category')->with('thongbao','hien thi');
   }

   function hidde($id){
   DB::table('category')->where('id',$id)->update(['status'=>1]);
   return  redirect('/admin/category')->with('thongbao',' di');
       }
}
