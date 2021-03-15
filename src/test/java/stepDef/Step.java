package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Attachment;
import ru.avito.SearchTest;

public class Step {

    SearchTest searchTest = new SearchTest();

    @Attachment
    public byte[] getScreenshot()  { return searchTest.getScreenshot(); }

    @ParameterType(".*")
    public Categories categories(String category){ return Categories.valueOf(category); }

    @ParameterType(".*")
    public Sort sort(String sort){ return Sort.valueOf(sort); }

    @Before
    public void setUp(){
        searchTest.setUp();
    }

    @Пусть("открыт ресурс авито")
    @io.qameta.allure.Step("открыт ресурс авито")
    public void openSite() {
        searchTest.openSite();
        getScreenshot();
    }

    @И("в выпадающем списке категорий выбрана {categories}")
    @io.qameta.allure.Step("выбрана нужная категория")
    public void setCaregoryName(Categories category) {
        searchTest.setCaregoryName(category.getId());
        getScreenshot();
    }

    @И("в поле поиска введено значение {word}")
    @io.qameta.allure.Step("ввели наименование искомого товара")
    public void setItemName(String name){
        searchTest.setItemName(name);
        getScreenshot();
    }

    @Тогда("кликнуть по выпадающему списку региона")
    @io.qameta.allure.Step("нажата кнопка выбора региона")
    public void changeCity(){
        searchTest.changeCity();
        getScreenshot();
    }

    @И("в поле регион введено значение {word}")
    @io.qameta.allure.Step("введен город поиска")
    public void setCityName(String name){
        searchTest.setCityName(name);
        getScreenshot();
    }

    @Тогда("нажата кнопка показать объявления")
    @io.qameta.allure.Step("нажата кнопка показать объявления")
    public void pressShowAdsButton() {
        searchTest.pressShowAdsButton();
        getScreenshot();
    }

    @Тогда("открыласть страница результаты по запросу {word}")
    @io.qameta.allure.Step("открыласть страница результатов по нашему запросу")
    public void result(String name){
        searchTest.result(name);
        getScreenshot();
    }

    @И("активирован чекбокс только с доставкой")
    @io.qameta.allure.Step("активируем чекбокс с доставкой")
    public void isDelivery() {
        searchTest.isDelivery();
        getScreenshot();
    }

    @И("в выпадающем списке сотировка выбрано значение {sort}")
    @io.qameta.allure.Step("выбираем метод сортировки результатов")
    public void setSort(Sort sort){
       searchTest.setSort(sort);
        getScreenshot();
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    @io.qameta.allure.Step("выводится нужное количество результатов")
    public void getResults(int count){ searchTest.getResults(count); }

    @After
    public void tearDown(){
        getScreenshot();
        searchTest.tearDown();
    }
}
