package com.example.muskangoyal.kotlintodolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.muskangoyal.kotlintodolist.Adapter.TodoAdapter
import com.example.muskangoyal.kotlintodolist.models.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val todos: ArrayList<Todo> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("First task",false))

        rvtodo.layoutManager= LinearLayoutManager(this)
        val todoAdapter : TodoAdapter = TodoAdapter(todos);
        rvtodo.adapter= todoAdapter;

        btn.setOnClickListener({
            val newtodo =et1.text.toString()
            todos.add(Todo(newtodo,false))
            todoAdapter.notifyDataSetChanged();
        }
        )
    }
}
