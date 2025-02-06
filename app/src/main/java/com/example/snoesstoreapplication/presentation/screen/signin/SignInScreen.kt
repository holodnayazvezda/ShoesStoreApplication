package com.example.snoesstoreapplication.presentation.screen.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.snoesstoreapplication.R
import com.example.snoesstoreapplication.presentation.theme.AppAccent
import com.example.snoesstoreapplication.presentation.theme.AppBackground
import com.example.snoesstoreapplication.presentation.theme.AppBlock
import com.example.snoesstoreapplication.presentation.theme.AppHint
import com.example.snoesstoreapplication.presentation.theme.AppSubTextDark
import com.example.snoesstoreapplication.presentation.theme.AppText
import com.example.snoesstoreapplication.presentation.theme.newPeninimFontFamily

@Composable
fun SignInScreen(
    vm: SignInScreenViewModel,
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    Box(Modifier.fillMaxSize().background(AppBlock)) {
        Column(Modifier.padding(horizontal = 20.dp)) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.padding(50.dp))
                Text(
                    text = "Привет!",
                    fontFamily = newPeninimFontFamily,
                    fontSize = 40.sp,
                    color = AppText
                )
                Spacer(Modifier.padding(5.dp))
                Text(
                    text = "Заполните Свои Данные Или",
                    fontFamily = newPeninimFontFamily,
                    fontSize = 17.sp,
                    color = AppSubTextDark,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Продолжите Через Социальные Медиа",
                    fontFamily = newPeninimFontFamily,
                    fontSize = 17.sp,
                    color = AppSubTextDark,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.padding(30.dp))
            }
            Column(
                Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Email",
                    color = AppText,
                    fontSize = 20.sp
                )
                Spacer(Modifier.padding(6.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        vm.updateEmail(it)
                    },

                    placeholder = {
                        Text(
                            text = "xyz@gmail.com",
                            fontSize = 16.sp,
                            color = AppSubTextDark
                        )
                    },

                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .height(57.dp)
                        .background(AppBackground),
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent, focusedTextColor = AppText, unfocusedTextColor = AppText)
                )

                Spacer(Modifier.padding(15.dp))
                Text(
                    text = "Пароль",
                    color = AppText,
                    fontSize = 20.sp
                )
                Spacer(Modifier.padding(6.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        vm.updatePassword(it)
                    },
                    placeholder = {
                        Text(
                            text = "······",
                            fontSize = 20.sp,
                            color = AppHint,
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {showPassword = !showPassword}
                        ) {
                            Icon(
                                imageVector = if (showPassword) ImageVector.vectorResource(R.drawable.eye_open) else ImageVector.vectorResource(R.drawable.eye_close),
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = AppHint
                            )
                        }
                    },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation('·') ,
                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .height(57.dp)
                        .background(AppBackground),
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent, focusedTextColor = AppText, unfocusedTextColor = AppText)
                )

                Spacer(Modifier.padding(6.dp))

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Восстановить",
                        color = AppSubTextDark,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth().height(57.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = AppAccent),
                        onClick = {
                            vm.buttonPressed(navController, context)
                        }
                    ) {
                        Text(
                            text = "Войти",
                            color = AppBackground,
                            fontSize = 17.sp
                        )
                    }
                    Spacer(Modifier.padding(80.dp))
                }
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    val annotatedString = buildAnnotatedString {
                        append("Вы впервые?")
                        addStyle(SpanStyle(fontSize = 17.sp, color = AppHint), 0, this.length)
                        append("Создать пользователя")
                        addStyle(SpanStyle(fontSize = 18.sp, color = Color.Black), "Вы впервые?".length, this.length)
                        toAnnotatedString()
                    }
                    Text(text = annotatedString, textAlign = TextAlign.Center)
                }
            }
        }
    }
}