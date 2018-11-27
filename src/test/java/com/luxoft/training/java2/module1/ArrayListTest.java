package com.luxoft.training.java2.module1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayListTest { //for com.luxoft.training.java2.module1.ArrayList

  ArrayList arrayList = new ArrayList();

  @Test
  void testAnimals() {

    // given
    arrayList.addAnimal("Лошадь");
    arrayList.addAnimal("Носорог");
    arrayList.addAnimal("Собака");
    arrayList.addAnimal("Змея");
    arrayList.addAnimal("Обезьяна");
    arrayList.addAnimal("Индюк");
    arrayList.addAnimal("Косуля");
    arrayList.addAnimal("Лев");
    arrayList.addAnimal("Тигр");
    arrayList.addAnimal("Кошка");
    arrayList.addAnimal("Черепаха");

    // when
    arrayList.insertAnimal(1, "Человек");

    // then
//    Assertions.assertThat(arrayList.animals.length % 5).isEqualTo(0);
//    Assertions.assertThat(arrayList.animals[1]).isEqualTo("Человек");

    arrayList.deleteAnimal(2);
    arrayList.showAnimals();
  }
}