package com.example.databindingexample.product;

import android.databinding.BindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.databindingexample.R;
import com.example.databindingexample.models.Product;

public class ProductView extends AppCompatActivity implements ProductContract.View {
    ProductContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Product product = getFromIntent();
        presenter = new ProductPresenter(this, product);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setProduct(ProductViewModel product) {

    }

    @Override
    public void setProductDetail(ProductViewModel productDetail) {

    }

    private Product getFromIntent() {
        Product product = new Product();
        product.isFav = true;
        product.id = 123;
        product.title = "Product title";
        product.image = "url";
        product.oldPrice = 90;
        product.newPrice = 80;
        return null;
    }


    @BindingAdapter("visible")
    public static void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("selected")
    public static void setSelected(View view, boolean selected) {
        view.setSelected(selected);
    }
}
