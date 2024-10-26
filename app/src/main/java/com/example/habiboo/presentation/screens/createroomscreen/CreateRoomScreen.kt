import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habiboo.R
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRoomScreen(navController: NavController) {
    var roomName by remember { mutableStateOf("") }
    var roomDescription by remember { mutableStateOf("") }
    var period by remember { mutableStateOf(0) }
    var isClosed by remember { mutableStateOf(false) }
    var controlByAdmin by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.background(backgroundWhite),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Create new room",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp)
                            .background(backgroundWhite),
                        style = mainTextStyleMin,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                modifier = Modifier.background(backgroundWhite),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White, // Background color
                    titleContentColor = Color.Black, // Title color
                    navigationIconContentColor = Color.Black // Navigation icon color
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .padding(horizontal = 100.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(backgroundWhite)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.no_image),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = {
                        // Handle the click action
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(36.dp)
                        .shadow(4.dp, CircleShape)
                        .background(Color.White, CircleShape)
                ) {
                    Icon(Icons.Filled.Create, contentDescription = "Edit", tint = mainPurple)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = roomName,
                onValueChange = { roomName = it },
                label = { Text("Name", fontSize = 12.sp) },
                singleLine = true,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Handle the 'Done' action on the keyboard
                    }
                )
            )
            OutlinedTextField(
                value = roomDescription,
                onValueChange = { roomDescription = it },
                label = { Text("Description", fontSize = 12.sp) },
                singleLine = true,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Handle the 'Done' action on the keyboard
                    }
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Period (days):", style = mainTextStyleMin, fontSize = 16.sp)
                HorizontalNumberPicker(min = 1, max = 10, initial = 5)
            }

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Closed:")
                Switch(
                    checked = isClosed,
                    onCheckedChange = { isClosed = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = mainPurple,
                        checkedTrackColor = mainPurple.copy(alpha = 0.5f), // Lighter purple when checked
                        uncheckedThumbColor = Color.Gray,
                        uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f) // Lighter gray when unchecked
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Moderated by admin:")
                Switch(
                    checked = controlByAdmin, onCheckedChange = { controlByAdmin = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = mainPurple,
                        checkedTrackColor = mainPurple.copy(alpha = 0.5f), // Lighter purple when checked
                        uncheckedThumbColor = Color.Gray,
                        uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f) // Lighter gray when unchecked
                    )
                )
            }
            if (isClosed) {
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", fontSize = 12.sp) },
                    singleLine = true,
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Handle the 'Done' action on the keyboard
                        }
                    )
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Handle create room */ }, colors = ButtonDefaults.buttonColors(
                    containerColor = mainPurple
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("CREATE", style = mainTextStyleMin, fontSize = 18.sp)
            }
        }

    }
}


@Composable
fun HorizontalNumberPicker(min: Int, max: Int, initial: Int) {
    var value by remember { mutableStateOf(initial) }

    Row(verticalAlignment = Alignment.CenterVertically) {

        Button(
            onClick = { if (value > min) value -= 1 },
            modifier = Modifier
                .height(45.dp)
                .width(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mainPurple,
                contentColor = Color.White
            )
        ) {
            Text(
                "-",
                textAlign = TextAlign.Center,
                style = mainTextStyleMin,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text("$value", style = mainTextStyleMin, fontSize = 20.sp)

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = { if (value < max) value += 1 },
            modifier = Modifier
                .height(45.dp)
                .width(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = mainPurple,
                contentColor = Color.White
            )
        ) {
            Text(
                "+",
                textAlign = TextAlign.Center,
                style = mainTextStyleMin,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

        }
    }
}