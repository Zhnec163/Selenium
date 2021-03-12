# language: ru
@all
Функция: Поиск на авито
  Выбираем раздел товаров, вводим искомый товар
  Выбираем нужный нам город, ставим фильтр по убыванию
  Получаем название и цену, трех результатов поиска

  Сценарий: Найдем самые дорогие принтеры на авито
    Пусть открыт ресурс авито
    И в выпадающем списке категорий выбрана оргтехника
    И в поле поиска введено значение принтер
    Тогда кликнуть по выпадающему списку региона
    Тогда в поле регион введено значение Владивосток
    И нажата кнопка показать объявления
    Тогда открыласть страница результаты по запросу принтер
    И активирован чекбокс только с доставкой
    И в выпадающем списке сотировка выбрано значение Дороже
    И в консоль выведено значение названия и цены 5 первых товаров

