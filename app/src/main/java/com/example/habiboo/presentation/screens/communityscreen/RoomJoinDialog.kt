import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.habiboo.R
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@Composable
fun RoomJoinDialog(showDialog: Boolean, onClose: () -> Unit) {

    val fontSize = 15.sp

    if (showDialog) {
        Dialog(onDismissRequest = onClose) {
            Card(
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color.White
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Spacer(modifier = Modifier.height(36.dp)) // Spacer to make room for the close button

                        Text(
                            text = "Sports training",

                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 28.sp,
                            style = mainTextStyleMin,
                            fontWeight = FontWeight.Normal,
                            color = mainPurple,
                            textAlign = TextAlign.Center,
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            "Goal:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            style = mainTextStyleMin,
                            color = mainPurple,
                        )


                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(R.drawable.goal_icon),
                                contentDescription = "Bottom navigation Image",
                                modifier = Modifier.size(22.dp),
                            )
                            Spacer(Modifier.width(12.dp))
                            Text(
                                text = "Strength training and endurance building",
                                style = mainTextStyleMin,
                                fontSize = fontSize,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }

                        Text(
                            text = "Description:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            style = mainTextStyleMin,
                            color = mainPurple,
                            modifier = Modifier.padding(top = 16.dp)
                        )

                        Text(
                            text = "Join us for daily workouts that focus on building strength, endurance," +
                                    " and flexibility. This room is perfect for all fitness levels. " +
                                    "Track your progress, share results, and stay motivated with a " +
                                    "supportive community!",
                            fontSize = fontSize,
                            style = mainTextStyleMin,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Spacer(Modifier.height(32.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.community_icon),
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "12",
                                    fontSize = 16.sp,
                                    style = mainTextStyleMin,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }

                            Spacer(modifier = Modifier.width(86.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.lock_locked),
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Private",
                                    fontSize = 16.sp,
                                    style = mainTextStyleMin,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }


                        val isPrivate = false
                        if (isPrivate){

                            OutlinedTextField(
                                value = "",
                                onValueChange = {
                                   ""
                                },
                                label = { Text("Enter password", style = mainTextStyleMin) },
                                modifier = Modifier.fillMaxWidth().padding(top=16.dp).padding(horizontal = 16.dp)
                            )
                        }

                        Button(
                            onClick = onClose,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = mainPurple,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 28.dp)
                                .clip(RoundedCornerShape(15.dp)),

                            ) {
                            Text(
                                "JOIN",
                                style = mainTextStyleMin,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 32.dp)
                            )
                        }
                    }
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 14.dp, start = 14.dp)
                            .size(25.dp)
                    ) {
                        Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun TaskItem(taskName: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = true,
            onCheckedChange = null  // For display only
        )
        Text(taskName, fontSize = 16.sp)
    }
}

@Composable
fun IconText(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = text)
        Spacer(Modifier.width(4.dp))
        Text(text)
    }
}
