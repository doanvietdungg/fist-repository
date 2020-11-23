<?php

namespace App\Http\Controllers\frontend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class cartController extends Controller
{
   function getcart(){
       return view('frontend.cart.cart');
   }
}
