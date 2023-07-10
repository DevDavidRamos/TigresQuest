package com.example.tigresquest.data

data class Question(val question: String, val options: List<String>, val correctAnswer: String)



val tigresQuestions = listOf(
    Question(
        "¿En qué año se fundó el equipo Tigres?",
        listOf("1960", "1974", "1982", "1990"),
        "1960"
    ),
    Question(
        "¿Cuál es el estadio donde juega el equipo Tigres?",
        listOf("Estadio Azteca", "Estadio BBVA", "Estadio Akron", "Estadio Universitario"),
        "Estadio Universitario"
    ),
    Question(
        "¿Cuántas veces ha sido campeón el equipo Tigres en la Liga MX?",
        listOf("4", "6", "8", "10"),
        "8"
    ),
    Question(
        "¿Como se le llama a la barra de Tigres?",
        listOf("La rebel", "Libres y Lokos", "Barra 51", "La ultra tuza"),
        "Libres y Lokos"
    ),
    Question(
        "¿Quién es el actual entrenador del equipo Tigres?",
        listOf("Ricardo Ferretti", "Miguel Herrera", "Robert Dante Siboldi", "Diego Cocca"),
        "Robert Dante Siboldi"
    ),
    Question(
        "¿Cuál es el color predominante en el uniforme de Tigres?",
        listOf("Amarillo", "Azul", "Verde", "Rojo"),
        "Amarillo"
    ),
    Question(
        "¿Como se le llama a la afición de Tigres?",
        listOf("Bravos", "Libres y Lokos", "Auriazules", "Incomparables"),
        "Incomparables"
    ),
    Question(
        "¿Cuál es el récord de asistencia en un partido de Tigres en el Estadio Universitario?",
        listOf("50,000 espectadores", "60,000 espectadores", "70,000 espectadores", "80,000 espectadores"),
        "60,000 espectadores"
    ),
    Question(
        "¿Cuál es el récord de goles anotados en una temporada por un jugador de Tigres?",
        listOf("25 goles", "30 goles", "35 goles", "40 goles"),
        "30 goles"
    ),
    Question(
        "¿Quién es el entrenador más exitoso en la historia de Tigres?",
        listOf("Ricardo Ferretti", "Tuca Ferretti", "Miguel Herrera", "Ricardo La Volpe"),
        "Ricardo Ferretti"
    ),
    Question(
        "¿Cuál fue el primer título importante ganado por el equipo Tigres?",
        listOf("Liga MX", "Copa MX", "Copa Libertadores", "Liga de Campeones de la CONCACAF"),
        "Copa MX"
    ),
    Question(
        "¿Cuál es el nombre del clásico regiomontano, el partido entre Tigres y Rayados?",
        listOf("El Clásico Regio", "El Clásico del Norte", "El Clásico Monterrey", "El Clásico Tigres vs Rayados"),
        "El Clásico Regio"
    ),
    Question(
        "¿Quién es el máximo goleador de Tigres en la historia?",
        listOf("Tomás Boy", "Hugo Sánchez", "Walter Gaitán", "André-Pierre Gignac"),
        "André-Pierre Gignac"
    ),
    Question(
        "¿Cuál es el récord de puntos obtenidos por Tigres en una temporada de la Liga MX?",
        listOf("32 puntos", "36 puntos", "40 puntos", "44 puntos"),
        "40 puntos"
    ),
    // Agrega más preguntas aquí...
)