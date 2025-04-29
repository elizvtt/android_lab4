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

        // Найти по id элементы из fragment4_layout
        switch = view.findViewById(R.id.switch1)
        imageView = view.findViewById(R.id.imageView2)

        // Установить слушатель переключателя
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                imageView.setImageResource(R.drawable.img3) // когда switch включен
            } else {
                imageView.setImageResource(R.drawable.img2) // когда выключен
            }
        }
    }
}