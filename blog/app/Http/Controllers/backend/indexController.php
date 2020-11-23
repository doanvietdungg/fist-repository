<?php

namespace App\Http\Controllers\backend;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class indexController extends Controller
{
   function getindex(){
       return \view('backend.index');
   }
   function logout(){
       Auth::logout();
       return redirect('login');
   }
}
