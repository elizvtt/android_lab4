package com.example.lab4_palazova

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import androidx.fragment.app.Fragment

class Fragment4 : Fragment() {

    private lateinit var switch: Switch
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment4_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // знаходимо елементи по id
        switch = view.findViewById(R.id.switch1)
        imageView = view.findViewById(R.id.imageView2)

        // встановлюємо обробник події для перемикача
        switch.setOnCheckedChangeListener { _, isChecked ->
            // якщо перемикач увімкнено — відображаємо зображення img3
            // якщо перемикач вимкнено — відображаємо зображення img2
            if (isChecked) {
                imageView.setImageResource(R.drawable.img3)
            } else {
                imageView.setImageResource(R.drawable.img2)
            }
        }
    }
}