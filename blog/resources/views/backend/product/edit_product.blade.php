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
                            Add_Product
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form"  enctype="multipart/form-data" method="post" >
                                    @csrf
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name product</label>
                                    <input name="name" class="form-control" id="exampleInputEmail1" placeholder="Name_category" value="{{ $prd->name }}">
                                    {{ showErrors($errors,'name') }}
                                </div>
                                
                                    <div class="form-group">
                                        <label>Ảnh sản phẩm</label>
                                     {{-- //   {{ showErrors($errors,'product_img') }} --}}
                                        <input id="img" type="file" name="img" class="form-control hidden"
                                            onchange="changeImg(this)">
                                            {{ showErrors($errors,'img') }}
                                        <img id="avatar" class="thumbnail" width="450px" height="350px" src="images/{{ $prd->img }}">
                                    
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Code product</label>
                                    <input name="code" class="form-control" id="exampleInputEmail1" placeholder="code_category" value="{{ $prd->product_code }}">
                                    {{ showErrors($errors,'code') }}
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Price product</label>
                                    <input name="price" class="form-control" id="exampleInputEmail1" placeholder="price_category" value="{{ $prd->price }}">
                                    {{ showErrors($errors,'price') }}
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputFile">feature</label>
                                   <select name="feature" id="" class="form-control input-sm m-bot15">
                                       <option @if ($prd->featured==0)
                                           selected
                                       @endif value="0">Yes</option>
                                       <option @if ($prd->featured==1 )
                                        selected
                                    @endif  value="1">No</option>
                                   </select>
                                 
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputFile">State</label>
                                   <select name="state" id="" class="form-control input-sm m-bot15">
                                       <option @if ($prd->state==0)
                                           selected
                                       @endif value="0">Con hang</option>
                                       <option @if ($prd->state==1)
                                           selected
                                       @endif value="1">Het hang</option>
                                   </select>
                                 
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Describe</label>
                                    <textarea name="des" style="resize:none " cols="30" rows="10" class="form-control" id="exampleInputPassword1" placeholder="Describe category">{{ $prd->describe }}</textarea>  
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputFile">Show</label>
                                   <select name="status" id="" class="form-control input-sm m-bot15">
                                       <option @if ($prd->status ==0)
                                           selected
                                       @endif value="0">Show</option>
                                       <option @if ($prd->status==1)
                                           selected
                                       @endif value="1">Hidde</option>
                                   </select>
                                 
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">category</label>
                                   <select name="category_id" id="" class="form-control input-sm m-bot15">
                                       @foreach ($cate as $row)
                                       <option @if ($prd->category_id==$row->id)
                                           selected
                                       @endif value="{{ $row->id }}">{{ $row->name }}</option>
                                       @endforeach
                                   
                                      
                                   </select>
                                 
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">brand</label>
                                   <select name="brand_id" id="" class="form-control input-sm m-bot15">
                                       @foreach ($brand as $row)
                                       <option @if ($prd->brand_id==$row->id)
                                           selected
                                       @endif value="{{ $row->id }}">{{ $row->name }}</option>
                                       @endforeach
                                       
                                      
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
@section('script')
    @parent
    <script>

    function changeImg(input) {
        //Nếu như tồn thuộc tính file, đồng nghĩa người dùng đã chọn file mới
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            //Sự kiện file đã được load vào website
            reader.onload = function (e) {
                //Thay đổi đường dẫn ảnh
                $('#avatar').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $(document).ready(function () {
        $('#avatar').click(function () {
            $('#img').click();
        });

        {{-- $('#add_product').click(function(event){
               event.preventDefault();
            $.ajax({
                   url:"{{ 'admin/product/add' }}",
                   method:"POST",
                   data:new FormData(this),
                   contentType:false,
                   cache:false;
                   processData:false,
                   dataType:"json",

            })

        }); --}}



    });

</script>
@endsection
