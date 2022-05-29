package com.example.virginmoney.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.virginmoney.model.People
import com.example.virginmoney.model.Room
import com.example.virginmoney.view.ui.theme.VirginMoneyTheme
import com.example.virginmoney.viewmodel.MainViewModel

class ListActivity: ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirginMoneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    if(intent.getStringExtra("TYPE").equals("PEOPLE")) {
                        mainViewModel.getPeopleList()
                        PeopleList(peopleList = mainViewModel.peopleListResponse)
                    }
                    else
                    {
                        mainViewModel.getRoomsList()
                        RoomList(roomList = mainViewModel.roomsListResponse)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    VirginMoneyTheme {
        //PeopleList(peopleList)
    }
}

@Composable
fun PeopleList(peopleList : ArrayList<People>) {

    LazyColumn {
        itemsIndexed(items = peopleList) { index, item ->
            PeopleItem(people = item)
        }
    }
}

@Composable
fun RoomList(roomList : ArrayList<Room>) {

    LazyColumn {
        itemsIndexed(items = roomList) { index, item ->
            RoomItem(room = item)
        }
    }
}

@Composable
fun PeopleItem(people: People) {
    
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = people.avatar,

                        builder = {
                            scale(Scale.FILL)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = people.firstName.toString() + " " + people.lastName.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = people.jobtitle.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = people.email.toString(),
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}

@Composable
fun RoomItem(room: Room) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = "Room No. " + room.id,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Max Occupancy : " + room.maxOccupancy.toString(),
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    if(room.isOccupied!!) {
                        Text(
                            text = "Room is occupied",
                            style = MaterialTheme.typography.body1,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Red

                        )
                    }
                    else
                    {
                        Text(
                            text = "Room is not occupied",
                            style = MaterialTheme.typography.body1,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Green
                        )
                    }

                }
            }
        }
    }

}