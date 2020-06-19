package com.example.muskangoyal.staticfragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count_down.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class CountDownFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var count=0
        val fragmentView = inflater.inflate(R.layout.fragment_count_down, container, false)

        fragmentView.btnadd.setOnClickListener {
            count--
            fragmentView.tvCounter.text = count.toString()
        }

        return fragmentView
    }


}
