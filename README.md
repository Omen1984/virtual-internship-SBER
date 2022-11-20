# 1 Задача

## Описание задачи

Необходимо реализовать класс Main, используя java.util.Scanner, прочесть информацию из текстового представления справочника и разложить данные в модель City с полями:

name – наименование города
region - регион
district – федеральный округ
population – количество жителей города
foundation – дата основания или первое упоминание
Полученный список объектов City нужно вывести в консоль.

Пример полученного результата:

```
City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}

City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}

City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'} 
```
## Реализация

- Создал отдельный класс `CityUtils` для парсинга CSV в `City`; - Заметил в данных ошибку - отсутствует поле foundation в csv и из расчета, что это поле является не обязательным в парсере прописал проверку на присутствие этого поля в считываемой строке, изначально воспользовался методами класса String, но по условиям задачи нужно было делать с помощью класса `Scanner` поэтому переделал с использованием данного класса.

[Реализация доступна по ссылке]()

---

# 2 Задача 

## Описание задачи

Необходимо реализовать следующие варианты сортировки:

Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;
Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра;
Вывести полученный список объектов City в консоль. При реализации сортировки обратить внимание на возможные варианты реализации: Comporator, lambda-выражения.

Пример полученного результата для сортировки по наименованию:

```
City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation='1867'}

City{name='Абакан', region='Хакасия', district='Сибирский', population=165183, foundation='1931'}

City{name='Абдулино', region='Оренбургская область', district='Приволжский', population=20663, foundation='1795'} 
```


Пример полученного результата для сортировки по двум полям справочника – федеральному округу и наименованию города:

```
City{name='Алдан', region='Якутия', district='Дальневосточный', population=21277, foundation='1924'}

City{name='Александровск-Сахалинский', region='Сахалинская область', district='Дальневосточный', population=10613, foundation='1869'}

City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}
```
## Реализация

-  Реализовал простой поиск максиму в массиве алг. сложность о(n). Все также реализовано в классе `CityUtils`

[Реализация доступна по ссылке]()

---

# 3 Задача 

## Описание задачи

Необходимо определить количество городов в разрезе регионов.

Пример полученного результата:
```
Вологодская область - 15

Татарстан - 22

Хабаровский край – 7
```
## Реализация

-  Решил данную задачу с помощью заполнения мапы, где ключом выступает регион, а значением количество изпользовав лямбда выражение. Все также реализовано в классе `CityUtils`

[Реализация доступна по ссылке]()

---