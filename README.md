# Лабораторна робота №4
### Завдання №1
  За допомогою методу статичного додавання фрагментів, реалізуйте наступний додаток (макет з 4х фрагментів, залежно від орієнтації використовується альтернативний макет з іншим компонуванням фрагментів)

### Виконання завдання:

У файлі activity_main.xml за допомогою androidx.fragment.app.FragmentContainerView створюємо 4 фрагменти для вертикальної орієнтації. У папці land створюємо ще один файл activity_main.xml для горизонтальної орієнтації 

![image](https://github.com/user-attachments/assets/92c47fcf-68d7-48e1-a758-a43caae96cbc)

![image](https://github.com/user-attachments/assets/a06509e7-72a9-4f10-b410-1b76e0418aeb)

В папці Layout створюємо xml макети для усіх фрагментів:

![image](https://github.com/user-attachments/assets/c699d884-f00e-469e-b207-9a8e336d06c6)
![image](https://github.com/user-attachments/assets/fd231146-7026-4fa2-89a9-cab4e7573e93)
![image](https://github.com/user-attachments/assets/0282ba5c-5107-4e0f-8362-de1f570d94e1)
![image](https://github.com/user-attachments/assets/f4998b85-bb17-4694-9758-28fbc68692fe)

Створюємо файл SharedViewModel.kt, який містить LiveData для зберігання і передачі даних між фрагментами. Реалізуємо методи для додавання та віднімання одиниці від поточного значення лічильника.
```
class SharedViewModel : ViewModel() {

    private val count = MutableLiveData(0) // змінна для лічильника
    val counter: LiveData<Int> = count

    // збільшення лічільника на 1
    fun increment() {
        count.value = count.value!! + 1
    }

    // зменшення лічільника на 1
    fun decrement() {
        count.value = count.value!! - 1
    }
}
```

Далі створюємо файли Fragment.kt для усіх фрагментів. У кожному файлі реалізуємо метод onCreateView(), який створює інтерфейс фрагмента, підключаючи XML-розмітку fragment_layout.

У файлах Fragment2.kt та Fragment3.kt додаємо метод onViewCreated(), який викликається після того, як інтерфейс вже створено. В цьому методі додаємо слухачі для кнопок, при натисканні яких виконується збільшення або зменшення значення лічильника за допомогою SharedViewModel та показується повідомлення з поточним значенням. 

У файлі Fragment4.kt також використовуємо метод onViewCreated(), у якому додаємо обробник події для перимакача. Якщо перемикач увімкнено, то відображається зображення img3, Якщо перемикач вимкнено - зображення img2.

В результаті отримуємо додаток з 4ма фрагментамі:

![image](https://github.com/user-attachments/assets/36f1bc95-d38f-4fee-9ab2-c7201c610aff)
![Снимок экрана 2025-04-30 142421](https://github.com/user-attachments/assets/f8dafe06-0c4a-40fa-a432-0f3b835b597f)
![image](https://github.com/user-attachments/assets/f3375b84-6d70-49e3-9f73-e417cf809de4)


### Завдання №2
Для успішного виконання другого завдання необхідно реалізувати гортання фрагментів за допомогою `ViewPager2` спільно з `TabLayout` або `BottomNavigationView`

### Виконання завдання:

У папці res створюємо папку menu. У створеній папці створюємо файл bootom-menu.xml для нижної навігації. Для кожного item додаємо іконку. Всі п'ять іконок знайдені за [посиланням](https://www.flaticon.com/ru/search?author_id=1&style_id=7&type=standard&word=)

```
    <item
        android:id="@+id/item_1"
        android:icon="@drawable/icon1"
        tools:ignore="MenuTitle" />
```
Далі у файлі activity_main.xml додаємо ViewPager2 та BottomNavigationView

![image](https://github.com/user-attachments/assets/ac60c042-bf6c-4226-81cc-341e3842df45)

Після цього створюємо XML файли для всіх фрагментів. Для цього завдання всі фрагменти містять лише ImageView.
Далі створюємо файли Fragment.kt для усіх фрагментів. У кожному файлі реалізуємо метод onCreateView(), який створює інтерфейс фрагмента, підключаючи XML-розмітку fragment_layout.
Далі створюємо адаптер для ViewPager2, що повертає фрагменти відповідно до позиції.
У файлі MainActivity.kt ініціалізується ViewBinding, створюється адаптер для ViewPager2, який відповідає за відображення фрагментів при гортанні. Також додається слухач подій на зміну сторінок ViewPager2, щоб під час гортання активувався відповідний пункт у нижньому меню навігації. Також реалізується обробка натискань на пункти нижньої навігації — при натисканні змінюється сторінка у ViewPager2.
В результаті отримано:

![image](https://github.com/user-attachments/assets/bea5a403-b39f-4316-aaff-b9791b4e239a)
![image](https://github.com/user-attachments/assets/4375a255-a447-4df1-a56a-42e64f6a59d7)
