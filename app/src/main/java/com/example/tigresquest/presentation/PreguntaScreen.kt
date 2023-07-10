package com.example.tigresquest.presentation

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tigresquest.R
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tigresquest.data.tigresQuestions
import kotlinx.coroutines.delay

@Composable
fun PreguntaScreen(navController: NavController) {
    val context = LocalContext.current // Obtener el contexto actual

    Scaffold(
        topBar = { Toolbar(navController) },
        content = { Content() }
    )

    // Agregar el reproductor de música en la parte inferior de la pantalla
    MusicPlayer(context = context)
}

@Composable
fun Toolbar(navController: NavController) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.dorado)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Volver",
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Saludos Incomparables", color = colorResource(id = R.color.azul))
    }
}

@Composable
fun Content() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        item {
            QuizApp()
        }
    }
}


@Composable
fun MusicPlayer(context: Context) {
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.dale_tigueres) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    LaunchedEffect(Unit) {
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }
}

@Composable
fun QuizApp() {
    var score by remember { mutableStateOf(0) }

    val currentQuestionIndex = remember { mutableStateOf(0) }
    val selectedAnswerIndex = remember { mutableStateOf<Int?>(null) }
    val currentQuestion = tigresQuestions.getOrNull(currentQuestionIndex.value)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        if (currentQuestion != null) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                val annotatedString = buildAnnotatedString {
                    pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black))
                    append(currentQuestion.question)
                    pop()
                }
                Text(text = annotatedString)
                currentQuestion.options.forEachIndexed { index, option ->
                    val backgroundColor = if (selectedAnswerIndex.value != null) {
                        val isCorrect =
                            index == currentQuestion.options.indexOf(currentQuestion.correctAnswer)
                        if (selectedAnswerIndex.value == index) {
                            if (isCorrect) {
                                Color.Green
                            } else {
                                Color.Red
                            }
                        } else if (isCorrect) {
                            Color.Green.copy(alpha = 0.5f)
                        } else {
                            Color.Black
                        }
                    } else {
                        Color.Black
                    }
                    Button(
                        onClick = {
                            if (selectedAnswerIndex.value == null) {
                                selectedAnswerIndex.value = index
                                val isCorrect =
                                    index == currentQuestion.options.indexOf(currentQuestion.correctAnswer)
                                if (isCorrect) {
                                    score++
                                }
                            }
                        },
                        modifier = Modifier.padding(top = 8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                        enabled = selectedAnswerIndex.value == null || selectedAnswerIndex.value == index
                    ) {
                        Text(text = option, color = Color.White)
                    }
                }
            }
        } else {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Puntaje final: $score/${tigresQuestions.size}",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color.Black
            )
        }
    }

    LaunchedEffect(selectedAnswerIndex.value) {
        if (selectedAnswerIndex.value != null) {
            delay(500)
            selectedAnswerIndex.value = null
            currentQuestionIndex.value++
        }
    }
}
