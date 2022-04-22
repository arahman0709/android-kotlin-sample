package com.lmorda.shopper.invite

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmorda.shopper.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun InviteAFriendPreview() {
    InviteAFriend({}, {}, {}, {}, {}, {}, {})
}

@Composable
fun InviteAFriend(
    closeClickListener: () -> Unit,
    addToCalendarClickListener: () -> Unit,
    shareThisOrderClickListener: () -> Unit,
    learnMoreClickListener: () -> Unit,
    messageClickListener: () -> Unit,
    copyLinkClickListener: () -> Unit,
    shareLinkClickListener: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Close(closeClickListener)
        Checkmark()
        Spacer(modifier = Modifier.height(16.dp))
        EnjoyYourOrder()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                AddToCalendar(addToCalendarClickListener)
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                ShareThisOrder(shareThisOrderClickListener)
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(end = 16.dp)
            ) {
                GiveTheGift(learnMoreClickListener)
            }
            Column(
                modifier = Modifier.weight(0.3f)
            ) {
                ShopperHero()
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Message(messageClickListener)
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CopyLink(copyLinkClickListener)
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Share(shareLinkClickListener)
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
    }

}

@Composable
private fun Close(closeClickListener: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_close),
        contentDescription = stringResource(R.string.invite_close_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = closeClickListener
            )
            .fillMaxWidth(),
        alignment = Alignment.CenterEnd
    )
}

@Composable
private fun Checkmark() {
    Image(
        painter = painterResource(id = R.drawable.ic_orange_check),
        contentDescription = stringResource(R.string.invite_check_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = {}
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
}

@Composable
private fun EnjoyYourOrder() {
    Text(
        text = stringResource(R.string.invite_enjoy_order_title),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
}

@Composable
private fun AddToCalendar(addToCalendarClickListener: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_add_calendar),
        contentDescription = stringResource(R.string.invite_add_cal_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = addToCalendarClickListener
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = stringResource(R.string.invite_add_cal_icon_text),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 10.sp
    )
}

@Composable
private fun ShareThisOrder(shareLinkClickListener: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_share),
        contentDescription = stringResource(R.string.invite_share_order_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = shareLinkClickListener
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = stringResource(R.string.invite_share_order_icon_text),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 10.sp
    )
}


@Composable
private fun Message(messageClickListener: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_message),
        contentDescription = stringResource(R.string.invite_message_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = messageClickListener
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(
        text = stringResource(R.string.invite_message_icon_text),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 10.sp
    )
}

@Composable
private fun GiveTheGift(learnMoreClickListener: () -> Unit) {
    Text(stringResource(R.string.invite_give_gift_title),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        stringResource(R.string.invite_gift_copy),
        fontSize = 13.sp,
        color = Color(0xFF696C73)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(stringResource(R.string.invite_gift_link), color = Color(0xFFD7612E),
        fontSize = 13.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = Modifier.clickable(
            enabled = true,
            onClick = learnMoreClickListener
        )
    )
}

@Composable
private fun ShopperHero() {
    Image(
        painter = painterResource(id = R.drawable.store),
        contentDescription = stringResource(R.string.invite_shopper_ada)
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun CopyLink(copyLinkClickListener: () -> Unit) {
    var count by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    Image(
        painter = painterResource(id = R.drawable.ic_link),
        contentDescription = stringResource(R.string.invite_copy_link_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = {
                    copyLinkClickListener()
                    count++
                    coroutineScope.launch {
                        delay(2000)
                        count = 0
                    }
                }
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    Spacer(modifier = Modifier.padding(4.dp))
    AnimatedContent(targetState = count) { targetCount ->
        Text(
            text = if (targetCount == 0)
                stringResource(R.string.invite_copy_link_icon_text)
            else stringResource(R.string.invite_link_copied_icon_text),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 10.sp
        )
    }
}

@Composable
private fun Share(shareLinkClickListener: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_share),
        contentDescription = stringResource(R.string.invite_share_ada),
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = shareLinkClickListener
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Text(
        text = stringResource(R.string.invite_share_icon_text),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 10.sp
    )
}