package com.example.hiittimer

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.hiittimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

//    private lateinit var viewModel:MainViewModel

//    https://developer.android.com/codelabs/android-databinding
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        viewModel.lapsAdd(4)
        viewModel.runAdd(20)
        viewModel.restAdd(10)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private enum class ActionStates{
        zero,runninng,stopping
    }
    private  var actionState =ActionStates.zero;


    fun onClickAction(v:View){
        when(actionState){
            ActionStates.zero->actionStart();
            ActionStates.runninng->actionStop();
        }
    }

    fun actionStart(){
        actionState=ActionStates.runninng
        
    }
    fun actionStop(){
        actionState=ActionStates.stopping

    }
    fun actionReset(){

    }

}