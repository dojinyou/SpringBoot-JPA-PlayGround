package com.dojinyou.inflearn.w4.external

import org.tinylog.kotlin.Logger

class OsEnv

fun main() {
    val envMap = System.getenv()

    for (key in envMap.keys) {
        Logger.info("env $key = ${envMap[key]}")
    }
//    INFO: env PATH = /opt/homebrew/bin:/opt/homebrew/sbin:/Users/dojinyou/.nvm/versions/node/v14.21.2/bin:/Users/dojinyou/.docker/bin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/appleinternal/bin:/Users/dojinyou/Library/Application Support/JetBrains/Toolbox/scripts
//    2023-04-06 00:18:56 [main] com.dojinyou.inflearn.w4.external.OsEnvKt.main()
//    INFO: env MANPATH = /opt/homebrew/share/man::
//    2023-04-06 00:18:56 [main] com.dojinyou.inflearn.w4.external.OsEnvKt.main()
//    INFO: env SSH_SOCKET_DIR = ~/.ssh
//    2023-04-06 00:18:56 [main] com.dojinyou.inflearn.w4.external.OsEnvKt.main()
}
