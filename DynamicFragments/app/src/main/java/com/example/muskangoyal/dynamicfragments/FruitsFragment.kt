package com.example.muskangoyal.dynamicfragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_fruits.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class FruitsFragment : Fragment() {

    val fruits = arrayOf(
            "Banana","apple","orange","mango","peach","grapes",
            "avacado","cherry","pineapple","kiwi","melon"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val FragmentView =inflater.inflate(R.layout.fragment_fruits, container, false)

        FragmentView.lvFruits.adapter = ArrayAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                fruits
        )

        return FragmentView
    }


}
