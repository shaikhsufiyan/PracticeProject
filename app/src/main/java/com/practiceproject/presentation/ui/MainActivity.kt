package com.practiceproject.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.practiceproject.R
import com.practiceproject.presentation.viewmodel.TodoVM
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val todoVM: TodoVM by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv = findViewById<MaterialTextView>(R.id.fieldTextList)
        val fieldTitle = findViewById<TextInputEditText>(R.id.fieldTitle)
        val btnAdd = findViewById<MaterialButton>(R.id.btn_add)

//        val dao: TodoDAO? = TodoDB.getInstance(this@MainActivity)?.todo()
//        val repo = DataProvideRepoImp(dao!!)
//        val addUseCase = AddTodoUseCase(repo)
//        val getUseCase = GetTodoUseCase(repo)
//        val factory = TodoVMFactory(addUseCase, getUseCase)
//        val todoVM = ViewModelProvider(this, factory)[TodoVM::class.java]

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                todoVM.todo.collect {
                    tv.text = it.toString()
                }

            }
        }

//        todoVM.loadTodo()
        btnAdd.setOnClickListener {
            lifecycleScope.launch {
                try {
                    todoVM.addTodo(fieldTitle.text.toString())
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}