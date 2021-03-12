package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.avito.SearchTest;

public class Step {

    SearchTest searchTest = new SearchTest();

    @ParameterType(".*")
    public Categories categories(String category){ return Categories.valueOf(category); }

    @ParameterType(".*")
    public Sort sort(String sort){ return Sort.valueOf(sort); }

    @Before
    public void setUp(){
        searchTest.setUp();
    }

    @Пусть("открыт ресурс авито")
    public void openSite(){
        searchTest.openSite();
    }


    @И("в выпадающем списке категорий выбрана {categories}")
    public void setCaregoryName(Categories category){
        searchTest.setCaregoryName(category.getId());
    }

    @И("в поле поиска введено значение {word}")
    public void setItemName(String name){
        searchTest.setItemName(name);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void changeCity(){
        searchTest.changeCity();
    }

    @И("в поле регион введено значение {word}")
    public void setCityName(String name){
        searchTest.setCityName(name);
    }

    @Тогда("нажата кнопка показать объявления")
    public void pressShowAdsButton() {
        searchTest.pressShowAdsButton();
    }

    @Тогда("открыласть страница результаты по запросу {word}")
    public void result(String name){
        searchTest.result(name);
    }

    @И("активирован чекбокс только с доставкой")
    public void isDelivery() {
        searchTest.isDelivery();
    }

    @И("в выпадающем списке сотировка выбрано значение {sort}")
    public void setSort(Sort sort){
       searchTest.setSort(sort);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void getResults(int count){
        searchTest.getResults(count);
    }

    @After
    public void close(){
        searchTest.close();
    }
}
