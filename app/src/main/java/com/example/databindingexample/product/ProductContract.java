package com.example.databindingexample.product;

/**
 * Braindigit
 * Created on 1/2/17.
 */

public interface ProductContract {

    interface Presenter {
        void start();
    }

    interface View {
        void setProduct(ProductViewModel product);

        void setProductDetail(ProductViewModel productDetail);

        void showLoading();

        void showError();
    }
}
