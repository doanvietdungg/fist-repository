<?php

namespace App\Http\Controllers\frontend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class blogController extends Controller
{
    function getBlog(){
        return view('frontend.blog.blog');
    }

    function blogsingle(){
return view('frontend.blog.blog-single');
    }
}
