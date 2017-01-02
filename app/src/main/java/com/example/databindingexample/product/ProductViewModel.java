package com.example.databindingexample.product;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.databindingexample.BR;
import com.example.databindingexample.models.Currency;
import com.example.databindingexample.models.Product;
import com.example.databindingexample.models.ProductDetail;

import java.util.Arrays;
import java.util.List;

/**
 * Braindigit
 * Created on 1/2/17.
 */
public class ProductViewModel extends BaseObservable {
    private final Product product;
    private final Currency currency;
    private boolean isFavourite;
    private ProductDetail productDetail;

    public ProductViewModel(Product product, Currency currency, boolean isFavourite) {
        this.product = product;
        this.currency = currency;
        this.isFavourite = isFavourite;
    }

    public void setProductDetail(ProductDetail productDetail){
        this.productDetail = productDetail;
        notifyChange();
    }

    int getId() {
        return product.id;
    }

    @Bindable
    public String getName() {
        if (productDetail == null)
            return product.title;
        else
            return productDetail.title;
    }

    @Bindable
    public List<String> getImages() {
        if (productDetail == null)
            return Arrays.asList(product.image);
        else
            return productDetail.images;
    }


    @Bindable
    public String getNewPrice() {
        return currency.label + product.newPrice;
    }

    @Bindable
    public String getOldPrice() {
        return currency.label + product.oldPrice;
    }

    @Bindable
    public boolean isFav() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite){
        this.isFavourite = favourite;
        notifyPropertyChanged(BR.fav);
    }

    public void onFavClicked(View view){

    }

}
