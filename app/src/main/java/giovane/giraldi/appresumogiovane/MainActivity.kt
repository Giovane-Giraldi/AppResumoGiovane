package giovane.giraldi.appresumogiovane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import giovane.giraldi.appresumogiovane.ui.theme.AppResumoGiovaneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppResumoGiovaneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaInicial(paddingValues = innerPadding)

                }
            }
        }
    }
}
@Composable
fun TelaInicial(
    paddingValues: PaddingValues
){

            var nome by remember { mutableStateOf(value = "") }
            var curso by remember { mutableStateOf(value = "") }
            var idade by remember { mutableStateOf(value = "") }

            var nomeExibido by remember { mutableStateOf("") }
            var cursoExibido by remember { mutableStateOf("") }
            var idadeExibida by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Curso") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade") },
                modifier = Modifier.fillMaxWidth()
            )
        Button(
            onClick = {
                nomeExibido = nome
                cursoExibido = curso
                idadeExibida = idade
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Exibir dados")
        }

        Text("Exibindo dados")
        LinhaInformacao(titulo = "Nome",valor = nomeExibido)
        LinhaInformacao(titulo = "Curso", valor = cursoExibido )
        LinhaInformacao(titulo = "Idade", valor = idade)
    }
}
@Composable
fun LinhaInformacao(
    titulo: String,
    valor: String
)
{
Text(text = "$titulo:$valor")
}
@Preview
@Composable
fun PreviewTelaInicial(){
    Scaffold { innerPadding ->
        TelaInicial(paddingValues = innerPadding)
    }
}


