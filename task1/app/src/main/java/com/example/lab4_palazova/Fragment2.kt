package com.example.lab4_palazova

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Fragment2 : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var toast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment2_layout, container, false)
    }

    // метод, який викликається, коли інтерфейс створено
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val buttonP: Button = view.findViewById(R.id.buttonPlus)

        buttonP.setOnClickListener {
            viewModel.increment()

            // швидке оновлення Toast повідомлень
            toast?.cancel()
            toast = Toast.makeText(requireContext(), "${viewModel.counter.value}", Toast.LENGTH_SHORT)
            toast?.show()
        }
    }
}