package com.luxoft.training.java2.module1;

import org.junit.jupiter.api.Test;

class ArrayListTest { //for com.luxoft.training.java2.module1.ArrayList

  ArrayList arrayList = new ArrayList();

  @Test
  void testAnimals() {

    // given
    arrayList.add("Лошадь");
    arrayList.add("Носорог");
    arrayList.add("Собака");
    arrayList.add("Змея");
    arrayList.add("Обезьяна");
    arrayList.add("Индюк");
    arrayList.add("Косуля");
    arrayList.add("Лев");
    arrayList.add("Тигр");
    arrayList.add("Кошка");
    arrayList.add("Черепаха");

    // when
    arrayList.insert(1, "Человек");

    // then
//    Assertions.assertThat(arrayList.animals.length % 5).isEqualTo(0);
//    Assertions.assertThat(arrayList.animals[1]).isEqualTo("Человек");

    arrayList.delete(2);

    arrayList.showElements();
  }
}