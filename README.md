# 電卓サンプル

逆ポーランド記法、ポーランド記法電卓のサンプルです。
加減乗除をサポートしています。

## 実行方法

逆ポーランド記法

    $ ./gradlew run -Dexec.args='4 5 1 - + 3 0.35 * /'

ポーランド記法

    $ ./gradlew run -Dexec.args='/ + 4 - 5 1 * 3 0.35'

