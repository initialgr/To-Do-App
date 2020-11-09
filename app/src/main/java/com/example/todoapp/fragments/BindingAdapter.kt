package com.example.todoapp.fragments

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.todoapp.R
import com.example.todoapp.data.model.Priority
import com.example.todoapp.data.model.ToDoData
import com.example.todoapp.fragments.list.ListFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BindingAdapter {

    companion object{

        @BindingAdapter("android:navigateToAddFragment")
        @JvmStatic
        fun navigateToAddFragment(view : FloatingActionButton, navigate : Boolean){
            view.setOnClickListener {
                if(navigate){
                    view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
                }
            }
        }
        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view : View, emptyDatabase : MutableLiveData<Boolean>){
            when (emptyDatabase.value){
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE

            }
        }
        @BindingAdapter("android:parsePriorityToInt")
        @JvmStatic
        fun parsePriorityToInt(view : Spinner, priority: Priority){
            when(priority){
                Priority.HIGH ->{view .setSelection(0)}
                Priority.MEDIUM ->{view .setSelection(1)}
                Priority.LOW ->{view .setSelection(2)}
            }
        }
        @SuppressLint("UseCompatLoadingForDrawables")
        @BindingAdapter("android:parsePriorityColor")
        @JvmStatic
        fun parsePriorityColor(imageView : ImageView, priority: Priority){
            when(priority){
                Priority.HIGH ->{ imageView.setImageDrawable(imageView.context.getDrawable(R.drawable.red))}
                Priority.MEDIUM ->{ imageView.setImageDrawable(imageView.context.getDrawable(R.drawable.yellow))}
                Priority.LOW ->{ imageView.setImageDrawable(imageView.context.getDrawable(R.drawable.green))}
            }
        }
        @BindingAdapter("android:sendDataToUpdateFragment")
        @JvmStatic
        fun sendDataToUpdateFragment(view : ConstraintLayout, currentItem : ToDoData) {
            view.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                view.findNavController().navigate(action)
            }
        }
    }
}