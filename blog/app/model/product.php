<?php

namespace App\model;

use Illuminate\Database\Eloquent\Model;

class product extends Model
{
    protected $table='product';

    
    public function category()
    {
        return $this->belongsTo('App\model\category', 'category_id', 'id');
    }
      
    public function brand()
    {
        return $this->belongsTo('App\model\brand', 'brand_id', 'id');
    }
}
