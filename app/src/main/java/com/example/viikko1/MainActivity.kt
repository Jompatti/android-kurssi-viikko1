package com.example.viikko1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.viikko1.domain.Task
import com.example.viikko1.domain.addTask
import com.example.viikko1.domain.todoItems
import com.example.viikko1.domain.toggleDone
import com.example.viikko1.ui.theme.Viikko1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Viikko1Theme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        title = "TODO APP",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(title: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)


    ){
        // App title
        Text(text = title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold )

        // Todo list task rows
        var taskList by remember { mutableStateOf(todoItems) }
        taskList.forEach { task ->
            Card() {
                Column(modifier = Modifier
                    .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "${task.title}", fontWeight = FontWeight.Bold, modifier = Modifier.weight(6f,true))
                        Text(text = "${task.priority}", modifier = Modifier.weight(1f,true))
                        Text(text = "${task.dueDate}", modifier = Modifier.weight(4f,true))

                        IconToggleButton(checked = task.done, onCheckedChange = { taskList = toggleDone(taskList, task.id) }) {
                            if (task.done) {
                                Icon(Icons.Filled.CheckCircle, contentDescription = "Toggle Check")
                            } else {
                                Icon(Icons.Outlined.CheckCircle, contentDescription = " Toggle Check")
                            }
                        }
                    }
//                    Text(text = "${task.description}")
                }
            }
        }

        // Add tasks
        var text by remember { mutableStateOf("") }

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = {Text("Write tasks")},
                modifier = Modifier.weight(4f)
            )

            IconButton(
                onClick = {
                val newTask = Task(
                    id = taskList.size + 1,
                    title = text,
                    priority = 1,
                    description = "",
                    dueDate = "2026-01-18",
                    done = false
                )
                taskList = addTask(taskList, newTask)
                text = ""
            },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Outlined.AddCircle,
                    contentDescription = "Add task",
                )

            }
        }

    }
}
