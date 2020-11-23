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
                            Add_category
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form" method="post" action="/admin/category/add_category">
                                    @csrf
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name Category</label>
                                    <input name="name" class="form-control" id="exampleInputEmail1" placeholder="Name_category">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Describe category</label>
                                    <textarea name="des" style="resize:none " cols="30" rows="10" class="form-control" id="exampleInputPassword1" placeholder="Describe category"></textarea>  
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">Show</label>
                                   <select name="status" id="" class="form-control input-sm m-bot15">
                                       <option value="0">Show</option>
                                       <option value="1">Hidde</option>
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
