@extends('backend.master.master')
@section('content')
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
       ALL_product
    </div>
    <div class="row w3-res-tb">
   
      <div class="col-sm-4">
      </div>
      <div class="col-sm-3">
      
      </div>
    </div>
    <div class="table-responsive">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th style="width:20px;">
              <label class="i-checks m-b-none">
              
              </label>
            </th>
            <th>id</th>
            <th>code</th>
            <th>name</th>
            <th>price</th>
            <th>featured</th>
            <th>state</th>
            <th>Mota</th>
            <th>img</th>
            <th>Danh muc san pham</th>
            <th>brand san pham</th>
            <th>Date</th>
            <th>status</th>
            <th style="width:30px;">edit/delete</th>
          </tr>
        </thead>
        <tbody>

          @foreach ($prd as $row)
              
       
          <tr>
            <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
            <td>{{ $row->id}}</td>
            <td>{{ $row->product_code}}</td>
            <td>{{ $row->name}}</td>
            <td>{{ $row->price}}</td>
            <td>@if ($row->featured==1)
                <a class="btn btn-success"  role="button">YES</a>

                @else 
                    <a  class="btn btn-danger" role="button">NO</a>
                
            @endif
        </td>

        <td>@if ($row->state==1)
            <a class="btn btn-success"  role="button">CON hang</a>

            @else 
                <a  class="btn btn-danger" role="button">Het hang</a>
            
        @endif</td>
    
            <td><span class="text-ellipsis"></span>{{$row->describe}}</td>
            <td><img src="images/{{ $row->img }}" alt="Áo đẹp" width="100px" class="thumbnail"></td>
            <td>{{ $row->category->name }}</td>
            <td>{{ $row->brand->name }}</td>
         
            <td><span class="text-ellipsis">{{ $row->created_at }}</span></td>
            <td><span class="text-ellipsis"><?php  
              if($row->status==0){
              ?>
    <a href="/admin/product/hidde/{{ $row->id }}"><span class="fa fa-thumbs-up"> </span></a>
  <?php 
              }
              else {
?>
<a href="/admin/product/show/{{ $row->id }}"><span class="fa fa-thumbs-down"> </span></a>
<?php 
  } 
  ?>

  
           
            
            </span></td>
         
            <td>
              <a href="/admin/product/edit_prd/{{ $row->id }}" class="active" ui-toggle-class=""><i class="fa fa-pencil-square-o text-success text-active"></i>
             
              </a>
              <a href="/admin/product/delete/{{ $row->id }} class="active" ui-toggle-class="">   <i class="fa fa-times text-danger text"></i>   </a>
            </td>
          </tr>
         
          @endforeach
        </tbody>
      </table>
    </div>
    <footer class="panel-footer">
      <div class="row">
     
        <div class="col-sm-7 text-right text-center-xs">                
          {{--  <ul class="pagination pagination-sm m-t-none m-b-none">
            <li><a href=""><i class="fa fa-chevron-left"></i></a></li>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
            <li><a href="">4</a></li>
            <li><a href=""><i class="fa fa-chevron-right"></i></a></li>  --}}
            {{ $prd->links() }}
          </ul>
        </div>
      </div>
    </footer>
  </div>
</div>
@endsection

