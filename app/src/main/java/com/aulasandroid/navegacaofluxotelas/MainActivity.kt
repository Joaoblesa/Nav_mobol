package com.aulasandroid.navegacaofluxotelas

import android.os.Bundle
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aulasandroid.navegacaofluxotelas.Screens.LoginScreen
import com.aulasandroid.navegacaofluxotelas.Screens.MenuScreen
import com.aulasandroid.navegacaofluxotelas.Screens.PedidosScreen
import com.aulasandroid.navegacaofluxotelas.Screens.PerfilScreen
import com.aulasandroid.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "Login"
                    ) {
                        composable (route = "login"){ LoginScreen(navController = navController)}
                        composable (route = "Menu"){ MenuScreen(navController = navController)}
                        composable (route = "Perfil/{nome}"){
                            val nome = it.arguments?.getString("nome")
                            PerfilScreen(
                                navController = navController,
                                nome = nome!!

                            )}
                        composable (route = "Pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument("numeroPedido"){
                                    defaultValue = "Sem Pedidos"
                                }
                            )
                        )  {
                            val numeroPedido = it.arguments?.getString("numeroPedido")
                            PedidosScreen(
                                navController = navController,
                                numeroPedido = numeroPedido!!
                                )}
                    }

//                    LoginScreen()
//                    MenuScreen()
//                    PerfilScreen()
//                    PedidosScreen()
                }
            }
        }
    }
}

