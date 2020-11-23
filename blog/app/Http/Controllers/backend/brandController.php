<?php

namespace App\Http\Controllers\backend;
use App\model\brand;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use DB;
class brandController extends Controller
{
    function getbrand(){
      $data['brand']=brand::orderby('id','desc')->paginate(5);
      return \view('backend.brand.brand',$data);
    }

    function getAddbrand(){
        return \view('backend.brand.add_brand');
    }
    function postAddbrand(request $r){
        $brand=new brand;
        $brand->name=$r->name;
        $brand->mota=$r->des;
        $brand->status=$r->status;
        $brand->save();
        return redirect('/admin/brand');
    }
    function geteditbrand($id){
      $data['brand']=brand::find($id);
      return view('backend.brand.edit_brand',$data);
    }

    function postEditbrand(request $r,$id){
$brand=brand::find($id);
$brand->name=$r->name;
$brand->mota=$r->des;
$brand->status=$r->status;
$brand->save();
return redirect('/admin/brand');
    }

    function delete($id){
        $brand=brand::find($id);
        $brand->delete();
        return redirect('/admin/brand');
    }

    function show($id,request $r){
        DB::table('brand')->where('id',$id)->update(['status'=>0]);
        return  redirect('/admin/brand')->with('thongbao','hien thi');
    }

    function hidde($id,request $r){
        DB::table('brand')->where('id',$id)->update(['status'=>1]);
        return  redirect('/admin/brand')->with('thongbao','hien thi');
    }
}
