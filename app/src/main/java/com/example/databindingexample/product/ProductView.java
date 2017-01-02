package com.example.databindingexample.product;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.databindingexample.R;
import com.example.databindingexample.databinding.ActivityMainBinding;
import com.example.databindingexample.models.Product;

public class ProductView extends AppCompatActivity implements ProductContract.View {
    ProductContract.Presenter presenter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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
        this.binding.setState(1);
        this.binding.setProduct(product);
    }

    @Override
    public void setProductDetail(ProductViewModel productDetail) {
//        setup pagers etc
    }

    @Override
    public void showLoading() {
        this.binding.setState(0);
    }

    @Override
    public void showError() {
        this.binding.setState(2);
    }

    private Product getFromIntent() {
        Product product = new Product();
        product.isFav = true;
        product.id = 123;
        product.title = "Product title";
        product.image = "url";
        product.oldPrice = 90;
        product.newPrice = 80;
        return product;
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
