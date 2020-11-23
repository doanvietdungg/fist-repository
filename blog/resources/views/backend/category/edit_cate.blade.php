@extends('backend.master.master')
@section('content')
<section id="main-content">
	<section class="wrapper">
	<div class="form-w3layouts">
        <!-- page start-->
        <!-- page start-->
        <div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Edit_category
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form" method="post" action="/admin/category/edit_category/{{ $cate->id }}">
                                    @csrf
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name Category</label>
                                    <input value="{{ $cate->name }}" name="name" class="form-control" id="exampleInputEmail1" placeholder="Name_category">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Describe category</label>
                                    <textarea name="des"  style="resize:none " cols="30" rows="10" class="form-control" id="exampleInputPassword1" placeholder="Describe category">{{ $cate->mota }}</textarea>  
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">Show</label>
                                   <select name="status" id="" class="form-control input-sm m-bot15">
                                       <option @if($cate->status==0) selected @endif  value="0">Show</option>
                                       <option @if($cate->status==1) selected @endif  value="1">Hidde</option>
                                   </select>
                                 
                                </div>
                               
                                <button type="submit" class="btn btn-info">Submit</button>
                            </form>
                            </div>

                        </div>
                    </section>

            </div>
           
        </div>
       
        
        </div>
</section>   
@endsection
