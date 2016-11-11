package util;

import web.form.AddProductAccessoriesForm;

/**
 * Created by Egor on 11.11.2016.
 */
public class AddProductAccessoriesValidator {
    public static boolean nonEmptyAddProduct(AddProductAccessoriesForm addProductForm) {
        return addProductForm.getName() == null ||
                addProductForm.getName().isEmpty() ||
                addProductForm.getPrice() == 0 ||
                addProductForm.getCount() == 0 ||
                addProductForm.getDescription() == null ||
                addProductForm.getDescription().isEmpty();
    }
}
