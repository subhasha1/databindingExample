package com.example.databindingexample.product;

import android.os.AsyncTask;

import com.example.databindingexample.models.Currency;
import com.example.databindingexample.models.Product;
import com.example.databindingexample.models.ProductDetail;

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
        new AsyncTask<Void, ProductViewModel, ProductDetail>() {

            @Override
            protected ProductDetail doInBackground(Void... voids) {
                Currency currency = new Currency();
                boolean isFav = isProductFav(product.id);
                productViewModel = new ProductViewModel(product, currency, isFav);
                publishProgress(productViewModel);
                ProductDetail productDetail = getProductDetailsFromServer(product.id);
                return productDetail;
            }

            @Override
            protected void onProgressUpdate(ProductViewModel... values) {
                productViewModel = values[0];
                view.setProduct(productViewModel);
            }

            @Override
            protected void onPostExecute(ProductDetail productDetail) {
                productViewModel.setProductDetail(productDetail);
            }
        }.execute();
    }

    private ProductDetail getProductDetailsFromServer(int id) {
        return new ProductDetail();
    }

    private boolean isProductFav(int id) {
        return false;
    }
}
