package steps;

import org.testng.Assert;

import basePkg.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import pages.ProductPage;
import pages.SearchResultPage;

public class AmazonSteps {
	Homepage home;
    SearchResultPage results;
    ProductPage product;
    
    @Before(order = 1)
    public void initPages() {
        home = new Homepage(BaseClass.driver);
        results = new SearchResultPage(BaseClass.driver);
        product = new ProductPage(BaseClass.driver);
    }
	@Given("Amazon home page is launched")
	public void amazon_home_page_is_launched() {
		BaseClass.waitForTitle("Amazon");
		Assert.assertTrue(home.getTitle().contains("Amazon"));
	}

	@Then("Verify page title contains Amazon")
	public void verify_page_title_contains_amazon() {
		Assert.assertTrue(home.getTitle().contains("Amazon"));
	}

	@When("Search for product {string}")
	public void search_for_product(String pname) {
		home.searchProduct(pname);
	}

	@Then("Verify search results are displayed")
	public void verify_search_results_are_displayed() {
		Assert.assertTrue(results.resultsDisplayed());
	}

	@When("Apply brand filter {string}")
	public void apply_brand_filter(String brand) throws InterruptedException {
		results.applyBrandFilter(brand);
		Thread.sleep(5000);
	}

	@When("Open first product from results")
	public void open_first_product_from_results() {
		results.clickFirstProduct();
		BaseClass.SwitchWindow();
	}

	@Then("Verify product title and price are displayed")
	public void verify_product_title_and_price_are_displayed() {
		Assert.assertTrue(product.isTitleDisplayed());
        Assert.assertTrue(product.isPriceDisplayed());
	}

	@When("Add product to cart")
	public void add_product_to_cart() {
		product.addToCart();
	}

	@Then("Verify product added to cart")
	public void verify_product_added_to_cart() {
		Assert.assertTrue(product.cartUpdated());
	}

}
