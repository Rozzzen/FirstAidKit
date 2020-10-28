package com.example.bandages;

import com.example.Material;

public class AdhesivePlaster extends BandagingMaterial {

    public AdhesivePlaster(int width, int length, Material material) {
        super(width, length, material);
    }

    @Override
    public void bandageWound() {
        System.out.println("Wound was bandaged by plaster");
    }

}


//8) Перевизначити метод toString() для класу enum. Наприклад, виводити всі значення у одну строчку розділяючи комою.
//9) Зібрати строку за допомогою StringBuffer або StringBuilder, вміти пояснити, чому так більш влучно, ніж за допомогою оператора "+" для String.
//11) Вивести деякі строки на екран консолі із використанням конкатенції строк із іншими типами (1 бал)
//14) Використати неперевизначений метод equals або hashCode для порівняння двох об’єктів одного з ваших класів. (1 бал)
//18) присутня композиція або агрегація (без урахування nested класу) (1 бал)
//19) присутня колекція із java.util.Collections, тип — такий, що найбільше підходить для завдання на вашу думку. Створити об’єкт-ітератор і реалізувати перебір за його допомогою створеної колекції (2 бали).
//Exception