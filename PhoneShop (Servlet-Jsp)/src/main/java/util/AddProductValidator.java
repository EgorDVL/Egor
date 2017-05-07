package util;

import web.form.AddProductForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 11.11.2016.
 */
public class AddProductValidator {

    public static boolean nonEmptyAddProduct(AddProductForm addProductForm) {
        return addProductForm.getName() == null ||
                addProductForm.getName().isEmpty() ||
                addProductForm.getPrice() == 0 ||
                addProductForm.getCount() == 0 ||
                addProductForm.getDescription() == null ||
                addProductForm.getDescription().isEmpty() ||
                addProductForm.getColor() == null ||
                addProductForm.getColor().isEmpty() ||
                addProductForm.getMemory() == 0 ||
                addProductForm.getScreenSize() == 0.0 ||
                addProductForm.getProcessor() == null ||
                addProductForm.getProcessor().isEmpty() ||
                addProductForm.getRam() == 0 ||
                addProductForm.getFrontCamera() == 0.0 ||
                addProductForm.getMainCamera() == 0.0;
    }
}