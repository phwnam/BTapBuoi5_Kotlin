package com.phwnam.lab3_ph35329

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ThanhToan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GetLayout() {
        val selectedOption = remember { mutableStateOf("") }
        var selectedItemIndex by remember { mutableStateOf(2) }

        Surface(color = Color(0xFF262121)) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GetTextTitle("Thanh toán")
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .height(150.dp),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = "Địa chỉ nhận hàng", color = Color.White)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.address),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .height(30.dp),
                            )
                            GetRowAddress(
                                ten = "Nguyễn Phương Nam",
                                sonha = "S218, Ocean Park",
                                phuong = "Đa Tốn, Gia Lâm",
                                thanhpho = "Hà Nội"
                            )
                        }
                        Text(
                            text = "Vui lòng chọn một trong những phương thức sau:",
                            color = Color.White
                        )
                    }

                    GetRowItem(
                        color = Color(0xFFfa8500),
                        "Paypal", R.drawable.paypal,
                        selectedOption = selectedOption.value,
                        onSelect = { selectedOption.value = "Paypal" })

                    GetRowItem(
                        color = Color(0xFFDBDBDB),
                        "Visa",
                        R.drawable.visa,
                        selectedOption = selectedOption.value,
                        onSelect = { selectedOption.value = "Visa" })

                    GetRowItem(
                        color = Color(0xFFec1387),
                        "Momo", R.drawable.momo,
                        selectedOption = selectedOption.value,
                        onSelect = { selectedOption.value = "Momo" })

                    GetRowItem(
                        color = Color(0xFF00c2fd),
                        "Zalo Pay", R.drawable.zalopay,
                        selectedOption = selectedOption.value,
                        onSelect = { selectedOption.value = "Zalo Pay" })

                    GetRowItem(
                        color = Color(0xFF18ebea),
                        "Thanh toán trực tiếp",
                        R.drawable.thanhtoan,
                        selectedOption = selectedOption.value,
                        onSelect = { selectedOption.value = "Thanh toán trực tiếp" }
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFfe734c)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)

                    ) {
                        Text(text = "Tiếp theo", color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))

                BottomNavigationBar()
            }
        }
    }

    @Composable
    fun GetRowAddress(ten: String, sonha: String, phuong: String, thanhpho: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        ) {
            Text(text = ten, color = Color.White)
            Text(text = sonha, color = Color.White)
            Text(text = phuong, color = Color.White)
            Text(text = thanhpho, color = Color.White)
        }

    }

    @Composable
    fun GetRowItem(
        color: Color = Color.Red,
        title: String,
        imageRes: Int,
        selectedOption: String,
        onSelect: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color, shape = RoundedCornerShape(15.dp))
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(40.dp)
                    .padding(start = 20.dp)

            )
            Text(text = title, modifier = Modifier.padding(start = 50.dp), color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selectedOption == title,
                onClick = { onSelect() },
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Composable
    fun GetTextTitle(title: String = "Trang chu") {
        Text(
            text = title,
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth()
        )
    }
    @Composable
    fun BottomNavigationBar() {
        NavigationBar(
            containerColor = Color(0xFFFFFFF),
            contentColor = Color.White
        ) {
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = null) },
                label = {
                    Text(
                        text = "Trang chủ",
                        style = TextStyle(color = Color.White)
                    )
                },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = R.drawable.ic_calendar), contentDescription = null) },
                label = {
                    Text(
                        text = "Lịch sử",
                        style = TextStyle(color = Color.White)
                    )
                },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = null) },
                label = {
                    Text(
                        text = "Giỏ hàng",
                        style = TextStyle(color = Color.White)
                    )
                },
                selected = true,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = R.drawable.ic_person), contentDescription = null) },
                label = {
                    Text(
                        text = " Hồ Sơ ",
                        style = TextStyle(color = Color.White)
                    )
                },
                selected = false,
                onClick = {}
            )
        }
    }
}