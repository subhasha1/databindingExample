package com.example.databindingexample.product;

import com.example.databindingexample.models.Product;

/**
 * Braindigit
 * Created on 1/2/17.
 */

public class ProductPresenter implements ProductContract.Presenter {
    private final ProductContract.View view;
    private final Product product;
    private ProductViewModel productViewModel;

    public ProductPresenter(ProductContract.View view, Product product) {
        this.view = view;
        this.product = product;
    }


    @Override
    public void start() {
        this.view.showLoading();

    }
}
