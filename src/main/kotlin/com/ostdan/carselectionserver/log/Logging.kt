package com.ostdan.carselectionserver.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

interface Logging
    inline fun <reified T : Logging> T.logger(): Logger = getLogger(T::class.java)