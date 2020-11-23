@extends('frontend.master.master')
@section('content')
<section>
	<div class="container">
		<div class="row">
			@include('frontend.master.category')
			<div class="col-sm-9 padding-right">
				<div class="product-details"><!--product-details-->
					<div class="col-sm-5">
						<div class="view-product">
							<img src="backend/images/{{ $prd->img }}" alt="" />
							<h3>ZOOM</h3>
						</div>
						<div id="similar-product" class="carousel slide" data-ride="carousel">
							
							  <!-- Wrapper for slides -->
								<div class="carousel-inner">
									<div class="item active">
									  <a href=""><img src="frontend/images/product-details/similar1.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar2.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar3.jpg" alt=""></a>
									</div>
									<div class="item">
									  <a href=""><img src="frontend/images/product-details/similar1.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar2.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar3.jpg" alt=""></a>
									</div>
									<div class="item">
									  <a href=""><img src="frontend/images/product-details/similar1.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar2.jpg" alt=""></a>
									  <a href=""><img src="frontend/images/product-details/similar3.jpg" alt=""></a>
									</div>
									
								</div>

							  <!-- Controls -->
							  <a class="left item-control" href="#similar-product" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right item-control" href="#similar-product" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>
						</div>

					</div>
					<div class="col-sm-7">
						<div class="product-information"><!--/product-information-->
							<img src="frontend/images/product-details/new.jpg" class="newarrival" alt="" />
							<h2>{{ $prd->name }}</h2>
							<p>Code: {{ $prd->product_code }}</p>
							<img src="frontend/images/product-details/{{ $prd->img }}" alt="" />
							
							
							<span>
								<span>US ${{ $prd->price }}</span>
								<label>Quantity:</label>
								<input  name="qty" type="number" value="1" min="1" />
								<input  name="productid_hidden" type="hidden" value="{{ $prd->id }}"  />
								<button type="submit" class="btn btn-fefault cart">
									<i class="fa fa-shopping-cart"></i>
									Add to cart
								</button>
							</span>
						
							<p><b>Danh Muc:</b> {{ $prd->category->name }}</p>
						
							<p><b>Brand:</b> {{ $prd->brand->name }}</p>
							<a href=""><img src="frontend/images/product-details/share.png" class="share img-responsive"  alt="" /></a>
						</div><!--/product-information-->
					</div>
				</div><!--/product-details-->
				
				<div class="category-tab shop-details-tab"><!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li class="active" ><a href="#details" data-toggle="tab">Details</a></li>
							<li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li>
							
							<li ><a href="#reviews" data-toggle="tab">Danh Gia(5)</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade active in " id="details" >
							<div class="col-sm-3">
								@if ($prd->describe==NULL)
								<h4 class="panel-title"><a href="#">Khong co mo ta</a></h4>

								@else {
									{{ $prd->describe }}
								}
									
								@endif
								
							</div>
						
						</div>
						
						<div class="tab-pane fade" id="companyprofile" >
							<div class="col-sm-3">
								<h4 class="panel-title"><a href="http://dungfucklinh.tech/?fbclid=IwAR1yQZa-Qczjrp3jQl_FexoDRm4IjukNMRpH4e4-Zjc1U9k5sL12LlhnCbE">
									Contact us, I'm here
								</a></h4>
							
						</div>
						
					
						<div class="tab-pane fade " id="reviews" >
							<div class="col-sm-12">
								<ul>
									<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
									<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
									<li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
								</ul>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
								<p><b>Write Your Review</b></p>
								
								<form action="#">
									<span>
										<input type="text" placeholder="Your Name"/>
										<input type="email" placeholder="Email Address"/>
									</span>
									<textarea name="" ></textarea>
									<b>Rating: </b> <img src="frontend/images/product-details/rating.png" alt="" />
									<button type="button" class="btn btn-default pull-right">
										Submit
									</button>
								</form>
							</div>
						</div>
						
					</div>
				</div><!--/category-tab-->
				
				<div class="recommended_items"><!--recommended_items-->
					<h2 class="title text-center">recommended items</h2>
					
					<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							<div class="item active">
								
								@foreach ($prd_brand as $row)
								<a href="product/product_detail/{{ $row->id }}/{{ $row->brand_id }}">
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="backend/images/{{ $row->img }}" alt="" />
												<h2>${{ $row->price }}</h2>
												<p>{{ $row->name }}</p>
												<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
											</div>
										</div>
									</div>
								</div>
							</a>
								@endforeach
							
							
							</div>
							<div class="item">	
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="frontend/images/home/recommend1.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="frontend/images/home/recommend2.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="frontend/images/home/recommend3.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						  </a>
						  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
							<i class="fa fa-angle-right"></i>
						  </a>			
					</div>
				</div><!--/recommended_items-->
				
			</div>
		</div>
	</div>
</section>

@endsection
