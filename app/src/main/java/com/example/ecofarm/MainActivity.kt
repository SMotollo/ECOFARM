package com.example.ecofarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecofarm.ui.theme.EcoFarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoFarmTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun MainLoginScreen(navController: NavController) {
    // Credenciais simuladas para login
    val correctUsername = "usuario@ecofarm.com"
    val correctPassword = "123456"

    // Variáveis de estado
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginFailed by remember { mutableStateOf(false) }

    // Função para validação do login
    fun validateLogin() {
        if (email == correctUsername && password == correctPassword) {
            loginFailed = false
            navController.navigate("welcome") // Navegação para a tela "welcome"
        } else {
            loginFailed = true
        }
    }

    // Layout da tela de login
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logotipo
        Image(
            painter = painterResource(id = R.drawable.eco_farm_logo),
            contentDescription = "Logo do Eco Farm",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo de e-mail
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de senha
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mensagem de erro caso o login falhe
        if (loginFailed) {
            Text("Credenciais inválidas", color = Color.Red)
        }

        // Botão de login
        Button(
            onClick = { validateLogin() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Textos clicáveis para "Esqueceu a senha?" e "Cadastre-se"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClickableText(
                text = AnnotatedString("Esqueceu a senha?"),
                onClick = { navController.navigate("forgotPassword") }, // Navegar para tela de recuperação
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Blue)
            )
            ClickableText(
                text = AnnotatedString("Cadastre-se"),
                onClick = { navController.navigate("register") }, // Navegar para tela de cadastro
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Blue)
            )
        }
    }
}

@Composable
fun WelcomeScreen() {
    // Tela de boas-vindas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bem-vindo ao EcoFarm!", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { MainLoginScreen(navController) }
        composable("welcome") { WelcomeScreen() }
        composable("register") { RegisterScreen(navController) } // Tela de Cadastro
        composable("forgotPassword") { ForgotPasswordScreen(navController) } // Tela de Recuperação de Senha
    }
}
