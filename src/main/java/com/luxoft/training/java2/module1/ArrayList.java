package com.luxoft.training.java2.module1;

import static com.luxoft.training.Logger.log;

/**
 * Данный класс делает то же, что делает стандартный ArrayList:
 * увеличивает размер массива, когда массив заполнен.
 * <p>
 * Реализуйте метод deleteAnimal(int position)
 */
class ArrayList<T> {

  private int animalsCapacity = 5;
  String[] animals = new String[animalsCapacity];
  private int animalsSize = 0;

  public void addAnimal(String animal) {
    if (animalsSize >= animalsCapacity)
      expandAnimalsArray();
    animals[animalsSize] = animal;
    animalsSize++;
  }

  private void expandAnimalsArray() {
    int old_animals_size = animalsCapacity;
    int animalsExpandBy = 5;
    animalsCapacity += animalsExpandBy;
    String[] animals_new = new String[animalsCapacity];
    System.arraycopy(animals, 0, animals_new, 0, old_animals_size);
    animals = animals_new;
  }

  public void insertAnimal(int position, String animal) {
    if (position < 0 || position > animalsSize - 1)
      throw new ArrayIndexOutOfBoundsException();

    if (position == animalsSize - 1)
      addAnimal(animal);
    else {
      if (animalsSize >= animalsCapacity)
        expandAnimalsArray();
      System.arraycopy(animals, position, animals, position + 1, animalsSize - position);
      animals[position] = animal;
      animalsSize++;
    }
  }

  public void deleteAnimal(int position) {
    System.arraycopy(animals,
        position + 1,
        animals,
        position,
        animalsSize - position);

    animalsSize--;
  }

  public void showAnimals() {
    for (int i = 0; i < animalsSize; i++) {
      log(i + ") " + animals[i]);
    }
  }

}
