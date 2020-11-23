@extends('backend.master.master')
@section('content')
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
      Category Product
    </div>
    <div class="row w3-res-tb">
      <div class="col-sm-5 m-b-xs">
        <select class="input-sm form-control w-sm inline v-middle">
          <option value="0">Bulk action</option>
          <option value="1">Delete selected</option>
          <option value="2">Bulk edit</option>
          <option value="3">Export</option>
        </select>
        <button class="btn btn-sm btn-default">Apply</button>                
      </div>
      <div class="col-sm-4">
      </div>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="input-sm form-control" placeholder="Search">
          <span class="input-group-btn">
            <button class="btn btn-sm btn-default" type="button">Go!</button>
          </span>
        </div>
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

          @foreach ($cate as $row)
              
       
          <tr>
            <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
            <td>{{ $row->name}}</td>
            <td><span class="text-ellipsis"></span>{{$row->mota}}</td>
            <td><s  pan class="text-ellipsis"><?php  
              if($row->status==0){
              ?>
    <a href="/admin/category/hidde/{{ $row->id }}"><span class="fa fa-thumbs-up"> </span></a>
  <?php 
              }
              else {
?>
<a href="/admin/category/show/{{ $row->id }}"><span class="fa fa-thumbs-down"> </span></a>
<?php 
  } 
  ?>

  
           
            
            </span></td>
            <td><span class="text-ellipsis">{{ $row->created_at }}</span></td>
            <td>
              <a href="/admin/category/edit_category/{{ $row->id }}" class="active" ui-toggle-class=""><i class="fa fa-pencil-square-o text-success text-active"></i>
             
              </a>
              <a href="/admin/category/delete/{{ $row->id }} class="active" ui-toggle-class="">   <i class="fa fa-times text-danger text"></i>   </a>
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
            {{ $cate->links() }}
          </ul>
        </div>
      </div>
    </footer>
  </div>
</div>
@endsection

