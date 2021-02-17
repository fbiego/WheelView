package com.wangjie.wheelview.sample
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wangjie.wheelview.R
import com.wangjie.wheelview.WheelView

class MainActivity:AppCompatActivity(), View.OnClickListener {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private val PLANETS = arrayListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune", "Pluto")
    }

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wva = findViewById<WheelView>(R.id.main_wv)
        wva.offset = 1
        wva.setItems(PLANETS)
        wva.onWheelViewListener = object  : WheelView.OnWheelViewListener(){
            override fun onSelected(index:Int, item:String?) {
                Log.d(TAG, "selectedIndex: $index, item: $item")
            }
        }
        findViewById<Button>(R.id.main_show_dialog_btn).setOnClickListener(this)
    }

    override fun onClick(v:View) {
        when (v.id) {
            R.id.main_show_dialog_btn -> {
                val outerView = LayoutInflater.from(this).inflate(R.layout.wheel_view, null)
                val wv = outerView.findViewById(R.id.wheel_view_wv) as WheelView
                wv.offset = 2
                wv.setItems(PLANETS)
                wv.setSelection(3)
                wv.onWheelViewListener = object :WheelView.OnWheelViewListener() {
                    override fun onSelected(index:Int, item:String?) {
                        Log.d(TAG, "[Dialog]selectedIndex: $index, item: $item")
                    }
                }
                AlertDialog.Builder(this)
                        .setTitle("WheelView in Dialog")
                        .setView(outerView)
                        .setPositiveButton("OK", null)
                        .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu:Menu):Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings)
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}