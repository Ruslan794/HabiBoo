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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.habiboo.data.network.model.room.Room
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@Composable
fun RoomJoinDialog(
    showDialog: Boolean,
    room: Room,
    onClose: () -> Unit,
    onJoinClick: (String) -> Unit
) {
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
                        Spacer(modifier = Modifier.height(36.dp))

                        Text(
                            text = room.name,
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
                                contentDescription = "Goal icon",
                                modifier = Modifier.size(22.dp),
                            )
                            Spacer(Modifier.width(12.dp))
                            Text(
                                text = room.goal ?: "No goal specified",
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
                            text = room.description ?: "No description provided.",
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
                                    contentDescription = "Community icon",
                                    modifier = Modifier.size(32.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = room.currentMembers.toString(),
                                    fontSize = 16.sp,
                                    style = mainTextStyleMin,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }

                            Spacer(modifier = Modifier.width(86.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                val lockIcon = if (room.close) {
                                    R.drawable.lock_locked
                                } else {
                                    R.drawable.lock_unlocked
                                }
                                Image(
                                    painter = painterResource(lockIcon),
                                    contentDescription = "Lock icon",
                                    modifier = Modifier.size(32.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (room.close) "Private" else "Public",
                                    fontSize = 16.sp,
                                    style = mainTextStyleMin,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }

                        // Поле для ввода пароля, если комната приватная
                        var password by remember { mutableStateOf("") }
                        if (room.close) {
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Enter password", style = mainTextStyleMin) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp)
                            )
                        }

                        Button(
                            onClick = {
                                onJoinClick(password)
                            },
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
