package com.example.lab4_palazova

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            // Получаем менеджер фрагментов
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            // Создаем фрагменты
            val fragment1 = Fragment1()
            val fragment2 = Fragment2()
            val fragment3 = Fragment3()
            val fragment4 = Fragment4()

            // Добавляем фрагменты в контейнеры
            fragmentTransaction.add(R.id.frame1, fragment1)
            fragmentTransaction.add(R.id.frame2, fragment2)
            fragmentTransaction.add(R.id.frame3, fragment3)
            fragmentTransaction.add(R.id.frame4, fragment4)

            // Подтверждаем транзакцию
            fragmentTransaction.commit()
        }
    }
}