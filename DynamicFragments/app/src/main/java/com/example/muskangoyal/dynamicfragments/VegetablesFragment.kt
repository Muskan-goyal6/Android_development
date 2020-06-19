package com.example.muskangoyal.dynamicfragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_vegetables.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class VegetablesFragment : Fragment() {

    val vegetables = arrayOf(
            "potato","peas","onion","tomato","carrot","capsicum","radish",
            "pumpkin","lettuce","gourd"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val FragmentView =inflater.inflate(R.layout.fragment_vegetables, container, false)

        FragmentView.lvVege.adapter = ArrayAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                vegetables
        )

        return FragmentView


    }


}
