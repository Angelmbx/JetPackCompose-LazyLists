package com.example.lazylists_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazylists_compose.ui.theme.LazyListsComposeTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListsComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MyLazyColumn()
                }
            }
        }
    }
}

// https://www.youtube.com/watch?v=_JO4Xxx0vb0

@Composable
fun MyLazyColumn() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        // state = rememberLazyListState(),  //
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(messages) { message -> MyComponent(message) }
    }
}


@Composable
fun MyComponent(message: MyMessage) {

    Row(Modifier
        .padding(10.dp)
        .background(MaterialTheme.colors.secondary)
        .padding(10.dp)
        .clickable(
            onClick = { /* Ignoring onClick */ }),
        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary),
            alignment = Alignment.Center,
        )
        Spacer(Modifier.width(8.dp))
        Column(Modifier.padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = message.title)
            Spacer(Modifier.height(8.dp))
            Text(text = message.body)
            Text(text= message.fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        }

    }

}


data class MyMessage(val title: String, val body: String, val fecha: LocalDateTime)

val messages: List<MyMessage> = listOf(
    MyMessage(title = "Título 1",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 2",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 3",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 4",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 5",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 6",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 7",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 8",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 9",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 10",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 11",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
    MyMessage(title = "Título 12",
        body = "You can think of Modifiers as implementations of the decorator pattern",
        fecha = LocalDateTime.now()),
)