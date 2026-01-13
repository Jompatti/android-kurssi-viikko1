package com.example.viikko1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.viikko1.domain.todoItems
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
        verticalArrangement = Arrangement.spacedBy(16.dp)


    ){
        // App title
        Text(text = title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold )

        // Todo list title row
        Row() {
            Text(text = "ID", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f,true))
            Text(text = "Title", fontWeight = FontWeight.Bold, modifier = Modifier.weight(4f,true))
            Text(text = "Priority", fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f,true))
            Text(text = "Due Date", fontWeight = FontWeight.Bold, modifier = Modifier.weight(3f,true))
            Text(text = "Done", fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f,true))

        }


        // Todo list task rows
        var taskList by remember { mutableStateOf(todoItems) }
        taskList.forEach { task ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "${task.id}", modifier = Modifier.weight(1f,true))
                    Text(text = "${task.title}", modifier = Modifier.weight(4f,true))
                    Text(text = "${task.priority}", modifier = Modifier.weight(2f,true))
                    Text(text = "${task.dueDate}", modifier = Modifier.weight(3f,true))
                    Text(text = "${task.done}", modifier = Modifier.weight(2f,true))
                }
                Text(text = "${task.description}")
            }
        }

    }
}
