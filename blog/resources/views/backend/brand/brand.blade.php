@extends('backend.master.master')
@section('content')
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
      Category Brand
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
            <th>Name Category</th>
            <th>mota</th>
            <th>Show</th>
            <th>Date</th>
            <th style="width:30px;">edit/delete</th>
          </tr>
        </thead>
        <tbody>

          @foreach ($brand as $row)
              
       
          <tr>
            <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
            <td>{{ $row->name}}</td>
            <td><span class="text-ellipsis"></span>{{$row->mota}}</td>
            <td><s  pan class="text-ellipsis"><?php  
              if($row->status==0){
              ?>
    <a href="/admin/brand/hidde/{{ $row->id }}"><span class="fa fa-thumbs-up"> </span></a>
  <?php 
              }
              else {
?>
<a href="/admin/brand/show/{{ $row->id }}"><span class="fa fa-thumbs-down"> </span></a>
<?php 
  } 
  ?>

  
           
            
            </span></td>
            <td><span class="text-ellipsis">{{ $row->created_at }}</span></td>
            <td>
              <a href="/admin/brand/edit_brand/{{ $row->id }}" class="active" ui-toggle-class=""><i class="fa fa-pencil-square-o text-success text-active"></i>
             
              </a>
              <a href="/admin/brand/delete/{{ $row->id }} class="active" ui-toggle-class="">   <i class="fa fa-times text-danger text"></i>   </a>
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
            {{ $brand->links() }}
          </ul>
        </div>
      </div>
    </footer>
  </div>
</div>
@endsection

secio