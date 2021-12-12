# language: ru

Функционал: Проверка корректности поиска наушников на Яндекс.Маркет

  Сценарий: Поиск наушников на Яндекс.Маркет

Когда Выполнен переход на Яндекс.Маркет
    И Выполнен переход в раздел Электроника
    И Выполнен переход в раздел "наушники"
    И Выполнен переход к расширенному фильтру
    И Установлена цена от "5000"
    И Выбран производитель "Beats"
    И Фильтр применен
    Тогда Проверяет кол-во выведенных результатов поиска
    Когда Вводит в поисковую строку первый элемент в списке результатов поиска
    Тогда Проверяет, что наименование товара соответствует заданному значению

