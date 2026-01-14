package com.example.viikko1.domain

fun addTask(list: List<Task>, task: Task): List<Task>{
    return list + task
}

fun toggleDone(list: List<Task>, id: Int): List<Task> {
   val newList = list.map { task ->
       if(task.id == id){
           task.copy(done = !task.done)
       } else {
           task
       }
   }
    return newList
}
