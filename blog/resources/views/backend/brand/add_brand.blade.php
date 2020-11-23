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
                            Add_Brand
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form" method="post" action="/admin/brand/add_brand">
                                    @csrf
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name brand</label>
                                    <input name="name" class="form-control" id="exampleInputEmail1" placeholder="Name_brand">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Describe brand</label>
                                    <textarea name="des" style="resize:none " cols="30" rows="10" class="form-control"  placeholder="Describe brand"></textarea>  
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
