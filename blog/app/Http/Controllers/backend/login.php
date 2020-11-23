<?php

namespace App\Http\Controllers\backend;
use App\Http\Requests\loginrequest;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class login extends Controller
{
    function getLogin(){
        return \view('backend.login.login');

    }

    function postLogin(loginrequest $r){
    $email=$r->email;
    $pass=$r->password;
    if(Auth::attempt(['email' => $email, 'password' => $pass])){
        return redirect('admin');
    }
    else{
        return redirect()->back();
    } 
    }
}
