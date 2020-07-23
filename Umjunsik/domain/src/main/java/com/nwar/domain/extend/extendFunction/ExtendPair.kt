package com.nwar.domain.extend.extendFunction

infix fun <A,B,C>Pair<A,B>.to(value : C) = Triple(this.first, this.second, value)