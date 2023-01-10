package com.example.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(btnShowContextMenu)

        btnShowContextMenu.setOnClickListener { v -> openContextMenu(v) }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu, v: View?,
        menuInfo: ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.context_menu, menu)
        menu.setHeaderTitle("Select Item")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.one -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.two -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.three -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}