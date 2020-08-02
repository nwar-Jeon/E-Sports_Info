package com.nwar.data.mapper

import com.nwar.data.model.Account
import com.nwar.domain.entity.User

fun User.toAccount() = Account(this.userId, this.password, this.authorization, this.nickName)