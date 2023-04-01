import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class InStockTests {

    private final String DEFAULT_PRODUCT_LABEL = "Some label";
    private final int DEFAULT_QUANTITY = 5;
    private Instock products;
    private final Product defaultProduct = new Product(DEFAULT_PRODUCT_LABEL, 0.5, DEFAULT_QUANTITY);


    @Before
    public void beforeEach() {
        products = new Instock();
    }

    @Test
    public void testCountIsZeroForNewInstock() {
        int actual = products.getCount();

        assertEquals(0, actual);
    }

    @Test
    public void testCountShouldBeOneWithSingleProduct() {
        products.add(defaultProduct);
        int count = products.getCount();

        assertEquals(1, count);
    }

    @Test
    public void testCountIncreasesWhenAddingProducts() {
        int productCount = 100;
        for (int i = 0; i < productCount; i++) {
            products.add(new Product("asd" + i, 0.5, 5));
        }

        int actualCount = products.getCount();

        assertEquals(productCount, actualCount);
    }

    @Test
    public void testCountStaysTheSameWithEqualLabelProducts() {
        for (int i = 0; i < 100; i++) {
            products.add(new Product(DEFAULT_PRODUCT_LABEL, 0.5, 5));
        }

        int actualCount = products.getCount();

        assertEquals(1, actualCount);
    }

    @Test
    public void testContainsWithNotExistingProduct() {
        boolean result = products.contains(defaultProduct);

        assertFalse(result);
    }

    @Test
    public void testContainsWithExistingProduct() {
        products.add(defaultProduct);
        boolean result = products.contains(defaultProduct);

        assertTrue(result);
    }

    @Test
    public void testContainsWithExistingProductComparedByLabel() {
        products.add(defaultProduct);
        boolean result = products.contains(new Product(DEFAULT_PRODUCT_LABEL, 0.5, 5));

        assertTrue(result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidIndexThrows() {
        products.find(1);
    }

    @Test
    public void testFindWithValidIndexReturnsProduct() {
        products.add(defaultProduct);

        Product actualProduct = products.find(0);

        assertEquals(defaultProduct, actualProduct);
    }

    @Test
    public void testFindWithMultipleProductsAndValidIndexReturnsProduct() {
        for (int i = 0; i < 100; i++) {
            products.add(new Product("label" + i, 0, 0));
        }
        Product expected = new Product("label33", 0, 0);

        Product actual = products.find(33);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityForEmptyInstockThrows() {
        products.changeQuantity(DEFAULT_PRODUCT_LABEL,  5);
    }

    @Test
    public void testChangeQuantityForExistingProduct() {
        products.add(defaultProduct);

        products.changeQuantity(DEFAULT_PRODUCT_LABEL, 5);
        Product actual = products.find(0);


        assertEquals(DEFAULT_QUANTITY + 5, actual.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityForMissingProductThrows() {
        for (int i = 0; i < 100; i++) {
            products.add(new Product(DEFAULT_PRODUCT_LABEL + i, 0, 0));
        }

        products.changeQuantity(DEFAULT_PRODUCT_LABEL,  5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWithEmptyInstockThrows() {
        products.findByLabel(DEFAULT_PRODUCT_LABEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWithMissingProductThrows() {
        for (int i = 0; i < 100; i++) {
            products.add(new Product(DEFAULT_PRODUCT_LABEL + i, 0, 0));
        }

        products.findByLabel(DEFAULT_PRODUCT_LABEL);
    }

    @Test
    public void testFindByLabelReturnsCorrectProduct() {
        products.add(defaultProduct);

        Product actual = products.findByLabel(DEFAULT_PRODUCT_LABEL);

        assertEquals(defaultProduct, actual);
    }

    @Test
    public void testFindByLabelWithMultipleProducts() {
        for (int i = 0; i < 100; i++) {
            products.add(new Product(DEFAULT_PRODUCT_LABEL + i, 0, 0));
        }
        products.add(defaultProduct);

        Product actual = products.findByLabel(DEFAULT_PRODUCT_LABEL);

        assertThat(actual, is(equalTo(defaultProduct)));
    }

    @Test
    public void testFindFirstByAlphabeticalWithEmptyInstock() {
        Iterable<Product> actual = products.findFirstByAlphabeticalOrder(5);

        assertThat(actual, is(emptyIterable()));
    }

    @Test
    public void testFindFirstByAlphabeticalWithSingleProduct() {
        products.add(defaultProduct);
        Iterable<Product> actual = products.findFirstByAlphabeticalOrder(1);

        assertThat(actual, contains(defaultProduct));
        assertThat(actual, is(iterableWithSize(1)));
    }

    @Test
    public void testFindFirstByAlphabeticalWithSizeLargerThanProductCount() {
        products.add(defaultProduct);
        Iterable<Product> actual = products.findFirstByAlphabeticalOrder(5);

        assertThat(actual, is(emptyIterable()));
    }

    @Test
    public void testFindFirstByAlphabeticalWithMultipleProducts() {
        Product aProduct = new Product("A", 0, 0);
        Product dProduct = new Product("D", 0, 0);
        Product cProduct = new Product("C", 0, 0);
        Product bProduct = new Product("B", 0, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findFirstByAlphabeticalOrder(3);
//        List<Product> expected = Arrays.asList(aProduct, bProduct, cProduct);

//        int index = 0;
//        for (Product p : actual) {
//            assertEquals(expected.get(index), p);
//            index++;
//        }
//        assertEquals(expected.size(), index);

        assertThat(actual, contains(aProduct, bProduct, cProduct));
    }

    @Test
    public void testFindAllInPriceRangeWhenThereIsNoSuchProducts() {
        products.add(defaultProduct);
        Iterable<Product> actual = products.findAllInRange(0.6, 10);

        assertThat(actual, is(emptyIterable()));
    }

    @Test
    public void testFindAllInPriceRangeWithSingleProductInTheRange() {
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", 0.9, 0);
        Product cProduct = new Product("C", 10, 0);
        Product bProduct = new Product("B", 1.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllInRange(5, 11);

        assertThat(actual, contains(cProduct));
    }

    @Test
    public void testFindAllInPriceRangeWithMultipleProductsInTheRangeSorted() {
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", 6, 0);
        Product cProduct = new Product("C", 10, 0);
        Product bProduct = new Product("B", 7.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllInRange(5, 11);

        assertThat(actual, contains(cProduct, bProduct, dProduct));
    }

    @Test
    public void testFindAllInPriceRangeWithProductWithPriceEqualToLowBound() {
        double lowBound = 5;
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", lowBound, 0);
        Product cProduct = new Product("C", 10, 0);
        Product bProduct = new Product("B", 7.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllInRange(lowBound, 11);

        assertThat(actual, contains(cProduct, bProduct));
    }

    @Test
    public void testFindAllInPriceRangeWithProductWithPriceEqualToHighBound() {
        double highBound = 10;
        Product aProduct = new Product("A", 8, 0);
        Product dProduct = new Product("D", 5, 0);
        Product cProduct = new Product("C", highBound, 0);
        Product bProduct = new Product("B", 7.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllInRange(5, highBound);

        assertThat(actual, contains(cProduct, aProduct, bProduct));
    }

    @Test
    public void testFindAllByPriceWhenThereIsNoSuchProducts() {
        Iterable<Product> actual = products.findAllByPrice(10);

        assertThat(actual, is(emptyIterable()));
    }

    @Test
    public void testFindAllByPriceWithSingleProductWithThatPrice() {
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", 0.9, 0);
        Product cProduct = new Product("C", 10, 0);
        Product bProduct = new Product("B", 1.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllByPrice(10);

        assertThat(actual, contains(cProduct));
    }

    @Test
    public void testFindAllByPriceWithMultipleProductsWithThatPrice() {
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", 10, 0);
        Product cProduct = new Product("C", 10, 0);
        Product bProduct = new Product("B", 10, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllByPrice(10);

        assertThat(actual, contains(dProduct, cProduct, bProduct));
    }

    @Test
    public void testFindAllByQuantityWhenThereIsNoSuchProducts() {
        Iterable<Product> actual = products.findAllByQuantity(DEFAULT_QUANTITY);

        assertThat(actual, is(emptyIterable()));
    }

    @Test
    public void testFindAllByQuantityWithSingleProductWithThatQuantity() {
        Product aProduct = new Product("A", 0.5, 0);
        Product dProduct = new Product("D", 0.9, 0);
        Product cProduct = new Product("C", 5, 0);
        Product bProduct = new Product("B", 1.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(defaultProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllByQuantity(DEFAULT_QUANTITY);

        assertThat(actual, contains(defaultProduct));
    }

    @Test
    public void testFindAllByQuantityWithMultipleProductsWithThatQuantity() {
        Product aProduct = new Product("A", 0.5, DEFAULT_QUANTITY);
        Product dProduct = new Product("D", 9, 0);
        Product cProduct = new Product("C", 5, DEFAULT_QUANTITY);
        Product bProduct = new Product("B", 7.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(defaultProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.findAllByQuantity(DEFAULT_QUANTITY);

        assertThat(actual, contains(aProduct, defaultProduct, cProduct));
    }

    @Test
    public void testGetIterable() {
        Product aProduct = new Product("A", 0.5, DEFAULT_QUANTITY);
        Product dProduct = new Product("D", 9, 0);
        Product cProduct = new Product("C", 5, DEFAULT_QUANTITY);
        Product bProduct = new Product("B", 7.5, 0);

        products.add(aProduct);
        products.add(dProduct);
        products.add(defaultProduct);
        products.add(cProduct);
        products.add(bProduct);

        Iterable<Product> actual = products.getIterable();

        assertThat(actual, contains(aProduct, dProduct, defaultProduct, cProduct, bProduct));
    }
}
